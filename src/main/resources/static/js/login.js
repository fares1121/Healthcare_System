// login.js

document.addEventListener("DOMContentLoaded", function() {
    // Add event listener to login button
    document.getElementById("loginButton").addEventListener("click", function() {
        var form = document.getElementById("loginForm");
        if (form.checkValidity()) {
            fetchCsrfTokenAndAuthenticateUser();
        } else {
            // If the form is invalid, display an error message
            alert("Please fill in all required fields.");
        }
    });
});

function fetchCsrfTokenAndAuthenticateUser() {
    fetch('/csrf-token')
        .then(response => response.json())
        .then(data => {
            authenticateUser(data.token);
        })
        .catch(error => {
            console.error('Error fetching CSRF token:', error);
            alert("An error occurred while logging in. Please try again later.");
        });
}

function authenticateUser(csrfToken) {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var credentials = {
        login: username,
        password: password
    };

    // Send AJAX request to login endpoint with CSRF token
    fetch("/api/v1/user/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "X-CSRF-Token": csrfToken
        },
        body: JSON.stringify(credentials)
    })
    .then(response => {
        if (response.ok) {
            alert("Login successful!");
            // Optionally, redirect the user to another page
            // window.location.href = "/dashboard";
        } else {
            // Display error message if login fails
            document.getElementById("errorMessage").style.display = "block";
        }
    })
    .catch(error => {
        console.error("Error logging in:", error);
        alert("An error occurred while logging in. Please try again later.");
    });
}
