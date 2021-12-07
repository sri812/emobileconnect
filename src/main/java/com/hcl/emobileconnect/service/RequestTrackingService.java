package com.hcl.emobileconnect.service;

import com.hcl.emobileconnect.dao.RequestRepository;
import com.hcl.emobileconnect.entity.Request;
import com.hcl.emobileconnect.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestTrackingService {

    @Autowired
    private RequestRepository requestRepository;

    public String getStatusByRequestID(int requestID) throws RecordNotFoundException {
        Request request = requestRepository.findById(requestID)
                .orElseThrow(() -> new RecordNotFoundException("Request ID not found in the system. Please try again"));

        return request.getStatus();

        //TODO 2: LOMBOK WITH <OPTIONAL> NOT  WORKING; CHECK THIS
        // TODO 1: call the method from the DAO JPA REPOSITORY



    }

}
