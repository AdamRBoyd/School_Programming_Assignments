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

#ifndef LINKED_LIST_H
#define LINKED_LIST_H

#include <iostream>

using namespace std;

template <class T>
class Node {
public:
    T data;
    Node<T>* next;
    Node<T>* prev;

    Node(const T& d = T(), Node<T>* n = nullptr, Node<T>* p = nullptr) {
        data = d;
        next = n;
        prev = p;
    }
};

template <class T>
class LinkedList {
    friend ostream& operator<<(ostream& out, const LinkedList<T>& list)
    {
        out << "{ ";
        Node<T>* current = list.headPtr;
        while (current != nullptr) {
            out << current->data << " ";
            current = current->next;
        }
        out << "}";
        return out;
    }
private:
    Node<T>* headPtr;
    Node<T>* tailPtr;
    int length = 0;

public:
    LinkedList() {
        headPtr = nullptr;
        tailPtr = nullptr;
    }

    LinkedList(const LinkedList<T>& other) {
        if (other.headPtr == nullptr) {
            headPtr = nullptr;
            tailPtr = nullptr;
        }
        else {
            headPtr = new Node<T>(other.headPtr->data);
            Node<T>* otherCurrent = other.headPtr->next;
            Node<T>* pre = headPtr;
            while (otherCurrent != nullptr) {
                pre->next = new Node<T>(otherCurrent->data);
                if (otherCurrent->next == nullptr)
                    tailPtr = pre;
                pre = pre->next;
                otherCurrent = otherCurrent->next;
                length++;
            }
        }
    }

    ~LinkedList() {
        clear();
    }

    void insertFirst(const T& d) {
        Node<T>* toInsert = new Node<T>(d, headPtr, nullptr);
        if(headPtr != nullptr)
            headPtr->prev = toInsert;
        headPtr = toInsert;
        if (headPtr->next == nullptr) {
            tailPtr = headPtr;
        }
        length++;   
    }

    void removeFirst() {
        if (isEmpty())
            return;
        Node<T>* temp = headPtr;
        headPtr = headPtr->next;
        if(headPtr != nullptr && headPtr->next != nullptr)
            headPtr->next->prev = nullptr;
        length--;
        delete temp;
    }

    T getFirst() const {
        if (isEmpty())
            throw logic_error("Can't get first for an empty list.");
        return headPtr->data;
    }

    //insertLast
    void insertLast(const T& d) {
        Node<T>* toInsert = new Node<T>(d, nullptr, tailPtr);
        tailPtr->next = toInsert;
        tailPtr = toInsert;
        length++;
    }

    //removeLast
    void removeLast() {
        if (isEmpty())
            throw logic_error("Can't remove last for an empty list.");
        
        Node<T>* temp = tailPtr;
        tailPtr->prev->next = nullptr;
        tailPtr = tailPtr->prev;
        length--;
        delete temp;
    }

    //getLast
    T getLast() const {
        if (isEmpty())
            throw logic_error("Can't get last for an empty list.");
        return tailPtr->data;
    }

    bool isEmpty() const {
        return headPtr == nullptr;
    }

    void setFirst(const T& d) {
        if (!isEmpty())
            headPtr->data = d;

    }

    void clear() {
        while (!isEmpty())
            removeFirst();
        length = 0;
    }

    int getLength() {
        return length;
    }

    //reverse
    void reverse() {
        if (isEmpty())
            return;
        
        Node<T>* current = headPtr;
        while (current != nullptr) {
            swap(current->next, current->prev);
            current = current->prev;
        }

        swap(headPtr, tailPtr);
        /*OR swap head and tail ptr locations without swap function
        Node<T>* temp = headPtr;
        headPtr = tailPtr;
        tailPtr = temp;*/
    }
};


#endif

