#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Book{
    public:
        string title;
        bool isBorrowed;
    
        Book(string t) {
            title = t;
            isBorrowed = false;
        }
};

void checkBookList(vector<Book>& library){
    cout << "[도서 목록]" << endl;
    for(int i=0; i < library.size(); i++){
        cout << i+1 << ". " << library[i].title << "(";
        if(library[i].isBorrowed){
          cout << "대출중";
        }else{
            cout << "대출가능";
        }
        cout << ") \n";
    };
};

void borrow(vector<Book>& library){
    int choiceBookNum;
    int indexNum;
    cout << "대출할 도서 번호를 입력하세요: " << endl;
    cin >> choiceBookNum;
    indexNum = choiceBookNum-1; // 인덱스 번호
    for(int i=0; i < library.size(); i++){
        if(choiceBookNum < 0 || choiceBookNum > library.size()){
            cout << "잘못입력하셨습니다.";
        }else if(library[i].isBorrowed){
            cout << "이미 대출된 책입니다.";
        }else if(choiceBookNum == i){
            library[i].isBorrowed = true;
            cout << "'" << library[i].title << "' 책을 대출했습니다.";
        }
    };
};

void returnBook(vector<Book>& library){
    int choiceBookNum;
    cout << "반납할 도서 번호를 입력하세요: " << endl;
    cin >> choiceBookNum;
    for(int i=0; i < library.size(); i++){
        if(choiceBookNum < 0 || choiceBookNum > library.size()){
            cout << "잘못입력하셨습니다.";
        }else if(!library[i].isBorrowed){
            cout << "대출중인 도서가 아닙니다.";
        }else if(choiceBookNum == i-1){
            library[i].isBorrowed = false;
            cout << "'" << library[i].title << "' 책을 반납했습니다.";
        }
    };
}


int main()
{
    vector<Book> library;
    library.push_back(Book("C++ 입문서"));
    library.push_back(Book("자료구조론"));
    library.push_back(Book("알고리즘 기초"));


    while(true){
        cout << "=== 도서 대출 프로그램 ===" << endl;
        cout << "1. 도서 목록 확인" << endl;
        cout << "2. 도서 대출" << endl;
        cout << "3. 도서 반납" << endl;
        cout << "4. 프로그램 종료" << endl;
        
        int choiceNum;
        cin >> choiceNum;
        switch (choiceNum)
            {
            case 1:
                checkBookList(library);
                break;

            case 2:
                borrow(library);
                break;

            case 3:
                returnBook(library);
                break;

            case 4:
                cout << "프로그램을 종료합니다.";
                return 0;        
            default:
                cout << "잘못된 입력입니다. 다시 입력해주세요";
                break;
            }
    }
    return 0;
}
