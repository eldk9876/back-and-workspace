package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TXCommitTest2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member","root","qwer1234");
			
			
			
			conn.setAutoCommit(false);
			
			String qurey1 = "UPDATE bank SET balance = balance -? WHERE name = ?";
			PreparedStatement ps1 = conn.prepareStatement(qurey1);
			ps1.setInt(1, 30000);
			ps1.setString(2, "동엽");
			
			ps1.executeUpdate();

			String qurey2 =  "UPDATE bank SET balance = balance +? WHERE name = ?";
			PreparedStatement ps2 = conn.prepareStatement(qurey2);	
			ps2.setInt(1, 30000);
			ps2.setString(2, "동호");
			
			ps2.executeUpdate();
	
			String qurey3 = "SELECT balance FROM bank WHERE name = ?";
			PreparedStatement ps3 = conn.prepareStatement(qurey3);			
			ps3.setString(1, "동엽");

			ResultSet rs = ps3.executeQuery();
			

			
			if(rs.next()) { //잔액이 없으므로 이체 취소!	
				if(rs.getInt("balance") < 0) {
					conn.rollback();
					System.out.println("잔액이 없으므로 이체 취소!");
				}else {// 잔액이 있으므로 이체 성공!
					conn.commit();
					System.out.println("잔액이 있으므로 이체 성공!");
				}
				

			/*
			 * 동엽 -> 동호 : 3만원씩 이체
			 * 동엽님의 잔액이 마이너스가 되면 이제 취소가 되어야 함!
			 *
			 * */
			// 3개 필요! UPDATE 2개 -> SELECT 1개
			
			// 잔액이 없으므로 이체 취소!			
			// 잔액이 있으므로 이체 성공!

			
			conn.setAutoCommit(true);
			
			
		}} catch (Exception e) {
			e.printStackTrace();
		}}}
		
		
		
	


