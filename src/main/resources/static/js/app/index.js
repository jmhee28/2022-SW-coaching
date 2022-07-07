var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
        $('#btn-addviewcnt').on('click', function () {
            _this.addviewcnt();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            id: $('#id').val(),
            contents: $('#contents').val()
        };

        $.ajax({
            type: 'POST',
            url: '/savePosts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('Registered!.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#contents').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/updatePosts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    addviewcnt : function ()
    {
        var id  = $('#id').val();
        $.ajax({
            type: 'PUT',
            url: '/addViewCount/'+id,

        })

    }

};

main.init();