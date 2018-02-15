package com.dwm.daisomanage.factoryItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dwm.daisomanage.main.DBManager;

public class FactoryItemDAO {

	public static void reg(FactoryItem item) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql1 = null, sql2 = null, sql3 = null;
		try {
			conn = DBManager.connect();
			
			sql1 = "insert into FEB13_DWM_FactoryItem values(FEB13_DWM_FactoryItem_SEQ.nextval, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql1);
			
			pstmt.setString(1, item.getName());
			pstmt.setInt(2, item.getAmount());
			pstmt.setInt(3, item.getCost());
			
			if(pstmt.executeUpdate() == 1) {
				pstmt.close();
				
				sql2 = "insert into FEB13_DWM_SUPPLIES values(FEB13_DWM_SUPPLIES_SEQ.nextval, ?, ?, 0, 0)";
				
				pstmt = conn.prepareStatement(sql2);
				
				pstmt.setString(1, item.getName());
				pstmt.setInt(2, item.getCost()*3); // ������ 3�谡 �ǸŰ���
				
				if (pstmt.executeUpdate() == 1) {
					pstmt.close();
					
					sql3 = "insert into FEB13_DWM_SellItem values(FEB13_DWM_SellItem_SEQ.nextval, ?, 0, 0)";
					
					pstmt = conn.prepareStatement(sql3);
					
					pstmt.setString(1, item.getName());
					
					if (pstmt.executeUpdate() == 1) {
						FactoryItemController.goToRegResult("����");											
					} else {
						FactoryItemController.goToRegResult("����");											
					}
				} else {
					FactoryItemController.goToRegResult("����");					
				}
			} else {
				FactoryItemController.goToRegResult("����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			FactoryItemController.goToRegResult(null);
			
		} finally {
			DBManager.destroy(conn, pstmt, null);
		}
		
	}

	public static void update(FactoryItem item) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		try {
			conn = DBManager.connect();
			
			sql = "update FEB13_DWM_FactoryItem " + 
					"set f_amount = f_amount + ? " + 
					"where f_name = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, item.getAmount());
			pstmt.setString(2, item.getName());
			
			if(pstmt.executeUpdate() == 1) {
				FactoryItemController.goToUpdateResult("����");
			} else {
				FactoryItemController.goToUpdateResult("����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			FactoryItemController.goToUpdateResult(null);
			
		} finally {
			DBManager.destroy(conn, pstmt, null);
		}
	}

	public static void info() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null;
		try {
			conn = DBManager.connect();
			
			sql = "select * from FEB13_DWM_FactoryItem";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			ArrayList<FactoryItem> items = new ArrayList<>();
			FactoryItem fi = null;
			
			while (rs.next()) {
				fi = new FactoryItem(rs.getInt("f_no"), rs.getString("f_name"), rs.getInt("f_amount"), rs.getInt("f_cost"));
				items.add(fi);
			}
			
			if(items.size() == 0) {
				FactoryItemController.goToInfoResult("����", null);
			} else {
				FactoryItemController.goToInfoResult("����", items);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			FactoryItemController.goToInfoResult(null, null);
			
		} finally {
			DBManager.destroy(conn, pstmt, rs);
		}
		
	}

	public static void del(FactoryItem item) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		try {
			conn = DBManager.connect();
			
			sql = "delete from FEB13_DWM_FACTORYITEM where f_name = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, item.getName());
			
			if(pstmt.executeUpdate() == 1) {
				FactoryItemController.goToDelResult("����");
			} else {
				FactoryItemController.goToDelResult("����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			FactoryItemController.goToDelResult(null);
			
		} finally {
			DBManager.destroy(conn, pstmt, null);
		}
	}

	public static void deal(FactoryItem item) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql1 = null, sql2 = null;
		try {
			conn = DBManager.connect();
			// ������Ʈ
			sql1 = "update FEB13_DWM_FACTORYITEM " + 
					"set f_amount = f_amount - ? " + 
					"where f_name = ?";
			
			pstmt = conn.prepareStatement(sql1);
			
			pstmt.setInt(1, item.getAmount());
			pstmt.setString(2, item.getName());
			
			if(pstmt.executeUpdate() == 1) {
				pstmt.close();
				// ���̼� �� ������Ʈ
				sql2 = "update FEB13_DWM_SUPPLIES " + 
						"set s_amount = s_amount + ? " + 
						"where s_name = ?";
				
				pstmt = conn.prepareStatement(sql2);
				
				pstmt.setInt(1, item.getAmount());
				pstmt.setString(2, item.getName());
				
				if(pstmt.executeUpdate() == 1) {
					FactoryItemController.goToDealResult("����");					
				} else {
					FactoryItemController.goToDealResult("����");					
				}
				
			} else {
				FactoryItemController.goToDealResult("����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			FactoryItemController.goToDealResult(null);
			
		} finally {
			DBManager.destroy(conn, pstmt, null);
		}
		
	}
}
