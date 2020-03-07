package main.java.com.softpager.estores.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageDispatcher {

	
	public static void showFrontEndMessage(String message,
							 HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		forwardToPage(ViewMapper.FRONTEND_MESSAGE, message, request, response);
	}
	
	public static void showBackEndMessage(String message,
								HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		forwardToPage(ViewMapper.BACKEND_MESSAGE, message, request, response);
	}

	public static void forwardToPage(String page,
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.getRequestDispatcher(page).forward(request, response);		
	}


	public static void forwardToPage(String page, String message,
									 HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("message", message);
		request.getRequestDispatcher(page).forward(request, response);
	}
}