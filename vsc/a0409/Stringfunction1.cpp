#include <stdio.h>
#include <string.h>

int main()
{
    char alphabet[50] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    printf("%d",strlen(alphabet));  // 26, 실제 문자열 갯수만 출력
    printf("%d",sizeof(alphabet));  // 50, 방의 갯수를 정했기 때문에 크기는 50이 출력됨
    return 0;
}
