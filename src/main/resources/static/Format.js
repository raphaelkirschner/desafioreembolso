//Formato Telefone
function FormatTelephone(IdInput) {
    var telephone = document.getElementById(IdInput).value;
    telephone = telephone.replace(/\D/g, "");
    telephone = telephone.replace(/(\d{2})(\d)/, "($1) $2");
    telephone = telephone.replace(/(\d{4})(\d)/, "$1-$2");
    document.getElementById(IdInput).value = telephone;
}

//Formato CPF

function FormatCPF(IdInput) {
    var cpf = document.getElementById(IdInput).value;
    cpf = cpf.replace(/\D/g, "");
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
    cpf = cpf.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
    document.getElementById(IdInput).value = cpf;
}

//Formato campo numerico

function NumericalValidation(event) {
    var key = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

    if (key >= 48 && key <= 57 || key === 8 || key === 9 || key === 13) {
        return true;
    } else {
        return false;
    }
}
//Formato Só letras

function FormatString(IdInput) {

    const field = document.getElementById(IdInput);
    const regex = /[^a-z\s]/gi;
    field.value = field.value.replace(regex, '');
}
function FormatNoSpace(IdInput){
    const field = document.getElementById(IdInput);
    field.value = field.value.replace(/\s/g, "");   
}


//Formato chave Pix

function FormatPixKey() {

    const keyType = document.getElementById("keyType").value;

    if (keyType === "EMAIL") {
        FormatNoSpace("pixKey")
        const field = document.getElementById("pixKey");
        //field.value = field.value.slice(0, 5);
    } else if (keyType === "CELULAR") {
        FormatTelephone("pixKey");
    } else if (keyType === "CPF") {
        FormatCPF("pixKey")
    } else if (keyType === "ALEATORIO") {
        FormatNoSpace("pixKey")
    }
    else {

    }
}

