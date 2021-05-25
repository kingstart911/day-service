package com.study.day.dayservice.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by chenyapeng on 2021/1/8 14:30
 */
@Entity
@Table(name = "c_person")
@Data
@Cacheable
public class PersonEntity  implements Serializable {

    private static final long serialVersionUID = 3627365738204636437l;

    @Id
    @GenericGenerator(name =  "gid" , strategy =  "uuid" )
    @GeneratedValue (generator =  "gid" )
    @Column (name =  "gid" , unique =  true , nullable =  false , length = 32)
    private String gid;
    private String name;
    private String address;
    private String job;
    private String ideal;
    private String opinion;

    @OneToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinColumn(name = "persongid")
    @Fetch(FetchMode.SUBSELECT)
    List<CarEntity> carList;

    public PersonEntity(String address,String name) {
        this.address = address;
        this.name = name;
    }

}
