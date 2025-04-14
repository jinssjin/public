#include <iostream>
#include <string>
using namespace std;

class MyClass{
    public:
        void myMethod(){
            cout << "Hellow World!";
        }

};

int main()
{
    MyClass myobj;

    myobj.myMethod();

    return 0;
}


