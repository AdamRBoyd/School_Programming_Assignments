#include <iostream>

using namespace std;

int main()
{   
    int test[9] = { 9,8,7,6,5,4,3,2,1 };
    int* t2 = test + 2;

    for (int i = 0; i < 9; i++) {
        cout << t2[i] << endl;
    }

    return 0;
}

