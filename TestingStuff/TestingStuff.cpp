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

    vector<vector<int>> test;


    test.insert(test.begin(), { 3,6 });

    cout << test[0][0] << " " << test[0][1] << endl;

    test.insert(test.begin(), { 4,9 });

    cout << test[0][0] << " " << test[0][1] << " " << test[1][0] << " " << test[1][1] << endl;

    /*string v[] = { "123", "abc", "xyz" };*/

    int index = distance(v.begin(), find(v.begin(), v.end(), "abc"));
    cout << index << endl;

    v.insert(v.begin()+1, "def");

    index = distance(v.begin(), find(v.begin(), v.end(), "abc"));
    cout << index << endl;

    if ("seol" < "seil") {
        cout << "yup" << endl;
    }
    if ("reil" > "seil") {
        cout << "yup" << endl;
    }

    vector<string> t2 = { "aaa", "aac", "aba" };
    int i = 0;

    for (; i < t2.size(); i++)
    {
        if (t2[i] > "aab") {
            break;
        }
    }
    t2.insert((t2.begin() + i), "aab");

    for (i = 0; i < t2.size(); i++)
    {
        if (t2[i] > "aad") {
            break;
        }
    }
    t2.insert((t2.begin() + i), "aad");

    cout << index << endl;

    for (size_t i = 0; i < t2.size(); i++)
    {
        cout << t2[i] << " ";
    }

    return 0;
}

