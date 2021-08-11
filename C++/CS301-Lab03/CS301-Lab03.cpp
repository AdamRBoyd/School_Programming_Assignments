#include "LinkedList.h"
#include <iostream>

using namespace std;

int main()
{
    LinkedList<int> myList;
    cout << "initial list - " << myList << endl;
    cout << "Length: " << myList.getLength() << endl << endl;

    cout << "insertFirst 5" << endl;
    myList.insertFirst(5);
    cout << "insertFirst 6" << endl;
    myList.insertFirst(6);
    cout << "insertFirst 7" << endl;
    myList.insertFirst(7);
    cout << "mylist - " << myList << endl << endl;

    cout << "copy list" << endl << endl;
    LinkedList<int> yourList = myList; // same as yourList(myList)

    cout << "yourlist.setFirst 100" << endl << endl;
    yourList.setFirst(100);
    cout << "yourlist - " << yourList << endl;
    cout << "mylist - " << myList << endl << endl;
     
    cout << "Length: " << myList.getLength() << endl;
    cout << "insertLast 9" << endl;
    myList.insertLast(9);
    cout << myList << endl;
    cout << "Length: " << myList.getLength() << endl << endl;

    cout << "removeLast" << endl;
    myList.removeLast();
    cout << myList << endl;
    cout << "Length: " << myList.getLength() << endl << endl;

    cout << "getFirst" << endl;
    cout << "First: " << myList.getFirst() << endl << endl;

    cout << "getLast" << endl;
    cout << "Last: " << myList.getLast() << endl << endl;

    cout << "Adding more numbers..." << endl << endl;

    myList.insertFirst(8);
    myList.insertFirst(9);
    myList.insertFirst(10);
    myList.insertFirst(11);
    myList.insertLast(4);
    myList.insertLast(3);
    myList.insertLast(2);
    myList.insertLast(1);

    cout << "Reverse" << endl;
    cout << myList << endl;
    myList.reverse();
    cout << "Reversed" << endl;
    cout << myList << endl << endl;

    return 0;
}



