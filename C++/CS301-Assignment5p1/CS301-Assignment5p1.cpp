// CS301 Section 2 - Assignment 5 pt 1
// Adam Boyd
// xv3543

#include <iostream>
#include <utility>

using namespace std;

int counter = 0;

//  slowsort
void slowsort(int  a[], int n) {
    if (n <= 1) return;
    slowsort(a + 1, n - 1);
    counter++;
    if (a[0] > a[1]) {  // item comparison
        swap(a[0], a[1]);
    }
    slowsort(a + 1, n - 1);
}

int main()
{
    int test[20];

    for (int i = 20, j = 0; i > 0; i--, j++) {
        test[j] = i;
    }

    cout << "Array Size\tItem comparisons" << endl;
    for (int i = 1; i <= 20; i++) {
        slowsort(test + 20 - i, i);
        cout << i << "\t\t" << counter << endl;
        counter = 0;
    }

    cout << endl;
    return 0;
}

