#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int func(int arr[], int n, int key){
    int i;
    for(i = 0; i < n; i++)
        if(arr[i] == key)
            return i;
    return -1;
}

int main()
{   
    int arr[9] = { 1,2,3,4,5,6,7,8,9 };
    
    cout << func(arr, 9, 1) << endl;
    cout << func(arr, 9, 2) << endl;
    cout << func(arr, 9, 3) << endl;
    cout << func(arr, 9, 4) << endl;
    cout << func(arr, 9, 5) << endl;
    cout << func(arr, 9, 12) << endl;

    return 0;
}

