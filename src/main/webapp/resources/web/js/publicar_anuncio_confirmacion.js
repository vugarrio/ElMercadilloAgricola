$(function() {
    
        // Publicar un anuncio
    /*$(".listing-form-steps li").on("click", function(){
            $(this).removeClass("completed");
            $(".listing-form-steps li").removeClass("active");
            $(this).addClass("active");
            $(this).prevAll().addClass("completed");
    });*/
    
    $(".listing-form-steps li").on("click", function(event){
         event.preventDefault();
    });
    
    $(".listing-form-progress .progress-bar").attr("data-appear-progress-animation","100%").width("100%");
    
    $('.listing-form-steps li:nth-child(1)').addClass("active").prevAll().addClass("completed");
    $('.listing-form-steps li:nth-child(2)').addClass("active").prevAll().addClass("completed");
    $('.listing-form-steps li:nth-child(3)').addClass("active").prevAll().addClass("completed");
    $('.listing-form-steps li:nth-child(3)').addClass("active").addClass("completed");
    
    
    
});


