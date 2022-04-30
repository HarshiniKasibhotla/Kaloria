function updateDietItems() {
            var contentId = $('#editContentId').val();
            var postDataUrl = '/EditDietItem/' + (contentId == "" ? "0" : contentId) + '/' + $('#nutriType').val() + '/' + $('#itemName').val() + '/' + $('#itemCalorie').val()+ '/' + $('#category').val() + '/'+ $('#health').val()+'/'+ $('#allergy').val()+'/'+ $('#meal').val();
            $.ajax({
                url: postDataUrl,
                method: 'GET',
                success: function (data) {
                    window.location = '/admin';
                }
            });
        }

function navigationClick(navUser) {
  if (navUser === "Chart") {
    $(".diet-chart-form").show();
    $(".dietcian-approval-form").hide();
    $(".diet-chart-nav-item").addClass("active");
    $(".dietician-approval-nav-item").removeClass("active");

    getDietItems();
  } else if (navUser === "Dietician") {
    $(".dietcian-approval-form").show();
    $(".diet-chart-form").hide();
    $(".dietician-approval-nav-item").addClass("active");
    $(".diet-chart-nav-item").removeClass("active");

    getVerifiedContent();

  }
  else if (navUser === "Verified") {
    $(".waiting-container").hide();
    $(".verified-container").show();
    $(".verified-nav-item").addClass("active");
    $(".waiting-nav-item").removeClass("active");

    getVerifiedContent();
  }
  else {
    $(".verified-container").hide();
    $(".waiting-container").show();
    $(".verified-nav-item").removeClass("active");
    $(".waiting-nav-item").addClass("active");

    getWaitingContent();

  }
}

