import { Component, ElementRef, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { Producto } from '../../model/producto.model';
import { Categoria } from '../../model/categoria.model';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { HttpClient } from '@angular/common/http';
import { CategoriaService } from '../../services/categoria';
import { ProductoService } from '../../services/producto';
import { MatDialog } from '@angular/material/dialog';
import Swal from 'sweetalert2';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-producto',
  standalone: false,
  templateUrl: './producto.html',
  styleUrl: './producto.css',
})
export class ProductoComponent implements OnInit {

  productoS: Producto[] = [];
  categorias: Categoria [] = [];
  producto: Producto = { } as Producto;
  editar: boolean = false;
  idEditar: number | null = null;
  dataSource!: MatTableDataSource<Producto>;
  seleccionarArchivo!: File;
  imagenPrevia: string = "";
  productoSeleccionado: Producto | null = null;

  mostrarColumnas: String[] = ['nombre', 'idProducto','precio','tipoProducto'];
  @ViewChild('FormulariopProducto') FormulariopProducto!: ElementRef;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild('modalProducto') modalProducto!: TemplateRef<any>;
  @ViewChild('modalDetalles') modalDetalles!: TemplateRef<any>;

    constructor(
      private productoService: ProductoService,
      private categoriaService: CategoriaService,
      private dialog: MatDialog,
      private http: HttpClient
    ){}


  ngOnInit(): void {
    this.findAll();
    this.cargarCategorias();
  }

  findAll(): void{
    this.productoService.findAll().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
     });
  }

  cargarCategorias(): void{
    this.categoriaService.findAll().subscribe(data=> {
      this.categorias = data;
    });
  }

  save(): void{
    this.productoService.save(this.producto).subscribe(()=>{
      this.producto= { } as Producto;
      this.findAll();
    });
  }

  update(): void{
    if(this.idEditar !== null){
      this.productoService.update(this.idEditar, this.producto).subscribe(()=>{
      this.producto = { } as Producto;
      this.editar = false;
      this.idEditar = null;
      this.findAll();
       });
      }
  }

   delete(): void{
    Swal.fire({ 
      title: '¿Dese eliminar el producto?',
      text: 'Esta accion no se puede deshacer',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, eliminar',
      cancelButtonText: 'Cancelar',
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6'

    }).then((result) =>{
      if(result.isConfirmed){
        this.productoService.delete(this.producto.idProducto).subscribe(() =>{
          this.findAll();
          this.producto = {} as Producto;
          Swal.fire('Eliminado','El libro a sido eliminado','success');
        })

      }else{
        this.producto = {} as Producto;
      }
    });
  }
  
  // //interaccion en la pagina
  editarProducto(producto: Producto): void{
    this.producto = { ...producto };
    this.idEditar = producto.idProducto;
    this.editar = true;

    setTimeout(() => {
      this.FormulariopProducto.nativeElement.scrollIntoView({ behavior: 'smooth', block: 'start' })
    }, 100);
  }

  editarProductoCancelar(form: NgForm): void{
    this.producto = { } as Producto;
    this.idEditar = null;
    this.editar = false;
    form.resetForm();
  }

  guardarProducto(form: NgForm): void{
    if(this.editar && this.idEditar !== null){
      this.update();
    }else{
      this.save();
    }
    this.dialog.closeAll();
  }

  filtroProducto(event: Event):void{
    const filtro = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filtro.trim().toLocaleLowerCase();
  }




}
