import { Categoria } from "./categoria.model"

export interface Producto{
  idProducto: number
  nombre: string
  descripcion: string
  precio: number
  stock: number
  categoria: Categoria
  tipoProducto: string
  tipoPorducto?: string

  [Key: string]: any;
}