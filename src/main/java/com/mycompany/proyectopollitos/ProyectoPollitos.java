package com.mycompany.proyectopollitos;

import javax.swing.JOptionPane;

public class ProyectoPollitos {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al Sistema de bodegas de  Los Pollitos INC");
        //Variables MenuPrincipal
        int opcMenu = 0;
        //Anti 
        String antiFall="";

        
        //Variables de las Listas
        int Cantidad = 100;
        ListaMarcas listamarcas = new ListaMarcas(Cantidad);
        ListaCategorias listacategoria = new ListaCategorias(Cantidad);
        ListaProducto listaproductos = new ListaProducto(Cantidad);

        while (opcMenu != 5) {
             antiFall = JOptionPane.showInputDialog(null, "Menu Principal \nDigite el número de la opción que desea\n 1. Registro \n 2. Ingresar Mercadería \n 3. Editar Precio \n 4. Ver Inventario \n 5. Salir");
             if(Numerico(antiFall)){
               opcMenu = Integer.parseInt(antiFall);
             }else{
               JOptionPane.showMessageDialog(null, "ERROR");
                }
            
            if (opcMenu == 5) {
                break;
            }
            switch (opcMenu) {

                //Menu Registro
                case 1:
                    int Rmenu = 0;
                    while (Rmenu != 4) {
                        antiFall = JOptionPane.showInputDialog(null, "Menu de Registro \nDigite el número de la opción que desea seleccionar en el menu de Registro \n 1. Registrar Marca \n 2. Registrar Categoria  \n 3. Registrar nuevo producto \n 4. Volver al menu");
                        if(Numerico(antiFall)){
                            Rmenu = Integer.parseInt(antiFall);
                        }else{
                            JOptionPane.showMessageDialog(null, "ERROR");
                        }
                         
                        if (Rmenu == 4) {
                            break;
                        }
                        switch (Rmenu) {
                            case 1:
                                listamarcas.setMarcas(RegistrarMarca(listamarcas.getMarcas(), antiFall));
                                break;
                            case 2:
                                listacategoria.setCategorias(RegistrarCategorias(listacategoria.getCategorias(), antiFall));
                                break;
                            case 3:
                                listaproductos.setProductos(RegistrarProductos(listaproductos.getProductos(), listamarcas.getMarcas(), listacategoria.getCategorias(), antiFall));
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no valida");
                        }
                    }
                    break;

                //Menu Ingresar Mercaderia
                case 2:
                    int IMmenu = 0;
                    while (IMmenu != 2) {
                        antiFall = JOptionPane.showInputDialog(null, "Menu Ingresar Mercaderia \nDigite el número de la opción que desea en el menu de Ingresar Mercaderia \n 1. Ingresar Mercaderia \n 2. Volver al menu");
                        if(Numerico(antiFall)){
                            IMmenu = Integer.parseInt(antiFall);
                        }else{
                            JOptionPane.showMessageDialog(null, "ERROR");
                        }
                        if (IMmenu == 2) {
                            break;
                        }
                        switch (IMmenu) {
                            case 1:
                                String NombreProducto = JOptionPane.showInputDialog("Digite el nombre del producto al que le quiere agregar ");      
                                int posicion = (BuscarNombreProducto(NombreProducto, listaproductos.getProductos()));
                                if (posicion > listaproductos.getProductos().length) {
                                    JOptionPane.showMessageDialog(null, "El producto con el nombre introducido  no existe");       
                                } else {
                                    JOptionPane.showMessageDialog(null, "El producto con el nombre introducido  existe  " + listaproductos.getProductos()[posicion].toString());
                                    antiFall= JOptionPane.showInputDialog(null, "Digite la cantidad de mercaderia ");
                                    if(Numerico(antiFall)){
                                        int CantidadIngresar = Integer.parseInt(antiFall);
                                        int Contador = listaproductos.getProductos()[posicion].getCantidad() + CantidadIngresar;
                                        listaproductos.getProductos()[posicion].setCantidad(Contador);
                                        JOptionPane.showMessageDialog(null, "El producto con la mercaderia ingresada  con exito es: \n" + listaproductos.getProductos()[posicion].toString());
                                    }else{
                                        JOptionPane.showMessageDialog(null, "ERROR, Se requiere que ingrese un valor numerico, vuelva a intentarlo");
                                    }
                                                                                                     
                                }
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no valida");
                        }
                    }
                    break;
                //Menu Editar Precio
                case 3:
                    int EPmenu = 0;
                    while (EPmenu != 2) {
                        antiFall = JOptionPane.showInputDialog(null, "Menu Editar Precio \nDigite el número de la opción que desea \n 1. Editar Precio \n 2. Volver al menu");
                        if(Numerico(antiFall)){
                            EPmenu = Integer.parseInt(antiFall);
                        }else{
                            JOptionPane.showMessageDialog(null, "ERROR");
                        }
                        
                        if (EPmenu == 2) {
                            break;
                        }
                        switch (EPmenu) {
                            case 1:
                                String NombreProducto = JOptionPane.showInputDialog("Digite el nombre del producto al que le quieres editar el precio ");
                                int posicion = (BuscarNombreProducto(NombreProducto, listaproductos.getProductos()));
                                if (posicion > listaproductos.getProductos().length) {
                                    JOptionPane.showMessageDialog(null, "El producto con el nombre introducido  no existe");
                                } else {
                                    JOptionPane.showMessageDialog(null, "El producto con el nombre introducido  existe  " + listaproductos.getProductos()[posicion].toString());
                                    antiFall = JOptionPane.showInputDialog(null, "Ingrese el nuevo precio");
                                    if(Numerico(antiFall)){
                                        int PrecioIngresar = Integer.parseInt(antiFall);
                                        listaproductos.getProductos()[posicion].setPrecio(PrecioIngresar);
                                        JOptionPane.showMessageDialog(null, "precio cambiado con exito");
                                    }else{
                                        JOptionPane.showMessageDialog(null, "ERROR, digite valores numericos por favor");
                                        break;
                                    }
                                                                 
                                    
                                    JOptionPane.showMessageDialog(null, "El producto con la mercaderia ingresada  con exito es: \n" + listaproductos.getProductos()[posicion].toString());
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no valida");
                        }
                    }
                    break;
                //Menu Ver Invetario
                case 4:
                    int VImenu = 0;
                    while (VImenu != 2) {
                        antiFall = JOptionPane.showInputDialog(null, "Menu Ver Inventario \nDigite el número de la opción que desea \n 1. Ver Inventario Completo \n 2. Volver al menu");
                        if(Numerico(antiFall)){
                            VImenu = Integer.parseInt(antiFall);
                        }else{
                            JOptionPane.showMessageDialog(null, "ERROR, por favor ingrese un valor numerico");
                        }
                        
                        if (VImenu == 2) {
                            break;
                        }
                        switch (VImenu) {
                            case 1:
                                String ListadMarcas = MostrarListaMarcas(listamarcas.getMarcas());                                   
                                String ListadCategorias= MostrarListaCategorias(listacategoria.getCategorias());                    
                                String ListadProductos= MostrarListaProductos(listaproductos.getProductos());                        
                                JOptionPane.showMessageDialog(null, "Lista de Marcas: \n"+ListadMarcas+"\nLista de Categorias:"+ListadCategorias+"\n \nLista de Productos:"+ListadProductos);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no valida");
                        }
                    }
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        }
    }

    public static Marcas[] RegistrarMarca(Marcas[] marc, String antiFall) {
        int nidmarca = 0;
        int Entrada =0;
        for (int i = 0; i < marc.length; i++) {
            if (marc[i] == null) {
                marc[i] = new Marcas();
                String opc = JOptionPane.showInputDialog(null, "Está por registrar una marca, digite  0  para cancelar o\n digite cualquier otra tecla para continuar ");
                if ("0".equals(opc)) {
                    break;
                }
                antiFall = JOptionPane.showInputDialog(null, "Digite el id de la marca que quiere registrar "); 
                if(Numerico(antiFall)){
                    Entrada = Integer.parseInt(antiFall);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR\nEl id debe ser un valor numerico");
                    break;
                }
                String marcA = JOptionPane.showInputDialog(null, "Digite el nombre de la marca que quiere");
                String confirm= JOptionPane.showInputDialog(null, "Desea guardar la categoria?\n pulse cualquier tecla para guardar o\n Digite 0 para descartar ");
                if("0".equals(confirm)){
                    break;
                }else{
                marc[i].SETMarca(marcA);
                nidmarca = Entrada;
                marc[i].SETidMarca(nidmarca);
                }
                
            }
            
        }
        return marc;

    }

    public static Categorias[] RegistrarCategorias(Categorias[] categ, String antiFall) {
        int nidcategoria = 0;
        int Entrada = 0;
        for (int i = 0; i < categ.length; i++) {
            if (categ[i] == null) {
                categ[i] = new Categorias();
                String opc = JOptionPane.showInputDialog(null, "Está por registar una categoria, digite  0 para cancelar o\n digite cualquier otra tecla para continuar ");
                if ("0".equals(opc)) {
                    break;
                }
                antiFall = JOptionPane.showInputDialog(null, "Digite el id de la marca que quiere registrar "); 
                if(Numerico(antiFall)){
                    
                    Entrada = Integer.parseInt(antiFall);
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR\nEl id debe ser un valor numerico");
                    break;
                }
                
                String catego = JOptionPane.showInputDialog(null, "Digite el nombre de la categoria que quiere");
                String confirm= JOptionPane.showInputDialog(null, "Desea guardar la categoria?\n pulse cualquier tecla para guardar o\n Digite 0 para descartar ");
                if("0".equals(confirm)){
                    break;
                }else{
                  categ[i].SETcategoria(catego);
                  nidcategoria = Entrada;
                  categ[i].SETidCategoria(nidcategoria);
                }
            }
            
        }
        return categ;

    }

    public static Producto[] RegistrarProductos(Producto[] prod, Marcas marc[], Categorias categ[], String antiFall) {
        int cantidad = 0, EntradaC=0;
        double precio = 0;
        String Categoria = "", cCategoria = "", Marca = "", mMarca = "";

        for (int i = 0; i < prod.length; i++) {
            if (prod[i] == null) {
                prod[i] = new Producto();
                String nom=JOptionPane.showInputDialog(null, "Digite el nombre del producto "); 
                antiFall = JOptionPane.showInputDialog(null, "Digite el precio del producto "); 
                if(Numerico(antiFall)){
                    precio= Double.parseDouble(antiFall);
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR, El precio debe ser un valor numerico");
                    break;
                }
                antiFall = JOptionPane.showInputDialog(null, "Digite el codigo  del producto");  
                if(Numerico(antiFall)){
                   EntradaC = Integer.parseInt(antiFall);
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR,El codigo debe ser un valor numerico");
                    break;
                }
                Marca = JOptionPane.showInputDialog(null, "Digite el nombre de la marca del producto ");
                boolean verificaM = false;
                for (int m = 0; m < marc.length; m++) {
                    if(marc[m]!= null && marc[m].GETMarca()!=null){
                       if ( Marca.equals(marc[m].GETMarca())) {
                        verificaM = true;
                        break;
                       }
                    }
                }

                if (verificaM == true) {
                    JOptionPane.showMessageDialog(null, "La Marca Existe");
                    mMarca= Marca;
                } else {
                    JOptionPane.showMessageDialog(null, "La Marca No Existe, Digite los datos de nuevo");
                    break; 

                }
                Categoria = JOptionPane.showInputDialog(null, "Digite el nombre de la categoria del producto ");
                boolean verificaC = false;
                for (int c = 0; c < categ.length; c++) {
                    if(categ[c]!=null && categ[c].GETcategoria()!=null){
                        if (Categoria.equals(categ[c].GETcategoria())) {
                            verificaC = true;
                            break;
                        }
                    }
                }
                if (verificaC == true) {
                    JOptionPane.showMessageDialog(null, "La Categoria Existe");
                    cCategoria=Categoria;
                } else {
                    JOptionPane.showMessageDialog(null, "La Categoria No Existe, Digite los datos de nuevo");
                    break;
                    
                }
                String confirm= JOptionPane.showInputDialog(null, "Desea guardar el producto?\n pulse cualquier tecla para guardar o\n Digite 0 para descartar ");
                if("0".equals(confirm)){
                    break;
                }else{
                   prod[i].setCodigo(EntradaC);
                   prod[i].setNombre(nom);
                   prod[i].setMarca(mMarca);
                   prod[i].setCategoria(cCategoria);
                   prod[i].setCantidad(cantidad);
                   prod[i].setPrecio(precio);
                }
                String opc = JOptionPane.showInputDialog(null, "Digite  0   para terminar de registrar productos o\n digite cualquier otra tecla para continuar ");
                if ("0".equals(opc)) {
                    break;
                }
                
            }
        }
        return prod;

    }

    public static int BuscarNombreProducto(String NombreProducto, Producto prod[]) {
        int posicion = prod.length + 1;
        for (int i = 0; i < prod.length; i++) {
            if(prod[i]!=null && prod[i].getNombre()!=null){
                if (prod[i].getNombre().equals(NombreProducto)) {
                    posicion = i;
                    break;
                }
            }
        }
        return posicion;
    }
    
    public static String MostrarListaMarcas(Marcas marc[]){
        String ListadMarcas="";
        for (int i = 0; i < marc.length; i++) {
            if(marc[i] != null && marc[i].GETMarca() !=null){
               ListadMarcas=ListadMarcas + "Id: " + marc[i].GETidMarca()+" Nombre: "+marc[i].GETMarca();
            }
        }
        return ListadMarcas;
    }
    public static String MostrarListaCategorias(Categorias categ[]){
        String ListadCategorias="";
        for (int i = 0; i < categ.length; i++) {
            if(categ[i] != null && categ[i].GETcategoria() !=null){
              ListadCategorias=ListadCategorias + "Id: " + categ[i].GETidCategoria()+" Nombre: "+categ[i].GETcategoria();
            }
        }
        return ListadCategorias;
    }
    public static String MostrarListaProductos(Producto prod[]){
        String ListadProductos="";
        for (int i = 0; i < prod.length; i++) {
           if(prod[i] != null ){
            ListadProductos=ListadProductos + "Id: " + prod[i].getCodigo()+" Nombre: "+prod[i].getNombre()+" Precio: "+prod[i].getPrecio()+" Cantidad: "+prod[i].getCantidad()+" Marca: "+prod[i].getMarca()+" Categoria: "+prod[i].getCategoria();
           }
        }
        return ListadProductos;
    }
    //evitar caidas por String en int
    public static boolean Numerico(String antiFall){
       
	try {
		Integer.parseInt(antiFall);
                
		return true;
	} catch (NumberFormatException nfe){
                
		return false;
	}
}

}
