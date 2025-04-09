#include <stdio.h>

int main()
{
    int myNum;
    char myChar;
    printf("Type a number and a character press enter: \n");
    scanf("%d %c",&myNum, &myChar);  // & : 주소를 통해 값을 저장
    printf("Your number is: %d\n",myNum);
    printf("Your number is: %c\n",myChar);
    return 0;
}

// %d 정수 입력 : 변수 int
// %f 실수 입력 : 변수 float
// %lf 실수 입력 : 변수 double
// %s 문자열 입력 : char[] 배열 전체
// %c 문자 입력 : char 문자 하나