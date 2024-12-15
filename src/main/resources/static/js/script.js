// Kullanıcının giriş yapıp yapmadığını kontrol et
function checkLogin() {
    const isLoggedIn = localStorage.getItem("isLoggedIn");

    if (!isLoggedIn) {
        alert("You need to log in to access this page.");
        window.location.href = "login.html"; // Log In sayfasına yönlendir
    }
}

// Navbar'daki butonların görünürlüğünü ayarla
function toggleNavbarButtons() {
    const isLoggedIn = localStorage.getItem("isLoggedIn");
    const logOutBtn = document.getElementById("logout-btn");
    const reservationsLink = document.getElementById("reservations-link");
    const logInLink = document.getElementById("login-link");

    if (isLoggedIn) {
        // Giriş yapılmışsa Log Out ve Reservations görünür, Log In gizlenir
        logOutBtn.style.display = "inline";
        reservationsLink.style.display = "inline";
        logInLink.style.display = "none";
    } else {
        // Giriş yapılmamışsa Log Out ve Reservations gizlenir, Log In görünür
        logOutBtn.style.display = "none";
        reservationsLink.style.display = "none";
        logInLink.style.display = "inline";
    }
}

// Çıkış işlemi
function logout() {
    localStorage.removeItem("isLoggedIn");
    localStorage.removeItem("role"); // Rol bilgisini de temizle
    alert("You have been logged out.");
    window.location.href = "index.html"; // Ana sayfaya yönlendir
}

// Kullanıcı rolüne göre yönlendirme
function handleLogin(role) {
    if (role === 'user') {
        localStorage.setItem("isLoggedIn", true);
        localStorage.setItem("role", "user");
        alert("Welcome, User!");
        window.location.href = "user-dashboard.html"; // Kullanıcı Dashboard
    } else if (role === 'admin') {
        localStorage.setItem("isLoggedIn", true);
        localStorage.setItem("role", "admin");
        alert("Welcome, Admin!");
        window.location.href = "admin-dashboard.html"; // Admin Dashboard
    }
}

// Rol kontrolü ve sayfa yönlendirmesi
function checkRoleAndRedirect(expectedRole) {
    const role = localStorage.getItem("role");

    if (role !== expectedRole) {
        alert("Unauthorized access! Redirecting to login page.");
        window.location.href = "login.html"; // Giriş sayfasına yönlendir
    }
}

// Sayfa yüklendiğinde navbar kontrolü
window.onload = toggleNavbarButtons;
