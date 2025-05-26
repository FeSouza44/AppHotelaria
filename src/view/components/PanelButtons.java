package view.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PanelButtons extends HBox{
public PanelButtons() {
    Image iconCadastrar = new Image(getClass().getResourceAsStream("/view/resources/img/plus48px.png"));
    Image iconAtualizar = new Image(getClass().getResourceAsStream("/view/resources/img/update48px.png"));
    Image iconExcluir = new Image(getClass().getResourceAsStream("/view/resources/img/delete48px.png"));

    //Parâmetros para definir como a imagem será visualizada

    ImageView imageCadastrar = new ImageView(iconCadastrar);
    imageCadastrar.setFitHeight(20);
    imageCadastrar.setFitWidth(20);

    ImageView imageAtualizar = new ImageView(iconAtualizar);
    imageAtualizar.setFitHeight(20);
    imageAtualizar.setFitWidth(20);

    ImageView imageExcluir = new ImageView(iconExcluir);
    imageExcluir.setFitHeight(20);
    imageExcluir.setFitWidth(20);

    Button btnCadastrar= new Button("Cadastrar");
    Button btnAtualizar= new Button("Atualizar");
    Button btnExcluir= new Button("Excluir");

    btnCadastrar.setGraphic(imageCadastrar);
    btnAtualizar.setGraphic(imageAtualizar);
    btnExcluir.setGraphic(imageExcluir);



    //Estilização do Botão
    btnCadastrar.setStyle("-fx-background-color: transparent;");
    btnAtualizar.setStyle("-fx-background-color: transparent;");
    btnExcluir.setStyle("-fx-background-color: transparent;");


    setAlignment(Pos.CENTER);
    setSpacing(10);


    getChildren().addAll(btnCadastrar, btnAtualizar, btnExcluir);
}
}
