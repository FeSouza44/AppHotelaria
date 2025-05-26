package view;
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

public class CadUsuario  extends Application {


    @Override
    public void start(Stage janela) throws Exception {
        Sidebar sidebar = new Sidebar();
        PanelButtons btns = new PanelButtons();
        //Carregar imagens
        Image ImgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/hotelLogo.png"));
        Image IconUser = new Image(getClass().getResourceAsStream("/view/resources/img/UserBlack40px.png"));
        ImageView viewIconUser = new ImageView(ImgIcon);

        //CRIAÇÃO DE UM CONTAINER PRINCIPAL (MAIN PANEL)
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(sidebar);


        //Parâmetros para definir como a imagem será visualizada

        ImageView viewUser = new ImageView(IconUser);
        viewUser.setFitWidth(20);
        viewUser.setFitHeight(20);
        //viewImgBtnCad.setOpacity(0.5); //Definição de opacidade: 0.0 (invisível) - 1.0 (opaco)

        //Título

        Label tituloBox = new Label("Login Usuário", viewUser);
        tituloBox.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox ttlBox = new HBox(tituloBox);
        ttlBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();

        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione:");

        Label lblSenha = new Label("Senha: ");
        TextField txtSenha = new TextField();

        Label lblSetor = new Label("Setor: ");
        TextField txtSetor = new TextField();
        ComboBox<String> boxSetor = new ComboBox<>();
        boxSetor.getItems().addAll("Administração","Gerência", "Recepção");
        boxSetor.setPromptText("Selecione:");

        GridPane formGrid = new GridPane();

        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);

        formGrid.add(lblEmail, 0, 1);
        formGrid.add(txtEmail, 1,1); //Esquerda Coluna
        formGrid.add(boxEmail, 2, 1);//Direita Linha

        formGrid.add(lblSenha, 0, 2);
        formGrid.add(txtSenha, 1, 2);

        formGrid.add(lblSetor, 0, 3);
        formGrid.add(txtSetor, 1, 3);
        formGrid.add(boxSetor, 2, 3);
        //antes(layout[vbox])--->mainPane
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        VBox layout = new VBox(10, ttlBox, formGrid, btns);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);
        Scene scene = new Scene(mainPane, 750, 600);
        janela.setTitle("Hotel Ibis");
        janela.getIcons().add(ImgIcon);
        janela.setScene(scene);
        janela.setResizable(false); //impede a janela de redimensionar
        janela.show();
    }
    public static void main(String[] args) {
    launch(args);
    }

}
