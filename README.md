# TP2-Progra3


Programación III - Universidad Nacional de General Sarmiento Trabajo Práctico 2: Rápido y furioso.
El objetivo del trabajo práctico es implementar una aplicación para planificar viajes en auto por las rutas del país,
con el objetivo de minimizar las distancias de viaje pero con un límite de peajes a atravesar. 
Dados un grafo G = (V, E) con una función de distancia d : E → R+,
un conjunto de aristas P ⊆ E con peaje,
dos vértices s y t,
y un máximo p de peajes a atravesar, el objetivo del problema es encontrar el camino más corto entre s y t que atraviesa a lo sumo p peajes. No es aceptable un camino que atraviese más de p peajes, aunque sea mucho más corto. Para esto, la aplicación debe incluir la siguiente funcionalidad:
Agregar un vértice/ciudad al mapa/grafo, especificando su nombre, latitud y longitud. Cuando se agrega una ciudad al mapa, la aplicación le asigna un identificador correlativo, comenzando desde 0.
Agregar una ruta/arista al mapa/grafo, especificando el identificador de las dos ciudades, la longitud de la ruta/arista y si tiene un peaje.
Calcular la ruta más corta entre dos ciudades dadas por su identificador (o bien por su nombre, a elección del grupo), con a lo sumo p peajes. El usuario debe proporcionar las ciudades de origen y destino, y la cantidad máxima de peajes a atravesar. Para resolver este último punto se debe implementar algún algoritmo de camino mínimo, sobre un grafo construido a partir de los datos registrados en la aplicación. Como objetivos opcionales no obligatorios, se pueden contemplar los siguientes elementos:
Guardar en archivos los datos del mapa, de modo tal que se preserven entre una ejecución de la aplicación y la siguiente.
Mostrar el grafo en pantalla, como un grafo o bien sobre un mapa. Cuando se busca la ruta más corta entre dos ciudades, mostrar la ruta sobre el grafo en la pantalla.
Guardar el historial de búsquedas realizadas, y dar una interfaz para consultar el historial de búsquedas. Condiciones de entrega: El trabajo práctico se debe entregar por mail a los docentes de la materia. Además del código, se debe incluir un documento en el que se describa la implementación y se detallen las decisiones tomadas durante el desarrollo. Todas las clases de negocio deben tener tests unitarios. El trabajo práctico se puede hacer en grupos de hasta tres personas. Fecha de entrega: Martes 16 de mayo
