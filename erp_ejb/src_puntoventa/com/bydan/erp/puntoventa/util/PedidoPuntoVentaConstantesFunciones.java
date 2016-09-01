/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.puntoventa.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.puntoventa.util.PedidoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.PedidoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.PedidoPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PedidoPuntoVentaConstantesFunciones extends PedidoPuntoVentaConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,-20);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="PedidoPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PedidoPuntoVenta"+PedidoPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PedidoPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PedidoPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+PedidoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+PedidoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+PedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+PedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PedidoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PedidoPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PedidoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PedidoPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pedido Punto Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Pedido Punto Venta";
	public static final String SCLASSWEBTITULO_LOWER="Pedido Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PedidoPuntoVenta";
	public static final String OBJECTNAME="pedidopuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="pedido_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pedidopuntoventa from "+PedidoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" pedidopuntoventa";
	public static String QUERYSELECTNATIVE="select "+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_usuario,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_vendedor,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_caja,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_precio,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_mesa,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_estado_pedido_punto_venta,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".numero_secuencial,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".codigo_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".nombre_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".direccion_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".telefono_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".tarjeta_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".fecha,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".hora,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".iva,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".ice,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".total from "+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+PedidoPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected PedidoPuntoVentaConstantesFuncionesAdditional pedidopuntoventaConstantesFuncionesAdditional=null;
	
	public PedidoPuntoVentaConstantesFuncionesAdditional getPedidoPuntoVentaConstantesFuncionesAdditional() {
		return this.pedidopuntoventaConstantesFuncionesAdditional;
	}
	
	public void setPedidoPuntoVentaConstantesFuncionesAdditional(PedidoPuntoVentaConstantesFuncionesAdditional pedidopuntoventaConstantesFuncionesAdditional) {
		try {
			this.pedidopuntoventaConstantesFuncionesAdditional=pedidopuntoventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDCAJA= "id_caja";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDMESA= "id_mesa";
    public static final String IDESTADOPEDIDOPUNTOVENTA= "id_estado_pedido_punto_venta";
    public static final String NUMERO_SECUENCIAL= "numero_secuencial";
    public static final String CODIGOCLIENTE= "codigo_cliente";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String DIRECCIONCLIENTE= "direccion_cliente";
    public static final String TELEFONOCLIENTE= "telefono_cliente";
    public static final String TARJETACLIENTE= "tarjeta_cliente";
    public static final String FECHA= "fecha";
    public static final String HORA= "hora";
    public static final String SUBTOTAL= "sub_total";
    public static final String IVA= "iva";
    public static final String ICE= "ice";
    public static final String DESCUENTO= "descuento";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_IDMESA= "Mesa";
		public static final String LABEL_IDMESA_LOWER= "Mesa";
    	public static final String LABEL_IDESTADOPEDIDOPUNTOVENTA= "Estado";
		public static final String LABEL_IDESTADOPEDIDOPUNTOVENTA_LOWER= "Estado Pedido Punto Venta";
    	public static final String LABEL_NUMERO_SECUENCIAL= "No. Secuencial";
		public static final String LABEL_NUMERO_SECUENCIAL_LOWER= "Numero_ Secuencial";
    	public static final String LABEL_CODIGOCLIENTE= "Codigo Cliente";
		public static final String LABEL_CODIGOCLIENTE_LOWER= "Codigo Cliente";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_DIRECCIONCLIENTE= "Direccion Cliente";
		public static final String LABEL_DIRECCIONCLIENTE_LOWER= "Direccion Cliente";
    	public static final String LABEL_TELEFONOCLIENTE= "Telefono Cliente";
		public static final String LABEL_TELEFONOCLIENTE_LOWER= "Telefono Cliente";
    	public static final String LABEL_TARJETACLIENTE= "Tarjeta Cliente";
		public static final String LABEL_TARJETACLIENTE_LOWER= "Tarjeta Cliente";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_HORA= "Hora";
		public static final String LABEL_HORA_LOWER= "Hora";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_CLIENTE=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXTARJETA_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTARJETA_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getPedidoPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.IDUSUARIO)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.IDVENDEDOR)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.IDCAJA)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.IDCLIENTE)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.IDMESA)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_IDMESA;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_IDESTADOPEDIDOPUNTOVENTA;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.NUMERO_SECUENCIAL)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_NUMERO_SECUENCIAL;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.TARJETACLIENTE)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.FECHA)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.HORA)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_HORA;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.SUBTOTAL)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.IVA)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.ICE)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.DESCUENTO)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(PedidoPuntoVentaConstantesFunciones.TOTAL)) {sLabelColumna=PedidoPuntoVentaConstantesFunciones.LABEL_TOTAL;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPedidoPuntoVentaDescripcion(PedidoPuntoVenta pedidopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pedidopuntoventa !=null/* && pedidopuntoventa.getId()!=0*/) {
			sDescripcion=pedidopuntoventa.getnumero_secuencial();//pedidopuntoventapedidopuntoventa.getnumero_secuencial().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPedidoPuntoVentaDescripcionDetallado(PedidoPuntoVenta pedidopuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=pedidopuntoventa.getId().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pedidopuntoventa.getVersionRow().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pedidopuntoventa.getid_empresa().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=pedidopuntoventa.getid_sucursal().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=pedidopuntoventa.getid_usuario().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=pedidopuntoventa.getid_vendedor().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.IDCAJA+"=";
		sDescripcion+=pedidopuntoventa.getid_caja().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=pedidopuntoventa.getid_cliente().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=pedidopuntoventa.getid_tipo_precio().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.IDMESA+"=";
		sDescripcion+=pedidopuntoventa.getid_mesa().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA+"=";
		sDescripcion+=pedidopuntoventa.getid_estado_pedido_punto_venta().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.NUMERO_SECUENCIAL+"=";
		sDescripcion+=pedidopuntoventa.getnumero_secuencial()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.CODIGOCLIENTE+"=";
		sDescripcion+=pedidopuntoventa.getcodigo_cliente()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=pedidopuntoventa.getnombre_cliente()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE+"=";
		sDescripcion+=pedidopuntoventa.getdireccion_cliente()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.TELEFONOCLIENTE+"=";
		sDescripcion+=pedidopuntoventa.gettelefono_cliente()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.TARJETACLIENTE+"=";
		sDescripcion+=pedidopuntoventa.gettarjeta_cliente()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.FECHA+"=";
		sDescripcion+=pedidopuntoventa.getfecha().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.HORA+"=";
		sDescripcion+=pedidopuntoventa.gethora().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=pedidopuntoventa.getsub_total().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.IVA+"=";
		sDescripcion+=pedidopuntoventa.getiva().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.ICE+"=";
		sDescripcion+=pedidopuntoventa.getice().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=pedidopuntoventa.getdescuento().toString()+",";
		sDescripcion+=PedidoPuntoVentaConstantesFunciones.TOTAL+"=";
		sDescripcion+=pedidopuntoventa.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPedidoPuntoVentaDescripcion(PedidoPuntoVenta pedidopuntoventa,String sValor) throws Exception {			
		if(pedidopuntoventa !=null) {
			pedidopuntoventa.setnumero_secuencial(sValor);;//pedidopuntoventapedidopuntoventa.getnumero_secuencial().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
		}

		return sDescripcion;
	}

	public static String getMesaDescripcion(Mesa mesa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mesa!=null/*&&mesa.getId()>0*/) {
			sDescripcion=MesaConstantesFunciones.getMesaDescripcion(mesa);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoPuntoVentaDescripcion(EstadoPedidoPuntoVenta estadopedidopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedidopuntoventa!=null/*&&estadopedidopuntoventa.getId()>0*/) {
			sDescripcion=EstadoPedidoPuntoVentaConstantesFunciones.getEstadoPedidoPuntoVentaDescripcion(estadopedidopuntoventa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoPedidoPuntoVenta")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdMesa")) {
			sNombreIndice="Tipo=  Por Mesa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPedidoPuntoVenta(Long id_estado_pedido_punto_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido_punto_venta!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_pedido_punto_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMesa(Long id_mesa) {
		String sDetalleIndice=" Parametros->";
		if(id_mesa!=null) {sDetalleIndice+=" Codigo Unico De Mesa="+id_mesa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPedidoPuntoVenta(PedidoPuntoVenta pedidopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidopuntoventa.setnumero_secuencial(pedidopuntoventa.getnumero_secuencial().trim());
		pedidopuntoventa.setcodigo_cliente(pedidopuntoventa.getcodigo_cliente().trim());
		pedidopuntoventa.setnombre_cliente(pedidopuntoventa.getnombre_cliente().trim());
		pedidopuntoventa.setdireccion_cliente(pedidopuntoventa.getdireccion_cliente().trim());
		pedidopuntoventa.settelefono_cliente(pedidopuntoventa.gettelefono_cliente().trim());
		pedidopuntoventa.settarjeta_cliente(pedidopuntoventa.gettarjeta_cliente().trim());
	}
	
	public static void quitarEspaciosPedidoPuntoVentas(List<PedidoPuntoVenta> pedidopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidoPuntoVenta pedidopuntoventa: pedidopuntoventas) {
			pedidopuntoventa.setnumero_secuencial(pedidopuntoventa.getnumero_secuencial().trim());
			pedidopuntoventa.setcodigo_cliente(pedidopuntoventa.getcodigo_cliente().trim());
			pedidopuntoventa.setnombre_cliente(pedidopuntoventa.getnombre_cliente().trim());
			pedidopuntoventa.setdireccion_cliente(pedidopuntoventa.getdireccion_cliente().trim());
			pedidopuntoventa.settelefono_cliente(pedidopuntoventa.gettelefono_cliente().trim());
			pedidopuntoventa.settarjeta_cliente(pedidopuntoventa.gettarjeta_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoPuntoVenta(PedidoPuntoVenta pedidopuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pedidopuntoventa.getConCambioAuxiliar()) {
			pedidopuntoventa.setIsDeleted(pedidopuntoventa.getIsDeletedAuxiliar());	
			pedidopuntoventa.setIsNew(pedidopuntoventa.getIsNewAuxiliar());	
			pedidopuntoventa.setIsChanged(pedidopuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pedidopuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pedidopuntoventa.setIsDeletedAuxiliar(false);	
			pedidopuntoventa.setIsNewAuxiliar(false);	
			pedidopuntoventa.setIsChangedAuxiliar(false);
			
			pedidopuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidoPuntoVentas(List<PedidoPuntoVenta> pedidopuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PedidoPuntoVenta pedidopuntoventa : pedidopuntoventas) {
			if(conAsignarBase && pedidopuntoventa.getConCambioAuxiliar()) {
				pedidopuntoventa.setIsDeleted(pedidopuntoventa.getIsDeletedAuxiliar());	
				pedidopuntoventa.setIsNew(pedidopuntoventa.getIsNewAuxiliar());	
				pedidopuntoventa.setIsChanged(pedidopuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pedidopuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pedidopuntoventa.setIsDeletedAuxiliar(false);	
				pedidopuntoventa.setIsNewAuxiliar(false);	
				pedidopuntoventa.setIsChangedAuxiliar(false);
				
				pedidopuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPedidoPuntoVenta(PedidoPuntoVenta pedidopuntoventa,Boolean conEnteros) throws Exception  {
		pedidopuntoventa.setsub_total(0.0);
		pedidopuntoventa.setiva(0.0);
		pedidopuntoventa.setice(0.0);
		pedidopuntoventa.setdescuento(0.0);
		pedidopuntoventa.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPedidoPuntoVentas(List<PedidoPuntoVenta> pedidopuntoventas,Boolean conEnteros) throws Exception  {
		
		for(PedidoPuntoVenta pedidopuntoventa: pedidopuntoventas) {
			pedidopuntoventa.setsub_total(0.0);
			pedidopuntoventa.setiva(0.0);
			pedidopuntoventa.setice(0.0);
			pedidopuntoventa.setdescuento(0.0);
			pedidopuntoventa.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPedidoPuntoVenta(List<PedidoPuntoVenta> pedidopuntoventas,PedidoPuntoVenta pedidopuntoventaAux) throws Exception  {
		PedidoPuntoVentaConstantesFunciones.InicializarValoresPedidoPuntoVenta(pedidopuntoventaAux,true);
		
		for(PedidoPuntoVenta pedidopuntoventa: pedidopuntoventas) {
			if(pedidopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pedidopuntoventaAux.setsub_total(pedidopuntoventaAux.getsub_total()+pedidopuntoventa.getsub_total());			
			pedidopuntoventaAux.setiva(pedidopuntoventaAux.getiva()+pedidopuntoventa.getiva());			
			pedidopuntoventaAux.setice(pedidopuntoventaAux.getice()+pedidopuntoventa.getice());			
			pedidopuntoventaAux.setdescuento(pedidopuntoventaAux.getdescuento()+pedidopuntoventa.getdescuento());			
			pedidopuntoventaAux.settotal(pedidopuntoventaAux.gettotal()+pedidopuntoventa.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PedidoPuntoVentaConstantesFunciones.getArrayColumnasGlobalesPedidoPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoPuntoVentaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoPuntoVentaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidoPuntoVentaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidoPuntoVentaConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPedidoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidoPuntoVenta> pedidopuntoventas,PedidoPuntoVenta pedidopuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidoPuntoVenta pedidopuntoventaAux: pedidopuntoventas) {
			if(pedidopuntoventaAux!=null && pedidopuntoventa!=null) {
				if((pedidopuntoventaAux.getId()==null && pedidopuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pedidopuntoventaAux.getId()!=null && pedidopuntoventa.getId()!=null){
					if(pedidopuntoventaAux.getId().equals(pedidopuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidoPuntoVenta(List<PedidoPuntoVenta> pedidopuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double sub_totalTotal=0.0;
		Double ivaTotal=0.0;
		Double iceTotal=0.0;
		Double descuentoTotal=0.0;
		Double totalTotal=0.0;
	
		for(PedidoPuntoVenta pedidopuntoventa: pedidopuntoventas) {			
			if(pedidopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			sub_totalTotal+=pedidopuntoventa.getsub_total();
			ivaTotal+=pedidopuntoventa.getiva();
			iceTotal+=pedidopuntoventa.getice();
			descuentoTotal+=pedidopuntoventa.getdescuento();
			totalTotal+=pedidopuntoventa.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoPuntoVentaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoPuntoVentaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoPuntoVentaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoPuntoVentaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoPuntoVentaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPedidoPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_ID, PedidoPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_VERSIONROW, PedidoPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA, PedidoPuntoVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL, PedidoPuntoVentaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_IDUSUARIO, PedidoPuntoVentaConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR, PedidoPuntoVentaConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_IDCAJA, PedidoPuntoVentaConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_IDCLIENTE, PedidoPuntoVentaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO, PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_IDMESA, PedidoPuntoVentaConstantesFunciones.IDMESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_IDESTADOPEDIDOPUNTOVENTA, PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_NUMERO_SECUENCIAL, PedidoPuntoVentaConstantesFunciones.NUMERO_SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE, PedidoPuntoVentaConstantesFunciones.CODIGOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE, PedidoPuntoVentaConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE, PedidoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE, PedidoPuntoVentaConstantesFunciones.TELEFONOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE, PedidoPuntoVentaConstantesFunciones.TARJETACLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_FECHA, PedidoPuntoVentaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_HORA, PedidoPuntoVentaConstantesFunciones.HORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL, PedidoPuntoVentaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_IVA, PedidoPuntoVentaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_ICE, PedidoPuntoVentaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO, PedidoPuntoVentaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidoPuntoVentaConstantesFunciones.LABEL_TOTAL, PedidoPuntoVentaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPedidoPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.IDMESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.NUMERO_SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.CODIGOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.TELEFONOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.TARJETACLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.HORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidoPuntoVentaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoPuntoVenta() throws Exception  {
		return PedidoPuntoVentaConstantesFunciones.getTiposSeleccionarPedidoPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoPuntoVenta(Boolean conFk) throws Exception  {
		return PedidoPuntoVentaConstantesFunciones.getTiposSeleccionarPedidoPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidoPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_IDMESA);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IDMESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_IDESTADOPEDIDOPUNTOVENTA);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IDESTADOPEDIDOPUNTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_NUMERO_SECUENCIAL);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_NUMERO_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_HORA);
		reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_HORA);

		arrTiposSeleccionarTodos.add(reporte);
		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidoPuntoVentaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPedidoPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoPuntoVenta(PedidoPuntoVenta pedidopuntoventaAux) throws Exception {
		
			pedidopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidopuntoventaAux.getEmpresa()));
			pedidopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidopuntoventaAux.getSucursal()));
			pedidopuntoventaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(pedidopuntoventaAux.getUsuario()));
			pedidopuntoventaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(pedidopuntoventaAux.getVendedor()));
			pedidopuntoventaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(pedidopuntoventaAux.getCaja()));
			pedidopuntoventaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidopuntoventaAux.getCliente()));
			pedidopuntoventaAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(pedidopuntoventaAux.getTipoPrecio()));
			pedidopuntoventaAux.setmesa_descripcion(MesaConstantesFunciones.getMesaDescripcion(pedidopuntoventaAux.getMesa()));
			pedidopuntoventaAux.setestadopedidopuntoventa_descripcion(EstadoPedidoPuntoVentaConstantesFunciones.getEstadoPedidoPuntoVentaDescripcion(pedidopuntoventaAux.getEstadoPedidoPuntoVenta()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPedidoPuntoVenta(List<PedidoPuntoVenta> pedidopuntoventasTemp) throws Exception {
		for(PedidoPuntoVenta pedidopuntoventaAux:pedidopuntoventasTemp) {
			
			pedidopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidopuntoventaAux.getEmpresa()));
			pedidopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidopuntoventaAux.getSucursal()));
			pedidopuntoventaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(pedidopuntoventaAux.getUsuario()));
			pedidopuntoventaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(pedidopuntoventaAux.getVendedor()));
			pedidopuntoventaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(pedidopuntoventaAux.getCaja()));
			pedidopuntoventaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pedidopuntoventaAux.getCliente()));
			pedidopuntoventaAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(pedidopuntoventaAux.getTipoPrecio()));
			pedidopuntoventaAux.setmesa_descripcion(MesaConstantesFunciones.getMesaDescripcion(pedidopuntoventaAux.getMesa()));
			pedidopuntoventaAux.setestadopedidopuntoventa_descripcion(EstadoPedidoPuntoVentaConstantesFunciones.getEstadoPedidoPuntoVentaDescripcion(pedidopuntoventaAux.getEstadoPedidoPuntoVenta()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Caja.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(Mesa.class));
				classes.add(new Classe(EstadoPedidoPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mesa.class)) {
						classes.add(new Classe(Mesa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedidoPuntoVenta.class)) {
						classes.add(new Classe(EstadoPedidoPuntoVenta.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPedidoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Mesa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mesa.class)); continue;
					}

					if(EstadoPedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedidoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Mesa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mesa.class)); continue;
					}

					if(EstadoPedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedidoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoPuntoVentaConstantesFunciones.getClassesRelationshipsOfPedidoPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetallePedidoPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetallePedidoPuntoVenta.class)) {
						classes.add(new Classe(DetallePedidoPuntoVenta.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidoPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfPedidoPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetallePedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetallePedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePedidoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(PedidoPuntoVenta pedidopuntoventa,List<PedidoPuntoVenta> pedidopuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PedidoPuntoVenta pedidopuntoventaEncontrado=null;
			
			for(PedidoPuntoVenta pedidopuntoventaLocal:pedidopuntoventas) {
				if(pedidopuntoventaLocal.getId().equals(pedidopuntoventa.getId())) {
					pedidopuntoventaEncontrado=pedidopuntoventaLocal;
					
					pedidopuntoventaLocal.setIsChanged(pedidopuntoventa.getIsChanged());
					pedidopuntoventaLocal.setIsNew(pedidopuntoventa.getIsNew());
					pedidopuntoventaLocal.setIsDeleted(pedidopuntoventa.getIsDeleted());
					
					pedidopuntoventaLocal.setGeneralEntityOriginal(pedidopuntoventa.getGeneralEntityOriginal());
					
					pedidopuntoventaLocal.setId(pedidopuntoventa.getId());	
					pedidopuntoventaLocal.setVersionRow(pedidopuntoventa.getVersionRow());	
					pedidopuntoventaLocal.setid_empresa(pedidopuntoventa.getid_empresa());	
					pedidopuntoventaLocal.setid_sucursal(pedidopuntoventa.getid_sucursal());	
					pedidopuntoventaLocal.setid_usuario(pedidopuntoventa.getid_usuario());	
					pedidopuntoventaLocal.setid_vendedor(pedidopuntoventa.getid_vendedor());	
					pedidopuntoventaLocal.setid_caja(pedidopuntoventa.getid_caja());	
					pedidopuntoventaLocal.setid_cliente(pedidopuntoventa.getid_cliente());	
					pedidopuntoventaLocal.setid_tipo_precio(pedidopuntoventa.getid_tipo_precio());	
					pedidopuntoventaLocal.setid_mesa(pedidopuntoventa.getid_mesa());	
					pedidopuntoventaLocal.setid_estado_pedido_punto_venta(pedidopuntoventa.getid_estado_pedido_punto_venta());	
					pedidopuntoventaLocal.setnumero_secuencial(pedidopuntoventa.getnumero_secuencial());	
					pedidopuntoventaLocal.setcodigo_cliente(pedidopuntoventa.getcodigo_cliente());	
					pedidopuntoventaLocal.setnombre_cliente(pedidopuntoventa.getnombre_cliente());	
					pedidopuntoventaLocal.setdireccion_cliente(pedidopuntoventa.getdireccion_cliente());	
					pedidopuntoventaLocal.settelefono_cliente(pedidopuntoventa.gettelefono_cliente());	
					pedidopuntoventaLocal.settarjeta_cliente(pedidopuntoventa.gettarjeta_cliente());	
					pedidopuntoventaLocal.setfecha(pedidopuntoventa.getfecha());	
					pedidopuntoventaLocal.sethora(pedidopuntoventa.gethora());	
					pedidopuntoventaLocal.setsub_total(pedidopuntoventa.getsub_total());	
					pedidopuntoventaLocal.setiva(pedidopuntoventa.getiva());	
					pedidopuntoventaLocal.setice(pedidopuntoventa.getice());	
					pedidopuntoventaLocal.setdescuento(pedidopuntoventa.getdescuento());	
					pedidopuntoventaLocal.settotal(pedidopuntoventa.gettotal());	
					
					
					pedidopuntoventaLocal.setDetallePedidoPuntoVentas(pedidopuntoventa.getDetallePedidoPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!pedidopuntoventa.getIsDeleted()) {
				if(!existe) {
					pedidopuntoventas.add(pedidopuntoventa);
				}
			} else {
				if(pedidopuntoventaEncontrado!=null && permiteQuitar)  {
					pedidopuntoventas.remove(pedidopuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PedidoPuntoVenta pedidopuntoventa,List<PedidoPuntoVenta> pedidopuntoventas) throws Exception {
		try	{			
			for(PedidoPuntoVenta pedidopuntoventaLocal:pedidopuntoventas) {
				if(pedidopuntoventaLocal.getId().equals(pedidopuntoventa.getId())) {
					pedidopuntoventaLocal.setIsSelected(pedidopuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPedidoPuntoVenta(List<PedidoPuntoVenta> pedidopuntoventasAux) throws Exception {
		//this.pedidopuntoventasAux=pedidopuntoventasAux;
		
		for(PedidoPuntoVenta pedidopuntoventaAux:pedidopuntoventasAux) {
			if(pedidopuntoventaAux.getIsChanged()) {
				pedidopuntoventaAux.setIsChanged(false);
			}		
			
			if(pedidopuntoventaAux.getIsNew()) {
				pedidopuntoventaAux.setIsNew(false);
			}	
			
			if(pedidopuntoventaAux.getIsDeleted()) {
				pedidopuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPedidoPuntoVenta(PedidoPuntoVenta pedidopuntoventaAux) throws Exception {
		//this.pedidopuntoventaAux=pedidopuntoventaAux;
		
			if(pedidopuntoventaAux.getIsChanged()) {
				pedidopuntoventaAux.setIsChanged(false);
			}		
			
			if(pedidopuntoventaAux.getIsNew()) {
				pedidopuntoventaAux.setIsNew(false);
			}	
			
			if(pedidopuntoventaAux.getIsDeleted()) {
				pedidopuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PedidoPuntoVenta pedidopuntoventaAsignar,PedidoPuntoVenta pedidopuntoventa) throws Exception {
		pedidopuntoventaAsignar.setId(pedidopuntoventa.getId());	
		pedidopuntoventaAsignar.setVersionRow(pedidopuntoventa.getVersionRow());	
		pedidopuntoventaAsignar.setid_empresa(pedidopuntoventa.getid_empresa());
		pedidopuntoventaAsignar.setempresa_descripcion(pedidopuntoventa.getempresa_descripcion());	
		pedidopuntoventaAsignar.setid_sucursal(pedidopuntoventa.getid_sucursal());
		pedidopuntoventaAsignar.setsucursal_descripcion(pedidopuntoventa.getsucursal_descripcion());	
		pedidopuntoventaAsignar.setid_usuario(pedidopuntoventa.getid_usuario());
		pedidopuntoventaAsignar.setusuario_descripcion(pedidopuntoventa.getusuario_descripcion());	
		pedidopuntoventaAsignar.setid_vendedor(pedidopuntoventa.getid_vendedor());
		pedidopuntoventaAsignar.setvendedor_descripcion(pedidopuntoventa.getvendedor_descripcion());	
		pedidopuntoventaAsignar.setid_caja(pedidopuntoventa.getid_caja());
		pedidopuntoventaAsignar.setcaja_descripcion(pedidopuntoventa.getcaja_descripcion());	
		pedidopuntoventaAsignar.setid_cliente(pedidopuntoventa.getid_cliente());
		pedidopuntoventaAsignar.setcliente_descripcion(pedidopuntoventa.getcliente_descripcion());	
		pedidopuntoventaAsignar.setid_tipo_precio(pedidopuntoventa.getid_tipo_precio());
		pedidopuntoventaAsignar.settipoprecio_descripcion(pedidopuntoventa.gettipoprecio_descripcion());	
		pedidopuntoventaAsignar.setid_mesa(pedidopuntoventa.getid_mesa());
		pedidopuntoventaAsignar.setmesa_descripcion(pedidopuntoventa.getmesa_descripcion());	
		pedidopuntoventaAsignar.setid_estado_pedido_punto_venta(pedidopuntoventa.getid_estado_pedido_punto_venta());
		pedidopuntoventaAsignar.setestadopedidopuntoventa_descripcion(pedidopuntoventa.getestadopedidopuntoventa_descripcion());	
		pedidopuntoventaAsignar.setnumero_secuencial(pedidopuntoventa.getnumero_secuencial());	
		pedidopuntoventaAsignar.setcodigo_cliente(pedidopuntoventa.getcodigo_cliente());	
		pedidopuntoventaAsignar.setnombre_cliente(pedidopuntoventa.getnombre_cliente());	
		pedidopuntoventaAsignar.setdireccion_cliente(pedidopuntoventa.getdireccion_cliente());	
		pedidopuntoventaAsignar.settelefono_cliente(pedidopuntoventa.gettelefono_cliente());	
		pedidopuntoventaAsignar.settarjeta_cliente(pedidopuntoventa.gettarjeta_cliente());	
		pedidopuntoventaAsignar.setfecha(pedidopuntoventa.getfecha());	
		pedidopuntoventaAsignar.sethora(pedidopuntoventa.gethora());	
		pedidopuntoventaAsignar.setsub_total(pedidopuntoventa.getsub_total());	
		pedidopuntoventaAsignar.setiva(pedidopuntoventa.getiva());	
		pedidopuntoventaAsignar.setice(pedidopuntoventa.getice());	
		pedidopuntoventaAsignar.setdescuento(pedidopuntoventa.getdescuento());	
		pedidopuntoventaAsignar.settotal(pedidopuntoventa.gettotal());	
	}
	
	public static void inicializarPedidoPuntoVenta(PedidoPuntoVenta pedidopuntoventa) throws Exception {
		try {
				pedidopuntoventa.setId(0L);	
					
				pedidopuntoventa.setid_empresa(-1L);	
				pedidopuntoventa.setid_sucursal(-1L);	
				pedidopuntoventa.setid_usuario(-1L);	
				pedidopuntoventa.setid_vendedor(-1L);	
				pedidopuntoventa.setid_caja(-1L);	
				pedidopuntoventa.setid_cliente(-1L);	
				pedidopuntoventa.setid_tipo_precio(-1L);	
				pedidopuntoventa.setid_mesa(-1L);	
				pedidopuntoventa.setid_estado_pedido_punto_venta(-1L);	
				pedidopuntoventa.setnumero_secuencial("");	
				pedidopuntoventa.setcodigo_cliente("");	
				pedidopuntoventa.setnombre_cliente("");	
				pedidopuntoventa.setdireccion_cliente("");	
				pedidopuntoventa.settelefono_cliente("");	
				pedidopuntoventa.settarjeta_cliente("");	
				pedidopuntoventa.setfecha(new Date());	
				pedidopuntoventa.sethora(new Time((new Date()).getTime()));	
				pedidopuntoventa.setsub_total(0.0);	
				pedidopuntoventa.setiva(0.0);	
				pedidopuntoventa.setice(0.0);	
				pedidopuntoventa.setdescuento(0.0);	
				pedidopuntoventa.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPedidoPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_IDMESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_IDESTADOPEDIDOPUNTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_NUMERO_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_CODIGOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_DIRECCIONCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_TELEFONOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_TARJETACLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_HORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidoPuntoVentaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPedidoPuntoVenta(String sTipo,Row row,Workbook workbook,PedidoPuntoVenta pedidopuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getmesa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getestadopedidopuntoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getcodigo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getdireccion_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.gettelefono_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.gettarjeta_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.gethora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidopuntoventa.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPedidoPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPedidoPuntoVenta() {
		return this.sFinalQueryPedidoPuntoVenta;
	}
	
	public void setsFinalQueryPedidoPuntoVenta(String sFinalQueryPedidoPuntoVenta) {
		this.sFinalQueryPedidoPuntoVenta= sFinalQueryPedidoPuntoVenta;
	}
	
	public Border resaltarSeleccionarPedidoPuntoVenta=null;
	
	public Border setResaltarSeleccionarPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPedidoPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPedidoPuntoVenta() {
		return this.resaltarSeleccionarPedidoPuntoVenta;
	}
	
	public void setResaltarSeleccionarPedidoPuntoVenta(Border borderResaltarSeleccionarPedidoPuntoVenta) {
		this.resaltarSeleccionarPedidoPuntoVenta= borderResaltarSeleccionarPedidoPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPedidoPuntoVenta=null;
	public Boolean mostraridPedidoPuntoVenta=true;
	public Boolean activaridPedidoPuntoVenta=true;

	public Border resaltarid_empresaPedidoPuntoVenta=null;
	public Boolean mostrarid_empresaPedidoPuntoVenta=true;
	public Boolean activarid_empresaPedidoPuntoVenta=true;
	public Boolean cargarid_empresaPedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_sucursalPedidoPuntoVenta=null;
	public Boolean mostrarid_sucursalPedidoPuntoVenta=true;
	public Boolean activarid_sucursalPedidoPuntoVenta=true;
	public Boolean cargarid_sucursalPedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_usuarioPedidoPuntoVenta=null;
	public Boolean mostrarid_usuarioPedidoPuntoVenta=true;
	public Boolean activarid_usuarioPedidoPuntoVenta=true;
	public Boolean cargarid_usuarioPedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioPedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_vendedorPedidoPuntoVenta=null;
	public Boolean mostrarid_vendedorPedidoPuntoVenta=true;
	public Boolean activarid_vendedorPedidoPuntoVenta=true;
	public Boolean cargarid_vendedorPedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorPedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_cajaPedidoPuntoVenta=null;
	public Boolean mostrarid_cajaPedidoPuntoVenta=true;
	public Boolean activarid_cajaPedidoPuntoVenta=true;
	public Boolean cargarid_cajaPedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaPedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_clientePedidoPuntoVenta=null;
	public Boolean mostrarid_clientePedidoPuntoVenta=true;
	public Boolean activarid_clientePedidoPuntoVenta=true;
	public Boolean cargarid_clientePedidoPuntoVenta=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clientePedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioPedidoPuntoVenta=null;
	public Boolean mostrarid_tipo_precioPedidoPuntoVenta=true;
	public Boolean activarid_tipo_precioPedidoPuntoVenta=true;
	public Boolean cargarid_tipo_precioPedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioPedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_mesaPedidoPuntoVenta=null;
	public Boolean mostrarid_mesaPedidoPuntoVenta=true;
	public Boolean activarid_mesaPedidoPuntoVenta=true;
	public Boolean cargarid_mesaPedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesaPedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_estado_pedido_punto_ventaPedidoPuntoVenta=null;
	public Boolean mostrarid_estado_pedido_punto_ventaPedidoPuntoVenta=true;
	public Boolean activarid_estado_pedido_punto_ventaPedidoPuntoVenta=true;
	public Boolean cargarid_estado_pedido_punto_ventaPedidoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedido_punto_ventaPedidoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarnumero_secuencialPedidoPuntoVenta=null;
	public Boolean mostrarnumero_secuencialPedidoPuntoVenta=true;
	public Boolean activarnumero_secuencialPedidoPuntoVenta=true;

	public Border resaltarcodigo_clientePedidoPuntoVenta=null;
	public Boolean mostrarcodigo_clientePedidoPuntoVenta=true;
	public Boolean activarcodigo_clientePedidoPuntoVenta=true;

	public Border resaltarnombre_clientePedidoPuntoVenta=null;
	public Boolean mostrarnombre_clientePedidoPuntoVenta=true;
	public Boolean activarnombre_clientePedidoPuntoVenta=true;

	public Border resaltardireccion_clientePedidoPuntoVenta=null;
	public Boolean mostrardireccion_clientePedidoPuntoVenta=true;
	public Boolean activardireccion_clientePedidoPuntoVenta=true;

	public Border resaltartelefono_clientePedidoPuntoVenta=null;
	public Boolean mostrartelefono_clientePedidoPuntoVenta=true;
	public Boolean activartelefono_clientePedidoPuntoVenta=true;

	public Border resaltartarjeta_clientePedidoPuntoVenta=null;
	public Boolean mostrartarjeta_clientePedidoPuntoVenta=true;
	public Boolean activartarjeta_clientePedidoPuntoVenta=true;

	public Border resaltarfechaPedidoPuntoVenta=null;
	public Boolean mostrarfechaPedidoPuntoVenta=true;
	public Boolean activarfechaPedidoPuntoVenta=false;

	public Border resaltarhoraPedidoPuntoVenta=null;
	public Boolean mostrarhoraPedidoPuntoVenta=true;
	public Boolean activarhoraPedidoPuntoVenta=true;

	public Border resaltarsub_totalPedidoPuntoVenta=null;
	public Boolean mostrarsub_totalPedidoPuntoVenta=true;
	public Boolean activarsub_totalPedidoPuntoVenta=true;

	public Border resaltarivaPedidoPuntoVenta=null;
	public Boolean mostrarivaPedidoPuntoVenta=true;
	public Boolean activarivaPedidoPuntoVenta=true;

	public Border resaltaricePedidoPuntoVenta=null;
	public Boolean mostraricePedidoPuntoVenta=true;
	public Boolean activaricePedidoPuntoVenta=true;

	public Border resaltardescuentoPedidoPuntoVenta=null;
	public Boolean mostrardescuentoPedidoPuntoVenta=true;
	public Boolean activardescuentoPedidoPuntoVenta=true;

	public Border resaltartotalPedidoPuntoVenta=null;
	public Boolean mostrartotalPedidoPuntoVenta=true;
	public Boolean activartotalPedidoPuntoVenta=true;

	
	

	public Border setResaltaridPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPedidoPuntoVenta() {
		return this.resaltaridPedidoPuntoVenta;
	}

	public void setResaltaridPedidoPuntoVenta(Border borderResaltar) {
		this.resaltaridPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridPedidoPuntoVenta() {
		return this.mostraridPedidoPuntoVenta;
	}

	public void setMostraridPedidoPuntoVenta(Boolean mostraridPedidoPuntoVenta) {
		this.mostraridPedidoPuntoVenta= mostraridPedidoPuntoVenta;
	}

	public Boolean getActivaridPedidoPuntoVenta() {
		return this.activaridPedidoPuntoVenta;
	}

	public void setActivaridPedidoPuntoVenta(Boolean activaridPedidoPuntoVenta) {
		this.activaridPedidoPuntoVenta= activaridPedidoPuntoVenta;
	}

	public Border setResaltarid_empresaPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPedidoPuntoVenta() {
		return this.resaltarid_empresaPedidoPuntoVenta;
	}

	public void setResaltarid_empresaPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_empresaPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaPedidoPuntoVenta() {
		return this.mostrarid_empresaPedidoPuntoVenta;
	}

	public void setMostrarid_empresaPedidoPuntoVenta(Boolean mostrarid_empresaPedidoPuntoVenta) {
		this.mostrarid_empresaPedidoPuntoVenta= mostrarid_empresaPedidoPuntoVenta;
	}

	public Boolean getActivarid_empresaPedidoPuntoVenta() {
		return this.activarid_empresaPedidoPuntoVenta;
	}

	public void setActivarid_empresaPedidoPuntoVenta(Boolean activarid_empresaPedidoPuntoVenta) {
		this.activarid_empresaPedidoPuntoVenta= activarid_empresaPedidoPuntoVenta;
	}

	public Boolean getCargarid_empresaPedidoPuntoVenta() {
		return this.cargarid_empresaPedidoPuntoVenta;
	}

	public void setCargarid_empresaPedidoPuntoVenta(Boolean cargarid_empresaPedidoPuntoVenta) {
		this.cargarid_empresaPedidoPuntoVenta= cargarid_empresaPedidoPuntoVenta;
	}

	public Border setResaltarid_sucursalPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPedidoPuntoVenta() {
		return this.resaltarid_sucursalPedidoPuntoVenta;
	}

	public void setResaltarid_sucursalPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_sucursalPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPedidoPuntoVenta() {
		return this.mostrarid_sucursalPedidoPuntoVenta;
	}

	public void setMostrarid_sucursalPedidoPuntoVenta(Boolean mostrarid_sucursalPedidoPuntoVenta) {
		this.mostrarid_sucursalPedidoPuntoVenta= mostrarid_sucursalPedidoPuntoVenta;
	}

	public Boolean getActivarid_sucursalPedidoPuntoVenta() {
		return this.activarid_sucursalPedidoPuntoVenta;
	}

	public void setActivarid_sucursalPedidoPuntoVenta(Boolean activarid_sucursalPedidoPuntoVenta) {
		this.activarid_sucursalPedidoPuntoVenta= activarid_sucursalPedidoPuntoVenta;
	}

	public Boolean getCargarid_sucursalPedidoPuntoVenta() {
		return this.cargarid_sucursalPedidoPuntoVenta;
	}

	public void setCargarid_sucursalPedidoPuntoVenta(Boolean cargarid_sucursalPedidoPuntoVenta) {
		this.cargarid_sucursalPedidoPuntoVenta= cargarid_sucursalPedidoPuntoVenta;
	}

	public Border setResaltarid_usuarioPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_usuarioPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioPedidoPuntoVenta() {
		return this.resaltarid_usuarioPedidoPuntoVenta;
	}

	public void setResaltarid_usuarioPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_usuarioPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_usuarioPedidoPuntoVenta() {
		return this.mostrarid_usuarioPedidoPuntoVenta;
	}

	public void setMostrarid_usuarioPedidoPuntoVenta(Boolean mostrarid_usuarioPedidoPuntoVenta) {
		this.mostrarid_usuarioPedidoPuntoVenta= mostrarid_usuarioPedidoPuntoVenta;
	}

	public Boolean getActivarid_usuarioPedidoPuntoVenta() {
		return this.activarid_usuarioPedidoPuntoVenta;
	}

	public void setActivarid_usuarioPedidoPuntoVenta(Boolean activarid_usuarioPedidoPuntoVenta) {
		this.activarid_usuarioPedidoPuntoVenta= activarid_usuarioPedidoPuntoVenta;
	}

	public Boolean getCargarid_usuarioPedidoPuntoVenta() {
		return this.cargarid_usuarioPedidoPuntoVenta;
	}

	public void setCargarid_usuarioPedidoPuntoVenta(Boolean cargarid_usuarioPedidoPuntoVenta) {
		this.cargarid_usuarioPedidoPuntoVenta= cargarid_usuarioPedidoPuntoVenta;
	}

	public Border setResaltarid_vendedorPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_vendedorPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorPedidoPuntoVenta() {
		return this.resaltarid_vendedorPedidoPuntoVenta;
	}

	public void setResaltarid_vendedorPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_vendedorPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_vendedorPedidoPuntoVenta() {
		return this.mostrarid_vendedorPedidoPuntoVenta;
	}

	public void setMostrarid_vendedorPedidoPuntoVenta(Boolean mostrarid_vendedorPedidoPuntoVenta) {
		this.mostrarid_vendedorPedidoPuntoVenta= mostrarid_vendedorPedidoPuntoVenta;
	}

	public Boolean getActivarid_vendedorPedidoPuntoVenta() {
		return this.activarid_vendedorPedidoPuntoVenta;
	}

	public void setActivarid_vendedorPedidoPuntoVenta(Boolean activarid_vendedorPedidoPuntoVenta) {
		this.activarid_vendedorPedidoPuntoVenta= activarid_vendedorPedidoPuntoVenta;
	}

	public Boolean getCargarid_vendedorPedidoPuntoVenta() {
		return this.cargarid_vendedorPedidoPuntoVenta;
	}

	public void setCargarid_vendedorPedidoPuntoVenta(Boolean cargarid_vendedorPedidoPuntoVenta) {
		this.cargarid_vendedorPedidoPuntoVenta= cargarid_vendedorPedidoPuntoVenta;
	}

	public Border setResaltarid_cajaPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_cajaPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaPedidoPuntoVenta() {
		return this.resaltarid_cajaPedidoPuntoVenta;
	}

	public void setResaltarid_cajaPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_cajaPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_cajaPedidoPuntoVenta() {
		return this.mostrarid_cajaPedidoPuntoVenta;
	}

	public void setMostrarid_cajaPedidoPuntoVenta(Boolean mostrarid_cajaPedidoPuntoVenta) {
		this.mostrarid_cajaPedidoPuntoVenta= mostrarid_cajaPedidoPuntoVenta;
	}

	public Boolean getActivarid_cajaPedidoPuntoVenta() {
		return this.activarid_cajaPedidoPuntoVenta;
	}

	public void setActivarid_cajaPedidoPuntoVenta(Boolean activarid_cajaPedidoPuntoVenta) {
		this.activarid_cajaPedidoPuntoVenta= activarid_cajaPedidoPuntoVenta;
	}

	public Boolean getCargarid_cajaPedidoPuntoVenta() {
		return this.cargarid_cajaPedidoPuntoVenta;
	}

	public void setCargarid_cajaPedidoPuntoVenta(Boolean cargarid_cajaPedidoPuntoVenta) {
		this.cargarid_cajaPedidoPuntoVenta= cargarid_cajaPedidoPuntoVenta;
	}

	public Border setResaltarid_clientePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_clientePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clientePedidoPuntoVenta() {
		return this.resaltarid_clientePedidoPuntoVenta;
	}

	public void setResaltarid_clientePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_clientePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_clientePedidoPuntoVenta() {
		return this.mostrarid_clientePedidoPuntoVenta;
	}

	public void setMostrarid_clientePedidoPuntoVenta(Boolean mostrarid_clientePedidoPuntoVenta) {
		this.mostrarid_clientePedidoPuntoVenta= mostrarid_clientePedidoPuntoVenta;
	}

	public Boolean getActivarid_clientePedidoPuntoVenta() {
		return this.activarid_clientePedidoPuntoVenta;
	}

	public void setActivarid_clientePedidoPuntoVenta(Boolean activarid_clientePedidoPuntoVenta) {
		this.activarid_clientePedidoPuntoVenta= activarid_clientePedidoPuntoVenta;
	}

	public Boolean getCargarid_clientePedidoPuntoVenta() {
		return this.cargarid_clientePedidoPuntoVenta;
	}

	public void setCargarid_clientePedidoPuntoVenta(Boolean cargarid_clientePedidoPuntoVenta) {
		this.cargarid_clientePedidoPuntoVenta= cargarid_clientePedidoPuntoVenta;
	}

	public Border setResaltarid_tipo_precioPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioPedidoPuntoVenta() {
		return this.resaltarid_tipo_precioPedidoPuntoVenta;
	}

	public void setResaltarid_tipo_precioPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_tipo_precioPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioPedidoPuntoVenta() {
		return this.mostrarid_tipo_precioPedidoPuntoVenta;
	}

	public void setMostrarid_tipo_precioPedidoPuntoVenta(Boolean mostrarid_tipo_precioPedidoPuntoVenta) {
		this.mostrarid_tipo_precioPedidoPuntoVenta= mostrarid_tipo_precioPedidoPuntoVenta;
	}

	public Boolean getActivarid_tipo_precioPedidoPuntoVenta() {
		return this.activarid_tipo_precioPedidoPuntoVenta;
	}

	public void setActivarid_tipo_precioPedidoPuntoVenta(Boolean activarid_tipo_precioPedidoPuntoVenta) {
		this.activarid_tipo_precioPedidoPuntoVenta= activarid_tipo_precioPedidoPuntoVenta;
	}

	public Boolean getCargarid_tipo_precioPedidoPuntoVenta() {
		return this.cargarid_tipo_precioPedidoPuntoVenta;
	}

	public void setCargarid_tipo_precioPedidoPuntoVenta(Boolean cargarid_tipo_precioPedidoPuntoVenta) {
		this.cargarid_tipo_precioPedidoPuntoVenta= cargarid_tipo_precioPedidoPuntoVenta;
	}

	public Border setResaltarid_mesaPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_mesaPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesaPedidoPuntoVenta() {
		return this.resaltarid_mesaPedidoPuntoVenta;
	}

	public void setResaltarid_mesaPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_mesaPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_mesaPedidoPuntoVenta() {
		return this.mostrarid_mesaPedidoPuntoVenta;
	}

	public void setMostrarid_mesaPedidoPuntoVenta(Boolean mostrarid_mesaPedidoPuntoVenta) {
		this.mostrarid_mesaPedidoPuntoVenta= mostrarid_mesaPedidoPuntoVenta;
	}

	public Boolean getActivarid_mesaPedidoPuntoVenta() {
		return this.activarid_mesaPedidoPuntoVenta;
	}

	public void setActivarid_mesaPedidoPuntoVenta(Boolean activarid_mesaPedidoPuntoVenta) {
		this.activarid_mesaPedidoPuntoVenta= activarid_mesaPedidoPuntoVenta;
	}

	public Boolean getCargarid_mesaPedidoPuntoVenta() {
		return this.cargarid_mesaPedidoPuntoVenta;
	}

	public void setCargarid_mesaPedidoPuntoVenta(Boolean cargarid_mesaPedidoPuntoVenta) {
		this.cargarid_mesaPedidoPuntoVenta= cargarid_mesaPedidoPuntoVenta;
	}

	public Border setResaltarid_estado_pedido_punto_ventaPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedido_punto_ventaPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedido_punto_ventaPedidoPuntoVenta() {
		return this.resaltarid_estado_pedido_punto_ventaPedidoPuntoVenta;
	}

	public void setResaltarid_estado_pedido_punto_ventaPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarid_estado_pedido_punto_ventaPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedido_punto_ventaPedidoPuntoVenta() {
		return this.mostrarid_estado_pedido_punto_ventaPedidoPuntoVenta;
	}

	public void setMostrarid_estado_pedido_punto_ventaPedidoPuntoVenta(Boolean mostrarid_estado_pedido_punto_ventaPedidoPuntoVenta) {
		this.mostrarid_estado_pedido_punto_ventaPedidoPuntoVenta= mostrarid_estado_pedido_punto_ventaPedidoPuntoVenta;
	}

	public Boolean getActivarid_estado_pedido_punto_ventaPedidoPuntoVenta() {
		return this.activarid_estado_pedido_punto_ventaPedidoPuntoVenta;
	}

	public void setActivarid_estado_pedido_punto_ventaPedidoPuntoVenta(Boolean activarid_estado_pedido_punto_ventaPedidoPuntoVenta) {
		this.activarid_estado_pedido_punto_ventaPedidoPuntoVenta= activarid_estado_pedido_punto_ventaPedidoPuntoVenta;
	}

	public Boolean getCargarid_estado_pedido_punto_ventaPedidoPuntoVenta() {
		return this.cargarid_estado_pedido_punto_ventaPedidoPuntoVenta;
	}

	public void setCargarid_estado_pedido_punto_ventaPedidoPuntoVenta(Boolean cargarid_estado_pedido_punto_ventaPedidoPuntoVenta) {
		this.cargarid_estado_pedido_punto_ventaPedidoPuntoVenta= cargarid_estado_pedido_punto_ventaPedidoPuntoVenta;
	}

	public Border setResaltarnumero_secuencialPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialPedidoPuntoVenta() {
		return this.resaltarnumero_secuencialPedidoPuntoVenta;
	}

	public void setResaltarnumero_secuencialPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarnumero_secuencialPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialPedidoPuntoVenta() {
		return this.mostrarnumero_secuencialPedidoPuntoVenta;
	}

	public void setMostrarnumero_secuencialPedidoPuntoVenta(Boolean mostrarnumero_secuencialPedidoPuntoVenta) {
		this.mostrarnumero_secuencialPedidoPuntoVenta= mostrarnumero_secuencialPedidoPuntoVenta;
	}

	public Boolean getActivarnumero_secuencialPedidoPuntoVenta() {
		return this.activarnumero_secuencialPedidoPuntoVenta;
	}

	public void setActivarnumero_secuencialPedidoPuntoVenta(Boolean activarnumero_secuencialPedidoPuntoVenta) {
		this.activarnumero_secuencialPedidoPuntoVenta= activarnumero_secuencialPedidoPuntoVenta;
	}

	public Border setResaltarcodigo_clientePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarcodigo_clientePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_clientePedidoPuntoVenta() {
		return this.resaltarcodigo_clientePedidoPuntoVenta;
	}

	public void setResaltarcodigo_clientePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarcodigo_clientePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarcodigo_clientePedidoPuntoVenta() {
		return this.mostrarcodigo_clientePedidoPuntoVenta;
	}

	public void setMostrarcodigo_clientePedidoPuntoVenta(Boolean mostrarcodigo_clientePedidoPuntoVenta) {
		this.mostrarcodigo_clientePedidoPuntoVenta= mostrarcodigo_clientePedidoPuntoVenta;
	}

	public Boolean getActivarcodigo_clientePedidoPuntoVenta() {
		return this.activarcodigo_clientePedidoPuntoVenta;
	}

	public void setActivarcodigo_clientePedidoPuntoVenta(Boolean activarcodigo_clientePedidoPuntoVenta) {
		this.activarcodigo_clientePedidoPuntoVenta= activarcodigo_clientePedidoPuntoVenta;
	}

	public Border setResaltarnombre_clientePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarnombre_clientePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clientePedidoPuntoVenta() {
		return this.resaltarnombre_clientePedidoPuntoVenta;
	}

	public void setResaltarnombre_clientePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarnombre_clientePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnombre_clientePedidoPuntoVenta() {
		return this.mostrarnombre_clientePedidoPuntoVenta;
	}

	public void setMostrarnombre_clientePedidoPuntoVenta(Boolean mostrarnombre_clientePedidoPuntoVenta) {
		this.mostrarnombre_clientePedidoPuntoVenta= mostrarnombre_clientePedidoPuntoVenta;
	}

	public Boolean getActivarnombre_clientePedidoPuntoVenta() {
		return this.activarnombre_clientePedidoPuntoVenta;
	}

	public void setActivarnombre_clientePedidoPuntoVenta(Boolean activarnombre_clientePedidoPuntoVenta) {
		this.activarnombre_clientePedidoPuntoVenta= activarnombre_clientePedidoPuntoVenta;
	}

	public Border setResaltardireccion_clientePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardireccion_clientePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_clientePedidoPuntoVenta() {
		return this.resaltardireccion_clientePedidoPuntoVenta;
	}

	public void setResaltardireccion_clientePedidoPuntoVenta(Border borderResaltar) {
		this.resaltardireccion_clientePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardireccion_clientePedidoPuntoVenta() {
		return this.mostrardireccion_clientePedidoPuntoVenta;
	}

	public void setMostrardireccion_clientePedidoPuntoVenta(Boolean mostrardireccion_clientePedidoPuntoVenta) {
		this.mostrardireccion_clientePedidoPuntoVenta= mostrardireccion_clientePedidoPuntoVenta;
	}

	public Boolean getActivardireccion_clientePedidoPuntoVenta() {
		return this.activardireccion_clientePedidoPuntoVenta;
	}

	public void setActivardireccion_clientePedidoPuntoVenta(Boolean activardireccion_clientePedidoPuntoVenta) {
		this.activardireccion_clientePedidoPuntoVenta= activardireccion_clientePedidoPuntoVenta;
	}

	public Border setResaltartelefono_clientePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartelefono_clientePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_clientePedidoPuntoVenta() {
		return this.resaltartelefono_clientePedidoPuntoVenta;
	}

	public void setResaltartelefono_clientePedidoPuntoVenta(Border borderResaltar) {
		this.resaltartelefono_clientePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartelefono_clientePedidoPuntoVenta() {
		return this.mostrartelefono_clientePedidoPuntoVenta;
	}

	public void setMostrartelefono_clientePedidoPuntoVenta(Boolean mostrartelefono_clientePedidoPuntoVenta) {
		this.mostrartelefono_clientePedidoPuntoVenta= mostrartelefono_clientePedidoPuntoVenta;
	}

	public Boolean getActivartelefono_clientePedidoPuntoVenta() {
		return this.activartelefono_clientePedidoPuntoVenta;
	}

	public void setActivartelefono_clientePedidoPuntoVenta(Boolean activartelefono_clientePedidoPuntoVenta) {
		this.activartelefono_clientePedidoPuntoVenta= activartelefono_clientePedidoPuntoVenta;
	}

	public Border setResaltartarjeta_clientePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartarjeta_clientePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartarjeta_clientePedidoPuntoVenta() {
		return this.resaltartarjeta_clientePedidoPuntoVenta;
	}

	public void setResaltartarjeta_clientePedidoPuntoVenta(Border borderResaltar) {
		this.resaltartarjeta_clientePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartarjeta_clientePedidoPuntoVenta() {
		return this.mostrartarjeta_clientePedidoPuntoVenta;
	}

	public void setMostrartarjeta_clientePedidoPuntoVenta(Boolean mostrartarjeta_clientePedidoPuntoVenta) {
		this.mostrartarjeta_clientePedidoPuntoVenta= mostrartarjeta_clientePedidoPuntoVenta;
	}

	public Boolean getActivartarjeta_clientePedidoPuntoVenta() {
		return this.activartarjeta_clientePedidoPuntoVenta;
	}

	public void setActivartarjeta_clientePedidoPuntoVenta(Boolean activartarjeta_clientePedidoPuntoVenta) {
		this.activartarjeta_clientePedidoPuntoVenta= activartarjeta_clientePedidoPuntoVenta;
	}

	public Border setResaltarfechaPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarfechaPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPedidoPuntoVenta() {
		return this.resaltarfechaPedidoPuntoVenta;
	}

	public void setResaltarfechaPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarfechaPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfechaPedidoPuntoVenta() {
		return this.mostrarfechaPedidoPuntoVenta;
	}

	public void setMostrarfechaPedidoPuntoVenta(Boolean mostrarfechaPedidoPuntoVenta) {
		this.mostrarfechaPedidoPuntoVenta= mostrarfechaPedidoPuntoVenta;
	}

	public Boolean getActivarfechaPedidoPuntoVenta() {
		return this.activarfechaPedidoPuntoVenta;
	}

	public void setActivarfechaPedidoPuntoVenta(Boolean activarfechaPedidoPuntoVenta) {
		this.activarfechaPedidoPuntoVenta= activarfechaPedidoPuntoVenta;
	}

	public Border setResaltarhoraPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarhoraPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoraPedidoPuntoVenta() {
		return this.resaltarhoraPedidoPuntoVenta;
	}

	public void setResaltarhoraPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarhoraPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarhoraPedidoPuntoVenta() {
		return this.mostrarhoraPedidoPuntoVenta;
	}

	public void setMostrarhoraPedidoPuntoVenta(Boolean mostrarhoraPedidoPuntoVenta) {
		this.mostrarhoraPedidoPuntoVenta= mostrarhoraPedidoPuntoVenta;
	}

	public Boolean getActivarhoraPedidoPuntoVenta() {
		return this.activarhoraPedidoPuntoVenta;
	}

	public void setActivarhoraPedidoPuntoVenta(Boolean activarhoraPedidoPuntoVenta) {
		this.activarhoraPedidoPuntoVenta= activarhoraPedidoPuntoVenta;
	}

	public Border setResaltarsub_totalPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarsub_totalPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalPedidoPuntoVenta() {
		return this.resaltarsub_totalPedidoPuntoVenta;
	}

	public void setResaltarsub_totalPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarsub_totalPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarsub_totalPedidoPuntoVenta() {
		return this.mostrarsub_totalPedidoPuntoVenta;
	}

	public void setMostrarsub_totalPedidoPuntoVenta(Boolean mostrarsub_totalPedidoPuntoVenta) {
		this.mostrarsub_totalPedidoPuntoVenta= mostrarsub_totalPedidoPuntoVenta;
	}

	public Boolean getActivarsub_totalPedidoPuntoVenta() {
		return this.activarsub_totalPedidoPuntoVenta;
	}

	public void setActivarsub_totalPedidoPuntoVenta(Boolean activarsub_totalPedidoPuntoVenta) {
		this.activarsub_totalPedidoPuntoVenta= activarsub_totalPedidoPuntoVenta;
	}

	public Border setResaltarivaPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarivaPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaPedidoPuntoVenta() {
		return this.resaltarivaPedidoPuntoVenta;
	}

	public void setResaltarivaPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarivaPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarivaPedidoPuntoVenta() {
		return this.mostrarivaPedidoPuntoVenta;
	}

	public void setMostrarivaPedidoPuntoVenta(Boolean mostrarivaPedidoPuntoVenta) {
		this.mostrarivaPedidoPuntoVenta= mostrarivaPedidoPuntoVenta;
	}

	public Boolean getActivarivaPedidoPuntoVenta() {
		return this.activarivaPedidoPuntoVenta;
	}

	public void setActivarivaPedidoPuntoVenta(Boolean activarivaPedidoPuntoVenta) {
		this.activarivaPedidoPuntoVenta= activarivaPedidoPuntoVenta;
	}

	public Border setResaltaricePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaricePedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaricePedidoPuntoVenta() {
		return this.resaltaricePedidoPuntoVenta;
	}

	public void setResaltaricePedidoPuntoVenta(Border borderResaltar) {
		this.resaltaricePedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostraricePedidoPuntoVenta() {
		return this.mostraricePedidoPuntoVenta;
	}

	public void setMostraricePedidoPuntoVenta(Boolean mostraricePedidoPuntoVenta) {
		this.mostraricePedidoPuntoVenta= mostraricePedidoPuntoVenta;
	}

	public Boolean getActivaricePedidoPuntoVenta() {
		return this.activaricePedidoPuntoVenta;
	}

	public void setActivaricePedidoPuntoVenta(Boolean activaricePedidoPuntoVenta) {
		this.activaricePedidoPuntoVenta= activaricePedidoPuntoVenta;
	}

	public Border setResaltardescuentoPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltardescuentoPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoPedidoPuntoVenta() {
		return this.resaltardescuentoPedidoPuntoVenta;
	}

	public void setResaltardescuentoPedidoPuntoVenta(Border borderResaltar) {
		this.resaltardescuentoPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescuentoPedidoPuntoVenta() {
		return this.mostrardescuentoPedidoPuntoVenta;
	}

	public void setMostrardescuentoPedidoPuntoVenta(Boolean mostrardescuentoPedidoPuntoVenta) {
		this.mostrardescuentoPedidoPuntoVenta= mostrardescuentoPedidoPuntoVenta;
	}

	public Boolean getActivardescuentoPedidoPuntoVenta() {
		return this.activardescuentoPedidoPuntoVenta;
	}

	public void setActivardescuentoPedidoPuntoVenta(Boolean activardescuentoPedidoPuntoVenta) {
		this.activardescuentoPedidoPuntoVenta= activardescuentoPedidoPuntoVenta;
	}

	public Border setResaltartotalPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltartotalPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalPedidoPuntoVenta() {
		return this.resaltartotalPedidoPuntoVenta;
	}

	public void setResaltartotalPedidoPuntoVenta(Border borderResaltar) {
		this.resaltartotalPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartotalPedidoPuntoVenta() {
		return this.mostrartotalPedidoPuntoVenta;
	}

	public void setMostrartotalPedidoPuntoVenta(Boolean mostrartotalPedidoPuntoVenta) {
		this.mostrartotalPedidoPuntoVenta= mostrartotalPedidoPuntoVenta;
	}

	public Boolean getActivartotalPedidoPuntoVenta() {
		return this.activartotalPedidoPuntoVenta;
	}

	public void setActivartotalPedidoPuntoVenta(Boolean activartotalPedidoPuntoVenta) {
		this.activartotalPedidoPuntoVenta= activartotalPedidoPuntoVenta;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridPedidoPuntoVenta(esInicial);
		this.setMostrarid_empresaPedidoPuntoVenta(esInicial);
		this.setMostrarid_sucursalPedidoPuntoVenta(esInicial);
		this.setMostrarid_usuarioPedidoPuntoVenta(esInicial);
		this.setMostrarid_vendedorPedidoPuntoVenta(esInicial);
		this.setMostrarid_cajaPedidoPuntoVenta(esInicial);
		this.setMostrarid_clientePedidoPuntoVenta(esInicial);
		this.setMostrarid_tipo_precioPedidoPuntoVenta(esInicial);
		this.setMostrarid_mesaPedidoPuntoVenta(esInicial);
		this.setMostrarid_estado_pedido_punto_ventaPedidoPuntoVenta(esInicial);
		this.setMostrarnumero_secuencialPedidoPuntoVenta(esInicial);
		this.setMostrarcodigo_clientePedidoPuntoVenta(esInicial);
		this.setMostrarnombre_clientePedidoPuntoVenta(esInicial);
		this.setMostrardireccion_clientePedidoPuntoVenta(esInicial);
		this.setMostrartelefono_clientePedidoPuntoVenta(esInicial);
		this.setMostrartarjeta_clientePedidoPuntoVenta(esInicial);
		this.setMostrarfechaPedidoPuntoVenta(esInicial);
		this.setMostrarhoraPedidoPuntoVenta(esInicial);
		this.setMostrarsub_totalPedidoPuntoVenta(esInicial);
		this.setMostrarivaPedidoPuntoVenta(esInicial);
		this.setMostraricePedidoPuntoVenta(esInicial);
		this.setMostrardescuentoPedidoPuntoVenta(esInicial);
		this.setMostrartotalPedidoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDMESA)) {
				this.setMostrarid_mesaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA)) {
				this.setMostrarid_estado_pedido_punto_ventaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.NUMERO_SECUENCIAL)) {
				this.setMostrarnumero_secuencialPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {
				this.setMostrarcodigo_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setMostrardireccion_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {
				this.setMostrartelefono_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.TARJETACLIENTE)) {
				this.setMostrartarjeta_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.FECHA)) {
				this.setMostrarfechaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.HORA)) {
				this.setMostrarhoraPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IVA)) {
				this.setMostrarivaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.ICE)) {
				this.setMostraricePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setMostrartotalPedidoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridPedidoPuntoVenta(esInicial);
		this.setActivarid_empresaPedidoPuntoVenta(esInicial);
		this.setActivarid_sucursalPedidoPuntoVenta(esInicial);
		this.setActivarid_usuarioPedidoPuntoVenta(esInicial);
		this.setActivarid_vendedorPedidoPuntoVenta(esInicial);
		this.setActivarid_cajaPedidoPuntoVenta(esInicial);
		this.setActivarid_clientePedidoPuntoVenta(esInicial);
		this.setActivarid_tipo_precioPedidoPuntoVenta(esInicial);
		this.setActivarid_mesaPedidoPuntoVenta(esInicial);
		this.setActivarid_estado_pedido_punto_ventaPedidoPuntoVenta(esInicial);
		this.setActivarnumero_secuencialPedidoPuntoVenta(esInicial);
		this.setActivarcodigo_clientePedidoPuntoVenta(esInicial);
		this.setActivarnombre_clientePedidoPuntoVenta(esInicial);
		this.setActivardireccion_clientePedidoPuntoVenta(esInicial);
		this.setActivartelefono_clientePedidoPuntoVenta(esInicial);
		this.setActivartarjeta_clientePedidoPuntoVenta(esInicial);
		this.setActivarfechaPedidoPuntoVenta(esInicial);
		this.setActivarhoraPedidoPuntoVenta(esInicial);
		this.setActivarsub_totalPedidoPuntoVenta(esInicial);
		this.setActivarivaPedidoPuntoVenta(esInicial);
		this.setActivaricePedidoPuntoVenta(esInicial);
		this.setActivardescuentoPedidoPuntoVenta(esInicial);
		this.setActivartotalPedidoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDMESA)) {
				this.setActivarid_mesaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA)) {
				this.setActivarid_estado_pedido_punto_ventaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.NUMERO_SECUENCIAL)) {
				this.setActivarnumero_secuencialPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {
				this.setActivarcodigo_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setActivardireccion_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {
				this.setActivartelefono_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.TARJETACLIENTE)) {
				this.setActivartarjeta_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.FECHA)) {
				this.setActivarfechaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.HORA)) {
				this.setActivarhoraPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IVA)) {
				this.setActivarivaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.ICE)) {
				this.setActivaricePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setActivartotalPedidoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPedidoPuntoVenta(esInicial);
		this.setResaltarid_empresaPedidoPuntoVenta(esInicial);
		this.setResaltarid_sucursalPedidoPuntoVenta(esInicial);
		this.setResaltarid_usuarioPedidoPuntoVenta(esInicial);
		this.setResaltarid_vendedorPedidoPuntoVenta(esInicial);
		this.setResaltarid_cajaPedidoPuntoVenta(esInicial);
		this.setResaltarid_clientePedidoPuntoVenta(esInicial);
		this.setResaltarid_tipo_precioPedidoPuntoVenta(esInicial);
		this.setResaltarid_mesaPedidoPuntoVenta(esInicial);
		this.setResaltarid_estado_pedido_punto_ventaPedidoPuntoVenta(esInicial);
		this.setResaltarnumero_secuencialPedidoPuntoVenta(esInicial);
		this.setResaltarcodigo_clientePedidoPuntoVenta(esInicial);
		this.setResaltarnombre_clientePedidoPuntoVenta(esInicial);
		this.setResaltardireccion_clientePedidoPuntoVenta(esInicial);
		this.setResaltartelefono_clientePedidoPuntoVenta(esInicial);
		this.setResaltartarjeta_clientePedidoPuntoVenta(esInicial);
		this.setResaltarfechaPedidoPuntoVenta(esInicial);
		this.setResaltarhoraPedidoPuntoVenta(esInicial);
		this.setResaltarsub_totalPedidoPuntoVenta(esInicial);
		this.setResaltarivaPedidoPuntoVenta(esInicial);
		this.setResaltaricePedidoPuntoVenta(esInicial);
		this.setResaltardescuentoPedidoPuntoVenta(esInicial);
		this.setResaltartotalPedidoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDMESA)) {
				this.setResaltarid_mesaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA)) {
				this.setResaltarid_estado_pedido_punto_ventaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.NUMERO_SECUENCIAL)) {
				this.setResaltarnumero_secuencialPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.CODIGOCLIENTE)) {
				this.setResaltarcodigo_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setResaltardireccion_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.TELEFONOCLIENTE)) {
				this.setResaltartelefono_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.TARJETACLIENTE)) {
				this.setResaltartarjeta_clientePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.FECHA)) {
				this.setResaltarfechaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.HORA)) {
				this.setResaltarhoraPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.IVA)) {
				this.setResaltarivaPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.ICE)) {
				this.setResaltaricePedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidoPuntoVentaConstantesFunciones.TOTAL)) {
				this.setResaltartotalPedidoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetallePedidoPuntoVentaPedidoPuntoVenta=null;

	public Border getResaltarDetallePedidoPuntoVentaPedidoPuntoVenta() {
		return this.resaltarDetallePedidoPuntoVentaPedidoPuntoVenta;
	}

	public void setResaltarDetallePedidoPuntoVentaPedidoPuntoVenta(Border borderResaltarDetallePedidoPuntoVenta) {
		if(borderResaltarDetallePedidoPuntoVenta!=null) {
			this.resaltarDetallePedidoPuntoVentaPedidoPuntoVenta= borderResaltarDetallePedidoPuntoVenta;
		}
	}

	public Border setResaltarDetallePedidoPuntoVentaPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetallePedidoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//pedidopuntoventaBeanSwingJInternalFrame.jTtoolBarPedidoPuntoVenta.setBorder(borderResaltarDetallePedidoPuntoVenta);
			
		this.resaltarDetallePedidoPuntoVentaPedidoPuntoVenta= borderResaltarDetallePedidoPuntoVenta;

		 return borderResaltarDetallePedidoPuntoVenta;
	}



	public Boolean mostrarDetallePedidoPuntoVentaPedidoPuntoVenta=true;

	public Boolean getMostrarDetallePedidoPuntoVentaPedidoPuntoVenta() {
		return this.mostrarDetallePedidoPuntoVentaPedidoPuntoVenta;
	}

	public void setMostrarDetallePedidoPuntoVentaPedidoPuntoVenta(Boolean visibilidadResaltarDetallePedidoPuntoVenta) {
		this.mostrarDetallePedidoPuntoVentaPedidoPuntoVenta= visibilidadResaltarDetallePedidoPuntoVenta;
	}



	public Boolean activarDetallePedidoPuntoVentaPedidoPuntoVenta=true;

	public Boolean gethabilitarResaltarDetallePedidoPuntoVentaPedidoPuntoVenta() {
		return this.activarDetallePedidoPuntoVentaPedidoPuntoVenta;
	}

	public void setActivarDetallePedidoPuntoVentaPedidoPuntoVenta(Boolean habilitarResaltarDetallePedidoPuntoVenta) {
		this.activarDetallePedidoPuntoVentaPedidoPuntoVenta= habilitarResaltarDetallePedidoPuntoVenta;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarDetallePedidoPuntoVentaPedidoPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoPuntoVenta.class)) {
				this.setMostrarDetallePedidoPuntoVentaPedidoPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarDetallePedidoPuntoVentaPedidoPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoPuntoVenta.class)) {
				this.setActivarDetallePedidoPuntoVentaPedidoPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetallePedidoPuntoVentaPedidoPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePedidoPuntoVenta.class)) {
				this.setResaltarDetallePedidoPuntoVentaPedidoPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCajaPedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdCajaPedidoPuntoVenta() {
		return this.mostrarFK_IdCajaPedidoPuntoVenta;
	}

	public void setMostrarFK_IdCajaPedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCajaPedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClientePedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdClientePedidoPuntoVenta() {
		return this.mostrarFK_IdClientePedidoPuntoVenta;
	}

	public void setMostrarFK_IdClientePedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClientePedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdEmpresaPedidoPuntoVenta() {
		return this.mostrarFK_IdEmpresaPedidoPuntoVenta;
	}

	public void setMostrarFK_IdEmpresaPedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta() {
		return this.mostrarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta;
	}

	public void setMostrarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesaPedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdMesaPedidoPuntoVenta() {
		return this.mostrarFK_IdMesaPedidoPuntoVenta;
	}

	public void setMostrarFK_IdMesaPedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesaPedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdSucursalPedidoPuntoVenta() {
		return this.mostrarFK_IdSucursalPedidoPuntoVenta;
	}

	public void setMostrarFK_IdSucursalPedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioPedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdTipoPrecioPedidoPuntoVenta() {
		return this.mostrarFK_IdTipoPrecioPedidoPuntoVenta;
	}

	public void setMostrarFK_IdTipoPrecioPedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioPedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioPedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdUsuarioPedidoPuntoVenta() {
		return this.mostrarFK_IdUsuarioPedidoPuntoVenta;
	}

	public void setMostrarFK_IdUsuarioPedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioPedidoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorPedidoPuntoVenta=true;

	public Boolean getMostrarFK_IdVendedorPedidoPuntoVenta() {
		return this.mostrarFK_IdVendedorPedidoPuntoVenta;
	}

	public void setMostrarFK_IdVendedorPedidoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorPedidoPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCajaPedidoPuntoVenta=true;

	public Boolean getActivarFK_IdCajaPedidoPuntoVenta() {
		return this.activarFK_IdCajaPedidoPuntoVenta;
	}

	public void setActivarFK_IdCajaPedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdCajaPedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdClientePedidoPuntoVenta=true;

	public Boolean getActivarFK_IdClientePedidoPuntoVenta() {
		return this.activarFK_IdClientePedidoPuntoVenta;
	}

	public void setActivarFK_IdClientePedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdClientePedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPedidoPuntoVenta=true;

	public Boolean getActivarFK_IdEmpresaPedidoPuntoVenta() {
		return this.activarFK_IdEmpresaPedidoPuntoVenta;
	}

	public void setActivarFK_IdEmpresaPedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta=true;

	public Boolean getActivarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta() {
		return this.activarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta;
	}

	public void setActivarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdMesaPedidoPuntoVenta=true;

	public Boolean getActivarFK_IdMesaPedidoPuntoVenta() {
		return this.activarFK_IdMesaPedidoPuntoVenta;
	}

	public void setActivarFK_IdMesaPedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdMesaPedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPedidoPuntoVenta=true;

	public Boolean getActivarFK_IdSucursalPedidoPuntoVenta() {
		return this.activarFK_IdSucursalPedidoPuntoVenta;
	}

	public void setActivarFK_IdSucursalPedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioPedidoPuntoVenta=true;

	public Boolean getActivarFK_IdTipoPrecioPedidoPuntoVenta() {
		return this.activarFK_IdTipoPrecioPedidoPuntoVenta;
	}

	public void setActivarFK_IdTipoPrecioPedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioPedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioPedidoPuntoVenta=true;

	public Boolean getActivarFK_IdUsuarioPedidoPuntoVenta() {
		return this.activarFK_IdUsuarioPedidoPuntoVenta;
	}

	public void setActivarFK_IdUsuarioPedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioPedidoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorPedidoPuntoVenta=true;

	public Boolean getActivarFK_IdVendedorPedidoPuntoVenta() {
		return this.activarFK_IdVendedorPedidoPuntoVenta;
	}

	public void setActivarFK_IdVendedorPedidoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorPedidoPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCajaPedidoPuntoVenta=null;

	public Border getResaltarFK_IdCajaPedidoPuntoVenta() {
		return this.resaltarFK_IdCajaPedidoPuntoVenta;
	}

	public void setResaltarFK_IdCajaPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdCajaPedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdCajaPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCajaPedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdClientePedidoPuntoVenta=null;

	public Border getResaltarFK_IdClientePedidoPuntoVenta() {
		return this.resaltarFK_IdClientePedidoPuntoVenta;
	}

	public void setResaltarFK_IdClientePedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdClientePedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdClientePedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClientePedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPedidoPuntoVenta=null;

	public Border getResaltarFK_IdEmpresaPedidoPuntoVenta() {
		return this.resaltarFK_IdEmpresaPedidoPuntoVenta;
	}

	public void setResaltarFK_IdEmpresaPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta=null;

	public Border getResaltarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta() {
		return this.resaltarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta;
	}

	public void setResaltarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoPuntoVentaPedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdMesaPedidoPuntoVenta=null;

	public Border getResaltarFK_IdMesaPedidoPuntoVenta() {
		return this.resaltarFK_IdMesaPedidoPuntoVenta;
	}

	public void setResaltarFK_IdMesaPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdMesaPedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdMesaPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesaPedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPedidoPuntoVenta=null;

	public Border getResaltarFK_IdSucursalPedidoPuntoVenta() {
		return this.resaltarFK_IdSucursalPedidoPuntoVenta;
	}

	public void setResaltarFK_IdSucursalPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdSucursalPedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioPedidoPuntoVenta=null;

	public Border getResaltarFK_IdTipoPrecioPedidoPuntoVenta() {
		return this.resaltarFK_IdTipoPrecioPedidoPuntoVenta;
	}

	public void setResaltarFK_IdTipoPrecioPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioPedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioPedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioPedidoPuntoVenta=null;

	public Border getResaltarFK_IdUsuarioPedidoPuntoVenta() {
		return this.resaltarFK_IdUsuarioPedidoPuntoVenta;
	}

	public void setResaltarFK_IdUsuarioPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdUsuarioPedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioPedidoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdVendedorPedidoPuntoVenta=null;

	public Border getResaltarFK_IdVendedorPedidoPuntoVenta() {
		return this.resaltarFK_IdVendedorPedidoPuntoVenta;
	}

	public void setResaltarFK_IdVendedorPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdVendedorPedidoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdVendedorPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*PedidoPuntoVentaBeanSwingJInternalFrame pedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorPedidoPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}