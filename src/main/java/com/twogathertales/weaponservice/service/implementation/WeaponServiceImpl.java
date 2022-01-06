package com.twogathertales.weaponservice.service.implementation;

import com.twogathertales.weaponservice.model.weapon.Weapon;
import com.twogathertales.weaponservice.repository.WeaponRepository;
import com.twogathertales.weaponservice.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("weaponService")
public class WeaponServiceImpl implements GenericService<Weapon> {

    @Autowired
    private WeaponRepository weaponRepository;

    @Override
    public Iterable<Weapon> findAll() {
        return null;
    }

    @Override
    public Weapon find(Long id) { return (Weapon) weaponRepository.findById(id).get();    }

    @Override
    public Weapon create(Weapon weapon) {
        return null;
    }

    @Override
    public void update(Weapon weapon) {

    }

    @Override
    public void delete(Long id) {

    }
}
