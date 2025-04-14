#include <iostream>
#include <string>
using namespace std;

class Book{
    public:
        string title;
        string author;
        int price;

           Book(string t, string a, int p) {
            title = t;
            author = a;
            price = p;
        }
        void printInfo(string a, string b, int c){
            cout << a << " (" << b << " 저) : " << c << "원" << endl;
        }

        Book(){
        }

        void printInfo(){
            cout << title << " (" << author << " 저) : " << price << "원" << endl;
        }
};

int main()
{
    Book myBook;
    myBook.printInfo("c++","LEE",500);
    Book myBook1("c+++","LEEE",5000);
    myBook1.printInfo();
    return 0;
}


