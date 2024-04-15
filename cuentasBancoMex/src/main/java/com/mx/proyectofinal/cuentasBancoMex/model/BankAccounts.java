package com.mx.proyectofinal.cuentasBancoMex.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Daniela Ruiz
 * @since 1.0
 *
 * Entity class of the table BankAccounts.
 */
@Entity
@Table(name = "BANK_ACCOUNTS")
@Getter
@Setter
@ToString
public class BankAccounts {

    /**
     * Account Identifier.
     */
    @Id
    @Column
    private Integer id;

    /**
     * Account type column.
     */
    @Column
    private String account_type;

    /**
     * Holder name column.
     */
    @Column
    private String holder_name;

    /**
     * Status column.
     */
    @Column
    private String status;

    /**
     * Creditable column.
     */
    @Column
    private String creditable;

    /**
     * Debitable column.
     */
    @Column
    private String debitable;

    /**
     * Version column.
     */
    @Column
    private String version;

    /**
     * Bank name column.
     */
    @Column
    private String bank_name;
}
