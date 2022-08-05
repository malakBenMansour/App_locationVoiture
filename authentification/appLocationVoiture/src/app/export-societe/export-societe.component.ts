import { Component, OnInit } from '@angular/core';
import { SocieteService } from '../service/societe.service';
import { Societe } from '../model/societe';
@Component({
  selector: 'app-export-societe',
  templateUrl: './export-societe.component.html',
  styleUrls: ['./export-societe.component.scss']
})
export class ExportSocieteComponent implements OnInit {

  constructor(private societeService:SocieteService) { }

  ngOnInit(): void {
  }

  exportSocietePdf(){
    this.societeService.exportPdfSociete().subscribe(x=>{
    const blob =new Blob([x],{type:'application/pdf'});
   /* if (window.navigator && window.navigator.msSaveOrOpenBlob)
    {
     window.navigator.msSaveOrOpenBlob(blob);
     return;
    }*/
const data=window.URL.createObjectURL(blob);
const link=document.createElement('a');
link.href=data;
link.download='societes.pdf';
link.dispatchEvent(new MouseEvent('click',{bubbles:true,cancelable:true,view:window}));
setTimeout(function(){

window.URL.revokeObjectURL(data);
link.remove();

},100);

    });

  }


  exportSocieteExcel(){
this.societeService.exportExcelSociete().subscribe(x=>{

const blob=new Blob([x],{type:'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet .xml, XML, application/xml'})

const data=window.URL.createObjectURL(blob);
const link=document.createElement('a');
link.href=data;
link.download='societes.xlsx';
link.dispatchEvent(new MouseEvent('click',{bubbles:true,cancelable:true,view:window}));
setTimeout(function(){

window.URL.revokeObjectURL(data);
link.remove();

},100);

    });

}







  }

