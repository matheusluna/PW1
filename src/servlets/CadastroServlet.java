package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Dao cadastro = new DaoBanco();
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String sexo = request.getParameter("sexo");
		LocalDate nascimento = LocalDate.parse(request.getParameter("nascimento"), formatter);
		String cidade = request.getParameter("cidade");
		String profissao = request.getParameter("profissao");
		String foto = request.getParameter("foto");
		String senha = request.getParameter("senha");
		
		try {
			Pessoa pessoa = new Pessoa(email, nome, cidade, sexo, senha, foto, profissao, nascimento);
			if(cadastro.create(pessoa)) {
				response.sendRedirect("index.html");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SenhaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NomeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
