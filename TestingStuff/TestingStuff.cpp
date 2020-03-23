// TestingStuff.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
#pragma once
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <sstream>
#include <unordered_map>

using namespace std;

int main()
{   
    unordered_map<string, int> myMap = { {"count", 0}, {"(" , 0}, {")" , 0}, {"[" , 0}, {"]" , 0}, {"+" , 0}, {"-" , 0}, {"=" , 0}, {"," , 0}, {";" , 0} };
    /*string m = "This is, a test/tstring/nthere+we=go", dl = "()[]+-=,;", t = " ";
    
    size_t found = m.find_first_of(dl);

    while (found != string::npos) {
        t[0] = m[found];
        myMap.at(t)++;
        myMap.at("count")++;
        found = m.find_first_of(dl, found + 1);
    }*/
    string t = " ";

    cout << t.size() << endl;

    if (myMap.find("?") == myMap.end()) {
        myMap.emplace("?", 1);
    }

    for (auto i : myMap) {
        cout << i.first << " - " << i.second << endl;
    }

    return 0;
}

