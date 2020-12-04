<%@page import="com.cdac.dto.User"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


<style>
.btn {
  border: 2px solid black;
  background-color: white;
  color: black;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
}

/* Green */
.success {
  border-color: #4CAF50;
  color: green;
}

.success:hover {
  background-color: #fff;
  color: white;
}

/* Blue */
.info {
  border-color: #2196F3;
  color: dodgerblue;
}

.info:hover {
  background: #2196F3;
  color: white;
}

/* Orange */
.warning {
  border-color: #ff9800;
  color: orange;
}

.warning:hover {
  background: #ff9800;
  color: white;
}

/* Red */
.danger {
  border-color: #f44336;
  color: red;
}

.danger:hover {
  background: #f44336;
  color: white;
}

/* Gray */
.default {
  border-color: #e7e7e7;
  color: black;
}

.default:hover {
  background: #e7e7e7;
}
</style>
</head>
<body>

<div class="container-fluid p-0" style="background: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5))">
	
	<nav class="navbar navbar-expand-lg navbar-light  bg-dark ">
  <a class="navbar-brand text-light col-7" href="#"><h5>Hi <%=((User)session.getAttribute("LoggedUser")).getuName() %> </h5></a>
  	
  <div class="collapse navbar-collapse col-5" id="navbarNav">
	    <ul class="navbar-nav ml-auto">
	      <li class="nav-item active  mr-2 ">
	        <h5><a class="nav-link text-light" href="#">Home <span class="sr-only">(current)</span></a></h5>
	      </li>
	      
	      <li class="nav-item active  mr-2 ">
	        <h5><a class="nav-link text-light" href="UserLogout.htm">Logout <span class="sr-only">(current)</span></a></h5>
	      </li>           
	    </ul>
  </div>
</nav>

<!--
<div class="container-fluid d-flex justify-content-center "style="height: 100vh ;
	background: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5)),url(suff.jpg);
 background-size:cover;background-position:center; background-repeat:no-repeat">
 		
 		 <table align="center" >
		<tr>
			<td><button class="btn btn-secondary"  type="button">Add Member</td>
			<td><button class="btn btn-secondary"  type="button">Member List</td>
			
		</tr>
		
		<tr>
			<td><button class="btn btn-secondary"  type="button">Add Package</td>
			<td><button class="btn btn-secondary"  type="button">Package List</td>
			
		</tr>
		
	</table> 	
</div>   -->



<div class="container-fluid" style="height: 100vh ;
	background: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5)),url(suff.jpg);
 background-size:cover;background-position:center; background-repeat:no-repeat" >
        <div class="row" style="height: 100vh;">
      
            <div class="col">
                <div class="row justify-content-center align-items-center d-flex img" style="height: 80vh; ">

                    <div class="col-8 ">
                        <div class="row" style="height: 12%;">

                        </div>
                        <div class="row">

                            <div class="col-md-6">
                                <div class="col mt-3 mb-3">
                                    <div>
	                                 	<div>
	                                        <a href="showDetails.htm" 
	                                        class="btn btn-dark btn-lg btn-block  active" role="button" 
	                                        aria-pressed="true">View Profile</a>
	                                    </div>
                                    	<br>
	                                    <div>
	                                        <a href="updateProfilViaUser.htm"
	                                            class="btn btn-dark  btn-lg btn-block  active" role="button"
	                                            aria-pressed="true">Update Profile</a>
	                                    </div>
	                                    <br>
	                                    
                                	</div>



                            	</div>


                        	</div>
                        
                        	<div class="col-md-6">

                            <div class="col mt-3 mb-3">
                                    <div>
	                                 	<div>
	                                        <a href="CurrPackage.htm" 
	                                        class="btn btn-dark btn-lg btn-block  active" role="button" 
	                                        aria-pressed="true">Current Package</a>
	                                    </div>
	                                    <br>
	                                    <div>
	                                        <a href="available_package.htm"
	                                            class="btn btn-dark btn-lg btn-block  active" role="button"
	                                            aria-pressed="true">Update Package</a>
	                                    </div>
                                	</div>



                            </div>
							
                        
                    </div>

	                                    <br>

            </div>
