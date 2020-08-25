
//1. Create Vacancy
function createVacancy() {

    // 1.1. validation
    let verifier
    verifier = validateForm();
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

    let baseUri = "/api/create/vacancy";
    let employerID_url = "EmployerID=" + $('select[id=employer-name]').val();
    let vacancyName_url = "VacancyName=" + $('input[id=vacancy-name]').val();
    let vacancyLink_url = "VacancyLink=" + $('input[id=web-link]').val();
    let vacancySummary = "VacancySummary=" + $('textarea[id=vacancy-summary]').val();
    let typeOfVacancyID_url = "TypeOfVacancyID=" + $('select[id=vacancy-type]').val();
    let statusOfVacancyID_url="StatusOfVacancyID=" + $('select[id=vacancy-status]').val();
    let startOfVacancy_url = "StartOfVacancy=" + $('input[id=start-date]').val();
    let deadlineForApplication_url = "DeadlineForApplication=" + $('input[id=closing-date]').val();
    let occupationalCodeID_url = "OccupationalCodeID=" + $('select[id=occup-code]').val();
    let applicationMethodID_url = "ApplicationMethodID=" + $('select[id=appl-method]').val();
    let vacancyPostcode_url = "VacancyPostcode=" + $('input[id=post-code]').val();

    let fullUri = baseUri + "?" + "&" + employerID_url+ "&" + vacancyName_url + "&" + vacancyLink_url
        + "&" + vacancySummary + "&" + typeOfVacancyID_url  + "&" + "&" + statusOfVacancyID_url  + "&" + startOfVacancy_url + "&"
        + deadlineForApplication_url + "&" + occupationalCodeID_url+ "&" + applicationMethodID_url + "&" + vacancyPostcode_url  ;

    let token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    let header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol
    console.log(fullUri);

    $.ajax({
        type: "GET", url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data === true) {
                localStorage.setItem("vacAdded","true");
                location.assign("/vacancies")
            } else {
                alert("There was an error, please try again.");
                alert(data.responseText);
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

//2. Update Vacancy
function UpdateThisVacancy() {

    // 2.1. validation
    let verifier
    verifier = validateForm();
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
                localStorage.setItem("vacancyUpdated","true")
                // location.assign("/vacancies")
                location.reload()
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
                localStorage.setItem("vacancyDeleted", "true")
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
    let val = $('#vacancy-search').val()

    //4.2 Remove class vacancy found - to restart the "search"
    $(".vacancy-found").removeClass("vacancy-found")

    //4.3 Add classes for the right values
    $(".list-vacancies").find(".searchable:contains('"+val+"')").closest(".vacancy-card").addClass("vacancy-found")

    //4.4 Add the d-none to all cards and then removes it from the ones that are filtered or searched
    $(".vacancy-card").addClass("d-none");
    $('.vacancy-filtered.vacancy-found').removeClass('d-none');

}

//5. Sort Vacancy By Name and Date
function sortVacanciesByNameAndDate(type, order) {

    let baseUri = "api/vacancy/sortBy";
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
            console.log(data)
            sortVacancies(data);
        },
        error: function (data) {
            alert("FAIL");
            alert(data.responseText);
            alert(data.toString());
        }
    });
}

// 6. sortVacancy
function sortVacancies(ids){

    for (i = 0; i < ids.length; i++) {
        $("#"+ids[i]).closest(".vacancy-card").before( $("#"+ids[i+1]).closest(".vacancy-card"));
    }
}

// 7. Hide Vacancies
function hideVacancies(ids){

    //7.1 remove previous filtering
    $(".vacancy-filtered").removeClass("vacancy-filtered");

    //7.2 add .vacancy-filtered class to indicate which filtering results
    for (i = 0; i < ids.length; i++) {
        $("#"+ids[i]).addClass("vacancy-filtered");
    }

    //7.3 Add the d-none to all cards and then removes it from the ones that are filtered or searched
    $(".vacancy-card").addClass("d-none");
    $('.vacancy-filtered.vacancy-found').removeClass('d-none');
}

// 8. Filter Vacancies
function filterVacancies() {

    var baseUri = "/api/filter/vacancy";
    var typeOfVacancyID_url = "typeOfVacancyID=" + $('select[id=vacancy-type]').val();
    var occupationalCodeID_url = "occupationalCodeID=" + $('select[id=occup-code]').val();

    var fullUri = baseUri + "?" + "&" + typeOfVacancyID_url  + "&" + occupationalCodeID_url ;

    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol


    console.log(fullUri);

    $.ajax({
        type: "GET",
        url: fullUri,
        dataType: 'json',
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            hideVacancies(data);
            console.log(data);
          },
        error: function (data) {
            alert("FAIL");
            alert(data.responseText);
            alert(data.toString());
        }
    });
}

