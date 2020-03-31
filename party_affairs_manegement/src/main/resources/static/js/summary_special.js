/**
 * Created by Administrator on 2016/8/4.
 */
// 加载数据
var name, currentID;
function SumMeetoad() {
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
                title: "文件编号",
                field: 'class',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '文件名称',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '提交时间',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '状态',
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
                    var d = '<button button="#" mce_href="#" onclick="down(\'' + row.WORKRECORDID + '\')">下载</button> ';

                    return e + d;
                }
            }
        ]
    });
    getData();


}
// 查询数据
function getData() {
        name = $("#name").val();

    $.ajax({
        type: "GET",
        url: "../OAWorkLog/Query",
        data: { "Title": name},
        success: function (result) {
            if (result.data) {
                var TableData = result.data;
                $('#table').bootstrapTable("load", TableData);
            }
        }
    })
}

// 删除操作
function del(id) {
    alert(id)
    var NId = id;
    $.ajax({
        url: '../WorkRecord/DeleteWork?workId=' + NId,
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
// 下载操作
function down(id) {
    alert(id)
    var NId = id;
    $.ajax({
        url: '../WorkRecord/DeleteWork?workId=' + NId,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            if (data.data) {
                alert("下载成功！")

            } else {
                alert("下载失败")
            }
        },
        error: function (err) {
        }
    });
}
function getCurrentID(id) {
    return currentID;
}





