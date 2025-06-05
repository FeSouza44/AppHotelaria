package util;
/*Classe para testar a conexão do banco
 com as requisições; se os parametros como IP, nome de usuario,
senha e nome do banco de dados estão corretos, utilizando-se o
driver JDBC para MYSQL
*/


import dao.AdicionaisDAO;
import dao.ClienteDAO;
import dao.QuartoDAO;
import dao.UsuarioDAO;

import java.sql.Connection;

public class testeConexaoDb {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
//
                QuartoDAO quartoDAO = new QuartoDAO();
                quartoDAO.inserirQuarto();
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.inserirUsuario();
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.inserirCliente();
                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.inserirAdicionais();

                System.out.println("Inserido com sucesso!");
                condb.close();
                System.out.println("Conexão Encerrada");
            } catch(Exception e) {
                System.out.println("Erro ao Encerrar Banco de Dados: " + e.getMessage());
            }
        }else{
            System.out.println("Falha ao conectar ao Banco de Dados!");
        }
    }
}
