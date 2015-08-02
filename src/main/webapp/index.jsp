<%@ page import="static java.lang.Package.*" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Properties" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    Properties prop = new Properties();
    prop.load(pageContext.getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
%>
<h2>Manifest: <%=prop.getProperty("Manifest-Version")%></h2>
Project Name: <%=prop.getProperty("Name")%><br/>
Specification-Vendor: <%=prop.getProperty("Specification-Vendor")%><br/>
Specification-Title: <%=prop.getProperty("Specification-Title")%><br/>
Specification-Version: <%=prop.getProperty("Specification-Version")%><br/>
Implementation-Version: <%=prop.getProperty("Implementation-Version")%> <br/>

</body>
</html>
