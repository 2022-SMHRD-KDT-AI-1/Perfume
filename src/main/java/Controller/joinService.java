package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDAO;
import Model.MemberDTO;

public class joinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date date = new Date();

		System.out.println("[JoinService]");
		// 1. post��� ���ڵ�
		request.setCharacterEncoding("UTF-8");
		// 2. ������ ��������
		String m_id = request.getParameter("id");
		String m_pw = request.getParameter("pw");
		String m_name = request.getParameter("name");
		String m_birthDate = request.getParameter("birthdate");
		String m_gender = request.getParameter("gender");

		// 2-2 ������ �� �����͸� dto�� ���
		MemberDTO dto = new MemberDTO(m_id, m_pw, m_name, m_birthDate, m_gender);

		// 2-1. �����͸� �� �����Դ��� consoleâ�� ����غ���
		System.out.println("id : " + m_id);
		System.out.println("pw : " + m_pw);
		System.out.println("name : " + m_name);
		System.out.println("birthDate : " + m_birthDate);
		System.out.println("gender : " + m_gender);

		// 3. DB�� �� �ֱ�
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(dto);
		if (cnt >= 1) {
			System.out.println("ȸ������ ����");
			response.sendRedirect("Main.jsp");
			// ���� ������ �Ѱ��ֱ� (email�� ������Ű��)
			// HttpSession session = request.getSession();
			// session.setAttribute("aaa", dto.getM_id());
		} else {
			System.out.println("ȸ������ ����");
			response.sendRedirect("Main.jsp");
		}
	}

}
