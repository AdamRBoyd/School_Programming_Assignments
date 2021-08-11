package asLeapDay;

public class LeapDay extends Day{
	
	private int year;
	
	public LeapDay(int d, int m, int y) {
		super(d, m);
		year = y;
	}

	public int getYear() {
		return year;
	}
	
	public int findDayNum() {
		int dayNum = super.findDayNum();
		
		//leap year stuff
		if (((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0)) && (month > 2)) {
			dayNum++;
		}
		
		return dayNum;
	}

}
