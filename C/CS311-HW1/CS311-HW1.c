//Adam Boyd
//CS311 01
//ID xv3543

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>

enum LetterGrade {
	A = 4,
	B = 3,
	C = 2,
	D = 1,
	F = 0
};

double getArrayAverage(int arr[], int size) {
	double sum = 0;
	for (int i = 0; i < size; ++i) {
		sum += arr[i];
	}
	
	return sum / size;
}

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
	char c, firstName[50], lastName[50], fullName[100];   //c used in input flush
	int numPrevCourses = 0, numExams;

	printf("Please enter your first name: ");
	scanf("%s", &firstName);

	printf("Please enter your last name: ");
	scanf("%s", &lastName);

	
	printf("\nEnter number of previous courses: ");
	scanf("%d", &numPrevCourses);
	
	while ((c = getchar()) != '\n' && c != EOF) {}  //input flush

	enum LetterGrade* prevGrades = (enum LetterGrade*)malloc(numPrevCourses * sizeof(enum LetterGrade));

	for (int courseIx = 0; courseIx < numPrevCourses; ++courseIx) {
		printf("Enter letter grade for course %d: ", courseIx + 1);
		char letterGrade;
		scanf("%c", &letterGrade);
		
		while ((c = getchar()) != '\n' && c != EOF) {}   //input flush

		convertCharToLetterGrade(&letterGrade);

		prevGrades[courseIx] = letterGrade;
	}
	
	printf("\nEnter number of exams this semester: ");
	scanf("%d", &numExams);
	
	while ((c = getchar()) != '\n' && c != EOF) {}   //input flush

	int* examGrades = (int*)malloc(numExams * sizeof(int));

	for(int examIx = 0; examIx < numExams; ++examIx) {
		printf("%s %d %s", "Enter grade for exam ", examIx+1, " as an integer: ");
		scanf("%d", &examGrades[examIx]);
		
		while ((c = getchar()) != '\n' && c != EOF) {}    //input flush
	}

	strcpy(fullName, firstName);
	strcat(fullName, " ");
	strcat(fullName, lastName);

	printf("%s %s:\n", "\nGrade Report for", fullName);

	double examAverage = getArrayAverage(examGrades, numExams);
	printf("%s %.2f\n", "Your exam average is:", examAverage);

	enum LetterGrade newLetterGrade = getLetterGradeFromAverage(examAverage);

	prevGrades = realloc(prevGrades, ++numPrevCourses * sizeof(enum LetterGrade));
	prevGrades[numPrevCourses-1] = newLetterGrade;

	double gpa = getArrayAverage(prevGrades, numPrevCourses);
	printf("%s %.2f\n", "Your latest GPA is:", gpa);

	free(prevGrades);
	free(examGrades);
	return 0;
}