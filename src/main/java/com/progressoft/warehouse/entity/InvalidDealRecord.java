package com.progressoft.warehouse.entity;

import com.progressoft.warehouse.entity.Interface.DealRecord;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EYAD on 3/6/2019.
 */
@Entity
@Table(name = "DEALS_INVALID_RECORDS")
@Data
public class InvalidDealRecord implements DealRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = DealRecord.ID)
    private long id;

    @Column(name = DealRecord.RECORD_ID)
    private long record_id;

    @Column(name = DealRecord.FROM_CURRENCY)
    private String fromCurrency;

    @Column(name = DealRecord.TO_CURRENCY)
    private String toCurrency;

    //    @Temporal(TemporalType.DATE)
    @Column(name = DealRecord.TIME_STAMP)
    private String timeStamp;

    @Column(name = DealRecord.AMOUNT)
    private String amount;

    @Column(name = "violations")
    private String violation;

    public String getViolations() {
        return violationList.toString();
    }

    @Transient
    private List<Violation> violationList = new ArrayList<>();

    @Column(name = DealRecord.FILE_ID)
    private long fileId;

    public InvalidDealRecord(String fromCurrency, String toCurrency, String amount, String timeStamp, List<Violation> violationList, Long fileId) {
        this.record_id = record_id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.timeStamp = timeStamp;
        this.amount = amount;
        this.violationList = violationList;
        this.fileId = fileId;
    }

}
