package com.progressoft.warehouse.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by EYAD on 3/6/2019.
 */
@Entity
@Table(name = "FILE_NAME")
@Data
public class FileRecord {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "file_name")
    private String fileName;

}
