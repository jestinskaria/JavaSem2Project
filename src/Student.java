
public class Student {

	 private String sId;
	    private String firstName;
	    private String lastName;
	    private String major;
	    private String phone;
	    private double gpa;
	    private String dob;
	    
	    public Student()
	    {
	    }
	    
	    public Student(String sId, String firstName, String lastName, String major, String phone, double gpa,String dob)
	    {
	        this.sId = sId;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.major = major;
	        this.phone = phone;
	        this.gpa = gpa;
	        this.dob=dob;
	    }
	    
	   
	    public String getId()
	    {
	        return sId;
	    }
	    public void setId(String sId)
	    {
	        this.sId = sId;
	    }
	    
	    public String getFirstName()
	    {
	        return firstName;
	    }
	    public void setFirstName(String firstName)
	    {
	        this.firstName = firstName;
	    }
	    
	    public String getLastName()
	    {
	        return lastName;
	    }
	    public void setLastName(String lastName)
	    {
	        this.lastName = lastName;
	    }
	    
	    public String getMajor()
	    {
	        return major;
	    }
	    public void setMajo(String major)
	    {
	        this.major = major;
	    }
	    
	    public String getPhone()
	    {
	        return phone;
	    }
	    public void setPhone(String phone)
	    {
	       
	            this.phone = phone;
	        
	    }
	    public double getGPA()
	    {
	        return gpa;
	    }
	    public void setGPA(double gpa)
	    {
	       
	            this.gpa = gpa;
	        
	    }
	    public String getDOB()
	    {
	    	
	        return dob;
	    }
	    public void setDOB(String dob)
	    {
	    	
	            this.dob = dob;
	        
	    }
	    
}
