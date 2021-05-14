package sample;

import javacode.controllers.ListController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ressources/view/listScreen.fxml"));
        Parent root = fxmlLoader.load();
        ListController listController = (ListController) fxmlLoader.getController();
        listController.updateList();
        primaryStage.setTitle("List of good deals");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
