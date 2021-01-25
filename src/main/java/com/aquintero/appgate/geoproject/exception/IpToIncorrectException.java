package com.aquintero.appgate.geoproject.exception;

import com.aquintero.appgate.geoproject.exception.constants.ErrorMessageHelper;

public class IpToIncorrectException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public IpToIncorrectException() {
        super(ErrorMessageHelper.IP_TO_INCORRECT);
    }

}
