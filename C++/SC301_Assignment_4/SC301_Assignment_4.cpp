#include <exception>
#include <cmath>
#include <sstream>
#include "LinkedStack.h"

double toDouble(const string& s);
double factorial(double n);
void updateTheStack(const string & tok, LinkedStack<double> & stk);

int main() {        // Main should NOT be changed!

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

/*<<<<<<<<<<<<<<<<<<<<<<<<  My Code  <<<<<<<<<<<<<<<<<<<<<<<<*/

double factorial(double n) {
    if (n <= 1) return 1;
    return factorial(n - 1) * n;    //recursive factorial
}

void updateTheStack(const string& tok, LinkedStack<double>& stk) {

    if (isdigit(static_cast<double>(tok[0]))) {     //if its a number, convert then push it to the stack
        stk.push(toDouble(tok));
    }
    else {
        double x, y, p;     //two operrands and one for power checking
        y = stk.top();
        stk.pop();
        if (tok != "!" && tok != "~") {     //! and ~ only need the one opperand
            if (stk.isEmpty()) throw logic_error("Not enough operands");
            x = stk.top();
            stk.pop();
        }

        //+, -, *, /, ^, !, ~
        switch (tok[0]) {
        case '+':
            stk.push(x + y);
            break;
        case '-':
            stk.push(x - y);
            break;
        case '*':
            stk.push(x * y);
            break;
        case '/':
            if (y == 0) throw range_error("Illegal operation");     // div by 0
            else stk.push(x / y);
            break;
        case '^':
            p = pow(x, y);
            if (isinf(p) || isnan(p)) throw range_error("Illegal operation");
            else stk.push(p);
            break;
        case '!':
            stk.push(factorial(y));
            break;
        case '~':
            stk.push(-y);
            break;
        default:
            throw logic_error("Unsupported operator");
            break;
        }
    }
}
