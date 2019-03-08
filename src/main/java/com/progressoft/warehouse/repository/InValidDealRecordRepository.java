package com.progressoft.warehouse.repository;

import com.progressoft.warehouse.entity.InvalidDealRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by EYAD on 3/6/2019.
 */
@Repository
public interface InValidDealRecordRepository extends JpaRepository<InvalidDealRecord, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO DEALS_INVALID_RECORDS (from_currency, to_currency, time_stamp, amount, file_id)" +
            " VALUES (:toCurrency,:fromCurrency,:time_stamp,:amount,:fileId)", nativeQuery = true)
    void addInvalidDealRecord(@Param("toCurrency") String toCurrency, @Param("fromCurrency") String fromCurrency, @Param("time_stamp") String timeStamp,
                              @Param("amount") double amount, @Param("fileId") int fileId);


}
