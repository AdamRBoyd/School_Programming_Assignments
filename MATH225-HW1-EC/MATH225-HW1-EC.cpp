#include <iostream>
#include <math.h>

using namespace std;

int factorial(int n) {
	if (n > 1) return n * factorial(n - 1);
	else return 1;
}

int main()
{
	bool run;
	do {
		int terms, neg = 1;
		double tot1 = 1, tot2 = 1, x;
		char c;
		run = false;

		do {
			cout << "Enter x: ";
			cin >> x;
			if (x < 0) cout << "x must be greater than or equal to 0!" << endl;
		} while (x < 0);


		do {
			cout << "Enter number of terms: ";
			cin >> terms;
			if (terms <= 0) cout << "Terms must be greater than 0!" << endl;
		} while (terms <= 0);


		//Approx 1
		if (terms > 1) {
			tot1 -= x;
			if (terms > 2)
				for (int i = 2; i <= terms; i++) {
					tot1 += neg * ((pow(x, i)) / factorial(i));
					neg *= -1;
				}
		}

		//Approx 2
		if (terms > 1) {
			tot2 += x;
			if(terms > 2)
				for (int i = 2; i <= terms; i++) {
					tot2 += ((pow(x, i)) / factorial(i));
				}
			tot2 = 1 / tot2;
		}

		double e = 1 / (exp(x));

		cout << "\nActual Value of e^" << x << " = " << e << endl << endl;

		cout << "Approximation 1: " << tot1 << endl;
		cout << "Absolute Error: " << (abs(e - tot1)) << endl;
		cout << "Relative Error: " << (abs(e - tot1)) / abs(e) << endl;
			   
		cout << "\nApproximation 2: " << tot2 << endl;
		cout << "Absolute Error: " << (abs(e - tot2)) << endl;
		cout << "Relative Error: " << (abs(e - tot2)) / abs(e) << endl;

		cout << "\nRun again? (y/n): ";
		cin >> c;

		if (c == 'y') run = true;
		cout << endl;

	} while (run);

	return 0;
}

