#include <stdio.h>

/* 
4. 배열과 반복문
사용자로부터 5개의 정수를 입력받아, 그 중 가장 큰 값을 출력하는 프로그램을 작성하시오.
*/


int main()
{
    int numbers [5];
    printf("정수 다섯개를 입력하시오\n");
    scanf("%d%d%d%d%d",&numbers[0],&numbers[1],&numbers[2],&numbers[3],&numbers[4]);
    int max = numbers[0];
    int length = sizeof(numbers) / sizeof(numbers[0]);
    for(int i=0;i<length;i++){
        if(max < numbers[i]){
            max = numbers[i];
        }
    }
    printf("가장 큰 값 : %d",max);
    return 0;
}