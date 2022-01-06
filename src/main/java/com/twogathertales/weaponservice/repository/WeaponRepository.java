package com.twogathertales.weaponservice.repository;

import com.twogathertales.weaponservice.model.weapon.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("weaponRepository")
public interface WeaponRepository<T> extends JpaRepository<Weapon, Long> {

}
