// Adam Boyd
// CS 301 02
// ID xv3543

#include <queue>
#include <list>
#include <iostream>
#include <vector>
#include <string>
#include <fstream>
#include <algorithm>
#include <unordered_map>

using namespace std;

void printPath(unordered_map<string, string> parents, int size, string startv, string endv) {
    if (endv == startv) {
        cout << endv;
        return;
    }
    printPath(parents, size, startv, parents.at(endv));
    cout << " --> " << endv;
}
      
void bfs(vector<string> alists[], int size, string start, string target) {
    unordered_map<string, string> parents;
    
    for (int i = 0; i < size; i++) {
        parents.emplace(alists[i][0], " ");
    }

    parents.at(start) = start;
    queue<string> q;
    q.push(start);
    bool found = false;

    while (!q.empty() && !found) {
        string v = q.front();
        q.pop();
        if (v == target) {
            found = true;
        }
        else {
            int index = 0;
            for (; index < size; index++) {
                if (alists[index][0] == v) break;
            }

            if (index != size) {
                for (size_t i = 1; i < alists[index].size(); i++) {
                    string w = alists[index][i];
                    if (parents.find(w) == parents.end()) {     //make sure its in the list, if not add it
                        parents.emplace(w, v);
                        q.push(w);
                    }
                    else if (parents.at(w) == " ") {
                        parents.at(w) = v;
                        q.push(w);
                    }
                }
            }
        }
    }
    if (found)
        printPath(parents, size, start, target);
    else
        cout << "Not found";
    cout << endl;
}


int main() {
    const int size = 1000;
    vector<string> alists[size], dest;
    vector<int> cityNums;
    int loc, cities = 0, index = -1;
    bool foundCity = false, getNum = true;
    string start, target, line, from, to, input;
    ifstream myfile;
    
    myfile.open("connections.txt");

    if (myfile.is_open()) {
        while (getline(myfile, line)) {
            if (line[0] == 'F') {
                alists[++index].push_back(line.substr(7, (line.length() - 7)));
                cities++;
            }
            else {
                string to = line.substr(7, (line.length() - 7));
                alists[index].push_back(to);
                //compile list of destinations, excluding duplicates
                if (find(dest.begin(), dest.end(), to) == dest.end())
                {
                    dest.push_back(line.substr(7, (line.length() - 7)));
                }
            }
        }
        myfile.close();
    }
    else {
        cout << "Unable to find file!" << endl;
        return 0;
    }

    //select departing city
    while (true) {
        while (!foundCity && getNum) {
            while (!foundCity) {
                while (true) {
                    cout << "Please enter a departing city name or \"quit\" to exit: ";
                    getline(cin, start);
                    if (start.length() < 2) cout << "Please use at least two characters." << endl << endl;
                    else break;
                }

                if (start == "quit") return 0;

                cout << endl;

                //Convert start to lower case letters for searching
                for (size_t i = 0; i < start.length(); i++) {
                    start[i] = tolower(start[i]);
                }

                for (int i = 0; i < cities; i++) {
                    //convert city to lower case letters for searching
                    string city = alists[i][0];
                    for (size_t i = 0; i < city.length(); i++) {
                        if (isalpha(city[i])) {
                            city[i] = tolower(city[i]);
                        }
                    }

                    size_t found = city.find(start);
                    if (found != string::npos) {
                        cout << i << ": " << alists[i][0] << endl;
                        cityNums.push_back(i);
                        foundCity = true;
                    }
                }
                if (!foundCity) {
                    cout << "No Cities Found" << endl;
                }

            }
            cout << endl;

            while (getNum) {
                cout << "Enter the number of the desired city: ";
                getline(cin, input);
                loc = stoi(input);

                for (size_t i = 0; i < cityNums.size(); i++) {
                    if (cityNums[i] == loc) {
                        getNum = false;
                    }
                }

                if (!getNum) {
                    start = alists[loc][0];
                    cout << "\nSelected Departure: " << start << endl;
                }
                else {
                    cout << "\nCity Number not found! Please select from the list above." << endl;
                }
            }
            cout << endl;
        }

        foundCity = false, getNum = true;
        cityNums.clear();

        //Select destination city
        while (!foundCity && getNum) {
            while (!foundCity) {
                while (true) {
                    cout << "Please enter a destination city name or \"quit\" to exit: ";
                    getline(cin, target);
                    if (target.length() < 2) cout << "Please use at least two characters." << endl << endl;
                    else break;
                }

                if (target == "quit") return 0;

                cout << endl;

                //Convert start to lower case letters for searching
                for (size_t i = 0; i < target.length(); i++) {
                    target[i] = tolower(target[i]);
                }

                for (size_t i = 0; i < dest.size(); i++) {
                    //convert city to lower case letters for searching
                    string city = dest[i];
                    for (size_t i = 0; i < city.length(); i++) {
                        if (isalpha(city[i])) {
                            city[i] = tolower(city[i]);
                        }
                    }

                    size_t found = city.find(target);
                    if (found != string::npos) {
                        cout << i << ": " << dest[i] << endl;
                        cityNums.push_back(i);
                        foundCity = true;
                    }
                }
                if (!foundCity) {
                    cout << "No Cities Found" << endl;
                }

            }
            cout << endl;

            while (getNum) {
                cout << "Enter the number of the desired city: ";
                getline(cin, input);
                loc = stoi(input);

                for (size_t i = 0; i < cityNums.size(); i++) {
                    if (cityNums[i] == loc) {
                        getNum = false;
                    }
                }

                if (!getNum) {
                    target = dest[loc];
                    cout << "\nSelected Destination: " << target << endl;
                }
                else {
                    cout << "\nCity Number not found! Please select from the list above." << endl;
                }
            }
            cout << endl;
        }

        //bfs search
        bfs(alists, cities, start, target);

        cout << "\n\nMake another search? (\"yes\" or \"no\"): ";
        getline(cin, input);
        if (input == "no") {
            cout << endl;
            break;
        }
        else if (input != "yes") {
            cout << "\nwhat...? Ok, just gonna go again..." << endl;
        }
        
        cout << endl;
        foundCity = false, getNum = true;
        cityNums.clear();
    }

    cout << endl;
    return 0;
}
