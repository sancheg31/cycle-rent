require('./signUp.scss');

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

const obj = {};

document.querySelector('.login100-form-btn').addEventListener('click', () => {
    obj.username = $('#username').val()
    obj.email = $('#email').val()
    obj.password = $('#password').val()
    obj.rePassword = $('#rePassword').val()
    console.log(obj);
    console.log(JSON.stringify(obj));
    // отправка данных формы в API
    $.ajax({
        url: "/signUp",
        type : "POST",
        contentType : 'application/json',
        data : JSON.stringify(obj),
        success : function(result) {
            result = typeof result === "string" ? JSON.parse(result || {}) : result;
            if (result.successful === "true") {
                // продукт был создан, вернуться к списку продуктов
                document.location = '/login';
            } else {
                console.log("We have some errors:", result);
                document.getElementById('errorPlace').innerText = result.username;
                document.getElementById('errorPlace').classList.remove('hide');
            }
        },
        error: function(xhr, resp, text) {
            // вывести ошибку в консоль
            console.error(xhr, resp, text);
        }
    });
})

