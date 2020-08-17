//1. Create Employer
function createNewEmployer() {
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
            alert("FAIL");
            alert(data.responseText);
            alert(data.toString());
        }
    });
};

//2. Update Employer
function updateThisEmployer() {
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
    $("input[name='update-employer-alumni-name']").each(function() {update_alumni_name.push($(this).val()); update_alumni_id.push($(this).attr("id"))});
    $("select[name='update-employer-alumni-school']").each(function() {update_alumni_school.push($(this).val());});

    let updateEmployerAlumniID_url = "UpdateEmployerAlumniID=" + update_alumni_id;
    let updateEmployerAlumniName_url = "UpdateEmployerAlumniName=" + update_alumni_name;
    let updateEmployerAlumniSchoolID_url = "UpdateEmployerAlumniSchoolID=" +update_alumni_school;

    if ($('input[name=update-employer-alumni-name]').attr("id")=== undefined){updateEmployerAlumniID_url = "UpdateEmployerAlumniID="}
    if ($('input[name=update-employer-alumni-name]').val() === undefined){updateEmployerAlumniName_url = "UpdateEmployerAlumniName="}
    if ($('select[name=update-employer-alumni-school]').val()=== undefined){updateEmployerAlumniSchoolID_url = "UpdateEmployerAlumniSchoolID="}

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
            alert("FAIL");
            alert(data.responseText);
            alert(data.toString());
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

function hideEmployers(ids){

    $(".employer-card").removeClass("d-none");
    $(".employer-card").addClass("d-none");


    for (i = 0; i < ids.length; i++) {
        $("#"+ids[i]).removeClass("d-none");
    }
}


//6. FilterEmployers
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

// 5. Sort Events by Name
function sortByName(){
    var list, i, switching, shouldSwitch;
    switching = true;
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // start by saying: no switching is done:
        switching = false;
        list = $('div[name=employer-card-title]')

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
            list[i].closest(".employer-card").before(list[i + 1].closest(".employer-card"));
            switching = true;
        }
    }

}

// 6. Sort Vacancy by Date
function sortByDate() {
    let list = $('input[name=employer]').val()

    // Loop through all list-items:
    for (i = 0; i < (list.length - 1); i++) {
        let listCompare1 = list[i].innerHTML.split("-");

        for (j = 0; j < (list.length - 1); j++) {
            let listCompare2 = list[j].innerHTML.split("-");

            if (listCompare1[0] < listCompare2[0]) {
                // alert(" Part 1 ---- listCompare1: " + listCompare1 + " listCompare2: " + listCompare2)
                list[i].closest(".employer-card").before(list[j].closest(".employer-card"));
            }

            if (listCompare1[0] == listCompare2[0] && listCompare1[1] < listCompare2[1]) {
                // alert("Part 2 --- listCompare1: " + listCompare1 + " listCompare2: " + listCompare2)
                list[i].closest(".employer-card").before(list[j].closest(".employer-card"));
            }
            if (listCompare1[0] == listCompare2[0] && listCompare1[1] == listCompare2[1] && listCompare1[2] < listCompare2[2]) {
                // alert("Part 3 --- listCompare1: " + listCompare1 + " listCompare2: " + listCompare2)
                list[i].closest(".employer-card").before(list[j].closest(".employer-card"));
            }

        }
    }
}

empAdded = localStorage.getItem("empAdded");

if (empAdded === "true"){
    console.log("is the object added " + empAdded)
    document.getElementById('success_message').classList.remove('d-none')
    document.getElementById('success_message').classList.add('show')
    $("#success_message").fadeTo(2000, 500).slideUp(500, function() {
        $("#success_message").slideUp(500);
    });
    localStorage.clear()
}

employerDeleted = localStorage.getItem("employerDeleted");

if (employerDeleted === "true"){
    console.log("is the object deleted " + empAdded)
    document.getElementById('success_message').innerHTML = 'The employer is deleted!'
    document.getElementById('success_message').classList.remove('d-none')
    document.getElementById('success_message').classList.add('show')
    $("#success_message").fadeTo(2000, 500).slideUp(500, function() {
        $("#success_message").slideUp(500);
    });
    localStorage.clear()
}


//7. On document Ready
$( document ).ready(function() {
    $("select[name=employer-sort-by]").change(function(){
        if($(this).val()=="Name"){
            sortByName();
        }


        if($(this).val()=="Date"){
            sortByDate();
        }

    });
});

$(document).ready(function(){
    $('#filterButton').click(function(){
        filterEmployers();
    });
});


// For the Employer Name selector
$('.selectpicker').selectpicker();
