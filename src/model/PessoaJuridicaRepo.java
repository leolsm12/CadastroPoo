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


public class PessoaJuridicaRepo {

    private Map<Integer, PessoaJuridica> mapaPessoas;
    
    public PessoaJuridicaRepo() { mapaPessoas = new HashMap<>();}

    public void inserir(PessoaJuridica pessoaJuridica) {
        mapaPessoas.put(pessoaJuridica.getId(), pessoaJuridica);
    }

    public void alterar(PessoaJuridica pessoaJuridica) {
        if (mapaPessoas.containsKey(pessoaJuridica.getId())) {
            mapaPessoas.put(pessoaJuridica.getId(), pessoaJuridica);
            System.out.println("Pessoa alterada com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada. Não foi possível realizar a alteração.");
        }
    }

    public void excluir(int id) {
        mapaPessoas.remove(id);
        System.out.println("Pessoa excluida com sucesso!");
    }

    public PessoaJuridica obter(int id) {
        return mapaPessoas.get(id);
    }

    public List<PessoaJuridica> obterTodos() {
        return new ArrayList<>(mapaPessoas.values());
    }

    public void persistir(String nomeArquivo) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(nomeArquivo));
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(mapaPessoas);
        }
        System.out.println("Dados de Pessoa Juridica Armazenados.");
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File(nomeArquivo));
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            mapaPessoas = (Map<Integer, PessoaJuridica>) ois.readObject();
        }
        System.out.println("Dados de Pessoa Juridica Recuperados.");
    }


}
