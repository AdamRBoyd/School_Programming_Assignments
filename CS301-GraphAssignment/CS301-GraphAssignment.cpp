/*
Create a program that finds shortest flight routes between two cities.

If a route is found the program outputs the list of connecting cities. (Think of these as flight stops at corresponding airports.)  Otherwise the program indicates that no route was found.

The sense in which a route is shortest is simply having the least number of connections.

That means you can use a breadth first search algorithm. Using Dijkstra's algorithm would be overkill.  
The vertexes in your graphs will simply be numbers in the range 0 to n-1 where n is the number of cities. 
Each number will be associated with a city name via your lookup table.  Do not create a graph class with nodes and pointers. 
That's a sure way to get zero credit on this assignment. The correct approach is to use a lookup table which associates each city with an index in the lookup table. 
Then you will use the bfs and printpath functions (posted below), suitably modified, to output the shortest paths.

To create the lookup table and the adjacency lists for your graph, your program will read in the file connections.txt.

As a side note: the From and To content of connections.txt was randomaly generated and not based on actual flights. 
Unfortunately, or maybe entertainingly, that means shortest paths found by the program will usually be absurd from the standpoint of world geography.

Be careful when creating the lookup table for city names, because some cities with a From: entry do not have any To: entry (you can fly out but not in). 
It's also possible that a city appearing under To:  has no From: entry  (can fly in but not out).  
Be prepared for some wacky results since the connections in the file have no relation to actual connections between real airports.

To select start and destination cities, the user can type in a string, normally the beginning of a city name,  and the program will list matching cities, from which the user can select via a number.

The program should only accept strings that are of length two or more as input. 
To find matches it simply looks for the user's string as a substring of city names in the lookup table.  
Ignore case when looking for substrings.

Upload your source file(s) and a text file with copied output from a sample run of the program with multiple  searches.
The output below is from a sample solution.  Your program output should be similar.

For the city numbers you may use the indexes in your lookup table (as is done below) or number them 1, 2, 3 etc. to be more user friendly.   
You're also free to avoid displaying a list of cities when the user string matched only one city name.
*/

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

using namespace std;

// traces parent pointers back from endv to startv
void printPath(int parents[], int size, int startv, int endv) {
    if (endv != startv) {
        printPath(parents, size, startv, parents[endv]);
    }
    cout << endv << " --> ";
}

//        
void bfs(vector<int> alists[], int size, int start, int target) {
    int* parents = new int[size];
    for (int i = 0; i < size; i++) parents[i] = -1;
    parents[start] = start;
    queue<int> q;
    q.push(start);
    bool found = false;
    while (!q.empty() && !found) {
        int v = q.front();
        q.pop();
        if (v == target)
            found = true;

        else for (int i = 0; i < alists[v].size(); i++) {
            int w = alists[v][i];
            if (parents[w] == -1) {
                parents[w] = v;
                q.push(w);
            }
        }
    }
    if (found)
        printPath(parents, size, start, target);
    else
        cout << "Not found";
    cout << endl;
    delete[] parents;
}


int main() {
    const int size = 1000;
    vector<string> alists[size], dest; // Adjacency lists for a sample graph
    vector<int> cityNums;
    string parents[size];
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
                    cin >> start;
                    if (start.length() < 2) cout << "Please use at least two characters." << endl << endl;
                    else break;
                }
                if (start == "quit") return 0;

                cout << endl;

                //Convert start to lower case letters for searching
                for (int i = 0; i < start.length(); i++) {
                    start[i] = tolower(start[i]);
                }

                for (int i = 0; i < cities; i++) {
                    //convert city to lower case letters for searching
                    string city = alists[i][0];
                    for (int i = 0; i < city.length(); i++) {
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
                cin >> input;
                loc = stoi(input);

                for (int i = 0; i < cityNums.size(); i++) {
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
                    cin >> target;
                    if (target.length() < 2) cout << "Please use at least two characters." << endl << endl;
                    else break;
                }
                if (target == "quit") return 0;

                cout << endl;

                //Convert start to lower case letters for searching
                for (int i = 0; i < target.length(); i++) {
                    target[i] = tolower(target[i]);
                }

                for (int i = 0; i < dest.size(); i++) {
                    //convert city to lower case letters for searching
                    string city = dest[i];
                    for (int i = 0; i < city.length(); i++) {
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
                cin >> input;
                loc = stoi(input);

                for (int i = 0; i < cityNums.size(); i++) {
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

        cout << "Make another search? (\"yes\" or \"no\"): ";
        cin >> input;
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
