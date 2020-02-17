/*#include <iostream>
#include <string>
#include <cstdint>
#include <vector>
using namespace std;*/

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <ctype.h>


/*enum LetterGrade {
	A = 4,
	B = 3,
	C = 2,
	D = 1,
	F = 0
};*/

enum LetterGrade {
	A = 4,
	B = 3,
	C = 2,
	D = 1,
	F = 0
};

// type T must be castable into a double
/*template<class T>
double getArrayAverage(vector<T>& vec) {
	double sum = 0;
	for (const auto& value : vec) {
		sum += static_cast<double>(value);
	}
	const auto avg = sum / vec.size();
	return avg;
}*/

double getArrayAverage(int arr[], int size) {
	double sum = 0;
	for (int i = 0; i < size; ++i) {
		sum += arr[i];
	}
	
	return sum / size;
}

/*void convertCharToLetterGrade(char& grade) {
	switch (grade) {
	case 'A': case 'a':
		grade = 4;
		return;
	case 'B': case 'b':
		grade = 3;
		return;
	case 'C': case 'c':
		grade = 2;
		return;
	case 'D': case 'd':
		grade = 1;
		return;
	case 'F': case 'f':
		grade = 0;
		return;
	default:
		cout << "Warning... Invalid Character... Recording an F.\n";
		return;
	}
}*/

void convertCharToLetterGrade(char *grade) {
	switch (*grade) {
	case 'A': case 'a':
		*grade = 4;
		return;
	case 'B': case 'b':
		*grade = 3;
		return;
	case 'C': case 'c':
		*grade = 2;
		return;
	case 'D': case 'd':
		*grade = 1;
		return;
	case 'F': case 'f':
		*grade = 0;
		return;
	default:
		printf("%s", "Warning... Invalid Character... Recording an F.\n");
		*grade = 0;
		return;
	}
}

/*LetterGrade getLetterGradeFromAverage(const double avg) {
	if (avg >= 90)
		return LetterGrade::A;
	else if (avg >= 80)
		return LetterGrade::B;
	else if (avg >= 70)
		return LetterGrade::C;
	else if (avg >= 60)
		return LetterGrade::D;
	else
		return LetterGrade::F;
}*/

enum LetterGrade getLetterGradeFromAverage(const double avg) {
	enum LetteGrade grade;
	if (avg >= 90)
		grade = A;
	else if (avg >= 80)
		grade = B;
	else if (avg >= 70)
		grade = C;
	else if (avg >= 60)
		grade = D;
	else
		grade = F;
	return grade;
}

int main() {
	/*string firstName;
	cout << "Please enter your first name: ";
	cin >> firstName;
	string lastName;
	cout << "Please enter your last name: ";
	cin >> lastName;
	int32_t numPrevCourses;
	cout << "Enter number of previous courses: ";
	cin >> numPrevCourses;
	cin.ignore();*/
	
	char c;  //used for input flush
	//char* firstName, * lastName, * fullName;
	
	char firstName[50];							//<<<<<<<<<<<<<<<<<<<<<<<<<<MAKE DYNAMIC<<<<<<<<<<<<<<<<<<<<<<<<<<<< <
	printf("Please enter your first name: ");
	scanf("%s", &firstName);

	char lastName[50];							//<<<<<<<<<<<<<<<<<<<<<<<<<<MAKE DYNAMIC<<<<<<<<<<<<<<<<<<<<<<<<<<<< <
	printf("Please enter your last name: ");
	scanf("%s", &lastName);

	int numPrevCourses = 0;
	printf("\nEnter number of previous courses: ");
	scanf("%d", &numPrevCourses);
	
	//flush input buffer aka cin.ignore()
	while ((c = getchar()) != '\n' && c != EOF) {}

	/*vector<LetterGrade> prevGrades(numPrevCourses);

	for (int32_t courseIx = 0; courseIx < numPrevCourses; ++courseIx) {
		cout << "Enter letter grade for course " << courseIx << ": ";
		char letterGrade;
		cin.get(letterGrade);
		cin.ignore();
		convertCharToLetterGrade(letterGrade);
		prevGrades.at(courseIx) = static_cast<LetterGrade>(letterGrade);
	}*/

	enum LetterGrade* prevGrades = (enum LetterGrade*)malloc(numPrevCourses * sizeof(enum LetterGrade));

	for (int courseIx = 0; courseIx < numPrevCourses; ++courseIx) {
		printf("Enter letter grade for course %d: ", courseIx + 1);
		char letterGrade;
		scanf("%c", &letterGrade);
		//flush input buffer aka cin.ignore()
		while ((c = getchar()) != '\n' && c != EOF) {}

		convertCharToLetterGrade(&letterGrade);

		prevGrades[courseIx] = letterGrade;
	}
	
	/*int32_t numExams;
	cout << "Enter number of exams this semester: ";
	cin >> numExams;
	cin.ignore();

	vector<int32_t> examGrades(numExams);

	for (int32_t examIx = 0; examIx < numExams; ++examIx) {
		cout << "Enter grade for exam " << examIx << " as an integer: ";
		cin >> examGrades.at(examIx);
		cin.ignore();
	}*/

	int numExams;
	printf("\nEnter number of exams this semester: ");
	scanf("%d", &numExams);
	//flush input buffer aka cin.ignore()
	while ((c = getchar()) != '\n' && c != EOF) {}

	int* examGrades = (int*)malloc(numExams * sizeof(int));

	for(int examIx = 0; examIx < numExams; ++examIx) {
		printf("%s %d %s", "Enter grade for exam ", examIx+1, " as an integer: ");
		scanf("%d", &examGrades[examIx]);
		//flush input buffer aka cin.ignore()
		while ((c = getchar()) != '\n' && c != EOF) {}
	}

	/*const auto fullName = firstName + " " + lastName;
	cout << "Grade Report For " << fullName << ":\n";*/

	char fullname[100];										//<<<<<<<<<<<<<<<<<<<<<<<<<<MAKE DYNAMIC<<<<<<<<<<<<<<<<<<<<<<<<<<<< <
	int nameCat = 0;

	for (; firstName[nameCat] != '\0'; nameCat++) {
		fullname[nameCat] = firstName[nameCat];
	}
	fullname[nameCat] = ' ';
	nameCat++;
	for (int i = 0; lastName[i] != '\0'; i++, nameCat++) {
		fullname[nameCat] = lastName[i];
	}
	fullname[nameCat] = '\0';

	printf("%s %s:\n", "\nGrade Report for", fullname);

	/*const auto examAverage = getArrayAverage(examGrades);
	cout << "Your exam average is: " << examAverage << "\n";*/

	double examAverage = getArrayAverage(examGrades, numExams);
	printf("%s %.2f\n", "Your exam average is:", examAverage);

	// get GPA with newest course added:
	/*const auto newLetterGrade = getLetterGradeFromAverage(examAverage);
	prevGrades.push_back(newLetterGrade);*/

	enum LetterGrade newLetterGrade = getLetterGradeFromAverage(examAverage);

	prevGrades = realloc(prevGrades, ++numPrevCourses * sizeof(enum LetterGrade));
	prevGrades[numPrevCourses-1] = newLetterGrade;

	/*const auto gpa = getArrayAverage(prevGrades);
	cout << "Your latest GPA is: " << gpa << "\n";*/

	double gpa = getArrayAverage(prevGrades, numPrevCourses);
	printf("%s %.2f\n", "Your latest GPA is:", gpa);

	free(prevGrades);
	free(examGrades);
	return 0;
}