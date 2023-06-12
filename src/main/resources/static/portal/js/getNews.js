let page = 0;
function getNews() {
    //let page = 0;
    $.ajax({
        type:'post',
        url:'/api/v1/news/get/all/' + page,
        success:function(result){// получаем ответ с сервера
            //$('#user').empty();
            if (page < result.totalPages){ //ограничиваем всеми загруженными страницами
                page++;
                let content = result.content;

                content.forEach((item) => {
                    var contentComment = "";
                    item.comments.forEach((comment)=> {
                        contentComment += '<div class="d-flex px-2 py-1">' +
                                                '<div>' +
                                                    '<img src="../assets/img/team-2.jpg" class="avatar avatar-sm me-3" alt="user1">' +
                                                '</div>' +
                                                '<div class="d-flex flex-column justify-content-center">' +
                                                    '<h6 class="mb-0 text-sm">' + comment.user.surname + ' ' + comment.user.name + ' ' + comment.user.middleName + ' ' + '</h6>' +
                                                    '<p class="text-xs text-secondary mb-0">' + comment.text + '</p>' +
                                                '</div>' +
                                            '</div>'
                    });
                    $('#contentNews').append(
                        '<div class="card w-80 mb-4">' +
                            '<div class="card-header pb-0">' +
                                '<img src="' + item.urlImg + '" style="width: 100%; max-height: 400px; object-fit: cover; object-position: 50% 50%" alt="news">' +
                            '</div>' +
                            '<div class="card-body pt-2">' +
                                '<h4>' + item.title +'</h4>' +
                                '<p>' + item.text +'</p>' +
                            '</div>' +
                            '<div class="card-footer">' +
                                '<h6>Все комментарии: </h6>' +
                                '<div class="max-height-200 overflow-auto mb-4">' +
                                    contentComment +
                                '</div>' +
                                '<form method="post" action="/news/comment/new/'+ item.id +'">' +
                                    '<div class="d-flex justify-content-center w-100 input-group w-95">' +
                                        '<input type="text" name="comment" class="form-control" style="border-bottom-right-radius: 0 !important; border-top-right-radius: 0 !important;" placeholder="Ваш комментарий" aria-label="Имя пользователя получателя" aria-describedby="button-addon2">' +
                                            '<button class="btn btn-outline-secondary m-0" type="submit" id="button-addon2">' +
                                                'Отправить' +
                                            '</button>' +
                                    '</div>' +
                                '</form>' +
                            '</div>' +
                        '</div>')
                })
            } else {
                document.getElementById("btn_getNews").hidden = true;
            }
        }
    })
}

function checkPosition() {
    // Нам потребуется знать высоту документа и высоту экрана:
    const height = document.getElementById("heightNews").offsetHeight;
    const screenHeight = window.innerHeight
    // Они могут отличаться: если на странице много контента,
    // высота документа будет больше высоты экрана (отсюда и скролл).
    // Записываем, сколько пикселей пользователь уже проскроллил:
    const scrolled = window.scrollY
    // Обозначим порог, по приближении к которому
    // будем вызывать какое-то действие.
    // В нашем случае — четверть экрана до конца страницы:
    const threshold = height - screenHeight / 3
    // Отслеживаем, где находится низ экрана относительно страницы:
    const position = scrolled + screenHeight

    if (position >= threshold) {
        // Если мы пересекли полосу-порог, вызываем нужное действие.
        getNews();
    }
}

window.onload = function () {
    getNews();
};
