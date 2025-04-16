#include<stdio.h>

int main(){
    FILE *fptr;//기본적인 데이터 유형, 사용하려면 포인터 변수 fptr

    fptr = fopen("d:\\student\\filename.txt", "w");

    fclose(fptr);
    return 0;
}

// 파일은 만들지만 디렉토리(폴더)는 못만든다 . 폴더가 없으면 fptr == NULL

/*
🔸 FILE *fptr;
FILE : C에서 파일을 다룰 때 사용하는 구조체 타입
*fptr : 그 파일과 연결된 포인터 변수

🔸 fopen("경로", "모드");
"d:\\student\\filename.txt" : 생성하거나 열 파일의 경로;
    (\\는 이스케이프 문자라서 \를 두 번 써야 함)

"w" : 쓰기 모드;
파일이 없으면 새로 만듦
있으면 내용을 덮어씀 (주의!)

🔸 fclose(fptr);
파일 작업이 끝나면 꼭 닫아줌
메모리 누수 방지
다른 프로그램에서 파일 접근 가능하게 해줌

*/