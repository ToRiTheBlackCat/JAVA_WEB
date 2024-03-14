<%-- 
    Document   : search
    Created on : Jan 26, 2024, 4:16:28 PM
    Author     : PC
--%>

<%@page import="java.util.List"%>
<%@page import="Registration.RegistrationDTO"%>
<%@page import="Registration.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SEARCH PAGE</title>
    </head>
    <body>
       <style>
            #search_div{
                background-image: linear-gradient(45deg, #9e50e1, #ff91e7);
                border-radius: 15px 60px;
                border: 2px solid black;
                width: 28%;
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
            h1{
                margin-left: 100px;
            }
            #sr{
                font-weight: 400;
                color: #33ffa4;
                
            }
        </style>
            
        <%
            String username = "";
            Cookie[] cookies = request.getCookies();
            if( cookies != null){
               
                for( Cookie c: cookies){
                    username = c.getName();
                }
            }
        %>
        <div id="welcome"> 
            <h3 style="color: red">Welcome, <%= username %> </h3>
        </div>
        
            <div id="search_div">
                <h1 style="color: #fffa88">Search Page</h1>
                <table>
                    <form action="MainController" >
                        <tr>
                            <td id="sr">Search Value</td> 
                            <td><input type="text" name="txtSearchValue" value=""><br/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input class="click" type="submit" value="Search" name="btAction"<br/>
                                
                            </td>
                        </tr>
                    </form>
                    
                </table>
            </div>
        <br>
                <%-- Search --%> 
            <%
                
                //Lấy những giá trị tìm được từ SearchServlet lên  
                String searchValue = request.getParameter("txtSearchValue");
                //Catch trường hợp lần đầu tiên vào chưa có giá trị search
                if( searchValue != null){
                out.println("Your search value is: " + searchValue);
              
            
                List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");
                if (result != null) {
                out.println("<table border='1'>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>No.</th>");
                out.println("<th>UserName</th>");
                out.println("<th>Password</th>");
                out.println("<th>FullName</th>");
                out.println("<th>Role</th>");
                out.println("<th>Delete</th>");
                out.println("<th>Update</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                int count = 0;

                for (RegistrationDTO dto : result) {
                  
                    String urlRewriting = "MainController?btAction=Delete&pk=" + dto.getUsername() + "&lastSearchValue=" + request.getParameter("txtSearchValue");

                    out.println("<tr>");
                    out.println("<form action='MainController' method='POST' accept-charset=\"UTF-8\" >"); // Start form
                    out.println("<td>" + ++count + "</td>");
                    out.println("<td>" + dto.getUsername() + "</td>");
                    out.println("<td><input type='text' name='txtPassword' value='" + dto.getPassword() + "' /></td>");
                    out.println("<td><input type='text' name='txtFullName' value='" + dto.getLastname() + "' /></td>");
                    out.println("<td><input type='checkbox' name='chkRole' " + (dto.isRole() ? "checked" : "") + " />Admin</td>");
                    out.println("<td>" + " <a href='" + urlRewriting + "'>Delete </a>" + "</td>");
                    out.println("<td><input type='submit' value='Update' name='btAction' /></td>");
                    out.println("<input type='hidden' name='txtUserName' value='" + dto.getUsername() + "' />"); // Hidden field for username
                    out.println("<input type='hidden' name='lastSearchValue' value='" + searchValue + "' />"); // Hidden field for last search value
                    out.println("</form>"); // End form
                    out.println("</tr>");
                }
                
                out.println("</tbody>");
                out.println("</table>");
            } else {
                out.println("<h2>No record is matched</h2>");
            }
                  } 

            %>
            
            
                
        
    </body>
</html>
