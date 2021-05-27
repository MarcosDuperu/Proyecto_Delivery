import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { facturas } from 'src/app/models/facturas';
import { FacturaService } from 'src/app/services/factura.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  Facturas:facturas[];
  constructor(private router:Router,private FacturaService:FacturaService) { }



  actualizarFactura(facturas:facturas){
    this.FacturaService.editarFactura(facturas).subscribe(data =>{this.Facturas= data})
    this.router.navigate(['facturas'])
    alert("Factura editada con exito")
  }
  ngOnInit(): void {
    
  }

}
