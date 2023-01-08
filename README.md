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
<p> Eres un administrador y accedes a la aplicación. Lo primero que observas es una ventana donde tienes tres opciones, para entrar como administrador has de presionar el botón Administrador, aparecerán en pantalla la opción Nuevo Administrador e Iniciar Sesión,al presionar Nuevo Administrador deberá llenar los campos Nombre y Contraseña, y podrá introducir el Nombre de su almacén. Si presiona el botón Iniciar Sesión también deberá llenar los campos Nombre y Contraseña, presionas "Acceder",y si los datos introducidos se encuentran en el sistema aparecerá en pantalla el nombre de su almacén junto con cuatro opciones: Envíos, Pedidos, Stock y Agentes .<br>
Si un cliente llama para hacer una compra has de dirigirte a la opción Agentes y luego a Cliente, donde verás un listado con todos los clientes registrados en el sistema, en el caso de que el cliente no se encuentre en la lista, presione el botón Agregar(Cliente), llene todos los campos y presione Registrar, dicho cliente aparecerá ahora en el listado. Para eliminar un cliente del sistema solo debe seleccionarlo en la lista y presionar la opción Eliminar. De igual modo si necesita agregar un proveedor a su almacén presione el botón Agregar(Proveedor), llene todos los campos y presione finalizar. Para eliminar un proveedor solo debe seleccionarlo en la lista de proveedores y presionar la opción Eliminar<br>
Si el cliente solicita un nuevo envío has de dirigirte a la opción Envíos y se le mostrará la lista de envíos a realizar, presione la opción Nuevo Envío, coloque la información que allí se solicita y presione Validar. Si desea eliminar un envío, selecciónelo en el listado y presione la opción Eliminar.<br>
Si desea hacer un pedido para el almacén presione Pedido, donde prodrá ver todos los pedidos del almacén, los que están validados por un proveedor y los que no lo están, para cofeccionar uno nuevo presione Nuevo Pedido, llene todos los campos y seleccione Terminar, el pedido aparecerá en la sección de no validados hasta que el proveedor correspondiente al artículo deseado cambie dicha propiedad, cuando esto ocurra recibirás una notificación. Para cancelar un pedido, luego de seleccionarlo en la lista presione Cancelar<br>
Para registrar un nuevo producto presione Stock, aparecerá la lista de procuctos en existencia donde si selecciona uno aparece a la derecha del listado toda la información correspondiente a este. Presione Agregar, llene los todos los campos y seleccione Finalizar.<br> 
</p>   
<br>
<br>
<h6> Situación #2</h6> 
<br>
<p> Eres un cliente y accedes a la aplicación. Al observar las tres opciones, para entrar como cliente has de presionar el botón Cliente. Aparecerá en la pantalla un listado de todos los almacenes disponibles para realizar envíos. Una vez seleccionado el deseado presione la opción Entrar y aparecerá en pantalla el nombre del almacén junto con dos opciones: Envíos y Stock.<br>
Si accede a la opción Stock aparecerán todos los productos en venta disponibles con su respectivo tipo y costo.<br>
Si accede a la opción Envíos aparecerá el listado de todos los envíos registrados en el almacén. Para solicitar un envío debe realizar una llamada telefónica al Administrador o presentarse personalmente a la dirección indicada en el listado de almacenes correspondiente al almacén seleccionado donde deberá proporcionar al administrador los productos que va a solicitar y la cantidad a entregar por cada uno. Una vez realizado lo anterior, el administrador entrará sus datos en el sistema y su solicitud quedará registrada en el listado de envíos.<br>
</p>
<br>
<br>
<h6> Situación #3</h6>
<br>
<p> Eres un proveedor y accedes a la aplicación. Al observar las tres opciones, para entrar como proveedor has de presionar el botón Proveedor. Al igual que en la Situación anterior Aparecerá en la pantalla un listado de todos los almacenes disponibles. Una vez seleccionado el deseado presione la opción Entrar y aparecerá en pantalla el nombre del almacén junto la opción: Órden.<br>
Al acceder a esta opción aparecerá un listado con todas las órdenes q ha hecho el almacén a sus proveedores donde cada órden viene con la información de producto, cantidad, proveedor solicitado, precio, y si esá validado o no. Si se encuentra una orden nueva con su nombre usted tendrá la opción de validarla o no, si la desea validar seleccione la órden y presione el botón Validar.<br>
</p>
<br>
<br>  



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
</b></p>
<br>
<br>
<h2 align="center">Módulo a desarrollar por vmcalderingamez 
<br>
:link: (https://github.com/LachoCardenas44) :link:</h2>
<br>
Imagen del módulo (UML)<img src ="https://github.com/LachoCardenas44/GestionAlmacen.VisualParadigm/blob/main/modulos/Modulo%20vmcalderingamez.jpg?raw=true">
<br>
<br>

:page_with_curl:**Descripción**:page_with_curl:
<br>
<br>
<p>
<b>User:</b> Clase abstracta donde estarán las propiedades de todos los usuarios que accedan al sistema.
<br>
<br>
<b>InternalAgent:</b> Clase abstracta donde se definen a los usuarios que son internos o pertenecen a un almacén específico.
<br>
<br>
<b>ExternalAgent:</b> Clase abstracta donde se definen a los usuarios que no pertenecen a un almanén e interactúan con él.
<br>
<br>
<b>Admin:</b> Es el controlador principal del negocio, tiene la funcionalidad de agregar o eliminar a otros agentes tanto internos como externos así como crear y modificar envíos y pedidos o eliminarlos.
<br>
<br>
<b>Client:</b> Es la entidad extena que consultará la información de los envíos.
<br>
<br>
<b>Supplier:</b> Es la entidad externa encargada de validar o cancelar un pedido.
<br>
<br>
<b>Product:</b> Es la unidad fundamental del negocio, sus instancias componen el registro de stock y se encuentran en las órdenes de pedido y envío.
<br>
<br>
<b>PhisicLocation:</b> Contiene la información exacta de la localización de un producto.
<br>
<br>
</p>

:ballot_box_with_check: **Tecnologías Utilizadas** :ballot_box_with_check:
<br>
<br>
:radio_button:...Visual Studio Code usando solo el lenguaje Java
<br>
<br>


**Licencia**:  (http://www.apache.org/licenses/)

 
