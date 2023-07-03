package org.sp.app0703.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener, KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p;
	JTextField t;
	JButton bt;
	ChatB chatB;

	public ChatA() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p = new JPanel();
		t = new JTextField(16);
		bt = new JButton("open");
		
		//부착
		add(scroll); //center는 명시할 필요 없음.
		p.add(t); //아래쪽 패널에 부착
		p.add(bt); //아래쪽 패널에 부착
		add(p, BorderLayout.SOUTH); //아래쪽에 패널부착
				
		setBounds(200, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		//버튼과 리스너의 연결
		bt.addActionListener(this);
		t.addKeyListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// System.out.println("창 열림 버튼");
		chatB = new ChatB(this);
	}
	

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode(); //js에서 event.keyCode 와 유사
		if (key == KeyEvent.VK_ENTER) {
			//System.out.println("Enter 쳤어?");
			//1) 나의 창의 area에 입력한 대입
			String msg = t.getText();
			area.append(msg+"\n");
			t.setText(""); //입력한 값 초기화
			
			//2) ChatB 창의 area에 입력한 값 대입
			chatB.area.append(msg+"\n");
			chatB.t.setText(""); //입력한 값 초기화
		}
		// System.out.println(key); -> enter키의 아스키코드 찾는 콘솔
	}

	public static void main(String[] args) {
		new ChatA();
	}
}
