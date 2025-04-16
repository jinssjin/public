#include <iostream>
#include <map>
using namespace std;

int main()
{
// map 선언
    map<string,int> score;

// 값 삽입
    score["Alice"] = 95;
    score["Bob"] = 82;
    score["Charlie"] = 88;

// 출력
    cout << "학생 점수 목록: " << endl;
    for(map<string,int>::iterator it=score.begin(); it!=score.end(); ++it){
        cout << it -> first << " : " << it -> second << endl;
    }


// 위와 같은 식
    for(auto it=score.begin(); it!=score.end(); ++it){
        cout << it -> first << " : " << it -> second << endl;
    }

    // it -> first : 키 (key)
    // it -> second : 값 (value)



// 특정값 찾기
    string name = "Bob";
    if(score.find(name) != score.end()){
        cout << name << "의 점수는 " << score[name] << endl;
    }else{
        cout << name << "의 점수가 존재하지 않습니다." << endl;
    }

// 삭제
    score.erase("Charlie");
    cout << "삭제 후 남은 학생 목록" << endl;
    for(auto it=score.begin(); it!=score.end(); ++it){
        cout << it -> first << " : " << it -> second << endl;
    }

    for(const auto& pair : score){
        cout << pair.first << " : " << pair.second << endl;
    }

    // const auto& 변수 : score라는 map의 각 key-value 쌍을 변수라는 이름으로 하나씩 가져옴
    // :score : score 대상으로 순회하겠다.
    // 변수.first : 현재 순회중인 key
    // 변수.second : 현재 순회중인 value
    return 0;
}
