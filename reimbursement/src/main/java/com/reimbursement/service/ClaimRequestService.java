package com.reimbursement.service;
import com.reimbursement.entities.ClaimRequest;
import com.reimbursement.exception.ClaimFormNotFoundException;
import com.reimbursement.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimRequestService {
    @Autowired
    private ClaimRepository claimRepository;

    public List<ClaimRequest> getAllClaimRequest(){
        List<ClaimRequest> list=new ArrayList();
        list=claimRepository.findAll();
        return list;
    }

    public  ClaimRequest getClaimsById(Long claimFormid){
        Optional<ClaimRequest> claimRequestOptional=claimRepository.findById(claimFormid);
        if (claimRequestOptional.isPresent()) {
            return claimRequestOptional.get();
        } else {
            throw new ClaimFormNotFoundException(claimFormid);
        }
    }

    public ClaimRequest addClaimRequest(ClaimRequest claimRequest){
        return claimRepository.save(claimRequest);
    }
}



