package com.manzanofp.CrudCompleto.repositories;

import com.manzanofp.CrudCompleto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{
}
