#include <iostream>
#include <string>
using namespace std;

class Animal{
    public:
        void animalSound(){
            cout << "The animal makes a sound \n";
        }
};

class Bird : public Animal{
    public:
    void animalSound(){
        cout << "The bird says: 짹짹 \n";
    }
};

class Dog : public Animal{
    public:
    void animalSound(){
        cout << "The dog says: bow wow \n";
    }
};

class Cat : public Animal{
    public:
    void animalSound(){
        cout << "The Cat says: 애용\n";
    }
};


int main()
{
    Animal myAnimal;
    Bird myBird;
    Dog myDog;
    Cat myCat;

    myAnimal.animalSound();
    myBird.animalSound();
    myDog.animalSound();
    myCat.animalSound();
    return 0;
}


