package com.zking.ssm.controller;

import com.zking.ssm.model.File;
import com.zking.ssm.service.IFileService;
import com.zking.ssm.utils.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private IFileService iFileService;

    @ModelAttribute
    public Model into(Model model){
        return model.addAttribute("fileVo",new FileVo());
    }

    @RequestMapping("/dofile")
    public String dofile(){
        return "file";
    }

    @RequestMapping("/doUpload")
    public String fileAdd(MultipartFile img) throws IOException {
        System.out.println("file:"+img.getContentType());
        File file = new File();
        String s = UUID.randomUUID().toString().replaceAll("-","");
        file.setFileId(s);
        file.setUrl("G:\\"+s);
        file.setRealName(img.getName());
        file.setContentType(img.getContentType());
        iFileService.insert(file);
        java.io.File file1 = new java.io.File(file.getUrl());
        img.transferTo(file1);

        return "file";
    }



}
