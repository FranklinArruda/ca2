package com.CA2.User.Services;


import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Repositories.HospitalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalDataService {

    @Autowired
    private HospitalDataRepository hospitalDataRepository;

    public List<HospitalData> findAll() {
        return hospitalDataRepository.findAll();
    }

    public HospitalData findById(Long id) {
        return hospitalDataRepository.findById(id).orElse(null);
    }

    public HospitalData save(HospitalData hospitalData) {
        return hospitalDataRepository.save(hospitalData);
    }

    public void deleteById(Long id) {
        hospitalDataRepository.deleteById(id);
    }
}

