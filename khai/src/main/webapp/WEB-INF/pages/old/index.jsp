<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>
  <h1>BookManager</h1>
  <c:if test = "${!empty books}">
    <table>
      <tr>
        <th>Name</th>
        <th>Genre</th>
        <th>&nbsp;</th>
      </tr>
      <c:forEach items = "${books}" var = "book">
        <tr>
          <td>${book.name}</td>
          <td>${book.genre}<td>
          <td><a href="deleteBook/${book.id}">delete</a> </td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
  <a href="addBook">Add Book</a>
</t:template>
