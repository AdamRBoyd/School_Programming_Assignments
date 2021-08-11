// CS413 Project 1
// Adam Boyd - xv3543

#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

int main()
{
    vector<int> v;
    ifstream myfile("input.txt");
    int x, count = 0, size = 0;

    if (myfile.is_open()) {
        myfile >> size;

        while (myfile >> x) {
            v.push_back(x);
        }
        myfile.close();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (v[j] < v[i]) count++;
            }
        }
    }
    else {
        cout << "\nError: Unable to Open File!\n" << endl;
        return 0;
    }

    cout << "\nFile: input.txt\nCount: " << count << endl << endl;

    return 0;
}