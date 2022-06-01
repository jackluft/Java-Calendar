import java.util.ArrayList;
public class Month{

	//interface
	private DayPressed dp;
	private int year;
	private String month;
	private ArrayList<Day> days;
	//holds the number of days
	private int numDays;
	//holds the first day of the month and of week (ex: Monday, Friday..)
	private String dayOfWeek;
	public Month(DayPressed dp,int year,String month){
		this.dp = dp;
		this.year = year;
		this.month = month;
		init();

	}
	private void init(){
		/*


		*/
		this.days = new ArrayList<>();
		this.dayOfWeek = getStartingDay(year,month);
		createDays();

	}
	private String getStartingDay(int year, String month){
		//This function will return the name of the day of the first of this month
		int ans = (getYearCode(year) + getMonthCode(month) + getCenturyCode(year) + 1 - getLeapCode(year,month)) %7;

		if(ans == 0){
			return "Sunday";

		}else if(ans == 1){
			return "Monday";

		}else if(ans == 2){
			return "Tuesday";

		}else if(ans == 3){
			return "Wednesday";

		}else if(ans == 4){
			return "Thursday";

		}else if(ans == 5){
			return "Friday";

		}else if(ans == 6){
			return "Saturday";

		}
		return null;
	}
	private void createDays(){
		/*
			func: createDays
			args: None
			doc: This function will see how many days are in the month.
			Set the numDays variable to the number of days in month.

		*/
		if(month.equals("January")){
			numDays = 31;

		}else if(month.equals("February")){
			//check if it is  a leap year 
			if(getLeapCode(this.year,"February") == 1){
				//its a leap year
				numDays = 29;

			}else{
				//its not a leap year
				numDays = 28;
			}



		}else if(month.equals("March")){
			numDays = 31;

		}else if(month.equals("April")){
			numDays = 30;

		}else if(month.equals("May")){
			numDays = 31;

		}else if(month.equals("June")){
			numDays = 30;

		}else if(month.equals("July")){
			numDays = 31;

		}else if(month.equals("August")){
			numDays = 31;

		}else if(month.equals("September")){
			numDays = 30;

		}else if(month.equals("October")){
			numDays = 31;

		}else if(month.equals("November")){
			numDays = 30;

		}else if(month.equals("December")){
			numDays = 31;

		}
		
		for(int i = 1; i <=numDays; i++){
			days.add(new Day(this.dp,this.year,this.month,i,this.dayOfWeek));
			this.dayOfWeek = increaseDayOfWeek();

		}

	}
	private String increaseDayOfWeek(){
		String result = null;
		if(this.dayOfWeek.equals("Sunday")){
			result = "Monday";

		}else if(this.dayOfWeek.equals("Monday")){
			result = "Tuesday";

		}else if(this.dayOfWeek.equals("Tuesday")){
			result = "Wednesday";

		}else if(this.dayOfWeek.equals("Wednesday")){
			result = "Thursday";

		}else if(this.dayOfWeek.equals("Thursday")){
			result = "Friday";

		}else if(this.dayOfWeek.equals("Friday")){
			result = "Saturday";

		}else if(this.dayOfWeek.equals("Saturday")){
			result = "Sunday";

		}


		return result;

	}
	//-------------
	private int getYearCode(int year){
		int century = (year/100) *100;
		int yy = year-century;

		return ( yy + (yy/4)) %7;


	}
	private int getCenturyCode(int year){
		/*
			func: getCenturyCode
			args: month -> year-> the year.
			doc: This function will return a number bases on the number of the year.
			This function is used to later calculate the day of the week.


		*/
		int result = -1;
		int century = (year/100) *100;
		if(century == 1700){
			result = 4;

		}else if(century == 1800){
			result = 2;
		}else if(century == 1900){
			result = 0;

		}else if(century == 2000){
			result = 6;

		}else if(century == 2100){
			result = 4;

		}else if(century == 2200){
			result = 2;
		}else if(century == 2300){
			result = 0;

		}

		return result;
	}
	private int getLeapCode(int year, String month){
		/*
			func: getMonthCode

			args: year-> the year. month-> the full name of the month.

			doc: This function will see if the year is a a leap year.
			it will return 1 if its is a leap year, zero if not.
			This function is used to later calculate the day of the week.


		*/
		//returns 1, if it is a leap year
		int result = 0;
		if(year%4 == 0){
			if(month.equals("January") || month.equals("February")){
				return 1;
			}	

		}
		return result;

	}
	private int getMonthCode(String month){
		/*
			func: getMonthCode
			args: month -> full name of month.
			doc: This function will return a number bases on the number of the month.
			This function is used to later calculate the day of the week.


		*/
		int result = -1;
		if(month.equals("January")){
			result = 0;

		}else if(month.equals("February")){
			result = 3;


		}else if(month.equals("March")){
			result = 3;

		}else if(month.equals("April")){
			result = 6;

		}else if(month.equals("May")){
			result = 1;

		}else if(month.equals("June")){
			result = 4;

		}else if(month.equals("July")){
			result = 6;

		}else if(month.equals("August")){
			result = 2;

		}else if(month.equals("September")){
			result = 5;

		}else if(month.equals("October")){
			result = 0;

		}else if(month.equals("November")){
			result = 3;

		}else if(month.equals("December")){
			result = 5;

		}
		return result;

	}
	public void decreaseMonth(){
		/*	
			func" decreaseMonth
			args: None
			doc: This function will be called when the backward button is
			pressed. Will set the month to the last month. 

		*/
		

		if(month.equals("January")){
			month = "December";
			year--;

		}else if(month.equals("February")){
			month = "January";

		}else if(month.equals("March")){
			month = "February";

		}else if(month.equals("April")){
			month = "March";

		}else if(month.equals("May")){
			month = "April";

		}else if(month.equals("June")){
			month = "May";

		}else if(month.equals("July")){
			month = "June";

		}else if(month.equals("August")){
			month = "July";

		}else if(month.equals("September")){
			month = "August";
		}else if(month.equals("October")){
			month = "September";

		}else if(month.equals("November")){
			month = "October";

		}else if(month.equals("December")){
			month = "November";
			

		}
		init();

	}
	public void monthTo(String month,int year){
		this.month = month;
		this.year = year;
		init();

	}
	public void increaseMonth(){
		/*	
			func" increaseMonth
			args: None
			doc: This function will be called when the forward button is
			pressed. Will set the month to the next month. 

		*/
		

		if(month.equals("January")){
			month = "February";

		}else if(month.equals("February")){
			month = "March";

		}else if(month.equals("March")){
			month = "April";

		}else if(month.equals("April")){
			month = "May";

		}else if(month.equals("May")){
			month = "June";

		}else if(month.equals("June")){
			month = "July";

		}else if(month.equals("July")){
			month = "August";

		}else if(month.equals("August")){
			month = "September";

		}else if(month.equals("September")){
			month = "October";
		}else if(month.equals("October")){
			month = "November";

		}else if(month.equals("November")){
			month = "December";

		}else if(month.equals("December")){
			month = "January";
			year++;

		}
		init();
	}
	public ArrayList<Day> getDays(){
		return days;
	}
	public String getMonth(){
		/*
			func: getMonth
			args: None
			doc: This function will return the month
		*/
		return this.month;
	}
	public int getYear(){
		/*
			func: getMonth
			args: None
			doc: This function will return the year
		*/
		return this.year;
	}

}