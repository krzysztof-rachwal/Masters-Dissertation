
    //HTTP REQUEST METHODS
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