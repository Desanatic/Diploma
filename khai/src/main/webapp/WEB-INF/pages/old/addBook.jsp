<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:template>
  <form:form method="post" action="addBook" modelAttribute="book">
    <table>
      <tr>
        <td>Name</td>
        <td><form:input path="name"/></td>
        <td><form:errors path="name"/></td>
      </tr>

      <tr>
        <td>Genre</td>
        <td><form:input path="genre"/></td>
        <td><form:errors path="genre"/></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="addBook"/></td>
      </tr>
    </table>
  </form:form>
</t:template>