#include <iostream>
#include <string>
using namespace std;

class Car{
    public:
        string brand;
        string model;
        int year;
        Car(string x, string y, int z){
            brand = x;
            model = y;
            year = z;
        }
};

int main()
{
    Car CarObj1("BMW","X5",1999);
    Car CarObj2("Ford","Mustang",1969);
    cout << CarObj1.brand <<" " << CarObj1.model << " " << CarObj1.year << "\n";
    cout << CarObj2.brand <<" " << CarObj2.model << " " << CarObj2.year << "\n";
    return 0;
}


