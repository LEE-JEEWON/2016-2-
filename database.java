import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

class connectDatabase {
	
	void connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("����̹� �˻� ����");
		}
		
		try{
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
		
			System.out.println("My-SQL ���Ӽ���");
			con.close();
		}catch(SQLException e){
			System.out.println("My-SQL ���ӽ���");
		}
	}
}

class ranking {
	
	String name, time, level;   
	int score, life;
	int i=0;
	
	void addRanking() {
		
		String sql = "insert into ranking values(?,?,?,?,?)";
		
		try{
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("���̵��� �Է��ϼ���.");
			level = sc.nextLine();
			System.out.println("�̸��� �Է��ϼ���.");
			name = sc.nextLine();
			System.out.println("�ð��� �Է��ϼ���.");
			time = sc.nextLine();
			System.out.println("������ �Է��ϼ���.");
			score = sc.nextInt();
			System.out.println("������ �Է��ϼ���.");
			life = sc.nextInt();
			
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
			
			PreparedStatement ps = null;
		
			ps = con.prepareStatement(sql);
			ps.setString(1, level);
			ps.setString(2, name);
			ps.setInt(3, score);
			ps.setString(4, time);
			ps.setInt(5, life);
			
			int n = ps.executeUpdate();
			
			if(n>0){
				System.out.println("�߰� ����");
			}else{
				System.out.println("�߰� ����");
			}
		}catch(SQLException e){
			System.out.println("������ �߰� ����");
		}
	}

