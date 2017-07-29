<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      
<%--           <%@ taglib uri="adminHeader.tld" prefix= "cs3220"%>
 --%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="../app.css">
    <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Cabin' rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width, initial-scale=1" shrink-to-fit="no ">

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
        <h2>Create a new Item</h2>

        <form action="../create" method="post">
            <fieldset>
                <legend>
                    <h2>Food Information</h2>
                </legend>
                <table>
                    <tr>
                        <td>
                            <h3>Food Name</h3>
                            <input type="text" name="name" id="item_name"></input>
                            <br><br>
                            <h3>Image Link</h3>
                            <input type="text" name="image" id="item_image"></input>
                            <br><br>
                            <h3>Food Description</h3>
               
                            <textarea id="item_description" name="description"></textarea>
                           
                        </td>
                        <!--<td>
                            <h3>Ingredients</h3>
                            <input type='text' id = 'ingredient' />
                            <!--<input type='button'class="button1" value = 'Add Ingredient' id = 'add'>
                            <button id="create_ingredient_button"   type="button">Add</button>
                            <ul id="ingredientlist">
                            <li>
                                Ingredients
                            </li>
                            </ul>
                        </td>-->
                        <td>
                        	 <h3>Food Price</h3>
                            <input id="item_price" name="price"></input>
                        </td>
                    </tr>

                    <tr>
                        <td>
                           <!--  <button id="create_food_button" button class="button1" type="button">Add this</button>
 -->
 					<input type="submit" value="Submit">
 					
 					
                        </td>



                    </tr>
                </table>
            </fieldset>
        </form>










    </main>

    

</body>
<footer class="footer ">
    Copyright © 2012-2017. All rights reserved.
</footer>
</html>