/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import model.PessoaFisica;
import model.PessoaJuridica;
import java.util.Scanner;

/**
  * @author leosc
 */
public class CadastroPOO {
    private static int IdCadastro = 1;
    
    public static int proximoId(){
        return IdCadastro++;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {       
        boolean inicio = true;
      
        model.PessoaFisicaRepo repo1 = new model.PessoaFisicaRepo();
        model.PessoaJuridicaRepo repo2 = new model.PessoaJuridicaRepo();
    
        while(inicio == true){
        
        System.out.println("==================================");
        System.out.println("1 - Incluir Pessoa");
        System.out.println("2 - Alterar Pessoa");
        System.out.println("3 - Excluir Pessoa");
        System.out.println("4 - Buscar pelo Id");
        System.out.println("5 - Exibir Todos");
        System.out.println("6 - Persistir Dados");
        System.out.println("7 - Recuperar Dados");
        System.out.println("0 - Finalizar Programa");
        System.out.println("==================================");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero desejado: ");
        int numero = scanner.nextInt();
        
        
        switch (numero){
        case 1 -> {
            boolean caso = true;
            
            while(caso == true){
                System.out.println("Selecionado Incluir Pessoa");
                System.out.println("F - Pessoa Fisica | J - Pessoa Juridica ");
                String tipoPessoa = scanner.next().toUpperCase();
                
                if(tipoPessoa.equals("F")){
                    System.out.println("Selecionado Pessoa Fisica");
                    PessoaFisica pessoa = new model.PessoaFisica();
                    pessoa.setId(proximoId());
                    
                    /*int Id = scanner.nextInt();*/
                    
                    System.out.println("Digite o Nome: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite a Idade: ");
                    int idade = scanner.nextInt();
                    
                    pessoa.setNome(nome);
                    pessoa.setCpf(cpf);
                    pessoa.setIdade(idade);
                              
                    repo1.inserir(pessoa);
                    caso = false;
                    
                }else if(tipoPessoa.equals("J")){
                    System.out.println("Selecionado Pessoa Juridica");
                    PessoaJuridica pessoa = new model.PessoaJuridica();
                    pessoa.setId(proximoId());
                   
                    
                    System.out.println("Digite o Nome: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CNPJ: ");
                    String cnpj = scanner.nextLine();
                    
                    pessoa.setNome(nome);
                    pessoa.setCnpj(cnpj);
                    
               
                    repo2.inserir(pessoa);
                    caso = false;
                    
                }else {
                    System.out.println("Comando Incorreto!!");
                    caso = true;
                    }
                }   
            }
        case 2 -> {
                boolean caso = true;
                while(caso == true){
                System.out.println("Selecionado Alterar Pessoa");
                System.out.println("F - Pessoa Fisica | J - Pessoa Juridica ");
                String tipoPessoa = scanner.next().toUpperCase();
                
                if(tipoPessoa.equals("F")){
                    System.out.println("Digite o ID da pessoa que deseja alterar: ");
                    PessoaFisica pessoaAlterada = new model.PessoaFisica();
                    int id = scanner.nextInt();
           
                    PessoaFisica pessoaFisica = repo1.obter(id);
                    System.out.println(pessoaFisica);
            
                    System.out.println("Digite o nome: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    
                    System.out.println("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    
                    System.out.println("Digite o Idade: ");
                    int idade = scanner.nextInt();
                    pessoaAlterada.setId(id);
                    pessoaAlterada.setNome(nome);
                    pessoaAlterada.setCpf(cpf);
                    pessoaAlterada.setIdade(idade);
    
                    repo1.alterar(pessoaAlterada);
                    
                    
                    caso = false;

                }else if (tipoPessoa.equals("J")){
                    System.out.println("Digite o ID da pessoa que deseja alterar: ");
                    PessoaJuridica pessoaAlterada = new model.PessoaJuridica();
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    
           
                    PessoaJuridica pessoaJuridica = repo2.obter(id);
                    System.out.println(pessoaJuridica);
            
                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();
                    
                    
                    System.out.println("Digite o CNPJ: ");
                    String cnpj = scanner.nextLine();
                    pessoaAlterada.setId(id);
                    pessoaAlterada.setNome(nome);
                    pessoaAlterada.setCnpj(cnpj);
                    
                    repo2.alterar(pessoaAlterada);
                    
                    
                    caso = false;
                    
                }else{
                    System.out.println("Comando Incorreto!!");
                    caso = true;
                    }
                }  
          
            }
        
        case 3 ->{ 
            
            System.out.println("Selecionado Excluir Pessoa");
            boolean caso = true;
            while(caso == true){
                System.out.println("F - Pessoa Fisica | J - Pessoa Juridica ");
                String tipoPessoa = scanner.next().toUpperCase();
                if(tipoPessoa.equals("F")){
                    System.out.println("Digite o ID da pessoa que deseja excluir: ");
                    int id = scanner.nextInt();
                    repo1.excluir(id);
                 
                    caso = false; 
                }else if (tipoPessoa.equals("J")){
                    System.out.println("Digite o ID da pessoa que deseja excluir: ");
                    int id = scanner.nextInt();
                    repo2.excluir(id);
                    
                    caso = false;
                }else{
                    System.out.println("Comando Incorreto!!");
                    caso = true;
            }
        
          }
        }        
        case 4 -> {
            System.out.println("Selecionado Buscar pelo Id");
            boolean caso = true;
            while(caso == true){
                
                System.out.println("F - Pessoa Fisica | J - Pessoa Juridica ");
                String tipoPessoa = scanner.next().toUpperCase();
                
                if(tipoPessoa.equals("F")){
                    
                    System.out.println("Digite o ID da pessoa que deseja obter: ");
                    int id = scanner.nextInt();
                    
                    PessoaFisica pessoaFisica = repo1.obter(id);
                    System.out.println(pessoaFisica);
                    
                    System.out.println("Pessoa obtida com sucesso!");
               
                
                    caso = false; 
                }else if (tipoPessoa.equals("J")){
                    
                    System.out.println("Digite o ID da pessoa que deseja obter: ");
                    int id = scanner.nextInt();                  
                    
                    
                    PessoaJuridica pessoaJuridica = repo2.obter(id);
                    System.out.println(pessoaJuridica);
                    
                    System.out.println("Pessoa obtida com sucesso!");

                    caso = false;
                }else{
                    System.out.println("Comando Incorreto!!");
                    caso = true;
            }
          }
        }
        case 5 -> {
            System.out.println("Selecionado Exibir Todos");
            
            boolean caso = true;
            while(caso == true){
                
                System.out.println("F - Pessoa Fisica | J - Pessoa Juridica ");
                scanner.nextLine();
                String tipoPessoa = scanner.next().toUpperCase();
                
                if(tipoPessoa.equals("F")){
                    
                   for (PessoaFisica pessoa : repo1.obterTodos()) {
                    System.out.println(pessoa);
               
                   }
              
                    caso = false; 
                }else if (tipoPessoa.equals("J")){
                    
                    for (PessoaJuridica pessoa : repo2.obterTodos()) {
                    System.out.println(pessoa);
                    }

                    caso = false;
                }else{
                    System.out.println("Comando Incorreto!!");
                    caso = true;
            }
          }
        }
        case 6 -> {
            System.out.println("Selecionado  Persistir Dados");
                scanner.nextLine();
                System.out.println("Digite o prefixo do arquivo:");
                String prefixo = scanner.nextLine();
                
                repo1.persistir(prefixo + ".fisica.bin");
                repo2.persistir(prefixo + ".fisica.bin");
        
        }
        case 7 -> {
            System.out.println("Selecionado Recuperar Dados");
                scanner.nextLine();
                System.out.println("Digite o prefixo do arquivo:");
                String prefixo = scanner.nextLine();
                
                repo1.recuperar(prefixo + ".fisica.bin");
                repo2.recuperar(prefixo + ".fisica.bin");
        
        }
        case 0 -> {
            System.out.println("Programa Finalizado!");
            inicio = false;
                }
        default -> System.out.println("Comando Incorreto!!");
            
        }
    }
 }
}   

