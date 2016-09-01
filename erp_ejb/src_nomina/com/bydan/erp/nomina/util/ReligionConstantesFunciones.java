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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.ReligionConstantesFunciones;
import com.bydan.erp.nomina.util.ReligionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ReligionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ReligionConstantesFunciones extends ReligionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Religion";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Religion"+ReligionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ReligionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ReligionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ReligionConstantesFunciones.SCHEMA+"_"+ReligionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ReligionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ReligionConstantesFunciones.SCHEMA+"_"+ReligionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ReligionConstantesFunciones.SCHEMA+"_"+ReligionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ReligionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ReligionConstantesFunciones.SCHEMA+"_"+ReligionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReligionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReligionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReligionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReligionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReligionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReligionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ReligionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ReligionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ReligionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ReligionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Religiones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Religion";
	public static final String SCLASSWEBTITULO_LOWER="Religion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Religion";
	public static final String OBJECTNAME="religion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="religion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select religion from "+ReligionConstantesFunciones.SPERSISTENCENAME+" religion";
	public static String QUERYSELECTNATIVE="select "+ReligionConstantesFunciones.SCHEMA+"."+ReligionConstantesFunciones.TABLENAME+".id,"+ReligionConstantesFunciones.SCHEMA+"."+ReligionConstantesFunciones.TABLENAME+".version_row,"+ReligionConstantesFunciones.SCHEMA+"."+ReligionConstantesFunciones.TABLENAME+".codigo,"+ReligionConstantesFunciones.SCHEMA+"."+ReligionConstantesFunciones.TABLENAME+".nombre from "+ReligionConstantesFunciones.SCHEMA+"."+ReligionConstantesFunciones.TABLENAME;//+" as "+ReligionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ReligionConstantesFuncionesAdditional religionConstantesFuncionesAdditional=null;
	
	public ReligionConstantesFuncionesAdditional getReligionConstantesFuncionesAdditional() {
		return this.religionConstantesFuncionesAdditional;
	}
	
	public void setReligionConstantesFuncionesAdditional(ReligionConstantesFuncionesAdditional religionConstantesFuncionesAdditional) {
		try {
			this.religionConstantesFuncionesAdditional=religionConstantesFuncionesAdditional;
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
	
	public static String getReligionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ReligionConstantesFunciones.CODIGO)) {sLabelColumna=ReligionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ReligionConstantesFunciones.NOMBRE)) {sLabelColumna=ReligionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getReligionDescripcion(Religion religion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(religion !=null/* && religion.getId()!=0*/) {
			sDescripcion=religion.getcodigo();//religionreligion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getReligionDescripcionDetallado(Religion religion) {
		String sDescripcion="";
			
		sDescripcion+=ReligionConstantesFunciones.ID+"=";
		sDescripcion+=religion.getId().toString()+",";
		sDescripcion+=ReligionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=religion.getVersionRow().toString()+",";
		sDescripcion+=ReligionConstantesFunciones.CODIGO+"=";
		sDescripcion+=religion.getcodigo()+",";
		sDescripcion+=ReligionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=religion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setReligionDescripcion(Religion religion,String sValor) throws Exception {			
		if(religion !=null) {
			religion.setcodigo(sValor);;//religionreligion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosReligion(Religion religion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		religion.setcodigo(religion.getcodigo().trim());
		religion.setnombre(religion.getnombre().trim());
	}
	
	public static void quitarEspaciosReligions(List<Religion> religions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Religion religion: religions) {
			religion.setcodigo(religion.getcodigo().trim());
			religion.setnombre(religion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReligion(Religion religion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && religion.getConCambioAuxiliar()) {
			religion.setIsDeleted(religion.getIsDeletedAuxiliar());	
			religion.setIsNew(religion.getIsNewAuxiliar());	
			religion.setIsChanged(religion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			religion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			religion.setIsDeletedAuxiliar(false);	
			religion.setIsNewAuxiliar(false);	
			religion.setIsChangedAuxiliar(false);
			
			religion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReligions(List<Religion> religions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Religion religion : religions) {
			if(conAsignarBase && religion.getConCambioAuxiliar()) {
				religion.setIsDeleted(religion.getIsDeletedAuxiliar());	
				religion.setIsNew(religion.getIsNewAuxiliar());	
				religion.setIsChanged(religion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				religion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				religion.setIsDeletedAuxiliar(false);	
				religion.setIsNewAuxiliar(false);	
				religion.setIsChangedAuxiliar(false);
				
				religion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresReligion(Religion religion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresReligions(List<Religion> religions,Boolean conEnteros) throws Exception  {
		
		for(Religion religion: religions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaReligion(List<Religion> religions,Religion religionAux) throws Exception  {
		ReligionConstantesFunciones.InicializarValoresReligion(religionAux,true);
		
		for(Religion religion: religions) {
			if(religion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesReligion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ReligionConstantesFunciones.getArrayColumnasGlobalesReligion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesReligion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoReligion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Religion> religions,Religion religion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Religion religionAux: religions) {
			if(religionAux!=null && religion!=null) {
				if((religionAux.getId()==null && religion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(religionAux.getId()!=null && religion.getId()!=null){
					if(religionAux.getId().equals(religion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaReligion(List<Religion> religions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Religion religion: religions) {			
			if(religion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaReligion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ReligionConstantesFunciones.LABEL_ID, ReligionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReligionConstantesFunciones.LABEL_VERSIONROW, ReligionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReligionConstantesFunciones.LABEL_CODIGO, ReligionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReligionConstantesFunciones.LABEL_NOMBRE, ReligionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasReligion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ReligionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReligionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReligionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReligionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReligion() throws Exception  {
		return ReligionConstantesFunciones.getTiposSeleccionarReligion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReligion(Boolean conFk) throws Exception  {
		return ReligionConstantesFunciones.getTiposSeleccionarReligion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReligion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReligionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ReligionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReligionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ReligionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesReligion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesReligion(Religion religionAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesReligion(List<Religion> religionsTemp) throws Exception {
		for(Religion religionAux:religionsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfReligion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfReligion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfReligion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReligionConstantesFunciones.getClassesRelationshipsOfReligion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReligion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReligion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReligionConstantesFunciones.getClassesRelationshipsFromStringsOfReligion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReligion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	public static void actualizarLista(Religion religion,List<Religion> religions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Religion religionEncontrado=null;
			
			for(Religion religionLocal:religions) {
				if(religionLocal.getId().equals(religion.getId())) {
					religionEncontrado=religionLocal;
					
					religionLocal.setIsChanged(religion.getIsChanged());
					religionLocal.setIsNew(religion.getIsNew());
					religionLocal.setIsDeleted(religion.getIsDeleted());
					
					religionLocal.setGeneralEntityOriginal(religion.getGeneralEntityOriginal());
					
					religionLocal.setId(religion.getId());	
					religionLocal.setVersionRow(religion.getVersionRow());	
					religionLocal.setcodigo(religion.getcodigo());	
					religionLocal.setnombre(religion.getnombre());	
					
					
					religionLocal.setEmpleados(religion.getEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!religion.getIsDeleted()) {
				if(!existe) {
					religions.add(religion);
				}
			} else {
				if(religionEncontrado!=null && permiteQuitar)  {
					religions.remove(religionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Religion religion,List<Religion> religions) throws Exception {
		try	{			
			for(Religion religionLocal:religions) {
				if(religionLocal.getId().equals(religion.getId())) {
					religionLocal.setIsSelected(religion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesReligion(List<Religion> religionsAux) throws Exception {
		//this.religionsAux=religionsAux;
		
		for(Religion religionAux:religionsAux) {
			if(religionAux.getIsChanged()) {
				religionAux.setIsChanged(false);
			}		
			
			if(religionAux.getIsNew()) {
				religionAux.setIsNew(false);
			}	
			
			if(religionAux.getIsDeleted()) {
				religionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesReligion(Religion religionAux) throws Exception {
		//this.religionAux=religionAux;
		
			if(religionAux.getIsChanged()) {
				religionAux.setIsChanged(false);
			}		
			
			if(religionAux.getIsNew()) {
				religionAux.setIsNew(false);
			}	
			
			if(religionAux.getIsDeleted()) {
				religionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Religion religionAsignar,Religion religion) throws Exception {
		religionAsignar.setId(religion.getId());	
		religionAsignar.setVersionRow(religion.getVersionRow());	
		religionAsignar.setcodigo(religion.getcodigo());	
		religionAsignar.setnombre(religion.getnombre());	
	}
	
	public static void inicializarReligion(Religion religion) throws Exception {
		try {
				religion.setId(0L);	
					
				religion.setcodigo("");	
				religion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderReligion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ReligionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReligionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataReligion(String sTipo,Row row,Workbook workbook,Religion religion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(religion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(religion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryReligion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryReligion() {
		return this.sFinalQueryReligion;
	}
	
	public void setsFinalQueryReligion(String sFinalQueryReligion) {
		this.sFinalQueryReligion= sFinalQueryReligion;
	}
	
	public Border resaltarSeleccionarReligion=null;
	
	public Border setResaltarSeleccionarReligion(ParametroGeneralUsuario parametroGeneralUsuario/*ReligionBeanSwingJInternalFrame religionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//religionBeanSwingJInternalFrame.jTtoolBarReligion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarReligion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarReligion() {
		return this.resaltarSeleccionarReligion;
	}
	
	public void setResaltarSeleccionarReligion(Border borderResaltarSeleccionarReligion) {
		this.resaltarSeleccionarReligion= borderResaltarSeleccionarReligion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridReligion=null;
	public Boolean mostraridReligion=true;
	public Boolean activaridReligion=true;

	public Border resaltarcodigoReligion=null;
	public Boolean mostrarcodigoReligion=true;
	public Boolean activarcodigoReligion=true;

	public Border resaltarnombreReligion=null;
	public Boolean mostrarnombreReligion=true;
	public Boolean activarnombreReligion=true;

	
	

	public Border setResaltaridReligion(ParametroGeneralUsuario parametroGeneralUsuario/*ReligionBeanSwingJInternalFrame religionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//religionBeanSwingJInternalFrame.jTtoolBarReligion.setBorder(borderResaltar);
		
		this.resaltaridReligion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridReligion() {
		return this.resaltaridReligion;
	}

	public void setResaltaridReligion(Border borderResaltar) {
		this.resaltaridReligion= borderResaltar;
	}

	public Boolean getMostraridReligion() {
		return this.mostraridReligion;
	}

	public void setMostraridReligion(Boolean mostraridReligion) {
		this.mostraridReligion= mostraridReligion;
	}

	public Boolean getActivaridReligion() {
		return this.activaridReligion;
	}

	public void setActivaridReligion(Boolean activaridReligion) {
		this.activaridReligion= activaridReligion;
	}

	public Border setResaltarcodigoReligion(ParametroGeneralUsuario parametroGeneralUsuario/*ReligionBeanSwingJInternalFrame religionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//religionBeanSwingJInternalFrame.jTtoolBarReligion.setBorder(borderResaltar);
		
		this.resaltarcodigoReligion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoReligion() {
		return this.resaltarcodigoReligion;
	}

	public void setResaltarcodigoReligion(Border borderResaltar) {
		this.resaltarcodigoReligion= borderResaltar;
	}

	public Boolean getMostrarcodigoReligion() {
		return this.mostrarcodigoReligion;
	}

	public void setMostrarcodigoReligion(Boolean mostrarcodigoReligion) {
		this.mostrarcodigoReligion= mostrarcodigoReligion;
	}

	public Boolean getActivarcodigoReligion() {
		return this.activarcodigoReligion;
	}

	public void setActivarcodigoReligion(Boolean activarcodigoReligion) {
		this.activarcodigoReligion= activarcodigoReligion;
	}

	public Border setResaltarnombreReligion(ParametroGeneralUsuario parametroGeneralUsuario/*ReligionBeanSwingJInternalFrame religionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//religionBeanSwingJInternalFrame.jTtoolBarReligion.setBorder(borderResaltar);
		
		this.resaltarnombreReligion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreReligion() {
		return this.resaltarnombreReligion;
	}

	public void setResaltarnombreReligion(Border borderResaltar) {
		this.resaltarnombreReligion= borderResaltar;
	}

	public Boolean getMostrarnombreReligion() {
		return this.mostrarnombreReligion;
	}

	public void setMostrarnombreReligion(Boolean mostrarnombreReligion) {
		this.mostrarnombreReligion= mostrarnombreReligion;
	}

	public Boolean getActivarnombreReligion() {
		return this.activarnombreReligion;
	}

	public void setActivarnombreReligion(Boolean activarnombreReligion) {
		this.activarnombreReligion= activarnombreReligion;
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
		
		
		this.setMostraridReligion(esInicial);
		this.setMostrarcodigoReligion(esInicial);
		this.setMostrarnombreReligion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReligionConstantesFunciones.ID)) {
				this.setMostraridReligion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReligionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoReligion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReligionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreReligion(esAsigna);
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
		
		
		this.setActivaridReligion(esInicial);
		this.setActivarcodigoReligion(esInicial);
		this.setActivarnombreReligion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReligionConstantesFunciones.ID)) {
				this.setActivaridReligion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReligionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoReligion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReligionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreReligion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ReligionBeanSwingJInternalFrame religionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridReligion(esInicial);
		this.setResaltarcodigoReligion(esInicial);
		this.setResaltarnombreReligion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReligionConstantesFunciones.ID)) {
				this.setResaltaridReligion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReligionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoReligion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReligionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreReligion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEmpleadoReligion=null;

	public Border getResaltarEmpleadoReligion() {
		return this.resaltarEmpleadoReligion;
	}

	public void setResaltarEmpleadoReligion(Border borderResaltarEmpleado) {
		if(borderResaltarEmpleado!=null) {
			this.resaltarEmpleadoReligion= borderResaltarEmpleado;
		}
	}

	public Border setResaltarEmpleadoReligion(ParametroGeneralUsuario parametroGeneralUsuario/*ReligionBeanSwingJInternalFrame religionBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//religionBeanSwingJInternalFrame.jTtoolBarReligion.setBorder(borderResaltarEmpleado);
			
		this.resaltarEmpleadoReligion= borderResaltarEmpleado;

		 return borderResaltarEmpleado;
	}



	public Boolean mostrarEmpleadoReligion=true;

	public Boolean getMostrarEmpleadoReligion() {
		return this.mostrarEmpleadoReligion;
	}

	public void setMostrarEmpleadoReligion(Boolean visibilidadResaltarEmpleado) {
		this.mostrarEmpleadoReligion= visibilidadResaltarEmpleado;
	}



	public Boolean activarEmpleadoReligion=true;

	public Boolean gethabilitarResaltarEmpleadoReligion() {
		return this.activarEmpleadoReligion;
	}

	public void setActivarEmpleadoReligion(Boolean habilitarResaltarEmpleado) {
		this.activarEmpleadoReligion= habilitarResaltarEmpleado;
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

		this.setMostrarEmpleadoReligion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setMostrarEmpleadoReligion(esAsigna);
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

		this.setActivarEmpleadoReligion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setActivarEmpleadoReligion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ReligionBeanSwingJInternalFrame religionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEmpleadoReligion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Empleado.class)) {
				this.setResaltarEmpleadoReligion(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}