package com.polansky.batching

import com.polansky.batching.entity.Address
import com.polansky.batching.entity.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@SpringBootTest(classes = BatchingApplication.class)
class BatchingApplication2Spec extends Specification {

    Logger log = LoggerFactory.getLogger(BatchingApplication2Spec.class)

    @Autowired
    UserRepo userRepo;

    @Transactional
    @Rollback(false)
    def "context loads"() {
        given:
        Address a = new Address()


        when:
        for (i in 0..1005) {


            User user = new User();
            user.setAddresses([new Address(street: 'street1'), new Address(street: 'street2')])
            userRepo.save(user)
            log.info("test" + i)
        }


        then:
        userRepo.findAll().size() == 1005
        false
    }
}
