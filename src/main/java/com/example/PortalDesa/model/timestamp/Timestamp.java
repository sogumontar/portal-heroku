package com.example.PortalDesa.model.timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/04/2020.
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"created_at", "updated_at"},
        allowGetters = true
)
public abstract class Timestamp implements Serializable {
    Calendar c1 = Calendar.getInstance();
    Date dateOne = c1.getTime();
    @CreatedDate
    private Instant created_at = dateOne.toInstant();

    @LastModifiedDate
    private Instant updated_at;

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public Instant getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }
}
