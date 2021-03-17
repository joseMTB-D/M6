package com.example.service;    
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.SpringBootExampleSts;
import com.example.repository.UserRepository;    
@Service    
public class UserService   
{    
@Autowired    
private UserRepository userRepository;    
public List<SpringBootExampleSts> getAllUsers()  
{    
List<SpringBootExampleSts>userRecords = new ArrayList<>();    
userRepository.findAll().forEach(userRecords::add);    
return userRecords;    
}    
public void addUser(SpringBootExampleSts userRecord)  
{    
userRepository.save(userRecord);    
}    
}    