package lb.applicationstage.locationvoiture.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Energie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private int id;

    private String nom;

    public Energie(){}
    public Energie(String nom)
    {
        this.nom=nom;
    }
    public int getId(){return  id;}
    public String getNom(){return nom;}
    public void setId(int id){this.id=id;}
    public void setNom(String nom){this.nom=nom;}

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="energie")
    private List<Modele> ListModele;


    public List<Modele> getListModele() {
        return ListModele;
    }

    public void setListModele(List<Modele> listModele) {
        ListModele = listModele;
    }
}
