package model;

public class Comments {
	private int commentid;
	private String comment;

	public Comments() {

	}

	public Comments(int commentid, String comment) {
		this.commentid = commentid;
		this.comment = comment;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {

		return "Post [commentid=" + commentid + ", comment=" + comment + "]";
	}
}
