#include <stdio.h>
#include <limits.h>

int main()
{
    int max = 0; // INT_MIN -2147483648
    int min=99; // INT_MAX 2147483647
    int sum;
    double average;
    int arr[10] = {5, 12, 8, 3, 15, 7, 9, 20, 1, 18};
    int size = sizeof(arr) / sizeof(arr[0]);
    
    for(int i=0; i < size; i++){
        sum += arr[i];
        if(max < arr[i]){
            max = arr[i];
        }
        if(min > arr[i]){
            min = arr[i];
        }

    };

    average = (double)sum/10;
    printf("배열의 평균 : %.2f\n",average);
    printf("배열의 최댓값 : %d\n",max);
    printf("배열의 최솟값 : %d\n",min);
    return 0;
}
