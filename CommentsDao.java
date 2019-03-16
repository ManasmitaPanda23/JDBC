package dao;

import java.util.List;
import model.Comments;

public interface CommentsDao {

	int insert(Comments comments);

	int delete(int commentid);

	List<Comments> view();

	Comments view(int id);

}
