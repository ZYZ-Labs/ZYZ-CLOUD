package org.zyz.core.mapper;

import java.util.List;

/**
 * 基础 Mapper 接口，定义通用的 CRUD 操作。
 *
 * @param <T> 实体类型
 */
public interface BaseMapper<T> {

    /**
     * 根据 ID 查找实体。
     *
     * @param id 实体 ID
     * @return 返回查询到的实体对象，如果不存在则返回 null
     */
    T findById(Long id);

    /**
     * 查询所有实体。
     *
     * @return 返回所有实体对象的列表
     */
    List<T> findAll();

    /**
     * 插入实体到数据库表中。
     *
     * @param entity 要插入的实体对象
     */
    void insert(T entity);

    /**
     * 更新数据库表中的实体信息。
     *
     * @param entity 要更新的实体对象
     */
    void update(T entity);

    /**
     * 根据 ID 删除数据库表中的实体。
     *
     * @param id 实体 ID
     */
    void delete(Long id);
}
