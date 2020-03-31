/**
 * Created by Administrator on 2016/8/4.
 */

var user, time,currentID, flag = true;
function Receive01load() {
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

                    var d = '<button button="#" mce_href="#" onclick="edit(\'' + row.WORKRECORDID + '\')">查看详情</button> ';

                    return  d;
                }
            }
        ]
    });
    getData();


}
function getData() {
    if (flag) {
        user = "";
        time = "";



        flag = false;
    } else {
        user = $("#user").val();
        time= $("#demo").val();



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
        closeBtn:2,
        area: ['80%', '90%'],
        shadeClose: true,
        closeBtn: 2,
        content: 'receive01_tail01.html'
        //iframe的url
    });
}





