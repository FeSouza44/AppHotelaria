package util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Conexao {
    private String driver = "com.mysql.cj.jdbc.Driver";
    //jdbc:mysql://localhost:3306/dbHotel
    private String url = "jdbc:mysql://127.0.0.1:3306/dbhotel";
    private String usuario = "dbaHotel";
    private String senha = "dbaHotel123";

    public Conexao(){
        carregarConfiguracoes();
    }
    private void carregarConfiguracoes(){
        Properties prop = new Properties();

        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream("config.properties")){
            prop.load(inputPropsConfig);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            usuario = prop.getProperty("usuario");
            senha = prop.getProperty("senha");
        }

        catch (IOException erro){
            System.out.println("Erro ao carregar configurações: " + erro.getMessage());

           }
    }

    public Connection conectar() {
        /*Objeto da conexao inicializa nulo pois não
        se sabe se o banco vai responder*/
        Connection condb = null;

        try {
            /*Especifica a rota do driver a ser carregado (JDBC para SGBD MySQL)*/
            Class.forName(driver);

            /*Inicializar o driver já carregado por meio do metodo getConnection(IP, porta, nome do banco, usuario, senha)*/
            condb = DriverManager.getConnection(url, usuario, senha);
            return condb;

        } catch (SQLException erro) {
            System.out.print("Erro ao conectar ao Banco de Dados " + erro);
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}