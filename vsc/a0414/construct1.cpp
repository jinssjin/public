#include <iostream>
#include <string>
using namespace std;

class MyClass{
    public:
        MyClass(){  // 생성과 동시에 실행
            cout << "Hello World!";
        }

};

int main()
{
    MyClass myobj;
    return 0;
}


