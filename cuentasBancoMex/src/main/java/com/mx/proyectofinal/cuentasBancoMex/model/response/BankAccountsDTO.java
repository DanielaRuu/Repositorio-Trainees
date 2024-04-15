package com.mx.proyectofinal.cuentasBancoMex.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Daniela Ruiz
 * @since 1.0
 *
 * Object CuentasBancarias used in the API response of API de Cuentas Bancarias.
 */
@Schema(name = "BankAccount")
@Setter
@Getter
@ToString
public class BankAccountsDTO {
    //Account id
    @Schema(type = "integer", description = "Id de la cuenta", example = "3")
    @JsonProperty("id")
    private Integer id;

    //Account type
    @Schema(type = "string", description = "Tipo de cuenta", example = "cuenta de ahorros")
    @JsonProperty("account_type")
    private String account_type;

    //Account holder name
    @Schema(type = "string", description = "Nombre del titular de cuenta", example = "Daniela Ruiz")
    @JsonProperty("holder_name")
    private String holder_name;

    //Current account status
    @Schema(type = "string", description = "Estado actual de la cuenta", example = "activa")
    @JsonProperty("status")
    private String status;

    //It is a credit account
    @Schema(type = "boolean", description = "Es cuenta de credito", example = "false")
    @JsonProperty("creditable")
    private boolean creditable;

    //It is a debit account
    @Schema(type = "boolean", description = "Es cuenta de debito", example = "true")
    @JsonProperty("debitable")
    private boolean debitable;

    //Account version
    @Schema(type = "string", description = "version de la cuenta", example = "oro")
    @JsonProperty("version")
    private String version;

    //Name of the financial institution
    @Schema(type = "string", description = "Nombre de la institucion financiera", example = " Nu")
    @JsonProperty("bank_name")
    private String bank_name;
}
