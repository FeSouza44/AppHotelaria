package dao;

import model.Usuarios;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
    public boolean deletarUsuario(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removeUsuario = condb.prepareStatement("DELETE FROM usuarios where id = ?;");
            removeUsuario.setInt(1,1);
            int linhaAfetada = removeUsuario.executeUpdate();;
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }


    }
    public boolean alterarUsuario(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement altUsuario = condb.prepareStatement("UPDATE usuarios"+"SET nome = ?, email = ?, senha = (md5)?, cargo id = ?");
            altUsuario.setString(1, "asdaa");
            altUsuario.setString(2,"asdasdad");
            altUsuario.setString(3,"sdasdasda");
            altUsuario.setInt(4, 1);

            int linhaAlterada  = altUsuario.executeUpdate();
            condb.close();
            return linhaAlterada > 0;
        } catch (Exception e) {
            System.out.println("Erro ao alterar usuario: " + e);
            return false;
        }
    }

    public void pesquisarUsuario(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscaUsuario = condb.prepareStatement("SELECT nome, email" + "FROM usuarios where cargo_id = ?");
            buscaUsuario.setInt(1,1);
            ResultSet resultSet =buscaUsuario.executeQuery();

            while (resultSet.next()){
                String nome = resultSet.getString("nome: ");
                String email = resultSet.getString("email: ");
                System.out.println("Nome: "+nome + "Email: " + email);
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
        }
    }
    public boolean autenticarUsuario(Usuarios usuario){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement stmtautenticarUsuario = condb.prepareStatement("SELECT nome from usuarios WHERE email = ? AND senha = ?");
            stmtautenticarUsuario.setString(1, usuario.getEmail());
            stmtautenticarUsuario.setString(2, usuario.getSenha());

            ResultSet resultado = stmtautenticarUsuario.executeQuery();
            boolean acessoAutorizado = resultado.next();

                String nome = resultado.getString("nome");

            System.out.println("Olá, seja bem vindo, " + nome);
            condb.close();
            return acessoAutorizado;

        } catch (Exception erro) {
            System.out.println("Erro ao autenticar usuario: " + erro);
        }
        return false;
    }
}
