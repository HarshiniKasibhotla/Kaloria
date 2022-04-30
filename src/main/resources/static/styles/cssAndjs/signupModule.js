function goTo_loginPage() {
    location.href = "Signup.html";
}

function navigationClick(navUser) {
    if (navUser === "User") {
        $(".user-signup-form").show();
        $(".doctor-signup-form").hide();
        $(".user-signup-nav-item").addClass("active");
        $(".doctor-signup-nav-item").removeClass("active");
    } else {
        $(".doctor-signup-form").show();
        $(".user-signup-form").hide();
        $(".doctor-signup-nav-item").addClass("active");
        $(".user-signup-nav-item").removeClass("active");
    }
}