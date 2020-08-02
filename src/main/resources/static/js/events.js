
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

    $.ajax({
        type: "GET", url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data === true) {
                location.assign("/events")
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

};

// 2.Delete Event
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
                location.assign("/events")
            } else {
                alert("There was an error, please try again.")
                alert(data.responseText)
                alert(data)
            }
        },
        error: function (data) {
            alert("FAIL");
            alert(data.responseText);
        }

    });
}


// For the Event Name selector
$('.selectpicker').selectpicker();