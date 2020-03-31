/**
 * Created by Administrator on 2016/8/4.
 */

var tit, unit, currentID, time, flag = true;
function Documentload() {
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
                title: "文件字号",
                field: 'class',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '主题',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '来文单位',
                field: 'type',
                align: 'center'
            },
            {
                title: '来文时间',
                field: 'name',
                align: 'center',
                valign: 'middle'
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
                    var d = '<button button="#" mce_href="#" onclick="edit(\'' + row.WORKRECORDID + '\')">办理</button> ';
                    return e + d;
                }
            }
        ]
    });
    getTableData();
}
function getTableData() {
    if (flag) {
        tit = "";
        unit= "";
        time = "";
        flag = false;
    } else {
        tit = $("#tit").val();
         unit= $("#unit").val();
        time = $("#demo").val();
    }
    $.ajax({
        type: "GET",
        url: "../WorkRecord/SearchWork?dtStart=" + tit + "&dtEnd=" + unit + "&dtEnd=" +time,
        dataType: "json",
        success: function (result) {
            if (result.data) {
                var LeaveTableData = result.data;
                $('#table').bootstrapTable("load", LeaveTableData);
            }
        }
    })
}
//初始化状态下拉菜单
// function getType() {
//     $.ajax({
//         url: '../Common/GetPhaseList',
//         type: 'GET',
//         dataType: 'json',
//         success: function (data) {
//             var PHASEValue = data.data;
//             if (PHASEValue.length > 0) {
//                 $("#part").html("");
//                 for (var i = 0; i < PHASEValue.length; i++) {
//                     if (TASKPHASE == PHASEValue[i].ID) {
//                         var html = "<Option value = '" + PHASEValue[i].ID + "'  selected = 'true'>" + PHASEValue[i].NAME + "</Option>";
//                     } else {
//                         var html = "<Option value = '" + PHASEValue[i].ID + "'>" + PHASEValue[i].NAME + "</Option>";
//                     };
//                     $("#part").append(html);
//                 }
//             }
//
//
//         },
//         error: function (err) {
//         }
//
//     })
// }
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
    var Id = id;
    $.ajax({
        url: '../WorkRecord/DeleteWork?workId=' + Id,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            if (data.data) {
                alert("删除成功！")
                getTableData();
            } else {
                alert("删除失败")
            }
        },
        error: function (err) {
        }
    });
}
function out(id) {
    alert(id)
    var Id = id;
    $.ajax({
        url: '../WorkRecord/DeleteWork?workId=' + Id,
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
        content: 'document_tail.html'
        //iframe的url
    });
}





