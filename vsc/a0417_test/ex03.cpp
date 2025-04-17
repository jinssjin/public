#include <stdio.h>

/* 
3. 반복문
1부터 100까지의 정수 중에서 3의 배수만 출력하는 프로그램을 작성하시오.
*/


int main()
{
    int threeM=3;
    for(int i=2;i<=100;i++){
        if(threeM < 100){
        printf("%d\n",threeM);
        threeM = i*3;
        }
    }
    return 0;

}