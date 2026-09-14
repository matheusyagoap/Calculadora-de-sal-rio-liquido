package com.mycompany.calculosalario;

import java.util.Scanner;

public class Calculosalario {

    String nome;
    int matricula;
    int qtdDependentes;
    float salario;

    public static void main(String[] args) {
        Calculosalario func = new Calculosalario();
        Scanner sc = new Scanner(System.in);

        int menu = 0;
        float salarioFamilia = 0;
        float inss = 0;
        float impostoRenda = 0;
        float salarioLiquido = 0;

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Cadastrar / Alterar dados");
            System.out.println("2 - Mostrar dados e calcular salario liquido");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opcao: ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("\n--- CADASTRO DE DADOS ---");
                    System.out.print("Digite o nome: ");
                    func.nome = sc.nextLine();

                    System.out.print("Digite a matricula: ");
                    func.matricula = sc.nextInt();

                    System.out.print("Digite a quantidade de dependentes: ");
                    func.qtdDependentes = sc.nextInt();

                    salarioFamilia = 0;

                    for (int i = 1; i <= func.qtdDependentes; i++) {
                        System.out.println("Digite o nome do dependente " + i + ": ");
                        sc.nextLine();
                        String nomeDependente = sc.nextLine();

                        System.out.println("Digite a idade do dependente " + i + ": ");
                        int idadeDependente = sc.nextInt();

                        if (idadeDependente <= 14) {
                            salarioFamilia = salarioFamilia + 67;
                        }
                    }

                    System.out.print("Digite o salario bruto: ");
                    func.salario = sc.nextFloat();

                    System.out.println("Dados cadastrados com sucesso!");
                    break;

                case 2:
                    if (func.nome == null) {
                        System.out.println("Nenhum dado cadastrado ainda! Escolha a opcao 1 primeiro.");
                    } else {
                        if (func.salario <= 3000) {
                            inss = func.salario * 0.08f;
                        } else {
                            inss = func.salario * 0.09f;
                        }

                        if (func.salario > 5000) {
                            impostoRenda = func.salario * 0.15f;
                        } else {
                            impostoRenda = 0;
                        }

                        salarioLiquido = func.salario + salarioFamilia - inss - impostoRenda;

                        System.out.println("\n--- DEMONSTRATIVO DE PAGAMENTO ---");
                        System.out.println("Nome: " + func.nome);
                        System.out.println("Matricula: " + func.matricula);
                        System.out.println("Salario familia: R$ " + salarioFamilia);
                        System.out.println("Inss: R$ " + inss);
                        System.out.println("Imposto de renda: R$ " + impostoRenda);
                        System.out.println("Salario liquido: R$ " + salarioLiquido);
                    }
                    break;

                case 3:
                    System.out.println("Valew por usar nossa calculadora...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (menu != 3);

        sc.close();
    }
}
