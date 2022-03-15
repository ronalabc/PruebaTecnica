package interfacemercadona;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Formulario extends JFrame implements ActionListener {

    // Atributos
    // Labels
    JLabel idT;
    JLabel logoT;
    JLabel nombreT;
    JLabel precioT;
    JLabel seccionT;
    JLabel listadoT;
    JLabel mensajeT;
    JLabel mensajeT2;
    JLabel mensajeT3;

    // JTextField 
    JTextField idTF;
    JTextField nombreTF;
    JTextField precioTF;
    JTextField seccionTF;

    // Tabla listado
    JTable miTabla;
    JScrollPane scrollTable;

    // Tabla vacia inicial
    JTable miTablaInicio;
    JScrollPane scrollTableInicio;

    // Botones
    JButton addB;
    JButton consultarB;
    JButton listarB;
    JButton actualizarB;
    JButton eliminarB;
    JButton salirB;
    JButton limpiarB;

    // Panel
    JPanel miCapa;

    // Conexión a la API
    URL url;
    HttpURLConnection conexion;

    public Formulario() throws MalformedURLException, IOException {

        this.setTitle("Gestion Productos");
        this.setSize(760, 420);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear y Inicializar capa
        miCapa = new JPanel();
        // Indicamos que la posición y tamaño de los controles será por
        // coordenadas X e Y, ancho y alto.
        miCapa.setLayout(null);
        miCapa.setBackground(new Color(0, 0, 0));

        // Posicionamos los JLabel
        logoT = new JLabel();
        logoT.setBounds(60, 0, 700, 150);
        logoT.setIcon(new ImageIcon(getClass().getResource("/imagenes/logo.png")));
        miCapa.add(logoT);

        idT = new JLabel("ID");
        idT.setBounds(10, 185, 100, 30);
        idT.setForeground(new Color(7, 144, 191));
        miCapa.add(idT);

        nombreT = new JLabel("Nombre");
        nombreT.setBounds(10, 215, 100, 30);
        nombreT.setForeground(new Color(7, 144, 191));
        miCapa.add(nombreT);

        precioT = new JLabel("Precio");
        precioT.setBounds(10, 245, 100, 30);
        precioT.setForeground(new Color(7, 144, 191));
        miCapa.add(precioT);

        seccionT = new JLabel("Sección");
        seccionT.setBounds(10, 275, 100, 30);
        seccionT.setForeground(new Color(7, 144, 191));
        miCapa.add(seccionT);

        listadoT = new JLabel("Listado de Productos");
        listadoT.setBounds(490, 155, 200, 30);
        listadoT.setForeground(new Color(7, 144, 191));
        miCapa.add(listadoT);

        mensajeT = new JLabel("");
        mensajeT.setBounds(90, 300, 200, 30);
        mensajeT.setForeground(new Color(255, 161, 2));
        miCapa.add(mensajeT);

        mensajeT2 = new JLabel("Ronal Alexis Baier Cifuentes - 2022");
        mensajeT2.setBounds(280, 355, 200, 30);
        mensajeT2.setForeground(new Color(255, 161, 2));
        miCapa.add(mensajeT2);

        mensajeT3 = new JLabel("Cod. Respuesta: ");
        mensajeT3.setBounds(10, 355, 200, 30);
        mensajeT3.setForeground(new Color(0, 255, 0));
        miCapa.add(mensajeT3);

        // Posicionamos los JTextField
        idTF = new JTextField();
        idTF.setBounds(80, 185, 140, 30);
        idTF.setBorder(new LineBorder(new Color(255, 161, 2)));
        miCapa.add(idTF);

        nombreTF = new JTextField();
        nombreTF.setBounds(80, 215, 140, 30);
        nombreTF.setBorder(new LineBorder(new Color(255, 161, 2)));
        miCapa.add(nombreTF);

        precioTF = new JTextField();
        precioTF.setBounds(80, 245, 140, 30);
        precioTF.setBorder(new LineBorder(new Color(255, 161, 2)));
        miCapa.add(precioTF);

        seccionTF = new JTextField();
        seccionTF.setBounds(80, 275, 140, 30);
        seccionTF.setBorder(new LineBorder(new Color(255, 161, 2)));
        miCapa.add(seccionTF);

        // Posicionar JTable vacia para listado
        // Creamos array de encabezado de campos de las tablas
        String[] cabecera = {"ID", "Nombre", "Precio", "Sección"};

        // Creamos array multidimensional que almacenará los datos de la tabla productos
        Object[][] datos = new Object[0][4];

        // Creamos JTable
        miTablaInicio = new JTable(datos, cabecera);

        // Creamos el Scroll para la Tabla (JScrollPane)
        scrollTableInicio = new JScrollPane(miTablaInicio);
        // Posicionamos el ScrollPane
        scrollTableInicio.setBounds(350, 185, 400, 170);
        scrollTableInicio.setBorder(new LineBorder(new Color(255, 161, 2)));
        // Volcamos el Scrollpane
        miCapa.add(scrollTableInicio);

        // Posicionamos los botones
        addB = new JButton("Añadir");
        addB.setBounds(120, 325, 100, 30);
        addB.setForeground(Color.white);
        addB.setBackground(new Color(1, 120, 58));
        addB.setBorder(new LineBorder(new Color(255, 161, 2)));
        miCapa.add(addB);

        listarB = new JButton("Listar");
        listarB.setBounds(240, 185, 100, 30);
        listarB.setForeground(Color.white);
        listarB.setBackground(new Color(1, 120, 58));
        listarB.setBorder(new LineBorder(new Color(255, 161, 2)));
        miCapa.add(listarB);

        consultarB = new JButton("Consultar");
        consultarB.setBounds(240, 215, 100, 30);
        consultarB.setForeground(Color.white);
        consultarB.setBackground(new Color(1, 120, 58));
        consultarB.setBorder(new LineBorder(new Color(255, 161, 2)));
        miCapa.add(consultarB);

        actualizarB = new JButton("Actualizar");
        actualizarB.setBounds(240, 245, 100, 30);
        actualizarB.setForeground(Color.white);
        actualizarB.setBackground(new Color(1, 120, 58));
        actualizarB.setBorder(new LineBorder(new Color(255, 161, 2)));
        miCapa.add(actualizarB);

        eliminarB = new JButton("Eliminar");
        eliminarB.setBounds(240, 275, 100, 30);
        eliminarB.setForeground(Color.white);
        eliminarB.setBackground(new Color(1, 120, 58));
        eliminarB.setBorder(new LineBorder(new Color(255, 161, 2)));
        miCapa.add(eliminarB);

        salirB = new JButton("Salir");
        salirB.setBounds(240, 325, 100, 30);
        salirB.setForeground(Color.white);
        salirB.setBackground(new Color(231, 86, 86));
        salirB.setBorder(new LineBorder(new Color(255, 161, 2)));
        miCapa.add(salirB);

        limpiarB = new JButton("Limpiar");
        limpiarB.setBounds(10, 325, 100, 30);
        limpiarB.setForeground(Color.white);
        limpiarB.setBackground(new Color(1, 120, 58));
        limpiarB.setBorder(new LineBorder(new Color(255, 161, 2)));
        miCapa.add(limpiarB);

        // Ponemos botones a la escucha
        addB.addActionListener(this);
        consultarB.addActionListener(this);
        listarB.addActionListener(this);
        actualizarB.addActionListener(this);
        eliminarB.addActionListener(this);
        salirB.addActionListener(this);
        limpiarB.addActionListener(this);

        // Volcar la capa (JPanel) en el formulario
        this.add(miCapa);

        // Creamos la Conexión a la API
        URL url = new URL("http://localhost:8080/ApiMercadona/ApiMCDN/productos/");
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setDoOutput(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salirB) {
            // Botón para salir del programa
            System.exit(0);
        }
        if (e.getSource() == addB) {
            try {
                // Creamos y abrimos la conexión
                url = new URL("http://localhost:8080/ApiMercadona/ApiMCDN/productos/");
                conexion = (HttpURLConnection) url.openConnection();

                // Establecemos el método POST , el formato json e indicamos que
                // vamos a enviar una estructura json el nuevo producto
                conexion.setDoOutput(true);
                conexion.setRequestMethod("POST");
                conexion.setRequestProperty("Content-Type", "application/json");

                // Damos valor a los campos recuperando el texto de las cajas
                int id = Integer.parseInt(idTF.getText());
                String nombre = nombreTF.getText();
                double precio = Double.parseDouble(precioTF.getText());
                String seccion = seccionTF.getText();

                // Creamos el json del producto que queremos insertar
                Producto miProducto = new Producto(id, nombre, precio, seccion);

                // Creamos instancia de Gson
                Gson miGson = new Gson();

                // Convertimos Gson a String
                String json = miGson.toJson(miProducto);

                // Creamos OutputStream para enviar el json del producto a la API
                // El envío se realiza como un array de bytes
                OutputStream os = conexion.getOutputStream();
                os.write(json.getBytes());
                os.flush();
                os.close();

                // Mostramos Código de Respuesta
                int codigoRespuesta = conexion.getResponseCode();
                if (codigoRespuesta >= 200 && codigoRespuesta <= 299) {
                    mensajeT3.setText("Cod.Respuesta: " + codigoRespuesta);
                    mensajeT3.setForeground(new Color(0, 255, 0));
                    mensajeT.setText("Producto Insertado!");
                } else {
                    mensajeT3.setText("Cod.Respuesta: " + codigoRespuesta);
                    mensajeT3.setForeground(new Color(255, 0, 0));
                    mensajeT.setText("Ha ocurrido un error");
                }

                // Cerramos OutputStream
                os.close();
                // Desconectamos de la api
                conexion.disconnect();
            } catch (MalformedURLException ex) {
                ex.getMessage();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        if (e.getSource() == listarB) {
            // Creamos otra tabla para volcar el contenido de la consulta
            String[] cabecera = {"ID", "Nombre", "Precio", "Sección"};
            Object[][] datos = new Object[1000][4];
            scrollTableInicio.setVisible(false);
            try {
                // Creamos la conexión
                url = new URL("http://localhost:8080/ApiMercadona/ApiMCDN/productos");
                conexion = (HttpURLConnection) url.openConnection();

                // Establecemos el método GET y el formato de intercambio de datos en json
                conexion.setRequestMethod("GET");
                conexion.setRequestProperty("Accept", "application/json");

                // Obtenemos el código de respuesta
                // Si el código de respuesta es mayor a 400 quiere decir que 
                // ha ocurrido algún error y se mostrará de color rojo
                // en caso contrario se mostrará de color ver al no haber ningún
                // error
                int codigoRespuesta = conexion.getResponseCode();
                if (codigoRespuesta >= 400) {
                    mensajeT3.setText("Cod.Respuesta: " + codigoRespuesta);
                    mensajeT3.setForeground(new Color(255, 0, 0));
                } else {
                    mensajeT3.setText("Cod.Respuesta: " + codigoRespuesta);
                    mensajeT3.setForeground(new Color(0, 255, 0));
                }

                // Leemos el string json linea a linea y lo guardamos en la 
                // variable listado
                InputStreamReader is = new InputStreamReader(conexion.getInputStream());
                BufferedReader br = new BufferedReader(is);

                String listado = "";
                String linea = "";
                while ((linea = br.readLine()) != null) {
                    listado += linea;
                }

                // Convertimos el string json a una Lista
                Gson gson = new Gson();
                List<Producto> listProducto = gson.fromJson(listado, new TypeToken<List<Producto>>() {
                }.getType());
                if (listProducto != null) {
                    int cont = 0;
                    for (Producto miProducto : listProducto) {
                        // Volcamos el contenido de la lista en una tabla
                        int id = miProducto.getId();
                        String nombre = miProducto.getNombre();
                        double precio = miProducto.getPrecio();
                        String seccion = miProducto.getSeccion();

                        datos[cont][0] = id;
                        datos[cont][1] = nombre;
                        datos[cont][2] = precio + "€";
                        datos[cont][3] = seccion;

                        cont++;
                    }
                    // Mostramos la tabla
                    miTabla = new JTable(datos, cabecera);
                    scrollTable = new JScrollPane(miTabla);
                    scrollTable.setBounds(350, 185, 400, 170);
                    scrollTable.setBorder(new LineBorder(new Color(255, 161, 2)));
                    miCapa.add(scrollTable);
                    mensajeT.setText("Listando Productos...");
                    limpiarCajasB();

                }
                // Cerramos buffer y conexión
                br.close();
                conexion.disconnect();
            } catch (MalformedURLException ex) {
                ex.getMessage();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        if (e.getSource() == consultarB) {
            // Creamos otra tabla para volcar el contenido de la consulta
            String[] cabecera = {"ID", "Nombre", "Precio", "Sección"};
            Object[][] datos = new Object[1000][4];
            scrollTableInicio.setVisible(false);
            try {
                // Recuperamos el ID del producto para hacer la consulta
                int idProducto = Integer.parseInt(idTF.getText());
                url = new URL("http://localhost:8080/ApiMercadona/ApiMCDN/productos/" + idProducto + "/");
                conexion = (HttpURLConnection) url.openConnection();

                // Establecemos el método GET y el formato de intercambio de datos en json
                conexion.setRequestMethod("GET");
                conexion.setRequestProperty("Accept", "application/json");

                // Obtenemos el código de respuesta
                // Si el código de respuesta es mayor a 400 quiere decir que 
                // ha ocurrido algún error y se mostrará de color rojo
                // en caso contrario se mostrará de color ver al no haber ningún
                // error
                int codigoRespuesta = conexion.getResponseCode();
                if (codigoRespuesta >= 400) {
                    mensajeT3.setText("Cod.Respuesta: " + codigoRespuesta);
                    mensajeT3.setForeground(new Color(255, 0, 0));
                } else {
                    mensajeT3.setText("Cod.Respuesta: " + codigoRespuesta);
                    mensajeT3.setForeground(new Color(0, 255, 0));
                }

                // Leemos el string json linea a linea y lo guardamos en la 
                // variable consulta
                InputStreamReader is = new InputStreamReader(conexion.getInputStream());
                BufferedReader br = new BufferedReader(is);

                String consulta = "";
                String linea = "";
                while ((linea = br.readLine()) != null) {
                    consulta += linea;
                }

                // Creamos instancia de Gson para convertir el String json a Objeto
                Gson gson = new Gson();
                Producto miProducto = gson.fromJson(consulta, Producto.class);

                if (miProducto.getNombre() != null) {

                }
                // Damos valor a los parametros recuperando los datos del 
                // objeto consultado
                int id = miProducto.getId();
                String nombre = miProducto.getNombre();
                double precio = miProducto.getPrecio();
                String seccion = miProducto.getSeccion();

                // Volcamos los datos sobre la tabla 
                datos[0][0] = id;
                datos[0][1] = nombre;
                datos[0][2] = precio + "€";
                datos[0][3] = seccion;

                // Tambíen volcamos los datos sobre los campos de texto
                // para actualizar los datos del producto con más fácilidad
                idTF.setText(Integer.toString(miProducto.getId()));
                nombreTF.setText(miProducto.getNombre());
                precioTF.setText(Double.toString(miProducto.getPrecio()));
                seccionTF.setText(miProducto.getSeccion());

                // Mostramos la tabla
                miTabla = new JTable(datos, cabecera);
                scrollTable = new JScrollPane(miTabla);
                scrollTable.setBounds(350, 185, 400, 170);
                scrollTable.setBorder(new LineBorder(new Color(255, 161, 2)));
                miCapa.add(scrollTable);
                mensajeT.setText("Consultando Producto");

                // Cerramos el buffer
                br.close();

                // Desconectamos de la URL
                conexion.disconnect();
            } catch (MalformedURLException ex) {
                ex.getMessage();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        if (e.getSource() == actualizarB) {
            try {
                int id = Integer.parseInt(idTF.getText());
                // Creamos conexion y abrimos la conexión
                url = new URL("http://localhost:8080/ApiMercadona/ApiMCDN/productos/" + id + "/");
                conexion = (HttpURLConnection) url.openConnection();

                // Establecemos el método PUT , el formato json e indicamos que
                // vamos a enviar una estructura json el nuevo producto
                conexion.setDoOutput(true);
                conexion.setRequestMethod("PUT");
                conexion.setRequestProperty("Content-Type", "application/json");

                // Damos valor a los campos
                
                String nombre = nombreTF.getText();
                double precio = Double.parseDouble(precioTF.getText());
                String seccion = seccionTF.getText();

                // Creamos el json del producto que queremos actualizar
                Producto miProducto = new Producto(id, nombre, precio, seccion);

                Gson miGson = new Gson();

                // Convertimos Gson a String
                String json = miGson.toJson(miProducto);

                // Creamos OutputStream para enviar el json del producto a la API
                // El envío se realiza como un array de bytes
                OutputStream os = conexion.getOutputStream();
                os.write(json.getBytes());
                os.flush();
                os.close();

                // Obtenemos el código de respuesta
                // Si el código de respuesta es mayor a 400 quiere decir que 
                // ha ocurrido algún error y se mostrará de color rojo
                // en caso contrario se mostrará de color ver al no haber ningún
                // error
                int codigoRespuesta = conexion.getResponseCode();
                if (codigoRespuesta >= 400) {
                    mensajeT3.setText("Cod.Respuesta: " + codigoRespuesta);
                    mensajeT3.setForeground(new Color(255, 0, 0));
                } else {
                    mensajeT3.setText("Cod.Respuesta: " + codigoRespuesta);
                    mensajeT.setText("Producto Actualizado!");
                    mensajeT3.setForeground(new Color(0, 255, 0));
                }
                // Desconectamos de la api
                conexion.disconnect();
            } catch (MalformedURLException ex) {
                ex.getMessage();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        if (e.getSource() == eliminarB) {
            try {
                int id = Integer.parseInt(idTF.getText());
                // Creamos conexion y abrimos la conexión
                url = new URL("http://localhost:8080/ApiMercadona/ApiMCDN/productos/" + id + "/");
                conexion = (HttpURLConnection) url.openConnection();

                // Establecemos el método DELETE , el formato json e indicamos que
                // vamos a enviar una estructura json el nuevo producto
                conexion.setDoOutput(true);
                conexion.setRequestMethod("DELETE");
                conexion.setRequestProperty("Content-Type", "application/json");

                // Obtenemos el código de respuesta
                // Si el código de respuesta es mayor a 400 quiere decir que 
                // ha ocurrido algún error y se mostrará de color rojo
                // en caso contrario se mostrará de color ver al no haber ningún
                // error
                int codigoRespuesta = conexion.getResponseCode();
                if (codigoRespuesta >= 400) {
                    mensajeT3.setText("Cod.Respuesta: " + codigoRespuesta);
                    mensajeT3.setForeground(new Color(255, 0, 0));
                } else {
                    mensajeT3.setText("Cod.Respuesta: " + codigoRespuesta);
                    limpiarCajas();
                    mensajeT.setText("Producto Eliminado!");
                    mensajeT3.setForeground(new Color(0, 255, 0));
                }
                // Desconectamos de la api
                conexion.disconnect();
                
            } catch (MalformedURLException ex) {
                ex.getMessage();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        if (e.getSource() == limpiarB) {
            limpiarCajas();
        }

    }

    public void limpiarCajas() {
        mensajeT.setText("");
        idTF.setText("");
        nombreTF.setText("");
        precioTF.setText("");
        seccionTF.setText("");
        scrollTableInicio.setVisible(true);
    }

    public void limpiarCajasB() {
        idTF.setText("");
        nombreTF.setText("");
        precioTF.setText("");
        seccionTF.setText("");
    }
}
