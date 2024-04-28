document.addEventListener("DOMContentLoaded", function() {
            document.getElementById("submitBtn").addEventListener("click", function() {
                var form = document.getElementById("signupForm");
                if (form.checkValidity()) {
                    fetchCsrfTokenAndSubmitForm();
                } else {
                    // If the form is invalid, display an error message
                    document.getElementById("errorMessage").style.display = "block";
                }
            });
        });

        function fetchCsrfTokenAndSubmitForm() {
            fetch('/csrf-token')
                .then(response => response.json())
                .then(data => {
                    submitFormWithCsrfToken(data.token);
                })
                .catch(error => {
                    console.error('Error fetching CSRF token:', error);
                });
        }

        function submitFormWithCsrfToken(csrfToken) {
            var form = document.getElementById("signupForm");
            var formData = new FormData(form);

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/api/v1/doctor");

            // Include CSRF token in request headers
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.setRequestHeader("X-CSRF-TOKEN", csrfToken);

            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 201) {
                        console.log("Form submitted successfully.");
                        document.getElementById("errorMessage").style.display = "none";
                    } else {
                        console.error("Form submission failed. Status: " + xhr.status);
                    }
                }
            };

            xhr.send(JSON.stringify(Object.fromEntries(formData.entries())));
        }