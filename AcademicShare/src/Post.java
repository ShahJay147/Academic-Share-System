import java.util.*;
public class Post {
	int upvote,downvote;
	String content;
	ArrayList<Post>comment=new ArrayList<Post>();
	Account owner;
	
	public Post(Account owner,String content)
	{
		this.owner=owner;
		this.content=content;
		upvote=0;
		downvote=0;
	}
	
	public void addComment(Account comm, String cont)
	{
		this.comment.add(new Post(comm,cont));
		System.out.println("Comment has been Added.");
	}
	
	public void showComment()
	{
		for(int i=0;i<comment.size();i++)
		{
			System.out.println();
			System.out.println("Commentor Name: "+comment.get(i).owner.getUserName());
    		System.out.println(comment.get(i).content);
    		System.out.println();
		}
	}
}
