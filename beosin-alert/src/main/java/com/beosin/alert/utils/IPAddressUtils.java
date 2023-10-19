package com.beosin.alert.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Hex
 * create at 2023-10-19 16:14
 */
public class IPAddressUtils {
    private static final Logger logger = LoggerFactory.getLogger(IPAddressUtils.class);

    private static final String UNKNOWN = "unknown";
    private static final String IP_UTILS_FLAG = ",";
    private static final String LOCALHOST_IP = "0:0:0:0:0:0:0:1";
    private static final String LOCALHOST_IP1 = "127.0.0.1";

    private static String localIp;

    public static String getClientIp() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            return getClientIp(((ServletRequestAttributes) requestAttributes).getRequest());
        }
        return null;
    }

    public static String getClientIp(HttpServletRequest request) {
        if (request == null) {
            return LOCALHOST_IP1;
        }
        String ip = null;
        try {
            ip = request.getHeader("X-Original-Forwarded-For");
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("X-Forwarded-For");
            }
            //获取nginx等代理的ip
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("x-forwarded-for");
            }
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            //兼容k8s集群获取ip
            if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (LOCALHOST_IP1.equalsIgnoreCase(ip) || LOCALHOST_IP.equalsIgnoreCase(ip)) {
                    if (StringUtils.isEmpty(localIp)) {
                        //根据网卡取本机配置的IP
                        InetAddress iNet;
                        try {
                            iNet = InetAddress.getLocalHost();
                            localIp = iNet.getHostAddress();
                        } catch (UnknownHostException e) {
                            logger.warn("getClientIp error: {}", e.getMessage());
                        }
                    }
                    ip = localIp;
                }
            }
        } catch (Exception e) {
            logger.warn("IPUtils ERROR ", e);
        }
        //使用代理，则获取第一个IP地址
        if (!StringUtils.isEmpty(ip) && ip.indexOf(IP_UTILS_FLAG) > 0) {
            ip = ip.substring(0, ip.indexOf(IP_UTILS_FLAG));
        }
        return ip;
    }
}
