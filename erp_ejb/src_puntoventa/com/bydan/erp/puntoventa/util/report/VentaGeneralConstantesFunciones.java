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
package com.bydan.erp.puntoventa.util.report;

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


import com.bydan.erp.puntoventa.util.report.VentaGeneralConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.VentaGeneralParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.VentaGeneralParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
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
final public class VentaGeneralConstantesFunciones{		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="VentaGeneral";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VentaGeneral"+VentaGeneralConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VentaGeneralHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VentaGeneralHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VentaGeneralConstantesFunciones.SCHEMA+"_"+VentaGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VentaGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VentaGeneralConstantesFunciones.SCHEMA+"_"+VentaGeneralConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VentaGeneralConstantesFunciones.SCHEMA+"_"+VentaGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VentaGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VentaGeneralConstantesFunciones.SCHEMA+"_"+VentaGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentaGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentaGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentaGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentaGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentaGeneralHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentaGeneralConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VentaGeneralConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VentaGeneralConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VentaGeneralConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VentaGeneralConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Venta Generales";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Venta General";
	public static final String SCLASSWEBTITULO_LOWER="Venta General";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VentaGeneral";
	public static final String OBJECTNAME="ventageneral";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="venta_general";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ventageneral from "+VentaGeneralConstantesFunciones.SPERSISTENCENAME+" ventageneral";
	public static String QUERYSELECTNATIVE="select "+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".id,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".version_row,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".id_empresa,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".id_sucursal,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".id_cliente,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".id_producto,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".fecha_desde,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".fecha_hasta,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".nombre_producto,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".nombre_cliente,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".fecha,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".secuencial,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".cantidad,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".precio,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".descuento,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".iva,"+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME+".ice from "+VentaGeneralConstantesFunciones.SCHEMA+"."+VentaGeneralConstantesFunciones.TABLENAME;//+" as "+VentaGeneralConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDPRODUCTO= "id_producto";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String FECHA= "fecha";
    public static final String SECUENCIAL= "secuencial";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String DESCUENTO= "descuento";
    public static final String IVA= "iva";
    public static final String ICE= "ice";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getVentaGeneralLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.IDEMPRESA)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.IDSUCURSAL)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.IDCLIENTE)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.IDPRODUCTO)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.FECHADESDE)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.FECHAHASTA)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.FECHA)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.SECUENCIAL)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.CANTIDAD)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.PRECIO)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.DESCUENTO)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.IVA)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(VentaGeneralConstantesFunciones.ICE)) {sLabelColumna=VentaGeneralConstantesFunciones.LABEL_ICE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVentaGeneralDescripcion(VentaGeneral ventageneral) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ventageneral !=null/* && ventageneral.getId()!=0*/) {
			if(ventageneral.getId()!=null) {
				sDescripcion=ventageneral.getId().toString();
			}//ventageneralventageneral.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVentaGeneralDescripcionDetallado(VentaGeneral ventageneral) {
		String sDescripcion="";
			
		sDescripcion+=VentaGeneralConstantesFunciones.ID+"=";
		sDescripcion+=ventageneral.getId().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ventageneral.getVersionRow().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ventageneral.getid_empresa().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ventageneral.getid_sucursal().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=ventageneral.getid_cliente().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=ventageneral.getid_producto().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=ventageneral.getfecha_desde().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=ventageneral.getfecha_hasta().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=ventageneral.getnombre_producto()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=ventageneral.getnombre_cliente()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.FECHA+"=";
		sDescripcion+=ventageneral.getfecha().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=ventageneral.getsecuencial()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=ventageneral.getcantidad().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.PRECIO+"=";
		sDescripcion+=ventageneral.getprecio().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=ventageneral.getdescuento().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.IVA+"=";
		sDescripcion+=ventageneral.getiva().toString()+",";
		sDescripcion+=VentaGeneralConstantesFunciones.ICE+"=";
		sDescripcion+=ventageneral.getice().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVentaGeneralDescripcion(VentaGeneral ventageneral,String sValor) throws Exception {			
		if(ventageneral !=null) {
			//ventageneralventageneral.getId().toString();
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaVentaGeneral")) {
			sNombreIndice="Tipo=  Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaVentaGeneral(Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

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

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVentaGeneral(VentaGeneral ventageneral,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventageneral.setnombre_producto(ventageneral.getnombre_producto().trim());
		ventageneral.setnombre_cliente(ventageneral.getnombre_cliente().trim());
		ventageneral.setsecuencial(ventageneral.getsecuencial().trim());
	}
	
	public static void quitarEspaciosVentaGenerals(List<VentaGeneral> ventagenerals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentaGeneral ventageneral: ventagenerals) {
			ventageneral.setnombre_producto(ventageneral.getnombre_producto().trim());
			ventageneral.setnombre_cliente(ventageneral.getnombre_cliente().trim());
			ventageneral.setsecuencial(ventageneral.getsecuencial().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentaGeneral(VentaGeneral ventageneral,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ventageneral.getConCambioAuxiliar()) {
			ventageneral.setIsDeleted(ventageneral.getIsDeletedAuxiliar());	
			ventageneral.setIsNew(ventageneral.getIsNewAuxiliar());	
			ventageneral.setIsChanged(ventageneral.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ventageneral.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ventageneral.setIsDeletedAuxiliar(false);	
			ventageneral.setIsNewAuxiliar(false);	
			ventageneral.setIsChangedAuxiliar(false);
			
			ventageneral.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentaGenerals(List<VentaGeneral> ventagenerals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VentaGeneral ventageneral : ventagenerals) {
			if(conAsignarBase && ventageneral.getConCambioAuxiliar()) {
				ventageneral.setIsDeleted(ventageneral.getIsDeletedAuxiliar());	
				ventageneral.setIsNew(ventageneral.getIsNewAuxiliar());	
				ventageneral.setIsChanged(ventageneral.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ventageneral.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ventageneral.setIsDeletedAuxiliar(false);	
				ventageneral.setIsNewAuxiliar(false);	
				ventageneral.setIsChangedAuxiliar(false);
				
				ventageneral.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVentaGeneral(VentaGeneral ventageneral,Boolean conEnteros) throws Exception  {
		ventageneral.setcantidad(0.0);
		ventageneral.setprecio(0.0);
		ventageneral.setdescuento(0.0);
		ventageneral.setiva(0.0);
		ventageneral.setice(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVentaGenerals(List<VentaGeneral> ventagenerals,Boolean conEnteros) throws Exception  {
		
		for(VentaGeneral ventageneral: ventagenerals) {
			ventageneral.setcantidad(0.0);
			ventageneral.setprecio(0.0);
			ventageneral.setdescuento(0.0);
			ventageneral.setiva(0.0);
			ventageneral.setice(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVentaGeneral(List<VentaGeneral> ventagenerals,VentaGeneral ventageneralAux) throws Exception  {
		VentaGeneralConstantesFunciones.InicializarValoresVentaGeneral(ventageneralAux,true);
		
		for(VentaGeneral ventageneral: ventagenerals) {
			if(ventageneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ventageneralAux.setcantidad(ventageneralAux.getcantidad()+ventageneral.getcantidad());			
			ventageneralAux.setprecio(ventageneralAux.getprecio()+ventageneral.getprecio());			
			ventageneralAux.setdescuento(ventageneralAux.getdescuento()+ventageneral.getdescuento());			
			ventageneralAux.setiva(ventageneralAux.getiva()+ventageneral.getiva());			
			ventageneralAux.setice(ventageneralAux.getice()+ventageneral.getice());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentaGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VentaGeneralConstantesFunciones.getArrayColumnasGlobalesVentaGeneral(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVentaGeneral(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentaGeneralConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentaGeneralConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentaGeneralConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentaGeneralConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVentaGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentaGeneral> ventagenerals,VentaGeneral ventageneral,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentaGeneral ventageneralAux: ventagenerals) {
			if(ventageneralAux!=null && ventageneral!=null) {
				if((ventageneralAux.getId()==null && ventageneral.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ventageneralAux.getId()!=null && ventageneral.getId()!=null){
					if(ventageneralAux.getId().equals(ventageneral.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentaGeneral(List<VentaGeneral> ventagenerals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cantidadTotal=0.0;
		Double precioTotal=0.0;
		Double descuentoTotal=0.0;
		Double ivaTotal=0.0;
		Double iceTotal=0.0;
	
		for(VentaGeneral ventageneral: ventagenerals) {			
			if(ventageneral.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cantidadTotal+=ventageneral.getcantidad();
			precioTotal+=ventageneral.getprecio();
			descuentoTotal+=ventageneral.getdescuento();
			ivaTotal+=ventageneral.getiva();
			iceTotal+=ventageneral.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaGeneralConstantesFunciones.CANTIDAD);
		datoGeneral.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_CANTIDAD);
		datoGeneral.setdValorDouble(cantidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaGeneralConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaGeneralConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaGeneralConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaGeneralConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVentaGeneral() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_ID, VentaGeneralConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_VERSIONROW, VentaGeneralConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_IDCLIENTE, VentaGeneralConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_IDPRODUCTO, VentaGeneralConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_NOMBREPRODUCTO, VentaGeneralConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_NOMBRECLIENTE, VentaGeneralConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_FECHA, VentaGeneralConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_SECUENCIAL, VentaGeneralConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_CANTIDAD, VentaGeneralConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_PRECIO, VentaGeneralConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_DESCUENTO, VentaGeneralConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_IVA, VentaGeneralConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaGeneralConstantesFunciones.LABEL_ICE, VentaGeneralConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVentaGeneral() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaGeneralConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentaGeneral() throws Exception  {
		return VentaGeneralConstantesFunciones.getTiposSeleccionarVentaGeneral(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentaGeneral(Boolean conFk) throws Exception  {
		return VentaGeneralConstantesFunciones.getTiposSeleccionarVentaGeneral(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentaGeneral(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaGeneralConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVentaGeneral(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVentaGeneral(VentaGeneral ventageneralAux) throws Exception {
		
			ventageneralAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventageneralAux.getEmpresa()));
			ventageneralAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventageneralAux.getSucursal()));
			ventageneralAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(ventageneralAux.getCliente()));
			ventageneralAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ventageneralAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVentaGeneral(List<VentaGeneral> ventageneralsTemp) throws Exception {
		for(VentaGeneral ventageneralAux:ventageneralsTemp) {
			
			ventageneralAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventageneralAux.getEmpresa()));
			ventageneralAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventageneralAux.getSucursal()));
			ventageneralAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(ventageneralAux.getCliente()));
			ventageneralAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ventageneralAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVentaGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Producto.class));
				
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVentaGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentaGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentaGeneralConstantesFunciones.getClassesRelationshipsOfVentaGeneral(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentaGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentaGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentaGeneralConstantesFunciones.getClassesRelationshipsFromStringsOfVentaGeneral(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentaGeneral(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(VentaGeneral ventageneral,List<VentaGeneral> ventagenerals,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(VentaGeneral ventageneral,List<VentaGeneral> ventagenerals) throws Exception {
		try	{			
			for(VentaGeneral ventageneralLocal:ventagenerals) {
				if(ventageneralLocal.getId().equals(ventageneral.getId())) {
					ventageneralLocal.setIsSelected(ventageneral.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVentaGeneral(List<VentaGeneral> ventageneralsAux) throws Exception {
		//this.ventageneralsAux=ventageneralsAux;
		
		for(VentaGeneral ventageneralAux:ventageneralsAux) {
			if(ventageneralAux.getIsChanged()) {
				ventageneralAux.setIsChanged(false);
			}		
			
			if(ventageneralAux.getIsNew()) {
				ventageneralAux.setIsNew(false);
			}	
			
			if(ventageneralAux.getIsDeleted()) {
				ventageneralAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVentaGeneral(VentaGeneral ventageneralAux) throws Exception {
		//this.ventageneralAux=ventageneralAux;
		
			if(ventageneralAux.getIsChanged()) {
				ventageneralAux.setIsChanged(false);
			}		
			
			if(ventageneralAux.getIsNew()) {
				ventageneralAux.setIsNew(false);
			}	
			
			if(ventageneralAux.getIsDeleted()) {
				ventageneralAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VentaGeneral ventageneralAsignar,VentaGeneral ventageneral) throws Exception {
		ventageneralAsignar.setId(ventageneral.getId());	
		ventageneralAsignar.setVersionRow(ventageneral.getVersionRow());	
		ventageneralAsignar.setid_cliente(ventageneral.getid_cliente());
		ventageneralAsignar.setcliente_descripcion(ventageneral.getcliente_descripcion());	
		ventageneralAsignar.setid_producto(ventageneral.getid_producto());
		ventageneralAsignar.setproducto_descripcion(ventageneral.getproducto_descripcion());	
		ventageneralAsignar.setnombre_producto(ventageneral.getnombre_producto());	
		ventageneralAsignar.setnombre_cliente(ventageneral.getnombre_cliente());	
		ventageneralAsignar.setfecha(ventageneral.getfecha());	
		ventageneralAsignar.setsecuencial(ventageneral.getsecuencial());	
		ventageneralAsignar.setcantidad(ventageneral.getcantidad());	
		ventageneralAsignar.setprecio(ventageneral.getprecio());	
		ventageneralAsignar.setdescuento(ventageneral.getdescuento());	
		ventageneralAsignar.setiva(ventageneral.getiva());	
		ventageneralAsignar.setice(ventageneral.getice());	
	}
	
	public static void inicializarVentaGeneral(VentaGeneral ventageneral) throws Exception {
		try {
				ventageneral.setId(0L);	
					
				ventageneral.setid_cliente(-1L);	
				ventageneral.setid_producto(-1L);	
				ventageneral.setnombre_producto("");	
				ventageneral.setnombre_cliente("");	
				ventageneral.setfecha(new Date());	
				ventageneral.setsecuencial("");	
				ventageneral.setcantidad(0.0);	
				ventageneral.setprecio(0.0);	
				ventageneral.setdescuento(0.0);	
				ventageneral.setiva(0.0);	
				ventageneral.setice(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVentaGeneral(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaGeneralConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVentaGeneral(String sTipo,Row row,Workbook workbook,VentaGeneral ventageneral,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventageneral.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVentaGeneral="";
	
	public String getsFinalQueryVentaGeneral() {
		return this.sFinalQueryVentaGeneral;
	}
	
	public void setsFinalQueryVentaGeneral(String sFinalQueryVentaGeneral) {
		this.sFinalQueryVentaGeneral= sFinalQueryVentaGeneral;
	}
	
	public Border resaltarSeleccionarVentaGeneral=null;
	
	public Border setResaltarSeleccionarVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVentaGeneral= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVentaGeneral() {
		return this.resaltarSeleccionarVentaGeneral;
	}
	
	public void setResaltarSeleccionarVentaGeneral(Border borderResaltarSeleccionarVentaGeneral) {
		this.resaltarSeleccionarVentaGeneral= borderResaltarSeleccionarVentaGeneral;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVentaGeneral=null;
	public Boolean mostraridVentaGeneral=true;
	public Boolean activaridVentaGeneral=true;

	public Border resaltarid_empresaVentaGeneral=null;
	public Boolean mostrarid_empresaVentaGeneral=true;
	public Boolean activarid_empresaVentaGeneral=true;
	public Boolean cargarid_empresaVentaGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVentaGeneral=false;//ConEventDepend=true

	public Border resaltarid_sucursalVentaGeneral=null;
	public Boolean mostrarid_sucursalVentaGeneral=true;
	public Boolean activarid_sucursalVentaGeneral=true;
	public Boolean cargarid_sucursalVentaGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalVentaGeneral=false;//ConEventDepend=true

	public Border resaltarid_clienteVentaGeneral=null;
	public Boolean mostrarid_clienteVentaGeneral=true;
	public Boolean activarid_clienteVentaGeneral=false;
	public Boolean cargarid_clienteVentaGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteVentaGeneral=false;//ConEventDepend=true

	public Border resaltarid_productoVentaGeneral=null;
	public Boolean mostrarid_productoVentaGeneral=true;
	public Boolean activarid_productoVentaGeneral=false;
	public Boolean cargarid_productoVentaGeneral=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoVentaGeneral=false;//ConEventDepend=true

	public Border resaltarfecha_desdeVentaGeneral=null;
	public Boolean mostrarfecha_desdeVentaGeneral=true;
	public Boolean activarfecha_desdeVentaGeneral=true;

	public Border resaltarfecha_hastaVentaGeneral=null;
	public Boolean mostrarfecha_hastaVentaGeneral=true;
	public Boolean activarfecha_hastaVentaGeneral=true;

	public Border resaltarnombre_productoVentaGeneral=null;
	public Boolean mostrarnombre_productoVentaGeneral=true;
	public Boolean activarnombre_productoVentaGeneral=true;

	public Border resaltarnombre_clienteVentaGeneral=null;
	public Boolean mostrarnombre_clienteVentaGeneral=true;
	public Boolean activarnombre_clienteVentaGeneral=true;

	public Border resaltarfechaVentaGeneral=null;
	public Boolean mostrarfechaVentaGeneral=true;
	public Boolean activarfechaVentaGeneral=true;

	public Border resaltarsecuencialVentaGeneral=null;
	public Boolean mostrarsecuencialVentaGeneral=true;
	public Boolean activarsecuencialVentaGeneral=true;

	public Border resaltarcantidadVentaGeneral=null;
	public Boolean mostrarcantidadVentaGeneral=true;
	public Boolean activarcantidadVentaGeneral=true;

	public Border resaltarprecioVentaGeneral=null;
	public Boolean mostrarprecioVentaGeneral=true;
	public Boolean activarprecioVentaGeneral=true;

	public Border resaltardescuentoVentaGeneral=null;
	public Boolean mostrardescuentoVentaGeneral=true;
	public Boolean activardescuentoVentaGeneral=true;

	public Border resaltarivaVentaGeneral=null;
	public Boolean mostrarivaVentaGeneral=true;
	public Boolean activarivaVentaGeneral=true;

	public Border resaltariceVentaGeneral=null;
	public Boolean mostrariceVentaGeneral=true;
	public Boolean activariceVentaGeneral=true;

	
	

	public Border setResaltaridVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltaridVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVentaGeneral() {
		return this.resaltaridVentaGeneral;
	}

	public void setResaltaridVentaGeneral(Border borderResaltar) {
		this.resaltaridVentaGeneral= borderResaltar;
	}

	public Boolean getMostraridVentaGeneral() {
		return this.mostraridVentaGeneral;
	}

	public void setMostraridVentaGeneral(Boolean mostraridVentaGeneral) {
		this.mostraridVentaGeneral= mostraridVentaGeneral;
	}

	public Boolean getActivaridVentaGeneral() {
		return this.activaridVentaGeneral;
	}

	public void setActivaridVentaGeneral(Boolean activaridVentaGeneral) {
		this.activaridVentaGeneral= activaridVentaGeneral;
	}

	public Border setResaltarid_empresaVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarid_empresaVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVentaGeneral() {
		return this.resaltarid_empresaVentaGeneral;
	}

	public void setResaltarid_empresaVentaGeneral(Border borderResaltar) {
		this.resaltarid_empresaVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarid_empresaVentaGeneral() {
		return this.mostrarid_empresaVentaGeneral;
	}

	public void setMostrarid_empresaVentaGeneral(Boolean mostrarid_empresaVentaGeneral) {
		this.mostrarid_empresaVentaGeneral= mostrarid_empresaVentaGeneral;
	}

	public Boolean getActivarid_empresaVentaGeneral() {
		return this.activarid_empresaVentaGeneral;
	}

	public void setActivarid_empresaVentaGeneral(Boolean activarid_empresaVentaGeneral) {
		this.activarid_empresaVentaGeneral= activarid_empresaVentaGeneral;
	}

	public Boolean getCargarid_empresaVentaGeneral() {
		return this.cargarid_empresaVentaGeneral;
	}

	public void setCargarid_empresaVentaGeneral(Boolean cargarid_empresaVentaGeneral) {
		this.cargarid_empresaVentaGeneral= cargarid_empresaVentaGeneral;
	}

	public Border setResaltarid_sucursalVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarid_sucursalVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalVentaGeneral() {
		return this.resaltarid_sucursalVentaGeneral;
	}

	public void setResaltarid_sucursalVentaGeneral(Border borderResaltar) {
		this.resaltarid_sucursalVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarid_sucursalVentaGeneral() {
		return this.mostrarid_sucursalVentaGeneral;
	}

	public void setMostrarid_sucursalVentaGeneral(Boolean mostrarid_sucursalVentaGeneral) {
		this.mostrarid_sucursalVentaGeneral= mostrarid_sucursalVentaGeneral;
	}

	public Boolean getActivarid_sucursalVentaGeneral() {
		return this.activarid_sucursalVentaGeneral;
	}

	public void setActivarid_sucursalVentaGeneral(Boolean activarid_sucursalVentaGeneral) {
		this.activarid_sucursalVentaGeneral= activarid_sucursalVentaGeneral;
	}

	public Boolean getCargarid_sucursalVentaGeneral() {
		return this.cargarid_sucursalVentaGeneral;
	}

	public void setCargarid_sucursalVentaGeneral(Boolean cargarid_sucursalVentaGeneral) {
		this.cargarid_sucursalVentaGeneral= cargarid_sucursalVentaGeneral;
	}

	public Border setResaltarid_clienteVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarid_clienteVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteVentaGeneral() {
		return this.resaltarid_clienteVentaGeneral;
	}

	public void setResaltarid_clienteVentaGeneral(Border borderResaltar) {
		this.resaltarid_clienteVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarid_clienteVentaGeneral() {
		return this.mostrarid_clienteVentaGeneral;
	}

	public void setMostrarid_clienteVentaGeneral(Boolean mostrarid_clienteVentaGeneral) {
		this.mostrarid_clienteVentaGeneral= mostrarid_clienteVentaGeneral;
	}

	public Boolean getActivarid_clienteVentaGeneral() {
		return this.activarid_clienteVentaGeneral;
	}

	public void setActivarid_clienteVentaGeneral(Boolean activarid_clienteVentaGeneral) {
		this.activarid_clienteVentaGeneral= activarid_clienteVentaGeneral;
	}

	public Boolean getCargarid_clienteVentaGeneral() {
		return this.cargarid_clienteVentaGeneral;
	}

	public void setCargarid_clienteVentaGeneral(Boolean cargarid_clienteVentaGeneral) {
		this.cargarid_clienteVentaGeneral= cargarid_clienteVentaGeneral;
	}

	public Border setResaltarid_productoVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarid_productoVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoVentaGeneral() {
		return this.resaltarid_productoVentaGeneral;
	}

	public void setResaltarid_productoVentaGeneral(Border borderResaltar) {
		this.resaltarid_productoVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarid_productoVentaGeneral() {
		return this.mostrarid_productoVentaGeneral;
	}

	public void setMostrarid_productoVentaGeneral(Boolean mostrarid_productoVentaGeneral) {
		this.mostrarid_productoVentaGeneral= mostrarid_productoVentaGeneral;
	}

	public Boolean getActivarid_productoVentaGeneral() {
		return this.activarid_productoVentaGeneral;
	}

	public void setActivarid_productoVentaGeneral(Boolean activarid_productoVentaGeneral) {
		this.activarid_productoVentaGeneral= activarid_productoVentaGeneral;
	}

	public Boolean getCargarid_productoVentaGeneral() {
		return this.cargarid_productoVentaGeneral;
	}

	public void setCargarid_productoVentaGeneral(Boolean cargarid_productoVentaGeneral) {
		this.cargarid_productoVentaGeneral= cargarid_productoVentaGeneral;
	}

	public Border setResaltarfecha_desdeVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeVentaGeneral() {
		return this.resaltarfecha_desdeVentaGeneral;
	}

	public void setResaltarfecha_desdeVentaGeneral(Border borderResaltar) {
		this.resaltarfecha_desdeVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeVentaGeneral() {
		return this.mostrarfecha_desdeVentaGeneral;
	}

	public void setMostrarfecha_desdeVentaGeneral(Boolean mostrarfecha_desdeVentaGeneral) {
		this.mostrarfecha_desdeVentaGeneral= mostrarfecha_desdeVentaGeneral;
	}

	public Boolean getActivarfecha_desdeVentaGeneral() {
		return this.activarfecha_desdeVentaGeneral;
	}

	public void setActivarfecha_desdeVentaGeneral(Boolean activarfecha_desdeVentaGeneral) {
		this.activarfecha_desdeVentaGeneral= activarfecha_desdeVentaGeneral;
	}

	public Border setResaltarfecha_hastaVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaVentaGeneral() {
		return this.resaltarfecha_hastaVentaGeneral;
	}

	public void setResaltarfecha_hastaVentaGeneral(Border borderResaltar) {
		this.resaltarfecha_hastaVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaVentaGeneral() {
		return this.mostrarfecha_hastaVentaGeneral;
	}

	public void setMostrarfecha_hastaVentaGeneral(Boolean mostrarfecha_hastaVentaGeneral) {
		this.mostrarfecha_hastaVentaGeneral= mostrarfecha_hastaVentaGeneral;
	}

	public Boolean getActivarfecha_hastaVentaGeneral() {
		return this.activarfecha_hastaVentaGeneral;
	}

	public void setActivarfecha_hastaVentaGeneral(Boolean activarfecha_hastaVentaGeneral) {
		this.activarfecha_hastaVentaGeneral= activarfecha_hastaVentaGeneral;
	}

	public Border setResaltarnombre_productoVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarnombre_productoVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoVentaGeneral() {
		return this.resaltarnombre_productoVentaGeneral;
	}

	public void setResaltarnombre_productoVentaGeneral(Border borderResaltar) {
		this.resaltarnombre_productoVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarnombre_productoVentaGeneral() {
		return this.mostrarnombre_productoVentaGeneral;
	}

	public void setMostrarnombre_productoVentaGeneral(Boolean mostrarnombre_productoVentaGeneral) {
		this.mostrarnombre_productoVentaGeneral= mostrarnombre_productoVentaGeneral;
	}

	public Boolean getActivarnombre_productoVentaGeneral() {
		return this.activarnombre_productoVentaGeneral;
	}

	public void setActivarnombre_productoVentaGeneral(Boolean activarnombre_productoVentaGeneral) {
		this.activarnombre_productoVentaGeneral= activarnombre_productoVentaGeneral;
	}

	public Border setResaltarnombre_clienteVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteVentaGeneral() {
		return this.resaltarnombre_clienteVentaGeneral;
	}

	public void setResaltarnombre_clienteVentaGeneral(Border borderResaltar) {
		this.resaltarnombre_clienteVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteVentaGeneral() {
		return this.mostrarnombre_clienteVentaGeneral;
	}

	public void setMostrarnombre_clienteVentaGeneral(Boolean mostrarnombre_clienteVentaGeneral) {
		this.mostrarnombre_clienteVentaGeneral= mostrarnombre_clienteVentaGeneral;
	}

	public Boolean getActivarnombre_clienteVentaGeneral() {
		return this.activarnombre_clienteVentaGeneral;
	}

	public void setActivarnombre_clienteVentaGeneral(Boolean activarnombre_clienteVentaGeneral) {
		this.activarnombre_clienteVentaGeneral= activarnombre_clienteVentaGeneral;
	}

	public Border setResaltarfechaVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarfechaVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaVentaGeneral() {
		return this.resaltarfechaVentaGeneral;
	}

	public void setResaltarfechaVentaGeneral(Border borderResaltar) {
		this.resaltarfechaVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarfechaVentaGeneral() {
		return this.mostrarfechaVentaGeneral;
	}

	public void setMostrarfechaVentaGeneral(Boolean mostrarfechaVentaGeneral) {
		this.mostrarfechaVentaGeneral= mostrarfechaVentaGeneral;
	}

	public Boolean getActivarfechaVentaGeneral() {
		return this.activarfechaVentaGeneral;
	}

	public void setActivarfechaVentaGeneral(Boolean activarfechaVentaGeneral) {
		this.activarfechaVentaGeneral= activarfechaVentaGeneral;
	}

	public Border setResaltarsecuencialVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarsecuencialVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialVentaGeneral() {
		return this.resaltarsecuencialVentaGeneral;
	}

	public void setResaltarsecuencialVentaGeneral(Border borderResaltar) {
		this.resaltarsecuencialVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarsecuencialVentaGeneral() {
		return this.mostrarsecuencialVentaGeneral;
	}

	public void setMostrarsecuencialVentaGeneral(Boolean mostrarsecuencialVentaGeneral) {
		this.mostrarsecuencialVentaGeneral= mostrarsecuencialVentaGeneral;
	}

	public Boolean getActivarsecuencialVentaGeneral() {
		return this.activarsecuencialVentaGeneral;
	}

	public void setActivarsecuencialVentaGeneral(Boolean activarsecuencialVentaGeneral) {
		this.activarsecuencialVentaGeneral= activarsecuencialVentaGeneral;
	}

	public Border setResaltarcantidadVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarcantidadVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadVentaGeneral() {
		return this.resaltarcantidadVentaGeneral;
	}

	public void setResaltarcantidadVentaGeneral(Border borderResaltar) {
		this.resaltarcantidadVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarcantidadVentaGeneral() {
		return this.mostrarcantidadVentaGeneral;
	}

	public void setMostrarcantidadVentaGeneral(Boolean mostrarcantidadVentaGeneral) {
		this.mostrarcantidadVentaGeneral= mostrarcantidadVentaGeneral;
	}

	public Boolean getActivarcantidadVentaGeneral() {
		return this.activarcantidadVentaGeneral;
	}

	public void setActivarcantidadVentaGeneral(Boolean activarcantidadVentaGeneral) {
		this.activarcantidadVentaGeneral= activarcantidadVentaGeneral;
	}

	public Border setResaltarprecioVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarprecioVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioVentaGeneral() {
		return this.resaltarprecioVentaGeneral;
	}

	public void setResaltarprecioVentaGeneral(Border borderResaltar) {
		this.resaltarprecioVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarprecioVentaGeneral() {
		return this.mostrarprecioVentaGeneral;
	}

	public void setMostrarprecioVentaGeneral(Boolean mostrarprecioVentaGeneral) {
		this.mostrarprecioVentaGeneral= mostrarprecioVentaGeneral;
	}

	public Boolean getActivarprecioVentaGeneral() {
		return this.activarprecioVentaGeneral;
	}

	public void setActivarprecioVentaGeneral(Boolean activarprecioVentaGeneral) {
		this.activarprecioVentaGeneral= activarprecioVentaGeneral;
	}

	public Border setResaltardescuentoVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltardescuentoVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoVentaGeneral() {
		return this.resaltardescuentoVentaGeneral;
	}

	public void setResaltardescuentoVentaGeneral(Border borderResaltar) {
		this.resaltardescuentoVentaGeneral= borderResaltar;
	}

	public Boolean getMostrardescuentoVentaGeneral() {
		return this.mostrardescuentoVentaGeneral;
	}

	public void setMostrardescuentoVentaGeneral(Boolean mostrardescuentoVentaGeneral) {
		this.mostrardescuentoVentaGeneral= mostrardescuentoVentaGeneral;
	}

	public Boolean getActivardescuentoVentaGeneral() {
		return this.activardescuentoVentaGeneral;
	}

	public void setActivardescuentoVentaGeneral(Boolean activardescuentoVentaGeneral) {
		this.activardescuentoVentaGeneral= activardescuentoVentaGeneral;
	}

	public Border setResaltarivaVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltarivaVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaVentaGeneral() {
		return this.resaltarivaVentaGeneral;
	}

	public void setResaltarivaVentaGeneral(Border borderResaltar) {
		this.resaltarivaVentaGeneral= borderResaltar;
	}

	public Boolean getMostrarivaVentaGeneral() {
		return this.mostrarivaVentaGeneral;
	}

	public void setMostrarivaVentaGeneral(Boolean mostrarivaVentaGeneral) {
		this.mostrarivaVentaGeneral= mostrarivaVentaGeneral;
	}

	public Boolean getActivarivaVentaGeneral() {
		return this.activarivaVentaGeneral;
	}

	public void setActivarivaVentaGeneral(Boolean activarivaVentaGeneral) {
		this.activarivaVentaGeneral= activarivaVentaGeneral;
	}

	public Border setResaltariceVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventageneralBeanSwingJInternalFrame.jTtoolBarVentaGeneral.setBorder(borderResaltar);
		
		this.resaltariceVentaGeneral= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceVentaGeneral() {
		return this.resaltariceVentaGeneral;
	}

	public void setResaltariceVentaGeneral(Border borderResaltar) {
		this.resaltariceVentaGeneral= borderResaltar;
	}

	public Boolean getMostrariceVentaGeneral() {
		return this.mostrariceVentaGeneral;
	}

	public void setMostrariceVentaGeneral(Boolean mostrariceVentaGeneral) {
		this.mostrariceVentaGeneral= mostrariceVentaGeneral;
	}

	public Boolean getActivariceVentaGeneral() {
		return this.activariceVentaGeneral;
	}

	public void setActivariceVentaGeneral(Boolean activariceVentaGeneral) {
		this.activariceVentaGeneral= activariceVentaGeneral;
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
		
		
		this.setMostraridVentaGeneral(esInicial);
		this.setMostrarid_empresaVentaGeneral(esInicial);
		this.setMostrarid_sucursalVentaGeneral(esInicial);
		this.setMostrarid_clienteVentaGeneral(esInicial);
		this.setMostrarid_productoVentaGeneral(esInicial);
		this.setMostrarfecha_desdeVentaGeneral(esInicial);
		this.setMostrarfecha_hastaVentaGeneral(esInicial);
		this.setMostrarnombre_productoVentaGeneral(esInicial);
		this.setMostrarnombre_clienteVentaGeneral(esInicial);
		this.setMostrarfechaVentaGeneral(esInicial);
		this.setMostrarsecuencialVentaGeneral(esInicial);
		this.setMostrarcantidadVentaGeneral(esInicial);
		this.setMostrarprecioVentaGeneral(esInicial);
		this.setMostrardescuentoVentaGeneral(esInicial);
		this.setMostrarivaVentaGeneral(esInicial);
		this.setMostrariceVentaGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentaGeneralConstantesFunciones.ID)) {
				this.setMostraridVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.FECHA)) {
				this.setMostrarfechaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.PRECIO)) {
				this.setMostrarprecioVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IVA)) {
				this.setMostrarivaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.ICE)) {
				this.setMostrariceVentaGeneral(esAsigna);
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
		
		
		this.setActivaridVentaGeneral(esInicial);
		this.setActivarid_empresaVentaGeneral(esInicial);
		this.setActivarid_sucursalVentaGeneral(esInicial);
		this.setActivarid_clienteVentaGeneral(esInicial);
		this.setActivarid_productoVentaGeneral(esInicial);
		this.setActivarfecha_desdeVentaGeneral(esInicial);
		this.setActivarfecha_hastaVentaGeneral(esInicial);
		this.setActivarnombre_productoVentaGeneral(esInicial);
		this.setActivarnombre_clienteVentaGeneral(esInicial);
		this.setActivarfechaVentaGeneral(esInicial);
		this.setActivarsecuencialVentaGeneral(esInicial);
		this.setActivarcantidadVentaGeneral(esInicial);
		this.setActivarprecioVentaGeneral(esInicial);
		this.setActivardescuentoVentaGeneral(esInicial);
		this.setActivarivaVentaGeneral(esInicial);
		this.setActivariceVentaGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentaGeneralConstantesFunciones.ID)) {
				this.setActivaridVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.FECHA)) {
				this.setActivarfechaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.PRECIO)) {
				this.setActivarprecioVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IVA)) {
				this.setActivarivaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.ICE)) {
				this.setActivariceVentaGeneral(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVentaGeneral(esInicial);
		this.setResaltarid_empresaVentaGeneral(esInicial);
		this.setResaltarid_sucursalVentaGeneral(esInicial);
		this.setResaltarid_clienteVentaGeneral(esInicial);
		this.setResaltarid_productoVentaGeneral(esInicial);
		this.setResaltarfecha_desdeVentaGeneral(esInicial);
		this.setResaltarfecha_hastaVentaGeneral(esInicial);
		this.setResaltarnombre_productoVentaGeneral(esInicial);
		this.setResaltarnombre_clienteVentaGeneral(esInicial);
		this.setResaltarfechaVentaGeneral(esInicial);
		this.setResaltarsecuencialVentaGeneral(esInicial);
		this.setResaltarcantidadVentaGeneral(esInicial);
		this.setResaltarprecioVentaGeneral(esInicial);
		this.setResaltardescuentoVentaGeneral(esInicial);
		this.setResaltarivaVentaGeneral(esInicial);
		this.setResaltariceVentaGeneral(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentaGeneralConstantesFunciones.ID)) {
				this.setResaltaridVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.FECHA)) {
				this.setResaltarfechaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.PRECIO)) {
				this.setResaltarprecioVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.IVA)) {
				this.setResaltarivaVentaGeneral(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaGeneralConstantesFunciones.ICE)) {
				this.setResaltariceVentaGeneral(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaVentaGeneralVentaGeneral=true;

	public Boolean getMostrarBusquedaVentaGeneralVentaGeneral() {
		return this.mostrarBusquedaVentaGeneralVentaGeneral;
	}

	public void setMostrarBusquedaVentaGeneralVentaGeneral(Boolean visibilidadResaltar) {
		this.mostrarBusquedaVentaGeneralVentaGeneral= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaVentaGeneralVentaGeneral=true;

	public Boolean getActivarBusquedaVentaGeneralVentaGeneral() {
		return this.activarBusquedaVentaGeneralVentaGeneral;
	}

	public void setActivarBusquedaVentaGeneralVentaGeneral(Boolean habilitarResaltar) {
		this.activarBusquedaVentaGeneralVentaGeneral= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaVentaGeneralVentaGeneral=null;

	public Border getResaltarBusquedaVentaGeneralVentaGeneral() {
		return this.resaltarBusquedaVentaGeneralVentaGeneral;
	}

	public void setResaltarBusquedaVentaGeneralVentaGeneral(Border borderResaltar) {
		this.resaltarBusquedaVentaGeneralVentaGeneral= borderResaltar;
	}

	public void setResaltarBusquedaVentaGeneralVentaGeneral(ParametroGeneralUsuario parametroGeneralUsuario/*VentaGeneralBeanSwingJInternalFrame ventageneralBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaVentaGeneralVentaGeneral= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}