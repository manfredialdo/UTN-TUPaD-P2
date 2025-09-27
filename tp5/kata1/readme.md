    <h1>Ejercicio 1: Pasaporte - Foto - Titular</h1>
    <p>Este ejercicio modela dos relaciones 1 a 1 para la clase <strong>Pasaporte</strong>: una relación fuerte de composición con <strong>Foto</strong> y una asociación bidireccional con <strong>Titular</strong>.</p>

    <hr>

    <h2>1. Relaciones Definidas</h2>

    <table border="1" style="width:100%; text-align:center;">
        <thead>
            <tr>
                <th>Relación</th>
                <th>Clases</th>
                <th>Tipo</th>
                <th>Dirección</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>a</td>
                <td>Pasaporte &rarr; Foto</td>
                <td><strong>Composición</strong></td>
                <td>Unidireccional</td>
            </tr>
            <tr>
                <td>b</td>
                <td>Pasaporte &harr; Titular</td>
                <td><strong>Asociación</strong></td>
                <td>Bidireccional</td>
            </tr>
        </tbody>
    </table>

    <hr>

    <h2>2. Implementación en Java (Conceptos)</h2>
    
    <ul>
        <li>
            <strong>Composición (Pasaporte &rarr; Foto):</strong> 
            El objeto <strong>Foto</strong> (la parte) se crea junto con el <strong>Pasaporte</strong> (el todo) en el constructor y solo se referencia desde Pasaporte. Esto refleja que la vida de la Foto depende del Pasaporte.
        </li>
        <li>
            <strong>Asociación Bidireccional (Pasaporte &harr; Titular):</strong> 
            Ambas clases tienen un atributo de la otra (Pasaporte tiene un Titular y Titular tiene un Pasaporte), lo que permite la navegación en ambos sentidos.
        </li>
    </ul>
