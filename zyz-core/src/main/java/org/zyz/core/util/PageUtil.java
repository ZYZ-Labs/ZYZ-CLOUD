package org.zyz.core.util;

import java.util.List;

/**
 * 分页工具类，用于封装分页结果。
 *
 * @param <T> 数据类型
 */
public class PageUtil<T> {

    private List<T> data; // 当前页的数据
    private long total;   // 数据总数
    private int page;     // 当前页码
    private int size;     // 每页大小

    public PageUtil(List<T> data, long total, int page, int size) {
        this.data = data;
        this.total = total;
        this.page = page;
        this.size = size;
    }

    // Getter 和 Setter 省略
}
