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


import com.bydan.erp.nomina.util.IdiomaConstantesFunciones;
import com.bydan.erp.nomina.util.IdiomaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.IdiomaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class IdiomaConstantesFunciones extends IdiomaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Idioma";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Idioma"+IdiomaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="IdiomaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="IdiomaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=IdiomaConstantesFunciones.SCHEMA+"_"+IdiomaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/IdiomaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=IdiomaConstantesFunciones.SCHEMA+"_"+IdiomaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=IdiomaConstantesFunciones.SCHEMA+"_"+IdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/IdiomaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=IdiomaConstantesFunciones.SCHEMA+"_"+IdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/IdiomaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/IdiomaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+IdiomaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=IdiomaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+IdiomaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=IdiomaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+IdiomaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Idiomas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Idioma";
	public static final String SCLASSWEBTITULO_LOWER="Idioma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Idioma";
	public static final String OBJECTNAME="idioma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="idioma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select idioma from "+IdiomaConstantesFunciones.SPERSISTENCENAME+" idioma";
	public static String QUERYSELECTNATIVE="select "+IdiomaConstantesFunciones.SCHEMA+"."+IdiomaConstantesFunciones.TABLENAME+".id,"+IdiomaConstantesFunciones.SCHEMA+"."+IdiomaConstantesFunciones.TABLENAME+".version_row,"+IdiomaConstantesFunciones.SCHEMA+"."+IdiomaConstantesFunciones.TABLENAME+".nombre,"+IdiomaConstantesFunciones.SCHEMA+"."+IdiomaConstantesFunciones.TABLENAME+".descripcion from "+IdiomaConstantesFunciones.SCHEMA+"."+IdiomaConstantesFunciones.TABLENAME;//+" as "+IdiomaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected IdiomaConstantesFuncionesAdditional idiomaConstantesFuncionesAdditional=null;
	
	public IdiomaConstantesFuncionesAdditional getIdiomaConstantesFuncionesAdditional() {
		return this.idiomaConstantesFuncionesAdditional;
	}
	
	public void setIdiomaConstantesFuncionesAdditional(IdiomaConstantesFuncionesAdditional idiomaConstantesFuncionesAdditional) {
		try {
			this.idiomaConstantesFuncionesAdditional=idiomaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getIdiomaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(IdiomaConstantesFunciones.NOMBRE)) {sLabelColumna=IdiomaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(IdiomaConstantesFunciones.DESCRIPCION)) {sLabelColumna=IdiomaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
	
	public static String getIdiomaDescripcion(Idioma idioma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(idioma !=null/* && idioma.getId()!=0*/) {
			sDescripcion=idioma.getnombre();//idiomaidioma.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getIdiomaDescripcionDetallado(Idioma idioma) {
		String sDescripcion="";
			
		sDescripcion+=IdiomaConstantesFunciones.ID+"=";
		sDescripcion+=idioma.getId().toString()+",";
		sDescripcion+=IdiomaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=idioma.getVersionRow().toString()+",";
		sDescripcion+=IdiomaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=idioma.getnombre()+",";
		sDescripcion+=IdiomaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=idioma.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setIdiomaDescripcion(Idioma idioma,String sValor) throws Exception {			
		if(idioma !=null) {
			idioma.setnombre(sValor);;//idiomaidioma.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosIdioma(Idioma idioma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		idioma.setnombre(idioma.getnombre().trim());
		idioma.setdescripcion(idioma.getdescripcion().trim());
	}
	
	public static void quitarEspaciosIdiomas(List<Idioma> idiomas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Idioma idioma: idiomas) {
			idioma.setnombre(idioma.getnombre().trim());
			idioma.setdescripcion(idioma.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresIdioma(Idioma idioma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && idioma.getConCambioAuxiliar()) {
			idioma.setIsDeleted(idioma.getIsDeletedAuxiliar());	
			idioma.setIsNew(idioma.getIsNewAuxiliar());	
			idioma.setIsChanged(idioma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			idioma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			idioma.setIsDeletedAuxiliar(false);	
			idioma.setIsNewAuxiliar(false);	
			idioma.setIsChangedAuxiliar(false);
			
			idioma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresIdiomas(List<Idioma> idiomas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Idioma idioma : idiomas) {
			if(conAsignarBase && idioma.getConCambioAuxiliar()) {
				idioma.setIsDeleted(idioma.getIsDeletedAuxiliar());	
				idioma.setIsNew(idioma.getIsNewAuxiliar());	
				idioma.setIsChanged(idioma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				idioma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				idioma.setIsDeletedAuxiliar(false);	
				idioma.setIsNewAuxiliar(false);	
				idioma.setIsChangedAuxiliar(false);
				
				idioma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresIdioma(Idioma idioma,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresIdiomas(List<Idioma> idiomas,Boolean conEnteros) throws Exception  {
		
		for(Idioma idioma: idiomas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaIdioma(List<Idioma> idiomas,Idioma idiomaAux) throws Exception  {
		IdiomaConstantesFunciones.InicializarValoresIdioma(idiomaAux,true);
		
		for(Idioma idioma: idiomas) {
			if(idioma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesIdioma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=IdiomaConstantesFunciones.getArrayColumnasGlobalesIdioma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesIdioma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoIdioma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Idioma> idiomas,Idioma idioma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Idioma idiomaAux: idiomas) {
			if(idiomaAux!=null && idioma!=null) {
				if((idiomaAux.getId()==null && idioma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(idiomaAux.getId()!=null && idioma.getId()!=null){
					if(idiomaAux.getId().equals(idioma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaIdioma(List<Idioma> idiomas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Idioma idioma: idiomas) {			
			if(idioma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaIdioma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,IdiomaConstantesFunciones.LABEL_ID, IdiomaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IdiomaConstantesFunciones.LABEL_VERSIONROW, IdiomaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IdiomaConstantesFunciones.LABEL_NOMBRE, IdiomaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,IdiomaConstantesFunciones.LABEL_DESCRIPCION, IdiomaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasIdioma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=IdiomaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IdiomaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IdiomaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=IdiomaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIdioma() throws Exception  {
		return IdiomaConstantesFunciones.getTiposSeleccionarIdioma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIdioma(Boolean conFk) throws Exception  {
		return IdiomaConstantesFunciones.getTiposSeleccionarIdioma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarIdioma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IdiomaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(IdiomaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(IdiomaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(IdiomaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesIdioma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesIdioma(Idioma idiomaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesIdioma(List<Idioma> idiomasTemp) throws Exception {
		for(Idioma idiomaAux:idiomasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfIdioma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfIdioma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfIdioma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return IdiomaConstantesFunciones.getClassesRelationshipsOfIdioma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfIdioma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(EmpleadoIdioma.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoIdioma.class)) {
						classes.add(new Classe(EmpleadoIdioma.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfIdioma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return IdiomaConstantesFunciones.getClassesRelationshipsFromStringsOfIdioma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfIdioma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoIdioma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoIdioma.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoIdioma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoIdioma.class)); continue;
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
	public static void actualizarLista(Idioma idioma,List<Idioma> idiomas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Idioma idiomaEncontrado=null;
			
			for(Idioma idiomaLocal:idiomas) {
				if(idiomaLocal.getId().equals(idioma.getId())) {
					idiomaEncontrado=idiomaLocal;
					
					idiomaLocal.setIsChanged(idioma.getIsChanged());
					idiomaLocal.setIsNew(idioma.getIsNew());
					idiomaLocal.setIsDeleted(idioma.getIsDeleted());
					
					idiomaLocal.setGeneralEntityOriginal(idioma.getGeneralEntityOriginal());
					
					idiomaLocal.setId(idioma.getId());	
					idiomaLocal.setVersionRow(idioma.getVersionRow());	
					idiomaLocal.setnombre(idioma.getnombre());	
					idiomaLocal.setdescripcion(idioma.getdescripcion());	
					
					
					idiomaLocal.setEmpleadoIdiomas(idioma.getEmpleadoIdiomas());
					
					existe=true;
					break;
				}
			}
			
			if(!idioma.getIsDeleted()) {
				if(!existe) {
					idiomas.add(idioma);
				}
			} else {
				if(idiomaEncontrado!=null && permiteQuitar)  {
					idiomas.remove(idiomaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Idioma idioma,List<Idioma> idiomas) throws Exception {
		try	{			
			for(Idioma idiomaLocal:idiomas) {
				if(idiomaLocal.getId().equals(idioma.getId())) {
					idiomaLocal.setIsSelected(idioma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesIdioma(List<Idioma> idiomasAux) throws Exception {
		//this.idiomasAux=idiomasAux;
		
		for(Idioma idiomaAux:idiomasAux) {
			if(idiomaAux.getIsChanged()) {
				idiomaAux.setIsChanged(false);
			}		
			
			if(idiomaAux.getIsNew()) {
				idiomaAux.setIsNew(false);
			}	
			
			if(idiomaAux.getIsDeleted()) {
				idiomaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesIdioma(Idioma idiomaAux) throws Exception {
		//this.idiomaAux=idiomaAux;
		
			if(idiomaAux.getIsChanged()) {
				idiomaAux.setIsChanged(false);
			}		
			
			if(idiomaAux.getIsNew()) {
				idiomaAux.setIsNew(false);
			}	
			
			if(idiomaAux.getIsDeleted()) {
				idiomaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Idioma idiomaAsignar,Idioma idioma) throws Exception {
		idiomaAsignar.setId(idioma.getId());	
		idiomaAsignar.setVersionRow(idioma.getVersionRow());	
		idiomaAsignar.setnombre(idioma.getnombre());	
		idiomaAsignar.setdescripcion(idioma.getdescripcion());	
	}
	
	public static void inicializarIdioma(Idioma idioma) throws Exception {
		try {
				idioma.setId(0L);	
					
				idioma.setnombre("");	
				idioma.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderIdioma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(IdiomaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(IdiomaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataIdioma(String sTipo,Row row,Workbook workbook,Idioma idioma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(idioma.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(idioma.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryIdioma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryIdioma() {
		return this.sFinalQueryIdioma;
	}
	
	public void setsFinalQueryIdioma(String sFinalQueryIdioma) {
		this.sFinalQueryIdioma= sFinalQueryIdioma;
	}
	
	public Border resaltarSeleccionarIdioma=null;
	
	public Border setResaltarSeleccionarIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*IdiomaBeanSwingJInternalFrame idiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//idiomaBeanSwingJInternalFrame.jTtoolBarIdioma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarIdioma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarIdioma() {
		return this.resaltarSeleccionarIdioma;
	}
	
	public void setResaltarSeleccionarIdioma(Border borderResaltarSeleccionarIdioma) {
		this.resaltarSeleccionarIdioma= borderResaltarSeleccionarIdioma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridIdioma=null;
	public Boolean mostraridIdioma=true;
	public Boolean activaridIdioma=true;

	public Border resaltarnombreIdioma=null;
	public Boolean mostrarnombreIdioma=true;
	public Boolean activarnombreIdioma=true;

	public Border resaltardescripcionIdioma=null;
	public Boolean mostrardescripcionIdioma=true;
	public Boolean activardescripcionIdioma=true;

	
	

	public Border setResaltaridIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*IdiomaBeanSwingJInternalFrame idiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//idiomaBeanSwingJInternalFrame.jTtoolBarIdioma.setBorder(borderResaltar);
		
		this.resaltaridIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridIdioma() {
		return this.resaltaridIdioma;
	}

	public void setResaltaridIdioma(Border borderResaltar) {
		this.resaltaridIdioma= borderResaltar;
	}

	public Boolean getMostraridIdioma() {
		return this.mostraridIdioma;
	}

	public void setMostraridIdioma(Boolean mostraridIdioma) {
		this.mostraridIdioma= mostraridIdioma;
	}

	public Boolean getActivaridIdioma() {
		return this.activaridIdioma;
	}

	public void setActivaridIdioma(Boolean activaridIdioma) {
		this.activaridIdioma= activaridIdioma;
	}

	public Border setResaltarnombreIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*IdiomaBeanSwingJInternalFrame idiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//idiomaBeanSwingJInternalFrame.jTtoolBarIdioma.setBorder(borderResaltar);
		
		this.resaltarnombreIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreIdioma() {
		return this.resaltarnombreIdioma;
	}

	public void setResaltarnombreIdioma(Border borderResaltar) {
		this.resaltarnombreIdioma= borderResaltar;
	}

	public Boolean getMostrarnombreIdioma() {
		return this.mostrarnombreIdioma;
	}

	public void setMostrarnombreIdioma(Boolean mostrarnombreIdioma) {
		this.mostrarnombreIdioma= mostrarnombreIdioma;
	}

	public Boolean getActivarnombreIdioma() {
		return this.activarnombreIdioma;
	}

	public void setActivarnombreIdioma(Boolean activarnombreIdioma) {
		this.activarnombreIdioma= activarnombreIdioma;
	}

	public Border setResaltardescripcionIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*IdiomaBeanSwingJInternalFrame idiomaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//idiomaBeanSwingJInternalFrame.jTtoolBarIdioma.setBorder(borderResaltar);
		
		this.resaltardescripcionIdioma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionIdioma() {
		return this.resaltardescripcionIdioma;
	}

	public void setResaltardescripcionIdioma(Border borderResaltar) {
		this.resaltardescripcionIdioma= borderResaltar;
	}

	public Boolean getMostrardescripcionIdioma() {
		return this.mostrardescripcionIdioma;
	}

	public void setMostrardescripcionIdioma(Boolean mostrardescripcionIdioma) {
		this.mostrardescripcionIdioma= mostrardescripcionIdioma;
	}

	public Boolean getActivardescripcionIdioma() {
		return this.activardescripcionIdioma;
	}

	public void setActivardescripcionIdioma(Boolean activardescripcionIdioma) {
		this.activardescripcionIdioma= activardescripcionIdioma;
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
		
		
		this.setMostraridIdioma(esInicial);
		this.setMostrarnombreIdioma(esInicial);
		this.setMostrardescripcionIdioma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IdiomaConstantesFunciones.ID)) {
				this.setMostraridIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(IdiomaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(IdiomaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionIdioma(esAsigna);
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
		
		
		this.setActivaridIdioma(esInicial);
		this.setActivarnombreIdioma(esInicial);
		this.setActivardescripcionIdioma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IdiomaConstantesFunciones.ID)) {
				this.setActivaridIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(IdiomaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(IdiomaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionIdioma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,IdiomaBeanSwingJInternalFrame idiomaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridIdioma(esInicial);
		this.setResaltarnombreIdioma(esInicial);
		this.setResaltardescripcionIdioma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(IdiomaConstantesFunciones.ID)) {
				this.setResaltaridIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(IdiomaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreIdioma(esAsigna);
				continue;
			}

			if(campo.clase.equals(IdiomaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionIdioma(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEmpleadoIdiomaIdioma=null;

	public Border getResaltarEmpleadoIdiomaIdioma() {
		return this.resaltarEmpleadoIdiomaIdioma;
	}

	public void setResaltarEmpleadoIdiomaIdioma(Border borderResaltarEmpleadoIdioma) {
		if(borderResaltarEmpleadoIdioma!=null) {
			this.resaltarEmpleadoIdiomaIdioma= borderResaltarEmpleadoIdioma;
		}
	}

	public Border setResaltarEmpleadoIdiomaIdioma(ParametroGeneralUsuario parametroGeneralUsuario/*IdiomaBeanSwingJInternalFrame idiomaBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoIdioma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//idiomaBeanSwingJInternalFrame.jTtoolBarIdioma.setBorder(borderResaltarEmpleadoIdioma);
			
		this.resaltarEmpleadoIdiomaIdioma= borderResaltarEmpleadoIdioma;

		 return borderResaltarEmpleadoIdioma;
	}



	public Boolean mostrarEmpleadoIdiomaIdioma=true;

	public Boolean getMostrarEmpleadoIdiomaIdioma() {
		return this.mostrarEmpleadoIdiomaIdioma;
	}

	public void setMostrarEmpleadoIdiomaIdioma(Boolean visibilidadResaltarEmpleadoIdioma) {
		this.mostrarEmpleadoIdiomaIdioma= visibilidadResaltarEmpleadoIdioma;
	}



	public Boolean activarEmpleadoIdiomaIdioma=true;

	public Boolean gethabilitarResaltarEmpleadoIdiomaIdioma() {
		return this.activarEmpleadoIdiomaIdioma;
	}

	public void setActivarEmpleadoIdiomaIdioma(Boolean habilitarResaltarEmpleadoIdioma) {
		this.activarEmpleadoIdiomaIdioma= habilitarResaltarEmpleadoIdioma;
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

		this.setMostrarEmpleadoIdiomaIdioma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoIdioma.class)) {
				this.setMostrarEmpleadoIdiomaIdioma(esAsigna);
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

		this.setActivarEmpleadoIdiomaIdioma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoIdioma.class)) {
				this.setActivarEmpleadoIdiomaIdioma(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,IdiomaBeanSwingJInternalFrame idiomaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEmpleadoIdiomaIdioma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoIdioma.class)) {
				this.setResaltarEmpleadoIdiomaIdioma(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}