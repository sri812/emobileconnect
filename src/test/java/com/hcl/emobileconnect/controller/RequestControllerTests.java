package com.hcl.emobileconnect.controller;

import com.hcl.emobileconnect.exception.RecordNotFoundException;
import com.hcl.emobileconnect.service.RequestTrackingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.hcl.emobileconnect.eMobileconnectApplicationConstants.REQUEST_ID_NOT_FOUND;
import static com.hcl.emobileconnect.eMobileconnectApplicationConstants.UNKNOWN_ERROR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RequestControllerTests {

    @Mock
    RequestTrackingService trackingService;

    @InjectMocks
    RequestController requestController;

    @Test
    public void testGetStatusByRequestID() throws RecordNotFoundException {
        when(trackingService.getStatusByRequestID(2)).thenReturn("In Progress");
        assertThat(requestController.getStatusByRequestID(2)).isEqualTo("In Progress");

        when(trackingService.getStatusByRequestID(9999)).thenThrow(new RuntimeException(UNKNOWN_ERROR));
        assertThat(requestController.getStatusByRequestID(9999)).isEqualTo(UNKNOWN_ERROR);


    }

}
