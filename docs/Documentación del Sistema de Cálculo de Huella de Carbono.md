**Documentación del Sistema de Cálculo de Huella de Carbono**\
\
Autores:

-   Laura Valentina Ladino Rivera

-   Sebastián Alejandro Gaibor González

-   Richard Arley Navas Peñaranda

-   Dana Lizeth Trujillo

Lenguaje: Java

Paquete: huellaCarbono

1.  Descripción general del sistema

El sistema implementa una calculadora de huella de carbono que estima la
cantidad de CO₂ emitida por una persona o grupo familiar en función de
su consumo energético, tipo de transporte y alimentación.

La aplicación fue diseñada utilizando patrones de diseño orientados a
objetos para garantizar modularidad, extensibilidad y mantenibilidad.

El usuario interactúa mediante un formulario por consola, donde ingresa
sus datos. El sistema procesa esta información y genera el cálculo total
junto con una equivalencia ambiental (plantar árboles) y una
notificación en tiempo real.

2.  Patrones de diseño utilizados

  -----------------------------------------------------------------------
  Patrón                  Propósito               Clases relacionadas
  ----------------------- ----------------------- -----------------------
  Composite               Permitir agrupar        FuenteHuella,
                          múltiples fuentes de    GrupoFuentes
                          huella (energía,        
                          transporte,             
                          alimentación) y         
                          tratarlas como una      
                          sola.                   

  Factory Method          Centralizar la creación FuenteHuellaFactory
                          de las distintas        
                          fuentes de huella.      

  Strategy                Permitir distintos      EstrategiaTransporte,
                          métodos de cálculo para EstrategiaCarro,
                          los medios de           EstrategiaBus,
                          transporte.             EstrategiaBici,
                                                  Transporte

  Singleton               Asegurar que exista una CalculadoraHuella
                          única instancia del     
                          cálculo global.         

  Adapter                 Convertir el resultado  Equivalencia,
                          del cálculo en          ArbolesAdapter
                          equivalencias           
                          ambientales (árboles).  

  Observer                Notificar               Sujeto, Observador,
                          automáticamente cuando  ConsolaObservador
                          se obtiene un nuevo     
                          cálculo.                
  -----------------------------------------------------------------------


3.  Descripción de clases

    1.  Interfaz base: FuenteHuella

-   Rol: Define el comportamiento común que todas las fuentes de huella
    deben implementar.

-   Método principal: calcular CO₂ (): Retorna el total de CO₂ generado
    por una fuente especifica.

    2.  Composite: GrupoFuentes

-   Propósito: Permite agrupar múltiples instancias de FuenteHuella
    (energía, transporte, alimentación) y tratarlas somo una sola
    entidad.

-   Ventaja: Facilita el cálculo total de CO₂ sin conocer los detalles
    internos de cada fuente.

    3.  Factory: FuenteHuellaFactory\
-   Propósito: Crea las distintas fuentes de huella según el tipo.

	-   Alimentación: Según dieta y frecuencia.

	-   Energía: Según consumo de luz, gas y agua.

	-   Transporte: instancia directamente una clase de transporte.

-   Ventaja: Centraliza la creación de objetos, simplificando el código
    del formulario.

    4.  Strategy: Transporte y sus estrategias
> Estrategias concretas:

-   EstrategiaCarro: km \* 0.21

-   EstrategiaBus: km \* 0.1

-   EstrategiaBici: 0


-   Propósito: Permite cambiar dinámicamente la forma de calcular la
    huella de transporte según el medio elegido.

-   Ventaja: Abierto a extensión.

    5.  Singleton: CalculadoraHuella

-   Propósito: Garantiza que solo exista una instancia del cálculo
    general.

-   Ventaja: Control centralizado del proceso de cálculo.

    6.  Adapter: Equivalencia y ArbolesAdapter

-   Propósito: Convierte los resultados de CO₂ en una unidad amigable
    (número de árboles).

-   Ventaja: Permite crear otros adaptadores en el futuro (por ejemplo,
    litros de gasolina, km recorridos, etc.).

    7.  Observer: Sujeto, Observador, ConsolaObservador

-   Propósito: Implementa un sistema de notificaciones que informa
    cuando se ha calculado una nueva huella.

-   Ventaja: Facilita la extensión con observadores adicionales (correo,
    base de datos, interfaz gráfica, etc.).

    8.  Main

> Función: Interactúa con el usuario, recopila los datos y utiliza los
> patrones anteriores para generar el resultado final.

-   Proceso general:

    -   Solicita datos de energía, transporte y alimentación.

    -   Usa FuenteHuellaFactory para crear las fuentes.

    -   Las agrega a un GrupoFuentes.

    -   Calcula el total con CalculadoraHuella.

    -   Convierte el resultado con ArbolesAdapter.

    -   Notifica con ConsolaObservador.

4.  Conclusiones

-   El sistema integra 6 **patrones de diseño clásicos**, demostrando un
    diseño flexible y escalable.

-   Puede ampliarse fácilmente agregando nuevas fuentes o estrategias
    sin alterar el código existente.

-   Su arquitectura permite evolucionar hacia una versión con interfaz
    gráfica o conexión a base de datos.
