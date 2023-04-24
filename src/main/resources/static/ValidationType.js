
const pixkeyInput = document.getElementById("pixKey");

pixkeyInput.addEventListener("input", function () {
    validateTypePix();
});

function validateTypePix() {
    let isValid = true;
    const pixKey = pixkeyInput.value;

    const keyType = document.getElementById("keyType").value;
    if (keyType === 'EMAIL') {
        if (!ValidateEmail(pixKey)) {
            pixkeyInput.classList.add('invalid');
            isValid = false;
        }
        else {
            pixkeyInput.classList.remove('invalid');
        }
    } else if (keyType === 'CELULAR') {
        if (!PhoneValidation(pixKey)) {
            pixkeyInput.classList.add('invalid');
            isValid = false;
        } else {
            pixkeyInput.classList.remove('invalid');
        }
    } else if (keyType === 'CPF') {
        if (!validateCPF(pixKey)) {
            pixkeyInput.classList.add('invalid');
            isValid = false;
        } else {
            pixkeyInput.classList.remove('invalid');
        }
    } else if (keyType === 'ALEATORIO') {
        if (pixKey.length != 32) {
            pixkeyInput.classList.add('invalid');
            isValid = false;
        } else {
            pixkeyInput.classList.remove('invalid');
        }
    } else {
        pixkeyInput.classList.add('invalid');
        isValid = false;
    }

     return isValid;
}
