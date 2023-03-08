<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!-- <link -->
<!-- 	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" -->
<!-- 	rel="stylesheet" -->
<!-- 	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" -->
<!-- 	crossorigin="anonymous"> -->

<!-- <title>JSP Form Validation</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<form action=""> -->
<!-- 		<div class="mb-3"> -->
<!-- 			<label for="exampleInputEmail1" class="form-label">Email -->
<!-- 				address</label> <input type="email" class="form-control" -->
<!-- 				id="exampleInputEmail1" aria-describedby="emailHelp"> -->
<!-- 			<div id="emailHelp" class="form-text">We'll never share your -->
<!-- 				email with anyone else.</div> -->
<!-- 		</div> -->
<!-- 		<div class="mb-3"> -->
<!-- 			<label for="exampleInputPassword1" class="form-label">Password</label> -->
<!-- 			<input type="password" required=true class="form-control" -->
<!-- 				id="exampleInputPassword1"> -->
<!-- 		</div> -->
<!-- 		<div class="mb-3 form-check"> -->
<!-- 			<input type="checkbox" class="form-check-input" id="exampleCheck1"> -->
<!-- 			<label class="form-check-label" for="exampleCheck1">Check me -->
<!-- 				out</label> -->
<!-- 		</div> -->
<!-- 		<button type="submit" class="btn btn-primary">Submit</button> -->
<!-- 	</form> -->
<!-- </body> -->
<!-- <script -->
<!-- 	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" -->
<!-- 	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" -->
<!-- 	crossorigin="anonymous"></script> -->
<!-- <script> -->

<!-- </script> -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> -->

<!-- </html> -->

<!DOCTYPE html>
<html>
  <head>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script>
      $(document).ready(function () {
        let var1;
        const bookList = document.getElementById("book-list");
        document.getElementById("showLoader").style.display = "block";

        fetch("https://jsonplaceholder.typicode.com/users")
          .then((response) => response.json())
          .then((data) => {
            var1 = data;
            document.getElementById("showLoader").style.display = "none";
            data.forEach((user) => {
              const li = document.createElement("li");
              li.innerText = user.name;
              bookList.appendChild(li);
            });
          });
        $("form").submit(function (event) {
          event.preventDefault();
          console.log(event);
          const li = document.createElement("li");
          li.innerText = document.getElementsByTagName("input")[0].value;
          bookList.appendChild(li);

          document.getElementsByTagName("input")[0].value = "";
          document.getElementsByTagName("input")[1].value = "";
        });
      });
    </script>
  </head>
  <body>
    <form action="">
      <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <input
          type="email"
          name="new"
          required="true"
          class="form-control"
          id="exampleInputEmail1"
          aria-describedby="emailHelp"
        />
        <div id="emailHelp" class="form-text">
          We'll never share your email with anyone else.
        </div>
      </div>
      <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input
          type="password"
          required="true"
          class="form-control"
          id="exampleInputPassword1"
        />
      </div>
      <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1" />
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <div class="mt-5" id="showLoader" style="display: none">
      <div class="text-center">
        <h1>Loading...</h1>
      </div>
    </div>
    <ul id="book-list"></ul>
  </body>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"
  ></script>
  <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</html>
