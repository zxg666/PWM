var userName,organization,flag = true;
function getData() {
    userName = $("#userName").val();
    organization = $("#organization").val();
    alert(userName);
    alert(organization);
    $.ajax({
        type: "GET",
        url: "/user/userList",
        data:{"userName":userName,"organization":organization},
        dataType: "json",
        success: function (result) {
            alert(result);
        }
    })
}
function edit(id) {
    openlayer()
    currentID = id;
}
function del(id) {
    alert(id)
    var NoticeId = id;
    $.ajax({
        url: '../user/delete?userId=' + NoticeId,
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