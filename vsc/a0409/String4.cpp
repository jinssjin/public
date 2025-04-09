#include <stdio.h>

int main()
{
    char carName[] = "Volvo";  // 문자열을 문자 배열로 저장
    int i;
    for(i=0;i<5;++i){
        printf("%c\n",carName[i]);  // 문자열을 출력
    }

    return 0;
}
