package com.traveloka.bootcamp.subtraction.service;

import com.traveloka.bootcamp.subtraction.model.SubtractRequest;
import com.traveloka.bootcamp.subtraction.model.SubtractResponse;

public interface SubtractionService {
    int subtract(int a, int b);

    SubtractResponse subtract(SubtractRequest subtractRequest);
}
