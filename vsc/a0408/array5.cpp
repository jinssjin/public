#include <stdio.h>

int main(){

    int myNumbers[] = {10,25,50,75,100};
    
    printf("%lu",sizeof(myNumbers));
        // "%lu" unsigned Long  // 길이를 모를때
    return 0;
}


// int는 보통 4byte를 사용 4 * 5 = 20