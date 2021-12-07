package com.hcl.emobileconnect.controller;

import com.hcl.emobileconnect.exception.RecordNotFoundException;
import com.hcl.emobileconnect.service.RequestTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
class RequestController {

    @Autowired
    private RequestTrackingService requestTrackingService;

// REQUEST TRACKING FOR CUSTOMER : Modified the API endpoint to customers/requests/{requestID}
    @GetMapping(value = "requests")
    public String getStatusByRequestID(@PathVariable Integer id) {
        try {
            return requestTrackingService.getStatusByRequestID(id);
        } catch (RecordNotFoundException e) {
            return "Request ID not found in the system. Please try again.";
        } catch (Exception e) {
            return "Unknown Error. Please try again.";
        }
    }
}
