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


import com.bydan.erp.puntoventa.util.EstadoFacturaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.EstadoFacturaPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.EstadoFacturaPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoFacturaPuntoVentaConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="EstadoFacturaPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoFacturaPuntoVenta"+EstadoFacturaPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoFacturaPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoFacturaPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+EstadoFacturaPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+EstadoFacturaPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+EstadoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"_"+EstadoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoFacturaPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFacturaPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoFacturaPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoFacturaPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoFacturaPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoFacturaPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Facturas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Factura";
	public static final String SCLASSWEBTITULO_LOWER="Estado Factura Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoFacturaPuntoVenta";
	public static final String OBJECTNAME="estadofacturapuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="estado_factura_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadofacturapuntoventa from "+EstadoFacturaPuntoVentaConstantesFunciones.SPERSISTENCENAME+" estadofacturapuntoventa";
	public static String QUERYSELECTNATIVE="select "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+".id,"+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME+".nombre from "+EstadoFacturaPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME;//+" as "+EstadoFacturaPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEstadoFacturaPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoFacturaPuntoVentaConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoFacturaPuntoVentaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getEstadoFacturaPuntoVentaDescripcion(EstadoFacturaPuntoVenta estadofacturapuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadofacturapuntoventa !=null/* && estadofacturapuntoventa.getId()!=0*/) {
			sDescripcion=estadofacturapuntoventa.getnombre();//estadofacturapuntoventaestadofacturapuntoventa.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoFacturaPuntoVentaDescripcionDetallado(EstadoFacturaPuntoVenta estadofacturapuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=EstadoFacturaPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=estadofacturapuntoventa.getId().toString()+",";
		sDescripcion+=EstadoFacturaPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadofacturapuntoventa.getVersionRow().toString()+",";
		sDescripcion+=EstadoFacturaPuntoVentaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadofacturapuntoventa.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoFacturaPuntoVentaDescripcion(EstadoFacturaPuntoVenta estadofacturapuntoventa,String sValor) throws Exception {			
		if(estadofacturapuntoventa !=null) {
			estadofacturapuntoventa.setnombre(sValor);;//estadofacturapuntoventaestadofacturapuntoventa.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoFacturaPuntoVenta(EstadoFacturaPuntoVenta estadofacturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadofacturapuntoventa.setnombre(estadofacturapuntoventa.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoFacturaPuntoVentas(List<EstadoFacturaPuntoVenta> estadofacturapuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoFacturaPuntoVenta estadofacturapuntoventa: estadofacturapuntoventas) {
			estadofacturapuntoventa.setnombre(estadofacturapuntoventa.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoFacturaPuntoVenta(EstadoFacturaPuntoVenta estadofacturapuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadofacturapuntoventa.getConCambioAuxiliar()) {
			estadofacturapuntoventa.setIsDeleted(estadofacturapuntoventa.getIsDeletedAuxiliar());	
			estadofacturapuntoventa.setIsNew(estadofacturapuntoventa.getIsNewAuxiliar());	
			estadofacturapuntoventa.setIsChanged(estadofacturapuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadofacturapuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadofacturapuntoventa.setIsDeletedAuxiliar(false);	
			estadofacturapuntoventa.setIsNewAuxiliar(false);	
			estadofacturapuntoventa.setIsChangedAuxiliar(false);
			
			estadofacturapuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoFacturaPuntoVentas(List<EstadoFacturaPuntoVenta> estadofacturapuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoFacturaPuntoVenta estadofacturapuntoventa : estadofacturapuntoventas) {
			if(conAsignarBase && estadofacturapuntoventa.getConCambioAuxiliar()) {
				estadofacturapuntoventa.setIsDeleted(estadofacturapuntoventa.getIsDeletedAuxiliar());	
				estadofacturapuntoventa.setIsNew(estadofacturapuntoventa.getIsNewAuxiliar());	
				estadofacturapuntoventa.setIsChanged(estadofacturapuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadofacturapuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadofacturapuntoventa.setIsDeletedAuxiliar(false);	
				estadofacturapuntoventa.setIsNewAuxiliar(false);	
				estadofacturapuntoventa.setIsChangedAuxiliar(false);
				
				estadofacturapuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoFacturaPuntoVenta(EstadoFacturaPuntoVenta estadofacturapuntoventa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoFacturaPuntoVentas(List<EstadoFacturaPuntoVenta> estadofacturapuntoventas,Boolean conEnteros) throws Exception  {
		
		for(EstadoFacturaPuntoVenta estadofacturapuntoventa: estadofacturapuntoventas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoFacturaPuntoVenta(List<EstadoFacturaPuntoVenta> estadofacturapuntoventas,EstadoFacturaPuntoVenta estadofacturapuntoventaAux) throws Exception  {
		EstadoFacturaPuntoVentaConstantesFunciones.InicializarValoresEstadoFacturaPuntoVenta(estadofacturapuntoventaAux,true);
		
		for(EstadoFacturaPuntoVenta estadofacturapuntoventa: estadofacturapuntoventas) {
			if(estadofacturapuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoFacturaPuntoVentaConstantesFunciones.getArrayColumnasGlobalesEstadoFacturaPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoFacturaPuntoVenta> estadofacturapuntoventas,EstadoFacturaPuntoVenta estadofacturapuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoFacturaPuntoVenta estadofacturapuntoventaAux: estadofacturapuntoventas) {
			if(estadofacturapuntoventaAux!=null && estadofacturapuntoventa!=null) {
				if((estadofacturapuntoventaAux.getId()==null && estadofacturapuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadofacturapuntoventaAux.getId()!=null && estadofacturapuntoventa.getId()!=null){
					if(estadofacturapuntoventaAux.getId().equals(estadofacturapuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoFacturaPuntoVenta(List<EstadoFacturaPuntoVenta> estadofacturapuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoFacturaPuntoVenta estadofacturapuntoventa: estadofacturapuntoventas) {			
			if(estadofacturapuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoFacturaPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoFacturaPuntoVentaConstantesFunciones.LABEL_ID, EstadoFacturaPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFacturaPuntoVentaConstantesFunciones.LABEL_VERSIONROW, EstadoFacturaPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFacturaPuntoVentaConstantesFunciones.LABEL_NOMBRE, EstadoFacturaPuntoVentaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoFacturaPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoFacturaPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFacturaPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFacturaPuntoVentaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFacturaPuntoVenta() throws Exception  {
		return EstadoFacturaPuntoVentaConstantesFunciones.getTiposSeleccionarEstadoFacturaPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFacturaPuntoVenta(Boolean conFk) throws Exception  {
		return EstadoFacturaPuntoVentaConstantesFunciones.getTiposSeleccionarEstadoFacturaPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFacturaPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoFacturaPuntoVentaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoFacturaPuntoVentaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoFacturaPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(EstadoFacturaPuntoVenta estadofacturapuntoventaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoFacturaPuntoVenta(List<EstadoFacturaPuntoVenta> estadofacturapuntoventasTemp) throws Exception {
		for(EstadoFacturaPuntoVenta estadofacturapuntoventaAux:estadofacturapuntoventasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoFacturaPuntoVentaConstantesFunciones.getClassesRelationshipsOfEstadoFacturaPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFacturaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FacturaPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaPuntoVenta.class)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoFacturaPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoFacturaPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoFacturaPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
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
	public static void actualizarLista(EstadoFacturaPuntoVenta estadofacturapuntoventa,List<EstadoFacturaPuntoVenta> estadofacturapuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoFacturaPuntoVenta estadofacturapuntoventaEncontrado=null;
			
			for(EstadoFacturaPuntoVenta estadofacturapuntoventaLocal:estadofacturapuntoventas) {
				if(estadofacturapuntoventaLocal.getId().equals(estadofacturapuntoventa.getId())) {
					estadofacturapuntoventaEncontrado=estadofacturapuntoventaLocal;
					
					estadofacturapuntoventaLocal.setIsChanged(estadofacturapuntoventa.getIsChanged());
					estadofacturapuntoventaLocal.setIsNew(estadofacturapuntoventa.getIsNew());
					estadofacturapuntoventaLocal.setIsDeleted(estadofacturapuntoventa.getIsDeleted());
					
					estadofacturapuntoventaLocal.setGeneralEntityOriginal(estadofacturapuntoventa.getGeneralEntityOriginal());
					
					estadofacturapuntoventaLocal.setId(estadofacturapuntoventa.getId());	
					estadofacturapuntoventaLocal.setVersionRow(estadofacturapuntoventa.getVersionRow());	
					estadofacturapuntoventaLocal.setnombre(estadofacturapuntoventa.getnombre());	
					
					
					estadofacturapuntoventaLocal.setFacturaPuntoVentas(estadofacturapuntoventa.getFacturaPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!estadofacturapuntoventa.getIsDeleted()) {
				if(!existe) {
					estadofacturapuntoventas.add(estadofacturapuntoventa);
				}
			} else {
				if(estadofacturapuntoventaEncontrado!=null && permiteQuitar)  {
					estadofacturapuntoventas.remove(estadofacturapuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoFacturaPuntoVenta estadofacturapuntoventa,List<EstadoFacturaPuntoVenta> estadofacturapuntoventas) throws Exception {
		try	{			
			for(EstadoFacturaPuntoVenta estadofacturapuntoventaLocal:estadofacturapuntoventas) {
				if(estadofacturapuntoventaLocal.getId().equals(estadofacturapuntoventa.getId())) {
					estadofacturapuntoventaLocal.setIsSelected(estadofacturapuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoFacturaPuntoVenta(List<EstadoFacturaPuntoVenta> estadofacturapuntoventasAux) throws Exception {
		//this.estadofacturapuntoventasAux=estadofacturapuntoventasAux;
		
		for(EstadoFacturaPuntoVenta estadofacturapuntoventaAux:estadofacturapuntoventasAux) {
			if(estadofacturapuntoventaAux.getIsChanged()) {
				estadofacturapuntoventaAux.setIsChanged(false);
			}		
			
			if(estadofacturapuntoventaAux.getIsNew()) {
				estadofacturapuntoventaAux.setIsNew(false);
			}	
			
			if(estadofacturapuntoventaAux.getIsDeleted()) {
				estadofacturapuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoFacturaPuntoVenta(EstadoFacturaPuntoVenta estadofacturapuntoventaAux) throws Exception {
		//this.estadofacturapuntoventaAux=estadofacturapuntoventaAux;
		
			if(estadofacturapuntoventaAux.getIsChanged()) {
				estadofacturapuntoventaAux.setIsChanged(false);
			}		
			
			if(estadofacturapuntoventaAux.getIsNew()) {
				estadofacturapuntoventaAux.setIsNew(false);
			}	
			
			if(estadofacturapuntoventaAux.getIsDeleted()) {
				estadofacturapuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoFacturaPuntoVenta estadofacturapuntoventaAsignar,EstadoFacturaPuntoVenta estadofacturapuntoventa) throws Exception {
		estadofacturapuntoventaAsignar.setId(estadofacturapuntoventa.getId());	
		estadofacturapuntoventaAsignar.setVersionRow(estadofacturapuntoventa.getVersionRow());	
		estadofacturapuntoventaAsignar.setnombre(estadofacturapuntoventa.getnombre());	
	}
	
	public static void inicializarEstadoFacturaPuntoVenta(EstadoFacturaPuntoVenta estadofacturapuntoventa) throws Exception {
		try {
				estadofacturapuntoventa.setId(0L);	
					
				estadofacturapuntoventa.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoFacturaPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoFacturaPuntoVentaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoFacturaPuntoVenta(String sTipo,Row row,Workbook workbook,EstadoFacturaPuntoVenta estadofacturapuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadofacturapuntoventa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoFacturaPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoFacturaPuntoVenta() {
		return this.sFinalQueryEstadoFacturaPuntoVenta;
	}
	
	public void setsFinalQueryEstadoFacturaPuntoVenta(String sFinalQueryEstadoFacturaPuntoVenta) {
		this.sFinalQueryEstadoFacturaPuntoVenta= sFinalQueryEstadoFacturaPuntoVenta;
	}
	
	public Border resaltarSeleccionarEstadoFacturaPuntoVenta=null;
	
	public Border setResaltarSeleccionarEstadoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFacturaPuntoVentaBeanSwingJInternalFrame estadofacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadofacturapuntoventaBeanSwingJInternalFrame.jTtoolBarEstadoFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoFacturaPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoFacturaPuntoVenta() {
		return this.resaltarSeleccionarEstadoFacturaPuntoVenta;
	}
	
	public void setResaltarSeleccionarEstadoFacturaPuntoVenta(Border borderResaltarSeleccionarEstadoFacturaPuntoVenta) {
		this.resaltarSeleccionarEstadoFacturaPuntoVenta= borderResaltarSeleccionarEstadoFacturaPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoFacturaPuntoVenta=null;
	public Boolean mostraridEstadoFacturaPuntoVenta=true;
	public Boolean activaridEstadoFacturaPuntoVenta=true;

	public Border resaltarnombreEstadoFacturaPuntoVenta=null;
	public Boolean mostrarnombreEstadoFacturaPuntoVenta=true;
	public Boolean activarnombreEstadoFacturaPuntoVenta=true;

	
	

	public Border setResaltaridEstadoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFacturaPuntoVentaBeanSwingJInternalFrame estadofacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofacturapuntoventaBeanSwingJInternalFrame.jTtoolBarEstadoFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridEstadoFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoFacturaPuntoVenta() {
		return this.resaltaridEstadoFacturaPuntoVenta;
	}

	public void setResaltaridEstadoFacturaPuntoVenta(Border borderResaltar) {
		this.resaltaridEstadoFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridEstadoFacturaPuntoVenta() {
		return this.mostraridEstadoFacturaPuntoVenta;
	}

	public void setMostraridEstadoFacturaPuntoVenta(Boolean mostraridEstadoFacturaPuntoVenta) {
		this.mostraridEstadoFacturaPuntoVenta= mostraridEstadoFacturaPuntoVenta;
	}

	public Boolean getActivaridEstadoFacturaPuntoVenta() {
		return this.activaridEstadoFacturaPuntoVenta;
	}

	public void setActivaridEstadoFacturaPuntoVenta(Boolean activaridEstadoFacturaPuntoVenta) {
		this.activaridEstadoFacturaPuntoVenta= activaridEstadoFacturaPuntoVenta;
	}

	public Border setResaltarnombreEstadoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFacturaPuntoVentaBeanSwingJInternalFrame estadofacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofacturapuntoventaBeanSwingJInternalFrame.jTtoolBarEstadoFacturaPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoFacturaPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoFacturaPuntoVenta() {
		return this.resaltarnombreEstadoFacturaPuntoVenta;
	}

	public void setResaltarnombreEstadoFacturaPuntoVenta(Border borderResaltar) {
		this.resaltarnombreEstadoFacturaPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoFacturaPuntoVenta() {
		return this.mostrarnombreEstadoFacturaPuntoVenta;
	}

	public void setMostrarnombreEstadoFacturaPuntoVenta(Boolean mostrarnombreEstadoFacturaPuntoVenta) {
		this.mostrarnombreEstadoFacturaPuntoVenta= mostrarnombreEstadoFacturaPuntoVenta;
	}

	public Boolean getActivarnombreEstadoFacturaPuntoVenta() {
		return this.activarnombreEstadoFacturaPuntoVenta;
	}

	public void setActivarnombreEstadoFacturaPuntoVenta(Boolean activarnombreEstadoFacturaPuntoVenta) {
		this.activarnombreEstadoFacturaPuntoVenta= activarnombreEstadoFacturaPuntoVenta;
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
		
		
		this.setMostraridEstadoFacturaPuntoVenta(esInicial);
		this.setMostrarnombreEstadoFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFacturaPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridEstadoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFacturaPuntoVentaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoFacturaPuntoVenta(esAsigna);
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
		
		
		this.setActivaridEstadoFacturaPuntoVenta(esInicial);
		this.setActivarnombreEstadoFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFacturaPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridEstadoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFacturaPuntoVentaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoFacturaPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoFacturaPuntoVentaBeanSwingJInternalFrame estadofacturapuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoFacturaPuntoVenta(esInicial);
		this.setResaltarnombreEstadoFacturaPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFacturaPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridEstadoFacturaPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFacturaPuntoVentaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoFacturaPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFacturaPuntoVentaEstadoFacturaPuntoVenta=null;

	public Border getResaltarFacturaPuntoVentaEstadoFacturaPuntoVenta() {
		return this.resaltarFacturaPuntoVentaEstadoFacturaPuntoVenta;
	}

	public void setResaltarFacturaPuntoVentaEstadoFacturaPuntoVenta(Border borderResaltarFacturaPuntoVenta) {
		if(borderResaltarFacturaPuntoVenta!=null) {
			this.resaltarFacturaPuntoVentaEstadoFacturaPuntoVenta= borderResaltarFacturaPuntoVenta;
		}
	}

	public Border setResaltarFacturaPuntoVentaEstadoFacturaPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFacturaPuntoVentaBeanSwingJInternalFrame estadofacturapuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltarFacturaPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadofacturapuntoventaBeanSwingJInternalFrame.jTtoolBarEstadoFacturaPuntoVenta.setBorder(borderResaltarFacturaPuntoVenta);
			
		this.resaltarFacturaPuntoVentaEstadoFacturaPuntoVenta= borderResaltarFacturaPuntoVenta;

		 return borderResaltarFacturaPuntoVenta;
	}



	public Boolean mostrarFacturaPuntoVentaEstadoFacturaPuntoVenta=true;

	public Boolean getMostrarFacturaPuntoVentaEstadoFacturaPuntoVenta() {
		return this.mostrarFacturaPuntoVentaEstadoFacturaPuntoVenta;
	}

	public void setMostrarFacturaPuntoVentaEstadoFacturaPuntoVenta(Boolean visibilidadResaltarFacturaPuntoVenta) {
		this.mostrarFacturaPuntoVentaEstadoFacturaPuntoVenta= visibilidadResaltarFacturaPuntoVenta;
	}



	public Boolean activarFacturaPuntoVentaEstadoFacturaPuntoVenta=true;

	public Boolean gethabilitarResaltarFacturaPuntoVentaEstadoFacturaPuntoVenta() {
		return this.activarFacturaPuntoVentaEstadoFacturaPuntoVenta;
	}

	public void setActivarFacturaPuntoVentaEstadoFacturaPuntoVenta(Boolean habilitarResaltarFacturaPuntoVenta) {
		this.activarFacturaPuntoVentaEstadoFacturaPuntoVenta= habilitarResaltarFacturaPuntoVenta;
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

		this.setMostrarFacturaPuntoVentaEstadoFacturaPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setMostrarFacturaPuntoVentaEstadoFacturaPuntoVenta(esAsigna);
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

		this.setActivarFacturaPuntoVentaEstadoFacturaPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setActivarFacturaPuntoVentaEstadoFacturaPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoFacturaPuntoVentaBeanSwingJInternalFrame estadofacturapuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFacturaPuntoVentaEstadoFacturaPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setResaltarFacturaPuntoVentaEstadoFacturaPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}