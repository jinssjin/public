#include <stdio.h>

int main(){

    int myNumbers[] = {10,25,50,75,100};
    int length = sizeof(myNumbers) / sizeof(myNumbers[0]);
    printf("%d",length);
        // "%lu" unsigned Long  // 길이를 모를때
    return 0;
}