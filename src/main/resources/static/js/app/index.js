var main ={
    init : function(){
    var _this = this;
    $('#btn-save').on('click', function(){
        _this.save();
    });
    },

    save: function(){

        var data ={
            name : $('#name').val(),
            writer : $('#writer').val(),
            minLatitude : $('minLatitude').val(),
            maxLatitude : $('maxLatitude').val(),
            minLongitude : $('minLongitude').val(),
            maxLongitude : $('maxLongitude').val(),
            congestion : $('congestion').val()
        };

        $.ajax({
            type:'POST',
            url: '/api/v1/playgrounds',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data:JSON.stringify(data)
        }).done(function(){
            alert('놀이터가 등록되었습니다.');
            window.location.href ='/main';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();