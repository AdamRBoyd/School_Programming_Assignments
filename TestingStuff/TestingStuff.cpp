#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{   
    vector<string> v;
    v.push_back("123");
    v.push_back("abc");
    v.push_back("xyz");

    if (find(v.begin(), v.end(), "abc") == v.end())
    {
        cout << "Not found" << endl;
    }
    else {
        cout << "Found" << endl;
    }

    return 0;
}

