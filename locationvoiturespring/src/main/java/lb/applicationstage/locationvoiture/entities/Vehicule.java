package lb.applicationstage.locationvoiture.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Vehicule implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable = false,updatable = false)
private int id;
private String color;
private String nom;
private Date dateDebService;
private int numChassis;
private String matricule;

    public Vehicule() {
    }

    public Vehicule(String color, String nom, Date dateDebService, int numChassis, String matricule) {
        this.color = color;
        this.nom = nom;
        this.dateDebService = dateDebService;
        this.numChassis = numChassis;
        this.matricule = matricule;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebService() {
        return dateDebService;
    }

    public void setDateDebService(Date dateDebService) {
        this.dateDebService = dateDebService;
    }

    public int getNumChassis() {
        return numChassis;
    }

    public void setNumChassis(int numChassis) {
        this.numChassis = numChassis;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    @JsonIgnore
    @ManyToOne
    private Modele modele;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }
    @JsonIgnore
    @ManyToOne
    private Boite boite;

    public Boite getBoite() {
        return boite;
    }

    public void setBoite(Boite boite) {
        this.boite = boite;
    }
}
