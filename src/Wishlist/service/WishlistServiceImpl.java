package Wishlist.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import Wishlist.dao.WishlistDao;
import Wishlist.dao.WishlistDaoImpl;
import Wishlist.dto.Wishlist;

public class WishlistServiceImpl implements WishlistService {
	boolean flag;
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
	public void addProduct() throws Exception{
		Scanner sc=new Scanner(System.in);
		flag=false;
		Wishlist wishlist=new Wishlist();
		String n = null;
		flag=false;
		while(flag==false) {
			System.out.println("Enter the product name");
			
		
		 n=sc.next();
		
			 if(n.compareTo("null")==0) {
				 
				 System.out.println("Product Name cannot be null");
				 
				 continue;
			 }
			 else {
				 
				 wishlist.setProduct_Name(n);
				 flag=true;
				 
			 }
		}
		
		boolean flag=false;
		do {
			
		
		System.out.println("Enter the product cost");
		boolean isCost=sc.hasNextInt();
		int c=sc.nextInt();
		if(isCost==true && c>0) {
		wishlist.setCost(c);
		flag=true;
		}
		else {
			System.out.println("Invalid Cost");
		}
		}while(flag!=true);
		String m=null;
		flag=false;
		while(flag==false) {
			System.out.println("Enter the manufacturer name");
			m=sc.next();
			if(m.compareTo("null")==0) {
				 
				 System.out.println("Manufacturer Name cannot be null");
				
				 continue;
			 }
			 else {
				 
				 wishlist.setManufacturer(m);
				 flag=true;
				 
			 }
		}
		
		
		
		wishlistDao.Add_to_Wishlist(wishlist);
		

	}

}
