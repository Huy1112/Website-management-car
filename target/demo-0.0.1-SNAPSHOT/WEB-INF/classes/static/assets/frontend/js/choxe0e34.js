// console.log($("#sl-hang-sx").val());
// console.log($("#sl-model").val());

function validate(e, t, a) {
    var l;
    return $(e).parent().find(".error_submit").remove(), "" == $(e).val() && 0 == a ? (isCheck = !1, $(e).parent().find("input,.select2,textarea").addClass("border-red"), $(e).parent().append('<p class="text-red mt5 font12 styleitalic error_submit error_mb">' + t + "</p>"), l = !0) : ($(e).parent().find("input,.select2,textarea").removeClass("border-red"), l = !1), l
}

function goToByScroll2(e, t) {
    $("html,body").animate({
        scrollTop: $(e).offset().top - t
    }, "fast")
}

function showPhoneNumner(salon_id, phone_number) {
    
    ga(ga_tracker_name + '.send', 'event', 'Tin', 'Xem thông tin liên hệ', salon_id); // KhoaNT add

    var element = document.getElementById("salon_id_" + salon_id);
    element.classList.remove("btn-show-phone-list");
    element.classList.add("btn-hide-phone-list");
    element.innerHTML = '<i class="icon-sprite-24 icon-phone"></i>' + phone_number;
}

function naturalSplit(str) {
    'use strict';
    let arr = [];
    let split = str.split(/(\d+)/);
    for (let i in split) {
        let s = split[i];
        if (s !== "") {
            if (i % 2) {
                arr.push(+s);
            } else {
                arr.push(s);
            }
        }
    }
    return arr;
}

function handleFileSelect(event) {
    // Khoa Nguyen add
    var updateUrl = window.location.href;
    var url_slpit = updateUrl.split('/');
    var p = url_slpit[url_slpit.length - 1];
    var pro_split = naturalSplit(p);
    var upload_auto_id = pro_split[1];
    // End

    var isMobile = false; //initiate as false
    if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent)
        || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4))) isMobile = true;
    // var iOS = /iPad|iPhone|iPod/.test(navigator.userAgent) && !window.MSStream;
    if (window.File && window.FileList && window.FileReader) {
        for (var e = event.target.files, t = document.getElementById("result"), a = 0; a < e.length; a++) {
            var l = e[a];
            if (l.type.match("image")) {
                var n = new FileReader;
                n.addEventListener("load", function (e) {
                    var a = e.target,
                        l = document.createElement("div");
                    if (isMobile || true) {
                        $.ajax({
                            url: '/common/ajax/upload_js/' + upload_auto_id,
                            type: 'post',
                            dataType: 'json',
                            data: {
                                img: a.result
                            },
                            success: function(response) {
                                l.className = "col-xs-12 col-sm-3 col-md-3 pmb0", l.innerHTML = '<input type="hidden" name="b64_images[]" value="' + response.logo + '" /><div class="item-anhbx" style="background:url(' + response.logo + '); background-size: cover"> <i class="icon-sprite-24 icon-xoaanh" onclick="$(this).parent().parent().remove();"></i><img src="' + a.result + '" class="visible-xs" /></div>', t.insertBefore(l, null)
                            }
                        });
                    } else {
                        l.className = "col-xs-12 col-sm-3 col-md-3 pmb0", l.innerHTML = '<div class="item-anhbx" style="background:url(' + a.result + '); background-size: cover"> <i class="icon-sprite-24 icon-xoaanh" onclick="$(this).parent().parent().remove();"></i><img src="' + a.result + '" class="visible-xs" /></div>', t.insertBefore(l, null)
                    }
                }), n.readAsDataURL(l)
            }
        }
        setTimeout(function () {
            sortable("output#result")
        }, 500)
    } else console.log("Your browser does not support File API")
}

function select_logic(e, t, a) {
    var l = [];
    $("#" + t + " option").each(function() {
        l.push({
            val: $(this).val(),
            text: $(this).text()
        })
    }), $("#" + t).data("values", JSON.stringify(l)), $("#" + e).change(function() {
        var e = JSON.parse(jQuery("#" + t).data("values")),
            l = $(this).val(),
            n = $("#" + t).val();
        $("#" + t).select2("destroy"), $("#" + t + " option").remove(), $.each(e, function(e, o) {
            var s = !1;
            s = ">=" == a ? parseInt(o.val) >= parseInt(l) : parseInt(o.val) <= parseInt(l), (!l || "" == o.val || s) && $("#" + t).append("<option value='" + o.val + "' " + (parseInt(n) == parseInt(o.val) ? 'selected="selected"' : "") + ">" + o.text + "</option>")
        }), $("#" + t).select2()
    })
}
var loadFile = function(e) {
    var t = new FileReader;
    t.onload = function() {
        var e = document.getElementById("avatar");
        e.src = t.result
    }, $("#avatar-preview").removeClass("hidden"), $("#current-avatar").addClass("hidden"), t.readAsDataURL(e.target.files[0])
};

