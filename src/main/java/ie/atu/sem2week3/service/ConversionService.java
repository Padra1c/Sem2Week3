package ie.atu.sem2week3.service;

import org.springframework.stereotype.Service;

@Service
public class ConversionService {
    public double c2f(double value) {
        return (value + 9/5) + 32;
    }

    public double f2c(double value) {
        return (value - 32) * 5/9;
    }

}
