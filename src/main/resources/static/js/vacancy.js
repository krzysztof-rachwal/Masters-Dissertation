
//1. Create Vacancy
function createVacancy() {
    var baseUri = "/api/create/vacancy";
    var employerID_url = "EmployerID=" + $('select[id=employer-name]').val();
    var vacancyName_url = "VacancyName=" + $('input[id=vacancy-name]').val();
    var vacancyLink_url = "VacancyLink=" + $('input[id=web-link]').val();
    var vacancySummary = "VacancySummary=" + $('textarea[id=vacancy-summary]').val();
    var typeOfVacancyID_url = "TypeOfVacancyID=" + $('select[id=vacancy-type]').val();
    var statusOfVacancyID_url="StatusOfVacancyID=" + $('select[id=vacancy-status]').val();
    var startOfVacancy_url = "StartOfVacancy=" + $('input[id=start-date]').val();
    var deadlineForApplication_url = "DeadlineForApplication=" + $('input[id=closing-date]').val();
    var occupationalCodeID_url = "OccupationalCodeID=" + $('select[id=occup-code]').val();
    var applicationMethodID_url = "ApplicationMethodID=" + $('select[id=appl-method]').val();
    var vacancyPostcode_url = "VacancyPostcode=" + $('input[id=post-code]').val();

    var fullUri = baseUri + "?" + "&" + employerID_url+ "&" + vacancyName_url + "&" + vacancyLink_url
        + "&" + vacancySummary + "&" + typeOfVacancyID_url  + "&" + "&" + statusOfVacancyID_url  + "&" + startOfVacancy_url + "&"
        + deadlineForApplication_url + "&" + occupationalCodeID_url+ "&" + applicationMethodID_url + "&" + vacancyPostcode_url  ;

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


//2. Update Vacancy
function UpdateThisVacancy() {
    var baseUri = "/api/update/vacancy";
    var employerID_url = "EmployerID=" + $('select[id=employer-name]').val();
    var vacancyName_url = "VacancyName=" + $('input[id=vacancy-name]').val();
    var vacancyOldId_url = "VacancyOldName=" + $('input[id=vacancy-old-name]').val();
    var vacancyLink_url = "VacancyLink=" + $('input[id=web-link]').val();
    var vacancySummary = "VacancySummary=" + $('textarea[id=vacancy-summary]').val();
    var typeOfVacancyID_url = "TypeOfVacancyID=" + $('select[id=vacancy-type]').val();
    var statusOfVacancyID_url="StatusOfVacancyID=" + $('select[id=vacancy-status]').val();
    var startOfVacancy_url = "StartOfVacancy=" + $('input[id=start-date]').val();
    var deadlineForApplication_url = "DeadlineForApplication=" + $('input[id=closing-date]').val();
    var occupationalCodeID_url = "OccupationalCodeID=" + $('select[id=occup-code]').val();
    var applicationMethodID_url = "ApplicationMethodID=" + $('select[id=appl-method]').val();
    var vacancyPostcode_url = "VacancyPostcode=" + $('input[id=post-code]').val();
    var vacancyOldPostcode_url = "VacancyOldPostcode=" + $('input[id=old-post-code]').val();

    var fullUri = baseUri + "?" + "&" + employerID_url+ "&" + vacancyName_url + "&" + vacancyOldId_url  + "&" + vacancyLink_url
        + "&" + vacancySummary + "&" + typeOfVacancyID_url  + "&" + "&" + statusOfVacancyID_url  + "&" + startOfVacancy_url + "&"
        + deadlineForApplication_url + "&" + occupationalCodeID_url+ "&" + applicationMethodID_url + "&" + vacancyPostcode_url + "&"
        + vacancyOldPostcode_url;

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

// 3.Delete Vacancy
function deleteVacancy(vacancyId) {
    var baseUri = "/api/delete/vacancy";
    var vacancyId_url = "vacancyId=" + vacancyId;
    var fullUri = baseUri + "?" + vacancyId_url;

    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- SOlution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass SPring Boot's CSRF protocol


    $.ajax({
        type: "DELETE", url: fullUri,
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
        }

    });
}



// 4.Search Vacancy
function searchVacancy(){
    // 4.1 Get the value from Search input
    val = $('#vacancy-search').val()

    //4.2  If value is null exit the function
    if (val==""){
        $(".vacancy-card").removeClass("d-none")
    }

    //4.3 Transform the first letters in a word to uppercase
    let val2 = val.charAt(0).toUpperCase() + val.slice(1);

    //4.4 Remove class vacancy found - to restart the "search"
    $(".vacancy-found").removeClass("vacancy-found")
    $(".vacancy-card").removeClass("d-none")

    //4.5 Add classes for the right values
    $(".list-vacancies").find(".searchable:contains('"+val2+"')").closest(".vacancy-card").addClass("vacancy-found")

    //4.6 Remove the cards
    $(".list-vacancies").find(".searchable:not(:contains('"+val2+"'))").closest(".vacancy-card").addClass("d-none")

    //4.7 Show the "Right" Card
    $(".vacancy-found").removeClass("d-none")

}

// 5. Sort Vacancy by Name
function sortByName(){
    var list, i, switching, shouldSwitch;
    switching = true;
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // start by saying: no switching is done:
        switching = false;
        list = $('div[name=vacancy-card-title]')

        // b = list.closest(".vacancy-card");

        // Loop through all list-items:
        for (i = 0; i < (list.length - 1); i++) {
            // start by saying there should be no switching:
            shouldSwitch = false;
            /* check if the next item should
            switch place with the current item: */
            if (list[i].innerHTML.toLowerCase() > list[i + 1].innerHTML.toLowerCase()) {
                /* if next item is alphabetically
                lower than current item, mark as a switch
                and break the loop: */
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark the switch as done: */
            list[i].closest(".vacancy-card").before(list[i + 1].closest(".vacancy-card"));
            switching = true;
        }
    }

}

// 6. Sort Vacancy by Date
function sortByDate() {
    var list = $('h5[name=vacancy-card-date]')

    // Loop through all list-items:
    for (i = 0; i < (list.length - 1); i++) {
        var listCompare1 = list[i].innerHTML.split("-");

        for (j = 0; j < (list.length - 1); j++) {
            var listCompare2 = list[j].innerHTML.split("-");

            if (listCompare1[0] < listCompare2[0]) {
                // alert(" Part 1 ---- listCompare1: " + listCompare1 + " listCompare2: " + listCompare2)
                list[i].closest(".vacancy-card").before(list[j].closest(".vacancy-card"));
            }

            if (listCompare1[0] == listCompare2[0] && listCompare1[1] < listCompare2[1]) {
                // alert("Part 2 --- listCompare1: " + listCompare1 + " listCompare2: " + listCompare2)
                list[i].closest(".vacancy-card").before(list[j].closest(".vacancy-card"));
            }
            if (listCompare1[0] == listCompare2[0] && listCompare1[1] == listCompare2[1] && listCompare1[2] < listCompare2[2]) {
                // alert("Part 3 --- listCompare1: " + listCompare1 + " listCompare2: " + listCompare2)
                list[i].closest(".vacancy-card").before(list[j].closest(".vacancy-card"));
            }


            // if (list[i].textContent > list[j].textContent) {
            //     list[i].closest(".vacancy-card").before(list[j].closest(".vacancy-card"));
            // }
        }
    }
}

//7. On document Ready
$( document ).ready(function() {
    $("select[name=vacancy-sort-by]").change(function(){
        if($(this).val()=="Name"){
            sortByName();
        }
        if($(this).val()=="Date"){
            sortByDate();
        }

    });
});


// For the Vacancy Name selector
$('.selectpicker').selectpicker();