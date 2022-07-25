package com.traveloka.bootcamp.subtraction.service;

import com.traveloka.bootcamp.subtraction.model.SubtractRequest;
import com.traveloka.bootcamp.subtraction.model.SubtractResponse;

public class SubtractionServiceImpl implements SubtractionService {
    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public SubtractResponse subtract(SubtractRequest subtractRequest) {
        int result = subtract(subtractRequest.getA(), subtractRequest.getB());
        return new SubtractResponse(result);
    }
}
