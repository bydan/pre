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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.EstadoNovedadSeguimientoConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoNovedadSeguimientoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoNovedadSeguimientoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoNovedadSeguimientoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoNovedadSeguimiento";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoNovedadSeguimiento"+EstadoNovedadSeguimientoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoNovedadSeguimientoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoNovedadSeguimientoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"_"+EstadoNovedadSeguimientoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoNovedadSeguimientoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"_"+EstadoNovedadSeguimientoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"_"+EstadoNovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoNovedadSeguimientoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"_"+EstadoNovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoNovedadSeguimientoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoNovedadSeguimientoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoNovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoNovedadSeguimientoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoNovedadSeguimientoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoNovedadSeguimientoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoNovedadSeguimientoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Novedad Seguimientoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Estado Novedad Seguimiento";
	public static final String SCLASSWEBTITULO_LOWER="Estado Novedad Seguimiento";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoNovedadSeguimiento";
	public static final String OBJECTNAME="estadonovedadseguimiento";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_novedad_seguimiento";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadonovedadseguimiento from "+EstadoNovedadSeguimientoConstantesFunciones.SPERSISTENCENAME+" estadonovedadseguimiento";
	public static String QUERYSELECTNATIVE="select "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+".id,"+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+".version_row,"+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+".codigo,"+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME+".nombre from "+EstadoNovedadSeguimientoConstantesFunciones.SCHEMA+"."+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME;//+" as "+EstadoNovedadSeguimientoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEstadoNovedadSeguimientoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoNovedadSeguimientoConstantesFunciones.CODIGO)) {sLabelColumna=EstadoNovedadSeguimientoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoNovedadSeguimientoConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoNovedadSeguimientoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoNovedadSeguimientoDescripcion(EstadoNovedadSeguimiento estadonovedadseguimiento) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadonovedadseguimiento !=null/* && estadonovedadseguimiento.getId()!=0*/) {
			sDescripcion=estadonovedadseguimiento.getcodigo();//estadonovedadseguimientoestadonovedadseguimiento.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoNovedadSeguimientoDescripcionDetallado(EstadoNovedadSeguimiento estadonovedadseguimiento) {
		String sDescripcion="";
			
		sDescripcion+=EstadoNovedadSeguimientoConstantesFunciones.ID+"=";
		sDescripcion+=estadonovedadseguimiento.getId().toString()+",";
		sDescripcion+=EstadoNovedadSeguimientoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadonovedadseguimiento.getVersionRow().toString()+",";
		sDescripcion+=EstadoNovedadSeguimientoConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadonovedadseguimiento.getcodigo()+",";
		sDescripcion+=EstadoNovedadSeguimientoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadonovedadseguimiento.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoNovedadSeguimientoDescripcion(EstadoNovedadSeguimiento estadonovedadseguimiento,String sValor) throws Exception {			
		if(estadonovedadseguimiento !=null) {
			estadonovedadseguimiento.setcodigo(sValor);;//estadonovedadseguimientoestadonovedadseguimiento.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoNovedadSeguimiento(EstadoNovedadSeguimiento estadonovedadseguimiento,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadonovedadseguimiento.setcodigo(estadonovedadseguimiento.getcodigo().trim());
		estadonovedadseguimiento.setnombre(estadonovedadseguimiento.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoNovedadSeguimientos(List<EstadoNovedadSeguimiento> estadonovedadseguimientos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoNovedadSeguimiento estadonovedadseguimiento: estadonovedadseguimientos) {
			estadonovedadseguimiento.setcodigo(estadonovedadseguimiento.getcodigo().trim());
			estadonovedadseguimiento.setnombre(estadonovedadseguimiento.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoNovedadSeguimiento(EstadoNovedadSeguimiento estadonovedadseguimiento,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadonovedadseguimiento.getConCambioAuxiliar()) {
			estadonovedadseguimiento.setIsDeleted(estadonovedadseguimiento.getIsDeletedAuxiliar());	
			estadonovedadseguimiento.setIsNew(estadonovedadseguimiento.getIsNewAuxiliar());	
			estadonovedadseguimiento.setIsChanged(estadonovedadseguimiento.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadonovedadseguimiento.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadonovedadseguimiento.setIsDeletedAuxiliar(false);	
			estadonovedadseguimiento.setIsNewAuxiliar(false);	
			estadonovedadseguimiento.setIsChangedAuxiliar(false);
			
			estadonovedadseguimiento.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoNovedadSeguimientos(List<EstadoNovedadSeguimiento> estadonovedadseguimientos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoNovedadSeguimiento estadonovedadseguimiento : estadonovedadseguimientos) {
			if(conAsignarBase && estadonovedadseguimiento.getConCambioAuxiliar()) {
				estadonovedadseguimiento.setIsDeleted(estadonovedadseguimiento.getIsDeletedAuxiliar());	
				estadonovedadseguimiento.setIsNew(estadonovedadseguimiento.getIsNewAuxiliar());	
				estadonovedadseguimiento.setIsChanged(estadonovedadseguimiento.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadonovedadseguimiento.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadonovedadseguimiento.setIsDeletedAuxiliar(false);	
				estadonovedadseguimiento.setIsNewAuxiliar(false);	
				estadonovedadseguimiento.setIsChangedAuxiliar(false);
				
				estadonovedadseguimiento.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoNovedadSeguimiento(EstadoNovedadSeguimiento estadonovedadseguimiento,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoNovedadSeguimientos(List<EstadoNovedadSeguimiento> estadonovedadseguimientos,Boolean conEnteros) throws Exception  {
		
		for(EstadoNovedadSeguimiento estadonovedadseguimiento: estadonovedadseguimientos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoNovedadSeguimiento(List<EstadoNovedadSeguimiento> estadonovedadseguimientos,EstadoNovedadSeguimiento estadonovedadseguimientoAux) throws Exception  {
		EstadoNovedadSeguimientoConstantesFunciones.InicializarValoresEstadoNovedadSeguimiento(estadonovedadseguimientoAux,true);
		
		for(EstadoNovedadSeguimiento estadonovedadseguimiento: estadonovedadseguimientos) {
			if(estadonovedadseguimiento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoNovedadSeguimiento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoNovedadSeguimientoConstantesFunciones.getArrayColumnasGlobalesEstadoNovedadSeguimiento(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoNovedadSeguimiento(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoNovedadSeguimiento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoNovedadSeguimiento> estadonovedadseguimientos,EstadoNovedadSeguimiento estadonovedadseguimiento,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoNovedadSeguimiento estadonovedadseguimientoAux: estadonovedadseguimientos) {
			if(estadonovedadseguimientoAux!=null && estadonovedadseguimiento!=null) {
				if((estadonovedadseguimientoAux.getId()==null && estadonovedadseguimiento.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadonovedadseguimientoAux.getId()!=null && estadonovedadseguimiento.getId()!=null){
					if(estadonovedadseguimientoAux.getId().equals(estadonovedadseguimiento.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoNovedadSeguimiento(List<EstadoNovedadSeguimiento> estadonovedadseguimientos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoNovedadSeguimiento estadonovedadseguimiento: estadonovedadseguimientos) {			
			if(estadonovedadseguimiento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoNovedadSeguimiento() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoNovedadSeguimientoConstantesFunciones.LABEL_ID, EstadoNovedadSeguimientoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoNovedadSeguimientoConstantesFunciones.LABEL_VERSIONROW, EstadoNovedadSeguimientoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoNovedadSeguimientoConstantesFunciones.LABEL_CODIGO, EstadoNovedadSeguimientoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoNovedadSeguimientoConstantesFunciones.LABEL_NOMBRE, EstadoNovedadSeguimientoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoNovedadSeguimiento() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoNovedadSeguimientoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoNovedadSeguimientoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoNovedadSeguimientoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoNovedadSeguimientoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoNovedadSeguimiento() throws Exception  {
		return EstadoNovedadSeguimientoConstantesFunciones.getTiposSeleccionarEstadoNovedadSeguimiento(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoNovedadSeguimiento(Boolean conFk) throws Exception  {
		return EstadoNovedadSeguimientoConstantesFunciones.getTiposSeleccionarEstadoNovedadSeguimiento(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoNovedadSeguimiento(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoNovedadSeguimientoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoNovedadSeguimientoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoNovedadSeguimientoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoNovedadSeguimientoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoNovedadSeguimiento(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(EstadoNovedadSeguimiento estadonovedadseguimientoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(List<EstadoNovedadSeguimiento> estadonovedadseguimientosTemp) throws Exception {
		for(EstadoNovedadSeguimiento estadonovedadseguimientoAux:estadonovedadseguimientosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoNovedadSeguimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoNovedadSeguimiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoNovedadSeguimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoNovedadSeguimientoConstantesFunciones.getClassesRelationshipsOfEstadoNovedadSeguimiento(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoNovedadSeguimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(NovedadSeguimiento.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(NovedadSeguimiento.class)) {
						classes.add(new Classe(NovedadSeguimiento.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoNovedadSeguimiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoNovedadSeguimientoConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoNovedadSeguimiento(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoNovedadSeguimiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(NovedadSeguimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadSeguimiento.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(NovedadSeguimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadSeguimiento.class)); continue;
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
	public static void actualizarLista(EstadoNovedadSeguimiento estadonovedadseguimiento,List<EstadoNovedadSeguimiento> estadonovedadseguimientos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoNovedadSeguimiento estadonovedadseguimientoEncontrado=null;
			
			for(EstadoNovedadSeguimiento estadonovedadseguimientoLocal:estadonovedadseguimientos) {
				if(estadonovedadseguimientoLocal.getId().equals(estadonovedadseguimiento.getId())) {
					estadonovedadseguimientoEncontrado=estadonovedadseguimientoLocal;
					
					estadonovedadseguimientoLocal.setIsChanged(estadonovedadseguimiento.getIsChanged());
					estadonovedadseguimientoLocal.setIsNew(estadonovedadseguimiento.getIsNew());
					estadonovedadseguimientoLocal.setIsDeleted(estadonovedadseguimiento.getIsDeleted());
					
					estadonovedadseguimientoLocal.setGeneralEntityOriginal(estadonovedadseguimiento.getGeneralEntityOriginal());
					
					estadonovedadseguimientoLocal.setId(estadonovedadseguimiento.getId());	
					estadonovedadseguimientoLocal.setVersionRow(estadonovedadseguimiento.getVersionRow());	
					estadonovedadseguimientoLocal.setcodigo(estadonovedadseguimiento.getcodigo());	
					estadonovedadseguimientoLocal.setnombre(estadonovedadseguimiento.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!estadonovedadseguimiento.getIsDeleted()) {
				if(!existe) {
					estadonovedadseguimientos.add(estadonovedadseguimiento);
				}
			} else {
				if(estadonovedadseguimientoEncontrado!=null && permiteQuitar)  {
					estadonovedadseguimientos.remove(estadonovedadseguimientoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoNovedadSeguimiento estadonovedadseguimiento,List<EstadoNovedadSeguimiento> estadonovedadseguimientos) throws Exception {
		try	{			
			for(EstadoNovedadSeguimiento estadonovedadseguimientoLocal:estadonovedadseguimientos) {
				if(estadonovedadseguimientoLocal.getId().equals(estadonovedadseguimiento.getId())) {
					estadonovedadseguimientoLocal.setIsSelected(estadonovedadseguimiento.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoNovedadSeguimiento(List<EstadoNovedadSeguimiento> estadonovedadseguimientosAux) throws Exception {
		//this.estadonovedadseguimientosAux=estadonovedadseguimientosAux;
		
		for(EstadoNovedadSeguimiento estadonovedadseguimientoAux:estadonovedadseguimientosAux) {
			if(estadonovedadseguimientoAux.getIsChanged()) {
				estadonovedadseguimientoAux.setIsChanged(false);
			}		
			
			if(estadonovedadseguimientoAux.getIsNew()) {
				estadonovedadseguimientoAux.setIsNew(false);
			}	
			
			if(estadonovedadseguimientoAux.getIsDeleted()) {
				estadonovedadseguimientoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoNovedadSeguimiento(EstadoNovedadSeguimiento estadonovedadseguimientoAux) throws Exception {
		//this.estadonovedadseguimientoAux=estadonovedadseguimientoAux;
		
			if(estadonovedadseguimientoAux.getIsChanged()) {
				estadonovedadseguimientoAux.setIsChanged(false);
			}		
			
			if(estadonovedadseguimientoAux.getIsNew()) {
				estadonovedadseguimientoAux.setIsNew(false);
			}	
			
			if(estadonovedadseguimientoAux.getIsDeleted()) {
				estadonovedadseguimientoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoNovedadSeguimiento estadonovedadseguimientoAsignar,EstadoNovedadSeguimiento estadonovedadseguimiento) throws Exception {
		estadonovedadseguimientoAsignar.setId(estadonovedadseguimiento.getId());	
		estadonovedadseguimientoAsignar.setVersionRow(estadonovedadseguimiento.getVersionRow());	
		estadonovedadseguimientoAsignar.setcodigo(estadonovedadseguimiento.getcodigo());	
		estadonovedadseguimientoAsignar.setnombre(estadonovedadseguimiento.getnombre());	
	}
	
	public static void inicializarEstadoNovedadSeguimiento(EstadoNovedadSeguimiento estadonovedadseguimiento) throws Exception {
		try {
				estadonovedadseguimiento.setId(0L);	
					
				estadonovedadseguimiento.setcodigo("");	
				estadonovedadseguimiento.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoNovedadSeguimiento(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoNovedadSeguimientoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoNovedadSeguimientoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoNovedadSeguimiento(String sTipo,Row row,Workbook workbook,EstadoNovedadSeguimiento estadonovedadseguimiento,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadonovedadseguimiento.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadonovedadseguimiento.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoNovedadSeguimiento=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoNovedadSeguimiento() {
		return this.sFinalQueryEstadoNovedadSeguimiento;
	}
	
	public void setsFinalQueryEstadoNovedadSeguimiento(String sFinalQueryEstadoNovedadSeguimiento) {
		this.sFinalQueryEstadoNovedadSeguimiento= sFinalQueryEstadoNovedadSeguimiento;
	}
	
	public Border resaltarSeleccionarEstadoNovedadSeguimiento=null;
	
	public Border setResaltarSeleccionarEstadoNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNovedadSeguimientoBeanSwingJInternalFrame estadonovedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadonovedadseguimientoBeanSwingJInternalFrame.jTtoolBarEstadoNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoNovedadSeguimiento= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoNovedadSeguimiento() {
		return this.resaltarSeleccionarEstadoNovedadSeguimiento;
	}
	
	public void setResaltarSeleccionarEstadoNovedadSeguimiento(Border borderResaltarSeleccionarEstadoNovedadSeguimiento) {
		this.resaltarSeleccionarEstadoNovedadSeguimiento= borderResaltarSeleccionarEstadoNovedadSeguimiento;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoNovedadSeguimiento=null;
	public Boolean mostraridEstadoNovedadSeguimiento=true;
	public Boolean activaridEstadoNovedadSeguimiento=true;

	public Border resaltarcodigoEstadoNovedadSeguimiento=null;
	public Boolean mostrarcodigoEstadoNovedadSeguimiento=true;
	public Boolean activarcodigoEstadoNovedadSeguimiento=true;

	public Border resaltarnombreEstadoNovedadSeguimiento=null;
	public Boolean mostrarnombreEstadoNovedadSeguimiento=true;
	public Boolean activarnombreEstadoNovedadSeguimiento=true;

	
	

	public Border setResaltaridEstadoNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNovedadSeguimientoBeanSwingJInternalFrame estadonovedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadonovedadseguimientoBeanSwingJInternalFrame.jTtoolBarEstadoNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltaridEstadoNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoNovedadSeguimiento() {
		return this.resaltaridEstadoNovedadSeguimiento;
	}

	public void setResaltaridEstadoNovedadSeguimiento(Border borderResaltar) {
		this.resaltaridEstadoNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostraridEstadoNovedadSeguimiento() {
		return this.mostraridEstadoNovedadSeguimiento;
	}

	public void setMostraridEstadoNovedadSeguimiento(Boolean mostraridEstadoNovedadSeguimiento) {
		this.mostraridEstadoNovedadSeguimiento= mostraridEstadoNovedadSeguimiento;
	}

	public Boolean getActivaridEstadoNovedadSeguimiento() {
		return this.activaridEstadoNovedadSeguimiento;
	}

	public void setActivaridEstadoNovedadSeguimiento(Boolean activaridEstadoNovedadSeguimiento) {
		this.activaridEstadoNovedadSeguimiento= activaridEstadoNovedadSeguimiento;
	}

	public Border setResaltarcodigoEstadoNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNovedadSeguimientoBeanSwingJInternalFrame estadonovedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadonovedadseguimientoBeanSwingJInternalFrame.jTtoolBarEstadoNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoNovedadSeguimiento() {
		return this.resaltarcodigoEstadoNovedadSeguimiento;
	}

	public void setResaltarcodigoEstadoNovedadSeguimiento(Border borderResaltar) {
		this.resaltarcodigoEstadoNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoNovedadSeguimiento() {
		return this.mostrarcodigoEstadoNovedadSeguimiento;
	}

	public void setMostrarcodigoEstadoNovedadSeguimiento(Boolean mostrarcodigoEstadoNovedadSeguimiento) {
		this.mostrarcodigoEstadoNovedadSeguimiento= mostrarcodigoEstadoNovedadSeguimiento;
	}

	public Boolean getActivarcodigoEstadoNovedadSeguimiento() {
		return this.activarcodigoEstadoNovedadSeguimiento;
	}

	public void setActivarcodigoEstadoNovedadSeguimiento(Boolean activarcodigoEstadoNovedadSeguimiento) {
		this.activarcodigoEstadoNovedadSeguimiento= activarcodigoEstadoNovedadSeguimiento;
	}

	public Border setResaltarnombreEstadoNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoNovedadSeguimientoBeanSwingJInternalFrame estadonovedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadonovedadseguimientoBeanSwingJInternalFrame.jTtoolBarEstadoNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoNovedadSeguimiento() {
		return this.resaltarnombreEstadoNovedadSeguimiento;
	}

	public void setResaltarnombreEstadoNovedadSeguimiento(Border borderResaltar) {
		this.resaltarnombreEstadoNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoNovedadSeguimiento() {
		return this.mostrarnombreEstadoNovedadSeguimiento;
	}

	public void setMostrarnombreEstadoNovedadSeguimiento(Boolean mostrarnombreEstadoNovedadSeguimiento) {
		this.mostrarnombreEstadoNovedadSeguimiento= mostrarnombreEstadoNovedadSeguimiento;
	}

	public Boolean getActivarnombreEstadoNovedadSeguimiento() {
		return this.activarnombreEstadoNovedadSeguimiento;
	}

	public void setActivarnombreEstadoNovedadSeguimiento(Boolean activarnombreEstadoNovedadSeguimiento) {
		this.activarnombreEstadoNovedadSeguimiento= activarnombreEstadoNovedadSeguimiento;
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
		
		
		this.setMostraridEstadoNovedadSeguimiento(esInicial);
		this.setMostrarcodigoEstadoNovedadSeguimiento(esInicial);
		this.setMostrarnombreEstadoNovedadSeguimiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoNovedadSeguimientoConstantesFunciones.ID)) {
				this.setMostraridEstadoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadSeguimientoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadSeguimientoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoNovedadSeguimiento(esAsigna);
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
		
		
		this.setActivaridEstadoNovedadSeguimiento(esInicial);
		this.setActivarcodigoEstadoNovedadSeguimiento(esInicial);
		this.setActivarnombreEstadoNovedadSeguimiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoNovedadSeguimientoConstantesFunciones.ID)) {
				this.setActivaridEstadoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadSeguimientoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadSeguimientoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoNovedadSeguimiento(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoNovedadSeguimientoBeanSwingJInternalFrame estadonovedadseguimientoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoNovedadSeguimiento(esInicial);
		this.setResaltarcodigoEstadoNovedadSeguimiento(esInicial);
		this.setResaltarnombreEstadoNovedadSeguimiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoNovedadSeguimientoConstantesFunciones.ID)) {
				this.setResaltaridEstadoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadSeguimientoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoNovedadSeguimientoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoNovedadSeguimiento(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoNovedadSeguimientoBeanSwingJInternalFrame estadonovedadseguimientoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	
	//CONTROL_FUNCION2
}