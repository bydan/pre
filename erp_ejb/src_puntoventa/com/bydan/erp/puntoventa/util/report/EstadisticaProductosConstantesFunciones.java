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


import com.bydan.erp.puntoventa.util.report.EstadisticaProductosConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.EstadisticaProductosParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.EstadisticaProductosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadisticaProductosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadisticaProductos";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadisticaProductos"+EstadisticaProductosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadisticaProductosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadisticaProductosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadisticaProductosConstantesFunciones.SCHEMA+"_"+EstadisticaProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadisticaProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadisticaProductosConstantesFunciones.SCHEMA+"_"+EstadisticaProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadisticaProductosConstantesFunciones.SCHEMA+"_"+EstadisticaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadisticaProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadisticaProductosConstantesFunciones.SCHEMA+"_"+EstadisticaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadisticaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadisticaProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadisticaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadisticaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadisticaProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadisticaProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadisticaProductosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadisticaProductosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadisticaProductosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadisticaProductosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estadistica Productoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Estadistica Productos";
	public static final String SCLASSWEBTITULO_LOWER="Estadistica Productos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadisticaProductos";
	public static final String OBJECTNAME="estadisticaproductos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="estadistica_productos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadisticaproductos from "+EstadisticaProductosConstantesFunciones.SPERSISTENCENAME+" estadisticaproductos";
	public static String QUERYSELECTNATIVE="select "+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME+".id,"+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME+".version_row,"+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME+".id_empresa,"+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME+".id_sucursal,"+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME+".id_producto,"+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME+".fecha_inicio,"+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME+".fecha_fin,"+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME+".codigo_producto,"+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME+".nombre_producto,"+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME+".cantidad_precio,"+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME+".cantidad from "+EstadisticaProductosConstantesFunciones.SCHEMA+"."+EstadisticaProductosConstantesFunciones.TABLENAME;//+" as "+EstadisticaProductosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPRODUCTO= "id_producto";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String CODIGOPRODUCTO= "codigo_producto";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String CANTIDADPRECIO= "cantidad_precio";
    public static final String CANTIDAD= "cantidad";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_CANTIDADPRECIO= "Cantad Precio";
		public static final String LABEL_CANTIDADPRECIO_LOWER= "Cantidad Precio";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
	
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getEstadisticaProductosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadisticaProductosConstantesFunciones.IDEMPRESA)) {sLabelColumna=EstadisticaProductosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EstadisticaProductosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=EstadisticaProductosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(EstadisticaProductosConstantesFunciones.IDPRODUCTO)) {sLabelColumna=EstadisticaProductosConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(EstadisticaProductosConstantesFunciones.FECHAINICIO)) {sLabelColumna=EstadisticaProductosConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(EstadisticaProductosConstantesFunciones.FECHAFIN)) {sLabelColumna=EstadisticaProductosConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(EstadisticaProductosConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=EstadisticaProductosConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(EstadisticaProductosConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=EstadisticaProductosConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(EstadisticaProductosConstantesFunciones.CANTIDADPRECIO)) {sLabelColumna=EstadisticaProductosConstantesFunciones.LABEL_CANTIDADPRECIO;}
		if(sNombreColumna.equals(EstadisticaProductosConstantesFunciones.CANTIDAD)) {sLabelColumna=EstadisticaProductosConstantesFunciones.LABEL_CANTIDAD;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEstadisticaProductosDescripcion(EstadisticaProductos estadisticaproductos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadisticaproductos !=null/* && estadisticaproductos.getId()!=0*/) {
			if(estadisticaproductos.getId()!=null) {
				sDescripcion=estadisticaproductos.getId().toString();
			}//estadisticaproductosestadisticaproductos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadisticaProductosDescripcionDetallado(EstadisticaProductos estadisticaproductos) {
		String sDescripcion="";
			
		sDescripcion+=EstadisticaProductosConstantesFunciones.ID+"=";
		sDescripcion+=estadisticaproductos.getId().toString()+",";
		sDescripcion+=EstadisticaProductosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadisticaproductos.getVersionRow().toString()+",";
		sDescripcion+=EstadisticaProductosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=estadisticaproductos.getid_empresa().toString()+",";
		sDescripcion+=EstadisticaProductosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=estadisticaproductos.getid_sucursal().toString()+",";
		sDescripcion+=EstadisticaProductosConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=estadisticaproductos.getid_producto().toString()+",";
		sDescripcion+=EstadisticaProductosConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=estadisticaproductos.getfecha_inicio().toString()+",";
		sDescripcion+=EstadisticaProductosConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=estadisticaproductos.getfecha_fin().toString()+",";
		sDescripcion+=EstadisticaProductosConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=estadisticaproductos.getcodigo_producto()+",";
		sDescripcion+=EstadisticaProductosConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=estadisticaproductos.getnombre_producto()+",";
		sDescripcion+=EstadisticaProductosConstantesFunciones.CANTIDADPRECIO+"=";
		sDescripcion+=estadisticaproductos.getcantidad_precio().toString()+",";
		sDescripcion+=EstadisticaProductosConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=estadisticaproductos.getcantidad().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadisticaProductosDescripcion(EstadisticaProductos estadisticaproductos,String sValor) throws Exception {			
		if(estadisticaproductos !=null) {
			//estadisticaproductosestadisticaproductos.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaEstadisticaProductos")) {
			sNombreIndice="Tipo=  Por Producto Por Fecha Inicio Por Fecha Fin";
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

	public static String getDetalleIndiceBusquedaEstadisticaProductos(Long id_producto,Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosEstadisticaProductos(EstadisticaProductos estadisticaproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadisticaproductos.setcodigo_producto(estadisticaproductos.getcodigo_producto().trim());
		estadisticaproductos.setnombre_producto(estadisticaproductos.getnombre_producto().trim());
	}
	
	public static void quitarEspaciosEstadisticaProductoss(List<EstadisticaProductos> estadisticaproductoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadisticaProductos estadisticaproductos: estadisticaproductoss) {
			estadisticaproductos.setcodigo_producto(estadisticaproductos.getcodigo_producto().trim());
			estadisticaproductos.setnombre_producto(estadisticaproductos.getnombre_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadisticaProductos(EstadisticaProductos estadisticaproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadisticaproductos.getConCambioAuxiliar()) {
			estadisticaproductos.setIsDeleted(estadisticaproductos.getIsDeletedAuxiliar());	
			estadisticaproductos.setIsNew(estadisticaproductos.getIsNewAuxiliar());	
			estadisticaproductos.setIsChanged(estadisticaproductos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadisticaproductos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadisticaproductos.setIsDeletedAuxiliar(false);	
			estadisticaproductos.setIsNewAuxiliar(false);	
			estadisticaproductos.setIsChangedAuxiliar(false);
			
			estadisticaproductos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadisticaProductoss(List<EstadisticaProductos> estadisticaproductoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadisticaProductos estadisticaproductos : estadisticaproductoss) {
			if(conAsignarBase && estadisticaproductos.getConCambioAuxiliar()) {
				estadisticaproductos.setIsDeleted(estadisticaproductos.getIsDeletedAuxiliar());	
				estadisticaproductos.setIsNew(estadisticaproductos.getIsNewAuxiliar());	
				estadisticaproductos.setIsChanged(estadisticaproductos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadisticaproductos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadisticaproductos.setIsDeletedAuxiliar(false);	
				estadisticaproductos.setIsNewAuxiliar(false);	
				estadisticaproductos.setIsChangedAuxiliar(false);
				
				estadisticaproductos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadisticaProductos(EstadisticaProductos estadisticaproductos,Boolean conEnteros) throws Exception  {
		estadisticaproductos.setcantidad_precio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			estadisticaproductos.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresEstadisticaProductoss(List<EstadisticaProductos> estadisticaproductoss,Boolean conEnteros) throws Exception  {
		
		for(EstadisticaProductos estadisticaproductos: estadisticaproductoss) {
			estadisticaproductos.setcantidad_precio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				estadisticaproductos.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadisticaProductos(List<EstadisticaProductos> estadisticaproductoss,EstadisticaProductos estadisticaproductosAux) throws Exception  {
		EstadisticaProductosConstantesFunciones.InicializarValoresEstadisticaProductos(estadisticaproductosAux,true);
		
		for(EstadisticaProductos estadisticaproductos: estadisticaproductoss) {
			if(estadisticaproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			estadisticaproductosAux.setcantidad_precio(estadisticaproductosAux.getcantidad_precio()+estadisticaproductos.getcantidad_precio());			
			estadisticaproductosAux.setcantidad(estadisticaproductosAux.getcantidad()+estadisticaproductos.getcantidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadisticaProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadisticaProductosConstantesFunciones.getArrayColumnasGlobalesEstadisticaProductos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadisticaProductos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstadisticaProductosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstadisticaProductosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstadisticaProductosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstadisticaProductosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadisticaProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadisticaProductos> estadisticaproductoss,EstadisticaProductos estadisticaproductos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadisticaProductos estadisticaproductosAux: estadisticaproductoss) {
			if(estadisticaproductosAux!=null && estadisticaproductos!=null) {
				if((estadisticaproductosAux.getId()==null && estadisticaproductos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadisticaproductosAux.getId()!=null && estadisticaproductos.getId()!=null){
					if(estadisticaproductosAux.getId().equals(estadisticaproductos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadisticaProductos(List<EstadisticaProductos> estadisticaproductoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cantidad_precioTotal=0.0;
	
		for(EstadisticaProductos estadisticaproductos: estadisticaproductoss) {			
			if(estadisticaproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cantidad_precioTotal+=estadisticaproductos.getcantidad_precio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadisticaProductosConstantesFunciones.CANTIDADPRECIO);
		datoGeneral.setsDescripcion(EstadisticaProductosConstantesFunciones.LABEL_CANTIDADPRECIO);
		datoGeneral.setdValorDouble(cantidad_precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadisticaProductos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadisticaProductosConstantesFunciones.LABEL_ID, EstadisticaProductosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadisticaProductosConstantesFunciones.LABEL_VERSIONROW, EstadisticaProductosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadisticaProductosConstantesFunciones.LABEL_CODIGOPRODUCTO, EstadisticaProductosConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadisticaProductosConstantesFunciones.LABEL_NOMBREPRODUCTO, EstadisticaProductosConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadisticaProductosConstantesFunciones.LABEL_CANTIDADPRECIO, EstadisticaProductosConstantesFunciones.CANTIDADPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadisticaProductosConstantesFunciones.LABEL_CANTIDAD, EstadisticaProductosConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadisticaProductos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadisticaProductosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadisticaProductosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadisticaProductosConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadisticaProductosConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadisticaProductosConstantesFunciones.CANTIDADPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadisticaProductosConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadisticaProductos() throws Exception  {
		return EstadisticaProductosConstantesFunciones.getTiposSeleccionarEstadisticaProductos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadisticaProductos(Boolean conFk) throws Exception  {
		return EstadisticaProductosConstantesFunciones.getTiposSeleccionarEstadisticaProductos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadisticaProductos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadisticaProductosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EstadisticaProductosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadisticaProductosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(EstadisticaProductosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadisticaProductosConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(EstadisticaProductosConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadisticaProductosConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(EstadisticaProductosConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadisticaProductosConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(EstadisticaProductosConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadisticaProductosConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(EstadisticaProductosConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadisticaProductosConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(EstadisticaProductosConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadisticaProductosConstantesFunciones.LABEL_CANTIDADPRECIO);
			reporte.setsDescripcion(EstadisticaProductosConstantesFunciones.LABEL_CANTIDADPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadisticaProductosConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(EstadisticaProductosConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadisticaProductos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadisticaProductos(EstadisticaProductos estadisticaproductosAux) throws Exception {
		
			estadisticaproductosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadisticaproductosAux.getEmpresa()));
			estadisticaproductosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(estadisticaproductosAux.getSucursal()));
			estadisticaproductosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(estadisticaproductosAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEstadisticaProductos(List<EstadisticaProductos> estadisticaproductossTemp) throws Exception {
		for(EstadisticaProductos estadisticaproductosAux:estadisticaproductossTemp) {
			
			estadisticaproductosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadisticaproductosAux.getEmpresa()));
			estadisticaproductosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(estadisticaproductosAux.getSucursal()));
			estadisticaproductosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(estadisticaproductosAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadisticaProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadisticaProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadisticaProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadisticaProductosConstantesFunciones.getClassesRelationshipsOfEstadisticaProductos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadisticaProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadisticaProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadisticaProductosConstantesFunciones.getClassesRelationshipsFromStringsOfEstadisticaProductos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadisticaProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EstadisticaProductos estadisticaproductos,List<EstadisticaProductos> estadisticaproductoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(EstadisticaProductos estadisticaproductos,List<EstadisticaProductos> estadisticaproductoss) throws Exception {
		try	{			
			for(EstadisticaProductos estadisticaproductosLocal:estadisticaproductoss) {
				if(estadisticaproductosLocal.getId().equals(estadisticaproductos.getId())) {
					estadisticaproductosLocal.setIsSelected(estadisticaproductos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadisticaProductos(List<EstadisticaProductos> estadisticaproductossAux) throws Exception {
		//this.estadisticaproductossAux=estadisticaproductossAux;
		
		for(EstadisticaProductos estadisticaproductosAux:estadisticaproductossAux) {
			if(estadisticaproductosAux.getIsChanged()) {
				estadisticaproductosAux.setIsChanged(false);
			}		
			
			if(estadisticaproductosAux.getIsNew()) {
				estadisticaproductosAux.setIsNew(false);
			}	
			
			if(estadisticaproductosAux.getIsDeleted()) {
				estadisticaproductosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadisticaProductos(EstadisticaProductos estadisticaproductosAux) throws Exception {
		//this.estadisticaproductosAux=estadisticaproductosAux;
		
			if(estadisticaproductosAux.getIsChanged()) {
				estadisticaproductosAux.setIsChanged(false);
			}		
			
			if(estadisticaproductosAux.getIsNew()) {
				estadisticaproductosAux.setIsNew(false);
			}	
			
			if(estadisticaproductosAux.getIsDeleted()) {
				estadisticaproductosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadisticaProductos estadisticaproductosAsignar,EstadisticaProductos estadisticaproductos) throws Exception {
		estadisticaproductosAsignar.setId(estadisticaproductos.getId());	
		estadisticaproductosAsignar.setVersionRow(estadisticaproductos.getVersionRow());	
		estadisticaproductosAsignar.setcodigo_producto(estadisticaproductos.getcodigo_producto());	
		estadisticaproductosAsignar.setnombre_producto(estadisticaproductos.getnombre_producto());	
		estadisticaproductosAsignar.setcantidad_precio(estadisticaproductos.getcantidad_precio());	
		estadisticaproductosAsignar.setcantidad(estadisticaproductos.getcantidad());	
	}
	
	public static void inicializarEstadisticaProductos(EstadisticaProductos estadisticaproductos) throws Exception {
		try {
				estadisticaproductos.setId(0L);	
					
				estadisticaproductos.setcodigo_producto("");	
				estadisticaproductos.setnombre_producto("");	
				estadisticaproductos.setcantidad_precio(0.0);	
				estadisticaproductos.setcantidad(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadisticaProductos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadisticaProductosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadisticaProductosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadisticaProductosConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadisticaProductosConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadisticaProductosConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadisticaProductosConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadisticaProductosConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadisticaProductosConstantesFunciones.LABEL_CANTIDADPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadisticaProductosConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadisticaProductos(String sTipo,Row row,Workbook workbook,EstadisticaProductos estadisticaproductos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadisticaproductos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadisticaproductos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadisticaproductos.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadisticaproductos.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadisticaproductos.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadisticaproductos.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadisticaproductos.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadisticaproductos.getcantidad_precio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadisticaproductos.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadisticaProductos="";
	
	public String getsFinalQueryEstadisticaProductos() {
		return this.sFinalQueryEstadisticaProductos;
	}
	
	public void setsFinalQueryEstadisticaProductos(String sFinalQueryEstadisticaProductos) {
		this.sFinalQueryEstadisticaProductos= sFinalQueryEstadisticaProductos;
	}
	
	public Border resaltarSeleccionarEstadisticaProductos=null;
	
	public Border setResaltarSeleccionarEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadisticaproductosBeanSwingJInternalFrame.jTtoolBarEstadisticaProductos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadisticaProductos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadisticaProductos() {
		return this.resaltarSeleccionarEstadisticaProductos;
	}
	
	public void setResaltarSeleccionarEstadisticaProductos(Border borderResaltarSeleccionarEstadisticaProductos) {
		this.resaltarSeleccionarEstadisticaProductos= borderResaltarSeleccionarEstadisticaProductos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadisticaProductos=null;
	public Boolean mostraridEstadisticaProductos=true;
	public Boolean activaridEstadisticaProductos=true;

	public Border resaltarid_empresaEstadisticaProductos=null;
	public Boolean mostrarid_empresaEstadisticaProductos=true;
	public Boolean activarid_empresaEstadisticaProductos=true;
	public Boolean cargarid_empresaEstadisticaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEstadisticaProductos=false;//ConEventDepend=true

	public Border resaltarid_sucursalEstadisticaProductos=null;
	public Boolean mostrarid_sucursalEstadisticaProductos=true;
	public Boolean activarid_sucursalEstadisticaProductos=true;
	public Boolean cargarid_sucursalEstadisticaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalEstadisticaProductos=false;//ConEventDepend=true

	public Border resaltarid_productoEstadisticaProductos=null;
	public Boolean mostrarid_productoEstadisticaProductos=true;
	public Boolean activarid_productoEstadisticaProductos=true;
	public Boolean cargarid_productoEstadisticaProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoEstadisticaProductos=false;//ConEventDepend=true

	public Border resaltarfecha_inicioEstadisticaProductos=null;
	public Boolean mostrarfecha_inicioEstadisticaProductos=true;
	public Boolean activarfecha_inicioEstadisticaProductos=true;

	public Border resaltarfecha_finEstadisticaProductos=null;
	public Boolean mostrarfecha_finEstadisticaProductos=true;
	public Boolean activarfecha_finEstadisticaProductos=true;

	public Border resaltarcodigo_productoEstadisticaProductos=null;
	public Boolean mostrarcodigo_productoEstadisticaProductos=true;
	public Boolean activarcodigo_productoEstadisticaProductos=true;

	public Border resaltarnombre_productoEstadisticaProductos=null;
	public Boolean mostrarnombre_productoEstadisticaProductos=true;
	public Boolean activarnombre_productoEstadisticaProductos=true;

	public Border resaltarcantidad_precioEstadisticaProductos=null;
	public Boolean mostrarcantidad_precioEstadisticaProductos=true;
	public Boolean activarcantidad_precioEstadisticaProductos=true;

	public Border resaltarcantidadEstadisticaProductos=null;
	public Boolean mostrarcantidadEstadisticaProductos=true;
	public Boolean activarcantidadEstadisticaProductos=true;

	
	

	public Border setResaltaridEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadisticaproductosBeanSwingJInternalFrame.jTtoolBarEstadisticaProductos.setBorder(borderResaltar);
		
		this.resaltaridEstadisticaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadisticaProductos() {
		return this.resaltaridEstadisticaProductos;
	}

	public void setResaltaridEstadisticaProductos(Border borderResaltar) {
		this.resaltaridEstadisticaProductos= borderResaltar;
	}

	public Boolean getMostraridEstadisticaProductos() {
		return this.mostraridEstadisticaProductos;
	}

	public void setMostraridEstadisticaProductos(Boolean mostraridEstadisticaProductos) {
		this.mostraridEstadisticaProductos= mostraridEstadisticaProductos;
	}

	public Boolean getActivaridEstadisticaProductos() {
		return this.activaridEstadisticaProductos;
	}

	public void setActivaridEstadisticaProductos(Boolean activaridEstadisticaProductos) {
		this.activaridEstadisticaProductos= activaridEstadisticaProductos;
	}

	public Border setResaltarid_empresaEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadisticaproductosBeanSwingJInternalFrame.jTtoolBarEstadisticaProductos.setBorder(borderResaltar);
		
		this.resaltarid_empresaEstadisticaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEstadisticaProductos() {
		return this.resaltarid_empresaEstadisticaProductos;
	}

	public void setResaltarid_empresaEstadisticaProductos(Border borderResaltar) {
		this.resaltarid_empresaEstadisticaProductos= borderResaltar;
	}

	public Boolean getMostrarid_empresaEstadisticaProductos() {
		return this.mostrarid_empresaEstadisticaProductos;
	}

	public void setMostrarid_empresaEstadisticaProductos(Boolean mostrarid_empresaEstadisticaProductos) {
		this.mostrarid_empresaEstadisticaProductos= mostrarid_empresaEstadisticaProductos;
	}

	public Boolean getActivarid_empresaEstadisticaProductos() {
		return this.activarid_empresaEstadisticaProductos;
	}

	public void setActivarid_empresaEstadisticaProductos(Boolean activarid_empresaEstadisticaProductos) {
		this.activarid_empresaEstadisticaProductos= activarid_empresaEstadisticaProductos;
	}

	public Boolean getCargarid_empresaEstadisticaProductos() {
		return this.cargarid_empresaEstadisticaProductos;
	}

	public void setCargarid_empresaEstadisticaProductos(Boolean cargarid_empresaEstadisticaProductos) {
		this.cargarid_empresaEstadisticaProductos= cargarid_empresaEstadisticaProductos;
	}

	public Border setResaltarid_sucursalEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadisticaproductosBeanSwingJInternalFrame.jTtoolBarEstadisticaProductos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalEstadisticaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalEstadisticaProductos() {
		return this.resaltarid_sucursalEstadisticaProductos;
	}

	public void setResaltarid_sucursalEstadisticaProductos(Border borderResaltar) {
		this.resaltarid_sucursalEstadisticaProductos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalEstadisticaProductos() {
		return this.mostrarid_sucursalEstadisticaProductos;
	}

	public void setMostrarid_sucursalEstadisticaProductos(Boolean mostrarid_sucursalEstadisticaProductos) {
		this.mostrarid_sucursalEstadisticaProductos= mostrarid_sucursalEstadisticaProductos;
	}

	public Boolean getActivarid_sucursalEstadisticaProductos() {
		return this.activarid_sucursalEstadisticaProductos;
	}

	public void setActivarid_sucursalEstadisticaProductos(Boolean activarid_sucursalEstadisticaProductos) {
		this.activarid_sucursalEstadisticaProductos= activarid_sucursalEstadisticaProductos;
	}

	public Boolean getCargarid_sucursalEstadisticaProductos() {
		return this.cargarid_sucursalEstadisticaProductos;
	}

	public void setCargarid_sucursalEstadisticaProductos(Boolean cargarid_sucursalEstadisticaProductos) {
		this.cargarid_sucursalEstadisticaProductos= cargarid_sucursalEstadisticaProductos;
	}

	public Border setResaltarid_productoEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadisticaproductosBeanSwingJInternalFrame.jTtoolBarEstadisticaProductos.setBorder(borderResaltar);
		
		this.resaltarid_productoEstadisticaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoEstadisticaProductos() {
		return this.resaltarid_productoEstadisticaProductos;
	}

	public void setResaltarid_productoEstadisticaProductos(Border borderResaltar) {
		this.resaltarid_productoEstadisticaProductos= borderResaltar;
	}

	public Boolean getMostrarid_productoEstadisticaProductos() {
		return this.mostrarid_productoEstadisticaProductos;
	}

	public void setMostrarid_productoEstadisticaProductos(Boolean mostrarid_productoEstadisticaProductos) {
		this.mostrarid_productoEstadisticaProductos= mostrarid_productoEstadisticaProductos;
	}

	public Boolean getActivarid_productoEstadisticaProductos() {
		return this.activarid_productoEstadisticaProductos;
	}

	public void setActivarid_productoEstadisticaProductos(Boolean activarid_productoEstadisticaProductos) {
		this.activarid_productoEstadisticaProductos= activarid_productoEstadisticaProductos;
	}

	public Boolean getCargarid_productoEstadisticaProductos() {
		return this.cargarid_productoEstadisticaProductos;
	}

	public void setCargarid_productoEstadisticaProductos(Boolean cargarid_productoEstadisticaProductos) {
		this.cargarid_productoEstadisticaProductos= cargarid_productoEstadisticaProductos;
	}

	public Border setResaltarfecha_inicioEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadisticaproductosBeanSwingJInternalFrame.jTtoolBarEstadisticaProductos.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioEstadisticaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioEstadisticaProductos() {
		return this.resaltarfecha_inicioEstadisticaProductos;
	}

	public void setResaltarfecha_inicioEstadisticaProductos(Border borderResaltar) {
		this.resaltarfecha_inicioEstadisticaProductos= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioEstadisticaProductos() {
		return this.mostrarfecha_inicioEstadisticaProductos;
	}

	public void setMostrarfecha_inicioEstadisticaProductos(Boolean mostrarfecha_inicioEstadisticaProductos) {
		this.mostrarfecha_inicioEstadisticaProductos= mostrarfecha_inicioEstadisticaProductos;
	}

	public Boolean getActivarfecha_inicioEstadisticaProductos() {
		return this.activarfecha_inicioEstadisticaProductos;
	}

	public void setActivarfecha_inicioEstadisticaProductos(Boolean activarfecha_inicioEstadisticaProductos) {
		this.activarfecha_inicioEstadisticaProductos= activarfecha_inicioEstadisticaProductos;
	}

	public Border setResaltarfecha_finEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadisticaproductosBeanSwingJInternalFrame.jTtoolBarEstadisticaProductos.setBorder(borderResaltar);
		
		this.resaltarfecha_finEstadisticaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finEstadisticaProductos() {
		return this.resaltarfecha_finEstadisticaProductos;
	}

	public void setResaltarfecha_finEstadisticaProductos(Border borderResaltar) {
		this.resaltarfecha_finEstadisticaProductos= borderResaltar;
	}

	public Boolean getMostrarfecha_finEstadisticaProductos() {
		return this.mostrarfecha_finEstadisticaProductos;
	}

	public void setMostrarfecha_finEstadisticaProductos(Boolean mostrarfecha_finEstadisticaProductos) {
		this.mostrarfecha_finEstadisticaProductos= mostrarfecha_finEstadisticaProductos;
	}

	public Boolean getActivarfecha_finEstadisticaProductos() {
		return this.activarfecha_finEstadisticaProductos;
	}

	public void setActivarfecha_finEstadisticaProductos(Boolean activarfecha_finEstadisticaProductos) {
		this.activarfecha_finEstadisticaProductos= activarfecha_finEstadisticaProductos;
	}

	public Border setResaltarcodigo_productoEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadisticaproductosBeanSwingJInternalFrame.jTtoolBarEstadisticaProductos.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoEstadisticaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoEstadisticaProductos() {
		return this.resaltarcodigo_productoEstadisticaProductos;
	}

	public void setResaltarcodigo_productoEstadisticaProductos(Border borderResaltar) {
		this.resaltarcodigo_productoEstadisticaProductos= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoEstadisticaProductos() {
		return this.mostrarcodigo_productoEstadisticaProductos;
	}

	public void setMostrarcodigo_productoEstadisticaProductos(Boolean mostrarcodigo_productoEstadisticaProductos) {
		this.mostrarcodigo_productoEstadisticaProductos= mostrarcodigo_productoEstadisticaProductos;
	}

	public Boolean getActivarcodigo_productoEstadisticaProductos() {
		return this.activarcodigo_productoEstadisticaProductos;
	}

	public void setActivarcodigo_productoEstadisticaProductos(Boolean activarcodigo_productoEstadisticaProductos) {
		this.activarcodigo_productoEstadisticaProductos= activarcodigo_productoEstadisticaProductos;
	}

	public Border setResaltarnombre_productoEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadisticaproductosBeanSwingJInternalFrame.jTtoolBarEstadisticaProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_productoEstadisticaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoEstadisticaProductos() {
		return this.resaltarnombre_productoEstadisticaProductos;
	}

	public void setResaltarnombre_productoEstadisticaProductos(Border borderResaltar) {
		this.resaltarnombre_productoEstadisticaProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_productoEstadisticaProductos() {
		return this.mostrarnombre_productoEstadisticaProductos;
	}

	public void setMostrarnombre_productoEstadisticaProductos(Boolean mostrarnombre_productoEstadisticaProductos) {
		this.mostrarnombre_productoEstadisticaProductos= mostrarnombre_productoEstadisticaProductos;
	}

	public Boolean getActivarnombre_productoEstadisticaProductos() {
		return this.activarnombre_productoEstadisticaProductos;
	}

	public void setActivarnombre_productoEstadisticaProductos(Boolean activarnombre_productoEstadisticaProductos) {
		this.activarnombre_productoEstadisticaProductos= activarnombre_productoEstadisticaProductos;
	}

	public Border setResaltarcantidad_precioEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadisticaproductosBeanSwingJInternalFrame.jTtoolBarEstadisticaProductos.setBorder(borderResaltar);
		
		this.resaltarcantidad_precioEstadisticaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_precioEstadisticaProductos() {
		return this.resaltarcantidad_precioEstadisticaProductos;
	}

	public void setResaltarcantidad_precioEstadisticaProductos(Border borderResaltar) {
		this.resaltarcantidad_precioEstadisticaProductos= borderResaltar;
	}

	public Boolean getMostrarcantidad_precioEstadisticaProductos() {
		return this.mostrarcantidad_precioEstadisticaProductos;
	}

	public void setMostrarcantidad_precioEstadisticaProductos(Boolean mostrarcantidad_precioEstadisticaProductos) {
		this.mostrarcantidad_precioEstadisticaProductos= mostrarcantidad_precioEstadisticaProductos;
	}

	public Boolean getActivarcantidad_precioEstadisticaProductos() {
		return this.activarcantidad_precioEstadisticaProductos;
	}

	public void setActivarcantidad_precioEstadisticaProductos(Boolean activarcantidad_precioEstadisticaProductos) {
		this.activarcantidad_precioEstadisticaProductos= activarcantidad_precioEstadisticaProductos;
	}

	public Border setResaltarcantidadEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadisticaproductosBeanSwingJInternalFrame.jTtoolBarEstadisticaProductos.setBorder(borderResaltar);
		
		this.resaltarcantidadEstadisticaProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadEstadisticaProductos() {
		return this.resaltarcantidadEstadisticaProductos;
	}

	public void setResaltarcantidadEstadisticaProductos(Border borderResaltar) {
		this.resaltarcantidadEstadisticaProductos= borderResaltar;
	}

	public Boolean getMostrarcantidadEstadisticaProductos() {
		return this.mostrarcantidadEstadisticaProductos;
	}

	public void setMostrarcantidadEstadisticaProductos(Boolean mostrarcantidadEstadisticaProductos) {
		this.mostrarcantidadEstadisticaProductos= mostrarcantidadEstadisticaProductos;
	}

	public Boolean getActivarcantidadEstadisticaProductos() {
		return this.activarcantidadEstadisticaProductos;
	}

	public void setActivarcantidadEstadisticaProductos(Boolean activarcantidadEstadisticaProductos) {
		this.activarcantidadEstadisticaProductos= activarcantidadEstadisticaProductos;
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
		
		
		this.setMostraridEstadisticaProductos(esInicial);
		this.setMostrarid_empresaEstadisticaProductos(esInicial);
		this.setMostrarid_sucursalEstadisticaProductos(esInicial);
		this.setMostrarid_productoEstadisticaProductos(esInicial);
		this.setMostrarfecha_inicioEstadisticaProductos(esInicial);
		this.setMostrarfecha_finEstadisticaProductos(esInicial);
		this.setMostrarcodigo_productoEstadisticaProductos(esInicial);
		this.setMostrarnombre_productoEstadisticaProductos(esInicial);
		this.setMostrarcantidad_precioEstadisticaProductos(esInicial);
		this.setMostrarcantidadEstadisticaProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.ID)) {
				this.setMostraridEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.CANTIDADPRECIO)) {
				this.setMostrarcantidad_precioEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadEstadisticaProductos(esAsigna);
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
		
		
		this.setActivaridEstadisticaProductos(esInicial);
		this.setActivarid_empresaEstadisticaProductos(esInicial);
		this.setActivarid_sucursalEstadisticaProductos(esInicial);
		this.setActivarid_productoEstadisticaProductos(esInicial);
		this.setActivarfecha_inicioEstadisticaProductos(esInicial);
		this.setActivarfecha_finEstadisticaProductos(esInicial);
		this.setActivarcodigo_productoEstadisticaProductos(esInicial);
		this.setActivarnombre_productoEstadisticaProductos(esInicial);
		this.setActivarcantidad_precioEstadisticaProductos(esInicial);
		this.setActivarcantidadEstadisticaProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.ID)) {
				this.setActivaridEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.CANTIDADPRECIO)) {
				this.setActivarcantidad_precioEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadEstadisticaProductos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadisticaProductos(esInicial);
		this.setResaltarid_empresaEstadisticaProductos(esInicial);
		this.setResaltarid_sucursalEstadisticaProductos(esInicial);
		this.setResaltarid_productoEstadisticaProductos(esInicial);
		this.setResaltarfecha_inicioEstadisticaProductos(esInicial);
		this.setResaltarfecha_finEstadisticaProductos(esInicial);
		this.setResaltarcodigo_productoEstadisticaProductos(esInicial);
		this.setResaltarnombre_productoEstadisticaProductos(esInicial);
		this.setResaltarcantidad_precioEstadisticaProductos(esInicial);
		this.setResaltarcantidadEstadisticaProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.ID)) {
				this.setResaltaridEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.CANTIDADPRECIO)) {
				this.setResaltarcantidad_precioEstadisticaProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadisticaProductosConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadEstadisticaProductos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaEstadisticaProductosEstadisticaProductos=true;

	public Boolean getMostrarBusquedaEstadisticaProductosEstadisticaProductos() {
		return this.mostrarBusquedaEstadisticaProductosEstadisticaProductos;
	}

	public void setMostrarBusquedaEstadisticaProductosEstadisticaProductos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaEstadisticaProductosEstadisticaProductos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaEstadisticaProductosEstadisticaProductos=true;

	public Boolean getActivarBusquedaEstadisticaProductosEstadisticaProductos() {
		return this.activarBusquedaEstadisticaProductosEstadisticaProductos;
	}

	public void setActivarBusquedaEstadisticaProductosEstadisticaProductos(Boolean habilitarResaltar) {
		this.activarBusquedaEstadisticaProductosEstadisticaProductos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaEstadisticaProductosEstadisticaProductos=null;

	public Border getResaltarBusquedaEstadisticaProductosEstadisticaProductos() {
		return this.resaltarBusquedaEstadisticaProductosEstadisticaProductos;
	}

	public void setResaltarBusquedaEstadisticaProductosEstadisticaProductos(Border borderResaltar) {
		this.resaltarBusquedaEstadisticaProductosEstadisticaProductos= borderResaltar;
	}

	public void setResaltarBusquedaEstadisticaProductosEstadisticaProductos(ParametroGeneralUsuario parametroGeneralUsuario/*EstadisticaProductosBeanSwingJInternalFrame estadisticaproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaEstadisticaProductosEstadisticaProductos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}