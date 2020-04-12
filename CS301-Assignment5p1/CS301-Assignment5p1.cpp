// CS301 Section 2 - Assignment 5 pt 1
// Adam Boyd
// xv3543

#include <iostream>
#include <utility>

using namespace std;

//  slowsort (modified)
int slowsort(int  a[], int n) {
    int count = 0;
    if (n <= 1) {
        return count;
    }
    count += slowsort(a + 1, n - 1);
    count++;
    if (a[0] > a[1]) {  // item comparison
        swap(a[0], a[1]);
    }
    count += slowsort(a + 1, n - 1);
    return count;
}

int main()
{
    int test[20];

    for (int i = 20, j = 0; i > 0; i--, j++) {
        test[j] = i;
    }

    cout << "Array Size\tItem comparisons" << endl;
    for (int i = 1; i <= 20; i++) {
        cout << i << "\t\t";
        cout << slowsort(test + 20 - i, i) << endl;
    }

    cout << endl;
    return 0;
}

