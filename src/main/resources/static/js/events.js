
//1. Create Event
function createNewEvent() {
    var baseUri = "/api/create/event";
    var eventName_url = "eventName=" + $('input[id=event-name]').val();
    var typeOfEventID_url = "typeOfEventID=" + $('select[id=event-type]').val();
    var eventDate_url = "eventDate=" + $('input[id=event-date]').val();
    var eventTime_url = "eventTime=" + $('input[id=event-time]').val();
    var eventVenueName_url = "eventVenueName=" + $('input[id=event-venue]').val();
    var eventAddressCity_url = "eventAddressCity=" + $('input[id=event-city]').val();
    var eventAddressStreet_url = "eventAddressStreet=" + $('input[id=event-street]').val();
    var eventAddressNumber_url = "eventAddressNumber=" + $('input[id=event-number]').val();
    var eventPostcode_url = "eventPostcode=" + $('input[id=event-postcode]').val();
    var eventSummary_url = "eventSummary=" + $('textarea[id=event-summary]').val();
    var isPublic_url = "isPublic=" + $('select[id=event-public]').val();
    var isCancelled_url = "isCancelled=" + $('select[id=event-cancelled]').val();
    var nameOfAdviser_url = "nameOfAdviser=" + $('input[id=adviser-name]').val();
    var numberOfAttendees_url = "numberOfAttendees=" + $('input[id=no-attendees]').val();
    var promotesApprenticeships_url="promotesApprenticeships=" + $('select[id=promote-apprenticheship]').val();
    var promotesWelshLanguage_url = "promotesWelshLanguage=" + $('select[id=conducted-welsh]').val();
    var challengesGenderStereotypes_url = "challengesGenderStereotypes=" + $('select[id=challenger-gender]').val();
    var employerAttending_url = "employerAttending=" + $('select[id=employers-attending]').val();
    var schoolAttending_url = "schoolAttending=" + $('select[id=schools-attending]').val();


    var fullUri = baseUri + "?" + "&" + eventName_url+ "&" + typeOfEventID_url + "&" + eventDate_url + "&" + eventTime_url + "&"
        + eventVenueName_url + "&" + eventAddressCity_url  + "&" + eventAddressStreet_url  + "&" + eventAddressNumber_url + "&"
        + eventPostcode_url + "&" + eventSummary_url+ "&" + isPublic_url + "&" + isCancelled_url + "&" +nameOfAdviser_url +"&"
        + numberOfAttendees_url + "&" + promotesApprenticeships_url  + "&" + promotesWelshLanguage_url + "&" + challengesGenderStereotypes_url  + "&"
        + employerAttending_url + "&" + schoolAttending_url ;

    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol
    console.log(fullUri)

    // 1.1. validation
    let verifier
    verifier = validateForm($('input[id=vacancy-name]'),$('textarea[id=vacancy-summary]'),$('input[id=start-date]'),$('input[id=closing-date]'),$('input[id=post-code]'));
    // 1.2. Error Message
    if(!verifier){
        $('#failed_message_text').text("The Form was not filled properly.");
        $('#failed_message').removeClass('d-none').addClass('show');
        $("#failed_message").fadeTo(1500, 1);
        setTimeout(function(){
            $("#failed_message").fadeTo(1500, 0);
        },5000);
        return
    }



    $.ajax({
        type: "GET", url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data === true) {
                localStorage.setItem("eventAdded","true");
                location.assign("/events")
            } else {
                alert("There was an error, please try again.")
                alert(data.responseText)
                alert(data)
            }
        },
        error: function (data) {
            $('#failed_message_text').text("Something went wrong with the submission.");
            $('#failed_message').removeClass('d-none').addClass('show');
            $("#failed_message").fadeTo(1500, 1);
            setTimeout(function(){
                $("#failed_message").fadeTo(1500, 0);
            },5000);
            console.log(data.responseText);
        }
    });

};

