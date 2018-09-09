package com.tzxylao.manager.aop;

import com.tzxylao.manager.enums.ExceptionEnum;
import com.tzxylao.manager.exception.NoFoundExcepiton;
import com.tzxylao.manager.pojo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestControllerAdvice
public class GlobalExceptionHandler {
 
	private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
	public ResponseResult processException(Exception ex, HttpServletRequest request, HttpServletResponse response){
		ex.printStackTrace();
		
		if(ex instanceof MissingServletRequestParameterException){
			return new ResponseResult(ExceptionEnum.ERROR_REQUESTMISS,ex.getMessage(), null);
		}
		if(ex instanceof NoFoundExcepiton){
		        
	        LOGGER.error("======="+ex.getMessage()+"=======");
			return new ResponseResult(ExceptionEnum.ERROR_NOFOUND, "无法找到相应数据！", null);
			
		}
		
		return new ResponseResult(ExceptionEnum.ERROR_UNKNOW, ex.getMessage(), null);
		
	}
}