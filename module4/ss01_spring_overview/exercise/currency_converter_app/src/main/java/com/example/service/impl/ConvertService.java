package com.example.service.impl;

import com.example.repository.IConvertRepository;
import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Autowired
    IConvertRepository convertRepository;
    @Override
    public double convert(double rate, double usd) {
        return 0;
    }
}
