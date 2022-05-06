package com.polansky.batching;

import com.polansky.batching.entity.Address;
import com.polansky.batching.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionalSaver {

    @Autowired
    UserRepo userRepo;

    @Transactional
    public void saveInTransaction() {
        for (int i = 1; i <= 1000; i++) {
            User user = new User();
            user.setAddresses(List.of(new Address(), new Address()));
            userRepo.save(user);
        }
    }

}
