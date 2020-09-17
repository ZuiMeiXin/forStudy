//购物车
$(".car_t").click(function () {
    $(".last").show();
});


$(".ss_listBg").mouseenter(function () {
    $(".ss_list_bg").slideDown("normal");
})
$(".ss_listBg").mouseleave(function () {
    $(".ss_list_bg").slideUp("normal");
})

//左侧导航栏信息显示
$(".fj").hover(function () {
$(this).next().show()
},function () {
    $(this).next().hide()
})


//焦点图

$(".num li").mouseover(function () {
$(this).addClass("active");
$(this).siblings().removeClass("active");
})


var index=0;
function showpic(){
  if (index==3){
      index=0;
  }
    $(".num li:eq("+index+")").addClass("active");
    $(".num li:eq("+index+")").siblings().removeClass("active");
    // $(".slide_box li:eq("+index+")").siblings().removeClass("active");
    // $(".slide_box li:eq("+index+")").addClass("active");
    var $newNode=$(".slide_box li:eq(0) ").clone();
    $newNode.appendTo($(".slide_box"));
    console.log($(".slide_box li:eq(0)").html())
    // console.log(index)
    $(".slide_box li:eq(0) ").remove();
    $(".slide_box li").fadeOut("10");
    $(".slide_box li").fadeIn("10");
    // $(".slide_box li:eq("+index+") ").fadeOut();
    // console.log($(".slide_box li:eq("+index+")").html())
    index++;
    console.log(index)

}

//快讯轮播
$(function () {
     setInterval("showpic()",2000);
     var marginTop= $("#express").children("li").first().css("margin-top")
    marginTop=marginTop.substring(0,marginTop.length-2)
    var interval=setInterval(function(){
        $("#express").children("li").first().animate(
            {"margin-top":marginTop--},0,
            function(){
                var $first=$(this);
                if(!$first.is(":animated")){
                    if((-marginTop)>$first.height()){
                        $first.css({"margin-top":0}).appendTo($("#express"));
                        marginTop=0;
                    }
                }
            });
    },50);
})














