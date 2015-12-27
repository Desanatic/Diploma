<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
  <!-- CSS -->
  <!-- BBCode -->
  <link rel="stylesheet" href="/resources/css/custom_css/bbcode/theme/default/wbbtheme.css" />
  <!-- Сhart -->
  <link rel="stylesheet" href="/resources/libs/dist/chartist.min.css">
  <!-- Castom CSS-->
  <link rel="stylesheet" href="/resources/css/custom_css/main.css">

  <!-- Javascript -->
  <script src="/resources/js/jquery-1.11.1.min.js"></script>
  <!-- BBCode -->
  <script src="/resources/js/custom_js/util/bbcode/jquery.wysibb.js"></script>
  <!-- Сhart -->
  <script src="/resources/libs/dist/chartist.min.js"></script>



  <!-- Page Title -->
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
        <div class="col-sm-12 services-title wow fadeIn">
          <h2>Задание</h2>
        </div>
      </div>

      <div class="row">
        <div class="col-sm-12">
          <h5 class="task-edit-page"><i class="fa fa-pencil-square-o checkCursor"></i></h5>
          <h5 class="task-ok-edit-page"><i class="fa fa-check checkCursor"></i></h5>
        </div>
        <div id="task"></div>
        <div class="task-home-work-text"></div>
        <div id="task-inspector">
          <div class="row">
            <div class="col-sm-12">
              <div id="task-myTextArea" class="task" style="display: none;">
                <textarea class="form-control" id="task-editor" rows="19"></textarea>
              </div>
            </div>
          </div>
        </div>
      </div>


      <div class="row">
        <div class="col-sm-12 services-title wow fadeIn">
          <h2>Решение</h2>
        </div>
      </div>

      <div class="row">
        <div class="col-sm-12">
          <h5 class="edit-page"><i class="fa fa-pencil-square-o checkCursor"></i></h5>
          <h5 class="ok-edit-page"><i class="fa fa-check checkCursor"></i></h5>
        </div>
        <div id="solution"></div>
        <div class="home-work-text"></div>
        <div id="task-inspector">
          <div class="row">
            <div class="col-sm-12">
              <div id="myTextArea" class="solution" style="display: none;">
                <textarea class="form-control" id="editor" rows="19"></textarea>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Modal chart -->
  <div id="chartModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Инспектор графиков</h4>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-sm-12" id="chart-inputs">
              <textarea class="form-control" id="chart-editor" rows="19"></textarea>
            </div>
          </div>
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-xs btn-default" id="add-chart" data-dismiss="modal">Ok</button>
          <button type="button" class="btn btn-xs btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>

  <!-- Task modal chart -->
  <div id="task-chartModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Инспектор графиков</h4>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-sm-12" id="chart-inputs">
              <textarea class="form-control" id="task-chart-editor" rows="19"></textarea>
            </div>
          </div>
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-xs btn-default" id="task-add-chart" data-dismiss="modal">Ok</button>
          <button type="button" class="btn btn-xs btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>

  <!-- Javascript -->
  <script src="/resources/js/custom_js/util/cursor.js"></script>
  <script src="/resources/js/custom_js/util/chart.js"></script>
  <script src="/resources/js/custom_js/util/bbcode.js"></script>
  <script src="/resources/js/custom_js/active/home_work_active.js"></script>
</t:template>
