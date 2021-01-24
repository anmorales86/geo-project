package com.aquintero.appgate.geoproject.exception;

import com.aquintero.appgate.geoproject.exception.constants.ErrorMessageHelper;

/**
 * Class NoIsIpException
 * @author aquintero
 */
public class NoIsIpException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public NoIsIpException() {
        super(ErrorMessageHelper.NO_IS_IP);
    }
}
