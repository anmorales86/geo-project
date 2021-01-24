package com.aquintero.appgate.geoproject.exception;

import com.aquintero.appgate.geoproject.domain.response.ErrorResponse;
import com.aquintero.appgate.geoproject.exception.constants.ErrorMessageHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.ServletWebRequest;
import javax.servlet.http.HttpServletRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomExceptionHandlerTest
{

    @Mock
    private CustomExceptionHandler customExceptionHandler;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void handleUserNotFoundExceptionTest()
    {
        final ServletWebRequest request = new ServletWebRequest(mock(HttpServletRequest.class));
        final RecordNotFoundException exception = new RecordNotFoundException();
        final ResponseEntity<ErrorResponse> responseEntity = customExceptionHandler.handleUserNotFoundException(
                                                                                                exception,
                                                                                                request);
        assertEquals(ErrorMessageHelper.RECORD_NOT_FOUND, responseEntity.getBody().getMessage(),
                "It should be Cannot find record");
    }

    @Test
    public void handleAnyExceptionTest()
    {
        final ServletWebRequest request = new ServletWebRequest(mock(HttpServletRequest.class));
        final Exception exception = new Exception("Error!!!");
        final ResponseEntity<ErrorResponse> responseEntity = customExceptionHandler.handleAnyException(
                exception,
                request);
        assertEquals(ErrorMessageHelper.ERROR_TEST, responseEntity.getBody().getMessage(),
                "It should be Error!!!");
    }

}
