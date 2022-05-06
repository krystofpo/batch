package com.polansky.batching;

import com.polansky.batching.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {


}
