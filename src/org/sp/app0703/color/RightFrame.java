package org.sp.app0703.color;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RightFrame extends JFrame{
	JButton bt_green;
	JButton bt_blue;
	JButton bt_pink;
	JPanel p; //용도: 색상을 부여하기 위함. panel은 div와 흡사.
	LeftFrame leftFrame; //null 이기 때문에 기존에 이미 생성되어 있는 LeftFrame을 가져와야 한다.
	
	//has a 관계로 부품을 가지고 있다는 것은, 이 본체가 태어날 때 부품들도 함께 생성되어야 한다. 따라서 초기화할 이유가 있다.
	//즉, 생성자 메서드를 적극 활용해보자
	public RightFrame(LeftFrame leftFrame) {
		bt_green = new JButton("green");
		bt_blue = new JButton("blue");
		bt_pink = new JButton("pink");
		p = new JPanel();
		this.leftFrame = leftFrame;
		
		//버튼에 배경색 적용하기
		Color c;
		bt_green.setBackground(Color.GREEN);
		bt_blue.setBackground(Color.BLUE);
		bt_pink.setBackground(Color.PINK);
		p.setPreferredSize(new Dimension(280, 300));
		
		this.setLayout(new FlowLayout()); //배치관리자 변경 적용
		
		add(bt_green);
		add(bt_blue);
		add(bt_pink);
		add(p);
		
		setVisible(true);
		//setSize(300, 400);
		setBounds(400, 200, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//버튼과 리스너와의 연결
		MyListener2 listener = new MyListener2(this);
		
		bt_green.addActionListener(listener);
		bt_blue.addActionListener(listener);
		bt_pink.addActionListener(listener);
	}
	
}
