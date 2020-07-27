
//1. Create Vacancy
function createVacancy() {
    var baseUri = "/api/create/vacancy";
    var employerName_url = "employerName=" + $('input[id=employer-name]').val();
    var vacancyTitle_url = "VacancyTitle=" + $('input[id=vacancy-name]').val();
    var link_url = "Link=" + $('input[id=web-link]').val();
    var details_url = "Details=" + $('textarea[id=vacancy-desc]').val();
    var typeOfVacancy_url = "TypeOfVacancy=" + $('select[id=vacancy-type]').val();
    var startOfVacancy_url = "StartOfVacancy=" + $('input[id=start-date]').val();
    var closingDate_url = "ClosingDate=" + $('input[id=closing-date]').val();
    var occupationalCode_url = "OccupationalCode=" + $('select[id=occup-code]').val();
    var applicationMethod_url = "ApplicationMethod=" + $('select[id=appl-method]').val();
    var postcode_url = "Postcode=" + $('input[id=post-code]').val();

    var fullUri = baseUri + "?" + "&" + employerName_url+ "&" + vacancyTitle_url + "&" + link_url
        + "&" + details_url + "&" + typeOfVacancy_url  + "&" + startOfVacancy_url + "&"
        + closingDate_url + "&" + occupationalCode_url+ "&" + applicationMethod_url + "&" + postcode_url  ;

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

// 2.Delete Vacancy
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
