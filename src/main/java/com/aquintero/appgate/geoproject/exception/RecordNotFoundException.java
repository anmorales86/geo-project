package com.aquintero.appgate.geoproject.exception;

import com.aquintero.appgate.geoproject.exception.constants.ErrorMessageHelper;

public class RecordNotFoundException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public RecordNotFoundException() {
        super(ErrorMessageHelper.RECORD_NOT_FOUND);
    }

}
