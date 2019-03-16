package dao;

import java.util.List;
import model.Posts;

public interface PostsDao {

	int insert(Posts posts);

	int update(Posts posts);

	int delete(int id);

	List<Posts> view();

	Posts view(int id);

}
