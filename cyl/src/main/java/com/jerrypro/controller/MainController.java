package com.jerrypro.controller;

import com.jerrypro.common.result.dto.Result;
import com.jerrypro.common.result.util.ResultUtil;
import com.jerrypro.entity.MyAnniversaryDTO;
import com.jerrypro.enums.MyAnniversaryEnum;
import com.jerrypro.service.MyAnniversaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jerrypro
 * @date 2021/7/23
 */
@RestController
@RequestMapping("cyl/main")
public class MainController {

    @Resource
    private MyAnniversaryService myAnniversaryService;

    @GetMapping("anni")
    Result<MyAnniversaryDTO> getAnniversary() {
        final MyAnniversaryDTO dto = myAnniversaryService.getByCode(MyAnniversaryEnum.FIRST_DAY.getCode());
        return ResultUtil.successData(dto);
    }
}
