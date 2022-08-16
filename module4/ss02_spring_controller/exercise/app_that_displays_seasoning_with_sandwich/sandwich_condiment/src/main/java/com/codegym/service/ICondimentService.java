package com.codegym.service;

import java.util.List;

public interface ICondimentService {
    List<String> condiment();

    String save(String [] condiment);
}
