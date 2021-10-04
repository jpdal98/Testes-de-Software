package br.ufc.entities;

import java.util.ArrayList;
import java.util.List;

public class Pets {
    private int id;
    private static int proxid = 1;
    private String nome;
    private String raça;
    private int dono;
    private List<Serviços> serviços = new ArrayList<>();

    public Pets(String nome, String raça, int dono) {
        this.nome = nome;
        this.raça = raça;
        this.dono = dono;
        this.IncrementarId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public int getDono() {
        return dono;
    }

    public void setDono(int dono) {
        this.dono = dono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getProxid() {
        return proxid;
    }

    public void setServiços(List<Serviços> serviços) {
        this.serviços = serviços;
    }

    public void IncrementarId(){
        this.id = this.proxid;
        this.proxid++;
    }

    public static void setProxid(int proxid) {
        Pets.proxid = proxid;
    }

    public List<Serviços> getServiços() {
        return serviços;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id + " ");
        sb.append("nome: ");
        sb.append(this.nome + " ");
        sb.append("raca: ");
        sb.append(this.raça + " ");
        sb.append("dono: ");
        sb.append(this.dono);
        return sb.toString();

    }
}
