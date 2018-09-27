<%-- 
    Document   : registro
    Created on : 17/09/2018, 13:52:58
    Author     : guzno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale = 1, shrink-to-fit=no">
        <title>CAR|ICARDO - Registrar</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/bibliotecas/bootstrap/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/bibliotecas/font-awesome/css/font-awesome.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/css/sb-admin.min.css" />">
    </head>
    <body class="bg-dark">

        <div class="container">
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">Criar uma Conta</div>
                <div class="card-body">

                    <form name="form1" action="cadastroFuncionario" method="POST">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="primeiroNome">Primeiro Nome</label>
                                    <input type="text" class="form-control" id="primeiroNome" name="nome"
                                           placeholder="Digite seu Primeiro Nome" required="">
                                </div>
                                <div class="col-md-6">
                                    <label for="sobrenome">Sobrenome</label>
                                    <input type="text" class="form-control" id="sobrenome" name="sobrenome"
                                           placeholder="Digite seu Sobrenome" required="">
                                </div>					
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email"
                                   placeholder="Digite seu Email" required="">
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="senha">Senha</label>
                                    <input type="password" class="form-control" id="senha" name="senha"
                                           placeholder="Digite uma Senha" required="">
                                </div>
                                <div class="col-md-6">
                                    <label for="confirmaSenha">Confirmar Senha</label>
                                    <input type="text" class="form-control" id="confirmaSenha" name="confirmaSenha"
                                           placeholder="Confirme sua Senha" required="">
                                </div>					
                            </div>
                        </div>
                        <button class="btn btn-primary btn-block">Registrar-se</button>
                        <div class="text-center">
                            <a href="login" class="d-block small">Página de Login</a>
                        </div>
                        <p class="texto">${mensagem}</p>
                    </form>
                </div>
            </div>
        </div>

        <script src="<c:url value="/resources/Dashboard/bibliotecas/jquery/jquery.min.js"/>"></script>
        <script src="<c:url value="/resources/Dashboard/bibliotecas/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
        <script src="<c:url value="/resources/Dashboard/bibliotecas/jquery-easing/jquery.easing.min.js"/>"></script>
    </body>
</html>
