package crud;

import java.util.List;

import java.util.Scanner;

import dao.PostDaoImpl;
import model.Posts;

public class PostsCrud {
	public static void main(String[] args) {

		PostDaoImpl dao = new PostDaoImpl();

		Scanner scn = new Scanner(System.in);

		int doFlag = -1;

		do {
			System.out.println("1.Insert\n2.Update\n3.Delete\n4.View All Posts\n5.Search a Post");
			int ch = scn.nextInt();
			scn.nextLine();
			switch (ch) {
			case 1:

				System.out.println("Enter Posts title and body");
				Posts posts = new Posts(0, scn.nextLine(), scn.nextLine());

				int res = dao.insert(posts);

				System.out.println("Rows inserted=" + res);

				break;

			case 2:
				System.out.println("Enter id of the Posts to be updated");
				int id = scn.nextInt();
				scn.nextLine();
				System.out.println("Enter new title and body of the Posts to be updated");

				res = dao.update(new Posts(id, scn.nextLine(), scn.nextLine()));

				System.out.println("Rows updated=" + res);
				break;

			case 3:
				System.out.println("Enter id of the Posts to be deleted");
				id = scn.nextInt();
				scn.nextLine();
				res = dao.delete(id);
				System.out.println("Rows deleted=" + res);
				break;

			case 4:

				List<Posts> list = dao.view();

				for (Posts p : list) {
					System.out.println(p);
				}

				break;

			case 5:
				System.out.println("Enter id of the Posts to be searched");
				id = scn.nextInt();
				scn.nextLine();
				posts = dao.view(id);
				System.out.println(posts);
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
