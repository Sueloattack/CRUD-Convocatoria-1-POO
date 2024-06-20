CRUD Convocatoria 1 POO

Hecho por: Cipa 1 Jaider Julian Manco, Juan José Ardila, Linda Gonzalez y Stephanie Solano

Se construyo una Api Rest en Spring boot donde se registren las siguientes operaciones para la clase Docente (tiene atributos tales como Id, numeroDocumento, 
tipoDocumento, celular, apellidos, nombres y email). Se trabajo en el mismo proyecto que se ha venido trabajando en las tutorías. Se modifico el codigo para que
no se pueda crear un Docente con el mismo numero de identificacion de un docente ya registrado. Tambien al momento de eliminar y actualizar un docente se verifica
que exista previamente en la base de datos(a través de su ID). Se realizo la implementación de Swagger para la documentación del servicio expuesto y se hizo el 
correspondiente manejo de excepciones.

Tener en cuenta que se uso el puerto 8090, la base de datos se uso con el phpmyadmin de XAMPP y el spring.jpa.hibernate.ddl-auto=create(se puede cambiar a update).

Métodos:
- Crear Docente.
- Obtener todos los docentes creados.
- Actualizar Docente.
- Eliminar Docente

Enlace del Swagger:http://localhost:8090/swagger-ui/index.html#/
