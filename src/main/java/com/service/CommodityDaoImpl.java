package com.service;

import com.bean.Commodity;
import com.dao.CommodityDao;
import com.mysql.jdbc.Connection;
import com.utils.DBHeper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/** 商品类的service
 * @author Qgs123
 * @date 2022/11/10 9:42
 **/
public class CommodityDaoImpl  implements CommodityDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    public CommodityDaoImpl(){
    }
    @Override
    public List<Commodity> getCommodityList() {
        List<Commodity> list=new ArrayList<Commodity>();

        try {
            con= (Connection) DBHeper.getCon();
            ps=con.prepareStatement("select * from `commodity`");
            rs=ps.executeQuery();
            while (rs.next()){
                Commodity g=new Commodity();
                g.setCommodityId(rs.getInt(1));
                g.setCommodityName(rs.getString(2));
                g.setCommodityPrice(rs.getDouble(3));
                g.setCommodityStock(rs.getInt(4));
                g.setCommodityPhoto(rs.getString(5));
                g.setCommodityInformation(rs.getString(6));
                g.setCommodityComment(rs.getString(7));
                list.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHeper.getColes(con, ps, rs);
        }
        return list;
    }
    /** 查询单个
     * @author Qgs123
     * @date 2022/11/12 10:27
     **/
    @Override
    public Commodity getOne(int id){
        try {
            con= (Connection) DBHeper.getCon();
            ps=con.prepareStatement("select * from shopping where commodity_id=?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()) {
                Commodity g=new Commodity();
                g.setCommodityId(rs.getInt(1));
                g.setCommodityName(rs.getString(2));
                g.setCommodityPrice(rs.getDouble(3));
                g.setCommodityStock(rs.getInt(4));
                g.setCommodityPhoto(rs.getString(5));
                g.setCommodityInformation(rs.getString(6));
                g.setCommodityComment(rs.getString(7));
                return g;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBHeper.getColes(con, ps, rs);
        }
        return null;
    }
    /** insert语句返回的是自增列的值
     */
    @Override
    public boolean addCommodity(Commodity commodity) {
        String sql = "insert into shopping values(0,?,?,?,?)";
/**      int count = super.executeUpdate(sql,commodity.getCommodityName(),commodity.getCommodityPrice(),commodity.getCommodityStock(),commodity.getCommodityInformation()) ;
  *      return count>0;
 */
     return false;
    }

    @Override
    public boolean updateCommodity(Commodity commodity) {
        String sql = "update shopping set  commodity_stock= ? where commodity_id = ? " ;
/**       return super.executeUpdate(sql,commodity.getCommodityStock(),commodity.getCommodityId())>0;
 */
    return false;
    }

    @Override
    public boolean delCommodity(String commodity) {
        String sql = "delete from commodity where commodity_name like ? " ;
/**      return super.executeUpdate(sql,commodity_name)>0;
   */
    return false;
    }

}
