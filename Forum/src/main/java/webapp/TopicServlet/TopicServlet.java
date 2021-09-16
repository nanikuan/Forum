package webapp.TopicServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class topic
 */
@WebServlet("/topic")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String jdbcURL = "jdbc:mysql://localhost:3306/forum";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private static final String INSERT_TOPIC_SQL = "INSERT INTO topic" + " (name, content, number, date) VALUES "
			+ " (?, ?, ?,?);";
	private static final String SELECT_ALL_TOPIC = "Select * from topic";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopicServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();
		System.out.println("action is " + action);
		try {
			switch (action) {
			case "/TopicServlet/update":
				updateTopic(request, response);
				break;

			default:
				listTopic(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

	private void listTopic(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<topic> topics = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TOPIC);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String content = rs.getString("content");
				String number = rs.getString("number");
				String date = rs.getString("date");
				topics.add(new topic(name, content, number, date));
				System.out.println(name);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		// List < User > listTopic = databaseOperations.selectAllUsers();
		request.setAttribute("listTopic", topics);
		RequestDispatcher dispatcher = request.getRequestDispatcher("topics.jsp");
		dispatcher.forward(request, response);
	}

	// method to get parameter, query database for existing user data and redirect
	// to user edit page

	// method to update the user data
	private void updateTopic(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		System.out.println("comes to updateUser");
		// get values from the request
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String number = request.getParameter("number");
		String date = request.getParameter("date");
		System.out.println(name);
		System.out.println(content);
		System.out.println(number);
		System.out.println(date);
		// database operation
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_TOPIC_SQL);) {
			statement.setString(1, name);
			statement.setString(2, content);
			statement.setString(3, number);
			statement.setString(4, date);
			int i = statement.executeUpdate();
		}
		// redirect us back to UserServlet !note: do change the url to your project name
		response.sendRedirect("http://localhost:8081/Forum/TopicServlet");
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
