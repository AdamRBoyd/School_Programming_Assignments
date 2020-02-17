#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

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
	char c;
	
	char firstName[50];
	printf("Please enter your first name: ");
	scanf("%s", &firstName);

	char lastName[50];
	printf("Please enter your last name: ");
	scanf("%s", &lastName);

	int numPrevCourses = 0;
	printf("\nEnter number of previous courses: ");
	scanf("%d", &numPrevCourses);
	
	while ((c = getchar()) != '\n' && c != EOF) {}

	enum LetterGrade* prevGrades = (enum LetterGrade*)malloc(numPrevCourses * sizeof(enum LetterGrade));

	for (int courseIx = 0; courseIx < numPrevCourses; ++courseIx) {
		printf("Enter letter grade for course %d: ", courseIx + 1);
		char letterGrade;
		scanf("%c", &letterGrade);
		
		while ((c = getchar()) != '\n' && c != EOF) {}

		convertCharToLetterGrade(&letterGrade);

		prevGrades[courseIx] = letterGrade;
	}
	
	int numExams;
	printf("\nEnter number of exams this semester: ");
	scanf("%d", &numExams);
	
	while ((c = getchar()) != '\n' && c != EOF) {}

	int* examGrades = (int*)malloc(numExams * sizeof(int));

	for(int examIx = 0; examIx < numExams; ++examIx) {
		printf("%s %d %s", "Enter grade for exam ", examIx+1, " as an integer: ");
		scanf("%d", &examGrades[examIx]);
		
		while ((c = getchar()) != '\n' && c != EOF) {}
	}

	char fullname[100];
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