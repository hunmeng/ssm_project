package com.zking.ssm.utils;

import com.zking.ssm.model.File;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@ToString
public class FileVo extends File {

    private Integer bookId;

    private MultipartFile multipartFile;

    public FileVo() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }


}
