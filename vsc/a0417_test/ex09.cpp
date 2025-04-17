#include <iostream>
#include <string>
using namespace std;

/*
4. 상속
Animal클래스를 만들고, 이를 상속받는Dog클래스를 만들어sound()함수를 오버라이드하여"멍멍!"을 
출력하시오.
*/

class Animal{
    public:
        void sound(){
            cout << "멍멍!";
        }

        Animal(){
            
        }
};

class Dog : Animal{
    public:
    string name = "sigore";
};

int main()
{
    Dog mydog;
    
    cout << mydog.name << "은(는)";
    mydog.sound();
    cout << "짖는다";
    return 0;
}
