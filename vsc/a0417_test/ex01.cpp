#include <stdio.h>

/* 
1. 변수와 연산자 (기초)
사용자로부터 두 개의 정수를 입력받아, 합, 차, 곱, 몫, 나머지를 출력하는 프로그램을 작성하시오.
*/


int main()
{
    int a, b;
    printf("정수 두개를 입력하시오\n");
    printf("첫번쨰 정수를 입력하시오\n");
    scanf("%d",&a);
    printf("두번쨰 정수를 입력하시오\n");
    scanf("%d",&b);
    char c;
    printf("연산자를 입력하시오(+,-,*,/,% 중 선택1)\n");
    scanf("%c",&c);

    
        switch (c)
        {
        case '+':
            printf("%d",a+b);
            break;
        case '-':
            printf("%d",a-b);
            break;
        case '*':
            printf("%d",a*b);
            break;
        case '/':
            printf("%f",a/b);
            break;
        case '%':
            printf("%d",a%b);
            break;
        
        default:
            printf("잘못된 입력입니다.\n");
            break;
        }
    
    return 0;
}
