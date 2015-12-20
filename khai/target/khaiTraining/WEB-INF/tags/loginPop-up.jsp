<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">Авторизация</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="inputEmail">Логин</label>
            <input type="text" class="form-control" id="inputEmail" placeholder="Имя_Фамилия">
          </div>
          <div class="form-group">
            <label for="inputPassword">Пароль</label>
            <input type="password" class="form-control" id="inputPassword" placeholder="Пароль">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" id="loginBtn" class="btn btn-primary">Войти</button>
      </div>
    </div>
  </div>
</div>