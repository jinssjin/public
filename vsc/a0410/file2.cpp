#include<stdio.h>

int main(){
    FILE *fptr;//기본적인 데이터 유형, 사용하려면 포인터 변수 fptr

    fptr = fopen("d:\\student\\filename.txt", "r"); // 경로에 저장된 파일을 읽기모드로
    char myString[100];  // 문자열을 저장할 배열 선언
    fgets(myString, 100 , fptr);  // 공백을 포함한 한줄읽기
    // myString - 방금만들 배열에 저장
    // 100 -myString(100)과 일치
    //  fptr 파일을 읽는데 사용데는 파일 포인터
    printf("%s", myString);  // 파일에서 읽어온 내용을 출력

    fclose(fptr);
    return 0;
}
// fgets(myString, 100 , fptr);
// myString : 문자열을 저장할 공간(버퍼) 먼저 char myString[100];등을 선언해야됨
// // 100 :  만약 줄이 100자보다 길어도, 99자까지만 읽고 멈춰 (나머진 다음 fgets()에서 읽음)
// fptr : fopen()으로 연 파일의 주소

/*

여러줄일 경우 while문을 사용하면 여러줄 출력

while (fgets(myString, 100, fptr) != NULL) {
    printf("%s", myString);
}

*/