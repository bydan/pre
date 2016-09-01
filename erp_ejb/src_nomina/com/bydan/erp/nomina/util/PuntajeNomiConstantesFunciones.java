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


import com.bydan.erp.nomina.util.PuntajeNomiConstantesFunciones;
import com.bydan.erp.nomina.util.PuntajeNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.PuntajeNomiParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PuntajeNomiConstantesFunciones extends PuntajeNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PuntajeNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PuntajeNomi"+PuntajeNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PuntajeNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PuntajeNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PuntajeNomiConstantesFunciones.SCHEMA+"_"+PuntajeNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PuntajeNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PuntajeNomiConstantesFunciones.SCHEMA+"_"+PuntajeNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PuntajeNomiConstantesFunciones.SCHEMA+"_"+PuntajeNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PuntajeNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PuntajeNomiConstantesFunciones.SCHEMA+"_"+PuntajeNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuntajeNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PuntajeNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuntajeNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuntajeNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PuntajeNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuntajeNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PuntajeNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PuntajeNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PuntajeNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PuntajeNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Puntaje Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Puntaje Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Puntaje Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PuntajeNomi";
	public static final String OBJECTNAME="puntajenomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="puntaje_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select puntajenomi from "+PuntajeNomiConstantesFunciones.SPERSISTENCENAME+" puntajenomi";
	public static String QUERYSELECTNATIVE="select "+PuntajeNomiConstantesFunciones.SCHEMA+"."+PuntajeNomiConstantesFunciones.TABLENAME+".id,"+PuntajeNomiConstantesFunciones.SCHEMA+"."+PuntajeNomiConstantesFunciones.TABLENAME+".version_row,"+PuntajeNomiConstantesFunciones.SCHEMA+"."+PuntajeNomiConstantesFunciones.TABLENAME+".nombre from "+PuntajeNomiConstantesFunciones.SCHEMA+"."+PuntajeNomiConstantesFunciones.TABLENAME;//+" as "+PuntajeNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PuntajeNomiConstantesFuncionesAdditional puntajenomiConstantesFuncionesAdditional=null;
	
	public PuntajeNomiConstantesFuncionesAdditional getPuntajeNomiConstantesFuncionesAdditional() {
		return this.puntajenomiConstantesFuncionesAdditional;
	}
	
	public void setPuntajeNomiConstantesFuncionesAdditional(PuntajeNomiConstantesFuncionesAdditional puntajenomiConstantesFuncionesAdditional) {
		try {
			this.puntajenomiConstantesFuncionesAdditional=puntajenomiConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPuntajeNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PuntajeNomiConstantesFunciones.NOMBRE)) {sLabelColumna=PuntajeNomiConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getPuntajeNomiDescripcion(PuntajeNomi puntajenomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(puntajenomi !=null/* && puntajenomi.getId()!=0*/) {
			sDescripcion=puntajenomi.getnombre();//puntajenomipuntajenomi.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPuntajeNomiDescripcionDetallado(PuntajeNomi puntajenomi) {
		String sDescripcion="";
			
		sDescripcion+=PuntajeNomiConstantesFunciones.ID+"=";
		sDescripcion+=puntajenomi.getId().toString()+",";
		sDescripcion+=PuntajeNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=puntajenomi.getVersionRow().toString()+",";
		sDescripcion+=PuntajeNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=puntajenomi.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setPuntajeNomiDescripcion(PuntajeNomi puntajenomi,String sValor) throws Exception {			
		if(puntajenomi !=null) {
			puntajenomi.setnombre(sValor);;//puntajenomipuntajenomi.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosPuntajeNomi(PuntajeNomi puntajenomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		puntajenomi.setnombre(puntajenomi.getnombre().trim());
	}
	
	public static void quitarEspaciosPuntajeNomis(List<PuntajeNomi> puntajenomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PuntajeNomi puntajenomi: puntajenomis) {
			puntajenomi.setnombre(puntajenomi.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPuntajeNomi(PuntajeNomi puntajenomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && puntajenomi.getConCambioAuxiliar()) {
			puntajenomi.setIsDeleted(puntajenomi.getIsDeletedAuxiliar());	
			puntajenomi.setIsNew(puntajenomi.getIsNewAuxiliar());	
			puntajenomi.setIsChanged(puntajenomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			puntajenomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			puntajenomi.setIsDeletedAuxiliar(false);	
			puntajenomi.setIsNewAuxiliar(false);	
			puntajenomi.setIsChangedAuxiliar(false);
			
			puntajenomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPuntajeNomis(List<PuntajeNomi> puntajenomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PuntajeNomi puntajenomi : puntajenomis) {
			if(conAsignarBase && puntajenomi.getConCambioAuxiliar()) {
				puntajenomi.setIsDeleted(puntajenomi.getIsDeletedAuxiliar());	
				puntajenomi.setIsNew(puntajenomi.getIsNewAuxiliar());	
				puntajenomi.setIsChanged(puntajenomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				puntajenomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				puntajenomi.setIsDeletedAuxiliar(false);	
				puntajenomi.setIsNewAuxiliar(false);	
				puntajenomi.setIsChangedAuxiliar(false);
				
				puntajenomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPuntajeNomi(PuntajeNomi puntajenomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPuntajeNomis(List<PuntajeNomi> puntajenomis,Boolean conEnteros) throws Exception  {
		
		for(PuntajeNomi puntajenomi: puntajenomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPuntajeNomi(List<PuntajeNomi> puntajenomis,PuntajeNomi puntajenomiAux) throws Exception  {
		PuntajeNomiConstantesFunciones.InicializarValoresPuntajeNomi(puntajenomiAux,true);
		
		for(PuntajeNomi puntajenomi: puntajenomis) {
			if(puntajenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPuntajeNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PuntajeNomiConstantesFunciones.getArrayColumnasGlobalesPuntajeNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPuntajeNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPuntajeNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PuntajeNomi> puntajenomis,PuntajeNomi puntajenomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PuntajeNomi puntajenomiAux: puntajenomis) {
			if(puntajenomiAux!=null && puntajenomi!=null) {
				if((puntajenomiAux.getId()==null && puntajenomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(puntajenomiAux.getId()!=null && puntajenomi.getId()!=null){
					if(puntajenomiAux.getId().equals(puntajenomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPuntajeNomi(List<PuntajeNomi> puntajenomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PuntajeNomi puntajenomi: puntajenomis) {			
			if(puntajenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPuntajeNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PuntajeNomiConstantesFunciones.LABEL_ID, PuntajeNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PuntajeNomiConstantesFunciones.LABEL_VERSIONROW, PuntajeNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PuntajeNomiConstantesFunciones.LABEL_NOMBRE, PuntajeNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPuntajeNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PuntajeNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PuntajeNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PuntajeNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPuntajeNomi() throws Exception  {
		return PuntajeNomiConstantesFunciones.getTiposSeleccionarPuntajeNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPuntajeNomi(Boolean conFk) throws Exception  {
		return PuntajeNomiConstantesFunciones.getTiposSeleccionarPuntajeNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPuntajeNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PuntajeNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PuntajeNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPuntajeNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPuntajeNomi(PuntajeNomi puntajenomiAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesPuntajeNomi(List<PuntajeNomi> puntajenomisTemp) throws Exception {
		for(PuntajeNomi puntajenomiAux:puntajenomisTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPuntajeNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPuntajeNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPuntajeNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PuntajeNomiConstantesFunciones.getClassesRelationshipsOfPuntajeNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPuntajeNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FormatoNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomi.class)) {
						classes.add(new Classe(FormatoNomi.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPuntajeNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PuntajeNomiConstantesFunciones.getClassesRelationshipsFromStringsOfPuntajeNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPuntajeNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
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
	public static void actualizarLista(PuntajeNomi puntajenomi,List<PuntajeNomi> puntajenomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PuntajeNomi puntajenomiEncontrado=null;
			
			for(PuntajeNomi puntajenomiLocal:puntajenomis) {
				if(puntajenomiLocal.getId().equals(puntajenomi.getId())) {
					puntajenomiEncontrado=puntajenomiLocal;
					
					puntajenomiLocal.setIsChanged(puntajenomi.getIsChanged());
					puntajenomiLocal.setIsNew(puntajenomi.getIsNew());
					puntajenomiLocal.setIsDeleted(puntajenomi.getIsDeleted());
					
					puntajenomiLocal.setGeneralEntityOriginal(puntajenomi.getGeneralEntityOriginal());
					
					puntajenomiLocal.setId(puntajenomi.getId());	
					puntajenomiLocal.setVersionRow(puntajenomi.getVersionRow());	
					puntajenomiLocal.setnombre(puntajenomi.getnombre());	
					
					
					puntajenomiLocal.setFormatoNomis(puntajenomi.getFormatoNomis());
					
					existe=true;
					break;
				}
			}
			
			if(!puntajenomi.getIsDeleted()) {
				if(!existe) {
					puntajenomis.add(puntajenomi);
				}
			} else {
				if(puntajenomiEncontrado!=null && permiteQuitar)  {
					puntajenomis.remove(puntajenomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PuntajeNomi puntajenomi,List<PuntajeNomi> puntajenomis) throws Exception {
		try	{			
			for(PuntajeNomi puntajenomiLocal:puntajenomis) {
				if(puntajenomiLocal.getId().equals(puntajenomi.getId())) {
					puntajenomiLocal.setIsSelected(puntajenomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPuntajeNomi(List<PuntajeNomi> puntajenomisAux) throws Exception {
		//this.puntajenomisAux=puntajenomisAux;
		
		for(PuntajeNomi puntajenomiAux:puntajenomisAux) {
			if(puntajenomiAux.getIsChanged()) {
				puntajenomiAux.setIsChanged(false);
			}		
			
			if(puntajenomiAux.getIsNew()) {
				puntajenomiAux.setIsNew(false);
			}	
			
			if(puntajenomiAux.getIsDeleted()) {
				puntajenomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPuntajeNomi(PuntajeNomi puntajenomiAux) throws Exception {
		//this.puntajenomiAux=puntajenomiAux;
		
			if(puntajenomiAux.getIsChanged()) {
				puntajenomiAux.setIsChanged(false);
			}		
			
			if(puntajenomiAux.getIsNew()) {
				puntajenomiAux.setIsNew(false);
			}	
			
			if(puntajenomiAux.getIsDeleted()) {
				puntajenomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PuntajeNomi puntajenomiAsignar,PuntajeNomi puntajenomi) throws Exception {
		puntajenomiAsignar.setId(puntajenomi.getId());	
		puntajenomiAsignar.setVersionRow(puntajenomi.getVersionRow());	
		puntajenomiAsignar.setnombre(puntajenomi.getnombre());	
	}
	
	public static void inicializarPuntajeNomi(PuntajeNomi puntajenomi) throws Exception {
		try {
				puntajenomi.setId(0L);	
					
				puntajenomi.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPuntajeNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PuntajeNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPuntajeNomi(String sTipo,Row row,Workbook workbook,PuntajeNomi puntajenomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(puntajenomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPuntajeNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPuntajeNomi() {
		return this.sFinalQueryPuntajeNomi;
	}
	
	public void setsFinalQueryPuntajeNomi(String sFinalQueryPuntajeNomi) {
		this.sFinalQueryPuntajeNomi= sFinalQueryPuntajeNomi;
	}
	
	public Border resaltarSeleccionarPuntajeNomi=null;
	
	public Border setResaltarSeleccionarPuntajeNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PuntajeNomiBeanSwingJInternalFrame puntajenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//puntajenomiBeanSwingJInternalFrame.jTtoolBarPuntajeNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPuntajeNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPuntajeNomi() {
		return this.resaltarSeleccionarPuntajeNomi;
	}
	
	public void setResaltarSeleccionarPuntajeNomi(Border borderResaltarSeleccionarPuntajeNomi) {
		this.resaltarSeleccionarPuntajeNomi= borderResaltarSeleccionarPuntajeNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPuntajeNomi=null;
	public Boolean mostraridPuntajeNomi=true;
	public Boolean activaridPuntajeNomi=true;

	public Border resaltarnombrePuntajeNomi=null;
	public Boolean mostrarnombrePuntajeNomi=true;
	public Boolean activarnombrePuntajeNomi=true;

	
	

	public Border setResaltaridPuntajeNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PuntajeNomiBeanSwingJInternalFrame puntajenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//puntajenomiBeanSwingJInternalFrame.jTtoolBarPuntajeNomi.setBorder(borderResaltar);
		
		this.resaltaridPuntajeNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPuntajeNomi() {
		return this.resaltaridPuntajeNomi;
	}

	public void setResaltaridPuntajeNomi(Border borderResaltar) {
		this.resaltaridPuntajeNomi= borderResaltar;
	}

	public Boolean getMostraridPuntajeNomi() {
		return this.mostraridPuntajeNomi;
	}

	public void setMostraridPuntajeNomi(Boolean mostraridPuntajeNomi) {
		this.mostraridPuntajeNomi= mostraridPuntajeNomi;
	}

	public Boolean getActivaridPuntajeNomi() {
		return this.activaridPuntajeNomi;
	}

	public void setActivaridPuntajeNomi(Boolean activaridPuntajeNomi) {
		this.activaridPuntajeNomi= activaridPuntajeNomi;
	}

	public Border setResaltarnombrePuntajeNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PuntajeNomiBeanSwingJInternalFrame puntajenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//puntajenomiBeanSwingJInternalFrame.jTtoolBarPuntajeNomi.setBorder(borderResaltar);
		
		this.resaltarnombrePuntajeNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePuntajeNomi() {
		return this.resaltarnombrePuntajeNomi;
	}

	public void setResaltarnombrePuntajeNomi(Border borderResaltar) {
		this.resaltarnombrePuntajeNomi= borderResaltar;
	}

	public Boolean getMostrarnombrePuntajeNomi() {
		return this.mostrarnombrePuntajeNomi;
	}

	public void setMostrarnombrePuntajeNomi(Boolean mostrarnombrePuntajeNomi) {
		this.mostrarnombrePuntajeNomi= mostrarnombrePuntajeNomi;
	}

	public Boolean getActivarnombrePuntajeNomi() {
		return this.activarnombrePuntajeNomi;
	}

	public void setActivarnombrePuntajeNomi(Boolean activarnombrePuntajeNomi) {
		this.activarnombrePuntajeNomi= activarnombrePuntajeNomi;
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
		
		
		this.setMostraridPuntajeNomi(esInicial);
		this.setMostrarnombrePuntajeNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PuntajeNomiConstantesFunciones.ID)) {
				this.setMostraridPuntajeNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuntajeNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePuntajeNomi(esAsigna);
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
		
		
		this.setActivaridPuntajeNomi(esInicial);
		this.setActivarnombrePuntajeNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PuntajeNomiConstantesFunciones.ID)) {
				this.setActivaridPuntajeNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuntajeNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePuntajeNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PuntajeNomiBeanSwingJInternalFrame puntajenomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPuntajeNomi(esInicial);
		this.setResaltarnombrePuntajeNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PuntajeNomiConstantesFunciones.ID)) {
				this.setResaltaridPuntajeNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuntajeNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePuntajeNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormatoNomiPuntajeNomi=null;

	public Border getResaltarFormatoNomiPuntajeNomi() {
		return this.resaltarFormatoNomiPuntajeNomi;
	}

	public void setResaltarFormatoNomiPuntajeNomi(Border borderResaltarFormatoNomi) {
		if(borderResaltarFormatoNomi!=null) {
			this.resaltarFormatoNomiPuntajeNomi= borderResaltarFormatoNomi;
		}
	}

	public Border setResaltarFormatoNomiPuntajeNomi(ParametroGeneralUsuario parametroGeneralUsuario/*PuntajeNomiBeanSwingJInternalFrame puntajenomiBeanSwingJInternalFrame*/) {
		Border borderResaltarFormatoNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//puntajenomiBeanSwingJInternalFrame.jTtoolBarPuntajeNomi.setBorder(borderResaltarFormatoNomi);
			
		this.resaltarFormatoNomiPuntajeNomi= borderResaltarFormatoNomi;

		 return borderResaltarFormatoNomi;
	}



	public Boolean mostrarFormatoNomiPuntajeNomi=true;

	public Boolean getMostrarFormatoNomiPuntajeNomi() {
		return this.mostrarFormatoNomiPuntajeNomi;
	}

	public void setMostrarFormatoNomiPuntajeNomi(Boolean visibilidadResaltarFormatoNomi) {
		this.mostrarFormatoNomiPuntajeNomi= visibilidadResaltarFormatoNomi;
	}



	public Boolean activarFormatoNomiPuntajeNomi=true;

	public Boolean gethabilitarResaltarFormatoNomiPuntajeNomi() {
		return this.activarFormatoNomiPuntajeNomi;
	}

	public void setActivarFormatoNomiPuntajeNomi(Boolean habilitarResaltarFormatoNomi) {
		this.activarFormatoNomiPuntajeNomi= habilitarResaltarFormatoNomi;
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

		this.setMostrarFormatoNomiPuntajeNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomi.class)) {
				this.setMostrarFormatoNomiPuntajeNomi(esAsigna);
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

		this.setActivarFormatoNomiPuntajeNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomi.class)) {
				this.setActivarFormatoNomiPuntajeNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PuntajeNomiBeanSwingJInternalFrame puntajenomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormatoNomiPuntajeNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormatoNomi.class)) {
				this.setResaltarFormatoNomiPuntajeNomi(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}