package com.hcl.emobileconnect.controller;

import com.hcl.emobileconnect.exception.RecordNotFoundException;
import com.hcl.emobileconnect.service.RequestTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.hcl.emobileconnect.eMobileconnectApplicationConstants.*;

@RestController
@RequestMapping("/customers")
public class RequestController {

    @Autowired
    private RequestTrackingService requestTrackingService;

    // REQUEST TRACKING FOR CUSTOMER : Modified the API endpoint to customers/requests/{requestID}
    @GetMapping(value = "/requests/{id}")
    public String getStatusByRequestID(@PathVariable Integer id) {
        try {
            return requestTrackingService.getStatusByRequestID(id);
        } catch (RecordNotFoundException e) {
            return REQUEST_ID_NOT_FOUND;
        } catch (Exception e) {
            return UNKNOWN_ERROR;
        }
    }
}
