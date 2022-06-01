import javafx.scene.layout.*;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
public class AddForm extends BorderPane{

	private TextField eventNameField;

	private RadioButton workEvent;
	private RadioButton vacEvent;
	private RadioButton otherEvent;

	private HBox radioButtonHolder;

	private Button addBtn;
	public AddForm(){
		init();
	}
	private void init(){
		/*
			func: init
			args: None
			doc: 

		*/

	}
	private void createAddButton(){
		/*
			func: createAddButton
			args: None
			doc: This function will create the add button for the form.

		*/
		addBtn = new Button("Add");

		addBtn.setOnAction(e->{
			//when the add button is pressed
		});
		setBottom(addBtn);

	}
	private void createTypeOfEventHolder(){
		/*
			func: createTypeOfEventHolder
			args: None
			doc: 
		*/
		radioButtonHolder = new HBox();
		createWorkRadioButton();
		createVacationRadioButton();
		createOtherRadioButton();



	}
	private void createWorkRadioButton(){
		/*
			func: createWorkRadioButton
			args: None
			doc: This function will create  and add the radio button, that when selected the event will be a work event.

		*/
		workEvent = new RadioButton();
		workEvent.setText("Work");
		radioButtonHolder.getChildren().add(workEvent);

	}
	private void createVacationRadioButton(){
		/*
			func: createVacationRadioButton
			args: None
			doc: This function will create and add the radio button, that when select the event will be a vaction event.

		*/
		vacEvent = new RadioButton();
		vacEvent.setText("Vacation");
		radioButtonHolder.getChildren().add(vacEvent);
	}
	private void createOtherRadioButton(){
		/*
			func: createOtherRadioButton
			args: None
			doc: This function will create and add the radio button, that when select the event will be an other event.
			(don't have a name for the event)
		*/
		otherEvent = new RadioButton();
		otherEvent.setText("Other");
		radioButtonHolder.getChildren().add(otherEvent);
	}

	private void createEventNameField(){
		/*
			func: createEventNameField
			args: None
			doc: This function will create the text field that holds the events name
		*/
		eventNameField = new TextField();
		eventNameField.setPromptText("New Event");

	}
}