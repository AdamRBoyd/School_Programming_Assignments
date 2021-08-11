/*Implement a void function called lotsAdots that takes an int n as its parameter and outputs 2n dots to the console.  You may assume that the function is only called with an n >= 0. 

Your implementation MUST BE RECURSIVE AND HAVE NO LOOPS.  Also, use of global or static local variables is not allowed, nor are you allowed to call any other functions including anything in the cmath library.*/

#include <iostream>

using namespace std;

void lotsAdots(int n) {
    if (n <= 0) {
        cout << '.';
        return;
    }
    lotsAdots(n - 1);
    lotsAdots(n - 1);
}



int main()
{
    std::cout << "Hello World!\n";
    lotsAdots(0);
    cout << endl;
    lotsAdots(1);
    cout << endl;
    lotsAdots(2);
    cout << endl;
    lotsAdots(3);
    cout << endl;
    lotsAdots(4);
    //--------------------

}