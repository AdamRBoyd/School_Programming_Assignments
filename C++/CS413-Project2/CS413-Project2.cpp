#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

int merge(vector<int> arr, vector<int>& temp, int left, int mid, int right)     //O(n)
{
    int count = 0;

    int i = left;   // i is index for left subarray
    int j = mid;    // j is index for right subarray

    while ((i <= mid - 1) && (j <= right)) {
        if (arr.at(i) <= arr.at(j)) {
            temp.push_back(arr[i++]);
        }
        else {
            temp.push_back(arr[j++]);
            count = count + (mid - i);
        }
    }
    // Add remaining elements of left subarray (if any)
    while (i <= mid - 1) temp.push_back(arr[i++]);
    // Add remaining elements of right subarray (if any)
    while (j <= right) temp.push_back(arr[j++]);

    return count;
}


int mergeSort(vector<int> arr, vector<int>& temp, int left, int right)  //T(n) = 2T(n/2) + O(n) => O(nlogn)
{
    int mid, count = 0;
    if (right > left) {
        mid = (right + left) / 2;

        count += mergeSort(arr, temp, left, mid);           //T(n/2)
        count += mergeSort(arr, temp, mid + 1, right);      //T(n/2)

        count += merge(arr, temp, left, mid + 1, right);    //O(n)
    }
    return count;
}


int main()
{
    int size, x = 0;
    vector<int> v, temp;
    ifstream myfile("input.txt");

    if (myfile.is_open()) {
        myfile >> size;

        while (myfile >> x) {
            v.push_back(x);
        }

        myfile.close();

        cout << "File: input.txt\nCount: " << mergeSort(v, temp, 0, size-1) << endl << endl;
    }
    else {
        cout << "\nError: Unable to Open File!\n" << endl;
        return 0;
    }

    return 0;
}