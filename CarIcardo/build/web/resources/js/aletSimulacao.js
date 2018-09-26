function funcao1() {

    var form3 = document.getElementById('simulador');
    var valorreal = document.getElementById('valorreal');

    form3.addEventListener('submit', function (e) {
        // alerta o valor do campo
        alert("O valor total a ser pago será de: " + "R$" + valorreal.value);

        // impede o envio do form
        e.preventDefault();
    });
}

function calcula_valor() {
    document.form3.valortotal.value = document.form3.KM.value * document.form3.valorKM.value;
    if (document.form3.valortotal.value) {
        calculo_total();
    }

}

function difDias() {
    var dataSaida = new Date(document.getElementById("dataSaida").value);
    var dataEntrada = new Date(document.getElementById("dataEntrada").value);
    return parseInt((dataSaida - dataEntrada) / (24 * 3600 * 1000));
}

function chamar() {
    document.getElementById("ndias").value = isNaN(difDias()) ? "" : difDias();
    if (!isNaN(document.getElementById("ndias").value)) {
        calcula_aluguel();
    }
}

function calcula_aluguel() {
    document.form3.valoraluguel.value = document.form3.ndias.value * document.form3.diaria.value;
}

function calculo_total() {
    document.form3.valorreal.value = (document.form3.valoraluguel.value * 1) + (document.form3.valortotal.value * 1);
}


document.getElementById("KM").oninput = function () {
    var valor = this.value;
    if (isNaN(valor)) {
        this.value = "";
        document.getElementById("valortotal").value = "";
        document.getElementById("valorreal").value = "";
    } else {
        calcula_valor();
    }
};