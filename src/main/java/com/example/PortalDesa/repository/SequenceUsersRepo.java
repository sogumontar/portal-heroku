package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.sequence.SequenceUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
@Repository
public interface SequenceUsersRepo extends JpaRepository<SequenceUsers,String> {
    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true else FALSE END FROM SequenceUsers s WHERE s.key=?1")
    Boolean existsByKey(String key);

    @Query("SELECT s FROM SequenceUsers s WHERE s.key=?1")
    SequenceUsers findFirstByKey(String key);

}
