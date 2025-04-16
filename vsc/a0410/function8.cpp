#include<stdio.h>
void myFunction(); //함수선언 먼저

//절차지향적 (차례대로 읽어서 컴파일)
int main(){
    myFunction();
    return 0;
}
void myFunction(){
   printf("hello\n");
}




