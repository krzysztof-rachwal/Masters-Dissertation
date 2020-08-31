//1. On document Ready
$(document).ready(function () {

    //1.1.  Feedback - Success
    eventProfileShowInterest = localStorage.getItem("EventProfileShowInterest");

    if (eventProfileShowInterest === "true"){
        $('#success_message_text').text(' The Interest in the event was sent!');
        $('#success_message').removeClass('d-none').addClass('show');
        localStorage.clear()
        $("#success_message").fadeTo(1500, 1);
        setTimeout(function(){
            $("#success_message").fadeTo(1500, 0);
        },5000);
    }

    requestEmployerEmail = localStorage.getItem("requestEmployerEmail");

    if (requestEmployerEmail === "true"){
        $('#success_message_text').text('You have successfully request an event with this employer.');
        $('#success_message').removeClass('d-none').addClass('show');
        localStorage.clear()
        $("#success_message").fadeTo(1500, 1);
        setTimeout(function(){
            $("#success_message").fadeTo(1500, 0);
        },5000);
    }
});

$("#menuHome").addClass("is-active")