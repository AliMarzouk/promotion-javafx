package javacode.controllers;

import javacode.models.Promotion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailsController {

    @FXML
    private Text brand;

    @FXML
    private Text product;

    @FXML
    private Text description;

    @FXML
    private TextField qty;

    @FXML
    private Text priceToPay;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView img;

    @FXML
    private Text price;

    private Promotion promotion;

    @FXML
    void ConfirmBuy(MouseEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void confirm(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../ressources/view/paymentScreen.fxml"));
            Parent root = fxmlLoader.load();
            PaymentController paymentController = (PaymentController) fxmlLoader.getController();
            Stage stage = new Stage();
            stage.setTitle("Payment");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void numberClear(KeyEvent event) {

    }

    public void initializeView(Promotion promotion) {
        this.promotion = promotion;
        this.brand.setText(promotion.getBrand());
        this.product.setText(promotion.getProduct());
        this.description.setText(promotion.getDescription());
        this.price.setText(promotion.getPrice() + " TND");
        this.img.setImage(new Image(getClass().getResource(promotion.getImagePath()).toExternalForm()));
        this.logo.setImage(new Image(getClass().getResource(promotion.getLogoPath()).toExternalForm()));
        this.qty.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                qty.setText(newValue.replaceAll("[^\\d]", ""));
                newValue = newValue.replaceAll("[^\\d]", "");
            }
            System.out.println(newValue);
            float qty = Float.parseFloat(newValue.equals("") ? "0" : newValue);
            this.priceToPay.setText(qty * promotion.getPrice() + " TND");
        });
    }

}
