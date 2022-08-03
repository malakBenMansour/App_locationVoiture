package lb.applicationstage.locationvoiture.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Boite implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable = false,updatable = false)
private int id;

private String nom;

public Boite(){}

    public Boite(String nom) {
        this.nom = nom;
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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="boite")
    private List<Vehicule> ListVehicule;

    public List<Vehicule> getListVehicule() {
        return ListVehicule;
    }

    public void setListVehicule(List<Vehicule> listVehicule) {
        ListVehicule = listVehicule;
    }
}
