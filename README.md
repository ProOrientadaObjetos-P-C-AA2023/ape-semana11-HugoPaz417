# taller10

## Problemática 1

En un juego de rol, se desea implementar un sistema de combate en el que participen diferentes tipos de personajes: guerreros, magos y arqueros. Cada personaje tiene atributos y habilidades únicas, así como diferentes métodos de ataque y defensa.

El objetivo del juego es enfrentar a los personajes en batallas y determinar el ganador en función de sus habilidades, estrategias y atributos. Los guerreros se destacan por su fuerza y habilidades cuerpo a cuerpo, los magos por sus hechizos y poderes mágicos, y los arqueros por su precisión y habilidades a distancia.

El sistema debe permitir crear nuevos personajes de cada tipo, asignarles atributos iniciales, como puntos de vida y nivel de experiencia, y permitirles subir de nivel a medida que ganan batallas. Además, se debe implementar un algoritmo de combate que evalúe las habilidades de cada personaje y determine el resultado de la batalla.

Utilizando programación orientada a objetos, herencia y polimorfismo, implementa el sistema de combate y las clases necesarias para representar a los diferentes tipos de personajes. Asegúrate de que cada tipo de personaje tenga sus propias habilidades y métodos de ataque y defensa, y que puedan interactuar entre sí en las batallas.

Para solucionar lo anterior se debe generar lo siguiente:

* Un diagrama exclusivo que involucren las funcionalidades principales del juego.
* Una solución en lenguaje de programación Java a través del IDE Netbeans. Usar Polimorfismo en la solución.
* Clase de prueba/ejecutor, que demuestre la funcionalidad del juego. 

## Problemática 2

En un restaurant se tiene diferentes tipos de menú para ofrecer a los clientes. Un cuenta por pagar está compuesta por características como: nombre del cliente, listado de todos las cartas(menú) solicitados por el cliente, valor a cancelar total,  subtotal, Iva.

Los tipos de menú del restaurant son:

**Menú a la Carta**

- nombre del plato
- valor del menú
* valor inicial del menú
* valor de porción de guarnición
* valor de bebida
* porcentaje adicional por servicio en relación del valor inicial del menú

**Menú del Día**

* nombre del plato
* valor del menú
* valor inicial del menú
* valor de postre
* valor de bebida


**Menú de Niños**

* nombre del plato
* valor del menú
* valor inicial del menú
* valor de porción de helado
* valor de porción de pastel

**Menú Económico**

* nombre del plato
* valor del menú
* valor inicial del menú
* porcentaje de descuento, en referencia al valor inicial del menú


Para solucionar lo anterior se debe generar lo siguiente:

* Un diagrama exclusivo que involucren las clases de tipo Menú (usar polimorfismo)
* Una solución en lenguaje de programación Java a través del IDE Netbeans. Usar Polimorfismo en la solución.
	* También debe existir en la solución un clase llamada Ejecutor001.java, donde conste el método main (**usar clase Ejecutor001**).
		* En dicho método se debe crear lo siguiente:
			*	Dos objetos de tipo menú de niños
			*	Un objeto de tipo menú de económico
			* Un objeto de tipo menú del día
			* Un objeto de tipo menú a la carta.
			*	Un objeto de tipo Cuenta (con datos iniciales como: nombre del cliente, IVA, listado de cartas -menú-, valor a cancelar total
			* Hacer uso del método toString para presentar toda la información posible del objeto Cuenta (nombre del cliente, subtotal, iva, listado de todos los menú, valor a cancelar a total.
	* Solucionar lo indicado en Ejecutor002.java
