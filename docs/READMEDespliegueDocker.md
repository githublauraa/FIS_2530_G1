# Bioprint Backend - Despliegue con Docker y GitHub Actions

## 📦 Requisitos previos
- Docker y Docker Compose instalados.  
- Java 17 (solo necesario para desarrollo local).  
- Cuenta de GitHub con acceso a GitHub Actions.  
- Acceso a la base de datos PostgreSQL alojada en **Railway**.

---

## 🚀 Construcción y despliegue local

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/<tu-usuario>/<tu-repositorio>.git
   cd <tu-repositorio>/scripts/backend
   ```

2. Construir la imagen Docker:
   ```bash
   docker build -t bioprint-backend .
   ```

3. (Opcional) Crear y levantar los contenedores con Docker Compose:
   ```bash
   docker-compose up --build
   ```

4. Verificar que la imagen fue creada correctamente:
   ```bash
   docker images
   ```

5. (Solo si se desea ejecutar el contenedor localmente)
   ```bash
   docker run --rm bioprint-backend
   ```

> **Nota:**  
> La aplicación se conecta automáticamente a la base de datos de Railway configurada en el archivo `application.properties`.  
> No es necesario tener PostgreSQL en local.

---

## ⚙️ Flujo automatizado (CI/CD con GitHub Actions)

El archivo `.github/workflows/build.yml` define un **pipeline de integración continua** que automatiza la construcción del backend.

### Etapas del flujo:
1. **Checkout del repositorio:** Descarga el código fuente del proyecto.  
2. **Configuración de Java 17:** Prepara el entorno de compilación.  
3. **Compilación con Maven:** Ejecuta `mvn clean package -DskipTests` para construir el artefacto.  
4. **Configuración de Docker Buildx:** Habilita la construcción de imágenes multiplataforma.  
5. **Construcción de imagen Docker:** Ejecuta `docker build` para generar la imagen `bioprint-backend`.  
6. **Verificación de la imagen:** Se valida que el contenedor puede ser creado correctamente (sin ejecutarlo de forma prolongada).  

Este proceso garantiza que la imagen Docker se genera de manera **consistente, documentada y reproducible** en cualquier entorno compatible.

---

## 🧩 Archivos principales del proyecto

| Archivo | Descripción |
|----------|--------------|
| `Dockerfile` | Define los pasos para construir la imagen del backend. |
| `docker-compose.yml` | Orquesta los servicios Docker (aplicación y base de datos si se usa localmente). |
| `.github/workflows/build.yml` | Define el pipeline automatizado de GitHub Actions. |
| `application.properties` | Contiene la configuración de conexión a la base de datos en Railway. |

---

## 🧠 Configuración reproducible

Cualquier usuario puede replicar el entorno siguiendo estos pasos:
1. Clonar el repositorio.  
2. Ejecutar los comandos de construcción del contenedor (`docker build`).  
3. Verificar la ejecución del pipeline en GitHub Actions.  

Esto asegura una configuración **documentada, reproducible y portable**, cumpliendo los criterios de despliegue automatizado mediante contenedores.

---
