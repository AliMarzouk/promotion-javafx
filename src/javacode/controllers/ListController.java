package javacode.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Arrays;

import javacode.models.Promotion;
import javafx.stage.Stage;

public class ListController {

    private Promotion[] list = {
            new Promotion("baguette",
                    "sandwich", "2 for the price of 1",
                    "../../ressources/assets/sandwich.png",
                    "../../ressources/assets/betb.png", "food",
                    20),
            new Promotion("DeLonghi",
                    "Blender", "50 TND instead of 90 TND",
                    "../../ressources/assets/blender.jpg",
                    "../../ressources/assets/DeLonghi_logo.png", "home",
                    50),
            new Promotion("Pull&Bear",
                    "Pull", "20% Reduction",
                    "../../ressources/assets/pull.png",
                    "../../ressources/assets/petb.png",
                    "clothes",
                    30),
            new Promotion("Chanel",
                    "Parfume", "Saint-valentin offer",
                    "../../ressources/assets/parfume.jpg",
                    "../../ressources/assets/chanel.png", "parfum",
                    50)
    };

    @FXML
    private VBox promotionList;

    public ListController() {
    }

    @FXML
    void clothesFilter(ActionEvent event) {
        Promotion[] newList = Arrays.stream(this.list).filter(x -> x.getCategory().equals("clothes")).toArray(Promotion[]::new);
        this.updateList(newList);
    }

    @FXML
    void foodFilter(ActionEvent event) {
        Promotion[] newList = Arrays.stream(this.list).filter(x -> x.getCategory().equals("food")).toArray(Promotion[]::new);
        this.updateList(newList);
    }

    @FXML
    void homeFilter(ActionEvent event) {
        Promotion[] newList = Arrays.stream(this.list).filter(x -> x.getCategory().equals("home")).toArray(Promotion[]::new);
        this.updateList(newList);
    }

    @FXML
    void parfumFilter(ActionEvent event) {
        Promotion[] newList = Arrays.stream(this.list).filter(x -> x.getCategory().equals("parfum")).toArray(Promotion[]::new);
        this.updateList(newList);
    }


    void seeDetails(Promotion promotion) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../ressources/view/detailsScreen.fxml"));
            Parent root = fxmlLoader.load();
            DetailsController detailsController = (DetailsController) fxmlLoader.getController();
            detailsController.initializeView(promotion);
            Stage stage = new Stage();
            stage.setTitle("Details Screen");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateList(Promotion[] newList) {
        this.promotionList.getChildren().clear();
        for (Promotion el: newList) {
            HBox item = this.createItem(el);
            this.promotionList.getChildren().add(item);
        }
    }

    public void updateList() {
        this.promotionList.getChildren().clear();
        for (Promotion el: this.list) {
            HBox item = this.createItem(el);
            this.promotionList.getChildren().add(item);
        }
    }

    HBox createItem(Promotion promotion) {
        ImageView img = new ImageView(getClass().getResource(promotion.getImagePath()).toExternalForm());

        Text brand = new Text(promotion.getBrand());
        brand.setWrappingWidth(400);
        brand.setTextAlignment(TextAlignment.CENTER);
        brand.setStyle("-fx-font: 30 arial;");

        Text description = new Text(promotion.getDescription());
        description.setWrappingWidth(400);
        description.setTextAlignment(TextAlignment.CENTER);
        description.setStyle("-fx-font: 24 arial;");

        Text priceField = new Text(String.valueOf(promotion.getPrice()) + " TND");
        priceField.setWrappingWidth(400);
        priceField.setTextAlignment(TextAlignment.CENTER);
        priceField.setStyle("-fx-font: 33 arial;");

        VBox textPart = new VBox(brand, description, priceField);
        textPart.setPrefWidth(600);

        img.setFitHeight(150);
        img.setFitWidth(200);
        HBox root = new HBox(img, textPart);
        root.setOnMouseClicked((click) -> {
            this.seeDetails(promotion);
        });
        return root ;
    }

}
