<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<jsp:include page="../includes/header.jsp" />
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">List</h1>
		<table class="table">
			<tr>
				<th>${board.bno }</th>
				<th>${board.title }</th>
				<th>${board.writer }</th>
			</tr>
			<tr>
				<td colspan="3">${board.content }</td>
			</tr>
			<tr>
				<td colspan="3">마지막 수정일: <c:if test="${board.updatedate == board.regdate}">
						<fmt:formatDate value="${board.regdate }" type="both" pattern="yy-MM-dd a hh:mm:ss" />
					</c:if>
					<c:if test="${board.updatedate != board.regdate}">
						<fmt:formatDate value="${board.updatedate }" type="both" pattern="yy-MM-dd a hh:mm:ss" />
					</c:if>
				</td>
			</tr>
		</table>

		<form action="delete" method="post">
			<input type="hidden" name="bno" value="${board.bno }">
			<%-- <input type="hidden" name="pageNum" value="${criteria.pageNum}">
			<input type="hidden" name="amount" value="${criteria.amount }"> --%>
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#updateModal">글 수정</button>
			<button class="btn btn-danger" type="submit">글 삭제</button>
			<a class="btn btn-primary" 
				href="list?pageNum=${criteria.pageNum}
						&amount=${criteria.amount}
						&type=${criteria.type }
						&keyword=${criteria.keyword}">
			목록으로</a>
		</form>
		
		<!-- Modal -->
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="updateModalLabel">글 수정하기</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form role="form" action="update" method="post">
						<%-- <input type="hidden" name="pageNum" value="${criteria.pageNum}">
						<input type="hidden" name="amount" value="${criteria.amount }"> --%>
						<div class="modal-body">
							<div class="form-group">
								<label>글 제목</label>
								<input class="form-control" name="title" required>
							</div>
							<div class="form-group">
								<label>글내용</label>
								<textarea class="form-control" rows="3" name="content" required></textarea>
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">수정완료</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../includes/footer.jsp" />

</html>