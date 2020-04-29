package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.sequence.SequenceProduk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
@Repository
public interface SequenceProdukRepo  extends JpaRepository<SequenceProduk,String> {
    Boolean existsByKey(String key);
    SequenceProduk findFirstByKey(String key);
}
