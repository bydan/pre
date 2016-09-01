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


import com.bydan.erp.nomina.util.ParentezcoConstantesFunciones;
import com.bydan.erp.nomina.util.ParentezcoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ParentezcoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParentezcoConstantesFunciones extends ParentezcoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Parentezco";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Parentezco"+ParentezcoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParentezcoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParentezcoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParentezcoConstantesFunciones.SCHEMA+"_"+ParentezcoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParentezcoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParentezcoConstantesFunciones.SCHEMA+"_"+ParentezcoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParentezcoConstantesFunciones.SCHEMA+"_"+ParentezcoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParentezcoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParentezcoConstantesFunciones.SCHEMA+"_"+ParentezcoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParentezcoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParentezcoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParentezcoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParentezcoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParentezcoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParentezcoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParentezcoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParentezcoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParentezcoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParentezcoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parentezcos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parentezco";
	public static final String SCLASSWEBTITULO_LOWER="Parentezco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Parentezco";
	public static final String OBJECTNAME="parentezco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="parentezco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parentezco from "+ParentezcoConstantesFunciones.SPERSISTENCENAME+" parentezco";
	public static String QUERYSELECTNATIVE="select "+ParentezcoConstantesFunciones.SCHEMA+"."+ParentezcoConstantesFunciones.TABLENAME+".id,"+ParentezcoConstantesFunciones.SCHEMA+"."+ParentezcoConstantesFunciones.TABLENAME+".version_row,"+ParentezcoConstantesFunciones.SCHEMA+"."+ParentezcoConstantesFunciones.TABLENAME+".codigo,"+ParentezcoConstantesFunciones.SCHEMA+"."+ParentezcoConstantesFunciones.TABLENAME+".nombre from "+ParentezcoConstantesFunciones.SCHEMA+"."+ParentezcoConstantesFunciones.TABLENAME;//+" as "+ParentezcoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParentezcoConstantesFuncionesAdditional parentezcoConstantesFuncionesAdditional=null;
	
	public ParentezcoConstantesFuncionesAdditional getParentezcoConstantesFuncionesAdditional() {
		return this.parentezcoConstantesFuncionesAdditional;
	}
	
	public void setParentezcoConstantesFuncionesAdditional(ParentezcoConstantesFuncionesAdditional parentezcoConstantesFuncionesAdditional) {
		try {
			this.parentezcoConstantesFuncionesAdditional=parentezcoConstantesFuncionesAdditional;
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
	
	public static String getParentezcoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParentezcoConstantesFunciones.CODIGO)) {sLabelColumna=ParentezcoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ParentezcoConstantesFunciones.NOMBRE)) {sLabelColumna=ParentezcoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getParentezcoDescripcion(Parentezco parentezco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parentezco !=null/* && parentezco.getId()!=0*/) {
			sDescripcion=parentezco.getcodigo();//parentezcoparentezco.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getParentezcoDescripcionDetallado(Parentezco parentezco) {
		String sDescripcion="";
			
		sDescripcion+=ParentezcoConstantesFunciones.ID+"=";
		sDescripcion+=parentezco.getId().toString()+",";
		sDescripcion+=ParentezcoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parentezco.getVersionRow().toString()+",";
		sDescripcion+=ParentezcoConstantesFunciones.CODIGO+"=";
		sDescripcion+=parentezco.getcodigo()+",";
		sDescripcion+=ParentezcoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=parentezco.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setParentezcoDescripcion(Parentezco parentezco,String sValor) throws Exception {			
		if(parentezco !=null) {
			parentezco.setcodigo(sValor);;//parentezcoparentezco.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosParentezco(Parentezco parentezco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parentezco.setcodigo(parentezco.getcodigo().trim());
		parentezco.setnombre(parentezco.getnombre().trim());
	}
	
	public static void quitarEspaciosParentezcos(List<Parentezco> parentezcos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Parentezco parentezco: parentezcos) {
			parentezco.setcodigo(parentezco.getcodigo().trim());
			parentezco.setnombre(parentezco.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParentezco(Parentezco parentezco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parentezco.getConCambioAuxiliar()) {
			parentezco.setIsDeleted(parentezco.getIsDeletedAuxiliar());	
			parentezco.setIsNew(parentezco.getIsNewAuxiliar());	
			parentezco.setIsChanged(parentezco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parentezco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parentezco.setIsDeletedAuxiliar(false);	
			parentezco.setIsNewAuxiliar(false);	
			parentezco.setIsChangedAuxiliar(false);
			
			parentezco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParentezcos(List<Parentezco> parentezcos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Parentezco parentezco : parentezcos) {
			if(conAsignarBase && parentezco.getConCambioAuxiliar()) {
				parentezco.setIsDeleted(parentezco.getIsDeletedAuxiliar());	
				parentezco.setIsNew(parentezco.getIsNewAuxiliar());	
				parentezco.setIsChanged(parentezco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parentezco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parentezco.setIsDeletedAuxiliar(false);	
				parentezco.setIsNewAuxiliar(false);	
				parentezco.setIsChangedAuxiliar(false);
				
				parentezco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParentezco(Parentezco parentezco,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParentezcos(List<Parentezco> parentezcos,Boolean conEnteros) throws Exception  {
		
		for(Parentezco parentezco: parentezcos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParentezco(List<Parentezco> parentezcos,Parentezco parentezcoAux) throws Exception  {
		ParentezcoConstantesFunciones.InicializarValoresParentezco(parentezcoAux,true);
		
		for(Parentezco parentezco: parentezcos) {
			if(parentezco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParentezco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParentezcoConstantesFunciones.getArrayColumnasGlobalesParentezco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParentezco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParentezco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Parentezco> parentezcos,Parentezco parentezco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Parentezco parentezcoAux: parentezcos) {
			if(parentezcoAux!=null && parentezco!=null) {
				if((parentezcoAux.getId()==null && parentezco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parentezcoAux.getId()!=null && parentezco.getId()!=null){
					if(parentezcoAux.getId().equals(parentezco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParentezco(List<Parentezco> parentezcos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Parentezco parentezco: parentezcos) {			
			if(parentezco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParentezco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParentezcoConstantesFunciones.LABEL_ID, ParentezcoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParentezcoConstantesFunciones.LABEL_VERSIONROW, ParentezcoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParentezcoConstantesFunciones.LABEL_CODIGO, ParentezcoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParentezcoConstantesFunciones.LABEL_NOMBRE, ParentezcoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParentezco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParentezcoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParentezcoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParentezcoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParentezcoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParentezco() throws Exception  {
		return ParentezcoConstantesFunciones.getTiposSeleccionarParentezco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParentezco(Boolean conFk) throws Exception  {
		return ParentezcoConstantesFunciones.getTiposSeleccionarParentezco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParentezco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParentezcoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ParentezcoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParentezcoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ParentezcoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParentezco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParentezco(Parentezco parentezcoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesParentezco(List<Parentezco> parentezcosTemp) throws Exception {
		for(Parentezco parentezcoAux:parentezcosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParentezco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParentezco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParentezco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParentezcoConstantesFunciones.getClassesRelationshipsOfParentezco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParentezco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Referencia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Referencia.class)) {
						classes.add(new Classe(Referencia.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParentezco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParentezcoConstantesFunciones.getClassesRelationshipsFromStringsOfParentezco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParentezco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Referencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Referencia.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Referencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Referencia.class)); continue;
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
	public static void actualizarLista(Parentezco parentezco,List<Parentezco> parentezcos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Parentezco parentezcoEncontrado=null;
			
			for(Parentezco parentezcoLocal:parentezcos) {
				if(parentezcoLocal.getId().equals(parentezco.getId())) {
					parentezcoEncontrado=parentezcoLocal;
					
					parentezcoLocal.setIsChanged(parentezco.getIsChanged());
					parentezcoLocal.setIsNew(parentezco.getIsNew());
					parentezcoLocal.setIsDeleted(parentezco.getIsDeleted());
					
					parentezcoLocal.setGeneralEntityOriginal(parentezco.getGeneralEntityOriginal());
					
					parentezcoLocal.setId(parentezco.getId());	
					parentezcoLocal.setVersionRow(parentezco.getVersionRow());	
					parentezcoLocal.setcodigo(parentezco.getcodigo());	
					parentezcoLocal.setnombre(parentezco.getnombre());	
					
					
					parentezcoLocal.setReferencias(parentezco.getReferencias());
					
					existe=true;
					break;
				}
			}
			
			if(!parentezco.getIsDeleted()) {
				if(!existe) {
					parentezcos.add(parentezco);
				}
			} else {
				if(parentezcoEncontrado!=null && permiteQuitar)  {
					parentezcos.remove(parentezcoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Parentezco parentezco,List<Parentezco> parentezcos) throws Exception {
		try	{			
			for(Parentezco parentezcoLocal:parentezcos) {
				if(parentezcoLocal.getId().equals(parentezco.getId())) {
					parentezcoLocal.setIsSelected(parentezco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParentezco(List<Parentezco> parentezcosAux) throws Exception {
		//this.parentezcosAux=parentezcosAux;
		
		for(Parentezco parentezcoAux:parentezcosAux) {
			if(parentezcoAux.getIsChanged()) {
				parentezcoAux.setIsChanged(false);
			}		
			
			if(parentezcoAux.getIsNew()) {
				parentezcoAux.setIsNew(false);
			}	
			
			if(parentezcoAux.getIsDeleted()) {
				parentezcoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParentezco(Parentezco parentezcoAux) throws Exception {
		//this.parentezcoAux=parentezcoAux;
		
			if(parentezcoAux.getIsChanged()) {
				parentezcoAux.setIsChanged(false);
			}		
			
			if(parentezcoAux.getIsNew()) {
				parentezcoAux.setIsNew(false);
			}	
			
			if(parentezcoAux.getIsDeleted()) {
				parentezcoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Parentezco parentezcoAsignar,Parentezco parentezco) throws Exception {
		parentezcoAsignar.setId(parentezco.getId());	
		parentezcoAsignar.setVersionRow(parentezco.getVersionRow());	
		parentezcoAsignar.setcodigo(parentezco.getcodigo());	
		parentezcoAsignar.setnombre(parentezco.getnombre());	
	}
	
	public static void inicializarParentezco(Parentezco parentezco) throws Exception {
		try {
				parentezco.setId(0L);	
					
				parentezco.setcodigo("");	
				parentezco.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParentezco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParentezcoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParentezcoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParentezco(String sTipo,Row row,Workbook workbook,Parentezco parentezco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parentezco.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parentezco.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParentezco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParentezco() {
		return this.sFinalQueryParentezco;
	}
	
	public void setsFinalQueryParentezco(String sFinalQueryParentezco) {
		this.sFinalQueryParentezco= sFinalQueryParentezco;
	}
	
	public Border resaltarSeleccionarParentezco=null;
	
	public Border setResaltarSeleccionarParentezco(ParametroGeneralUsuario parametroGeneralUsuario/*ParentezcoBeanSwingJInternalFrame parentezcoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parentezcoBeanSwingJInternalFrame.jTtoolBarParentezco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParentezco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParentezco() {
		return this.resaltarSeleccionarParentezco;
	}
	
	public void setResaltarSeleccionarParentezco(Border borderResaltarSeleccionarParentezco) {
		this.resaltarSeleccionarParentezco= borderResaltarSeleccionarParentezco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParentezco=null;
	public Boolean mostraridParentezco=true;
	public Boolean activaridParentezco=true;

	public Border resaltarcodigoParentezco=null;
	public Boolean mostrarcodigoParentezco=true;
	public Boolean activarcodigoParentezco=true;

	public Border resaltarnombreParentezco=null;
	public Boolean mostrarnombreParentezco=true;
	public Boolean activarnombreParentezco=true;

	
	

	public Border setResaltaridParentezco(ParametroGeneralUsuario parametroGeneralUsuario/*ParentezcoBeanSwingJInternalFrame parentezcoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parentezcoBeanSwingJInternalFrame.jTtoolBarParentezco.setBorder(borderResaltar);
		
		this.resaltaridParentezco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParentezco() {
		return this.resaltaridParentezco;
	}

	public void setResaltaridParentezco(Border borderResaltar) {
		this.resaltaridParentezco= borderResaltar;
	}

	public Boolean getMostraridParentezco() {
		return this.mostraridParentezco;
	}

	public void setMostraridParentezco(Boolean mostraridParentezco) {
		this.mostraridParentezco= mostraridParentezco;
	}

	public Boolean getActivaridParentezco() {
		return this.activaridParentezco;
	}

	public void setActivaridParentezco(Boolean activaridParentezco) {
		this.activaridParentezco= activaridParentezco;
	}

	public Border setResaltarcodigoParentezco(ParametroGeneralUsuario parametroGeneralUsuario/*ParentezcoBeanSwingJInternalFrame parentezcoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parentezcoBeanSwingJInternalFrame.jTtoolBarParentezco.setBorder(borderResaltar);
		
		this.resaltarcodigoParentezco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoParentezco() {
		return this.resaltarcodigoParentezco;
	}

	public void setResaltarcodigoParentezco(Border borderResaltar) {
		this.resaltarcodigoParentezco= borderResaltar;
	}

	public Boolean getMostrarcodigoParentezco() {
		return this.mostrarcodigoParentezco;
	}

	public void setMostrarcodigoParentezco(Boolean mostrarcodigoParentezco) {
		this.mostrarcodigoParentezco= mostrarcodigoParentezco;
	}

	public Boolean getActivarcodigoParentezco() {
		return this.activarcodigoParentezco;
	}

	public void setActivarcodigoParentezco(Boolean activarcodigoParentezco) {
		this.activarcodigoParentezco= activarcodigoParentezco;
	}

	public Border setResaltarnombreParentezco(ParametroGeneralUsuario parametroGeneralUsuario/*ParentezcoBeanSwingJInternalFrame parentezcoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parentezcoBeanSwingJInternalFrame.jTtoolBarParentezco.setBorder(borderResaltar);
		
		this.resaltarnombreParentezco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreParentezco() {
		return this.resaltarnombreParentezco;
	}

	public void setResaltarnombreParentezco(Border borderResaltar) {
		this.resaltarnombreParentezco= borderResaltar;
	}

	public Boolean getMostrarnombreParentezco() {
		return this.mostrarnombreParentezco;
	}

	public void setMostrarnombreParentezco(Boolean mostrarnombreParentezco) {
		this.mostrarnombreParentezco= mostrarnombreParentezco;
	}

	public Boolean getActivarnombreParentezco() {
		return this.activarnombreParentezco;
	}

	public void setActivarnombreParentezco(Boolean activarnombreParentezco) {
		this.activarnombreParentezco= activarnombreParentezco;
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
		
		
		this.setMostraridParentezco(esInicial);
		this.setMostrarcodigoParentezco(esInicial);
		this.setMostrarnombreParentezco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParentezcoConstantesFunciones.ID)) {
				this.setMostraridParentezco(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParentezcoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoParentezco(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParentezcoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreParentezco(esAsigna);
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
		
		
		this.setActivaridParentezco(esInicial);
		this.setActivarcodigoParentezco(esInicial);
		this.setActivarnombreParentezco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParentezcoConstantesFunciones.ID)) {
				this.setActivaridParentezco(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParentezcoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoParentezco(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParentezcoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreParentezco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParentezcoBeanSwingJInternalFrame parentezcoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParentezco(esInicial);
		this.setResaltarcodigoParentezco(esInicial);
		this.setResaltarnombreParentezco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParentezcoConstantesFunciones.ID)) {
				this.setResaltaridParentezco(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParentezcoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoParentezco(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParentezcoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreParentezco(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarReferenciaParentezco=null;

	public Border getResaltarReferenciaParentezco() {
		return this.resaltarReferenciaParentezco;
	}

	public void setResaltarReferenciaParentezco(Border borderResaltarReferencia) {
		if(borderResaltarReferencia!=null) {
			this.resaltarReferenciaParentezco= borderResaltarReferencia;
		}
	}

	public Border setResaltarReferenciaParentezco(ParametroGeneralUsuario parametroGeneralUsuario/*ParentezcoBeanSwingJInternalFrame parentezcoBeanSwingJInternalFrame*/) {
		Border borderResaltarReferencia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//parentezcoBeanSwingJInternalFrame.jTtoolBarParentezco.setBorder(borderResaltarReferencia);
			
		this.resaltarReferenciaParentezco= borderResaltarReferencia;

		 return borderResaltarReferencia;
	}



	public Boolean mostrarReferenciaParentezco=true;

	public Boolean getMostrarReferenciaParentezco() {
		return this.mostrarReferenciaParentezco;
	}

	public void setMostrarReferenciaParentezco(Boolean visibilidadResaltarReferencia) {
		this.mostrarReferenciaParentezco= visibilidadResaltarReferencia;
	}



	public Boolean activarReferenciaParentezco=true;

	public Boolean gethabilitarResaltarReferenciaParentezco() {
		return this.activarReferenciaParentezco;
	}

	public void setActivarReferenciaParentezco(Boolean habilitarResaltarReferencia) {
		this.activarReferenciaParentezco= habilitarResaltarReferencia;
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

		this.setMostrarReferenciaParentezco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Referencia.class)) {
				this.setMostrarReferenciaParentezco(esAsigna);
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

		this.setActivarReferenciaParentezco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Referencia.class)) {
				this.setActivarReferenciaParentezco(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParentezcoBeanSwingJInternalFrame parentezcoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarReferenciaParentezco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Referencia.class)) {
				this.setResaltarReferenciaParentezco(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}