#include <stdio.h>

int x = 5;

void myFunction(){
    printf("%d\n",x);
}

int main()
{
    myFunction();
    printf("%d",x);
    return 0;
}
