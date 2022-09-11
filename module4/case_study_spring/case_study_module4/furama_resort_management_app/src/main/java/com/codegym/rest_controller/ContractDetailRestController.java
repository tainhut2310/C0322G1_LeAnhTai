package com.codegym.rest_controller;

import com.codegym.model.ContractDetail;
import com.codegym.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/contractDetail")
public class ContractDetailRestController {

    @Autowired
    private IContractDetailService contractDetailService;

    @PostMapping(value = "/create")
    public ResponseEntity<Void> save(@RequestBody ContractDetail contractDetail) {
        this.contractDetailService.save(contractDetail);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
