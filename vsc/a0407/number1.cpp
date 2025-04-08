#include <stdio.h>

int main()
{
    float myNum = 19.99;
    // printf("%1f",myNum);  // 1f는 소용없음
    printf("%.2f\n",myNum);  // 19.99
    printf("%.1f\n",myNum);  // 20.0 소수점 아래 1자리(반올림)
    printf("%10.2f\n",myNum);  // 전체너비 10칸, 소수점 두자리
    return 0;
}
