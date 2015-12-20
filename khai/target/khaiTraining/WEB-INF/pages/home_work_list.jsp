<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/resources/js/jquery-1.11.1.min.js"></script>
<t:template>
  <div class="page-title-container">
    <div class="container">
      <div class="row">
        <div class="col-sm-12 wow fadeIn">
          <i class="fa fa-graduation-cap"></i>
          <h1>About /</h1>
          <p>${proverb}</p>
        </div>
      </div>
    </div>
  </div>

  <!-- About Us Text -->
  <div class="about-us-container">
    <div class="container">
      <div class="row">
        <div class="col-sm-6 about-us-text wow fadeInLeft">
          <table class="table">
            <tr>
              <td class="success">Проверено</td>
              <td class="info">Выполнено</td>
              <td class="warning">Выполняется</td>
              <td class="active">Задано</td>
              <td class="danger">Просрочено</td>
            </tr>
          </table>
        </div>

        <div class="col-sm-12 about-us-text wow fadeInLeft">
          <table class="table current_tasks">
            <tr class="head_type">
              <td>ID</td>
              <td>Предмет</td>
              <td>Название</td>
              <td>Дата выдачи</td>
              <td>Дата сдачи</td>
              <td>Оценка</td>
            </tr>


          </table>
        </div>

        <div class="col-sm-12 about-us-text wow fadeInLeft">
          <table class="table has_state">
            <tr class="head_type">
              <td>ID</td>
              <td>Предмет</td>
              <td>Название</td>
              <td>Дата выдачи</td>
              <td>Дата сдачи</td>
              <td>Оценка</td>
            </tr>

          </table>
        </div>
      </div>
    </div>
  </div>


  <!-- Javascript -->
  <script src="/resources/js/custom_js/util/cursor.js"></script>
  <script src="/resources/js/custom_js/active/home_work_list_active.js"></script>
</t:template>
