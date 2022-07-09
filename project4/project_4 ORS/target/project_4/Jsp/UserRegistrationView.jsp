<%@page import="in.co.rays.project4.Ctl.UserRegistrationCtl"%>
<%@page import="in.co.rays.project4.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project4.util.DataUtility"%>
<%@page import="in.co.rays.project4.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
.p1{
font-size: 18px;
font-weight: bold;
}
.p2{
padding: 5px;
margin: 3px;
}
.footer{
	position:relative;
	left:  0;
	bottom: 0;
	width: 100%;
	text-align:center;
}
</style>
<script> 
      function phoneno() {
	$('#phone').keypress(function(e) {
		var a = [];
		var k = e.which;

		for (i = 48; i < 58; i++)
			a.push(i);

		if (!(a.indexOf(k) >= 0))
			e.preventDefault();
	});
}

$(function() {
	$("#datepicker").datepicker({
		changeMonth : true,
		changeYear : true,
		yearRange : '1970:2030',
		dateFormat : 'dd/mm/yy',
		endDate : '-18y',
			maxDate:0
	});
});

</script>
</head>
<body>
    <form action="<%=ORSView.USER_REGISTRATION_CTL%>" METHOD="POST">
     <%@ include file="Header.jsp"%>
      
        <jsp:useBean id="bean" class="in.co.rays.project4.bean.UserBean"
            scope="request"></jsp:useBean>

        <center>
            <h1 style="font-size: 40px;">User Registration</h1>

            <H2>
                <font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
                </font>
            </H2>
            <H2>
                <font color="red"> <%=ServletUtility.getErrorMessage(request)%>
                </font>
            </H2>

            <input type="hidden" name="id" value="<%=bean.getId()%>">
            <input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
            <input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>">
            <input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
            <input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">
            

            <table>
    
    <tr>
  
    
      <th align="left" class="p1">First Name<span style="color:red;">*</span></th>
                    <td><input type="text" name="firstName" size="40"  class="p2" placeholder="please enter name" 
                        value="<%=DataUtility.getStringData(bean.getFirstName())%>"></td>
						<td><font  color="red"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></td>
                       
                </tr>
                <tr>
                    <th align="left" class="p1">Last Name<span style="color:red;">*</span></th>
                    <td><input type="text" name="lastName" size="40" class="p2" placeholder="please  enter last name"
                        value="<%=DataUtility.getStringData(bean.getLastName())%>"></td>
						<td><font
                        color="red"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></td>
                </tr>
                <tr>
                    <th align="left" class="p1">LoginId<span style="color:red;">*</span></th>
                    <td><input type="text" name="login" size="40"  class="p2"
                        placeholder="Must be Email ID"
                        value="<%=DataUtility.getStringData(bean.getLogin())%>"></td>
						<td><font
                        color="red"> <%=ServletUtility.getErrorMessage("login", request)%></font></td>
                </tr>
                <tr>
					<th align="left" class="p1">MobileNo<span style="color:red;">*</span></th>
					<td><input type="text" name="mobile" size="40"  maxlength="10" class="p2" placeholder="please enter mobile no"
						value="<%=DataUtility.getStringData(bean.getMobileNo())%>"></td>
						<td><font
						color="red"> <%=ServletUtility.getErrorMessage("mobile", request)%></font></td>
				</tr>
                <tr>
                    <th align="left" class="p1">Password<span style="color:red;">*</span></th>
                    <td><input type="password" name="password" size="40" class="p2" placeholder="please enter password"
                        value="<%=DataUtility.getStringData(bean.getPassword())%>"></td>
						<td><font
                        color="red"> <%=ServletUtility.getErrorMessage("password", request)%></font></td>
                </tr>
                <tr>
                    <th align="left" class="p1">Confirm Password<span style="color:red;">*</span></th>
                    <td><input type="password" name="confirmPassword" size="40" class="p2" placeholder="re-enter password"
                        value="<%=DataUtility.getStringData(bean.getConfirmPassword())%>"></td>
						<td><font
                        color="red"> <%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></td>
                </tr>
                <tr>
                    <th align="left" class="p1">Gender <span style="color:red;">*</span></th>
                    <td>
                        <% 
                            HashMap map = new HashMap();
                            map.put("Male", "Male");
                            map.put("Female", "Female");

                            String htmlList = HTMLUtility.getList("gender", bean.getGender(),
                                    map);
                        %> <%=htmlList%></td>
						<td><font color="red"> <%=ServletUtility.getErrorMessage("gender", request)%></font>

                    </td>
                </tr>

                  <tr>
                    <th align="left" class="p1">Date Of Birth<span style="color:red;">*</span> </th>
                    <td><input type="text"  readonly="readonly" name="dob" id="datepicker"  size="40" class="p2"
                        placeholder="dd/MM/yyyy"
                        value="<%=DataUtility.getDateString(bean.getDob())%>"> </td>
						<td >
                   <font color="red"> <%=ServletUtility.getErrorMessage("dob", request)%></font></td>
                </tr> 
   
                <tr> 
                    <th></th>
                    <td colspan="2" align="center">
                         <input type="submit" name="operation" value="<%=UserRegistrationCtl.OP_SIGN_UP %>" style="padding: 5px;">
                    &nbsp;
                        &nbsp; <input type="submit" name="operation" value="<%=UserRegistrationCtl.OP_RESET %>" style="padding: 5px;">
                    </td>
                </tr>
            </table>
    </form>
    </center>
    <div class="footer">
<hr>
<center> 
  <h4>
  <i><b>&copy;RAYSTechnologies</b></i></div></h4>
  </center>
</body>
</html>   