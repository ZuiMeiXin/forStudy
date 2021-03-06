var roleObj;

//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)
function deleteRole(obj) {
    $.ajax({
        type: "GET",
        url: path + "/role/delrole",
        data: {id: obj.attr("roleid")},
        dataType: "json",
        success: function (data) {
            if (data.delResult == "true") {//删除成功：移除删除行
                cancleBtn();
                obj.parents("tr").remove();
            } else if (data.delResult == "false") {//删除失败
                changeDLGContent("对不起，删除用户【" + obj.attr("rolename") + "】失败");
            } else if (data.delResult == "notexist") {
                changeDLGContent("对不起，用户【" + obj.attr("rolename") + "】不存在");
            }
        },
        error: function (data) {
            changeDLGContent("对不起，删除失败");
        }
    });
}

function openYesOrNoDLG() {
    $('.zhezhao').css('display', 'block');
    $('#removeUse').fadeIn();
}

function cancleBtn() {
    $('.zhezhao').css('display', 'none');
    $('#removeUse').fadeOut();
}

function changeDLGContent(contentStr) {
    var p = $(".removeMain").find("p");
    p.html(contentStr);
}

$(function () {
    $(".viewRole").on("click", function () {
        //将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
        var obj = $(this);
        $.ajax({
            url: path + "/role/view",
            type: "get",
            data: {id: obj.attr("roleid")},
            dataType: "json",
            success: function (data) {
                if (data == "null") {
                    alert("数据不存在");
                } else {
                    $(".providerView #roleCode").html(data.roleCode);
                    $(".providerView #roleName").html(data.roleName);
                }
            }
        })
    });


    $(".modifyRole").on("click", function () {
        var obj = $(this);
        window.location.href = path + "/role/tomodify.html?id=" + obj.attr("roleid");
    });

    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        deleteRole(roleObj);
    });

    $(".deleteRole").on("click", function () {
        roleObj = $(this);
        changeDLGContent("你确定要删除用户【" + roleObj.attr("rolename") + "】吗？");
        openYesOrNoDLG();
    });


});