package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController () {
		
	}
	
	private String os() {
		String os = System.getProperty("os.name");	
		return os;
	}
	
	public void ip () {
		if (os().contains("Linux")) {
			String process = "ip addr";
			
			try {
				
				Process p = Runtime.getRuntime().exec(process); 
				
				InputStream dados = p.getInputStream();
				
				InputStreamReader leitor = new InputStreamReader(dados);
				
				BufferedReader buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				
				while (linha!=null) {
					if (linha.contains("mtu")) {
						System.out.println(linha);
					}
					if (linha.contains("inet")) {
						String[] separa = linha.split(" ");
						System.out.println("IPv4: " + separa[1]);
					}
					linha = buffer.readLine();
				
				}
				
				
			} catch (IOException e) { 
				
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
		} else {
			String process = "IPCONFIG";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader reader = new BufferedReader(leitor);
				String linha = reader.readLine();
				while (linha != null) {
					if (linha.contains("Ethernet")) {
						System.out.println(linha);
					}
					if (linha.contains("IPv4")) {
						System.out.println(linha);
					}
					linha = reader.readLine();
				}
				reader.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	public void ping () {
		if (os().contains("Linux")) {
			String cmd = "ping -4 -c 10 www.google.com.br";
			try {
				Process p = Runtime.getRuntime().exec(cmd);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader reader = new BufferedReader(leitor);
				String linha = reader.readLine();
				while (linha != null) {
					if (linha.contains("rtt")) {
						String[] separa = linha.split("/");
						System.out.println("Média: " + separa[4] + "ms.");
					}
					linha = reader.readLine();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		} else {
			String cmd = "ping -4 -n 10 www.google.com.br";
			try {
				Process p = Runtime.getRuntime().exec(cmd);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader reader = new BufferedReader(leitor);
				String linha = reader.readLine();
				while (linha != null) {
					if (linha.contains("dia")) {
						String[] separa = linha.split(" ");
						System.out.println("Média: " + separa[12]);
					}
					linha = reader.readLine();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			
				}
			
	}
	
}
