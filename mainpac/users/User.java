package users;
import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

import handlers.Database;
import handlers.News;

/**
* @generated
*/
public class User implements Comparable<User>, Serializable, Cloneable {
    private String username;
    private Integer password;
    private String fullName;
    private String id;
    
    private String mail;
    
    public User(String password, String fullname, String id) {
    	this.password = this.hashPassword(password);
    	this.fullName = fullname;
    	this.id = id;
    	this.username = this.genUsername(fullName);
    	this.mail = this.username + "@kbtu.kz";
    }

    //                          Operations        
    
    public boolean logIn(String username, String password) {
    	if(this.username.equalsIgnoreCase(username) && this.password == this.hashPassword(password))
    		return true;
    	return false;
    }
    
    private String genUsername(String fullname) {
    	String u = "";
    	boolean flag = false;
    	String name = "", surname = "";
    	
    	for(int i = 0; i < fullname.length(); i++) {
    		if(fullname.charAt(i) == ' ')
    			flag = true;
    		
    		if(!flag) {
    			name += fullname.charAt(i);
    		}
    		if(fullname.charAt(i) != ' ' && flag) {
    			surname += fullname.charAt(i);
    		}
    	}
    	
    	u = name.toLowerCase().charAt(0) + "_" + surname.toLowerCase();
    	
    	return u;
    }
    
    public void viewNews() {
        Vector<News> n = Database.getDB().getNews();
        int pos = 1;
        for(News i: n) {
        	System.out.println(pos + ". " + i.getTitle());
        	pos++;
        }
    }
    
    
    private int hashPassword(String password) {
        //TODO
        return password.hashCode();
    }
    
    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", fullName=" + fullName + ", id=" + id
				+ ", mail=" + mail + "]";
	}


    
    @Override
	public int hashCode() {
		return Objects.hash(fullName, id, mail, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(fullName, other.fullName) && Objects.equals(id, other.id)
				&& Objects.equals(mail, other.mail) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
}
