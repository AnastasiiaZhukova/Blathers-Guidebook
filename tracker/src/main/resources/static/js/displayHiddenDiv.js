//gets the user roles
//shows the hidden divs
window.onload = function() {
    var isModerator = document.getElementById('isModerator').value === 'true';
    var isAdmin = document.getElementById('isAdmin').value === 'true';

    if (isModerator) {
        document.getElementById('moderatorDiv').style.display = 'block';
    }

    if (isAdmin) {
        document.getElementById('adminDiv').style.display = 'block';
    }
}