	void showRankingHigh() {
		   
		try {
			
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
			
			PreparedStatement ps = null;
			ResultSet rs = null;   
			
			String sql = "select * from ranking where LEVEL = '��' order by SCORE desc, TIME, LIFE desc";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("��  ��\t��  ��\t��  ��\t��  ��\t��  ��");
			while (rs.next()) {
				i++;
				level = rs.getString("LEVEL");
				name = rs.getString(2);
				score = rs.getInt(3);
				time = rs.getString(4);
				life = rs.getInt(5);
				System.out.println(level + "\t" + name + "\t" + score + "\t" + time + "\t" + life);
				if(i==10){
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("��¿���");
		}
	}
	
	void showRankingMid() {
		   
		try {
			
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
			
			PreparedStatement ps = null;
			ResultSet rs = null;   
			
			String sql = "select * from ranking where LEVEL = '��' order by SCORE desc, TIME, LIFE desc";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("��  ��\t��  ��\t��  ��\t��  ��\t��  ��");
			while (rs.next()) {
				i++;
				level = rs.getString("LEVEL");
				name = rs.getString(2);
				score = rs.getInt(3);
				time = rs.getString(4);
				life = rs.getInt(5);
				System.out.println(level + "\t" + name + "\t" + score + "\t" + time + "\t" + life);
				if(i==10){
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("��¿���");
		}
	}
	
	void showRankingLow() {
		   
		try {
			
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
			
			PreparedStatement ps = null;
			ResultSet rs = null;   
			
			String sql = "select * from ranking where LEVEL = '��' order by SCORE desc, TIME, LIFE desc";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("��  ��\t��  ��\t��  ��\t��  ��\t��  ��");
			while (rs.next()) {
				i++;
				level = rs.getString("LEVEL");
				name = rs.getString(2);
				score = rs.getInt(3);
				time = rs.getString(4);
				life = rs.getInt(5);
				System.out.println(level + "\t" + name + "\t" + score + "\t" + time + "\t" + life);
				if(i==10){
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("��¿���");
		}
	}
}

class question {
	
	String dex, problem, answer, explain;
	String [][] arr = new String [10][4];//�ε���,����,��,�ؼ�
	int i;
	int []randnum = new int[30];
	String []qustnum = new String[10];
	int j;
	int tmp2;
	
	//showQuest�Լ����� println�κ��� �迭�� ���������� ������ Ȯ���ϴ� �κ��̶� �ڵ� ��ĥ�� ����ø� �˴ϴ�~
	
	String[][] reque(){
		return arr;
	}
	
	void showQuestionHigh() {

		try{
			
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			// ���ߺ� �����Լ�
			Random ra = new Random();
			for(j=0;j<30;j++)
			{
				randnum[j]=j;
			}
			for(j=0;j<30;j++)
			{
				int desti = ra.nextInt(30);
				tmp2 = randnum[j];
				randnum[j] = randnum[desti];
				randnum[desti] = tmp2;
			}
			for(j=0;j<10;j++)
			{
				qustnum[j]=Integer.toString(randnum[j]);//10��
			}
	
			for(i=0;i<10;i++)
			{
		
				String sql = "select * from testhigh where dex = \'" + qustnum[i]+ "\';" ;
		
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()){
					dex = rs.getString("dex"); 
					problem = rs.getString(2);
					answer = rs.getString(3);
					explain = rs.getString(4);
			
					arr[i][0] = dex;
					arr[i][1] = problem;
					arr[i][2] = answer;
					arr[i][3] = explain;
			
					System.out.println((i+1) + ". " + arr[i][1]);
					System.out.println(arr[i][2] + "\n" + arr[i][3]);
				}
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

	void showQuestionMid() {

		try{
			
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			// ���ߺ� �����Լ�
			Random ra = new Random();
			for(j=0;j<30;j++)
			{
				randnum[j]=j;
			}
			for(j=0;j<30;j++)
			{
				int desti = ra.nextInt(30);
				tmp2 = randnum[j];
				randnum[j] = randnum[desti];
				randnum[desti] = tmp2;
			}
			for(j=0;j<10;j++)
			{
				qustnum[j]=Integer.toString(randnum[j]);//10��
			}
	
			for(i=0;i<10;i++)
			{
		
				String sql = "select * from testmid where dex = \'" + qustnum[i]+ "\';" ;
		
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()){
					dex = rs.getString("dex"); 
					problem = rs.getString(2);
					answer = rs.getString(3);
					explain = rs.getString(4);
			
					arr[i][0] = dex;
					arr[i][1] = problem;
					arr[i][2] = answer;
					arr[i][3] = explain;
			
					System.out.println((i+1) + ". " + arr[i][1]);
					System.out.println(arr[i][2] + "\n" + arr[i][3]);
				}
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

	void showQuestionLow() {

		try{
			
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			// ���ߺ� �����Լ�
			Random ra = new Random();
			for(j=0;j<30;j++)
			{
				randnum[j]=j;
			}
			for(j=0;j<30;j++)
			{
				int desti = ra.nextInt(30);
				tmp2 = randnum[j];
				randnum[j] = randnum[desti];
				randnum[desti] = tmp2;
			}
			for(j=0;j<10;j++)
			{
				qustnum[j]=Integer.toString(randnum[j]);//10��
			}
	
			for(i=0;i<10;i++)
			{
		
				String sql = "select * from testlow where dex = \'" + qustnum[i]+ "\';" ;
		
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()){
					dex = rs.getString("dex"); 
					problem = rs.getString(2);
					answer = rs.getString(3);
					explain = rs.getString(4);
			
					arr[i][0] = dex;
					arr[i][1] = problem;
					arr[i][2] = answer;
					arr[i][3] = explain;
			
					System.out.println((i+1) + ". " + arr[i][1]);
					System.out.println(arr[i][2] + "\n" + arr[i][3]);
				}
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
}

public class jdbc {
	public static void main(String[] args){
		
		connectDatabase Database_connect = new connectDatabase();
		Database_connect.connect();
		
		//ranking Database_ranking = new ranking();
		question Database_showquestion = new question();
		
		//Database_ranking.addRanking();
		//Database_ranking.showRankingHigh();
		//Database_ranking.showRankingMid();
		//Database_ranking.showRankingLow();
		Database_showquestion.showQuestionLow();
	}
}