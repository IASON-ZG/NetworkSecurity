package com.example.securingweb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;

@Component
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT u FROM User u WHERE u.username=?1")
    public User findUser(String username);

    @Modifying
    @Query(value = "UPDATE logging SET time_of_login =?2 WHERE username =?1", nativeQuery = true)
    @Transactional
    public void newLogin(String username, Date timestamp);

    @Modifying
    @Query(value = "INSERT INTO logging (username,time_of_login) VALUES (:username,:timestamp)", nativeQuery = true)
    @Transactional
    public void firstLogin(String username, Date timestamp);

    @Query(value = "SELECT username FROM logging WHERE username=?1", nativeQuery = true)
    public String findLastLogin(String username);
}
