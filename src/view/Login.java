package view;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;


public class Login extends Application {
    @Override
    public void start(Stage janela) throws Exception {

        Image fotoLogin = new Image(getClass().getResourceAsStream("/view/resources/img/fotoHotel.jpg"));
        ImageView fotoHotel = new ImageView(fotoLogin);

        Image zoioFechado = new Image(getClass().getResourceAsStream("/view/resources/img/zoiofechadi.png"));
        ImageView zoioFechadi = new ImageView(zoioFechado);
        zoioFechadi.setFitHeight(15);
        zoioFechadi.setFitWidth(15);


        Image olhoAbredo = new Image(getClass().getResourceAsStream("/view/resources/img/zoio.png"));
        ImageView olhoAbrido = new ImageView(olhoAbredo);
        olhoAbrido.setFitHeight(15);
        olhoAbrido.setFitWidth(15);

        fotoHotel.setFitHeight(350);
        fotoHotel.setFitWidth(250);

        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"+"DMSans-Bold.ttf"), 9);

        Label lblLogin = new Label("Faça seu login");
        lblLogin.setFont(fontNegrito);
        lblLogin.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

//        lblLogin.setStyle("-fx-font-family: sans-serif; --body-font-size: 28px");
        lblLogin.setAlignment(Pos.TOP_CENTER);

        TextField txtLogin = new TextField();
        txtLogin.setPromptText("Login");

        olhoAbrido.setCursor(Cursor.HAND);

        PasswordField passSenha = new PasswordField();
        passSenha.setPromptText("Senha");

        Button toggleButton = new Button();
        toggleButton.setGraphic((zoioFechadi));

        TextField txtsenha = new TextField();
        txtsenha.setPromptText("Digite sua Senha");
        txtsenha.setVisible(false);
        txtsenha.setManaged(false);

        boolean senhaVisivel = passSenha.isVisible();
        toggleButton.setOnMouseClicked(event -> {
        if (senhaVisivel) {
            String senhaDigitada = passSenha.getText();
            passSenha.setText(senhaDigitada);
            passSenha.setVisible(true);
            passSenha.setManaged(true);

            //OCULTA
            txtsenha.setVisible(false);
            txtsenha.setManaged(false);

            //troca o icone do botao
            toggleButton.setGraphic((zoioFechadi));

        }else{//se a senha está visivel, ou seja verificarSenha = true
            txtsenha.setText(passSenha.getText());

            txtsenha.setVisible(true);
            passSenha.setManaged(false);

            passSenha.setVisible(false);
            passSenha.setManaged(false);
            toggleButton.setGraphic((zoioFechadi));


        }});


        Button btnLogin = new Button("Login");
        String styleButton = "-fx-background-color: transparent;"+"-fx-border-color: transparent;"+"-fx-graphic-text-gap: 10px; ";
        btnLogin.setStyle(styleButton);


        GridPane formGrid = new GridPane();

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(formGrid);
        borderPane.setLeft(fotoHotel);

        lblLogin.setAlignment(Pos.CENTER);
        formGrid.setAlignment(Pos.CENTER);

        btnLogin.setStyle(styleButton);
        btnLogin.setOnMouseEntered(mouseEvent -> btnLogin.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnLogin.setOnMouseExited(mouseEvent -> btnLogin.setStyle(styleButton));

        btnLogin.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(lblLogin,formGrid, btnLogin);
        HBox senhaBox = new HBox(txtsenha, passSenha, toggleButton);
        senhaBox.setAlignment(Pos.CENTER_LEFT);
        HBox hBox = new HBox(15,fotoHotel,vBox,senhaBox);


        formGrid.add(txtLogin, 0, 0);
        formGrid.add(passSenha, 0, 1);
        formGrid.add(toggleButton, 1, 1);
        formGrid.add(btnLogin, 0, 2);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hBox, 450, 300);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
