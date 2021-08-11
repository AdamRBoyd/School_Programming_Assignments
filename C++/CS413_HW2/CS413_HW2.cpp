#include <iostream>
#include <vector>
#include <map>

using namespace std;

int findDuplicates(vector<int> myVec, int n) {
    map<int,int> myMap;
    map<int,int>::iterator it;
    int dup = 0;

    for (int i = 0; i < n; i++) {   //Linear
        it = myMap.find(myVec[i]);   //Logarithmic
        if (it != myMap.end()) {
            dup++;
        }
        else {
            myMap.insert(pair<int,int>(myVec[i],1));   //Logarithmic
        }
    }
    
    return dup;
}

int main(){

    vector<int> myVec;

    int n, x;

    cout << "Enter number of elements: ";
    cin >> n;

    for (int i = 0; i < n; i++) {
        cout << "Enter Element " << i+1 << ": ";
        cin >> x;
        myVec.push_back(x);
    }

    cout << "\nTotal duplicates: " << findDuplicates(myVec,n) << endl;

    return 0;
}


