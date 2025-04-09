#include <stdio.h>

int main()
{
    char greetings[] = "Hello World";  // 문자열을 문자 배열로 저장
    printf("%c",greetings[0]);  // "%c"는 한글자만 출력되기 때문에 인덱스 번호를 지정해줘야한다. 이 경우 모든 문자열을 나타내고 싶을때 for문을 써준다.

    return 0;
}
