import { Boite } from "./boite";
import { Modele } from "./modele";

export class Vehicule {

    id!:number;
    color!:string;
    nom!:string;
    dateDebService!:Date;
    numChassis!:number;
    matricule!:string;
    boite!:Boite;
    modele!:Modele;
}
