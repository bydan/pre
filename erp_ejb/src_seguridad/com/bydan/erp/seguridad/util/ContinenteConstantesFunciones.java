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


import com.bydan.erp.seguridad.util.ContinenteConstantesFunciones;
import com.bydan.erp.seguridad.util.ContinenteParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ContinenteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ContinenteConstantesFunciones extends ContinenteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Continente";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Continente"+ContinenteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ContinenteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ContinenteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ContinenteConstantesFunciones.SCHEMA+"_"+ContinenteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ContinenteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ContinenteConstantesFunciones.SCHEMA+"_"+ContinenteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ContinenteConstantesFunciones.SCHEMA+"_"+ContinenteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ContinenteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ContinenteConstantesFunciones.SCHEMA+"_"+ContinenteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContinenteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ContinenteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContinenteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContinenteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ContinenteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ContinenteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ContinenteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ContinenteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ContinenteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ContinenteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Continentes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Continente";
	public static final String SCLASSWEBTITULO_LOWER="Continente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Continente";
	public static final String OBJECTNAME="continente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="continente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select continente from "+ContinenteConstantesFunciones.SPERSISTENCENAME+" continente";
	public static String QUERYSELECTNATIVE="select "+ContinenteConstantesFunciones.SCHEMA+"."+ContinenteConstantesFunciones.TABLENAME+".id,"+ContinenteConstantesFunciones.SCHEMA+"."+ContinenteConstantesFunciones.TABLENAME+".version_row,"+ContinenteConstantesFunciones.SCHEMA+"."+ContinenteConstantesFunciones.TABLENAME+".codigo,"+ContinenteConstantesFunciones.SCHEMA+"."+ContinenteConstantesFunciones.TABLENAME+".nombre from "+ContinenteConstantesFunciones.SCHEMA+"."+ContinenteConstantesFunciones.TABLENAME;//+" as "+ContinenteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ContinenteConstantesFuncionesAdditional continenteConstantesFuncionesAdditional=null;
	
	public ContinenteConstantesFuncionesAdditional getContinenteConstantesFuncionesAdditional() {
		return this.continenteConstantesFuncionesAdditional;
	}
	
	public void setContinenteConstantesFuncionesAdditional(ContinenteConstantesFuncionesAdditional continenteConstantesFuncionesAdditional) {
		try {
			this.continenteConstantesFuncionesAdditional=continenteConstantesFuncionesAdditional;
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
	
	public static String getContinenteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ContinenteConstantesFunciones.CODIGO)) {sLabelColumna=ContinenteConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ContinenteConstantesFunciones.NOMBRE)) {sLabelColumna=ContinenteConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getContinenteDescripcion(Continente continente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(continente !=null/* && continente.getId()!=0*/) {
			sDescripcion=continente.getcodigo();//continentecontinente.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getContinenteDescripcionDetallado(Continente continente) {
		String sDescripcion="";
			
		sDescripcion+=ContinenteConstantesFunciones.ID+"=";
		sDescripcion+=continente.getId().toString()+",";
		sDescripcion+=ContinenteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=continente.getVersionRow().toString()+",";
		sDescripcion+=ContinenteConstantesFunciones.CODIGO+"=";
		sDescripcion+=continente.getcodigo()+",";
		sDescripcion+=ContinenteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=continente.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setContinenteDescripcion(Continente continente,String sValor) throws Exception {			
		if(continente !=null) {
			continente.setcodigo(sValor);;//continentecontinente.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosContinente(Continente continente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		continente.setcodigo(continente.getcodigo().trim());
		continente.setnombre(continente.getnombre().trim());
	}
	
	public static void quitarEspaciosContinentes(List<Continente> continentes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Continente continente: continentes) {
			continente.setcodigo(continente.getcodigo().trim());
			continente.setnombre(continente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresContinente(Continente continente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && continente.getConCambioAuxiliar()) {
			continente.setIsDeleted(continente.getIsDeletedAuxiliar());	
			continente.setIsNew(continente.getIsNewAuxiliar());	
			continente.setIsChanged(continente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			continente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			continente.setIsDeletedAuxiliar(false);	
			continente.setIsNewAuxiliar(false);	
			continente.setIsChangedAuxiliar(false);
			
			continente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresContinentes(List<Continente> continentes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Continente continente : continentes) {
			if(conAsignarBase && continente.getConCambioAuxiliar()) {
				continente.setIsDeleted(continente.getIsDeletedAuxiliar());	
				continente.setIsNew(continente.getIsNewAuxiliar());	
				continente.setIsChanged(continente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				continente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				continente.setIsDeletedAuxiliar(false);	
				continente.setIsNewAuxiliar(false);	
				continente.setIsChangedAuxiliar(false);
				
				continente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresContinente(Continente continente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresContinentes(List<Continente> continentes,Boolean conEnteros) throws Exception  {
		
		for(Continente continente: continentes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaContinente(List<Continente> continentes,Continente continenteAux) throws Exception  {
		ContinenteConstantesFunciones.InicializarValoresContinente(continenteAux,true);
		
		for(Continente continente: continentes) {
			if(continente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesContinente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ContinenteConstantesFunciones.getArrayColumnasGlobalesContinente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesContinente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoContinente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Continente> continentes,Continente continente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Continente continenteAux: continentes) {
			if(continenteAux!=null && continente!=null) {
				if((continenteAux.getId()==null && continente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(continenteAux.getId()!=null && continente.getId()!=null){
					if(continenteAux.getId().equals(continente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaContinente(List<Continente> continentes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Continente continente: continentes) {			
			if(continente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaContinente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ContinenteConstantesFunciones.LABEL_ID, ContinenteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContinenteConstantesFunciones.LABEL_VERSIONROW, ContinenteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContinenteConstantesFunciones.LABEL_CODIGO, ContinenteConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ContinenteConstantesFunciones.LABEL_NOMBRE, ContinenteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasContinente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ContinenteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContinenteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContinenteConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ContinenteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContinente() throws Exception  {
		return ContinenteConstantesFunciones.getTiposSeleccionarContinente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContinente(Boolean conFk) throws Exception  {
		return ContinenteConstantesFunciones.getTiposSeleccionarContinente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarContinente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContinenteConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ContinenteConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ContinenteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ContinenteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesContinente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesContinente(Continente continenteAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesContinente(List<Continente> continentesTemp) throws Exception {
		for(Continente continenteAux:continentesTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfContinente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfContinente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfContinente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ContinenteConstantesFunciones.getClassesRelationshipsOfContinente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfContinente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfContinente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ContinenteConstantesFunciones.getClassesRelationshipsFromStringsOfContinente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfContinente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	public static void actualizarLista(Continente continente,List<Continente> continentes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Continente continenteEncontrado=null;
			
			for(Continente continenteLocal:continentes) {
				if(continenteLocal.getId().equals(continente.getId())) {
					continenteEncontrado=continenteLocal;
					
					continenteLocal.setIsChanged(continente.getIsChanged());
					continenteLocal.setIsNew(continente.getIsNew());
					continenteLocal.setIsDeleted(continente.getIsDeleted());
					
					continenteLocal.setGeneralEntityOriginal(continente.getGeneralEntityOriginal());
					
					continenteLocal.setId(continente.getId());	
					continenteLocal.setVersionRow(continente.getVersionRow());	
					continenteLocal.setcodigo(continente.getcodigo());	
					continenteLocal.setnombre(continente.getnombre());	
					
					
					continenteLocal.setPaiss(continente.getPaiss());
					
					existe=true;
					break;
				}
			}
			
			if(!continente.getIsDeleted()) {
				if(!existe) {
					continentes.add(continente);
				}
			} else {
				if(continenteEncontrado!=null && permiteQuitar)  {
					continentes.remove(continenteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Continente continente,List<Continente> continentes) throws Exception {
		try	{			
			for(Continente continenteLocal:continentes) {
				if(continenteLocal.getId().equals(continente.getId())) {
					continenteLocal.setIsSelected(continente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesContinente(List<Continente> continentesAux) throws Exception {
		//this.continentesAux=continentesAux;
		
		for(Continente continenteAux:continentesAux) {
			if(continenteAux.getIsChanged()) {
				continenteAux.setIsChanged(false);
			}		
			
			if(continenteAux.getIsNew()) {
				continenteAux.setIsNew(false);
			}	
			
			if(continenteAux.getIsDeleted()) {
				continenteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesContinente(Continente continenteAux) throws Exception {
		//this.continenteAux=continenteAux;
		
			if(continenteAux.getIsChanged()) {
				continenteAux.setIsChanged(false);
			}		
			
			if(continenteAux.getIsNew()) {
				continenteAux.setIsNew(false);
			}	
			
			if(continenteAux.getIsDeleted()) {
				continenteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Continente continenteAsignar,Continente continente) throws Exception {
		continenteAsignar.setId(continente.getId());	
		continenteAsignar.setVersionRow(continente.getVersionRow());	
		continenteAsignar.setcodigo(continente.getcodigo());	
		continenteAsignar.setnombre(continente.getnombre());	
	}
	
	public static void inicializarContinente(Continente continente) throws Exception {
		try {
				continente.setId(0L);	
					
				continente.setcodigo("");	
				continente.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderContinente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ContinenteConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ContinenteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataContinente(String sTipo,Row row,Workbook workbook,Continente continente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(continente.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(continente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryContinente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryContinente() {
		return this.sFinalQueryContinente;
	}
	
	public void setsFinalQueryContinente(String sFinalQueryContinente) {
		this.sFinalQueryContinente= sFinalQueryContinente;
	}
	
	public Border resaltarSeleccionarContinente=null;
	
	public Border setResaltarSeleccionarContinente(ParametroGeneralUsuario parametroGeneralUsuario/*ContinenteBeanSwingJInternalFrame continenteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//continenteBeanSwingJInternalFrame.jTtoolBarContinente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarContinente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarContinente() {
		return this.resaltarSeleccionarContinente;
	}
	
	public void setResaltarSeleccionarContinente(Border borderResaltarSeleccionarContinente) {
		this.resaltarSeleccionarContinente= borderResaltarSeleccionarContinente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridContinente=null;
	public Boolean mostraridContinente=true;
	public Boolean activaridContinente=true;

	public Border resaltarcodigoContinente=null;
	public Boolean mostrarcodigoContinente=true;
	public Boolean activarcodigoContinente=true;

	public Border resaltarnombreContinente=null;
	public Boolean mostrarnombreContinente=true;
	public Boolean activarnombreContinente=true;

	
	

	public Border setResaltaridContinente(ParametroGeneralUsuario parametroGeneralUsuario/*ContinenteBeanSwingJInternalFrame continenteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//continenteBeanSwingJInternalFrame.jTtoolBarContinente.setBorder(borderResaltar);
		
		this.resaltaridContinente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridContinente() {
		return this.resaltaridContinente;
	}

	public void setResaltaridContinente(Border borderResaltar) {
		this.resaltaridContinente= borderResaltar;
	}

	public Boolean getMostraridContinente() {
		return this.mostraridContinente;
	}

	public void setMostraridContinente(Boolean mostraridContinente) {
		this.mostraridContinente= mostraridContinente;
	}

	public Boolean getActivaridContinente() {
		return this.activaridContinente;
	}

	public void setActivaridContinente(Boolean activaridContinente) {
		this.activaridContinente= activaridContinente;
	}

	public Border setResaltarcodigoContinente(ParametroGeneralUsuario parametroGeneralUsuario/*ContinenteBeanSwingJInternalFrame continenteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//continenteBeanSwingJInternalFrame.jTtoolBarContinente.setBorder(borderResaltar);
		
		this.resaltarcodigoContinente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoContinente() {
		return this.resaltarcodigoContinente;
	}

	public void setResaltarcodigoContinente(Border borderResaltar) {
		this.resaltarcodigoContinente= borderResaltar;
	}

	public Boolean getMostrarcodigoContinente() {
		return this.mostrarcodigoContinente;
	}

	public void setMostrarcodigoContinente(Boolean mostrarcodigoContinente) {
		this.mostrarcodigoContinente= mostrarcodigoContinente;
	}

	public Boolean getActivarcodigoContinente() {
		return this.activarcodigoContinente;
	}

	public void setActivarcodigoContinente(Boolean activarcodigoContinente) {
		this.activarcodigoContinente= activarcodigoContinente;
	}

	public Border setResaltarnombreContinente(ParametroGeneralUsuario parametroGeneralUsuario/*ContinenteBeanSwingJInternalFrame continenteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//continenteBeanSwingJInternalFrame.jTtoolBarContinente.setBorder(borderResaltar);
		
		this.resaltarnombreContinente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreContinente() {
		return this.resaltarnombreContinente;
	}

	public void setResaltarnombreContinente(Border borderResaltar) {
		this.resaltarnombreContinente= borderResaltar;
	}

	public Boolean getMostrarnombreContinente() {
		return this.mostrarnombreContinente;
	}

	public void setMostrarnombreContinente(Boolean mostrarnombreContinente) {
		this.mostrarnombreContinente= mostrarnombreContinente;
	}

	public Boolean getActivarnombreContinente() {
		return this.activarnombreContinente;
	}

	public void setActivarnombreContinente(Boolean activarnombreContinente) {
		this.activarnombreContinente= activarnombreContinente;
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
		
		
		this.setMostraridContinente(esInicial);
		this.setMostrarcodigoContinente(esInicial);
		this.setMostrarnombreContinente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContinenteConstantesFunciones.ID)) {
				this.setMostraridContinente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContinenteConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoContinente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContinenteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreContinente(esAsigna);
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
		
		
		this.setActivaridContinente(esInicial);
		this.setActivarcodigoContinente(esInicial);
		this.setActivarnombreContinente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContinenteConstantesFunciones.ID)) {
				this.setActivaridContinente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContinenteConstantesFunciones.CODIGO)) {
				this.setActivarcodigoContinente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContinenteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreContinente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ContinenteBeanSwingJInternalFrame continenteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridContinente(esInicial);
		this.setResaltarcodigoContinente(esInicial);
		this.setResaltarnombreContinente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ContinenteConstantesFunciones.ID)) {
				this.setResaltaridContinente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContinenteConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoContinente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ContinenteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreContinente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPaisContinente=null;

	public Border getResaltarPaisContinente() {
		return this.resaltarPaisContinente;
	}

	public void setResaltarPaisContinente(Border borderResaltarPais) {
		if(borderResaltarPais!=null) {
			this.resaltarPaisContinente= borderResaltarPais;
		}
	}

	public Border setResaltarPaisContinente(ParametroGeneralUsuario parametroGeneralUsuario/*ContinenteBeanSwingJInternalFrame continenteBeanSwingJInternalFrame*/) {
		Border borderResaltarPais=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//continenteBeanSwingJInternalFrame.jTtoolBarContinente.setBorder(borderResaltarPais);
			
		this.resaltarPaisContinente= borderResaltarPais;

		 return borderResaltarPais;
	}



	public Boolean mostrarPaisContinente=true;

	public Boolean getMostrarPaisContinente() {
		return this.mostrarPaisContinente;
	}

	public void setMostrarPaisContinente(Boolean visibilidadResaltarPais) {
		this.mostrarPaisContinente= visibilidadResaltarPais;
	}



	public Boolean activarPaisContinente=true;

	public Boolean gethabilitarResaltarPaisContinente() {
		return this.activarPaisContinente;
	}

	public void setActivarPaisContinente(Boolean habilitarResaltarPais) {
		this.activarPaisContinente= habilitarResaltarPais;
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

		this.setMostrarPaisContinente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Pais.class)) {
				this.setMostrarPaisContinente(esAsigna);
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

		this.setActivarPaisContinente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Pais.class)) {
				this.setActivarPaisContinente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ContinenteBeanSwingJInternalFrame continenteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPaisContinente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Pais.class)) {
				this.setResaltarPaisContinente(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}