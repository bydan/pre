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
package com.bydan.erp.comisiones.util;

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


import com.bydan.erp.comisiones.util.EstadoComisionConstantesFunciones;
import com.bydan.erp.comisiones.util.EstadoComisionParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.EstadoComisionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.comisiones.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.comisiones.business.dataaccess.*;
//import com.bydan.erp.comisiones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoComisionConstantesFunciones extends EstadoComisionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoComision";
	public static final String SPATHOPCION="Comisiones";	
	public static final String SPATHMODULO="comisiones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoComision"+EstadoComisionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoComisionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoComisionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoComisionConstantesFunciones.SCHEMA+"_"+EstadoComisionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoComisionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoComisionConstantesFunciones.SCHEMA+"_"+EstadoComisionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoComisionConstantesFunciones.SCHEMA+"_"+EstadoComisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoComisionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoComisionConstantesFunciones.SCHEMA+"_"+EstadoComisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoComisionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoComisionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoComisionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoComisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoComisionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoComisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoComisionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoComisionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoComisionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoComisionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Comisiones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Estado Comision";
	public static final String SCLASSWEBTITULO_LOWER="Estado Comision";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoComision";
	public static final String OBJECTNAME="estadocomision";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_COMISIONES;	
	public static final String TABLENAME="estado_comision";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadocomision from "+EstadoComisionConstantesFunciones.SPERSISTENCENAME+" estadocomision";
	public static String QUERYSELECTNATIVE="select "+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+".id,"+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+".version_row,"+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+".codigo,"+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME+".nombre from "+EstadoComisionConstantesFunciones.SCHEMA+"."+EstadoComisionConstantesFunciones.TABLENAME;//+" as "+EstadoComisionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoComisionConstantesFuncionesAdditional estadocomisionConstantesFuncionesAdditional=null;
	
	public EstadoComisionConstantesFuncionesAdditional getEstadoComisionConstantesFuncionesAdditional() {
		return this.estadocomisionConstantesFuncionesAdditional;
	}
	
	public void setEstadoComisionConstantesFuncionesAdditional(EstadoComisionConstantesFuncionesAdditional estadocomisionConstantesFuncionesAdditional) {
		try {
			this.estadocomisionConstantesFuncionesAdditional=estadocomisionConstantesFuncionesAdditional;
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
	
	public static String getEstadoComisionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoComisionConstantesFunciones.CODIGO)) {sLabelColumna=EstadoComisionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoComisionConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoComisionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoComisionDescripcion(EstadoComision estadocomision) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadocomision !=null/* && estadocomision.getId()!=0*/) {
			sDescripcion=estadocomision.getcodigo();//estadocomisionestadocomision.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoComisionDescripcionDetallado(EstadoComision estadocomision) {
		String sDescripcion="";
			
		sDescripcion+=EstadoComisionConstantesFunciones.ID+"=";
		sDescripcion+=estadocomision.getId().toString()+",";
		sDescripcion+=EstadoComisionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadocomision.getVersionRow().toString()+",";
		sDescripcion+=EstadoComisionConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadocomision.getcodigo()+",";
		sDescripcion+=EstadoComisionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadocomision.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoComisionDescripcion(EstadoComision estadocomision,String sValor) throws Exception {			
		if(estadocomision !=null) {
			estadocomision.setcodigo(sValor);;//estadocomisionestadocomision.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoComision(EstadoComision estadocomision,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadocomision.setcodigo(estadocomision.getcodigo().trim());
		estadocomision.setnombre(estadocomision.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoComisions(List<EstadoComision> estadocomisions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoComision estadocomision: estadocomisions) {
			estadocomision.setcodigo(estadocomision.getcodigo().trim());
			estadocomision.setnombre(estadocomision.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoComision(EstadoComision estadocomision,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadocomision.getConCambioAuxiliar()) {
			estadocomision.setIsDeleted(estadocomision.getIsDeletedAuxiliar());	
			estadocomision.setIsNew(estadocomision.getIsNewAuxiliar());	
			estadocomision.setIsChanged(estadocomision.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadocomision.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadocomision.setIsDeletedAuxiliar(false);	
			estadocomision.setIsNewAuxiliar(false);	
			estadocomision.setIsChangedAuxiliar(false);
			
			estadocomision.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoComisions(List<EstadoComision> estadocomisions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoComision estadocomision : estadocomisions) {
			if(conAsignarBase && estadocomision.getConCambioAuxiliar()) {
				estadocomision.setIsDeleted(estadocomision.getIsDeletedAuxiliar());	
				estadocomision.setIsNew(estadocomision.getIsNewAuxiliar());	
				estadocomision.setIsChanged(estadocomision.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadocomision.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadocomision.setIsDeletedAuxiliar(false);	
				estadocomision.setIsNewAuxiliar(false);	
				estadocomision.setIsChangedAuxiliar(false);
				
				estadocomision.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoComision(EstadoComision estadocomision,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoComisions(List<EstadoComision> estadocomisions,Boolean conEnteros) throws Exception  {
		
		for(EstadoComision estadocomision: estadocomisions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoComision(List<EstadoComision> estadocomisions,EstadoComision estadocomisionAux) throws Exception  {
		EstadoComisionConstantesFunciones.InicializarValoresEstadoComision(estadocomisionAux,true);
		
		for(EstadoComision estadocomision: estadocomisions) {
			if(estadocomision.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoComision(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoComisionConstantesFunciones.getArrayColumnasGlobalesEstadoComision(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoComision(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoComision(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoComision> estadocomisions,EstadoComision estadocomision,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoComision estadocomisionAux: estadocomisions) {
			if(estadocomisionAux!=null && estadocomision!=null) {
				if((estadocomisionAux.getId()==null && estadocomision.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadocomisionAux.getId()!=null && estadocomision.getId()!=null){
					if(estadocomisionAux.getId().equals(estadocomision.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoComision(List<EstadoComision> estadocomisions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoComision estadocomision: estadocomisions) {			
			if(estadocomision.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoComision() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoComisionConstantesFunciones.LABEL_ID, EstadoComisionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoComisionConstantesFunciones.LABEL_VERSIONROW, EstadoComisionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoComisionConstantesFunciones.LABEL_CODIGO, EstadoComisionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoComisionConstantesFunciones.LABEL_NOMBRE, EstadoComisionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoComision() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoComisionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoComisionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoComisionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoComisionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoComision() throws Exception  {
		return EstadoComisionConstantesFunciones.getTiposSeleccionarEstadoComision(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoComision(Boolean conFk) throws Exception  {
		return EstadoComisionConstantesFunciones.getTiposSeleccionarEstadoComision(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoComision(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoComisionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoComisionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoComisionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoComisionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoComision(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoComision(EstadoComision estadocomisionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoComision(List<EstadoComision> estadocomisionsTemp) throws Exception {
		for(EstadoComision estadocomisionAux:estadocomisionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoComision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoComision(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoComision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoComisionConstantesFunciones.getClassesRelationshipsOfEstadoComision(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoComision(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ComisionCate.class));
				classes.add(new Classe(ComisionMarca.class));
				classes.add(new Classe(ComisionLinea.class));
				classes.add(new Classe(ComisionGrupo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionCate.class)) {
						classes.add(new Classe(ComisionCate.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionMarca.class)) {
						classes.add(new Classe(ComisionMarca.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionLinea.class)) {
						classes.add(new Classe(ComisionLinea.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionGrupo.class)) {
						classes.add(new Classe(ComisionGrupo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoComision(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoComisionConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoComision(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoComision(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ComisionCate.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionCate.class)); continue;
					}

					if(ComisionMarca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionMarca.class)); continue;
					}

					if(ComisionLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionLinea.class)); continue;
					}

					if(ComisionGrupo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionGrupo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ComisionCate.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionCate.class)); continue;
					}

					if(ComisionMarca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionMarca.class)); continue;
					}

					if(ComisionLinea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionLinea.class)); continue;
					}

					if(ComisionGrupo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionGrupo.class)); continue;
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
	public static void actualizarLista(EstadoComision estadocomision,List<EstadoComision> estadocomisions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoComision estadocomisionEncontrado=null;
			
			for(EstadoComision estadocomisionLocal:estadocomisions) {
				if(estadocomisionLocal.getId().equals(estadocomision.getId())) {
					estadocomisionEncontrado=estadocomisionLocal;
					
					estadocomisionLocal.setIsChanged(estadocomision.getIsChanged());
					estadocomisionLocal.setIsNew(estadocomision.getIsNew());
					estadocomisionLocal.setIsDeleted(estadocomision.getIsDeleted());
					
					estadocomisionLocal.setGeneralEntityOriginal(estadocomision.getGeneralEntityOriginal());
					
					estadocomisionLocal.setId(estadocomision.getId());	
					estadocomisionLocal.setVersionRow(estadocomision.getVersionRow());	
					estadocomisionLocal.setcodigo(estadocomision.getcodigo());	
					estadocomisionLocal.setnombre(estadocomision.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!estadocomision.getIsDeleted()) {
				if(!existe) {
					estadocomisions.add(estadocomision);
				}
			} else {
				if(estadocomisionEncontrado!=null && permiteQuitar)  {
					estadocomisions.remove(estadocomisionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoComision estadocomision,List<EstadoComision> estadocomisions) throws Exception {
		try	{			
			for(EstadoComision estadocomisionLocal:estadocomisions) {
				if(estadocomisionLocal.getId().equals(estadocomision.getId())) {
					estadocomisionLocal.setIsSelected(estadocomision.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoComision(List<EstadoComision> estadocomisionsAux) throws Exception {
		//this.estadocomisionsAux=estadocomisionsAux;
		
		for(EstadoComision estadocomisionAux:estadocomisionsAux) {
			if(estadocomisionAux.getIsChanged()) {
				estadocomisionAux.setIsChanged(false);
			}		
			
			if(estadocomisionAux.getIsNew()) {
				estadocomisionAux.setIsNew(false);
			}	
			
			if(estadocomisionAux.getIsDeleted()) {
				estadocomisionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoComision(EstadoComision estadocomisionAux) throws Exception {
		//this.estadocomisionAux=estadocomisionAux;
		
			if(estadocomisionAux.getIsChanged()) {
				estadocomisionAux.setIsChanged(false);
			}		
			
			if(estadocomisionAux.getIsNew()) {
				estadocomisionAux.setIsNew(false);
			}	
			
			if(estadocomisionAux.getIsDeleted()) {
				estadocomisionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoComision estadocomisionAsignar,EstadoComision estadocomision) throws Exception {
		estadocomisionAsignar.setId(estadocomision.getId());	
		estadocomisionAsignar.setVersionRow(estadocomision.getVersionRow());	
		estadocomisionAsignar.setcodigo(estadocomision.getcodigo());	
		estadocomisionAsignar.setnombre(estadocomision.getnombre());	
	}
	
	public static void inicializarEstadoComision(EstadoComision estadocomision) throws Exception {
		try {
				estadocomision.setId(0L);	
					
				estadocomision.setcodigo("");	
				estadocomision.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoComision(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoComisionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoComisionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoComision(String sTipo,Row row,Workbook workbook,EstadoComision estadocomision,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadocomision.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadocomision.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoComision=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoComision() {
		return this.sFinalQueryEstadoComision;
	}
	
	public void setsFinalQueryEstadoComision(String sFinalQueryEstadoComision) {
		this.sFinalQueryEstadoComision= sFinalQueryEstadoComision;
	}
	
	public Border resaltarSeleccionarEstadoComision=null;
	
	public Border setResaltarSeleccionarEstadoComision(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoComisionBeanSwingJInternalFrame estadocomisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadocomisionBeanSwingJInternalFrame.jTtoolBarEstadoComision.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoComision= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoComision() {
		return this.resaltarSeleccionarEstadoComision;
	}
	
	public void setResaltarSeleccionarEstadoComision(Border borderResaltarSeleccionarEstadoComision) {
		this.resaltarSeleccionarEstadoComision= borderResaltarSeleccionarEstadoComision;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoComision=null;
	public Boolean mostraridEstadoComision=true;
	public Boolean activaridEstadoComision=true;

	public Border resaltarcodigoEstadoComision=null;
	public Boolean mostrarcodigoEstadoComision=true;
	public Boolean activarcodigoEstadoComision=true;

	public Border resaltarnombreEstadoComision=null;
	public Boolean mostrarnombreEstadoComision=true;
	public Boolean activarnombreEstadoComision=true;

	
	

	public Border setResaltaridEstadoComision(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoComisionBeanSwingJInternalFrame estadocomisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocomisionBeanSwingJInternalFrame.jTtoolBarEstadoComision.setBorder(borderResaltar);
		
		this.resaltaridEstadoComision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoComision() {
		return this.resaltaridEstadoComision;
	}

	public void setResaltaridEstadoComision(Border borderResaltar) {
		this.resaltaridEstadoComision= borderResaltar;
	}

	public Boolean getMostraridEstadoComision() {
		return this.mostraridEstadoComision;
	}

	public void setMostraridEstadoComision(Boolean mostraridEstadoComision) {
		this.mostraridEstadoComision= mostraridEstadoComision;
	}

	public Boolean getActivaridEstadoComision() {
		return this.activaridEstadoComision;
	}

	public void setActivaridEstadoComision(Boolean activaridEstadoComision) {
		this.activaridEstadoComision= activaridEstadoComision;
	}

	public Border setResaltarcodigoEstadoComision(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoComisionBeanSwingJInternalFrame estadocomisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocomisionBeanSwingJInternalFrame.jTtoolBarEstadoComision.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoComision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoComision() {
		return this.resaltarcodigoEstadoComision;
	}

	public void setResaltarcodigoEstadoComision(Border borderResaltar) {
		this.resaltarcodigoEstadoComision= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoComision() {
		return this.mostrarcodigoEstadoComision;
	}

	public void setMostrarcodigoEstadoComision(Boolean mostrarcodigoEstadoComision) {
		this.mostrarcodigoEstadoComision= mostrarcodigoEstadoComision;
	}

	public Boolean getActivarcodigoEstadoComision() {
		return this.activarcodigoEstadoComision;
	}

	public void setActivarcodigoEstadoComision(Boolean activarcodigoEstadoComision) {
		this.activarcodigoEstadoComision= activarcodigoEstadoComision;
	}

	public Border setResaltarnombreEstadoComision(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoComisionBeanSwingJInternalFrame estadocomisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadocomisionBeanSwingJInternalFrame.jTtoolBarEstadoComision.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoComision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoComision() {
		return this.resaltarnombreEstadoComision;
	}

	public void setResaltarnombreEstadoComision(Border borderResaltar) {
		this.resaltarnombreEstadoComision= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoComision() {
		return this.mostrarnombreEstadoComision;
	}

	public void setMostrarnombreEstadoComision(Boolean mostrarnombreEstadoComision) {
		this.mostrarnombreEstadoComision= mostrarnombreEstadoComision;
	}

	public Boolean getActivarnombreEstadoComision() {
		return this.activarnombreEstadoComision;
	}

	public void setActivarnombreEstadoComision(Boolean activarnombreEstadoComision) {
		this.activarnombreEstadoComision= activarnombreEstadoComision;
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
		
		
		this.setMostraridEstadoComision(esInicial);
		this.setMostrarcodigoEstadoComision(esInicial);
		this.setMostrarnombreEstadoComision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoComisionConstantesFunciones.ID)) {
				this.setMostraridEstadoComision(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoComisionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoComision(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoComisionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoComision(esAsigna);
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
		
		
		this.setActivaridEstadoComision(esInicial);
		this.setActivarcodigoEstadoComision(esInicial);
		this.setActivarnombreEstadoComision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoComisionConstantesFunciones.ID)) {
				this.setActivaridEstadoComision(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoComisionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoComision(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoComisionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoComision(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoComisionBeanSwingJInternalFrame estadocomisionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoComision(esInicial);
		this.setResaltarcodigoEstadoComision(esInicial);
		this.setResaltarnombreEstadoComision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoComisionConstantesFunciones.ID)) {
				this.setResaltaridEstadoComision(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoComisionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoComision(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoComisionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoComision(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoComisionBeanSwingJInternalFrame estadocomisionBeanSwingJInternalFrame*/)throws Exception {	
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