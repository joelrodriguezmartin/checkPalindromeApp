package dad.javafx.checkPalindrome;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class checkPalindromeApp extends Application {

	private TextField palindromeText;
	private Button palindromeButton;
	private Label palindromeLabel;
	@Override
	public void start(Stage primaryStage) throws Exception {
		palindromeText = new TextField();
		palindromeText.setPromptText("Introduce un texto: ");
		palindromeText.setMaxWidth(150);
		
		palindromeLabel = new Label("Aqui saldra la solción");
		
		palindromeButton = new Button("Comprobar palindromo");
		palindromeButton.setDefaultButton(true);
		palindromeButton.setOnAction(e -> onSaludarButtonAction(e));
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(palindromeText, palindromeButton, palindromeLabel);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("checkPalindrome");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	private void onSaludarButtonAction(ActionEvent e) {
		String input = palindromeText.getText();
		String inverse = "";
	    boolean pal = true;
	    int i;
	    for (i = input.length() - 1 ; i >= 0 ; i--) {
	        inverse = inverse + input.charAt(i);
	    }
	    i = 0;

	    while (i < input.length() && pal == true){
	        if (inverse.charAt(i) != input.charAt(i)){
	            pal = false;
	        }
	        i++;
	    }
	    if (pal){
	    	palindromeLabel.setText("Es palíndromo");
	    	palindromeLabel.setStyle("-fx-text-fill: green; -fx-font:italic bold 30 comic-sans;");
	    }
	    else {
	    	palindromeLabel.setText("No es palíndromo");
	    	palindromeLabel.setStyle("-fx-text-fill: red; -fx-font:italic bold 30 consolas;");
	    }
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
