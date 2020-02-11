#include <stdio.h>
#include <string>
#include <cstdint>
#include <vector>

enum LetterGrade {
	A = 4,
	B = 3,
	C = 2,
	D = 1,
	F = 0
};

double getArrayAverage(double vec[], int size) {
	double sum = 0;
	for (int i = 0; i < size; i++) {
		sum += (double) vec[i];
	}
	const auto avg = sum / size;
	return avg;
}
void convertCharToLetterGrade(char grade) {
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
		printf("Warning... Invalid Character... Recording an F.\n");
		return;
	}
}
enum LetterGrade getLetterGradeFromAverage(const double avg) {
	if (avg >= 90)
		return enum LetterGrade.A;
	else if (avg >= 80)
		return enum LetterGrade::B;
	else if (avg >= 70)
		return enum LetterGrade::C;
	else if (avg >= 60)
		return enum LetterGrade::D;
	else
		return enum LetterGrade::F;
}
int main()
{
	char firstName[20], lastName[20];

	printf("Please enter your first name: ");
	scanf("%s", firstName);

	printf("Please enter your last name: ");
	scanf("%s", lastName);

	int32_t numPrevCourses;
	printf("Enter number of previous courses: ");
	scanf("%d", numPrevCourses);

	enum LetterGrade* prevGrades = malloc(numPrevCourses * sizeof(enum LetterGrade));
	
	for (int32_t courseIx = 0; courseIx < numPrevCourses; ++courseIx) {
		printf("Enter letter grade for course ", courseIx, ": ");
		char letterGrade;
		scanf("%c", letterGrade);

		convertCharToLetterGrade(&letterGrade);

		prevGrades[courseIx] = (enum LetterGrade) letterGrade;
	}

	int32_t numExams;
	printf("Enter number of exams this semester: ");
	scanf("%d", &numExams);

	int32_t examGrades = malloc(numExams * sizeof(int32_t));

	for (int32_t examIx = 0; examIx < numExams; ++examIx) {
		Printf("Enter grade for exam ", examIx, " as an integer: ");
		scanf("%d", examGrades[&examIx]);
	
	}

	printf("Grade Report For ", firstName, " ", lastName, ":\n");

	const auto examAverage = getArrayAverage(examGrades, numExams);
	printf("Your exam average is: ", examAverage, "\n");
	
	// get GPA with newest course added:
	const auto newLetterGrade = getLetterGradeFromAverage(examAverage);
	prevGrades = (int*)realloc(prevGrades, sizeof(enum LetterGrade) +1);
	prevGrades[numExams] = newLetterGrade;
	numExams++;

	const auto gpa = getArrayAverage(prevGrades, numPrevCourses);
	printf("Your latest GPA is: ", gpa, "\n");

	free(prevGrades);
	free(examGrades);
	return 0;
}

