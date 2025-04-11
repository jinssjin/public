#include <iostream>
#include <string>
using namespace std;

int main()
{
    int myNum = 5;
    float myFloatNum = 5.99;
    double myDoubleNum = 9.98;
    char myLetter = 'D';  // ""을 쓰면 오류남
    bool myBoolean = true;
    string myString = "Hello";

    cout << "string: " << myString << "\n";
    cout << "int: " << myNum << "\n";
    cout << "float: " << myFloatNum << "\n";
    cout << "double: " << myDoubleNum << "\n";
    cout << "char: " << myLetter << "\n";
    cout << "bool: " << myBoolean << "\n";
    return 0;
}
