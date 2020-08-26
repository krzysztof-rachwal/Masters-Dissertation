
//HTTP REQUEST METHODS
function deleteEmployer(employerId) {
    var baseUri = "/api/delete/employer";
    var employerId_url = "employerId=" + employerId;
    var fullUri = baseUri + "?" + employerId_url;

    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- SOlution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass SPring Boot's CSRF protocol


    $.ajax({
        type: "DELETE", url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data === true) {
                location.assign("/employers")
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

// 4.Search Employer
function searchEmployer(){
    // 4.1 Get the value from Search input
    let val = $('#employer-search').val()

    //4.2 Remove class employer found - to restart the "search"
    $(".employer-found").removeClass("employer-found")

    //4.3 Add classes for the right values
    $(".list-employers").find(".searchable:contains('"+val+"')").closest(".employer-card").addClass("employer-found")

    //4.4 Add the d-none to all cards and then removes it from the ones that are filtered or searched
    $(".employer-card").addClass("d-none");
    $('.employer-filtered.employer-found').removeClass('d-none');

}

//5. Sort Employers By Name
function sortEmployerByName(type, order) {

    let baseUri = "api/employer/sortBy";
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
            sortEmployers(data);
        },
        error: function (data) {
            alert("FAIL");
            alert(data.responseText);
            alert(data.toString());
        }
    });
}

// 6. sort Employers
function sortEmployers(ids){

    for (i = 0; i < ids.length; i++) {
        $("#"+ids[i]).closest(".employer-card").before( $("#"+ids[i+1]).closest(".employer-card"));
    }
}


//7. FilterEmployers
function filterEmployers() {

    var baseUri = "/api/filter/employer";
    var EmployerSectorIndustry_url = "EmployerSectorIndustry=" + $('select[id=industry-sector]').val();
    var EmployerCooperationType_url = "EmployerCooperationType=" + $('select[id=employer-cooperation-type]').val();
    var EmployerCurriculumAreas_url = "EmployerCurriculumAreas=" + $('select[id=curriculum-area]').val();
    var EmployerPreferences_url = "EmployerPreferences=" + $('select[id=employer-preferences]').val();
    var EmployerLanguage_url = "EmployerLanguage=" + $('select[id=employer-language]').val();
    var SchoolPreferences_url = "SchoolPreferences=" + $('select[id=schools-attending]').val()
    var localAuthorities_url = "LocalAuthorities=" + $('select[id=local-authorities]').val();

    var fullUri = baseUri + "?" + "&" + EmployerSectorIndustry_url  + "&"
        + EmployerCooperationType_url + "&" + EmployerCurriculumAreas_url + "&"
        + EmployerPreferences_url+ "&" + EmployerLanguage_url+ "&"
        + EmployerCurriculumAreas_url + "&" + SchoolPreferences_url + "&"+ localAuthorities_url ;

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
            hideEmployers(data);
            console.log(data);
        },
        error: function (data) {
            alert("FAIL");
            alert(data.responseText);
            alert(data.toString());
        }
    });
}

// 8. Hide Employer
function hideEmployers(ids){

    //8.1 remove previous filtering
    $(".employer-filtered").removeClass("employer-filtered");

    //8.2 add .employer-filtered class to indicate which filtering results
    for (i = 0; i < ids.length; i++) {
        $("#"+ids[i]).addClass("employer-filtered");
    }

    //8.3 Add the d-none to all cards and then removes it from the ones that are filtered or searched
    $(".employer-card").addClass("d-none");
    $('.employer-filtered.employer-found').removeClass('d-none');

}

//9. Feedback - Add Employer
empAdded = localStorage.getItem("empAdded");

if (empAdded === "true"){
    $('#success_message_text').text(' The employer profile was created!');
    $('#success_message').removeClass('d-none').addClass('show');
    $("#success_message").fadeTo(1500, 1);
    setTimeout(function(){
        $("#success_message").fadeTo(1500, 0);
    },5000);
    localStorage.clear()
}

//10. Feedback - Remove Employer
employerDeleted = localStorage.getItem("employerDeleted");

if (employerDeleted === "true"){
    $('#success_message_text').text(' The employer profile is deleted!');
    $('#success_message').removeClass('d-none').addClass('show');
    $("#success_message").fadeTo(1500, 1);
    setTimeout(function(){
        $("#success_message").fadeTo(1500, 0);
    },5000);
    localStorage.clear()
}

//11. Feedback - Update Employer
employerUpdated = localStorage.getItem("employerUpdated");

if (employerUpdated === "true"){
    $('#success_message').removeClass('d-none')
    $("#success_message").fadeTo(1500, 1);
    setTimeout(function(){$("#success_message").fadeTo(1500, 0); },5000);
}


