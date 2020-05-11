/*Given the above Node type, we wish to detect "invalid" binary trees in which there is a loop from some node back to itself.  Write a function

bool hasALoop(Node * r);

that returns true if the intended tree with root r has such a loop and false otherwise.   
Rather than just detect nodes which point back to themselves via left or right child pointer, your implementation should detect situations in which any descendant of any given node points back to the node.  
For example,  if r's left child has a right child equal to r, that would be considered a loop. 
On the other hand, if r's left child has a right child equal to r's right child that would be an invalid binary tree, but we wouldn't consider it a loop since there is no path back to r. 
I've provided a tester.cpp  so you can check that your implementation works as intended.  The file tester.cpp should be edited to fill in code for your hasALoop implementation. 
Nothing else in the tester should be altered EXCEPT please change TREESIZE to 8 (from the current value of 4) when you run it for the uploaded sample output.

For you submission, upload the edited tester.cpp and a textfile with your output. (Type -1 for fromIndex when it prompts to omit the debugging part of the tester.)

Notice there's a second parameter of type vector for hasALoop.  You're free to use the second parameter or not. It's provided to suggest a possible implementation.

 */

#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;


class Node {
public:
	Node* left, * right;
	int data;
	Node(char d, Node* l = nullptr, Node* r = nullptr) {
		left = l; right = r;
		data = d;
	}
};

const int TREESIZE = 4;  // change TREESIZE to 8 for your submission

void printNode(Node* r);              // called by printChildren 
void printChildren(Node* nodes[], int size); // called by debug 
void printTree(Node* r, int offset = 4);  // called by debug
void debug(Node* nodes[]); // to help debug your hasALoop implementation
bool isIn(Node* r, vector<Node*> v);  // optional helper function for your hasALoop implementation 
bool hasALoop(Node* r, vector<Node*> v = vector<Node*>());  // you implement this


int main() {
	Node* nodes[2 * TREESIZE + 1] = { nullptr }; // store Node pointers in an array for convenience
	for (int i = TREESIZE - 1; i >= 0; i--)
		nodes[i] = new Node(i, nodes[2 * i + 1], nodes[2 * i + 2]);  // create a complete binary tree
	debug(nodes);
	int loopcount = 0;
	// try reassigning left or right child pointers for each node
	for (int i = 0; i < TREESIZE; i++)
		for (int j = 0; j < TREESIZE; j++)
			for (int k = 0; k < 2; k++) {
				if (k == 0)	nodes[i]->left = nodes[j];
				else nodes[i]->right = nodes[j];
				cout << i << ", " << j << ", " << (k == 0 ? 'L' : 'R') << " :  ";
				bool loop = hasALoop(nodes[0]);
				if (loop) loopcount++;
				cout << (loop ? "LOOP" : "----") << endl;
				for (int i = TREESIZE - 1; i >= 0; i--) {
					nodes[i]->left = nodes[2 * i + 1];
					nodes[i]->right = nodes[2 * i + 2];
				}
				cout << "_______________" << endl;
			}
	cout << loopcount << " loops in total." << endl;
	return 0;
}

bool isIn(Node* r, vector<Node*> v) {
	for (unsigned int i = 0; i < v.size(); i++)
		if (v[i] == r) return true;
	return false;
}


void printNode(Node* r) {
	if (r != nullptr) cout << r->data; else cout << "N";
}
void printChildren(Node* nodes[], int size) {
	for (int i = 0; i < size; i++) {
		Node* r = nodes[i];
		if (r != nullptr) {
			cout << r->data << ":";
			cout << "(";
			printNode(r->left);
			cout << ",";
			printNode(r->right);
			cout << ")   ";
		}
	}
	cout << endl;
}
bool hasALoop(Node* r, vector<Node*> v)
{
	if (r == nullptr) return false;

	bool loopFound = false;
				
	vector<Node*>::iterator found = find(v.begin(), v.end(), r);
	if (found != v.end()) { 
		return true;
	}
	else { v.push_back(r); }

	if (r->left != nullptr) {
		if (hasALoop(r->left, v)) return true;
	}
	if (r->right != nullptr) { 
		if (hasALoop(r->right, v)) return true; 
	}

	return loopFound;
}

// Print the binary tree.
void printTree(Node* r, int offset) {
	char c = r == nullptr ? '.' : '-';
	for (int i = 0; i < offset - 4; i++)
		cout << ' ';
	for (int i = 0; i < 4; i++)
		cout << c;
	if (r != nullptr)
	{
		cout << r->data << endl;
		offset += 4;
		printTree(r->left, offset);
		printTree(r->right, offset);
	}
	else cout << '.' << endl;
}


void debug(Node* nodes[]) {
	bool quit = false;
	do {
		printChildren(nodes, TREESIZE);
		printTree(nodes[0]);
		cout << endl;
		int fromIndex, toIndex;
		cout << endl << "fromIndex or -1 to quit: ";
		cin >> fromIndex;
		if (fromIndex < 0 || fromIndex >= TREESIZE) quit = true;
		else {
			cout << "toIndex: ";
			cin >> toIndex;
			if (toIndex < 0 || toIndex >= TREESIZE) break;
			cout << "Reassign left or right child (l/r)? ";
			char lr;
			cin >> lr;
			if (lr == 'r' || lr == 'R')
				nodes[fromIndex]->right = nodes[toIndex];
			else
				nodes[fromIndex]->left = nodes[toIndex];
			printChildren(nodes, TREESIZE);
			bool loop = hasALoop(nodes[0]);
			if (loop)	cout << "This tree has a loop!" << endl;
			else		cout << "No loop found." << endl;
			cout << endl << endl;
			for (int i = TREESIZE - 1; i >= 0; i--) {
				nodes[i]->left = nodes[2 * i + 1];
				nodes[i]->right = nodes[2 * i + 2];
			}
		}
	} while (!quit);
}

