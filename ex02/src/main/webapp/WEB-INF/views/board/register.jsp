<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<jsp:include page="../includes/header.jsp" />
<h1 class="page-header">Forms</h1>
<div class="panel panel-default">
	<div class="panel-heading">글쓰기</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-lg-12">
				<form role="form" action="register" method="post">
					<div class="form-group">
						<label>글 제목</label> 
						<input class="form-control" name="title" required>
					</div>
					<div class="form-group">
						<label>작성자</label> 
						<input class="form-control" name="writer" required>
					</div>
					<div class="form-group">
						<label>글내용</label>
						<textarea class="form-control" rows="3" name="content" required></textarea>
					</div>
					<button type="submit" class="btn btn-default">글 등록하기</button>
					<button type="reset" class="btn btn-default">취소</button>
				</form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../includes/footer.jsp" />
</html>