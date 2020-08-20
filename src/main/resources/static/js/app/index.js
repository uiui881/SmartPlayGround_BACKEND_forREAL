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

    $('#btn-rides-save').on('click', function(){
        _this.rides_save();
    });

    $('#btn-rides-update').on('click', function(){
        _this.rides_update();
    });

    $('#btn-rides-delete').on('click', function(){
        _this.rides_delete();
    });


    $('#btn-managerInfos-save').on('click', function(){
        _this.managerInfos_save();
    });

    $('#btn-managerInfos-update').on('click', function(){
        _this.managerInfos_update();
    });

    $('#btn-managerInfos-delete').on('click', function(){
        _this.managerInfos_delete();
    });

    $('#btn-safety-save').on('click', function(){
        _this.safety_save();
    });

    $('#btn-safety-update').on('click', function(){
        _this.safety_update();
    });

    $('#btn-safety-delete').on('click', function(){
        _this.safety_delete();
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
        var playgroundId = $('#playgroundId').val();

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
    },

    rides_save : function (){
        var data ={
            rideName :$('#rideName').val(),
            id_p: $('#id_p').val(),
            rideCongestion: $('#rideCongestion').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/rides',
            dataType: 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function (){
            alert('놀이기구가 등록되었습니다.');
            window.location.href='/rides/list';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },

    rides_update : function (){

        var data ={
            rideName :$('#rideName').val(),
            id_p: $('#id_p').val(),
            rideCongestion: $('#rideCongestion').val()
        };

        var id = $('#id_r').val();
        $.ajax({
            type: 'PUT',
            url: '/api/v1/rides/'+id,
            dataType: 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function (){
            alert('놀이기구가 수정되었습니다.');
            window.location.href='/rides/list';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    rides_delete :function (){
        var id_r = $('#id_r').val();

        $.ajax({
            type :'DELETE',
            url:'/api/v1/rides/'+id_r,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function(){
            alert('놀이기구가 삭제되었습니다.');
            window.location.href ='/rides/list';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },

    managerInfos_save : function (){
        var data ={
            managerName :$('#managerName').val(),
            institution: $('#institution').val(),
            contact: $('#contact').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/managerInfos',
            dataType: 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function (){
            alert('관리자가 등록되었습니다.');
            window.location.href='/managerInfos/list';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },

    managerInfos_update : function (){

        var data ={
            managerName :$('#managerName').val(),
            institution: $('#institution').val(),
            contact: $('#contact').val()
        };

        var id = $('#managerId').val();
        $.ajax({
            type: 'PUT',
            url: '/api/v1/managerInfos/'+id,
            dataType: 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function (){
            alert('관리자 정보가 수정되었습니다.');
            window.location.href='/managerInfos/list';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    managerInfos_delete :function (){
        var id = $('#managerId').val();

        $.ajax({
            type :'DELETE',
            url: '/api/v1/managerInfos/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function(){
            alert('관리자 정보가 삭제되었습니다.');
            window.location.href='/managerInfos/list';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    safety_save : function (){
        var data ={
            id_p :$('#id_p').val(),
            questionId: $('#questionId').val(),
            checkResult:$('#checkResult').val(),
            id_MI: $('#id_MI').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/safety',
            dataType: 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function (){
            alert('안전관리 정보가 등록되었습니다.');
            window.location.href='/safety/list';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },

    safety_update : function (){

        var data ={
            id_p :$('#id_p').val(),
            questionId: $('#questionId').val(),
            checkResult: $('#checkResult').val(),
            id_MI: $('#id_MI').val()
        };

        var id = $('#id_s').val();
        $.ajax({
            type: 'PUT',
            url: '/api/v1/safety/'+id,
            dataType: 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function (){
            alert('안전관리 정보가 수정되었습니다.');
            window.location.href='/safety/list';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    safety_delete :function (){
        var id = $('#id_s').val();

        $.ajax({
            type :'DELETE',
            url: '/api/v1/safety/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function(){
            alert('안전관리 정보가 삭제되었습니다.');
            window.location.href='/safety/list';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();