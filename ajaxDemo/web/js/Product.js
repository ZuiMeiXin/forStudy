$(function () {
    totals();
    total2();
    shoptotal();
})

function totals() {
    var num = $(".n_ipt").val();
    var price = $(".des_price b").html();
    var total = $(".des_price span").html();
    price = price.substring(1, price.length);
    total = total.substring(1, total.length);
    total = parseInt(price) * num;
    $(".des_price span").html("￥" + total)
}

//购物车显示
$(".car_t").click(function () {
    console.log("yes")
    $(".last").show();
});
//尺码和颜色选择
$("#choice1 ul li,#choice2 ul li").click(function () {
    $(this).addClass("checked");
    $(this).siblings().removeClass("checked")
})
//商品数量加减
$(".n_btn_2").click(function () {
    var num = $(".n_ipt").val();
    if (num == 1) {
        alert("不能再减了！");
    } else {
        num--;
        $(".n_ipt").val(num)
    }
    totals();
})

$(".n_btn_1").click(function () {
    var vals = document.getElementsByClassName("n_ipt")[0];
    console.log(vals)
    var num = $(".n_ipt").val();
    num++;
    $(".n_ipt").val(num);
    totals();
})

//推荐搭配
function total2() {
    var price = $(".checkbox input:checked").parent().next();
    // var total = $(".team_sum span").html();
    // total = total.substring(1, total.length);
    total = 0;
    for (let i = 0; i < price.length; i++) {
        var temp = $(".checkbox input:checked").parent().next()[i];
        price[i] = temp.innerHTML;
        price[i] = price[i].substring(1, temp.length);
        total += parseInt(price[i]);
    }
    $(".team_sum span").html("￥" + total);
    $(".sum_ipt").val(price.length);
    console.log(price);
}

$(".checkbox input").click(
    function () {
        total2()
    }
)

//购物车合计
function shoptotal() {
    var prices = $(".J_smallTotalPrice");
    total = 0;
    for (let i = 0; i < prices.length; i++) {
        var temp = prices[i].innerHTML;
        var price = temp.substring(1, temp.length);
        // console.log(price)
        total += parseFloat(price);
    }
    // console.log(total)
    $(".J_totalPrice").html("￥" + total);
    console.log(prices)
}

//商品删除
$(".J_btnDelete").click(function () {
    $(this).parents("li").remove();
    var childres = $(".shop ul").children();
    console.log(childres.length);
    if (childres.length == 0) {
        $(".shop").hide();
        $(".noshop").show();
    }
    shoptotal();
});

//点击购物车减少商品数量
$(".J_btnDelCount").click(function () {
    var num = $(this).next().val();
    if (num == 1) {
        alert("不能再减了");
    } else {
        num--;
        $(this).next().val(num)
    }
    total3($(this));

})

//点击购物车商品增加数量
$(".J_btnAddCount").click(function () {
    var num = $(this).prev().val();
    // console.log(num)
    num++;
    $(this).prev().val(num)
    total4($(this))
})

//商品减少计算价格
function total3(ncode) {
    var totalprices = ncode.parent().next().html();
    var num = ncode.parent().children("input").val();
    totalprices = totalprices.substring(1, totalprices.length);
    totalprices = parseFloat(totalprices);
    num=parseInt(num);
    var price = totalprices / (num + 1);
    console.log("单价"+price)
    var prices = price.toFixed(3) * num;
    ncode.parent().next().html("￥" + prices);
    console.log("商品减少了")
    shoptotal();
}

//商品增加 计算价格
function total4(ncode) {
    var totalprices = ncode.parent().next().html();
    var num = ncode.parent().children("input").val();
    totalprices = totalprices.substring(1, totalprices.length);
    var price = parseFloat(totalprices) / (num - 1);
    console.log(price + "商品增加了")
    var prices = price.toFixed(3) * num;
    ncode.parent().next().html("￥" + prices)
    shoptotal();
}




