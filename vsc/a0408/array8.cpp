#include <stdio.h>

int main(){
    // 최소 나이를 구하시오
    int ages[] = {20,22,18,35,48,26,87,70};
    float avg, sum =0;
    int i;
    int length = sizeof(ages) / sizeof(ages[0]);
    // int min = ages[0];
    int min = 100;
    for(i=0; i <length; i++){
        if(min > ages[i]){
            min = ages[i];
        }
    }
    avg = sum / length;
    // Print the average
    printf("The min age is: %d",min);
    return 0;
}