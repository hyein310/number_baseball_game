import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Gimal201921252Exam extends JFrame implements ActionListener {
	MyPanel panel = new MyPanel();
	JTextField tf = new JTextField(10);
	JButton btn = new JButton("입력");
	RNum rcom = new RNum();
	

	public Gimal201921252Exam() {
		/*난수 발생 수 출력 부분
		 
		this.rcom = rcom;
		System.out.println(rcom.getCom()[0]+""+rcom.getCom()[1]+""+rcom.getCom()[2]);
		
		*/
		panel.add(tf);
		btn.addActionListener(this);
		panel.add(btn);
		
		
		setTitle("야구 GUI 게임 (201921252_강혜인)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new MyPanel());
		
		
		setContentPane(panel);
		
		setSize(400, 400);
		setVisible(true);
	}
	
	
	class MyPanel extends JPanel {

		JTextField tf;
		int strike = 0;
		int ball = 0;
		boolean out = false;
		
		void setData(int strike, int ball, boolean out)
		{
			this.strike = strike;
			this.ball = ball;
			this.out = out;
		}
		
		
		public void paintComponent (Graphics g) {
			super.paintComponent(g);
			
			g.setFont(new Font("굴림",Font.BOLD,20));
			
			if(strike == 3)
			{
				g.setFont(new Font ("굴림",Font.BOLD,50));
				g.drawString("홈런입니다.", 30, 180);
			}
			
			else
			{
				if(strike == 0)
				{
					g.setColor(Color.RED);
					g.drawString("스트라이크", 30, 180);
					g.drawRect(150, 150, 50, 50);
					g.drawRect(210, 150, 50, 50);
				}
				else if(strike == 1)
				{
					g.setColor(Color.RED);
					g.drawString("스트라이크", 30, 180);
					g.fillRect(150, 150, 50, 50);
					g.drawRect(210, 150, 50, 50);
				}
				else
				{
					g.setColor(Color.RED);
					g.drawString("스트라이크", 30, 180);
					g.fillRect(150, 150, 50, 50);
					g.fillRect(210, 150, 50, 50);
				}
				
				if(ball == 0)
				{
					g.setColor(Color.BLUE);
					g.drawString("볼", 30, 240);
					g.drawRect(150, 210, 50, 50);
					g.drawRect(210, 210, 50, 50);
					g.drawRect(270, 210, 50, 50);
				}
				else if(ball == 1)
				{
					g.setColor(Color.BLUE);
					g.drawString("볼", 30, 240);
					g.fillRect(150, 210, 50, 50);
					g.drawRect(210, 210, 50, 50);
					g.drawRect(270, 210, 50, 50);
				}
				else if (ball == 2)
				{
					g.setColor(Color.BLUE);
					g.drawString("볼", 30, 240);
					g.fillRect(150, 210, 50, 50);
					g.fillRect(210, 210, 50, 50);
					g.drawRect(270, 210, 50, 50);
				}
				else
				{
					g.setColor(Color.BLUE);
					g.drawString("볼", 30, 240);
					g.fillRect(150, 210, 50, 50);
					g.fillRect(210, 210, 50, 50);
					g.fillRect(270, 210, 50, 50);
				}
				
				if(!out)
				{
					g.setColor(Color.GREEN);
					g.drawString("아웃", 30, 300);
					g.drawRect(150, 270, 50, 50);
				}
				else
				{
					g.setColor(Color.GREEN);
					g.drawString("아웃", 30, 300);
					g.fillRect(150, 270, 50, 50);
				}
			}
			
		}
	}
			
		
	public void actionPerformed(ActionEvent e) {
		int[] u_num = new int[3];
		
		//입력 다이얼로그 생성
		String input = JOptionPane.showInputDialog("3자리 숫자를 입력하세요.");
		tf.setText(input);
		
		String[] arr = input.split("");
		
			for(int i = 0; i< arr.length; i++)
				{
					u_num[i] = Integer.parseInt(arr[i]);
				}
				BaseballGame b = new BaseballGame(rcom.getCom(), u_num);
				panel.setData(b.getStrike(), b.getBall(), b.getOut());
				panel.repaint();
				
				}


	class RNum
	{ 
		int c_num[]; 
		
		public RNum() { 
			c_num = new int[3]; 
			c_num[0] =(int)(Math.random()*9+1);
			c_num[1] =(int)(Math.random()*9+1); 
			
			while(c_num[0] == c_num[1])
			{ 
				c_num[1] =(int)(Math.random()*9+1); 
			}  
			c_num[2] =(int)(Math.random()*9+1); 
			
			while(c_num[0] == c_num[2] || c_num[1] == c_num[2])
				{ 
				c_num[2] =(int)(Math.random()*9+1); 
				}
			} 
		public int[] getCom() 
		{
			return c_num;  
		} 
	}
	
	class BaseballGame{
		int strike;
		int ball;
		boolean out;
		
		public BaseballGame(int[] com, int[] user) {
			for (int i = 0; i<3; i++)
			{
				for(int j = 0; j<3; j++)
				{
					if (com[i] == user[j])
					{
						if(i==j)
							strike++;
						else
							ball++;
					}
				}
			}
		}
		
		public int getStrike()
		{
			return strike;
		}
		public int getBall()

		{ 
			return ball;
		} 
		public boolean getOut() 
		{ 
			if(strike == 0 && ball== 0)
				return true; 
			else 
				return false;
			}
		}
				

	
	public static void main(String[] args) {
		new Gimal201921252Exam();
	}
}


