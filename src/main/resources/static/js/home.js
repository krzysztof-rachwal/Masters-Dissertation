//1. On document Ready
$(document).ready(function () {

    //1.1.  Feedback - Success
    EventProfileShowInterest = localStorage.getItem("EventProfileShowInterest");

    if (EventProfileShowInterest === "true"){
        $('#success_message_text').text(' The Interest in the event was sent!');
        $('#success_message').removeClass('d-none').addClass('show');
        localStorage.clear()
        $("#success_message").fadeTo(1500, 1);
        setTimeout(function(){
            $("#success_message").fadeTo(1500, 0);
        },5000);
    }

});
