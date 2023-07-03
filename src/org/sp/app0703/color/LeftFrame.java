package org.sp.app0703.color;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeftFrame extends JFrame{
	JButton bt_open;
	JButton bt_red;
	JButton bt_orange;
	JButton bt_yellow;
	JPanel p; //색상을 적용하기 위함.
	
	//has a 관계로 부품을 가지고 있다는 것은, 이 본체가 태어날 때 부품들도 함께 생성되어야 한다. 따라서 초기화할 이유가 있다.
	//즉, 생성자 메서드를 적극 활용해보자
	public LeftFrame() {
		bt_open = new JButton("열기");
		bt_red = new JButton("red");
		bt_orange = new JButton("orange");
		bt_yellow = new JButton("yellow");
		p = new JPanel();
		
		//버튼에 배경색 적용하기
		Color c;
		bt_red.setBackground(Color.RED);
		bt_orange.setBackground(Color.ORANGE);
		bt_yellow.setBackground(Color.YELLOW);
		p.setPreferredSize(new Dimension(280, 300));
		
		this.setLayout(new FlowLayout()); //배치관리자 변경 적용
		
		add(bt_open);
		add(bt_red);
		add(bt_orange);
		add(bt_yellow);
		add(p);
		
		setVisible(true);
		//setSize() 기능에, 윈도우의 위치(좌표)까지 지어할 수 있는 메서드.
		//setSize(300, 400);
		setBounds(100, 200, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//버튼과 리스너 연결
		MyListener listener = new MyListener(this); // 좌측창의 인스턴스를 매개변수로 넘겨야 한다.
		bt_open.addActionListener(listener);
		bt_red.addActionListener(listener);
		bt_orange.addActionListener(listener);
		bt_yellow.addActionListener(listener);
	}
	
	public static void main(String[] args) {
		new LeftFrame();
	}
}
