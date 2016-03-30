<%@page import="java.io.FileOutputStream"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String fileStoreURL = "";
	
	
		fileStoreURL = config.getServletContext().getRealPath("") + "/uploads";
		try {
			File f = new File(fileStoreURL);
			if (!f.exists()) {
				f.mkdirs();
			}
		} catch (Exception e) {
	
		}
	
		try{
			HttpServletRequest req=(HttpServletRequest) pageContext.getRequest();  
			HttpServletResponse res=(HttpServletResponse) pageContext.getResponse();
			long time = new Date().getTime();
			
			FileOutputStream fileOutputStream = new FileOutputStream(
					fileStoreURL + "/"+time+".jpg");
			int r;
	
			while ((r = req.getInputStream().read()) != -1) {
				fileOutputStream.write(r);
				
			}
			fileOutputStream.close();
			
			res.getWriter().append(
					"http://localhost:8080/Veterinaria_LTFinalJueves03072014/uploads/" + time
							+ ".jpg");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	%>