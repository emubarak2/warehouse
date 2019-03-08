package com.progressoft.warehouse.repository;

import com.progressoft.warehouse.entity.ValidDealRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

/**
 * Created by EYAD on 3/6/2019.
 */
@Repository
public interface ValidDealRecordRepository extends JpaRepository<ValidDealRecord, UUID> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO DEALS_VALID_RECORDS (record_id, from_currency, to_currency, time_stamp, amount, file_id)" +
            " VALUES (:recordId,:toCurrency,:fromCurrency,:time_stamp,:amount,:fileId)", nativeQuery = true)
    void addValidDealRecord(@Param("recordId") long recordId, @Param("toCurrency") String toCurrency, @Param("fromCurrency") String fromCurrency
            , @Param("time_stamp") Date timeStamp, @Param("amount") double amount, @Param("fileId") long fileId);


}
