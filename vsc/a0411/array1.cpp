#include <iostream>
#include <string>
using namespace std;

int main()
{
    string myString = "Hello";
    cout << myString[1] << "\n";
    cout << myString[myString.length()-1];  // 마지막 글자, 인덱스값은 -1
    return 0;
}
