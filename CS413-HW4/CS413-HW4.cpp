#include <iostream>

using namespace std;

int reverse(int num, int rev) {
	if (0 == num) return rev;
	rev = (rev * 10) + (num % 10);

	return reverse(num / 10, rev);
}

int main()
{
	int num, rev = 0;
	do
	{	
		char c = 'n';
		bool exit = true;

		cout << "Enter Number: ";
		cin >> num;

		rev = reverse(num,rev);

		if (rev == num) cout << "Yes, " << num << " is a palindrome" << endl;
		else cout << "No, " << num << " is not a palindrome" << endl;

		cout << "Check another number? (Y/N): ";
		cin >> c;

		if ('Y' == c || 'y' == c) exit = false;

	} while (exit);

	return 0;
}

