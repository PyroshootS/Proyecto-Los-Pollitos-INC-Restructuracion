package com.mycompany.proyectopollitos;

import javax.swing.JOptionPane;

public class ProyectoPollitos {

    //MENUS
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al Sistema de Bodegas de  Los Pollitos INC");
        //Variables MenuPrincipal
        int opcMenu = 0;
        //Anti 
        String antiFall = "";

        //Variables de las Listas
        int Cantidad = 100;
        ListaMarcas listamarcas = new ListaMarcas(Cantidad);
        ListaCategorias listacategoria = new ListaCategorias(Cantidad);
        ListaProducto listaproductos = new ListaProducto(Cantidad);

        while (opcMenu != 5) {
            opcMenu = 0;
            antiFall = JOptionPane.showInputDialog(null, "Menú Principal \nDigite el número de la opción que desea\n 1. Registro \n 2. Ingresar Mercadería \n 3. Editar Precio \n 4. Ver Inventario \n 5. Salir");
            if (Numerico(antiFall)) {
                opcMenu = Integer.parseInt(antiFall);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, porfavor ingrese un valor numérico");
            }

            if (opcMenu == 5) {
                break;
            }
            switch (opcMenu) {

                //Menu Registro
                case 1:
                    int Rmenu = 0;
                    while (Rmenu != 4) {
                        Rmenu = 0;
                        antiFall = JOptionPane.showInputDialog(null, "Menú de Registro \nDigite el número de la opción que desea seleccionar en el menú de Registro \n 1. Registrar Marca \n 2. Registrar Categoría  \n 3. Registrar nuevo producto \n 4. Volver al menu");
                        if (Numerico(antiFall)) {
                            Rmenu = Integer.parseInt(antiFall);
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR, porfavor ingrese un valor numérico");
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
                                JOptionPane.showMessageDialog(null, "Opción no valida");
                        }
                    }
                    break;

                //Menu Ingresar Mercaderia
                case 2:
                    int IMmenu = 0;
                    while (IMmenu != 2) {
                        IMmenu = 0;
                        antiFall = JOptionPane.showInputDialog(null, "Menú Ingresar Mercadería \nDigite el número de la opción que desea en el menú de Ingresar Mercadería \n 1. Ingresar Mercadería \n 2. Volver al menú");
                        if (Numerico(antiFall)) {
                            IMmenu = Integer.parseInt(antiFall);
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR, porfavor ingrese un valor numérico");
                        }
                        if (IMmenu == 2) {
                            break;
                        }
                        switch (IMmenu) {
                            case 1:
                                String ListadMarcas = MostrarListaMarcas(listamarcas.getMarcas());
                                String ListadCategorias = MostrarListaCategorias(listacategoria.getCategorias());
                                String ListadProductos = MostrarListaProductos(listaproductos.getProductos());
                                String NombreProducto = JOptionPane.showInputDialog("Lista de Marcas: \n" + ListadMarcas + "\n \nLista de Categorías:\n" + ListadCategorias + "\n \nLista de Productos:\n" + ListadProductos + "\n \nDigite el nombre del producto al que le quiere agregar ");
                                int posicion = (BuscarNombreProducto(NombreProducto, listaproductos.getProductos()));
                                if (posicion > listaproductos.getProductos().length) {
                                    JOptionPane.showMessageDialog(null, "El producto con el nombre " + NombreProducto + " no existe");
                                } else {
                                    JOptionPane.showMessageDialog(null, "El producto con el nombre " + NombreProducto + " si existe \n" + listaproductos.getProductos()[posicion].toString());
                                    antiFall = JOptionPane.showInputDialog(null, "Digite la cantidad de mercadería que quiere ingresar ");
                                    if (Numerico(antiFall)) {
                                        int CantidadIngresar = Integer.parseInt(antiFall);
                                        int Contador = listaproductos.getProductos()[posicion].getCantidad() + CantidadIngresar;
                                        listaproductos.getProductos()[posicion].setCantidad(Contador);
                                        JOptionPane.showMessageDialog(null, "El producto con la mercadería ingresada con exito es: \n" + listaproductos.getProductos()[posicion].toString());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ERROR, Se requiere que ingrese un valor numérico, vuelva a intentarlo");
                                    }

                                }
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opción no valida");
                        }
                    }
                    break;
                //Menu Editar Precio
                case 3:
                    int EPmenu = 0;
                    while (EPmenu != 2) {
                        EPmenu = 0;
                        antiFall = JOptionPane.showInputDialog(null, "Menú Editar Precio \nDigite el número de la opción que desea \n 1. Editar Precio \n 2. Volver al menú");
                        if (Numerico(antiFall)) {
                            EPmenu = Integer.parseInt(antiFall);
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR, porfavor ingrese un valor número");

                        }

                        if (EPmenu == 2) {
                            break;
                        }
                        switch (EPmenu) {
                            case 1:
                                String ListadMarcas = MostrarListaMarcas(listamarcas.getMarcas());
                                String ListadCategorias = MostrarListaCategorias(listacategoria.getCategorias());
                                String ListadProductos = MostrarListaProductos(listaproductos.getProductos());
                                String NombreProducto = JOptionPane.showInputDialog("Lista de Marcas: \n" + ListadMarcas + "\n \nLista de Categorías:\n" + ListadCategorias + "\n \nLista de Productos:\n" + ListadProductos + "\n \nDigite el nombre del producto al que le quieres editar el precio ");
                                int posicion = (BuscarNombreProducto(NombreProducto, listaproductos.getProductos()));
                                if (posicion > listaproductos.getProductos().length) {
                                    JOptionPane.showMessageDialog(null, "El producto con el nombre " + NombreProducto + "   no existe");
                                } else {
                                    JOptionPane.showMessageDialog(null, "El producto con el nombre " + NombreProducto + "  existe \n" + listaproductos.getProductos()[posicion].toString());
                                    antiFall = JOptionPane.showInputDialog(null, "Ingrese el nuevo precio");
                                    if (Numerico(antiFall)) {
                                        int PrecioIngresar = Integer.parseInt(antiFall);
                                        listaproductos.getProductos()[posicion].setPrecio(PrecioIngresar);
                                        JOptionPane.showMessageDialog(null, "El producto con el precio editado con exito es:\n" + listaproductos.getProductos()[posicion].toString());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ERROR, porfavor ingrese un valor numérico");
                                        break;
                                    }

                                    JOptionPane.showMessageDialog(null, "El producto con el precio editado con exito es: \n" + listaproductos.getProductos()[posicion].toString());
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no valida");

                        }
                    }
                    break;
                //Menu Ver Invetario
                case 4:
                    int VImenu = 0;
                    while (VImenu != 2) {
                        VImenu = 0;
                        antiFall = JOptionPane.showInputDialog(null, "Menú Ver Inventario \nDigite el número de la opción que desea \n 1. Ver Inventario Completo \n 2. Volver al menú");
                        if (Numerico(antiFall)) {
                            VImenu = Integer.parseInt(antiFall);
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR, por favor ingrese un valor numérico");

                        }
                        if (VImenu == 2) {
                            break;
                        }
                        switch (VImenu) {
                            case 1:
                                String ListadMarcas = MostrarListaMarcas(listamarcas.getMarcas());
                                String ListadCategorias = MostrarListaCategorias(listacategoria.getCategorias());
                                String ListadProductos = MostrarListaProductos(listaproductos.getProductos());
                                //Menu de FILTRAR INVENTARIO
                                JOptionPane.showMessageDialog(null, "Lista de Marcas: \n" + ListadMarcas + "\nLista de Categorías:\n" + ListadCategorias + "\n \nLista de Productos:\n" + ListadProductos);
                                int FilMenu = 0;
                                while (FilMenu != 3) {
                                    FilMenu = 0;
                                    antiFall = JOptionPane.showInputDialog(null, "Menu Filtrar Inventario \nDigite el número de la opción que desea \n 1. Filtrar Marcas \n 2. Filtrar Categorías \n 3. Salir");

                                    if (Numerico(antiFall)) {
                                        FilMenu = Integer.parseInt(antiFall);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ERROR, por favor ingrese un valor numérico");
                                    }
                                    if (FilMenu == 3) {
                                        break;
                                    }
                                    switch (FilMenu) {
                                        case 1:
                                            ListadMarcas = MostrarListaMarcas(listamarcas.getMarcas());
                                            String NombreMarcaF = JOptionPane.showInputDialog("Lista de Marcas: \n" + ListadMarcas + "\n \nDigite el nombre de la marca que quiere filtrar ");
                                            int posicionMarca = BuscarNombreMarca(NombreMarcaF, listamarcas.getMarcas());
                                            if (posicionMarca > listamarcas.getMarcas().length) {
                                                JOptionPane.showMessageDialog(null, "La marca con el nombre " + NombreMarcaF + " no existe");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "La marca con el nombre " + NombreMarcaF + " si existe: \n" + listamarcas.getMarcas().toString());
                                                ListadProductos = FiltrarPorMarca(listaproductos.getProductos(), NombreMarcaF);
                                                JOptionPane.showMessageDialog(null, "Lista de Productos:\n" + ListadProductos);
                                            }
                                            break;
                                        case 2:
                                            ListadCategorias = MostrarListaCategorias(listacategoria.getCategorias());
                                            String NombreCategoriasF = JOptionPane.showInputDialog("Lista de Categorias: \n" + ListadCategorias + "\n \nDigite el nombre de la categoria que quiere filtrar ");
                                            int posicionCategoria = BuscarNombreCategoria(NombreCategoriasF, listacategoria.getCategorias());
                                            if (posicionCategoria > listamarcas.getMarcas().length) {
                                                JOptionPane.showMessageDialog(null, "La categoria con el nombre " + NombreCategoriasF + " no existe");
                                            } else {

                                                JOptionPane.showMessageDialog(null, "La categoria con el nombre " + NombreCategoriasF + " si existe: \n" + listacategoria.getCategorias().toString());
                                                ListadProductos = FiltrarPorCategoria(listaproductos.getProductos(), NombreCategoriasF);
                                                JOptionPane.showMessageDialog(null, "Lista de Productos:\n" + ListadProductos);
                                            }
                                            break;

                                    }
                                    break;
                                }

                        }
                    }

            }
        }
    }

    //REGISTRAR EN LISTAS
    public static Marcas[] RegistrarMarca(Marcas[] marc, String antiFall) {
        int nidmarca = 0;
        int Entrada = 0;
        for (int i = 0; i < marc.length; i++) {
            if (marc[i] == null) {
                marc[i] = new Marcas();
                String opc = JOptionPane.showInputDialog(null, "Está por registrar una marca. \nDigite  0  para cancelar o \ndigite cualquier otra tecla para continuar ");
                if ("0".equals(opc)) {
                    break;
                }
                antiFall = JOptionPane.showInputDialog(null, "Digite el codigo/id de la marca que quiere registrar ");
                if (Numerico(antiFall)) {
                    Entrada = Integer.parseInt(antiFall);

                } else {
                    JOptionPane.showMessageDialog(null, "ERROR\nEl codigo/id debe ser un valor numérico");
                    break;
                }
                String marcA = JOptionPane.showInputDialog(null, "Digite el nombre de la marca que quiere registrar");
                String confirm = JOptionPane.showInputDialog(null, "Desea guardar la marca?\nPulse cualquier tecla para guardar o\nDigite 0 para descartar ");
                if ("0".equals(confirm)) {
                    break;
                } else {
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
                String opc = JOptionPane.showInputDialog(null, "Está por registar una categoría.\nDigite 0 para cancelar o\nDigite cualquier otra tecla para continuar ");
                if ("0".equals(opc)) {
                    break;
                }
                antiFall = JOptionPane.showInputDialog(null, "Digite el codigo/id de la categoría que quiere registrar ");
                if (Numerico(antiFall)) {

                    Entrada = Integer.parseInt(antiFall);
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR \nEl codigo/id debe ser un valor numérico");
                    break;
                }

                String catego = JOptionPane.showInputDialog(null, "Digite el nombre de la categoría que quiere registrar");
                String confirm = JOptionPane.showInputDialog(null, "Desea guardar la categoria?\nPulse cualquier tecla para guardar o\nDigite 0 para descartar ");
                if ("0".equals(confirm)) {
                    break;
                } else {
                    categ[i].SETcategoria(catego);
                    nidcategoria = Entrada;
                    categ[i].SETidCategoria(nidcategoria);
                }
            }

        }
        return categ;

    }

    public static Producto[] RegistrarProductos(Producto[] prod, Marcas[] marc, Categorias[] categ, String antiFall) {
        int cantidad = 0, EntradaC = 0;
        double precio = 0;
        String Categoria = "", cCategoria = "", Marca = "", mMarca = "";

        for (int i = 0; i < prod.length; i++) {
            if (prod[i] == null) {
                prod[i] = new Producto();
                String nom = JOptionPane.showInputDialog(null, "Digite el nombre del producto ");
                antiFall = JOptionPane.showInputDialog(null, "Digite el precio del producto ");
                if (Numerico(antiFall)) {
                    precio = Double.parseDouble(antiFall);

                } else {
                    JOptionPane.showMessageDialog(null, "ERROR.\n El precio debe ser un valor numerico");
                    break;
                }
                antiFall = JOptionPane.showInputDialog(null, "Digite el codigo  del producto");
                if (Numerico(antiFall)) {
                    EntradaC = Integer.parseInt(antiFall);
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR.\n El codigo debe ser un valor numerico");
                    break;
                }
                String ListadMarcas = "";
                for (int mm = 0; mm < marc.length; mm++) {
                    if (marc[mm] != null && marc[mm].GETMarca() != null) {
                        ListadMarcas = ListadMarcas + "  Id:  " + marc[mm].GETidMarca() + "  Nombre:  " + marc[mm].GETMarca() + "\n";
                    }

                }
                Marca = JOptionPane.showInputDialog(null, "Lista Marcas\n" + ListadMarcas + "Digite el nombre de la marca del producto ");
                boolean verificaM = false;
                for (int m = 0; m < marc.length; m++) {
                    if (marc[m] != null && marc[m].GETMarca() != null) {
                        if (Marca.equals(marc[m].GETMarca())) {
                            verificaM = true;
                            break;
                        }
                    }
                }
                if (verificaM == true) {
                    JOptionPane.showMessageDialog(null, "La Marca Existe");
                    mMarca = Marca;
                } else {
                    JOptionPane.showMessageDialog(null, "La Marca No Existe, Digite los datos de nuevo");
                    break;

                }
                String ListadCategorias = "";
                for (int mc = 0; mc < categ.length; mc++) {
                    if (categ[mc] != null && categ[mc].GETcategoria() != null) {
                        ListadCategorias = ListadCategorias + "  Id:  " + categ[mc].GETidCategoria() + "  Nombre:  " + categ[mc].GETcategoria() + "\n";
                    }
                }
                Categoria = JOptionPane.showInputDialog(null, "Lista Categorias\n" + ListadCategorias + "Digite el nombre de la categoria del producto ");
                boolean verificaC = false;
                for (int c = 0; c < categ.length; c++) {
                    if (categ[c] != null && categ[c].GETcategoria() != null) {
                        if (Categoria.equals(categ[c].GETcategoria())) {
                            verificaC = true;
                            break;
                        }
                    }
                }
                if (verificaC == true) {
                    JOptionPane.showMessageDialog(null, "La Categoria Existe");
                    cCategoria = Categoria;
                } else {
                    JOptionPane.showMessageDialog(null, "La Categoria No Existe, Digite los datos de nuevo");
                    break;

                }
                String confirm = JOptionPane.showInputDialog(null, "Desea guardar el producto?\n Pulse cualquier tecla para guardar o\n Digite 0 para descartar ");
                if ("0".equals(confirm)) {
                    break;
                } else {

                    prod[i].setCodigo(EntradaC);
                    prod[i].setNombre(nom);
                    prod[i].setMarca(mMarca);
                    prod[i].setCategoria(cCategoria);
                    prod[i].setCantidad(cantidad);
                    prod[i].setPrecio(precio);
                }
                String opc = JOptionPane.showInputDialog(null, "Digite  0   para terminar de registrar productos o\n Digite cualquier otra tecla para continuar ");
                if ("0".equals(opc)) {
                    break;
                }

            }
        }
        return prod;

    }

    //BUSCAR POR NOMBRE EN LISTAS
    public static int BuscarNombreProducto(String NombreProducto, Producto prod[]) {
        int posicion = prod.length + 1;
        for (int i = 0; i < prod.length; i++) {
            if (prod[i] != null && prod[i].getNombre() != null) {
                if (prod[i].getNombre().equals(NombreProducto)) {
                    posicion = i;
                    break;
                }
            }
        }
        return posicion;
    }

    public static int BuscarNombreMarca(String NombreMarca, Marcas marc[]) {
        int posicion = marc.length + 1;
        for (int i = 0; i < marc.length; i++) {
            if (marc[i] != null && marc[i].GETMarca() != null) {
                if (marc[i].GETMarca().equals(NombreMarca)) {
                    posicion = i;
                    break;
                }
            }
        }
        return posicion;
    }

    public static int BuscarNombreCategoria(String NombreCategoria, Categorias categ[]) {
        int posicion = categ.length + 1;
        for (int i = 0; i < categ.length; i++) {
            if (categ[i] != null && categ[i].GETcategoria() != null) {
                if (categ[i].GETcategoria().equals(NombreCategoria)) {
                    posicion = i;
                    break;
                }
            }
        }
        return posicion;
    }

    //MOSTRAR LISTAS
    public static String MostrarListaMarcas(Marcas marc[]) {
        String ListadMarcas = "";
        for (int i = 0; i < marc.length; i++) {
            if (marc[i] != null && marc[i].GETMarca() != null) {
                ListadMarcas = ListadMarcas + "  Id:  " + marc[i].GETidMarca() + "  Nombre:  " + marc[i].GETMarca() + "\n";
            }
        }
        return ListadMarcas;
    }

    public static String MostrarListaCategorias(Categorias categ[]) {
        String ListadCategorias = "";
        for (int i = 0; i < categ.length; i++) {
            if (categ[i] != null && categ[i].GETcategoria() != null) {
                ListadCategorias = ListadCategorias + "  Id:  " + categ[i].GETidCategoria() + "  Nombre:  " + categ[i].GETcategoria() + "\n";
            }
        }
        return ListadCategorias;
    }

    public static String MostrarListaProductos(Producto prod[]) {
        String ListadProductos = "";
        for (int i = 0; i < prod.length; i++) {
            if (prod[i] != null && prod[i].getNombre() != null) {
                ListadProductos = ListadProductos + "  Id:  " + prod[i].getCodigo() + "  Nombre:  " + prod[i].getNombre() + "  Precio:  " + prod[i].getPrecio() + "  Cantidad:  " + prod[i].getCantidad() + "  Marca:  " + prod[i].getMarca() + "  Categoría:  " + prod[i].getCategoria() + "\n";
            }
        }
        return ListadProductos;
    }

    //FILTRAR LISTAS
    public static String FiltrarPorMarca(Producto prod[], String NombreMarcaF) {
        String ListaFiltradaM = "";
        for (int i = 0; i < prod.length; i++) {
            if (prod[i] != null) {
                if (prod[i].getMarca().equals(NombreMarcaF)) {
                    ListaFiltradaM = ListaFiltradaM + "  Id:  " + prod[i].getCodigo() + "  Nombre:  " + prod[i].getNombre() + "  Precio:  " + prod[i].getPrecio() + "  Cantidad:  " + prod[i].getCantidad() + "  Marca:  " + prod[i].getMarca() + "  Categoría:  " + prod[i].getCategoria() + "\n";
                }
            }

        }
        return ListaFiltradaM;
    }

    public static String FiltrarPorCategoria(Producto prod[], String NombreCategoriaF) {
        String ListaFiltradaC = "";
        for (int i = 0; i < prod.length; i++) {
            if (prod[i] != null) {
                if (prod[i].getCategoria().equals(NombreCategoriaF)) {
                    ListaFiltradaC = ListaFiltradaC + "  Id:  " + prod[i].getCodigo() + "  Nombre:  " + prod[i].getNombre() + "  Precio:  " + prod[i].getPrecio() + "  Cantidad:  " + prod[i].getCantidad() + "  Marca:  " + prod[i].getMarca() + "  Categoría:  " + prod[i].getCategoria() + "\n";
                }
            }

        }
        return ListaFiltradaC;
    }

    //evitar caidas por String en int
    public static boolean Numerico(String antiFall) {

        try {
            Integer.parseInt(antiFall);

            return true;
        } catch (NumberFormatException nfe) {

            return false;
        }
    }

}
