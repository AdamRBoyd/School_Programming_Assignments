// CS301-Lab03.cpp : This file contains the 'main' function. Program execution begins and ends there.

/*Implement a LinkedList class that uses a doubly-linked list as the underlying data structure. 
That means each node will have both a previous and a next pointer along with the data.   
This will be a class template similar to the LinkedList code I posted on Blackboard except we will include 
fields int length; and Node * tailPtr;  along with the original Node * headPtr.

Implement the same functions as in the posted LInkedList class, along with corresponding insertLast, removeLast and getLast methods.  
Also provide a getLength() method and a reverse method that reverses the order of element in the list. 
Your reverse method should be code efficiently, meaning don't allocate any new nodes or move data between node. 
Just update the pointers, if possible.

Upload your LinkedList.h file and a tester.cpp that does some tests on LinkedList object. 
You're graded on the correctness of LinkedList.h not on the quality of your tests.*/

#include "LinkedList.h"
#include <iostream>

using namespace std;

int main()
{
    LinkedList<int> myList;
    cout << myList << endl;
    myList.insertFirst(5);
    myList.insertFirst(6);
    myList.insertFirst(7);
    cout << myList << endl;
    LinkedList<int> yourList = myList; // same as yourList(myList)
    yourList.setFirst(100);
    cout << yourList << endl;
    cout << myList << endl;

    /*
    myList.removeFirst();
    cout << myList << endl;
    cout << myList.getFirst() << endl;
    cout << myList.getLast() << endl;

    myList.removeFirst();

    cout << myList << endl;
    cout << myList.getFirst() << endl;
    cout << myList.getLast() << endl;

    myList.removeFirst();

    cout << myList << endl;

    try {
            cout << myList.getFirst() << endl;
            cout << "done" << endl;
    }

    catch (logic_error e) {
            cout << e.what() << endl;
    }
    */

    return 0;
}



