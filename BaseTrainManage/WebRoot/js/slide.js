/**
 * Created by Administrator on 2016/5/13.
 */
function slide(){
    $(".imgBtn").click(function(){
        $(this).toggleClass("imgBtnDown");
        $(this).siblings("div").slideToggle(1);
        $(this).parent().siblings(".term").css("margin-top",30);
    })
}