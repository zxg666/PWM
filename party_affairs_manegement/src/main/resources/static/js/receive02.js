/**
 * Created by Administrator on 2016/8/4.
 */

var user, time,currentID, flag = true;
function Receive02load() {
    $('#table').bootstrapTable({
        method: "get",
        striped: true,
        singleSelect: false,
        dataType: "json",
        pagination: true, //分页
        pageSize: 10,
        pageNumber: 1,
        search: false, //显示搜索框
        contentType: "application/x-www-form-urlencoded",
        queryParams: null,
        columns: [

            {
                checkbox:"true",
                field: 'ID',
                align: 'center',
                valign: 'middle'
            },
            {
                title: "编号",
                field: 'class',
                align: 'center',
                valign: 'middle'
            },
            {
                title: "出单日期",
                field: 'class',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '经办人',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '来客单位',
                field: 'type',
                align: 'center'
            },

            {
                title: '备注',
                field: 'work',
                align: 'center'
            },
           
            {
                title: '操作',
                field: '',
                align: 'center',
                formatter: function (value, row) {
                    var e = '<button button="#" mce_href="#" onclick="del(\'' + row.WORKRECORDID + '\')">删除</button> '
                    var d = '<button button="#" mce_href="#" onclick="edit(\'' + row.WORKRECORDID + '\')">编辑</button> ';

                    return e + d;
                }
            }
        ]
    });
    getData();


}
function getData() {
    if (flag) {
        time = "";
        user= "";



        flag = false;
    } else {
        time = $("#demo").val();
        user= $("#user").val();



    }
    $.ajax({
        type: "GET",
        url: "../WorkRecord/SearchWork?dtStart=" + user + "&dtEnd=" + time,
        dataType: "json",
        success: function (result) {
            if (result.data) {
                var TableData = result.data;
                $('#table').bootstrapTable("load", TableData);
            }
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
function out(id) {
    alert(id)
    var NoticeId = id;
    $.ajax({
        url: '../WorkRecord/DeleteWork?workId=' + NoticeId,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            if (data.data) {
                alert("导出成功！")

            } else {
                alert("导出失败")
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
        closeBtn:1,
        area: ['98%', '98%'],
        shadeClose: true,
        closeBtn: 1,
        content: 'receive02_tail01.html'
        //iframe的url
    });
}





