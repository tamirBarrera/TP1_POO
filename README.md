# Clases Abstractas: Cuenta y Cliente y Pilares de POO

Este documento explica el rol y diseño de las clases abstractas `Cuenta` y `Cliente`, así como la aplicación práctica de los cuatro pilares de la Programación Orientada a Objetos (POO): abstracción, encapsulamiento, herencia y polimorfismo.

## Abstracción

La abstracción consiste en identificar las características esenciales y comportamientos comunes de una entidad del mundo real o del dominio del problema, descartando los detalles específicos o irrelevantes para ese nivel de diseño.

En el sistema, se modelan dos conceptos base abstractos:
- `Cliente`: representa a cualquier cliente del banco capturando lo esencial e invariable (como `numeroCliente`), sin entrar en detalles de si se trata de una persona física o una persona jurídica.
- `Cuenta`: modela el concepto general de una cuenta bancaria con su identificador (`numeroCuenta`), el titular asociado (`clienteAsociado`) y el estado financiero (`saldoPesos`), además de definir que toda cuenta debe operar mediante depósitos y extracciones sin imponer cómo lo hace cada tipo específico.

## Clases Abstractas en el Sistema

Una clase abstracta es una clase que no se puede instanciar directamente con `new`. Su objetivo es actuar como una plantilla o molde base para que otras clases deriven de ella, compartiendo estructura y forzando la implementación de ciertos métodos.

En `Cuenta`, se declaran métodos abstractos como `depositarEfectivo(double monto)` y `extraerEfectivo(double monto)`. Esto garantiza que toda cuenta hija (por ejemplo, caja de ahorro o cuenta corriente) esté obligada a definir sus propias reglas de negocio para operar saldo y comisiones.

En `Cliente`, la clase abstracta define el identificador base del cliente y permite que las clases hijas extiendan datos particulares (como DNI, CUIT, razón social o nombres) según corresponda.

## Encapsulamiento

El encapsulamiento es el mecanismo que oculta los detalles internos de un objeto y protege su estado de accesos o modificaciones no autorizadas desde el exterior, exponiendo únicamente interfaces seguras mediante métodos controlados.

En `Cuenta` y `Cliente` se aplica a través de modificadores de acceso:
- `private`: campos como `numeroCliente` y `numeroCuenta` son privados e inmutables (`final`), evitando que sean alterados fuera del constructor.
- `protected`: atributos como `saldoPesos` en `Cuenta` restringen el acceso directo al exterior pero permiten que las subclases operen y validen el saldo según su lógica interna.
- Getters y Setters: permiten la lectura y actualización controlada de los atributos respetando las reglas de negocio.

## Herencia

La herencia es el mecanismo por el cual una clase (subclase o clase hija) adquiere atributos y métodos de otra clase (superclase o clase padre), facilitando la reutilización de código y estableciendo una relación semántica de tipo "es un".

En este modelo:
- Las variantes específicas de cuentas (como `CuentaCorriente` o `CuentaConvertibilidad`) heredan de `Cuenta`. Heredan la gestión del titular, el número de cuenta y el saldo base, evitando duplicación de código.
- Las variantes de clientes heredan de `Cliente`, compartiendo la identificación numérica base provista por la clase padre.

## Polimorfismo

El polimorfismo es la capacidad que tienen objetos de diferentes clases de responder a un mismo mensaje o llamada a método, comportándose cada uno de acuerdo a su propia implementación.

En este diseño se observa en dos aspectos clave:
- Referencia polimórfica: `Cuenta` tiene un atributo de tipo `Cliente` (`clienteAsociado`). Esto permite que cualquier objeto cuya clase herede de `Cliente` pueda asociarse a una cuenta sin necesidad de acoplar la cuenta a un tipo de cliente específico.
- Sobrescritura de métodos: al llamar a `depositarEfectivo` o `extraerEfectivo` sobre una referencia de tipo `Cuenta`, se ejecuta dinámicamente el comportamiento de la subclase concreta instanciada, adaptándose a las reglas particulares de cada tipo de cuenta.
