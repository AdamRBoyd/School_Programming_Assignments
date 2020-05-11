#include <iostream>

using namespace std;

void printPath(int parents[], int size, int startv, int endv) {
    if (startv == endv) {
        cout << endv;
        return;
    }
    if (parents[endv] < 0 || parents[endv] > size-1) {
        cout << "Unreachable from vertex " << startv;
        return;
    }
    if (endv != startv) {
        printPath(parents, size, startv, parents[endv]);
    }
    
    cout << " --> " << endv;
}

void printAllPaths(int parents[], int size) {
    //find starting index
    int i = 0;
    for (; i < size; i++)
    {
        if (parents[i] = i)
            cout << "found" << endl;
            break;
    }

    for (int j = 0; j < size; j++)
    {
        cout << j << ": ";
        printPath(parents, size, i, j);
        cout << endl;
    }
}

int main()
{
    int parents[] = { 0, 2, 0, 1, -1, 0 }, size = 6;
    printAllPaths(parents, size);
}
