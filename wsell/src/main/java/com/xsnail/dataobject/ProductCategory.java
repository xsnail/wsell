package com.xsnail.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/28 0028.
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;

    @Column(insertable = false,updatable = false)
    private Date createTime;
    @Column(insertable = false,updatable = false)
    private Date updateTime;


    public ProductCategory() {
    }
}
