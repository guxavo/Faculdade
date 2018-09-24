<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale = 1, shrink-to-fit=no">
        <title>CAR|ICARDO - Login</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/bibliotecas/bootstrap/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/bibliotecas/font-awesome/css/font-awesome.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/Dashboard/css/sb-admin.min.css"/>">
    </head>

    <body class="bg-dark">

        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header"><img src='<c:url value="/resources/Dashboard/img/logob.fw.png"/>' alt=”CAR|ICARDO”/></div>
                <div class="card-body">
                    <form name="form1" action="logar" method="POTS">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" id="email" 
                                   placeholder="Digite seu Email">
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input type="password" class="form-control" name="senha" id="senha" 
                                   placeholder="Digite sua Senha">
                        </div>
                        <div class="form-group">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input">
                                    Lembrar minha senha.
                                </label>
                            </div>
                        </div>
                        <button class="btn btn-primary btn-block"><a href="indexDashboard"></a> Entrar</button>
                        <div class="text-center">
                            <a href="registro" class="d-block small mt-3">Criar uma Conta</a>
                            <a href="recuperar" class="d-block small">Esqueceu a Senha?</a>
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
