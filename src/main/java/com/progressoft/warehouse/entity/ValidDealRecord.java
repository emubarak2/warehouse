package com.progressoft.warehouse.entity;

import com.progressoft.warehouse.entity.Interface.DealRecord;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by EYAD on 3/6/2019.
 */
@Entity
@Table(name = "DEALS_VALID_RECORDS")
@Data
@AllArgsConstructor
public class ValidDealRecord implements DealRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = DealRecord.ID)
    private long id;

    @Column(name = DealRecord.FROM_CURRENCY)
    private String fromCurrency;

    @Column(name = DealRecord.TO_CURRENCY)
    private String toCurrency;

    //  @Temporal(TemporalType.DATE)
    @Column(name = DealRecord.TIME_STAMP)
    private String timeStamp;

    @Column(name = DealRecord.AMOUNT)
    private String amount;

    @Column(name = DealRecord.FILE_ID)
    private long fileId;

    @Transient
    private String violations = "";

    public ValidDealRecord(String fromCurrency, String toCurrency, String timeStamp, String amount, Long fileId) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.timeStamp = timeStamp;
        this.amount = amount;
        this.fileId = fileId;
    }
}
