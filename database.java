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
			System.out.println("드라이버 검색 실패");
		}
		
		try{
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
		
			System.out.println("My-SQL 접속성공");
			con.close();
		}catch(SQLException e){
			System.out.println("My-SQL 접속실패");
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
			
			System.out.println("난이도를 입력하세요.");
			level = sc.nextLine();
			System.out.println("이름을 입력하세요.");
			name = sc.nextLine();
			System.out.println("시간을 입력하세요.");
			time = sc.nextLine();
			System.out.println("점수을 입력하세요.");
			score = sc.nextInt();
			System.out.println("생명을 입력하세요.");
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
				System.out.println("추가 성공");
			}else{
				System.out.println("추가 실패");
			}
		}catch(SQLException e){
			System.out.println("데이터 추가 에러");
		}
	}

	void showRankingHigh() {
		   
		try {
			
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
			
			PreparedStatement ps = null;
			ResultSet rs = null;   
			
			String sql = "select * from ranking where LEVEL = '상' order by SCORE desc, TIME, LIFE desc";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("레  벨\t이  름\t점  수\t시  간\t생  명");
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
			System.out.println("출력오류");
		}
	}
	
	void showRankingMid() {
		   
		try {
			
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
			
			PreparedStatement ps = null;
			ResultSet rs = null;   
			
			String sql = "select * from ranking where LEVEL = '중' order by SCORE desc, TIME, LIFE desc";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("레  벨\t이  름\t점  수\t시  간\t생  명");
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
			System.out.println("출력오류");
		}
	}
	
	void showRankingLow() {
		   
		try {
			
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
			
			PreparedStatement ps = null;
			ResultSet rs = null;   
			
			String sql = "select * from ranking where LEVEL = '하' order by SCORE desc, TIME, LIFE desc";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("레  벨\t이  름\t점  수\t시  간\t생  명");
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
			System.out.println("출력오류");
		}
	}
}

class question {
	
	String dex, problem, answer, explain;
	String [][] arr = new String [10][4];//인덱스,문제,답,해설
	int i;
	int []randnum = new int[30];
	String []qustnum = new String[10];
	int j;
	int tmp2;
	
	//showQuest함수에서 println부분은 배열에 정상적으로 들어갔는지 확인하는 부분이라서 코드 합칠때 지우시면 됩니당~
	
	String[][] reque(){
		return arr;
	}
	
	void showQuestionHigh() {

		try{
			
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			// 비중복 랜덤함수
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
				qustnum[j]=Integer.toString(randnum[j]);//10개
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
			// 비중복 랜덤함수
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
				qustnum[j]=Integer.toString(randnum[j]);//10개
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
			// 비중복 랜덤함수
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
				qustnum[j]=Integer.toString(randnum[j]);//10개
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