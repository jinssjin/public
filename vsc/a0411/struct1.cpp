#include <iostream>
#include <string>
using namespace std;

int main()
{
    // 구조체
    struct 
    {
        int myNum;
        string myString;
    }myStructure; // 구조체명

    myStructure.myNum = 1;
    myStructure.myString = "Hello World";
    cout << myStructure.myNum << "\n";
    cout << myStructure.myString << "\n";

    
    return 0;
}
