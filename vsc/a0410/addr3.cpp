#include <stdio.h>

int main()
{
    int myAge = 43;
    int *ptr = &myAge;  // * : 역참조, 포인터
    printf("%d\n",myAge);  // myAge의 값
    printf("%p\n",&myAge);  // myAge의 주소
    printf("%p\n",&ptr);  // 포인터 변수 ptr의 주소
    return 0;
}
