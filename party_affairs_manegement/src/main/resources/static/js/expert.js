/**
 * Created by Administrator on 2016/8/4.
 */
// 全部专家
var name, loca,sex,currentID, flag = true;
function Expertdload() {
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
                title: "专家姓名",
                field: 'class',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '性别',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '联系方式',
                field: 'type',
                align: 'center'
            },
            {
                title: '详情地址',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '专业领域',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '备注',
                field: 'sex',
                align: 'center',
                valign: 'middle'
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
   getLoca();

}
function getData() {
    if (flag) {
        name = "";
        loca = "";
        sex="";



        flag = false;
    } else {
        name = $("#name").val();
        loca= $("#loca").val();
        sex=$("#sex").val();



    }
    $.ajax({
        type: "GET",
        url: "../WorkRecord/SearchWork?dtStart=" + name + "&dtEnd=" + loca+ "&dtEnd=" + sex,
        dataType: "json",
        success: function (result) {
            if (result.data) {
                var TableData = result.data;
                $('#table').bootstrapTable("load", TableData);
            }
        }
    })
}
//初始化类型下拉菜单
function getLoca() {
    $.ajax({
        url: '../Common/GetTaskTypeList',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var TYPEValue = data.data;
            var TYPEItem = "<Option value = " + "-1" + ">" + "全部" + "</Option>";
            $("#loca").append(TYPEItem);
            for (var i = 0; i < TYPEValue.length; i++) {
                var html = "<Option value = '" + TYPEValue[i].ID + "'>" + TYPEValue[i].NAME + "</Option>";
                $("#loca").append(html);
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
        closeBtn:1,
        area: ['80%', '98%'],
        shadeClose: true,
        closeBtn: 1,
        content: 'expert_tail01.html'
        //iframe的url
    });
}
// 共享专家
var name01, loca01,sex01,currentID01, flag01 = true;
function Expertdload01() {
    $('#table01').bootstrapTable({
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
                title: "专家姓名",
                field: 'class',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '性别',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '联系方式',
                field: 'type',
                align: 'center'
            },
            {
                title: '详情地址',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '专业领域',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '备注',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },

            {
                title: '操作',
                field: '',
                align: 'center',
                formatter: function (value, row) {
                    var e = '<button button="#" mce_href="#" onclick="del01(\'' + row.WORKRECORDID + '\')">删除</button> '
                    var d = '<button button="#" mce_href="#" onclick="edit01(\'' + row.WORKRECORDID + '\')">编辑</button> ';

                    return e + d;
                }
            }
        ]
    });
    getData01();
    getLoca01();

}
function getData01() {
    if (flag01) {
        name01 = "";
        loca01 = "";
        sex01="";



        flag01 = false;
    } else {
        name01 = $("#name01").val();
        loca01= $("#loca01").val();
        sex01=$("#sex01").val();



    }
    $.ajax({
        type: "GET",
        url: "../WorkRecord/SearchWork?dtStart=" + name01 + "&dtEnd=" + loca01+ "&dtEnd=" + sex01,
        dataType: "json",
        success: function (result) {
            if (result.data) {
                var TableData = result.data;
                $('#table01').bootstrapTable("load", TableData);
            }
        }
    })
}
//初始化类型下拉菜单
function getLoca01() {
    $.ajax({
        url: '../Common/GetTaskTypeList',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var TYPEValue = data.data;
            var TYPEItem = "<Option value = " + "-1" + ">" + "全部" + "</Option>";
            $("#loca01").append(TYPEItem);
            for (var i = 0; i < TYPEValue.length; i++) {
                var html = "<Option value = '" + TYPEValue[i].ID + "'>" + TYPEValue[i].NAME + "</Option>";
                $("#loca01").append(html);
            }
        },
        error: function (err) {
        }

    })
}


function add01() {
    openlayer01()
    currentID01 = "";
}
function edit01(id) {
    openlayer01()
    currentID01 = id;
}
function del01(id) {
    alert(id)
    var NoticeId = id;
    $.ajax({
        url: '../WorkRecord/DeleteWork?workId=' + NoticeId,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            if (data.data) {
                alert("删除成功！")
                getData01();
            } else {
                alert("删除失败")
            }
        },
        error: function (err) {
        }
    });
}
function getCurrentID01() {
    return currentID01;
}

function openlayer01(id){
    layer.open({
        type: 2,
        title: '添加信息',
        shadeClose: true,
        shade: 0.5,
        skin: 'layui-layer-rim',
//            maxmin: true,
        closeBtn:1,
        area: ['80%', '98%'],
        shadeClose: true,
        closeBtn: 1,
        content: 'expert_tail02.html'
        //iframe的url
    });
}




