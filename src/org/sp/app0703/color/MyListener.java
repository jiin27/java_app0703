package org.sp.app0703.color;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//왼쪽 프레임에서 발생하는 액션 이벤트를 감지하는 리스너
public class MyListener implements ActionListener {
	LeftFrame leftFrame; //현재 값 null
	RightFrame rightFrame;
	
	//MyListener 인 '나'를 new 연산자로 메모리에 올리는 者는 생성자의 매개변수로 LeftFrame의 인스턴스를 전달해달라는 것.
	//이때, LeftFrame의 주소값을 넘겨받았기 때문에 leftFrame의 변수로는 원본객체를 제어할 수 있다!! (call by reference)
	public MyListener(LeftFrame leftFrame) {
		// 아래처럼 새롭게 생성하지 말고, 기존의 좌측창의 주소값을 얻어오자.
		this.leftFrame = leftFrame;
	}
	
	//사용자들이 클릭을 누르면 아래의 메서드가 자동으로 호출된다 - 콜백 메서드
	public void actionPerformed(ActionEvent e) {
		//사용자가 발생시킨 액션 이벤트는 ActionEvent 객체의 인스턴스화되어 이메서드로 전달되어 진다.
		//따라서 이 ActionEvent의 인스턴스로부터 각종 이벤트 정보들을 얻어낼 수 있다.
		System.out.println(e);
		
		Object obj = e.getSource(); //사용자가 누른 컴포넌트를 반환
		
		//사용자가 누른 버튼이 좌측 프레임이 보유한 bt_open이라면, RightFrame()을 띄우겠다.
		if(obj == leftFrame.bt_open) {
			// 우측에 친구창 띄우기
			rightFrame = new RightFrame(leftFrame); //인스턴스로 생성된 RightFrame()의 주소값을 변수로 받기. -> 주소값을 받아 추후에 제어하기 위해서
		} else if(obj == leftFrame.bt_red) {
			//이미 태어난 우측창의 색상을 변경
			System.out.println("red버튼 눌림");
			rightFrame.p.setBackground(Color.RED);
			
		} else if(obj == leftFrame.bt_orange) {
			System.out.println("orange버튼 눌림");
			rightFrame.p.setBackground(Color.ORANGE);

		} else if(obj == leftFrame.bt_yellow) {
			System.out.println("yellow버튼 눌림");
			rightFrame.p.setBackground(Color.YELLOW);

		}

	}

}
