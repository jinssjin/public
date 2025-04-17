#include <stdio.h>

int main()
{
    int num;
    int sum;
    printf("양의 정수를 입력하세요");
    scanf("%d",&num);
    if(num < 0){
        printf("양의 정수를 입력해야합니다. \n");
        return 1;
    }

    while (num > 0)
    {
        sum = sum + (num % 10);  // 12345 % 10 = 5 일의 자리수 sum에 저장, 1234 % 10 = 4 일의 자리수 sum에 누적, 123 % 10 = 3 일의 자리수 sum에 누적 ...
        num = num / 10;  // 12345 / 10 = 1234 num에다가 저장, 1234 / 10 = 123 num에다가 저장, 123 / 10 = 12 num에다가 저장 ...
    }
    
    printf("%d",sum);
    return 0;
}
