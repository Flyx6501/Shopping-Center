package com.service;
import com.bean.Commodity;
import com.dao.CommodityDao;
import com.mysql.jdbc.Connection;
import com.utils.DBHeper;
import com.utils.JDBCUtil;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/** 商品数据访问层
 * @author Qgs123
 * @date 2022/11/10 9:42
 **/
public class CommodityDaoImpl  implements CommodityDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    public CommodityDaoImpl(){
    }
    /** 商品的模糊查询
     * @param commodityName  商品名
     * @return java.util.List<com.bean.Commodity>
     * @author Qgs123
     * @date 2022/11/27 17:41
     **/
    @Override
    public List<Commodity> getFuzzyQueryCommodity(String commodityName){
        List<Commodity> list=new ArrayList<Commodity>();
        try {
            con= (Connection) DBHeper.getCon();
            ps=con.prepareStatement("select * from `commodity` where commodity_name LIKE '%"+commodityName+"%' ");

            rs=ps.executeQuery();
            while (rs.next()){
                Commodity g=new Commodity();
                g.setCommodityId(rs.getInt(1));
                g.setCommodityName(rs.getString(2));
                g.setCommodityPrice(rs.getDouble(3));
                g.setCommodityStock(rs.getInt(4));
                g.setCommodityPhoto(rs.getBytes(5));
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
    /** 根据commodityName获取商品信息
     * @param commodityName  商品的名字信息
     * @return java.util.List<com.bean.Commodity>
     * @author Qgs123
     * @date 2022/11/26 9:47
     **/
    @Override
    public List<Commodity> getNameCommodity(String commodityName){
        List<Commodity> list=new ArrayList<Commodity>();
        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer ss=new StringBuffer();
            ss.append("select * from `commodity`");
            if(commodityName!=null && commodityName !=""){
                ss.append("where commodity_name =?");
            }
            ps=con.prepareStatement(String.valueOf(ss));
            if (commodityName!=null && commodityName !=""){
                ps.setString(1,commodityName);
            }
            rs=ps.executeQuery();
            while (rs.next()){
                Commodity g=new Commodity();
                g.setCommodityId(rs.getInt(1));
                g.setCommodityName(rs.getString(2));
                g.setCommodityPrice(rs.getDouble(3));
                g.setCommodityStock(rs.getInt(4));
                g.setCommodityPhoto(rs.getBytes(5));
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
    /** 获取商品详情列表
     * @return java.util.List<com.bean.Commodity>
     * @author Qgs123
     * @date 2022/11/16 9:40
     **/
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
                g.setCommodityPhoto(rs.getBytes(5));
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
/** 获取某个商品详细信息
 * @param id  商品的id信息
 * @return java.util.List<com.bean.Commodity>
 * @author Qgs123
 * @date 2022/11/23 21:18
 **/
    public List<Commodity> getOneCommodity(int id){
        List<Commodity> list=new ArrayList<Commodity>();
        try {
            con= (Connection) DBHeper.getCon();
            ps=con.prepareStatement("select * from `commodity` where commodity_id=?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()){
                Commodity g=new Commodity();
                g.setCommodityId(rs.getInt(1));
                g.setCommodityName(rs.getString(2));
                g.setCommodityPrice(rs.getDouble(3));
                g.setCommodityStock(rs.getInt(4));
                g.setCommodityPhoto(rs.getBytes(5));
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
    /** 查询单个商品详情
     *  @param id 根据商品id查找
     * @author Qgs123
     * @date 2022/11/12 10:27
     **/
    @Override
    public Commodity getOne(int id){
        Commodity g=new Commodity();
        try {
            con= (Connection) DBHeper.getCon();
            ps=con.prepareStatement("select * from `commodity` where commodity_id=?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()) {
                g.setCommodityId(rs.getInt(1));
                g.setCommodityName(rs.getString(2));
                g.setCommodityPrice(rs.getDouble(3));
                g.setCommodityStock(rs.getInt(4));
                g.setCommodityPhoto(rs.getBytes(5));
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
    /** 新增商品库存
     * @param c 连接数据库
     * @param commodityName 商品名
     * @param commodityPrice 商品价格
     * @param commodityStock 商品库存
     * @param commodityInformation 商品信息
     * @return boolean
     * @author Qgs123
     * @date 2022/11/20 16:44
     **/
    @Override
    public boolean addCommodity(Connection c,String commodityName,Double commodityPrice,int commodityStock,String commodityInformation) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO `commodity` (commodity_name,commodity_price,commodity_stock,commodity_information) VALUES (?,?,?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1,commodityName);
            ps.setDouble(2, commodityPrice);
            ps.setInt(3, commodityStock);

            ps.setString(4,commodityInformation);
            int rs1 = ps.executeUpdate();
            if (rs1 >= 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(c, ps, rs);
        }
        return false;
    }
    /** 更新商品库存信息
     * @param c 连接数据库
     * @param commodityId 商品的id
     * @param commodityName 商品名
     * @param commodityPrice 商品价格
     * @param commodityStock 商品库存
     * @param commodityInformation 商品信息
         * @return boolean
     * @author Qgs123
            * @date 2022/11/20 16:08
            **/
    @Override
    public boolean updateCommodity(Connection c,String commodityName,Double commodityPrice,int commodityStock,String commodityInformation,int commodityId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE  `commodity` SET commodity_name=?,commodity_price=?,commodity_stock=?,commodity_information=? WHERE commodity_id=?";
            ps = c.prepareStatement(sql);
            ps.setString(1,commodityName);
            ps.setDouble(2, commodityPrice);
            ps.setInt(3, commodityStock);
           /** ps.setBytes(4,commodityPhoto);
           */
            ps.setString(4,commodityInformation);
            ps.setInt(5,commodityId);
            int rs1 = ps.executeUpdate();
            if (rs1 >= 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(c, ps, rs);
        }
        return false;
    }
    /** 删除特定库存记录
     * @param c 数据库连接
     * @param commodityId 商品id
     * @return boolean
     * @author Qgs123
     * @date 2022/11/20 16:43
     **/
    @Override
    public boolean deleteCommodity(Connection c,int commodityId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "delete from `commodity` where commodity_id=? ";

            ps = c.prepareStatement(sql);
            ps.setInt(1,commodityId);
            int rs1 = ps.executeUpdate();
            if (rs1 >= 1) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResource(c, ps, rs);
        }
        return false;
    }
    /** 根据id查询到商品信息
     * @param c 连接数据库
     * @param commodityId 商品的id
     * @return boolean
     * @author Qgs123
     * @date 2022/11/20 17:40
     **/
    @Override
    public boolean selectCommodity(Connection c,int commodityId){

        return false;
    }
    /** 根据id查询商品图片
     * @param id  商品的id信息
     * @return com.bean.Commodity 返回对应id商品图片数据
     * @author Qgs123
     * @date 2022/11/21 21:57
     **/
    public Commodity getOnePhoto(int id){
        Commodity g=new Commodity();
        try {
            con= (Connection) DBHeper.getCon();
            ps=con.prepareStatement("select * from `commodity` where commodity_id=?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()) {
                g.setCommodityId(rs.getInt(1));
                g.setCommodityName(rs.getString(2));
                g.setCommodityPrice(rs.getDouble(3));
                g.setCommodityStock(rs.getInt(4));
                g.setCommodityPhoto(rs.getBytes(5));
                g.setCommodityInformation(rs.getString(5));
                g.setCommodityComment(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBHeper.getColes(con, ps, rs);
        }
        return g;
    }
}
