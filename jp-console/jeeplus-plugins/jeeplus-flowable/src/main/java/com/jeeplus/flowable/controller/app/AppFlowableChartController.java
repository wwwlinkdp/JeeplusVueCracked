/**
 * Copyright &copy; 2021-2026 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.flowable.controller.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeeplus.flowable.controller.FlowableTaskController;
import org.apache.commons.io.IOUtils;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.editor.language.json.converter.BpmnJsonConverter;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.repository.Model;
import org.flowable.image.impl.DefaultProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 流程个人任务相关Controller
 *
 * @author jeeplus
 * @version 2021-09-03
 */
@RestController
@RequestMapping("/")
public class AppFlowableChartController extends FlowableTaskController {


    @Autowired
    private HistoryService historyService;

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping(value = "getAppFlowChart/{procDefId}/{procInsId}")
    public void getJpgActivityDiagram(@PathVariable(value = "procDefId") String procDefId,
                                      @PathVariable(value = "procInsId") String procInsId,
                                      HttpServletResponse response) {
        //获得已经办理的历史节点
        List <HistoricActivityInstance> activityInstances = historyService.createHistoricActivityInstanceQuery().processInstanceId(procInsId).orderByHistoricActivityInstanceStartTime().asc().list();
        List<String> activties = new ArrayList <> ();
        List<String> flows = new ArrayList<>();
        for (HistoricActivityInstance activityInstance : activityInstances) {
            if ("sequenceFlow".equals(activityInstance.getActivityType())) {
                //需要高亮显示的连接线
                flows.add(activityInstance.getActivityId());
            } else {
                //需要高亮显示的节点
                activties.add(activityInstance.getActivityId());
            }
        }

        try {
            //根据modelId或者BpmnModel
            Model modelData = repositoryService.getModel(procDefId);
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter ();
            byte[] modelEditorSource = repositoryService.getModelEditorSource(modelData.getId());
            JsonNode editorNode = new ObjectMapper ().readTree(modelEditorSource);
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);
            //获得图片流
            DefaultProcessDiagramGenerator diagramGenerator = new DefaultProcessDiagramGenerator();
            InputStream inputStream = diagramGenerator.generateDiagram(
                    bpmnModel,
                    "png",
                    activties,
                    flows,
                    "宋体",
                    "宋体",
                    "宋体",
                    null,
                    1.0,
                    false);
            //输出图片
            IOUtils.copy(inputStream, response.getOutputStream());
            response.setHeader("Content-Disposition", "attachment; filename=" + bpmnModel.getMainProcess().getId() + ".png" );
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
