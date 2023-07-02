package com.example.temperatureconvertertooljava;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar= createMenu();
        rootNode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootNode, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Convertor Tool");
//        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu(){
        Menu fileMenu= new Menu("File");
        MenuItem newMenuItem= new MenuItem("new");
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem quitMenuItem= new MenuItem("Quit");
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
        newMenuItem.setOnAction(actionEvent -> System.out.println("Creating New File"));
        quitMenuItem.setOnAction(actionEvent -> {
            System.out.println("Exiting...");
            Platform.exit();
//                System.exit(0);
        });

        Menu helpMenu=new Menu("Help");
        MenuItem aboutApp=new MenuItem("About");
        helpMenu.getItems().addAll(aboutApp);

        aboutApp.setOnAction(actionEvent -> aboutApp());

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutApp() {
        System.out.println("Opening about");
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("Title");
        alertDialog.setHeaderText("Header");
        alertDialog.setContentText("This is content");

        ButtonType yesBtn=new ButtonType("Yes");
        ButtonType noBtn=new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

        Optional<ButtonType> clickedBtn=alertDialog.showAndWait();
        if(clickedBtn.get()==yesBtn){
            System.out.println("Yes");
        }
        if(clickedBtn.get()==noBtn){
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}