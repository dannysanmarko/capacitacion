package TestClases;

import Utils.DriverContext;
import Utils.ReadProperties;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import page.Index;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InicioJson {

    Index index;


    public void ingresoJson() throws IOException, InterruptedException {
        index = new Index();
        String datos="";
        String comparacion;
        BufferedReader br = new BufferedReader(new FileReader("C:\\git\\Tarea_1\\usuarios.json"));
        while((comparacion = br.readLine()) != null){
            datos = datos+comparacion+"\n";
        }
        br.close();
        JsonObject jsonObject = new Gson().fromJson(datos, JsonObject.class);
        JsonArray jsonUsuarios = jsonObject.getAsJsonArray("usuario");
        String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("web");
        JsonObject jsonArreglo;
        for (int x = 0; x < jsonUsuarios.size(); x++) {
            jsonArreglo = (JsonObject) jsonUsuarios.get(x);
            String usuario = jsonArreglo.get("nombre").getAsString();
            String clave =jsonArreglo.get("clave").getAsString();
            index.login(usuario, clave);
            DriverContext.getDriver().navigate().to(url);
        }
    }
}
