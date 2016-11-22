import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class StartScreen1 extends JFrame {
	JPanel panel;

	JLabel jLabel1;

	public StartScreen1() {

		setTitle("Magician Of Code");
		setBounds(137, 35, 870, 570);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\first.png"); // 넣을 그림
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) { // 페인트 컴포넌트 함수로 jpanel에 넣음
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		panel.setLayout(null);

		makeComponent();

		getContentPane().add(panel, BorderLayout.CENTER);

		Runnable run = new StartScreenFlash(this);
		Thread thread = new Thread(run);
		thread.start();
	}

	public void makeComponent() {
		jLabel1 = new JLabel();
		jLabel1.setText(" ");
		jLabel1.setFont(new Font("Dialog.plain", 0, 22));
		jLabel1.setIcon(new ImageIcon(""));
		jLabel1.setForeground(new Color(-13421773));
		jLabel1.setBackground(new Color(-1118482));
		jLabel1.setBounds(192, 180, 144, 36);
		panel.add(jLabel1);
	}
}

class StartScreenFlash implements Runnable {
	StartScreen1 startScreen1;

	public StartScreenFlash(StartScreen1 startScreen1) {
		this.startScreen1 = startScreen1;
	}

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

class StartScreen2 extends JFrame {
	JPanel panel;

	JButton jButton1, jButton2, jButton3;

