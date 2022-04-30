function navigationClick(userTask) {
    if(userTask === "ShowAppointmentHistory"){
        $(".appointment-history").show();
        $(".verified-dietician").hide();
        getAppointmentsHistory();
    } else if(userTask === "BookAppointment"){
            $(".appointment-history").hide();
            $(".verified-dietician").show();
        getApprovedDieticians();
    } else{
        getDietSuggestions();
    }

 }

  function getApprovedDieticians(){
     $.ajax({
            url: '/bookAppointment',
            datatype: 'html',
            success: function(data)
            {
                console.log(data);
                $('#verified-dietician-id').html(data);
            }
        });
    }

  function getAppointmentsHistory(){
   $.ajax({
          url: '/appointmentHistory',
          datatype: 'html',
          success: function(data)
          {
              $('#appointment-history-id').html(data);
          }
      });
  }

  function getDietSuggestions(){

  }

  $(document).ready(function(){
      getApprovedDieticians();
  });

  function showAppointments(type){
      if(type === "upcoming"){
        $(".past-appointments").hide();
        $(".upcoming-appointments").show();
        $(".li-past-appointment").removeClass("active");
        $(".li-upcoming-appointment").addClass("active");
      } else{
         $(".past-appointments").removeClass("hide");
         $(".past-appointments").show();
         $(".upcoming-appointments").hide();
         $(".li-upcoming-appointment").removeClass("active");
         $(".li-past-appointment").addClass("active");
      }
  }