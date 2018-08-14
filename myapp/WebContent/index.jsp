<html>
	<head>
	    <script type="text/javascript">

	      function country_onchange()
	      {
	    	  		if(document.CountryForm.country.value==-1)
	    	  			{
	    	  			alert("select country");
	    	  			document.Country.state.option.lenth=0;
	    	  			return;
	    	  			}
			        var queryString = "country=" + document.CountryForm.country.value;
					var url = "CountryServlet?" + queryString;
					xmlHttpRequest = getXmlHttpRequest();
		      		xmlHttpRequest.onreadystatechange = processStateChange;
					try 
					{
			  			xmlHttpRequest.open("GET", url, true);
			  			xmlHttpRequest.send(null);			  			
					}
					catch(e) 
					{
			  			alert("Error : " + e);
					}	
	     	}      

	      function getXmlHttpRequest() 
	      {
					if (window.XMLHttpRequest) 
					{ 
			  			// Non-IE browsers
			  			req = new XMLHttpRequest();       
					} 
					else if (window.ActiveXObject) 
					{ 
			  			// IE
			  			req = new ActiveXObject("Microsoft.XMLHTTP");
					}
					return req;
	      }

	      function processStateChange()
	      {
					if(xmlHttpRequest.readyState == 4 || xmlHttpRequest.readyState == "complete")
					{
			  			if(xmlHttpRequest.status == 200)
			  			{
			    			var stateCombo = document.CountryForm.state;
			    			stateCombo.options.length = 0;
			    			var jsonArray = 
								eval( "(" + xmlHttpRequest.responseText + ")" );
			    			for (var i = 0; i < jsonArray.length; i++)
				    	 	{	
			    				stateCombo.options[stateCombo.options.length] = new Option(jsonArray[i], jsonArray[i]);
			  				}
			  			}
					}
			}

		</script>
	</head>



	<body>
		<h1>
	    <form name="CountryForm" method="post">
	        Select a Country: 
	        <select name="country" onchange="country_onchange();">
	            <option>Select</option>
	            <option value="INDIA">INDIA</option>
	            <option value="USA">USA</option>
	        </select>
	        <br>
	        Select a State:
	        <select name="state">
	        </select>
	    </form>
	  </h1>
	</body>
</html>





























<%-- <%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<script language="javascript">
      function b1_onclick()
      {
			var url = "DateTimeServlet";
			xmlHttpRequest = getXmlHttpRequest();
        	xmlHttpRequest.onreadystatechange = processStateChange;
			try 
			{
	  			xmlHttpRequest.open("GET", url, true);
	  			xmlHttpRequest.send(null);
			}
			catch(e) 
			{
	  			alert("Error : " + e);
			}	
     	}      
      function getXmlHttpRequest() 
      {
			if (window.XMLHttpRequest) 
			{ 
	  			// Non-IE browsers
	  			req = new XMLHttpRequest();       
			} 
			else if (window.ActiveXObject) 
			{ 
	  			// IE
	  			req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			return req;
      }
      function processStateChange()
      {
			if(xmlHttpRequest.readyState == 4 || xmlHttpRequest.readyState=="complete")
			{
	  			if(xmlHttpRequest.status == 200)
	  			{
	    			document.forms[0].t1.value = xmlHttpRequest.responseText;
	  			}
			}
		}
    </script>
</head>
<body>
	<h1>
		<form>
			Server Date and Time: <input type="text" name="t1" size="35"
				value="<%=new Date()%>"> 
				<input type="button" name="b1"
				value="Get Date &Time" onclick="b1_onclick()">
		</form>
	</h1>
	<h2>
		<%=new Date()%>
	</h2>
</body>
</html> --%>
