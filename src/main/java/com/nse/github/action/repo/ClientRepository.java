package com.nse.github.action.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nse.github.action.model.ClientCodeDtls;
import com.nse.github.action.model.ClientIdentity;



@Repository
public interface ClientRepository extends JpaRepository<ClientCodeDtls, ClientIdentity>{

    Optional<ClientCodeDtls> findByCcdPan(String ccdPan);

}
