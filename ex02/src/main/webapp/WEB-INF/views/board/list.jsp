<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<jsp:include page="../includes/header.jsp" />
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.0/css/jquery.dataTables.min.css">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">List</h1>
		
		<form id="actionForm" action="list">
			<select name="type" id="">
				<option value="" ${pageMaker.cri.type == null ? 'selected' : ''}>선택</option>
				<option value="T" ${pageMaker.cri.type == 'T' ? 'selected' : ''}>제목</option>
				<option value="C" ${pageMaker.cri.type == 'C' ? 'selected' : ''}>내용</option>
				<option value="W" ${pageMaker.cri.type == 'W' ? 'selected' : ''}>작성자</option>
				<option value="TC" ${pageMaker.cri.type == 'TC' ? 'selected' : ''}>제목 or 내용</option>
				<option value="TW" ${pageMaker.cri.type == 'TW' ? 'selected' : ''}>제목 or 작성자</option>
				<option value="TWC" ${pageMaker.cri.type == 'TWC' ? 'selected' : ''}>제목 or 내용 or 작성자</option>
			</select>
			<input type="text" name="keyword" value="${pageMaker.cri.keyword }">
			<input type="hidden" name="bno" value="">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
			<button>검색</button>
		</form>

		<table class="table" id="board">
			<thead>
				<tr>
					<th width="8%">글 번호</th>
					<th>제목</th>
					<th width="20%">작성자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${list }">
					<tr data-bno="${board.bno}" style="cursor: pointer;">
						<th class="text-right font-weight">${board.bno }</th>
						<td>${board.title }</td>
						<td>${board.writer }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="pull-rigth">
			<ul class="pagination">
				<c:if test="${pageMaker.prev }">
					<li class="paginate_button previous">
						<a href="${pageMaker.startPage -1}">Prev</a>
					</li>
				</c:if>
				
				<!-- 삼항 연산자를 활용, active클래스를 toggle한다 -->
				<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
					<li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active' : '' }"> 
						<a href="${num }">${num }</a>
					</li>
				</c:forEach>
				
				<c:if test="${pageMaker.next }">
					<li class="paginate_button previous">
						<a href="${pageMaker.endPage +1}">Next</a>
					</li>
				</c:if>
			</ul>
		</div>
		<a class="btn btn-primary" href="register">글 쓰러가기</a>
	</div>
</div>

<jsp:include page="../includes/footer.jsp" />
<script src="https://cdn.datatables.net/1.11.0/js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function () {
		// $('#board').DataTable();

		if ("<c:out value='${result}'/>" == "update") {
			alert("수정완료");
		} else if ("<c:out value='${result}'/>" == "delete") {
			alert("삭제완료");
		}
		
		const actionForm = $("#actionForm");
		
		$("#board tbody tr").click(function(e){
			$(actionForm).attr("action", "get");
			$(actionForm).find("input[name='bno']").val($(this).attr("data-bno"));
			$(actionForm).submit();
		});

		$(".paginate_button a").click(function(e){
			e.preventDefault();
			$(actionForm).attr("action", "list");
			$(actionForm).find("input[name='pageNum']").val($(this).attr("href"));
			$(actionForm).submit();
		});
	});
</script>

</html>