package com.beosin.alert.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beosin.alert.common.domain.po.RiskUrlPO;
import com.beosin.alert.mapper.RiskUrlMapper;
import com.beosin.alert.service.RiskUrlService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Hex
 * create at 2023-05-12 14:45
 */
@Service
public class RiskUrlServiceImpl extends ServiceImpl<RiskUrlMapper, RiskUrlPO> implements RiskUrlService {

    private static final String HTTPS_PREFIX = "https://";
    @SuppressWarnings("all")
    private static final String HTTP_PREFIX = "http://";

    @Override
    public List<RiskUrlPO> listByUrlColl(Collection<String> urlColl) {
        if (CollectionUtils.isEmpty(urlColl)) {
            return Collections.emptyList();
        }
        return this.list(new LambdaQueryWrapper<RiskUrlPO>().in(RiskUrlPO::getUrl, urlColl));
    }

    @Override
    public String trimPrefix(String url) {
        url = StringUtils.trimToEmpty(url);
        if (StringUtils.isEmpty(url)) {
            return "";
        }
        return StringUtils.trimToEmpty(url.replace(HTTPS_PREFIX, "").replace(HTTP_PREFIX, ""));

    }

    @Override
    public String getDomainFromUrl(String url) {
        url = StringUtils.trimToEmpty(url);
        if (StringUtils.isEmpty(url)) {
            return "";
        }

        url = url.toLowerCase().trim();
        if (url.startsWith(HTTPS_PREFIX)) {
            url = url.replace(HTTPS_PREFIX, HTTP_PREFIX);
        }
        if (!url.startsWith(HTTP_PREFIX)) {
            url = HTTP_PREFIX + url;
        }
        String host = url;
        try {
            host = new URL(url).getHost();
        } catch (MalformedURLException ignored) {
        }
        return host;
    }

    @Override
    public RiskUrlPO getByUrl(String url) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        return this.getOne(new LambdaQueryWrapper<RiskUrlPO>().eq(RiskUrlPO::getUrl, url));
    }
}
