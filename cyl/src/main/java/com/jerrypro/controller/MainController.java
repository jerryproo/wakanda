package com.jerrypro.controller;

import com.jerrypro.common.entity.MyAnniversaryDTO;
import com.jerrypro.common.result.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jerrypro
 * @date 2021/7/23
 */
@RestController
@RequestMapping("cyl/main")
public class MainController {

    @GetMapping("anni")
    Result<MyAnniversaryDTO> getAnniversary() {

        return null;

    }
}
