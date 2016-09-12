package sl.boardroom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sl.boardroom.dao.DestineInfoDao;
import sl.boardroom.entity.DestineInfoEntity;
import sl.boardroom.impl.DestineInfoImpl;

public class DestineServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DestineServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		DestineInfoDao dd = new DestineInfoImpl();		
		
		if (action.equals("select")) {
			List<DestineInfoEntity> list = new ArrayList<DestineInfoEntity>();
			list = dd.getAllInfoOrderByTime();
			request.getSession().setAttribute("dlist", list);
			response.sendRedirect("index.jsp");
		} else if (action.equals("add")) {
			String room_name = request.getParameter("room_name");
			String destine_name =request.getParameter("destine_name");
			String destine_time1 = request.getParameter("destine_time");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = (Date) sdf.parse(destine_time1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			java.sql.Date date2=new java.sql.Date(date.getTime());
						
			DestineInfoEntity de = new DestineInfoEntity();
			de.setDestine_name(destine_name);
			de.setDestine_time(date2);
			de.setRoom_name(room_name);				
			int result = dd.addInfo(de);
			if (result == 1) {
				out.print("<script>alert('预定成功!');location='DestineServlet?action=select'</script>");
			} else {
				out.print("<script>alert('预定失败!');location='addInfo.jsp'</script>");
			}
			
		}
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
