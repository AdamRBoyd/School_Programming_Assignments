#include <iostream>
#include <cctype>

using namespace std;

int reverse(int num, int rev) {
	if (0 == num) return rev;
	rev = (rev * 10) + (num % 10);
	return reverse(num / 10, rev);
}

int main()
{
	while(true){
		int num, rev = 0;
		char exit;

		cout << "Enter Number: ";
		cin >> num;

		rev = reverse(num,rev);

		if (rev == num) cout << "Yes, " << num << " is a palindrome" << endl;
		else cout << "No, " << num << " is not a palindrome" << endl;

		cout << "Check another number? (Y/N): ";
		cin >> exit;

		if (!(toupper(exit) == 'Y')) break;

		cout << endl;
	}

	return 0;
}

