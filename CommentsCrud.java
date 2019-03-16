package crud;

import java.util.List;
import java.util.Scanner;

import dao.CommentsDaoImpl;
import model.Comments;

public class CommentsCrud {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		CommentsDaoImpl dao = new CommentsDaoImpl();

		int doFlag = -1;
		do {
			System.out.println("1.Insert\n2.Delete\n3.View All Comments");
			int ch = scn.nextInt();
			scn.nextLine();
			switch (ch) {
			case 1:
				System.out.println("Enter Comments comment");
				Comments comments = new Comments(0, scn.nextLine());

				int res = dao.insert(comments);

				System.out.println("Rows inserted=" + res);

				break;

			case 2:
				System.out.println("Enter commentid of the Comments to be deleted");
				int commentid = scn.nextInt();
				scn.nextLine();
				res = dao.delete(commentid);
				System.out.println("Rows deleted=" + res);
				break;

			case 3:

				List<Comments> list = dao.view();

				for (Comments c : list) {
					System.out.println(c);
				}

				break;
		
			default:
				System.out.println("Invalid Input Choice");
			}

			System.out.println("RE RUN ? 1.YES\t2.NO");
			doFlag = scn.nextInt();
			scn.nextLine();

		} while (doFlag == 1);

	}
}
