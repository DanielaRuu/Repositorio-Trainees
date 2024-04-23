package com.mx.proyectofinal.cuentasBancoMex.service;

import com.mx.proyectofinal.cuentasBancoMex.model.BankAccounts;
import com.mx.proyectofinal.cuentasBancoMex.model.repository.BankAccountsRepository;
import com.mx.proyectofinal.cuentasBancoMex.model.response.BankAccountsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Daniela Ruiz
 * @since 1.0
 *
 * Class to implement methods used in the service layer of API de Cuentas Bancarias.
 */
@Service
public class BankAccountsServiceImpl implements IBankAccountsService{
    /**
     * Bean of the repository.
     */
    private final BankAccountsRepository repository;

    /**
     *  Bean of the modelMapper.
     */
    private final ModelMapper modelMapper;

    public BankAccountsServiceImpl(BankAccountsRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }





    /**
     * Implements the method to get all records of BankAccounts entity.
     * @return a response entity of the list of the BankAccounts object.
     */
    @Override
    public ResponseEntity<List<BankAccountsDTO>> listAll() {

        return ResponseEntity.ok(getAllBankAccounts());
    }



    /**
     * Method to query from BankAccounts entities.
     * @return a list of BankAccounts object.
     */
    private List<BankAccountsDTO> getAllBankAccounts() {
        List<BankAccountsDTO> bankAccountsDTOList = new ArrayList<>();

        List<BankAccounts> bankAccountsList = (List<BankAccounts>) repository.findAll();

        bankAccountsDTOList = bankAccountsList.
                stream().
                map(bankAccounts -> modelMapper.map(bankAccounts, BankAccountsDTO.class)).
                collect(Collectors.toList());

        return bankAccountsDTOList;
    }

    /**
     * Implements the method to get bank accounts filtered by status.
     *
     * @param status The status to filter bank accounts.
     * @return a response entity of the list of filtered BankAccounts object.
     */

    //Metodo para consultar cuentas con status activo
    @Override
    public ResponseEntity<List<BankAccountsDTO>> listByStatus(String status) {
        List<BankAccountsDTO> bankAccountsDTOList = new ArrayList<>();

        if ("ACTIVA".equals(status)) {
            // Obtener todas las cuentas bancarias con estado ACTIVO
            List<BankAccounts> bankAccountsList = repository.findByStatus("ACTIVA");

            // Mapear las cuentas bancarias a DTOs
            bankAccountsDTOList = bankAccountsList
                    .stream()
                    .map(bankAccounts -> modelMapper.map(bankAccounts, BankAccountsDTO.class))
                    .collect(Collectors.toList());
        }else{
            // Si no se proporciona el estado o es diferente de "ACTIVO", devolver una lista vacía
            return ResponseEntity.ok(Collections.emptyList());
        }

        return ResponseEntity.ok(bankAccountsDTOList);
    }


    // Método para obtener una cuenta bancaria por su ID y verificar si está activa
    @Override
    public ResponseEntity<BankAccountsDTO> getById(Integer accountId) {
        Optional<BankAccounts> optionalBankAccount = repository.findById(accountId);
        if (optionalBankAccount.isPresent()) {
            BankAccounts bankAccount = optionalBankAccount.get();
            if (bankAccount.getStatus().equals("ACTIVA")) {
                BankAccountsDTO bankAccountDTO = modelMapper.map(bankAccount, BankAccountsDTO.class);
                return ResponseEntity.ok(bankAccountDTO);
            } else {
                return ResponseEntity.notFound().build(); // La cuenta no está activa, devolver error 404
            }
        } else {
            return ResponseEntity.notFound().build(); // No se encontró la cuenta con el ID proporcionado
        }
    }

}
