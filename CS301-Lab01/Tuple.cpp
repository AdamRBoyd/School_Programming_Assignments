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
	if (position > SIZE - 1) {
		cout << "Invalid Position - " << position << " Not in Range!;
		return;
	}
	if (value < MINVALUE || value > MAXVALUE) {
		cout << "Invalid Value - " << value << " Not in Range!!";
		return;
	}
	items[position-1] = value;
}


void Tuple::rotate(int amount) {  //<----------Finish!!
	amount %= SIZE;
	if (amount == 0) return;

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

	for (int i = 0, int j = SIZE - 1; i < SIZE; i++, j--) {
		items[i] = temp[j];
	}
}


void Tuple::print() const {
	cout << "{";
	for (int i = 0; i < SIZE; i++) {
		cout << items[i];
		if (i < SIZE - 1) cout << ", ";
	}
}

double Tuple::getAverage() const {



}


void Tuple::sort() {




}


bool Tuple::equal(const Tuple& t) const {



}


bool Tuple::equalBags(const Tuple& t) const {



}