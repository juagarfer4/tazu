// Responsive Menu

var $j = jQuery.noConflict();

$j(function () {
    $j('#cssmenu').slicknav();
});

//fancybox
$j(document).ready(function () {
	$j('.fancybox').fancybox();
});
	


// Carousel
$j(document).ready(function () {
    $j("#home-projects").owlCarousel({

        navigation: true,
        slideSpeed: 300,
        paginationSpeed: 400,
        singleItem: true,
        pagination: false

        // "singleItem:true" is a shortcut for:
        // items : 1, 
        // itemsDesktop : false,
        // itemsDesktopSmall : false,
        // itemsTablet: false,
        // itemsMobile : false

    });
});

// Carousel
$j(document).ready(function () {
    $j("#home-quotes2").owlCarousel({
        autoPlay: 3000,
        items: 2,
        navigation: true,
        slideSpeed: 300,
        paginationSpeed: 400,
        pagination: false,
        itemsDesktop: [1199, 2],
        itemsDesktopSmall: [979, 2],
        itemsTablet: [768, 2],
        itemsTabletSmall: false,
        itemsMobile: [600, 1]

    });

});

// Carousel
$j(document).ready(function () {
    $j("#home-slider3").owlCarousel({
        autoPlay: 5000,
        navigation: true,
        slideSpeed: 700,
        paginationSpeed: 400,
        singleItem: true,
        pagination: false


        // "singleItem:true" is a shortcut for:
        // items : 1, 
        // itemsDesktop : false,
        // itemsDesktopSmall : false,
        // itemsTablet: false,
        // itemsMobile : false

    });
});

// Carousel
$j(document).ready(function () {
    $j("#home-projects2").owlCarousel({
        items: 3,
        navigation: true,
        slideSpeed: 300,
        paginationSpeed: 400,
        pagination: false,
        itemsDesktop: [1199, 3],
        itemsDesktopSmall: [979, 3]


    });

});

// Carousel
$j(document).ready(function () {
    $j("#home-projects3").owlCarousel({
        items: 4,
        navigation: true,
        slideSpeed: 300,
        paginationSpeed: 400,
        pagination: false,
        itemsDesktop: [1199, 4],
        itemsDesktopSmall: [979, 3],
        itemsMobile: [600, 1]

    });

});

// Carousel
$j(document).ready(function () {
    $j("#product-single-item").owlCarousel({

        navigation: false,
        slideSpeed: 300,
        paginationSpeed: 400,
        singleItem: true,
        pagination: true


        // "singleItem:true" is a shortcut for:
        // items : 1, 
        // itemsDesktop : false,
        // itemsDesktopSmall : false,
        // itemsTablet: false,
        // itemsMobile : false

    });
});

// Flexslider
$j(window).load(function () {
    $j('#home-quotes').flexslider({
        animation: "fade",
        manualControls: ".quote-paging li",
        controlNav: "true",
        start: function (slider) {
            $j('body').removeClass('loading');
        }
    });
});

// Flexslider
$j(window).load(function () {
    $j('#home-slider2').flexslider({
        animation: "slide",
        manualControls: ".home-slider2-thumbs li",
        controlNav: "true",
        directionNav: false,
        start: function (slider) {
            $j('body').removeClass('loading');
        }
    });
});

// Carousel
$j(document).ready(function () {
    $j("#post-slider").owlCarousel({
        autoPlay: 5000,
        navigation: true,
        slideSpeed: 700,
        paginationSpeed: 400,
        singleItem: true,
        pagination: false


        // "singleItem:true" is a shortcut for:
        // items : 1, 
        // itemsDesktop : false,
        // itemsDesktopSmall : false,
        // itemsTablet: false,
        // itemsMobile : false

    });
});

// Google map
$j(document).ready(function () {

    $j('#map_addresses').gMap({
        address: "40.764316,-73.976945",
        zoom: 17,
        arrowStyle: 1,
        controls: {
            panControl: true,
            zoomControl: true,
            mapTypeControl: true,
            scaleControl: false,
            streetViewControl: true,
            overviewMapControl: false
        },

        markers: [{
            address: "40.764316,-73.976945",
            html: "Awesome Street, NYC",
            popup: false,
        }]
    });
});

// Portfolio Slider
$j(document).ready(function ($) {

    $j(".p2").on('click', function () {
        $j(".p2-img").show(500);
        $j(".p1-img").hide(500);
        $j(".p3-img").hide(500);
        $j(".p4-img").hide(500);
    });

    $j(".p1").on('click', function () {
        $j(".p1-img").show(500);
        $j(".p2-img").hide(500);
        $j(".p3-img").hide(500);
        $j(".p4-img").hide(500);
    });

    $j(".p3").on('click', function () {
        $j(".p3-img").show(500);
        $j(".p1-img").hide(500);
        $j(".p2-img").hide(500);
        $j(".p4-img").hide(500);
    });
});

// Isotope
$j(window).load(function(){

	var $container = $j('#folio');

	if( $container.length )   {
	$container.isotope({
		itemSelector : '.folio-item'
	});
	

	var $optionSets = $j('#portfolio .folio-filter'),
		$optionLinks = $optionSets.find('a');
	$optionLinks.click(function(){
		var $this = $j(this);
		// don't proceed if already selected
		if ( $this.hasClass('selected') ) {
			return false;
		}
		var $optionSet = $this.parents('.folio-filter');
		$optionSet.find('.selected').removeClass('selected');
		$this.addClass('selected');
	// make option object dynamically, i.e. { filter: '.my-filter-class' }
	var options = {},
		key = $optionSet.attr('data-option-key'),
		value = $this.attr('data-option-value');
		
	// parse 'false' as false boolean
	value = value === 'false' ? false : value;
	options[ key ] = value;
		if ( key === 'layoutMode' && typeof changeLayoutMode === 'function' ) {
		changeLayoutMode( $this, options );
	} else {
		// otherwise, apply new options
		$container.isotope( options );
	}    
	return false;
	});
	}
	
});

$j(window).bind('resize', function(e){ 
	  window.RT = setTimeout(function()  {$j('#folio').isotope('reLayout'); }, 800); 
	  });
