package Modelo;

import java.util.ArrayList;

public class Operacion
{
    private String fecha;
    private UnidadOperativa unidad;
    private Rescatados rescatados;

    private ArrayList<Departamento> departamentos;
    private ArrayList<UnidadOperativa> unidadesOperativas;
    private ArrayList<Operacion> operaciones;

    public Operacion() {
        this.departamentos = new ArrayList<>();
        this.unidadesOperativas = new ArrayList<>();
        this.operaciones = new ArrayList<>();
    }

    public Operacion(String fecha, UnidadOperativa unidad, Rescatados rescatados) {
        this.fecha = fecha;
        this.unidad = unidad;
        this.rescatados = rescatados;
    }

    public UnidadOperativa getUnidad() {
        return unidad;
    }

    public Rescatados getRescatados() {
        return rescatados;
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public ArrayList<UnidadOperativa> getUnidadesOperativas() {
        return unidadesOperativas;
    }

    public void setUnidadesOperativas(ArrayList<UnidadOperativa> unidadesOperativas) {
        this.unidadesOperativas = unidadesOperativas;
    }

    public ArrayList<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(ArrayList<Operacion> operaciones) {
        this.operaciones = operaciones;
    }
    public boolean registrarMunicipios(Departamento departamento, String nombreMunicipio, int poblacion, String codigo) {
        MunicipiosAfectados m = null;
        for (MunicipiosAfectados existente : departamento.getMunicipios()) {
            if (existente.getNombreMunicipio().equals(nombreMunicipio)) {
                m = existente;
            }
        }
        if (m == null) {
            m = new MunicipiosAfectados(nombreMunicipio, poblacion, NivelDeAlerta.BAJO);
            departamento.getMunicipios().add(m);
        }
        for (Incendio in : m.getIncendios()) {
            if (in.getCodigo().equals(codigo)) {
                return false;
            }
        }
        m.setPoblacion(poblacion);
        m.getIncendios().add(new Incendio(codigo));
        return true;
    }

    public boolean anadirIncendio(MunicipiosAfectados municipio, String codigo) {
        for (Incendio in : municipio.getIncendios()) {
            if (in.getCodigo().equals(codigo)) {
                return false;
            }
        }
        municipio.getIncendios().add(new Incendio(codigo));
        return true;
    }

    public String listarMunicipios() {
        String respuesta = "";
        for (Departamento dep : Departamento.getCatalogo()) {
            for (MunicipiosAfectados m : dep.getMunicipios()) {
                if (m.getIncendios().isEmpty()) {
                    continue;
                }

                respuesta += "Departamento: " + dep.getNombre()
                           + " Municipio: " + m.getNombreMunicipio()
                           + " De Poblacion: " + m.getPoblacion();

                int cantidadIncendios = m.getIncendios().size();

                String a = "";
                if (cantidadIncendios < 3) {
                    NivelDeAlerta nivelAlerta1 = NivelDeAlerta.BAJO;
                    a = nivelAlerta1.name();
                } else if (cantidadIncendios <= 6) {
                    NivelDeAlerta nivelAlerta2 = NivelDeAlerta.MEDIO;
                    a = nivelAlerta2.name();
                } else {
                    NivelDeAlerta nivelAlerta3 = NivelDeAlerta.ALTO;
                    a = nivelAlerta3.name();
                }

                respuesta += " Cantidad de incendios: " + cantidadIncendios + " Nivel de Alerta " + a + "\n";

                for (Incendio inc : m.getIncendios()) {
                    respuesta += "Municipio de " + m.getNombreMunicipio()
                               + " de población " + m.getPoblacion()
                               + " con código de incendio " + inc.getCodigo()
                               + " nivel de alerta " + a + "\n";
                }
            }
        }
        if (respuesta.equals("")) {
            return "No hay municipios con incendios registrados";
        }
        return respuesta;
    }

    public boolean registrarUnidadesTerrestres(String codigo, int equipoTotal, boolean equipoCertificado) {
        for (UnidadOperativa uni : unidadesOperativas) {
            if (uni.getCodigo().equals(codigo)) {
                return false;
            }
        }
        UnidadTerrestre u = new UnidadTerrestre(codigo, equipoTotal, equipoCertificado);
        unidadesOperativas.add(u);
        return true;
    }

    public String listarUnidadesTerrestres() {
        String respuesta = "";
        for (UnidadOperativa u : unidadesOperativas) {
            if (u instanceof UnidadTerrestre) {
                respuesta += u.toString() + "\n";
            }
        }
        return respuesta;
    }

    public boolean registrarHelicopteros(String nombre, String codigo, boolean bambiBucket) {
        for (UnidadOperativa u : unidadesOperativas) {
            if (u.getCodigo().equals(codigo)) {
                return false;
            }
        }
        String cedula = "";
        String idLicenciaVuelo = "";
        int edad = 0;
        Piloto p = new Piloto(nombre, cedula, edad, idLicenciaVuelo);
        Helicoptero h = new Helicoptero(codigo, p, bambiBucket);
        unidadesOperativas.add(h);
        return true;
    }

    public String listarHelicopteros() {
        String r = "";
        for (UnidadOperativa u : unidadesOperativas) {
            if (u instanceof Helicoptero) {
                r += u.toString() + "\n";
            }
        }
        return r;
    }

    public String iniciarOperacion(MunicipiosAfectados municipio, String codigoIncendio, UnidadOperativa unidad, String fecha) {
        if (municipio == null || unidad == null) {
            return null;
        }

        Incendio incendio = null;
        for (Incendio inc : municipio.getIncendios()) {
            if (inc.getCodigo().equals(codigoIncendio)) {
                incendio = inc;
            }
        }
        if (incendio == null) {
            return null;
        }

        for (Operacion op : operaciones) {
            if (op.unidad == unidad) {
                return null;
            }
        }

        int cantidad = municipio.getIncendios().size();
        NivelDeAlerta nivel;
        if (cantidad < 3) {
            nivel = NivelDeAlerta.BAJO;
        } else if (cantidad <= 6) {
            nivel = NivelDeAlerta.MEDIO;
        } else {
            nivel = NivelDeAlerta.ALTO;
        }

        if (unidad instanceof UnidadTerrestre) {
            if (!((UnidadTerrestre) unidad).isEquipoCertificado() && nivel != NivelDeAlerta.BAJO) {
                return null;
            }
        }
        if (unidad instanceof Helicoptero) {
            if (!((Helicoptero) unidad).getPoseeBambiBucket() && nivel != NivelDeAlerta.BAJO) {
                return null;
            }
        }

        int pob = municipio.getPoblacion();
        int noAfectados;
        int damnificados;

        if (nivel == NivelDeAlerta.BAJO) {
            noAfectados = pob * 50 / 100;
            damnificados = pob * 30 / 100;
        } else if (nivel == NivelDeAlerta.MEDIO) {
            noAfectados = pob * 40 / 100;
            damnificados = pob * 35 / 100;
        } else {
            noAfectados = pob * 10 / 100;
            damnificados = pob * 30 / 100;
        }

        if (pob == 0) {
            return "Operacion Fallida Todos Murieron";
        }
        int muertos = pob - noAfectados - damnificados;
        int sobrevivientes = noAfectados + damnificados;
        municipio.setPoblacion(sobrevivientes);

        operaciones.add(new Operacion(fecha, unidad, null));

        return "Fecha: " + fecha + "\n"
                + "Municipio: " + municipio.getNombreMunicipio() + "\n"
                + "Código del incendio apagado: " + incendio.getCodigo() + "\n"
                + "Poblacion Original: " + pob + "\n"
                + "No afectados: " + noAfectados + "\n"
                + "Damnificados: " + damnificados + "\n"
                + "Muertos: " + muertos + "\n"
                + "Sobrevivientes: " + sobrevivientes + "\n"
                + "Nivel actual del municipio: " + nivel + "\n";
    }
}