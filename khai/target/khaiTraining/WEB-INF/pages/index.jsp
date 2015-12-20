<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
  <div class="services-container">
    <div class="container">
      <div class="row">
        <div class="col-sm-12 services-title wow fadeIn">
          <h2>Сервисы</h2>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-3">
          <div class="service wow fadeInUp">
            <div class="service-icon"><i class="fa fa-magic"></i></div>
            <h3>Домашняя работа</h3>
            <p>Выполнение и проверка дмашних заданий</p>
            <a class="big-link-1" href="home_work_list">Воспользоваться</a>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="service wow fadeInDown">
            <div class="service-icon"><i class="fa fa-university"></i></div>
            <h3>База знаний</h3>
            <p>Открытая база знаний. Тут ты можешь найти все,что нужно.</p>
            <a class="big-link-1" href="services.html">Воспользоваться</a>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="service wow fadeInUp">
            <div class="service-icon"><i class="fa fa-eye"></i></div>
            <h3>Проверка уникальности</h3>
            <p>Проверка уникальности работ студентов между собой.</p>
            <a class="big-link-1" href="services.html">Воспользоваться</a>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="service wow fadeInDown">
            <div class="service-icon"><i class="fa fa-globe"></i></div>
            <h3>Копирайт</h3>
            <p>Проверка текста на уникальность с интернет ресурсами</p>
            <a class="big-link-1" href="services.html">Воспользоваться</a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Latest work -->
  <div class="work-container">
    <div class="container">
      <div class="row">
        <div class="col-sm-12 work-title wow fadeIn">
          <h2>Our Latest Work</h2>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-3">
          <div class="work wow fadeInUp">
            <img src="/resources/img/portfolio/work1.jpg" alt="Lorem Website" data-at2x="assets/img/portfolio/work1.jpg">
            <h3>Lorem Website</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</p>
            <div class="work-bottom">
              <a class="big-link-2 view-work" href="assets/img/portfolio/work1.jpg"><i class="fa fa-search"></i></a>
              <a class="big-link-2" href="portfolio.html"><i class="fa fa-link"></i></a>
            </div>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="work wow fadeInDown">
            <img src="/resources/img/portfolio/work2.jpg" alt="Ipsum Logo" data-at2x="assets/img/portfolio/work2.jpg">
            <h3>Ipsum Logo</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</p>
            <div class="work-bottom">
              <a class="big-link-2 view-work" href="/resources/img/portfolio/work2.jpg"><i class="fa fa-search"></i></a>
              <a class="big-link-2" href="portfolio.html"><i class="fa fa-link"></i></a>
            </div>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="work wow fadeInUp">
            <img src="/resources/img/portfolio/work3.jpg" alt="Dolor Prints" data-at2x="assets/img/portfolio/work3.jpg">
            <h3>Dolor Prints</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</p>
            <div class="work-bottom">
              <a class="big-link-2 view-work" href="/resources/img/portfolio/work3.jpg"><i class="fa fa-search"></i></a>
              <a class="big-link-2" href="portfolio.html"><i class="fa fa-link"></i></a>
            </div>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="work wow fadeInDown">
            <img src="/resources/img/portfolio/work4.jpg" alt="Sit Amet Website" data-at2x="assets/img/portfolio/work4.jpg">
            <h3>Sit Amet Website</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</p>
            <div class="work-bottom">
              <a class="big-link-2 view-work" href="/resources/img/portfolio/work4.jpg"><i class="fa fa-search"></i></a>
              <a class="big-link-2" href="portfolio.html"><i class="fa fa-link"></i></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="/resources/js/jquery-1.11.1.min.js"></script>
</t:template>
