package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberDTO;


public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("[UpdateService]");
		
		// post��� ���ڵ�
		request.setCharacterEncoding("UTF-8");
		// ������ ������ �޾ƿ���
		String m_pw = request.getParameter("pw");
		String m_name = request.getParameter("tel");
		
		System.out.println("pw : " + m_pw);
		System.out.println("name : " + m_name);
		
		// �α����� �̸����� �������� �����ϱ� ���� �α��� ���� ��������
		HttpSession session = request.getSession();
		MemberDTO info = (MemberDTO)session.getAttribute("info");
		String m_id = info.getM_id();
		
		// info ������ ���� �� ����� �����
		info = new MemberDTO(m_id, m_pw, m_name);
	
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(info);
		
		if(cnt>0) {
			System.out.println("���� �Ϸ�");
			session.setAttribute("info", info);
		}else {
			System.out.println("���� ����");
		}
		response.sendRedirect("main.html");
	}

}
