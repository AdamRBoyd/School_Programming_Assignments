/*//  slowsort
void slowsort(int  a[], int n) {
    if (n <= 1) return;
    slowsort(a + 1, n - 1);
    if (a[0] > a[1])  // item comparison
        swap(a[0], a[1]);
    slowsort(a + 1, n - 1);
}

Write a tester program that runs slowsort on array sizes n= 1 through n= 20, in which the array values are are  {n-1, n-2, ..., 1, 0}   (e.g. for n = 2  the values are {1,0}). 
Using a suitably placed counter in the slowsort code, your program will count the number of item comparisons for each n and output the results.
Output should look like 

Array Size               Item comparisons
1                        __________
2                        __________
3                        __________
...                      ...
19                       __________
20                       __________

where each blank is filled in by the count for the given array size. Of course the first blank would just be 0 since there are no item comparisons performed when the array size is 1.
Upload your tester program (.cpp) and a screenshot (pic) of a sample run to show your output.*/

#include <iostream>

using namespace std;

//  slowsort 
void slowsort(int  a[], int n) {
    if (n <= 1) return;
    slowsort(a + 1, n - 1);
    cout << "-";
    if (a[0] > a[1])  // item comparison
        swap(a[0], a[1]);
    slowsort(a + 1, n - 1);
    return;
}

int main()
{
    std::cout << "Hello World!\n";
}

