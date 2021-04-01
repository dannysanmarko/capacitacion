package TestClases;

import page.*;

public class TestLogin {

    Index index;
    Tabla tabla;
    Carga_Archivos carga_archivos;
    PaginaDownload paginaDownload;
    AgregarUsuario agregarUsuario;

    public void inicio(String usuario, String clave) throws InterruptedException {
        index = new Index();
        index.login(usuario, clave);
    }

    public void ErrorAux() throws InterruptedException {
        String msgAux = "Nombre y/o password incorrecto";
        index = new Index();
        index.Ierror(msgAux);
    }

    public void inicio2(String usuario, String clave, String campo1, String campo2, String correo, String fecha, int campo_lista, boolean Multi1, boolean Multi2, boolean Multi3, int campo_radio) throws InterruptedException {
        index = new Index();
        index.login_2(usuario, clave, campo1, campo2, correo, fecha, campo_lista, Multi1, Multi2, Multi3, campo_radio);
    }

    public void extraer_tabla(String nombre) {
        tabla = new Tabla();
        tabla.Filtrar(nombre);
    }

    public void subir_archivos(String archivo) throws InterruptedException {
        carga_archivos = new Carga_Archivos();
        carga_archivos.archivos(archivo);
    }

    public void download() throws InterruptedException {
        paginaDownload = new PaginaDownload();
        paginaDownload.eliminarArchivo();
        paginaDownload.descargar();
        paginaDownload.validacionDescarga();

    }

    public void fecha() throws InterruptedException {
        index = new Index();
        index.fecha();
    }

    public void agregar(String nuevoUsuario, String contra, String nombreCompleto, String correo, String msgAuxi, String msgFallado) throws InterruptedException {
        agregarUsuario = new AgregarUsuario();
        agregarUsuario.agregar(nuevoUsuario, contra, nombreCompleto, correo, msgAuxi, msgFallado);
    }

}
