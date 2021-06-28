package VendingMachine;

import java.util.HashMap;

import javax.swing.JOptionPane;

/**
 * @author Ji-Hoon Shim
 * @date 2016-04-09
 * @brief 잔돈에 대한 액션이 구현되어 있는 클래스
 * 
 */

public class Change{
	
	MachineUI mainFrame = null;
	
	HashMap<Integer, Coin> Coins = null;
	
	private Coin c10 = null;
	private Coin c50 = null;
	private Coin c100 = null;
	private Coin c500 = null;
	private Coin c1000 = null;
	
	/**
	 * 
	 * @param f 알림창을 중앙에 띄우기 위해 MachineUI 인스턴스를 불러옴
	 */
	public Change(MachineUI f){
		c10 = new Coin("10", 50);
		c50 = new Coin("50", 50);
		c100 = new Coin("100", 50);
		c500 = new Coin("500", 50);
		c1000 = new Coin("1000", 50);
		
		Coins = new HashMap();
		
		Coins.put(10, c10);
		Coins.put(50, c50);
		Coins.put(100, c100);
		Coins.put(500, c500);
		Coins.put(1000, c1000);
		
		mainFrame = f;
	}
	
	/**
	 * 
	 * @param money 얼만큼 거스를 것인지를 나타냄
	 */
	public boolean returnCharges(int money){
		int NumberOf10 = 0;
		int NumberOf50 = 0;
		int NumberOf100 = 0;
		int NumberOf500 = 0;
		int NumberOf1000 = 0;
		
		int total = 1000 * Coins.get(1000).getNumber()
					+ 500 * Coins.get(500).getNumber()
					+ 100 * Coins.get(100).getNumber()
					+ 50 * Coins.get(50).getNumber()
					+ 10 * Coins.get(10).getNumber();  // 거스름 돈이 부족한지 판단하기 위해 사용
		
		if(money <= 0){  // 거스를 돈이 없을 경우
			JOptionPane.showMessageDialog(mainFrame, "거스를 돈이 없습니다.",
					"Notice", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(total < money){  // 거스름 돈이 부족한 경우
			JOptionPane.showMessageDialog(mainFrame, "죄송합니다. 거스름 돈이 부족합니다. 관리자에게 문의하십시오.",
					"Notice", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		while(money >= 10){  // 동전의 갯수를 최소화하면서 거스름돈을 계산하는 과정
			if(money >= 1000 && Coins.get(1000).getNumber() > 0){
				money = money - 1000;
				NumberOf1000++;
				Coins.get(1000).setNumber(Coins.get(1000).getNumber() - 1);
			}
			else if(money >= 500 && Coins.get(500).getNumber() > 0){
				money = money - 500;
				NumberOf500++;
				Coins.get(500).setNumber(Coins.get(500).getNumber() - 1);
			}
			else if(money >= 100 && Coins.get(100).getNumber() > 0){
				money = money - 100;
				NumberOf100++;
				Coins.get(100).setNumber(Coins.get(100).getNumber() - 1);
			}
			else if(money >= 50 && Coins.get(50).getNumber() > 0){
				money = money - 50;
				NumberOf50++;
				Coins.get(50).setNumber(Coins.get(50).getNumber() - 1);
			}
			else if(money >= 10 && Coins.get(10).getNumber() > 0){
				money = money - 10;
				NumberOf10++;
				Coins.get(10).setNumber(Coins.get(10).getNumber() - 1);
			}
		}
		
		JOptionPane.showMessageDialog(mainFrame, String.format("잔돈이 나왔습니다. \n 10원: %d개 \n 50원: %d개 \n 100원: %d개 \n 500원: %d개 \n 1000원: %d개", NumberOf10, NumberOf50, NumberOf100, NumberOf500, NumberOf1000),
				"Notice", JOptionPane.INFORMATION_MESSAGE);
		
		return true;
	}
	
	/**
	 * 
	 * @param c10 추가하려는 10원짜리 동전의 갯수
	 * @param c50 추가하려는 50원짜리 동전의 갯수
	 * @param c100 추가하려는 100원짜리 동전의 갯수
	 * @param c500 추가하려는 500원짜리 동전의 갯수
	 * @param c1000 추가하려는 1000원짜리 지폐의 갯수
	 */
	public void inputCharges(int c10, int c50, int c100, int c500, int c1000){
		this.c10.setNumber(this.c10.getNumber() + c10);
		this.c50.setNumber(this.c50.getNumber() + c50);
		this.c100.setNumber(this.c100.getNumber() + c100);
		this.c500.setNumber(this.c500.getNumber() + c500);
		this.c1000.setNumber(this.c1000.getNumber() + c1000);
		// 거스름용 돈을 지정한 수만큼 추가함
	}
}