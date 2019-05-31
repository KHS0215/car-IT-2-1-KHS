import java.awt.*;
import javax.swing.*;

class TimeThread extends Thread {
	private JLabel timerLabel;
	
	public TimerThread(JLabel timerLabel){
		this.timerLabel = timerLabel;
	}
	
	@override
	public void run(){
		int n=0;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				return;
			}
		}
	}
}

public class ThreadTimer extends JFrame {
	public ThreadTimerEx(){
		setTitle("Thread�� ��ӹ��� Ÿ�̸� ������ ����");
		setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel TimerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic,Font.ITALIC, 80));
		c.add(timerLabel);
		
		TimerThread th = new TimerThread(timerLabel);
		
		setSize(300,170);
		setVisible(true);
		
		th.start();
	}
	public static void main(String[] args){
		new ThreadTimerEx();
	}
}
