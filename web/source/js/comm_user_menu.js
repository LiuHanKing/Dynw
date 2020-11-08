$(function () {
  /*设置鼠标移入时背景颜色*/
  $(".menu_li").on("mouseover", function () {
    $(this).css("backgroundColor", "chartreuse");
  })
  /*设置鼠标移出时背景颜色恢复*/
  $(".menu_li").on("mouseout", function () {
    $(this).css("backgroundColor", "");
  })
})