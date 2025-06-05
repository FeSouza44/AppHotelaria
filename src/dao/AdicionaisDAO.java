package dao;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Adicional: " + erro);
            return false;
        }
    }


}

