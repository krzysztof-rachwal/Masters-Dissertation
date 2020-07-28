
//1. Create Event
function createEvent() {
    var baseUri = "/api/create/event";
    var eventName = "eventName=" + $('input[id=event-name]').val();
    var adviserName_url = "adviserName=" + $('input[id=adviser-name]').val();
    var eventType_url = "eventType=" + $('select[id=event-type]').val();
    var details_url = "Details=" + $('textarea[id=vacancy-desc]').val();
    var eventDate_url = "TypeOfVeventDateacancy=" + $('input[id=event-date]').val();
    var employerAttending_url="StatusOfVacancy=" + $('select[id=employers-attending]').val();
    var eventTime_url = "StartOfVacancy=" + $('input[id=event-time]').val();
    var schoolAttending_url = "ClosingDate=" + $('select[id=schools-attending]').val();
    var eventVenue_url = "OccupationalCode=" + $('select[id=event-venue]').val();
    var applicationMethod_url = "ApplicationMethod=" + $('select[id=appl-method]').val();
    var postcode_url = "Postcode=" + $('input[id=post-code]').val();

    var fullUri = baseUri + "?" + "&" + eventName+ "&" + adviserName_url + "&" + eventType_url
        + "&" + eventType_url + "&" + eventDate_url  + "&" + "&" + employerAttending_url  + "&" + eventTime_url + "&"
        + schoolAttending_url + "&" + eventVenue_url+ "&" + applicationMethod_url + "&" + postcode_url  ;

    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- SOlution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol
    console.log(fullUri)

    $.ajax({
        type: "GET", url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data === true) {
                location.assign("/vacancies")
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
                llocation.assign("/events")
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