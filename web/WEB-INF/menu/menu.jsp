<%-- 
    Document   : menu
    Created on : 02.02.2021, 10:34:42
    Author     : Comp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">Arlamov Product Shop</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
            <c:if test="${role eq 'ADMIN'}">
                <li class="nav-item">
                    <a class="nav-link <c:if test="${activeListFurnitures eq true}">active</c:if>" aria-current="page" href="listFurnitures">Список товаров</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link <c:if test="${activePurchaseFurnitureForm eq true}">active</c:if>" href="purchaseFurnitureForm">Список купленных товаров</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link <c:if test="${activeAddFurniture eq true}">active</c:if>" href="addFurniture">Добавить товар</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link <c:if test="${activeListBuyers eq true}">active</c:if>" href="listBuyers">Список покупателей</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link <c:if test="${activeAdminPanel eq true}">active</c:if>" href="adminPanel">Панель администратора</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link <c:if test="${activeLogout eq true}">active</c:if>" href="logout">Выйти</a>
                </li>
            </c:if>
            <c:if test="${role eq 'MANAGER'}">
                <li class="nav-item">
                    <a class="nav-link <c:if test="${activelistFurnitures eq true}">active</c:if>" aria-current="page" href="listFurnitures">Список товаров</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link <c:if test="${activeAddFurniture eq true}">active</c:if>" href="addFurniture">Добавить товар</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link <c:if test="${activeLogout eq true}">active</c:if>" href="logout">Выйти</a>
                </li>
           </c:if>
           <c:if test="${role eq 'BUYER'}">
                <li class="nav-item">
                    <a class="nav-link <c:if test="${activelistFurnitures eq true}">active</c:if>" aria-current="page" href="listFurnitures">Список товаров</a>
                </li>                
                <li class="nav-item">
                    <a class="nav-link <c:if test="${activePurchaseFurnitureForm eq true}">active</c:if>" href="purchaseFurnitureForm">Список купленных товаров</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link <c:if test="${activeLogout eq true}">active</c:if>" href="logout">Выйти</a>
                </li>
            </c:if>
            <c:if test="${role eq null}">
                <li class="nav-item">
                    <a class="nav-link <c:if test="${activeListFurnitures eq true}">active</c:if>" aria-current="page" href="listFurnitures">Список товаров</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link <c:if test="${activeShowLoginForm eq true}">active</c:if>" href="showLoginForm">Войти</a>
                </li>
            </c:if>   
      </ul>
    </div>
  </div>
</nav> 