//9. Feedback - Add Vacancy
vacAdded = localStorage.getItem("vacAdded");

if (vacAdded === "true"){
    $('#success_message_text').text(' The vacancy was created!');
    $('#success_message').removeClass('d-none').addClass('show');
    localStorage.clear()
    $("#success_message").fadeTo(1500, 1);
    setTimeout(function(){
        $("#success_message").fadeTo(1500, 0);
    },5000);
}

//10. Feedback - Remove Vacancy
vacancyDeleted = localStorage.getItem("vacancyDeleted");

if (vacancyDeleted === "true"){
    $('#success_message_text').text(' The vacancy was deleted!');
    $('#success_message').removeClass('d-none').addClass('show');
    $("#success_message").fadeTo(1500, 1);
    setTimeout(function(){
        $("#success_message").fadeTo(1500, 0);
    },5000);
    localStorage.clear()
}

//11. Validation Function
function validateForm(){

    let verifier = true;
    let attributesArray = $(".form-required")

    // 11.1 Remove the Valid/Invalid class
    $(".form-required").removeClass("is-invalid ").removeClass("is-valid ")
    $(".selectpicker").parent().removeClass("is-invalid").removeClass("is-valid ")

    // 11.2 Add The Valid class to all elements
    $(".selectpicker").add("is-valid ")

    // 11.3 Validate inputs(Empty)
    for (let i = 0; i < attributesArray.length; i++) {
        if (attributesArray[i].value === "") {
            // 11.3.1 Remove The Valid/Invalid class
            attributesArray[i].classList.remove("is-invalid")
            attributesArray[i].classList.remove("is-valid")
            // 11.3.2 Add the Invalid class
            attributesArray[i].classList.add("is-invalid")
        }
    }

    // 11.4 Change variable data to selectpickers
    attributesArray = $(".selectpicker")

    //11.5 Validate selectpickers
    for (let i = 0; i < attributesArray.length; i++) {
        if (attributesArray[i].value === "") {
            // 11.5.1 Remove The Valid/Invalid class
            attributesArray[i].classList.remove("is-invalid")
            attributesArray[i].classList.remove("is-valid")
            // 11.5.2 Add the Invalid class
            attributesArray[i].parentNode.classList.add("is-invalid")
        }
    }

    // 11.6 Validate Input(PostCode)

    // 11.6.1 Set the RegEx and test it
    let postCodeVal = /[a-z][a-z]\d\d\s\d[a-z][a-z]|[a-z][a-z]\d\s\d[a-z][a-z]|[a-z]\d\s\d[a-z][a-z]|[a-z][a-z]\d[a-z]\s\d[a-z][a-z]|[a-z]\d\d\s\d[a-z][a-z]/i.test($("#post-code").val());
    // let postCodeVal = postCodeValidation.test($("#employer-postcode").val());
    // 11.6.2 Verify if it's needed to put an invalid class
    if(!postCodeVal){
        $("#post-code").removeClass("is-invalid").removeClass("is-valid")
        $("#post-code").addClass("is-invalid")
    }

    //11.7 Verify if there is any invalid class
    if($(".selectpicker").parent().hasClass("is-invalid") || $(".form-required").hasClass("is-invalid")){
        verifier = false
    }

    return verifier;
}



//12. On document Ready
$( document ).ready(function() {
    $("select[name=vacancy-sort-by]").change(function(){
        sortVacanciesByNameAndDate($(this).val(),$(this).children(":selected").attr("data-val"));
    });

    $('#filterButton').click(function(){
        filterVacancies();
    });

    $("#addVacancy").hover(function(){
            $(this).addClass("typoWhite")
        },
        function(){
            $(this).removeClass("typoWhite")
        }
    )

    $("#tooltip").hover(function(){
            $(this).tooltip('show')
        },
        function(){
            $(this).tooltip('hide')
        }
    )

    // Overwriting contains to be case insensitive, found at :
    // https://css-tricks.com/snippets/jquery/make-jquery-contains-case-insensitive/
    $.expr[":"].contains = $.expr.createPseudo(function(arg) {
        return function( elem ) {
            return $(elem).text().toUpperCase().indexOf(arg.toUpperCase()) >= 0;
        };
    });

});
