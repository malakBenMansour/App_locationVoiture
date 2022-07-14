package lb.applicationstage.locationvoiture.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Modele implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable = false,updatable = false)
private  int id ;
private String nom;
private int nbplaces;
private  int nbportes;
private float volumecoffre;
private String puissance;
private String version;

public Modele (){}

    public Modele(String nom, int nbplaces, int nbportes, float volumecoffre, String puissance, String version) {
        this.nom = nom;
        this.nbplaces = nbplaces;
        this.nbportes = nbportes;
        this.volumecoffre = volumecoffre;
        this.puissance = puissance;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbplaces() {
        return nbplaces;
    }

    public void setNbplaces(int nbplaces) {
        this.nbplaces = nbplaces;
    }

    public int getNbportes() {
        return nbportes;
    }

    public void setNbportes(int nbportes) {
        this.nbportes = nbportes;
    }

    public float getVolumecoffre() {
        return volumecoffre;
    }

    public void setVolumecoffre(float volumecoffre) {
        this.volumecoffre = volumecoffre;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    @ManyToOne
    private Marque marque;

    @JsonIgnore
    @ManyToOne
    private Categorie categorie;

    @JsonIgnore
    @ManyToOne
    private Energie energie;

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Energie getEnergie() {
        return energie;
    }

    public void setEnergie(Energie energie) {
        this.energie = energie;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="modele")
    private List<Vehicule> ListVehicule;

    public List<Vehicule> getListVehicule() {
        return ListVehicule;
    }

    public void setListVehicule(List<Vehicule> listVehicule) {
        ListVehicule = listVehicule;
    }
}
