#include <stdio.h>

int main()
{
    int myNum;
    printf("Type a number and press enter: \n");
    scanf("%d",&myNum);  // & : 주소를 통해 값을 저장
    printf("Your number is: %d",myNum);
    return 0;
}

// %d 정수 입력 : 변수 int
// %f 실수 입력 : 변수 float
// %lf 실수 입력 : 변수 double
// %s 문자열 입력 : char[] 배열 전체
// %c 문자 입력 : char 문자 하나