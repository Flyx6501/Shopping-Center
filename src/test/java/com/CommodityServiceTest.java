package com;

import com.bean.Commodity;
import com.service.CommodityDaoImpl;
import com.service.CommodityServiceImpl;
import java.sql.Connection;
import com.utils.JDBCUtil;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

/**��Ʒ�б�
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/12 19:55
 **/
public class CommodityServiceTest {
     /** ��ѯ��Ʒ�б�
      * @author Qgs123
      * @date 2022/11/20 16:51
      **/
    @Test
    public void getCommodityListTest() {
        CommodityServiceImpl commodityDao = new CommodityServiceImpl();

        List<Commodity> list = commodityDao.getCommodityList();
        System.out.println(list);
    }
     /** ��ȡĳ����Ʒ������
     * @author Qgs123
     * @date 2022/11/20 16:53
      **/
    @Test
    public void getOne() {
        CommodityServiceImpl commodityDao = new CommodityServiceImpl();
        Commodity list1=commodityDao.getOne(5);
        System.out.println(list1);
    }

}