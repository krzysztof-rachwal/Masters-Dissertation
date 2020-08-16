
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
                localStorage.setItem("eventAdded","true");
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
            alert("FAIL");
            alert(data.responseText);
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

// 5. Sort Events by Name
function sortByName(type){
    var list, i, switching, shouldSwitch;
    switching = true;
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // start by saying: no switching is done:
        switching = false;
        list = $('div[name=event-card-title]')

        // Loop through all list-items:
        for (i = 0; i < (list.length - 1); i++) {
            // start by saying there should be no switching:
            shouldSwitch = false;
            /* check if the next item should
            switch place with the current item: */
            if (type =="up") {
                if (list[i].innerHTML.toLowerCase() > list[i + 1].innerHTML.toLowerCase()) {
                    /* if next item is alphabetically
                    lower than current item, mark as a switch
                    and break the loop: */
                    shouldSwitch = true;
                    break;
                }
            }

            if (type =="down") {
                if (list[i].innerHTML.toLowerCase() < list[i + 1].innerHTML.toLowerCase()) {
                    /* if next item is alphabetically
                    lower than current item, mark as a switch
                    and break the loop: */
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark the switch as done: */
            list[i].closest(".event-card").before(list[i + 1].closest(".event-card"));
            switching = true;
        }
    }

}

// 6. Sort Vacancy by Date
function sortByDate(type) {
    let list = $('h5[name=event-card-date]').val()

    // Loop through all list-items:
    for (i = 0; i < (list.length - 1); i++) {
        let listCompare1 = list[i].innerHTML.split("-");

        for (j = 0; j < (list.length - 1); j++) {
            let listCompare2 = list[j].innerHTML.split("-");
            if(type=="down") {
                if (listCompare1[0] < listCompare2[0]) {
                    list[i].closest(".event-card").before(list[j].closest(".event-card"));
                }

                if (listCompare1[0] == listCompare2[0] && listCompare1[1] < listCompare2[1]) {
                    list[i].closest(".event-card").before(list[j].closest(".event-card"));
                }
                if (listCompare1[0] == listCompare2[0] && listCompare1[1] == listCompare2[1] && listCompare1[2] < listCompare2[2]) {
                    list[i].closest(".event-card").before(list[j].closest(".event-card"));
                }
            }
            if(type=="up"){
                if (listCompare1[0] > listCompare2[0]) {
                    // alert(" Part 1 ---- listCompare1: " + listCompare1 + " listCompare2: " + listCompare2)
                    list[i].closest(".event-card").before(list[j].closest(".event-card"));
                }

                if (listCompare1[0] == listCompare2[0] && listCompare1[1] > listCompare2[1]) {
                    // alert("Part 2 --- listCompare1: " + listCompare1 + " listCompare2: " + listCompare2)
                    list[i].closest(".event-card").before(list[j].closest(".event-card"));
                }
                if (listCompare1[0] == listCompare2[0] && listCompare1[1] == listCompare2[1] && listCompare1[2] > listCompare2[2]) {
                    // alert("Part 3 --- listCompare1: " + listCompare1 + " listCompare2: " + listCompare2)
                    list[i].closest(".event-card").before(list[j].closest(".event-card"));
                }
            }
        }
    }
}

//7. On document Ready
$( document ).ready(function() {
    $("select[name=event-sort-by]").change(function(){
        if($(this).val()=="NameUp"){
            sortByName("up");
        }

        if($(this).val()=="NameDown"){
            sortByName("down");
        }

        if($(this).val()=="DateUp"){
            sortByDate("up");
        }

        if($(this).val()=="DateDown"){
            sortByDate("down");
        }

    });
});


// For the Event Name selector
// $('.selectpicker').selectpicker();
