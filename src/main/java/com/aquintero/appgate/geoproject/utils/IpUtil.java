package com.aquintero.appgate.geoproject.utils;

import com.aquintero.appgate.geoproject.exception.NoIsIpException;
import org.apache.commons.validator.routines.InetAddressValidator;

/**
 * Class IpUtil
 * @author aquintero
 */
public class IpUtil
{

    private static final Long VALUE_POS_0 = 16777216L;
    private static final Long VALUE_POS_1 = 65536L;
    private static final Long VALUE_POS_2 = 256L;

    /**
     * Method to reset the value of IP to value decimal
     * @param ip        IP
     * @return Long     Value Decimal
     */
    public static Long resetIpToDecimal(String ip)
    {
        validateIp(ip);
        String []dataIp = ip.split("\\.");
        return Long.parseLong(dataIp[0] )* VALUE_POS_0 + Long.parseLong(dataIp[1]) * VALUE_POS_1 +
                Long.parseLong(dataIp[2]) * VALUE_POS_2 + Long.parseLong(dataIp[3]);

    }

    /**
     * Method to validate IP
     * @param ip    IP
     */
    private static void validateIp(String ip)
    {
        InetAddressValidator validator = InetAddressValidator.getInstance();
        if (StringUtil.isNullOrEmpty(ip) || !validator.isValidInet4Address(ip)) { throw new NoIsIpException(); }
    }

}
