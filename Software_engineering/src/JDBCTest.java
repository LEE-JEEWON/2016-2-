
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javazoom.jl.decoder.*;
import javazoom.jl.player.*;

import java.sql.*;
import java.util.Random;

class StartScreen1 extends JFrame {
	JPanel panel;

	public StartScreen1() {

		setTitle("Magician Of Code");
		setBounds(137, 35, 870, 570);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\first.png");
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		panel.setLayout(null);

		getContentPane().add(panel, BorderLayout.CENTER);

		Runnable run = new StartScreenFlash(this);
		Thread thread = new Thread(run);
		thread.start();
	}
}

class StartScreenFlash implements Runnable {
	   StartScreen1 startScreen1;
	   String path;

	   public StartScreenFlash(StartScreen1 startScreen1) {
	      this.startScreen1 = startScreen1;
	      path = "C:\\photoshop\\bgm.mp3";
	   }

	   public void run() {
	      try {
	         Thread.sleep(2000);
	         startScreen1.setVisible(false);
	         StartScreen2 startScreen2 = new StartScreen2();
	         startScreen2.setVisible(true);
	         try
	         {
	            do{
	               Player p = new Player(new FileInputStream(path));
	               p.play();
	               p.close();
	               }
	            while(true);
	         }
	         catch(Exception e)
	         {
	            e.printStackTrace();
	         }
	      } catch (InterruptedException e) {
	         e.printStackTrace();
	      }
	   }
	}

class StartScreen2 extends JFrame {
	JPanel panel;

	JButton jButton1, jButton2, jButton3;

