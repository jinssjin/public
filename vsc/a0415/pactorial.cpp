#include <stdio.h>

int main()
{

    //정수 n을 구하여 n!(팩토리얼)을 구하시오 모르것다
    int n;
    int result;
    scanf("%d",&n);
    for(int i=1;i<=n;i++){
        result *= i;
    };
    printf("n! = %d",result);
    return 0;
}

