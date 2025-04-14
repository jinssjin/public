#include <iostream>
#include <string>
using namespace std;

class Car{
    public:
        string modelName;
        int speed;

        int speedUp(){
            return speed += 10;
        }

        int speedDown(){
            return speed -= 10;
        }
};

int main()
{
    Car myCar;
    myCar.speed = 20;
    myCar.speedUp();
    cout << myCar.speed << "\n";
    myCar.speedUp();
    cout << myCar.speed << "\n";
    myCar.speedDown();
    cout << myCar.speed << "\n";
    return 0;
}


