#include <iostream>
#include <string>
using namespace std;

class Employee{
    private:
        int salary;

    public:
        void setSalary(int s){
            salary = s;
        }

    public:
        int getSalary(){
            return salary;
        }
};

int main()
{
    Employee myObj;
    myObj.setSalary(50000); // salary에 50000 입력
    cout << myObj.getSalary(); // 입력한 50000 출력
    return 0;
}


