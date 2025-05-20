import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;

// Clase para el DTO Sensor (coincide con SensorDto)
class SensorDto {
    public int id;
    public String nombre;
    public double valor;

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ") - Valor: " + valor;
    }
}

// Clase para el formato de respuesta (asumiendo estructura)
class ResponseFormat<T> {
    public String status;
    public String message;
    public T data;
}

public class SensorClientSwing extends JFrame {

    private final DefaultListModel<SensorDto> sensorListModel = new DefaultListModel<>();
    private final JList<SensorDto> sensorList = new JList<>(sensorListModel);

    private final JTextField idField = new JTextField(5);
    private final JTextField nombreField = new JTextField(15);
    private final JTextField valorField = new JTextField(7);

    private final JButton refreshButton = new JButton("Refrescar");
    private final JButton createButton = new JButton("Crear Sensor");

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String baseUrl = "http://localhost:8080/api/sensor";

    public SensorClientSwing() {
        super("Cliente Sensores");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout(10,10));

        // Panel de lista
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder("Sensores"));
        listPanel.add(new JScrollPane(sensorList), BorderLayout.CENTER);
        listPanel.add(refreshButton, BorderLayout.SOUTH);
        add(listPanel, BorderLayout.CENTER);

        // Panel de formulario
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Crear Nuevo Sensor"));
        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nombreField);
        formPanel.add(new JLabel("Valor:"));
        formPanel.add(valorField);
        formPanel.add(createButton);
        add(formPanel, BorderLayout.NORTH);

        // Acciones
        refreshButton.addActionListener(e -> fetchSensors());
        createButton.addActionListener(e -> createSensor());

        // Carga inicial
        fetchSensors();
    }

    private void fetchSensors() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(baseUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

            // Parsear JSON genérico (ResponseFormat con lista de sensores)
            JavaType type = objectMapper.getTypeFactory()
                    .constructParametricType(ResponseFormat.class,
                            objectMapper.getTypeFactory().constructCollectionType(List.class, SensorDto.class));

            ResponseFormat<List<SensorDto>> responseFormat = objectMapper.readValue(response.body(), type);

            SwingUtilities.invokeLater(() -> {
                sensorListModel.clear();
                if (responseFormat.data != null) {
                    for (SensorDto sensor : responseFormat.data) {
                        sensorListModel.addElement(sensor);
                    }
                }
            });

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener sensores:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createSensor() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String nombre = nombreField.getText().trim();
            double valor = Double.parseDouble(valorField.getText().trim());

            SensorDto newSensor = new SensorDto();
            newSensor.id = id;
            newSensor.nombre = nombre;
            newSensor.valor = valor;

            String json = objectMapper.writeValueAsString(newSensor);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(baseUrl))
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

            ResponseFormat<?> responseFormat = objectMapper.readValue(response.body(), ResponseFormat.class);

            JOptionPane.showMessageDialog(this, responseFormat.message,
                    "Respuesta del servidor", JOptionPane.INFORMATION_MESSAGE);

            fetchSensors();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID y Valor deben ser números válidos.",
                    "Validación", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al crear sensor:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SensorClientSwing app = new SensorClientSwing();
            app.setVisible(true);
        });
    }
}
