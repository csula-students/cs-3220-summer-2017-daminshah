<%@ page language="java" contentType="text/html; charset=UTF-8"	
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%--  <%@ taglib uri="adminHeader.tld" prefix= "cs3220"%>
     --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href='<c:url value='/app.css'></c:url>'">
    <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Cabin' rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width, initial-scale=1" shrink-to-fit=no " />
</head>
<body>
<header class="clearfix ">
        <nav>
          

            <a href="menu">Menu</a>

            <a href="h4_order">Order</a>
            
             <a href="h4_status">Order Status</a>
        </nav>
        <cs3220:AdminHeader/>

    </header>
    
    <main>
        <div class="container ">
            <h2>Your Order</h2>
     
       
       		<table border=2>
       		<tr>
       		<thead>
       			<th>Name</th>
       			<th>Description</th>
       			<th>Price</th>
       			<th>Delete</th>
       			
       			</thead>
       		</tr>
       		<tbody>
       		<c:forEach items="${cartlist}"  var="hw4items">
       		<tr>
       		<td>${hw4items.getName()}</td>
       		<td>${hw4items.getDescription()}</td>
       		<td>${hw4items.getPrice()}</td>
       		<td><form method="get"><button name="Delete" value="${hw4items.id}">Delete</button></form>
				</td>
       		</tr>
       		</c:forEach>
       		</tbody>
       		</table>    
       		
       		<form method="post">
			<label>Your Name:</label><br>
			<input name='customer_name' type='text' /><br><br>
			<button class="button1">Place Your order</button>
	</form>
       		
    </main>
    
    </body>

</body>

<footer class="footer ">
    Copyright © 2012-2017. All rights reserved.
</footer>
</html>