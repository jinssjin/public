$(function(){
    $('.slider').bxSlider({
        auto: true,
        controls: false,
    });
});

// $(function(){
//     $('.box6').bxSlider({
//         auto: true,
//         controls: false,
//     });
// });




// $(function(){
//     $('#sanmenusub').bxSlider({
//         auto: true,
//         controls: false,
//     });
// });

// 메뉴 선택

// const menus1 = document.querySelectorAll('.menus > li');  // 탭버튼
// const sanmenusub1 = document.querySelectorAll('.sanmenusub > ul');  // 탭 내용

// menus1.forEach(function(tab,i){
//     tab.addEventListener('click',function(e){
        
//         // 색이 바뀜
//         menus1.forEach(function(item){
//             // 기존에 있던 색 없애기
//             item.classList.remove('active');
//         });
           
//             // 선택한 ul에 색 넣기
//          menus1[i].classList.add('active');

//         // 내용이 바뀜
//         sanmenusub1.forEach(function(item){
//             // div 없애기
//             item.classList.remove('on');
//         });

//         // li에 맞는 div 나오기
//         sanmenusub1[i].classList.add('on');
//     });
// });

// 세부메뉴 슬라이드

$(function(){
    $(".r_pager").click(function(){
        $('.frame ul').css('margin-left','-1300px')
    })
})

$(function(){
    $(".l_pager").click(function(){
        $('.frame ul').css('margin-left','0')
    })
})

//   $(function(){
//     // var copy1 = $('.ban li:lt(5)').clone();
//     // $('.ban').append(copy1);
//     // 뒤에 복붙하기 : 복제해서 붙여넣기(추가하기)

//     var num = 0;  // 슬라이드 카운팅
//     var li_w = $('.sanmenusub ul li').eq(0).width()*2 ;  // li 한개의 넓이(198px)

    
    // $('.r_pager').eq(2).click(function(){
    //   if(num==2){
    //     num=0;
    //     $('.sanmenusub ul').css('margin-left','0')
    //   }
    //   num++
    //   $('.sanmenusub ul').stop().animate({
    //       'margin-left': -li_w* num
    //   },500)
     
    // })

    // $('.left li a').eq(0).click(function(){
    //   if(num==0){
    //     num=1;
    //     $('.sanmenusub ul').css('margin-left',-li_w* num)
    //   }
    //   num--
    //   $('.sanmenusub ul').stop().animate({
    //       'margin-left': -li_w* num
    //   },500)

    //   return false
     
    // })

    // var id = setInterval(autoplay,2000);
            
    //         function autoplay(){
    //             if(num==0){
    //             num=1;
    //             $('.sanmenusub ul').css('margin-left','0');
    //         }
    //         num++;
    //         $('.sanmenusub ul').stop().animate({
    //             'margin-left':-li_w*num
    //         },500)
    //         }

    
//  })


// 스폰 슬라이드

$(function(){
    var visual = $(".spon > li"); // 큰 사진
    var button = $(".button > li"); // pager 버튼
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
    // 타이머를 한 번 실행시켜줘야 자동으로 돌아감
    function timer(){
        id = setInterval(function(){
            var n = current + 1
            console.log(n)
            if(n == 4){n=0;}
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