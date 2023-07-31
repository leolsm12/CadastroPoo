/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leosc
 */


public class PessoaFisicaRepo {
        private Map<Integer, PessoaFisica> mapaPessoas;
        
        public PessoaFisicaRepo() { mapaPessoas = new HashMap<>();}

    public void inserir(PessoaFisica pessoaFisica) {
        mapaPessoas.put(pessoaFisica.getId(), pessoaFisica);
    }

    public void alterar(PessoaFisica pessoaFisica) {
        if (mapaPessoas.containsKey(pessoaFisica.getId())) {
            mapaPessoas.put(pessoaFisica.getId(), pessoaFisica);
        } else {
            System.out.println("Pessoa não encontrada. Não foi possível realizar a alteração.");
        }
    }

    public void excluir(int id) {
        mapaPessoas.remove(id);
    }

    public PessoaFisica obter(int id) {
        return mapaPessoas.get(id);
        
    }

    public List<PessoaFisica> obterTodos() {
        return new ArrayList<>(mapaPessoas.values());
    }

    public void persistir(String nomeArquivo) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(nomeArquivo));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(mapaPessoas);
        oos.close();
        System.out.println("Dados de Pessoa Fisica Armazenados.");
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File(nomeArquivo));
        ObjectInputStream ois = new ObjectInputStream(fis);
        mapaPessoas = (Map<Integer, PessoaFisica>) ois.readObject();
        ois.close();
        System.out.println("Dados de Pessoa Fisica Recuperados.");
    }

    public void inserir(PessoaJuridica pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    

}