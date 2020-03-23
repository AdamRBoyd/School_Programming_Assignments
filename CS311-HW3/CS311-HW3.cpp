/*
Write a program (in C, C++, C#, Java, or Python) that implements a simple scanner for a source file given as a command-line argument.
The format of the tokens is described below. You may assume that the input is syntactically correct.
Your program should build a symbol table which contains an entry for each token that was found in the input.

When all the input has been read, your program should produce a summary report that includes:
	- a list of all the tokens that appeared in the input.
	- the number of times each token appears in the input.
	- the class of each token.
	- how many times tokens of each class appeared in the input.

The grammar for producing tokens is as follows:

keyword ::= if | then | else | begin | end
identifier -> character | character identifier
integer -> digit | digit integer
real -> integer.integer
special -> ( | ) | [ | ] | + | - | = | , | ;

digit -> 0|1|2|3|4|5|6|7|8|9
character -> a|b|c ... |z|A|B|C ... |Z

More details:
Case is not used to distinguish keywords or identifiers.
The delimiters are space, tab, newline, and the special characters.  " ()[]+-=,;\t\n"
The token classes that should be recognized are keyword, identifier, integer, real and special.
 */

#include <iostream>
#include <unordered_map>
#include <fstream>
#include <string>

using namespace std;

int main()
{
	unordered_map<string, int> keyword = { {"count", 0}, {"if", 0}, {"then", 0}, {"else", 0}, {"begin", 0}, {"end", 0} };
	unordered_map<string, int> identifier = { {"count", 0} };
	unordered_map<string, int> integer = { {"count", 0} };
	unordered_map<string, int> real = { {"count", 0} };
	unordered_map<string, int> special = { {"count", 0}, {"(" , 0}, {")" , 0}, {"[" , 0}, {"]" , 0}, {"+" , 0}, {"-" , 0}, {"=" , 0}, {"," , 0}, {";" , 0} };
	string infile, line, tok = " ",
		delim = "()[]+-=,; \t\n",
		token = "",
		alpha = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz",
		numbDot = "1234567890.";
	string keyw[] = { "if", "then", "else", "begin", "end" };
	size_t found;

	cout << "Please enter a file to analyze: ";
	cin >> infile;

	cout << endl;

	ifstream myfile;
	myfile.open(infile);

	if (myfile.is_open()) {
		while (getline(myfile, line)) {
			//Reading/Compiling Code here...

			//find first delim/token
			found = line.find_first_of(delim);
			token = line.substr(0, found);

			//begin and end are on their own lines with no delimiters... find those
			if (found == string::npos && line.size() > 0) {
				if (token.compare("begin") == 0) {
					keyword.at("begin")++;
					keyword.at("count")++;
				}
				else if (token.compare("end") == 0) {
					keyword.at("end")++;
					keyword.at("count")++;
				}
			}

			//find between delimiters
			while (found != string::npos) {
				if (line[found] != '\t' && line[found] != '\n' && line[found] != ' ') {	//log special
					tok[0] = line[found];
					special.at(tok)++;
					special.at("count")++;
				}
				size_t found2 = line.find_first_of(delim, found + 1);
				if ((found + 1) != found2) {    //not empty token aka between ()
					token = line.substr(found + 1, (found2 - found - 1));
					bool keyF = false;

					if (token != "") {
						//analyze token for possible match to keyword terms
						for (int i = 0; i < 5; i++) {
							if (keyw[i].compare(token) == 0) {
								keyword.at(token)++;
								keyword.at("count")++;
								keyF = true;
								break;
							}
						}

						if (!keyF) {
							//Any integer must be all numbers or number plus '.' (ie 0.05 or 1234)
							size_t integ = token.find_first_not_of(numbDot);  //integer or real
							if (integ == string::npos) {
								integ = token.find_first_of('.');  //separate integer from real, if string doesn't have '.' then npos and is integer 
								if (integ == string::npos) {    //integer
									if (integer.find(token) != integer.end()) { //token already in map
										integer.at(token)++;
									}
									else {  //does not exist, add it
										integer.emplace(token, 1);
									}
									integer.at("count")++;
									keyF = true;
								}
								else {  //real
									if (real.find(token) != real.end()) { //token already in map
										real.at(token)++;
									}
									else {  //does not exist, add it
										real.emplace(token, 1);
									}
									real.at("count")++;
									keyF = true;
								}
							}
						}

						if (!keyF) {
							//Anycharacter must be only chars?
							size_t ident = token.find_first_not_of(alpha);
							if (ident == string::npos) {    //is a character only string
								if (identifier.find(token) != identifier.end()) {	//token already in map
									identifier.at(token)++;
								}
								else {		//does not exist, add it
									identifier.emplace(token, 1);
								}
								identifier.at("count")++;
							}
						}
					}
				}

				found = line.find_first_of(delim, found2);
			}

		}
		myfile.close();
		//Printing code here...
		cout << "\nReport for file: " << infile << endl;
		//print keyword
		cout << "\n--- Class Keyword ---" << endl;
		for (int i = 0; i < 5; i++) {
			if (keyword.at(keyw[i]) > 0) {
				cout << keyw[i] << " - " << keyword.at(keyw[i]) << endl;
			}
		}
		cout << "Keyword Token Count - " << keyword.at("count") << endl;

		//print identifier
		cout << "\n--- Class Identifier ---" << endl;
		for (auto i : identifier) {
			if (i.first != "count") {
				cout << i.first << " - " << i.second << endl;
			}
		}
		cout << "Identifier Token Count - " << identifier.at("count") << endl;

		//print integer
		cout << "\n--- Class Integer ---" << endl;
		for (auto i : integer) {
			if (i.first != "count") {
				cout << i.first << " - " << i.second << endl;
			}
		}
		cout << "Integer Token Count - " << integer.at("count") << endl;

		//print real
		cout << "\n--- Class Real ---" << endl;
		for (auto i : real) {
			if (i.first != "count") {
				cout << i.first << " - " << i.second << endl;
			}
		}
		cout << "Real Token Count - " << real.at("count") << endl;

		//print special characters
		cout << "\n--- Class Special ---" << endl;
		for (int i = 0; i < 9; i++) {
			tok[0] = delim[i];
			if (special.at(tok) > 0) {
				cout << tok << " - " << special.at(tok) << endl;
			}
		}
		cout << "Special Token Count - " << special.at("count") << endl;


	}
	else {
		cout << "Unable to find file!" << endl;
	}

	cout << endl;
	return 0;
}
