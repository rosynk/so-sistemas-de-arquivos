	package view;

	import javax.swing.JOptionPane;

	import controller.RedesController;

	public class MainRedes {
		public static void main(String[] args) {

			int opcao;

			do {
				opcao = Integer.parseInt(
						JOptionPane.showInputDialog("Informe uma opção\n\n" + "01. Ping\n" + "02. IP\n" + "00. Finalizar"));

				opcoes(opcao);
			} while (opcao != 0);
		}

		private static void opcoes(int valor) {
			RedesController rdC = new RedesController();
			switch (valor) {
			
			case 0:
				JOptionPane.showMessageDialog(null, "Finalizado!");
				break;
			
			case 1:
				rdC.ping();
				break;

			case 2:
				rdC.ip();
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		}
	}

