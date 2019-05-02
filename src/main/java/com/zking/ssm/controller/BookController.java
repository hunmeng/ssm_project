package com.zking.ssm.controller;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.ResponseResult;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @ModelAttribute
    public void init(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        model.addAttribute("categoryId",new Integer[]{1,2,3,4,5});
    }

    @RequestMapping(value = "/addBook",method = RequestMethod.POST)
    public String addBook(@Validated(value = Book.ValidateGroups.Add.class) Book book, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            int insert = iBookService.insert(book);
        }
        return "add";
    }

    @RequestMapping(value = "/doAdd")
    public String doAdd (){
        return "add";
    }

    @RequestMapping(value = "/listBook")
    public ModelAndView listBook(ModelAndView modelAndView, Book book, HttpServletRequest request){
        PageBean pageBean = new PageBean();
        if (null== book.getBookName()) {
            book.setBookName("");
        }
        pageBean.setRequest(request);
        System.out.println(pageBean.toString());
        List<Book> bookList = iBookService.listBook(book, pageBean);
        modelAndView.addObject(pageBean);
        modelAndView.addObject(bookList);
        modelAndView.setViewName("list");
        return  modelAndView;
    }

    @RequestMapping(value = "/del")
    public String bookDel(@RequestParam("id") Integer id){
        int i = iBookService.deleteByPrimaryKey(id);
        return "redirect:/book/listBook";
    }

    @RequestMapping(value = "/addBookApi",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult addBook1(@Validated(value = Book.ValidateGroups.Add.class) Book book, BindingResult bindingResult){
//        Map<String,Object> jsonDate = new HashMap<>();
        ResponseResult<Map<String,Object>> responseResult = new ResponseResult<>();

        if(!bindingResult.hasErrors()){
            int insert = iBookService.insert(book);
            responseResult.setCode(0);
            responseResult.setMessage("新增成功");
//            jsonDate.put("code",0);
//            jsonDate.put("message","新增成功");
        }else{
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            Map<String,Object> fieldErrorsMap = new HashMap<>();
            for (FieldError fieldError : fieldErrors) {
                fieldErrorsMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            responseResult.setCode(-1);
            responseResult.setMessage("新增失败");
            responseResult.setDate(fieldErrorsMap);
        }
        return responseResult;
    }


}
