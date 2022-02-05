package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDAO;

public class IdCheckService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// ajax�� ���� �ޱ� ������ UTF-8�� ���ڵ����ش�
		response.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		// join.jsp���� �޾ƿ� key���� userId�̰�
		// value���� ������ ������ ���� ��, String userId���� value���� ����.
		PrintWriter out = response.getWriter();

		MemberDAO dao = new MemberDAO();

		int idChcek = dao.checkId(userId);

		// �������� Ȯ�� : �����ڿ�
		if (idChcek == 0) {
			System.out.println("�̹� �����ϴ� ���̵��Դϴ�.");
		} else if (idChcek == 1) {
			System.out.println("��� ������ ���̵��Դϴ�.");
		}

		out.write(idChcek + ""); // --> ajax ������� result�� ��
		// --> String���� ���� ������ �� �ֵ��� + "" �� ���ش�
	}
}
