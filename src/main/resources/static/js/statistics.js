
// Return number of events by auth and type
function getEventsByAuthAndType(){
    let baseUri = "/api/filter/";
    let eventType = "EventType=" + $('select[id=typeOfEvent]').val();
    let authority = "LocalAuthority=" + $('select[id=authorityForEve]').val();

    let fullUri = baseUri + "?" + "&" + eventType + "&" + authority;

    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol
    console.log(fullUri);

    $.ajax({
        type: "GET",
        url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data != null) {
                console.log(data)
                $("#eventAuthResult").text(data);
                // location.assign("/report")
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

function getEventsBySchool() {
    let baseUri = "/api/filter/school";
    let school = "School=" + $('select[id=schoolForEvent]').val();

    let fullUri = baseUri + "?" + "&" + school;

    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol
    console.log(fullUri);

    $.ajax({
        type: "GET",
        url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data != null) {
                console.log(data)
                $("#eveBySchoolResult").text(data);
                // location.assign("/report")
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