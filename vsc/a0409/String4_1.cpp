#include <stdio.h>

int main()
{
    char carName[] = "Volvo";  // 문자열을 문자 배열로 저장
    int lenght = sizeof(carName) / sizeof(carName[0]);
    // 문자 하나당 4byte,전체 byte수는 20byte, 20/4 = 5
    int i;
    for(i=0;i<lenght;++i){
        printf("%c\n",carName[i]);  // 문자열을 출력
    }

    return 0;
}
