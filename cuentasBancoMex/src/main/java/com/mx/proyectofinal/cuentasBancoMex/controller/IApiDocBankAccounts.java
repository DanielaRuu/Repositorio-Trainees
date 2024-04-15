package com.mx.proyectofinal.cuentasBancoMex.controller;

import com.mx.proyectofinal.cuentasBancoMex.model.response.BankAccountsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/**
 * @author Daniela
 * @since 1.0
 *
 * Inteface to define methods used in the Controller class.
 */
public interface IApiDocBankAccounts {
    /**
     * Method used as entry point of the GET function that return all records of BankAccounts catalog.
     * @return a ResponseEntity of List of BankAccountsDTO object.
     */
    @Operation(
            summary = "index",
            description = "Obtiene lista de cuentas de Cuentas Bancarias"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = BankAccountsDTO.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })


    @GetMapping("/bankAccounts")
    ResponseEntity<List<BankAccountsDTO>> getAll();

    @GetMapping("/bankAccounts?status=ACTIVO")
    ResponseEntity<List<BankAccountsDTO>> getAll(@RequestParam(name = "status", required = false) String status);

    @GetMapping("/bankAccounts/{accountId}")
    ResponseEntity<BankAccountsDTO> getById(@PathVariable("accountId") Integer accountId);

}
