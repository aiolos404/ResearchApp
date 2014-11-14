<%-- 
    Document   : search
    Created on : Oct 21, 2014, 9:23:25 PM
    Author     : aiolos404
--%>
<html>
    <head>
    </head>
    <body>
        <br><br><br><br><br><br>
        <form method="post" name="frm" action="../SearchResearchServlet">
            <table border="0" width="300" align="center" bgcolor="#CDFFFF">
                <tr><td colspan=2 style="font-size:12pt;color:#00000;" align="center">
                        <h3>Search Research Data</h3></td></tr>
                <tr><td ><b>Number</b></td>
                    <td>: <input  type="text" name="Number" id="Number">
                    </td></tr>
                <tr><td ><b>Name</b></td>
                    <td>: <input  type="text" name="Name" id="Name">
                    </td></tr>
                <tr><td ><b>Type</b></td>
                    <td>: <input  type="text" name="Type" id="Type">
                    </td></tr>
                <tr><td ><b>Date</b></td>
                    <td>: <input  type="text" name="Date" id="Date">
                    </td></tr>
                <tr><td ><b>Author</b></td>
                    <td>: <input  type="text" name="Author" id="Author">
                    </td></tr>
                <tr><td ><b>Publisher</b></td>
                    <td>: <input  type="text" name="Publisher" id="Publisher">
                    </td></tr>
                <tr><td colspan=2 align="center">
                        <input  type="submit" name="submit" value="Search"></td></tr>
            </table>
        </form>
    </body>
</html>