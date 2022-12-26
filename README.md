<h1 align="center">Gestión De Almacén</h1>

:construction:Proyecto En Progreso:construction:
<br>
<br>
[Imagen Del Diagrama UML]<img src ="https://raw.githubusercontent.com/LachoCardenas44/GestionAlmacen.VisualParadigm/main/PreviewGestionAlmacen.jpg">
<br>
<br>
:page_with_curl:**Descripción**:page_with_curl: <p><strong>Aplicación de escritorio cuyo propósito es la fácil administración de almacenes; el personal, los productos en existencia ,así como los envíos y pedidos. Para usarse de una manera lo más intuitiva posible.</strong></p>
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
[Imagen del módulo (UML)](<img src = "https://github.com/LachoCardenas44/GestionAlmacen.VisualParadigm/blob/main/modulos/Modulo%20LazaroCardenas44.jpg">)
<br>
<br>

:page_with_curl:**Descripción**:page_with_curl:
<br>
<br>
<p><b>
Warehouse... Se mostrarán los almacenes disponibles para la administración de los mismos, y además será posible la entrada de la información pertinente para controlar un nuevo almacén; es decir, el nombre y la localización.
<br>
<br>
Location... Ubicación de los almacenes.
<br>
<br>
Delivery... Corresponde a todo lo referente con la administración de los envíos; donde se mostrarán los productos a enviar, costo de transportación, país destino, tasa de impuestos, y porcentaje de descuento.
<br>
<br>
OutDeliveryNote... Registro de envíos.
<br>
<br>
Order... Corresponde a todo lo referente con la administración de los pedidos; efectuados por el propio personal de un respectivo almacén sobre el que se está trabajando y donde se mostrarán el producto requerido, cantidad de unidades, fecha de entrega, y fecha de realización del pedido.
<br>
<br>
InDeliveryNote... Registro de pedidos.</b></p>
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
<br>

:ballot_box_with_check: **Tecnologías Utilizadas** :ballot_box_with_check:
<br>
<br>
:radio_button:...Visual Studio Code usando solo el lenguaje Java
<br>
<br>


**Licencia**:  (http://www.apache.org/licenses/)

 
