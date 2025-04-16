#include <iostream>
#include <list>
using namespace std;

int main()
{
    list<string> cars = {"Volvo","BMW","Ford","Mazda"};
        cout << cars.front() << "\n";
        cout << cars.back() << "\n";
    
    return 0;
}
