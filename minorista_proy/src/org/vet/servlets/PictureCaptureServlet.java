package org.vet.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PictureCaptureServlet
 */
public class PictureCaptureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fileStoreURL = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PictureCaptureServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("yaa");
		fileStoreURL = config.getServletContext().getRealPath("") + "/uploads";
		try {
			File f = new File(fileStoreURL);
			if (!f.exists()) {
				f.mkdirs();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			long time = new Date().getTime();
			
			FileOutputStream fileOutputStream = new FileOutputStream(
					fileStoreURL + "/"+time+".jpg");
			int res;
			while ((res = request.getInputStream().read()) != -1) {
				fileOutputStream.write(res);
			}
			fileOutputStream.close();
			/**
			 * To make sure each url is differeent and not cached added time to tit
			 */
			response.getWriter().append(
					"http://localhost:8080/uploads/" + time
							+ ".jpg");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
