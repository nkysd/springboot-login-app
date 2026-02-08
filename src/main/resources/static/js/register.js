// ===== Get HTML elements =====
const form = document.getElementById("registerForm");
const messageEl = document.getElementById("message");
const submitBtn = document.getElementById("submitBtn");

// ===== Show message to the user =====
function setMessage(text, type) {
  // Set text message
  messageEl.textContent = text;

  // Remove old styles
  messageEl.classList.remove("ok", "ng");

  // Add style if type exists (ok or ng)
  if (type) {
    messageEl.classList.add(type);
  }
}

// ===== Enable / Disable button while loading =====
function setLoading(isLoading) {
  submitBtn.disabled = isLoading;

  // Change button text
  submitBtn.textContent = isLoading
    ? "Registering..."
    : "Register";
}

// ===== Handle form submit =====
form.addEventListener("submit", async (e) => {
  // Stop default form submit (page reload)
  e.preventDefault();

  // Clear old message
  setMessage("");

  // ===== Get input values =====
  const username = document.getElementById("username").value.trim();
  const email = document.getElementById("email").value.trim();
  const password = document.getElementById("password").value;
  const confirmPassword = document.getElementById("confirmPassword").value;

  // ===== Simple validation =====
  if (password !== confirmPassword) {
    setMessage("Passwords do not match.", "ng");
    return;
  }

  // ===== Data to send to Spring Boot =====
  const payload = {
    username: username,
    email: email,
    password: password
  };

  // Disable button during request
  setLoading(true);

  try {
    // ===== Send POST request =====
    const response = await fetch("/api/users", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(payload)
    });

    // ===== Read response =====
    const contentType = response.headers.get("content-type");
    const data = contentType && contentType.includes("application/json")
      ? await response.json()
      : await response.text();

    // ===== Handle error response =====
    if (!response.ok) {
      const errorMessage =
        typeof data === "string"
          ? data
          : (data.message || "Registration failed.");

      setMessage(errorMessage, "ng");
      return;
    }

    // ===== Success =====
    setMessage("Registration successful! Please log in.", "ok");
    form.reset();

    // Optional: redirect to login page
    // window.location.href = "/login.html";

  } catch (error) {
    // Network or server error
    setMessage("Network error. Please try again later.", "ng");
  } finally {
    // Enable button again
    setLoading(false);
  }
});
