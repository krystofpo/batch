package com.polansky.batching;

import com.polansky.batching.entity.UserUsingIdentity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserUsingIdentityRepo extends JpaRepository<UserUsingIdentity, Long> {


}
