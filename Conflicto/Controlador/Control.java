package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {
    private JFConflicto vista;
    private GestorConflicto gestor;

    public Control(GestorConflicto gestor, JFConflicto vista) {
        this.gestor = gestor;
        this.vista = vista;

        cargarDatos();

        this.vista.getCampoTexto().setText("Conflictos: " + gestor.getConflictos().size()
                + " | Grupos armados: " + gestor.getGrupos().size()
                + " | Organizaciones mediadoras: " + gestor.getOrganizaciones().size()
                + "\nSeleccione un conflicto o un grupo armado.");

        this.vista.getBtnVerConflicto().addActionListener(this);
        this.vista.getBtnVerGrupo().addActionListener(this);
        this.vista.getBtnVerDialogos().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnVerConflicto()) {
            Conflicto c = (Conflicto) vista.getCbConflictos().getSelectedItem();
            if (c == null) {
                vista.getCampoTexto().setText("Seleccione un conflicto");
            } else {
                vista.getCampoTexto().setText(gestor.describirConflicto(c));
                vista.getCampoTexto().setCaretPosition(0);
            }
        } else if (e.getSource() == vista.getBtnVerGrupo()) {
            GrupoArmado g = (GrupoArmado) vista.getCbGrupos().getSelectedItem();
            if (g == null) {
                vista.getCampoTexto().setText("Seleccione un grupo armado");
            } else {
                vista.getCampoTexto().setText(gestor.describirGrupo(g));
                vista.getCampoTexto().setCaretPosition(0);
            }
        } else if (e.getSource() == vista.getBtnVerDialogos()) {
            vista.getCampoTexto().setText(gestor.describirDialogos());
            vista.getCampoTexto().setCaretPosition(0);
        }
    }

    private void cargarDatos() {
        Pais valdoria = new Pais("Valdoria");
        Pais kantara = new Pais("Kantara");
        Pais norland = new Pais("Norland");
        Pais sudelia = new Pais("Sudelia");
        Pais oriana = new Pais("Oriana");

        Territorial c1 = new Territorial(1, "Guerra del Valle", 1200, 3400);
        c1.agregarPais(valdoria);
        c1.agregarPais(kantara);
        c1.agregarRegion("Valle Alto");
        c1.agregarRegion("Costa Norte");

        Religioso c2 = new Religioso(2, "Conflicto del Desierto", 800, 2100);
        c2.agregarPais(kantara);
        c2.agregarPais(sudelia);
        c2.agregarReligion("Solarismo");
        c2.agregarReligion("Lunarismo");

        Economico c3 = new Economico(3, "Disputa del Litio", 150, 600);
        c3.agregarPais(norland);
        c3.agregarPais(sudelia);
        c3.agregarMateriaPrima("Litio");
        c3.agregarMateriaPrima("Cobre");

        Racial c4 = new Racial(4, "Conflicto del Rio", 400, 900);
        c4.agregarPais(oriana);
        c4.agregarEtnia("Tarenos");
        c4.agregarEtnia("Moloc");

        agregar(c1);
        agregar(c2);
        agregar(c3);
        agregar(c4);

        GrupoArmado g1 = new GrupoArmado("G1", "Frente Norte");
        LiderPolitico aldo = new LiderPolitico("Aldo Reyes", "El Halcon, El Profe");
        g1.agregarLider(aldo);
        Division d11 = new Division(1, 3, 10, 800, 15, 120);
        Division d12 = new Division(2, 1, 4, 500, 8, 80);
        g1.agregarDivision(d11);
        g1.agregarDivision(d12);
        g1.agregarJefe(d11, new JefeMilitar("J1", "General", aldo));
        g1.agregarJefe(d11, new JefeMilitar("J2", "Coronel", aldo));
        g1.agregarJefe(d12, new JefeMilitar("J3", "Mayor", aldo));

        GrupoArmado g2 = new GrupoArmado("G2", "Ejercito Libre");
        LiderPolitico marta = new LiderPolitico("Marta Solis", "La Dama");
        g2.agregarLider(marta);
        Division d21 = new Division(1, 0, 6, 900, 20, 200);
        g2.agregarDivision(d21);
        g2.agregarJefe(d21, new JefeMilitar("J4", "General", marta));

        GrupoArmado g3 = new GrupoArmado("G3", "Milicia del Valle");
        LiderPolitico omar = new LiderPolitico("Omar Vega", "El Zorro");
        LiderPolitico luz = new LiderPolitico("Luz Mena", "La Sombra");
        g3.agregarLider(omar);
        g3.agregarLider(luz);
        Division d31 = new Division(1, 0, 0, 300, 2, 60);
        g3.agregarDivision(d31);
        g3.agregarJefe(d31, new JefeMilitar("J5", "Capitan", luz));
        g3.agregarJefe(d31, new JefeMilitar("J6", "Teniente", omar));

        GrupoArmado g4 = new GrupoArmado("G4", "Guardia Sur");
        LiderPolitico iris = new LiderPolitico("Iris Campos", "La Roca");
        g4.agregarLider(iris);
        Division d41 = new Division(1, 2, 3, 600, 10, 90);
        Division d42 = new Division(2, 0, 1, 250, 4, 40);
        g4.agregarDivision(d41);
        g4.agregarDivision(d42);
        g4.agregarJefe(d41, new JefeMilitar("J7", "Coronel", iris));
        g4.agregarJefe(d42, new JefeMilitar("J8", "Mayor", iris));

        agregar(g1);
        agregar(g2);
        agregar(g3);
        agregar(g4);

        OrganizacionMediadora m1 = new OrganizacionMediadora("M1", "Mediadores Unidos", TipoOrganizacion.INTERNACIONAL, null);
        OrganizacionMediadora m2 = new OrganizacionMediadora("M2", "Ministerio de Paz", TipoOrganizacion.GUBERNAMENTAL, null);
        OrganizacionMediadora m3 = new OrganizacionMediadora("M3", "Fundacion Esperanza", TipoOrganizacion.NO_GUBERNAMENTAL, m1);
        gestor.agregarOrganizacion(m1);
        gestor.agregarOrganizacion(m2);
        gestor.agregarOrganizacion(m3);

        gestor.agregarIntervencion(new Intervencion(g1, c1, new Fecha(10, 1, 2020), null));
        gestor.agregarIntervencion(new Intervencion(g2, c1, new Fecha(1, 3, 2020), new Fecha(30, 6, 2022)));
        gestor.agregarIntervencion(new Intervencion(g3, c1, new Fecha(15, 5, 2021), null));
        gestor.agregarIntervencion(new Intervencion(g2, c2, new Fecha(2, 2, 2021), null));
        gestor.agregarIntervencion(new Intervencion(g4, c2, new Fecha(20, 9, 2021), null));
        gestor.agregarIntervencion(new Intervencion(g3, c3, new Fecha(5, 4, 2022), null));
        gestor.agregarIntervencion(new Intervencion(g4, c3, new Fecha(8, 8, 2022), null));
        gestor.agregarIntervencion(new Intervencion(g1, c4, new Fecha(12, 12, 2019), new Fecha(1, 10, 2021)));
        gestor.agregarIntervencion(new Intervencion(g4, c4, new Fecha(3, 3, 2020), null));

        gestor.agregarIntervencion(new Intervencion(m1, c1, new Fecha(1, 6, 2020), null, 120, TipoAyuda.MEDICA));
        gestor.agregarIntervencion(new Intervencion(m3, c1, new Fecha(1, 9, 2020), null, 60, TipoAyuda.PRESENCIAL));
        gestor.agregarIntervencion(new Intervencion(m1, c2, new Fecha(10, 4, 2021), null, 40, TipoAyuda.DIPLOMATICA));
        gestor.agregarIntervencion(new Intervencion(m2, c3, new Fecha(1, 7, 2022), null, 25, TipoAyuda.DIPLOMATICA));

        TipoArma fusil = new TipoArma("Fusil", 5);
        TipoArma misil = new TipoArma("Misil", 9);
        TipoArma mortero = new TipoArma("Mortero", 7);

        Traficante t1 = new Traficante("Armas del Este");
        t1.agregarArma(fusil, 1000);
        t1.agregarArma(misil, 50);
        Traficante t2 = new Traficante("Comercio Gris");
        t2.agregarArma(fusil, 500);
        t2.agregarArma(mortero, 200);
        gestor.agregarTraficante(t1);
        gestor.agregarTraficante(t2);

        gestor.agregarSuministro(new Suministra(t1, g1, fusil, 400));
        gestor.agregarSuministro(new Suministra(t1, g2, fusil, 300));
        gestor.agregarSuministro(new Suministra(t1, g1, misil, 20));
        gestor.agregarSuministro(new Suministra(t2, g3, mortero, 100));
        gestor.agregarSuministro(new Suministra(t2, g4, fusil, 200));

        gestor.agregarDialogo(new Dialogo(aldo, m1, new Fecha(5, 7, 2020)));
        gestor.agregarDialogo(new Dialogo(marta, m1, new Fecha(9, 11, 2021)));
        gestor.agregarDialogo(new Dialogo(marta, m2, new Fecha(14, 2, 2022)));
        gestor.agregarDialogo(new Dialogo(omar, m3, new Fecha(3, 10, 2021)));
        gestor.agregarDialogo(new Dialogo(iris, m2, new Fecha(18, 8, 2022)));
    }

    private void agregar(Conflicto c) {
        if (gestor.agregarConflicto(c)) {
            vista.getCbConflictos().addItem(c);
        }
    }

    private void agregar(GrupoArmado g) {
        if (gestor.agregarGrupo(g)) {
            vista.getCbGrupos().addItem(g);
        }
    }
}