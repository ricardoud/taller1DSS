Descripción del Proyecto: Breve explicación de la aplicación y sus funcionalidades.

Esta es una aplicación academia cuyo objetivo es gestionar un inventario de productos de manera estructurada y segura, separando claramente las capas de dominio, casos de uso, adaptadores y interfaz de usuario (CLI).

🔹 Funcionalidades principales:

Agregar productos al inventario con validaciones avanzadas (formato de ID, rango de precios, caracteres permitidos en nombres, control de stock).

Actualizar productos existentes, asegurando integridad en los datos.

Eliminar productos del inventario por identificador.

Listar todos los productos registrados en el sistema.

Autenticación y autorización básica: solo los usuarios con rol ADMIN pueden agregar nuevos productos.

Manejo de errores seguro, mostrando mensajes claros al usuario sin exponer detalles internos de la implementación.



Guía de Configuración: Instrucciones claras sobre cómo clonar, configurar las dependencias (Maven/Gradle), compilar y ejecutar la aplicación desde la línea de comandos....

Clonar el repositorio (Usar PowerShell)

git clone https://github.com/ricardoud/taller1DSS.git
cd taller1DSS


Verificar dependencias

Java 17+:

java -version


Maven:

mvn -v


Compilar y empaquetar

mvn clean package


Ejecutar la aplicación

Con JAR:

java -jar target\secure-inventory-app-1.0-SNAPSHOT.jar


O con clase principal:

java -cp target\secure-inventory-app-1.0-SNAPSHOT.jar com.inventory.cli.Main


Ejecutar desde IntelliJ IDEA

Abrir el proyecto (pom.xml).

Asegurar SDK = JDK 17.

Abrir Main.java → clic derecho → Run 'Main'.

Comando útil si hay errores de dependencias

mvn clean package -U


Guía de Configuración: Instrucciones claras sobre cómo clonar, configurar las dependencias....

Iniciar la aplicación

java -cp target\secure-inventory-app-1.0-SNAPSHOT.jar com.inventory.cli.Main


Seleccionar el rol de usuario (simulación)

Al inicio, el sistema pedirá ingresar un rol:

admin → puede agregar, actualizar, eliminar y listar productos.

user → solo puede listar productos.

Demostración con rol admin

Agregar producto: ingresar ID, nombre, precio y stock.

Listar productos: verificar que se registró correctamente.

Actualizar producto: modificar atributos de un producto existente.

Eliminar producto: quitarlo del inventario.

Ver validaciones en acción (IDs vacíos, precios negativos, caracteres especiales en nombres).

Demostración con rol user

Listar productos: visualizar inventario disponible.

Intentar agregar/actualizar/eliminar → el sistema debe rechazar la acción con un mensaje de "Permiso denegado".

Mensajes de error seguros

Validaciones incorrectas generan errores claros y útiles, sin exponer detalles internos.

Acciones restringidas por rol muestran advertencias de seguridad.
