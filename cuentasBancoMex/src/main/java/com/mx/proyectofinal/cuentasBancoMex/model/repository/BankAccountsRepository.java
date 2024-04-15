package com.mx.proyectofinal.cuentasBancoMex.model.repository;

import com.mx.proyectofinal.cuentasBancoMex.model.BankAccounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Daniela Ruiz
 * @since 1.0
 *
 * Repository of the BankAccounts entity.
 */
@Repository
public interface BankAccountsRepository extends CrudRepository<BankAccounts,Integer> {
    // Método para buscar cuentas bancarias por estado
    List<BankAccounts> findByStatus(String status);
}
