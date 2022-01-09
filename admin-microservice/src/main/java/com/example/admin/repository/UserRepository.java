package com.example.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.admin.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT new User(r.email, r.type) FROM User r")
	List<User> findAllUsers();
	
	@Query("SELECT new User(r.email, r.password, r.type) FROM User r")
	List<User> findAllUsersforLogin();
	
	@Query("SELECT new User(r.email, r.password, r.type) FROM User r where r.email = :email")
	User findUserById(@Param("email") String email);
	
	@Query("SELECT new User(r.email, r.type, r.password) FROM User r where r.email = :email")
	Optional<User> findUserByIdLogin(@Param("email") String email);
	
//	@Query("DELETE FROM USER r where r.email = :email")
//	void deleteUserByUserName(@Param("email") String email);
//	Optional<User> findByUserName(String email);

}
