package Modelo;
import java.util.ArrayList;

public class GestorConflicto
{
    private ArrayList<Conflicto> conflictos;
    private ArrayList<GrupoArmado> grupos;
    private ArrayList<OrganizacionMediadora> organizaciones;
    private ArrayList<Traficante> traficantes;
    private ArrayList<Intervencion> intervenciones;
    private ArrayList<Suministra> suministros;
    private ArrayList<Dialogo> dialogos;

    public GestorConflicto(){
        conflictos = new ArrayList<>();
        grupos = new ArrayList<>();
        organizaciones = new ArrayList<>();
        traficantes = new ArrayList<>();
        intervenciones = new ArrayList<>();
        suministros = new ArrayList<>();
        dialogos = new ArrayList<>();
    }

    public ArrayList<Conflicto> getConflictos(){
        return conflictos;
    }

    public ArrayList<GrupoArmado> getGrupos(){
        return grupos;
    }

    public ArrayList<OrganizacionMediadora> getOrganizaciones(){
        return organizaciones;
    }


  
    public boolean agregarConflicto(Conflicto c){
        if(buscarConflicto(c.getCodigo()) != null || c.getPaises().isEmpty() || c.getMuertos() + c.getHeridos() == 0){
            return false;
        }
        conflictos.add(c);
        return true;
    }

    public Conflicto buscarConflicto(int codigo){
        for(Conflicto c : conflictos){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        return null;
    }

    public boolean agregarGrupo(GrupoArmado g){
        for(GrupoArmado grupo : grupos){
            if(grupo.getCodigo().equals(g.getCodigo())){
                return false;
            }
        }
        if(!g.cumpleMinimos()){
            return false;
        }
        grupos.add(g);
        return true;
    }

    public boolean agregarOrganizacion(OrganizacionMediadora o){
        for(OrganizacionMediadora org : organizaciones){
            if(org.getCodigo().equals(o.getCodigo())){
                return false;
            }
        }
        organizaciones.add(o);
        return true;
    }

    public void agregarTraficante(Traficante t){
        traficantes.add(t);
    }

    public void agregarIntervencion(Intervencion i){
        intervenciones.add(i);
    }

    
    public boolean agregarSuministro(Suministra s){
        int yaSuministradas = 0;
        for(Suministra otro : suministros){
            if(otro.getTraficante() == s.getTraficante() && otro.getArma() == s.getArma()){
                yaSuministradas += otro.getNumeroArmas();
            }
        }
        if(yaSuministradas + s.getNumeroArmas() > s.getTraficante().cantidadPosible(s.getArma())){
            return false;
        }
        suministros.add(s);
        return true;
    }

    public void agregarDialogo(Dialogo d){
        dialogos.add(d);
    }


    public int contarGrupos(Conflicto c){
        int contador = 0;
        for(Intervencion i : intervenciones){
            if(i.getConflicto() == c && i.esGrupo()){
                contador++;
            }
        }
        return contador;
    }


    public boolean conflictoValido(Conflicto c){
        return contarGrupos(c) >= 2;
    }

    public int totalDesplegados(OrganizacionMediadora o){
        int total = 0;
        for(Intervencion i : intervenciones){
            if(i.getOrganizacion() == o){
                total += i.getNumDespliegue();
            }
        }
        return total;
    }

    public String describirConflicto(Conflicto c){
        String texto = "Conflicto " + c + "\nTipo: " + c.getTipo();
        if(!c.getDetalle().isEmpty()){
            texto += "\n" + c.getDetalle();
        }
        texto += "\nPaises afectados: " + c.getPaises() +
            "\nMuertos: " + c.getMuertos() + " | Heridos: " + c.getHeridos() +
            "\nGrupos armados: " + contarGrupos(c) + (conflictoValido(c) ? " (cumple el minimo de 2)" : " (no cumple el minimo de 2)");

        texto += "\n\nGrupos armados:";
        for(Intervencion i : intervenciones){
            if(i.getConflicto() == c && i.esGrupo()){
                texto += "\n - " + i.getGrupo() + " | " + i.getPeriodo();
            }
        }

        texto += "\n\nOrganizaciones mediadoras:";
        boolean hay = false;
        for(Intervencion i : intervenciones){
            if(i.getConflicto() == c && !i.esGrupo()){
                hay = true;
                texto += "\n - " + i.getOrganizacion() + " | ayuda " + i.getAyuda() +
                    " | personas: " + i.getNumDespliegue() + " | " + i.getPeriodo();
            }
        }
        if(!hay){
            texto += "\n (ninguna)";
        }
        return texto;
    }

    public String describirGrupo(GrupoArmado g){
        String texto = "Grupo armado " + g + "\nBajas totales: " + g.sumarBajas();

        texto += "\n\nLideres politicos:";
        for(LiderPolitico l : g.getLideres()){
            texto += "\n - " + l.getNombre() + " (" + l.getApodos() + ")";
        }

        texto += "\n\nDivisiones:";
        for(Division d : g.getDivisiones()){
            texto += "\n - " + d;
            for(JefeMilitar j : d.getJefes()){
                texto += "\n     Jefe: " + j;
            }
        }

        texto += "\n\nArmas suministradas:";
        boolean hay = false;
        for(Suministra s : suministros){
            if(s.getGrupo() == g){
                hay = true;
                texto += "\n - " + s.getTraficante() + ": " + s.getNumeroArmas() + " x " + s.getArma();
            }
        }
        if(!hay){
            texto += "\n (ninguna)";
        }

        texto += "\n\nConflictos en que interviene:";
        hay = false;
        for(Intervencion i : intervenciones){
            if(i.getGrupo() == g){
                hay = true;
                texto += "\n - " + i.getConflicto() + " | " + i.getPeriodo();
            }
        }
        if(!hay){
            texto += "\n (ninguno)";
        }
        return texto;
    }

  
    public String describirDialogos(){
        String texto = "Lideres politicos y organizaciones con que dialogan:";
        for(GrupoArmado g : grupos){
            for(LiderPolitico l : g.getLideres()){
                texto += "\n - " + l.getNombre() + " (" + g.getCodigo() + "): ";
                String lista = "";
                for(Dialogo d : dialogos){
                    if(d.getLider() == l){
                        lista += (lista.isEmpty() ? "" : ", ") + d.getOrganizacion().getNombre() + " [" + d.getFechaDialogo() + "]";
                    }
                }
                texto += lista.isEmpty() ? "ninguna" : lista;
            }
        }

        texto += "\n\nOrganizaciones y lideres con que dialogan:";
        for(OrganizacionMediadora o : organizaciones){
            texto += "\n - " + o.getNombre() + ": ";
            String lista = "";
            for(Dialogo d : dialogos){
                if(d.getOrganizacion() == o){
                    lista += (lista.isEmpty() ? "" : ", ") + d.getLider().getNombre();
                }
            }
            texto += lista.isEmpty() ? "ninguno" : lista;
        }
        return texto;
    }
}
