package com.kaavya.springdatajpa.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.kaavya.springdatajpa.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>{
	//Automatic query generation methods
	List<User> findByName(String name);
	List<User> findByEmail(String email);
	List<User> findByNameAllIgnoreCase(String name);
	List<User> findByNameOrderByNameAsc(String name);
	
	@Query("select u from User u where u.email = ?1")
	List<User> findUserByEmailAddressSorted(String email, Sort sort);
	
	@Query(value="SELECT * FROM user where name like '%m' ", nativeQuery = true)
	List<User> findUserByLikeName();
	
}
