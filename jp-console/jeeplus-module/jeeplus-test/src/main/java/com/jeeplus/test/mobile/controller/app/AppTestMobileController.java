/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.mobile.controller.app;

import com.jeeplus.test.mobile.controller.TestMobileController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * App测试移动表单Controller
 * @author 刘高峰
 * @version 2022-04-13
 */

@Api(tags ="测试移动表单")
@RestController
@RequestMapping(value = "/app/test/mobile/testMobile")
public class AppTestMobileController extends TestMobileController {

}
