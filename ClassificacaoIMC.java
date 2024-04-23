import java.util.Scanner;

public class ClassificacaoIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();

        char genero;
        do {
            System.out.println("Digite seu gênero (M para Masculino, F para Feminino, N para Não informar):");
            genero = scanner.next().charAt(0);
            genero = Character.toLowerCase(genero);
            if (genero != 'm' && genero != 'f' && genero != 'n') {
                System.out.println("Gênero inválido. Tente novamente.");
            }
        } while (genero != 'm' && genero != 'f' && genero != 'n');

        System.out.println("Digite sua altura (em centímetros):");
        double alturaCM = 0;
        while (alturaCM <= 0) {
            alturaCM = scanner.nextDouble();
            if (alturaCM <= 0) {
                System.out.println("Altura inválida. Digite novamente:");
            }
        }

        double altura = alturaCM / 100.0;

        System.out.println("Digite seu peso (em kg):");
        double peso = 0;
        while (peso <= 0) {
            peso = scanner.nextDouble();
            if (peso <= 0) {
                System.out.println("Peso inválido. Digite novamente:");
            }
        }

        double imc = calcularIMC(peso, altura);

        String resultadoIMC = "Seu IMC é: " + imc;

        System.out.println(resultadoIMC);
        System.out.println("Nome: " + nome);
        System.out.println("Gênero: " + ((genero == 'n') ? "Não informado" : (genero == 'm') ? "Masculino" : "Feminino"));
        System.out.println("Altura: " + altura + " metros");
        System.out.println("Peso: " + peso + " kg");

        String classificacao = classificarIMC(imc, genero);

        System.out.println("Classificação do IMC: " + classificacao);

        scanner.close();
    }

    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String classificarIMC(double imc, char genero) {
        if (genero == 'm') { // Masculino
            if (imc < 18.5) {
                return "Abaixo do peso";
            } else if (imc < 24.9) {
                return "Peso normal";
            } else if (imc < 29.9) {
                return "Sobrepeso";
            } else if (imc < 34.9) {
                return "Obesidade grau I";
            } else if (imc < 39.9) {
                return "Obesidade grau II";
            } else {
                return "Obesidade grau III";
            }
        } else { // Feminino
            if (imc < 19.1) {
                return "Abaixo do peso";
            } else if (imc < 25.9) {
                return "Peso normal";
            } else if (imc < 32.4) {
                return "Sobrepeso";
            } else if (imc < 37.5) {
                return "Obesidade grau I";
            } else if (imc < 40.0) {
                return "Obesidade grau II";
            } else {
                return "Obesidade grau III";
            }
        }
    }
}
    
