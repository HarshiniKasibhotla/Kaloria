function navigationClick(navAction) {
    if (navAction === "Dietitian")
     {
        $(".dietitians-list-form").show();
        $(".diet-chart-form").hide();
        $(".dietitians-list-nav-item").addClass("active");
        $(".diet-chart-nav-item").removeClass("active");
        $(".verified-dietitians-nav-item").addClass("active");
     } 
    else if(navAction === "DietChart") 
    {
        $(".diet-chart-form").show();
        $(".dietitians-list-form").hide();
        $(".waiting-approval-form").hide();
		$(".verified-dietitians-form").hide();
        $(".diet-chart-nav-item").addClass("active");
        $(".dietitians-list-nav-item").removeClass("active");
        $(".verified-dietitians-nav-item").removeClass("active");
        $(".waiting-approval-nav-item").removeClass("active");
    }
    else if(navAction === "Verified")
    {
		$(".verified-dietitians-form").show();
		$(".waiting-approval-form").hide();
		$(".diet-chart-form").hide();
		$(".verified-dietitians-container").show();
		$(".verified-dietitians-nav-item").addClass("active");
        $(".waiting-approval-nav-item").removeClass("active");
        $(".diet-chart-nav-item").removeClass("active");
        $(".dietitians-list-nav-item").addClass("active");
	
	}
	else
	{
		$(".waiting-approval-form").show();
		$(".verified-dietitians-form").hide();
		$(".diet-chart-form").hide();
		$(".verified-dietitians-container").hide();
		$(".waiting-approval-nav-item").addClass("active");
		$(".verified-dietitians-nav-item").removeClass("active");
		$(".diet-chart-nav-item").removeClass("active");
		$(".dietitians-list-nav-item").addClass("active");
    }
}