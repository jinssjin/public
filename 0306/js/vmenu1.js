$(function(){
    // $('.m_menu li ul').css("display","none")
    $('.sub').hide();
    // $('.sub').eq(0).show();
    $('.m_menu li ul').eq(0).show();

    $('.m_menu li a').click(function(){
        var kkk = $(this).next('.sub').css('display');
        // 클릭a 다음에 .sub의 display 상태 none, block을 알 수 있음
        // alert(kkk);
        if(kkk=="none"){
            $('.sub').slideUp();  // 모든 슬라이드를 닫고
            $(this).next('.sub').slideDown();
            // 방금 클릭한 다음에 .sub를 보여줌
        }
        return false;
    })
})
