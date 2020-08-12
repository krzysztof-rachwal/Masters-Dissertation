
//1. Create Vacancy
function createVacancy() {
    var baseUri = "/api/create/vacancy";
    var employerID_url = "EmployerID=" + $('select[id=employer-name]').val();
    var vacancyName_url = "VacancyName=" + $('input[id=vacancy-name]').val();
    var vacancylink_url = "VacancyLink=" + $('input[id=web-link]').val();
    var vacancySummary = "VacancySummary=" + $('textarea[id=vacancy-summary]').val();
    var typeOfVacancyID_url = "TypeOfVacancyID=" + $('select[id=vacancy-type]').val();
    var statusOfVacancyID_url="StatusOfVacancyID=" + $('select[id=vacancy-status]').val();
    var startOfVacancy_url = "StartOfVacancy=" + $('input[id=start-date]').val();
    var deadlineForApplication_url = "DeadlineForApplication=" + $('input[id=closing-date]').val();
    var occupationalCodeID_url = "OccupationalCodeID=" + $('select[id=occup-code]').val();
    var applicationMethodID_url = "ApplicationMethodID=" + $('select[id=appl-method]').val();
    var vacancyPostcode_url = "VacancyPostcode=" + $('input[id=post-code]').val();

    var fullUri = baseUri + "?" + "&" + employerID_url+ "&" + vacancyName_url + "&" + vacancylink_url
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
    let val2 = UpperCaseHelper(val)

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

// 5. Makes all first letters uppercase
function UpperCaseHelper(str) {
    var splitStr = str.toLowerCase().split(' ');
    for (var i = 0; i < splitStr.length; i++) {
        // You do not need to check if i is larger than splitStr length, as your for does that for you
        // Assign it back to the array
        splitStr[i] = splitStr[i].charAt(0).toUpperCase() + splitStr[i].substring(1);
    }
    // Directly return the joined string
    return splitStr.join(' ');
}


// For the Vacancy Name selector
$('.selectpicker').selectpicker();