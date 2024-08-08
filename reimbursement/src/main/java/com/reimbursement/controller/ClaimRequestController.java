package com.reimbursement.controller;

import com.reimbursement.entities.ClaimRequest;
import com.reimbursement.service.ClaimRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/claimrequest")
@RestController
public class ClaimRequestController {

    @Autowired
    private ClaimRequestService claimRequestService;

    @PostMapping("/submitClaim")
    public ResponseEntity<ClaimRequest> addClaimRequest(@RequestBody ClaimRequest claimRequest){
        ClaimRequest claimRequest1= claimRequestService.addClaimRequest(claimRequest);
        return new ResponseEntity<>(claimRequest, HttpStatus.OK);
    }

    @GetMapping("/getClaimsById/{claimFormId}")
    public ClaimRequest getClaimByID(@PathVariable Long claimFormId){
        ClaimRequest claimRequest = claimRequestService.getClaimsById(claimFormId);
        return claimRequest;
    }
}

