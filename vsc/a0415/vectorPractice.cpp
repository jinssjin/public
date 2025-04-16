#include <iostream>
#include <vector>
using namespace std;

// 사용자로부터 정수 5개를 입력받아 vector<int> 에 저장한 후,
// 저장된 값을 모두 출력하는 프로그램을 작성하세요.


int main()
{
    vector<int> num;
    for(int i=0;i < 5;i++){
        int result;
        cin >> result;
        num.push_back(result);
    }
    
    for(int i=0;i < 5;i++){
        cout << num[i] << "\n";
    }
    return 0;
}
