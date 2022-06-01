import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
public class DisplayForm extends BorderPane{

	private final double width = 300;
	private final double height = 450;

	private Text title;
	private final int titleSize = 25;

	private Text startTime;
	private final int startTimeSize = 15;

	private Event event;

	private Text endTime;
	private final int endTimeSize = 15;

	//top
	private VBox header;


	//center
	private TextArea body;

	//Bottom
	//Button that will delete the event
	private Button deleteEventBtn;
	private final double deleteBtnWidth = 190;
	private final double deleteBtnHeight = 40;

	
	public DisplayForm(Event event){
		//Constructor 
		this.event = event;
		init();

	}
	private void setValues(){
		/*
			func: setValues
			args: None
			doc: This function will set all of the data being display change to the events data.
		*/
		title.setText(event.getName());
		startTime.setText(event.getStartTime().toString());
		endTime.setText(event.getEndTime().toString());
	}
	public void changeEvent(Event event){
		this.event = event;

		setValues();

	}
	private void createDeleteButton(){
		/*
			func: createDeleteButton
			args: None
			doc: This function will create the button that will delete the event selected.
		*/
		deleteEventBtn = new Button("Delete");


		deleteEventBtn.setMinWidth(deleteBtnWidth);
		deleteEventBtn.setPrefWidth(deleteBtnWidth);

		deleteEventBtn.setMinHeight(deleteBtnHeight);
		deleteEventBtn.setPrefHeight(deleteBtnHeight);



		deleteEventBtn.setStyle("-fx-background-color: red; -fx-border-radius: 20px; -fx-font-size: 23; -fx-text-fill: black;");
		deleteEventBtn.setOnAction(e->{
			//when button is pressed
		});
		deleteEventBtn.setOnMouseEntered(e->{
			//when the mouse enter the button
			deleteEventBtn.setStyle("-fx-background-color: red; -fx-border-radius: 20px; -fx-font-size: 25; -fx-text-fill: white;");
		});
		deleteEventBtn.setOnMouseExited(e->{
			//when the mouse existe the button
			deleteEventBtn.setStyle("-fx-background-color: red; -fx-border-radius: 20px; -fx-font-size: 23; -fx-text-fill: black;");

		});

		setBottom(deleteEventBtn);
	}

	private void init(){
		/*
			func: init
			args: None
			doc: 

		*/
		setSize();
		createMain();
		
	}
	private void setSize(){
		/*
			func: setSize
			args: None
			doc: This function will set the size for the form.

		*/
		setMinWidth(width);
		setPrefWidth(width);
		setMaxWidth(width);

		setMinHeight(height);
		setPrefHeight(height);
		setMaxHeight(height);
	}
	private void createBody(){
		/*
			func: createBody
			args: None
			doc: This function will create the body of the form.

		*/
		body = new TextArea();
		setCenter(body);
	}
	private void createHeader(){
		/*
			func: createHeader
			args: None
			doc: This function will create the header of the form, and 
			call all the fucntions to make the content in the header.

		*/
		header = new VBox();
		createTitle();
		createStartTime();
		createEndTime();
		setTop(header);

	}
	private void createMain(){
		/*
			func: createMain
			args: None
			doc: This function will create the main layout (BorderPane) 
			and create all the smaller layouts in the form.
		*/
		createHeader();
		createBody();
		createDeleteButton();
	

	}
	private void createTitle(){
		/*	
			func: createTitle
			args: None
			doc: This function will create the title of the event in Text format. Also add
			it to the form.

		*/
		title = new Text();
		title.setText("Running");
		title.setFont(new Font(titleSize));
		header.getChildren().add(title);
	}	
	private void createStartTime(){
		/*
			func: createStartTime
			args: None
			doc: This function will create the start time of the event in text format. Also add
			it to the form
			
		*/
		startTime = new Text();
		startTime.setText("6:45AM");

		startTime.setFont(new Font("PIRULAN RG",startTimeSize));
		header.getChildren().add(startTime);
	}
	private void createEndTime(){
		/*
			func: createEndTime
			args: None
			doc: This function will create the end time of the event in text format. 
			Also add it to the form.
		

		*/
		endTime = new Text();
		endTime.setText("7:30PM");
		endTime.setFont(new Font("PIRULAN RG",endTimeSize));
		header.getChildren().add(endTime);
	}

}