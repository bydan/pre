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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.FacturacionConstantesFunciones;
import com.bydan.erp.facturacion.util.FacturacionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.FacturacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.facturacion.util.report.*;
import com.bydan.erp.facturacion.business.entity.report.*;
import com.bydan.erp.facturacion.util.FacturacionSql;
import com.bydan.erp.facturacion.util.FacturacionSqlReporte;


@SuppressWarnings("unused")
final public class FacturacionConstantesFunciones extends FacturacionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Facturacion";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Facturacion"+FacturacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturacionConstantesFunciones.SCHEMA+"_"+FacturacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturacionConstantesFunciones.SCHEMA+"_"+FacturacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturacionConstantesFunciones.SCHEMA+"_"+FacturacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturacionConstantesFunciones.SCHEMA+"_"+FacturacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Facturaciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Facturacion";
	public static final String SCLASSWEBTITULO_LOWER="Facturacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Facturacion";
	public static final String OBJECTNAME="facturacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="facturacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturacion from "+FacturacionConstantesFunciones.SPERSISTENCENAME+" facturacion";
	public static String QUERYSELECTNATIVE="select "+FacturacionConstantesFunciones.SCHEMA+"."+FacturacionConstantesFunciones.TABLENAME+".id,"+FacturacionConstantesFunciones.SCHEMA+"."+FacturacionConstantesFunciones.TABLENAME+".version_row,"+FacturacionConstantesFunciones.SCHEMA+"."+FacturacionConstantesFunciones.TABLENAME+".codigo from "+FacturacionConstantesFunciones.SCHEMA+"."+FacturacionConstantesFunciones.TABLENAME;//+" as "+FacturacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FacturacionConstantesFuncionesAdditional facturacionConstantesFuncionesAdditional=null;
	
	public FacturacionConstantesFuncionesAdditional getFacturacionConstantesFuncionesAdditional() {
		return this.facturacionConstantesFuncionesAdditional;
	}
	
	public void setFacturacionConstantesFuncionesAdditional(FacturacionConstantesFuncionesAdditional facturacionConstantesFuncionesAdditional) {
		try {
			this.facturacionConstantesFuncionesAdditional=facturacionConstantesFuncionesAdditional;
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
	
	public static String getFacturacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturacionConstantesFunciones.CODIGO)) {sLabelColumna=FacturacionConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getFacturacionDescripcion(Facturacion facturacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturacion !=null/* && facturacion.getId()!=0*/) {
			sDescripcion=facturacion.getcodigo();//facturacionfacturacion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturacionDescripcionDetallado(Facturacion facturacion) {
		String sDescripcion="";
			
		sDescripcion+=FacturacionConstantesFunciones.ID+"=";
		sDescripcion+=facturacion.getId().toString()+",";
		sDescripcion+=FacturacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturacion.getVersionRow().toString()+",";
		sDescripcion+=FacturacionConstantesFunciones.CODIGO+"=";
		sDescripcion+=facturacion.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturacionDescripcion(Facturacion facturacion,String sValor) throws Exception {			
		if(facturacion !=null) {
			facturacion.setcodigo(sValor);;//facturacionfacturacion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosFacturacion(Facturacion facturacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturacion.setcodigo(facturacion.getcodigo().trim());
	}
	
	public static void quitarEspaciosFacturacions(List<Facturacion> facturacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Facturacion facturacion: facturacions) {
			facturacion.setcodigo(facturacion.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturacion(Facturacion facturacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturacion.getConCambioAuxiliar()) {
			facturacion.setIsDeleted(facturacion.getIsDeletedAuxiliar());	
			facturacion.setIsNew(facturacion.getIsNewAuxiliar());	
			facturacion.setIsChanged(facturacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturacion.setIsDeletedAuxiliar(false);	
			facturacion.setIsNewAuxiliar(false);	
			facturacion.setIsChangedAuxiliar(false);
			
			facturacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturacions(List<Facturacion> facturacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Facturacion facturacion : facturacions) {
			if(conAsignarBase && facturacion.getConCambioAuxiliar()) {
				facturacion.setIsDeleted(facturacion.getIsDeletedAuxiliar());	
				facturacion.setIsNew(facturacion.getIsNewAuxiliar());	
				facturacion.setIsChanged(facturacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturacion.setIsDeletedAuxiliar(false);	
				facturacion.setIsNewAuxiliar(false);	
				facturacion.setIsChangedAuxiliar(false);
				
				facturacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturacion(Facturacion facturacion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFacturacions(List<Facturacion> facturacions,Boolean conEnteros) throws Exception  {
		
		for(Facturacion facturacion: facturacions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturacion(List<Facturacion> facturacions,Facturacion facturacionAux) throws Exception  {
		FacturacionConstantesFunciones.InicializarValoresFacturacion(facturacionAux,true);
		
		for(Facturacion facturacion: facturacions) {
			if(facturacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturacionConstantesFunciones.getArrayColumnasGlobalesFacturacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Facturacion> facturacions,Facturacion facturacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Facturacion facturacionAux: facturacions) {
			if(facturacionAux!=null && facturacion!=null) {
				if((facturacionAux.getId()==null && facturacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturacionAux.getId()!=null && facturacion.getId()!=null){
					if(facturacionAux.getId().equals(facturacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturacion(List<Facturacion> facturacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Facturacion facturacion: facturacions) {			
			if(facturacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturacion() throws Exception  {
		return FacturacionConstantesFunciones.getTiposSeleccionarFacturacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturacion(Boolean conFk) throws Exception  {
		return FacturacionConstantesFunciones.getTiposSeleccionarFacturacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(FacturacionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturacion(Facturacion facturacionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesFacturacion(List<Facturacion> facturacionsTemp) throws Exception {
		for(Facturacion facturacionAux:facturacionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturacionConstantesFunciones.getClassesRelationshipsOfFacturacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturacionConstantesFunciones.getClassesRelationshipsFromStringsOfFacturacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Facturacion facturacion,List<Facturacion> facturacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Facturacion facturacionEncontrado=null;
			
			for(Facturacion facturacionLocal:facturacions) {
				if(facturacionLocal.getId().equals(facturacion.getId())) {
					facturacionEncontrado=facturacionLocal;
					
					facturacionLocal.setIsChanged(facturacion.getIsChanged());
					facturacionLocal.setIsNew(facturacion.getIsNew());
					facturacionLocal.setIsDeleted(facturacion.getIsDeleted());
					
					facturacionLocal.setGeneralEntityOriginal(facturacion.getGeneralEntityOriginal());
					
					facturacionLocal.setId(facturacion.getId());	
					facturacionLocal.setVersionRow(facturacion.getVersionRow());	
					facturacionLocal.setcodigo(facturacion.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!facturacion.getIsDeleted()) {
				if(!existe) {
					facturacions.add(facturacion);
				}
			} else {
				if(facturacionEncontrado!=null && permiteQuitar)  {
					facturacions.remove(facturacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Facturacion facturacion,List<Facturacion> facturacions) throws Exception {
		try	{			
			for(Facturacion facturacionLocal:facturacions) {
				if(facturacionLocal.getId().equals(facturacion.getId())) {
					facturacionLocal.setIsSelected(facturacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturacion(List<Facturacion> facturacionsAux) throws Exception {
		//this.facturacionsAux=facturacionsAux;
		
		for(Facturacion facturacionAux:facturacionsAux) {
			if(facturacionAux.getIsChanged()) {
				facturacionAux.setIsChanged(false);
			}		
			
			if(facturacionAux.getIsNew()) {
				facturacionAux.setIsNew(false);
			}	
			
			if(facturacionAux.getIsDeleted()) {
				facturacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturacion(Facturacion facturacionAux) throws Exception {
		//this.facturacionAux=facturacionAux;
		
			if(facturacionAux.getIsChanged()) {
				facturacionAux.setIsChanged(false);
			}		
			
			if(facturacionAux.getIsNew()) {
				facturacionAux.setIsNew(false);
			}	
			
			if(facturacionAux.getIsDeleted()) {
				facturacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Facturacion facturacionAsignar,Facturacion facturacion) throws Exception {
		facturacionAsignar.setId(facturacion.getId());	
		facturacionAsignar.setVersionRow(facturacion.getVersionRow());	
		facturacionAsignar.setcodigo(facturacion.getcodigo());	
	}
	
	public static void inicializarFacturacion(Facturacion facturacion) throws Exception {
		try {
				facturacion.setId(0L);	
					
				facturacion.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturacion(String sTipo,Row row,Workbook workbook,Facturacion facturacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFacturacion() {
		return this.sFinalQueryFacturacion;
	}
	
	public void setsFinalQueryFacturacion(String sFinalQueryFacturacion) {
		this.sFinalQueryFacturacion= sFinalQueryFacturacion;
	}
	
	public Border resaltarSeleccionarFacturacion=null;
	
	public Border setResaltarSeleccionarFacturacion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionBeanSwingJInternalFrame facturacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturacionBeanSwingJInternalFrame.jTtoolBarFacturacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturacion() {
		return this.resaltarSeleccionarFacturacion;
	}
	
	public void setResaltarSeleccionarFacturacion(Border borderResaltarSeleccionarFacturacion) {
		this.resaltarSeleccionarFacturacion= borderResaltarSeleccionarFacturacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturacion=null;
	public Boolean mostraridFacturacion=true;
	public Boolean activaridFacturacion=true;

	public Border resaltarcodigoFacturacion=null;
	public Boolean mostrarcodigoFacturacion=true;
	public Boolean activarcodigoFacturacion=true;

	
	

	public Border setResaltaridFacturacion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionBeanSwingJInternalFrame facturacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionBeanSwingJInternalFrame.jTtoolBarFacturacion.setBorder(borderResaltar);
		
		this.resaltaridFacturacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturacion() {
		return this.resaltaridFacturacion;
	}

	public void setResaltaridFacturacion(Border borderResaltar) {
		this.resaltaridFacturacion= borderResaltar;
	}

	public Boolean getMostraridFacturacion() {
		return this.mostraridFacturacion;
	}

	public void setMostraridFacturacion(Boolean mostraridFacturacion) {
		this.mostraridFacturacion= mostraridFacturacion;
	}

	public Boolean getActivaridFacturacion() {
		return this.activaridFacturacion;
	}

	public void setActivaridFacturacion(Boolean activaridFacturacion) {
		this.activaridFacturacion= activaridFacturacion;
	}

	public Border setResaltarcodigoFacturacion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionBeanSwingJInternalFrame facturacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionBeanSwingJInternalFrame.jTtoolBarFacturacion.setBorder(borderResaltar);
		
		this.resaltarcodigoFacturacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoFacturacion() {
		return this.resaltarcodigoFacturacion;
	}

	public void setResaltarcodigoFacturacion(Border borderResaltar) {
		this.resaltarcodigoFacturacion= borderResaltar;
	}

	public Boolean getMostrarcodigoFacturacion() {
		return this.mostrarcodigoFacturacion;
	}

	public void setMostrarcodigoFacturacion(Boolean mostrarcodigoFacturacion) {
		this.mostrarcodigoFacturacion= mostrarcodigoFacturacion;
	}

	public Boolean getActivarcodigoFacturacion() {
		return this.activarcodigoFacturacion;
	}

	public void setActivarcodigoFacturacion(Boolean activarcodigoFacturacion) {
		this.activarcodigoFacturacion= activarcodigoFacturacion;
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
		
		
		this.setMostraridFacturacion(esInicial);
		this.setMostrarcodigoFacturacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturacionConstantesFunciones.ID)) {
				this.setMostraridFacturacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoFacturacion(esAsigna);
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
		
		
		this.setActivaridFacturacion(esInicial);
		this.setActivarcodigoFacturacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturacionConstantesFunciones.ID)) {
				this.setActivaridFacturacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoFacturacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturacionBeanSwingJInternalFrame facturacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturacion(esInicial);
		this.setResaltarcodigoFacturacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturacionConstantesFunciones.ID)) {
				this.setResaltaridFacturacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoFacturacion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturacionBeanSwingJInternalFrame facturacionBeanSwingJInternalFrame*/)throws Exception {	
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