<%@ page import="java.util.*,com.m2i.Format" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<jsp:include page="contact.jsp" flush="true" />

<%-- expression --%>
<p>Date et heure : <%= new java.util.Date() %></p>

<p>Bienvenue, <%= session.getAttribute("userName") %> !</p>
<% out.println("Page générée le : " + new java.util.Date()); %>

<%
  Integer compteur = Integer.parseInt(application.getInitParameter("visites"));
  out.println("compteur: "+ compteur);
  compteur = (compteur == null) ? 1 : compteur + 1;
  application.setAttribute("visites", compteur);
%>
<p>Visites totales : <%= compteur %></p>

<%-- scriplet --%>
<% 
  List<String>  liste = Format.getData();
  request.setAttribute("liste", liste); // Rendre disponible à JSTL
  String utilisateur = request.getParameter("user");  
  utilisateur = Format.toUpper(utilisateur);
  session.setAttribute("userName", utilisateur);
  
  // Calcul d’une valeur
  int annee = java.time.Year.now().getValue();
  out.println("Année actuelle : " + annee);
%>


 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="f" uri="http://m2i.com/tags/format" %>

<c:forEach var="item" items="${liste}">
  <li>${item}</li>
</c:forEach>


<ul>
  <c:forEach var="item" items="${f:getData()}">
    <li>${item}</li>
  </c:forEach>
</ul>


<jsp:useBean id="user"
             class="com.m2i.User"
             scope="request"/>
             
<jsp:setProperty name="user" property="username" value="test"/>


<h1><jsp:getProperty name="user" property="username"/></h1>
<p>user : ${user.username}</p>


<c:if test="${user.username == 'test'}" >
ok
</c:if>


<c:choose >
<c:when test="${user.username == 'test'}" >
ok
</c:when>
<c:when test="${user.username == 10}" >
non
</c:when>
<c:otherwise>
merci
</c:otherwise>
</c:choose>



</body>
</html>