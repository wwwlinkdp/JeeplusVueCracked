package com.jeeplus;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * <p>
 *     Jeeplus破解
 * </p>
 * @author zhangbin
 * @version 2022-12-01
 */
public class JeeplusCrack {

    public static void main(String[] args) {
        try {
            crack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void crack() throws Exception {
        ClassPool classPool = new ClassPool(true);
        classPool.importPackage("cn.hutool.extra.spring.SpringUtil");
        classPool.importPackage("com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper");
        classPool.importPackage("com.google.common.collect.Lists");
        classPool.importPackage("com.google.common.collect.Maps");
        classPool.importPackage("com.jeeplus.common.query.QueryType");
        classPool.importPackage("com.jeeplus.gencode.SerialNumberUtil");
        classPool.importPackage("com.jeeplus.gencode.controller.QueryTypeController");
        classPool.importPackage("com.jeeplus.gencode.controller.ShowTypeController");
        classPool.importPackage("com.jeeplus.gencode.controller.TemplateGroupController");
        classPool.importPackage("com.jeeplus.gencode.domain.CustomObj");
        classPool.importPackage("com.jeeplus.gencode.domain.TemplateObj");
        classPool.importPackage("com.jeeplus.gencode.service.CustomObjService");
        classPool.importPackage("com.jeeplus.gencode.service.dto.SchemeDTO");
        classPool.importPackage("com.jeeplus.gencode.service.dto.TableColumnDTO");
        classPool.importPackage("com.jeeplus.gencode.service.dto.TableDTO");
        classPool.importPackage("com.jeeplus.gencode.service.dto.TemplateDTO");
        classPool.importPackage("java.io.BufferedReader");
        classPool.importPackage("java.io.File");
        classPool.importPackage("java.io.FileWriter");
        classPool.importPackage("java.io.IOException");
        classPool.importPackage("java.io.InputStreamReader");
        classPool.importPackage("java.io.LineNumberReader");
        classPool.importPackage("java.net.HttpURLConnection");
        classPool.importPackage("java.net.URL");
        classPool.importPackage("java.net.UnknownHostException");
        classPool.importPackage("java.security.interfaces.RSAPublicKey");
        classPool.importPackage("java.text.SimpleDateFormat");
        classPool.importPackage("java.util.Date");
        classPool.importPackage("java.util.HashMap");
        classPool.importPackage("java.util.Iterator");
        classPool.importPackage("java.util.List");
        classPool.importPackage("java.util.Locale");
        classPool.importPackage("java.util.Map");
        classPool.importPackage("java.util.TimeZone");
        classPool.importPackage("org.apache.commons.lang3.StringUtils");
        classPool.importPackage("org.apache.commons.lang3.time.DateFormatUtils");
        classPool.importPackage("org.slf4j.Logger");
        classPool.importPackage("org.slf4j.LoggerFactory");
        classPool.importPackage("org.springframework.core.io.DefaultResourceLoader");

        CtClass ctClass = classPool.getCtClass("com.jeeplus.gencode.util.CodeUtils");
        CtMethod ctMethod = ctClass.getDeclaredMethod("getSerial");
        ctMethod.setBody("{ return getM(); }");
        ctClass.writeFile();
    }
}