	public StartScreen2() {

		setTitle("Magician Of Code");
		setBounds(125, 30, 870, 570);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\startscreen.png");
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setLayout(null);
		makeComponent();
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public void makeComponent() {

		jButton1 = new JButton();
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\start.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(390, 190, 140, 52);
		ActionListener listener1 = new StartButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setIcon(new ImageIcon("C:\\photoshop\\ranking.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(390, 250, 140, 52);
		ActionListener listener2 = new RankingButton(this, 2);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setIcon(new ImageIcon("C:\\photoshop\\end.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(390, 310, 140, 52);
		ActionListener listener3 = new EndButton();
		jButton3.addActionListener(listener3);
		panel.add(jButton3);
	}
}

class StartButton implements ActionListener {
	StartScreen2 StartScreen2;

	public StartButton(StartScreen2 StartScreen2) {
		this.StartScreen2 = StartScreen2;
	}

	public void actionPerformed(ActionEvent e) {
		StartScreen2.setVisible(false);
		TutorialScreen tutorialScreen = new TutorialScreen();
		tutorialScreen.setVisible(true);
	}
}

class EndButton extends JFrame implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}

class TutorialScreen extends JFrame {
	JPanel panel;

	PointChecker pointChecker = new PointChecker(this);
	JLabel jLabel1, jLabel2, jLabel3, jLabel4;
	JLabel image3;

	ImageIcon icon3;

	JTextArea jTextArea1, jTextArea2;

	JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7;
	JButton[] exButton = new JButton[12];
	JButton[] life = new JButton[3];

	QueParser Que;
	PointChecker Point;
	String exam[];

	ImageIcon textIcon;
	Image textImg;

	ActionListener listener;
	ActionListener listener1;
	ActionListener listener2;

	int exButtonCount = 0;

	public TutorialScreen() {

		setTitle("Magician Of Code");
		setBounds(125, 30, 870, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\tutorial.png");
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setLayout(null);

		icon3 = new ImageIcon("C:\\photoshop\\Done1.png");
		image3 = new JLabel(icon3);
		image3.setBounds(400, 300, icon3.getIconWidth(), icon3.getIconHeight());
		image3.setVisible(false);
		panel.add(image3);

		exam = new String[3];

		makeComponent();
		setExButton();
		getContentPane().add(panel, BorderLayout.CENTER);

		Runnable run = new Time(jLabel1, jLabel2);
		Thread thread = new Thread(run);
		thread.start();
	}

	public void makeComponent() {
		textIcon = new ImageIcon("C:\\photoshop\\tutorial1.jpg");
		textImg = textIcon.getImage();
		jTextArea1 = new JTextArea() {
			public void paintComponent(Graphics g) {
				g.drawImage(textImg, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		};
		jTextArea1.setText(
				"\n\n\n Hello, World!를 출력하기 위해 다음 코드를 완성하시오." + " \n\n\n #include <stdio.h> " + "\n\nint main() { "
						+ "\n          (          )(\"Hello, World!\");" + "\n          return 0;" + "\n}");
		jTextArea1.setFont(new Font("Dialog.plain", 0, 12));
		jTextArea1.setBackground(new Color(255, 255, 255, 178));
		jTextArea1.setBorder(null);
		jTextArea1.setBounds(75, 59, 323, 454);
		jTextArea1.setFocusable(false);
		panel.add(jTextArea1);

		jTextArea2 = new JTextArea();
		jTextArea2.setText("안녕? 나는 도로시야\n코드의 마법사를 찾으러 왔구나!");
		jTextArea2.setFont(new Font("맑은고딕", Font.BOLD, 35));
		jTextArea2.setOpaque(false);
		jTextArea2.setBorder(null);
		jTextArea2.setBounds(190, 530, 680, 90);
		panel.add(jTextArea2);

		jLabel1 = new JLabel(); // 시간 초 단위
		jLabel1.setText("00");
		jLabel1.setFont(new Font("맑은고딕", Font.BOLD, 20));
		jLabel1.setBounds(635, 19, 30, 20);
		panel.add(jLabel1);

		jLabel2 = new JLabel(); // 시간 분 단위
		jLabel2.setText("00");
		jLabel2.setFont(new Font("맑은고딕", Font.BOLD, 20));
		jLabel2.setBounds(595, 19, 30, 20);
		panel.add(jLabel2);

		jLabel3 = new JLabel();
		jLabel3.setText(":");
		jLabel3.setFont(new Font("맑은고딕", Font.BOLD, 20));
		jLabel3.setBounds(623, 18, 10, 21);
		panel.add(jLabel3);

		jLabel4 = new JLabel();
		jLabel4.setText(String.valueOf(pointChecker.GetTotalScore()));
		jLabel4.setFont(new Font("맑은고딕", Font.BOLD, 30));
		jLabel4.setBounds(480, 18, 100, 30);
		panel.add(jLabel4);

		for (int i = 0; i < 12; i++) {
			exButton[i] = new JButton();
			exButton[i].setText("보기" + (i + 1));
			exButton[i].setFont(new Font("Dialog.plain", 0, 12));
			exButton[i].setBackground(new Color(255, 255, 255, 250));
			listener = new ExButtonMoving(this, i, exam);
			exButton[i].addActionListener(listener);
			panel.add(exButton[i]);
		}

		jButton1 = new JButton();
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\reset.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(610, 470, 102, 40);
		listener1 = new ResetButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setIcon(new ImageIcon("C:\\photoshop\\check.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(728, 470, 100, 40);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setIcon(new ImageIcon("C:\\photoshop\\hint.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(728, 310, 102, 40);
		panel.add(jButton3);

		jButton4 = new JButton();
		jButton4.setIcon(new ImageIcon("C:\\photoshop\\pass.png"));
		jButton4.setBackground(Color.WHITE);
		jButton4.setOpaque(false);
		jButton4.setBorderPainted(false);
		jButton4.setBounds(728, 356, 102, 40);
		panel.add(jButton4);

		jButton5 = new JButton();
		jButton5.setIcon(new ImageIcon("C:\\photoshop\\skip.png"));
		jButton5.setBackground(Color.WHITE);
		jButton5.setOpaque(false);
		jButton5.setBorderPainted(false);
		jButton5.setBounds(5, 8, 87, 37);
		ActionListener listener5 = new SkipButton(this);
		jButton5.addActionListener(listener5);
		panel.add(jButton5);

		jButton6 = new JButton();
		jButton6.setIcon(new ImageIcon("C:\\photoshop\\화살표.png"));
		jButton6.setBackground(Color.WHITE);
		jButton6.setOpaque(false);
		jButton6.setBorderPainted(false);
		jButton6.setBounds(800, 600, 52, 53);
		ActionListener listener6 = new NextButton(this, 0);
		jButton6.addActionListener(listener6);
		panel.add(jButton6);

		jButton7 = new JButton();
		jButton7.setIcon(new ImageIcon("C:\\photoshop\\밑화살표.png"));
		jButton7.setBackground(Color.WHITE);
		jButton7.setOpaque(false);
		jButton7.setBorderPainted(false);
		jButton7.setBounds(440, 83, 77, 71);
		jButton7.setVisible(false);
		panel.add(jButton7);

		for (int i = 0; i < 3; i++) {
			life[i] = new JButton();
			life[i].setFont(new Font("Dialog.plain", 0, 12));
			life[i].setIcon(new ImageIcon("C:\\photoshop\\life.png"));
			life[i].setBackground(Color.WHITE);
			life[i].setOpaque(false);
			life[i].setBorderPainted(false);
			switch (i) {
			case 0:
				life[i].setBounds(690, 10, 40, 34);
				break;
			case 1:
				life[i].setBounds(740, 10, 40, 34);
				break;
			case 2:
				life[i].setBounds(790, 10, 40, 34);
				break;
			}
			panel.add(life[i]);
		}
	}

	public void setExButton() {
		exButton[0].setBounds(407, 150, 134, 56);
		exButton[1].setBounds(552, 150, 134, 56);
		exButton[2].setBounds(697, 150, 134, 56);
		exButton[0].setText("printf");
		exButton[1].setText("scanf");
		exButton[2].setText("for");
	}
}

class NextButton implements ActionListener {
	TutorialScreen tutorialScreen;
	int num = 0;

	public NextButton(TutorialScreen tutorialScreen, int num) {
		this.tutorialScreen = tutorialScreen;
		this.num = num;
	}

	public void actionPerformed(ActionEvent e) {
		switch (num++) {
		case 0:
			tutorialScreen.jTextArea2.setText("게임 방법을 설명해줄게!\n따라 해봐!!");
			break;
		case 1:
			tutorialScreen.jTextArea2.setText("문제와 보기가 보이니??\n문제를 읽고 보기를 클릭해봐!");
			tutorialScreen.jButton7.setVisible(true);
			break;
		case 2:
			tutorialScreen.jButton7.setBounds(540, 455, 77, 71);
			tutorialScreen.jButton7.setIcon(new ImageIcon("C:\\photoshop\\우화살표.png"));
			tutorialScreen.jTextArea2.setText("선택한 보기의 위치가 변했지!?\nRESET버튼을 클릭해봐!");
			break;
		case 3:
			tutorialScreen.jButton7.setVisible(false);
			tutorialScreen.jTextArea2.setText("보기가 원래대로 돌아왔지!?");
			break;
		case 4:
			tutorialScreen.jTextArea2.setText("HINT버튼은 문제를 풀다가 \n정답 하나를 알고 싶을 때 쓰는 버튼이야!");
			tutorialScreen.jButton7.setBounds(672, 290, 77, 71);
			tutorialScreen.jButton7.setVisible(true);
			break;
		case 5:
			tutorialScreen.jButton7.setBounds(672, 340, 77, 71);
			tutorialScreen.jTextArea2.setText("PASS버튼은 문제를 풀다가 이 문제를\n넘어가고 싶을 때 쓰는 버튼이야!");
			break;
		case 6:
			tutorialScreen.jButton7.setVisible(false);
			tutorialScreen.jTextArea2.setText("그럼 이제 답을 골라보렴!");
			break;
		case 7:
			tutorialScreen.jButton7.setBounds(745, 400, 77, 71);
			tutorialScreen.jButton7.setIcon(new ImageIcon("C:\\photoshop\\밑화살표.png"));
			tutorialScreen.jButton7.setVisible(true);
			tutorialScreen.jTextArea2.setText("prinf를 골랐지?? \nCHECK 버튼으로 답을 확인할 수 있어!");
			break;
		case 8:
			tutorialScreen.jButton7.setVisible(false);
			tutorialScreen.jTextArea2.setText("내 설명은 여기까지야 \n화살표버튼을 눌러 다음으로 넘어가!");
			break;
		case 9:
			tutorialScreen.setVisible(false);
			LevelChoiceScreen1 levelChoiceScreen1 = new LevelChoiceScreen1();
			levelChoiceScreen1.setVisible(true);
		}
	}
}

class Time implements Runnable {
	JLabel jLabel1, jLabel2;
	int minute, second;
	String min, sec;

	public Time(JLabel jLabel1, JLabel jLabel2) {
		this.jLabel1 = jLabel1;
		this.jLabel2 = jLabel2;
	}

	public void run() {
		try {
			for (;;) {
				second = Integer.parseInt(jLabel1.getText());
				minute = Integer.parseInt(jLabel2.getText());
				Thread.sleep(1000);
				second++;
				if (second >= 60) {
					second = 0;
					minute++;
				}
				if (second < 10)
					sec = String.valueOf("0" + second);
				else
					sec = String.valueOf(second);

				if (minute < 10)
					min = String.valueOf("0" + minute);
				else
					min = String.valueOf(minute);

				jLabel1.setText(sec);
				jLabel2.setText(min);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ExButtonMoving implements ActionListener {
	TutorialScreen tutorialScreen;
	int i;
	String exam[];

	public ExButtonMoving(TutorialScreen tutorialScreen, int i, String exam[]) {
		this.tutorialScreen = tutorialScreen;
		this.i = i;
		this.exam = exam;

	}

	public void actionPerformed(ActionEvent e) {
		tutorialScreen.image3.setVisible(false);
		if (tutorialScreen.exButton[i].getY() != 405) {
			switch (tutorialScreen.exButtonCount) {
			case 0:
				tutorialScreen.exButton[i].setBounds(407, 405, tutorialScreen.exButton[i].getWidth(),
						tutorialScreen.exButton[i].getHeight());
				exam[0] = tutorialScreen.exButton[i].getText();
				break;
			case 1:
				tutorialScreen.exButton[i].setBounds(551, 405, tutorialScreen.exButton[i].getWidth(),
						tutorialScreen.exButton[i].getHeight());
				exam[1] = tutorialScreen.exButton[i].getText();
				break;
			case 2:
				tutorialScreen.exButton[i].setBounds(697, 405, tutorialScreen.exButton[i].getWidth(),
						tutorialScreen.exButton[i].getHeight());
				exam[2] = tutorialScreen.exButton[i].getText();
				break;
			}
			tutorialScreen.exButtonCount++;
		}
	}
}

class ResetButton implements ActionListener {
	TutorialScreen tutorialScreen;

	public ResetButton(TutorialScreen tutorialScreen) {
		this.tutorialScreen = tutorialScreen;
	}

	public void actionPerformed(ActionEvent e) {
		tutorialScreen.image3.setVisible(false);
		tutorialScreen.setExButton();
		tutorialScreen.exButtonCount = 0;
	}
}

class ReturnButton implements ActionListener {
	TutorialScreen tutorialScreen;
	FinalScreen finalScreen;
	int num = 2;

	public ReturnButton(TutorialScreen tutorialScreen, int num) {
		this.tutorialScreen = tutorialScreen;
		this.num = num;
	}

	public ReturnButton(FinalScreen finalScreen, int num) {
		this.finalScreen = finalScreen;
		this.num = num;
	}

	public void actionPerformed(ActionEvent e) {
		if (num == 0)
			finalScreen.setVisible(false);
		else
			tutorialScreen.setVisible(false);
		StartScreen2 startScreen2 = new StartScreen2();
		startScreen2.setVisible(true);
	}
}

class SkipButton implements ActionListener {
	TutorialScreen tutorialScreen;

	public SkipButton(TutorialScreen tutorialScreen) {
		this.tutorialScreen = tutorialScreen;
	}

	public void actionPerformed(ActionEvent e) {
		tutorialScreen.setVisible(false);
		LevelChoiceScreen1 levelChoiceScreen1 = new LevelChoiceScreen1();
		levelChoiceScreen1.setVisible(true);
	}
}

class LevelChoiceScreen1 extends JFrame {
	JPanel panel;

	JButton jButton1, jButton2, jButton3;

	public LevelChoiceScreen1() {

		setTitle("Magician Of Code");
		setBounds(125, 30, 870, 570);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\level.png");
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setLayout(null);

		makeComponent();
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public void makeComponent() {
		jButton1 = new JButton();
		jButton1.setFont(new Font("Dialog.plain", 0, 12));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(60, 270, 170, 200);
		ActionListener listener1 = new LevelChoiceButton(this, 1);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setFont(new Font("Dialog.plain", 0, 12));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(345, 270, 170, 200);
		ActionListener listener2 = new LevelChoiceButton(this, 2);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setFont(new Font("Dialog.plain", 0, 12));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setForeground(new Color(-13421773));
		jButton3.setBounds(610, 270, 170, 200);
		ActionListener listener3 = new LevelChoiceButton(this, 3);
		jButton3.addActionListener(listener3);
		panel.add(jButton3);
	}
}

class LevelChoiceButton implements ActionListener {
	LevelChoiceScreen1 levelChoiceScreen1;
	int level = 0;
	QueParser Que;
	Blind HighQue;

	public LevelChoiceButton(LevelChoiceScreen1 levelChoiceScreen1, int level) {
		this.levelChoiceScreen1 = levelChoiceScreen1;
		this.level = level;
	}

	public void actionPerformed(ActionEvent e) {
		switch (level) {
		case 1:
			Que = new QueParser(1);
			levelChoiceScreen1.setVisible(false);
			LevelLowScreen levelLowScreen = new LevelLowScreen();
			levelLowScreen.setQue(Que);
			levelLowScreen.showQuestion();
			levelLowScreen.setVisible(true);
			break;
		case 2:
			Que = new QueParser(2);
			levelChoiceScreen1.setVisible(false);
			LevelMiddleScreen levelMiddleScreen = new LevelMiddleScreen();
			levelMiddleScreen.setQue(Que);
			levelMiddleScreen.showQuestion();
			levelMiddleScreen.setVisible(true);
			break;
		case 3:
			HighQue = new Blind();
			levelChoiceScreen1.setVisible(false);
			LevelHighScreen levelHighScreen = new LevelHighScreen();
			levelHighScreen.setQue(HighQue);
			levelHighScreen.showQuestion();
			levelHighScreen.setVisible(true);
			break;
		}
	}
}

class LevelLowScreen extends TutorialScreen {
	int[] wrongQueNum = new int[6];
	int wrongNum = 0;

	String level = "하";

	int remainHintCount = 3;
	int remainPassCount = 3;
	int remainLifeCount = 3;
	int bonusCount = 1;
	boolean isBonus = false;

	JScrollPane jScrollPane;

	JLabel image, bonusImage;
	int QueNum;

	JLabel image1;
	JLabel image2;

	boolean ready = true;

	int[] ansNum = new int[3];
	int questionNum = 1;
	int count = 1;

	int timerCount = 0;
	JButton[] restTime = new JButton[16];
	ActionListener listener3, listener4;

	public void setQue(QueParser Que) {
		this.Que = Que;
		jButton2.removeActionListener(listener2);
		ActionListener listener2 = new CheckButton(this, Que, Point, exam, false);
		jButton2.addActionListener(listener2);
		jButton2.addActionListener(listener1);
	}

	public LevelLowScreen() {

		ImageIcon icon1 = new ImageIcon("C:\\photoshop\\Done.png");
		image1 = new JLabel(icon1);
		image1.setBounds(400, 300, icon1.getIconWidth(), icon1.getIconHeight());
		image1.setVisible(false);
		panel.add(image1);

		ImageIcon icon2 = new ImageIcon("C:\\photoshop\\Wrong.png");
		image2 = new JLabel(icon2);
		image2.setBounds(400, 300, icon2.getIconWidth(), icon2.getIconHeight());
		image2.setVisible(false);
		panel.add(image2);

		setBounds(125, 30, 870, 570);

		panel.remove(jTextArea1);
		textIcon = new ImageIcon("C:\\photoshop\\game11.jpg");
		textImg = textIcon.getImage();
		jTextArea1 = new JTextArea() {
			public void paintComponent(Graphics g) {
				g.drawImage(textImg, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		};
		jTextArea1.setText(" ");
		jTextArea1.setFont(new Font("Dialog.plain", 0, 12));
		jTextArea1.setBackground(new Color(255, 255, 255, 178));
		jTextArea1.setBorder(null);
		jTextArea1.setBounds(75, 59, 323, 454);
		jTextArea1.setLineWrap(true);
		jTextArea1.setFocusable(false);
		jScrollPane = new JScrollPane(jTextArea1);
		jScrollPane.setBounds(75, 59, 323, 454);
		jScrollPane.setBorder(null);
		panel.add(jScrollPane);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\game1.png");
		image = new JLabel(icon);
		image.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		panel.add(image);

		makeComponent2();
		setExButton();
	}

	public void makeComponent2() {

		listener3 = new HintButton(this, Que, Point);
		jButton3.addActionListener(listener3);

		listener4 = new PassButton(this, Que, Point);
		jButton4.addActionListener(listener4);
		jButton4.addActionListener(listener1);

		jButton5.setVisible(false);
		jButton6.setVisible(false);
	}

	public void setExButton() {
		exButton[0].setBounds(407, 60, 134, 56);
		exButton[1].setBounds(552, 60, 134, 56);
		exButton[2].setBounds(697, 60, 134, 56);
		exButton[3].setBounds(407, 120, 134, 56);
		exButton[4].setBounds(552, 120, 134, 56);
		exButton[5].setBounds(697, 120, 134, 56);
		exButton[6].setBounds(407, 180, 134, 56);
		exButton[7].setBounds(552, 180, 134, 56);
		exButton[8].setBounds(697, 180, 134, 56);
		exButton[9].setBounds(407, 240, 134, 56);
		exButton[10].setBounds(552, 240, 134, 56);
		exButton[11].setBounds(697, 240, 134, 56);
	}

	public void nextQuestion() {
		questionNum++;
		if (questionNum <= 10) {
			Que.QueProvider();
			showQuestion();
		}
	}

	public void showQuestion() {

		int arr[] = new int[12];
		Random rdd = new Random();
		boolean overwrap = false;

		for (int i = 0; i < 12; i++)
			arr[i] = i;

		for (int i = 0; i < 12; i++) {
			int des = rdd.nextInt(12);
			int temp = arr[i];
			arr[i] = arr[des];
			arr[des] = temp;
		}

		for (int i = 0; i < 3; i++) {
			exButton[arr[i]].setText((Que.Answer[i]));
			ansNum[i] = arr[i];
		}
		for (int i = 3; i < 12; i++) {
			if (i >= Que.count || Que.ex.size() == 0) {
				exButton[arr[i]].setText("보너스");
				continue;
			}

			int num = rdd.nextInt(Que.ex.size());
			if (Que.ex.get(num).equals(" ") || Que.ex.get(num).equals("") || Que.ex.get(num).equals("\n")
					|| Que.ex.get(num).equals("}") || Que.ex.get(num).equals("{") || Que.ex.get(num).equals("\n{")
					|| Que.ex.get(num).equals("\n}") || Que.ex.get(num).equals("\n\n")) {
				Que.ex.remove(num);
				i--;
				continue;
			}
			

			for (int j = 0; j < 12; j++) {
				if (Que.ex.get(num).equals(exButton[j].getText())) {
					Que.ex.remove(num);
					i--;
					overwrap = true;
					break;
				}
			}
			
			if (overwrap == true) {
				continue;
			}
			
			overwrap = false;
			exButton[arr[i]].setText((Que.ex.get(num)));
			Que.ex.remove(num);
		}
		Que.count = 0;

		jTextArea1.setText(" ");
		jTextArea1.append(questionNum + ". " + Que.QueArr[questionNum - 1][1] + "\n");

		for (int k = 0; k < Que.list.size(); k++)
			jTextArea1.append(Que.list.get(k));
	}
}

class HintButton implements ActionListener {
	LevelLowScreen screen;
	QueParser Que;
	PointChecker Point;

	public HintButton(LevelLowScreen screen, QueParser Que, PointChecker Point) {
		this.screen = screen;
		this.Que = Que;
		this.Point = Point;
	}

	public void actionPerformed(ActionEvent e) {
		if (screen.image3.isVisible() == false) {
			if (screen.remainHintCount > 0 && screen.exam[2] != null) {
				JOptionPane.showMessageDialog(null, "답안 작성 완료.");
			} else if (screen.remainHintCount > 0) {
				screen.remainHintCount--; // 힌트 루틴 추가
				switch (screen.exButtonCount) {
				case 0:
					screen.image3.setBounds(screen.exButton[screen.ansNum[0]].getX(),
							screen.exButton[screen.ansNum[0]].getY() - 30, screen.icon3.getIconWidth(),
							screen.icon3.getIconHeight());
					screen.image3.setVisible(true);
					break;
				case 1:
					screen.image3.setBounds(screen.exButton[screen.ansNum[1]].getX(),
							screen.exButton[screen.ansNum[1]].getY() - 30, screen.icon3.getIconWidth(),
							screen.icon3.getIconHeight());
					screen.image3.setVisible(true);
					break;
				case 2:
					screen.image3.setBounds(screen.exButton[screen.ansNum[2]].getX(),
							screen.exButton[screen.ansNum[2]].getY() - 30, screen.icon3.getIconWidth(),
							screen.icon3.getIconHeight());
					screen.image3.setVisible(true);
					break;
				}
				screen.pointChecker.MinusHint();
			} else
				JOptionPane.showMessageDialog(null, "힌트 다 썼어요.");
		}
	}
}

class PassButton implements ActionListener {
	LevelLowScreen screen;
	QueParser Que;
	PointChecker Point;

	public PassButton(LevelLowScreen screen, QueParser Que, PointChecker Point) {
		this.screen = screen;
		this.Que = Que;
		this.Point = Point;
	}

	public void actionPerformed(ActionEvent e) {
		screen.image3.setVisible(false);
		screen.wrongQueNum[screen.wrongNum++] = screen.questionNum - 1;
		if (screen.remainPassCount > 0 && screen.questionNum != 10) {
			screen.remainPassCount--;
			screen.pointChecker.MinusPass();
			screen.nextQuestion();
		} else if (screen.questionNum == 10 && screen.remainPassCount > 0) {
			screen.remainPassCount--;
			screen.pointChecker.MinusPass();
			screen.setVisible(false);
			SuccessScreen successScreen = new SuccessScreen(screen.level,
					screen.jLabel2.getText() + ":" + screen.jLabel1.getText(), screen.remainLifeCount,
					Integer.parseInt(screen.jLabel4.getText()), screen.Que, screen.wrongQueNum);
			successScreen.setVisible(true);
		} else
			JOptionPane.showMessageDialog(null, "패스 다 썼어요.");
	}
}

class CheckButton implements ActionListener {
	LevelLowScreen levelLowScreen;
	PointChecker Point;
	QueParser Que;
	String exam[];
	JLabel image;
	int num = 0;
	boolean right;
	boolean retry = false;

	public CheckButton(LevelLowScreen levelLowScreen, QueParser Que, PointChecker Point, String[] exam, boolean retry) {
		this.levelLowScreen = levelLowScreen;
		this.Que = Que;
		this.Point = Point;
		this.exam = exam;
		this.right = true;
		this.retry = retry;
	}

	public void actionPerformed(ActionEvent e) {
		levelLowScreen.timerCount = 0;
		Timer timer = new Timer(levelLowScreen);
		timer.reset();

		for (int i = 0; i < 3; i++) {
			if (!(exam[i].equals(Que.Answer[i]))) {
				right = false;
			}
		}

		for (int i = 0; i < 3; i++) {
			exam[i] = null;
		}

		if (retry == false) {
			if (right == true) { // 정답을 맞춘 경우
				if (levelLowScreen.questionNum == 10) {
					levelLowScreen.setVisible(false);
					SuccessScreen successScreen = new SuccessScreen(levelLowScreen.level,
							levelLowScreen.jLabel2.getText() + ":" + levelLowScreen.jLabel1.getText(),
							levelLowScreen.remainLifeCount, Integer.parseInt(levelLowScreen.jLabel4.getText()),
							levelLowScreen.Que, levelLowScreen.wrongQueNum);
					successScreen.setVisible(true);
				}
				levelLowScreen.nextQuestion();

				Runnable run = new OX(levelLowScreen, true);
				Thread thread = new Thread(run);
				thread.start();

			} else { // 정답을 맞추지 못한 경우
				levelLowScreen.wrongQueNum[levelLowScreen.wrongNum++] = levelLowScreen.questionNum - 1;
				Life remainLife = new Life(levelLowScreen.life, --levelLowScreen.remainLifeCount);
				remainLife.lifeReduce();
				levelLowScreen.pointChecker.MinusLife();
				if (levelLowScreen.remainLifeCount == 0) {
					levelLowScreen.setVisible(false);
					FailScreen failScreen = new FailScreen(levelLowScreen.Que, levelLowScreen.wrongQueNum);
					failScreen.setVisible(true);
				}
				if (levelLowScreen.questionNum == 10) {
					levelLowScreen.setVisible(false);
					SuccessScreen successScreen = new SuccessScreen(levelLowScreen.level,
							levelLowScreen.jLabel2.getText() + ":" + levelLowScreen.jLabel1.getText(),
							levelLowScreen.remainLifeCount, Integer.parseInt(levelLowScreen.jLabel4.getText()),
							levelLowScreen.Que, levelLowScreen.wrongQueNum);
					successScreen.setVisible(true);
				}
				right = true;
				levelLowScreen.nextQuestion();

				Runnable run = new OX(levelLowScreen, false);
				Thread thread = new Thread(run);
				thread.start();
			}
		} else {
			if (right == true) {
				Runnable run = new OX(levelLowScreen, true);
				Thread thread = new Thread(run);
				thread.start();
			} else {
				Runnable run = new OX(levelLowScreen, false);
				Thread thread = new Thread(run);
				thread.start();
			}
			levelLowScreen.nextQuestion();
		}
	}
}

class OX implements Runnable {
	LevelLowScreen levelLowScreen;
	boolean right;

	public OX(LevelLowScreen levelLowScreen, boolean right) {
		this.levelLowScreen = levelLowScreen;
		this.right = right;
	}

	public void run() {
		if (right) {
			try {
				levelLowScreen.image1.setVisible(true);
				Thread.sleep(2000);
				levelLowScreen.image1.setVisible(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				levelLowScreen.image2.setVisible(true);
				Thread.sleep(2000);
				levelLowScreen.image2.setVisible(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Life {
	JButton[] life;
	int count;

	public Life(JButton[] life, int count) {
		this.life = life;
		this.count = count;
	}

	public void lifeReduce() {
		life[count].setIcon(new ImageIcon("C:\\photoshop\\lifex.png"));
	}

	public void lifeIncrease() {
		life[count].setIcon(new ImageIcon("C:\\photoshop\\life.png"));
	}
}

class LevelMiddleScreen extends LevelLowScreen {

	public LevelMiddleScreen() {
		level = "중";

		setBounds(125, 30, 870, 570);

		panel.remove(jScrollPane);
		textIcon = new ImageIcon("C:\\photoshop\\game22.jpg");
		textImg = textIcon.getImage();
		jTextArea1 = new JTextArea() {
			public void paintComponent(Graphics g) {
				g.drawImage(textImg, 0, -1, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		};
		jTextArea1.setText(" ");
		jTextArea1.setFont(new Font("Dialog.plain", 0, 12));
		jTextArea1.setBackground(new Color(255, 255, 255, 178));
		jTextArea1.setBorder(null);
		jTextArea1.setBounds(75, 59, 323, 454);
		jTextArea1.setLineWrap(true);
		jTextArea1.setFocusable(false);
		jScrollPane = new JScrollPane(jTextArea1);
		jScrollPane.setBounds(75, 59, 323, 454);
		jScrollPane.setBorder(null);
		panel.add(jScrollPane);

		makeComponent3();

		panel.remove(image);
		ImageIcon icon = new ImageIcon("C:\\photoshop\\game2.png");

		image = new JLabel(icon);
		image.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		panel.add(image);

		Runnable run = new Timer(this);
		Thread thread = new Thread(run);
		thread.start();
	}

	public void makeComponent3() {

		int interval = 110; // 타이머 버튼 간격
		for (int i = 0; i < 16; i++) {
			restTime[i] = new JButton();
			restTime[i].setBackground(Color.WHITE);
			restTime[i].setOpaque(false);
			restTime[i].setBorderPainted(false);

			if (i < 8)
				restTime[i].setIcon(new ImageIcon("C:\\photoshop\\노란박스.png"));
			else
				restTime[i].setIcon(new ImageIcon("C:\\photoshop\\빨간박스.png"));

			restTime[i].setBounds(20, interval, 49, 28);
			panel.add(restTime[i]);
			interval += 25;
		}
	}

}

class Timer implements Runnable {
	LevelLowScreen levelLowScreen;

	public Timer(LevelLowScreen levelLowScreen) {
		this.levelLowScreen = levelLowScreen;
	}

	public void reset() {
		for (int j = 0; j < 16 && levelLowScreen.restTime[j] != null; j++) {
			if (j < 8)
				levelLowScreen.restTime[j].setIcon(new ImageIcon("C:\\photoshop\\노란박스.png"));
			else
				levelLowScreen.restTime[j].setIcon(new ImageIcon("C:\\photoshop\\빨간박스.png"));
		}
	}

	public void run() {
		long startTime = System.currentTimeMillis();
		long endTime = 0;

		for (;;) {
			endTime = System.currentTimeMillis();
			if (endTime - startTime > 3000) {
				levelLowScreen.restTime[levelLowScreen.timerCount++].setIcon(new ImageIcon("C:\\photoshop\\회색박스.png"));
				startTime = System.currentTimeMillis();
			}

			if (levelLowScreen.timerCount > 15) {
				levelLowScreen.timerCount = 0;
				reset();
				Life remainLife = new Life(levelLowScreen.life, --levelLowScreen.remainLifeCount);
				remainLife.lifeReduce();
				levelLowScreen.pointChecker.MinusLife();
				if (levelLowScreen.remainLifeCount == 0) {
					levelLowScreen.setVisible(false);
					FailScreen failScreen = new FailScreen(levelLowScreen.Que, levelLowScreen.wrongQueNum);
					failScreen.setVisible(true);
				}
				if (levelLowScreen.questionNum == 10) {
					levelLowScreen.setVisible(false);
					SuccessScreen successScreen = new SuccessScreen(levelLowScreen.level,
							levelLowScreen.jLabel1.getText() + ":" + levelLowScreen.jLabel2.getText(),
							levelLowScreen.remainLifeCount, Integer.parseInt(levelLowScreen.jLabel4.getText()),
							levelLowScreen.Que, levelLowScreen.wrongQueNum);
					successScreen.setVisible(true);
					break;
				}
				levelLowScreen.nextQuestion();
			}
		}
	}
}

class LevelHighScreen extends LevelMiddleScreen { // 가리기 구현할 부분

	Blind Bin;

	public LevelHighScreen() {
		level = "상";

		panel.remove(jScrollPane);
		textIcon = new ImageIcon("C:\\photoshop\\game33.jpg");
		textImg = textIcon.getImage();
		jTextArea1 = new JTextArea() {
			public void paintComponent(Graphics g) {
				g.drawImage(textImg, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		};
		jTextArea1.setText(" ");
		jTextArea1.setFont(new Font("Dialog.plain", 0, 12));
		jTextArea1.setBackground(new Color(255, 255, 255, 178));
		jTextArea1.setBorder(null);
		jTextArea1.setBounds(75, 59, 323, 454);
		jTextArea1.setLineWrap(true);
		jTextArea1.setFocusable(false);
		jScrollPane = new JScrollPane(jTextArea1);
		jScrollPane.setBounds(75, 59, 323, 454);
		jScrollPane.setBorder(null);
		panel.add(jScrollPane);

		panel.remove(image);
		ImageIcon icon = new ImageIcon("C:\\photoshop\\game3.png"); // 넣을 그림

		JLabel image = new JLabel(icon);
		image.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		panel.add(image);

		makeComponent4(Bin);
	}

	public void makeComponent4(Blind Bin) {

	}
}

class SuccessScreen extends JFrame {
	private static final int White = 0;

	JPanel panel;

	JLabel jLabel1;

	String level, time;
	int life, score;

	public SuccessScreen(String level, String time, int life, int score, QueParser Que, int[] wrongQueNum) {
		this.level = level;
		this.time = time;
		this.life = life;
		this.score = score;

		setTitle("Magician Of Code");
		setBounds(230, 150, 300, 280);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		panel = new JPanel();
		panel.setLayout(null);

		makeComponent();
		getContentPane().add(panel, BorderLayout.CENTER);

		Runnable run = new LastFlash(this, level, time, life, score, Que, wrongQueNum);
		Thread thread = new Thread(run);
		thread.start();
	}

	public void makeComponent() {
		jLabel1 = new JLabel();
		jLabel1.setFont(new Font("Dialog.plain", 0, 36));
		jLabel1.setIcon(new ImageIcon("C:\\photoshop\\success.png"));
		jLabel1.setBackground(new Color(White));
		jLabel1.setBounds(0, 0, 300, 240);
		panel.add(jLabel1);
	}
}

class FailScreen extends JFrame {

	JPanel panel;

	JLabel jLabel1;

	public FailScreen(QueParser Que, int[] wrongQueNum) {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		setResizable(false);

		setTitle("Magician Of Code");
		setBounds(230, 150, 300, 280);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);

		makeComponent();
		getContentPane().add(panel, BorderLayout.CENTER);

		Runnable run = new LastFlash(this, Que, wrongQueNum);
		Thread thread = new Thread(run);
		thread.start();
	}

	public void makeComponent() {
		jLabel1 = new JLabel();
		jLabel1.setFont(new Font("Dialog.plain", 0, 36));
		jLabel1.setIcon(new ImageIcon("C:\\photoshop\\fail.png"));
		jLabel1.setForeground(new Color(-13421773));
		jLabel1.setBackground(new Color(-1118482));
		jLabel1.setBounds(0, 0, 300, 240);
		panel.add(jLabel1);
	}
}

class LastFlash implements Runnable {
	SuccessScreen successScreen;
	FailScreen failScreen;
	String level, time;
	int life, score;
	QueParser Que;
	int[] wrongQueNum;

	public LastFlash(SuccessScreen successScreen, String level, String time, int life, int score, QueParser Que,
			int[] wrongQueNum) {
		this.successScreen = successScreen;
		this.level = level;
		this.time = time;
		this.life = life;
		this.score = score;
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;
	}

	public LastFlash(FailScreen failScreen, QueParser Que, int[] wrongQueNum) {
		this.failScreen = failScreen;
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;
	}

	public void run() {
		try {
			Thread.sleep(2000);
			if (successScreen == null) {
				failScreen.setVisible(false);
				FinalScreen finalScreen = new FinalScreen(Que, wrongQueNum);
				finalScreen.setVisible(true);
			} else {
				successScreen.setVisible(false);
				RankingPopup rankingPopup = new RankingPopup(level, time, life, score, Que, wrongQueNum);
				rankingPopup.setVisible(true);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class RankingPopup extends JFrame {
	JPanel panel;

	JTextField jTextField1;
	JButton jButton1;

	String level, time;
	int life, score;
	QueParser Que;
	int[] wrongQueNum;

	public RankingPopup(String level, String time, int life, int score, QueParser Que, int[] wrongQueNum) {
		this.level = level;
		this.time = time;
		this.life = life;
		this.score = score;
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;

		setTitle("Magician Of Code");
		setBounds(235, 174, 430, 315);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\rankingP.png");
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setLayout(null);

		makeComponent();
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public void makeComponent() {

		jTextField1 = new JTextField();
		jTextField1.setFont(new Font("Dialog.plain", 0, 12));
		jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		jTextField1.setForeground(new Color(-13421773));
		jTextField1.setBackground(new Color(-1));
		jTextField1.setBounds(150, 177, 132, 25);
		panel.add(jTextField1);

		jButton1 = new JButton();
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\ok.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(180, 215, 80, 33);
		ActionListener listener1 = new RankingRegisterButton(this, level, time, life, score, Que, wrongQueNum);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);
	}
}

class RankingRegisterButton implements ActionListener {
	RankingPopup rankingPopup;
	String level, name, time;
	int life, score;
	QueParser Que;
	int[] wrongQueNum;
	ranking ranking = new ranking();

	public RankingRegisterButton(RankingPopup rankingPopup, String level, String time, int life, int score,
			QueParser Que, int[] wrongQueNum) {
		this.rankingPopup = rankingPopup;
		this.level = level;
		this.time = time;
		this.life = life;
		this.score = score;
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;
	}

	public void actionPerformed(ActionEvent e) {
		// 디비에 랭킹 등록 --> 문제를 맞춰서 db에 등록시킬 때 필요! 알고리즘 필요..!
		name = rankingPopup.jTextField1.getText();
		if (name.length() > 45) {
			JOptionPane.showMessageDialog(null, "이름이 너무 길어요!\n다시 입력해주세요\n(45자 이하)");
			return;
		}
		ranking.addRanking(level, name, time, life, score);

		rankingPopup.setVisible(false);
		RankingScreen rankingScreen = new RankingScreen(0, level, Que, wrongQueNum);
		rankingScreen.setVisible(true);

	}
}

class RankingScreen extends JFrame {
	JPanel panel;

	JLabel jLabel1;
	JTextArea jTextArea1;
	JButton jButton1, jButton2, jButton3, jButton4;

	int num = 0;
	int levelNum = 0;
	String level = "";

	QueParser Que;
	int[] wrongQueNum;

	public RankingScreen(int num, String level, QueParser Que, int[] wrongQueNum) {
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;
		this.num = num;
		switch (level) {
		case "상":
			levelNum = 1;
			break;
		case "중":
			levelNum = 2;
			break;
		case "하":
			levelNum = 3;
			break;
		}

		setTitle("Magician Of Code");
		setBounds(141, 33, 527, 585);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\rankingS.png");
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setLayout(null);

		makeComponent();
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public void makeComponent() {

		jTextArea1 = new JTextArea();
		jTextArea1.setText("");
		jTextArea1.setFont(new Font("Dialog.plain", 0, 12));
		jTextArea1.setBounds(39, 114, 442, 369);
		panel.add(jTextArea1);
		RankingPrint rankingPrint = new RankingPrint(this, levelNum);
		rankingPrint.actionPerformed(null);

		jButton1 = new JButton();
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\랭킹나가기.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(395, 485, 102, 37);
		ActionListener listener1 = new FinalScreenButton(this, num, Que, wrongQueNum);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setIcon(new ImageIcon("C:\\photoshop\\랭킹상.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(332, 80, 50, 35);
		ActionListener listener2 = new RankingPrint(this, 1);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setIcon(new ImageIcon("C:\\photoshop\\랭킹중.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(381, 80, 50, 35);
		ActionListener listener3 = new RankingPrint(this, 2);
		jButton3.addActionListener(listener3);
		panel.add(jButton3);

		jButton4 = new JButton();
		jButton4.setIcon(new ImageIcon("C:\\photoshop\\랭킹하.png"));
		jButton4.setBackground(Color.WHITE);
		jButton4.setOpaque(false);
		jButton4.setBorderPainted(false);
		jButton4.setBounds(430, 80, 50, 35);
		ActionListener listener4 = new RankingPrint(this, 3);
		jButton4.addActionListener(listener4);
		panel.add(jButton4);
	}
}

class RankingPrint implements ActionListener {

	RankingScreen rankingScreen;
	int num = 0;
	int i = 0;
	ranking Database_ranking = new ranking();

	public RankingPrint(RankingScreen rankingScreen, int num) {
		this.rankingScreen = rankingScreen;
		this.num = num;
	}

	public void actionPerformed(ActionEvent e) {
		switch (num) {
		case 1: // 난이도 상 랭킹 출력
			Database_ranking.showRankingHigh();

			rankingScreen.jTextArea1.setText("\t이  름\t점  수\t시  간\t생  명\n");
			for (i = 0; i < 10; i++) {
				rankingScreen.jTextArea1.append((i + 1) + "등" + "\t" + Database_ranking.highrank[i][1] + "\t"
						+ Database_ranking.highrank[i][2] + "\t" + Database_ranking.highrank[i][3] + "\t"
						+ Database_ranking.highrank[i][4] + "\n");
			}
			break;
		case 2: // 난이도 중 랭킹 출력
			Database_ranking.showRankingMid();

			rankingScreen.jTextArea1.setText("\t이  름\t점  수\t시  간\t생  명\n");
			for (i = 0; i < 10; i++) {
				rankingScreen.jTextArea1.append(
						(i + 1) + "등" + "\t" + Database_ranking.midrank[i][1] + "\t" + Database_ranking.midrank[i][2]
								+ "\t" + Database_ranking.midrank[i][3] + "\t" + Database_ranking.midrank[i][4] + "\n");
			}
			break;
		case 3: // 난이도 하 랭킹 출력
			Database_ranking.showRankingLow();

			rankingScreen.jTextArea1.setText("\t이  름\t점  수\t시  간\t생  명\n");
			for (i = 0; i < 10; i++) {
				rankingScreen.jTextArea1.append(
						(i + 1) + "등" + "\t" + Database_ranking.lowrank[i][1] + "\t" + Database_ranking.lowrank[i][2]
								+ "\t" + Database_ranking.lowrank[i][3] + "\t" + Database_ranking.lowrank[i][4] + "\n");
			}
			break;
		}
	}
}

class connectDatabase {

	void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
		}

		try {
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false",
					"root", "thrhd");

			System.out.println("My-SQL 접속성공");
			con.close();
		} catch (SQLException e) {
			System.out.println("My-SQL 접속실패");
		}
	}
}

class ranking {
	String[][] highrank = new String[10][5];
	String[][] midrank = new String[10][5];
	String[][] lowrank = new String[10][5];

	void addRanking(String level, String name, String time, int life, int score) {

		String sql = "insert into ranking values(?,?,?,?,?)";

		try {

			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false",
					"root", "thrhd");

			PreparedStatement ps = null;

			ps = con.prepareStatement(sql);
			ps.setString(1, level);
			ps.setString(2, name);
			ps.setInt(3, score);
			ps.setString(4, time);
			ps.setInt(5, life);

			int n = ps.executeUpdate();

			if (n > 0) {
				System.out.println("추가 성공");
			} else {
				System.out.println("추가 실패");
			}
		} catch (SQLException e) {
			System.out.println("데이터 추가 에러");
		}
	}

	String[][] showRankingHigh() {

		int i = 0;

		try {

			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false",
					"root", "thrhd");

			PreparedStatement ps = null;
			ResultSet rs = null;

			String sql = "select * from ranking where LEVEL = '상' order by SCORE desc, TIME, LIFE desc";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				highrank[i][0] = rs.getString("LEVEL");
				highrank[i][1] = rs.getString(2);
				highrank[i][2] = rs.getString(3);
				highrank[i][3] = rs.getString(4);
				highrank[i][4] = rs.getString(5);

				i++;

				if (i == 10) {
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("출력오류");
		}
		return highrank;
	}

	String[][] showRankingMid() {
		int i = 0;
		try {

			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false",
					"root", "thrhd");

			PreparedStatement ps = null;
			ResultSet rs = null;

			String sql = "select * from ranking where LEVEL = '중' order by SCORE desc, TIME, LIFE desc";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				midrank[i][0] = rs.getString("LEVEL");
				midrank[i][1] = rs.getString(2);
				midrank[i][2] = rs.getString(3);
				midrank[i][3] = rs.getString(4);
				midrank[i][4] = rs.getString(5);

				i++;

				if (i == 10) {
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("출력오류");
		}
		return midrank;
	}

	String[][] showRankingLow() {
		int i = 0;
		try {

			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false",
					"root", "thrhd");

			PreparedStatement ps = null;
			ResultSet rs = null;

			String sql = "select * from ranking where LEVEL = '하' order by SCORE desc, TIME, LIFE desc";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				lowrank[i][0] = rs.getString("LEVEL");
				lowrank[i][1] = rs.getString(2);
				lowrank[i][2] = rs.getString(3);
				lowrank[i][3] = rs.getString(4);
				lowrank[i][4] = rs.getString(5);

				i++;

				if (i == 10) {
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("출력오류");
		}
		return lowrank;
	}
}

class question {

	String dex, problem, answer, explain;
	String[][] arr = new String[10][4];// 인덱스,문제,답,해설
	int i;
	int[] randnum = new int[29];
	String[] qustnum = new String[10];
	int j;
	int tmp2;
	int level;

	// showQuest함수에서 println부분은 배열에 정상적으로 들어갔는지 확인하는 부분이라서 코드 합칠때 지우시면 됩니당~
	question(int level) {
		this.level = level;
	}

	String[][] showQuestionHigh() {

		try {

			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false",
					"root", "thrhd");

			PreparedStatement ps = null;
			ResultSet rs = null;
			// 비중복 랜덤함수
			Random ra = new Random();
			for (j = 0; j < 29; j++) {
				randnum[j] = j + 1;
			}

			for (j = 0; j < 29; j++) {
				int desti = ra.nextInt(28) + 1;
				tmp2 = randnum[j];
				randnum[j] = randnum[desti];
				randnum[desti] = tmp2;
			}
			for (j = 0; j < 10; j++) {
				qustnum[j] = Integer.toString(randnum[j]);// 10개
			}

			for (i = 0; i < 10; i++) {

				String sql = "select * from testhigh where dex = \'" + qustnum[i] + "\';";

				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					dex = rs.getString("dex");
					problem = rs.getString(2);
					answer = rs.getString(3);
					explain = rs.getString(4);

					arr[i][0] = dex;
					arr[i][1] = problem;
					arr[i][2] = answer;
					arr[i][3] = explain;

					// System.out.println((i+1) + ". " + arr[i][1]);
					// System.out.println(arr[i][2] + "\n" + arr[i][3]);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}

	String[][] showQuestionMid() {

		try {
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false",
					"root", "thrhd");

			PreparedStatement ps = null;
			ResultSet rs = null;
			// 비중복 랜덤함수
			Random ra = new Random();
			for (j = 0; j < 29; j++) {
				randnum[j] = j + 1;
			}

			for (j = 0; j < 29; j++) {
				int desti = ra.nextInt(28) + 1;
				tmp2 = randnum[j];
				randnum[j] = randnum[desti];
				randnum[desti] = tmp2;
			}
			for (j = 0; j < 10; j++) {
				qustnum[j] = Integer.toString(randnum[j]);// 10개
			}

			for (i = 0; i < 10; i++) {

				String sql = "select * from testmid where dex = \'" + qustnum[i] + "\';";

				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					dex = rs.getString("dex");
					problem = rs.getString(2);
					answer = rs.getString(3);
					explain = rs.getString(4);

					arr[i][0] = dex;
					arr[i][1] = problem;
					arr[i][2] = answer;
					arr[i][3] = explain;

					// System.out.println((i + 1) + ". " + arr[i][1]);
					// System.out.println(arr[i][2] + "\n" + arr[i][3] + "\n!");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}

	String[][] showQuestionLow() {

		try {

			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false",
					"root", "thrhd");

			PreparedStatement ps = null;
			ResultSet rs = null;
			// 비중복 랜덤함수
			Random ra = new Random();
			for (j = 0; j < 29; j++) {
				randnum[j] = j + 1;
			}

			for (j = 0; j < 29; j++) {
				int desti = ra.nextInt(28) + 1;
				tmp2 = randnum[j];
				randnum[j] = randnum[desti];
				randnum[desti] = tmp2;
			}
			for (j = 0; j < 10; j++) {
				qustnum[j] = Integer.toString(randnum[j]);// 10개
			}

			for (i = 0; i < 10; i++) {

				String sql = "select * from testlow where dex = \'" + qustnum[i] + "\';";

				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					dex = rs.getString("dex");
					problem = rs.getString(2);
					answer = rs.getString(3);
					explain = rs.getString(4);

					arr[i][0] = dex;
					arr[i][1] = problem;
					arr[i][2] = answer;
					arr[i][3] = explain;

					// System.out.println((i + 1) + ". " + arr[i][1]);
					// System.out.println(arr[i][2] + "\n" + arr[i][3]);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}
}

class FinalScreenButton implements ActionListener {
	RankingScreen rankingScreen;
	RetryScreen retryScreen;
	SolutionScreen solutionScreen;
	int num = 0;
	QueParser Que;
	int[] wrongQueNum;

	public FinalScreenButton(RankingScreen rankingScreen, int num, QueParser Que, int[] wrongQueNum) {
		this.rankingScreen = rankingScreen;
		this.num = num;
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;
	}

	public FinalScreenButton(RetryScreen retryScreen, int num, QueParser Que, int[] wrongQueNum) {
		this.retryScreen = retryScreen;
		this.num = num;
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;
	}

	public FinalScreenButton(SolutionScreen solutionScreen, QueParser Que, int[] wrongQueNum) {
		this.solutionScreen = solutionScreen;
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;
	}

	public void actionPerformed(ActionEvent e) {
		if (num == 2) {
			rankingScreen.setVisible(false);
			StartScreen2 startScreen2 = new StartScreen2();
			startScreen2.setVisible(true);
		} else if (num == 1) {
			retryScreen.setVisible(false);
			FinalScreen finalScreen = new FinalScreen(Que, wrongQueNum);
			finalScreen.setVisible(true);
		} else {
			if (solutionScreen == null)
				rankingScreen.setVisible(false);
			else
				solutionScreen.setVisible(false);
			FinalScreen finalScreen = new FinalScreen(Que, wrongQueNum);
			finalScreen.setVisible(true);
		}
	}
}

class FinalScreen extends JFrame {
	JPanel panel;

	JButton jButton1, jButton2, jButton3, jButton4, jButton5;

	QueParser Que;
	int[] wrongQueNum;

	public FinalScreen(QueParser Que, int[] wrongQueNum) {
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;

		setTitle("Magician Of Code");
		setBounds(125, 30, 870, 570);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\lastscreen.png");
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setLayout(null);

		makeComponent();
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public void makeComponent() {
		jButton1 = new JButton();
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\retryB.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(360, 30, 140, 52);
		ActionListener listener1 = new RetryButton(this, Que, wrongQueNum);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setIcon(new ImageIcon("C:\\photoshop\\solu.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(360, 90, 140, 52);
		ActionListener listener2 = new SolutionButton(this, Que, wrongQueNum);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setIcon(new ImageIcon("C:\\photoshop\\ranking.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(360, 150, 140, 52);
		ActionListener listener3 = new RankingButton(this, Que, wrongQueNum);
		jButton3.addActionListener(listener3);
		panel.add(jButton3);

		jButton4 = new JButton();
		jButton4.setIcon(new ImageIcon("C:\\photoshop\\again.png"));
		jButton4.setBackground(Color.WHITE);
		jButton4.setOpaque(false);
		jButton4.setBorderPainted(false);
		jButton4.setBounds(360, 210, 140, 52);
		ActionListener listener4 = new ReturnButton(this, 0);
		jButton4.addActionListener(listener4);
		panel.add(jButton4);

		jButton5 = new JButton();
		jButton5.setIcon(new ImageIcon("C:\\photoshop\\end.png"));
		jButton5.setBackground(Color.WHITE);
		jButton5.setOpaque(false);
		jButton5.setBorderPainted(false);
		jButton5.setBounds(360, 270, 140, 52);
		ActionListener listener5 = new EndButton();
		jButton5.addActionListener(listener5);
		panel.add(jButton5);
	}
}

class RetryButton implements ActionListener {
	FinalScreen finalScreen;
	QueParser Que;
	int[] wrongQueNum;

	public RetryButton(FinalScreen finalScreen, QueParser Que, int[] wrongQueNum) {
		this.finalScreen = finalScreen;
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;
	}

	public void actionPerformed(ActionEvent e) {
		finalScreen.setVisible(false);
		RetryScreen retryScreen = new RetryScreen(Que, wrongQueNum);
		retryScreen.setVisible(true);
	}
}

class SolutionButton implements ActionListener {
	FinalScreen finalScreen;
	QueParser Que;
	int[] wrongQueNum;

	public SolutionButton(FinalScreen finalScreen, QueParser Que, int[] wrongQueNum) {
		this.finalScreen = finalScreen;
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;
	}

	public void actionPerformed(ActionEvent e) {
		finalScreen.setVisible(false);
		SolutionScreen solutionScreen = new SolutionScreen(Que, wrongQueNum);
		solutionScreen.setVisible(true);
	}
}

class RankingButton implements ActionListener {
	StartScreen2 startScreen2;
	FinalScreen finalScreen;
	int num = 0;
	QueParser Que;
	int[] wrongQueNum;

	public RankingButton(StartScreen2 startScreen2, int num) {
		this.startScreen2 = startScreen2;
		this.num = num;
	}

	public RankingButton(FinalScreen finalScreen, QueParser Que, int[] wrongQueNum) {
		this.finalScreen = finalScreen;
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;
	}

	public void actionPerformed(ActionEvent e) {
		if (startScreen2 == null)
			finalScreen.setVisible(false);
		else
			startScreen2.setVisible(false);
		RankingScreen rankingScreen = new RankingScreen(num, "하", Que, wrongQueNum);
		rankingScreen.setVisible(true);
	}
}

class RetryScreen extends LevelLowScreen {
	JButton jButton8;
	int quesNum = 0;
	QueParser Que;
	int[] wrongQueNum;

	public void nextQuestion() {
		Que.QueProvider(wrongQueNum[quesNum++]);
		showQuestion();
	}

	public void showQuestion() {

		int arr[] = new int[12];
		Random rdd = new Random();

		for (int i = 0; i < 12; i++)
			arr[i] = i;

		for (int i = 0; i < 12; i++) {
			int des = rdd.nextInt(12);
			int temp = arr[i];
			arr[i] = arr[des];
			arr[des] = temp;
		}

		for (int i = 0; i < 3; i++) {
			exButton[arr[i]].setText((Que.Answer[i]));
			ansNum[i] = arr[i];
		}
		for (int i = 3; i < 12; i++) {
			if (i >= Que.count || Que.ex.size() == 0) {
				exButton[arr[i]].setText("보너스");
				continue;
			}

			int num = rdd.nextInt(Que.ex.size());
			if (Que.ex.get(num).equals(" ") || Que.ex.get(num).equals("") || Que.ex.get(num).equals("\n")
					|| Que.ex.get(num).equals("}") || Que.ex.get(num).equals("{") || Que.ex.get(num).equals("\n{")
					|| Que.ex.get(num).equals("\n}") || Que.ex.get(num).equals("\n\n")) {
				Que.ex.remove(num);
				i--;
				continue;
			}

			for (int j = 0; j < 12; j++) {
				if (Que.ex.get(num).equals(exButton[j].getText())) {
					Que.ex.remove(num);
					i--;
					break;
				}
			}

			exButton[arr[i]].setText((Que.ex.get(num)));
			Que.ex.remove(num);
		}
		Que.count = 0;

		jTextArea1.setText(" ");
		jTextArea1.append(quesNum + ". " + Que.QueArr[wrongQueNum[quesNum - 1]][1] + "\n");

		for (int k = 0; k < Que.list.size(); k++)
			jTextArea1.append(Que.list.get(k));
	}

	public RetryScreen(QueParser Que, int[] wrongQueNum) {
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;

		makeComponent5();

		panel.remove(jScrollPane);
		textIcon = new ImageIcon("C:\\photoshop\\retry1.jpg");
		textImg = textIcon.getImage();
		jTextArea1 = new JTextArea() {
			public void paintComponent(Graphics g) {
				g.drawImage(textImg, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		};
		jTextArea1.setText(" ");
		jTextArea1.setFont(new Font("Dialog.plain", 0, 12));
		jTextArea1.setBackground(new Color(255, 255, 255, 178));
		jTextArea1.setBorder(null);
		jTextArea1.setBounds(75, 59, 323, 454);
		jTextArea1.setLineWrap(true);
		jTextArea1.setFocusable(false);
		jScrollPane = new JScrollPane(jTextArea1);
		jScrollPane.setBounds(75, 59, 323, 454);
		jScrollPane.setBorder(null);
		panel.add(jScrollPane);

		panel.remove(image);
		ImageIcon icon = new ImageIcon("C:\\photoshop\\retry.png");

		image = new JLabel(icon);
		image.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		panel.add(image);

		Que.setRetry();
		Que.QueProvider(wrongQueNum[quesNum++]);
		showQuestion();
	}

	public void makeComponent5() {
		jButton2.removeActionListener(listener2);
		ActionListener listener2 = new CheckButton(this, Que, Point, exam, true);
		jButton2.addActionListener(listener2);
		jButton2.addActionListener(listener1);

		jButton3.setVisible(false);
		jButton4.setVisible(false);

		jLabel1.setVisible(false);
		jLabel2.setVisible(false);
		jLabel3.setVisible(false);
		jLabel4.setVisible(false);

		life[0].setVisible(false);
		life[1].setVisible(false);
		life[2].setVisible(false);

		jButton8 = new JButton();
		jButton8.setFont(new Font("Dialog.plain", 0, 12));
		jButton8.setIcon(new ImageIcon("C:\\photoshop\\return.png"));
		jButton8.setBackground(Color.WHITE);
		jButton8.setOpaque(false);
		jButton8.setBorderPainted(false);
		jButton8.setBounds(10, 7, 60, 60);
		ActionListener listener1 = new FinalScreenButton(this, 1, Que, wrongQueNum);
		jButton8.addActionListener(listener1);
		panel.add(jButton8);
	}
}

class SolutionScreen extends JFrame {
	JPanel panel;

	JTextArea jTextArea1, jTextArea2;

	JButton jButton1, jButton2, jButton3;

	QueParser Que;
	int[] wrongQueNum;
	int quesNum = 0;
	int wrongNum;

	public SolutionScreen(QueParser Que, int[] wrongQueNum) {
		this.Que = Que;
		this.wrongQueNum = wrongQueNum;

		for (int i = 1; i < 6; i++) {
			if (wrongQueNum[i] == 0) {
				wrongNum = i;
				break;
			}
		}
		System.out.println(wrongNum);

		setTitle("Magician Of Code");
		setBounds(125, 30, 870, 570);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\solution.png");
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setLayout(null);

		makeComponent();
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public void makeComponent() {

		ImageIcon textIcon = new ImageIcon("C:\\photoshop\\solution1.jpg");
		Image textImg = textIcon.getImage();
		jTextArea1 = new JTextArea() {
			public void paintComponent(Graphics g) {
				g.drawImage(textImg, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		};
		jTextArea1.setText((quesNum + 1) + "번 : " + Que.QueArr[wrongQueNum[quesNum]][1] + "\n\n"
				+ Que.QueArr[wrongQueNum[quesNum]][2]);
		jTextArea1.setFont(new Font("Dialog.plain", 0, 12));
		jTextArea1.setBackground(new Color(255, 255, 255, 178));
		jTextArea1.setBounds(50, 60, 340, 390);
		jTextArea1.setLineWrap(true);
		jTextArea1.setFocusable(false);
		JScrollPane jScrollPane = new JScrollPane(jTextArea1);
		jScrollPane.setBounds(50, 60, 340, 390);
		jScrollPane.setBorder(null);
		panel.add(jScrollPane);

		ImageIcon textIcon2 = new ImageIcon("C:\\photoshop\\solution2.jpg");
		Image textImg2 = textIcon2.getImage();
		jTextArea2 = new JTextArea() {
			public void paintComponent(Graphics g) {
				g.drawImage(textImg2, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		};
		jTextArea2.setText(Que.QueArr[wrongQueNum[quesNum]][3]);
		jTextArea2.setFont(new Font("Dialog.plain", 0, 12));
		jTextArea2.setBackground(new Color(255, 255, 255, 178));
		jTextArea2.setBounds(455, 60, 340, 390);
		jTextArea2.setLineWrap(true);
		jTextArea2.setFocusable(false);
		JScrollPane jScrollPane2 = new JScrollPane(jTextArea2);
		jScrollPane2.setBounds(455, 60, 340, 390);
		jScrollPane2.setBorder(null);
		panel.add(jScrollPane2);

		jButton1 = new JButton();
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\return.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(6, 7, 60, 60);
		ActionListener listener1 = new FinalScreenButton(this, Que, wrongQueNum);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setIcon(new ImageIcon("C:\\photoshop\\before.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(30, 445, 115, 66);
		ActionListener listener2 = new BeforeNext(this, 0, true);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setIcon(new ImageIcon("C:\\photoshop\\next.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(695, 445, 115, 66);
		ActionListener listener3 = new BeforeNext(this, 1, true);
		jButton3.addActionListener(listener3);
		panel.add(jButton3);
	}
}

class BeforeNext implements ActionListener {
	SolutionScreen solutionScreen;
	RetryScreen retryScreen;
	int num = 0;
	boolean solu = false;

	public BeforeNext(SolutionScreen solutionScreen, int num, boolean solu) {
		this.solutionScreen = solutionScreen;
		this.num = num;
		this.solu = solu;
	}

	public BeforeNext(RetryScreen retryScreen, int num) {
		this.retryScreen = retryScreen;
		this.num = num;
	}

	public void actionPerformed(ActionEvent e) {
		if (solu) {
			if (num == 0 && solutionScreen.quesNum != 0)
				solutionScreen.quesNum--;
			else if (num == 1 && solutionScreen.quesNum != 5)
				solutionScreen.quesNum++;
			else {

			}
			solutionScreen.jTextArea1.setText((solutionScreen.quesNum + 1) + "번 : "
					+ solutionScreen.Que.QueArr[solutionScreen.wrongQueNum[solutionScreen.quesNum]][1] + "\n\n"
					+ solutionScreen.Que.QueArr[solutionScreen.wrongQueNum[solutionScreen.quesNum]][2]);
			solutionScreen.jTextArea2
					.setText(solutionScreen.Que.QueArr[solutionScreen.wrongQueNum[solutionScreen.quesNum]][3]);
		} else {
			if (num == 0 && retryScreen.quesNum != 0)
				retryScreen.quesNum++;
			else
				retryScreen.quesNum--;
		}
	}
}

class QueParser {
	String[][] QueArr;
	String[] Tokenize;
	String[] Answer;
	question Pro;
	int Que_number;
	int isCorrect;
	int tokennumber;
	int[] temp;
	int[] ansNum = new int[3];
	int num = 0;
	int count = 0;
	ArrayList<String> list, ex;
	boolean retry = false;
	int wrongNum = 0;

	QueParser(int level) {
		this.Answer = new String[3];
		this.isCorrect = 0;
		this.Que_number = 10;
		Pro = new question(level);
		switch (level) {
		case 1:
			QueArr = Pro.showQuestionLow();
			break;
		case 2:
			QueArr = Pro.showQuestionMid();
			break;
		case 3:
			QueArr = Pro.showQuestionHigh();
			break;
		}
		QueProvider();
	}

	void setRetry() {
		retry = true;
	}

	void QueProvider(int wrongNum) {
		this.wrongNum = wrongNum;
		QueProvider();
	}

	void QueProvider() {
		String str;
		if (retry)
			str = QueArr[wrongNum][2];
		else
			str = QueArr[num++][2];
		// String str = " #include <stdio.h> \n void main() \n { \n
		// printf(\"Hello wolrd\"); \n } ";

		boolean end = false;
		char space = ' ';
		list = new ArrayList<String>();
		ex = new ArrayList<String>();
		int i = 0;

		for (i = 0;; i++) {
			for (int j = i; j < str.length(); j++) {
				if (j == str.length() - 1) {
					list.add(str.substring(i, j));
					ex.add(str.substring(i, j));
					end = true;
					break;
				}
				if (space == str.charAt(j)) {
					list.add(str.substring(i, j));
					list.add(" ");
					ex.add(str.substring(i, j));
					i = j;
					break;
				}
			}
			if (end)
				break;
		}

		int tmp;
		Random rd = new Random();
		temp = new int[list.size()];

		for (i = 0; i < 3;) {
			int num = rd.nextInt(list.size());
			if (list.get(num).equals(" ") || list.get(num).equals("\n") || list.get(num).equals("")
					|| list.get(num).equals("\"") || list.get(num).equals("{") || list.get(num).equals("}")
					|| list.get(num).equals("\n\n"))
				continue;
			if (i == 1 && list.get(ansNum[0]).equals(list.get(num))) {
				continue;
			}
			if ((i == 2 && list.get(ansNum[0]).equals(list.get(num)))
					|| (i == 2 && list.get(ansNum[1]).equals(list.get(num)))) {
				continue;
			}
			ansNum[i++] = num;
		}

		for (i = 0; i < list.size(); i++) {
			if (list.get(i).equals(" ") || list.get(i).equals("\n") || list.get(i).equals("")
					|| list.get(i).equals("\"") || list.get(i).equals("{") || list.get(i).equals("}"))
				continue;
			count++;
		}

		for (i = 0; i < 3; i++) {
			for (int j = i; j < 3; j++) {
				if (ansNum[j] < ansNum[i]) {
					tmp = ansNum[j];
					ansNum[j] = ansNum[i];
					ansNum[i] = tmp;
				}
			}
		}

		for (i = 0; i < 3; i++) {
			Answer[i] = list.get(ansNum[i]);
			ex.remove(list.get(ansNum[i]));
			list.set(ansNum[i], "_" + (i + 1) + "_");
		}
	}
}

class PointChecker {
	TutorialScreen tutorialScreen;
	int StartPoint;
	int HintPoint;
	int PassPoint;
	int LeftLifePoint;
	int Level;

	PointChecker(TutorialScreen tutorialScreen) {
		this.tutorialScreen = tutorialScreen;
		this.StartPoint = 1000;
		this.HintPoint = 0;
		this.PassPoint = 0;
		this.LeftLifePoint = 0;
	}

	public void setScore() {
		tutorialScreen.jLabel4.setText(String.valueOf(tutorialScreen.pointChecker.GetTotalScore()));
	}

	int GetTotalScore() {
		return StartPoint + HintPoint + PassPoint + LeftLifePoint;
	}

	void MinusHint() {
		this.HintPoint -= 5;
		setScore();
	}

	void MinusPass() {
		this.PassPoint -= 10;
		setScore();
	}

	void MinusLife() {
		this.LeftLifePoint -= 10;
		setScore();
	}

	void plusBonus() {
		this.StartPoint += 10;
		setScore();
	}

	void SetLevel(int Button_value) {
		this.Level = Button_value;
	}
}

class Blind extends QueParser {

	public Blind() {
		super(3);
	}

	void QueProvider() {
		super.QueProvider();
		Random rd = new Random();
		for (int i = 0; i < 2; i++) {

			int num = rd.nextInt(list.size());
			if (list.get(num).equals("_1_") || list.get(num).equals("_2_") || list.get(num).equals("_3_")
					|| list.get(num).equals("") || list.get(num).equals("\n") || list.get(num).equals("{")
					|| list.get(num).equals("}") || list.get(num).equals("\"")) {
				i--;
				continue;
			}
			list.set(num, "(Blind !)");
		}
	}
}

public class JDBCTest {
	public static void main(String[] args) {

		connectDatabase Database_connect = new connectDatabase();
		Database_connect.connect();

		LevelChoiceScreen1 GUI_Interface = new LevelChoiceScreen1();
		GUI_Interface.setVisible(true);
	}
}