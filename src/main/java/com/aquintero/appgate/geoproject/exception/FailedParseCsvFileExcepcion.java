package com.aquintero.appgate.geoproject.exception;

import com.aquintero.appgate.geoproject.exception.constants.ErrorMessageHelper;

public class FailedParseCsvFileExcepcion extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public FailedParseCsvFileExcepcion() {
        super(ErrorMessageHelper.FAILED_PARSE_CSV_FILE);
    }
}
