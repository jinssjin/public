#include <iostream>
#include <string>
using namespace std;

class Car{
    public:
        string brand;
        string model;
        int year;
};

int main()
{
    Car carOBJ1;

    carOBJ1.brand = "BMW";
    carOBJ1.model = "X5";
    carOBJ1.year = 1999;
    Car carOBJ2;
    carOBJ2.brand = "Ford";
    carOBJ2.model = "Mustang";
    carOBJ2.year = 1969;

    cout << carOBJ1.brand <<" " << carOBJ1.model << " " << carOBJ1.year << "\n";
    cout << carOBJ2.brand <<" " << carOBJ2.model << " " << carOBJ2.year << "\n";


    return 0;
}


