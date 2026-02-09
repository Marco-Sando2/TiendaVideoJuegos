import { Categoria } from "./categoria.model"

export interface Producto{
    idProducto: number
    nombre: string
    descripcion: string
    precio: number
    stock: number
    categoria: Categoria
    tipoPorducto: string

    [Key: string]: any ;
} 