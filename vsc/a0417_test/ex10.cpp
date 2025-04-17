#include <iostream>
#include <string>
#include <vector>
using namespace std;

/*
5. 벡터 사용
사용자로부터 정수를 계속 입력받다가 -1이 입력되면 종료하고, 입력된 정수들을vector에 저장한 뒤 모든 값을 출력하시오.
*/

int main()
{
    int n;
    vector<int> numbers;
    while (true)
    {
        cout << "정수를 입력해주세요 (-1 입력하면 종료)" << endl;
        cin >> n;
        if(n>0){
        numbers.push_back(n);
        }else if(n==-1){
            if(numbers.empty()){
                cout << "정수만 입력해주세요\n";
            }else{
                cout << "입력된 값은" << endl;
                for(int i=0; i<numbers.size(); i++){
                    cout << numbers[i] << endl;
                }
                break;
            }
            
        
         }else if(n<-1){
            cout << "정수만 입력해주세요\n";
            continue;
        }
}
    
    return 0;
}
