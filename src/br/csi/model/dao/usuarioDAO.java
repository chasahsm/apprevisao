package br.csi.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.csi.model.usuario;
import br.csi.model.util.conectaBD;

public class usuarioDAO {
	
	public static void main(String args[]){
		usuario u = new usuario();
		u.setLogin("");
		u.setSenha("");
		
		try {
			
			System.out.println("Autenticado com Sucesso!!" + ""+new usuarioDAO().autenticado(u));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean autenticado(usuario u) throws SQLException{
		boolean autenticado = false;
		
		Connection c = conectaBD.getConexao();
		//Statement stmt = c.createStatement();
		//String sql = "select * from usuario where login = '"+u.getLogin()+"' and senha = '"+u.getSenha()+"';";
		//ResultSet rs = stmt.executeQuery(sql);//retorna valor
		
		String sql = "select * from usuario where login=? and senha=?";// p/impedir sql injection
		PreparedStatement stmtPre = c.prepareStatement(sql);
		stmtPre.setString(1, u.getLogin());
		stmtPre.setString(2, u.getSenha());
		ResultSet rs= stmtPre.executeQuery();
		
		while(rs.next()){
			long id = rs.getLong("id");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			autenticado = true;
		}
		
		return autenticado;
	}
	/*public boolean cadastrarUsuario(String l, String s) throws Exception{
        conectaBD bd = new conectaBD();
        Statement stmt = bd.getConexao().createStatement();//COMO SE FOSSE A TELA DO PGADMIN
        
        int retorno  = stmt.executeUpdate("INSERT INTO USUARIO (LOGIN, SENHA) VALUES ('" + l + "','"+ s +"')");
        if(retorno > 0){
            return true;
        }
        else{
            return false;
        }
    }*/
}
