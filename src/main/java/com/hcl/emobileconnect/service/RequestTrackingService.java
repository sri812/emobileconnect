package com.hcl.emobileconnect.service;

import com.hcl.emobileconnect.dao.RequestRepository;
import com.hcl.emobileconnect.entity.Request;
import com.hcl.emobileconnect.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.hcl.emobileconnect.eMobileconnectApplicationConstants.*;

@Service
public class RequestTrackingService {

    @Autowired
    private RequestRepository requestRepository;

    public String getStatusByRequestID(int requestID) throws RecordNotFoundException {
        Request request = requestRepository.findById(requestID)
                .orElseThrow(() -> new RecordNotFoundException(REQUEST_ID_NOT_FOUND));

        return request.getStatus().toString();
    }
}
