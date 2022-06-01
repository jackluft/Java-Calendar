import javafx.scene.layout.*;
import java.util.ArrayList;
public class MonthBlock extends VBox{

	private HBox[] weeks;
	private Month month;
	public MonthBlock(DayPressed dp,int year, String month){
		this.month = new Month(dp,year,month);

		createRows();


	}
	private void createRows(){
		
		weeks = new HBox[5];
		for(int i = 0; i< 5; i++){
			weeks[i] = new HBox();
			getChildren().add(weeks[i]);

		}
		addDaysToLayout();
		

	}
	private void clearDays(){
		/*
			func: clearDays
			args: None
			doc: This function will remove all of the days displayed on the calendar in the days
			array list.
		*/
		ArrayList<Day> days = month.getDays();
		int i = 0;
		int j = 0;
		int k =0;
		while(j < 5 && k < days.size()){
			//System.out.println("removed");
			
			if(i >= 7){
				j++;
				i= 0;


			}
			if(j < 5){
				weeks[j].getChildren().remove(days.get(k).getDayBlock());

			}


			i++;
			k++;

		}
		days.clear();


	}
	private void addDaysToLayout(){
		ArrayList<Day> days = month.getDays();
		int i = 0;
		int j = 0;
		int k =0;
		while(j < 5 && k < days.size()){
			///System.out.println("Added");

			
			if(i >= 7){
				j++;
				i= 0;


			}
			if(j < 5){
				weeks[j].getChildren().add(days.get(k).getDayBlock());
			}


			i++;
			k++;

		}


	}
	public void forward(){
		clearDays();
		month.increaseMonth();
		addDaysToLayout();
		
		
		
		//System.out.println(month.getMonth());

	}
	public void back(){
		clearDays();
		month.decreaseMonth();
		
		addDaysToLayout();
		
		
		

	}
	public void changeDate(String month, int year){
		/*
			func: chagneDate
			args: month-> full name of the month. year-> year
			docs: This function will change the month and year of the calendar
		*/
		clearDays();
		this.month.monthTo(month,year);
		addDaysToLayout();
	}
	public void setYear(int year){
	}
	public String getMonth(){
		return this.month.getMonth();
	}
	public int getYear(){
		return this.month.getYear();
	}
	
}