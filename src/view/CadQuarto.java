package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Quarto;
import view.components.PanelButtons;
import view.components.Sidebar;

public class CadQuarto extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Sidebar sidebar = new Sidebar();
        PanelButtons btns = new PanelButtons();


        Image IconUser = new Image(getClass().getResourceAsStream("/view/resources/img/UserBlack40px.png"));
        ImageView viewUser = new ImageView(IconUser);


        //criar uma barra lateral onde a sidebar ficara dentro
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(sidebar);
        //Label do título
        Label lblTitulo = new Label("Cadastro de Quartos", viewUser);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");

        HBox tituloBox = new HBox(lblTitulo);
        tituloBox.setAlignment(Pos.TOP_CENTER);

        Label lblNomeQuarto = new Label("Nome do Quarto: ");
        TextField txtNomeQuarto = new TextField();

        Label lblNumQuarto = new Label("Número do Quarto");
        TextField txtNumQuarto = criarMasc("###");

        Label lblQtdCamaCasal = new Label("Camas de Casal");
        Spinner<Integer> txtQtdCamaCasal = new Spinner<>(0, 5, 1);

        Label lblQtdCamaSolteiro = new Label("Camas de Solteiro");
        Spinner<Integer> txtQtdCamaSolteiro = new Spinner<>(0, 5, 1);

        Label lblDisponibilidade = new Label("Disponibilidade");
        ComboBox boxDisp = new ComboBox<>();
        boxDisp.getItems().addAll("Disponível","Indisponível");
        boxDisp.setPromptText("Selecione:");

        Label lblPreco = new Label("Preço");
        TextField txtPreco = criarMasc("R$"+"########");

        GridPane formGrid = new GridPane();
        formGrid.add(lblNomeQuarto, 0, 0);
        formGrid.add(txtNomeQuarto, 1, 0);

        formGrid.add(lblNumQuarto, 0, 1);
        formGrid.add(txtNumQuarto, 1, 1);

        formGrid.add(lblQtdCamaCasal, 0, 2);
        formGrid.add(txtQtdCamaCasal, 1, 2);

        formGrid.add(lblQtdCamaSolteiro, 0, 3);
        formGrid.add(txtQtdCamaSolteiro, 1, 3);

        formGrid.add(lblDisponibilidade, 0, 4);
        formGrid.add(boxDisp, 1, 4);

        formGrid.add(lblPreco, 0, 5);
        formGrid.add(txtPreco, 1, 5);

        formGrid.setHgap(10);
        formGrid.setVgap(10);



        VBox layout = new VBox(10, tituloBox, formGrid, btns);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 750, 600);
        stage.setTitle("Grand Hotel Royal");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    private TextField criarMasc(String mascara) {
        TextField txtMasc = new TextField();
        txtMasc.textProperty().addListener((observable, oldValue, newValue) -> {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    } else {
                        break;
                    }
                } else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMasc.setText(formatacaoCampo.toString());
        });
        return txtMasc;
    }
}