var call_offset = 0;

jQuery(document).ready(function() {
    $("#car-filter-form .filter-bg-gray").click(function() {
        var collapse_id = $(this).find("a").attr("href");
        $(collapse_id).collapse('toggle');
    });
    $("#car-filter-form .col-filter-2").each(function() {
        if ($(this).find('.filter-content input:checked') && $(this).find('.filter-content input:checked').val()) {
            if ($(this).find('.filter-content').hasClass('collapse')) {
                var collapse_id = $(this).find("a.collapsed");
                if (collapse_id && collapse_id.attr("href")) {
                    $(collapse_id.attr("href")).collapse('toggle');
                }
            }
        }
    });
    $(".toggle-filter").click(function() {
        $(".col-left").toggleClass('hidden-xs');
        $(".col-right,.footer").toggleClass('hidden-xs');
        if (!$(".col-left").eq(1).hasClass('hidden-xs')) {
            // $(".col-left").eq(1).find('.visible-xs input, .visible-xs select').prop("disabled", "");
            $(".main-content").css({
                marginBottom: '85px'
            })
        } else {
            // $(".col-left").eq(1).find('.visible-xs input, .visible-xs select').prop("disabled", "disabled");
        }
        return false;
    });
    $(".apply-filter").click(function() {
        $("#car-filter-form").submit();
        return false;
    });
    $(".tk-nang-cao").click(function() {
        var form = $(this).parents('form');
        form.find('.more-search').toggleClass('hidden');
        return false;
    });
    function e(e, t) {
        var a = 0;
        var current_value = $("#" + t).val();
        if (!current_value && t == 'sl-model' && $("#slm").length > 0) {
            current_value = $("#slm").val();
        }
        if (!current_value && t == 'sl-model-2' && $("#slm-2").length > 0) {
            current_value = $("#slm-2").val();
        }
        if (!$("#" + e).hasClass('sl-make-mb') || $(window).width() < 768) {
            $("#auto_number").val() > 0 && (a = $("#auto_number").val()), $("#" + e).change(function (l) {
                0 != $(this).val() ? $.ajax({
                        url: "/ajax/model",
                        data: {
                            make_id: $("#" + e).val(),
                            auto_number: a
                        },
                        beforeSend: function (e) {
                            $("#" + t).prop("disabled", !0)
                        },
                        success: function (e) {
                            // $("#" + t).select2('destroy');
                            var a = '<option value="">Chọn model</option>';
                            $("#" + t).html(a);
                            var e = $.parseJSON(e);
                            $.each(e, function (e, t) {
                                a += '<option value="' + t.model_id + '" ' + (t.model_id == current_value ? 'selected="selected"' : '') + '>' + t.name + "</option>"
                            }), $("#" + t).html(a), $("#" + t).prop("disabled", !1)
                        }
                    }) : ($("#" + t).html(""), $("#" + t).prop("disabled", !0))
            })
        }
    }

    function t(e, t, a) {
        if (!$("#" + e).hasClass('sl-make-mb') || $(window).width() < 768) {
            $("#" + e + ", #" + t).change(function (l) {
                var n = 0;
                var current_value = $("#" + a).val();
                $("#auto_number").val() > 0 && (n = $("#auto_number").val()), 0 != $(this).val() ? $.ajax({
                        url: "/ajax/trim",
                        data: {
                            make_id: $("#" + e).val(),
                            model_id: $("#" + t).val(),
                            auto_number: n
                        },
                        beforeSend: function (e) {
                            $("#" + a).prop("disabled", !0)
                        },
                        success: function (e) {
                            var t = '<option value="">Chọn phiên bản</option>';
                            $("#" + a).html(t);
                            var e = $.parseJSON(e);
                            $.each(e, function (e, a) {
                                t += '<option value="' + e + '"' + (e == current_value ? 'selected="selected"' : '') + '>' + a + "</option>"
                            }), $("#" + a).html(t), $("#" + a).prop("disabled", !1)
                        }
                    }) : ($("#" + a).html(""), $("#" + a).prop("disabled", !0))
            })
        }
    }
    jQuery('input[type="text"]').focus(function() {
        jQuery(this).attr("data-placeholder", $(this).attr("placeholder")).removeAttr("placeholder")
    });
    jQuery('input[type="text"]').blur(function() {
        jQuery(this).attr("placeholder", $(this).attr("data-placeholder"))
    });
    jQuery("#chon-gallery").length > 0 && document.getElementById("chon-gallery").addEventListener("change", handleFileSelect, !1), sortable("output#result", {
        forcePlaceholderSize: !0,
        dragImage: null,
        placeholderClass: "col-xs-12 col-sm-3 col-md-3 pmb0"
    });
    select_logic("sl-from-gia", "sl-to-gia", ">=");
    select_logic("sl-to-gia", "sl-from-gia", "<=");
    select_logic("sl-from-nam", "sl-to-nam", ">=");
    select_logic("sl-to-nam", "sl-from-nam", "<=");
    select_logic("sl-from-gia-2", "sl-to-gia-2", ">=");
    select_logic("sl-to-gia-2", "sl-from-gia-2", "<=");
    select_logic("sl-from-nam-2", "sl-to-nam-2", ">=");
    select_logic("sl-to-nam-2", "sl-from-nam-2", "<=");
    $("#search-make").keyup(function() {
        var e = $(this).val(),
            t = $("#collapse1 .check-sl"),
            a = $(),
            l = new RegExp(e, "i");
        a = a.add(t.filter(function() {
            return $(this).text().match(l)
        })), a.show(), t.show(), t.not(a).hide()
    });
    $(".ver-scroll").enscroll(), $(".validate-form").submit(function() {
        var e = !0;
        return $(this).find('input[type="text"],input[type="password"],select,textarea').each(function() {
            if ("trim" != $(this).attr("name") && 0 == $(this).hasClass("skip-feild")) {
                var t = validate(this, "Vui lòng không bỏ trống mục này", 0);
                t && e && (goToByScroll2(this, 100), e = !1)
            }
        }), console.log(e), e
    });
    $("#sl-mien, #sl-mien-2, #sl-sort, #sl-chon-hx, #sl_ss, #sl_ss3").on("select2:select", function(e) {
        window.location.href = $(this).select2("val")
    });
    $("#sl-model").prop("disabled", !0), $("#sl-model-2").prop("disabled", !0), $("#_sl-model").prop("disabled", !0), $("#_sl-model2").prop("disabled", !0), $("#_sl-model3").prop("disabled", !0), $("#_sl-model4").prop("disabled", !0), $("#sl-model").prop("disabled", !0), $("#_sl-phien-ban").prop("disabled", !0), $("#_sl-phien-ban2").prop("disabled", !0), $("#_sl-phien-ban3").prop("disabled", !0), $("#_sl-phien-ban4").prop("disabled", !0), e("sl-hang-sx-mb", "sl-model-mb"), e("sl-hang-sx", "sl-model"), e("sl-hang-sx-2", "sl-model-2"), e("sl-hang-sx", "_sl-model"), e("sl-hang-sx2", "_sl-model2"), e("sl-hang-sx3", "_sl-model3"), e("sl-hang-sx4", "_sl-model4"), e("hangsx-banxe", "model-banxe"), e("hangxe-dki", "model-dki"), t("sl-hang-sx", "_sl-model", "_sl-phien-ban"), t("sl-hang-sx2", "_sl-model2", "_sl-phien-ban2"), t("sl-hang-sx3", "_sl-model3", "_sl-phien-ban3"), t("sl-hang-sx4", "_sl-model4", "_sl-phien-ban4"), t("hangsx-banxe", "model-banxe", "phienban-banxe"), t("sl-hang-sx", "sl-model", "sl-phien-ban06"), $("#input-price").mask("#.##0", {
        reverse: !0
    });
    $("#car-filter-form").submit(function() {}), $("#car-filter-form input").on("ifChecked", function(e) {
        e.preventDefault();
        if ($(window).width() >= 768) {
            $("#car-filter-form").submit();
        }
    });
    $("#car-filter-form input").on("ifUnchecked", function() {
        if ($(window).width() >= 768) {
            $("#car-filter-form").submit()
        }
    });
    $("#car-filter-form select").change(function() {
        if ($(window).width() >= 768 && !$(this).prop("disabled")) {
            if ($(this).hasClass('sl-make-mb')) {
                $(".sl-model-mb").html('<option value="">Chọn model</option>');
            }
            $("#car-filter-form").submit()
        }
    });
    $("#sl-page").change(function() {
        window.location.href = $(this).val()
    });
    $(".form-uploadfile input[type='file']").change(function() {
        $(this).parents("form").submit()
    });
    $("#show-hide").click(function() {
        var e = $(this).data("object-id"),
            t = $(this).data("object-type");
        $.ajax({
            url: "/tracking/pixel/",
            type: "get",
            data: {
                object_id: e,
                object_type: t,
                action: "view_info"
            }
        }), $(this).addClass("hidden"), $(".short-info-v").addClass("hidden"), $(".deta-info").addClass("show")
    });
    $(".call-button").bind("click", function() {
        var e = $(this).data("object-id"),
            t = $(this).data("object-type");
        $.ajax({
            url: "/tracking/pixel/",
            type: "get",
            data: {
                object_id: e,
                object_type: t,
                action: "call"
            }
        })
    });
    $(".auto_sold").on("ifChecked", function(e) {
		var sold_confirm = confirm('Bạn có chắc chắn đánh dấu xe này đã bán?');
		if (sold_confirm) {
			var t = $(this).val();
			t > 0 && $.ajax({
				url: "/ajax/auto_sold",
				data: {
					auto_id: t
				},
				beforeSend: function(e) {},
				success: function(e) {
					e = $.parseJSON(e), 1 == e.code ? ($(".item-" + t).remove(), window.location.href = e.redirect_url) : alert("Cập nhật thất bại")
				}
			});
		} else {
			var sold_input = this;
			setTimeout(function() {
				$(sold_input).iCheck("uncheck");
			}, 10);
		}
    });
    $("#resend_sms").click(function() {
        return $.ajax({
            url: "/ajax/resend_sms",
            beforeSend: function(e) {
                $("#resend_sms, .txt-resend-sms").css("opacity", "0.5");						
            },
            success: function (e) {
				e = $.parseJSON(e);
				if (1 == e.code) {
					var t = 60;
					a = setInterval(function () {
						t--;
						e = t + " giây";
						console.log(e);
						$("#resend_sms").html(e);
						if (0 == t) {
							$("#resend_sms, .txt-resend-sms").css("opacity", "1");
							$("#resend_sms").html("Gửi lại");
							clearInterval(a);
						}
					}, 1000);
				}
			}
        });
        return false;
    });
	$(".txt-resend-sms").click(function(e) {
		e.preventDefault();
		$("#resend_sms").trigger('click');
	});
    $("#salon-fillter-form input").on("ifChecked", function(e) {
        $("#salon-fillter-form").submit()
    });
    $("#salon-fillter-form input").on("ifUnchecked", function() {
        $("#salon-fillter-form").submit()
    });
    $("#salon-fillter-form select").change(function() {
        $("#salon-fillter-form").submit()
    });
    $(".favor,.save").click(function () {
        var url = jQuery(this).attr("href");
        if ($(this).hasClass('delete-favor')) {
            jQuery(this).parents('.box-xe-ythich').remove();
        }
        if ($(this).hasClass('delete-save')) {
            jQuery(this).parents('.news').remove();
        }
        $.ajax({
            url: url,
            success: function() {

            }
        });
        return false;
    });
    if (wishlist_ids) {
        jQuery.each(wishlist_ids, function(index, id) {
            jQuery(".items-" + id + ' .favor').addClass('active');
        });
    }
    if (bookmark_ids) {
        jQuery.each(bookmark_ids, function(index, id) {
            jQuery(".items-" + id + ' .save').addClass('active');
        });
    }

    $("#sl-hang-sx,#sl-hang-sx-2,#sl-hang-sx2,#sl-hang-sx3,#sl-hang-xe,#hangsx-banxe").each(function() {
        if ($(this).val() > 0) {
            $(this).trigger('change');
        }
    });

    $("#sl-model").on('change', function() {
        if ($("#slm").length > 0) {
            $("#slm").val($(this).val());
        }
    });
    $("#sl-model-2").on('change', function() {
        if ($("#slm-2").length > 0) {
            $("#slm-2").val($(this).val());
        }
    });
});

$(window).load(function() {
    if ($(".call-button").length > 0) {
        call_offset = $(".call-button").offset().top;
        $(window).scroll(function () {
            var window_width = $(window).width();
            if (window_width <= 768) {
                var window_height = $(window).height();
                var scroll_top = $(window).scrollTop();
                var call_height = $(".mb-call-button .call-button").height();
                if (scroll_top > call_offset + call_height) {
                    $(".mb-call-button .call-button").addClass('fixed');
                    $(".footer").css({paddingBottom: call_height + 10});
                    $(".mb-call-button").height(call_height);
                } else {
                    $(".mb-call-button .call-button").removeClass('fixed');
                    $(".footer").css({paddingBottom: 0});
                    $(".mb-call-button").css({height: 'auto'});
                }
            }
        });
    }
})