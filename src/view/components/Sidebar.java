package view.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Sidebar  extends VBox {
    public Button btnCliente = new Button("Cliente");
    public Button btnFuncionario = new Button("Funcionario");
    public Button btnQuarto = new Button("Quarto");
    public Button btnReserva = new Button("Reserva");
    public Button btnRelatorio = new Button("Relatorio");

    public Sidebar() {
    Image iconCliente = new Image(getClass().getResourceAsStream("/view/resources/img/icon-cliente.png"));;
    ImageView imageCliente = new ImageView(iconCliente);
    imageCliente.setFitHeight(20);//Altura
    imageCliente.setFitWidth(20);//Largura

    Image iconLogo = new Image(getClass().getResourceAsStream("/view/resources/img/hotelLogo.png"));
    ImageView imageLogo = new ImageView(iconLogo);

    imageLogo.setFitHeight(40);
    imageLogo.setFitWidth(40);

        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"+"DMSans-Regular.ttf"), 12);
        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"+"DMSans-Bold.ttf"), 9);

    Image iconFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/icon-funcionario.png"));
    ImageView imageFuncionario = new ImageView(iconFuncionario);
    imageFuncionario.setFitHeight(20);//Altura
    imageFuncionario.setFitWidth(20);//Largura


    Image iconQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/icon-quarto.png"));
    ImageView imageQuarto = new ImageView(iconQuarto);
    imageQuarto.setFitHeight(20); //Altura
    imageQuarto.setFitWidth(20);//Largura


    Image iconRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/icon-relatorio.png"));
    ImageView imageRelatorio = new ImageView(iconRelatorio);
    imageRelatorio.setFitHeight(20);//Altura
    imageRelatorio.setFitWidth(20);//Largura


    Image iconReserva = new Image(getClass().getResourceAsStream("/view/resources/img/icon-reserva.png"));
    ImageView imageReserva = new ImageView(iconReserva);
    imageReserva.setFitHeight(20);//Altura
    imageReserva.setFitWidth(20);//Largura


    Label lblMenu = new Label("Grand Hotel Royal");

   lblMenu.setFont(Font.font(fontNegrito.getFamily(), 25));


        btnCliente.setGraphic(imageCliente);
        btnReserva.setGraphic(imageReserva);
        btnFuncionario.setGraphic(imageFuncionario);
        btnQuarto.setGraphic(imageQuarto);
        btnRelatorio.setGraphic(imageRelatorio);

        String styleButton = "-fx-background-color: transparent;"+"-fx-border-color: transparent;"+"-fx-graphic-text-gap: 10px;";
        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);
        btnReserva.setStyle(styleButton);

        btnFuncionario.setOnMouseEntered(mouseEvent -> btnFuncionario.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnFuncionario.setOnMouseExited(mouseEvent -> btnFuncionario.setStyle(styleButton));

        btnCliente.setOnMouseEntered(mouseEvent -> btnCliente.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnCliente.setOnMouseExited(mouseEvent -> btnCliente.setStyle(styleButton));

        btnQuarto.setOnMouseEntered(mouseEvent -> btnQuarto.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnQuarto.setOnMouseExited(mouseEvent -> btnQuarto.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(mouseEvent -> btnRelatorio.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnRelatorio.setOnMouseExited(mouseEvent -> btnRelatorio.setStyle(styleButton));

        btnReserva.setOnMouseEntered(mouseEvent -> btnReserva.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnReserva.setOnMouseExited(mouseEvent -> btnReserva.setStyle(styleButton));


        setStyle("-fx-background-color: #ffffff");
        setMargin(lblMenu, new Insets(0, 0, 20, 0));
        setSpacing(12);
    getChildren().addAll(lblMenu, btnFuncionario, btnCliente, btnQuarto, btnRelatorio, btnReserva);
    }

}
