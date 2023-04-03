package com.exemple.model;

import java.time.LocalDate;

// Java beans (Entity)
public class Credit {

    private Long credit_id;
    private Produit produit;
    private Client client;
    private int qte;
    private LocalDate date;

    public Credit() {
    }
    public Credit( Produit produit, Client client, int qte, LocalDate date) {

        this.produit = produit;
        this.client = client;
        this.qte = qte;
        this.date = date;
    }
    public Credit(Long credit_id, Produit produit, Client client, int qte, LocalDate date) {
        this.credit_id = credit_id;
        this.produit = produit;
        this.client = client;
        this.qte = qte;
        this.date = date;
    }

    public Long getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(Long credit_id) {
        this.credit_id = credit_id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Long getClientId() {
        if (client != null) {
            return client.getId_client();
        } else {
            return null;
        }
    }
    public Long getProduitId() {
        return this.produit.getId();
    }


    @Override
    public String toString() {
        return "Credit{" +
                "credit_id=" + credit_id +
                ", produit=" + produit +
                ", client=" + client +
                ", qte=" + qte +
                ", date=" + date +
                '}';
    }
}
