
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.*;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

/**
 * @brief ���α׷� ������ ��Ÿ���� ȭ�� Ŭ�����Դϴ�.
 * @details �����带 ȣ���Ͽ� 2�� �Ŀ� ����ȭ������ �Ѿ�� �մϴ�.
 * @author �Ұ� 2�� �ڵ��Ǹ�����
 * @date 2016-11-26
 * @version 0.0.1
 */

class StartScreen1 extends JFrame {
	JPanel panel;

	public StartScreen1() {

		setTitle("Magician Of Code");
		setBounds(137, 35, 870, 570);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("photo\\first.png");
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

/**
 * @brief ù ȭ���� �ѱ��� ������ Ŭ�����Դϴ�.
 * @details run()�Լ��� �����Ͽ� 2�ʵ� ���� ȭ������ �Ѿ���մϴ�.
 * @author �Ұ� 2�� �ڵ��Ǹ�����
 * @date 2016-11-26
 * @version 0.0.1
 */

class StartScreenFlash implements Runnable {
	StartScreen1 startScreen1;

	public StartScreenFlash(StartScreen1 startScreen1) {
		this.startScreen1 = startScreen1;
	}

	/**
	 * @brief ������ ���� �Լ��Դϴ�.
	 * @details 2�ʵ� ���� ȭ������ �Ѿ�� �մϴ�.
	 * @param
	 * @return
	 * 
	 * @bug
	 * @TODO
	 * @exception
	 * 
	 * 				@see
	 * @see
	 */

	public void run() {
		try {
			Thread.sleep(2000);
			startScreen1.setVisible(false);
			StartScreen2 startScreen2 = new StartScreen2();
			startScreen2.setVisible(true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**
 * @brief ������ �����ϱ� �� Ŭ�����Դϴ�.
 * @details ���� ����, ��ŷ ����, �����⸦ ������ �� �ִ� Ŭ�����Դϴ�.
 * @author �Ұ� 2�� �ڵ��Ǹ�����
 * @date 2016-11-26
 * @version 0.0.1
 */

class StartScreen2 extends JFrame {
	JPanel panel;

	JButton jButton1, jButton2, jButton3;

	public StartScreen2() {

		setTitle("Magician Of Code");
		setBounds(125, 30, 870, 570);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("photo\\startscreen.png");
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
		jButton1.setIcon(new ImageIcon("photo\\start.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(390, 190, 140, 52);
		ActionListener listener1 = new StartButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setIcon(new ImageIcon("photo\\ranking.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(390, 250, 140, 52);
		ActionListener listener2 = new RankingButton(this, 2);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setIcon(new ImageIcon("photo\\end.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(390, 310, 140, 52);
		ActionListener listener3 = new EndButton();
		jButton3.addActionListener(listener3);
		panel.add(jButton3);
	}
}

/**
 * @brief
 * @details ���ӽ��� ��ư�� �̺�Ʈ Ŭ�����Դϴ�.
 * @author �Ұ� 2�� �ڵ��Ǹ�����
 * @date 2016-11-26
 * @version 0.0.1
 */

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

	JLabel jLabel1, jLabel2, jLabel3;
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

		ImageIcon icon = new ImageIcon("photo\\tutorial.png");
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setLayout(null);

		icon3 = new ImageIcon("photo\\Done1.png");
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
		textIcon = new ImageIcon("photo\\tutorial1.jpg");
		textImg = textIcon.getImage();
		jTextArea1 = new JTextArea() {
			public void paintComponent(Graphics g) {
				g.drawImage(textImg, 0, 0, getWidth(), getHeight(), this);
				super.paintComponent(g);
			}
		};
		jTextArea1.setText(
				"\n\n\n Hello, World!�� �����ϱ� ���� ���� �ڵ带 �ϼ��Ͻÿ�." + " \n\n\n #include <stdio.h> " + "\n\nint main() { "
						+ "\n          (          )(\"Hello, World!\");" + "\n          return 0;" + "\n}");
		jTextArea1.setFont(new Font("Dialog.plain", 0, 12));
		jTextArea1.setBackground(new Color(255, 255, 255, 178));
		jTextArea1.setBorder(null);
		jTextArea1.setBounds(75, 59, 323, 454);
		panel.add(jTextArea1);

		jTextArea2 = new JTextArea();
		jTextArea2.setText("�ȳ�? ���� ���νþ�\n�ڵ��� �����縦 ã���� �Ա���!");
		jTextArea2.setFont(new Font("��������", Font.BOLD, 35));
		jTextArea2.setOpaque(false);
		jTextArea2.setBorder(null);
		jTextArea2.setBounds(190, 530, 680, 90);
		panel.add(jTextArea2);

		jLabel1 = new JLabel(); // �ð� �� ����
		jLabel1.setText("00");
		jLabel1.setFont(new Font("��������", Font.BOLD, 20));
		jLabel1.setBounds(635, 19, 30, 20);
		panel.add(jLabel1);

		jLabel2 = new JLabel(); // �ð� �� ����
		jLabel2.setText("00");
		jLabel2.setFont(new Font("��������", Font.BOLD, 20));
		jLabel2.setBounds(595, 19, 30, 20);
		panel.add(jLabel2);

		jLabel3 = new JLabel();
		jLabel3.setText(":");
		jLabel3.setFont(new Font("��������", Font.BOLD, 20));
		jLabel3.setBounds(623, 18, 10, 21);
		panel.add(jLabel3);

		for (int i = 0; i < 12; i++) {
			exButton[i] = new JButton();
			exButton[i].setText("����" + (i + 1));
			exButton[i].setFont(new Font("Dialog.plain", 0, 12));
			exButton[i].setBackground(new Color(255, 255, 255, 250));
			listener = new ExButtonMoving(this, i, exam);
			exButton[i].addActionListener(listener);
			panel.add(exButton[i]);
		}

		jButton1 = new JButton();
		jButton1.setIcon(new ImageIcon("photo\\reset.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(610, 470, 102, 40);
		listener1 = new ResetButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setIcon(new ImageIcon("photo\\check.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(728, 470, 100, 40);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setIcon(new ImageIcon("photo\\hint.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(728, 310, 102, 40);
		panel.add(jButton3);

		jButton4 = new JButton();
		jButton4.setIcon(new ImageIcon("photo\\pass.png"));
		jButton4.setBackground(Color.WHITE);
		jButton4.setOpaque(false);
		jButton4.setBorderPainted(false);
		jButton4.setBounds(728, 356, 102, 40);
		panel.add(jButton4);

		jButton5 = new JButton();
		jButton5.setIcon(new ImageIcon("photo\\skip.png"));
		jButton5.setBackground(Color.WHITE);
		jButton5.setOpaque(false);
		jButton5.setBorderPainted(false);
		jButton5.setBounds(5, 8, 87, 37);
		ActionListener listener5 = new SkipButton(this);
		jButton5.addActionListener(listener5);
		panel.add(jButton5);

		jButton6 = new JButton();
		jButton6.setIcon(new ImageIcon("photo\\ȭ��ǥ.png"));
		jButton6.setBackground(Color.WHITE);
		jButton6.setOpaque(false);
		jButton6.setBorderPainted(false);
		jButton6.setBounds(800, 600, 52, 53);
		ActionListener listener6 = new NextButton(this, 0);
		jButton6.addActionListener(listener6);
		panel.add(jButton6);

		jButton7 = new JButton();
		jButton7.setIcon(new ImageIcon("photo\\��ȭ��ǥ.png"));
		jButton7.setBackground(Color.WHITE);
		jButton7.setOpaque(false);
		jButton7.setBorderPainted(false);
		jButton7.setBounds(440, 83, 77, 71);
		jButton7.setVisible(false);
		panel.add(jButton7);

		for (int i = 0; i < 3; i++) {
			life[i] = new JButton();
			life[i].setFont(new Font("Dialog.plain", 0, 12));
			life[i].setIcon(new ImageIcon("photo\\life.png"));
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
			tutorialScreen.jTextArea2.setText("���� ������ �������ٰ�!\n���� �غ�!!");
			break;
		case 1:
			tutorialScreen.jTextArea2.setText("������ ���Ⱑ ���̴�??\n������ �а� ���⸦ Ŭ���غ�!");
			tutorialScreen.jButton7.setVisible(true);
			break;
		case 2:
			tutorialScreen.jButton7.setBounds(540, 455, 77, 71);
			tutorialScreen.jButton7.setIcon(new ImageIcon("photo\\��ȭ��ǥ.png"));
			tutorialScreen.jTextArea2.setText("������ ������ ��ġ�� ������!?\nRESET��ư�� Ŭ���غ�!");
			break;
		case 3:
			tutorialScreen.jButton7.setVisible(false);
			tutorialScreen.jTextArea2.setText("���Ⱑ �������� ���ƿ���!?");
			break;
		case 4:
			tutorialScreen.jTextArea2.setText("HINT��ư�� ������ Ǯ�ٰ� \n���� �ϳ��� �˰� ���� �� ���� ��ư�̾�!");
			tutorialScreen.jButton7.setBounds(672, 290, 77, 71);
			tutorialScreen.jButton7.setVisible(true);
			break;
		case 5:
			tutorialScreen.jButton7.setBounds(672, 340, 77, 71);
			tutorialScreen.jTextArea2.setText("PASS��ư�� ������ Ǯ�ٰ� �� ������\n�Ѿ�� ���� �� ���� ��ư�̾�!");
			break;
		case 6:
			tutorialScreen.jButton7.setVisible(false);
			tutorialScreen.jTextArea2.setText("�׷� ���� ���� ���󺸷�!");
			break;
		case 7:
			tutorialScreen.jButton7.setBounds(745, 400, 77, 71);
			tutorialScreen.jButton7.setIcon(new ImageIcon("photo\\��ȭ��ǥ.png"));
			tutorialScreen.jButton7.setVisible(true);
			tutorialScreen.jTextArea2.setText("prinf�� ������?? \nCHECK ��ư���� ���� Ȯ���� �� �־�!");
			break;
		case 8:
			tutorialScreen.jButton7.setVisible(false);
			tutorialScreen.jTextArea2.setText("�� ������ ���������� \nCHECK��ư�� ���� �������� �Ѿ!");
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

class ResetButton implements ActionListener {
	TutorialScreen tutorialScreen;

	public ResetButton(TutorialScreen tutorialScreen) {
		this.tutorialScreen = tutorialScreen;
	}

	public void actionPerformed(ActionEvent e) {
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

		ImageIcon icon = new ImageIcon("photo\\level.png");
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
			Que = new QueParser(3);
			levelChoiceScreen1.setVisible(false);
			LevelHighScreen levelHighScreen = new LevelHighScreen();
			levelHighScreen.setQue(Que);
			levelHighScreen.showQuestion();
			levelHighScreen.setVisible(true);
			break;
		}
	}
}

class LevelLowScreen extends TutorialScreen {

	int remainHintCount = 999;
	int remainPassCount = 999;
	int remainLifeCount = 3;
	JLabel image;
	int QueNum;

	JLabel image1;
	JLabel image2;

	boolean ready = true;

	int[] ansNum = new int[3];
	int questionNum = 1;
	int count = 1;

	ActionListener listener3, listener4;
	
	public void setQue(QueParser Que) {
		this.Que = Que;
		jButton2.removeActionListener(listener2);
		ActionListener listener2 = new CheckButton(this, 1, Que, Point, exam, QueNum);
		jButton2.addActionListener(listener2);
		jButton2.addActionListener(listener1);
	}

	public LevelLowScreen() {

		ImageIcon icon1 = new ImageIcon("photo\\Done.png");
		image1 = new JLabel(icon1);
		image1.setBounds(400, 300, icon1.getIconWidth(), icon1.getIconHeight());
		image1.setVisible(false);
		panel.add(image1);

		ImageIcon icon2 = new ImageIcon("photo\\Wrong.png");
		image2 = new JLabel(icon2);
		image2.setBounds(400, 300, icon2.getIconWidth(), icon2.getIconHeight());
		image2.setVisible(false);
		panel.add(image2);

		setBounds(125, 30, 870, 570);

		panel.remove(jTextArea1);
		textIcon = new ImageIcon("photo\\game11.jpg");
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
		panel.add(jTextArea1);

		ImageIcon icon = new ImageIcon("photo\\game1.png");
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
		int tm;
		int arr[] = new int[12];
		Random rdd = new Random();

		// ���� 10�� �����ؾߵ�!!
		/*
		for (int i = 0; i < 12; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < 12; i++) {
			int dex = rdd.nextInt(12);
			tm = arr[i];
			arr[i] = arr[dex];
			arr[dex] = tm;
		}*

		for (int i = 0, j = 0; i < 12; i++) { // ���� ��ư �� ���� 1111
			if (i < 3) {
				exButton[arr[i]].setText(Que.Answer[j++]);
				ansNum[i] = arr[i];
			} else {
				if (j >= Que.Tokenize.length - 1)
					j -= 4;
				if (Que.Tokenize[j].equals("\\n") || Que.Tokenize[j].equals("_0_") || Que.Tokenize[j].equals("_1_")
						|| Que.Tokenize[j].equals("_2_")) {
					i--;
					j++;
					continue;
				}
				if (j >= Que.Tokenize.length - 1)
					j -= 7;
				exButton[arr[i]].setText(Que.Tokenize[j++]);
			}
		}
		System.out.println("showQuestion : " + Que.Answer[0] + " " +
		Que.Answer[1] + " " + Que.Answer[2]);*/
		jTextArea1.setText(" ");
		jTextArea1.append(questionNum + ". : " + Que.QueArr[questionNum - 1][1] + "\n");
		/*
		for (int i = 0; i < Que.tokennumber; i++) {
			if (Que.Tokenize[i].equals("@"))
				jTextArea1.append("\n");
			else if (Que.Tokenize[i].equals("#"))
				jTextArea1.append("        ");
			else if (Que.Tokenize[i].equals("$"))
				jTextArea1.append(" ");
			else
				jTextArea1.append(Que.Tokenize[i]);
		}
		for (int i = 0; i < 3; i++) {
			jTextArea1.append("\n\n" + i + "��° �� : " + Que.Answer[i]);
		}*/
		for (int k = 0 ; k < Que.list.size() ; k++)
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
		if (screen.remainHintCount > 0) {
			screen.remainHintCount--; // ��Ʈ ��ƾ �߰�
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
			// Point.MinusHint();
		} else
			JOptionPane.showMessageDialog(null, "��Ʈ �� ������.");

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
		if (screen.remainPassCount > 0) {
			screen.remainPassCount--;
			// Point.MinusPass();
			screen.nextQuestion();
		} else
			JOptionPane.showMessageDialog(null, "�н� �� ������.");
	}
}

class CheckButton implements ActionListener, Runnable {
	LevelLowScreen levelLowScreen;
	PointChecker Point;
	QueParser Que;
	String exam[];
	JLabel image;
	int num = 0;
	int QueNum = 0;
	boolean right;

	public CheckButton(LevelLowScreen levelLowScreen, int num, QueParser Que, PointChecker Point, String[] exam,
			int QueNum) {
		this.levelLowScreen = levelLowScreen;
		this.num = num;
		this.Que = Que;
		this.Point = Point;
		this.exam = exam;
		right = true;
		this.QueNum = QueNum;
	}

	public CheckButton(JLabel image) {
		this.image = image;
	}

	public void actionPerformed(ActionEvent e) {
		//System.out.println("��ģ...." + levelLowScreen);

		//System.out.println("CheckButton : " + Que.Answer[0] + " " + Que.Answer[1] + " " + Que.Answer[2]);
		System.out.println(exam[0]);
		for (int i = 0; i < 3; i++) {
			if (!(exam[i].equals(Que.Answer[i]))) {
				right = false;
			}
		}

		if (right == true) { // ������ ���� ����
			// ������ �������� ���� ���� Ȯ�� ��

			System.out.println(levelLowScreen.questionNum);
			if (levelLowScreen.questionNum == 10) {
				levelLowScreen.setVisible(false);
				SuccessScreen successScreen = new SuccessScreen();
				successScreen.setVisible(true);
			}
			levelLowScreen.nextQuestion();
			// Runnable run = new CheckButton(levelLowScreen.image1);
			// Thread thread = new Thread(run);
			// thread.run();

		} else { // ������ ������ ���� ����
			Life remainLife = new Life(levelLowScreen.life, --levelLowScreen.remainLifeCount);
			remainLife.lifeReduce();
			// Point.MinusLife();
			if (levelLowScreen.remainLifeCount == 0) {
				levelLowScreen.setVisible(false);
				FailScreen failScreen = new FailScreen();
				failScreen.setVisible(true);
			}
			right = true;
			if (levelLowScreen.questionNum == 10) {
				levelLowScreen.setVisible(false);
				SuccessScreen successScreen = new SuccessScreen();
				successScreen.setVisible(true);
			}
		}
	}

	public void run() {
		try {
			image.setVisible(true);
			Thread.sleep(2000);
			image.setVisible(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
		life[count].setIcon(new ImageIcon("photo\\lifex.png"));
	}

	public void lifeIncrease() {
		life[count].setIcon(new ImageIcon("photo\\life.png"));
	}
}

class LevelMiddleScreen extends LevelLowScreen {
	JButton[] restTime = new JButton[16];

	public LevelMiddleScreen() {

		setBounds(125, 30, 870, 570);

		panel.remove(jTextArea1);
		textIcon = new ImageIcon("photo\\game22.jpg");
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
		panel.add(jTextArea1);

		makeComponent3();

		panel.remove(image);
		ImageIcon icon = new ImageIcon("photo\\game2.png");

		image = new JLabel(icon);
		image.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		panel.add(image);

		Runnable run = new Timer(restTime);
		Thread thread = new Thread(run);
		thread.start();
	}

	public void makeComponent3() {

		int interval = 110; // Ÿ�̸� ��ư ����
		for (int i = 0; i < 16; i++) {
			restTime[i] = new JButton();
			restTime[i].setBackground(Color.WHITE);
			restTime[i].setOpaque(false);
			restTime[i].setBorderPainted(false);

			if (i < 8)
				restTime[i].setIcon(new ImageIcon("photo\\�����ڽ�.png"));
			else
				restTime[i].setIcon(new ImageIcon("photo\\�����ڽ�.png"));

			restTime[i].setBounds(20, interval, 49, 28);
			panel.add(restTime[i]);
			interval += 25;
		}
	}

	
}

class Timer implements Runnable {
	JButton[] restTime;

	public Timer(JButton[] restTime) {
		this.restTime = restTime;
	}

	public void run() {
		long startTime = System.currentTimeMillis();
		long endTime = 0;
		int i = 0;

		for (;;) {
			endTime = System.currentTimeMillis();
			if (endTime - startTime > 3000) {
				restTime[i++].setIcon(new ImageIcon("photo\\ȸ���ڽ�.png"));
				startTime = System.currentTimeMillis();
			}

			if (i > 15)
				break;
		}
	}
}

class LevelHighScreen extends LevelMiddleScreen { // ������ ������ �κ�

	Blind Bin;

	public LevelHighScreen() {

		panel.remove(jTextArea1);
		textIcon = new ImageIcon("photo\\game33.jpg");
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
		panel.add(jTextArea1);

		panel.remove(image);
		ImageIcon icon = new ImageIcon("photo\\game3.png"); // ���� �׸�

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

	public SuccessScreen() {

		setTitle("Magician Of Code");
		setBounds(230, 150, 300, 280);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		panel = new JPanel();
		panel.setLayout(null);

		makeComponent();
		getContentPane().add(panel, BorderLayout.CENTER);

		Runnable run = new LastFlash(this);
		Thread thread = new Thread(run);
		thread.start();
	}

	public void makeComponent() {
		jLabel1 = new JLabel();
		jLabel1.setFont(new Font("Dialog.plain", 0, 36));
		jLabel1.setIcon(new ImageIcon("photo\\success.png"));
		jLabel1.setBackground(new Color(White));
		jLabel1.setBounds(0, 0, 300, 240);
		panel.add(jLabel1);
	}
}

class FailScreen extends JFrame {

	JPanel panel;

	JLabel jLabel1;

	public FailScreen() {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		setResizable(false);

		setTitle("Magician Of Code");
		setBounds(230, 150, 300, 280);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);

		makeComponent();
		getContentPane().add(panel, BorderLayout.CENTER);

		Runnable run = new LastFlash(this);
		Thread thread = new Thread(run);
		thread.start();
	}

	public void makeComponent() {
		jLabel1 = new JLabel();
		jLabel1.setFont(new Font("Dialog.plain", 0, 36));
		jLabel1.setIcon(new ImageIcon("photo\\fail.png"));
		jLabel1.setForeground(new Color(-13421773));
		jLabel1.setBackground(new Color(-1118482));
		jLabel1.setBounds(0, 0, 300, 240);
		panel.add(jLabel1);
	}
}

class LastFlash implements Runnable {
	SuccessScreen successScreen;
	FailScreen failScreen;

	public LastFlash(SuccessScreen successScreen) {
		this.successScreen = successScreen;
	}

	public LastFlash(FailScreen failScreen) {
		this.failScreen = failScreen;
	}

	public void run() {
		try {
			Thread.sleep(2000);
			if (successScreen == null) {
				failScreen.setVisible(false);
				FinalScreen finalScreen = new FinalScreen();
				finalScreen.setVisible(true);
			} else {
				successScreen.setVisible(false);
				RankingPopup rankingPopup = new RankingPopup();
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

	public RankingPopup() {

		setTitle("Magician Of Code");
		setBounds(235, 174, 430, 315);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("photo\\rankingP.png");
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
		;
		jButton1.setIcon(new ImageIcon("photo\\ok.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(180, 215, 80, 33);
		ActionListener listener1 = new RankingRegisterButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);
	}
}

class RankingRegisterButton implements ActionListener {
	RankingPopup rankingPopup;

	public RankingRegisterButton(RankingPopup rankingPopup) {
		this.rankingPopup = rankingPopup;
	}

	public void actionPerformed(ActionEvent e) {
		// ������ ��ŷ ���� --> ������ ���缭 db�� ���Ͻ�ų �� �ʿ�! �˰����� �ʿ�..!

		rankingPopup.setVisible(false);
		RankingScreen rankingScreen = new RankingScreen(0);
		rankingScreen.setVisible(true);

	}
}

class RankingScreen extends JFrame {
	JPanel panel;

	JLabel jLabel1;
	JTextArea jTextArea1;
	JButton jButton1, jButton2, jButton3, jButton4;

	int num = 0;

	public RankingScreen(int num) {
		this.num = num;

		setTitle("Magician Of Code");
		setBounds(141, 33, 527, 585);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("photo\\rankingS.png");
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
		RankingPrint rankingPrint = new RankingPrint(this, 1); // default�� ���̵� ��
																// ��ŷ ����
		rankingPrint.actionPerformed(null); // 1 = ��, 2 = ��, 3 = ��

		jButton1 = new JButton();
		jButton1.setIcon(new ImageIcon("photo\\��ŷ������.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(395, 485, 102, 37);
		ActionListener listener1 = new FinalScreenButton(this, num);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setIcon(new ImageIcon("photo\\��ŷ��.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(332, 80, 50, 35);
		ActionListener listener2 = new RankingPrint(this, 1);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setIcon(new ImageIcon("photo\\��ŷ��.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(381, 80, 50, 35);
		ActionListener listener3 = new RankingPrint(this, 2);
		jButton3.addActionListener(listener3);
		panel.add(jButton3);

		jButton4 = new JButton();
		jButton4.setIcon(new ImageIcon("photo\\��ŷ��.png"));
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
		case 1: // ���̵� �� ��ŷ ����
			Database_ranking.showRankingHigh();

			rankingScreen.jTextArea1.setText("\t��  ��\t��  ��\t��  ��\t��  ��\n");
			for (i = 0; i < 10; i++) {
				rankingScreen.jTextArea1.append((i + 1) + "��" + "\t" + Database_ranking.highrank[i][1] + "\t"
						+ Database_ranking.highrank[i][2] + "\t" + Database_ranking.highrank[i][3] + "\t"
						+ Database_ranking.highrank[i][4] + "\n");
			}
			break;
		case 2: // ���̵� �� ��ŷ ����
			Database_ranking.showRankingMid();

			rankingScreen.jTextArea1.setText("\t��  ��\t��  ��\t��  ��\t��  ��\n");
			for (i = 0; i < 10; i++) {
				rankingScreen.jTextArea1.append(
						(i + 1) + "��" + "\t" + Database_ranking.midrank[i][1] + "\t" + Database_ranking.midrank[i][2]
								+ "\t" + Database_ranking.midrank[i][3] + "\t" + Database_ranking.midrank[i][4] + "\n");
			}
			break;
		case 3: // ���̵� �� ��ŷ ����
			Database_ranking.showRankingLow();

			rankingScreen.jTextArea1.setText("\t��  ��\t��  ��\t��  ��\t��  ��\n");
			for (i = 0; i < 10; i++) {
				rankingScreen.jTextArea1.append(
						(i + 1) + "��" + "\t" + Database_ranking.lowrank[i][1] + "\t" + Database_ranking.lowrank[i][2]
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
			System.out.println("�����̹� �˻� ����");
		}

		try {
			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://165.229.90.36:3306/scheme??autoReconnect=true&useSSL=false",
					"root", "thrhd");

			System.out.println("My-SQL ���Ӽ���");
			con.close();
		} catch (SQLException e) {
			System.out.println("My-SQL ���ӽ���");
		}
	}
}

class ranking {

	String[][] highrank = new String[10][5];
	String[][] midrank = new String[10][5];
	String[][] lowrank = new String[10][5];
	int score, life;
	String level, name, time;

	void addRanking() {

		String sql = "insert into ranking values(?,?,?,?,?)";

		try {

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
				System.out.println("�߰� ����");
			} else {
				System.out.println("�߰� ����");
			}
		} catch (SQLException e) {
			System.out.println("������ �߰� ����");
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

			String sql = "select * from ranking where LEVEL = '��' order by SCORE desc, TIME, LIFE desc";

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
			System.out.println("���¿���");
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

			String sql = "select * from ranking where LEVEL = '��' order by SCORE desc, TIME, LIFE desc";

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
			System.out.println("���¿���");
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

			String sql = "select * from ranking where LEVEL = '��' order by SCORE desc, TIME, LIFE desc";

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
			System.out.println("���¿���");
		}
		return lowrank;
	}
}

class question {

	String dex, problem, answer, explain;
	String[][] arr = new String[10][4];// �ε���,����,��,�ؼ�
	int i;
	int[] randnum = new int[30];
	String[] qustnum = new String[10];
	int j;
	int tmp2;
	int level;

	// showQuest�Լ����� println�κ��� �迭�� ���������� ������� Ȯ���ϴ� �κ��̶��� �ڵ� ��ĥ�� �����ø� �˴ϴ�~
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
			// ���ߺ� �����Լ�
			Random ra = new Random();
			for (j = 0; j < 30; j++) {
				randnum[j] = j;
			}
			for (j = 0; j < 30; j++) {
				int desti = ra.nextInt(30);
				tmp2 = randnum[j];
				randnum[j] = randnum[desti];
				randnum[desti] = tmp2;
			}
			for (j = 0; j < 10; j++) {
				qustnum[j] = Integer.toString(randnum[j]);// 10��
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
			// ���ߺ� �����Լ�
			Random ra = new Random();
			for (j = 0; j < 30; j++) {
				randnum[j] = j;
			}
			for (j = 0; j < 30; j++) {
				int desti = ra.nextInt(30);
				tmp2 = randnum[j];
				randnum[j] = randnum[desti];
				randnum[desti] = tmp2;
			}
			for (j = 0; j < 10; j++) {
				qustnum[j] = Integer.toString(randnum[j]);// 10��
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
					System.out.println("d?");
					System.out.println((i + 1) + ". " + arr[i][1]);
					System.out.println(arr[i][2] + "\n" + arr[i][3]);
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
			// ���ߺ� �����Լ�
			Random ra = new Random();
			for (j = 0; j < 30; j++) {
				randnum[j] = j;
			}
			for (j = 0; j < 30; j++) {
				int desti = ra.nextInt(30);
				tmp2 = randnum[j];
				randnum[j] = randnum[desti];
				randnum[desti] = tmp2;
			}
			for (j = 0; j < 10; j++) {
				qustnum[j] = Integer.toString(randnum[j]);// 10��
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

	public FinalScreenButton(RankingScreen rankingScreen, int num) {
		this.rankingScreen = rankingScreen;
		this.num = num;
	}

	public FinalScreenButton(RetryScreen retryScreen, int num) {
		this.retryScreen = retryScreen;
		this.num = num;
	}

	public FinalScreenButton(SolutionScreen solutionScreen) {
		this.solutionScreen = solutionScreen;
	}

	public void actionPerformed(ActionEvent e) {
		if (num == 2) {
			rankingScreen.setVisible(false);
			StartScreen2 startScreen2 = new StartScreen2();
			startScreen2.setVisible(true);
		} else if (num == 1) {
			retryScreen.setVisible(false);
			FinalScreen finalScreen = new FinalScreen();
			finalScreen.setVisible(true);
		} else {
			if (solutionScreen == null)
				rankingScreen.setVisible(false);
			else
				solutionScreen.setVisible(false);
			FinalScreen finalScreen = new FinalScreen();
			finalScreen.setVisible(true);
		}
	}
}

class FinalScreen extends JFrame {
	JPanel panel;

	JButton jButton1, jButton2, jButton3, jButton4, jButton5;

	public FinalScreen() {

		setTitle("Magician Of Code");
		setBounds(125, 30, 870, 570);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("photo\\lastscreen.png");
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
		jButton1.setIcon(new ImageIcon("photo\\retryB.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(360, 30, 140, 52);
		ActionListener listener1 = new RetryButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setIcon(new ImageIcon("photo\\solu.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(360, 90, 140, 52);
		ActionListener listener2 = new SolutionButton(this);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setIcon(new ImageIcon("photo\\ranking.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(360, 150, 140, 52);
		ActionListener listener3 = new RankingButton(this);
		jButton3.addActionListener(listener3);
		panel.add(jButton3);

		jButton4 = new JButton();
		jButton4.setIcon(new ImageIcon("photo\\again.png"));
		jButton4.setBackground(Color.WHITE);
		jButton4.setOpaque(false);
		jButton4.setBorderPainted(false);
		jButton4.setBounds(360, 210, 140, 52);
		ActionListener listener4 = new ReturnButton(this, 0);
		jButton4.addActionListener(listener4);
		panel.add(jButton4);

		jButton5 = new JButton();
		jButton5.setIcon(new ImageIcon("photo\\end.png"));
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

	public RetryButton(FinalScreen finalScreen) {
		this.finalScreen = finalScreen;
	}

	public void actionPerformed(ActionEvent e) {
		finalScreen.setVisible(false);
		RetryScreen retryScreen = new RetryScreen();
		retryScreen.setVisible(true);
	}
}

class SolutionButton implements ActionListener {
	FinalScreen finalScreen;

	public SolutionButton(FinalScreen finalScreen) {
		this.finalScreen = finalScreen;
	}

	public void actionPerformed(ActionEvent e) {
		finalScreen.setVisible(false);
		SolutionScreen solutionScreen = new SolutionScreen();
		solutionScreen.setVisible(true);
	}
}

class RankingButton implements ActionListener {
	StartScreen2 startScreen2;
	FinalScreen finalScreen;
	int num = 0;

	public RankingButton(StartScreen2 startScreen2, int num) {
		this.startScreen2 = startScreen2;
		this.num = num;
	}

	public RankingButton(FinalScreen finalScreen) {
		this.finalScreen = finalScreen;
	}

	public void actionPerformed(ActionEvent e) {
		if (startScreen2 == null)
			finalScreen.setVisible(false);
		else
			startScreen2.setVisible(false);
		RankingScreen rankingScreen = new RankingScreen(num);
		rankingScreen.setVisible(true);
	}
}

class RetryScreen extends LevelLowScreen {
	JButton jButton1;

	public RetryScreen() {

		makeComponent5();

		panel.remove(image);
		ImageIcon icon = new ImageIcon("photo\\retry.png");

		image = new JLabel(icon);
		image.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		panel.add(image);
	}

	public void makeComponent5() {

		jLabel1.setVisible(false);
		jLabel2.setVisible(false);
		jLabel3.setVisible(false);
		life[0].setVisible(false);
		life[1].setVisible(false);
		life[2].setVisible(false);

		jButton1 = new JButton();
		jButton1.setFont(new Font("Dialog.plain", 0, 12));
		jButton1.setIcon(new ImageIcon("photo\\return.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(10, 7, 60, 60);
		ActionListener listener1 = new FinalScreenButton(this, 1);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton3.removeActionListener(listener3);
		jButton3.setText("��������");
		// ActionListener listener3 = new (); // ���������� ���� ����
		// jButton3.addActionListener(listener3);

		jButton4.removeActionListener(listener1);
		jButton4.removeActionListener(listener4);
		jButton4.setText("��������");
		// ActionListener listener4 = new (); // ���������� ���� ����
		// jButton4.addActionListener(listener4);
	}
}

class SolutionScreen extends JFrame {
	JPanel panel;

	JTextField jTextField1, jTextField2;

	JButton jButton1, jButton2, jButton3;

	public SolutionScreen() {

		setTitle("Magician Of Code");
		setBounds(125, 30, 870, 570);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("photo\\solution.png");
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
		jTextField1.setText(" ");
		jTextField1.setFont(new Font("Dialog.plain", 0, 12));
		jTextField1.setBackground(new Color(255, 255, 255, 178));
		jTextField1.setBounds(50, 60, 340, 390);
		panel.add(jTextField1);

		jTextField2 = new JTextField();
		jTextField2.setText(" ");
		jTextField2.setFont(new Font("Dialog.plain", 0, 12));
		jTextField2.setBackground(new Color(255, 255, 255, 178));
		jTextField2.setBounds(455, 60, 340, 390);
		panel.add(jTextField2);

		jButton1 = new JButton();
		jButton1.setIcon(new ImageIcon("photo\\return.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(6, 7, 60, 60);
		ActionListener listener1 = new FinalScreenButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setIcon(new ImageIcon("photo\\before.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(30, 445, 115, 66);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setIcon(new ImageIcon("photo\\next.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(695, 445, 115, 66);
		panel.add(jButton3);
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
	int num = 0;
	ArrayList<String> list;

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

	void QueProvider() {
		//String str = QueArr[num++][2];
		String str = "#include <stdio.h> \nint main() \n{ \n\tprintf(\"Hello wolrd\\n\"); \n\treturn 0; \n} ";                       
		//System.out.println(str);
		boolean end = false;
		char space = ' ';
		list = new ArrayList<String>();
		int i = 0;
		for (i = 0 ; ; i++) {
			for (int j = i ; j < str.length() ; j++) {
				if (j == str.length() - 1) {
					list.add(str.substring(i, j));
					end = true;
					break;
				}
				if (space == str.charAt(j)) {
					list.add(str.substring(i, j));
					list.add(" ");
					i = j;
					break;
				}
			}
			if (end)
				break;
		}
		//String str = QueArr[num++][2];
		/*String str = "#include $ <stdio.h> @ int $ main() @ { @ # printf( \"Hello $ wolrd\\n\" ); @ # return $ 0; @ }";
		int i = 0, j = 0;
		int tmp;
		Random rd = new Random();
		StringTokenizer st = new StringTokenizer(str);
		int[] temp = new int[st.countTokens()];
		Tokenize = new String[st.countTokens()];
		tokennumber = st.countTokens();
		
		while (st.hasMoreTokens()) {
			temp[i] = i;
			Tokenize[i] = st.nextToken();
			i++;
		}
		for (i = 0; i < tokennumber; i++) {
			int des = rd.nextInt(tokennumber);
			tmp = temp[i];
			temp[i] = temp[des];
			temp[des] = tmp;
		}

		for (j = 0; j < 3;) {
			int num = rd.nextInt(tokennumber);
			if (Tokenize[num].equals("@") || Tokenize[num].equals("\"") || Tokenize[num].equals("#") || Tokenize[num].equals("$"))
				continue;
			if (j == 1 && Tokenize[temp[j - 1]].equals(Tokenize[num])) {
				continue;
			}
			if ((j == 2 && Tokenize[temp[j - 2]].equals(Tokenize[num]))
					|| (j == 2 && Tokenize[temp[j - 1]].equals(Tokenize[num]))) {
				continue;
			}
			temp[j] = num;
			j++;
		}

		for (j = 0; j < 2; j++) {
			for (int k = j + 1; k < 3; k++) {
				if (temp[j] > temp[k]) {
					tmp = temp[j];
					temp[j] = temp[k];
					temp[k] = tmp;
				}
			}
		}

		for (j = 0; j < 3; j++) {
			Answer[j] = Tokenize[temp[j]];
			Tokenize[temp[j]] = "_" + j + "_";
		}
		System.out.println("Queparser : " + Answer[0] + " " + Answer[1] + " "
		+ Answer[2]); */
	}

	int AnsCheck() {

		if (isCorrect == 1) {
			isCorrect = 0;
			return 1;
		} else {
			return 0;
		}
	}

	void BonusQueProvider() {
		// String str = QueArr[0][0];
		String str = "#include <stdio.h> void main ()" + "{ printf( \" Hello wolrd \" ) ;}";
		int i = 0, j = 0;
		int tmp;
		Random rd = new Random();
		StringTokenizer st = new StringTokenizer(str);
		temp = new int[st.countTokens()];
		Tokenize = new String[st.countTokens()];
		while (st.hasMoreTokens()) {
			temp[i] = i;
			Tokenize[i] = st.nextToken();
			i++;
		}
		for (i = 0; i < st.countTokens(); i++) {
			int des = rd.nextInt(st.countTokens());
			tmp = temp[i];
			temp[i] = temp[des];
			temp[des] = tmp;
		}
		for (j = 0; j < 3; j++) {
			Answer[j] = Tokenize[temp[j]];
			Tokenize[temp[j]] = "(***)";
		}
	}
}

class PointChecker {
	int StartPoint;
	int HintPoint;
	int PassPoint;
	int LeftLifePoint;
	int LeftTime;
	int Level;

	PointChecker(int level) {
		this.StartPoint = 100;
		this.HintPoint = 0;
		this.PassPoint = 0;
		this.LeftLifePoint = 0;
		this.LeftTime = 0;
		this.Level = level;
	}

	int GetTotalScore() {
		if (Level == 1) {
			return StartPoint + HintPoint + PassPoint + LeftLifePoint + (5 * LeftTime);
		} else {
			return StartPoint + HintPoint + PassPoint + LeftLifePoint;
		}
	}

	void MinusHint() {
		this.HintPoint -= 5;
	}

	void MinusPass() {
		this.PassPoint -= 10;
	}

	void MinusLife() {
		this.LeftLifePoint -= 10;
	}

	void SetLevel(int Button_value) {
		this.Level = Button_value;
	}

	void SetLeftTime(int UI_LeftTime) {
		this.LeftTime += UI_LeftTime;
	}
}

class Blind extends QueParser {

	public Blind() {
		super(3);
	}

	void QueProvider() {
		// String str = QueArr[0][0];
		String str = "#include <stdio.h> void main ()" + "{ printf( \" Hello wolrd \" ) ;}";
		int i = 0, j = 0;
		int tmp;
		Random rd = new Random();
		StringTokenizer st = new StringTokenizer(str);
		int[] temp = new int[st.countTokens()];
		Tokenize = new String[st.countTokens()];
		while (st.hasMoreTokens()) {
			temp[i] = i;
			Tokenize[i] = st.nextToken();
			i++;
		}
		for (i = 0; i < st.countTokens(); i++) {
			int des = rd.nextInt(st.countTokens());
			tmp = temp[i];
			temp[i] = temp[des];
			temp[des] = tmp;
		}
		for (j = 0; j < 3; j++) {
			Answer[j] = Tokenize[temp[j]];
			Tokenize[temp[j]] = "(***)";
		}
		for (j = 4; j < st.countTokens(); j++) {
			Tokenize[temp[j]] = "(BLIND!)";
		}
	}

	int AnsCheck() {

		if (isCorrect == 1) {
			isCorrect = 0;
			return 1;
		} else {
			return 0;
		}
	}

}

/**
 * @brief ���� �Լ��� ������ Ŭ�����Դϴ�.
 * @details DB ������ ������ �����մϴ�.
 * @author �Ұ� 2�� �ڵ��Ǹ�����
 * @date 2016-11-26
 * @version 0.0.1
 */

public class imagetest {
	public static void main(String[] args) {

		connectDatabase Database_connect = new connectDatabase();
		Database_connect.connect();

		LevelChoiceScreen1 GUI_Interface = new LevelChoiceScreen1();
		GUI_Interface.setVisible(true);
	}
}