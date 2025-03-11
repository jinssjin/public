const targetlink = document.querySelectorAll('.tab_menu li a');  // 탭버튼
const tabContent = document.querySelectorAll('#tabContent > div');  // 탭 내용

targetlink.forEach(function(link){
    link.addEventListener('click',function(e){
        e.preventDefault();  // 링크 금지 a태그와 관련있으면 써야됨
        let orgTarget = e.target.getAttribute('href');
        // 클릭한 놈(e.target) : this로 변경가능
        // getAttribute는 href, src 속성값을 읽어옴
        // alert(orgTarget); #tab1, #tab2, #tab3
        let tabTarget = orgTarget.replace("#","");  // #tab3 → tab3
        // #tab1에서 #을 빈문자열로 대체 →  tab1
         // alert(tabTarget);

        tabContent.forEach(function(content){
            content.style.display="none";
                //  #tabContent > div를 안보이게 한 후

        });
        // 클릭한 탭만 보이게 설정
        document.getElementById(tabTarget).style.display="block";
        targetlink.forEach(function(link2){
            link2.classList.remove('active');
        });
            e.target.classList.add('active');
    });
});
