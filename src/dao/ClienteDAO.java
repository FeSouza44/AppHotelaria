package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
                return linhaAfetada > 0;
            } catch (Exception erro) {
                System.out.println("Erro ao inserir Cliente: " + erro);
                return false;
            }
        }


}
