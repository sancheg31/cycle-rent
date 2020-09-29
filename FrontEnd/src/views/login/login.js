require('./login.scss');

// import 'bootstrap';

// import 'bootstrap/js/src/alert';
// import 'bootstrap/js/src/button';
// import 'bootstrap/js/src/carousel';
import 'bootstrap/js/src/collapse';
// import 'bootstrap/js/src/dropdown';
// import 'bootstrap/js/src/modal';
// import 'bootstrap/js/src/popover';
// import 'bootstrap/js/src/scrollspy';
// import 'bootstrap/js/src/tab';
// import 'bootstrap/js/src/toast';
// import 'bootstrap/js/src/tooltip';
// import 'bootstrap/js/src/util';

(function ($) {
    "use strict";

    let input = $('.validate-input .input100');

    $('.validate-form').on('submit', function () {
        let check = true;
        for (let i = 0; i < input.length; i++) {
            if (validate(input[i]) === false) {
                showValidate(input[i]);
                check = false;
            }
        }
        return check;
    });


    $('.validate-form .input100').each(function () {
        $(this).focus(function () {
            hideValidate(this);
        });
    });

    function validate(inputData) {
        if ($(inputData).attr('type') === 'email' || $(inputData).attr('name') === 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        } else {
            if ($(inputData).val().trim() === '') {
                return false;
            }
        }
    }

    function showValidate(inputData) {
        let thisAlert = $(inputData).parent();
        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(inputData) {
        let thisAlert = $(inputData).parent();
        $(thisAlert).removeClass('alert-validate');
    }
})(jQuery);
