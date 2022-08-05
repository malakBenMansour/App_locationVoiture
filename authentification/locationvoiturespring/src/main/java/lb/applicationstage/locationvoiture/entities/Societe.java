package lb.applicationstage.locationvoiture.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Societe implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false,updatable = false)
    private int id;
    private String nom;
    private String adresse;
    private String email;
    private String tel;
    private String site;

    public Societe (){}
    public Societe (String nom,String adresse,String email,String tel,String site)
    {
        this.nom=nom;
        this.adresse=adresse;
        this.email=email;
        this.tel=tel;
        this.site=site;

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="societe")
    private List<Agence> ListAgence;

    public List<Agence> getListAgence() {
        return ListAgence;
    }

    public void setListAgence(List<Agence> listAgence) {
        ListAgence = listAgence;
    }
}
