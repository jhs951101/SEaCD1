package VendingMachine;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Ji-Hoon Shim
 * @date 2016-04-09
 * @brief ������� ���� �׼��� �����Ǿ� �ִ� Ŭ����
 * 
 */

public class BeverageAction{
	
	MachineUI mainFrame = null;
	
	HashMap<Integer, Product> IDnProduct = null;
	
	private Product coke = null;
	private Product cider = null;
	private Product fanta = null;
	private Product orangejuice = null;
	private Product grapejuice = null;
	private Product coffee = null;
	
	
	/**
	 * 
	 * @param f �˸�â�� �߾ӿ� ���� ���� MachineUI �ν��Ͻ��� �ҷ���
	 */
	public BeverageAction(MachineUI f){
		coke = new Product("�ݶ�", 800, 0, 10);
		cider = new Product("���̴�", 700, 0, 10);
		fanta = new Product("ȯŸ", 900, 0, 10);
		orangejuice = new Product("������ �ֽ�", 850, 0, 10);
		grapejuice = new Product("���� �ֽ�", 850, 0, 10);
		coffee = new Product("Ŀ��", 900, 0, 10);
		
		IDnProduct = new HashMap();
		
		IDnProduct.put(0, coke);  // 0: �ݶ�, 1: ���̴�, 2: ȯŸ, 3: �������ֽ�, 4: �����ֽ�, 5: Ŀ��
		IDnProduct.put(1, cider);
		IDnProduct.put(2, fanta);
		IDnProduct.put(3, orangejuice);
		IDnProduct.put(4, grapejuice);
		IDnProduct.put(5, coffee);
		
		this.mainFrame = f;
	}
	
	/**
	 * 
	 * @param id IDnProduct�� key
	 * @param currentmoney ���Ǳ⿡ ���� ���� �ǹ�
	 */
	public boolean giveBeverage(int id, int currentmoney){
		if(IDnProduct.get(id).getPrice() > currentmoney){  // ������ ���ݺ��� ������ ������ ���
			JOptionPane.showMessageDialog(mainFrame, "������ �����մϴ�.", "Notice", 
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(IDnProduct.get(id).getStock() <= 0){  // ������ ������� ��� ���� ���
			JOptionPane.showMessageDialog(mainFrame, "�˼��մϴ�. ��� �����ϴ�.", "Notice", 
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		// ������� �ϳ� �ְ� purchased ���� stock ���� ������
		JOptionPane.showMessageDialog(mainFrame, "���� " + IDnProduct.get(id).getName() + " �ֽ��ϴ�. ���� �Ϸ� �Ǽ���.", "Notice", 
				JOptionPane.INFORMATION_MESSAGE);
		IDnProduct.get(id).setPurchased( IDnProduct.get(id).getPurchased() + 1 );
		IDnProduct.get(id).setStock( IDnProduct.get(id).getStock() - 1 );	
		
		return true;
	}
	
	/**
	 * 
	 * @param coke �߰��Ϸ��� �ݶ��� ����
	 * @param cider �߰��Ϸ��� ���̴��� ����
	 * @param fanta �߰��Ϸ��� ȯŸ�� ����
	 * @param orangejuice �߰��Ϸ��� ������ �ֽ��� ����
	 * @param grapejuice �߰��Ϸ��� ���� �ֽ��� ����
	 * @param coffee �߰��Ϸ��� Ŀ���� ����
	 */
	public void inputBeverages(int coke, int cider, int fanta, int orangejuice, int grapejuice, int coffee){
		this.coke.setStock(this.coke.getStock() + coke);
		this.cider.setStock(this.cider.getStock() + cider);
		this.fanta.setStock(this.fanta.getStock() + fanta);
		this.orangejuice.setStock(this.orangejuice.getStock() + orangejuice);
		this.grapejuice.setStock(this.grapejuice.getStock() + grapejuice);
		this.coffee.setStock(this.coffee.getStock() + coffee);
		// ������� ������ ����ŭ �߰���
	}
}