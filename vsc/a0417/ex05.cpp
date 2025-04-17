#include <iostream>
using namespace std;

/*
문제 1: 클래스를 이용한 간단한 계산기 만들기
두 개의 정수 멤버 변수와 덧셈, 뺄셈, 곱셈, 나눗셈 기능을 수행하는 멤버 함수를 가진 Calculator 클래스를 설계하고 구현하세요.
메인 함수에서 Calculator 객체를 생성하고 사용자로부터 두 개의 정수와 수행할 연산을 입력받아 결과를 출력하는 프로그램을 작성하세요.
나눗셈의 경우 0으로 나누는 경우를 처리해야 합니다.
*/

class Calculator{
    public:
    int a, b;
    int plus (int a, int b){
        return a+b;
    }

    int subtrac (int a, int b){
        return a-b;
    }

    int multiple (int a, int b){
        return a*b;
    }

    double divise (int a, int b){
        return a/b;
    }
};


class Calculator1{
    public:
        int num1;
        int num2;

        void setNumbers(int n1, int n2){
            num1 = n1;
            num2 = n2;
        }

        int add(){
            return num1+num2;
        }
    
        int subtract1(){
            return num1-num2;
        }
    
        int multiply(){
            return num1*num2;
        }
    
        double divide(){
            if(num2==0){
                cerr << "Error: division" << endl;
                return 0.0;
            }
            // return (double) (num1) / num2;
            return static_cast<double> (num1) / num2;
        }
};



int main()
{
    Calculator cal;
    int a, b;
    cout << "정수 두 개 입력하시오" << endl;
    cin >> a >> b;
    int resultadd = cal.plus(a,b);
    cout << "더하기 하믄 : " << resultadd << endl;

    int resultsubtrac = cal.subtrac(a,b);
    cout << "빼믄 : " << resultsubtrac << endl;

    int resultmultiple = cal.multiple(a,b);
    cout << "곱하믄 : " << resultmultiple << endl;

    double resultdivise = cal.divise(a,b);
    cout << "나누믄 : " << resultdivise << endl;


    Calculator1 calc;
    int n1, n2;
    char operation;
    cout << "두개의 정수를 입력하세요: ";
    cin >> n1 >> n2;
    calc.setNumbers(n1,n2);

    cout << "수행할 연산을 입력하세요(+,-,*,/):";
    cin >> operation;

    double result;

    switch (operation)
    {
    case '+':
        result = calc.add();
        
        break;

    case '-':
        result = calc.subtract1();
        break;

    case '*':
        result = calc.multiply();
        break;

    case '/':
        result = calc.divide();
        break;
    
    default:

    // cerr c++에서 표준 에러 출력시스템
        cerr << "Error: Invalid operation!" << endl;
        break;
    }

    cout << "결과 : " << result << endl;
    return 0;
}
