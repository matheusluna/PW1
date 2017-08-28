package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.Dao;
import controle.DaoBanco;
import entidades.Pessoa;
import excecoes.EmailException;
import excecoes.NomeException;
import excecoes.SenhaException;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
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
		Dao banco = new DaoBanco();
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Pessoa pessoa = null;
		try {
			pessoa = banco.read(email);
			if(pessoa.getSenha().equals(senha)) {
				request.setAttribute("nome", pessoa.getNome());
				request.getRequestDispatcher("/principal.jsp").forward(request, response);
			}else {
				response.sendRedirect("index.html");
			}
		} catch (NullPointerException | ClassNotFoundException | SQLException | EmailException | SenhaException | NomeException e) {
			// TODO Auto-generated catch block
			request.setAttribute("erro", e.getMessage());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
