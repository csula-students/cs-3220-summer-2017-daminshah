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
</head>

<header class="clearfix">
    <nav>
       
        <a href="create-food.jsp">Create food</a>
        <a href="inventory.jsp">Inventory</a>
         <a href="order-statuses.jsp">Order Status</a>
    </nav>
    
      <cs3220:AdminHeader/>
    
    
</header>
    
    <br/>
<br/>
<main>
    <h2>
        Inventory For Food Items
    </h2>
    
     <table id="inventory_table">
        <thead>
            <th>
                <h4>Food Name</h4>
            </th>
            <th>
                <h4>Image</h4>
            </th>
            <th>
                <h4>Description</h4>
            </th>
            <th>
                <h4>Price</h4>
            </th>
        </thead>
        <tbody>
        <c:forEach items = "${list}" var="lab6item">
        	<tr>
        	<td>${lab6item.getName()}</td>	
        	<td> <img src="${lab6item.getUrl()}" width="100" height="100"> <br> </td>
        	<td>${lab6item.getDescription()}</td>
        	<td>${lab6item.getPrice()}</td>
        	
        	<td><form action="#" method="get"> <button class="button1" name="Submit" value="${lab6item.getId()}">Add to Cart</button></form></td>
        	</tr>
        	</c:forEach>
        </tbody>
        
         
</form>
        
    </table>
    
   <!--   <a href="lab6CreatefoodadminServlet"><button class="button1">Add new Food</button></a>
     <a href="lab6MenuServlet"><button class="button1">Go to Main Menu</button></a>
 --></main>
    

<footer class="footer ">
    Copyright © 2012-2017. All rights reserved.
</footer>
<body>

</body>
</html>