#include <stdio.h>

/* 
5. 함수
정수를 매개변수로 받아서 팩토리얼 값을 반환하는 함수를 작성하고, main 함수에서 호출하여 결과를 출력하시오.
*/

void fact(){
    int n;
    int result=1;
    printf("정수를 입력하시오\n");
    scanf("%d",&n);
    for(int i=1; i<=n; i++){
        result *= i;
    }
    printf("%d! = %d",n,result);
};

int main()
{
    fact();
    return 0;

    
}