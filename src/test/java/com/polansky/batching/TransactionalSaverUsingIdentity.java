package com.polansky.batching;

import com.polansky.batching.entity.AddressUsingIdentity;
import com.polansky.batching.entity.UserUsingIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionalSaverUsingIdentity {

    @Autowired
    UserUsingIdentityRepo userUsingIdentityRepo;

    @Transactional
    public void saveInTransaction() {
        for (int i = 1; i <= 1000; i++) {
            UserUsingIdentity user = new UserUsingIdentity();
            user.setAddresses(List.of(new AddressUsingIdentity(), new AddressUsingIdentity()));
            userUsingIdentityRepo.save(user);
        }
    }

}
