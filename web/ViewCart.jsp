<%-- 
    Document   : ViewCart
    Created on : Feb 2, 2024, 4:05:05 PM
    Author     : PC
--%>

<%@page import="java.util.Map"%>
<%@page import="Registration.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VIEW CART</title>
    </head>
    <body>
        <style>
            #cart_div{
                background-image: linear-gradient(45deg, #9e50e1, #ff91e7);
                border-radius: 15px 60px;
                border: 2px solid black;
                width: 40%;
                padding-bottom: 20px;
            }
            #cart_con{
                display: grid;
                justify-content: center;
            }
            h1{
                color: #fffa88;
            }
            th{
                color: #33ffa4;
                font-weight: 600;
                font-size: 20px;
            }
            .data{
                display: flex;
                justify-content: center;
                color: white;
            }
            #checkbox{
                width: 100%;

            }
            #chk{
                display: flex;
                margin: auto;
            }
            .click{
                background-color: #f5c44f;

                height: 25px;
            }

            .click:hover{
                background-color: #d74061;
                font-weight: 500;

            }
            .click:active{
                color: white;
                background-color: #8433c3;
            }
            #buymore{
                display: flex;
                justify-content: center;
                font-size: 20px;
            }
        </style>
        <div id="cart_div">
            <div id="cart_con">
                <h1>Your Cart includes</h1>
                <%
                    if (session != null) {
                        CartObj cart = (CartObj) session.getAttribute("CART");
                        if (cart != null) {
                            if (cart.getItems() != null) {
                %>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Title</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <form action="MainController" method="POST">
                        <%
                            Map<String, Integer> items = cart.getItems();
                            int count = 0;
                            for (Map.Entry item : items.entrySet()) {
                        %>

                        <tr>
                            <td class="data" >
                                <%= ++count%>
                            </td>
                            <td style="color: white" >
                                <%= item.getKey()%>
                            </td>
                            <td class="data">
                                <%= item.getValue()%>
                            </td>
                        <div id="checkbox"> 
                            <td >
                                <input id="chk" type="checkbox" name="chkItem" value="<%= item.getKey()%>" />
                            </td>
                        </div>
                        </tr>
                        <%
                            } // đóng for
                        %>
                        <tr>
                            <td colspan="3">
                                <a style="color: #33ffa4;" href="BookStore.html">Add More Items to Your Cart</a>
                            </td>

                            <td>
                                <input class="click" type="submit" value="Remove" name="btAction" />
                            </td>

                        </tr>
                    </form>  

                    </tbody>

                </table>
            </div>
        </div>
        <%
                return;
            } // đóng if của cart.getItem
        } // đóng if của cart
        else {
        %>
        <h2>No cart is existed </h2>
        <%
                }
            } // đóng của if session != null
        %>
        <a id="buymore" href="BookStore.html">Click here to buy more</a>
    </body>
</html>
