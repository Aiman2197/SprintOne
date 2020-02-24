package Wishlist.dao;

import java.sql.SQLException;
import java.util.HashMap;

import Wishlist.dto.Wishlist;

public interface WishlistDao {
	public HashMap<Integer, Wishlist> getAllWishlist() throws SQLException;
	public HashMap<String, Wishlist> getAllProduct() throws SQLException;
	public boolean Add_to_Wishlist(Wishlist wishlist) throws SQLException;
	
	
	

}
