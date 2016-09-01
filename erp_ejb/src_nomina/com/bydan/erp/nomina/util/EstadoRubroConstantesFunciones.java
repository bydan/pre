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


import com.bydan.erp.nomina.util.EstadoRubroConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoRubroParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoRubroParameterGeneral;

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
final public class EstadoRubroConstantesFunciones extends EstadoRubroConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoRubro";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoRubro"+EstadoRubroConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoRubroHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoRubroHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoRubroConstantesFunciones.SCHEMA+"_"+EstadoRubroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoRubroConstantesFunciones.SCHEMA+"_"+EstadoRubroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoRubroConstantesFunciones.SCHEMA+"_"+EstadoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoRubroConstantesFunciones.SCHEMA+"_"+EstadoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoRubroConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoRubroConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoRubroConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoRubroConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Rubros";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Rubro";
	public static final String SCLASSWEBTITULO_LOWER="Estado Rubro";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoRubro";
	public static final String OBJECTNAME="estadorubro";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="estado_rubro";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadorubro from "+EstadoRubroConstantesFunciones.SPERSISTENCENAME+" estadorubro";
	public static String QUERYSELECTNATIVE="select "+EstadoRubroConstantesFunciones.SCHEMA+"."+EstadoRubroConstantesFunciones.TABLENAME+".id,"+EstadoRubroConstantesFunciones.SCHEMA+"."+EstadoRubroConstantesFunciones.TABLENAME+".version_row,"+EstadoRubroConstantesFunciones.SCHEMA+"."+EstadoRubroConstantesFunciones.TABLENAME+".codigo,"+EstadoRubroConstantesFunciones.SCHEMA+"."+EstadoRubroConstantesFunciones.TABLENAME+".nombre from "+EstadoRubroConstantesFunciones.SCHEMA+"."+EstadoRubroConstantesFunciones.TABLENAME;//+" as "+EstadoRubroConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoRubroConstantesFuncionesAdditional estadorubroConstantesFuncionesAdditional=null;
	
	public EstadoRubroConstantesFuncionesAdditional getEstadoRubroConstantesFuncionesAdditional() {
		return this.estadorubroConstantesFuncionesAdditional;
	}
	
	public void setEstadoRubroConstantesFuncionesAdditional(EstadoRubroConstantesFuncionesAdditional estadorubroConstantesFuncionesAdditional) {
		try {
			this.estadorubroConstantesFuncionesAdditional=estadorubroConstantesFuncionesAdditional;
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
	
	public static String getEstadoRubroLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoRubroConstantesFunciones.CODIGO)) {sLabelColumna=EstadoRubroConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoRubroConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoRubroConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getEstadoRubroDescripcion(EstadoRubro estadorubro) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadorubro !=null/* && estadorubro.getId()!=0*/) {
			sDescripcion=estadorubro.getcodigo();//estadorubroestadorubro.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoRubroDescripcionDetallado(EstadoRubro estadorubro) {
		String sDescripcion="";
			
		sDescripcion+=EstadoRubroConstantesFunciones.ID+"=";
		sDescripcion+=estadorubro.getId().toString()+",";
		sDescripcion+=EstadoRubroConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadorubro.getVersionRow().toString()+",";
		sDescripcion+=EstadoRubroConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadorubro.getcodigo()+",";
		sDescripcion+=EstadoRubroConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadorubro.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoRubroDescripcion(EstadoRubro estadorubro,String sValor) throws Exception {			
		if(estadorubro !=null) {
			estadorubro.setcodigo(sValor);;//estadorubroestadorubro.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosEstadoRubro(EstadoRubro estadorubro,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadorubro.setcodigo(estadorubro.getcodigo().trim());
		estadorubro.setnombre(estadorubro.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoRubros(List<EstadoRubro> estadorubros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoRubro estadorubro: estadorubros) {
			estadorubro.setcodigo(estadorubro.getcodigo().trim());
			estadorubro.setnombre(estadorubro.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoRubro(EstadoRubro estadorubro,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadorubro.getConCambioAuxiliar()) {
			estadorubro.setIsDeleted(estadorubro.getIsDeletedAuxiliar());	
			estadorubro.setIsNew(estadorubro.getIsNewAuxiliar());	
			estadorubro.setIsChanged(estadorubro.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadorubro.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadorubro.setIsDeletedAuxiliar(false);	
			estadorubro.setIsNewAuxiliar(false);	
			estadorubro.setIsChangedAuxiliar(false);
			
			estadorubro.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoRubros(List<EstadoRubro> estadorubros,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoRubro estadorubro : estadorubros) {
			if(conAsignarBase && estadorubro.getConCambioAuxiliar()) {
				estadorubro.setIsDeleted(estadorubro.getIsDeletedAuxiliar());	
				estadorubro.setIsNew(estadorubro.getIsNewAuxiliar());	
				estadorubro.setIsChanged(estadorubro.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadorubro.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadorubro.setIsDeletedAuxiliar(false);	
				estadorubro.setIsNewAuxiliar(false);	
				estadorubro.setIsChangedAuxiliar(false);
				
				estadorubro.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoRubro(EstadoRubro estadorubro,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoRubros(List<EstadoRubro> estadorubros,Boolean conEnteros) throws Exception  {
		
		for(EstadoRubro estadorubro: estadorubros) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoRubro(List<EstadoRubro> estadorubros,EstadoRubro estadorubroAux) throws Exception  {
		EstadoRubroConstantesFunciones.InicializarValoresEstadoRubro(estadorubroAux,true);
		
		for(EstadoRubro estadorubro: estadorubros) {
			if(estadorubro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoRubro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoRubroConstantesFunciones.getArrayColumnasGlobalesEstadoRubro(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoRubro(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoRubro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoRubro> estadorubros,EstadoRubro estadorubro,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoRubro estadorubroAux: estadorubros) {
			if(estadorubroAux!=null && estadorubro!=null) {
				if((estadorubroAux.getId()==null && estadorubro.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadorubroAux.getId()!=null && estadorubro.getId()!=null){
					if(estadorubroAux.getId().equals(estadorubro.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoRubro(List<EstadoRubro> estadorubros) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoRubro estadorubro: estadorubros) {			
			if(estadorubro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoRubro() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoRubroConstantesFunciones.LABEL_ID, EstadoRubroConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRubroConstantesFunciones.LABEL_VERSIONROW, EstadoRubroConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRubroConstantesFunciones.LABEL_CODIGO, EstadoRubroConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoRubroConstantesFunciones.LABEL_NOMBRE, EstadoRubroConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoRubro() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoRubroConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRubroConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRubroConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoRubroConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRubro() throws Exception  {
		return EstadoRubroConstantesFunciones.getTiposSeleccionarEstadoRubro(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRubro(Boolean conFk) throws Exception  {
		return EstadoRubroConstantesFunciones.getTiposSeleccionarEstadoRubro(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoRubro(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoRubroConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoRubroConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoRubroConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoRubroConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoRubro(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoRubro(EstadoRubro estadorubroAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoRubro(List<EstadoRubro> estadorubrosTemp) throws Exception {
		for(EstadoRubro estadorubroAux:estadorubrosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoRubro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoRubroConstantesFunciones.getClassesRelationshipsOfEstadoRubro(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(RubroEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmpleado.class)) {
						classes.add(new Classe(RubroEmpleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoRubro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoRubroConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoRubro(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoRubro(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(RubroEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(RubroEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmpleado.class)); continue;
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
	public static void actualizarLista(EstadoRubro estadorubro,List<EstadoRubro> estadorubros,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoRubro estadorubroEncontrado=null;
			
			for(EstadoRubro estadorubroLocal:estadorubros) {
				if(estadorubroLocal.getId().equals(estadorubro.getId())) {
					estadorubroEncontrado=estadorubroLocal;
					
					estadorubroLocal.setIsChanged(estadorubro.getIsChanged());
					estadorubroLocal.setIsNew(estadorubro.getIsNew());
					estadorubroLocal.setIsDeleted(estadorubro.getIsDeleted());
					
					estadorubroLocal.setGeneralEntityOriginal(estadorubro.getGeneralEntityOriginal());
					
					estadorubroLocal.setId(estadorubro.getId());	
					estadorubroLocal.setVersionRow(estadorubro.getVersionRow());	
					estadorubroLocal.setcodigo(estadorubro.getcodigo());	
					estadorubroLocal.setnombre(estadorubro.getnombre());	
					
					
					estadorubroLocal.setRubroEmpleados(estadorubro.getRubroEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!estadorubro.getIsDeleted()) {
				if(!existe) {
					estadorubros.add(estadorubro);
				}
			} else {
				if(estadorubroEncontrado!=null && permiteQuitar)  {
					estadorubros.remove(estadorubroEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoRubro estadorubro,List<EstadoRubro> estadorubros) throws Exception {
		try	{			
			for(EstadoRubro estadorubroLocal:estadorubros) {
				if(estadorubroLocal.getId().equals(estadorubro.getId())) {
					estadorubroLocal.setIsSelected(estadorubro.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoRubro(List<EstadoRubro> estadorubrosAux) throws Exception {
		//this.estadorubrosAux=estadorubrosAux;
		
		for(EstadoRubro estadorubroAux:estadorubrosAux) {
			if(estadorubroAux.getIsChanged()) {
				estadorubroAux.setIsChanged(false);
			}		
			
			if(estadorubroAux.getIsNew()) {
				estadorubroAux.setIsNew(false);
			}	
			
			if(estadorubroAux.getIsDeleted()) {
				estadorubroAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoRubro(EstadoRubro estadorubroAux) throws Exception {
		//this.estadorubroAux=estadorubroAux;
		
			if(estadorubroAux.getIsChanged()) {
				estadorubroAux.setIsChanged(false);
			}		
			
			if(estadorubroAux.getIsNew()) {
				estadorubroAux.setIsNew(false);
			}	
			
			if(estadorubroAux.getIsDeleted()) {
				estadorubroAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoRubro estadorubroAsignar,EstadoRubro estadorubro) throws Exception {
		estadorubroAsignar.setId(estadorubro.getId());	
		estadorubroAsignar.setVersionRow(estadorubro.getVersionRow());	
		estadorubroAsignar.setcodigo(estadorubro.getcodigo());	
		estadorubroAsignar.setnombre(estadorubro.getnombre());	
	}
	
	public static void inicializarEstadoRubro(EstadoRubro estadorubro) throws Exception {
		try {
				estadorubro.setId(0L);	
					
				estadorubro.setcodigo("");	
				estadorubro.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoRubro(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoRubroConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoRubroConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoRubro(String sTipo,Row row,Workbook workbook,EstadoRubro estadorubro,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadorubro.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadorubro.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoRubro=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoRubro() {
		return this.sFinalQueryEstadoRubro;
	}
	
	public void setsFinalQueryEstadoRubro(String sFinalQueryEstadoRubro) {
		this.sFinalQueryEstadoRubro= sFinalQueryEstadoRubro;
	}
	
	public Border resaltarSeleccionarEstadoRubro=null;
	
	public Border setResaltarSeleccionarEstadoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRubroBeanSwingJInternalFrame estadorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadorubroBeanSwingJInternalFrame.jTtoolBarEstadoRubro.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoRubro= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoRubro() {
		return this.resaltarSeleccionarEstadoRubro;
	}
	
	public void setResaltarSeleccionarEstadoRubro(Border borderResaltarSeleccionarEstadoRubro) {
		this.resaltarSeleccionarEstadoRubro= borderResaltarSeleccionarEstadoRubro;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoRubro=null;
	public Boolean mostraridEstadoRubro=true;
	public Boolean activaridEstadoRubro=true;

	public Border resaltarcodigoEstadoRubro=null;
	public Boolean mostrarcodigoEstadoRubro=true;
	public Boolean activarcodigoEstadoRubro=true;

	public Border resaltarnombreEstadoRubro=null;
	public Boolean mostrarnombreEstadoRubro=true;
	public Boolean activarnombreEstadoRubro=true;

	
	

	public Border setResaltaridEstadoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRubroBeanSwingJInternalFrame estadorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadorubroBeanSwingJInternalFrame.jTtoolBarEstadoRubro.setBorder(borderResaltar);
		
		this.resaltaridEstadoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoRubro() {
		return this.resaltaridEstadoRubro;
	}

	public void setResaltaridEstadoRubro(Border borderResaltar) {
		this.resaltaridEstadoRubro= borderResaltar;
	}

	public Boolean getMostraridEstadoRubro() {
		return this.mostraridEstadoRubro;
	}

	public void setMostraridEstadoRubro(Boolean mostraridEstadoRubro) {
		this.mostraridEstadoRubro= mostraridEstadoRubro;
	}

	public Boolean getActivaridEstadoRubro() {
		return this.activaridEstadoRubro;
	}

	public void setActivaridEstadoRubro(Boolean activaridEstadoRubro) {
		this.activaridEstadoRubro= activaridEstadoRubro;
	}

	public Border setResaltarcodigoEstadoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRubroBeanSwingJInternalFrame estadorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadorubroBeanSwingJInternalFrame.jTtoolBarEstadoRubro.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoRubro() {
		return this.resaltarcodigoEstadoRubro;
	}

	public void setResaltarcodigoEstadoRubro(Border borderResaltar) {
		this.resaltarcodigoEstadoRubro= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoRubro() {
		return this.mostrarcodigoEstadoRubro;
	}

	public void setMostrarcodigoEstadoRubro(Boolean mostrarcodigoEstadoRubro) {
		this.mostrarcodigoEstadoRubro= mostrarcodigoEstadoRubro;
	}

	public Boolean getActivarcodigoEstadoRubro() {
		return this.activarcodigoEstadoRubro;
	}

	public void setActivarcodigoEstadoRubro(Boolean activarcodigoEstadoRubro) {
		this.activarcodigoEstadoRubro= activarcodigoEstadoRubro;
	}

	public Border setResaltarnombreEstadoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRubroBeanSwingJInternalFrame estadorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadorubroBeanSwingJInternalFrame.jTtoolBarEstadoRubro.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoRubro() {
		return this.resaltarnombreEstadoRubro;
	}

	public void setResaltarnombreEstadoRubro(Border borderResaltar) {
		this.resaltarnombreEstadoRubro= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoRubro() {
		return this.mostrarnombreEstadoRubro;
	}

	public void setMostrarnombreEstadoRubro(Boolean mostrarnombreEstadoRubro) {
		this.mostrarnombreEstadoRubro= mostrarnombreEstadoRubro;
	}

	public Boolean getActivarnombreEstadoRubro() {
		return this.activarnombreEstadoRubro;
	}

	public void setActivarnombreEstadoRubro(Boolean activarnombreEstadoRubro) {
		this.activarnombreEstadoRubro= activarnombreEstadoRubro;
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
		
		
		this.setMostraridEstadoRubro(esInicial);
		this.setMostrarcodigoEstadoRubro(esInicial);
		this.setMostrarnombreEstadoRubro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRubroConstantesFunciones.ID)) {
				this.setMostraridEstadoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRubroConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRubroConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoRubro(esAsigna);
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
		
		
		this.setActivaridEstadoRubro(esInicial);
		this.setActivarcodigoEstadoRubro(esInicial);
		this.setActivarnombreEstadoRubro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRubroConstantesFunciones.ID)) {
				this.setActivaridEstadoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRubroConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRubroConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoRubro(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoRubroBeanSwingJInternalFrame estadorubroBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoRubro(esInicial);
		this.setResaltarcodigoEstadoRubro(esInicial);
		this.setResaltarnombreEstadoRubro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoRubroConstantesFunciones.ID)) {
				this.setResaltaridEstadoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRubroConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoRubroConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoRubro(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarRubroEmpleadoEstadoRubro=null;

	public Border getResaltarRubroEmpleadoEstadoRubro() {
		return this.resaltarRubroEmpleadoEstadoRubro;
	}

	public void setResaltarRubroEmpleadoEstadoRubro(Border borderResaltarRubroEmpleado) {
		if(borderResaltarRubroEmpleado!=null) {
			this.resaltarRubroEmpleadoEstadoRubro= borderResaltarRubroEmpleado;
		}
	}

	public Border setResaltarRubroEmpleadoEstadoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoRubroBeanSwingJInternalFrame estadorubroBeanSwingJInternalFrame*/) {
		Border borderResaltarRubroEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadorubroBeanSwingJInternalFrame.jTtoolBarEstadoRubro.setBorder(borderResaltarRubroEmpleado);
			
		this.resaltarRubroEmpleadoEstadoRubro= borderResaltarRubroEmpleado;

		 return borderResaltarRubroEmpleado;
	}



	public Boolean mostrarRubroEmpleadoEstadoRubro=true;

	public Boolean getMostrarRubroEmpleadoEstadoRubro() {
		return this.mostrarRubroEmpleadoEstadoRubro;
	}

	public void setMostrarRubroEmpleadoEstadoRubro(Boolean visibilidadResaltarRubroEmpleado) {
		this.mostrarRubroEmpleadoEstadoRubro= visibilidadResaltarRubroEmpleado;
	}



	public Boolean activarRubroEmpleadoEstadoRubro=true;

	public Boolean gethabilitarResaltarRubroEmpleadoEstadoRubro() {
		return this.activarRubroEmpleadoEstadoRubro;
	}

	public void setActivarRubroEmpleadoEstadoRubro(Boolean habilitarResaltarRubroEmpleado) {
		this.activarRubroEmpleadoEstadoRubro= habilitarResaltarRubroEmpleado;
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

		this.setMostrarRubroEmpleadoEstadoRubro(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RubroEmpleado.class)) {
				this.setMostrarRubroEmpleadoEstadoRubro(esAsigna);
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

		this.setActivarRubroEmpleadoEstadoRubro(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RubroEmpleado.class)) {
				this.setActivarRubroEmpleadoEstadoRubro(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoRubroBeanSwingJInternalFrame estadorubroBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarRubroEmpleadoEstadoRubro(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RubroEmpleado.class)) {
				this.setResaltarRubroEmpleadoEstadoRubro(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}