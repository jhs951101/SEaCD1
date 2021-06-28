package VendingMachine;

import java.awt.EventQueue;

/**
 * @author Ji-Hoon Shim
 * @date 2016-04-09
 * @brief Main Class
 * 
 */

public class Machine{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MachineUI frame = new MachineUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}