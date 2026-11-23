package Modelo;

import java.util.ArrayList;

public class Departamento
{
    private String nombre;
    private ArrayList<MunicipiosAfectados> municipios;

    private static ArrayList<Departamento> catalogo = crearCatalogo();

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.municipios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<MunicipiosAfectados> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(ArrayList<MunicipiosAfectados> municipios) {
        this.municipios = municipios;
    }

    public static ArrayList<Departamento> getCatalogo() {
        return catalogo;
    }

    private static ArrayList<Departamento> crearCatalogo() {
        ArrayList<Departamento> lista = new ArrayList<>();

        Departamento antioquia = new Departamento("Antioquia");
        antioquia.getMunicipios().add(new MunicipiosAfectados("Medellín", 0, NivelDeAlerta.BAJO));
        antioquia.getMunicipios().add(new MunicipiosAfectados("Bello", 0, NivelDeAlerta.BAJO));
        antioquia.getMunicipios().add(new MunicipiosAfectados("Itagüí", 0, NivelDeAlerta.BAJO));
        antioquia.getMunicipios().add(new MunicipiosAfectados("Envigado", 0, NivelDeAlerta.BAJO));
        antioquia.getMunicipios().add(new MunicipiosAfectados("Rionegro", 0, NivelDeAlerta.BAJO));
        antioquia.getMunicipios().add(new MunicipiosAfectados("Apartadó", 0, NivelDeAlerta.BAJO));
        lista.add(antioquia);

        Departamento caldas = new Departamento("Caldas");
        caldas.getMunicipios().add(new MunicipiosAfectados("Manizales", 0, NivelDeAlerta.BAJO));
        caldas.getMunicipios().add(new MunicipiosAfectados("Villamaría", 0, NivelDeAlerta.BAJO));
        caldas.getMunicipios().add(new MunicipiosAfectados("Chinchiná", 0, NivelDeAlerta.BAJO));
        caldas.getMunicipios().add(new MunicipiosAfectados("Riosucio", 0, NivelDeAlerta.BAJO));
        caldas.getMunicipios().add(new MunicipiosAfectados("Aguadas", 0, NivelDeAlerta.BAJO));
        caldas.getMunicipios().add(new MunicipiosAfectados("La Dorada", 0, NivelDeAlerta.BAJO));
        lista.add(caldas);

        Departamento cundinamarca = new Departamento("Cundinamarca");
        cundinamarca.getMunicipios().add(new MunicipiosAfectados("Soacha", 0, NivelDeAlerta.BAJO));
        cundinamarca.getMunicipios().add(new MunicipiosAfectados("Chía", 0, NivelDeAlerta.BAJO));
        cundinamarca.getMunicipios().add(new MunicipiosAfectados("Zipaquirá", 0, NivelDeAlerta.BAJO));
        cundinamarca.getMunicipios().add(new MunicipiosAfectados("Facatativá", 0, NivelDeAlerta.BAJO));
        cundinamarca.getMunicipios().add(new MunicipiosAfectados("Fusagasugá", 0, NivelDeAlerta.BAJO));
        cundinamarca.getMunicipios().add(new MunicipiosAfectados("Girardot", 0, NivelDeAlerta.BAJO));
        lista.add(cundinamarca);

        Departamento tolima = new Departamento("Tolima");
        tolima.getMunicipios().add(new MunicipiosAfectados("Ibagué", 0, NivelDeAlerta.BAJO));
        tolima.getMunicipios().add(new MunicipiosAfectados("Espinal", 0, NivelDeAlerta.BAJO));
        tolima.getMunicipios().add(new MunicipiosAfectados("Honda", 0, NivelDeAlerta.BAJO));
        tolima.getMunicipios().add(new MunicipiosAfectados("Melgar", 0, NivelDeAlerta.BAJO));
        tolima.getMunicipios().add(new MunicipiosAfectados("Chaparral", 0, NivelDeAlerta.BAJO));
        tolima.getMunicipios().add(new MunicipiosAfectados("Mariquita", 0, NivelDeAlerta.BAJO));
        lista.add(tolima);

        Departamento valle = new Departamento("Valle del Cauca");
        valle.getMunicipios().add(new MunicipiosAfectados("Cali", 0, NivelDeAlerta.BAJO));
        valle.getMunicipios().add(new MunicipiosAfectados("Palmira", 0, NivelDeAlerta.BAJO));
        valle.getMunicipios().add(new MunicipiosAfectados("Tuluá", 0, NivelDeAlerta.BAJO));
        valle.getMunicipios().add(new MunicipiosAfectados("Buenaventura", 0, NivelDeAlerta.BAJO));
        valle.getMunicipios().add(new MunicipiosAfectados("Cartago", 0, NivelDeAlerta.BAJO));
        valle.getMunicipios().add(new MunicipiosAfectados("Buga", 0, NivelDeAlerta.BAJO));
        lista.add(valle);

        Departamento huila = new Departamento("Huila");
        huila.getMunicipios().add(new MunicipiosAfectados("Neiva", 0, NivelDeAlerta.BAJO));
        huila.getMunicipios().add(new MunicipiosAfectados("Pitalito", 0, NivelDeAlerta.BAJO));
        huila.getMunicipios().add(new MunicipiosAfectados("Garzón", 0, NivelDeAlerta.BAJO));
        huila.getMunicipios().add(new MunicipiosAfectados("La Plata", 0, NivelDeAlerta.BAJO));
        huila.getMunicipios().add(new MunicipiosAfectados("Campoalegre", 0, NivelDeAlerta.BAJO));
        huila.getMunicipios().add(new MunicipiosAfectados("San Agustín", 0, NivelDeAlerta.BAJO));
        lista.add(huila);

        return lista;
    }

    @Override
    public String toString() {
        return nombre;
    }
}