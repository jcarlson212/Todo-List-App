//package ToDoListPackage;

import java.util.Optional;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;

public class Main extends Application {
	@SuppressWarnings("deprecation")
	@Override
	public void start(Stage primaryStage) {
		
		HBox addNewEntryHBox = getAddEntryHBox();
		
		TableView tableOfToDoList = getTableView();
		
		HBox importSaveGenerateHBox = getImportSaveGenerateHBox();
		
		//Makes window and stuff------------------------------------------------
		AnchorPane root = new AnchorPane();
	
		root.getChildren().addAll(addNewEntryHBox, tableOfToDoList, importSaveGenerateHBox);
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);;
		primaryStage.setResizable(false);
		primaryStage.setTitle("To Do List");
		primaryStage.setScene(scene);
		primaryStage.show();
	
		//----------------------------------------------------------------------
	}
	
	//EXAMPLE (DOES NOT ACTUALLY UPDATE YET SINCE IT DEPENDS ON CLASS)
	public void update(AnchorPane root, Stage primaryStage) {
		TableView temp = (TableView) root.getChildren().get(1); //this depends on tableOfToDoList being the second entry on line 49
		TableColumn priorityColumn = (TableColumn) temp.getColumns().get(0);
		TableColumn descriptionColumn = (TableColumn) temp.getColumns().get(1);
		TableColumn dueDateColumn = (TableColumn) temp.getColumns().get(2);
		TableColumn finishDateColumn = (TableColumn) temp.getColumns().get(3);
		TableColumn statusColumn = (TableColumn) temp.getColumns().get(4);
		priorityColumn.setCellValueFactory(new PropertyValueFactory<>("0"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("example description"));
		dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("4/25/2019"));
		finishDateColumn.setCellValueFactory(new PropertyValueFactory<>("NA"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<>("In Progress"));
		primaryStage.show();
	}
	
	public HBox getAddEntryHBox() {
				
				//----------------------------------------------------------------------
				HBox addNewEntryHBox = new HBox();
				addNewEntryHBox.setPadding(new Insets(0,5,2,5));
				addNewEntryHBox.setSpacing(10);
				addNewEntryHBox.setLayoutY(2);
				addNewEntryHBox.setMinHeight(97);
				addNewEntryHBox.setMaxHeight(97);
				addNewEntryHBox.setStyle("-fx-background-color: 	#008080;");
				
				Pane descriptionPane = new Pane();
				descriptionPane.setMinHeight(75);
				descriptionPane.setMaxHeight(75);
				descriptionPane.setMinWidth(520);
				descriptionPane.setMaxWidth(520);
				TextField descriptionTextField = new TextField();
				descriptionTextField.setPromptText("description");
				descriptionTextField.setMinHeight(34);
				descriptionTextField.setMaxHeight(34);
				descriptionTextField.setMinWidth(520);
				descriptionTextField.setMaxWidth(520);
				descriptionTextField.setPrefSize(520, 34);
				descriptionTextField.setLayoutY(23);
				descriptionTextField.setId("descriptionTextField");
			
				
				Label descriptionLabel = new Label();
				descriptionLabel.setText("Description");
				descriptionLabel.setAlignment(Pos.CENTER);
				descriptionLabel.setMinHeight(20);
				descriptionLabel.setMaxHeight(20);
				descriptionLabel.setMinWidth(521);
				descriptionLabel.setMaxWidth(521);
				descriptionLabel.setLayoutX(0);
				descriptionLabel.setLayoutY(2);
				descriptionLabel.setFont(new Font("System",14));
				descriptionPane.getChildren().addAll(descriptionTextField,descriptionLabel);
				
				
				
				Pane dueDatePane = new Pane();
				dueDatePane.setMinHeight(75);
				dueDatePane.setMaxHeight(75);
				dueDatePane.setMinWidth(88);
				dueDatePane.setMaxWidth(88);
				TextField dueDateTextField = new TextField();
				dueDateTextField.setPromptText("due date");
				dueDateTextField.setMinHeight(34);
				dueDateTextField.setMaxHeight(34);
				dueDateTextField.setMinWidth(88);
				dueDateTextField.setMaxWidth(88);
				dueDateTextField.setPrefSize(88, 34);
				dueDateTextField.setLayoutY(23);
				dueDateTextField.setId("dueDateTextField");
	
				
				Label dueDateLabel = new Label();
				dueDateLabel.setText("Due Date");
				dueDateLabel.setAlignment(Pos.CENTER);
				dueDateLabel.setMinHeight(20);
				dueDateLabel.setMaxHeight(20);
				dueDateLabel.setMinWidth(88);
				dueDateLabel.setMaxWidth(88);
				dueDateLabel.setLayoutX(0);
				dueDateLabel.setLayoutY(2);
				dueDateLabel.setFont(new Font("System",14));
				
				dueDatePane.getChildren().addAll(dueDateTextField, dueDateLabel);
				
				
				
				Pane priorityPane = new Pane();
				priorityPane.setMinHeight(75);
				priorityPane.setMaxHeight(75);
				priorityPane.setMinWidth(92);
				priorityPane.setMaxWidth(92);
				TextField priorityTextField = new TextField();
				priorityTextField.setPromptText("priority");
				priorityTextField.setPromptText("due date");
				priorityTextField.setMinHeight(34);
				priorityTextField.setMaxHeight(34);
				priorityTextField.setMinWidth(92);
				priorityTextField.setMaxWidth(92);
				priorityTextField.setPrefSize(92, 34);
				priorityTextField.setLayoutY(23);
				priorityTextField.setId("priorityTextField");
			
				
				Label priorityLabel = new Label();
				priorityLabel.setText("Priority");
				priorityLabel.setAlignment(Pos.CENTER);
				priorityLabel.setMinHeight(20);
				priorityLabel.setMaxHeight(20);
				priorityLabel.setMinWidth(88);
				priorityLabel.setMaxWidth(88);
				priorityLabel.setLayoutX(0);
				priorityLabel.setLayoutY(2);
				priorityLabel.setFont(new Font("System",14));
				
				priorityPane.getChildren().addAll(priorityTextField, priorityLabel);
				
				
				//Add Entry Button-----------------------------------------------------
				Button addEntryButton = new Button();
				addEntryButton.setText("Add");
						addEntryButton.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								//This is called when the Add Entry button is pressed.
								//It needs to add the entry to the To Do List Class AND
								//call update after it does this.
								//update will reload all of the table entries.
								if (descriptionTextField.getText() != null && dueDateTextField.getText() != null && priorityTextField.getText() != null) {
									//some extra parsing should be handled here for valid dates and priority >= 1 or 0
									//it should also check for the text not equal to "" (since it can be "" but not null)
									System.out.println("Entry added: " + descriptionTextField.getText() + dueDateTextField.getText() + priorityTextField.getText());
								}
								
							}
						});
				addEntryButton.setMinHeight(25);
				addEntryButton.setMaxHeight(25);
				addEntryButton.setLayoutY(30);
				addEntryButton.setMinWidth(68);
				addEntryButton.setMaxWidth(68);
				
				
				Button makeFinishRequestForGivenEntryButton = new Button();
				makeFinishRequestForGivenEntryButton.setText("Finish");
				makeFinishRequestForGivenEntryButton.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						//This is called when the Mark Finished button is pressed.
						//It needs to mark an entry specified (if it exists) as finished in the To Do List Class AND
						//call update after it does this.
						//update will reload all of the table entries.
						if (descriptionTextField.getText() != null && dueDateTextField.getText() != null && priorityTextField.getText() != null) {
							//some extra parsing should be handled here for valid dates and priority >= 1 or 0
							//it should also check for the text not equal to "" (since it can be "" but not null)
							System.out.println("Entry marked finished: " + descriptionTextField.getText() + dueDateTextField.getText() + priorityTextField.getText());
						}
						
					}
					
				});
				makeFinishRequestForGivenEntryButton.setMinHeight(25);
				makeFinishRequestForGivenEntryButton.setMaxHeight(25);
				makeFinishRequestForGivenEntryButton.setLayoutY(2);
				makeFinishRequestForGivenEntryButton.setMinWidth(68);
				makeFinishRequestForGivenEntryButton.setMaxWidth(68);
				
				Pane addEntryPane = new Pane();
				addEntryPane.setMinHeight(75);
				addEntryPane.setMaxHeight(75);
			
				addEntryPane.getChildren().addAll(addEntryButton, makeFinishRequestForGivenEntryButton);
								
				addNewEntryHBox.getChildren().addAll(addEntryPane, descriptionPane, dueDatePane, priorityPane);		
		
		return addNewEntryHBox;
	}
	
	public TableView getTableView() {
		//Set up table of To Do Entries-----------------------------------------
				TableView tableOfToDoList = new TableView();
				tableOfToDoList.setEditable(true);
				TableColumn priorityColumn = new TableColumn("Priority");
				priorityColumn.setId("priorityColumn");
				priorityColumn.setMinWidth(72);
				priorityColumn.setMaxWidth(455);
				TableColumn descriptionColumn = new TableColumn("Description");
				descriptionColumn.setMinWidth(455);
				descriptionColumn.setMaxWidth(455);
				
				TableColumn dueDateColumn = new TableColumn("Due Date");
				dueDateColumn.setMinWidth(78);
				dueDateColumn.setMaxWidth(455);
				TableColumn finishDateColumn = new TableColumn("Finish Date");
				finishDateColumn.setMinWidth(90);
				finishDateColumn.setMaxWidth(455);
				TableColumn statusColumn = new TableColumn("Status");
				statusColumn.setMinWidth(105);
				statusColumn.setMaxWidth(455);
				tableOfToDoList.getColumns().addAll(priorityColumn, descriptionColumn, dueDateColumn, finishDateColumn, statusColumn);
				tableOfToDoList.setLayoutX(0);
				tableOfToDoList.setLayoutY(60);
				tableOfToDoList.setMinHeight(480);
				tableOfToDoList.setMaxHeight(480);
				tableOfToDoList.setMinWidth(800);
				
				//----------------------------------------------------------------------
		return tableOfToDoList;
	}
	
	public HBox getImportSaveGenerateHBox() {
		
		//Makes Row of buttons at the bottom for importing, exporting, and generating reports
				HBox importSaveGenerateHBox = new HBox();
				importSaveGenerateHBox.setPadding(new Insets(15,12,15,12));
				importSaveGenerateHBox.setSpacing(200);
				importSaveGenerateHBox.setStyle("-fx-background-color: 	#008080;");
				Button importListButton = new Button();
				importListButton.setText("Import List");
				importListButton.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						//This is called when the Import button is pressed.
						//update will reload all of the table entries.
						System.out.println("Import Pressed");
						TextInputDialog importAlert = new TextInputDialog("example.txt"); 
						importAlert.setTitle("Import");
						importAlert.setHeaderText("Please Answer");
						importAlert.setContentText("Please enter the file name: ");
						// Traditional way to get the response value.
						Optional<String> result = importAlert.showAndWait();
						if (result.isPresent()){
						    System.out.println("File name given: " + result.get());
						}

					}
				});
				importListButton.setPrefSize(100, 60);
				Button generateRupportButton = new Button();
				generateRupportButton.setText("Generate Report");
				generateRupportButton.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						//This is called when the Generate button is pressed.
						//It needs to print the stuff in the to do list (using the print
						//function given in the to do list class) to get a string with which
						//it outputs to a file the user specifies.
						System.out.println("Generate Report Pressed");
						TextInputDialog importAlert = new TextInputDialog("example.txt"); 
						importAlert.setTitle("Generate Report");
						importAlert.setHeaderText("Please Answer");
						importAlert.setContentText("Please enter the desired file name: ");
						// Traditional way to get the response value.
						Optional<String> result = importAlert.showAndWait();
						if (result.isPresent()){
						    System.out.println("File name given: " + result.get());
						}
					}
				});
				generateRupportButton.setPrefSize(100, 60);
				Button saveListButton = new Button();
				saveListButton.setText("Save List");
				saveListButton.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						//This is called when the Generate button is pressed.
						//It needs to print the stuff in the to do list (using the print
						//function given in the to do list class) to get a string with which
						//it outputs to a file the user specifies.
						System.out.println("Save List Pressed");
						TextInputDialog importAlert = new TextInputDialog("example.txt"); 
						importAlert.setTitle("Save To Do List");
						importAlert.setHeaderText("Please Answer");
						importAlert.setContentText("Please enter the desired file name: ");
						// Traditional way to get the response value.
						Optional<String> result = importAlert.showAndWait();
						if (result.isPresent()){
						    System.out.println("File name given: " + result.get());
						}
					}
				});
				saveListButton.setPrefSize(100, 60);
				
				importSaveGenerateHBox.getChildren().addAll(importListButton, generateRupportButton, saveListButton);
				importSaveGenerateHBox.setPrefSize(800,60);
				importSaveGenerateHBox.setMaxHeight(60);
				importSaveGenerateHBox.setMinHeight(70);
				importSaveGenerateHBox.setLayoutX(0);
				importSaveGenerateHBox.setLayoutY(540);
				importSaveGenerateHBox.setMinWidth(900);
				//----------------------------------------------------------------------
				
		return importSaveGenerateHBox;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
