package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController() {
		super ();
	}
		private String os() {
			String os = System.getProperty("os.name");	//getProperty é uma propriedade que pede uma chave em formato de String, 
														//nesse caso foi os.name
			return os;
		}
		
		public void listaProcessos() {
			if (os().contains("Windows")) {
				
				//bloco "try" "catch", no "try" ele tenta executar linha por linha, se der erro (Exception) ele cai no bloco catch, e guarda 
				//tds as infos da exceção na variável ao lado "e"*. Então ele faz as linhas de tratamento do erro.
				
				try {
					String x = "TASKLIST /FO TABLE";
					Process p = Runtime.getRuntime().exec(x); //para a aplicação java chamar outro processo
					
					InputStream dados = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(dados);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					
					while (linha!=null) {
						System.out.println(linha);
						linha = buffer.readLine();
					
					}
					buffer.close();
					leitor.close();
					dados.close();
					
				} catch (IOException e) { //*. IOException é a classe base para exceções geradas ao acessar informações usando fluxos,
										  //arquivos e diretórios
					// TODO Auto-generated catch block
					e.printStackTrace(); // esse "e.printStackTrace()" só mostra no console qual foi o erro
				}
			}
		}
		
		public void mataPid(int param) {
			if (os().contains("Windows")) {
				try {
					String x = "TASKKILL /PID";
					StringBuffer buffer = new StringBuffer();
					buffer.append(x);
					buffer.append(" ");
					buffer.append(param);
					
					Runtime.getRuntime().exec(buffer.toString());
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}
		
		public void mataNome(String nome) {
			if (os().contains("Windows")) {
				try {
					String x = "TASKKILL /IM";
					StringBuffer buffer = new StringBuffer();
					buffer.append(x);
					buffer.append(" ");
					buffer.append(nome);
					
					Runtime.getRuntime().exec(buffer.toString());
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}
}
