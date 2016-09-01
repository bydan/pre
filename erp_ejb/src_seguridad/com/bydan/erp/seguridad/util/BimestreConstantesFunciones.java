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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.BimestreConstantesFunciones;
import com.bydan.erp.seguridad.util.BimestreParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.BimestreParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class BimestreConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="Bimestre";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Bimestre"+BimestreConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BimestreHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BimestreHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BimestreConstantesFunciones.SCHEMA+"_"+BimestreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BimestreHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BimestreConstantesFunciones.SCHEMA+"_"+BimestreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BimestreConstantesFunciones.SCHEMA+"_"+BimestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BimestreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BimestreConstantesFunciones.SCHEMA+"_"+BimestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BimestreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BimestreHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BimestreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BimestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BimestreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BimestreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BimestreConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BimestreConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BimestreConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BimestreConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Bimestres";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Bimestre";
	public static final String SCLASSWEBTITULO_LOWER="Bimestre";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Bimestre";
	public static final String OBJECTNAME="bimestre";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="bimestre";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select bimestre from "+BimestreConstantesFunciones.SPERSISTENCENAME+" bimestre";
	public static String QUERYSELECTNATIVE="select "+BimestreConstantesFunciones.SCHEMA+"."+BimestreConstantesFunciones.TABLENAME+".id,"+BimestreConstantesFunciones.SCHEMA+"."+BimestreConstantesFunciones.TABLENAME+".version_row,"+BimestreConstantesFunciones.SCHEMA+"."+BimestreConstantesFunciones.TABLENAME+".nombre from "+BimestreConstantesFunciones.SCHEMA+"."+BimestreConstantesFunciones.TABLENAME;//+" as "+BimestreConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getBimestreLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BimestreConstantesFunciones.NOMBRE)) {sLabelColumna=BimestreConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getBimestreDescripcion(Bimestre bimestre) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(bimestre !=null/* && bimestre.getId()!=0*/) {
			sDescripcion=bimestre.getnombre();//bimestrebimestre.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getBimestreDescripcionDetallado(Bimestre bimestre) {
		String sDescripcion="";
			
		sDescripcion+=BimestreConstantesFunciones.ID+"=";
		sDescripcion+=bimestre.getId().toString()+",";
		sDescripcion+=BimestreConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=bimestre.getVersionRow().toString()+",";
		sDescripcion+=BimestreConstantesFunciones.NOMBRE+"=";
		sDescripcion+=bimestre.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setBimestreDescripcion(Bimestre bimestre,String sValor) throws Exception {			
		if(bimestre !=null) {
			bimestre.setnombre(sValor);;//bimestrebimestre.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosBimestre(Bimestre bimestre,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		bimestre.setnombre(bimestre.getnombre().trim());
	}
	
	public static void quitarEspaciosBimestres(List<Bimestre> bimestres,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Bimestre bimestre: bimestres) {
			bimestre.setnombre(bimestre.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBimestre(Bimestre bimestre,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && bimestre.getConCambioAuxiliar()) {
			bimestre.setIsDeleted(bimestre.getIsDeletedAuxiliar());	
			bimestre.setIsNew(bimestre.getIsNewAuxiliar());	
			bimestre.setIsChanged(bimestre.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			bimestre.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			bimestre.setIsDeletedAuxiliar(false);	
			bimestre.setIsNewAuxiliar(false);	
			bimestre.setIsChangedAuxiliar(false);
			
			bimestre.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBimestres(List<Bimestre> bimestres,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Bimestre bimestre : bimestres) {
			if(conAsignarBase && bimestre.getConCambioAuxiliar()) {
				bimestre.setIsDeleted(bimestre.getIsDeletedAuxiliar());	
				bimestre.setIsNew(bimestre.getIsNewAuxiliar());	
				bimestre.setIsChanged(bimestre.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				bimestre.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				bimestre.setIsDeletedAuxiliar(false);	
				bimestre.setIsNewAuxiliar(false);	
				bimestre.setIsChangedAuxiliar(false);
				
				bimestre.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBimestre(Bimestre bimestre,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresBimestres(List<Bimestre> bimestres,Boolean conEnteros) throws Exception  {
		
		for(Bimestre bimestre: bimestres) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaBimestre(List<Bimestre> bimestres,Bimestre bimestreAux) throws Exception  {
		BimestreConstantesFunciones.InicializarValoresBimestre(bimestreAux,true);
		
		for(Bimestre bimestre: bimestres) {
			if(bimestre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBimestre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BimestreConstantesFunciones.getArrayColumnasGlobalesBimestre(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBimestre(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBimestre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Bimestre> bimestres,Bimestre bimestre,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Bimestre bimestreAux: bimestres) {
			if(bimestreAux!=null && bimestre!=null) {
				if((bimestreAux.getId()==null && bimestre.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(bimestreAux.getId()!=null && bimestre.getId()!=null){
					if(bimestreAux.getId().equals(bimestre.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBimestre(List<Bimestre> bimestres) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Bimestre bimestre: bimestres) {			
			if(bimestre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBimestre() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BimestreConstantesFunciones.LABEL_ID, BimestreConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BimestreConstantesFunciones.LABEL_VERSIONROW, BimestreConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BimestreConstantesFunciones.LABEL_NOMBRE, BimestreConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBimestre() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BimestreConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BimestreConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BimestreConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBimestre() throws Exception  {
		return BimestreConstantesFunciones.getTiposSeleccionarBimestre(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBimestre(Boolean conFk) throws Exception  {
		return BimestreConstantesFunciones.getTiposSeleccionarBimestre(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBimestre(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BimestreConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(BimestreConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBimestre(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBimestre(Bimestre bimestreAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesBimestre(List<Bimestre> bimestresTemp) throws Exception {
		for(Bimestre bimestreAux:bimestresTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBimestre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBimestre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBimestre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BimestreConstantesFunciones.getClassesRelationshipsOfBimestre(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBimestre(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBimestre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BimestreConstantesFunciones.getClassesRelationshipsFromStringsOfBimestre(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBimestre(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Bimestre bimestre,List<Bimestre> bimestres,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Bimestre bimestreEncontrado=null;
			
			for(Bimestre bimestreLocal:bimestres) {
				if(bimestreLocal.getId().equals(bimestre.getId())) {
					bimestreEncontrado=bimestreLocal;
					
					bimestreLocal.setIsChanged(bimestre.getIsChanged());
					bimestreLocal.setIsNew(bimestre.getIsNew());
					bimestreLocal.setIsDeleted(bimestre.getIsDeleted());
					
					bimestreLocal.setGeneralEntityOriginal(bimestre.getGeneralEntityOriginal());
					
					bimestreLocal.setId(bimestre.getId());	
					bimestreLocal.setVersionRow(bimestre.getVersionRow());	
					bimestreLocal.setnombre(bimestre.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!bimestre.getIsDeleted()) {
				if(!existe) {
					bimestres.add(bimestre);
				}
			} else {
				if(bimestreEncontrado!=null && permiteQuitar)  {
					bimestres.remove(bimestreEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Bimestre bimestre,List<Bimestre> bimestres) throws Exception {
		try	{			
			for(Bimestre bimestreLocal:bimestres) {
				if(bimestreLocal.getId().equals(bimestre.getId())) {
					bimestreLocal.setIsSelected(bimestre.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBimestre(List<Bimestre> bimestresAux) throws Exception {
		//this.bimestresAux=bimestresAux;
		
		for(Bimestre bimestreAux:bimestresAux) {
			if(bimestreAux.getIsChanged()) {
				bimestreAux.setIsChanged(false);
			}		
			
			if(bimestreAux.getIsNew()) {
				bimestreAux.setIsNew(false);
			}	
			
			if(bimestreAux.getIsDeleted()) {
				bimestreAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBimestre(Bimestre bimestreAux) throws Exception {
		//this.bimestreAux=bimestreAux;
		
			if(bimestreAux.getIsChanged()) {
				bimestreAux.setIsChanged(false);
			}		
			
			if(bimestreAux.getIsNew()) {
				bimestreAux.setIsNew(false);
			}	
			
			if(bimestreAux.getIsDeleted()) {
				bimestreAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Bimestre bimestreAsignar,Bimestre bimestre) throws Exception {
		bimestreAsignar.setId(bimestre.getId());	
		bimestreAsignar.setVersionRow(bimestre.getVersionRow());	
		bimestreAsignar.setnombre(bimestre.getnombre());	
	}
	
	public static void inicializarBimestre(Bimestre bimestre) throws Exception {
		try {
				bimestre.setId(0L);	
					
				bimestre.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBimestre(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BimestreConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBimestre(String sTipo,Row row,Workbook workbook,Bimestre bimestre,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(bimestre.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBimestre=Constantes.SFINALQUERY;
	
	public String getsFinalQueryBimestre() {
		return this.sFinalQueryBimestre;
	}
	
	public void setsFinalQueryBimestre(String sFinalQueryBimestre) {
		this.sFinalQueryBimestre= sFinalQueryBimestre;
	}
	
	public Border resaltarSeleccionarBimestre=null;
	
	public Border setResaltarSeleccionarBimestre(ParametroGeneralUsuario parametroGeneralUsuario/*BimestreBeanSwingJInternalFrame bimestreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//bimestreBeanSwingJInternalFrame.jTtoolBarBimestre.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBimestre= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBimestre() {
		return this.resaltarSeleccionarBimestre;
	}
	
	public void setResaltarSeleccionarBimestre(Border borderResaltarSeleccionarBimestre) {
		this.resaltarSeleccionarBimestre= borderResaltarSeleccionarBimestre;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBimestre=null;
	public Boolean mostraridBimestre=true;
	public Boolean activaridBimestre=true;

	public Border resaltarnombreBimestre=null;
	public Boolean mostrarnombreBimestre=true;
	public Boolean activarnombreBimestre=true;

	
	

	public Border setResaltaridBimestre(ParametroGeneralUsuario parametroGeneralUsuario/*BimestreBeanSwingJInternalFrame bimestreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bimestreBeanSwingJInternalFrame.jTtoolBarBimestre.setBorder(borderResaltar);
		
		this.resaltaridBimestre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBimestre() {
		return this.resaltaridBimestre;
	}

	public void setResaltaridBimestre(Border borderResaltar) {
		this.resaltaridBimestre= borderResaltar;
	}

	public Boolean getMostraridBimestre() {
		return this.mostraridBimestre;
	}

	public void setMostraridBimestre(Boolean mostraridBimestre) {
		this.mostraridBimestre= mostraridBimestre;
	}

	public Boolean getActivaridBimestre() {
		return this.activaridBimestre;
	}

	public void setActivaridBimestre(Boolean activaridBimestre) {
		this.activaridBimestre= activaridBimestre;
	}

	public Border setResaltarnombreBimestre(ParametroGeneralUsuario parametroGeneralUsuario/*BimestreBeanSwingJInternalFrame bimestreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bimestreBeanSwingJInternalFrame.jTtoolBarBimestre.setBorder(borderResaltar);
		
		this.resaltarnombreBimestre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreBimestre() {
		return this.resaltarnombreBimestre;
	}

	public void setResaltarnombreBimestre(Border borderResaltar) {
		this.resaltarnombreBimestre= borderResaltar;
	}

	public Boolean getMostrarnombreBimestre() {
		return this.mostrarnombreBimestre;
	}

	public void setMostrarnombreBimestre(Boolean mostrarnombreBimestre) {
		this.mostrarnombreBimestre= mostrarnombreBimestre;
	}

	public Boolean getActivarnombreBimestre() {
		return this.activarnombreBimestre;
	}

	public void setActivarnombreBimestre(Boolean activarnombreBimestre) {
		this.activarnombreBimestre= activarnombreBimestre;
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
		
		
		this.setMostraridBimestre(esInicial);
		this.setMostrarnombreBimestre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BimestreConstantesFunciones.ID)) {
				this.setMostraridBimestre(esAsigna);
				continue;
			}

			if(campo.clase.equals(BimestreConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreBimestre(esAsigna);
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
		
		
		this.setActivaridBimestre(esInicial);
		this.setActivarnombreBimestre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BimestreConstantesFunciones.ID)) {
				this.setActivaridBimestre(esAsigna);
				continue;
			}

			if(campo.clase.equals(BimestreConstantesFunciones.NOMBRE)) {
				this.setActivarnombreBimestre(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BimestreBeanSwingJInternalFrame bimestreBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBimestre(esInicial);
		this.setResaltarnombreBimestre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BimestreConstantesFunciones.ID)) {
				this.setResaltaridBimestre(esAsigna);
				continue;
			}

			if(campo.clase.equals(BimestreConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreBimestre(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BimestreBeanSwingJInternalFrame bimestreBeanSwingJInternalFrame*/)throws Exception {	
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