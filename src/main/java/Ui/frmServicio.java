/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ui;
import Datos.clsPlanilla;
import Datos.clsServicios;
import Logica.fPlanilla;
import Logica.fServicios;
import java.awt.Color;
import java.sql.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class frmServicio extends javax.swing.JFrame {

    /**
     * Creates new form frmServicio
     */
    public frmServicio() {
        initComponents();
         //cargarTabla("", "Codigo", "Codigo", "desc");
        inhabilitar();
    }
        String accion = "null";
    boolean isActiveNuevo = false;
    boolean isActiveEditar = false;
private void inhabilitar() {
        isActiveNuevo = false;
        isActiveEditar = false;
        txtDescripcionServicio.setEditable(false);
        txtFechaServicios.setEditable(false);
        txtValor.setEditable(false);
        txtTipoServicio.setEditable(false);
        //  txtIva.setEditable(false);
        txtEstadoServicio.setEditable(false);
        txtNombreServicio.setEditable(false);
        btnGuardar.setBackground(new Color(179, 182, 183));
        btnEditar.setBackground(new Color(179, 182, 183));
        btnEliminar.setBackground(new Color(179, 182, 183));
        btnCancelar.setBackground(new Color(179, 182, 183));

    }

    private void habilitarNuevo() {
        isActiveNuevo = true;
        isActiveEditar = false;

        txtDescripcionServicio.setEditable(true);
        txtFechaServicios.setEditable(true);
        txtValor.setEditable(true);
        txtTipoServicio.setEditable(true);
        //  txtIva.setEditable(true);
        txtEstadoServicio.setEditable(true);
        txtNombreServicio.setEditable(true);
        btnGuardar.setBackground(new Color(52, 152, 219));
        btnEditar.setBackground(new Color(179, 182, 183));
        btnEliminar.setBackground(new Color(179, 182, 183));
        btnCancelar.setBackground(new Color(52, 152, 219));
    }

    private void tablahabilitareditar() {
        isActiveNuevo = true;
        isActiveEditar = true;
        txtDescripcionServicio.setEditable(false);
        txtFechaServicios.setEditable(false);
        txtValor.setEditable(false);
        txtTipoServicio.setEditable(false);
        // txtIva.setEditable(false);
        txtEstadoServicio.setEditable(false);
        txtNombreServicio.setEditable(false);
        btnGuardar.setBackground(new Color(52, 152, 219));
        btnCancelar.setBackground(new Color(52, 152, 219));
        btnEditar.setBackground(new Color(52, 152, 219));
        btnEliminar.setBackground(new Color(52, 152, 219));
    }

    private void habilitareditar() {
        isActiveNuevo = true;
        isActiveEditar = true;
        txtDescripcionServicio.setEditable(true);
        txtFechaServicios.setEditable(true);
        txtValor.setEditable(true);
        txtTipoServicio.setEditable(true);
        // txtIva.setEditable(true);
        txtEstadoServicio.setEditable(true);
        txtNombreServicio.setEditable(true);
        btnGuardar.setBackground(new Color(52, 152, 219));
        btnCancelar.setBackground(new Color(52, 152, 219));
        btnEditar.setBackground(new Color(52, 152, 219));
        btnEliminar.setBackground(new Color(52, 152, 219));
    }

    private void limpiarCampos() {
        txtIdServicio.setText("");
        txtDescripcionServicio.setText("");
        txtFechaServicios.setText("");
        txtValor.setText("");
        txtTipoServicio.setText("");
        //txtIva.setText("");
        txtEstadoServicio.setText("");
        txtNombreServicio.setText("");

    }

    void cargarTabla(String buscar, String criterioBusqueda, String criterioOrden, String orden) {
        try {
            DefaultTableModel modelo;
            fPlanilla funcPlanilla = new fPlanilla();
            modelo = funcPlanilla.mostrar(buscar, criterioBusqueda, criterioOrden, orden);
            tblServicios.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }

    void mostrarServiciosPlanilla(String buscar, String criterioBusqueda, String criterioOrden, String orden, int idPlanilla) {
        try {
            DefaultTableModel modelo;
            fServicios funcServicios = new fServicios();
            modelo = funcServicios.mostrarServiciosPlanilla(buscar, criterioBusqueda, criterioOrden, orden, idPlanilla);
            tblServicios.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    /* void cargarTablaMedidoresSocios(int idSocio) {
        try {
            DefaultTableModel modelo;
            fSocios funcSocios = new fSocios();
            modelo = funcSocios.mostrarMedidoresSocio(idSocio);
            tblMedidoresSocio.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }
     */
    void guardar() {
  
        if (txtFechaServicios.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la fecha del servicio");
            txtFechaServicios.requestFocus();
            return;
        }
        
        if (txtTipoServicio.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el tipo del servicio");
            txtTipoServicio.requestFocus();
            return;
        }

        if (txtEstadoServicio.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el estado del servicio");
            txtEstadoServicio.requestFocus();
            return;
        }
        if (txtNombreServicio.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el nombre del servicio");
            txtNombreServicio.requestFocus();
            return;
        }
             if (txtDescripcionServicio.getText().length() == 0) {
            txtDescripcionServicio.setText("NA");
            txtDescripcionServicio.requestFocus();
            return;
        }

        if (txtValor.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el valor del servicio");
            txtValor.requestFocus();
            return;
        }

   

        clsServicios dts = new clsServicios();
        fServicios funcServicios = new fServicios();

        dts.setFecha(Date.valueOf(txtFechaServicios.getText()));
        dts.setTipo(txtTipoServicio.getText());
        dts.setEstado(txtEstadoServicio.getText());
        dts.setNombre(txtNombreServicio.getText());
        dts.setDescripcion(txtDescripcionServicio.getText());
        dts.setValor(Double.parseDouble(txtValor.getText()));
        dts.setFkPlanilla(Integer.parseInt(txtFkPlanilla.getText()));
       

        if (accion.equals("nuevo")) {
            try {
                if (funcServicios.insertar(dts)) {
                    JOptionPane.showConfirmDialog(rootPane, "El servicio se ha registrado satisfactoriamente");
                    mostrarServiciosPlanilla("", "Nombre", "Nombre", "desc",Integer.parseInt(txtFkPlanilla.getText()) );
                    limpiarCampos();
                    isActiveEditar = false;
                    isActiveNuevo = false;
                    inhabilitar();
                }
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(rootPane, "Ha ocurrido un error " + e);

            }
        } else if (accion.equals("editar")) {
            try {
                dts.setId(Integer.parseInt(txtIdServicio.getText()));
                if (funcServicios.editar(dts)) {
                    JOptionPane.showConfirmDialog(rootPane, "Se ha actualizado el registro del servicio " + dts.getNombre() + "  de " + dts.getFecha());
                    mostrarServiciosPlanilla("", "Nombre", "Nombre", "desc",Integer.parseInt(txtFkPlanilla.getText()) );
                    isActiveEditar = false;
                    isActiveNuevo = false;
                    inhabilitar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar el registro", "Error", JOptionPane.INFORMATION_MESSAGE, null);
            }
        } else if (accion.equals("null")) {
            JOptionPane.showMessageDialog(null, "Seleciona la opcion de actualizar registro primero", "Error", JOptionPane.INFORMATION_MESSAGE, null);

        } else {
            JOptionPane.showMessageDialog(null, "No se ha entendido  tu peticion", "Error", JOptionPane.INFORMATION_MESSAGE, null);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lblNombreInventario = new javax.swing.JLabel();
        lblNombreInventario1 = new javax.swing.JLabel();
        lblNombreInventario2 = new javax.swing.JLabel();
        lblEstadoInventario = new javax.swing.JLabel();
        lblFechaInventario = new javax.swing.JLabel();
        txtFkPlanilla = new javax.swing.JTextField();
        txtFkParametros = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        btnReporte = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btnReporte1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblImplementos = new javax.swing.JTable();
        paneFormulario = new javax.swing.JPanel();
        txtIdServicio = new javax.swing.JTextField();
        txtFechaServicios = new javax.swing.JTextField();
        txtNombreServicio = new javax.swing.JTextField();
        txtTipoServicio = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JLabel();
        txtDescripcionServicio = new javax.swing.JTextField();
        txtEstadoServicio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        paneFormulario1 = new javax.swing.JPanel();
        txtId1 = new javax.swing.JTextField();
        txtFechaServicio = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtValorServicio = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        btnGuardar1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btnCancelar1 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btnEliminar1 = new javax.swing.JLabel();
        txtLecturaActual1 = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));

        tblServicios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        tblServicios.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tblServicios.setForeground(new java.awt.Color(102, 102, 102));
        tblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblServicios.setGridColor(new java.awt.Color(255, 255, 255));
        tblServicios.setRowHeight(20);
        tblServicios.setSelectionBackground(new java.awt.Color(52, 152, 219));
        tblServicios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServiciosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblServicios);

        jPanel7.setPreferredSize(new java.awt.Dimension(150, 0));

        btnEditar.setBackground(new java.awt.Color(52, 152, 219));
        btnEditar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editarL32x32.png"))); // NOI18N
        btnEditar.setText("ACTUALIZAR");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setOpaque(true);
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setPreferredSize(new java.awt.Dimension(150, 0));

        btnAgregar.setBackground(new java.awt.Color(52, 152, 219));
        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregarbold32x32.png"))); // NOI18N
        btnAgregar.setText("NUEVO");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setOpaque(true);
        btnAgregar.setPreferredSize(new java.awt.Dimension(40, 15));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBackground(new java.awt.Color(52, 152, 219));

        jLabel7.setBackground(new java.awt.Color(52, 152, 219));
        jLabel7.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SERVICIOS");

        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtBuscarInputMethodTextChanged(evt);
            }
        });
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(52, 152, 219));
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar32x32.png"))); // NOI18N
        btnBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setOpaque(true);
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nombre", "Tipo", "Descripción", "Marca" }));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CATEGORíA");

        lblNombreInventario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreInventario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreInventario.setText("Nombre Inventario:");

        lblNombreInventario1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreInventario1.setText("Fecha Inventario");

        lblNombreInventario2.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreInventario2.setText("Estado:");

        lblEstadoInventario.setForeground(new java.awt.Color(255, 255, 255));
        lblEstadoInventario.setText("activo");

        lblFechaInventario.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaInventario.setText("2000-12-11");

        txtFkPlanilla.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtFkPlanilla.setBorder(javax.swing.BorderFactory.createTitledBorder("fkMedidores"));
        txtFkPlanilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFkPlanillaActionPerformed(evt);
            }
        });

        txtFkParametros.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtFkParametros.setBorder(javax.swing.BorderFactory.createTitledBorder("fkParametros"));
        txtFkParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFkParametrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lblNombreInventario2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEstadoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(lblNombreInventario1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblFechaInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFkPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNombreInventario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFkParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbCategoria)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblNombreInventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreInventario1)
                    .addComponent(lblFechaInventario)
                    .addComponent(txtFkPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFkParametros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreInventario2)
                    .addComponent(lblEstadoInventario))
                .addGap(18, 18, 18))
        );

        jPanel10.setPreferredSize(new java.awt.Dimension(150, 0));

        btnReporte.setBackground(new java.awt.Color(52, 152, 219));
        btnReporte.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imprimir32x32.png"))); // NOI18N
        btnReporte.setText("REPORTE");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.setOpaque(true);
        btnReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReporteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(52, 152, 219));

        jLabel2.setBackground(new java.awt.Color(52, 152, 219));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("IMPLEMENTOS USADOS");

        jPanel12.setPreferredSize(new java.awt.Dimension(150, 0));

        btnReporte1.setBackground(new java.awt.Color(52, 152, 219));
        btnReporte1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnReporte1.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReporte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imprimir32x32.png"))); // NOI18N
        btnReporte1.setText("AGREGAR IMPLEMENTO");
        btnReporte1.setToolTipText("");
        btnReporte1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte1.setOpaque(true);
        btnReporte1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReporte1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReporte1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReporte1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnReporte1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnReporte1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));

        tblImplementos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        tblImplementos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tblImplementos.setForeground(new java.awt.Color(102, 102, 102));
        tblImplementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblImplementos.setGridColor(new java.awt.Color(255, 255, 255));
        tblImplementos.setRowHeight(20);
        tblImplementos.setSelectionBackground(new java.awt.Color(52, 152, 219));
        tblImplementos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblImplementos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImplementosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblImplementos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneFormulario.setBackground(new java.awt.Color(255, 255, 255));
        paneFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la Planilla", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 18), new java.awt.Color(153, 153, 153))); // NOI18N
        paneFormulario.setForeground(new java.awt.Color(153, 153, 153));

        txtIdServicio.setEditable(false);
        txtIdServicio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtIdServicio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo"));

        txtFechaServicios.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtFechaServicios.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));
        txtFechaServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaServiciosActionPerformed(evt);
            }
        });

        txtNombreServicio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNombreServicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        txtNombreServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreServicioActionPerformed(evt);
            }
        });

        txtTipoServicio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTipoServicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));
        txtTipoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoServicioActionPerformed(evt);
            }
        });

        txtValor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtValor.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor"));
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(150, 0));

        btnGuardar.setBackground(new java.awt.Color(52, 152, 219));
        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar32x32.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setOpaque(true);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(150, 40));

        btnCancelar.setBackground(new java.awt.Color(52, 152, 219));
        btnCancelar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar32x32.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setToolTipText("");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setOpaque(true);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setPreferredSize(new java.awt.Dimension(150, 40));

        btnEliminar.setBackground(new java.awt.Color(52, 152, 219));
        btnEliminar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar32x32.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setOpaque(true);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtDescripcionServicio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDescripcionServicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion"));
        txtDescripcionServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionServicioActionPerformed(evt);
            }
        });

        txtEstadoServicio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtEstadoServicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));
        txtEstadoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneFormularioLayout = new javax.swing.GroupLayout(paneFormulario);
        paneFormulario.setLayout(paneFormularioLayout);
        paneFormularioLayout.setHorizontalGroup(
            paneFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFormularioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(paneFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paneFormularioLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                    .addComponent(txtIdServicio)
                    .addComponent(txtFechaServicios)
                    .addComponent(txtNombreServicio)
                    .addComponent(txtTipoServicio)
                    .addComponent(txtValor)
                    .addComponent(txtDescripcionServicio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEstadoServicio))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        paneFormularioLayout.setVerticalGroup(
            paneFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFormularioLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(txtIdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFechaServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEstadoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNombreServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDescripcionServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 42, Short.MAX_VALUE)
                .addGroup(paneFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 152, 219));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Inicio/Registros/Planilla");

        paneFormulario1.setBackground(new java.awt.Color(255, 255, 255));
        paneFormulario1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Servicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 18), new java.awt.Color(153, 153, 153))); // NOI18N
        paneFormulario1.setForeground(new java.awt.Color(153, 153, 153));

        txtId1.setEditable(false);
        txtId1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtId1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo"));

        txtFechaServicio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtFechaServicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));
        txtFechaServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaServicioActionPerformed(evt);
            }
        });

        txtTipo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción"));
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        txtValorServicio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtValorServicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor"));
        txtValorServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorServicioActionPerformed(evt);
            }
        });

        jPanel13.setPreferredSize(new java.awt.Dimension(150, 0));

        btnGuardar1.setBackground(new java.awt.Color(52, 152, 219));
        btnGuardar1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnGuardar1.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar32x32.png"))); // NOI18N
        btnGuardar1.setText("GUARDAR");
        btnGuardar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar1.setOpaque(true);
        btnGuardar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardar1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardar1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardar1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel14.setPreferredSize(new java.awt.Dimension(150, 40));

        btnCancelar1.setBackground(new java.awt.Color(52, 152, 219));
        btnCancelar1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnCancelar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar32x32.png"))); // NOI18N
        btnCancelar1.setText("CANCELAR");
        btnCancelar1.setToolTipText("");
        btnCancelar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar1.setOpaque(true);
        btnCancelar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelar1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.setPreferredSize(new java.awt.Dimension(150, 40));

        btnEliminar1.setBackground(new java.awt.Color(52, 152, 219));
        btnEliminar1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminar1.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar32x32.png"))); // NOI18N
        btnEliminar1.setText("ELIMINAR");
        btnEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar1.setOpaque(true);
        btnEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminar1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtLecturaActual1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtLecturaActual1.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));
        txtLecturaActual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLecturaActual1ActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneFormulario1Layout = new javax.swing.GroupLayout(paneFormulario1);
        paneFormulario1.setLayout(paneFormulario1Layout);
        paneFormulario1Layout.setHorizontalGroup(
            paneFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFormulario1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(paneFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paneFormulario1Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                    .addComponent(txtId1)
                    .addComponent(txtFechaServicio)
                    .addComponent(txtTipo)
                    .addComponent(txtDescripcion)
                    .addComponent(txtValorServicio)
                    .addComponent(txtLecturaActual1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombre))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        paneFormulario1Layout.setVerticalGroup(
            paneFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFormulario1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(txtId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFechaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtLecturaActual1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtValorServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneFormulario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paneFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paneFormulario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(paneFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(paneFormulario1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(360, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServiciosMouseClicked
        int fila = tblServicios.rowAtPoint(evt.getPoint());
        txtIdServicio.setText(tblServicios.getValueAt(fila, 0).toString());
        txtFkPlanilla.setText(tblServicios.getValueAt(fila, 1).toString());
        txtNombreServicio.setText(tblServicios.getValueAt(fila, 6).toString());
        //txtFkParametros.setText(tblServicios.getValueAt(fila, 2).toString());
        txtFechaServicios.setText(tblServicios.getValueAt(fila, 4).toString());
        txtEstadoServicio.setText(tblServicios.getValueAt(fila, 5).toString());
        txtDescripcionServicio.setText(tblServicios.getValueAt(fila, 3).toString());
        txtTipoServicio.setText(tblServicios.getValueAt(fila, 6).toString());
        txtValor.setText(tblServicios.getValueAt(fila, 7).toString());
        //mostrarServiciosPlanilla("", "Nombre", "Nombre", "desc",Integer.parseInt(tblServicios.getValueAt(fila, 0).toString()) );
        accion = "null";
        isActiveEditar = true;
        tablahabilitareditar();
    }//GEN-LAST:event_tblServiciosMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        if (isActiveEditar) {
            if (txtIdServicio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un registro a editar", "Error", JOptionPane.INFORMATION_MESSAGE, null);
            } else {
                accion = "editar";
                habilitareditar();
            }
        }
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseEntered
        if (isActiveEditar) {
            btnEditar.setBackground(new Color(133, 193, 233));
        }
    }//GEN-LAST:event_btnEditarMouseEntered

    private void btnEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseExited
        if (isActiveEditar) {
            btnEditar.setBackground(new Color(52, 152, 219));
        }
    }//GEN-LAST:event_btnEditarMouseExited

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        limpiarCampos();
        accion = "nuevo";
        habilitarNuevo();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseEntered
        btnAgregar.setBackground(new Color(133, 193, 233));
    }//GEN-LAST:event_btnAgregarMouseEntered

    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited
        btnAgregar.setBackground(new Color(52, 152, 219));
    }//GEN-LAST:event_btnAgregarMouseExited

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked

    }//GEN-LAST:event_txtBuscarMouseClicked

    private void txtBuscarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtBuscarInputMethodTextChanged

    }//GEN-LAST:event_txtBuscarInputMethodTextChanged

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (txtBuscar.getText().length() > 0) {
            ImageIcon iconoCancelarBusqueda = new ImageIcon("src/main/resources/cancelSoftnoBorder32x32.png");
            btnBuscar.setIcon(iconoCancelarBusqueda);
        } else {
            ImageIcon iconoBusqueda = new ImageIcon("src/main/resources/buscar32x32.png");
            btnBuscar.setIcon(iconoBusqueda);
        }
        String criterioBusqueda = "";
        //Código, Marca, Nombres Socio, Cedula Socio, Barrio, Calle Principal, Fecha Instalacion, Numero Casa

        if (cmbCategoria.getSelectedItem().toString().equals("Código")) {
            criterioBusqueda = "Codigo";
        }
        if (cmbCategoria.getSelectedItem().toString().equals("Nombre")) {
            criterioBusqueda = "Nombre";
        }
        if (cmbCategoria.getSelectedItem().toString().equals("Tipo")) {
            criterioBusqueda = "Tipo";
        }
        if (cmbCategoria.getSelectedItem().toString().equals("Descripcion")) {
            criterioBusqueda = "Descripcion";
        }
        if (cmbCategoria.getSelectedItem().toString().equals("Marca")) {
            criterioBusqueda = "Marca";
        }

        cargarTabla(txtBuscar.getText(), criterioBusqueda, criterioBusqueda, "desc");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        if (txtBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, " Escribe un texto y selecciona la categoría a buscar", "Error", JOptionPane.INFORMATION_MESSAGE, null);

        } else {
            txtBuscar.setText("");
            ImageIcon iconoBusqueda = new ImageIcon("src/main/resources/buscar32x32.png");
            btnBuscar.setIcon(iconoBusqueda);
            cargarTabla("", "Codigo", "Codigo", "desc");
            cmbCategoria.setSelectedIndex(1);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        btnBuscar.setBackground(new Color(133, 193, 233));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        btnBuscar.setBackground(new Color(52, 152, 219));
    }//GEN-LAST:event_btnBuscarMouseExited

    private void txtFkPlanillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFkPlanillaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFkPlanillaActionPerformed

    private void txtFkParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFkParametrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFkParametrosActionPerformed

    private void btnReporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteMouseEntered
        btnReporte.setBackground(new Color(133, 193, 233));
    }//GEN-LAST:event_btnReporteMouseEntered

    private void btnReporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteMouseExited
        btnReporte.setBackground(new Color(52, 152, 219));
    }//GEN-LAST:event_btnReporteMouseExited

    private void btnReporte1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporte1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporte1MouseEntered

    private void btnReporte1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporte1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporte1MouseExited

    private void tblImplementosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImplementosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblImplementosMouseClicked

    private void txtFechaServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaServiciosActionPerformed
        txtFechaServicios.transferFocus();
    }//GEN-LAST:event_txtFechaServiciosActionPerformed

    private void txtNombreServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreServicioActionPerformed
        txtNombreServicio.transferFocus();
    }//GEN-LAST:event_txtNombreServicioActionPerformed

    private void txtTipoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoServicioActionPerformed
        txtTipoServicio.transferFocus();
    }//GEN-LAST:event_txtTipoServicioActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        txtValor.transferFocus();
    }//GEN-LAST:event_txtValorActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if (isActiveNuevo || isActiveEditar) {
            guardar();
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        if (isActiveNuevo || isActiveEditar) {
            btnGuardar.setBackground(new Color(133, 193, 233));
        }
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        if (isActiveNuevo || isActiveEditar) {
            btnGuardar.setBackground(new Color(52, 152, 219));
        }
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        if (isActiveEditar || isActiveNuevo) {
            limpiarCampos();
            inhabilitar();
            isActiveEditar = false;
            isActiveNuevo = false;
        }
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        if (isActiveNuevo || isActiveEditar) {
            btnCancelar.setBackground(new Color(133, 193, 233));
        }
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        if (isActiveNuevo || isActiveEditar) {
            btnCancelar.setBackground(new Color(52, 152, 219));
        }
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        if (isActiveEditar) {
            eliminar();
        }
    }//GEN-LAST:event_btnEliminarMouseClicked
