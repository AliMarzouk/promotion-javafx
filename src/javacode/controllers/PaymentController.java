package javacode.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PaymentController {
    @FXML
    private TextField code;

    @FXML
    private AnchorPane card;

    @FXML
    void TwoPressed(ActionEvent event) {
        this.code.appendText("*");
    }

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void eightPressed(ActionEvent event) {
        this.code.appendText("*");
    }

    @FXML
    void fivePressed(ActionEvent event) {
        this.code.appendText("*");
    }

    @FXML
    void fourPressed(ActionEvent event) {
        this.code.appendText("*");
    }

    @FXML
    void ninePressed(ActionEvent event) {
        this.code.appendText("*");
    }

    @FXML
    void onePressed(ActionEvent event) {
        this.code.appendText("*");
    }

    @FXML
    void sevenPressed(ActionEvent event) {
        this.code.appendText("*");
    }

    @FXML
    void sixPressed(ActionEvent event) {
        this.code.appendText("*");
    }

    @FXML
    void threePressed(ActionEvent event) {
        this.code.appendText("*");
    }

    public void initAnimation() {
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(this.card.layoutYProperty(), this.card.getLayoutY()+20);
        final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    @FXML
    public void initialize() {
        this.initAnimation();
        this.code.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() == 4) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../ressources/view/thankYou.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Thank you");
                    stage.setScene(new Scene(root, 600, 400));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
