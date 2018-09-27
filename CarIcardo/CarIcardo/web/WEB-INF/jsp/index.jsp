<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="resources/css/geral.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/main.css"/>" rel="stylesheet" type="text/css"/>
        <script src='https://www.google.com/recaptcha/api.js?hl=pt-BR'></script>
        <title>Cadastro</title>
    </head>
    <body>
        <section class="bloco1" id="bloco1">
            <div id="logo">
                <img alt="CAR|ICARDO" align="left" src="<c:url value="resources/img/logo.png"/>"/>
            </div>
            <nav>
                <ul>
                    <li><a href="#">Inicio</a></li>
                    <li><a href="#bloco2" class="scroll-to">Consulta</a></li>
                    <li><a href="#bloco3">Serviços</a></li>
                    <li><a href="login">Dashboard</a></li>
                </ul>
            </nav>

            <div id="form">
                <form name="form1" action="cadastro" method="POST">
                    <label for="Nome">Reserva Rápida!!</label>
                    <input type="text" id="nome" name="nome" placeholder="Digite seu nome completo" required="" value="Gustavo">
                    <input type="text" id="cpf" name="cpf" placeholder="Digite seu CPF" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" required="" value="123.456.789-10">
                    <input type="date" id="loc" name="locacao" required="" >
                    <input type="date" id="dev" name="devolucao" required="">
                    <select id="modelo" name="carro">
                        <option value="GOLF 2.6 VII 2018">GOLF 2.6 VII 2018</option>
                        <option value="BMW M240i">BMW M240i 2018</option>
                        <option value="COROLLA 2.0  VII 2018">Corolla 2.0  VII 2018</option>
                        <option value="Jeep Renegade Trailhawk 2018">Jeep Renegade Trailhawk 2018</option>
                    </select>
                    <div class="g-recaptcha" data-sitekey="6LekpHAUAAAAAGaWyDoO0adHahanLj-SEFWXZ7f2"></div>
                    <input type="submit" value="Reservar" name="submit" id="Reservar">
                    <p class="texto">${mensagem}</p>
                </form>
            </div>
            <div class="pmark">
                <p>✓Com a melhor e maior do BRASIL!! <br>✓Seu aluguel de carros em minutos!!<br>✓Segurança facilidade e agilidade<br>✓Conforto e qualidade<br>✓Com Estilo!</p>
            </div>
        </section>

        <section class="bloco2" id="bloco2">
            <div class=container4>
                <p>Consulte sua reserva!</p>
            </div>
            <div id="form2">
                <form name="form2" action="lista" method="post">
                    <input type="text" id="cpf" name="cpf" placeholder="Digite seu CPF" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" required="">        
                    <input type="submit" name="submit" value="Consultar">
                    <p class="texto">${mensagem2}</p>
                </form>
            </div>

            <div class="consulta">
                <div id="form5">
                    <form name="form5" action="editarExcluir" method="post">  
                        <c:forEach items="${lista}" var="cliente">
                            <input type="text" id="Nome" name="nome" value="${cliente.nome}" placeholder="Digite seu nome completo" required="">
                            <input type="text" id="cpf" name="cpf" value="${cliente.cpf}" placeholder="Digite seu CPF" readonly="readonly" required="">
                            <input type="date" id="loc" name="loc" value="${cliente.locacao}"> 
                            <input type="date" id="dev" name="dev" value="${cliente.devolucao}"> 
                            <select <input type="text" id="modelo" name="carro" value="${cliente.carro}" >
                                <option value="GOLF 2.6 VII 2018">GOLF 2.6 VII 2018</option>
                                <option value="BMW M240i">BMW M240i 2018</option>
                                <option value="COROLLA 2.0  VII 2018">Corolla 2.0  VII 2018</option>
                                <option value="Jeep Renegade Trailhawk 2018">Jeep Renegade Trailhawk 2018</option>
                            </select>
                        </c:forEach>
                        <input id="az"  name="submit" type="submit" value="Editar">
                        <input id="az" name="submit" type="submit" value="Excluir">
                    </form>
                </div>

            </div>
        </section>
        <section class="bloco3" id="bloco3">
            <div id="title3">
                <p id="title3">Simulador</p>
            </div>

            <div id="simulador">
                <div id="form3">
                    <form class="bloco24" name="form3" action="" method="post">
                        <input type="date" id="dataEntrada" name="dataEntrada" placeholder="dataEntrada" onchange="chamar()">
                        <input type="date" id="dataSaida" name="dataSaida" placeholder="dataSaida" onchange="chamar()">
                        <input type="hidden" id="ndias" name="ndias" value=""  placeholder="nº dias">
                        <input type="hidden" id="diaria" name="diaria" value="50" required=""  placeholder="Diaria">
                        <input type="hidden" id="valoraluguel" name="valoraluguel"  value="" onclick="calcula_aluguel()"  onkeyup="calcula_aluguel()" placeholder="valor da diaria">
                        <input type="hidden" id="valorKM" name="valorKM" value="2" placeholder="valorKM">
                        <input type="text" id="KM" name="KM" value="" placeholder="digite o KM percorrido">
                        <input type="hidden" id="valortotal" name="valortotal"  value=""  placeholder="valor total do KM percorrido">
                        <input type="hidden" id="valorreal" name="valorreal"  value="" onclick="calculo_total()"  onkeyup="calculo_total()" placeholder="valor total a ser pago">

                        <input type="submit" onclick="return funcao1()" onkeyup="funcao1()" value="Simular" />
                    </form>
                </div>
            </div>
            <div id="textomarq">
                <p>Pague por km rodados<br><br>✩ ✩ ✩ <br>CAR|ICardo!</p>
            </div>
        </section>




        <section class="mapas">
            <div id="map"></div>
            <script>
                function initMap() {
                    var uluru = {lat: -21.3103883, lng: -46.7128693};
                    var map = new google.maps.Map(document.getElementById('map'), {
                        zoom: 4,
                        center: uluru
                    });
                    var marker = new google.maps.Marker({
                        position: uluru,
                        map: map
                    });
                }
            </script>
            <script async defer
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAoG96nKZCdGEJfVgoxwlNeizU7xjBGwOQ&callback=initMap">
            </script>
        </section>

        <section class="rodape">
            <nav id="azddg">
                <ul id="kkkk">
                    <li id="kku"><a href="#bloco1">Home</a></li>
                    <li id="kku"><a href="#bloco2" class="scroll-to">Consulta</a></li>
                    <li id="kku"><a href="#bloco3">Serviços</a></li>
                </ul>
            </nav>
            <div id="texj">
                <p>©2018 CAR|ICARDO, All Rights Reserved @TDamiaoS</p>
            </div>
        </section>

        <script src="<c:url value="/resources/js/aletSimulacao.js"/>"></script>
    </body>
</html>
