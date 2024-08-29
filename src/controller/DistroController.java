package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {
	
	public DistroController() {
		super();
	}
	
	private String identOS() {
		String sistema = System.getProperty("os.name");
		return sistema;
	}
	
	private void callProcess(String call) {
		String[] callArr = call.split(" ");
		
		try {
			Process process = Runtime.getRuntime().exec(callArr);
			InputStream retorno = process.getInputStream();
			InputStreamReader leitor = new InputStreamReader(retorno);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = " ";
			while(!linha.contains("PRETTY_NAME")) {
				linha = buffer.readLine();
				if(linha.contains("PRETTY_NAME")) {
					String[] distroArr = linha.split("\"");
					String[] distroArr2 = distroArr[1].split(" ");
					System.out.println("Distro: " + distroArr[0] + " " + distroArr2[2]);
				}
			}
			retorno.close();
			leitor.close();
			buffer.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void exibeDistro() {
		String OS = identOS();
		
		if(OS.contains("Linux")) {
			String call = "cat /etc/os-release";
			callProcess(call);
		}else {
			System.out.println("Sistema operacional não é linux, encerrando aplicação");
			System.exit(0);
		}
	}
}
