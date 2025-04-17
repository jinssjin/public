#include <iostream>
#include <string>
using namespace std;

/*
2. 클래스와 객체 (기초)
Car라는 클래스를 만들고,speed,color멤버변수를 가진 뒤, 객체를 생성하여 값을 설정하고 출력하시오.
*/

class Car{
    public:
    int speed = 20;
    string color = "red";

};

int main()
{
    Car myCar;
    cout << "내 차는" << myCar.color << "(이)고 속도는 " << myCar.speed << "입니다.";
    return 0;
}
