async function submitForm() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    // Send data to the backend
    await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept-Language': 'fr'
        },
        body: JSON.stringify({username: username, password: password})
    }).then(response => response.json()).then(data => {
        console.log('Success',data);
    }).catch(error => {
        console.log('Error:', error);
    });
}