//Validação Email
function ValidateEmail(email) {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) {
      return false;
  } else {
      return true;
  }
}
//Validação CPF

function validateCPF(cpf) {
  cpf = cpf.replace(/[^\d]+/g, '');
  if (cpf === '') return false;

  if (cpf.length !== 11 ||
    cpf === "00000000000" ||
    cpf === "11111111111" ||
    cpf === "22222222222" ||
    cpf === "33333333333" ||
    cpf === "44444444444" ||
    cpf === "55555555555" ||
    cpf === "66666666666" ||
    cpf === "77777777777" ||
    cpf === "88888888888" ||
    cpf === "99999999999")
    return false;

  let add = 0;
  for (let i = 0; i < 9; i++)
    add += parseInt(cpf.charAt(i)) * (10 - i);
  let rev = 11 - (add % 11);
  if (rev === 10 || rev === 11)
    rev = 0;
  if (rev !== parseInt(cpf.charAt(9)))
    return false;

  add = 0;
  for (let i = 0; i < 10; i++)
    add += parseInt(cpf.charAt(i)) * (11 - i);
  rev = 11 - (add % 11);
  if (rev === 10 || rev === 11)
    rev = 0;
  if (rev !== parseInt(cpf.charAt(10)))
    return false;

  return true;
}

const cpfInput = document.getElementById("cpf");

cpfInput.addEventListener("input", function () {
  const cpf = cpfInput.value;
  if (!validateCPF(cpf)) {
    cpfInput.classList.add('invalid');
  } else {
    cpfInput.classList.remove('invalid');
  }
});


//Exibição Campos tipos de pagamentos

function ShowPaymentMethods(option) {
  var divCurrentAccount = document.getElementById("divCurrentAccount");
  var divPix = document.getElementById("divPix");
  var bankInput = document.getElementById("bank");
  var agencyInput = document.getElementById("agency");
  var accountInput = document.getElementById("account");
  var pixKeyInput = document.getElementById("pixKey");
  if (option == "CONTA_CORRENTE") {

    divCurrentAccount.style.display = "contents";
    divPix.style.display = "none";
    bankInput.required = true;
    agencyInput.required = true;
    accountInput.required = true;
    pixKeyInput.required = false;
    pixKeyInput.value = "";

  } else if (option == "PIX") {
    divPix.style.display = "contents";
    divCurrentAccount.style.display = "none";

    pixKeyInput.required = true;
    bankInput.required = false;
    agencyInput.required = false;
    accountInput.required = false;
    bankInput.value = "";
    agencyInput.value = "";
    accountInput.value = "";

  } else {
    divCurrentAccount.style.display = "none";
    divPix.style.display = "none";
  }
}
//Exibição Campos tipos de chave pix
function ShowPixTypeMethods(option){
  const pixkeyInput = document.getElementById("pixKey"); 
  if (option == "EMAIL") {
    pixkeyInput.maxLength = 150;
    pixkeyInput.value="";
  }else if(option == "CELULAR"){
    pixkeyInput.maxLength = 15;
    pixkeyInput.value="";
  }else if(option == "CPF"){
    pixkeyInput.maxLength = 14;
    pixkeyInput.value="";
  }else if(option == "ALEATORIO"){
    pixkeyInput.maxLength = 32;
    pixkeyInput.value="";
  }else{
    pixkeyInput.maxLength = 0;
    pixkeyInput.value="";
  }
}
//validação Telefone

const telephoneInput = document.getElementById("telephone");

telephoneInput.addEventListener("input", function () {
  const telephone = telephoneInput.value;
  if (!PhoneValidation(telephone)) {
    telephoneInput.classList.add('invalid');
  } else {
    telephoneInput.classList.remove('invalid');
  }
});

function PhoneValidation(inputTelephone) {
  const telephoneRegex = /^\d{2}\s?\d{4,5}-?\d{4}$/;

  inputTelephone = inputTelephone.replace(/[^\d]+/g, '');
  if (!telephoneRegex.test(inputTelephone)) {
    return false;
  } else {
    return true;
  }
}


function ValidateSave() {
    const requiredFields = ['orderId', 'name', 'telephone', 'cpf', 'paymentType'];
  
    let isValid = true;
  
    requiredFields.forEach(field => {
      const input = document.getElementById(field);
      if (input.value === '') {
        input.classList.add('invalid');
        isValid = false;
      } else {
        input.classList.remove('invalid');
      }
    });
  
    const paymentType = document.getElementById('paymentType');
    
    if (paymentType.value === 'CONTA_CORRENTE') {
      const requiredFieldsCC = ['bank', 'agency', 'account'];
  
      requiredFieldsCC.forEach(field => {
        const input = document.getElementById(field);
        if (input.value === '') {       
          input.classList.add('invalid');

          isValid = false;
        } else {
          input.classList.remove('invalid');
        }
      });
    } else if(paymentType.value === 'PIX') {
      const pixKeyInput = document.getElementById('pixKey');
      if (pixKeyInput.value === '') {
        pixKeyInput.classList.add('invalid');
        isValid = false;
      } else if (!validateTypePix()){
       isValid = false;
      }
      else {
       pixKeyInput.classList.remove('invalid');
      }
    }
    else {
      isValid = false;
      paymentType.classList.add('invalid');
    }
    if (!validateCPF(cpfInput.value) || !PhoneValidation(telephoneInput.value)) {
      isValid = false;
    }

    return isValid;
}
