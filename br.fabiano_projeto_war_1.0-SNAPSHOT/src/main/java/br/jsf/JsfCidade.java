/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.data.entity.Cidade;
import br.data.crud.CrudCidade;
import com.mifmif.common.regex.Generex;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author dell
 */
@Named(value = "jsfCidade")
@RequestScoped
public class JsfCidade {

    /**
     * Creates a new instance of JsfCidade
     */
    public JsfCidade() {
    }

    private int codigo;
    private String nome;
    private String cliente;
    
    public java.util.ArrayList<Cidade> getAll() {
        return new CrudCidade().getAll();
    }

    public void add() {
        Cidade cid = new Cidade();
        cid.setCodigo(codigo);
        cid.setNome(nome);
        cid.setCliente(cliente);
        
        new CrudCidade().add(cid);
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addRandon() {

        Generex generex = new Generex("[A-Z]{1}[a-z]*");
        for (int i = 0; i < 5; i++) {
            String cliente = generex.random(5, 30);
            String nome = generex.random(5, 30);
            int codigo = ((int) (Math.random() * 101));
            Cidade cid = new Cidade();
            cid.setCodigo(codigo);
            cid.setNome(nome);
            cid.setNome(cliente);
            new CrudCidade().add(cid);
        }
    }
}
