package br.csi.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.usuario;
import br.csi.model.dao.usuarioDAO;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/servletController")//"s" minusculo
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		usuario u = new usuario();
		u.setLogin(login);
		u.setSenha(senha);
		
		usuarioDAO ud = new usuarioDAO();
		RequestDispatcher dispatcher;
		
		try {
			boolean retorno = ud.autenticado(u);
			if(retorno){
				String pagina = "/principal.jsp";// op pra esconder jsp "WEB-INF/jsp/principal.jsp";
				request.setAttribute("usuario", u);
				dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}else{
				String pagina = "/index.jsp";
				request.setAttribute("msg", "Login/Senha Inválidos");
				dispatcher = getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			String pagina = "/index.jsp";
			dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
		/*if{//teste do botao CADASTRAR
            String login = request.getParameter("login");//extrai informacao digitada no campo login
            String senha = request.getParameter("senha");//extrai informacao digitada no campo senha
            
            usuarioDAO udao = new usuarioDAO();//objeto usuarioDAO
            try{
                boolean autenticado = udao.cadastrarUsuario(login, senha);
                
                if(autenticado == true){
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");//manda request do botao ENTRAR para INDEX.JSP
                rd.forward(request, response);
                out.println("<script>alert('Usuário cadastrado com sucesso!');location='principal.jsp';</script>");
                }
                else{
                RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");//manda request do botao ENTRAR para ERRO.JSP
                rd.forward(request, response);
                System.out.println("Cadastro não realizado!!");
                }
            }catch(Exception e){
                e.printStackTrace();//MOSTRA NO LOG O ERRO
            }
        }*/
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
