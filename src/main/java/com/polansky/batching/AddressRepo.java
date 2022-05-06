package com.polansky.batching;

import com.polansky.batching.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepo extends JpaRepository<Address, Long> {


}
