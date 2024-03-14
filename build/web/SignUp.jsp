<%-- 
    Document   : SignUp
    Created on : Feb 27, 2024, 3:23:01 PM
    Author     : PC
--%>

<%@page import="trinhm.controller.SignUpError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <style>
             #signup_div{
                background-image: linear-gradient(45deg, #9e50e1, #ff91e7);
                border-radius: 15px 60px;
                border: 2px solid black;
                width: 55%;
                padding-bottom: 15px;
            }
            h1{
                font-size: 1.5em;
                color: #fffa88;
                margin-left: 40px;
            }
            .click{
                background-color: #f5c44f;
                border-radius: 15px;
                width: 60px;
                height: 30px;
            }
            .click:hover{
                background-color: #d74061;
                font-weight: 500;
                
            }
            .click:active{
                color: white;
                background-color: #8433c3;
            }
            table{
                margin-left: 15px;
            }
            th{
                color: #33ffa4;
                font-weight: 400;
            }
            #note{
                font-size: 14px;
            }
        </style>
        <div id="signup_div">
            <h1>CREATE NEW ACCOUNT</h1>
            <form action="MainController" method="POST">
                <table>
                    <tbody>
                        <tr>
                            <th>USERNAME*</th>
                            <td><input type="text" name="txtUsername" value="<%= request.getParameter("txtUsername")%>" />(6 - 12 characters</td>
                            <td style="color: red">
                                <%
                                    SignUpError errors = (SignUpError) request.getAttribute("SIGNUPERROR");

                                    if (errors != null) {
                                        if (errors.getUsernameLengthError() != null) {
                                %>
                                <%= errors.getUsernameLengthError()%><br/>

                                <%
                                        }
                                    } // end if errors
                                %>

                            </td>
                        </tr>
                        <tr>
                            <th>PASSWORD*</th>
                            <td><input type="password" name="txtPassword" /> (8 - 20 characters)</td>
                            <td style="color: red">
                                <%
                                    if (errors != null) {
                                        if (errors.getPasswordLengthError() != null) {
                                %>
                                <%= errors.getPasswordLengthError()%><br/>

                                <%
                                        }
                                    } // end if errors
                                %>
                            </td>
                        </tr>
                        <tr>
                            <th>CONFIRM*</th>
                            <td><input type="password" name="txtConfirm" /></td>
                            <td style="color: red">
                                <%
                                    if (errors != null) {
                                        if (errors.getConfirmNoMatch() != null) {
                                %>
                                <%= errors.getConfirmNoMatch()%><br/>

                                <%
                                        }
                                    } // end if errors
%>
                            </td>
                        </tr>
                        <tr>
                            <th>FULLNAME*</th>
                            <td><input type="text" name="txtName" value="<%= request.getParameter("txtName")%>" />(2 - 50 characters)</td>
                            <td style="color: red">
                                <%

                                    if (errors != null) {
                                        if (errors.getFullNameLengthError() != null) {
                                %>
                                <%= errors.getFullNameLengthError()%><br/>

                                <%
                                        }
                                    } // end if errors
                                %>

                            </td>
                        </tr>
                        <tr>
                            <th>ROLE</th>
                            <td><input type="checkbox" name="chkRole" />Admin(Optional)</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input class="click" type="submit" name="btAction" value="Sign Up" />
                                
                            </td>
                        </tr>
                    </tbody>
                </table>

            </form><br/>
            <font color="red">
            <%
                if (errors != null) {
                    if (errors.getUsernameIsExisted() != null) {
            %>
            <%= errors.getUsernameIsExisted()%><br/>
            <%      } 
                }
            %>
            </font>
        </div>

    </body>
</html>
