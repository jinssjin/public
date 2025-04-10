#include <stdio.h>

int myFunction1(int a){
    return 5 + a;
}

int myFunction2(int a, int b){
    return b + a;
}

int main()
{
    printf("결과 값은 : %d\n",myFunction1(3));
    printf("결과 값은 : %d",myFunction2(3,5));
    return 0;
}
