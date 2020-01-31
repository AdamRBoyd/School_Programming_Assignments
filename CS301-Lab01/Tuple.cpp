// CS301 Section 2 - Lab 01
// Adam Boyd

#include "Tuple.h"
#include <iostream>
using namespace std;


Tuple::Tuple(int init) {
	for (int i = 0; i < SIZE; i++) {
		items[i] = init;
	}
}

int Tuple::get(int n) const {
	return items[n-1];
}

void Tuple::set(int position, int value) {
	if (position > SIZE || position <= 0) return;
	if (value < MINVALUE) value = MINVALUE;
	if (value > MAXVALUE) value = MAXVALUE;

	items[position-1] = value;
}


void Tuple::rotate(int amount) {
	if ((amount <= 0) || (amount % SIZE == 0)) return;
	amount %= SIZE;
	
	int temp[SIZE];

	//create temporary array to hold original values
	copy(begin(items), end(items), begin(temp)); 

	for (int i = 0; i < SIZE; i++) {
		int pos = i + amount;
		if (pos >= SIZE) pos -= SIZE; //reset to beginning of items array if end is reached

		items[pos] = temp[i];
	}
}

void Tuple::reverse() {
	int temp[SIZE];
	copy(begin(items), end(items), begin(temp));

	for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
		items[i] = temp[j];
	}
}


void Tuple::print() const {
	cout << "{";
	for (int i = 0; i < SIZE; i++) {
		cout << items[i];
		if (i < SIZE - 1) cout << ",";
	}
	cout << "}\n";
}

double Tuple::getAverage() const {
	int total = 0;
	for (int i = 0; i < SIZE; i++) {
		total += items[i];
	}
	total /= SIZE;
	return total;
}

void Tuple::sort() {
	bool FLAG = true;
	for (int i = 0; i <= SIZE && FLAG; i++) {
		FLAG = false;
		for (int j = 0; j < SIZE - 1; j++) {
			if (items[j + 1] < items[j]) {
				int temp = items[j];
				items[j] = items[j + 1];
				items[j + 1] = temp;
				FLAG = true;
			}
		}
	}
}


bool Tuple::equal(const Tuple& t) const {
	for (int i = 0; i < SIZE; i++) {
		if (t.items[i] != items[i]) return false;	
	}
	return true;
}


bool Tuple::equalBags(const Tuple& t) const {
	int temp1[SIZE];
	int temp2[SIZE];

	copy(begin(items), end(items), begin(temp1));
	copy(begin(t.items), end(t.items), begin(temp2));
	
	bool FLAG = true;
	for (int i = 0; i <= SIZE && FLAG; i++) {
		FLAG = false;
		for (int j = 0; j < SIZE - 1; j++) {
			if (temp1[j + 1] > temp1[j]) {
				int temp = temp1[j];
				temp1[j] = temp1[j + 1];
				temp1[j + 1] = temp;
				FLAG = true;
			}
		}
	}
	
	FLAG = true;
	for (int i = 0; i <= SIZE && FLAG; i++) {
		FLAG = false;
		for (int j = 0; j < SIZE - 1; j++) {
			if (temp2[j + 1] > temp2[j]) {
				int temp = temp2[j];
				temp2[j] = temp2[j + 1];
				temp2[j + 1] = temp;
				FLAG = true;
			}
		}
	}

	for (int i = 0; i < SIZE; i++) {
		if (temp1[i] != temp2[i]) return false;
	}

	return true;
}