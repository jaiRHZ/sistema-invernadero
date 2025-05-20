// Configuración de la API
const API_BASE_URL = '/api/sensor';

// Elementos DOM
const tabs = document.querySelectorAll('.tab');
const tabContents = document.querySelectorAll('.tab-content');
const notificationEl = document.getElementById('notification');
const sensorsTableBody = document.getElementById('sensors-table-body');
const sensorsLoading = document.getElementById('sensors-loading');
const sensorsTableContainer = document.getElementById('sensors-table-container');
const noSensors = document.getElementById('no-sensors');
const refreshButton = document.getElementById('refresh-sensors');
const sensorForm = document.getElementById('sensor-form');

// Cambio de pestañas
tabs.forEach(tab => {
    tab.addEventListener('click', () => {
        const tabId = tab.getAttribute('data-tab');
        
        // Activar pestaña
        tabs.forEach(t => t.classList.remove('active'));
        tab.classList.add('active');
        
        // Mostrar contenido de pestaña
        tabContents.forEach(content => {
            content.classList.remove('active');
            if (content.id === tabId) {
                content.classList.add('active');
            }
        });
        
        // Cargar datos si es la pestaña de lista de sensores
        if (tabId === 'sensors-list') {
            loadSensors();
        }
    });
});

// Mostrar notificación
function showNotification(message, type = 'success') {
    notificationEl.className = `alert alert-${type}`;
    notificationEl.textContent = message;
    notificationEl.style.display = 'block';
    
    // Ocultar después de 5 segundos
    setTimeout(() => {
        notificationEl.style.display = 'none';
    }, 5000);
}

// Cargar lista de sensores
function loadSensors() {
    sensorsLoading.style.display = 'block';
    sensorsTableContainer.style.display = 'none';
    noSensors.style.display = 'none';
    
    fetch(API_BASE_URL + '/')
        .then(response => response.json())
        .then(data => {
            sensorsLoading.style.display = 'none';
            
            if (data.status === 'success' && data.data && data.data.length > 0) {
                renderSensorsTable(data.data);
                sensorsTableContainer.style.display = 'block';
            } else {
                noSensors.style.display = 'block';
            }
        })
        .catch(error => {
            sensorsLoading.style.display = 'none';
            showNotification('Error al cargar los sensores: ' + error.message, 'danger');
        });
}

// Renderizar tabla de sensores
function renderSensorsTable(sensors) {
    sensorsTableBody.innerHTML = '';
    
    sensors.forEach(sensor => {
        const row = document.createElement('tr');
        
        // Fecha formateada
        const lastReading = sensor.lastReading ? new Date(sensor.lastReading).toLocaleString() : 'N/A';
        
        row.innerHTML = `
            <td>${sensor.id || '-'}</td>
            <td>${sensor.name || '-'}</td>
            <td>${formatSensorType(sensor.type) || '-'}</td>
            <td>${sensor.location || '-'}</td>
            <td>${lastReading}</td>
            <td><span class="${sensor.active ? 'status-active' : 'status-inactive'}">${sensor.active ? 'Activo' : 'Inactivo'}</span></td>
        `;
        
        sensorsTableBody.appendChild(row);
    });
}

// Formatear tipo de sensor
function formatSensorType(type) {
    if (!type) return '-';
    
    const types = {
        'TEMPERATURE': 'Temperatura',
        'HUMIDITY': 'Humedad',
        'PRESSURE': 'Presión',
        'LIGHT': 'Luz',
        'MOTION': 'Movimiento',
        'OTHER': 'Otro'
    };
    
    return types[type] || type;
}

// Evento de envío del formulario
sensorForm.addEventListener('submit', function(e) {
    e.preventDefault();
    
    const formData = {
        name: document.getElementById('name').value,
        type: document.getElementById('type').value,
        location: document.getElementById('location').value,
        description: document.getElementById('description').value,
        readingInterval: parseInt(document.getElementById('interval').value),
        active: true
    };
    
    // Enviar datos al servidor
    fetch(API_BASE_URL + '/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        if (data.status === 'success') {
            showNotification('Sensor registrado correctamente');
            sensorForm.reset();
            
            // Cambiar a la pestaña de lista y actualizar
            document.querySelector('[data-tab="sensors-list"]').click();
        } else {
            showNotification('Error al registrar el sensor: ' + (data.message || 'Error desconocido'), 'danger');
        }
    })
    .catch(error => {
        showNotification('Error al registrar el sensor: ' + error.message, 'danger');
    });
});

// Evento de botón refrescar
refreshButton.addEventListener('click', loadSensors);

// Cargar sensores al iniciar
loadSensors();