// TestingStuff.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
#pragma once
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <sstream>
#include <unordered_map>

using namespace std;

void testing(int n) {
    if (n == 0) return;
    testing(n - 1);
    cout << "-";
}

int main()
{   
    
    testing(3);
    cout << endl;
    testing(4);
    cout << endl;
    testing(10);
    cout << endl;
    testing(2);
    cout << endl << endl;
    return 0;
}

