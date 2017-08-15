package com.rimg.entity.mysql;

import lombok.*;

import javax.persistence.*;

/**
 * Created by alex on 2017/8/6.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String name;
    
    @Column
    private String passwd;
    
    @Column
    private String telephone;
    
    @Column
    private String sex = SEX.MALE;
    
    public interface SEX {
        String MALE = "male";
        String FEMALE = "female";
    }
}
