import javafx.scene.layout.*;
public class Calendar extends BorderPane{
	// holds the month block object
	private MonthBlock month;

	private final double width =0;
	private final double height = 0;

	public Calendar(DayPressed dp,int year,String month){
		this.month = new MonthBlock(dp,year,month);
		setCenter(this.month);

	}
	public void back(){

		month.back();


	}
	public void forward(){
		month.forward();
	}
	public String getMonth(){
		return month.getMonth();
	}
	public int getYear(){
		return month.getYear();
	}
	public void toCurrentMonth(String month, int year){
		this.month.changeDate(month,year);

	}
}