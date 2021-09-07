$(function () {
    const bno = $("#bno").text();
    const insertReply = $("#insertReply");
    const inputReply = $(insertReply).find("input[name='reply']");
    const inputReplyer = $(insertReply).find("input[name='replyer']");

    replyService.getList(
        {bno:bno}, 
        replyService.makeReply
    );

    $(insertReply).find("button[type='button']").on("click", function(){
        replyService.add(replyService.makeReply);
        $(inputReply).val("");
        $(inputReplyer).val("");
    });
});


// function module화 
const replyService = (function(){
    // ============== AJAX STRAT ==============
    // 댓글 전체 목록 조회
    function getList(param, callback, error){
        $.ajax({
            url: "../replies/",
            method: "get",
            data: param,
            dataType: "json",
            success: function (data) {
                if(callback){
                    for (let row of data) {
                        callback(row);
                    }
                }
            },
            error: function (err){
                if(error){
                    error(err);
                }
            }
        });
    }

    // 댓글 추가
    function add(callback, error){
        $.ajax({
            url: "../replies/",
            method: "post",
            data: $(insertReply).serialize(),
            dataType: "json",
            success: function(data){
                if(callback){
                    callback(data);
                }
            },
            error: function(err){
                if(error){
                    error(err);
                }
            }
        });
    }

    // 댓글 수정
    function modify(reply, callback, error){
        console.log(reply);
        $.ajax({
            url: "../replies/",
            method: "put",
            data: JSON.stringify(reply),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function(data){
                if(callback){
                    callback(data);
                }
            },
            error: function(err){
                if(error){
                    error(err);
                }
            }
        });
    }

    // 댓글 삭제
    function remove(param, callback, error){
        $.ajax({
            url: "../replies/"+param,
            method: "delete",
            success: function(data){
                if(callback){
                    callback(data);
                }
            },
            error: function(err){
                if(error){
                    error(err);
                }
            }
        });
    }
    // ============== AJAX END ==============

    // ======= Callback & Utils END =======
    // 댓글 조회 callback
    function makeReply(data) {
        const realDate = replyService.dateOfKorea(data.updatedate);
        // <li class="left clearfix" data-rno="댓글번호"></li>
        let liTag = $("<li />")
            .addClass("left clearfix")
            .attr("data-rno", data.rno);

        // <div class="header"></div>
        let replyWrapper = $("<div />")
            .addClass("header");

        // <strong class="primary-font">작성자</strong>
        let replyer = $("<strong />")
            .addClass("primary-font")
            .text(data.replyer);
    
        // <small class="pull-right text-muted">날짜</small>
        let updatedate = $("<small />")
            .addClass("pull-right text-muted")
            .text(realDate);
    
        // <p>내용</p>
        let reply = $("<p />")
            .text(data.reply);
        
        // <button class="btn btn-danger">삭제</button>
        let deleteBtn = $("<button />")
            .addClass("btn btn-danger")
            .text("삭제")
            .click(function(){
                replyService.remove(data.rno, replyService.removeReply);
            });

        // <button class="btn btn-primary">수정</button>
        let updateBtn = $("<button />")
            .addClass("btn btn-primary")
            .text("수정")
            .click(function(){
                replyService.modify(
                    { rno : data.rno, reply : $("input[name='reply']").val()}, 
                    replyService.modifyReply);
            });
    
        // <div class="header">
        //     <strong class="primary-font">작성자</strong>
        //     <small class="pull-right text-muted">날짜</small>
        //     <p>내용</p>
        // </div>
        $(replyWrapper).append(replyer, updatedate, reply);

        // <li class="left clearfix" data-rno="댓글번호">
        //     <div class="header">
        //         <strong class="primary-font">작성자</strong>
        //         <small class="pull-right text-muted">날짜</small>
        //         <p>내용</p>
        //     </div>
        //     <button class="btn btn-primary">수정</button>
        //     <button class="btn btn-danger">삭제</button>
        // </li>
        $(liTag).append(replyWrapper, updateBtn, deleteBtn);
        $(".chat").append(liTag);
    }

    // 댓글 삭제 callback
    function removeReply(data){
        $("li[data-rno="+data+"]").remove();
    }

    // 댓글 수정 callback
    function modifyReply(data){
        const realDate = replyService.dateOfKorea(data.updatedate);
        const target = $("li[data-rno="+data.rno+"]");
        target.find("p").text(data.reply);
        target.find("small").text(realDate);
    }
    
    // 날짜 변환(시간을 한국기준으로 변경)
    function dateOfKorea(date){
        const newDate = new Date(date);
        newDate.setHours(newDate.getHours()+9);
        return newDate;
    }
    // ======= Callback & Utils END =======

    return {
    // ========== AJAX ==========
        getList : getList,
        add : add,
        remove : remove,
        modify : modify,
    // ===== Callback & Utils =====
        makeReply : makeReply,
        removeReply : removeReply,
        modifyReply : modifyReply,
        dateOfKorea : dateOfKorea
    };
})();
