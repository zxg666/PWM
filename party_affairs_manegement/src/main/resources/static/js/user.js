var name, work,order,currentID, flag = true;
function getData() {
    if (flag) {
        name = "";
        work = "";
        order="";


        flag = false;
    } else {
        name = $("#name").val();
        work= $("#work").val();
        order=$("#order").val();


    }
    $.ajax({
        type: "GET",
        url: "../WorkRecord/SearchWork?dtStart=" + name + "&dtEnd=" + work+ "&dtEnd=" + order,
        dataType: "json",
        success: function (result) {
            if (result.data) {
                var TableData = result.data;
                $('#table').bootstrapTable("load", TableData);
            }
        }
    })
}
//初始化职位下拉菜单
function getWork() {
    $.ajax({
        url: '../Common/GetTaskTypeList',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var TYPEValue = data.data;
            var TYPEItem = "<Option value = " + "-1" + ">" + "全部" + "</Option>";
            $("#work").append(TYPEItem);
            for (var i = 0; i < TYPEValue.length; i++) {
                var html = "<Option value = '" + TYPEValue[i].ID + "'>" + TYPEValue[i].NAME + "</Option>";
                $("#work").append(html);
            }
        },
        error: function (err) {
        }

    })
}
//初始化排名下拉菜单
function getWork() {
    $.ajax({
        url: '../Common/GetTaskTypeList',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var TYPEValue = data.data;
            var TYPEItem = "<Option value = " + "-1" + ">" + "全部" + "</Option>";
            $("#order").append(TYPEItem);
            for (var i = 0; i < TYPEValue.length; i++) {
                var html = "<Option value = '" + TYPEValue[i].ID + "'>" + TYPEValue[i].NAME + "</Option>";
                $("#order").append(html);
            }
        },
        error: function (err) {
        }

    })
}

function add() {
    openlayer()
    currentID = "";
}
function edit(id) {
    openlayer()
    currentID = id;
}
function del(id) {
    alert(id)
    var NoticeId = id;
    $.ajax({
        url: '../WorkRecord/DeleteWork?workId=' + NoticeId,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            if (data.data) {
                alert("删除成功！")
                getData();
            } else {
                alert("删除失败")
            }
        },
        error: function (err) {
        }
    });
}
function getCurrentID() {
    return currentID;
}
function openlayer(id){
    layer.open({
        type: 2,
        title: '添加信息',
        shadeClose: true,
        shade: 0.5,
        skin: 'layui-layer-rim',
//            maxmin: true,
        closeBtn:2,
        area: ['80%', '90%'],
        shadeClose: true,
        closeBtn: 2,
        content: 'check_tail01.html'
        //iframe的url
    });
}





