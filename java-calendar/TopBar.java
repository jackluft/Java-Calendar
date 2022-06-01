import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text; 
import javafx.scene.layout.*;
import javafx.scene.control.Button;
public class TopBar extends BorderPane{

	//interface
	private ButtonPressed bp;

	private Text header;

	private Button backButton;
	private Button forwardButton;
	private Button currentButton;
	private HBox right;


	private int year;
	private String month;
	private String dayOfWeek;
	private int day;

	public TopBar(ButtonPressed bp,int year,String month){
		this.bp = bp;
		this.year = year;
		this.month = month;
		createHeader();
		createButtons();

		


	}
	private void createButtons(){
		/*
			func: createButtons
			args: None
			doc: This function will create and add the back button and
			forward button.


		*/
		right = new HBox();
		createCurrentButton();
		createBackButton();
		createForwardButton();
		right.getChildren().add(currentButton);
		right.getChildren().add(backButton);
		right.getChildren().add(forwardButton);
		setRight(right);




	}
	private void createCurrentButton(){
		/*
			func: createCurrentButton
			args: None
			doc: This function will create and add the currentButton.
			The current Button will display the current month and chagne the sidebar to the current day.
		*/
		currentButton = new Button("Current");
		currentButton.setOnAction(e->{
			bp.current();
		});

	}
	private void createBackButton(){
		/*
			func: createBackButton
			args: None
			doc: This function will create the back button

		*/
		backButton = new Button("<");
		backButton.setOnAction(e->{
			bp.back();

		});


	}
	private void createForwardButton(){
		/*
			func: createForwardButton
			args: None
			doc: This function will create the forward button.

		*/
		forwardButton = new Button(">");
		forwardButton.setOnAction(e->{
			bp.forward();
		});

	}
	private void createHeader(){
		/*
			func: createHeader
			args: None
			doc: This function will create the text header.

		*/
		String txt = this.month+", "+this.year;
		header = new Text();
		header.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
		header.setText(txt);
		setLeft(header);
		setStyle("-fx-border-color: black; -fx-border-width: 0 0 5 0;"); 
	}
	public void setTime(int year, String month){
		this.year = year;
		this.month = month;
		String txt = this.month+", "+this.year;
		header.setText(txt);
	}
}