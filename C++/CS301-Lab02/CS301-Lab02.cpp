// CS301-Lab02.cpp : This file contains the 'main' function. Program execution begins and ends there.

/*Implement a function double getRoot (double x, int n). 
The function should return the nth root of x. 
Use the same algorithm as in the squareRoot function posted above. 
The difference is that instead of using mid*mid in the test you'll need mid to the power n in the test. 
That means you will need to write a helper function to take powers, which should also be recursive.

No use of <cmath> allowed. No loops.

Upload a .cpp with your getRoot function and a main that calls the function at least once.*/

#include <iostream>

using namespace std;

double powerHelper(double x, int n) {
    if (n == 0) return 1.0;
    if (n % 2 == 0) return powerHelper(x * x, n / 2);
    return (x * powerHelper(x * x, (n - 1) / 2));
}

double rootHelper(double x, double low, double high, int n) {
    if (high - low < 0.000001) return low;
    double mid = (low + high) / 2.0;
    if (powerHelper(mid, n) > x)
        return rootHelper(x, low, mid, n);
    return rootHelper(x, mid, high, n);
}

double root(double x, int n) {
    if (x < 1)  return rootHelper(x, x, 1, n);
    return rootHelper(x, 1, x, n);
}

int main()
{
    int x, p;

    while (true) {
        cout << "Enter your number (Enter 0 to exit): ";
        cin >> x;
        if (x == 0) return 0;
        cout << "Enter the power: ";
        cin >> p;

        cout << x << " with a root of " << p << " is " << root(x, p) << endl << endl;
    }

    return 0;
}
