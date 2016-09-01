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


import com.bydan.erp.seguridad.util.MesConstantesFunciones;
import com.bydan.erp.seguridad.util.MesParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.MesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="Mes";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Mes"+MesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MesConstantesFunciones.SCHEMA+"_"+MesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MesConstantesFunciones.SCHEMA+"_"+MesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MesConstantesFunciones.SCHEMA+"_"+MesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MesConstantesFunciones.SCHEMA+"_"+MesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Mess";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Mes";
	public static final String SCLASSWEBTITULO_LOWER="Mes";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Mes";
	public static final String OBJECTNAME="mes";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="mes";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select mes from "+MesConstantesFunciones.SPERSISTENCENAME+" mes";
	public static String QUERYSELECTNATIVE="select "+MesConstantesFunciones.SCHEMA+"."+MesConstantesFunciones.TABLENAME+".id,"+MesConstantesFunciones.SCHEMA+"."+MesConstantesFunciones.TABLENAME+".version_row,"+MesConstantesFunciones.SCHEMA+"."+MesConstantesFunciones.TABLENAME+".nombre from "+MesConstantesFunciones.SCHEMA+"."+MesConstantesFunciones.TABLENAME;//+" as "+MesConstantesFunciones.TABLENAME;
	
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
	
	public static String getMesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MesConstantesFunciones.NOMBRE)) {sLabelColumna=MesConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
	
	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(mes !=null/* && mes.getId()!=0*/) {
			sDescripcion=mes.getnombre();//mesmes.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getMesDescripcionDetallado(Mes mes) {
		String sDescripcion="";
			
		sDescripcion+=MesConstantesFunciones.ID+"=";
		sDescripcion+=mes.getId().toString()+",";
		sDescripcion+=MesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=mes.getVersionRow().toString()+",";
		sDescripcion+=MesConstantesFunciones.NOMBRE+"=";
		sDescripcion+=mes.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setMesDescripcion(Mes mes,String sValor) throws Exception {			
		if(mes !=null) {
			mes.setnombre(sValor);;//mesmes.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMes(Mes mes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		mes.setnombre(mes.getnombre().trim());
	}
	
	public static void quitarEspaciosMess(List<Mes> mess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Mes mes: mess) {
			mes.setnombre(mes.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMes(Mes mes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && mes.getConCambioAuxiliar()) {
			mes.setIsDeleted(mes.getIsDeletedAuxiliar());	
			mes.setIsNew(mes.getIsNewAuxiliar());	
			mes.setIsChanged(mes.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			mes.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			mes.setIsDeletedAuxiliar(false);	
			mes.setIsNewAuxiliar(false);	
			mes.setIsChangedAuxiliar(false);
			
			mes.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMess(List<Mes> mess,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Mes mes : mess) {
			if(conAsignarBase && mes.getConCambioAuxiliar()) {
				mes.setIsDeleted(mes.getIsDeletedAuxiliar());	
				mes.setIsNew(mes.getIsNewAuxiliar());	
				mes.setIsChanged(mes.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				mes.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				mes.setIsDeletedAuxiliar(false);	
				mes.setIsNewAuxiliar(false);	
				mes.setIsChangedAuxiliar(false);
				
				mes.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMes(Mes mes,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMess(List<Mes> mess,Boolean conEnteros) throws Exception  {
		
		for(Mes mes: mess) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMes(List<Mes> mess,Mes mesAux) throws Exception  {
		MesConstantesFunciones.InicializarValoresMes(mesAux,true);
		
		for(Mes mes: mess) {
			if(mes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MesConstantesFunciones.getArrayColumnasGlobalesMes(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMes(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Mes> mess,Mes mes,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Mes mesAux: mess) {
			if(mesAux!=null && mes!=null) {
				if((mesAux.getId()==null && mes.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(mesAux.getId()!=null && mes.getId()!=null){
					if(mesAux.getId().equals(mes.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMes(List<Mes> mess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Mes mes: mess) {			
			if(mes.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMes() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MesConstantesFunciones.LABEL_ID, MesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MesConstantesFunciones.LABEL_VERSIONROW, MesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MesConstantesFunciones.LABEL_NOMBRE, MesConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMes() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MesConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMes() throws Exception  {
		return MesConstantesFunciones.getTiposSeleccionarMes(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMes(Boolean conFk) throws Exception  {
		return MesConstantesFunciones.getTiposSeleccionarMes(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMes(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MesConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(MesConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMes(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMes(Mes mesAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesMes(List<Mes> messTemp) throws Exception {
		for(Mes mesAux:messTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMes(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MesConstantesFunciones.getClassesRelationshipsOfMes(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMes(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMes(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MesConstantesFunciones.getClassesRelationshipsFromStringsOfMes(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMes(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Mes mes,List<Mes> mess,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Mes mesEncontrado=null;
			
			for(Mes mesLocal:mess) {
				if(mesLocal.getId().equals(mes.getId())) {
					mesEncontrado=mesLocal;
					
					mesLocal.setIsChanged(mes.getIsChanged());
					mesLocal.setIsNew(mes.getIsNew());
					mesLocal.setIsDeleted(mes.getIsDeleted());
					
					mesLocal.setGeneralEntityOriginal(mes.getGeneralEntityOriginal());
					
					mesLocal.setId(mes.getId());	
					mesLocal.setVersionRow(mes.getVersionRow());	
					mesLocal.setnombre(mes.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!mes.getIsDeleted()) {
				if(!existe) {
					mess.add(mes);
				}
			} else {
				if(mesEncontrado!=null && permiteQuitar)  {
					mess.remove(mesEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Mes mes,List<Mes> mess) throws Exception {
		try	{			
			for(Mes mesLocal:mess) {
				if(mesLocal.getId().equals(mes.getId())) {
					mesLocal.setIsSelected(mes.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMes(List<Mes> messAux) throws Exception {
		//this.messAux=messAux;
		
		for(Mes mesAux:messAux) {
			if(mesAux.getIsChanged()) {
				mesAux.setIsChanged(false);
			}		
			
			if(mesAux.getIsNew()) {
				mesAux.setIsNew(false);
			}	
			
			if(mesAux.getIsDeleted()) {
				mesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMes(Mes mesAux) throws Exception {
		//this.mesAux=mesAux;
		
			if(mesAux.getIsChanged()) {
				mesAux.setIsChanged(false);
			}		
			
			if(mesAux.getIsNew()) {
				mesAux.setIsNew(false);
			}	
			
			if(mesAux.getIsDeleted()) {
				mesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Mes mesAsignar,Mes mes) throws Exception {
		mesAsignar.setId(mes.getId());	
		mesAsignar.setVersionRow(mes.getVersionRow());	
		mesAsignar.setnombre(mes.getnombre());	
	}
	
	public static void inicializarMes(Mes mes) throws Exception {
		try {
				mes.setId(0L);	
					
				mes.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMes(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MesConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMes(String sTipo,Row row,Workbook workbook,Mes mes,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(mes.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMes=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMes() {
		return this.sFinalQueryMes;
	}
	
	public void setsFinalQueryMes(String sFinalQueryMes) {
		this.sFinalQueryMes= sFinalQueryMes;
	}
	
	public Border resaltarSeleccionarMes=null;
	
	public Border setResaltarSeleccionarMes(ParametroGeneralUsuario parametroGeneralUsuario/*MesBeanSwingJInternalFrame mesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//mesBeanSwingJInternalFrame.jTtoolBarMes.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMes= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMes() {
		return this.resaltarSeleccionarMes;
	}
	
	public void setResaltarSeleccionarMes(Border borderResaltarSeleccionarMes) {
		this.resaltarSeleccionarMes= borderResaltarSeleccionarMes;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMes=null;
	public Boolean mostraridMes=true;
	public Boolean activaridMes=true;

	public Border resaltarnombreMes=null;
	public Boolean mostrarnombreMes=true;
	public Boolean activarnombreMes=true;

	
	

	public Border setResaltaridMes(ParametroGeneralUsuario parametroGeneralUsuario/*MesBeanSwingJInternalFrame mesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mesBeanSwingJInternalFrame.jTtoolBarMes.setBorder(borderResaltar);
		
		this.resaltaridMes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMes() {
		return this.resaltaridMes;
	}

	public void setResaltaridMes(Border borderResaltar) {
		this.resaltaridMes= borderResaltar;
	}

	public Boolean getMostraridMes() {
		return this.mostraridMes;
	}

	public void setMostraridMes(Boolean mostraridMes) {
		this.mostraridMes= mostraridMes;
	}

	public Boolean getActivaridMes() {
		return this.activaridMes;
	}

	public void setActivaridMes(Boolean activaridMes) {
		this.activaridMes= activaridMes;
	}

	public Border setResaltarnombreMes(ParametroGeneralUsuario parametroGeneralUsuario/*MesBeanSwingJInternalFrame mesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mesBeanSwingJInternalFrame.jTtoolBarMes.setBorder(borderResaltar);
		
		this.resaltarnombreMes= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreMes() {
		return this.resaltarnombreMes;
	}

	public void setResaltarnombreMes(Border borderResaltar) {
		this.resaltarnombreMes= borderResaltar;
	}

	public Boolean getMostrarnombreMes() {
		return this.mostrarnombreMes;
	}

	public void setMostrarnombreMes(Boolean mostrarnombreMes) {
		this.mostrarnombreMes= mostrarnombreMes;
	}

	public Boolean getActivarnombreMes() {
		return this.activarnombreMes;
	}

	public void setActivarnombreMes(Boolean activarnombreMes) {
		this.activarnombreMes= activarnombreMes;
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
		
		
		this.setMostraridMes(esInicial);
		this.setMostrarnombreMes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MesConstantesFunciones.ID)) {
				this.setMostraridMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreMes(esAsigna);
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
		
		
		this.setActivaridMes(esInicial);
		this.setActivarnombreMes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MesConstantesFunciones.ID)) {
				this.setActivaridMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesConstantesFunciones.NOMBRE)) {
				this.setActivarnombreMes(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MesBeanSwingJInternalFrame mesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMes(esInicial);
		this.setResaltarnombreMes(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MesConstantesFunciones.ID)) {
				this.setResaltaridMes(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreMes(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MesBeanSwingJInternalFrame mesBeanSwingJInternalFrame*/)throws Exception {	
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