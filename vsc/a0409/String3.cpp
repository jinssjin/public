#include <stdio.h>

int main()
{
    char greetings[] = "Hello World";  // 문자열을 문자 배열로 저장
    greetings[0] = 'J';  // 배열 첫번째 인덱스 값을 변경
    printf("%s",greetings);  // 문자열을 출력

    return 0;
}
