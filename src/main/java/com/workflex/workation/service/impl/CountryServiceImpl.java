package com.workflex.workation.service.impl;

import com.workflex.workation.model.entity.Country;
import com.workflex.workation.model.entity.Employee;
import com.workflex.workation.repository.CountryRepository;
import com.workflex.workation.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public Country retrieveOrInsertCountry(String name) {
        Optional<Country> countryOptional = countryRepository.findByName(name);
        if (countryOptional.isPresent()) {
            return countryOptional.get();
        } else {
            Country country = Country.builder().name(name).build();
            return countryRepository.save(country);
        }
    }
}
