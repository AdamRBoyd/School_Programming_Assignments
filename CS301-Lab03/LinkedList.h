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
    // int length;
public:
    LinkedList() {
        headPtr = nullptr;
    }

    LinkedList(const LinkedList<T>& other) {
        if (other.headPtr == nullptr)
            headPtr = nullptr;
        else {
            headPtr = new Node<T>(other.headPtr->data);
            Node<T>* otherCurrent = other.headPtr->next;
            Node<T>* pre = headPtr;
            while (otherCurrent != nullptr) {
                pre->next = new Node<T>(otherCurrent->data);
                pre = pre->next;
                otherCurrent = otherCurrent->next;
            }

        }

    }

    ~LinkedList() {
        clear();
    }

    void insertFirst(const T& d) {
        Node<T>* toInsert = new Node<T>(d, headPtr, nullptr);
        headPtr = toInsert;
    }
    void removeFirst() {
        if (headPtr == nullptr)
            return;
        Node<T>* temp = headPtr;
        headPtr = headPtr->next;
        if(headPtr != nullptr && headPtr->next != nullptr)
            headPtr->next->prev = nullptr;
        delete temp;
    }
    T getFirst() const {
        if (headPtr == nullptr)
            throw logic_error("Can't get first for an empty list.");
        return headPtr->data;
    }

    //insertLast, removeLast
    void insertLast(const T& d) {
        Node<T>* current = headPtr;
        if (headPtr != nullptr) {
            while (current->next != nullptr)
                current = current->next;
        }
        Node<T>* toInsert = new Node<T>(d, nullptr, current);
        current->next = toInsert;
    }

    void removeLast() {
        if (headPtr == nullptr)
            throw logic_error("Can't remove last for an empty list.");
        Node<T>* current = headPtr;
        while (current->next != nullptr)
            current = current->next;

        Node<T>* temp = current;
        current->prev->next = nullptr;
        delete temp;
    }

    T getLast() const {
        if (headPtr == nullptr)
            throw logic_error("Can't get last for an empty list.");
        Node<T>* current = headPtr;
        while (current->next != nullptr)
            current = current->next;
        return current->data;
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
    }

    int getLength() {
        if (headPtr == nullptr)
            return 0;
        Node<T>* current = headPtr;
        int count = 1;
        while (current->next != nullptr) {
            current = current->next;
            count++;
        }
        return count;
    }
//reverse method
    void reverse() {

    }

};


#endif

#pragma once
