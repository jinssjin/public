#include <stdio.h>
#include <string.h>

int main()
{
    char str1[20] = "Hello World!";
    char str2[20];
    strcat(str2,str1);  // str2를 str1에 붙임
    printf("%s",str2);  // Hello World! 출력
    return 0;
}
