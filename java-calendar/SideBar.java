import javafx.scene.layout.*;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text; 
import javafx.scene.paint.Color;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import java.util.ArrayList;
public class SideBar extends BorderPane{

	private final double width = 200;

	private Day day;
	private ScrollPane scroll;

	//header
	private Text title;
	private VBox header;
	private final double headerHeight = 50;

	private VBox middle;
	//middle
	private TreeView<String> events;

	private final double eventHeight = 240;

	//bottom of the sidebar
	private EventPanel btm;

	public SideBar(Day day){
		this.day = day;
		init();

	}
	private void createMiddle(){
		/*	
			func: createMiddle
			args: None
			doc: 

		*/
		createScroll();
		middle = new VBox();
		displayDayEvents();
		createEventPanel();
		scroll.setContent(middle);
		setCenter(scroll);
	}
	private void createEventPanel(){
		/*	
			func: createEventPanel
			args: None
			doc: This function will create the form for the bottom of the sidebar. That displays 
			all the info of the event.

		*/
		btm = new EventPanel(new Event("Run"));
		middle.getChildren().add(btm);
		//setBottom(btm);
	}
	private void displayDayEvents(){
		/*
			func: displayDayEvents
			args: None
			doc: This function 

		*/
		events = new TreeView<String>();
		events.setMinHeight(eventHeight);
		events.setMaxHeight(eventHeight);
		events.setPrefHeight(eventHeight);
		TreeItem<String> e1 = new TreeItem<>("Events: "+day.getDay());
		e1.setExpanded(true);

		ArrayList<Event> dayEvents = day.getEvents();
		for(int i =0; i < dayEvents.size(); i++){
			Event e = dayEvents.get(i);
			TreeItem<String> temp = new TreeItem<>(e.toString());
			e1.getChildren().add(temp);
		}
		events.setRoot(e1);
		middle.getChildren().add(events);
		

	}
	
	private void createScroll(){
		/*	
			func: makeScrollable
			args: None
			doc: 

		*/
		scroll = new ScrollPane();
		scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	}
	private void setLook(){
		/*	
			func: setLook
			args: None
			doc: This function will set all the style layouts to make the sidebar look better
		*/
		setStyle("-fx-background-color: gray; -fx-border-color: red; -fx-border-style: dashed;");
	}
	private void init(){
		/*
			func: init
			args: None
			doc: 
		*/
		setSize();
		setLook();
		createHeader();
		createMiddle();
	}
	private void setSize(){
		/*
			func: setSize
			args: None
			doc: This function will set the size of the sidebar.
		*/
		setPrefWidth(width);
		setMinWidth(width);
		setMaxWidth(width);
	}
	private void createHeader(){
		/*
			func: createHeader
			args: None
			doc: This function will add and create all the header compentents.
		*/
		header = new VBox();
		header.setPrefHeight(headerHeight);
		header.setMinHeight(headerHeight);
		header.setMaxHeight(headerHeight);
		header.setStyle("-fx-border-color: black; -fx-border-width: 0 0 5 0;"); 
		createTitleText();
		setTop(header);
		

	}
	
	private void createTitleText(){
		/*
			func: createTitleText
			args: None
			doc: This function will create and add the text version of the date
			on to the header layout.
		*/
		String txt = day.getDayOfWeek()+", "+day.getDay()+" "+day.getMonth();
		title = new Text();
		title.setText(txt);
		title.setFill(Color.rgb(0,0,0));
		Font f = new Font(22);
		title.setFont(f);

		header.getChildren().add(title);
	}
	public void setDate(Day day){
		/*
			func: setDate
			args: day-> the day of the month. month-> the full name of the month.
			datOfWeek-> Full name of day of the week.
			doc: This function will set all reciece the day,month and dayOfWeek to change the header title.
			To the value provided.

		*/
		this.day = day;
		String txt = day.getDayOfWeek()+", "+day.getDay()+" "+day.getMonth();
		title.setText(txt);
		displayDayEvents();


	}
}