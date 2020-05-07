#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{   
    /*vector<string> v;
    v.push_back("123");
    v.push_back("abc");
    v.push_back("xyz");*/

    string v[] = { "123", "abc", "xyz" };

    int index = distance(v, find(v, v+4, "abc"));
    cout << index << endl;

    return 0;
}

