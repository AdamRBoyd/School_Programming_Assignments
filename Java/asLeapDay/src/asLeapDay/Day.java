package asLeapDay;

public class Day {
	private int day;
	protected int month;
	int[] days = {0,31,28,31,30,31,30,31,31,30,31,30};
	
	public Day(int d, int m) {
		day = d;
		month = m;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}
	
	public int findDayNum() {
		int dayNum = 0;
		for(int i = 0; i < month; i++) {
			dayNum += days[i];
		}
		dayNum += day;
		return dayNum;
	}
}
