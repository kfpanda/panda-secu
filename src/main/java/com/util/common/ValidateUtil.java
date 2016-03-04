package com.util.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kfpanda.secu.action.ResultDTO;
import com.util.common.error.ErrorMessage;
import com.util.common.rule.Rule;



/**
 * 版权所有：bean验证工具类
 * 项目名称:kaqm
 * 创建者: 宋展辉
 * 创建日期: 2015年7月10日
 * 文件说明: 
 */
public class ValidateUtil<T> {


    /*日志引入
     * 
     */
    private static final Logger log = LoggerFactory.getLogger(ValidateUtil.class);
    public Map<String, Rule[]> ruleMap = null;
    public Map<String, String> nameMap = null;
    public Map<String, String> valueMap = null;

    public ValidateUtil() {
        ruleMap = new HashMap<String,Rule[]>();
        nameMap = new HashMap<String, String>();
        valueMap = new HashMap<String, String>();
    }

    public Map<String, Object> validate(String key, String value, String name) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Rule[] rules = ruleMap.get(key);
        if(rules!=null && rules.length>0){
            for(Rule rule : rules){
                rule.setValue(value);
                if(!rule.valid()){
                    resultMap.put("result", false);
                    resultMap.put("message", name+rule.getMessage());
                    break;
                }
            }
        }
        return resultMap;
    }
    
    public void init(){
        ruleMap = new HashMap<String,Rule[]>();
    }
    
    public void add(String key, String value, String name, Rule[] ruleArr){
        nameMap.put(key, name);
        valueMap.put(key, value);
        ruleMap.put(key, ruleArr);
    }

    
    public Map<String, Object> validateAll() throws Exception{
        Map<String, Object> resultMap = null;
        for (Entry<String, Rule[]> entry : ruleMap.entrySet()) {
            String key = entry.getKey();
            resultMap = validate(key);
            boolean result = (Boolean)resultMap.get("result");
            if(!result){
                resultMap.put("result", result);
                break;
            }
        }
        return resultMap;
    }
    
    
    public String validateString() throws Exception{
        String message = null;
        Map<String, Object> resultMap = null;
        for (Entry<String, Rule[]> entry : ruleMap.entrySet()) {
            String key = entry.getKey();
            resultMap = validate(key);
            boolean result = (Boolean)resultMap.get("result");
            if(!result){
                message = (String)resultMap.get("message");
                break;
            }
        }
        this.clear();
        return message;
    }
    
    public Map<String, Object> validate(String key) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("result", true);
        Rule[] rules = ruleMap.get(key);
        if(rules!=null && rules.length>0){
            for(Rule rule : rules){
                rule.setValue(valueMap.get(key));
                if(!rule.valid()){
                    resultMap.put("result", false);
                    resultMap.put("message", nameMap.get(key)+rule.getMessage());
                    break;
                }
            }
        }
        return resultMap;
    }
    
    public void clear(){
        //ruleMap.clear();
        //nameMap.clear();
        //valueMap.clear();
        ruleMap = null;
        nameMap = null;
        valueMap = null;
    }
    
    /**
     * 说明:
     * @param object
     * @return
     * @return ResultDTO
     * @author dozen.zhang
     * @date 2015年12月12日下午4:28:52
     */
    public ResultDTO valid (T object){
        ResultDTO result =new ResultDTO();
        result.setR(1);
        //bean 验证
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        java.util.Set<ConstraintViolation<T>> constraintViolations = validator
                .validate(object);
        String errormsg ="";
        Map<String,String> errormap =new HashMap();
        if (!constraintViolations.isEmpty()) {
            
            result.setR(300);
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                //getMessage的内容为属性上配置的message，getPropertyPath的内容为属性名
                //因为在处理的过程中同一个属性可能会报出多个错误，因此还是使用message名作为key来处理错误集合
                errormap.put(constraintViolation.getPropertyPath().toString(),
                        ErrorMessage.getErrorMsg(constraintViolation
                                .getMessage()));
                log.info("新增"+object.getClass().getName()+"表单验证未通过:"+errormsg);
            }
            result.setData(errormap);
            result.setMsg("参数校验失败");
        }
        return result;
    }
}
