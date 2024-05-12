package com.group04.OnlineAuctionPlatform.auth;

import com.group04.OnlineAuctionPlatform.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData,Long> {

    Optional<UserData> findUserByEmail(String email);

}
