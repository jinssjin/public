$(function(){
    $('.slider').bxSlider({
        auto: true,
        controls: false,
    });
});


// $(function(){
//     $('#sanmenusub').bxSlider({
//         auto: true,
//         controls: false,
//     });
// });

const menus = document.querySelectorAll('#menus > li');  // 탭버튼
const sanmenusub = document.querySelectorAll('#sanmenusub > ul');  // 탭 내용

menus.forEach(function(tab,i){
    tab.addEventListener('click',function(e){
        
//        e.preventDefault();  // 링크 금지 a태그와 관련있으면 써야됨
       
        //. tab_menu li 모든 li .active 삭제

        // 색이 바뀜
        menus.forEach(function(item){
            // 기존에 있던 색 없애기
            item.classList.remove('active');
        });
           
            // 선택한 ul에 색 넣기
         menus[i].classList.add('active');

        // 내용이 바뀜
        sanmenusub.forEach(function(item){
            // div 없애기
            item.classList.remove('on');
        });

        // li에 맞는 div 나오기
        sanmenusub[i].classList.add('on');
    });
});