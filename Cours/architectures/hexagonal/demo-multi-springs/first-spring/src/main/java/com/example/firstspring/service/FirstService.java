package com.example.firstspring.service;

import com.example.secondspring.service.SecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    private SecondService secondService;

    public FirstService(SecondService secondService) {
        this.secondService = secondService;
    }
}
