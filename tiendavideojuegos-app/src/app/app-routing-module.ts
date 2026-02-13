import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteComponent } from './components/cliente/cliente';
import { CategoriaComponent } from './components/categoria/categoria';
import { ProductoComponent } from './components/producto/producto';

const routes: Routes = [
   { path: '', component: ClienteComponent },
  { path: 'categoria', component: CategoriaComponent },
  { path: 'producto', component: ProductoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
