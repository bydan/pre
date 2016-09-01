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


import com.bydan.erp.inventario.util.EstadoRequisicionConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoRequisicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoRequisicionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoRequisicionConstantesFunciones extends EstadoRequisicionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoRequisicion";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoRequisicion"+EstadoRequisicionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoRequisicionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoRequisicionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoRequisicionConstantesFunciones.SCHEMA+"_"+EstadoRequisicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoRequisicionConstantesFunciones.SCHEMA+"_"+EstadoRequisicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoRequisicionConstantesFunciones.SCHEMA+"_"+EstadoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoRequisicionConstantesFunciones.SCHEMA+"_"+EstadoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoRequisicionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoRequisicionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoRequisicionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoRequisicionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Requisiciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Estado Requisicion";
	public static final String SCLASSWEBTITULO_LOWER="Estado Requisicion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoRequisicion";
	public static final String OBJECTNAME="estadorequisicion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="estado_requisicion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadorequisicion from "+EstadoRequisicionConstantesFunciones.SPERSISTENCENAME+" estadorequisicion";
	public static String QUERYSELECTNATIVE="select "+EstadoRequisicionConstantesFunciones.SCHEMA+"."+EstadoRequisicionConstantesFunciones.TABLENAME+".id,"+EstadoRequisicionConstantesFunciones.SCHEMA+"."+EstadoRequisicionConstantesFunciones.TABLENAME+".version_row,"+EstadoRequisicionConstantesFunciones.SCHEMA+"."+EstadoRequisicionConstantesFunciones.TABLENAME+".codigo,"+EstadoRequisicionConstantesFunciones.SCHEMA+"."+EstadoRequisicionConstantesFunciones.TABLENAME+".nombre from "+EstadoRequisicionConstantesFunciones.SCHEMA+"."+EstadoRequisicionConstantesFunciones.TABLENAME;//+" as "+EstadoRequisicionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoRequisicionConstantesFuncionesAdditional estadorequisicionConstantesFuncionesAdditional=null;
	
	public EstadoRequisicionConstantesFuncionesAdditional getEstadoRequisicionConstantesFuncionesAdditional() {
		return this.estadorequisicionConstantesFuncionesAdditional;
	}
	
	public void setEstadoRequisicionConstantesFuncionesAdditional(EstadoRequisicionConstantesFuncionesAdditional estadorequisicionConstantesFuncionesAdditional) {
		try {
			this.estadorequisicionConstantesFuncionesAdditional=estadorequisicionConstantesFuncionesAdditional;
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
	
	public static String getEstadoRequisicionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoRequisicionConstantesFunciones.CODIGO)) {sLabelColumna=EstadoRequisicionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoRequisicionConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoRequisicionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoRequisicionDescripcion(EstadoRequisicion estadorequisicion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadorequisicion !=null/* && estadorequisicion.getId()!=0*/) {
			sDescripcion=estadorequisicion.getcodigo();//estadorequisicionestadorequisicion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoRequisicionDescripcionDetallado(EstadoRequisicion estadorequisicion) {
		String sDescripcion="";
			
		sDescripcion+=EstadoRequisicionConstantesFunciones.ID+"=";
		sDescripcion+=estadorequisicion.getId().toString()+",";
		sDescripcion+=EstadoRequisicionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadorequisicion.getVersionRow().toString()+",";
		sDescripcion+=EstadoRequisicionConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadorequisicion.getcodigo()+",";
		sDescripcion+=EstadoRequisicionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadorequisicion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoRequisicionDescripcion(EstadoRequisicion estadorequisicion,String sValor) throws Exception {			
		if(estadorequisicion !=null) {
			estadorequisicion.setcodigo(sValor);;//estadorequisicionestadorequisicion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoRequisicion(EstadoRequisicion estadorequisicion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadorequisicion.setcodigo(estadorequisicion.getcodigo().trim());
		estadorequisicion.setnombre(estadorequisicion.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoRequisicions(List<EstadoRequisicion> estadorequisicions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoRequisicion estadorequisicion: estadorequisicions) {
			estadorequisicion.setcodigo(estadorequisicion.getcodigo().trim());
			estadorequisicion.setnombre(estadorequisicion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoRequisicion(EstadoRequisicion estadorequisicion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadorequisicion.getConCambioAuxiliar()) {
			estadorequisicion.setIsDeleted(estadorequisicion.getIsDeletedAuxiliar());	
			estadorequisicion.setIsNew(estadorequisicion.getIsNewAuxiliar());	
			estadorequisicion.setIsChanged(estadorequisicion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadorequisicion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadorequisicion.setIsDeletedAuxiliar(false);	
			estadorequisicion.setIsNewAuxiliar(false);	
			estadorequisicion.setIsChangedAuxiliar(false);
			
			estadorequisicion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoRequisicions(List<EstadoRequisicion> estadorequisicions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoRequisicion estadorequisicion : estadorequisicions) {
			if(conAsignarBase && estadorequisicion.getConCambioAuxiliar()) {
				estadorequisicion.setIsDeleted(estadorequisicion.getIsDeletedAuxiliar());	
				estadorequisicion.setIsNew(estadorequisicion.getIsNewAuxiliar());	
				estadorequisicion.setIsChanged(estadorequisicion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadorequisicion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadorequisicion.setIsDeletedAuxiliar(false);	
				estadorequisicion.setIsNewAuxiliar(false);	
				estadorequisicion.setIsChangedAuxiliar(false);
				
				estadorequisicion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoRequisicion(EstadoRequisicion estadorequisicion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoRequisicions(List<EstadoRequisicion> estadorequisicions,Boolean conEnteros) throws Exception  {
		
		for(EstadoRequisicion estadorequisicion: estadorequisicions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoRequisicion(List<EstadoRequisicion> estadorequisicions,EstadoRequisicion estadorequisicionAux) throws Exception  {
		EstadoRequisicionConstantesFunciones.InicializarValoresEstadoRequisicion(estadorequisicionAux,true);
		
		for(EstadoRequisicion estadorequisicion: estadorequisicions) {
			if(estadorequisicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoRequisicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoRequisicionConstantesFunciones.getArrayColumnasGlobalesEstadoRequisicion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoRequisicion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoRequisicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoRequisicion> estadorequisicions,EstadoRequisicion estadorequisicion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoRequisicion estadorequisicionAux: estadorequisicions) {
			if(estadorequisicionAux!=null && estadorequisicion!=null) {
				if((estadorequisicionAux.getId()==null && estadorequisicion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadorequisicionAux.getId()!=null && estadorequisicion.getId()!=null){
					if(estadorequisicionAux.getId().equals(estadorequisicion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoRequisicion(List<EstadoRequisicion> estadorequisicions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoRequisicion estadorequisicion: estadorequisicions) {			
			if(estadorequisicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoRequisicion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoRequisicionConstantesFunciones.LABEL_ID, EstadoRequisicionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRequisicionConstantesFunciones.LABEL_VERSIONROW, EstadoRequisicionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRequisicionConstantesFunciones.LABEL_CODIGO, EstadoRequisicionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRequisicionConstantesFunciones.LABEL_NOMBRE, EstadoRequisicionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoRequisicion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoRequisicionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRequisicionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRequisicionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRequisicionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRequisicion() throws Exception  {
		return EstadoRequisicionConstantesFunciones.getTiposSeleccionarEstadoRequisicion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRequisicion(Boolean conFk) throws Exception  {
		return EstadoRequisicionConstantesFunciones.getTiposSeleccionarEstadoRequisicion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRequisicion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoRequisicionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoRequisicionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoRequisicionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoRequisicionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoRequisicion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoRequisicion(EstadoRequisicion estadorequisicionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoRequisicion(List<EstadoRequisicion> estadorequisicionsTemp) throws Exception {
		for(EstadoRequisicion estadorequisicionAux:estadorequisicionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoRequisicionConstantesFunciones.getClassesRelationshipsOfEstadoRequisicion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Requisicion.class));
				classes.add(new Classe(RequisicionCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Requisicion.class)) {
						classes.add(new Classe(Requisicion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RequisicionCompra.class)) {
						classes.add(new Classe(RequisicionCompra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoRequisicionConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoRequisicion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Requisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Requisicion.class)); continue;
					}

					if(RequisicionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RequisicionCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Requisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Requisicion.class)); continue;
					}

					if(RequisicionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RequisicionCompra.class)); continue;
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
	public static void actualizarLista(EstadoRequisicion estadorequisicion,List<EstadoRequisicion> estadorequisicions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoRequisicion estadorequisicionEncontrado=null;
			
			for(EstadoRequisicion estadorequisicionLocal:estadorequisicions) {
				if(estadorequisicionLocal.getId().equals(estadorequisicion.getId())) {
					estadorequisicionEncontrado=estadorequisicionLocal;
					
					estadorequisicionLocal.setIsChanged(estadorequisicion.getIsChanged());
					estadorequisicionLocal.setIsNew(estadorequisicion.getIsNew());
					estadorequisicionLocal.setIsDeleted(estadorequisicion.getIsDeleted());
					
					estadorequisicionLocal.setGeneralEntityOriginal(estadorequisicion.getGeneralEntityOriginal());
					
					estadorequisicionLocal.setId(estadorequisicion.getId());	
					estadorequisicionLocal.setVersionRow(estadorequisicion.getVersionRow());	
					estadorequisicionLocal.setcodigo(estadorequisicion.getcodigo());	
					estadorequisicionLocal.setnombre(estadorequisicion.getnombre());	
					
					
					estadorequisicionLocal.setRequisicionCompraCompras(estadorequisicion.getRequisicionCompraCompras());
					
					existe=true;
					break;
				}
			}
			
			if(!estadorequisicion.getIsDeleted()) {
				if(!existe) {
					estadorequisicions.add(estadorequisicion);
				}
			} else {
				if(estadorequisicionEncontrado!=null && permiteQuitar)  {
					estadorequisicions.remove(estadorequisicionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoRequisicion estadorequisicion,List<EstadoRequisicion> estadorequisicions) throws Exception {
		try	{			
			for(EstadoRequisicion estadorequisicionLocal:estadorequisicions) {
				if(estadorequisicionLocal.getId().equals(estadorequisicion.getId())) {
					estadorequisicionLocal.setIsSelected(estadorequisicion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoRequisicion(List<EstadoRequisicion> estadorequisicionsAux) throws Exception {
		//this.estadorequisicionsAux=estadorequisicionsAux;
		
		for(EstadoRequisicion estadorequisicionAux:estadorequisicionsAux) {
			if(estadorequisicionAux.getIsChanged()) {
				estadorequisicionAux.setIsChanged(false);
			}		
			
			if(estadorequisicionAux.getIsNew()) {
				estadorequisicionAux.setIsNew(false);
			}	
			
			if(estadorequisicionAux.getIsDeleted()) {
				estadorequisicionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoRequisicion(EstadoRequisicion estadorequisicionAux) throws Exception {
		//this.estadorequisicionAux=estadorequisicionAux;
		
			if(estadorequisicionAux.getIsChanged()) {
				estadorequisicionAux.setIsChanged(false);
			}		
			
			if(estadorequisicionAux.getIsNew()) {
				estadorequisicionAux.setIsNew(false);
			}	
			
			if(estadorequisicionAux.getIsDeleted()) {
				estadorequisicionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoRequisicion estadorequisicionAsignar,EstadoRequisicion estadorequisicion) throws Exception {
		estadorequisicionAsignar.setId(estadorequisicion.getId());	
		estadorequisicionAsignar.setVersionRow(estadorequisicion.getVersionRow());	
		estadorequisicionAsignar.setcodigo(estadorequisicion.getcodigo());	
		estadorequisicionAsignar.setnombre(estadorequisicion.getnombre());	
	}
	
	public static void inicializarEstadoRequisicion(EstadoRequisicion estadorequisicion) throws Exception {
		try {
				estadorequisicion.setId(0L);	
					
				estadorequisicion.setcodigo("");	
				estadorequisicion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoRequisicion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoRequisicionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoRequisicionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoRequisicion(String sTipo,Row row,Workbook workbook,EstadoRequisicion estadorequisicion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadorequisicion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadorequisicion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoRequisicion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoRequisicion() {
		return this.sFinalQueryEstadoRequisicion;
	}
	
	public void setsFinalQueryEstadoRequisicion(String sFinalQueryEstadoRequisicion) {
		this.sFinalQueryEstadoRequisicion= sFinalQueryEstadoRequisicion;
	}
	
	public Border resaltarSeleccionarEstadoRequisicion=null;
	
	public Border setResaltarSeleccionarEstadoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRequisicionBeanSwingJInternalFrame estadorequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadorequisicionBeanSwingJInternalFrame.jTtoolBarEstadoRequisicion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoRequisicion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoRequisicion() {
		return this.resaltarSeleccionarEstadoRequisicion;
	}
	
	public void setResaltarSeleccionarEstadoRequisicion(Border borderResaltarSeleccionarEstadoRequisicion) {
		this.resaltarSeleccionarEstadoRequisicion= borderResaltarSeleccionarEstadoRequisicion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoRequisicion=null;
	public Boolean mostraridEstadoRequisicion=true;
	public Boolean activaridEstadoRequisicion=true;

	public Border resaltarcodigoEstadoRequisicion=null;
	public Boolean mostrarcodigoEstadoRequisicion=true;
	public Boolean activarcodigoEstadoRequisicion=true;

	public Border resaltarnombreEstadoRequisicion=null;
	public Boolean mostrarnombreEstadoRequisicion=true;
	public Boolean activarnombreEstadoRequisicion=true;

	
	

	public Border setResaltaridEstadoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRequisicionBeanSwingJInternalFrame estadorequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadorequisicionBeanSwingJInternalFrame.jTtoolBarEstadoRequisicion.setBorder(borderResaltar);
		
		this.resaltaridEstadoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoRequisicion() {
		return this.resaltaridEstadoRequisicion;
	}

	public void setResaltaridEstadoRequisicion(Border borderResaltar) {
		this.resaltaridEstadoRequisicion= borderResaltar;
	}

	public Boolean getMostraridEstadoRequisicion() {
		return this.mostraridEstadoRequisicion;
	}

	public void setMostraridEstadoRequisicion(Boolean mostraridEstadoRequisicion) {
		this.mostraridEstadoRequisicion= mostraridEstadoRequisicion;
	}

	public Boolean getActivaridEstadoRequisicion() {
		return this.activaridEstadoRequisicion;
	}

	public void setActivaridEstadoRequisicion(Boolean activaridEstadoRequisicion) {
		this.activaridEstadoRequisicion= activaridEstadoRequisicion;
	}

	public Border setResaltarcodigoEstadoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRequisicionBeanSwingJInternalFrame estadorequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadorequisicionBeanSwingJInternalFrame.jTtoolBarEstadoRequisicion.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoRequisicion() {
		return this.resaltarcodigoEstadoRequisicion;
	}

	public void setResaltarcodigoEstadoRequisicion(Border borderResaltar) {
		this.resaltarcodigoEstadoRequisicion= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoRequisicion() {
		return this.mostrarcodigoEstadoRequisicion;
	}

	public void setMostrarcodigoEstadoRequisicion(Boolean mostrarcodigoEstadoRequisicion) {
		this.mostrarcodigoEstadoRequisicion= mostrarcodigoEstadoRequisicion;
	}

	public Boolean getActivarcodigoEstadoRequisicion() {
		return this.activarcodigoEstadoRequisicion;
	}

	public void setActivarcodigoEstadoRequisicion(Boolean activarcodigoEstadoRequisicion) {
		this.activarcodigoEstadoRequisicion= activarcodigoEstadoRequisicion;
	}

	public Border setResaltarnombreEstadoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRequisicionBeanSwingJInternalFrame estadorequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadorequisicionBeanSwingJInternalFrame.jTtoolBarEstadoRequisicion.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoRequisicion() {
		return this.resaltarnombreEstadoRequisicion;
	}

	public void setResaltarnombreEstadoRequisicion(Border borderResaltar) {
		this.resaltarnombreEstadoRequisicion= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoRequisicion() {
		return this.mostrarnombreEstadoRequisicion;
	}

	public void setMostrarnombreEstadoRequisicion(Boolean mostrarnombreEstadoRequisicion) {
		this.mostrarnombreEstadoRequisicion= mostrarnombreEstadoRequisicion;
	}

	public Boolean getActivarnombreEstadoRequisicion() {
		return this.activarnombreEstadoRequisicion;
	}

	public void setActivarnombreEstadoRequisicion(Boolean activarnombreEstadoRequisicion) {
		this.activarnombreEstadoRequisicion= activarnombreEstadoRequisicion;
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
		
		
		this.setMostraridEstadoRequisicion(esInicial);
		this.setMostrarcodigoEstadoRequisicion(esInicial);
		this.setMostrarnombreEstadoRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRequisicionConstantesFunciones.ID)) {
				this.setMostraridEstadoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRequisicionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRequisicionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoRequisicion(esAsigna);
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
		
		
		this.setActivaridEstadoRequisicion(esInicial);
		this.setActivarcodigoEstadoRequisicion(esInicial);
		this.setActivarnombreEstadoRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRequisicionConstantesFunciones.ID)) {
				this.setActivaridEstadoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRequisicionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRequisicionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoRequisicion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoRequisicionBeanSwingJInternalFrame estadorequisicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoRequisicion(esInicial);
		this.setResaltarcodigoEstadoRequisicion(esInicial);
		this.setResaltarnombreEstadoRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRequisicionConstantesFunciones.ID)) {
				this.setResaltaridEstadoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRequisicionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRequisicionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoRequisicion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarRequisicionCompraEstadoRequisicion=null;

	public Border getResaltarRequisicionCompraEstadoRequisicion() {
		return this.resaltarRequisicionCompraEstadoRequisicion;
	}

	public void setResaltarRequisicionCompraEstadoRequisicion(Border borderResaltarRequisicionCompra) {
		if(borderResaltarRequisicionCompra!=null) {
			this.resaltarRequisicionCompraEstadoRequisicion= borderResaltarRequisicionCompra;
		}
	}

	public Border setResaltarRequisicionCompraEstadoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRequisicionBeanSwingJInternalFrame estadorequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltarRequisicionCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadorequisicionBeanSwingJInternalFrame.jTtoolBarEstadoRequisicion.setBorder(borderResaltarRequisicionCompra);
			
		this.resaltarRequisicionCompraEstadoRequisicion= borderResaltarRequisicionCompra;

		 return borderResaltarRequisicionCompra;
	}



	public Boolean mostrarRequisicionCompraEstadoRequisicion=true;

	public Boolean getMostrarRequisicionCompraEstadoRequisicion() {
		return this.mostrarRequisicionCompraEstadoRequisicion;
	}

	public void setMostrarRequisicionCompraEstadoRequisicion(Boolean visibilidadResaltarRequisicionCompra) {
		this.mostrarRequisicionCompraEstadoRequisicion= visibilidadResaltarRequisicionCompra;
	}



	public Boolean activarRequisicionCompraEstadoRequisicion=true;

	public Boolean gethabilitarResaltarRequisicionCompraEstadoRequisicion() {
		return this.activarRequisicionCompraEstadoRequisicion;
	}

	public void setActivarRequisicionCompraEstadoRequisicion(Boolean habilitarResaltarRequisicionCompra) {
		this.activarRequisicionCompraEstadoRequisicion= habilitarResaltarRequisicionCompra;
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

		this.setMostrarRequisicionCompraEstadoRequisicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RequisicionCompra.class)) {
				this.setMostrarRequisicionCompraEstadoRequisicion(esAsigna);
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

		this.setActivarRequisicionCompraEstadoRequisicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RequisicionCompra.class)) {
				this.setActivarRequisicionCompraEstadoRequisicion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoRequisicionBeanSwingJInternalFrame estadorequisicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarRequisicionCompraEstadoRequisicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RequisicionCompra.class)) {
				this.setResaltarRequisicionCompraEstadoRequisicion(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}