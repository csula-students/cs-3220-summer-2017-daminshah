<%@ page language="java" contentType="text/html; charset=UTF-8"	
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ taglib uri="adminHeader.tld" prefix= "cs3220"%>
    
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
            <h3>Order Statuses</h3>
            <table class="status-table ">
                <thead>
                    <tr>
                        <th>Created</th>
                        <th>Item</th>
                        <th>Customer</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
            <c:forEach items = "${sampleorders}" var="sampleorders">
        	<tr>
        	
        	<td>${sampleorders.getDate()}</td>
        	<td>${sampleorders.getName()}</td>	
        	<td>${sampleorders.getCustomername()}</td>
        	<td><form name="status" method="get" action="#">
							<select>
								<option>In_QUEUE</option>
								<option>IN_PROGRESS</option>
								<option>COMPLETED</option>

							</select>
						</form></td>
                </tbody>
                 </c:forEach>
            </table>
            
           


        </div>

 
            <button class="button1">Update Status</button>
           
    </main>
    
    </body>

</body>

<footer class="footer ">
    Copyright © 2012-2017. All rights reserved.
</footer>
</html>