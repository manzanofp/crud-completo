package com.manzanofp.CrudCompleto.repositories;

import com.manzanofp.CrudCompleto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{

    @Query(value = "select u from  User u where upper(trim(u.name)) like %?1%")
    List<User> findByName(String name);

}
