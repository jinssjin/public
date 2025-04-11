#include <iostream>
#include <string>
using namespace std;

int main()
{
    int myNumbers[5] = {10, 20, 30, 40, 50};
    
for (int i = 0; i < sizeof(myNumbers) / sizeof(myNumbers[0]); i++) {
  cout << myNumbers[i] << "\n";
}
cout << sizeof(myNumbers) << "\n";
cout << sizeof(myNumbers[0]) << "\n";
}
