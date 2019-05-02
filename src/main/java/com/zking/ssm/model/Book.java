package com.zking.ssm.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Component
@ToString
public class Book {
    @NotNull(message = "ID不能为空",groups = {Book.ValidateGroups.Del.class,Book.ValidateGroups.Edit.class})
    private Integer bookId;

    @NotBlank(message = "书名不能为空！",groups = {Book.ValidateGroups.Add.class,Book.ValidateGroups.Edit.class})
    private String bookName;

    @NotNull(message = "金钱不能为空",groups ={Book.ValidateGroups.Add.class,Book.ValidateGroups.Edit.class})
    @Min(value = 0,message = "金钱不能低于0",groups ={Book.ValidateGroups.Add.class,Book.ValidateGroups.Edit.class})
    private Float price;

    private Integer categoryId;

    public Book(Integer bookId, String bookName, Float price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
    }

    public Book() {
        super();
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    // 书本验证分组
    public static interface ValidateGroups {
        // 新增
        public static interface Add {
        }
//        修改
        public static interface Edit {
        }

        // 删除
        public static interface Del {
        }

    }

}