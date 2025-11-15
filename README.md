Se quiere crear la funcion de crear en "terminal" y las persistencias de datos.

desde las opciones de crear en los combobox de la cabecera del programa se debe poder acceder a las opciones de crear de cada una:

Equipaje:
opcion para digitar el peso del equipaje.
combobox para elegir al pasajero duenio del equipaje (en el combobox se deben mostrar los nombres de los pasajeros, cuya informacion debe ser extraida desde la persistencia).
opcion para subir una foto del equipaje.
visualizacion de la imagen seleccionada.
boton para grabar la informacion.

Pasajero:
opcion para digitar la cedula del pasajero.
opcion para escribir el nombre del pasajero.
opcion para digitar la edad del pasajero.
radio button para elegir el genero del pasajero (verdadero si es masculino, falso si es femenino)
opcion para subir una foto del pasajero.
visualizacion de la imagen seleccionada.
boton para grabar la informacion.


Tiquete:
combobox para elegir al pasajero del tiqeute (en el combobox se deben mostrar los nombres de los pasajeros, cuya informacion debe ser extraida desde la persistencia).
combobox para elegir el viaje del tiquete (en el combobox se deben mostrar la informacion de esta manera "idViaje, horaViaje, fechaViaje, ciudadOrigen-ciudadDestino", cuya informacion debe ser extraida desde la persistencia).
combobox para elegir el asiento del tiquete (en el combobox se debe mostrar el id del asiento).
opcion para subir una foto del tiquete.
visualizacion de la imagen seleccionada.
boton para grabar la informacion.

Asiento:
combobox para elegir el bus del asiento (en el combobox se debe mostar la informacion de esta manera "idBus, modeloBus").
radio button para elegir el estado del asiento (verdadero si activo, falso si es inactivo).
opcion para subir una foto del asiento.
visualizacion de la imagen seleccionada.
boton para grabar la informacion.

Viaje:
combobox para elegir la ruta del viaje (en el combobox se deben mostrar la informacion de esta manera "ciudadOrigen-ciudadDestno", cuya informacion debe ser extraida desde la persistencia).
combobox para elegir el conductor del viaje (en el combobox se debe mostrar el nombre del conductor, cuya informacion debe ser extraida desde la persistencia).
combobox para elegir el bus del viaje (en el combobox se debe mostar la informacion de esta manera "idBus, modeloBus").
opcion para escribir la fecha del viaje.
opcion para digitar la hora del viaje.
opcion para subir una foto del viaje.
visualizacion de la imagen seleccionada.
boton para grabar la informacion.

Conductor:
opcion para digitar la cedula del conductor.
opcion para escribir el nombre del conductor.
opcion para digitar la edad del conductor.
radio button para elegir el genero del conductor (verdadero si es masculino, falso si es femenino)
opcion para subir una foto del conductor.
visualizacion de la imagen seleccionada.
boton para grabar la informacion.

Bus:
opcion para escribir el modelo del bus.
combobox para elegir la empresa del bus (en el combobox se debe mostrar el nombre de la empresa, cuya informacion debe ser extraida desde la persistencia).
opcion para subir una foto del bus.
visualizacion de la imagen seleccionada.
boton para grabar la informacion.

Empresa:
opcion para escribir el nombre de la empresa.
opcion para subir una foto del bus.
visualizacion de la imagen seleccionada.
boton para grabar la informacion.

Ruta:
opcion para escribir la ciudad de origen.
opcion para escribir la ciudad de destino.
opcion para digitar la tarifa de la ruta.
opcion para subir una foto de la ruta.
visualizacion de la imagen seleccionada.
boton para grabar la informacion.

en todos los cuestionarios anteriores, el cuestionario debera ser limpiado de toda la informacion que el usuario digito, luego de haber sido guardada.
en todas las clases que tengan como atributo "id", dicho id debe ser generado de forma auotomatica.
toda la informacion debe ser guardada en la persistencia, en archivos .txt. Ejemplo la informacion de bus se debe guardar en un arhivo llamado Bus.txt. 
en todas las persistencias la informacion se debe separar por punto y coma.
cada linea en los txt representa un registro.
la tarifa de la ruta se debe guardar en la persistencia con todos los decimales (sin formato exponencial).
Las imagenes se deben guardar con un identificador unico.
el identificador de la imagen tambien debe estar guardada en los archivos .txt de la persistencia.

Para poder hacer todas las implementacios anteriores, utiliza como guia al proyecto "Guia" que tiene implementaciones muy similares. Utiliza sintaxis, organizacion de clase, metodos, persistencia y diseño de interfaz, de la manera mas similar posible a como esta hecho en el proyecto "Guia"







