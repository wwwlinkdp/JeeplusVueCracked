/**
 * Copyright &copy; 2021-2026 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.flowable.controller.app;

import com.jeeplus.extension.domain.FormDefinitionJson;
import com.jeeplus.extension.service.FormDefinitionJsonService;
import com.jeeplus.flowable.controller.FlowableFormController;
import com.jeeplus.form.utils.FormJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 流程个人任务相关Controller
 *
 * @author jeeplus
 * @version 2021-09-03
 */
@RestController
@RequestMapping("/app/flowable/form")
public class AppFlowableFormController extends FlowableFormController {

    @Autowired
    private FormDefinitionJsonService formDefinitionJsonService;


    /**
     * 根据Id获取流程表单数据
     */
    @GetMapping("getMobileForm")
    public ResponseEntity queryById(String formDefinitionJsonId) {
        FormDefinitionJson formDefinitionJson = formDefinitionJsonService.getById (formDefinitionJsonId);
        List list = FormJsonUtils.newInstance ().getFieldsForApp (formDefinitionJson.getJson ());
        return ResponseEntity.ok ( list );
    }
}
