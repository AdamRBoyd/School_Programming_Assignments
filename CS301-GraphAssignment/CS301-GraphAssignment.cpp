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

#include <iostream>

int main()
{
    std::cout << "Hello World!\n";
}

