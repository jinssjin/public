#include <iostream>
#include <string>
using namespace std;

int main()
{
    string myString = "Hello";
    cout << myString;
    cout << myString.at(0) << "\n";
    cout << myString.at(1) << "\n";
    cout << myString.at(myString.length()-1) << "\n";
    myString.at(0) = 'J';
    cout << myString << "\n";
    return 0;
}
