import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { facturas } from 'src/app/models/facturas';
import { FacturaService } from 'src/app/services/factura.service';

@Component({
  selector: 'app-facturas',
  templateUrl: './facturas.component.html',
  styleUrls: ['./facturas.component.css']
})
export class FacturasComponent implements OnInit {

  facturas: facturas[];
  constructor(private service:FacturaService,private router:Router ) { }

  ngOnInit(): void {

    this.service.getFacturas()
    .subscribe(data => {this.facturas = data})

  }

}
