Search();

function Search() {
  GET().then(data => {
    const table = document.querySelector('#tabela tbody');
    while (table.firstChild){
    table.removeChild(table.firstChild);
    }
    data.data.forEach(post => {

      const cbRefunded = document.createElement("input");
      cbRefunded.type = "checkbox";
      cbRefunded.id = `check-box-${post.id}`;
      cbRefunded.name = "refunded";
      cbRefunded.checked = post.reembolsado;

      cbRefunded.addEventListener("click", function () {
        const confirmed = confirm("Deseja alterar o status do reembolso");
        if (confirmed) {
          Change(post.id, cbRefunded.checked);
        } else {
          cbRefunded.checked = !cbRefunded.checked;
        }
      });

      const line = table.insertRow();
      const column1 = line.insertCell(0);
      const column2 = line.insertCell(1);
      const column3 = line.insertCell(2);
      const column4 = line.insertCell(3);
      const column5 = line.insertCell(4);
      const column6 = line.insertCell(5);
      const column7 = line.insertCell(6);
      const column8 = line.insertCell(7);
      const column9 = line.insertCell(8);
      const column10 = line.insertCell(9);
      const column11 = line.insertCell(10);

      column1.innerHTML = post.idPedido;
      column2.innerHTML = post.nomeCliente;
      column3.innerHTML = post.telefoneCliente;
      column4.innerHTML = post.cpfCliente;
      column5.innerHTML = post.tipoPagamento;
      column6.innerHTML = post.banco;
      column7.innerHTML = post.bancoAgencia;
      column8.innerHTML = post.bancoConta;
      column9.innerHTML = post.tipoChavePIX;
      column10.innerHTML = post.chavePIX;
      column11.appendChild(cbRefunded);
    });
  })
    .catch(error => console.log(error));
}
function Save() {

  if (ValidateSave()) {


  var telefone = document.getElementById("telephone").value.replace(/[^\d]+/g, '');
  var cpf = document.getElementById("cpf").value.replace(/[^\d]+/g, '');

  var chave = "";

  if(document.getElementById("keyType").value == "CELULAR") {
    chave = document.getElementById("pixKey").value.replace(/[^\d]+/g, '');
  }
  else if(document.getElementById("keyType").value == "CPF"){
    chave = document.getElementById("pixKey").value.replace(/[^\d]+/g, '');
  }
  else{
    chave = document.getElementById("pixKey").value;
  }

    const data = {
      idPedido: document.getElementById("orderId").value,
      nomeCliente: document.getElementById("name").value,
      telefoneCliente: telefone,
      cpfCliente: cpf,
      tipoPagamento: document.getElementById("paymentType").value,
      banco: document.getElementById("bank").value,
      bancoAgencia: document.getElementById("agency").value,
      bancoConta: document.getElementById("account").value,
      reembolsado: false
    };

    if(document.getElementById("paymentType").value === "PIX") {
    data.chavePIX = chave;
    data.tipoChavePIX = document.getElementById("keyType").value;
    }


    POST(data).then(data => {

      console.log(data);
      Search();
    })
      .catch(error => console.error(error));
  }
}
function Change(id, status) {

const data = {
    reembolsado: status
}

  PATCH(data, id).then(data => {
    console.log(data);
  })
    .catch(error => console.error(error));
}
