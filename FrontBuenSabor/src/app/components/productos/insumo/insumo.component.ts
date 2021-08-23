import { Component, OnInit } from '@angular/core';
import { ArticuloInsumo } from 'src/app/models/ArticuloInsumo';
import { RubroArticulo } from 'src/app/models/RubroArticulo';
import { ProductosService } from 'src/app/services/productos.service';

@Component({
  selector: 'app-insumo',
  templateUrl: './insumo.component.html',
  styleUrls: ['./insumo.component.css']
})
export class InsumoComponent implements OnInit {

  insumo = new ArticuloInsumo();
  rubroArticulo = new RubroArticulo()
  constructor(private service: ProductosService) { }

  ngOnInit(): void {
  }

  onSave(){
    this.insumo.rubroArticulo = this.rubroArticulo;
    this.service.postArtInsumo(this.insumo).subscribe();
  }
}
