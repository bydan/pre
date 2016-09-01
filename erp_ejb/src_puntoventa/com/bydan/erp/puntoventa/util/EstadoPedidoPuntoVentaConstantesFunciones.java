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


import com.bydan.erp.puntoventa.util.EstadoPedidoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.EstadoPedidoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.EstadoPedidoPuntoVentaParameterGeneral;

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
final public class EstadoPedidoPuntoVentaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoPedidoPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoPedidoPuntoVenta"+EstadoPedidoPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoPedidoPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoPedidoPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoPedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+EstadoPedidoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoPedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+EstadoPedidoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoPedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+EstadoPedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoPedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoPedidoPuntoVentaConstantesFunciones.SCHEMA+"_"+EstadoPedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoPedidoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoPedidoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoPedidoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoPedidoPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoPedidoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoPedidoPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Pedidos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Pedido";
	public static final String SCLASSWEBTITULO_LOWER="Estado Pedido Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoPedidoPuntoVenta";
	public static final String OBJECTNAME="estadopedidopuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="estado_pedido_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadopedidopuntoventa from "+EstadoPedidoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" estadopedidopuntoventa";
	public static String QUERYSELECTNATIVE="select "+EstadoPedidoPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoPedidoPuntoVentaConstantesFunciones.TABLENAME+".id,"+EstadoPedidoPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoPedidoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+EstadoPedidoPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoPedidoPuntoVentaConstantesFunciones.TABLENAME+".nombre from "+EstadoPedidoPuntoVentaConstantesFunciones.SCHEMA+"."+EstadoPedidoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+EstadoPedidoPuntoVentaConstantesFunciones.TABLENAME;
	
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
	
	public static String getEstadoPedidoPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoPedidoPuntoVentaConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoPedidoPuntoVentaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getEstadoPedidoPuntoVentaDescripcion(EstadoPedidoPuntoVenta estadopedidopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadopedidopuntoventa !=null/* && estadopedidopuntoventa.getId()!=0*/) {
			sDescripcion=estadopedidopuntoventa.getnombre();//estadopedidopuntoventaestadopedidopuntoventa.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoPedidoPuntoVentaDescripcionDetallado(EstadoPedidoPuntoVenta estadopedidopuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=EstadoPedidoPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=estadopedidopuntoventa.getId().toString()+",";
		sDescripcion+=EstadoPedidoPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadopedidopuntoventa.getVersionRow().toString()+",";
		sDescripcion+=EstadoPedidoPuntoVentaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadopedidopuntoventa.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoPedidoPuntoVentaDescripcion(EstadoPedidoPuntoVenta estadopedidopuntoventa,String sValor) throws Exception {			
		if(estadopedidopuntoventa !=null) {
			estadopedidopuntoventa.setnombre(sValor);;//estadopedidopuntoventaestadopedidopuntoventa.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoPedidoPuntoVenta(EstadoPedidoPuntoVenta estadopedidopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadopedidopuntoventa.setnombre(estadopedidopuntoventa.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoPedidoPuntoVentas(List<EstadoPedidoPuntoVenta> estadopedidopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoPedidoPuntoVenta estadopedidopuntoventa: estadopedidopuntoventas) {
			estadopedidopuntoventa.setnombre(estadopedidopuntoventa.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPedidoPuntoVenta(EstadoPedidoPuntoVenta estadopedidopuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadopedidopuntoventa.getConCambioAuxiliar()) {
			estadopedidopuntoventa.setIsDeleted(estadopedidopuntoventa.getIsDeletedAuxiliar());	
			estadopedidopuntoventa.setIsNew(estadopedidopuntoventa.getIsNewAuxiliar());	
			estadopedidopuntoventa.setIsChanged(estadopedidopuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadopedidopuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadopedidopuntoventa.setIsDeletedAuxiliar(false);	
			estadopedidopuntoventa.setIsNewAuxiliar(false);	
			estadopedidopuntoventa.setIsChangedAuxiliar(false);
			
			estadopedidopuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoPedidoPuntoVentas(List<EstadoPedidoPuntoVenta> estadopedidopuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoPedidoPuntoVenta estadopedidopuntoventa : estadopedidopuntoventas) {
			if(conAsignarBase && estadopedidopuntoventa.getConCambioAuxiliar()) {
				estadopedidopuntoventa.setIsDeleted(estadopedidopuntoventa.getIsDeletedAuxiliar());	
				estadopedidopuntoventa.setIsNew(estadopedidopuntoventa.getIsNewAuxiliar());	
				estadopedidopuntoventa.setIsChanged(estadopedidopuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadopedidopuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadopedidopuntoventa.setIsDeletedAuxiliar(false);	
				estadopedidopuntoventa.setIsNewAuxiliar(false);	
				estadopedidopuntoventa.setIsChangedAuxiliar(false);
				
				estadopedidopuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoPedidoPuntoVenta(EstadoPedidoPuntoVenta estadopedidopuntoventa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoPedidoPuntoVentas(List<EstadoPedidoPuntoVenta> estadopedidopuntoventas,Boolean conEnteros) throws Exception  {
		
		for(EstadoPedidoPuntoVenta estadopedidopuntoventa: estadopedidopuntoventas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoPedidoPuntoVenta(List<EstadoPedidoPuntoVenta> estadopedidopuntoventas,EstadoPedidoPuntoVenta estadopedidopuntoventaAux) throws Exception  {
		EstadoPedidoPuntoVentaConstantesFunciones.InicializarValoresEstadoPedidoPuntoVenta(estadopedidopuntoventaAux,true);
		
		for(EstadoPedidoPuntoVenta estadopedidopuntoventa: estadopedidopuntoventas) {
			if(estadopedidopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPedidoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoPedidoPuntoVentaConstantesFunciones.getArrayColumnasGlobalesEstadoPedidoPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoPedidoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoPedidoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoPedidoPuntoVenta> estadopedidopuntoventas,EstadoPedidoPuntoVenta estadopedidopuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoPedidoPuntoVenta estadopedidopuntoventaAux: estadopedidopuntoventas) {
			if(estadopedidopuntoventaAux!=null && estadopedidopuntoventa!=null) {
				if((estadopedidopuntoventaAux.getId()==null && estadopedidopuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadopedidopuntoventaAux.getId()!=null && estadopedidopuntoventa.getId()!=null){
					if(estadopedidopuntoventaAux.getId().equals(estadopedidopuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoPedidoPuntoVenta(List<EstadoPedidoPuntoVenta> estadopedidopuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoPedidoPuntoVenta estadopedidopuntoventa: estadopedidopuntoventas) {			
			if(estadopedidopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoPedidoPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoPedidoPuntoVentaConstantesFunciones.LABEL_ID, EstadoPedidoPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPedidoPuntoVentaConstantesFunciones.LABEL_VERSIONROW, EstadoPedidoPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoPedidoPuntoVentaConstantesFunciones.LABEL_NOMBRE, EstadoPedidoPuntoVentaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoPedidoPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoPedidoPuntoVentaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPedidoPuntoVenta() throws Exception  {
		return EstadoPedidoPuntoVentaConstantesFunciones.getTiposSeleccionarEstadoPedidoPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPedidoPuntoVenta(Boolean conFk) throws Exception  {
		return EstadoPedidoPuntoVentaConstantesFunciones.getTiposSeleccionarEstadoPedidoPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoPedidoPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoPedidoPuntoVentaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoPedidoPuntoVentaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoPedidoPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(EstadoPedidoPuntoVenta estadopedidopuntoventaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoPedidoPuntoVenta(List<EstadoPedidoPuntoVenta> estadopedidopuntoventasTemp) throws Exception {
		for(EstadoPedidoPuntoVenta estadopedidopuntoventaAux:estadopedidopuntoventasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoPedidoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPedidoPuntoVentaConstantesFunciones.getClassesRelationshipsOfEstadoPedidoPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPedidoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PedidoPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoPuntoVenta.class)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPedidoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoPedidoPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoPedidoPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoPedidoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
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
	public static void actualizarLista(EstadoPedidoPuntoVenta estadopedidopuntoventa,List<EstadoPedidoPuntoVenta> estadopedidopuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoPedidoPuntoVenta estadopedidopuntoventaEncontrado=null;
			
			for(EstadoPedidoPuntoVenta estadopedidopuntoventaLocal:estadopedidopuntoventas) {
				if(estadopedidopuntoventaLocal.getId().equals(estadopedidopuntoventa.getId())) {
					estadopedidopuntoventaEncontrado=estadopedidopuntoventaLocal;
					
					estadopedidopuntoventaLocal.setIsChanged(estadopedidopuntoventa.getIsChanged());
					estadopedidopuntoventaLocal.setIsNew(estadopedidopuntoventa.getIsNew());
					estadopedidopuntoventaLocal.setIsDeleted(estadopedidopuntoventa.getIsDeleted());
					
					estadopedidopuntoventaLocal.setGeneralEntityOriginal(estadopedidopuntoventa.getGeneralEntityOriginal());
					
					estadopedidopuntoventaLocal.setId(estadopedidopuntoventa.getId());	
					estadopedidopuntoventaLocal.setVersionRow(estadopedidopuntoventa.getVersionRow());	
					estadopedidopuntoventaLocal.setnombre(estadopedidopuntoventa.getnombre());	
					
					
					estadopedidopuntoventaLocal.setPedidoPuntoVentas(estadopedidopuntoventa.getPedidoPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!estadopedidopuntoventa.getIsDeleted()) {
				if(!existe) {
					estadopedidopuntoventas.add(estadopedidopuntoventa);
				}
			} else {
				if(estadopedidopuntoventaEncontrado!=null && permiteQuitar)  {
					estadopedidopuntoventas.remove(estadopedidopuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoPedidoPuntoVenta estadopedidopuntoventa,List<EstadoPedidoPuntoVenta> estadopedidopuntoventas) throws Exception {
		try	{			
			for(EstadoPedidoPuntoVenta estadopedidopuntoventaLocal:estadopedidopuntoventas) {
				if(estadopedidopuntoventaLocal.getId().equals(estadopedidopuntoventa.getId())) {
					estadopedidopuntoventaLocal.setIsSelected(estadopedidopuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoPedidoPuntoVenta(List<EstadoPedidoPuntoVenta> estadopedidopuntoventasAux) throws Exception {
		//this.estadopedidopuntoventasAux=estadopedidopuntoventasAux;
		
		for(EstadoPedidoPuntoVenta estadopedidopuntoventaAux:estadopedidopuntoventasAux) {
			if(estadopedidopuntoventaAux.getIsChanged()) {
				estadopedidopuntoventaAux.setIsChanged(false);
			}		
			
			if(estadopedidopuntoventaAux.getIsNew()) {
				estadopedidopuntoventaAux.setIsNew(false);
			}	
			
			if(estadopedidopuntoventaAux.getIsDeleted()) {
				estadopedidopuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoPedidoPuntoVenta(EstadoPedidoPuntoVenta estadopedidopuntoventaAux) throws Exception {
		//this.estadopedidopuntoventaAux=estadopedidopuntoventaAux;
		
			if(estadopedidopuntoventaAux.getIsChanged()) {
				estadopedidopuntoventaAux.setIsChanged(false);
			}		
			
			if(estadopedidopuntoventaAux.getIsNew()) {
				estadopedidopuntoventaAux.setIsNew(false);
			}	
			
			if(estadopedidopuntoventaAux.getIsDeleted()) {
				estadopedidopuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoPedidoPuntoVenta estadopedidopuntoventaAsignar,EstadoPedidoPuntoVenta estadopedidopuntoventa) throws Exception {
		estadopedidopuntoventaAsignar.setId(estadopedidopuntoventa.getId());	
		estadopedidopuntoventaAsignar.setVersionRow(estadopedidopuntoventa.getVersionRow());	
		estadopedidopuntoventaAsignar.setnombre(estadopedidopuntoventa.getnombre());	
	}
	
	public static void inicializarEstadoPedidoPuntoVenta(EstadoPedidoPuntoVenta estadopedidopuntoventa) throws Exception {
		try {
				estadopedidopuntoventa.setId(0L);	
					
				estadopedidopuntoventa.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoPedidoPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoPedidoPuntoVentaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoPedidoPuntoVenta(String sTipo,Row row,Workbook workbook,EstadoPedidoPuntoVenta estadopedidopuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadopedidopuntoventa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoPedidoPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoPedidoPuntoVenta() {
		return this.sFinalQueryEstadoPedidoPuntoVenta;
	}
	
	public void setsFinalQueryEstadoPedidoPuntoVenta(String sFinalQueryEstadoPedidoPuntoVenta) {
		this.sFinalQueryEstadoPedidoPuntoVenta= sFinalQueryEstadoPedidoPuntoVenta;
	}
	
	public Border resaltarSeleccionarEstadoPedidoPuntoVenta=null;
	
	public Border setResaltarSeleccionarEstadoPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoPuntoVentaBeanSwingJInternalFrame estadopedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadopedidopuntoventaBeanSwingJInternalFrame.jTtoolBarEstadoPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoPedidoPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoPedidoPuntoVenta() {
		return this.resaltarSeleccionarEstadoPedidoPuntoVenta;
	}
	
	public void setResaltarSeleccionarEstadoPedidoPuntoVenta(Border borderResaltarSeleccionarEstadoPedidoPuntoVenta) {
		this.resaltarSeleccionarEstadoPedidoPuntoVenta= borderResaltarSeleccionarEstadoPedidoPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoPedidoPuntoVenta=null;
	public Boolean mostraridEstadoPedidoPuntoVenta=true;
	public Boolean activaridEstadoPedidoPuntoVenta=true;

	public Border resaltarnombreEstadoPedidoPuntoVenta=null;
	public Boolean mostrarnombreEstadoPedidoPuntoVenta=true;
	public Boolean activarnombreEstadoPedidoPuntoVenta=true;

	
	

	public Border setResaltaridEstadoPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoPuntoVentaBeanSwingJInternalFrame estadopedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopedidopuntoventaBeanSwingJInternalFrame.jTtoolBarEstadoPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridEstadoPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoPedidoPuntoVenta() {
		return this.resaltaridEstadoPedidoPuntoVenta;
	}

	public void setResaltaridEstadoPedidoPuntoVenta(Border borderResaltar) {
		this.resaltaridEstadoPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridEstadoPedidoPuntoVenta() {
		return this.mostraridEstadoPedidoPuntoVenta;
	}

	public void setMostraridEstadoPedidoPuntoVenta(Boolean mostraridEstadoPedidoPuntoVenta) {
		this.mostraridEstadoPedidoPuntoVenta= mostraridEstadoPedidoPuntoVenta;
	}

	public Boolean getActivaridEstadoPedidoPuntoVenta() {
		return this.activaridEstadoPedidoPuntoVenta;
	}

	public void setActivaridEstadoPedidoPuntoVenta(Boolean activaridEstadoPedidoPuntoVenta) {
		this.activaridEstadoPedidoPuntoVenta= activaridEstadoPedidoPuntoVenta;
	}

	public Border setResaltarnombreEstadoPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoPuntoVentaBeanSwingJInternalFrame estadopedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadopedidopuntoventaBeanSwingJInternalFrame.jTtoolBarEstadoPedidoPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoPedidoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoPedidoPuntoVenta() {
		return this.resaltarnombreEstadoPedidoPuntoVenta;
	}

	public void setResaltarnombreEstadoPedidoPuntoVenta(Border borderResaltar) {
		this.resaltarnombreEstadoPedidoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoPedidoPuntoVenta() {
		return this.mostrarnombreEstadoPedidoPuntoVenta;
	}

	public void setMostrarnombreEstadoPedidoPuntoVenta(Boolean mostrarnombreEstadoPedidoPuntoVenta) {
		this.mostrarnombreEstadoPedidoPuntoVenta= mostrarnombreEstadoPedidoPuntoVenta;
	}

	public Boolean getActivarnombreEstadoPedidoPuntoVenta() {
		return this.activarnombreEstadoPedidoPuntoVenta;
	}

	public void setActivarnombreEstadoPedidoPuntoVenta(Boolean activarnombreEstadoPedidoPuntoVenta) {
		this.activarnombreEstadoPedidoPuntoVenta= activarnombreEstadoPedidoPuntoVenta;
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
		
		
		this.setMostraridEstadoPedidoPuntoVenta(esInicial);
		this.setMostrarnombreEstadoPedidoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPedidoPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridEstadoPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoPuntoVentaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoPedidoPuntoVenta(esAsigna);
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
		
		
		this.setActivaridEstadoPedidoPuntoVenta(esInicial);
		this.setActivarnombreEstadoPedidoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPedidoPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridEstadoPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoPuntoVentaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoPedidoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPedidoPuntoVentaBeanSwingJInternalFrame estadopedidopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoPedidoPuntoVenta(esInicial);
		this.setResaltarnombreEstadoPedidoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoPedidoPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridEstadoPedidoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoPedidoPuntoVentaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoPedidoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPedidoPuntoVentaEstadoPedidoPuntoVenta=null;

	public Border getResaltarPedidoPuntoVentaEstadoPedidoPuntoVenta() {
		return this.resaltarPedidoPuntoVentaEstadoPedidoPuntoVenta;
	}

	public void setResaltarPedidoPuntoVentaEstadoPedidoPuntoVenta(Border borderResaltarPedidoPuntoVenta) {
		if(borderResaltarPedidoPuntoVenta!=null) {
			this.resaltarPedidoPuntoVentaEstadoPedidoPuntoVenta= borderResaltarPedidoPuntoVenta;
		}
	}

	public Border setResaltarPedidoPuntoVentaEstadoPedidoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoPedidoPuntoVentaBeanSwingJInternalFrame estadopedidopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadopedidopuntoventaBeanSwingJInternalFrame.jTtoolBarEstadoPedidoPuntoVenta.setBorder(borderResaltarPedidoPuntoVenta);
			
		this.resaltarPedidoPuntoVentaEstadoPedidoPuntoVenta= borderResaltarPedidoPuntoVenta;

		 return borderResaltarPedidoPuntoVenta;
	}



	public Boolean mostrarPedidoPuntoVentaEstadoPedidoPuntoVenta=true;

	public Boolean getMostrarPedidoPuntoVentaEstadoPedidoPuntoVenta() {
		return this.mostrarPedidoPuntoVentaEstadoPedidoPuntoVenta;
	}

	public void setMostrarPedidoPuntoVentaEstadoPedidoPuntoVenta(Boolean visibilidadResaltarPedidoPuntoVenta) {
		this.mostrarPedidoPuntoVentaEstadoPedidoPuntoVenta= visibilidadResaltarPedidoPuntoVenta;
	}



	public Boolean activarPedidoPuntoVentaEstadoPedidoPuntoVenta=true;

	public Boolean gethabilitarResaltarPedidoPuntoVentaEstadoPedidoPuntoVenta() {
		return this.activarPedidoPuntoVentaEstadoPedidoPuntoVenta;
	}

	public void setActivarPedidoPuntoVentaEstadoPedidoPuntoVenta(Boolean habilitarResaltarPedidoPuntoVenta) {
		this.activarPedidoPuntoVentaEstadoPedidoPuntoVenta= habilitarResaltarPedidoPuntoVenta;
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

		this.setMostrarPedidoPuntoVentaEstadoPedidoPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setMostrarPedidoPuntoVentaEstadoPedidoPuntoVenta(esAsigna);
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

		this.setActivarPedidoPuntoVentaEstadoPedidoPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setActivarPedidoPuntoVentaEstadoPedidoPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoPedidoPuntoVentaBeanSwingJInternalFrame estadopedidopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPedidoPuntoVentaEstadoPedidoPuntoVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setResaltarPedidoPuntoVentaEstadoPedidoPuntoVenta(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}