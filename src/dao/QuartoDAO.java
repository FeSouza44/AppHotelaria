package dao;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public void pesquisarQuarto(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscaQuarto = condb.prepareStatement("SELECT *" + "FROM quartos where id = ?");
            buscaQuarto.setInt(1,1);
            ResultSet resultSet = buscaQuarto.executeQuery();

            while (resultSet.next()){
                String nome = resultSet.getString("nome: ");
                String num = resultSet.getString("número: ");
                String camasCasal = resultSet.getString("Camas Casal: ");
                String camasSolt = resultSet.getString("Camas Solteiro: ");
                String preco = resultSet.getString("Preco: ");
                String disponivel = resultSet.getString("Disponivel: ");
                System.out.println("Nome: "+nome + "Número: " + num + "Camas Casal: " + camasCasal+ "Camas Solteiro"+camasSolt + "Preco: " + preco + "Disponivel: " + disponivel );
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar quarto: " + erro);
        }
    }

}

