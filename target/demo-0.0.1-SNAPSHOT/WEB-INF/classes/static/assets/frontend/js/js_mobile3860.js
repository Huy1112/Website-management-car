if($(window).width()<768){$(document).ready(function(){$("#block-2nd").insertBefore("#block-1st"),$(".ss-xe-slider").hasClass("slick-initialized")||$(".ss-xe-slider").slick({dots:!1,infinite:!0,slidesToShow:1,slidesToScroll:1,rows:2,arrows:!1}),$(".ds-logo-dtac").hasClass("slick-initialized")||$(".ds-logo-dtac").slick({dots:!0,infinite:!0,slidesToShow:4,slidesToScroll:3,rows:2,arrows:!1,centerMode:!1}),$(".list-story").hasClass("slick-initialized")||$(".list-story").slick({dots:!0,infinite:!0,slidesToShow:1,slidesToScroll:1,arrows:!1}),$("#slide-phien-ban").hasClass("slick-initialized")||$("#slide-phien-ban").slick({dots:!1,infinite:!0,slidesToShow:1,slidesToScroll:1,arrows:!1}),$(".sli-tso").hasClass("slick-initialized")||$(".sli-tso").slick({dots:!1,infinite:!0,slidesToShow:1,slidesToScroll:1,arrows:!1}),$(".sl-model").prop("disabled",!0),$(".sl-hang-xe").change(function(s){0!=$(this).val()?$(".sl-model").prop("disabled",!1):0==$(this).val()&&$(".sl-model").prop("disabled",!0)});var s=$(window).width();$(".anh-nen-salon").css("width",s),$(".anh-nen-salon").css("height",.5625*s),$(window).resize(function(){var s=$(window).width();$(".anh-nen-salon").css("width",s),$(".anh-nen-salon").css("height",.5625*s)})});var $status=$(".pagingInfo"),$slickElement=$(".slider-xe-noi");$slickElement.on("init reInit afterChange",function(s,i,e,l){var n=(e?e:0)+1;$status.text(n+"/"+i.slideCount)});var height_win=$(window).height(),height_header=$(".header").height()+1,height_body=$(".main-content").height(),height_footer=$(".footer").height(),height_hl=$(".huy-loc-ft").height(),h_L=$(".huy-loc-ft");height_hl>0&&0>=height_win-height_header-height_body-height_hl&&$(".main-content").css("margin-bottom",height_hl+20)}if($(window).width()<768&&($(document).ready(function(){$(".list-opt .compare").click(function(s){s.stopPropagation(),s.preventDefault(),$(this).hasClass("ss-xe")?($(this).removeClass("ss-xe"),$(this).find("span").text("So Sánh"),$(this).parent().removeClass("ss-xe-p"),$(".box-ss-nhanh").addClass("hidden")):($(this).addClass("ss-xe"),$(this).parent().addClass("ss-xe-p"),$(this).find("span").text("Bỏ So Sánh"),$(".box-ss-nhanh").removeClass("hidden"))})}),$(".ss-header").click(function(){$(".box-ss-nhanh").hasClass("open-box")?$(".box-ss-nhanh").removeClass("open-box"):$(".box-ss-nhanh").addClass("open-box")}),$(document).on("click",".icon-xoaanh",function(){$(this).parent().parent().remove();var s=$(".box-xe-hoi").length;1>s&&$(".box-ss-nhanh").addClass("hidden")})),$(window).width()<768&&($("#slider-car-small").hasClass("slick-initialized")||$("#slider-car-small").slick({slidesToShow:3.5,slidesToScroll:1,arrows:!0,infinite:!0,nextArrow:'<div class="pointer-next"><div id="" class="slider-gallery-next"></div></div>',prevArrow:'<div class="pointer-prev"><div id="" class="slider-gallery-prev"></div></div>',speed:300}),$(document).ready(function(){$(document).ready(function(){$("select").each(function(){$(this).css("color","#898989"),$(this).change(function(){var s=$(this).val();"null"!=s?$(this).css("color","#212121"):$(this).css("color","#898989")})})})})),$(window).width()<1200&&$(window).width()>786&&($("#slider-small-gallery").slick("slickSetOption","slidesToShow","5.25"),$("#slider-small-gallery").height("379px")),$(window).resize(function(s){$(window).width()<1200&&$(window).width()>786&&($("#slider-small-gallery").slick("slickSetOption","slidesToShow","5.25"),$("#slider-small-gallery").height("379px"))}),$(window).width()<768&&($("#slider-small-gallery").hasClass("slick-initialized")||$("#slider-small-gallery").slick({slidesToShow:3.5,slidesToScroll:1,arrows:!0,infinite:0,nextArrow:'<div class="pointer-next"><div id="" class="slider-gallery-next"></div></div>',prevArrow:'<div class="pointer-prev"><div id="" class="slider-gallery-prev"></div></div>',speed:300}),$("#slider-small-salon").hasClass("slick-initialized")||$("#slider-small-salon").slick({slidesToShow:3.5,slidesToScroll:1,arrows:!0,infinite:!0,nextArrow:'<div class="pointer-next"><div id="" class="slider-gallery-next"></div></div>',prevArrow:'<div class="pointer-prev"><div id="" class="slider-gallery-prev"></div></div>',speed:300})),$(document).ready(function(){$(window).width()<678&&$(".contact-right .form-contact .btn.btn_submit").text("GỬI TIN NHẮN")}),$(".icon-xoaanh").click(function(){$(this).parent().parent().remove()}),$(document).ready(function(){$('[data-toggle="modal"]').click(function(s){var i=$(this).attr("data-target");$("#"+i).modal(show)}),$('[href="#phu_kien"]').on("shown.bs.tab",function(s){$(".dropdown_qlpk").each(function(s,i){$(i).find(".dropdown_menu").css({width:$(i).parents(".pk-ban-chay").width()+"px",left:$(i).parents(".pk-ban-chay").offset().left-$(i).offset().left+"px"})})}),$('[href="#pk_dang_ban"]').on("shown.bs.tab",function(s){$(".dropdown_qlpk").each(function(s,i){$(i).find(".dropdown_menu").css({width:$(i).parents(".pk-ban-chay").width()+"px",left:$(i).parents(".pk-ban-chay").offset().left-$(i).offset().left+"px"})})})}),$(window).width()<768){$("select").each(function(){var s=$(this).data("select2");null!=s&&$(this).select2("destroy")});var scrollTo=0;$("body").on("click",".css_a",function(){scrollTo=$(this).parent().offset().left;var s=$(".menu_dl").width();scrollTo>=s/2?$("ul.list_menu_dl").animate({scrollLeft:scrollTo}):s/2>scrollTo&&scrollTo>=s/3?$("ul.list_menu_dl").animate({scrollRight:40}):$("ul.list_menu_dl").animate({scrollLeft:0})})}