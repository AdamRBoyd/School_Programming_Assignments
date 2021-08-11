#include <iostream>
#include <algorithm>

using namespace std;

struct Node
{
    int value;
    struct Node* left, * right;
    Node(int value)
    {
        this->value = value;
        left = right = nullptr;
    }
};

//reg tree
int getSmallest(Node* r) {
    static int minimum = INT_MAX;

    if (r == nullptr) return NULL;
    if (r->left != nullptr) getSmallest(r->left);
    if (r->right != nullptr) getSmallest(r->right);

    minimum = min(minimum, r->value);

    return minimum;
}

//BST
int getSmallestBST(Node* r) {
    Node* current = r;
    while (current->left != nullptr) {
        current = current->left;
    }
    return current->value;
}

int main()
{
    struct Node* root = new Node(7);
    root->left = new Node(4);
    root->right = new Node(10);
    root->left->left = new Node(2);
    root->left->right = new Node(5);
    root->right->left = new Node(9);
    root->right->right = new Node(12);
    root->right->right->left = new Node(11);

    cout << getSmallest(root) << endl;
    cout << getSmallestBST(root) << endl;

    return 0;
}

