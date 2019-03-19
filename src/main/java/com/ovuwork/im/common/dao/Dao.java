package com.ovuwork.im.common.dao;

import com.serverlite.dao.D;
import com.serverlite.dao.common.Page;
import com.serverlite.dao.mapping.Mapping;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class Dao extends D {

    /**
     *	================================================================== 查询方法 ==================================================================
     */

    /**
     * 分页查询
     *
     * @param sqlat
     * @param pageNo
     * @param pageSize
     * @param params
     * @return
     */
    public static Page<Map<String, Object>> queryPageAt(String sqlat, int pageNo, int pageSize, Object... params) {
        String sql = SqlUtil.getSql(sqlat);
        return D.queryPage(sql, pageNo, pageSize, params);
    }

    /**
     * 列表查询
     *
     * @param sqlat
     * @param params
     * @return
     */
    public static List<Map<String, Object>> queryAt(String sqlat, Object... params) {
        String sql = SqlUtil.getSql(sqlat);
        return D.query(sql, params);
    }

    /**
     * 列表查询
     *
     * @param sqlat
     * @param params
     * @return
     */
    public static <T> List<T> queryJavaAt(String sqlat, Class<T> clazz, Object... params) {
        String sql = SqlUtil.getSql(sqlat);
        return D.queryJava(sql, clazz, params);
    }

    /**
     * 单个实体查询
     *
     * @param sqlat
     * @param params
     * @return
     */
    public static Map<String, Object> queryOneAt(String sqlat, Object... params) {
        String sql = SqlUtil.getSql(sqlat);
        return D.queryOne(sql, params);
    }

    /**
     * 单个实体查询
     *
     * @param sqlat
     * @param params
     * @return
     */
    public static <T> T queryJavaOneAt(String sqlat, Class<T> clazz, Object... params) {
        String sql = SqlUtil.getSql(sqlat);
        return D.queryJavaOne(sql, clazz, params);
    }

    /**
     * 查询单值
     *
     * @param sqlat
     * @param params
     * @return
     */
    public static Object queryScalarAt(String sqlat, Object... params) {
        String sql = SqlUtil.getSql(sqlat);
        return D.queryScalar(sql, params);
    }

    /**
     *	================================================================== 更新方法 ==================================================================
     */

    /**
     * 删除一个对象
     *
     * @param obj
     */
    public static void delete(BaseEntity obj) {
        String t = Mapping.getTableName(obj.getClass());
        D.update("update " + t + " set del_flag = '1' where id = ?", obj.getId());
    }

    /**
     * 批量删除对象
     *
     * @param t
     * @param ids
     */
    public static void batchDelete(String t, String ids) {
        D.update("update " + t + " set del_flag = '1' where id" + D.in(ids.split(",")));
    }

    /**
     * 更新操作
     *
     * @param sqlat
     * @param params
     */
    public static void updateAt(String sqlat, Object... params) {
        String sql = SqlUtil.getSql(sqlat);
        D.update(sql);
    }


    /**
     *	================================================================== 公用方法 ==================================================================
     */


    /**
     * 拷贝对象属性值
     *
     * @param srcObj
     * @param desObj
     */
    public static void copyObject(Object srcObj, Object desObj) {
        try {
            Field[] fs = srcObj.getClass().getDeclaredFields();
            for (int i = 0; i < fs.length; i++) {
                Field f = fs[i];
                f.setAccessible(true); // 设置些属性是可以访问的
                Object val;
                val = f.get(srcObj);
                if (val != null) {
                    f.set(desObj, val);
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
