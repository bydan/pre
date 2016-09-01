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
package com.bydan.erp.produccion.util;

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


import com.bydan.erp.produccion.util.ProduccionConstantesFunciones;
import com.bydan.erp.produccion.util.ProduccionParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ProduccionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.produccion.util.report.*;
import com.bydan.erp.produccion.business.entity.report.*;
import com.bydan.erp.produccion.util.ProduccionSql;
import com.bydan.erp.produccion.util.ProduccionSqlReporte;


@SuppressWarnings("unused")
final public class ProduccionConstantesFunciones extends ProduccionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Produccion";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Produccion"+ProduccionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProduccionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProduccionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProduccionConstantesFunciones.SCHEMA+"_"+ProduccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProduccionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProduccionConstantesFunciones.SCHEMA+"_"+ProduccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProduccionConstantesFunciones.SCHEMA+"_"+ProduccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProduccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProduccionConstantesFunciones.SCHEMA+"_"+ProduccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProduccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProduccionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProduccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProduccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProduccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProduccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProduccionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProduccionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProduccionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProduccionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Produccion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Produccion";
	public static final String OBJECTNAME="produccion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="produccion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select produccion from "+ProduccionConstantesFunciones.SPERSISTENCENAME+" produccion";
	public static String QUERYSELECTNATIVE="select "+ProduccionConstantesFunciones.SCHEMA+"."+ProduccionConstantesFunciones.TABLENAME+".id,"+ProduccionConstantesFunciones.SCHEMA+"."+ProduccionConstantesFunciones.TABLENAME+".version_row,"+ProduccionConstantesFunciones.SCHEMA+"."+ProduccionConstantesFunciones.TABLENAME+".codigo from "+ProduccionConstantesFunciones.SCHEMA+"."+ProduccionConstantesFunciones.TABLENAME;//+" as "+ProduccionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProduccionConstantesFuncionesAdditional produccionConstantesFuncionesAdditional=null;
	
	public ProduccionConstantesFuncionesAdditional getProduccionConstantesFuncionesAdditional() {
		return this.produccionConstantesFuncionesAdditional;
	}
	
	public void setProduccionConstantesFuncionesAdditional(ProduccionConstantesFuncionesAdditional produccionConstantesFuncionesAdditional) {
		try {
			this.produccionConstantesFuncionesAdditional=produccionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProduccionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProduccionConstantesFunciones.CODIGO)) {sLabelColumna=ProduccionConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getProduccionDescripcion(Produccion produccion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(produccion !=null/* && produccion.getId()!=0*/) {
			sDescripcion=produccion.getcodigo();//produccionproduccion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProduccionDescripcionDetallado(Produccion produccion) {
		String sDescripcion="";
			
		sDescripcion+=ProduccionConstantesFunciones.ID+"=";
		sDescripcion+=produccion.getId().toString()+",";
		sDescripcion+=ProduccionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=produccion.getVersionRow().toString()+",";
		sDescripcion+=ProduccionConstantesFunciones.CODIGO+"=";
		sDescripcion+=produccion.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setProduccionDescripcion(Produccion produccion,String sValor) throws Exception {			
		if(produccion !=null) {
			produccion.setcodigo(sValor);;//produccionproduccion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosProduccion(Produccion produccion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		produccion.setcodigo(produccion.getcodigo().trim());
	}
	
	public static void quitarEspaciosProduccions(List<Produccion> produccions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Produccion produccion: produccions) {
			produccion.setcodigo(produccion.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProduccion(Produccion produccion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && produccion.getConCambioAuxiliar()) {
			produccion.setIsDeleted(produccion.getIsDeletedAuxiliar());	
			produccion.setIsNew(produccion.getIsNewAuxiliar());	
			produccion.setIsChanged(produccion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			produccion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			produccion.setIsDeletedAuxiliar(false);	
			produccion.setIsNewAuxiliar(false);	
			produccion.setIsChangedAuxiliar(false);
			
			produccion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProduccions(List<Produccion> produccions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Produccion produccion : produccions) {
			if(conAsignarBase && produccion.getConCambioAuxiliar()) {
				produccion.setIsDeleted(produccion.getIsDeletedAuxiliar());	
				produccion.setIsNew(produccion.getIsNewAuxiliar());	
				produccion.setIsChanged(produccion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				produccion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				produccion.setIsDeletedAuxiliar(false);	
				produccion.setIsNewAuxiliar(false);	
				produccion.setIsChangedAuxiliar(false);
				
				produccion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProduccion(Produccion produccion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProduccions(List<Produccion> produccions,Boolean conEnteros) throws Exception  {
		
		for(Produccion produccion: produccions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProduccion(List<Produccion> produccions,Produccion produccionAux) throws Exception  {
		ProduccionConstantesFunciones.InicializarValoresProduccion(produccionAux,true);
		
		for(Produccion produccion: produccions) {
			if(produccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProduccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProduccionConstantesFunciones.getArrayColumnasGlobalesProduccion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProduccion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProduccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Produccion> produccions,Produccion produccion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Produccion produccionAux: produccions) {
			if(produccionAux!=null && produccion!=null) {
				if((produccionAux.getId()==null && produccion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(produccionAux.getId()!=null && produccion.getId()!=null){
					if(produccionAux.getId().equals(produccion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProduccion(List<Produccion> produccions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Produccion produccion: produccions) {			
			if(produccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProduccion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProduccion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProduccion() throws Exception  {
		return ProduccionConstantesFunciones.getTiposSeleccionarProduccion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProduccion(Boolean conFk) throws Exception  {
		return ProduccionConstantesFunciones.getTiposSeleccionarProduccion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProduccion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProduccionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProduccionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProduccion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProduccion(Produccion produccionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesProduccion(List<Produccion> produccionsTemp) throws Exception {
		for(Produccion produccionAux:produccionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProduccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProduccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProduccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProduccionConstantesFunciones.getClassesRelationshipsOfProduccion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProduccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProduccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProduccionConstantesFunciones.getClassesRelationshipsFromStringsOfProduccion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProduccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Produccion produccion,List<Produccion> produccions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Produccion produccionEncontrado=null;
			
			for(Produccion produccionLocal:produccions) {
				if(produccionLocal.getId().equals(produccion.getId())) {
					produccionEncontrado=produccionLocal;
					
					produccionLocal.setIsChanged(produccion.getIsChanged());
					produccionLocal.setIsNew(produccion.getIsNew());
					produccionLocal.setIsDeleted(produccion.getIsDeleted());
					
					produccionLocal.setGeneralEntityOriginal(produccion.getGeneralEntityOriginal());
					
					produccionLocal.setId(produccion.getId());	
					produccionLocal.setVersionRow(produccion.getVersionRow());	
					produccionLocal.setcodigo(produccion.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!produccion.getIsDeleted()) {
				if(!existe) {
					produccions.add(produccion);
				}
			} else {
				if(produccionEncontrado!=null && permiteQuitar)  {
					produccions.remove(produccionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Produccion produccion,List<Produccion> produccions) throws Exception {
		try	{			
			for(Produccion produccionLocal:produccions) {
				if(produccionLocal.getId().equals(produccion.getId())) {
					produccionLocal.setIsSelected(produccion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProduccion(List<Produccion> produccionsAux) throws Exception {
		//this.produccionsAux=produccionsAux;
		
		for(Produccion produccionAux:produccionsAux) {
			if(produccionAux.getIsChanged()) {
				produccionAux.setIsChanged(false);
			}		
			
			if(produccionAux.getIsNew()) {
				produccionAux.setIsNew(false);
			}	
			
			if(produccionAux.getIsDeleted()) {
				produccionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProduccion(Produccion produccionAux) throws Exception {
		//this.produccionAux=produccionAux;
		
			if(produccionAux.getIsChanged()) {
				produccionAux.setIsChanged(false);
			}		
			
			if(produccionAux.getIsNew()) {
				produccionAux.setIsNew(false);
			}	
			
			if(produccionAux.getIsDeleted()) {
				produccionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Produccion produccionAsignar,Produccion produccion) throws Exception {
		produccionAsignar.setId(produccion.getId());	
		produccionAsignar.setVersionRow(produccion.getVersionRow());	
		produccionAsignar.setcodigo(produccion.getcodigo());	
	}
	
	public static void inicializarProduccion(Produccion produccion) throws Exception {
		try {
				produccion.setId(0L);	
					
				produccion.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProduccion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProduccionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProduccion(String sTipo,Row row,Workbook workbook,Produccion produccion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(produccion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProduccion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProduccion() {
		return this.sFinalQueryProduccion;
	}
	
	public void setsFinalQueryProduccion(String sFinalQueryProduccion) {
		this.sFinalQueryProduccion= sFinalQueryProduccion;
	}
	
	public Border resaltarSeleccionarProduccion=null;
	
	public Border setResaltarSeleccionarProduccion(ParametroGeneralUsuario parametroGeneralUsuario/*ProduccionBeanSwingJInternalFrame produccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//produccionBeanSwingJInternalFrame.jTtoolBarProduccion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProduccion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProduccion() {
		return this.resaltarSeleccionarProduccion;
	}
	
	public void setResaltarSeleccionarProduccion(Border borderResaltarSeleccionarProduccion) {
		this.resaltarSeleccionarProduccion= borderResaltarSeleccionarProduccion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProduccion=null;
	public Boolean mostraridProduccion=true;
	public Boolean activaridProduccion=true;

	public Border resaltarcodigoProduccion=null;
	public Boolean mostrarcodigoProduccion=true;
	public Boolean activarcodigoProduccion=true;

	
	

	public Border setResaltaridProduccion(ParametroGeneralUsuario parametroGeneralUsuario/*ProduccionBeanSwingJInternalFrame produccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//produccionBeanSwingJInternalFrame.jTtoolBarProduccion.setBorder(borderResaltar);
		
		this.resaltaridProduccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProduccion() {
		return this.resaltaridProduccion;
	}

	public void setResaltaridProduccion(Border borderResaltar) {
		this.resaltaridProduccion= borderResaltar;
	}

	public Boolean getMostraridProduccion() {
		return this.mostraridProduccion;
	}

	public void setMostraridProduccion(Boolean mostraridProduccion) {
		this.mostraridProduccion= mostraridProduccion;
	}

	public Boolean getActivaridProduccion() {
		return this.activaridProduccion;
	}

	public void setActivaridProduccion(Boolean activaridProduccion) {
		this.activaridProduccion= activaridProduccion;
	}

	public Border setResaltarcodigoProduccion(ParametroGeneralUsuario parametroGeneralUsuario/*ProduccionBeanSwingJInternalFrame produccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//produccionBeanSwingJInternalFrame.jTtoolBarProduccion.setBorder(borderResaltar);
		
		this.resaltarcodigoProduccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProduccion() {
		return this.resaltarcodigoProduccion;
	}

	public void setResaltarcodigoProduccion(Border borderResaltar) {
		this.resaltarcodigoProduccion= borderResaltar;
	}

	public Boolean getMostrarcodigoProduccion() {
		return this.mostrarcodigoProduccion;
	}

	public void setMostrarcodigoProduccion(Boolean mostrarcodigoProduccion) {
		this.mostrarcodigoProduccion= mostrarcodigoProduccion;
	}

	public Boolean getActivarcodigoProduccion() {
		return this.activarcodigoProduccion;
	}

	public void setActivarcodigoProduccion(Boolean activarcodigoProduccion) {
		this.activarcodigoProduccion= activarcodigoProduccion;
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
		
		
		this.setMostraridProduccion(esInicial);
		this.setMostrarcodigoProduccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProduccionConstantesFunciones.ID)) {
				this.setMostraridProduccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProduccionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProduccion(esAsigna);
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
		
		
		this.setActivaridProduccion(esInicial);
		this.setActivarcodigoProduccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProduccionConstantesFunciones.ID)) {
				this.setActivaridProduccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProduccionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProduccion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProduccionBeanSwingJInternalFrame produccionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProduccion(esInicial);
		this.setResaltarcodigoProduccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProduccionConstantesFunciones.ID)) {
				this.setResaltaridProduccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProduccionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProduccion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProduccionBeanSwingJInternalFrame produccionBeanSwingJInternalFrame*/)throws Exception {	
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