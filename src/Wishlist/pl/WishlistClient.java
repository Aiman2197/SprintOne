package Wishlist.pl;

import java.sql.SQLException;
import java.util.Scanner;

import Wishlist.service.WishlistService;
import Wishlist.service.WishlistServiceImpl;

public class WishlistClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ch = "yes";
		WishlistService service = null;
		try {
			service = new WishlistServiceImpl();

		} catch (SQLException e1) {
			System.err.println(e1.getMessage());
		}
		while (ch.equalsIgnoreCase("yes")) {
			System.out.println("Select Operation");
			System.out.println("1.Add to Wishlist");
			System.out.println("2. View Wishlist");
			int op = sc.nextInt();

			switch (op) {
			case 1:
				try {
					service.addProduct();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				try {
					service.showAllWishlist();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			default:
				break;
			}
			System.out.println("Continue Yes/No");
			ch = sc.next();
		}

	}

}
