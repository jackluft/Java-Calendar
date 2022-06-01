import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text; 
import javafx.scene.layout.*;
public class DayBlock extends BorderPane{

	//interface
	private DayPressed dp;

	private Day day;

	private Text dayNumber;
	private Text weekDay;
	private HBox header;

	private VBox eventContainer;

	private final double width = 100;
	private final double height = 100;

	public DayBlock(DayPressed dp,Day day){
		this.dp = dp;
		this.day = day;
		init();
		


	}
	private void init(){
		/*
			func: init
			args: None
			doc: 

		*/
		setSize();
		createLayout();
		
		setOnMouseClicked(e->{
			System.out.println("Day clicked on");
			dp.dayPressed(day);
		});

		

	}
	private void setSize(){
		/*
			func: setSize
			args: None
			doc: This function will set the size of the day block
	

		*/
		setPrefWidth(width);
		setMinWidth(width);
		setMaxWidth(width);

		setPrefHeight(height);
		setMinHeight(height);
		setMaxHeight(height);
	}
	private void createLayout(){
		createHeader();
		createEventContainer();
		setStyle("-fx-border-color: black; -fx-border-width: 3;"); 
	}
	private void createHeader(){
		header = new HBox();
		createDayNumber();
		createWeekDay();
		header.getChildren().add(dayNumber);
		header.getChildren().add(weekDay);
		setTop(header);


	}
	private void createDayNumber(){
		/*
			func: createDayNumber
			args: None
			doc:
		*/
		dayNumber = new Text();
		dayNumber.setText(day.getDay()+"-");
		dayNumber.setUnderline(true);
	}
	private void createWeekDay(){
		/*
			func: createWeekDay
			args: None
			doc: 
		
		*/
		weekDay = new Text();
		weekDay.setText(day.getDayOfWeek());
	}
	private void createEventContainer(){
		/*
			func: createEventContainer
			args: None
			doc: 
		*/
		eventContainer = new VBox();
		setCenter(eventContainer);


	}
}