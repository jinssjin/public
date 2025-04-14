#include <iostream>
#include <string>
using namespace std;

class MyClass{
    public:
        void myMethod();

};

// 외부에서 메소드 불러들일떄
void MyClass::myMethod(){
    cout << "Hellow World!";
}

/* 
클래스 정의 외부에서 함수를 정의하려면 클래스 내부에 함수를 선언한 후
클래스 외부에서 정의해야합니다.
클래스 이름, 범위 결정 ::연산자, 함수 이름을 차례로 지정하면 됩니다.
*/

int main()
{
    MyClass myobj;

    myobj.myMethod();

    return 0;
}


