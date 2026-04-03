# Taller 01 – Procrastinación Tracker

## Descripción del Proyecto
Este proyecto corresponde al **Taller 1 del curso de POO (Programación Orientada a Objetos)**.  
El objetivo es desarrollar un software en **Java estructurado (sin POO, sin colecciones, solo arreglos)** que permita a los usuarios registrar, modificar y analizar sus actividades de ocio, con el fin de medir su nivel de procrastinación.

El sistema trabaja con dos archivos de texto:
- **Usuarios.txt**: contiene los usuarios y sus contraseñas.
- **Registros.txt**: contiene las actividades registradas (usuario, fecha, horas, actividad).

El programa ofrece dos menús principales:
- **Menú de Usuarios**: login, registrar, modificar, eliminar actividades y cambiar contraseña.
- **Menú de Análisis**: estadísticas sobre las actividades más realizadas y el usuario con mayor procrastinación.

---

## Integrantes
- Kevin Zamora Riquelme – RUT: 21.578.521-1 – Usuario GitHub: kivairou 
- Tomás Zepeda Velasquez - RUT: 21.789.061-6 - Usuario GitHub: tomaszepeda2411

---

## Estructura del proyecto

```
├── src/
│   └── Main.java        # Clase principal con menús y lógica
├── Usuarios.txt         # Archivo de usuarios (ID;Contraseña)
├── Registros.txt        # Archivo de registros (ID;Fecha;Horas;Actividad)
└── README.md            # Documentación del proyecto
```

---
## Instrucciones de Ejecución
### En Visual Studio Code
1. Abre VS Code y selecciona **File > Open Folder**.  
   Elige la carpeta raíz del proyecto (donde está `src/`).
2. Instala la extensión **Java Extension Pack** si no la tienes.
3. Abre el archivo `Main.java` dentro de `src/`.
4. Haz clic en el botón **Run** que aparece arriba del método `main`.
5. El programa se ejecutará en la terminal integrada de VS Code.

### En Eclipse
1. Abre Eclipse y selecciona **File > New > Java Project**.
2. Asigna un nombre al proyecto (ejemplo: `Taller01`).
3. Copia la carpeta `src/` y los archivos `Usuarios.txt` y `Registros.txt` dentro del proyecto.
4. Asegúrate de que `Main.java` esté dentro del paquete `src`.
5. Haz clic derecho sobre `Main.java` → **Run As > Java Application**.
6. El programa se ejecutará en la consola de Eclipse.
