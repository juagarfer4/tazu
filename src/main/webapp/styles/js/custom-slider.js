// Slider
jQuery(document).ready(function () {
	window.slider= jQuery("#carousel").parent().html();
    var carousel = jQuery("#carousel").waterwheelCarousel({
        flankingItems: 2,
        movingToCenter: function ($item) {
            jQuery('#callback-output').prepend('movingToCenter: ' + $item.attr('id') + '<br/>');
        },
        movedToCenter: function ($item) {
            jQuery('#callback-output').prepend('movedToCenter: ' + $item.attr('id') + '<br/>');
        },
        movingFromCenter: function ($item) {
            jQuery('#callback-output').prepend('movingFromCenter: ' + $item.attr('id') + '<br/>');
        },
        movedFromCenter: function ($item) {
            jQuery('#callback-output').prepend('movedFromCenter: ' + $item.attr('id') + '<br/>');
        },
        clickedCenter: function ($item) {
            jQuery('#callback-output').prepend('clickedCenter: ' + $item.attr('id') + '<br/>');
        }
    });

    jQuery('#s-prev').bind('click', function () {
        carousel.prev();
        return false
    });

    jQuery('#s-next').bind('click', function () {
        carousel.next();
        return false;
    });

});

// Slider
jQuery(document).ready(function () {
	window.slider1= jQuery("#carousel1").parent().html();
    var carousel = jQuery("#carousel1").waterwheelCarousel({
        flankingItems: 1,
        // number tweeks to change apperance
        startingItem: 1, // item to place in the center of the carousel. Set to 0 for auto
        separation: 380, // distance between items in carousel
        separationMultiplier: 0.82, // multipled by separation distance to increase/decrease distance for each additional item
        horizonOffset: 0, // offset each item from the "horizon" by this amount (causes arching)
        horizonOffsetMultiplier: 1, // multipled by horizon offset to increase/decrease offset for each additional item
        sizeMultiplier: 0.75, // determines how drastically the size of each item changes
        opacityMultiplier: 1, // determines how drastically the opacity of each item changes
        horizon: 0, // how "far in" the horizontal/vertical horizon should be set from the container wall. 0 for auto

        movingToCenter: function ($item) {
            jQuery('#callback-output').prepend('movingToCenter: ' + $item.attr('id') + '<br/>');
        },
        movedToCenter: function ($item) {
            jQuery('#callback-output').prepend('movedToCenter: ' + $item.attr('id') + '<br/>');
        },
        movingFromCenter: function ($item) {
            jQuery('#callback-output').prepend('movingFromCenter: ' + $item.attr('id') + '<br/>');
        },
        movedFromCenter: function ($item) {
            jQuery('#callback-output').prepend('movedFromCenter: ' + $item.attr('id') + '<br/>');
        },
        clickedCenter: function ($item) {
            jQuery('#callback-output').prepend('clickedCenter: ' + $item.attr('id') + '<br/>');
        }
    });

    jQuery('#s-prev1').bind('click', function () {
        carousel.prev();
        return false
    });

    jQuery('#s-next1').bind('click', function () {
        carousel.next();
        return false;
    });
});


jQuery(window).bind('resize', function(e)
{ 
	//refresh carousel 
if( jQuery('#carousel').length )    {
  if (window.RT) clearTimeout(window.RT);
  window.RT = setTimeout(function(){
	var slider_parent=jQuery("#carousel").parent();
	jQuery("#carousel").next().remove();
	jQuery("#carousel").remove();
	slider_parent.append(window.slider);
   
    var carousel = jQuery("#carousel").waterwheelCarousel({
        flankingItems: 2,
        movingToCenter: function ($item) {
            jQuery('#callback-output').prepend('movingToCenter: ' + $item.attr('id') + '<br/>');
        },
        movedToCenter: function ($item) {
            jQuery('#callback-output').prepend('movedToCenter: ' + $item.attr('id') + '<br/>');
        },
        movingFromCenter: function ($item) {
            jQuery('#callback-output').prepend('movingFromCenter: ' + $item.attr('id') + '<br/>');
        },
        movedFromCenter: function ($item) {
            jQuery('#callback-output').prepend('movedFromCenter: ' + $item.attr('id') + '<br/>');
        },
        clickedCenter: function ($item) {
            jQuery('#callback-output').prepend('clickedCenter: ' + $item.attr('id') + '<br/>');
        }
    });

    jQuery('#s-prev').bind('click', function () {
        carousel.prev();
        return false
    });

    jQuery('#s-next').bind('click', function () {
        carousel.next();
        return false;
    });


  }, 100);
 }
	//refresh carousel 1  
  if( jQuery('#carousel1').length )  {
  if (window.RT) clearTimeout(window.RT);
  window.RT = setTimeout(function()
  {
   var slider_parent=jQuery("#carousel1").parent();
	jQuery("#carousel1").next().remove();
	jQuery("#carousel1").remove();
	slider_parent.append(window.slider1);
   
   var carousel = jQuery("#carousel1").waterwheelCarousel({
        flankingItems: 1,
        // number tweeks to change apperance
        startingItem: 1, // item to place in the center of the carousel. Set to 0 for auto
        separation: 380, // distance between items in carousel
        separationMultiplier: 0.82, // multipled by separation distance to increase/decrease distance for each additional item
        horizonOffset: 0, // offset each item from the "horizon" by this amount (causes arching)
        horizonOffsetMultiplier: 1, // multipled by horizon offset to increase/decrease offset for each additional item
        sizeMultiplier: 0.75, // determines how drastically the size of each item changes
        opacityMultiplier: 1, // determines how drastically the opacity of each item changes
        horizon: 0, // how "far in" the horizontal/vertical horizon should be set from the container wall. 0 for auto

        movingToCenter: function ($item) {
            jQuery('#callback-output').prepend('movingToCenter: ' + $item.attr('id') + '<br/>');
        },
        movedToCenter: function ($item) {
            jQuery('#callback-output').prepend('movedToCenter: ' + $item.attr('id') + '<br/>');
        },
        movingFromCenter: function ($item) {
            jQuery('#callback-output').prepend('movingFromCenter: ' + $item.attr('id') + '<br/>');
        },
        movedFromCenter: function ($item) {
            jQuery('#callback-output').prepend('movedFromCenter: ' + $item.attr('id') + '<br/>');
        },
        clickedCenter: function ($item) {
            jQuery('#callback-output').prepend('clickedCenter: ' + $item.attr('id') + '<br/>');
        }
    });

    jQuery('#s-prev1').bind('click', function () {
        carousel.prev();
        return false
    });

    jQuery('#s-next1').bind('click', function () {
        carousel.next();
        return false;
    });
     
  }, 100);
  }
});

