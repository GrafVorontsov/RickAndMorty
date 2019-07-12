<%@ page contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h3>Find characters</h3>

<form action="/characterList" method="post">
     <label>Name</label>
     <input name="search_name" placeholder="Enter name" value=""/>
     <input type="submit" value="Search" />
</form>