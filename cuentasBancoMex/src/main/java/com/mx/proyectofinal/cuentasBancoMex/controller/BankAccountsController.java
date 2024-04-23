package com.mx.proyectofinal.cuentasBancoMex.controller;

import com.mx.proyectofinal.cuentasBancoMex.model.response.BankAccountsDTO;
import com.mx.proyectofinal.cuentasBancoMex.service.IBankAccountsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Daniela Ruiz
 * @since 1.0
 *
 * Controller class to define endpoints of API de Cuentas Bancarias.
 */
@Tag(name = "Bank Account", description = "")
@RestController
public class BankAccountsController implements IApiDocBankAccounts {


    /**
     * Object to implement the funcionality of endpoint methods.
     */

    private final IBankAccountsService bankAccountsService;

    /**
     * Constructor of the Controller class
     * @param bankAccountsService;
     */
    @Autowired
    public BankAccountsController( IBankAccountsService bankAccountsService) {
        this.bankAccountsService = bankAccountsService;

    }

    @Override
    public ResponseEntity<List<BankAccountsDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /**
     * Endpoint used to get all records in BankAccounts entity.
     * @return a ResponseEntity of the list of BankAccounts object.
     */

    /*@RequestMapping("/bankAccounts")
    public ResponseEntity<List<BankAccounts>> getAll() {
        return bankAccountsService.listAll();
    }*/

    @Override
    public ResponseEntity<List<BankAccountsDTO>> getAll(@PathVariable("status") String status) {
            return bankAccountsService.listByStatus(status);

    }

    @Override
    public ResponseEntity<BankAccountsDTO> getById(@PathVariable("accountId") Integer accountId) {
        // Lógica para obtener la cuenta bancaria por su ID
        BankAccountsDTO bankAccountDTO = bankAccountsService.getById(accountId).getBody();
        if (bankAccountDTO != null) {
            return ResponseEntity.ok(bankAccountDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}