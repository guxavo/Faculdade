<%-- 
    Document   : recuperar
    Created on : 17/09/2018, 14:02:36
    Author     : guzno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale = 1, shrink-to-fit=no">
        <title>CAR|ICARDO - Recuperar Senha</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/bibliotecas/bootstrap/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/bibliotecas/font-awesome/css/font-awesome.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/css/sb-admin.min.css"/>">
    </head>
    <body class="bg-dark">

        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Recuperar Senha</div>
                <div class="card-body">
                    <div class="text-center mt-4 mb-5">
                        <h4>Esqueceu sua senha?</h4>
                        <p>Digite seu email e nós lhe enviaremos intruções
                            sobre como redefinir sua senha.</p>
                    </div>
                    <form>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" id="email" 
                                   placeholder="Digite seu Email">
                        </div>
                        <button class="btn btn-primary btn-block">Recuperar Senha</button>
                        <div class="text-center">
                            <a href="registro" class="d-block small mt-3">Criar uma Conta</a>
                            <a href="login" class="d-block small">Página de Login</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="<c:url value="/resources/Dashboard/bibliotecas/jquery/jquery.min.js"/>"></script>
        <script src="<c:url value="/resources/Dashboard/bibliotecas/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
        <script src="<c:url value="/resources/Dashboard/bibliotecas/jquery-easing/jquery.easing.min.js"/>"></script>
    </body>
</html>
