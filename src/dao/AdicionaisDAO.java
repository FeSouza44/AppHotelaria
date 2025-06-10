package dao;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdicionaisDAO {
    //Objeto para instanciar classe Conexao para requisiar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoAdicional = condb.prepareStatement("INSERT INTO adicionais"+
                    "(nome, preco) VALUES (?,?);");
//                Setar os Parâmetros
            novoAdicional.setString(1, "Banheira");
            novoAdicional.setDouble(2,149.90);



            int linhaAfetada = novoAdicional.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Adicional: " + erro);
            return false;
        }
    }
    public boolean deletarAdicionais() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removeAdicional = condb.prepareStatement("DELETE FROM adicionais WHERE ID = ?;");
            removeAdicional.setInt(1,1);

            int linhaAfetada = removeAdicional.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception e) {
            System.out.println("Erro ao deletar Adicional: " + e);
            return false;
        }
    }
    public boolean alterarAdicionais() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement alterarAdicionais = condb.prepareStatement("UPDATE adicionais" + "SET nome = ?, preco ? WHERE id =?");
            alterarAdicionais.setString(1,"Teste");
            alterarAdicionais.setDouble(2, 15.99);
        } catch (SQLException e) {
            System.out.println("Erro ao alterar Adicional: " + e);
        }
        return false;
    }


}

