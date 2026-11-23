package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.*;
import javax.swing.JButton;

public class ControladorIncendios implements ActionListener {

    private Operacion modelo;
    private JFTMunicipios vistaMunicipios;
    private JFTUnidadTerrestre vistaTerrestre;
    private JFTHelicoptero vistaHelicoptero;
    private JFTIniciarOperacion vistaOperacion;

    private JButton btnRegistrarMunicipios;
    private JButton btnListarMunicipios;
    private JButton btnAnadirIncendio;
    private JButton btnRegistrarTerrestre;
    private JButton btnListarTerrestre;
    private JButton btnRegistrarHelicoptero;
    private JButton btnListarHelicoptero;
    private JButton btnIniciarOperacion;

    public ControladorIncendios(Operacion modelo, JFTIncendioPrincipal ventana) {
        this.modelo = modelo;
        this.vistaMunicipios = ventana.municipios;
        this.vistaTerrestre = ventana.terrestre;
        this.vistaHelicoptero = ventana.helicoptero;
        this.vistaOperacion = ventana.operacion;

        btnRegistrarMunicipios = vistaMunicipios.getBotonRegistrar();
        btnListarMunicipios = vistaMunicipios.getBotonListar();
        btnAnadirIncendio = vistaMunicipios.getBotonAnadirIncendio();
        btnRegistrarTerrestre = vistaTerrestre.getBotonRegistrar();
        btnListarTerrestre = vistaTerrestre.getBotonListar();
        btnRegistrarHelicoptero = vistaHelicoptero.getBotonRegistrar();
        btnListarHelicoptero = vistaHelicoptero.getBotonListar();
        btnIniciarOperacion = vistaOperacion.getBotonIniciar();

        btnRegistrarMunicipios.addActionListener(this);
        btnListarMunicipios.addActionListener(this);
        btnAnadirIncendio.addActionListener(this);
        btnRegistrarTerrestre.addActionListener(this);
        btnListarTerrestre.addActionListener(this);
        btnRegistrarHelicoptero.addActionListener(this);
        btnListarHelicoptero.addActionListener(this);
        btnIniciarOperacion.addActionListener(this);

        vistaMunicipios.getCmbDepartamento().addItemListener(new ItemListener() {
            @Override //se encarga de vaciar los municipios al cambiar de departamentos
            public void itemStateChanged(ItemEvent ev) {
                if (ev.getStateChange() == ItemEvent.SELECTED) {
                    Departamento dep = (Departamento) ev.getItem();
                    vistaMunicipios.getCmbMunicipio().removeAllItems();
                    for (MunicipiosAfectados m : dep.getMunicipios()) {
                        vistaMunicipios.getCmbMunicipio().addItem(m);
                    }
                }
            }
        });

        vistaOperacion.getCmbDepartamento().addItemListener(new ItemListener() {
            @Override//se encarga de  agregar municipios con incendios dentro de la operacion
            public void itemStateChanged(ItemEvent ev) {
                if (ev.getStateChange() == ItemEvent.SELECTED) {
                    Departamento dep = (Departamento) ev.getItem();
                    vistaOperacion.getCmbIncendio().removeAllItems();
                    vistaOperacion.getCmbMunicipio().removeAllItems();
                    for (MunicipiosAfectados m : dep.getMunicipios()) {
                        if (!m.getIncendios().isEmpty()) {
                            vistaOperacion.getCmbMunicipio().addItem(m);
                        }
                    }
                }
            }
        });

        vistaOperacion.getCmbMunicipio().addItemListener(new ItemListener() {
            @Override//llena los incendios automaticamente dentro de la operacion
            public void itemStateChanged(ItemEvent ev) {
                if (ev.getStateChange() == ItemEvent.SELECTED) {
                    MunicipiosAfectados m = (MunicipiosAfectados) ev.getItem();
                    vistaOperacion.getCmbIncendio().removeAllItems();
                    for (Incendio inc : m.getIncendios()) {
                        vistaOperacion.getCmbIncendio().addItem(inc);
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegistrarMunicipios) {
            Departamento dep = (Departamento) vistaMunicipios.getCmbDepartamento().getSelectedItem();
            MunicipiosAfectados mun = (MunicipiosAfectados) vistaMunicipios.getCmbMunicipio().getSelectedItem();
            if (modelo.registrarMunicipios(dep, mun.getNombreMunicipio(),
                    Integer.parseInt(vistaMunicipios.getTxtPoblacion()), vistaMunicipios.getTxtCodigo())) {
                vistaMunicipios.setTxtRespuestas("Municipio registrado.\n");
                vistaMunicipios.getCmbNuevoMunicipio().removeAllItems();
                for (Departamento d : Departamento.getCatalogo()) {
                    for (MunicipiosAfectados m : d.getMunicipios()) {
                        if (!m.getIncendios().isEmpty()) {
                            vistaMunicipios.getCmbNuevoMunicipio().addItem(m);
                        }
                    }
                }
                vistaMunicipios.mostrarPanelNuevo();

                if (mun.getIncendios().size() == 1) {
                    boolean depEnOperacion = false;
                    for (int i = 0; i < vistaOperacion.getCmbDepartamento().getItemCount(); i++) {
                        if (vistaOperacion.getCmbDepartamento().getItemAt(i) == dep) {
                            depEnOperacion = true;
                        }
                    }
                    if (!depEnOperacion) {
                        vistaOperacion.getCmbDepartamento().addItem(dep);
                    } else if (vistaOperacion.getCmbDepartamento().getSelectedItem() == dep) {
                        vistaOperacion.getCmbMunicipio().addItem(mun);
                    }
                }
            } else {
                vistaMunicipios.setTxtRespuestas("Ese código ya existe en ese municipio.\n");
            }
        }

        else if (e.getSource() == btnListarMunicipios) {
            vistaMunicipios.setTxtRespuestas(modelo.listarMunicipios());
        }

        else if (e.getSource() == btnAnadirIncendio) {
            MunicipiosAfectados mun = (MunicipiosAfectados) vistaMunicipios.getCmbNuevoMunicipio().getSelectedItem();
            String codigo = vistaMunicipios.getTxtNuevoCodigo();
            if (modelo.anadirIncendio(mun, codigo)) {
                Incendio nuevo = mun.getIncendios().get(mun.getIncendios().size() - 1);
                if (vistaOperacion.getCmbMunicipio().getSelectedItem() == mun) {
                    vistaOperacion.getCmbIncendio().addItem(nuevo);
                }
                vistaMunicipios.setTxtRespuestas("Incendio añadido a " + mun.getNombreMunicipio() + ".\n");
            
            } else {
                vistaMunicipios.setTxtRespuestas("Ese código ya existe en ese municipio.\n");
            }
        }

        else if (e.getSource() == btnRegistrarTerrestre) {
            if (modelo.registrarUnidadesTerrestres(
                    vistaTerrestre.getTxtCodigo(),
                    Integer.parseInt(vistaTerrestre.getTxtCantidad()), vistaTerrestre.getChkCertificado())) {
                int ultimo = modelo.getUnidadesOperativas().size() - 1;
                vistaOperacion.getCmbUnidad().addItem((UnidadTerrestre) modelo.getUnidadesOperativas().get(ultimo));
                vistaTerrestre.setTxtRespuestasUnidad("Unidad registrada.\n");
            } else {
                vistaTerrestre.setTxtRespuestasUnidad("Ya existe una unidad con ese código.\n");
            }
        }

        else if (e.getSource() == btnListarTerrestre) {
            vistaTerrestre.setTxtRespuestasUnidad(modelo.listarUnidadesTerrestres());
        }

        else if (e.getSource() == btnRegistrarHelicoptero) {
            if (modelo.registrarHelicopteros(vistaHelicoptero.getTxtNombre(),
                    vistaHelicoptero.getTxtCodigo(), vistaHelicoptero.getChkBambiBucket())) {
                int ultimo = modelo.getUnidadesOperativas().size() - 1;
                vistaOperacion.getCmbHelicoptero().addItem((Helicoptero) modelo.getUnidadesOperativas().get(ultimo));
                vistaHelicoptero.setTxtRespuestasHelicoptero("Helicóptero registrado.\n");
            } else {
                vistaHelicoptero.setTxtRespuestasHelicoptero("Ya existe un helicóptero con ese código.\n");
            }
        }

        else if (e.getSource() == btnListarHelicoptero) {
            vistaHelicoptero.setTxtRespuestasHelicoptero(modelo.listarHelicopteros());
        }

        else if (e.getSource() == btnIniciarOperacion) {
            MunicipiosAfectados municipio = (MunicipiosAfectados) vistaOperacion.getCmbMunicipio().getSelectedItem();
            Incendio incendio = (Incendio) vistaOperacion.getCmbIncendio().getSelectedItem();

            UnidadOperativa unidad;
            if (vistaOperacion.getCmbUnidad().getSelectedItem() != null) {
                unidad = (UnidadTerrestre) vistaOperacion.getCmbUnidad().getSelectedItem();
            } else {
                unidad = (Helicoptero) vistaOperacion.getCmbHelicoptero().getSelectedItem();
            }

            String resultado = modelo.iniciarOperacion(municipio, String.valueOf(incendio),
                    unidad, vistaOperacion.getTxtFecha());

            if (resultado != null) {
                municipio.getIncendios().remove(incendio);
                vistaOperacion.getCmbIncendio().removeItem(incendio);

                if (municipio.getIncendios().isEmpty()) {
                    Departamento dep = (Departamento) vistaOperacion.getCmbDepartamento().getSelectedItem();
                    dep.getMunicipios().remove(municipio);
                    vistaOperacion.getCmbMunicipio().removeItem(municipio);
                    vistaMunicipios.getCmbMunicipio().removeItem(municipio);
                    vistaMunicipios.getCmbNuevoMunicipio().removeItem(municipio);

                    boolean quedanIncendios = false;
                    for (MunicipiosAfectados m : dep.getMunicipios()) {
                        if (!m.getIncendios().isEmpty()) {
                            quedanIncendios = true;
                        }
                    }
                    if (!quedanIncendios) {
                        vistaOperacion.getCmbDepartamento().removeItem(dep);
                    }
                }

                vistaOperacion.setTxtRespuestasOperacion(resultado);
            } else {
                vistaOperacion.setTxtRespuestasOperacion("No se pudo iniciar la operación.\n");
            }
        }
    }
}