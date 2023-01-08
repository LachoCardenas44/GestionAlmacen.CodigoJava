<h1 align="center">Gestión De Almacén</h1>

:construction:Proyecto En Progreso:construction:
<br>
<br>
[Imagen Del Diagrama UML]<img src ="https://raw.githubusercontent.com/LachoCardenas44/GestionAlmacen.VisualParadigm/main/PreviewGestionAlmacen.jpg">
<br>
<br>
:page_with_curl:<h4>Descripción</h4>:page_with_curl: 
<br>
<p><strong>Aplicación de escritorio cuyo propósito es la fácil administración de almacenes; el personal, los productos en existencia ,así como los envíos y pedidos. Para usarse de una manera lo más intuitiva posible.</strong></p>
<br>
<br>
<h6>Situación #1</h6>
<br>
<p>Eres un administrador y accedes a la aplicación. Lo primero que observas es una ventana donde tienes tres opciones, para entrar como administrador has de presionar el botón Administrador, aparecerán en pantalla la opción Nuevo Administrador e Iniciar Sesión,al presionar Nuevo Administrador deberá llenar los campos Nombre y Contraseña, y podrá introducir el Nombre y la Localización de su almacén. Si presiona el botón Iniciar Sesión también deberá llenar los campos Nombre y Contraseña, presionas "Acceder",y si los datos introducidos se encuentran en el sistema aparecerá en pantalla el nombre de su almacén junto con cuatro opciones; Envíos, Pedidos, Stock, Agentes .<br>
Si un cliente llama para hacer una compra has de dirigirte a la opción Agentes y luego a Cliente, donde verás un listado con todos los clientes registrados en el sistema, en el caso de que el cliente no se encuentre en la lista, presione el botón Nuevo Cliente, llene todos los campos y presione Registrar, dicho cliente aparecerá ahora en el listado, solo debe seleccionarlo y presionar en Nuevo Envío, colocar la información que allí se solicita y presionar Validar.Para eliminar un cliente del sistema solo debe seleccionarlo en la lista y presionar la opción Eliminar, para modificar sus datos luego de seleccionarlo presione Modificar.<br>
Si desea hacer un pedido para el almacén presione Pedido, donde prodrá ver todos los pedidos del almacén, los que están validados por un proveedor y los que no lo están, para cofeccionar uno nuevo presione Nuevo Pedido, llene todos los campos y seleccione Terminar, el pedido aparecerá en la sección de no validados hasta que el proveedor correspondiente al artículo deseado cambie dicha propiedad, cuando esto ocurra recibirás una notificación. Para cancelar un pedido, luego de seleccionarlo en la lista presione Cancelar<br>
Para registrar un nuevo producto presione Stock, aparecerá la lista de procuctos en existencia donde si selecciona uno aparecen las opciones para modificar su información. Presione Nuevo Producto, llene los todos los campos y seleccione Finalizar. <b>[ NOTA : Si la cantidad de un producto es inferior a la cantidad mínima de dicho producto establecida por usted, se hará un pedido automáticamente del cual será notificado.]</b><br>
Si presiona Envíos podrá ver la lista de envíos a realizar, seleccionando un envío podrá eliminarlo pulsando Cancelar.
</p>   


## Autores
<br>
<br>
<img src = "https://avatars.githubusercontent.com/u/116188859?s=400&u=da2746e27e04d9642dae0f71051d89eb96f02791&v=4"width=100>
<sub>Lázaro Cristian Cárdenas García</sub>(https://github.com/LachoCardenas44)
<br>
<img src = "https://avatars.githubusercontent.com/u/109447884?v=4" width=100>
<sub>Victor Manuel Calderín Gamez</sub>(https://github.com/vmcalderingamez)

<h2 align="center">Módulo a desarrollar por LachoCardenas44 
<br>
:link: (https://github.com/LachoCardenas44) :link:</h2>
<br>
[Imagen del módulo (UML)](<img src = "https://github.com/LachoCardenas44/GestionAlmacen.VisualParadigm/blob/main/modulos/moduloLachoCardenas44.jpg">)
<br>
<br>

:page_with_curl:**Descripción**:page_with_curl:
<br>
<br>
<p><b>
Warehouse... Se mostrarán los almacenes disponibles para la administración de los mismos, y además será posible la entrada de la información pertinente para controlar un nuevo almacén; es decir, el nombre y la localización.
<br>
<br>
Delivery... Corresponde a todo lo referente con la administración de los envíos; donde se mostrarán los productos a enviar, costo de transportación, país destino, tasa de impuestos, y porcentaje de descuento.
<br>
<br>
Order... Corresponde a todo lo referente con la administración de los pedidos; efectuados por el propio personal de un respectivo almacén sobre el que se está trabajando y donde se mostrarán el producto requerido, cantidad de unidades, fecha de entrega, y fecha de realización del pedido.
<br>
<br>
<h2 align="center">Módulo a desarrollar por vmcalderingamez 
<br>
:link: (https://github.com/LachoCardenas44) :link:</h2>
<br>
Imagen del módulo (UML)<img src ="https://github.com/LachoCardenas44/GestionAlmacen.VisualParadigm/blob/main/modulos/Modulo%20vmcalderingamez.jpg">
<br>
<br>

:page_with_curl:**Descripción**:page_with_curl:
<br>
<br>
<p><b>
User: Clase abstracta donde estarán las propiedades de todos los usuarios que accedan al sistema.
<br>
<br>
InternalAgent: Clase abstracta donde se definen a los usuarios que son internos o pertenecen a un almacén específico.
<br>
<br>
ExternalAgent: Clase abstracta donde se definen a los usuarios que no pertenecen a un almanén e interactúan con él.
<br>
<br>
Admin: Es el controlador principal del negocio, tiene la funcionalidad de agregar o eliminar a otros agentes tanto internos como externos así como crear y modificar envíos y pedidos o eliminarlos.
<br>
<br>
Client: Es la entidad extena que consultará la información de los envíos.
<br>
<br>
Supplier: Es la entidad externa encargada de validar o cancelar un pedido.
<br>
<br>
Product: Es la unidad fundamental del negocio, sus instancias componen el registro de stock y se encuentran en las órdenes de pedido y envío.
<br>
<br>
PhisicLocation: Contiene la información exacta de la localización de un producto.
<br>
<br>
QualityRecord: Es un registro que muestra información cualitativa de un producto.
<br>
<br>
StockRecord:  Es un registro que muestra información acerca de la existencia de un producto en el almacén. 
</b></p>

:ballot_box_with_check: **Tecnologías Utilizadas** :ballot_box_with_check:
<br>
<br>
:radio_button:...Visual Studio Code usando solo el lenguaje Java
<br>
<br>


**Licencia**:  (http://www.apache.org/licenses/)

 
