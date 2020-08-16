var main ={
    init : function(){
    var _this = this;

    $('#btn-save').on('click', function(){
        _this.save();
    });

    $('#btn-update').on('click',function (){
        _this.update();
    });

    $('#btn-delete').on('click',function(){
        _this.delete();
    });
    },

    save: function(){

        var data ={
            name : $('#name').val(),
            writer : $('#writer').val(),
            minLatitude : $('#minLatitude').val(),
            maxLatitude : $('#maxLatitude').val(),
            minLongitude : $('#minLongitude').val(),
            maxLongitude : $('#maxLongitude').val(),
            congestion : $('#congestion').val()
        };

        $.ajax({
            type:'POST',
            url: '/api/v1/playgrounds',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data:JSON.stringify(data)
        }).done(function(){
            alert('놀이터가 등록되었습니다.');
            window.location.href ='/playgrounds/list';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    delete :function (){
        var id = $('#playgroundId').val();

        $.ajax({
            type :'DELETE',
            url:'/api/v1/playgrounds/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function(){
            alert('놀이터가 삭제되었습니다.');
            window.location.href ='/playgrounds/list';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            name : $('#name').val(),
            congestion: $('#congestion').val(),
            minLatitude: $('#minLatitude').val(),
            maxLatitude: $('#maxLatitude').val(),
            minLongitude: $('#minLongitude').val(),
            maxLongitude: $('#maxLongitude').val(),

        };
        var playgroundId = $('#playgroundId').val()

        $.ajax({

            type: 'PUT',
            url: '/api/v1/playgrounds/'+playgroundId,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('놀이터 정보가 수정되었습니다.');
            window.location.href = '/playgrounds/list';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();