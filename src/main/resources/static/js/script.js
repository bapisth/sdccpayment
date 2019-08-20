  // ------- WOW ANIMATED ------ //
  wow = new WOW(
  {
    mobile: false
  });
  wow.init();// JavaScript Document
  // end wow


  $("document").ready(
        function(){
        	 
        	 $("#whats-new-btn").click(
                 function(){
                 	$("#whats-new-btn").hide();
                 	$("#whats-new-content").show();
                 }
        	 	);

             $(".whats-new-close-btn").click(
                   function(){
                      $("#whats-new-btn").show();
                 	$("#whats-new-content").hide(); 	
                   }
             	);


            


           $("#per-new-btn").click(
                 function(){
                     $(".main-interest-rate-content").toggle(1000);
                 }
            );
			
			$(".nav-tabs").children().mouseenter(
			     function(){
				     $(this)
				 }
			);
			
			 
			   
  
          /* $("#close-main-right-fix").click(
                 function(){
                     $(".main-interest-rate-content").hide(1000);
                 }
            );
           */

           
       
          
          /* stop on top  */
             
             
			       
             if($(window).width() >= 1100){
             
			 
			 
			 
			 
			 
			 
			     
               $(window).scroll(function () {
                      if ($(window).scrollTop() > 170) {
                         $(".navbar-custom").removeClass("relative");
                    $(".navbar-custom").addClass("fixed");
                     $(".navbar-custom").addClass("top-m-margine"); 
                   $("nav").addClass("bottom-menu-card");    
                   
             
			        if (navigator.userAgent.toLowerCase().indexOf('firefox') !== -1) {
			  $(".navbar-custom").removeClass("relative");
                    $(".navbar-custom").addClass("fixed");
                     $(".navbar-custom").addClass("top-m-margine-mz"); 
                   $("nav").addClass("bottom-menu-card");
			 
			 }
			
			 
			 
			    }
				
			
				
				
                  else
                {
                  $(".navbar-custom").addClass("relative");
                   $(".navbar-custom").removeClass("fixed");
                   $(".navbar-custom").removeClass("top-m-margine");
                   $("nav").removeClass("bottom-menu-card");  
				   
				   
				   if (navigator.userAgent.toLowerCase().indexOf('firefox') !== -1) {
				    $(".navbar-custom").addClass("relative");
                   $(".navbar-custom").removeClass("fixed");
                   $(".navbar-custom").removeClass("top-m-margine-mz");
                   $("nav").removeClass("bottom-menu-card");  
				   
				   }
				   
                } 

             
			 
			 
			 
			 
			 
			 
			      });
            
             }
             
			 
			 
			 $("#sbtn").click(
			    function(){
				    $(".globel-sidebaar-container").toggle();
				}
			);
			
			 
			
			
            
           
           
          /* end stop on top  */





  	});





