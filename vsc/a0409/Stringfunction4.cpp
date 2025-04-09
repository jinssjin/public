#include <stdio.h>
#include <string.h>

int main()
{
    char str1[] = "Hello";
    char str2[] = "Hello";
    char str3[] = "Hi";
    // strcmp : String Compare (비교)
    printf("%d\n",strcmp(str1,str2));  // 0 출력 :참
    printf("%d\n",strcmp(str1,str3));  // 음수 출력 : 아스키코드의 차
    return 0;
}
