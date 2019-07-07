package com.chenlei.elasticsearch.vo;

import com.chenlei.elasticsearch.common.constant.BizConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页对象
 * 
 * @author Administrator
 * @date 2018/10/09
 */
@ApiModel(value = "PageVO(分页对象)")
public class PageVO<T> {

    @ApiModelProperty(value = "每页数量", required = true)
    private Integer pageSize = BizConstant.PAGE_SIZE_20;// 每页显示记录数

    @ApiModelProperty(value = "当前页", required = true)
    private Integer currentPage = 1;// 当前页码

    @ApiModelProperty(value = "总记录数", required = true)
    private Integer totalCount = 0;// 总记录数

    @ApiModelProperty(value = "数据", required = true)
    private List<T> data;// 查询结果

    @ApiModelProperty(value = "map参数", required = true)
    private Map<String, Object> map;

    public PageVO() {}

    public PageVO(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public PageVO(Integer currentPage, Integer pageSize) {
        if (currentPage != null) {
            this.currentPage = currentPage;
        }
        if (pageSize != null) {
            this.pageSize = pageSize;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        Integer totalPage = getTotalPage();
        if (currentPage < 0 || totalPage == 0) {
            currentPage = 1;
        } else if (currentPage > totalPage) {
            currentPage = totalPage;
        }
    }

    @ApiModelProperty(value = "总页数", required = true)
    public Integer getTotalPage() {
        Integer totalPage = 0;
        if (this.totalCount == 0) {
            return totalPage;
        }
        totalPage = this.totalCount / pageSize;
        if (totalPage == 0 || totalCount % pageSize != 0) {
            totalPage = totalPage + 1;

        }
        return totalPage;
    }

    @ApiModelProperty(hidden = true)
    public Integer getStartIndex() {
        if (currentPage > 0) {
            return pageSize * (currentPage - 1);
        } else {
            return 0;
        }
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Map<String, Object> getMap() {
        return map == null ? new HashMap<String, Object>() : map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
