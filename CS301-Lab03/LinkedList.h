#ifndef LINKED_LIST_H
#define LINKED_LIST_H
#include <iostream>

using namespace std;

template <class T>
class Node {
public:
    T data;
    Node<T>* next;

    Node(const T& d = T(), Node<T>* n = nullptr) {
        data = d;
        next = n;
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
        Node<T>* toInsert = new Node<T>(d, headPtr);
        headPtr = toInsert;
    }
    void removeFirst() {
        //if (headPtr == nullptr)
        //      throw logic_error("Can't remove from an empty list.");
        if (headPtr == nullptr)
            return;
        Node<T>* temp = headPtr;
        headPtr = headPtr->next;
        delete temp;
    }
    T getFirst() const {
        if (headPtr == nullptr)
            throw logic_error("Can't get first for an empty list.");
        return headPtr->data;
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


};


#endif

#pragma once