//2. Update Event
function UpdateThisEvent(){
    var baseUri = "/api/update/event";
    var eventID_url = "eventID=" + $('input[id=event-id]').val();
    var eventName_url = "eventName=" + $('input[id=event-name]').val();
    var typeOfEventID_url = "typeOfEventID=" + $('select[id=event-type]').val();
    var eventDate_url = "eventDate=" + $('input[id=event-date]').val();
    var eventTime_url = "eventTime=" + $('input[id=event-time]').val();
    var eventVenueName_url = "eventVenueName=" + $('input[id=event-venue]').val();
    var eventAddressCity_url = "eventAddressCity=" + $('input[id=event-city]').val();
    var eventAddressStreet_url = "eventAddressStreet=" + $('input[id=event-street]').val();
    var eventAddressNumber_url = "eventAddressNumber=" + $('input[id=event-number]').val();
    var eventPostcode_url = "eventPostcode=" + $('input[id=event-postcode]').val();
    var eventSummary_url = "eventSummary=" + $('textarea[id=event-summary]').val();
    var nameOfAdviser_url = "nameOfAdviser=" + $('input[id=adviser-name]').val();
    var numberOfAttendees_url = "numberOfAttendees=" + $('input[id=no-attendees]').val();

    var isPublic_url = "isPublic=" + $('select[id=event-public]').val();
    var isCancelled_url = "isCancelled=" + $('select[id=event-cancelled]').val();
    var promotesApprenticeships_url="promotesApprenticeships=" + $('select[id=promote-apprenticheship]').val();
    var promotesWelshLanguage_url = "promotesWelshLanguage=" + $('select[id=conducted-welsh]').val();
    var challengesGenderStereotypes_url = "challengesGenderStereotypes=" + $('select[id=challenger-gender]').val();

    var employerAttending_url = "employerAttending=" + $('select[id=employers-attending]').val();
    var schoolAttending_url = "schoolAttending=" + $('select[id=schools-attending]').val();


    var fullUri = baseUri + "?" + "&" + eventID_url + "&" + eventName_url+ "&" + typeOfEventID_url + "&" + eventDate_url + "&" + eventTime_url + "&"
        + eventVenueName_url + "&" + eventAddressCity_url  + "&" + eventAddressStreet_url  + "&" + eventAddressNumber_url + "&"
        + eventPostcode_url + "&" + eventSummary_url+ "&" + isPublic_url + "&" + isCancelled_url + "&" +nameOfAdviser_url +"&"
        + numberOfAttendees_url + "&" + promotesApprenticeships_url  + "&" + promotesWelshLanguage_url + "&" + challengesGenderStereotypes_url  + "&"
        + employerAttending_url + "&" + schoolAttending_url ;

    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol
    console.log(fullUri)

    // 2.1. validation
    let verifier
    verifier = validateForm($('input[id=vacancy-name]'),$('textarea[id=vacancy-summary]'),$('input[id=start-date]'),$('input[id=closing-date]'),$('input[id=post-code]'));
    // 2.2. Error Message
    if(!verifier){
        $('#failed_message_text').text("The Form was not filled properly.");
        $('#failed_message').removeClass('d-none').addClass('show');
        $("#failed_message").fadeTo(1500, 1);
        setTimeout(function(){
            $("#failed_message").fadeTo(1500, 0);
        },5000);
        return
    }



    $.ajax({
        type: "GET", url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data === true) {
                localStorage.setItem("eventUpdated", 'true')
                // location.assign("/events")
                location.reload()
            } else {
                alert("There was an error, please try again.")
                alert(data.responseText)
                alert(data)
            }
        },
        error: function (data) {
            alert("FAIL");
            alert(data.responseText);
            alert(data.toString());
        }
    });
}

// 3.Delete Event
function deleteEvent(eventId) {
    var baseUri = "/api/delete/event";
    var eventId_url = "eventId=" + eventId;
    var fullUri = baseUri + "?" + eventId_url;

    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- SOlution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass SPring Boot's CSRF protocol


    $.ajax({
        type: "DELETE", url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data === true) {
                localStorage.setItem("eventDeleted", "true")
                location.assign("/events")
            } else {
                alert("There was an error, please try again.")
                alert(data.responseText)
                alert(data)
            }
        },
        error: function (data) {
            $('#failed_message_text').text("Something went wrong with the submission.");
            $('#failed_message').removeClass('d-none').addClass('show');
            $("#failed_message").fadeTo(1500, 1);
            setTimeout(function(){
                $("#failed_message").fadeTo(1500, 0);
            },5000);
            console.log(data.responseText);
        }
    });
}

// 4.Search Events
function searchEvents(){
    // 4.1 Get the value from Search input
    let val = $('#event-search').val()

    //4.2  If value is null exit the function
    if (val==""){
        $(".event-card").removeClass("d-none")
    }

    //4.3 Transform the first letters in a word to uppercase
    let val2 = val.charAt(0).toUpperCase()+ val.slice(1);
    //4.4 Remove class event found - to restart the "search"
    $(".event-found").removeClass("event-found")
    $(".event-card").removeClass("d-none")

    //4.5 Add classes for the right values
    $(".list-events").find(".searchable:contains('"+val2+"')").closest(".event-card").addClass("event-found")

    //4.6 Remove the cards
    $(".list-events").find(".searchable:not(:contains('"+val2+"'))").closest(".event-card").addClass("d-none")

    //4.7 Show the "Right" Card
    $(".event-found").removeClass("d-none")

}

