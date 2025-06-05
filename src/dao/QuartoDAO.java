package dao;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartoDAO {
    //Objeto para instanciar classe Conexao para requisiar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirQuarto() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoQuarto = condb.prepareStatement("INSERT INTO quartos"+
                    "(nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel) VALUES (?,?,?,?, ?,?);");
//                Setar os Parâmetros
            novoQuarto.setString(1, "Quarto Casal");
            novoQuarto.setString(2, "541");
            novoQuarto.setInt(4, 3);
            novoQuarto.setInt(3,0);
            novoQuarto.setDouble(5,299.90);
            novoQuarto.setBoolean(6,true);


            int linhaAfetada = novoQuarto.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Quarto: " + erro);
            return false;
        }
    }


}

