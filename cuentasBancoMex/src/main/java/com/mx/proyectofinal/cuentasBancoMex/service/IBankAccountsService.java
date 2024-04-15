package com.mx.proyectofinal.cuentasBancoMex.service;

import com.mx.proyectofinal.cuentasBancoMex.model.response.BankAccountsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Daniela Ruiz
 * @since 1.0
 *
 * Interface to define the methods used in each endpoints of the API de cuentas bancarias.
 */
public interface IBankAccountsService {

    /**
     * Method to return all records of BankAccounts object.
     * @return a response entity of list or BankAccounts object.
     */
    ResponseEntity<List<BankAccountsDTO>> listAll(); //metodo para obtener una lista de todas las cuentas

    ResponseEntity<List<BankAccountsDTO>> listByStatus(String status); //Metodo para obtener una lista de cuentas por su status
    ResponseEntity<BankAccountsDTO> getById(Integer accountId); // Método para obtener una cuenta bancaria por su ID


}
