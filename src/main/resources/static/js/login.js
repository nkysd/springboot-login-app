// get form elements
const form = document.getElementById("loginForm");
const message = document.getElementById("message");
const submitBtn = document.getElementById("submitBtn");

// handle submit event
form.addEventListener("submit", async (e) => {
  // stop normal form submit
  e.preventDefault();

  // clear message
  message.textContent = "";

  // disable button
  submitBtn.disabled = true;

  // get input values
  const email = document.getElementById("email").value.trim();
  const password = document.getElementById("password").value;

  // create request body
  const data = {
    email: email,
    password: password
  };

  try {
    // call login API
    const response = await fetch("/api/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(data)
    });

    // parse JSON
    const result = await response.json().catch(() => ({}));

    // if success
    if (response.ok) {
      message.textContent = "Login success";

      // move to home page (you can change this)
      window.location.href = "/home.html";
      return;
    }

    // if failed
    message.textContent = result.message || "Login failed";
  } catch (error) {
    message.textContent = "Server error";
  } finally {
    // enable button
    submitBtn.disabled = false;
  }
});
