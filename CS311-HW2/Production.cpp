#include <iostream>
#include <vector>
#include <unordered_map>
#include <utility>
#include <algorithm>
#include <cstdlib>
#include <time.h>
#include "Production.h"

using namespace std;

//string lhs;
//vector<string> rhs_options; // list of options for expansion
//vector<double> trans_probs; // list of probabilities associated with each choice 

Production::Production(){

}

Production::Production(string s){

}

void Production::add_rhs(string s, double d) {		//adds new rhs to the production
	rhs_options.push_back(s);
	if (!trans_probs.empty()) {		//Add probability to the total for cumulative probability
		d += trans_probs.back();
	}
	trans_probs.push_back(d);
}

string Production::expand() const {		//returns one of the rhs choices using a random number generator
	srand(time(NULL));
	double random = ((double)rand() / (RAND_MAX));

	auto low = lower_bound(trans_probs.begin(), trans_probs.end(), random);
	return rhs_options.at(low);
}