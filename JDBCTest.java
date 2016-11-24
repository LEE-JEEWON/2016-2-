package database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;
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
   
   String index, problem, answer, explain;
   String [][] arr = new String [10][4];
   int i=0;
   
   void showQuestionHigh() {

      try{
         
         Connection con = null;
         con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
         
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "select * from testhigh";
      
         
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();

         while(rs.next()){
            i++;
            index = rs.getString("index");
            problem = rs.getString(2);
            answer = rs.getString(3);
            explain = rs.getString(4);
         
            int qnum = Integer.parseInt(index);
         
            arr[qnum][0] = index;
            arr[qnum][1] = problem;
            arr[qnum][2] = answer;
            arr[qnum][3] = explain;
         
            System.out.println(arr[qnum][0] + ". " + arr[qnum][1]);
            System.out.println(arr[qnum][2] + "\n" + arr[qnum][3]);
            
            if(i==10){
               break;
            }
         }
      }catch(SQLException e){
         System.out.println("출력오류");
      }
   }

   void showQuestionMid() {

      try{
      
         Connection con = null;
         con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
         
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "select * from testmid";
      
         
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();

         while(rs.next()){
            i++;
            index = rs.getString("index");
            problem = rs.getString(2);
            answer = rs.getString(3);
            explain = rs.getString(4);
         
            int qnum = Integer.parseInt(index);
         
            arr[qnum][0] = index;
            arr[qnum][1] = problem;
            arr[qnum][2] = answer;
            arr[qnum][3] = explain;
         
            System.out.println(arr[qnum][0] + ". " + arr[qnum][1]);
            System.out.println(arr[qnum][2] + "\n" + arr[qnum][3]);
            if(i==10){
               break;
            }
         }
      }catch(SQLException e){
         System.out.println("출력오류");
      }
   }

   void showQuestionLow() {

      try{
         
         Connection con = null;
         con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false","root","thrhd");
         
         PreparedStatement ps = null;
         ResultSet rs = null;
         String sql = "select * from testlow";
      
         
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();

         while(rs.next()){
            i++;
            index = rs.getString("index");
            problem = rs.getString(2);
            answer = rs.getString(3);
            explain = rs.getString(4);
         
            int qnum = Integer.parseInt(index);
         
            arr[qnum][0] = index;
            arr[qnum][1] = problem;
            arr[qnum][2] = answer;
            arr[qnum][3] = explain;
         
            System.out.println(arr[qnum][0] + ". " + arr[qnum][1]);
            System.out.println(arr[qnum][2] + "\n" + arr[qnum][3]);
            if(i==10){
               break;
            }
         }
      }catch(SQLException e){
         System.out.println("출력오류");
      }
   }
}


public class JDBCTest {
   public static void main(String[] args){
      
      connectDatabase Database_connect = new connectDatabase();
      Database_connect.connect();
      
      ranking Database_ranking = new ranking();
      question Database_showquestion = new question();
      
      Database_ranking.addRanking();
      Database_ranking.showRankingHigh();
      Database_ranking.showRankingMid();
      Database_ranking.showRankingLow();
      Database_showquestion.showQuestionLow();
   }
}