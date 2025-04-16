#include<stdio.h>
// Function declaration
int myFunction(int x, int y);

// The main method
int main() {
  int result = myFunction(5, 3); // call the function
  printf("Result is = %d", result);
  return 0;
}

// Function definition
int myFunction(int x, int y) {
  return x + y;
}


// 이건 함수 선언 (Function Declaration) 또는 프로토타입 (Prototype) 이라고 불러.
// 컴파일러에게 "sum이라는 함수가 나중에 나올 거야~" 하고 미리 알려주는 역할을 해!
// C 언어에서는 함수가 사용되기 전에 정의되어 있거나, 선언되어 있어야 해.


