package Wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import Wishlist.dto.Wishlist;
import Wishlist.util.DatabaseUtil;

public class WishlistDaoImpl implements WishlistDao {
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst,pst1;
	Wishlist wishlist=null;

	HashMap<Integer, Wishlist> hashMap;
	HashMap<String, Wishlist> hashMap1;
	public WishlistDaoImpl() throws SQLException {
		connection = DatabaseUtil.myConnection();
	}

	@Override
	public HashMap<Integer, Wishlist> getAllWishlist() throws SQLException {
		st = connection.createStatement();
		rs = st.executeQuery("select * from wishlist");
		hashMap = new HashMap<>();
		while (rs.next()) {
			wishlist = null;
			wishlist = new Wishlist();

			wishlist.setCost(rs.getInt(1));
			wishlist.setProduct_Name(rs.getString(2));
			wishlist.setManufacturer(rs.getString(3));


			hashMap.put(rs.getInt(1), wishlist);
		}
		return hashMap;
	}

	@Override
	public boolean Add_to_Wishlist(Wishlist wishlist1) throws SQLException {
		pst=null;
        pst=connection.prepareStatement("insert into wishlist values(?,?,?)");
        pst.setInt(1, wishlist1.getCost());
        pst.setString(2, wishlist1.getProduct_Name());
        pst.setString(3, wishlist1.getManufacturer());
        int res=pst.executeUpdate();
        if(res==1)
        	return true;
        else
        	return false;
	}

	@Override
	public HashMap<String, Wishlist> getAllProduct() throws SQLException {
		// TODO Auto-generated method stub
		st = connection.createStatement();
		rs = st.executeQuery("select * from product");
		hashMap1 = new HashMap<>();
		while (rs.next()) {
			wishlist = null;
			wishlist = new Wishlist();

			wishlist.setCategory(rs.getString(1));
			wishlist.setProduct_Id(rs.getString(2));
			wishlist.setProduct_Name(rs.getString(3));
			wishlist.setCost(rs.getInt(4));

			hashMap1.put(rs.getString(1), wishlist);
		}
		//System.out.println(hashMap.size()+"   size  .....");
		return hashMap1;	
	}

}