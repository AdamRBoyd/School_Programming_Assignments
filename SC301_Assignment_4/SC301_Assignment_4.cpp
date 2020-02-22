/*Implement a postfix evaluator using  the main below.  Do not change main.
Support expressions with +, -, *, /,  ^ (power) ,  !  (factorial)  and  ~ (unary minus).  
To make factorial work with type double,  use the algorithm factorial(x) = 1 if x <= 1, otherwise factorial(x) = factorial(x-1) * x.
An example of a postfix expression:  2   3  +  2  *  4  3  2  ^  /   !  ~  - 
In the usual notation that would be written   ( (2 + 3) * 2)    -    ( - ((4   /  (3 ^ 2) !)  .
You'll need to implement the function updateTheStack along with any helper functions you want. 
When there is an out of range operand e.g. when dividing by 0 or when pow gives back infinity or nan  (try using the isInf() and isnan() functions), throw a range_error exception with the message  "Illegal operation."
If the stack becomes empty when you need an operand, throw a logic error exception with the message "Not enough operands."

You will need the following includes:*/

#include <exception>
#include <cmath>
#include <sstream>
#include "LinkedStack.h"    //(Use the  LinkedStack code posted below this on Blackboard. )

//Upload your Assignment4.cpp as your submission.
//(Your code should work with the posted LinkedStack code, so you don't need to upload LinkedStack.h.)

// CODE THAT SHOULD GO IN Assignment4.cpp
void updateTheStack(const string & tok, LinkedStack<double> & stk);  // implementation goes below main.

int main() {

    // 5 6 + means 5 + 6
    // 5 6 3 + * means 5 * (6 + 3)
    // 5 6 3 + * 2 ^ means (5 * (6 + 3)) ^ 2
    // Main should NOT be changed!

    string tok, exp;
    bool done = false;
    // read each line of input as a postfix expression and output the corresponding value

    do {

        cout << "Please type in a postfix expr or Enter to quit: ";

        getline(cin, exp);           // get next expression to process

        if (exp == "") done = true;  // user wants to quit

        else {
            try {

                istringstream in(exp);  // create a stringstream object
                LinkedStack<double> stk;      // create a stack of type double

                in >> tok;              // extract the first token from stream

                while (in)              // loop to process subsequent tokens
                {
                    updateTheStack(tok, stk);
                    in >> tok;          // get next token
                }

                double result = stk.top(); // this should be the final answer

                stk.pop();

                if (stk.isEmpty())
                    cout << exp << "  =  " << result << endl; // success!
                else
                    throw logic_error("Malformed expression"); // too many tokens on stack
            }
            catch (logic_error e) {
                cout << e.what() << endl;  // e.g. malformed expression, unsupported operator, not enough operands
            }
            catch (range_error e) {
                cout << "Range error: " << e.what() << endl;
            }
        }
    } while (!done);

    return 0;
}
// Convert s to a double.

// If conversion fails, throw a logic_error exception.

double toDouble(const string& s) {
    istringstream in(s);
    double x;
    in >> x;
    if (!in) throw logic_error("Bad operand");
    return x;
}

void updateTheStack(const string& tok, LinkedStack<double>& stk) {

}
