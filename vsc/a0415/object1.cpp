#include <iostream>
#include <string>
using namespace std;

class Member{
    public:
        string brand;
        string model;
        int year;
        Member(string a, string b, int c){
            brand = a;
            model = b;
            year = c;
        }
};

int main()
{
    Member memOBJ1;

    memOBJ1.brand = "BMW";
    memOBJ1.model = "X5";
    memOBJ1.year = 1999;
    Member memOBJ2;
    memOBJ2.brand = "Ford";
    memOBJ2.model = "Mustang";
    memOBJ2.year = 1969;

    cout << memOBJ1.brand <<" " << memOBJ1.model << " " << memOBJ1.year << "\n";
    cout << memOBJ2.brand <<" " << memOBJ2.model << " " << memOBJ2.year << "\n";


    return 0;
}


