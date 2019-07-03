#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.dal.interfaces;

/**
 * redis集成接口
 *
 * @author : joy.x.wei
 * @Data : 2018/12/20
 * @Time : 7:31 PM
 */
public interface RedisRepo {
    /**
     * 插入数据
     *
     * @param key   存储key
     * @param value 保存value
     * @return 保存是否成功
     */
    boolean put(String key, String value);

    /**
     * 查询数据
     *
     * @param key 指定key
     * @return 获取内容
     */
    String get(String key);

    /**
     * 删除数据
     *
     * @param key 删除key
     * @return 删除是否成功
     */
    boolean delete(String key);

    /**
     * 加锁
     *
     * @param key   存储key
     * @param value 存储value
     * @param timeout 存储value
     * @return 加锁是否成功
     */
    boolean lock(String key, String value, long timeout);
}
