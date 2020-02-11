#include "LinkedList.h"
#include <iostream>

using namespace std;

int main()
{
    LinkedList<int> myList;
    cout << "initial list" << endl;
    cout << myList << endl;
    cout << "Length: " << myList.getLength() << endl << endl;
    cout << "insertFirst 5" << endl;
    myList.insertFirst(5);
    cout << "insertFirst 6" << endl;
    myList.insertFirst(6);
    cout << "insertFirst 7" << endl;
    myList.insertFirst(7);
    cout << "mylist" << endl;
    cout << myList << endl << endl;
    cout << "copy list" << endl;
    LinkedList<int> yourList = myList; // same as yourList(myList)
    cout << "setFirst 100" << endl;
    yourList.setFirst(100);
    cout << "yourlist" << endl;
    cout << yourList << endl;
    cout << "mylist" << endl;
    cout << myList << endl;
    cout << "end" << endl;
    
    cout << "Length: " << myList.getLength() << endl;
    cout << "insertLast" << endl;
    myList.insertLast(9);
    cout << myList << endl;
    cout << "Length: " << myList.getLength() << endl;
    cout << "removeLast" << endl;
    myList.removeLast();
    cout << myList << endl;
    cout << "Length: " << myList.getLength() << endl;

    return 0;
}



