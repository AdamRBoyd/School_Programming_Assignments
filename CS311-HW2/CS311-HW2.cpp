// Adam Boyd
// CS 311 01
// ID xv3543

#include <iostream>
#include <vector>
#include <unordered_map>
#include <fstream>
#include <string>
#include <cstdlib>
#include <time.h>
#include "Production.h"

using namespace std;

bool findAndIdentify(const string inStr, size_t &beg, size_t &end) {
	beg = inStr.find("<");
	end = inStr.find(">");
	if (beg != string::npos) {
		return true;
	}
	return false;
}

int main() {
	string keyStr, newStr, mainStr = "int main() {\n <stat_list> \nreturn 0; \n}";
	size_t beg, end;
	ofstream myFile;

	srand(time(NULL));
	
	vector<vector<string>> vecStr{ 
		/*<stat_list>*/{"<stat>", "<stat_list> <stat>"}, 
		/*<stat>*/{"<cmpd_stat>", "<if_stat>", "<iter_stat>", "<assgn_stat>", "<decl_stat>"}, 
		/*<cmpd_stat>*/{"{\n\t <stat_list> \n}"}, 
		/*<if_stat>*/{"if (<exp>) <stat>", "if (<exp>) <cmpd_stat>", "if (<exp>) <stat> \nelse <stat>", "if (<exp>) <cmpd_stat> \nelse <stat>", "if (<exp>) <stat> \nelse <cmpd_stat>", "if (<exp>) <cmpd_stat> \nelse <cmpd_stat>"}, 
		/*<iter_stat>*/{"\nwhile (<exp>) {\n\t<stat>\n}\n", "\nwhile (<exp>) {\n\t<cmpd_stat>\n}\n"}, 
		/*<assgn_stat>*/{"<id> = <exp>"}, 
		/*<decl_stat>*/{"<type> <id>", "<type> <assgn_stat>"}, 
		/*<exp>*/{"<exp> <op> <exp>", "<id>", "<const>"}, 
		/*<op>*/{" + "," - "," * "," / "}, 
		/*<type>*/{"\nint ", "\ndouble "}, 
		/*<id>*/{"<char><char_digit_seq>"}, 
		/*<const>*/{"<digit><digit_seq>"}, 
		/*<char_digit_seq>*/{"", "<char><char_digit_seq>", "<digit><char_digit_seq>"}, 
		/*<digit_seq>*/{"", "<digit><digit_seq>"}, 
		/*<char>*/{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"},
		/*<digit>*/{"0","1","2","3","4","5","6","7","8","9"}
	};
	vector<vector<double>> vecDoub{				//<<<<<<<<<<<<<< To Do... Set Weights <<<<<<<<<<<<<<<<<<<
		/*<stat_list>*/{1, .1},
		/*<stat>*/{1, 0.05, 0.05, 0.5, 0.35},
		/*<cmpd_stat>*/{1},
		/*<if_stat>*/{ 1, 0.15, 0.15, 0.15, 0.2, 0.2},
		/*<iter_stat>*/{ 1, 0.25},
		/*<assgn_stat>*/{1},
		/*<decl_stat>*/{1, 0.5},
		/*<exp>*/{1, 0.3, 0.5},
		/*<op>*/{1},
		/*<type>*/{1},
		/*<id>*/{1},
		/*<const>*/{1},
		/*<char_digit_seq>*/{1, 0.3, 0.45},
		/*<digit_seq>*/{1, 0.5},
		/*<char>*/{1},
		/*<digit>*/{1}
	};

	Production	stat_list(vecStr[0], vecDoub[0]),
				stat(vecStr[1], vecDoub[1]),
				cmpd_stat(vecStr[2], vecDoub[2]),
				if_stat(vecStr[3], vecDoub[3]),
				iter_stat(vecStr[4], vecDoub[4]),
				assgn_stat(vecStr[5], vecDoub[5]),
				decl_stat(vecStr[6], vecDoub[6]),
				exp(vecStr[7], vecDoub[7]),
				op(vecStr[8], vecDoub[8]),
				type(vecStr[9], vecDoub[9]),
				id(vecStr[10], vecDoub[10]),
				consta(vecStr[11], vecDoub[11]),
				char_digit_seq(vecStr[12], vecDoub[12]),
				digit_seq(vecStr[13], vecDoub[13]),
				chara(vecStr[14], vecDoub[14]),
				digit(vecStr[15], vecDoub[15]);

	unordered_map<string, Production> myMap = { 
		{"<stat_list>", stat_list}, 
		{"<stat>", stat}, 
		{"<cmpd_stat>", cmpd_stat}, 
		{"<if_stat>", if_stat},	
		{"<iter_stat>", iter_stat},
		{"<assgn_stat>", assgn_stat},
		{"<decl_stat>", decl_stat},
		{"<exp>", exp},
		{"<op>", op},
		{"<type>", type},
		{"<id>", id},
		{"<const>", consta},
		{"<char_digit_seq>", char_digit_seq},
		{"<digit_seq>", digit_seq},
		{"<char>", chara},
		{"<digit>", digit}
	};


	while (findAndIdentify(mainStr, beg, end)) {
		size_t len = end - beg + 1;
		keyStr = mainStr.substr(beg, len);
		
		newStr = myMap.at(keyStr).expand();

		mainStr.replace(beg, len, newStr);
		cout << ".";
	}

	cout << "\n" << mainStr << endl;

	//Write to file
	/*myFile.open("outFile.txt");
	myFile << mainStr << endl;
	myFile.close();*/

	return 0;
}
