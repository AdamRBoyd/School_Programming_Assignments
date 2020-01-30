// CS301 Section 2 - Lab 01
// Adam Boyd

#include <iostream>
#include "Tuple.h"

using namespace std;

void testSet() {
    cout << "BEGIN TESTSET" << endl;
    Tuple t;
    t.print();
    for (int i = 1; i <= Tuple::SIZE; i++)
        t.set(i, Tuple::MINVALUE + i);
    t.print();
    t.set(Tuple::SIZE + 100, Tuple::MAXVALUE);
    t.set(0, Tuple::MINVALUE);
    t.print();
    t.set(1, Tuple::MAXVALUE - 1);
    t.set(Tuple::SIZE, Tuple::MINVALUE + 1);
    t.print();
    t.set(1, Tuple::MAXVALUE + 1);
    t.set(Tuple::SIZE, Tuple::MINVALUE - 1);
    t.print();
    cout << "END TESTSET" << endl << endl;
}

void testSort()
{
    cout << "BEGIN TESTSORT" << endl;
    Tuple t;
    for (int i = Tuple::SIZE; i > 1; i--)
        t.set(i - 1, t.get(i) + 1);
    t.print();
    t.sort();
    t.print();
    t.set(1, Tuple::MAXVALUE);
    t.print();
    t.sort();
    t.print();
    cout << "END TESTSORT" << endl << endl;
}

void testReverse()
{
    cout << "BEGIN TESTREVERSE" << endl;
    Tuple t((Tuple::MINVALUE + Tuple::MAXVALUE) / 2);
    for (int i = 1; i < Tuple::SIZE; i++)
        t.set(i + 1, t.get(i) + 1);
    t.print();
    t.reverse();
    t.print();
    t.reverse();
    t.print();
    cout << "END TESTREVERSE" << endl << endl;
}

void testRotate()
{
    cout << "BEGIN TESTROTATE" << endl;
    Tuple t;
    for (int i = 1; i < Tuple::SIZE; i++)
        t.set(i + 1, t.get(i) + 1);
    t.print();
    for (int i = -1; i <= 2 * Tuple::SIZE; i++) {
        Tuple u = t;
        u.rotate(i);
        u.print();
    }
    cout << "END TESTROTATE" << endl << endl;
}


int main()
{
    testSet();
    testSort();
    testReverse();
    testRotate();
    return 0;
}
