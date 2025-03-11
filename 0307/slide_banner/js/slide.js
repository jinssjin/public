$(function(){
    var visual = $("#brandVisual > ul > li"); // 큰 사진
    var button = $("#buttonList > li"); // pager 버튼
    var current = 0;
    var id;
    var i = 0;

    button.click(function(){
        i = $(this).index();
        // alert(i);
        button.removeClass('on');
        button.eq(i).addClass('on');
        move();
        return false

    });

    timer();
    // 타이머를 한 번 실해시켜줘야 자동으로 돌아감
    function timer(){
        id = setInterval(function(){
            var n = current + 1
            console.log(n)
            if(n == 3){n=0;}
            button.eq(n).trigger('click');
            // n번째 버튼을 3초마다 강제로 클릭

        },3000)
    }
    
    function move(){
        if(current==i) return;
        // 현재 활성화된 버튼이므로 클릭해도 가만히 있음. 빠져나간다.
        var cu = visual.eq(current);  // 현재사진 클릭한 버튼에 해당하는 사진
        var ne = visual.eq(i);  // 슬라이드되서 들어올 사진 : 클릭할 버튼에 해당하는 사진
        cu.css('left','0').stop().animate({'left':'-100%'},500)
        ne.css('left','100%').stop().animate({'left':'0%'},500)
        current=i;
    }
});