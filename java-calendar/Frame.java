import javafx.scene.layout.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
public class Frame extends BorderPane implements ButtonPressed, DayPressed{
	//this class will hold the calendar
	//the top bar and side bar
	private TopBar top;
	private Calendar center;
	private SideBar right;

	//full name of month
	private String month;
	//year
	private int year;
	//day
	private int day;

	//dayOfWeek
	private String dayOfWeek;

	private Day currentDay;

	public Frame(){
		init();


	}
	private void init(){
		/*
			func: init
			args: None
			doc: This function will call all the functions to create the frame
		*/
		getCurrentDate();
		createTopBar();
		createCalendar();
		createSideBar();


	}
	private void createSideBar(){
		/*
			func: createSideBar
			args: None
			doc: This function will create and add the side bar

		*/
		right = new SideBar(currentDay);
		setRight(right);
	}
	private void getCurrentDate(){
		/*
		func: getCurrentDate
		args: None
		doc: This function will set the values of month and year to the current date.


		*/

		LocalDate currentdate = LocalDate.now();
		String tempMonth = currentdate.getMonth().toString().toLowerCase();
		month = tempMonth.substring(0, 1).toUpperCase() + tempMonth.substring(1);
		year = currentdate.getYear();
		day = currentdate.getDayOfMonth();
		String tempDay = currentdate.getDayOfWeek().toString().toLowerCase();
		dayOfWeek = tempDay.substring(0, 1).toUpperCase() + tempDay.substring(1);
		this.currentDay = new Day(this,year,month,day,dayOfWeek);

	}
	private void createTopBar(){
		/*
			func: createTopBar
			args: None
			doc: This function will create and add TopBar object.
		*/
		top = new TopBar(this,year,month);
		setTop(top);
	}
	private void createCalendar(){
		/*
			func: createCalendar
			args: None
			doc: This function will create and add the calendar object
		*/
		center = new Calendar(this,year,month);
		setCenter(center);

	}
	@Override
	public void back(){
		/*
			func: back
			args: None
			doc: This is a interface function. It will be 
			called when the back button is clicked.
			This will call other functions to change the date.

		*/
		center.back();
		top.setTime(center.getYear(),center.getMonth());

	}
	@Override
	public void forward(){
		/*
			func: forward
			args: None
			doc: This is a interface function. It will be 
			called when the forward button is clicked.
			This will call other functions to change the date.

		*/
		center.forward();
		top.setTime(center.getYear(),center.getMonth());

	}
	@Override
	public void current(){
		/*
			func: current
			args: None
			doc: This is a interface function. It will be called when the currentbutton is clicked.
			This will call other functions to display the current month and change the sidebar to the current day.


		*/
		getCurrentDate();
		top.setTime(year,month);
		right.setDate(currentDay);
		center.toCurrentMonth(month,year);

	}
	@Override
	public void dayPressed(Day day){
		/*
			func: dayPressed
			args: Day-> day object pressed. events-> a list of all the events for that day.
			doc: This is a interface function (DayPressed interface). This will be called when a day block is clicked.
			This function will change the side bar to the day passe into this function.

		*/
		
		right.setDate(day);

	}

}