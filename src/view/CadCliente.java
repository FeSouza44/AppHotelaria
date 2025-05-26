package view; //Package view (classes que, quando executadas, interagem com o usuário)

import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; //Classe VBox: é um dos tipos de layouts
import javafx.stage.Stage; //Classe Stage é a própria jaanela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.components.PanelButtons;
import view.components.Sidebar;

public class CadCliente extends Application {

    @Override
    public void start(Stage janela) throws Exception {
        Sidebar sidebar = new Sidebar();
        PanelButtons btns = new PanelButtons();
        //Carregar imagens
//        Image imgIcon = new Image(getClass().getResourceAsStream("/view/image/asd.png"));
        Image iconUser = new Image(getClass().getResourceAsStream("/view/resources/img/UserBlack40px.png"));

        //CRIAÇÃO DE UM CONTAINER PRINCIPAL (MAIN PANEL)
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(sidebar);


        //Parâmetros para definir como a imagem será visualizada

        ImageView viewUser = new ImageView(iconUser);
        viewUser.setFitWidth(20);
        viewUser.setFitHeight(20);

        //viewImgBtnCad.setOpacity(0.5); //Definição de opacidade: 0.0 (invisível) - 1.0 (opaco)

        //Título

        Label lblTitulo = new Label("Cadastro de Clientes: ", viewUser);
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");

        HBox tituloBox = new HBox(lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);
//        tituloBox.setPadding(new Insets(20,20,20,20));


        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();


        Label lblCPF = new Label("CPF: ");
        TextField txtCPF = criarMasc("###.###.###-##");


        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();

        Label lblTel = new Label("Telefone: ");
        TextField txtTel = criarMasc("(##)#####-####");

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione:");


        txtTel.setPrefWidth(10);

        GridPane formGrid = new GridPane();


        // Coluna Vertical || Coluna Horizontal
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);

        formGrid.add(lblCPF, 0, 1);
        formGrid.add(txtCPF, 1, 1);

        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(boxEmail, 3, 2);

        formGrid.add(lblTel, 0, 3);
        formGrid.add(txtTel, 1, 3);

        formGrid.setHgap(10);
        formGrid.setVgap(10);


        VBox layout = new VBox(10, tituloBox, formGrid, btns);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);//adicionada nova linha!

                           //antes(layout[vbox])--->mainPane
        Scene scene = new Scene(mainPane, 750, 600);
        janela.setTitle("Hotel Ibis");
        janela.getIcons().add(iconUser);
        janela.setScene(scene);
        janela.setResizable(false); //impede a janela de redimensionar
        janela.show();
    }
    //Metodo para criar máscara num campo de texto//

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
