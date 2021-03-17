package com.example.repository;    
import org.springframework.data.repository.CrudRepository;  
import com.example.model.SpringBootExampleSts;    
public interface UserRepository extends CrudRepository<SpringBootExampleSts, String>   
{    
}
