<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="rbs.module.transaction.model.Transaction"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body align="center">
	<div class='well'>

		<form method="get" action="SearchController">
			<div>
				Select Criteria:
					<input type="checkbox" name="Account Number" value="criteria1"
					onclick="showMe('div1', this)">
					<input type="checkbox" name="Account Type" value="criteria2"
					onclick="showMe('div2', this)">
					<input type="checkbox" name="Transaction date" value="criteria3"
					onclick="showMe('div3', this)">
				
			</div>
			
			<div id="div1" style="display: none">[formidable id=1]</div>
			<div id="div2" style="display: none">[formidable id=2]</div>
			<div id="div3" style="display: none">[formidable id=3]</div>
			
			<form id="1"><input type="number" value =criteria_value > </form>
			<form id="2"><input type="text" value =criteria_value ></form>
			<form id="3"><input type="date" value =criteria_value ></form>
			<script type="text/javascript">

				function showMe(it, box) {
					var vis = (box.checked) ? "block" : "none";
					document.getElementById(it).style.display = vis;
				}
			</script>
		

			Enter Value:<input type="text" name="criteria_value" id="5">
			to <input type="text" name="criteria_value1"></br> <input
				type="submit" value="submit" id=5> <input type="text"
				name="criteria_value" id="6"> <input type="text"
				name="criteria_value" id="7">
		</form>
		<%
			ArrayList<Transaction> resultSet = (ArrayList<Transaction>) request.getAttribute("resultSet");
			if (resultSet != null) {
				out.println("<table border=1>");
				for (Transaction arr : resultSet) {
					out.println("<tr><td>" + arr.getTransactionId() + "</td><td> " + arr.getTransactionDate()
							+ "</td><td> " + arr.getTransactionFrom() + "</td><td> " + arr.getTransactionFromType()
							+ "</td><td> " + arr.getTransactionTo() + "</td><td> " + arr.getTransactionToType()
							+ "</td><td> " + arr.getAmount() + "</td><td> " + arr.getAccountType() + "</td></tr>");

				}
				out.println("</table>");
			}
		%>
	</div>
</body>
</html>