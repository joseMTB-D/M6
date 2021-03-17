package com.example.model;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
@Entity    
public class SpringBootExampleSts   
{   
@Id    
private int id;    
private String name;    
private String email;  
//default conatructor    
public SpringBootExampleSts()  
{  
}    
public int getId()   
{    
return id;    
}    
public void setId(int id)   
{    
this.id = id;    
}    
public String getName()   
{    
return name;    
}    
public void setName(String name)   
{    
this.name = name;    
}    
public String getEmail()   
{    
return email;    
}    
public void setEmail(String email)   
{  
this.email = email;    
}    
}    