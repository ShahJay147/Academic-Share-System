import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.*;
import java.io.*;

public class Account {

    private String username,DOB, name, userType, address, phoneNumber, eMail, acadInfo, password;
    private int followers;

    ArrayList<String>Wishlist=new ArrayList<String>();
    ArrayList<String>Notification=new ArrayList<String>();
    
    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }
    
    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String EMail) {
        this.eMail = EMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAcadInfo() {
        return acadInfo;
    }

    public void setAcadInfo(String acadInfo) {
        this.acadInfo = acadInfo;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    /*protected boolean login(String email, String password) throws SQLException {
        boolean ack = Main.db.checkuser(email, password);
        if(ack) {
            
        }else {
            System.out.println("Wrong email or password");
        }
        return false;
    }*/

    public Account(String username,String name, String email, String address, String DOB,String phoneNo, String password) {
    	this.username=username;
        this.eMail = email;
        this.name = name;
        this.address = address;
        this.DOB = DOB;
        this.phoneNumber = phoneNo;
        this.password=password;
    }

    public void addtoWishList(String s)
    {
    	if(Wishlist.contains(s))
    		System.out.println("Already in WishList.");
    	else
    	{
    		Wishlist.add(s);
    		System.out.println("Material added to WishList.");
    	}
    }
    
    public void removefromWishList(String s)
    {
    	if(!Wishlist.contains(s))
    		System.out.println("Material is not in WishList.");
    	else
    	{
    		Wishlist.remove(s);
    		System.out.println("Material has been removed.");
    	}
    }
    
    public void showNoti()
    {
    	for(int i=0;i<Notification.size();i++)
    	{
    		System.out.println(Notification.get(i));
    		System.out.println();
    		System.out.print("Would you like to delete it ? (y/n)");
    		Scanner sc=new Scanner(System.in);
    		System.out.println();
    		String ans=sc.nextLine();
    		if(ans.equals("y"))
    		{
    			Notification.remove(i);
    			System.out.println("Notification has been removed.");
    		}
    		System.out.println();
    	}
    }
    
    /*protected boolean forgotPassword() {

        return false;
    }

    protected boolean changePassword() {

        return false;
    }

    private boolean requirenmentsChecker() {
        
        return false;
    }

    private String createMD5(String pwd) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(pwd.getBytes());
        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }*/
}