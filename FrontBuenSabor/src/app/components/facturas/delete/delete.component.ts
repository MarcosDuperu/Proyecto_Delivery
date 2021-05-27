import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { facturas } from 'src/app/models/facturas';
import { FacturaService } from 'src/app/services/factura.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  facturas:facturas[];
  constructor(private router: Router,private FacturaService:FacturaService) { }

  delete(factura:facturas){return this.FacturaService.deleteFacturas(factura)
  .subscribe(data =>{this.facturas = this.facturas.filter(f=>f!=factura)})
}
  
  ngOnInit(): void {
    
  }

}
