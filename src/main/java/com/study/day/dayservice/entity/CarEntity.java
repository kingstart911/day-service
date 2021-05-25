package com.study.day.dayservice.entity;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chenyapeng on 2021/1/11 17:16
 */
@Entity
@Table(name = "c_car")
@Data
@Cacheable
public class CarEntity  implements Serializable {
    @Id
    @GenericGenerator(name =  "gid" , strategy =  "uuid" )
    @GeneratedValue (generator =  "gid" )
    @Column (name =  "gid" , unique =  true , nullable =  false , length = 32)
    private String gid;
    private String name;
    private String code;
    @Column(name = "carvalues")
    private String carValues;
    private String remark;
    @Column(name = "persongid")
    private String personGid;


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "persongid", insertable = false, updatable = false)
//    private PersonEntity personEntity;

}
