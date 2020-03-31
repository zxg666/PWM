/**
 * Created by Administrator on 2016/8/4.
 */

var time, type,currentID, flag = true;
function Rewardload() {
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
                title: '录入类型',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '奖惩对象',
                field: 'type',
                align: 'center'
            },
            {
                title: '备注',
                field: 'name',
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
   getType();

}
function getData() {
    if (flag) {
        time = "";
        type = "";



        flag = false;
    } else {
        time = $("#demo").val();
        type= $("#type").val();



    }
    $.ajax({
        type: "GET",
        url: "../WorkRecord/SearchWork?dtStart=" + time + "&dtEnd=" + type,
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
function getType() {
    $.ajax({
        url: '../Common/GetTaskTypeList',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var TYPEValue = data.data;
            var TYPEItem = "<Option value = " + "-1" + ">" + "全部" + "</Option>";
            $("#type").append(TYPEItem);
            for (var i = 0; i < TYPEValue.length; i++) {
                var html = "<Option value = '" + TYPEValue[i].ID + "'>" + TYPEValue[i].NAME + "</Option>";
                $("#type").append(html);
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
        area: ['80%', '80%'],
        shadeClose: true,
        closeBtn: 2,
        content: 'reward_tail01.html'
        //iframe的url
    });
}





