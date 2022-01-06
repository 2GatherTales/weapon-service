package com.twogathertales.weaponservice.controller;

import com.twogathertales.weaponservice.model.customprincipal.CustomPrincipal;
import com.twogathertales.weaponservice.model.weapon.Weapon;
import com.twogathertales.weaponservice.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@RestController
@RequestMapping("api/weapon")
public class WeaponController {
    @Autowired
    GenericService<Weapon> weaponRepository;


    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

    @RequestMapping(value = "health",
            method = RequestMethod.GET,
            produces =  {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json")
    public ResponseEntity<String> health() {
        try {
            UUID uuid = UUID.randomUUID();
            String response = "OK   " + now();
            return new ResponseEntity<String>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAnyAuthority('role_admin', 'role_user')")
    public ResponseEntity<Weapon> find(@PathVariable("id") Long id) {
        try {

            CustomPrincipal principal = (CustomPrincipal) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            if(principal.getId().equals(String.valueOf(id)) ||  (principal.getUsername().equals("admin")))
                return new ResponseEntity<Weapon>(
                        weaponRepository.find(id), HttpStatus.OK);
            return new ResponseEntity<Weapon>(
                    HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<Weapon>(
                    HttpStatus.BAD_REQUEST);
        }
    }
}