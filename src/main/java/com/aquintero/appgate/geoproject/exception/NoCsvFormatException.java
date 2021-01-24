package com.aquintero.appgate.geoproject.exception;

import com.aquintero.appgate.geoproject.exception.constants.ErrorMessageHelper;

public class NoCsvFormatException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public NoCsvFormatException() {
        super(ErrorMessageHelper.NO_CSV_FORMAT);
    }
}
