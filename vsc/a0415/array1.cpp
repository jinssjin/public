#include <stdio.h>

int main()
{
    int arr [5];
    int max;

    printf("5개의 정수를 입력하세요 : ");
    for(int i=0;i<5;i++){
        scanf("%d",&arr[i]);
    };
    max = arr[0];
    for(int i=0;i<5;i++){
        if(arr[i] > max){
            max = arr[i];
        };
    };
    printf("가장 큰 값은 %d 입니다.\n",max);
    return 0;
}

