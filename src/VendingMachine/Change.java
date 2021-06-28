package VendingMachine;

import java.util.HashMap;

import javax.swing.JOptionPane;

/**
 * @author Ji-Hoon Shim
 * @date 2016-04-09
 * @brief �ܵ��� ���� �׼��� �����Ǿ� �ִ� Ŭ����
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
	 * @param f �˸�â�� �߾ӿ� ���� ���� MachineUI �ν��Ͻ��� �ҷ���
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
	 * @param money ��ŭ �Ž��� �������� ��Ÿ��
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
					+ 10 * Coins.get(10).getNumber();  // �Ž��� ���� �������� �Ǵ��ϱ� ���� ���
		
		if(money <= 0){  // �Ž��� ���� ���� ���
			JOptionPane.showMessageDialog(mainFrame, "�Ž��� ���� �����ϴ�.",
					"Notice", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(total < money){  // �Ž��� ���� ������ ���
			JOptionPane.showMessageDialog(mainFrame, "�˼��մϴ�. �Ž��� ���� �����մϴ�. �����ڿ��� �����Ͻʽÿ�.",
					"Notice", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		while(money >= 10){  // ������ ������ �ּ�ȭ�ϸ鼭 �Ž������� ����ϴ� ����
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
		
		JOptionPane.showMessageDialog(mainFrame, String.format("�ܵ��� ���Խ��ϴ�. \n 10��: %d�� \n 50��: %d�� \n 100��: %d�� \n 500��: %d�� \n 1000��: %d��", NumberOf10, NumberOf50, NumberOf100, NumberOf500, NumberOf1000),
				"Notice", JOptionPane.INFORMATION_MESSAGE);
		
		return true;
	}
	
	/**
	 * 
	 * @param c10 �߰��Ϸ��� 10��¥�� ������ ����
	 * @param c50 �߰��Ϸ��� 50��¥�� ������ ����
	 * @param c100 �߰��Ϸ��� 100��¥�� ������ ����
	 * @param c500 �߰��Ϸ��� 500��¥�� ������ ����
	 * @param c1000 �߰��Ϸ��� 1000��¥�� ������ ����
	 */
	public void inputCharges(int c10, int c50, int c100, int c500, int c1000){
		this.c10.setNumber(this.c10.getNumber() + c10);
		this.c50.setNumber(this.c50.getNumber() + c50);
		this.c100.setNumber(this.c100.getNumber() + c100);
		this.c500.setNumber(this.c500.getNumber() + c500);
		this.c1000.setNumber(this.c1000.getNumber() + c1000);
		// �Ž����� ���� ������ ����ŭ �߰���
	}
}