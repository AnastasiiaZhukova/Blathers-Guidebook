function checkIfPasswordsMatch() {
    var password = document.getElementById('InputPassword').value;
    var confirmPassword = document.getElementById('InputConfirmPassword').value;
    if (password !== confirmPassword) {
        alert('Passwords do not match!');
        return false;
    }
    return true;
}