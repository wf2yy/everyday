package com.smile.tkpro.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 功能描述：BaseMapper for tk-mybatis.
 * 要使用tk-mybatis对应接口请继承此接口
 *
 * @author liuguanghui
 * @since 2018-05-17
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

    /**
     * tk-mybatis通用接口列表：
     *
     @Select 接口
     List<T> select(T record);//根据实体中的属性值进行查询，查询条件使用等号
     T selectByPrimaryKey(Object key);//根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     List<T> selectAll();//查询全部结果，select(null)方法能达到同样的效果
     T selectOne(T record);//根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     int selectCount(T record);//根据实体中的属性查询总数，查询条件使用等号

     @Insert 接口
     int insert(T record);//保存一个实体，null的属性也会保存，不会使用数据库默认值
     int insertSelective(T record);//保存一个实体，null的属性不会保存，会使用数据库默认值

     @Update 接口
     int updateByPrimaryKey(T record);//根据主键更新实体全部字段，null值会被更新
     int updateByPrimaryKeySelective(T record);//根据主键更新属性不为null的值

     @Delete 接口
     int delete(T record);//根据实体属性作为条件进行删除，查询条件使用等号
     int deleteByPrimaryKey(Object key);//根据主键字段进行删除，方法参数必须包含完整的主键属性

     @Example方法 接口
     List<T> selectByExample(Object example);
     //根据Example条件进行查询-重点：这个查询支持通过Example类指定查询列，通过selectProperties方法指定查询列
     int selectCountByExample(Object example);
     //根据Example条件进行查询总数
     int updateByExample(@Param("record") T record, @Param("example") Object example);
     //根据Example条件更新实体record包含的全部属性，null值会被更新
     int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);
     //根据Example条件更新实体record包含的不是null的属性值
     int deleteByExample(Object example);//根据Example条件删除数据

     @Condition方法 接口
     Condition方法和Example方法作用完全一样，只是为了避免Example带来的歧义，提供的的Condition方法
     略，完全一致的5个接口，请参考Example方法

     @RowBounds 接口
     默认为内存分页，可以配合PageHelper实现物理分页
     略，暂定不用内存分页

     @MySQL专用 接口
     int insertList(List<T> recordList);//批量插入，另外该接口限制实体包含id属性并且必须为自增列
     int insertUseGeneratedKeys(T record);//插入数据，限制为实体包含id属性并且必须为自增列，实体配置的主键策略无效

     @SqlServer专用 略

     @Ids接口 略

     */
}
