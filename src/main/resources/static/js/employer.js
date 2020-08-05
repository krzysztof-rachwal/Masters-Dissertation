//1. Create Employer
function createNewEmployer() {
    var baseUri = "/api/create/employer";
    var EmployerStatus_url ="StatusOfEmployerID=" + $('select[id=employer-status]').val();
    var EmployerName_url = "EmployerName=" + $('input[id=company-name]').val();
    var EmployerSummary_url = "EmployerSummary=" + $('textarea[id=company-summary]').val();
    var EmployerAddressCity_url = "EmployerAddressCity=" + $('select[id=employer-city]').val();
    var EmployerAddressStreet_url = "EmployerAddressStreet=" + $('input[id=employer-street]').val();
    var EmployerAddressNumber_url = "EmployerAddressNumber=" + $('input[id=employer-number]').val();
    var EmployerPostcode_url = "EmployerPostcode=" + $('input[id=employer-postcode]').val();
    var EmployerEmail_url = "EmployerEmail=" + $('input[id=employer-email]').val();
    var ContactPersonNameSurname_url = "ContactPersonNameSurname=" + $('input[id=contact-name]').val();
    var ContactPersonPosition_url = "ContactPersonPosition=" + $('input[id=contact-position]').val();
    var EmployerPhone_url = "EmployerPhone=" + $('input[id=employer-phone]').val();
    var EmployerWebsite_url = "EmployerWebsite=" + $('input[id=employer-website]').val();
    var EmployerTwitter_url = "EmployerTwitter=" + $('input[id=employer-twitter]').val();
    var EmployerFB_url = "EmployerFB=" + $('input[id=employer-facebook]').val();
    var NumberOfEmployeesID_url = "NumberOfEmployeesID=" + $('select[id=employer-employees-number]').val();
    var EmployerNotes_url="EmployerNotes=" + $('input[id=employer-notes]').val();
    var EmployerSectorIndustry_url = "EmployerSectorIndustry=" + $('select[id=industry-sector]').val();
    var EmployerCooperationType_url = "EmployerCooperationType=" + $('select[id=employer-cooperation-type]').val();
    var EmployerCurriculumAreas_url = "EmployerCurriculumAreas=" + $('select[id=curriculum-area]').val();
    var EmployerPreferences_url = "EmployerPreferences=" + $('select[id=employer-preferences]').val();
    var EmployerLanguage_url = "EmployerLanguage=" + $('select[id=employer-language]').val();
    var SchoolPreferences_url = "SchoolPreferences=" + $('select[id=schools-attending]').val()
    var localAuthorities_url = "LocalAuthorities=" + $('select[id=local-authorities]').val();


    var fullUri = baseUri + "?" + "&" + EmployerName_url+ "&" + EmployerStatus_url + "&" + EmployerSummary_url + "&" + EmployerAddressCity_url + "&" + EmployerAddressStreet_url + "&"
        + EmployerAddressNumber_url + "&" + EmployerPostcode_url  + "&" + EmployerEmail_url  + "&" + ContactPersonNameSurname_url + "&"
        + ContactPersonPosition_url + "&" + EmployerPhone_url+ "&" + EmployerWebsite_url + "&"  + "&" +EmployerTwitter_url +"&"
        + EmployerFB_url + "&" + NumberOfEmployeesID_url  + "&" + EmployerNotes_url + "&" + EmployerSectorIndustry_url  + "&"
        + EmployerCooperationType_url + "&" + EmployerCurriculumAreas_url + "&" + EmployerPreferences_url+ "&" + EmployerLanguage_url+ "&"
        + "&" + SchoolPreferences_url + "&"+ localAuthorities_url ;

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
            alert(data.toString());
        }
    });

};

