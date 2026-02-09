📘 Repositorio de apoyo para la Guía Práctica de Jenkins
Trabajo Recepcional – Licenciatura en Ingeniería de Software (UV)

📌 Propósito del repositorio

Este repositorio ha sido creado exclusivamente con fines académicos como material de apoyo para la Guía Práctica de Jenkins para el despliegue automatizado de software, desarrollada como parte del trabajo recepcional de la Licenciatura en Ingeniería de Software de la Universidad Veracruzana.

El contenido aquí presentado tiene como objetivo acompañar el aprendizaje progresivo del uso de Jenkins y la construcción de pipelines de CI/CD, en concordancia con los contenidos abordados en la Guía.
⚠️ Este repositorio no está destinado para uso productivo ni comercial.

🧭 Estructura general del repositorio

El repositorio está organizado en ramas independientes, cada una correspondiente a una etapa específica del pipeline de despliegue automatizado. Esta organización permite seguir un enfoque incremental, alineado con la progresión didáctica de la Guía.

🔹 Rama main

Contiene únicamente este archivo README.

Su propósito es documental e informativo.

No incluye código ni configuraciones de Jenkins.

🔹 Rama pipeline-base

Rama inicial del repositorio.

Contiene un Jenkinsfile base.

Incluye las instrucciones necesarias para crear un pipeline desde cero.

Diseñada para comprender la estructura mínima de un pipeline declarativo en Jenkins.

📍 Punto de partida recomendado para el lector de la Guía.

🔹 Rama checkout-scm-pipeline

Segunda etapa del proceso.

Contiene las instrucciones para realizar únicamente el checkout del código fuente desde el SCM.

En este punto se asume que el proyecto ya se encuentra alojado en un repositorio.

El Jenkinsfile se enfoca en la integración con el control de versiones.

🔹 Rama mvn-build-pipeline

Introduce la etapa de construcción (build) del proyecto.

Incluye instrucciones para compilar el código fuente utilizando Apache Maven.

Se asume un proyecto backend desarrollado en Java.

Permite validar que el proyecto puede construirse correctamente de forma automatizada.

🔹 Rama test-pipeline

Incorpora la etapa de pruebas automatizadas.

Contiene instrucciones para ejecutar:

Pruebas unitarias con JUnit

Pruebas de API con Newman

En esta rama se agregan los archivos de prueba correspondientes.

Permite verificar la calidad del software antes del despliegue.

🔹 Rama deployment-pipeline

Etapa final del pipeline.

Contiene las instrucciones para el despliegue automatizado de la aplicación.

Utiliza:

Docker

Docker Compose

Incluye los archivos necesarios para la construcción de imágenes y despliegue de contenedores.

Representa la integración completa del pipeline de CI/CD.

🎓 Uso académico

El uso de este repositorio es libre y gratuito para fines educativos y académicos, tales como:

Apoyo al aprendizaje de Jenkins

Prácticas de integración y despliegue continuos

Material de referencia para cursos relacionados con DevOps y despliegue de software

⚖️ Derechos de autor y restricciones

Queda estrictamente prohibida la distribución o explotación con fines comerciales de este repositorio o de cualquiera de sus contenidos.

Todos los derechos de creación y autoría pertenecen a:

Tristán Eduardo Suárez Santiago

Ángel de Jesús de la Cruz García

Este trabajo se encuentra desarrollado bajo la protección académica de la Universidad Veracruzana.

📚 Referencia académica

Este repositorio forma parte del material complementario del trabajo recepcional:

Guía Práctica de Jenkins para el despliegue automatizado de software
Licenciatura en Ingeniería de Software
Universidad Veracruzana
