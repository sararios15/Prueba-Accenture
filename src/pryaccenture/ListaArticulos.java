package pryaccenture;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ListaArticulos {
    private Nodo cab;
    private int tam;
    //String nombre;
    //float valor;
    
    public void Lista(){
        cab = null;
        tam = 0;
    }
    
    public boolean esVacia(){
        return cab == null;
    }
    
    public int getTamaño(){
        return tam;
    }
    
    public void agregarArticulo(String nombre, int valor){
        Nodo nuevo = new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setValor(valor);
        if (esVacia()) {
            cab = nuevo;
        }else{
            Nodo aux = cab;
            while(aux.getLiga() != null){
                aux = aux.getLiga();
            }
            aux.setLiga(nuevo);
        }
        tam++;
    }
    
    public void listar(){
        if (!esVacia()) {
            Nodo aux = cab;
            int i = 0;
            while(aux != null){
                System.out.print(i + ".[ " + aux.getValor() + aux.getNombre() + " ]" + " ->  ");
                aux = aux.getLiga();
                i++;
            }
        }
    }
    
    public void generarFactura(){
        Nodo aux = cab;
        int suma = 0;
        int domicilio = 10000;
        
        while(aux != null){
            suma = suma + aux.valor;
            aux = aux.getLiga();
        }
        
        int iva = (suma*19)/100;
        suma = suma + iva;
        
        //System.out.println("Valor total a pagar: "+suma);
        
        if(suma>70000 && suma<100000){
            System.out.println("El valor a pagar incluyendo el iva es: " +
                    suma+
                    " más 10.000 de domicilio: " +
                    (suma+domicilio));
        }else if (suma >= 100000){
            System.out.println("El valor a pagar es: " +
                    suma + " y no se le cobra domicilio. ");
        }
    }
    
    public void generarFacturaEliminado(){
        Nodo aux = cab;
        double suma = 0;
        
        while(aux != null){
            suma = suma + aux.valor;
            aux = aux.getLiga();
        }
        
        suma= suma*0.1;
        
            System.out.println("El valor a pagar por la eliminación del pedido es: " +
                    suma);
    }
    
    public void removerPorReferencia(String ref){
        // Consulta si el valor de referencia existe en la lista.
        Nodo p = cab, ant = cab;
        if(cab != null){
            while(p != null && p.nombre != ref){
                ant = p;
                p=p.liga;
            }
            if(p != null){
                if(p == cab){
                    cab = cab.liga;
                }else{
                    ant.liga = p.liga;
                }
            }else{
                System.out.println("El articulo"+ ref +"no encontrado en su pedido");
            }
        }else{
            System.out.println("Lista de compras vacía");
        }
    }
    
    public void eliminar(){
        // Elimina el valor y la referencia a los demas nodos.
        cab = null;
        // Reinicia el contador de tamaño de la lista a 0.
        tam = 0;
    }
}