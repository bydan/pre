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


import com.bydan.erp.inventario.util.EstadoDetalleInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoDetalleInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoDetalleInventarioParameterGeneral;

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
final public class EstadoDetalleInventarioConstantesFunciones extends EstadoDetalleInventarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoDetalleInventario";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoDetalleInventario"+EstadoDetalleInventarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoDetalleInventarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoDetalleInventarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoDetalleInventarioConstantesFunciones.SCHEMA+"_"+EstadoDetalleInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoDetalleInventarioConstantesFunciones.SCHEMA+"_"+EstadoDetalleInventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoDetalleInventarioConstantesFunciones.SCHEMA+"_"+EstadoDetalleInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoDetalleInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoDetalleInventarioConstantesFunciones.SCHEMA+"_"+EstadoDetalleInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoDetalleInventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoDetalleInventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoDetalleInventarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoDetalleInventarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoDetalleInventarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoDetalleInventarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Detalle Inventarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Detalle Inventario";
	public static final String SCLASSWEBTITULO_LOWER="Estado Detalle Inventario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoDetalleInventario";
	public static final String OBJECTNAME="estadodetalleinventario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_detalle_inventario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadodetalleinventario from "+EstadoDetalleInventarioConstantesFunciones.SPERSISTENCENAME+" estadodetalleinventario";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+".id,"+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleInventarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoDetalleInventarioConstantesFuncionesAdditional estadodetalleinventarioConstantesFuncionesAdditional=null;
	
	public EstadoDetalleInventarioConstantesFuncionesAdditional getEstadoDetalleInventarioConstantesFuncionesAdditional() {
		return this.estadodetalleinventarioConstantesFuncionesAdditional;
	}
	
	public void setEstadoDetalleInventarioConstantesFuncionesAdditional(EstadoDetalleInventarioConstantesFuncionesAdditional estadodetalleinventarioConstantesFuncionesAdditional) {
		try {
			this.estadodetalleinventarioConstantesFuncionesAdditional=estadodetalleinventarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getEstadoDetalleInventarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoDetalleInventarioConstantesFunciones.CODIGO)) {sLabelColumna=EstadoDetalleInventarioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoDetalleInventarioConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoDetalleInventarioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoDetalleInventarioDescripcion(EstadoDetalleInventario estadodetalleinventario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadodetalleinventario !=null/* && estadodetalleinventario.getId()!=0*/) {
			sDescripcion=estadodetalleinventario.getcodigo();//estadodetalleinventarioestadodetalleinventario.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoDetalleInventarioDescripcionDetallado(EstadoDetalleInventario estadodetalleinventario) {
		String sDescripcion="";
			
		sDescripcion+=EstadoDetalleInventarioConstantesFunciones.ID+"=";
		sDescripcion+=estadodetalleinventario.getId().toString()+",";
		sDescripcion+=EstadoDetalleInventarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadodetalleinventario.getVersionRow().toString()+",";
		sDescripcion+=EstadoDetalleInventarioConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadodetalleinventario.getcodigo()+",";
		sDescripcion+=EstadoDetalleInventarioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadodetalleinventario.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoDetalleInventarioDescripcion(EstadoDetalleInventario estadodetalleinventario,String sValor) throws Exception {			
		if(estadodetalleinventario !=null) {
			estadodetalleinventario.setcodigo(sValor);;//estadodetalleinventarioestadodetalleinventario.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoDetalleInventario(EstadoDetalleInventario estadodetalleinventario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadodetalleinventario.setcodigo(estadodetalleinventario.getcodigo().trim());
		estadodetalleinventario.setnombre(estadodetalleinventario.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoDetalleInventarios(List<EstadoDetalleInventario> estadodetalleinventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoDetalleInventario estadodetalleinventario: estadodetalleinventarios) {
			estadodetalleinventario.setcodigo(estadodetalleinventario.getcodigo().trim());
			estadodetalleinventario.setnombre(estadodetalleinventario.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleInventario(EstadoDetalleInventario estadodetalleinventario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadodetalleinventario.getConCambioAuxiliar()) {
			estadodetalleinventario.setIsDeleted(estadodetalleinventario.getIsDeletedAuxiliar());	
			estadodetalleinventario.setIsNew(estadodetalleinventario.getIsNewAuxiliar());	
			estadodetalleinventario.setIsChanged(estadodetalleinventario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadodetalleinventario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadodetalleinventario.setIsDeletedAuxiliar(false);	
			estadodetalleinventario.setIsNewAuxiliar(false);	
			estadodetalleinventario.setIsChangedAuxiliar(false);
			
			estadodetalleinventario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoDetalleInventarios(List<EstadoDetalleInventario> estadodetalleinventarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoDetalleInventario estadodetalleinventario : estadodetalleinventarios) {
			if(conAsignarBase && estadodetalleinventario.getConCambioAuxiliar()) {
				estadodetalleinventario.setIsDeleted(estadodetalleinventario.getIsDeletedAuxiliar());	
				estadodetalleinventario.setIsNew(estadodetalleinventario.getIsNewAuxiliar());	
				estadodetalleinventario.setIsChanged(estadodetalleinventario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadodetalleinventario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadodetalleinventario.setIsDeletedAuxiliar(false);	
				estadodetalleinventario.setIsNewAuxiliar(false);	
				estadodetalleinventario.setIsChangedAuxiliar(false);
				
				estadodetalleinventario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoDetalleInventario(EstadoDetalleInventario estadodetalleinventario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoDetalleInventarios(List<EstadoDetalleInventario> estadodetalleinventarios,Boolean conEnteros) throws Exception  {
		
		for(EstadoDetalleInventario estadodetalleinventario: estadodetalleinventarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoDetalleInventario(List<EstadoDetalleInventario> estadodetalleinventarios,EstadoDetalleInventario estadodetalleinventarioAux) throws Exception  {
		EstadoDetalleInventarioConstantesFunciones.InicializarValoresEstadoDetalleInventario(estadodetalleinventarioAux,true);
		
		for(EstadoDetalleInventario estadodetalleinventario: estadodetalleinventarios) {
			if(estadodetalleinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoDetalleInventarioConstantesFunciones.getArrayColumnasGlobalesEstadoDetalleInventario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoDetalleInventario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoDetalleInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoDetalleInventario> estadodetalleinventarios,EstadoDetalleInventario estadodetalleinventario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoDetalleInventario estadodetalleinventarioAux: estadodetalleinventarios) {
			if(estadodetalleinventarioAux!=null && estadodetalleinventario!=null) {
				if((estadodetalleinventarioAux.getId()==null && estadodetalleinventario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadodetalleinventarioAux.getId()!=null && estadodetalleinventario.getId()!=null){
					if(estadodetalleinventarioAux.getId().equals(estadodetalleinventario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoDetalleInventario(List<EstadoDetalleInventario> estadodetalleinventarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoDetalleInventario estadodetalleinventario: estadodetalleinventarios) {			
			if(estadodetalleinventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoDetalleInventario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoDetalleInventarioConstantesFunciones.LABEL_ID, EstadoDetalleInventarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleInventarioConstantesFunciones.LABEL_VERSIONROW, EstadoDetalleInventarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleInventarioConstantesFunciones.LABEL_CODIGO, EstadoDetalleInventarioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoDetalleInventarioConstantesFunciones.LABEL_NOMBRE, EstadoDetalleInventarioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoDetalleInventario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleInventarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleInventarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleInventarioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoDetalleInventarioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleInventario() throws Exception  {
		return EstadoDetalleInventarioConstantesFunciones.getTiposSeleccionarEstadoDetalleInventario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleInventario(Boolean conFk) throws Exception  {
		return EstadoDetalleInventarioConstantesFunciones.getTiposSeleccionarEstadoDetalleInventario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoDetalleInventario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleInventarioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoDetalleInventarioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoDetalleInventarioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoDetalleInventarioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoDetalleInventario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleInventario(EstadoDetalleInventario estadodetalleinventarioAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoDetalleInventario(List<EstadoDetalleInventario> estadodetalleinventariosTemp) throws Exception {
		for(EstadoDetalleInventario estadodetalleinventarioAux:estadodetalleinventariosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoDetalleInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleInventarioConstantesFunciones.getClassesRelationshipsOfEstadoDetalleInventario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleCompra.class));
				classes.add(new Classe(DetalleTransferencia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleCompra.class)) {
						classes.add(new Classe(DetalleCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleTransferencia.class)) {
						classes.add(new Classe(DetalleTransferencia.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoDetalleInventarioConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoDetalleInventario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoDetalleInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCompra.class)); continue;
					}

					if(DetalleTransferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleTransferencia.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCompra.class)); continue;
					}

					if(DetalleTransferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleTransferencia.class)); continue;
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
	public static void actualizarLista(EstadoDetalleInventario estadodetalleinventario,List<EstadoDetalleInventario> estadodetalleinventarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoDetalleInventario estadodetalleinventarioEncontrado=null;
			
			for(EstadoDetalleInventario estadodetalleinventarioLocal:estadodetalleinventarios) {
				if(estadodetalleinventarioLocal.getId().equals(estadodetalleinventario.getId())) {
					estadodetalleinventarioEncontrado=estadodetalleinventarioLocal;
					
					estadodetalleinventarioLocal.setIsChanged(estadodetalleinventario.getIsChanged());
					estadodetalleinventarioLocal.setIsNew(estadodetalleinventario.getIsNew());
					estadodetalleinventarioLocal.setIsDeleted(estadodetalleinventario.getIsDeleted());
					
					estadodetalleinventarioLocal.setGeneralEntityOriginal(estadodetalleinventario.getGeneralEntityOriginal());
					
					estadodetalleinventarioLocal.setId(estadodetalleinventario.getId());	
					estadodetalleinventarioLocal.setVersionRow(estadodetalleinventario.getVersionRow());	
					estadodetalleinventarioLocal.setcodigo(estadodetalleinventario.getcodigo());	
					estadodetalleinventarioLocal.setnombre(estadodetalleinventario.getnombre());	
					
					
					estadodetalleinventarioLocal.setDetalleCompras(estadodetalleinventario.getDetalleCompras());
					estadodetalleinventarioLocal.setDetalleTransferencias(estadodetalleinventario.getDetalleTransferencias());
					
					existe=true;
					break;
				}
			}
			
			if(!estadodetalleinventario.getIsDeleted()) {
				if(!existe) {
					estadodetalleinventarios.add(estadodetalleinventario);
				}
			} else {
				if(estadodetalleinventarioEncontrado!=null && permiteQuitar)  {
					estadodetalleinventarios.remove(estadodetalleinventarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoDetalleInventario estadodetalleinventario,List<EstadoDetalleInventario> estadodetalleinventarios) throws Exception {
		try	{			
			for(EstadoDetalleInventario estadodetalleinventarioLocal:estadodetalleinventarios) {
				if(estadodetalleinventarioLocal.getId().equals(estadodetalleinventario.getId())) {
					estadodetalleinventarioLocal.setIsSelected(estadodetalleinventario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoDetalleInventario(List<EstadoDetalleInventario> estadodetalleinventariosAux) throws Exception {
		//this.estadodetalleinventariosAux=estadodetalleinventariosAux;
		
		for(EstadoDetalleInventario estadodetalleinventarioAux:estadodetalleinventariosAux) {
			if(estadodetalleinventarioAux.getIsChanged()) {
				estadodetalleinventarioAux.setIsChanged(false);
			}		
			
			if(estadodetalleinventarioAux.getIsNew()) {
				estadodetalleinventarioAux.setIsNew(false);
			}	
			
			if(estadodetalleinventarioAux.getIsDeleted()) {
				estadodetalleinventarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoDetalleInventario(EstadoDetalleInventario estadodetalleinventarioAux) throws Exception {
		//this.estadodetalleinventarioAux=estadodetalleinventarioAux;
		
			if(estadodetalleinventarioAux.getIsChanged()) {
				estadodetalleinventarioAux.setIsChanged(false);
			}		
			
			if(estadodetalleinventarioAux.getIsNew()) {
				estadodetalleinventarioAux.setIsNew(false);
			}	
			
			if(estadodetalleinventarioAux.getIsDeleted()) {
				estadodetalleinventarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoDetalleInventario estadodetalleinventarioAsignar,EstadoDetalleInventario estadodetalleinventario) throws Exception {
		estadodetalleinventarioAsignar.setId(estadodetalleinventario.getId());	
		estadodetalleinventarioAsignar.setVersionRow(estadodetalleinventario.getVersionRow());	
		estadodetalleinventarioAsignar.setcodigo(estadodetalleinventario.getcodigo());	
		estadodetalleinventarioAsignar.setnombre(estadodetalleinventario.getnombre());	
	}
	
	public static void inicializarEstadoDetalleInventario(EstadoDetalleInventario estadodetalleinventario) throws Exception {
		try {
				estadodetalleinventario.setId(0L);	
					
				estadodetalleinventario.setcodigo("");	
				estadodetalleinventario.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoDetalleInventario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleInventarioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoDetalleInventarioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoDetalleInventario(String sTipo,Row row,Workbook workbook,EstadoDetalleInventario estadodetalleinventario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetalleinventario.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadodetalleinventario.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoDetalleInventario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoDetalleInventario() {
		return this.sFinalQueryEstadoDetalleInventario;
	}
	
	public void setsFinalQueryEstadoDetalleInventario(String sFinalQueryEstadoDetalleInventario) {
		this.sFinalQueryEstadoDetalleInventario= sFinalQueryEstadoDetalleInventario;
	}
	
	public Border resaltarSeleccionarEstadoDetalleInventario=null;
	
	public Border setResaltarSeleccionarEstadoDetalleInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleInventarioBeanSwingJInternalFrame estadodetalleinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadodetalleinventarioBeanSwingJInternalFrame.jTtoolBarEstadoDetalleInventario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoDetalleInventario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoDetalleInventario() {
		return this.resaltarSeleccionarEstadoDetalleInventario;
	}
	
	public void setResaltarSeleccionarEstadoDetalleInventario(Border borderResaltarSeleccionarEstadoDetalleInventario) {
		this.resaltarSeleccionarEstadoDetalleInventario= borderResaltarSeleccionarEstadoDetalleInventario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoDetalleInventario=null;
	public Boolean mostraridEstadoDetalleInventario=true;
	public Boolean activaridEstadoDetalleInventario=true;

	public Border resaltarcodigoEstadoDetalleInventario=null;
	public Boolean mostrarcodigoEstadoDetalleInventario=true;
	public Boolean activarcodigoEstadoDetalleInventario=true;

	public Border resaltarnombreEstadoDetalleInventario=null;
	public Boolean mostrarnombreEstadoDetalleInventario=true;
	public Boolean activarnombreEstadoDetalleInventario=true;

	
	

	public Border setResaltaridEstadoDetalleInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleInventarioBeanSwingJInternalFrame estadodetalleinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleinventarioBeanSwingJInternalFrame.jTtoolBarEstadoDetalleInventario.setBorder(borderResaltar);
		
		this.resaltaridEstadoDetalleInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoDetalleInventario() {
		return this.resaltaridEstadoDetalleInventario;
	}

	public void setResaltaridEstadoDetalleInventario(Border borderResaltar) {
		this.resaltaridEstadoDetalleInventario= borderResaltar;
	}

	public Boolean getMostraridEstadoDetalleInventario() {
		return this.mostraridEstadoDetalleInventario;
	}

	public void setMostraridEstadoDetalleInventario(Boolean mostraridEstadoDetalleInventario) {
		this.mostraridEstadoDetalleInventario= mostraridEstadoDetalleInventario;
	}

	public Boolean getActivaridEstadoDetalleInventario() {
		return this.activaridEstadoDetalleInventario;
	}

	public void setActivaridEstadoDetalleInventario(Boolean activaridEstadoDetalleInventario) {
		this.activaridEstadoDetalleInventario= activaridEstadoDetalleInventario;
	}

	public Border setResaltarcodigoEstadoDetalleInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleInventarioBeanSwingJInternalFrame estadodetalleinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleinventarioBeanSwingJInternalFrame.jTtoolBarEstadoDetalleInventario.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoDetalleInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoDetalleInventario() {
		return this.resaltarcodigoEstadoDetalleInventario;
	}

	public void setResaltarcodigoEstadoDetalleInventario(Border borderResaltar) {
		this.resaltarcodigoEstadoDetalleInventario= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoDetalleInventario() {
		return this.mostrarcodigoEstadoDetalleInventario;
	}

	public void setMostrarcodigoEstadoDetalleInventario(Boolean mostrarcodigoEstadoDetalleInventario) {
		this.mostrarcodigoEstadoDetalleInventario= mostrarcodigoEstadoDetalleInventario;
	}

	public Boolean getActivarcodigoEstadoDetalleInventario() {
		return this.activarcodigoEstadoDetalleInventario;
	}

	public void setActivarcodigoEstadoDetalleInventario(Boolean activarcodigoEstadoDetalleInventario) {
		this.activarcodigoEstadoDetalleInventario= activarcodigoEstadoDetalleInventario;
	}

	public Border setResaltarnombreEstadoDetalleInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleInventarioBeanSwingJInternalFrame estadodetalleinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadodetalleinventarioBeanSwingJInternalFrame.jTtoolBarEstadoDetalleInventario.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoDetalleInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoDetalleInventario() {
		return this.resaltarnombreEstadoDetalleInventario;
	}

	public void setResaltarnombreEstadoDetalleInventario(Border borderResaltar) {
		this.resaltarnombreEstadoDetalleInventario= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoDetalleInventario() {
		return this.mostrarnombreEstadoDetalleInventario;
	}

	public void setMostrarnombreEstadoDetalleInventario(Boolean mostrarnombreEstadoDetalleInventario) {
		this.mostrarnombreEstadoDetalleInventario= mostrarnombreEstadoDetalleInventario;
	}

	public Boolean getActivarnombreEstadoDetalleInventario() {
		return this.activarnombreEstadoDetalleInventario;
	}

	public void setActivarnombreEstadoDetalleInventario(Boolean activarnombreEstadoDetalleInventario) {
		this.activarnombreEstadoDetalleInventario= activarnombreEstadoDetalleInventario;
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
		
		
		this.setMostraridEstadoDetalleInventario(esInicial);
		this.setMostrarcodigoEstadoDetalleInventario(esInicial);
		this.setMostrarnombreEstadoDetalleInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleInventarioConstantesFunciones.ID)) {
				this.setMostraridEstadoDetalleInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleInventarioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoDetalleInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleInventarioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoDetalleInventario(esAsigna);
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
		
		
		this.setActivaridEstadoDetalleInventario(esInicial);
		this.setActivarcodigoEstadoDetalleInventario(esInicial);
		this.setActivarnombreEstadoDetalleInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleInventarioConstantesFunciones.ID)) {
				this.setActivaridEstadoDetalleInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleInventarioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoDetalleInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleInventarioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoDetalleInventario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleInventarioBeanSwingJInternalFrame estadodetalleinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoDetalleInventario(esInicial);
		this.setResaltarcodigoEstadoDetalleInventario(esInicial);
		this.setResaltarnombreEstadoDetalleInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoDetalleInventarioConstantesFunciones.ID)) {
				this.setResaltaridEstadoDetalleInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleInventarioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoDetalleInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoDetalleInventarioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoDetalleInventario(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleCompraEstadoDetalleInventario=null;

	public Border getResaltarDetalleCompraEstadoDetalleInventario() {
		return this.resaltarDetalleCompraEstadoDetalleInventario;
	}

	public void setResaltarDetalleCompraEstadoDetalleInventario(Border borderResaltarDetalleCompra) {
		if(borderResaltarDetalleCompra!=null) {
			this.resaltarDetalleCompraEstadoDetalleInventario= borderResaltarDetalleCompra;
		}
	}

	public Border setResaltarDetalleCompraEstadoDetalleInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleInventarioBeanSwingJInternalFrame estadodetalleinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadodetalleinventarioBeanSwingJInternalFrame.jTtoolBarEstadoDetalleInventario.setBorder(borderResaltarDetalleCompra);
			
		this.resaltarDetalleCompraEstadoDetalleInventario= borderResaltarDetalleCompra;

		 return borderResaltarDetalleCompra;
	}



	public Boolean mostrarDetalleCompraEstadoDetalleInventario=true;

	public Boolean getMostrarDetalleCompraEstadoDetalleInventario() {
		return this.mostrarDetalleCompraEstadoDetalleInventario;
	}

	public void setMostrarDetalleCompraEstadoDetalleInventario(Boolean visibilidadResaltarDetalleCompra) {
		this.mostrarDetalleCompraEstadoDetalleInventario= visibilidadResaltarDetalleCompra;
	}



	public Boolean activarDetalleCompraEstadoDetalleInventario=true;

	public Boolean gethabilitarResaltarDetalleCompraEstadoDetalleInventario() {
		return this.activarDetalleCompraEstadoDetalleInventario;
	}

	public void setActivarDetalleCompraEstadoDetalleInventario(Boolean habilitarResaltarDetalleCompra) {
		this.activarDetalleCompraEstadoDetalleInventario= habilitarResaltarDetalleCompra;
	}


	public Border resaltarDetalleTransferenciaEstadoDetalleInventario=null;

	public Border getResaltarDetalleTransferenciaEstadoDetalleInventario() {
		return this.resaltarDetalleTransferenciaEstadoDetalleInventario;
	}

	public void setResaltarDetalleTransferenciaEstadoDetalleInventario(Border borderResaltarDetalleTransferencia) {
		if(borderResaltarDetalleTransferencia!=null) {
			this.resaltarDetalleTransferenciaEstadoDetalleInventario= borderResaltarDetalleTransferencia;
		}
	}

	public Border setResaltarDetalleTransferenciaEstadoDetalleInventario(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoDetalleInventarioBeanSwingJInternalFrame estadodetalleinventarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleTransferencia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadodetalleinventarioBeanSwingJInternalFrame.jTtoolBarEstadoDetalleInventario.setBorder(borderResaltarDetalleTransferencia);
			
		this.resaltarDetalleTransferenciaEstadoDetalleInventario= borderResaltarDetalleTransferencia;

		 return borderResaltarDetalleTransferencia;
	}



	public Boolean mostrarDetalleTransferenciaEstadoDetalleInventario=true;

	public Boolean getMostrarDetalleTransferenciaEstadoDetalleInventario() {
		return this.mostrarDetalleTransferenciaEstadoDetalleInventario;
	}

	public void setMostrarDetalleTransferenciaEstadoDetalleInventario(Boolean visibilidadResaltarDetalleTransferencia) {
		this.mostrarDetalleTransferenciaEstadoDetalleInventario= visibilidadResaltarDetalleTransferencia;
	}



	public Boolean activarDetalleTransferenciaEstadoDetalleInventario=true;

	public Boolean gethabilitarResaltarDetalleTransferenciaEstadoDetalleInventario() {
		return this.activarDetalleTransferenciaEstadoDetalleInventario;
	}

	public void setActivarDetalleTransferenciaEstadoDetalleInventario(Boolean habilitarResaltarDetalleTransferencia) {
		this.activarDetalleTransferenciaEstadoDetalleInventario= habilitarResaltarDetalleTransferencia;
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

		this.setMostrarDetalleCompraEstadoDetalleInventario(esInicial);
		this.setMostrarDetalleTransferenciaEstadoDetalleInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleCompra.class)) {
				this.setMostrarDetalleCompraEstadoDetalleInventario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleTransferencia.class)) {
				this.setMostrarDetalleTransferenciaEstadoDetalleInventario(esAsigna);
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

		this.setActivarDetalleCompraEstadoDetalleInventario(esInicial);
		this.setActivarDetalleTransferenciaEstadoDetalleInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleCompra.class)) {
				this.setActivarDetalleCompraEstadoDetalleInventario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleTransferencia.class)) {
				this.setActivarDetalleTransferenciaEstadoDetalleInventario(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoDetalleInventarioBeanSwingJInternalFrame estadodetalleinventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleCompraEstadoDetalleInventario(esInicial);
		this.setResaltarDetalleTransferenciaEstadoDetalleInventario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleCompra.class)) {
				this.setResaltarDetalleCompraEstadoDetalleInventario(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleTransferencia.class)) {
				this.setResaltarDetalleTransferenciaEstadoDetalleInventario(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}