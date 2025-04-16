#include <iostream>
#include <map>
using namespace std;

int main()
{
// map 선언
    map<string,int> Employee;

// 값 삽입
    Employee["Kim"] = 4500;
    Employee["Lee"] = 5200;
    Employee["Park"] = 4800;
    Employee["Choi"] = 5500;
    Employee["Jung"] = 6100;

// 출력
    cout << "연봉이 5000만원 이상인 직원만 이름:연봉 " << endl;
    for(map<string,int>::iterator it=Employee.begin(); it!=Employee.end(); ++it){
        if(it -> second > 5000){
            cout << it -> first << " : " << it -> second << endl;
        }
    }
    return 0;
}
