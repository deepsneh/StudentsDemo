package com.ind.students.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService {
    @Override
    public String getCollegesByPinCode(String pinCode) {
        String url = "https://api.postalpincode.in/pincode/"+pinCode;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
