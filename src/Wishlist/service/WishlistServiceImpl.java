package Wishlist.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import Wishlist.dao.WishlistDao;
import Wishlist.dao.WishlistDaoImpl;
import Wishlist.dto.Wishlist;

public class WishlistServiceImpl implements WishlistService {
	WishlistDao wishlistDao;
	HashMap<Integer, Wishlist>hashMap;
	HashMap<String,Wishlist>hashMap1;
	public WishlistServiceImpl() throws SQLException{
		wishlistDao=new WishlistDaoImpl();
	}
	@Override
	public void showAllWishlist() throws SQLException {
		hashMap=wishlistDao.getAllWishlist();
		
		Set<Integer>keyset=hashMap.keySet();
		for (Integer integer : keyset) {
			System.out.println(hashMap.get(integer));
			
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addProduct() throws SQLException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the product name to add in wishlist");
		Wishlist wishlist=new Wishlist();
		wishlist.setProduct_Name(sc.next());
		
		System.out.println("Enter the product cost");
		wishlist.setCost(sc.nextInt());
		
		System.out.println("Enter the product manufacturer");
		wishlist.setManufacturer(sc.next());
		
		wishlistDao.Add_to_Wishlist(wishlist);
	}

}
