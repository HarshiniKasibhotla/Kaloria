function navigationClick(navUser) {
if (navUser === "Verified") {
    $(".waiting-appointments-container").hide();
    $(".verified-appointments-container").show();
    $(".verified-nav-item").addClass("active");
    $(".waiting-nav-item").removeClass("active");

    getVerifiedAppointmentContent();
  }
  else {
    $(".verified-appointments-container").hide();
    $(".waiting-appointments-container").show();
    $(".verified-nav-item").removeClass("active");
    $(".waiting-nav-item").addClass("active");

    getWaitingAppointmentContent();

  }
  }

function getVerifiedAppointmentContent(){
    $.ajax({
        url: '/verifiedAppointment',
        datatype: 'html',
        success: function(data)
        {
            $('#verifiedContent').html(data);
        }
    });
}

function getWaitingAppointmentContent(){
    $.ajax({
        url: '/waitingAppointment',
        datatype: 'html',
        success: function(data)
        {
            $('#waitingContent').html(data);
        }
    });
}

$(document).ready(function(){
   getVerifiedAppointmentContent();
});

