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
          

            <a href="new">Create Food Item</a>
            
            <a href="../food">Inventory</a>
            
             <a href="h4_status">Order Status</a>
        </nav>
        <cs3220:AdminHeader/>

    </header>
    
    <main>
        <div class="container ">
            <h3>Order Statuses</h3>
            <table class="status-table ">
                <thead>
                    <tr>
                       
                        <th>Item</th>
                        <th>Customer</th>
                        <th>Status</th>
                        <th>Edit</th>
                        
                    </tr>
                </thead>
                <tbody>
            <tbody>
       		<c:forEach items="${orderlist}"  var="hw4items">
       		<tr>
       		<td>${hw4items.getName()}</td>
       		<td>${hw4items.getCustomername()}</td>
       		<td>${hw4items.getStatus()}</td>
       		<td><form method="post">
					<select id="status" name="status">
					<option value="IN_QUEUE">In_QUEUE</option>
					<option value="IN_PROGRESS">IN_PROGRESS</option>
					<option value="COMPLETED">COMPLETED</option>
					</select>
					<button  class="button1" name="change" value="${hw4items.id}">Update Status</button>
					</form>
				</td>
						
     		
       		</tr>
       		</c:forEach>
       	                </tbody>
           
            </table>
            
           


        </div>

 
            
           
    </main>
    
    </body>

</body>

<footer class="footer ">
    Copyright © 2012-2017. All rights reserved.
</footer>
</html>