package com.hcl.emobileconnect.service;

import com.hcl.emobileconnect.dao.RequestRepository;
import com.hcl.emobileconnect.entity.Request;
import com.hcl.emobileconnect.exception.RecordNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.hcl.emobileconnect.eMobileconnectApplicationConstants.REQUEST_ID_NOT_FOUND;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class RequestTrackingServiceTests {

    @InjectMocks
    RequestTrackingService trackingService;

    @Mock
    RequestRepository requestRepository;

    @Test
    public void testSuccessGetStatusByRequestID() throws RecordNotFoundException {
        Request dummyRequest = new Request();
        dummyRequest.setStatus("In Progress");
        when(requestRepository.findById(1)).thenReturn(Optional.of(dummyRequest));
        assertThat(trackingService.getStatusByRequestID(1)).isEqualTo("In Progress");
    }

    @Test
    public void testFailureGetStatusByRequestID(){
        when(requestRepository.findById(2)).thenThrow(new RuntimeException(REQUEST_ID_NOT_FOUND));
        String status  = "";
        try {
            trackingService.getStatusByRequestID(2).toString();
        }
        catch(Exception e) {
            status = e.getMessage();
        }
        assertThat(status).isEqualTo(REQUEST_ID_NOT_FOUND);
    }

}
