import java.util.Optional;

import javax.swing.event.HyperlinkEvent.EventType;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Main extends Application {
	@SuppressWarnings("deprecation")
	@Override
	public void start(Stage primaryStage) {
		
		HBox addNewEntryHBox = getAddEntryHBox();
		
		TableView tableOfToDoList = getTableView();
		
		HBox importSaveGenerateHBox = getImportSaveGenerateHBox();
		
		HBox sortButtonsHBox = sortButtonsHBox();
		
		//Makes window and stuff------------------------------------------------
		AnchorPane root = new AnchorPane();
	
		root.getChildren().addAll(addNewEntryHBox, sortButtonsHBox, tableOfToDoList, importSaveGenerateHBox);
		Scene scene = new Scene(root, 1000, 800);
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
	
	
	
	public HBox sortButtonsHBox() {
		
		HBox sortButtons = new HBox();
		sortButtons.setPadding(new Insets(0,5,2,5));
		sortButtons.setSpacing(12);
		sortButtons.setLayoutY(77);
		sortButtons.setMinHeight(55);
		sortButtons.setMaxHeight(55);
		sortButtons.setStyle("-fx-background-color: 	#008080;");
		
		//Sort by Due Date Button-----------------------------------------------------
		Button sortByDueDateButton = new Button();
		sortByDueDateButton.setText("Sort By Due Date");
		sortByDueDateButton.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						//This is called when the sort by due date button is pressed.
						//It needs to call sort by due date function and then call update
						//update will reload all of the table entries based on the corresponding entry in the array list.======================================================================================================================================================================================================================
						
					}
				});
		sortByDueDateButton.setMinHeight(40);
		sortByDueDateButton.setMaxHeight(40);
		sortByDueDateButton.setLayoutY(30);
		sortByDueDateButton.setMinWidth(120);
		sortByDueDateButton.setMaxWidth(120);
		
		
		//Sort by Priority Button-----------------------------------------------------
		Button sortByPriorityButton = new Button();
				sortByPriorityButton.setText("Sort By Priority");
				sortByPriorityButton.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								//This is called when the sort by priority button is pressed.
								//It needs to call sort by priority function and then call update
								//update will reload all of the table entries based on the corresponding entry in the array list=================================================================================================================================================================================================================================================================================================================================
								
							}
						});
				sortByPriorityButton.setMinHeight(40);
				sortByPriorityButton.setMaxHeight(40);
				sortByPriorityButton.setLayoutY(30);
				sortByPriorityButton.setMinWidth(120);
				sortByPriorityButton.setMaxWidth(120);
				
		Button sortByNameButton = new Button();
		sortByNameButton.setText("Sort By Name");
		sortByNameButton.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								//This is called when the sort by name button is pressed.
								//It needs to call sort by name function and then call update
								//update will reload all of the table entries based on the corresponding entry in the array list.======================================================================================================================================================================================================================
								
							}
						});
		sortByNameButton.setMinHeight(40);
		sortByNameButton.setMaxHeight(40);
		sortByNameButton.setLayoutY(30);
		sortByNameButton.setMinWidth(120);
		sortByNameButton.setMaxWidth(120);
		
		//Change Due Date Button-----------------------------------------------------
				Button changeByDueDateButton = new Button();
				changeByDueDateButton.setText("Change Entry Due Date");
				changeByDueDateButton.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								//This is called when the sort by due date button is pressed.
								//It needs to call sort by due date function and then call update
								//update will reload all of the table entries based on the corresponding entry in the array list.

									TextInputDialog descriptionAlert = new TextInputDialog("Enter Entry's unique description"); 
									descriptionAlert.setTitle("Enter Entry's unique description");
									descriptionAlert.setHeaderText("Please Enter Entry's unique description");
									descriptionAlert.setContentText("Entry's unique description is: ");
								
									Optional<String> result = descriptionAlert.showAndWait();
									if (result.isPresent()){
									    System.out.println("description given: " + result.get());
									    boolean descriptionGivenIsValid = true; //the ToDoList class should implement this by returning null if description does not exist, otherwise the
									    //index of the Entry in the array=================================================================================================================================================================================================================================================================================================================================
									    if(descriptionGivenIsValid) {
									    	TextInputDialog changeDueDateAlert = new TextInputDialog("Enter the Entry's new Due Date"); 
									    	changeDueDateAlert.setTitle("Enter the Entry's new Due Date");
									    	changeDueDateAlert.setHeaderText("Enter the Entry's new Due Date");
									    	changeDueDateAlert.setContentText("Enter the Entry's new Due Date: ");
									    	
									    	Optional<String> result2 = changeDueDateAlert.showAndWait();
									    	if (result2.isPresent()){
									    		System.out.println("new due date given: " + result2.get());
									    		//Here it needs to perform the change to the Date of the given Entry and then call update ======================================================================================================================================================================================================================
									    		//NOTE: IT SHOULD MAKE SURE THE DATE IS IN THE CORRECT FORMAT OF MM.DD.YYYY (if it is not, do nothing)
									    	}
									    }
									}
									
							}
						});
				changeByDueDateButton.setMinHeight(40);
				changeByDueDateButton.setMaxHeight(40);
				changeByDueDateButton.setLayoutY(30);
				changeByDueDateButton.setMinWidth(150);
				changeByDueDateButton.setMaxWidth(150);
				
				
				//Change by Priority Button-----------------------------------------------------
				Button changeByPriorityButton = new Button();
				changeByPriorityButton.setText("Change Entry Priority");
				changeByPriorityButton.setOnAction(new EventHandler<ActionEvent>() {
									
									@Override
									public void handle(ActionEvent event) {
										//This is called when the Change Entry Priority button is pressed.
									
										TextInputDialog descriptionAlert = new TextInputDialog("Enter Entry's unique description"); 
										descriptionAlert.setTitle("Enter Entry's unique description");
										descriptionAlert.setHeaderText("Please Enter Entry's unique description");
										descriptionAlert.setContentText("Entry's unique description is: ");
										// Traditional way to get the response value.
										Optional<String> result = descriptionAlert.showAndWait();
										if (result.isPresent()){
										    System.out.println("description given: " + result.get());
										    boolean descriptionGivenIsValid = true; //the ToDoList class should implement this by returning null if description does not exist, otherwise the
										    //index of the Entry in the array=================================================================================================================================================================================================================================================================================================================================
										    if(descriptionGivenIsValid) {
										    	TextInputDialog changePriorityAlert = new TextInputDialog("Enter the Entry's new Priority"); 
										    	changePriorityAlert.setTitle("Enter the Entry's new Priority");
										    	changePriorityAlert.setHeaderText("Enter the Entry's new Priority");
										    	changePriorityAlert.setContentText("Enter the Entry's new Priority: ");
										    	
										    	Optional<String> result2 = changePriorityAlert.showAndWait();
										    	if (result2.isPresent()){
										    		System.out.println("new due date given: " + result2.get());
										    		//Here it needs to perform the change to priority of the given Entity and then call update======================================================================================================================================================================================================================
										    	}
										    }
										}
									}
								});
				changeByPriorityButton.setMinHeight(40);
				changeByPriorityButton.setMaxHeight(40);
				changeByPriorityButton.setLayoutY(30);
				changeByPriorityButton.setMinWidth(150);
				changeByPriorityButton.setMaxWidth(150);
						
				Button changeByNameButton = new Button();
				changeByNameButton.setText("Change Entry Description");
				changeByNameButton.setOnAction(new EventHandler<ActionEvent>() {
									
									@Override
									public void handle(ActionEvent event) {
										//This is called when the Change Entry Description button is pressed.
										TextInputDialog descriptionAlert = new TextInputDialog("Enter Entry's unique description"); 
										descriptionAlert.setTitle("Enter Entry's unique description");
										descriptionAlert.setHeaderText("Please Enter Entry's unique description");
										descriptionAlert.setContentText("Entry's unique description is: ");
										// Traditional way to get the response value.
										Optional<String> result = descriptionAlert.showAndWait();
										if (result.isPresent()){
										    System.out.println("description given: " + result.get());
										    boolean descriptionGivenIsValid = true; //the ToDoList class should implement this by returning null if description does not exist, otherwise the =================================================================================================================================================================================================================================================================================================================================
										    //index of the Entry in the array----------=================================================================================================================================================================================================================================================================================================================================
										    if(descriptionGivenIsValid) {
										    	TextInputDialog changeDescriptionAlert = new TextInputDialog("Enter the Entry's New Description"); 
										    	changeDescriptionAlert.setTitle("Enter the Entry's new Description");
										    	changeDescriptionAlert.setHeaderText("Enter the Entry's new Description");
										    	changeDescriptionAlert.setContentText("Enter the Entry's new Description: ");
										    	
										    	Optional<String> result2 = changeDescriptionAlert.showAndWait();
										    	if (result2.isPresent()){
										    		System.out.println("new description given: " + result2.get());
										    		//Here it needs to perform the change to the description and then call update ======================================================================================================================================================================================================================
										    	}
										    }
										}
									}
								});
				changeByNameButton.setMinHeight(40);
				changeByNameButton.setMaxHeight(40);
				changeByNameButton.setLayoutY(30);
				changeByNameButton.setMinWidth(150);
				changeByNameButton.setMaxWidth(150);
				
				
				Button deleteEntryButton = new Button();
				deleteEntryButton.setText("Delete Entry");
				deleteEntryButton.setOnAction(new EventHandler<ActionEvent>() {
									
									@Override
									public void handle(ActionEvent event) {
										//This is called when the Delete Entry button is pressed.
										TextInputDialog descriptionAlert = new TextInputDialog("Enter Entry's unique description"); 
										descriptionAlert.setTitle("Enter Entry's unique description");
										descriptionAlert.setHeaderText("Please Enter Entry's unique description");
										descriptionAlert.setContentText("Entry's unique description is: ");
										Optional<String> result = descriptionAlert.showAndWait();
										if (result.isPresent()){
										    System.out.println("description given: " + result.get());
										    //now it should delete the Entry corresponding to that description and call update======================================================================================================================================================================================================================
										}
									}
								});
				deleteEntryButton.setMinHeight(40);
				deleteEntryButton.setMaxHeight(40);
				deleteEntryButton.setLayoutY(30);
				deleteEntryButton.setMinWidth(120);
				deleteEntryButton.setMaxWidth(120);
		
		
		sortButtons.getChildren().addAll(sortByDueDateButton, sortByPriorityButton, sortByNameButton, changeByDueDateButton, changeByPriorityButton, changeByNameButton, deleteEntryButton);
		
		return sortButtons;
	}
	
	public HBox getAddEntryHBox() {
				
				//----------------------------------------------------------------------
				HBox addNewEntryHBox = new HBox();
				addNewEntryHBox.setPadding(new Insets(0,5,2,5));
				addNewEntryHBox.setSpacing(10);
				addNewEntryHBox.setLayoutY(2);
				addNewEntryHBox.setMinHeight(75);
				addNewEntryHBox.setMaxHeight(75);
				addNewEntryHBox.setStyle("-fx-background-color: 	#008080;");
				
				
				
				Pane namePane = new Pane();
				namePane.setMinHeight(75);
				namePane.setMaxHeight(75);
				namePane.setMinWidth(100);
				namePane.setMaxWidth(100);
				TextField nameTextField = new TextField();
				nameTextField.setPromptText("name");
				nameTextField.setMinHeight(34);
				nameTextField.setMaxHeight(34);
				nameTextField.setMinWidth(100);
				nameTextField.setMaxWidth(100);
				nameTextField.setPrefSize(100, 34);
				nameTextField.setLayoutY(23);
				nameTextField.setId("nameTextField");
				
				Label nameLabel = new Label();
				nameLabel.setText("Name");
				nameLabel.setAlignment(Pos.CENTER);
				nameLabel.setMinHeight(20);
				nameLabel.setMaxHeight(20);
				nameLabel.setMinWidth(100);
				nameLabel.setMaxWidth(100);
				nameLabel.setLayoutY(2);
				nameLabel.setFont(new Font("System",14));
				namePane.getChildren().addAll(nameTextField,nameLabel);
				
				
				Pane descriptionPane = new Pane();
				descriptionPane.setMinHeight(75);
				descriptionPane.setMaxHeight(75);
				descriptionPane.setMinWidth(592);
				descriptionPane.setMaxWidth(592);
				TextField descriptionTextField = new TextField();
				descriptionTextField.setPromptText("description");
				descriptionTextField.setMinHeight(34);
				descriptionTextField.setMaxHeight(34);
				descriptionTextField.setMinWidth(592);
				descriptionTextField.setMaxWidth(592);
				descriptionTextField.setPrefSize(592, 34);
				descriptionTextField.setLayoutY(23);
				descriptionTextField.setId("descriptionTextField");
			
				Label descriptionLabel = new Label();
				descriptionLabel.setText("Description");
				descriptionLabel.setAlignment(Pos.CENTER);
				descriptionLabel.setMinHeight(20);
				descriptionLabel.setMaxHeight(20);
				descriptionLabel.setMinWidth(592);		
				descriptionLabel.setMaxWidth(592);
				descriptionLabel.setLayoutY(2);
				descriptionLabel.setFont(new Font("System",14));
				descriptionPane.getChildren().addAll(descriptionTextField,descriptionLabel);
				
				
				
				Pane dueDatePane = new Pane();
				dueDatePane.setMinHeight(75);
				dueDatePane.setMaxHeight(75);
				dueDatePane.setMinWidth(100);
				dueDatePane.setMaxWidth(100);
				TextField dueDateTextField = new TextField();
				dueDateTextField.setPromptText("due date");
				dueDateTextField.setMinHeight(34);
				dueDateTextField.setMaxHeight(34);
				dueDateTextField.setMinWidth(100);
				dueDateTextField.setMaxWidth(100);
				dueDateTextField.setPrefSize(100, 34);
				dueDateTextField.setLayoutY(23);
				dueDateTextField.setId("dueDateTextField");
	
				
				Label dueDateLabel = new Label();
				dueDateLabel.setText("Due Date");
				dueDateLabel.setAlignment(Pos.CENTER);
				dueDateLabel.setMinHeight(20);
				dueDateLabel.setMaxHeight(20);
				dueDateLabel.setMinWidth(100);
				dueDateLabel.setMaxWidth(100);
				dueDateLabel.setLayoutX(0);
				dueDateLabel.setLayoutY(2);
				dueDateLabel.setFont(new Font("System",14));
				
				dueDatePane.getChildren().addAll(dueDateTextField, dueDateLabel);
				
				
				
				Pane priorityPane = new Pane();
				priorityPane.setMinHeight(75);
				priorityPane.setMaxHeight(75);
				priorityPane.setMinWidth(100);
				priorityPane.setMaxWidth(100);
				TextField priorityTextField = new TextField();
				priorityTextField.setPromptText("priority");
				priorityTextField.setPromptText("due date");
				priorityTextField.setMinHeight(34);
				priorityTextField.setMaxHeight(34);
				priorityTextField.setMinWidth(100);
				priorityTextField.setMaxWidth(100);
				priorityTextField.setPrefSize(100, 34);
				priorityTextField.setLayoutY(23);
				priorityTextField.setId("priorityTextField");
			
				
				Label priorityLabel = new Label();
				priorityLabel.setText("Priority");
				priorityLabel.setAlignment(Pos.CENTER);
				priorityLabel.setMinHeight(20);
				priorityLabel.setMaxHeight(20);
				priorityLabel.setMinWidth(100);
				priorityLabel.setMaxWidth(100);
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
								//call update after it does this.=================================================================================================================================================================================================================================================================================================================================
								//update will reload all of the table entries.
								if (nameTextField.getText() != null && descriptionTextField.getText() != null && dueDateTextField.getText() != null && priorityTextField.getText() != null) {
									//some extra parsing should be handled here for valid dates and priority >= 1 or 0
									//it should also check for the text not equal to "" (since it can be "" but not null)======================================================================================================================================================================================================================
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
						if (nameTextField.getText() != null && descriptionTextField.getText() != null && dueDateTextField.getText() != null && priorityTextField.getText() != null) {
							//some extra parsing should be handled here for valid dates and priority >= 1 or 0
							//it should also check for the text not equal to "" (since it can be "" but not null)======================================================================================================================================================================================================================
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
								
				addNewEntryHBox.getChildren().addAll(addEntryPane, namePane, descriptionPane, dueDatePane, priorityPane);		
		
		return addNewEntryHBox;
	}
	
	public TableView getTableView() {
		//Set up table of To Do Entries-----------------------------------------
				TableView tableOfToDoList = new TableView();
				tableOfToDoList.setEditable(true);
			
		
				TableColumn priorityColumn = new TableColumn("Priority");
				priorityColumn.setId("priorityColumn");
				priorityColumn.setMinWidth(72);
				priorityColumn.setMaxWidth(72);
		
				TableColumn nameColumn = new TableColumn("Name");
				priorityColumn.setId("nameColumn");
				priorityColumn.setMinWidth(105);
				priorityColumn.setMaxWidth(105);
				
				TableColumn descriptionColumn = new TableColumn("Description");
				descriptionColumn.setMinWidth(508);
				descriptionColumn.setMaxWidth(508);
				
				TableColumn dueDateColumn = new TableColumn("Due Date");
				dueDateColumn.setMinWidth(105);
				dueDateColumn.setMaxWidth(105);
				
				TableColumn finishDateColumn = new TableColumn("Finish Date");
				finishDateColumn.setMinWidth(105);
				finishDateColumn.setMaxWidth(105);
				
				TableColumn statusColumn = new TableColumn("Status");
				statusColumn.setMinWidth(105);
				statusColumn.setMaxWidth(105);
				
				tableOfToDoList.getColumns().addAll(priorityColumn, nameColumn, descriptionColumn, dueDateColumn, finishDateColumn, statusColumn);
				tableOfToDoList.setLayoutX(0);
				tableOfToDoList.setLayoutY(77 + 55);
				tableOfToDoList.setMinHeight(480 + 260 - (77 + 55));
				tableOfToDoList.setMaxHeight(480 + 260 - (77 + 55));
				tableOfToDoList.setMinWidth(1000);
				//----------------------------------------------------------------------
		return tableOfToDoList;
	}
	
	public HBox getImportSaveGenerateHBox() {
		
		//Makes Row of buttons at the bottom for importing, exporting, and generating reports
				HBox importSaveGenerateHBox = new HBox();
				importSaveGenerateHBox.setPadding(new Insets(15,12,15,12));
				
				importSaveGenerateHBox.setSpacing(180);
				importSaveGenerateHBox.setStyle("-fx-background-color: 	#008080;");
				Button importListButton = new Button();
				importListButton.setText("Import List");
				importListButton.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						//This is called when the Import button is pressed.
						//update will reload all of the table entries.======================================================================================================================================================================================================================
						System.out.println("Import Pressed");
						TextInputDialog importAlert = new TextInputDialog("example.txt"); 
						importAlert.setTitle("Import");
						importAlert.setHeaderText("Please Answer");
						importAlert.setContentText("Please enter the file name: ");
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
						//it outputs to a file the user specifies.======================================================================================================================================================================================================================
						System.out.println("Generate Report Pressed");
						TextInputDialog importAlert = new TextInputDialog("example.txt"); 
						importAlert.setTitle("Generate Report");
						importAlert.setHeaderText("Please Answer");
						importAlert.setContentText("Please enter the desired file name: ");
						Optional<String> result = importAlert.showAndWait();
						if (result.isPresent()){
						    System.out.println("File name given: " + result.get());
						}
					}
				});
				generateRupportButton.setPrefSize(150, 60);
				Button saveListButton = new Button();
				saveListButton.setText("Save List");
				saveListButton.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						//This is called when the Generate button is pressed.
						//It needs to print the stuff in the to do list (using the print
						//function given in the to do list class) to get a string with which
						//it outputs to a file the user specifies.======================================================================================================================================================================================================================
						System.out.println("Save List Pressed");
						TextInputDialog importAlert = new TextInputDialog("example.txt"); 
						importAlert.setTitle("Save To Do List");
						importAlert.setHeaderText("Please Answer");
						importAlert.setContentText("Please enter the desired file name: ");
						
						Optional<String> result = importAlert.showAndWait();
						if (result.isPresent()){
						    System.out.println("File name given: " + result.get());
						}
					}
				});
				saveListButton.setPrefSize(100, 60);
				
				Button startOverButton = new Button();
				startOverButton.setText("Start Over");
				startOverButton.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						//This is called when the Start Over button is pressed.
						//It needs to delete everything in the array (call the start over function)
						//and then call update.======================================================================================================================================================================================================================
						System.out.println("Start Over Button Pressed");
						
		
					}
				});
				startOverButton.setPrefSize(100, 60);
				
				importSaveGenerateHBox.getChildren().addAll(importListButton, generateRupportButton, saveListButton, startOverButton);
				importSaveGenerateHBox.setMaxHeight(60);
				importSaveGenerateHBox.setMinHeight(70);
				importSaveGenerateHBox.setLayoutX(0);
				importSaveGenerateHBox.setLayoutY(740);
				importSaveGenerateHBox.setMinWidth(1000);
				//----------------------------------------------------------------------
				
		return importSaveGenerateHBox;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
