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
         System.out.println("��¿���");
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
         System.out.println("��¿���");
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
         System.out.println("��¿���");
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