#include <iostream>
#include <list>
using namespace std;

int main()
{
    list<string> cars = {"Volvo","BMW","Ford","Mazda"};
    cars.pop_front();
    cars.pop_back();
        for(string car : cars){
        cout << car << "\n";
        }
    
    return 0;
}
