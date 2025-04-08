#include <stdio.h>

int main(){
    const int myNum = 15;
    // myNum =10;
    // 오류 뜸, const : 상수, 'myNum'의 재할당 불가능

    // const int minutesPerHour;
    // minutesPerHour = 60;
    // 오류 뜸, 선언과 초기화를 따로 할 수 없음

    const int minutesPerHour = 60;  // 상수 : 선언과 함께 초기화 해야된다.
    
    printf("%d",myNum); 
    return 0;
}