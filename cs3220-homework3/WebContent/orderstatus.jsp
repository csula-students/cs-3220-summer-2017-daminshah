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
          

            <a href="create-food.jsp ">Create Food Item</a>

            <a href="inventory.jsp ">Inventory</a>
            
             <a href="order-statuses.jsp">Order Status</a>
        </nav>
        <cs3220:AdminHeader/>

    </header>
    
    <main>
        <div class="container ">
            <h2>Your Order</h2>
            <%--  <c:forEach items = "${cartentry}" var="cartentry">
      
            
            <h2>You put ${cartentry.getName()} in the cart </h2>
            
            
            </c:forEach>
       --%>       
       
       
       		<table border=2>
       		<tr>
       		<thead>
       			<th>Name</th>
       			<th>Image</th>
       			<th>Status</th>
       			<th>Date</th>
       			
       			</thead>
       		</tr>
       		<tbody>
       		<c:forEach items="${orderitems}"  var="orderitems">
       		<tr>
       		<td>${orderitems.getFood().getName()}</td>
       		<td><img src="${orderitems.getFood().getUrl()}" width="70px"/></td>
       		<td>${orderitems.getStatuses().toString()}</td>
       		<td>${orderitems.getDate()}</td>
       		</tr>
       		</c:forEach>
       		</tbody>
       		</table>    
       		
    </main>
    
    </body>

</body>

<footer class="footer ">
    Copyright © 2012-2017. All rights reserved.
</footer>
</html>