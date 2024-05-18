function updateCollectableStatus(id, collected) {
        fetch('/update-collectable/' + id, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': /*[[${_csrf.token}]]*/''
            },
            body: JSON.stringify({ collected: collected })
        }).then(response => {
            if (!response.ok) {
                alert("Failed to update status");
            }
        });
    }