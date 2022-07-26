import { Energie } from "./energie";
import { Categorie } from "./categorie";
import { Marque } from "./marque";
export class Modele {
id!:number;
nom!:string;
nbplaces!:number;
nbportes!:number;
volumecoffre!:number;
puissance!:string;
version!:string;
marque!:Marque;
energie!:Energie;
categorie!:Categorie;
}
