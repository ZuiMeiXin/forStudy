var roleName = null;
var roleCode = null;
$(function(){
    roleCode=$("#roleCode");
    roleName = $("#roleName");
    saveBtn = $("#save");
    backBtn = $("#back");

    saveBtn.on("click",function(){
        if(confirm("是否确认要提交数据？")){
            $("#roleForm").submit();
        }
    });

    backBtn.on("click",function(){
        if(referer != undefined
            && null != referer
            && "" != referer
            && "null" != referer
            && referer.length > 4){
            window.location.href = referer;
        }else{
            history.back(-1);
        }
    });
});