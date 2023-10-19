package com.beosin.alert.rest;

import com.beosin.alert.actions.IPublicAction;
import com.beosin.alert.common.domain.dto.ResultDTO;
import com.beosin.alert.common.domain.ro.RiskUrlCheckRO;
import com.beosin.alert.common.domain.vo.PluginRiskUrlVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author Hex
 * create at 2023-10-16 15:46
 */
@Validated
@RestController
@RequestMapping("/public")
@Api(value = "Public", tags = "Public interfaces")
public class PublicRest {

    @Resource
    private IPublicAction publicAction;

    @ApiOperation("Search malicious websites")
    @PostMapping("/plugin/risk_url/verify")
    public ResultDTO<PluginRiskUrlVO> checkPluginRiskUrl(@Valid @RequestBody RiskUrlCheckRO ro) {
        return ResultDTO.success(publicAction.checkPluginRiskUrl(ro.getUrl(), ro.getWeb3Flag()));
    }

}
