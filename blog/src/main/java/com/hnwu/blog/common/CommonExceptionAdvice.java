package com.hnwu.blog.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 吴会楠 on 2017/12/8.
 */
@ControllerAdvice
public class CommonExceptionAdvice {

    @ExceptionHandler
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView mv = new ModelAndView();
        mv.addObject("ErrorMessage", exception.getMessage());
        mv.setViewName("common/Error");
        return mv;
    }

    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("SysMsg", "自定义显示的异常提示信息！");
    }

    @InitBinder
    public  void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }

}
