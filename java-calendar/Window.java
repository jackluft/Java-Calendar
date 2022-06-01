import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
public class Window{
	//this class will hold the stage and scene
	private Scene scene;
	private Stage stage;
	private BorderPane pane;

	private Frame frame;

	private double width;
	private double height;
	public Window(double width, double height){
		this.width = width;
		this.height = height;
		createLayout();
		createFrame();
		stage.show();

	}
	private void createLayout(){
		stage = new Stage();
		stage.setWidth(width);
		stage.setHeight(height);
		pane = new BorderPane();
		scene = new Scene(pane);
		stage.setScene(scene);

	}
	private void createFrame(){
		frame = new Frame();
		pane.setCenter(frame);
	}
}