const counters = document.querySelectorAll('.counter');
const speed = 150; // The lower the slower

counters.forEach(counter => {
    const updateCount = () => {
        const target = +counter.getAttribute('data-target');
        const count = +counter.innerText;

        // Lower inc to slow and higher to slow
        const inc = target / speed;

        // console.log(inc);
        // console.log(count);

        // Check if target is reached
        if (count < target) {
            // Add inc to count and output in counter
            counter.innerText = count + inc;
            // Call function every ms
            setTimeout(updateCount, 1);
        } else {
            counter.innerText = target;
        }
    };

    updateCount();
});
//Toggle Menu Burger Button
$(".js-primary-nav").click(function(){
    if($(".js-primary-nav").hasClass("nav--is-open")){
        $(".js-primary-nav").removeClass("nav--is-open")
        $(".js-main-content-area").removeClass("nav--is-open")
    }else{
        $(".js-primary-nav").addClass("nav--is-open")
        $(".js-main-content-area").addClass("nav--is-open")
    }
});