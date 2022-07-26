import { Societe } from "./societe";

export class Agence {
    id!:number;
    nom!:string;
    adresse!:string;
    tel!:string;
    email!:string;
    societe!:Societe;
}
