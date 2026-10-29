# Karate Jenkins QA2

Proyecto de ejemplo para practicar pruebas de API con Karate, Maven y Jenkins desde macOS (Java 21).

## Ejecutar localmente

```sh
java -version
mvn -version
mvn clean test
```

Reporte local: `target/karate-reports/karate-summary.html`.

## Configuración de Jenkins

1. Plugins necesarios: Pipeline, Git, JUnit, HTML Publisher.
2. Nueva tarea > Pipeline.
3. Definition: Pipeline script from SCM; SCM: Git.
4. Repository URL: dirección de ESTE repositorio tras subirlo a GitHub.
5. Branch Specifier: `*/main`.
6. Script Path: `Jenkinsfile`.
7. Guardar y ejecutar.

El `Jenkinsfile` requiere Java y Maven accesibles en el PATH del proceso de Jenkins.

Nota: Las pruebas llaman a una API pública y requieren acceso a internet. Los resultados dependen de la disponibilidad de ese servicio.