private void eliminar() {
        if (txtIdServicio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un registro a eliminar", "Error", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro que deseas eliminar el registro", "Confirmar", 2);
            if (confirmacion == 0) {
                try {
                    fServicios funcServicio = new fServicios();
                    clsServicios dts = new clsServicios();
                    dts.setId(Integer.parseInt(txtIdServicio.getText()));
                    funcServicio.eliminar(dts);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el registro", "Éxito", JOptionPane.INFORMATION_MESSAGE, null);
                    limpiarCampos();
                    isActiveEditar = false;
                    isActiveNuevo = false;
                    inhabilitar();
                    cargarTabla("", "Codigo", "Codigo", "desc");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, " Ha ocurrido un error al eliminar el registro", "Error", JOptionPane.INFORMATION_MESSAGE, null);

                }
            }
        }
    }
    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        if (isActiveEditar) {
            btnEliminar.setBackground(new Color(133, 193, 233));
        }
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        if (isActiveEditar) {
            btnEliminar.setBackground(new Color(52, 152, 219));
        }
    }//GEN-LAST:event_btnEliminarMouseExited

    private void txtDescripcionServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionServicioActionPerformed
        txtDescripcionServicio.transferFocus();
    }//GEN-LAST:event_txtDescripcionServicioActionPerformed

    private void txtEstadoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoServicioActionPerformed

    }//GEN-LAST:event_txtEstadoServicioActionPerformed

    private void txtFechaServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaServicioActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtValorServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorServicioActionPerformed

    private void btnGuardar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1MouseClicked

    private void btnGuardar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1MouseEntered

    private void btnGuardar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1MouseExited

    private void btnCancelar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelar1MouseClicked

    private void btnCancelar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelar1MouseEntered

    private void btnCancelar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelar1MouseExited

    private void btnEliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar1MouseClicked

    private void btnEliminar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar1MouseEntered

    private void btnEliminar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar1MouseExited

    private void txtLecturaActual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLecturaActual1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLecturaActual1ActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnReporte1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporte1MouseClicked
        this.dispose();
    }//GEN-LAST:event_btnReporte1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmServicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnCancelar1;
    private javax.swing.JLabel btnEditar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnEliminar1;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnGuardar1;
    private javax.swing.JLabel btnReporte;
    private javax.swing.JLabel btnReporte1;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblEstadoInventario;
    private javax.swing.JLabel lblFechaInventario;
    private javax.swing.JLabel lblNombreInventario;
    private javax.swing.JLabel lblNombreInventario1;
    private javax.swing.JLabel lblNombreInventario2;
    private javax.swing.JPanel paneFormulario;
    private javax.swing.JPanel paneFormulario1;
    private javax.swing.JTable tblImplementos;
    private javax.swing.JTable tblServicios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescripcionServicio;
    private javax.swing.JTextField txtEstadoServicio;
    private javax.swing.JTextField txtFechaServicio;
    private javax.swing.JTextField txtFechaServicios;
    private javax.swing.JTextField txtFkParametros;
    public javax.swing.JTextField txtFkPlanilla;
    private javax.swing.JTextField txtId1;
    private javax.swing.JTextField txtIdServicio;
    private javax.swing.JTextField txtLecturaActual1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreServicio;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTipoServicio;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValorServicio;
    // End of variables declaration//GEN-END:variables
}
