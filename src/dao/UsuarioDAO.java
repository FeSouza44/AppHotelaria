package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioDAO {
    //Objeto para instanciar classe Conexao para requisiar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoUsuario = condb.prepareStatement("INSERT INTO usuarios"+
                    "(nome, email, senha, cargo_id) VALUES (?,?, md5(?), ?);");
            //Setar os Parâmetros
            novoUsuario.setString(1, "Felipe");
            novoUsuario.setString(2,"feamaral.comercial@gmail.com");
            novoUsuario.setString(3, "123");
            novoUsuario.setInt(4, 1);
            
            int linhaAfetada = novoUsuario.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
}
