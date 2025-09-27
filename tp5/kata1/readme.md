# T.P. 5: Relaciones UML 1 a 1 (Pasaporte - Foto - Titular)

Este ejercicio modela dos relaciones **1 a 1** para la clase `Pasaporte`: una relación fuerte de Composicion con `Foto` y una Asociacion Bidireccional con `Titular`.

---

## 1. Definición de Relaciones

La siguiente tabla resume el tipo y dirección de las relaciones que deben implementarse.

| Relación | Clases | Tipo | Dirección |
| :--- | :--- | :--- | :--- |
| **a** | `Pasaporte` &rarr; `Foto` | **Composicion** | Unidireccional |
| **b** | `Pasaporte` &harr; `Titular` | **Asociacion** | Bidireccional |

### Clases y Atributos

| Clase | Atributos | Rol en la Relacion |
| :--- | :--- | :--- |
| `Pasaporte` | `numero`, `fechaEmision` | Contenedor (Todo) / Clase Central |
| `Foto` | `imagen`, `formato` | Contenida (Parte) |
| `Titular` | `nombre`, `dni` | Asociado |

---

## 2. Conceptos Clave para la Implementación en Java

La implementacion en Java debe reflejar la diferencia entre la dependencia del ciclo de vida y la bidireccionalidad.

### Composicin (`Pasaporte` &rarr; `Foto`)
* El objeto `Foto` (la parte) debe ser **creado dentro del constructor** de `Pasaporte`.
* Esto asegura que la `Foto` **no puede existir** sin una instancia de `Pasaporte`.

### Asociacin Bidireccional (`Pasaporte` &harr; `Titular`)
* La clase `Pasaporte` debe tener un atributo de tipo `Titular`.
* La clase `Titular` debe tener un atributo de tipo `Pasaporte`.
* El vínculo debe establecerse en ambas direcciones durante la creacion, asegurando que ambos objetos se conozcan mutuamente.
