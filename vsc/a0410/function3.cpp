#include <stdio.h>


void calculateSum(int a, int b){
    int sum = a + b;
    printf("%d+%d = %d\n",a,b,sum);
}

int main()
{
    calculateSum(5,3);
    calculateSum(8,2);
    calculateSum(15,15);
    return 0;
}
