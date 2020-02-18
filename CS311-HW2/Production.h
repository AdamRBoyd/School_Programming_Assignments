#pragma once
#ifndef PRODUCTION_H
#define PRODUCTION_H

class Production
{
private:
	string lhs;
	vector<string> rhs_options; // list of options for expansion
	vector<double> trans_probs; // list of probabilities associated with each choice 

public:
	Production();
	Production(string s);
	void add_rhs(string s, double d); // adds new rhs to the production
	string expand() const; // returns one of the rhs choices using a random number generator
};

#endif // !PRODUCTION_H

