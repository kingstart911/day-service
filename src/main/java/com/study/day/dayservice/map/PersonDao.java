package com.study.day.dayservice.map;

import com.study.day.dayservice.entity.PersonEntity;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface PersonDao   extends JpaRepository<PersonEntity,Long> {


    PersonEntity findByGid(String gid);

    PersonEntity findByName(String name);
}
