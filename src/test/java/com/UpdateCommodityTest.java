package com;

import com.service.CommodityDaoImpl;
import com.utils.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**后台删除商品
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/20 22:05
 **/
public class UpdateCommodityTest {
    /** 商品信息修改
     * @author Qgs123
     * @date 2022/11/20 9:46
     **/
    @Test
    public void UpdateCommodity(){
        Connection c=null;
        try {
            CommodityDaoImpl test = new CommodityDaoImpl();
            c = JDBCUtil.getConnection();
            boolean flag = test.updateCommodity((com.mysql.jdbc.Connection)c, "B", 12.2,3,"aaa",20);
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /** 商品信息添加
     * @author Qgs123
     * @version 1.0
     * @date 2022/11/20 9:46
     **/
    @Test
    public void AddCommodity(){
        Connection c=null;
        try {
            CommodityDaoImpl test = new CommodityDaoImpl();
            c = JDBCUtil.getConnection();
            boolean flag = test.addCommodity((com.mysql.jdbc.Connection)c, "A", 12.2,3,"aaa");
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /** 删除商品
     * @author Qgs123
     * @date 2022/11/20 16:37
     **/
    @Test
    public void DeleteCommodity(){
        Connection c=null;
        try {
            CommodityDaoImpl test = new CommodityDaoImpl();
            c = JDBCUtil.getConnection();
            boolean flag = test.deleteCommodity((com.mysql.jdbc.Connection)c,6);
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}