//5. Sort Event By Name and Date
function sortEventsByNameAndDate(type, order) {

    let baseUri = "api/event/sortBy";
    let orderBy_url = "orderBy=" + order ;
    let sortBy_url = "sortBy=" + type ;

    var fullUri = baseUri + "?" + "&" + orderBy_url + "&" + sortBy_url
    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol

    console.log(fullUri)

    $.ajax({
        type: "GET",
        url: fullUri,
        dataType: 'json',
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            sortEvents(data);
        },
        error: function (data) {
            alert("FAIL");
            alert(data.responseText);
            alert(data.toString());
        }
    });
}

// 6. sortEvents
function sortEvents(ids){

    for (i = 0; i < ids.length; i++) {
        $("#"+ids[i]).closest(".event-card").before( $("#"+ids[i+1]).closest(".event-card"));
    }
}

//7. On document Ready
$( document ).ready(function() {
    $("select[name=event-sort-by]").change(function(){
        sortEventsByNameAndDate($(this).val(),$(this).children(":selected").attr("data-val"));
    });
});

//8. Hide Events
function hideEvents(ids){

    $(".event-card").removeClass("d-none");
    $(".event-card").addClass("d-none");

    for (i = 0; i < ids.length; i++) {
        $("#"+ids[i]).removeClass("d-none");
    }
}

//9. Filter Events
function filterEvents() {
    var baseUri = "/api/event/filter";
    var typeOfEventID_url = "typeOfEventID=" + $('select[id=event-type]').val();
    var nameOfAdviser_url = "nameOfAdviser=" + $('select[id=event-advisor]').val();
    var eventPreferences_url = "eventPreferences=" + $('select[id=event-preference]').val();

    var fullUri = baseUri + "?" + "&" + typeOfEventID_url + "&" + nameOfAdviser_url+ "&" + eventPreferences_url;

    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol

    console.log(fullUri)

    $.ajax({
        type: "GET",
        url: fullUri,
        dataType: 'json',
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            hideEvents(data);
            console.log(data);
        },
        error: function (data) {
            alert("FAIL");
            alert(data.responseText);
            alert(data.toString());
        }
    });
}

//10. Feedback - Add Event
eventAdded = localStorage.getItem("eventAdded");

if (eventAdded === "true"){
    $('#success_message').removeClass('d-none').addClass('show');
    $("#success_message").fadeTo(1500, 1);
    setTimeout(function(){
        $("#success_message").fadeTo(1500, 0);
    },5000);
    localStorage.clear()
}

//11. Feedback - Remove Event
eventDeleted = localStorage.getItem("eventDeleted");

if (eventDeleted === "true"){
    $('#success_message').innerHTML =  "<strong> Success! </strong>" + 'The event was deleted!';
    $('#success_message').removeClass('d-none').addClass('show');
    $("#success_message").fadeTo(1500, 1);
    setTimeout(function(){
        $("#success_message").fadeTo(1500, 0);
    },5000);
    localStorage.clear()
}

//12. Validation Function
function validateForm(vacancyName,vacancyDescription,startDate,endDate,postCode){

    let verifier = true;
    let attributesArray = [vacancyName,vacancyDescription,startDate,endDate]

    // 11.1 Remove the Valid/Invalid class
    $(".form-control").removeClass("is-invalid ").removeClass("is-valid ")
    $(".selectpicker").removeClass("is-invalid ").removeClass("is-valid ")

    // 11.2 Add The Valid class to all elements
    $(".form-control").add("is-valid ")
    $(".selectpicker").add("is-valid ")

    for(let i = 0; i < attributesArray.length; i++){
        if(attributesArray[i].val()===""){
            // 11.3 Remove The Valid/Invalid class
            attributesArray[i].removeClass("is-invalid ").removeClass("is-valid ")
            // 11.4 Add the Invalid class
            attributesArray[i].addClass("is-invalid ")
            console.log(attributesArray[i])
            verifier = false
        }
    }
    return verifier;
}


//13. Document ready
$(document).ready(function(){
    $('#filterButton').click(function(){
        filterEvents();
    });

    $("#tooltip").hover(function(){
            $(this).tooltip('show')
        },
        function(){
            $(this).tooltip('hide')
        }
    )
});
