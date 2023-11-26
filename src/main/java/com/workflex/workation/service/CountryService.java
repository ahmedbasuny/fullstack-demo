package com.workflex.workation.service;

import com.workflex.workation.model.entity.Country;
import org.springframework.stereotype.Service;

@Service
public interface CountryService {
    Country retrieveOrInsertCountry(String name);
}
