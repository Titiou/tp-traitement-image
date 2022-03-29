package ch.hearc.image_processing;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.hearc.image_processing.helpers.DB;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// load title of drawings
		try {
			String sId = "id";
			String sTitle = "titre";
			String sImage = "image";
			
			ResultSet qs = DB.getInstance().executeQuery(String.format("SELECT %s, %s, %s FROM peintures", sId, sTitle, sImage));
			
			List<Integer> ids = new ArrayList();
			List<String> titles = new ArrayList();
			List<String> images = new ArrayList();

			while(qs.next())
			{
				ids.add(qs.getInt(sId));
				titles.add(qs.getString(sTitle));
				images.add(qs.getString(sImage));
			}

			request.setAttribute(sId, ids);
			request.setAttribute(sTitle, titles);
			request.setAttribute(sImage, images);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}
}
