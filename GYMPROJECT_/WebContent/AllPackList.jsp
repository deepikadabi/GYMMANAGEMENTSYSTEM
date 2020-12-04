<%@page import="com.cdac.dto.User"%>
<%@page import="com.cdac.dto.Admin"%>
<%@page import="com.cdac.dto.GymPackage"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Form</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</head>
<body>

<div class="container-fluid p-0" style="background: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5))">
	
	<nav class="navbar navbar-expand-lg navbar-light  bg-dark ">
  	  <a class="navbar-brand text-light col-7" href="#"><h5>Hi <%=((Admin)session.getAttribute("LoggedAdmin")).getaEmail() %></h5></a>
  	
  <div class="collapse navbar-collapse col-5" id="navbarNav">
	    <ul class="navbar-nav ml-auto">
	      <li class="nav-item active  mr-2 ">
	        <h5><a class="nav-link text-light" href="AdminHome.jsp">Home <span class="sr-only">(current)</span></a></h5>
	      </li>
	      
	      <li class="nav-item active  mr-2 ">
	        <h5><a class="nav-link text-light" href="AdminLogout.htm">Logout <span class="sr-only">(current)</span></a></h5>
	      </li>           
	    </ul>
  </div>
</nav>

<div class="container-fluid justify-content-center" style="height: 100% ;background: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5)),url(4.jpg);
 background-size:cover;background-position:center; background-repeat:no-repeat">

	<table class="table table-striped text-light" >
	<thead >
				<tr  class="text-center text-light">
					<th colspan = "7"  ><h5>Package List</h5></th>
				</tr>

				<tr style="font-size:3vh; color: white">
					<th><h6>Package Id</h6></th>
					<th ><h6>Package Name</h6></th>
					<th ><h6>Package Duration</h6></th>
					<th ><h6>Timing</h6></th>
					<th ><h6>Charges</h6></th>
					<th ><h6>Delete</h6></th>
					<th ><h6>Update</h6></th>			
				</tr>
				
			</thead>
		<% 
		List<GymPackage> packlist = (List<GymPackage>)request.getAttribute("pList");
		for(GymPackage u : packlist){
		%>
		<tr style="font-size:2.2vh">
			<td><%=u.getpId()%></td>
			<td><%=u.getpName()%></td>
			<td><%=u.getpMonth()%></td>
			<td><%=u.getpTime()%></td>
			<td><%=u.getpCharge()%></td>
			
			<td><a href="pack_delete.htm?pId=<%=u.getpId()%>">Delete</a></td>
			<td><a href="pack_update.htm?pId=<%=u.getpId()%>">Update</a></td>	
		</tr>
		<% } %>
		
	</table>
	
	<div class="d-flex justify-content-center">
		
				<tr>
					
					<td><a href="AdminHome.jsp"  class="btn btn-danger  btn-lg btn-block w-25"  >Back</a>
</td>
				</tr>
				
				
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