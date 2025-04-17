#include <stdio.h>

/* 
2. 조건문
사용자로부터 하나의 정수를 입력받아 짝수인지 홀수인지 판별하는 프로그램을 작성하시오.
*/


int main()
{
    while (true)
    {
        int a;
        printf("정수 한개를 입력하시오 : ");
        scanf("%d",&a);
        if(a%2==1){
            printf("%d는 홀수 입니다.\n",a);
        }else if(a%2==0){
            printf("%d는 짝수 입니다.\n",a);
        }else{
            printf("잘못된 입력입니다.");
        }
    }
}