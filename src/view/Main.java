package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {
	public static void main(String[] args) {
		KillController KC = new KillController();
		KC.listaProcessos();
		
		int x = Integer.parseInt(JOptionPane.showInputDialog("Informe um PID para matar: ")); 
		KC.mataPid(x);
		
		String k = (JOptionPane.showInputDialog("Informe um nome para matar: "));
		KC.mataNome(k);
	}
}