	public StartScreen2() {

		setTitle("Magician Of Code");
		setBounds(125, 30, 870, 570);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\startscreen.png"); // 넣을
																			// 그림
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) { // 페인트 컴포넌트 함수로 jpanel에 넣음
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
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\start.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(390, 190, 140, 52);
		ActionListener listener1 = new StartButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setFont(new Font("Dialog.plain", 0, 12));
		jButton2.setIcon(new ImageIcon("C:\\photoshop\\ranking.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(390, 250, 140, 52);
		ActionListener listener2 = new RankingButton(this, 2);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setFont(new Font("Dialog.plain", 0, 12));
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

	JLabel jLabel1, jLabel2, jLabel3;

	JTextField jTextField1, jTextField2;

	JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7;
	JButton[] exButton = new JButton[12];
	JButton[] life = new JButton[3];

	ActionListener listener1;
	ActionListener listener2;

	int exButtonCount = 0;

	public TutorialScreen() {

		setTitle("Magician Of Code");
		setBounds(125, 30, 870, 670);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\tutorial.png");
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) { // 페인트 컴포넌트 함수로 jpanel에 넣음
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setLayout(null);

		makeComponent();
		setExButton();

		getContentPane().add(panel, BorderLayout.CENTER);

		Runnable run = new Time(jLabel1, jLabel2);
		Thread thread = new Thread(run);
		thread.start();
	}

	public void makeComponent() {
		jTextField1 = new JTextField();
		jTextField1.setText("문제문제문제");
		jTextField1.setFont(new Font("Dialog.plain", 0, 12));
		jTextField1.setBackground(new Color(255, 255, 255, 178));
		jTextField1.setBounds(75, 59, 323, 454);
		panel.add(jTextField1);

		jTextField2 = new JTextField();
		jTextField2.setText("안녕? 나는 도로시야 코드의 마법사를 찾으러 왔구나!");
		jTextField2.setFont(new Font("Dialog.plain", 0, 12));
		jTextField2.setOpaque(false);
		jTextField2.setBorder(null);
		jTextField2.setBounds(200, 504, 329, 90);
		panel.add(jTextField2);

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

		for (int i = 0; i < 12; i++) {
			exButton[i] = new JButton();
			exButton[i].setText("보기" + (i + 1));
			exButton[i].setFont(new Font("Dialog.plain", 0, 12));
			exButton[i].setIcon(new ImageIcon(""));
			exButton[i].setBackground(new Color(255, 255, 255, 250));
			ActionListener listener = new ExButtonMoving(this, i);
			exButton[i].addActionListener(listener);
			panel.add(exButton[i]);
		}

		jButton1 = new JButton();
		jButton1.setFont(new Font("Dialog.plain", 0, 12));
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\reset.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(610, 470, 102, 40);
		listener1 = new ResetButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setFont(new Font("Dialog.plain", 0, 12));
		jButton2.setIcon(new ImageIcon("C:\\photoshop\\check.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(728, 470, 100, 40);
		listener2 = new CheckButton(this, 1);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setFont(new Font("Dialog.plain", 0, 12));
		jButton3.setIcon(new ImageIcon("C:\\photoshop\\hint.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(728, 310, 102, 40);
		panel.add(jButton3);

		jButton4 = new JButton();
		jButton4.setFont(new Font("Dialog.plain", 0, 12));
		jButton4.setIcon(new ImageIcon("C:\\photoshop\\pass.png"));
		jButton4.setBackground(Color.WHITE);
		jButton4.setOpaque(false);
		jButton4.setBorderPainted(false);
		jButton4.setBounds(728, 356, 102, 40);
		panel.add(jButton4);

		jButton5 = new JButton();
		jButton5.setFont(new Font("Dialog.plain", 0, 12));
		jButton5.setIcon(new ImageIcon(" "));
		jButton5.setBackground(Color.WHITE);
		jButton5.setOpaque(false);
		jButton5.setBorderPainted(false);
		jButton5.setBounds(15, 10, 1, 1);
		ActionListener listener5 = new ReturnButton(this, 1);
		jButton5.addActionListener(listener5);
		panel.add(jButton5);

		jButton6 = new JButton();
		jButton6.setFont(new Font("Dialog.plain", 0, 12));
		jButton6.setIcon(new ImageIcon("C:\\photoshop\\skip.png"));
		jButton6.setBackground(Color.WHITE);
		jButton6.setOpaque(false);
		jButton6.setBorderPainted(false);
		jButton6.setBounds(5, 8, 87, 37);
		ActionListener listener6 = new SkipButton(this);
		jButton6.addActionListener(listener6);
		panel.add(jButton6);

		jButton7 = new JButton();
		jButton7.setFont(new Font("Dialog.plain", 0, 12));
		jButton7.setIcon(new ImageIcon(""));
		// jButton7.setBackground(Color.WHITE);
		// jButton7.setOpaque(false);
		// jButton7.setBorderPainted(false);
		jButton7.setBounds(671, 547, 60, 33);
		ActionListener listener7 = new NextButton(this, 0);
		jButton7.addActionListener(listener7);
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
		switch(num++) {
		case 0: {
			tutorialScreen.jTextField2.setText("안녕하세요");
			break;
		}
		case 1: {
			tutorialScreen.jTextField2.setText("반가워요");
			break;
		}
		case 2: {
			tutorialScreen.jTextField2.setText("감사합니다");
			break;
		}
		case 3: {
			tutorialScreen.jTextField2.setText("ㅎㅎㅎㅎㅎㅎ");
			break;
		}
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

	public ExButtonMoving(TutorialScreen tutorialScreen, int i) {
		this.tutorialScreen = tutorialScreen;
		this.i = i;
	}

	public void actionPerformed(ActionEvent e) {
		switch (tutorialScreen.exButtonCount) {
		case 0:
			tutorialScreen.exButton[i].setBounds(407, 405, tutorialScreen.exButton[i].getWidth(),
					tutorialScreen.exButton[i].getHeight());
			break;
		case 1:
			tutorialScreen.exButton[i].setBounds(551, 405, tutorialScreen.exButton[i].getWidth(),
					tutorialScreen.exButton[i].getHeight());
			break;
		case 2:
			tutorialScreen.exButton[i].setBounds(697, 405, tutorialScreen.exButton[i].getWidth(),
					tutorialScreen.exButton[i].getHeight());
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

		ImageIcon icon = new ImageIcon("C:\\photoshop\\level.png"); // 넣을 그림
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) { // 페인트 컴포넌트 함수로 jpanel에 넣음
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
		// jButton1.setText("하");
		jButton1.setFont(new Font("Dialog.plain", 0, 12));
		// jButton1.setIcon(new ImageIcon(""));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(60, 270, 170, 200);
		ActionListener listener1 = new LevelLowButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		// jButton2.setText("중");
		jButton2.setFont(new Font("Dialog.plain", 0, 12));
		// jButton2.setIcon(new ImageIcon(""));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(345, 270, 170, 200);
		ActionListener listener2 = new LevelMiddleButton(this);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		// jButton3.setText("상");
		jButton3.setFont(new Font("Dialog.plain", 0, 12));
		// jButton3.setIcon(new ImageIcon(""));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setForeground(new Color(-13421773));
		jButton3.setBounds(610, 270, 170, 200);
		ActionListener listener3 = new LevelHighButton(this);
		jButton3.addActionListener(listener3);
		panel.add(jButton3);
	}
}

class LevelLowButton implements ActionListener {
	LevelChoiceScreen1 levelChoiceScreen1;

	public LevelLowButton(LevelChoiceScreen1 levelChoiceScreen1) {
		this.levelChoiceScreen1 = levelChoiceScreen1;
	}

	public void actionPerformed(ActionEvent e) {
		levelChoiceScreen1.setVisible(false);
		LevelLowScreen levelLowScreen = new LevelLowScreen();
		levelLowScreen.setVisible(true);
	}
}

class LevelMiddleButton implements ActionListener {
	LevelChoiceScreen1 levelChoiceScreen1;

	public LevelMiddleButton(LevelChoiceScreen1 levelChoiceScreen1) {
		this.levelChoiceScreen1 = levelChoiceScreen1;
	}

	public void actionPerformed(ActionEvent e) {
		levelChoiceScreen1.setVisible(false);
		LevelMiddleScreen levelMiddleScreen = new LevelMiddleScreen();
		levelMiddleScreen.setVisible(true);
	}
}

class LevelHighButton implements ActionListener {
	LevelChoiceScreen1 levelChoiceScreen1;

	public LevelHighButton(LevelChoiceScreen1 levelChoiceScreen1) {
		this.levelChoiceScreen1 = levelChoiceScreen1;
	}

	public void actionPerformed(ActionEvent e) {
		levelChoiceScreen1.setVisible(false);
		LevelHighScreen levelHighScreen = new LevelHighScreen();
		levelHighScreen.setVisible(true);
	}
}

class LevelLowScreen extends TutorialScreen {

	int remainHintCount = 3;
	int remainPassCount = 3;
	int remainLifeCount = 3;

	JLabel image;

	ActionListener listener3, listener4;

	public LevelLowScreen() {

		setBounds(125, 30, 870, 570);
		ImageIcon icon = new ImageIcon("C:\\photoshop\\game1.png"); // 넣을 그림

		image = new JLabel(icon);
		image.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		panel.add(image);

		makeComponent2();
		setExButton();

	}

	public void makeComponent2() {

		jButton2.removeActionListener(listener2);
		ActionListener listener2 = new CheckButton(this, 0);
		jButton2.addActionListener(listener2);
		jButton2.addActionListener(listener1);

		listener3 = new HintButton();
		jButton3.addActionListener(listener3);

		listener4 = new PassButton();
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
}

class HintButton implements ActionListener {

	public HintButton() {

	}

	public void actionPerformed(ActionEvent e) {
		// 힌트 기능
	}
}

class PassButton implements ActionListener {

	public PassButton() {

	}

	public void actionPerformed(ActionEvent e) {
		// 패스 기능
	}
}

class CheckButton implements ActionListener {
	TutorialScreen tutorialScreen;
	LevelLowScreen levelLowScreen;

	int num = 0;

	boolean right = true;

	public CheckButton(TutorialScreen tutorialScreen, int num) {
		this.tutorialScreen = tutorialScreen;
		this.num = num;
	}

	public CheckButton(LevelLowScreen levelLowScreen, int num) {
		this.levelLowScreen = levelLowScreen;
		this.num = num;
	}

	public void actionPerformed(ActionEvent e) {

		if (num == 1) { // 듀토리얼 화면에서 넘어온 경우
			LevelChoiceScreen1 levelChoiceScreen1 = new LevelChoiceScreen1();
			levelChoiceScreen1.setVisible(true);
			tutorialScreen.setVisible(false);
		}

		else { // 게임화면에서 넘어온 경우
				// 선택한 보기와 답을 비교

			if (right == true) { // 정답을 맞춘 경우
				// 다음문제 출제 함수

				// 끝가지 성공했을 경우 조건 확인 후
				levelLowScreen.setVisible(false);
				SuccessScreen successScreen = new SuccessScreen();
				successScreen.setVisible(true);
			} else { // 정답을 맞추지 못한 경우
				Life remainLife = new Life(levelLowScreen.life, --levelLowScreen.remainLifeCount);
				remainLife.lifeReduce();
				if (levelLowScreen.remainLifeCount == 0) {
					levelLowScreen.setVisible(false);
					FailScreen failScreen = new FailScreen();
					failScreen.setVisible(true);
				}
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
		life[count].setIcon(new ImageIcon("C:\\photoshop\\life.png"));
	}

	public void lifeIncrease() {
		life[count].setIcon(new ImageIcon("C:\\photoshop\\life.png"));
	}
}

class LevelMiddleScreen extends LevelLowScreen {
	JButton[] restTime = new JButton[16];

	public LevelMiddleScreen() {

		setBounds(125, 30, 870, 570);

		makeComponent3();

		panel.remove(image);
		ImageIcon icon = new ImageIcon("C:\\photoshop\\game2.png"); // 넣을 그림

		image = new JLabel(icon);
		image.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		panel.add(image);

		Runnable run = new Timer(restTime);
		Thread thread = new Thread(run);
		thread.start();
	}

	public void makeComponent3() {
		int interval = 272; // 타이머 버튼 간격
		for (int i = 0; i < 16; i++) {
			restTime[i] = new JButton();
			restTime[i].setBackground(Color.WHITE);
			restTime[i].setOpaque(false);
			restTime[i].setBorderPainted(false);

			if (i < 8)
				restTime[i].setIcon(new ImageIcon("C:\\photoshop\\노란박스.png"));
			else
				restTime[i].setIcon(new ImageIcon("C:\\photoshop\\빨간박스.png"));

			restTime[i].setBounds(20, interval, 25, 14);
			panel.add(restTime[i]);
			interval += 15;
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
				restTime[i++].setIcon(new ImageIcon("C:\\photoshop\\회색박스.png"));
				startTime = System.currentTimeMillis();
			}

			if (i > 15)
				break;
		}
	}
}

class LevelHighScreen extends LevelMiddleScreen { // 가리기 구현할 부분

	public LevelHighScreen() {

		panel.remove(image);
		ImageIcon icon = new ImageIcon("C:\\photoshop\\game3.png"); // 넣을 그림

		JLabel image = new JLabel(icon);
		image.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		panel.add(image);

		makeComponent4();
	}

	public void makeComponent4() {

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
		jLabel1.setIcon(new ImageIcon("C:\\photoshop\\success.png"));
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

	JLabel jLabel1;
	JTextField jTextField1;
	JButton jButton1;

	public RankingPopup() {

		setTitle("Magician Of Code");
		setBounds(235, 174, 430, 315);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\rankingP.png"); // 넣을 그림
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) { // 페인트 컴포넌트 함수로 jpanel에 넣음
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
		jLabel1 = new JLabel();
		jLabel1.setFont(new Font("Dialog.plain", 0, 12));
		jLabel1.setIcon(new ImageIcon(""));
		jLabel1.setForeground(new Color(-13421773));
		jLabel1.setBackground(new Color(-1118482));
		jLabel1.setBounds(88, 37, 117, 24);
		panel.add(jLabel1);

		jTextField1 = new JTextField();
		jTextField1.setFont(new Font("Dialog.plain", 0, 12));
		jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		jTextField1.setForeground(new Color(-13421773));
		jTextField1.setBackground(new Color(-1));
		jTextField1.setBounds(150, 177, 132, 25);
		panel.add(jTextField1);

		jButton1 = new JButton();
		jButton1.setFont(new Font("Dialog.plain", 0, 12));
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\ok.png"));
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
		// 디비에 랭킹 등록

		rankingPopup.setVisible(false);
		RankingScreen rankingScreen = new RankingScreen(0);
		rankingScreen.setVisible(true);
	}
}

class RankingScreen extends JFrame {
	JPanel panel;

	JLabel jLabel1;
	JTextField jTextField1;
	JButton jButton1, jButton2, jButton3, jButton4;

	int num = 0;

	public RankingScreen(int num) {
		this.num = num;

		setTitle("Magician Of Code");
		setBounds(141, 33, 527, 585);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		ImageIcon icon = new ImageIcon("C:\\photoshop\\rankingS.png"); // 넣을 그림
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) { // 페인트 컴포넌트 함수로 jpanel에 넣음
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

		jLabel1 = new JLabel();
		jLabel1.setFont(new Font("Dialog.plain", 0, 35));
		jLabel1.setIcon(new ImageIcon(""));
		jLabel1.setForeground(new Color(-13421773));
		jLabel1.setBackground(new Color(-1118482));
		jLabel1.setBounds(196, 29, 133, 37);
		panel.add(jLabel1);

		jTextField1 = new JTextField();
		jTextField1.setText("");
		jTextField1.setFont(new Font("Dialog.plain", 0, 12));
		jTextField1.setForeground(new Color(-13421773));
		jTextField1.setBackground(new Color(-1));
		jTextField1.setBounds(39, 114, 442, 369);
		panel.add(jTextField1);

		jButton1 = new JButton();
		jButton1.setFont(new Font("Dialog.plain", 0, 12));
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\랭킹나가기.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(395, 485, 102, 37);
		ActionListener listener1 = new FinalScreenButton(this, num);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setFont(new Font("Dialog.plain", 0, 12));
		jButton2.setIcon(new ImageIcon("C:\\photoshop\\랭킹상.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(332, 80, 50, 35);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setFont(new Font("Dialog.plain", 0, 12));
		jButton3.setIcon(new ImageIcon("C:\\photoshop\\랭킹중.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(381, 80, 50, 35);
		panel.add(jButton3);

		jButton4 = new JButton();
		jButton4.setFont(new Font("Dialog.plain", 0, 12));
		jButton4.setIcon(new ImageIcon("C:\\photoshop\\랭킹하.png"));
		jButton4.setBackground(Color.WHITE);
		jButton4.setOpaque(false);
		jButton4.setBorderPainted(false);
		jButton4.setBounds(430, 80, 50, 35);
		panel.add(jButton4);
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

		ImageIcon icon = new ImageIcon("C:\\photoshop\\lastscreen.png"); // 넣을
																			// 그림
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) { // 페인트 컴포넌트 함수로 jpanel에 넣음
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
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\retryB.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(360, 30, 140, 52);
		ActionListener listener1 = new RetryButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setFont(new Font("Dialog.plain", 0, 12));
		jButton2.setIcon(new ImageIcon("C:\\photoshop\\solu.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(360, 90, 140, 52);
		ActionListener listener2 = new SolutionButton(this);
		jButton2.addActionListener(listener2);
		panel.add(jButton2);

		jButton3 = new JButton();
		;
		jButton3.setFont(new Font("Dialog.plain", 0, 12));
		jButton3.setIcon(new ImageIcon("C:\\photoshop\\ranking.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(360, 150, 140, 52);
		ActionListener listener3 = new RankingButton(this);
		jButton3.addActionListener(listener3);
		panel.add(jButton3);

		jButton4 = new JButton();
		jButton4.setFont(new Font("Dialog.plain", 0, 12));
		jButton4.setIcon(new ImageIcon("C:\\photoshop\\again.png"));
		jButton4.setBackground(Color.WHITE);
		jButton4.setOpaque(false);
		jButton4.setBorderPainted(false);
		jButton4.setBounds(360, 210, 140, 52);
		ActionListener listener4 = new ReturnButton(this, 0);
		jButton4.addActionListener(listener4);
		panel.add(jButton4);

		jButton5 = new JButton();
		jButton5.setFont(new Font("Dialog.plain", 0, 12));
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
		ImageIcon icon = new ImageIcon("C:\\photoshop\\retry.png"); // 넣을 그림

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
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\return.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(10, 7, 60, 60);
		ActionListener listener1 = new FinalScreenButton(this, 1);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton3.removeActionListener(listener3);
		jButton3.setText("이전문제");
		// ActionListener listener3 = new (); // 이전문제로 가기 구현
		// jButton3.addActionListener(listener3);

		jButton4.removeActionListener(listener1);
		jButton4.removeActionListener(listener4);
		jButton4.setText("다음문제");
		// ActionListener listener4 = new (); // 다음문제로 가기 구현
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

		ImageIcon icon = new ImageIcon("C:\\photoshop\\solution.png"); // 넣을 그림
		Image img = icon.getImage();

		panel = new JPanel() {
			public void paintComponent(Graphics g) { // 페인트 컴포넌트 함수로 jpanel에 넣음
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
		jButton1.setFont(new Font("Dialog.plain", 0, 12));
		jButton1.setIcon(new ImageIcon("C:\\photoshop\\return.png"));
		jButton1.setBackground(Color.WHITE);
		jButton1.setOpaque(false);
		jButton1.setBorderPainted(false);
		jButton1.setBounds(6, 7, 60, 60);
		ActionListener listener1 = new FinalScreenButton(this);
		jButton1.addActionListener(listener1);
		panel.add(jButton1);

		jButton2 = new JButton();
		jButton2.setFont(new Font("Dialog.plain", 0, 12));
		jButton2.setIcon(new ImageIcon("C:\\photoshop\\before.png"));
		jButton2.setBackground(Color.WHITE);
		jButton2.setOpaque(false);
		jButton2.setBorderPainted(false);
		jButton2.setBounds(30, 445, 115, 66);
		panel.add(jButton2);

		jButton3 = new JButton();
		jButton3.setFont(new Font("Dialog.plain", 0, 12));
		jButton3.setIcon(new ImageIcon("C:\\photoshop\\next.png"));
		jButton3.setBackground(Color.WHITE);
		jButton3.setOpaque(false);
		jButton3.setBorderPainted(false);
		jButton3.setBounds(695, 445, 115, 66);
		panel.add(jButton3);
	}
}

public class test {
	public static void main(String[] args) {
		StartScreen1 GUI_Interface = new StartScreen1();
		GUI_Interface.setVisible(true);
	}
}