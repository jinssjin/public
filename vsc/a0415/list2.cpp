#include <iostream>
#include <list>
using namespace std;

int main()
{
    list<string> cars = {"Volvo","BMW","Ford","Mazda"};
    cars.push_front("Tesla");
    cars.push_back("Vw");
        for(string car : cars){
        cout << car << "\n";
        }
    
    return 0;
}
