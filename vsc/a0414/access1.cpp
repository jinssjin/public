#include <iostream>
#include <string>
using namespace std;

class MyClass{
    public:
        int x;
    private:
        int y;
};

int main()
{
    MyClass myObj;
    myObj.x =25;  // 접근 가능
    // myObj.y = 50;  // 접근 불가 private
    return 0;
}


