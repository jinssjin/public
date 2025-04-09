#include <stdio.h>
#include <string.h>

int main()
{
    char alphabet[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    printf("%d",strlen(alphabet));  // 26
    printf("%d",sizeof(alphabet));  // 27, '\0'까지 포함, 마지막 null
    return 0;
}
