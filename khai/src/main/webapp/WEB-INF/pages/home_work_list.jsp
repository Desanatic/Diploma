<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
        <div class="col-md-offset-2 col-sm-2">
          <h5 class="checkCursor home-work-modal-btm" >
            <i class="fa fa-pencil-square-o"> Добавить работу</i>
          </h5>
        </div>
        <div class=" col-sm-2">
            <h5 class="checkCursor task-modal-btm" >
              <i class="fa fa-pencil-square-o"> Добавить задание</i>
            </h5>
        </div>

        <div class="col-sm-12 about-us-text wow fadeInLeft">
          <table class="table current_tasks">
            <tr class="head_type">
              <td>ID</td>
              <td>Предмет</td>
              <td>Название</td>
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
              <td>Дата сдачи</td>
              <td>Оценка</td>
            </tr>

          </table>
        </div>
      </div>
    </div>
  </div>

  <!-- TASK MODAL -->
  <div id="task-modal" class="modal fade" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Инспектор заданий</h4>
        </div>
        <div class="modal-body">
          <div class="row">
            <h5 id="title-box-in-task-modal">About Us</h5>
            <div class="col-md-offset-3 col-sm-6" id="task-modal-body">

            </div>
          </div>

        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-xs btn-default" id="back-btn">Назад</button>
          <button type="button" class="btn btn-xs btn-default" id="sendResult" >Дальше</button>
        </div>
      </div>
    </div>
  </div>


  <!-- Javascript -->
  <script src="/resources/js/jquery-1.11.1.min.js"></script>
  <script src="/resources/js/custom_js/util/cursor.js"></script>
  <script src="/resources/js/custom_js/active/home_work_list_active.js"></script>
  <script src="/resources/js/custom_js/active/task_modal.js"></script>
</t:template>
