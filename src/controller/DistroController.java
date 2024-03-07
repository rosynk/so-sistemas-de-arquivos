package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {
	public DistroController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void exibeDistro() {
		if (!this.os().equals("Linux")) {
			System.out.println("ERRO: metodo funciona apenas em Linux!");
			return;
		}

		String comando = "cat /etc/os-release";
		try {
			// Copia o resultado do comando no buffer
			Process p = Runtime.getRuntime().exec(comando);// Executa o terminal
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);

			String linha, primeiraPalavra;
			linha = buffer.readLine(); // quarda oq ta na primeria

			while (linha != null) {
				String[] palavras = linha.split("=");
				primeiraPalavra = palavras[0];
				if (primeiraPalavra.equals("NAME")) {
					System.out.println("Nome da distro = " + palavras[1]);
				} else if (primeiraPalavra.equals("VERSION_ID")) {
					System.out.println("Versão da distro = " + palavras[1]);
				}

				linha = buffer.readLine();

			}

			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (

		Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
