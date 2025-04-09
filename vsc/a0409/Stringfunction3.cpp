#include <stdio.h>
#include <string.h>

int main()
{
    char str1[20] = "Hello ";
    char str2[] = "World!";
    strcat(str1,str2);  // str2를 str1에 붙임
    printf("%s",str1);  // Hello World! 출력
    return 0;
}