<div class="row justify-content-center align-items-center d-flex" >
	                                        <a href="available_package.htm"
	                                            class="btn btn-dark  btn-sm btn-block w-25  active" role="button"
	                                            aria-pressed="true">Available Package</a>
	                                    </div>

        </div>

    </div>
</div>
</div>
</div>
</div>

<footer class="page-footer font-small mdb-color pt-4" style="background-color: black;">

  <!-- Footer Links -->
  <div class="container text-center text-md-left">

    <!-- Footer links -->
    <div class="row text-center text-md-left mt-3 pb-3">

      <!-- Grid column -->
      <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
        <h6 class="text-uppercase mb-4 font-weight-bold text-light">Gym name</h6>
        <p class="text-secondary">Gym Management System developed by Star Link is an excellent solution for gyms with a large/growing number of members, or ones serving elite clientele. This solution is basically RFID and biometric-based which helps to identify the user and manage their timely memberships.
        </p>
      </div>
      <!-- Grid column -->

      <hr class="w-100 clearfix d-md-none">

      <!-- Grid column -->
      <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
        <h6 class="text-uppercase mb-4 font-weight-bold text-light">Top Gym</h6>
        <p>
          <a href="http://www.nitrro.in/">Nitrro Gym, Pune</a>
        </p>
        <p>
          <a href="https://crossfitom.wordpress.com/"> CrossFitOM, Mumbai. </a>
        </p>
       
        <p>
          <a href="https://goldsgym.in/">Gold's Gym, Delhi</a>
        </p>
        <p>
          <a href="https://www.fitnessfirst.net.in/clubs/south-point-mall-gurgaon">Fitness First, gurgaon.</a>
        </p>
      </div>
      <!-- Grid column -->

      <hr class="w-100 clearfix d-md-none">

      <!-- Grid column -->
      <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
        <h6 class="text-uppercase mb-4 font-weight-bold text-light">Useful links</h6>
        <p>
          <a href="http://hemcoindia.in/seguro.ml/"> Muscle & Beach Gym, Goa.</a>
        </p>
        <p>
          <a href="https://goldsgym.in/">Gold's Gym, Delhi</a>
        </p>
        <p>
          <a href="https://www.fitnessfirst.net.in/clubs/south-point-mall-gurgaon">Fitness First, gurgaon.</a>
        </p>
        
      </div>

      <!-- Grid column -->
      <hr class="w-100 clearfix d-md-none">

      <!-- Grid column -->
      <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
        <h6 class="text-uppercase mb-4 font-weight-bold text-light">Contact Us</h6>
        <p class="text-secondary">
          <i class="fas fa-home mr-3 text-light"></i>Deepika Dabi</p>
        <p class="text-secondary">
          <i class="fas fa-envelope mr-3"></i> Kajol Ingle</p>
        <p class="text-secondary">
          <i class="fas fa-phone mr-3"></i> +91 9644068230</p>
        <p class="text-secondary">
          <i class="fas fa-print mr-3"></i> +91 7276196865</p>
      </div>
      <!-- Grid column -->

    </div>
    <!-- Footer links -->

    <hr>

    <!-- Grid row -->
    <div class="row d-flex align-items-center">

      <!-- Grid column -->
      <div class="col-md-7 col-lg-8">

        <!--Copyright-->
        <p class="text-center text-md-left">© 2020 Copyright:
          <a href="">
            <strong> GymManagement.com</strong>
          </a>
        </p>

      </div>
      <!-- Grid column -->

      <!-- Grid column -->
      <div class="col-md-5 col-lg-4 ml-lg-0">

        <!-- Social buttons -->
        <div class="text-center text-md-right">
          <ul class="list-unstyled list-inline">
            <li class="list-inline-item">
              <a class="btn-floating btn-sm rgba-white-slight mx-1">
                <i class="fab fa-facebook-f"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a class="btn-floating btn-sm rgba-white-slight mx-1">
                <i class="fab fa-twitter"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a class="btn-floating btn-sm rgba-white-slight mx-1">
                <i class="fab fa-google-plus-g"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a class="btn-floating btn-sm rgba-white-slight mx-1">
                <i class="fab fa-linkedin-in"></i>
              </a>
            </li>
          </ul>
        </div>

      </div>
      <!-- Grid column -->

    </div>
    <!-- Grid row -->

  </div>
  <!-- Footer Links -->

</footer>
</body>
</html>