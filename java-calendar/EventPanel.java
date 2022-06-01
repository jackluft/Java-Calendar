import javafx.scene.layout.*;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
public class EventPanel extends BorderPane{

	private DisplayForm displayForm;
	private AddForm addForm;

	private HBox header;

	private ToggleGroup btnGroup;
	private ToggleButton displayButton;
	private ToggleButton addButton;

	private final double buttonWidth = 60;
	private final double buttonHeight = 30;

	private Event tempEvent;
	public EventPanel(Event event){
		this.tempEvent = event;
		init();

	}
	private void init(){
		/*
			func: init
			args: None
			doc: 

		*/
		createHeader();
		createDisplayForm();
		createAddForm();
	}
	private void createDisplayForm(){
		/*	
			func: createDisplayForm
			args: None
			doc: This function will create the display form object and add it to the center of the layout.
		*/
		displayForm = new DisplayForm(tempEvent);
		setCenter(displayForm);

	}
	private void createAddForm(){
		/*
			func: createAddForm
			args: None
			doc: This function will create the add form object.
		*/
		addForm = new AddForm();

	}
	private void createHeader(){
		/*
			func: createHeader
			args: None
			doc: This function will create and add the header and the components to the header.

		*/
		header = new HBox();
		createButtons();

		header.getChildren().add(displayButton);
		header.getChildren().add(addButton);
		setTop(header);

	}
	private void createDisplayEventButton(){
		/*
			func: createDisplayEventButton
			args: None
			doc:
		*/
		displayButton = new ToggleButton("Display");

		displayButton.setMinWidth(buttonWidth);
		displayButton.setPrefWidth(buttonWidth);
		displayButton.setMaxWidth(buttonWidth);

		displayButton.setSelected(true);

		displayButton.setOnAction(e->{
			//change cetner to the display form object
			setCenter(displayForm);
		});

		

	}
	private void createButtons(){
		/*
			func: createButtons
			args: None
			doc: 
		*/
		btnGroup = new ToggleGroup();
		createDisplayEventButton();
		createAddEventButton();
		displayButton.setToggleGroup(btnGroup);
		addButton.setToggleGroup(btnGroup);

		


	}
	private void createAddEventButton(){
		/*
			func: createAddEventButton
			args: None
			doc: 
		*/
		addButton = new ToggleButton("Add");

		addButton.setMinWidth(buttonWidth);
		addButton.setPrefWidth(buttonWidth);
		addButton.setMaxWidth(buttonWidth);

		addButton.setOnAction(e->{
			//change center to the display add Form object.
			setCenter(addForm);
		});

		

	}
}