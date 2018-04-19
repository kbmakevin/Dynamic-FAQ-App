package com.faq.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.faq.app.dao.DatabaseOperations;
import com.faq.app.model.Faq;

/**
 * Servlet implementation class Faqs
 */
@WebServlet("/Faqs")
public class Faqs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Faq> faqQueryResults = DatabaseOperations.getAllFaqRecords();
		System.out.println("Found faqs: " + faqQueryResults);

		// when a user has made a post request to /Faqs, then they have queried the
		// db...otherwise they simply visited page, no queries executed yet (show diff
		// view on page)
		HttpSession session = request.getSession();

		// if (request.getAttribute("userQueriedDb") == null) {
		request.setAttribute("userQueriedDb", true);
		// }
		request.setAttribute("queriedTopicName", request.getParameter("topicName"));
		request.setAttribute("matchingFaqs", faqQueryResults);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
