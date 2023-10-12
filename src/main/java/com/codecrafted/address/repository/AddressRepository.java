package com.codecrafted.address.repository;

import com.codecrafted.address.modal.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, String > {

    @Query(name = "Select * from Address where full_street like :value%' or full_street_abr like :value%' fetch next 100 rows only")
    List<Address> findAddressByFullStreet(@Param("value") String value);

}
