package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberDTO;


public class joinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[JoinService]");
		// 1. post��� ���ڵ�
		request.setCharacterEncoding("UTF-8");
		// 2. ������ ��������
		String m_id = request.getParameter("email");
		String m_pw = request.getParameter("pw");
		String m_name = request.getParameter("name");
		String m_birthDate = request.getParameter("tel");
		String m_gender = request.getParameter("address");
		String m_joinDate = request.getParameter("address");
		String m_admin_yesno = request.getParameter("address");
		
		// 2-2 ������ �� �����͸� dto�� ���
		MemberDTO dto = new MemberDTO(m_id, m_pw, m_name, m_birthDate, m_gender, m_joinDate, m_admin_yesno);
		
		// 2-1. �����͸� �� �����Դ��� consoleâ�� ����غ���
		System.out.println("id : "+ m_id);
		System.out.println("pw : " + m_pw);
		System.out.println("name : "+ m_name);
		System.out.println("birthDate : " + m_birthDate);
		System.out.println("gender : " + m_gender);
		System.out.println("joinDate : " + m_joinDate);
		System.out.println("admin : " + m_admin_yesno);
		
		// 3. DB�� �� �ֱ�
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(dto);
		if(cnt>=1) {
			System.out.println("ȸ������ ����");
			response.sendRedirect("join_success.jsp");
			// ���� ������ �Ѱ��ֱ� (email�� ������Ű��)
			HttpSession session = request.getSession();
			session.setAttribute("email", dto.getM_id());
		}else {
			System.out.println("ȸ������ ����");
			response.sendRedirect("main.jsp");
		}
	}

}
