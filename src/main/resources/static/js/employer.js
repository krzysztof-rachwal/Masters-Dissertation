//1. Create Employer
function createNewEmployer() {

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

    let baseUri = "/api/create/employer";
    let EmployerStatus_url ="StatusOfEmployerID=" + $('select[id=employer-status]').val();
    let EmployerName_url = "EmployerName=" + $('input[id=company-name]').val();
    let EmployerSummary_url = "EmployerSummary=" + $('textarea[id=company-summary]').val();
    let EmployerAddressCity_url = "EmployerAddressCity=" + $('select[id=employer-city]').val();
    let EmployerAddressStreet_url = "EmployerAddressStreet=" + $('input[id=employer-street]').val();
    let EmployerAddressNumber_url = "EmployerAddressNumber=" + $('input[id=employer-number]').val();
    let EmployerPostcode_url = "EmployerPostcode=" + $('input[id=employer-postcode]').val();
    let EmployerEmail_url = "EmployerEmail=" + $('input[id=employer-email]').val();
    let ContactPersonNameSurname_url = "ContactPersonNameSurname=" + $('input[id=contact-name]').val();
    let ContactPersonPosition_url = "ContactPersonPosition=" + $('input[id=contact-position]').val();
    let EmployerPhone_url = "EmployerPhone=" + $('input[id=employer-phone]').val();
    let EmployerWebsite_url = "EmployerWebsite=" + $('input[id=employer-website]').val();
    let EmployerTwitter_url = "EmployerTwitter=" + $('input[id=employer-twitter]').val();
    let EmployerFB_url = "EmployerFB=" + $('input[id=employer-facebook]').val();
    let NumberOfEmployeesID_url = "NumberOfEmployeesID=" + $('select[id=employer-employees-number]').val();
    let EmployerNotes_url="EmployerNotes=" + $('input[id=employer-notes]').val();
    let EmployerSectorIndustry_url = "EmployerSectorIndustry=" + $('select[id=industry-sector]').val();
    let EmployerCooperationType_url = "EmployerCooperationType=" + $('select[id=employer-cooperation-type]').val();
    let EmployerCurriculumAreas_url = "EmployerCurriculumAreas=" + $('select[id=curriculum-area]').val();
    let EmployerPreferences_url = "EmployerPreferences=" + $('select[id=employer-preferences]').val();
    let EmployerLanguage_url = "EmployerLanguage=" + $('select[id=employer-language]').val();
    let SchoolPreferences_url = "SchoolPreferences=" + $('select[id=schools-attending]').val()
    let localAuthorities_url = "LocalAuthorities=" + $('select[id=local-authorities]').val();

    let fullUri = baseUri + "?" + "&" + EmployerName_url+ "&" + EmployerStatus_url + "&" + EmployerSummary_url + "&" + EmployerAddressCity_url + "&" + EmployerAddressStreet_url + "&"
        + EmployerAddressNumber_url + "&" + EmployerPostcode_url  + "&" + EmployerEmail_url  + "&" + ContactPersonNameSurname_url + "&"
        + ContactPersonPosition_url + "&" + EmployerPhone_url+ "&" + EmployerWebsite_url + "&"  + "&" +EmployerTwitter_url +"&"
        + EmployerFB_url + "&" + NumberOfEmployeesID_url  + "&" + EmployerNotes_url + "&" + EmployerSectorIndustry_url  + "&"
        + EmployerCooperationType_url + "&" + EmployerCurriculumAreas_url + "&" + EmployerPreferences_url+ "&" + EmployerLanguage_url+ "&"
        + "&" + SchoolPreferences_url + "&"+ localAuthorities_url ;

    let token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    let header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol
    console.log(fullUri)

    $.ajax({
        type: "GET", url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data === true) {
                localStorage.setItem("empAdded","true");
                location.assign("/employers")
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

//2. Update Employer
function updateThisEmployer() {

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

    let baseUri = "/api/update/employer";
    let EmployerID_url ="EmployerID=" + $('input[id=employer-id]').val();
    let EmployerStatus_url ="StatusOfEmployerID=" + $('select[id=employer-status]').val();
    let EmployerName_url = "EmployerName=" + $('input[id=company-name]').val();
    let EmployerSummary_url = "EmployerSummary=" + $('textarea[id=company-summary]').val();
    let EmployerAddressCity_url = "EmployerAddressCity=" + $('select[id=employer-city]').val();
    let EmployerAddressStreet_url = "EmployerAddressStreet=" + $('input[id=employer-street]').val();
    let EmployerAddressNumber_url = "EmployerAddressNumber=" + $('input[id=employer-number]').val();
    let EmployerPostcode_url = "EmployerPostcode=" + $('input[id=employer-postcode]').val();
    let EmployerEmail_url = "EmployerEmail=" + $('input[id=employer-email]').val();
    let ContactPersonNameSurname_url = "ContactPersonNameSurname=" + $('input[id=contact-name]').val();
    let ContactPersonPosition_url = "ContactPersonPosition=" + $('input[id=contact-position]').val();
    let EmployerPhone_url = "EmployerPhone=" + $('input[id=employer-phone]').val();
    let EmployerWebsite_url = "EmployerWebsite=" + $('input[id=employer-website]').val();
    let EmployerTwitter_url = "EmployerTwitter=" + $('input[id=employer-twitter]').val();
    let EmployerFB_url = "EmployerFB=" + $('input[id=employer-facebook]').val();
    let NumberOfEmployeesID_url = "NumberOfEmployeesID=" + $('select[id=employer-employees-number]').val();
    let EmployerNotes_url="EmployerNotes=" + $('input[id=employer-notes]').val();
    let EmployerSectorIndustry_url = "EmployerSectorIndustry=" + $('select[id=industry-sector]').val();
    let EmployerCooperationType_url = "EmployerCooperationType=" + $('select[id=employer-cooperation-type]').val();
    let EmployerCurriculumAreas_url = "EmployerCurriculumAreas=" + $('select[id=curriculum-area]').val();
    let EmployerPreferences_url = "EmployerPreferences=" + $('select[id=employer-preferences]').val();
    let EmployerLanguage_url = "EmployerLanguage=" + $('select[id=employer-language]').val();
    let SchoolPreferences_url = "SchoolPreferences=" + $('select[id=schools-attending]').val()
    let localAuthorities_url = "LocalAuthorities=" + $('select[id=local-authorities]').val();
    let createEmployerAlumniName_url = "CreateEmployerAlumniName=" + $('input[name=create-employer-alumni-name]').val();
    let createEmployerAlumniSchoolID_url = "CreateEmployerAlumniSchoolID=" + $('select[name=create-employer-alumni-school]').val();
    if ($('select[name=create-employer-alumni-school]').val() == "" && $('input[name=create-employer-alumni-name]').val() !=""){alert("You forgot to fill the School Name of the Alumni!"); return;}
    if ($('select[name=create-employer-alumni-school]').val() != "" && $('input[name=create-employer-alumni-name]').val()==""){alert("You forgot to fill the Full Name of the Alumni!"); return;}

    let update_alumni_id = [];
    let update_alumni_name = [];
    let update_alumni_school = [];

    // Update Alumni Name and Id
    $("input[name='update-employer-alumni-name']").each(function() {
        update_alumni_name.push($(this).val());
        update_alumni_id.push($(this).attr("id"))
    });
    // Update Alumni School
    $("select[name='update-employer-alumni-school']").each(function() {
        update_alumni_school.push($(this).val());
    });

    let updateEmployerAlumniID_url = "UpdateEmployerAlumniID=" + update_alumni_id;
    let updateEmployerAlumniName_url = "UpdateEmployerAlumniName=" + update_alumni_name;
    let updateEmployerAlumniSchoolID_url = "UpdateEmployerAlumniSchoolID=" +update_alumni_school;

    if ($('input[name=update-employer-alumni-name]').attr("id")=== undefined){
        updateEmployerAlumniID_url = "UpdateEmployerAlumniID="
    }
    if ($('input[name=update-employer-alumni-name]').val() === undefined){
        updateEmployerAlumniName_url = "UpdateEmployerAlumniName="
    }
    if ($('select[name=update-employer-alumni-school]').val()=== undefined){
        updateEmployerAlumniSchoolID_url = "UpdateEmployerAlumniSchoolID="
    }

    let fullUri = baseUri + "?" + "&" + EmployerID_url + "&" + EmployerName_url+ "&" + EmployerStatus_url + "&" + EmployerSummary_url + "&" + EmployerAddressCity_url + "&" + EmployerAddressStreet_url + "&"
        + EmployerAddressNumber_url + "&" + EmployerPostcode_url  + "&" + EmployerEmail_url  + "&" + ContactPersonNameSurname_url + "&"
        + ContactPersonPosition_url + "&" + EmployerPhone_url+ "&" + EmployerWebsite_url + "&"  + "&" +EmployerTwitter_url +"&"
        + EmployerFB_url + "&" + NumberOfEmployeesID_url  + "&" + EmployerNotes_url + "&" + EmployerSectorIndustry_url  + "&"
        + EmployerCooperationType_url + "&" + EmployerCurriculumAreas_url + "&" + EmployerPreferences_url+ "&" + EmployerLanguage_url +  "&"
        + SchoolPreferences_url + "&"+ localAuthorities_url + "&" + createEmployerAlumniName_url + "&" + createEmployerAlumniSchoolID_url + "&"
        + updateEmployerAlumniName_url + "&" + updateEmployerAlumniSchoolID_url + "&" + updateEmployerAlumniID_url;

    let token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    let header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol
    console.log(fullUri)

    $.ajax({
        type: "GET", url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data === true) {
                // location.assign("/employers")
                localStorage.setItem("employerUpdated","true")
                location.reload();
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

// 3.Delete Employer
function deleteEmployer(employerId) {
    let baseUri = "/api/delete/employer";
    let employerId_url = "employerId=" + employerId;
    let fullUri = baseUri + "?" + employerId_url;

    let token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    let header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass SPring Boot's CSRF protocol


    $.ajax({
        type: "DELETE", url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data === true) {
                localStorage.setItem("employerDeleted", "true")
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


//4. Delete Alumni
function deleteAlumni(alumniID) {
    let baseUri = "/api/delete/employer/alumni";
    let alumniId_url = "alumniID=" + alumniID.val();
    let fullUri = baseUri + "?" + alumniId_url;

    let token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
    let header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol


    $.ajax({
        type: "DELETE", url: fullUri,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data === true) {
                // location.reload();
                // alumniID.closest(".alumniInfo").load();
                // alumniInfo
                alumniID.parent().parent().remove();;
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

    //4.2  If value is null exit the function
    if (val==""){
        $(".employer-card").removeClass("d-none")
    }

    //4.3 Transform the first letters in a word to uppercase
    let val2 = val.charAt(0).toUpperCase() + val.slice(1);

    //4.4 Remove class vacancy found - to restart the "search"
    $(".employer-found").removeClass("employer-found")
    $(".employer-card").removeClass("d-none")

    //4.5 Add classes for the right values
    $(".list-employers").find(".searchable:contains('"+val2+"')").closest(".employer-card").addClass("employer-found")

    //4.6 Remove the cards
    $(".list-employers").find(".searchable:not(:contains('"+val2+"'))").closest(".employer-card").addClass("d-none")

    //4.7 Show the "Right" Card
    $(".employer-found").removeClass("d-none")

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

    $(".employer-card").removeClass("d-none");
    $(".employer-card").addClass("d-none");

    for (i = 0; i < ids.length; i++) {
        $("#"+ids[i]).removeClass("d-none");
    }
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

//12. Validation Function
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

    // 11.6 Validate Input(Email)

    // 11.6.1 Set the RegEx and test it
    const emailValidation = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    let emailVal = emailValidation.test($("#employer-email").val());
    // 11.6.2 Verify if it's needed to put an invalid class
    if(!emailVal){
        $("#employer-email").removeClass("is-invalid").removeClass("is-valid")
        $("#employer-email").addClass("is-invalid")
    }

    // 11.7 Validate Input(Phone)

    // 11.7.1 Set the RegEx and test it
    const phoneValidation = /^(\(?(?:0(?:0|11)\)?[\s-]?\(?|\+)(44)\)?[\s-]?)?\(?0?(?:\)[\s-]?)?([0-9]\d{7,12}\)?[\d\s-]+)((?:x|ext\.?|\#)\d{3,4})?$/;

    let phoneVal = phoneValidation.test($("#employer-phone").val());
    // 11.7.2 Verify if it's needed to put an invalid class
    if(!phoneVal){
        $("#employer-phone").removeClass("is-invalid").removeClass("is-valid")
        $("#employer-phone").addClass("is-invalid")
    }


    // 11.8 Validate Input(PostCode)

    // 11.8.1 Set the RegEx and test it
    let postCodeVal = /[a-z][a-z]\d\d\s\d[a-z][a-z]|[a-z][a-z]\d\s\d[a-z][a-z]|[a-z]\d\s\d[a-z][a-z]|[a-z][a-z]\d[a-z]\s\d[a-z][a-z]|[a-z]\d\d\s\d[a-z][a-z]/i.test($("#employer-postcode").val());
    // let postCodeVal = postCodeValidation.test($("#employer-postcode").val());
    // 11.8.2 Verify if it's needed to put an invalid class
    if(!postCodeVal){
        $("#employer-postcode").removeClass("is-invalid").removeClass("is-valid")
        $("#employer-postcode").addClass("is-invalid")
    }

    //11.9 Exception
    $('select[name=create-employer-alumni-school]').parent().removeClass("is-invalid");
    $('select[id=employer-language]').parent().removeClass("is-invalid");

    //11.10 Verify if there is any invalid class
    if($(".selectpicker").parent().hasClass("is-invalid") || $(".form-required").hasClass("is-invalid")){
        verifier = false
    }

    return verifier;
}

//12. Document on Ready
$( document ).ready(function() {
    $("select[name=employer-sort-by]").change(function(){
        sortEmployerByName($(this).val(),$(this).children(":selected").attr("data-val"));
    });

    $('#filterButton').click(function(){
        filterEmployers();
    });

    $("#tooltip").hover(function(){
            $(this).tooltip('show')
        },
        function(){
            $(this).tooltip('hide')
        }
    );
});

