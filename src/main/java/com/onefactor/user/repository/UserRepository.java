package com.onefactor.user.repository;

 
import com.onefactor.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
    // You can define custom query methods here if needed
}
