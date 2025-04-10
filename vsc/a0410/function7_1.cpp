#include <stdio.h>


void myFunction(){
    int x = 5;
}

int main()
{
    myFunction();
    // printf("%d",x);  // 지역변수 x에 접근 하려면 오류
    return 0;
}
