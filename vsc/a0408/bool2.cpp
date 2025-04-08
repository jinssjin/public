#include <stdio.h>
#include <stdbool.h>  // bool값을 비교하기 위해서 c++에서는 꼭 넣어줘야한다.

int main(){

    bool isProgrammingFun = true;
    bool isFishTasty = true;
    
    printf("%d",isProgrammingFun == isFishTasty);
    return 0;
}