//2. Update Employer
function updateThisEmployer() {
    var baseUri = "/api/update/employer";
    var EmployerID_url ="EmployerID=" + $('input[id=employer-id]').val();
    var EmployerStatus_url ="StatusOfEmployerID=" + $('select[id=employer-status]').val();
    var EmployerName_url = "EmployerName=" + $('input[id=company-name]').val();
    var EmployerSummary_url = "EmployerSummary=" + $('textarea[id=company-summary]').val();
    var EmployerAddressCity_url = "EmployerAddressCity=" + $('select[id=employer-city]').val();
    var EmployerAddressStreet_url = "EmployerAddressStreet=" + $('input[id=employer-street]').val();
    var EmployerAddressNumber_url = "EmployerAddressNumber=" + $('input[id=employer-number]').val();
    var EmployerPostcode_url = "EmployerPostcode=" + $('input[id=employer-postcode]').val();
    var EmployerEmail_url = "EmployerEmail=" + $('input[id=employer-email]').val();
    var ContactPersonNameSurname_url = "ContactPersonNameSurname=" + $('input[id=contact-name]').val();
    var ContactPersonPosition_url = "ContactPersonPosition=" + $('input[id=contact-position]').val();
    var EmployerPhone_url = "EmployerPhone=" + $('input[id=employer-phone]').val();
    var EmployerWebsite_url = "EmployerWebsite=" + $('input[id=employer-website]').val();
    var EmployerTwitter_url = "EmployerTwitter=" + $('input[id=employer-twitter]').val();
    var EmployerFB_url = "EmployerFB=" + $('input[id=employer-facebook]').val();
    var NumberOfEmployeesID_url = "NumberOfEmployeesID=" + $('select[id=employer-employees-number]').val();
    var EmployerNotes_url="EmployerNotes=" + $('input[id=employer-notes]').val();
    var EmployerSectorIndustry_url = "EmployerSectorIndustry=" + $('select[id=industry-sector]').val();
    var EmployerCooperationType_url = "EmployerCooperationType=" + $('select[id=employer-cooperation-type]').val();
    var EmployerCurriculumAreas_url = "EmployerCurriculumAreas=" + $('select[id=curriculum-area]').val();
    var EmployerPreferences_url = "EmployerPreferences=" + $('select[id=employer-preferences]').val();
    var EmployerLanguage_url = "EmployerLanguage=" + $('select[id=employer-language]').val();
    var SchoolPreferences_url = "SchoolPreferences=" + $('select[id=schools-attending]').val()
    var localAuthorities_url = "LocalAuthorities=" + $('select[id=local-authorities]').val();
    var createEmployerAlumniName_url = "CreateEmployerAlumniName=" + $('input[name=create-employer-alumni-name]').val();
    var createEmployerAlumniSchoolID_url = "CreateEmployerAlumniSchoolID=" + $('select[name=create-employer-alumni-school]').val();
    if ($('select[name=create-employer-alumni-school]').val() == "" && $('input[name=create-employer-alumni-name]').val() !=""){alert("You forgot to fill the School Name of the Alumni!"); return;}
    if ($('select[name=create-employer-alumni-school]').val() != "" && $('input[name=create-employer-alumni-name]').val()==""){alert("You forgot to fill the Full Name of the Alumni!"); return;}

    var update_alumni_id = [];
    var update_alumni_name = [];
    var update_alumni_school = [];
    $("input[name='update-employer-alumni-name']").each(function() {update_alumni_name.push($(this).val()); update_alumni_id.push($(this).attr("id"))});
    $("select[name='update-employer-alumni-school']").each(function() {update_alumni_school.push($(this).val());});

    var updateEmployerAlumniID_url = "UpdateEmployerAlumniID=" + update_alumni_id;
    var updateEmployerAlumniName_url = "UpdateEmployerAlumniName=" + update_alumni_name;
    var updateEmployerAlumniSchoolID_url = "UpdateEmployerAlumniSchoolID=" +update_alumni_school;

    if ($('input[name=update-employer-alumni-name]').attr("id")=== undefined){updateEmployerAlumniID_url = "UpdateEmployerAlumniID="}
    if ($('input[name=update-employer-alumni-name]').val() === undefined){updateEmployerAlumniName_url = "UpdateEmployerAlumniName="}
    if ($('select[name=update-employer-alumni-school]').val()=== undefined){updateEmployerAlumniSchoolID_url = "UpdateEmployerAlumniSchoolID="}

    var fullUri = baseUri + "?" + "&" + EmployerID_url + "&" + EmployerName_url+ "&" + EmployerStatus_url + "&" + EmployerSummary_url + "&" + EmployerAddressCity_url + "&" + EmployerAddressStreet_url + "&"
        + EmployerAddressNumber_url + "&" + EmployerPostcode_url  + "&" + EmployerEmail_url  + "&" + ContactPersonNameSurname_url + "&"
        + ContactPersonPosition_url + "&" + EmployerPhone_url+ "&" + EmployerWebsite_url + "&"  + "&" +EmployerTwitter_url +"&"
        + EmployerFB_url + "&" + NumberOfEmployeesID_url  + "&" + EmployerNotes_url + "&" + EmployerSectorIndustry_url  + "&"
        + EmployerCooperationType_url + "&" + EmployerCurriculumAreas_url + "&" + EmployerPreferences_url+ "&" + EmployerLanguage_url +  "&"
        + SchoolPreferences_url + "&"+ localAuthorities_url + "&" + createEmployerAlumniName_url + "&" + createEmployerAlumniSchoolID_url + "&"
        + updateEmployerAlumniName_url + "&" + updateEmployerAlumniSchoolID_url + "&" + updateEmployerAlumniID_url;

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
                // location.assign("/employers")
                location.reload();
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

// 3.Delete Employer
function deleteEmployer(employerId) {
    var baseUri = "/api/delete/employer";
    var employerId_url = "employerId=" + employerId;
    var fullUri = baseUri + "?" + employerId_url;

    var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
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


    //4. Delete Alumni

    function deleteAlumni(alumniID) {
        var baseUri = "/api/delete/employer/alumni";
        var alumniId_url = "alumniID=" + alumniID.val();
        var fullUri = baseUri + "?" + alumniId_url;

        var token = $("meta[name='_csrf']").attr("content");    // Used to bypass Spring Boot's CSRF protocol     -- Solution taken from 'https://stackoverflow.com/questions/34747437/use-of-spring-csrf-with-ajax-rest-call-and-html-page-with-thymeleaf' on Nov 26th 2019
        var header = $("meta[name='_csrf_header']").attr("content");    // Used to bypass Spring Boot's CSRF protocol


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
