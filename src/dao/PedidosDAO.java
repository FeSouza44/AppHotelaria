package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidosDAO {
    private Conexao conexao = new Conexao();

    public boolean removePedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removePedidos = condb.prepareStatement("DELETE FROM pedidos WHERE id = ?;");
            removePedidos.setInt(1, 1);

        } catch (SQLException e) {
            conexao.conectar();
            System.out.println("Erro ao adicionar pedidos" + e);
            return false;
        }
        return false;
    }
    public boolean addPedidos(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement addPedidos = condb.prepareStatement("INSERT INTO pedidos"+"(id_vendedor, id_cliente)");
            addPedidos.setInt(1,1);
            addPedidos.setInt(1,2);

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar pedidos" + e);
            return false;
        }
        return false;
    }
    public boolean alterarPedidos(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement altPedido = condb.prepareStatement("Update pedidos"+"SET id_vendedor = ?, id_cliente = ?");
            altPedido.setInt(1,1);
            altPedido.setInt(1,2);

            int linhaAfetada = altPedido.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception e) {
            System.out.println("Erro ao alterar pedidos" + e);
        }
        return false;
    }
}
