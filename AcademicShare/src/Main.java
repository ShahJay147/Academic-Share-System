import java.util.*;
import java.io.*;

public class Main {

    //protected static UserDatabase db = new UserDatabase();
    protected static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        HashMap<String,Account> acc=new HashMap<String,Account>();
        ArrayList<Material> mat=new ArrayList<Material>();
        ArrayList<Post>Discussion=new ArrayList<Post>();
        while(true){
	        Account curr = null;
	        while (true) {
	
	            System.out.println("------------------------------------");
	            System.out.println("1) Signup");
	            System.out.println("2) Login");
	            System.out.println("3) Forgot Password");
	            System.out.println("------------------------------------");
	
	            String choice = sc.nextLine();
	            int flag=0;
	            switch (choice) {
	            case "1":
	            	System.out.println("Please fill the following fields to create an account.");
	            	System.out.println("------------------------------------");
	            	String s[] = new String[8];
	            	System.out.print("Username : ");
	                s[0] = sc.nextLine();
	                if(!acc.containsKey(s[0])){
	                System.out.print("Name : ");
	                s[1] = sc.nextLine();
	                System.out.print("Email : ");
	                s[2] = sc.nextLine();
	                System.out.print("Address : ");
	                s[3] = sc.nextLine();
	                System.out.print("Date of Birth(DOB) : ");
	                s[4] = sc.nextLine();
	                System.out.print("Contact Number : ");
	                s[5] = sc.nextLine();
	                System.out.print("Password : ");
	                s[6] = sc.nextLine();
	                System.out.print("Re-enter your password for verification : ");
	                s[7] = sc.nextLine();

		                if(s[6].endsWith(s[7]))
		                {
		                    Account na=new Account(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);
		                    acc.put(s[0],na);
		                    System.out.println("Boooom. Account Created.");
		                }
		                else
		                {
		                	System.out.println("password and repeated password is not same.");
		                }
		                break;
	                }
	                System.out.println("username already exists.");
	                break;
	            case "2":
	                System.out.print("Enter Username: ");
	                String un = sc.nextLine();
	                if(!acc.containsKey(un))
	                {
	                	System.out.println("Username not found!!!");
	                	break;
	                }
	                if(acc.containsKey(un));
	                {
		                System.out.print("Enter Password: ");
		                String pwd = sc.nextLine();
		                Account temp=acc.get(un);
		                if(temp.getPassword().equals(pwd))
		                {
		                	System.out.println("Account Found :) :) :)");
		                	curr=temp;
		                	flag=2;
		                }
		                else
		                {
		                	System.out.println("Password is not match with username.");
		                }
		                break;
	                }
				case "3":
	                System.out.print("Enter Username: ");
	                String uni=sc.nextLine();
	                System.out.println();
	                if(acc.containsKey(uni)){
		                System.out.print("Enter Date of Birth :");
		                String dob=sc.nextLine();
		                System.out.println();
		                Account temp=acc.get(uni);
		                if(temp.getDOB().equals(dob))
		                {
		                	System.out.print("Enter Password: ");
		                	String pass=sc.nextLine();
		                	System.out.println();
		                	System.out.print("Enter Password Again: ");
		                	String rpass=sc.nextLine();
		                	System.out.println();
		                	if(pass.equals(rpass))
		                	{
		                		temp.setPassword(pass);
		                	}
		                	else
		                	{
		                		System.out.println("Both Password should be same.");
		                		break;
		                	}
		                	acc.put(uni,temp);
		                	temp=acc.get(uni);
		                	System.out.println("Password has changed.");
		                }
		                else
		                {
		                	System.out.println("Wrong Date of Birth.");
		                }
	                }
	                else
	                	System.out.println("No username found!!!");
	               	break;
	            default:
	                System.out.println("Provide valid input");
	            }
	            System.out.println();
	            if(flag==2)
	                break;
	        }
	        while(true)
	        {
	        	if(curr.Notification.size()>0)
	        	{
	        		System.out.println("You have some notification. like to see? (y/n)");
	        		String ans=sc.nextLine();
	        		if(ans.equals("y"))
	        		{
	        			curr.showNoti();
	        		}
	        	}
	        	
	        	System.out.println("------------------------------------");
	            System.out.println("1) Search material");
	            System.out.println("2) Add material");
	            System.out.println("3) Show my Material.");
	            System.out.println("4) Delete Material.");
	            System.out.println("5) Show my WishList.");
	            System.out.println("6) Remove from WishList.");
	            System.out.println("7) Show Discussion.");
	            System.out.println("8) Add Post.");
	            System.out.println("9) Show Notification.");
	            System.out.println("10) Logout");
	            System.out.println("------------------------------------");
	            System.out.println();
	            int flag=0;
	            String choice = sc.nextLine();
	            switch(choice)
	            {
	                case "2":
	                    System.out.println("Add material :");
	                    System.out.println("Add product information to register your product.");
	                    System.out.println("------------------------------------");
	                    String m[] = new String[5];
	                    System.out.println("Enter material name, no. of pages, type, (h/s)for hardcopy/softcopy, price");
	                    System.out.print("Material name: ");
		                m[0] = sc.nextLine();
		                System.out.print("No. of Pages: ");
		                m[1] = sc.nextLine();
		                System.out.print("Material Type: ");
		                m[2] = sc.nextLine();
		                System.out.print("Hardcopy/SoftCopy(h/s): ");
		                m[3] = sc.nextLine();
		                System.out.print("Price: ");
		                m[4] = sc.nextLine();
	                    Material nm=new Material(curr,m[0],Integer.parseInt(m[1]),m[2],m[3],Double.parseDouble(m[4]));
	                    mat.add(nm);
	                    System.out.println("Material Added :");
	                    System.out.println();
	                    Iterator it=acc.entrySet().iterator();
	                    while(it.hasNext())
	                    {
	                    	Map.Entry pair = (Map.Entry)it.next();
	                    	if(acc.get(pair.getKey()).Wishlist.contains(m[0]))
	                    		acc.get(pair.getKey()).Notification.add(m[0]+" has been arrived.");
	                    }
	                    break;
	                case "1":
	                    System.out.println("Search Material :");
	                    System.out.print("Enter material name");
	                    String name=sc.nextLine();
	                    System.out.println();
	                    int f1=0;
	                    for(int i=0;i<mat.size();i++)
	                    {
	                        if(mat.get(i).name.endsWith(name))
	                        {
	                        	System.out.println();
	                        	System.out.println("Material Owner: "+mat.get(i).owner.getName());
	                            System.out.println("Material Name: "+mat.get(i).name);
	                            System.out.println("Number of Pages: "+mat.get(i).numOfPages);
	                            System.out.println("Material Type (i.e. pdf, book, etc.): "+mat.get(i).type);
	                            String ch = "Hardcopy"; 
	                            if(mat.get(i).ch == "s")
	                                ch = "Softcopy";
	                            System.out.println("HardCopy/SoftCopy: "+ch);
	                            System.out.println("Material Price: "+mat.get(i).price);
	                            System.out.println();
	                            System.out.println();
	                            System.out.println("Do you want to buy material ? (y/n)");
	                            String ans=sc.nextLine();
	                            if(ans.equals("y"))
	                            	mat.get(i).owner.Notification.add(curr.getName()+" wants to buy "+mat.get(i).name+" .");
	                            f1=1;
	                        }
	                    }
	                    if(f1==0)
	                    {
	                    	System.out.println();
	                    	System.out.println("Material not found.");
	                    	System.out.println("would you like to add Material in Wishlist? (y/n) ");
	                    	String nans=sc.nextLine();
	                    	if(nans.equals("y"))
	                    	{
	                    		curr.addtoWishList(name);
	                    		System.out.println();
	                    		System.out.println("Material has been added to WishList.");
	                    	}
	                    }
	                    System.out.println();
	                    break;
	                case "3":
	                    for(int i=0;i<mat.size();i++)
	                    {
	                    	if(mat.get(i).owner.getUserName().equals(curr.getUserName()))
	                    	{
	                    		System.out.println();
	                    		System.out.println("Material Owner: "+mat.get(i).owner.getName());
	                            System.out.println("Material Name: "+mat.get(i).name);
	                            System.out.println("Number of Pages: "+mat.get(i).numOfPages);
	                            System.out.println("Material Type (i.e. pdf, book, etc.): "+mat.get(i).type);
	                            String ch = "Hardcopy"; 
	                            if(mat.get(i).ch == "s")
	                                ch = "Softcopy";
	                            System.out.println("HardCopy/SoftCopy: "+ch);
	                            System.out.println("Material Price: "+mat.get(i).price);
	                            System.out.println();
	                    	}
	                    }
	                    System.out.println();
	                    break;
	                case "4":
	                	System.out.print("Enter material name");
	                	name=sc.nextLine();
	                	System.out.println();
	                	for(int i=0;i<mat.size();i++)
	                	{
	                    	if(mat.get(i).owner.getUserName().equals(curr.getUserName()) && mat.get(i).name.endsWith(name))
	                    	{
	                    		System.out.println();
	                    		System.out.println("Material Owner: "+mat.get(i).owner.getName());
	                            System.out.println("Material Name: "+mat.get(i).name);
	                            System.out.println("Number of Pages: "+mat.get(i).numOfPages);
	                            System.out.println("Material Type (i.e. pdf, book, etc.): "+mat.get(i).type);
	                            String ch = "Hardcopy"; 
	                            if(mat.get(i).ch == "s")
	                                ch = "Softcopy";
	                            System.out.println("HardCopy/SoftCopy: "+ch);
	                            System.out.println("Material Price: "+mat.get(i).price);
	                            System.out.println();
	                            System.out.print("Do you want to remove this material? (y/n)");
	                            String nexta=sc.nextLine();
	                            System.out.println();
	                            if(nexta.equals("y"))
	                            {
	                            	mat.remove(i);
	                            	System.out.println("material has been removed.");
	                            }
	                    	}
	                    }
	                	break;
	                case "5":
	                	Iterator it1=curr.Wishlist.iterator();
	                	int count=0;
	                	System.out.println();
	                	while(it1.hasNext())
	                	{
	                		count++;
	                		System.out.println(count+") "+it1.next());
	                	}
	                	break;
	                case "6":
	                	System.out.print("Enter Material Name: ");
	                	String s1=sc.nextLine();
	                	System.out.println();
	                	curr.removefromWishList(s1);
	                	break;
	                case "7":
	                	for(int i=0;i<Discussion.size();i++)
	                	{
	                		System.out.println("Writer Name: "+Discussion.get(i).owner.getUserName());
	                		System.out.println(Discussion.get(i).content);
	                		System.out.println("^"+(Discussion.get(i).upvote-Discussion.get(i).downvote));
	                		System.out.println();
	                		
	                		System.out.print("Would you like to see comments ? (y/n)");
	                		String ans=sc.nextLine();
	                		System.out.println();
	                		if(ans.equals("y"))
	                			Discussion.get(i).showComment();
	                		System.out.println();
	                		
	                		System.out.print("Would you like to upvote/downvote Post ? (u/d/n)");
	                		ans=sc.nextLine();
	                		System.out.println();
	                		if(ans.equals("u"))
	                			Discussion.get(i).upvote++;
	                		else if(ans.equals("v"))
	                			Discussion.get(i).downvote++;
	                		System.out.println();
	                		
	                		System.out.print("Would you like to comment on Post ? (y/n)");
	                		ans=sc.nextLine();
	                		System.out.println();
	                		if(ans.equals("y"))
	                		{
	                			System.out.print("Write Post :");
	                        	String content=sc.nextLine();
	                			Discussion.get(i).addComment(curr,content);
	                		}
	                		System.out.println();
	                	}
	                	break;
	                case "8":
	                	System.out.print("Write Post :");
	                	String content=sc.nextLine();
	                	System.out.println();
	                	Post np=new Post(curr,content);
	                	Discussion.add(np);
	                	break;
	                case "9":
	                	curr.showNoti();
	                	break;
	                case "10":
	                    flag=1;
	                    break;
	                default:
	                    System.out.println("Provide valid input");
	            }
	            System.out.println();
	            System.out.println();
	            if(flag==1)
	                break;
	        }
	    }
    }

}