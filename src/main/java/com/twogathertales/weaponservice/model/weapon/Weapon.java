package com.twogathertales.weaponservice.model.weapon;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLHStoreType;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="weapon", schema = "avarum_game")
@Data
public class Weapon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(columnDefinition = "flavour")
    private String flavour;

    @Column(columnDefinition = "rarity")
    private String rarity;

    @Column(columnDefinition = "dmg")
    private Integer dmg;

}
