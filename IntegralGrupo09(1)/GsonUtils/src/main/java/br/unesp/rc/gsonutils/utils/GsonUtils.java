package br.unesp.rc.gsonutils.utils;

import java.util.Set;

import com.google.gson.Gson;

import br.unesp.rc.modelo.Classe;


public class GsonUtils {

    private GsonUtils() {
    }


    public static String objetoToXML(Classe objeto) {
        Gson gson = new Gson();

        return gson.toJson(objeto);
    }

    public static Object xmlToObjeto(String json, Class classe) {
        Gson gson = new Gson();

        return gson.fromJson(json, classe);
    }
}
