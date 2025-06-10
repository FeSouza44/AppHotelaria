package dao;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Quarto: " + erro);
            return false;
        }
    } public boolean removeQuarto() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removeQuarto = condb.prepareStatement("DELETE from quartos WHERE id = ?;");
            removeQuarto.setInt(1,1);
            int linhaAfetada = removeQuarto.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception e) {
            System.out.println("Erro ao deletar Quarto: " + e);
            return false;
        }
    }
    public boolean alterarQuarto() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement altQuartos = condb.prepareStatement("UPDATE quartos"+"SET nome = ?, numero = ?, qtd_cama_casal = ?, qtd_cama_solteiro = ?, preco, disponivel = ? ");
        altQuartos.setString(1,"Quarto Teste");
        altQuartos.setString(2,"1902");
        altQuartos.setInt(3,1);
        altQuartos.setInt(4,2);
        altQuartos.setDouble(5, 750.99);
        altQuartos.setBoolean(6, true);

        int linhaAfetada = altQuartos.executeUpdate();
        condb.close();
        return linhaAfetada > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao alterar Quarto: " + e);
        }
        return false;
    }


}