//12. Validation Function
function validateForm(){

    let verifier = true;
    let attributesArray = $(".form-required")

    // 12.1 Remove the Valid/Invalid class
    $(".form-required").removeClass("is-invalid ").removeClass("is-valid ")
    $(".selectpicker").parent().removeClass("is-invalid").removeClass("is-valid ")

    // 12.2 Add The Valid class to all elements
    $(".selectpicker").add("is-valid ")

    // 12.3 Validate inputs(Empty)
    for (let i = 0; i < attributesArray.length; i++) {
        if (attributesArray[i].value === "") {
            // 12.3.1 Remove The Valid/Invalid class
            attributesArray[i].classList.remove("is-invalid")
            attributesArray[i].classList.remove("is-valid")
            // 12.3.2 Add the Invalid class
            attributesArray[i].classList.add("is-invalid")
        }
    }

    // 12.4 Change variable data to selectpickers
    attributesArray = $(".selectpicker")

    //12.5 Validate selectpickers
    for (let i = 0; i < attributesArray.length; i++) {
        if (attributesArray[i].value === "") {
            // 12.5.1 Remove The Valid/Invalid class
            attributesArray[i].classList.remove("is-invalid")
            attributesArray[i].classList.remove("is-valid")
            // 12.5.2 Add the Invalid class
            attributesArray[i].parentNode.classList.add("is-invalid")
        }
    }

    // 12.6 Validate Input(Email)

    // 12.6.1 Set the RegEx and test it
    const emailValidation = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    let emailVal = emailValidation.test($("#employer-email").val());
    // 12.6.2 Verify if it's needed to put an invalid class
    if(!emailVal){
        $("#employer-email").removeClass("is-invalid").removeClass("is-valid")
        $("#employer-email").addClass("is-invalid")
    }

    // 12.7 Validate Input(Phone)

    // 12.7.1 Set the RegEx and test it
    const phoneValidation = /^(\(?(?:0(?:0|11)\)?[\s-]?\(?|\+)(44)\)?[\s-]?)?\(?0?(?:\)[\s-]?)?([0-9]\d{7,12}\)?[\d\s-]+)((?:x|ext\.?|\#)\d{3,4})?$/;

    let phoneVal = phoneValidation.test($("#employer-phone").val());
    // 12.7.2 Verify if it's needed to put an invalid class
    if(!phoneVal){
        $("#employer-phone").removeClass("is-invalid").removeClass("is-valid")
        $("#employer-phone").addClass("is-invalid")
    }


    // 12.8 Validate Input(PostCode)

    // 12.8.1 Set the RegEx and test it
    let postCodeVal = /[a-z][a-z]\d\d\s\d[a-z][a-z]|[a-z][a-z]\d\s\d[a-z][a-z]|[a-z]\d\s\d[a-z][a-z]|[a-z][a-z]\d[a-z]\s\d[a-z][a-z]|[a-z]\d\d\s\d[a-z][a-z]/i.test($("#employer-postcode").val());
    // let postCodeVal = postCodeValidation.test($("#employer-postcode").val());
    // 12.8.2 Verify if it's needed to put an invalid class
    if(!postCodeVal){
        $("#employer-postcode").removeClass("is-invalid").removeClass("is-valid")
        $("#employer-postcode").addClass("is-invalid")
    }

    //12.9 Exception
    $('select[name=create-employer-alumni-school]').parent().removeClass("is-invalid");

    if($('div[id=div-foreign-language]').hasClass('d-none')){
        $('select[id=employer-language]').parent().removeClass("is-invalid");
    }

    //12.10 Verify if there is any invalid class
    if($(".selectpicker").parent().hasClass("is-invalid") || $(".form-required").hasClass("is-invalid")){
        verifier = false
    }

    return verifier;
}


//13. Document on Ready
$( document ).ready(function() {
    $("select[name=employer-sort-by]").change(function(){
        sortEmployerByName($(this).val(),$(this).children(":selected").attr("data-val"));
    });

    $('#filterButton').click(function(){
        filterEmployers();
    });

    // // Function classChange which is called whenever new .employer-filtered or .employer-found appears.
    // $('.employer-card').on('classChange', function() {
    //     $(".employer-card").addClass("d-none");
    //     $('.employer-filtered.employer-found').removeClass('d-none');
    // });

    $("#tooltip").hover(function(){
            $(this).tooltip('show')
        },
        function(){
            $(this).tooltip('hide')
        }
    );

    // Overwriting contains to be case insensitive, found at :
    // https://css-tricks.com/snippets/jquery/make-jquery-contains-case-insensitive/
    $.expr[":"].contains = $.expr.createPseudo(function(arg) {
        return function( elem ) {
            return $(elem).text().toUpperCase().indexOf(arg.toUpperCase()) >= 0;
        };
    });

    $('select[id=employer-preferences]').change(function(){
        if($('select[id=employer-preferences]').val()!=undefined){
            if($('select[id=employer-preferences]').val().includes("5")){
                $('div[id=div-foreign-language]').removeClass('d-none')
            }else{
                $('div[id=div-foreign-language]').addClass('d-none')
                $('select[id=employer-language]').parent().removeClass("is-invalid");
            }
        }
    });
    if( $("span[name=employer-language-checker]").text() =="Yes"){
        $('div[id=div-foreign-language]').removeClass('d-none')
    }
});

