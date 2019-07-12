<%@ page contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
     <meta charset="UTF-8">
     <title>Character List</title>
    <link href="css/form.css" rel="stylesheet">
 </head>
 <body>
 <jsp:include page="_header.jsp"/>
 <jsp:include page="menu.jsp"/>
 <jsp:include page="search.jsp"/>

 <table>
     <tr>
         <th>Description</th>
         <th>Image</th>
     </tr>
     <c:forEach items="${charList}" var="cr" >
     <tr>
         <td>
             <dl>
                 <dt>Name</dt>
                     <dd>${cr.name}</dd>
                 <dt>Status</dt>
                     <dd>${cr.status}</dd>
                 <dt>Species</dt>
                     <dd>${cr.species}</dd>
                 <dt>Type</dt>
                     <dd>${cr.type}</dd>
                 <dt>Gender</dt>
                     <dd>${cr.gender}</dd>
                 <dt>Origin</dt>
                     <dd>${cr.origin.name}</dd>
                 <dt>Location</dt>
                     <dd>${cr.location.name}</dd>
                 <dt>Episode</dt>
                     <dd><c:forEach items="${cr.episodes}" var="epz" >
                         ${epz.episode}&nbsp;-&nbsp;${epz.name}<br/>
                     </c:forEach></dd>
                 <dt>Created</dt>
                     <dd>${cr.created}</dd>
             </dl>
         </td>
         <td><img src="${cr.img_url}"></td>
     </tr>
     </c:forEach>
     <c:if test="${!empty charRand}">
     <tr>
         <td>
             <dl>
                 <dt>Name</dt>
                 <dd>${charRand.name}</dd>
                 <dt>Status</dt>
                 <dd>${charRand.status}</dd>
                 <dt>Species</dt>
                 <dd>${charRand.species}</dd>
                 <dt>Type</dt>
                 <dd>${charRand.type}</dd>
                 <dt>Gender</dt>
                 <dd>${charRand.gender}</dd>
                 <dt>Origin</dt>
                 <dd>${charRand.origin.name}</dd>
                 <dt>Location</dt>
                 <dd>${charRand.location.name}</dd>
                 <dt>Episode</dt>
                 <dd><c:forEach items="${charRand.episodes}" var="ep" >
                     ${ep.episode}&nbsp;-&nbsp;${ep.name}<br/>
                 </c:forEach></dd>
                 <dt>Created</dt>
                 <dd>${charRand.created}</dd>
             </dl>
         </td>
         <td><img src="${charRand.img_url}"></td>
     </tr>
     </c:if>
 </table>
 <jsp:include page="_footer.jsp"/>
 </body>
</html>