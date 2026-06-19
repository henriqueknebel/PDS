package academia;

public class PlanoModel {

	 public static double calcularValor(String plano, String duracao, String frequencia) {
	        double valorBase = 0;

	        // Plano
	        switch (plano) {
	            case "Básico":
	                valorBase = 80;
	                break;
	            case "Intermediário":
	                valorBase = 120;
	                break;
	            case "Premium":
	                valorBase = 180;
	                break;
	        }

	        // Frequência
	        if (frequencia.equals("3x")) {
	            valorBase *= 1.2;
	        } else if (frequencia.equals("5x")) {
	            valorBase *= 1.5;
	        }

	        // Duração
	        if (duracao.equals("Semestral")) {
	            valorBase *= 0.9;
	        } else if (duracao.equals("Anual")) {
	            valorBase *= 0.8;
	        }

	        return valorBase;
	  }

}
