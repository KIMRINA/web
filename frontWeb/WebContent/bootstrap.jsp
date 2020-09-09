<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
<style>
.container {
	min-height: 500px;
}

/* div {border: 1px solid blue;} */
.card {
	display: inline-block;
}
</style>
</head>
<body>
	<div class="container">
		<div>
			<div class="card" style="width: 18rem;">
				<img src="./images/nini1.gif" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			<div class="card" style="width: 18rem;">
				<img src="./images/nini2.gif" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			<div class="card" style="width: 18rem;">
				<img src="./images/nini3.gif" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
		</div>
		<div>
			<a href="#" class="btn btn-danger">링크버튼</a> <span
				class="btn btn-danger">스팬버튼</span>
			<button class="btn btn-danger">
				버튼<span class="badge badge-warning">4</span>
			</button>
		</div>
		<div class="alert alert-danger" role="alert">
			A simple <a href="#" class="alert-link">an example link</a> primary
			alert—check it out!
		</div>
		<!-- Content here -->
		<div class="row justify-content-center">
			<div class="col-2">로고</div>
			<div class="col-6">메뉴</div>
		</div>
		<div class="row align-items-center">
			<div class="col-xl-4 col-md-6 col-sm-12">
				<table class="table table-striped table-hover">
					<thead class="thead-dark">
						<tr>
							<th scope="col">#</th>
							<th scope="col">First</th>
							<th scope="col">Last</th>
							<th scope="col">Handle</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>Jacob</td>
							<td>Thornton</td>
							<td>@fat</td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>Larry</td>
							<td>the Bird</td>
							<td>@twitter</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-xl-4 col-md-6 col-sm-12">
				<form>
					<div class="form-group row">
						<label class="col-3">id</label>
						<div class="col-9">
							<input class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-3">pw</label>
						<div class="col-9">
							<input class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<button class="btn btn-success">등록</button>
					</div>
				</form>


			</div>
			<div class="col-xl-4 col-md-12 col-sm-12">div3</div>
		</div>
	</div>
</body>
</html>