package com.example.PortalDesa.model.sequence;

import com.example.PortalDesa.model.constant.SequenceConstantField;
import com.example.PortalDesa.model.constant.TablesConstant;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
@Entity
@NoArgsConstructor
@Table(name = TablesConstant.TABEL_SEQUENCE_PRODUK)
public class SequenceProduk {
    @Id
    @Column(name = SequenceConstantField.SEQUENCE_KEY)
    private String key;

    @Column(name = SequenceConstantField.SEQUENCE_LAST_SEQUENCE)
    private String last_seq;

    public SequenceProduk(String key, String last_seq) {
        this.key = key;
        this.last_seq = last_seq;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLast_seq() {
        return last_seq;
    }

    public void setLast_seq(String last_seq) {
        this.last_seq = last_seq;
    }
}
