package org.sp.app0703.chat;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatB extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p;
	JTextField t;
	ChatA chatA;

	public ChatB(ChatA chatA) {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p = new JPanel();
		t = new JTextField(20);
		
		this.chatA = chatA; //주입(injection)
		
		//부착
		add(scroll); //center는 명시할 필요 없음.
		p.add(t); //아래쪽 패널에 부착
		add(p, BorderLayout.SOUTH); //아래쪽에 패널부착
				
		setBounds(500, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
		//t와 리스너 연결
		t.addKeyListener(this);
	}

	public void keyTyped(KeyEvent e) {		
	}

	public void keyPressed(KeyEvent e) {		
	}

	public void keyReleased(KeyEvent e) {
		//System.out.println("입력!");
		
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ENTER) {
			//System.out.println("enter 쳤어");
			//1) 나의 area에 입력한 값 대입
			String msg2 = t.getText();
			area.append(msg2+"\n");
			t.setText("");
			
			//2) ChatA의 area에 입력한 값 대입
			chatA.area.append(msg2+"\n");
		}
		
	}
	
}
