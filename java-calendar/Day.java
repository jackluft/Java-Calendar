import java.util.ArrayList;
public class Day{
	//interface
	private DayPressed dp;
	//year
	private int year;
	//full month name
	private String month;
	//day number
	private int day;
	//day of the week full name (ex: Friday)
	private String dayOfWeek;
	// hold an arraylist of all of the events in the day
	private ArrayList<Event> events;
	//hold the DayBlock value
	private DayBlock dayObject;

	public Day(DayPressed dp,int year,String month,int day,String dayOfWeek){
		this.dp = dp;
		this.year = year;
		this.month = month;
		this.day = day;
		this.dayOfWeek = dayOfWeek;
		init();
		
		
	}
	
	private void init(){
		/*	
			func: init
			args: None
			doc: This 
		*/
		this.events = new ArrayList<>();
		this.dayObject = new DayBlock(dp,this);

	}
	public String getDayOfWeek(){
		/*
			func: getDayOfWeek
			args: None
			doc: This function will return the day of the week.

		*/
		return this.dayOfWeek;
	}
	public int getDay(){
		/*
			func: getDay
			args: None
			doc: This function will return the number of the day

		*/
		return this.day;
	}
	public String getMonth(){
		/*
			func: getMonth
			args: None
			doc: This function will be a getter. That returns the full name of the month.
		*/
		return this.month;
	}
	public void addEvent(Event e){
		/*
			func: AddEvent
			args: e-> a new event to be added.
			doc: This fucntion 
	
		*/
		this.events.add(e);

	}
	public void deleteEvent(){

	}
	public ArrayList<Event> getEvents(){
		/*
			func: getEvents
			args: None
			doc: This function will return a list of events.
		*/

		return this.events;
	}
	
	public DayBlock getDayBlock(){
		/*
			func: getDayBlock
			args: None
			doc: This function 

		*/
		return this.dayObject;
	}
	public String toString(){
		/*
			func: toString
			args: None
			doc: This function will return 
		*/
		return  dayOfWeek+ " " +day+", "+month+" "+year;
	}

}