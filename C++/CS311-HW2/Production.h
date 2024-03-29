#pragma once
#ifndef PRODUCTION_H
#define PRODUCTION_H

#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>
#include <time.h>
#include <iterator>

using namespace std;

class Production{
private:
	vector<string> rhs_options; // list of options for expansion
	vector<double> trans_probs; // list of probabilities associated with each choice 

public:
	Production(const vector<string> vs, const vector<double> vd) {
		rhs_options = vs;

		if (vd.at(0) == 1) {  //aka weight doesn't matter for this element [A-Z][a-z][0-9]etc...
			trans_probs = vd;
		}
		else {
			double cumul = 0;
			for (int i = 0; i < vd.size(); i++) {
				cumul += vd.at(i);
				trans_probs.push_back(cumul);
			}
		}
	}

	string expand() const {		//returns one of the rhs choices using a random number generator
		
		//if weight matters
		if (trans_probs[0] != 1) {
			double random = ((double)rand() / (RAND_MAX));

			auto low = lower_bound(trans_probs.begin(), trans_probs.end(), random);
			int index = distance(trans_probs.begin(), low);
			
			return rhs_options.at(index);
		}

		//if weight doesn't matter -> such as which number or letter to pick
		string test = rhs_options.at(rand() % rhs_options.size());
		
		return test;
	}
};

#endif // !PRODUCTION_H

