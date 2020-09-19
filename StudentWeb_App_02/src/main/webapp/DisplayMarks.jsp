<%@page import="com.dxc.dao.MarksJdbcDAO"%>
<%@page import="com.dxc.dao.ExamJdbcDAO"%>
<%@page import="com.dxc.beans.Marks"%>
<%@page import="com.dxc.beans.Exam"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mark_Display</title>
</head>
<body>

  <label for="examid">Choose one:</label>
  <select id="examid" name="examid">
  <option value="examid">examid</option>
  <%
  String examid="";
  List<Exam> exams=new ExamJdbcDAO().findAll();
  for(Exam exam:exams)
  {
  %>
    <option value="examid"><%=exam.getExamid()%></option>
    <%
   examid=exam.getExamid();
  }
    %>
  </select>
  <form action="MarkDisplay.jsp">
  <input type="submit" value="Display">
  </form>
 <table>
	<tr>
	<th>Id</th>
	<th>ExamId</th>
	<th>Sub1</th>
	<th>Sub2</th>
	<th>Sub3</th>
	</tr>
	<%
	List<Marks> marks=new MarksJdbcDAO().findAll();
	for(Marks mark : marks)
	{
		%>
		<tr>
		<td><%= mark.getId()%></td>
		<td>name</td>
		<td><%= mark.getSub1()%></td>
		<td><%=mark.getSub2()%></td>
		<td><%=mark.getSub3() %></td>		
		<td><a href='markEdit.jsp?eid=<%=mark.getExamid()%>?sid=<%=mark.getId()%>'>Edit</a>/
			<a href='deletemark?eid=<%=mark.getExamid()%>?sid=<%=mark.getId()%>'>Delete</a></td>
		</tr>
		<%
	}
	%>
	
	</table>
		<br><a href="addMark.jsp">Add New Student</a><br><br>

</body>
</html>