import javafx.scene.layout.*;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text; 
import javafx.scene.shape.Rectangle;
public class EventBlock extends HBox{

	private Event event;

	private Rectangle left;

	private Text title;

	private Text startTime;

	private final int layoutSpacing = 8;




	public EventBlock(Event event){
		this.event = event;
		init();

	}
	private void init(){
		/*
			func: init
			args: None
			doc: 
		*/
		setSpacing(layoutSpacing);
		setLayout();
	}
	private void setLayout(){
		/*
			func: setLayout
			args: None
			doc: This function will call all the components to be created.
		*/
			createLeft();
			createTitle();
			createTimeLabel();


	}
	private void createTimeLabel(){
		/*
			func: createTimeLabel
			args: None
			doc: This function will create the startTime text to be displayed.
		*/
		startTime = new Text();

		getChildren().add(startTime);

	}
	private void createLeft(){
		/*
			func: createLeft
			args: None
			doc: 
		*/
		left = new Rectangle();

		getChildren().add(left);
	}
	private void createTitle(){
		/*
			func: createTitle
			args: None
			doc: This function will create and add the title of the event.
		*/
		title = new Text();

		getChildren().add(title);

	}
	private void createStartTime(){
		/*
			func: createStartTime
			args: None
			doc: 
		*/
		startTime = new Text();

		getChildren().add(startTime);
	}


}