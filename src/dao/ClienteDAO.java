package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {
        //Objeto para instanciar classe Conexao para requisiar acesso ao DB
        private Conexao conexao = new Conexao();

        public boolean inserirCliente(){
            try {
                Connection condb = conexao.conectar();
                PreparedStatement novoCliente = condb.prepareStatement("INSERT INTO clientes"+
                        "(nome, cpf, telefone, email) VALUES (?,?,?,?);");
//                Setar os Parâmetros
                novoCliente.setString(1, "Felipe");
                novoCliente.setString(2, "54103259825");
                novoCliente.setString(3, "15 988250380");
                novoCliente.setString(4,"feamaral.comercial@gmail.com");

                int linhaAfetada = novoCliente.executeUpdate();
                condb.close();
                return linhaAfetada > 0;
            } catch (Exception erro) {
                System.out.println("Erro ao inserir Cliente: " + erro);
                return false;
            }
        }
        public boolean deleteCliente(){
            try {
                Connection condb = conexao.conectar();
                PreparedStatement removeCliente = condb.prepareStatement("DELETE from clientes WHERE ID = ?;");
                removeCliente.setInt(1, 1);
                int linhaAfetada = removeCliente.executeUpdate();
                condb.close();
                return linhaAfetada > 0;
            }catch (Exception erro) {
                System.out.println("Erro ao deletar Cliente: " + erro);
            }
            return false;
}
public boolean alterarCliente(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement altCliente = condb.prepareStatement("UPDATE clientes"+"SET nome = ?, cpf = ?, telefone = ?, email = ?");
            altCliente.setString(1, "Felipe");
            altCliente.setString(2,"123123131");
            altCliente.setString(3,"123125125");
            altCliente.setString(4,"@gmail.com");

            int linhaAfetada = altCliente.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception e) {
            System.out.println("Erro ao alterar Cliente: " + e);
            return false;
        }
}
    public void pesquisarCliente(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscaCliente = condb.prepareStatement("SELECT nome, email" + "FROM clientes where id = ?");
            buscaCliente.setInt(1,1);
            ResultSet resultSet =buscaCliente.executeQuery();

            while (resultSet.next()){
                String nome = resultSet.getString("nome: ");
                String email = resultSet.getString("email: ");
                System.out.println("Nome: "+nome + "Email: " + email);
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar cliente: " + erro);
        }
    }

}
