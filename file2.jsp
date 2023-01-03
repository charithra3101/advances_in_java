<%-- 
    Document   : file2
    Created on : 3 Jan, 2023, 3:03:21 PM
    Author     : mcacnj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student INformation</title>
    </head>
    <body>
    <center><br><br><br>
        <b>STUDENT DETAILS RETRIVED FROM STUDENT BEAN</b>
        <jsp:useBean id="stud" scope="session" class="program.StudentBean"/>
        
    </center>
          <table>
                <tr>
                <tr><td>Student Name:<jsp:getProperty name="stud" property="name" /></td></tr>
                <tr><td>Student USN:<jsp:getProperty name="stud" property="usn" /></td></tr>
                <tr><td>Student Branch:<jsp:getProperty name="stud" property="branch" /></td></tr>
                <tr><td>Email_id:<jsp:getProperty name="stud" property="email" /></td></tr>
                <tr><td>Contact:<jsp:getProperty name="stud" property="phone" /></td></tr>
                </tr>
            </table>
        
        
        
    </body>
</html>
