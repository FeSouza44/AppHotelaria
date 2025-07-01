package controller;

import dao.UsuarioDAO;
import model.Usuarios;

public class UsuariosController {
private final UsuarioDAO usuarioDAO;
/*1Construtor para inicializar objeto UsuariosController()
Ao inicializa-lo, o construtor de UsuariosDAO() será executado,
o que significa que a camada de controle estará verificando se
os parâmetros necessários foram informados para que sejam enviados
enviados às requisições (package DAO- Data Access Object)*/

public UsuariosController() {
    this.usuarioDAO = new UsuarioDAO();
}
/*Metodo pra verificar se os parametros necessários para autenticação
estão presentes, ou seja não podem ser vazios ou nulos */
public boolean autenticarUsuario(String email, String senha) {
    if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
        return false;
    }
    Usuarios usuarios = new Usuarios("",email, senha, 0);
    return usuarioDAO.autenticarUsuario(usuarios);
}
}
