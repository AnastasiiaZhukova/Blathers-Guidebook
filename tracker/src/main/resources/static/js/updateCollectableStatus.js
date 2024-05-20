//using csrf token (checkbox) updates isCollected
function updateCollectableStatus(checkbox, collectableId, collectableType) {

    var isCollected = checkbox.checked;
    var csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');

    fetch('/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        //object to json str
        body: JSON.stringify({ collectableId: collectableId, isCollected: isCollected, collectableType: collectableType })
    });
}
