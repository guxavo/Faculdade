<%-- 
    Document   : tabelas
    Created on : 17/09/2018, 14:08:25
    Author     : guzno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale = 1, shrink-to-fit=no">
        <title>CAR|ICARDO</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/bibliotecas/bootstrap/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/bibliotecas/font-awesome/css/font-awesome.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/css/sb-admin.min.css"/>">
    </head>
    <body class="bg-dark fixed-nav sticky-footer" id="page-top">
        <!-- Navegação !-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <a class="navbar-brand" href="indexDashboard"><img src='<c:url value="/resources/Dashboard/img/logo.fw.png"/>' alt=”CAR|ICARDO”/></a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                    data-target="#navbarCurso" aria-control="navbarCurso" aria-expanded="false" aria-label="Navegação Toggle">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navbarCurso" class="collapse navbar-collapse">
                <ul class="navbar-nav navbar-sidenav" id="linksaccordion">
                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
                        <a class="nav-link" href="indexDashboard">
                            <i class="fa fa-fw fa-dashboard"></i>
                            <span class="nav-link-text">Dashboard</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right">
                        <a class="nav-link" href="tabelas">
                            <i class="fa fa-fw fa-table"></i>
                            <span class="nav-link-text">Reservas</span>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav sidenav-toggler">
                    <li class="nav-item">
                        <a id="sidenavToggler" class="nav-link text-center">
                            <i class="fa fa-fw fa-angle-left"></i>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <form class="form-inline my-2 my-lg-0 mr-lg-2">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Pesquisar por...">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form name="form1" action="logout" method="post">
                            <a class="nav-link" onclick="this.parentNode.submit();"><i class="fa fa-sign-out">Logout</i></a>
                        </form>
                    </li>
                </ul>

            </div>
        </nav>
        <div class="content-wrapper">
            <div class="container-fluid">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="indexDashboard">Inicio</a>
                    </li>
                    <li class="breadcrumb-item">
                        Reservas
                    </li>
                </ol>
                <div class="row">
                    <div class="col-12">
                        <h1>Reservas</h1>
                    </div>
                </div>
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Agendados
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>CPF</th>
                                    <th>Data da Locação</th>
                                    <th>Data da Devolução</th>
                                    <th>Carro</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Nome</th>
                                    <th>CPF</th>
                                    <th>Data da Locação</th>
                                    <th>Data da Devolução</th>
                                    <th>Carro</th>
                                </tr>
                            </tfoot>
                            <tbody>
                                <c:forEach items="${lista}" var="c">
                                <tr>
                                    <td>${c.nome}</td>
                                    <td>${c.cpf}</td>
                                    <td>${c.locacao}</td>
                                    <td>${c.devolucao}</td>
                                    <td>${c.carro}</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<footer class="sticky-footer">
    <div class="container">
        <div class="text-center">
            <small>Copyright CAR|ICARDO 2018</small>
        </div>
    </div>
</footer>
</div>

<script src="<c:url value="/resources/Dashboard/bibliotecas/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/Dashboard/bibliotecas/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
<script src="<c:url value="/resources/Dashboard/bibliotecas/jquery-easing/jquery.easing.min.js"/>"></script>
</body>
</html>
