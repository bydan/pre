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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.InventarioConstantesFunciones;
import com.bydan.erp.inventario.util.InventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.InventarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.inventario.util.report.*;
import com.bydan.erp.inventario.business.entity.report.*;
import com.bydan.erp.inventario.util.InventarioSql;
import com.bydan.erp.inventario.util.InventarioSqlReporte;


@SuppressWarnings("unused")
final public class InventarioConstantesFunciones extends InventarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Inventario";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Inventario"+InventarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="InventarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="InventarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=InventarioConstantesFunciones.SCHEMA+"_"+InventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/InventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=InventarioConstantesFunciones.SCHEMA+"_"+InventarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=InventarioConstantesFunciones.SCHEMA+"_"+InventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/InventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=InventarioConstantesFunciones.SCHEMA+"_"+InventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/InventarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InventarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/InventarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InventarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=InventarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+InventarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=InventarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+InventarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Inventarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Inventario";
	public static final String SCLASSWEBTITULO_LOWER="Inventario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Inventario";
	public static final String OBJECTNAME="inventario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="inventario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select inventario from "+InventarioConstantesFunciones.SPERSISTENCENAME+" inventario";
	public static String QUERYSELECTNATIVE="select "+InventarioConstantesFunciones.SCHEMA+"."+InventarioConstantesFunciones.TABLENAME+".id,"+InventarioConstantesFunciones.SCHEMA+"."+InventarioConstantesFunciones.TABLENAME+".version_row,"+InventarioConstantesFunciones.SCHEMA+"."+InventarioConstantesFunciones.TABLENAME+".codigo from "+InventarioConstantesFunciones.SCHEMA+"."+InventarioConstantesFunciones.TABLENAME;//+" as "+InventarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected InventarioConstantesFuncionesAdditional inventarioConstantesFuncionesAdditional=null;
	
	public InventarioConstantesFuncionesAdditional getInventarioConstantesFuncionesAdditional() {
		return this.inventarioConstantesFuncionesAdditional;
	}
	
	public void setInventarioConstantesFuncionesAdditional(InventarioConstantesFuncionesAdditional inventarioConstantesFuncionesAdditional) {
		try {
			this.inventarioConstantesFuncionesAdditional=inventarioConstantesFuncionesAdditional;
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
	
	public static String getInventarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(InventarioConstantesFunciones.CODIGO)) {sLabelColumna=InventarioConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getInventarioDescripcion(Inventario inventario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(inventario !=null/* && inventario.getId()!=0*/) {
			sDescripcion=inventario.getcodigo();//inventarioinventario.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getInventarioDescripcionDetallado(Inventario inventario) {
		String sDescripcion="";
			
		sDescripcion+=InventarioConstantesFunciones.ID+"=";
		sDescripcion+=inventario.getId().toString()+",";
		sDescripcion+=InventarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=inventario.getVersionRow().toString()+",";
		sDescripcion+=InventarioConstantesFunciones.CODIGO+"=";
		sDescripcion+=inventario.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setInventarioDescripcion(Inventario inventario,String sValor) throws Exception {			
		if(inventario !=null) {
			inventario.setcodigo(sValor);;//inventarioinventario.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosInventario(Inventario inventario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		inventario.setcodigo(inventario.getcodigo().trim());
	}
	
	public static void quitarEspaciosInventarios(List<Inventario> inventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Inventario inventario: inventarios) {
			inventario.setcodigo(inventario.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresInventario(Inventario inventario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && inventario.getConCambioAuxiliar()) {
			inventario.setIsDeleted(inventario.getIsDeletedAuxiliar());	
			inventario.setIsNew(inventario.getIsNewAuxiliar());	
			inventario.setIsChanged(inventario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			inventario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			inventario.setIsDeletedAuxiliar(false);	
			inventario.setIsNewAuxiliar(false);	
			inventario.setIsChangedAuxiliar(false);
			
			inventario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresInventarios(List<Inventario> inventarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Inventario inventario : inventarios) {
			if(conAsignarBase && inventario.getConCambioAuxiliar()) {
				inventario.setIsDeleted(inventario.getIsDeletedAuxiliar());	
				inventario.setIsNew(inventario.getIsNewAuxiliar());	
				inventario.setIsChanged(inventario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				inventario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				inventario.setIsDeletedAuxiliar(false);	
				inventario.setIsNewAuxiliar(false);	
				inventario.setIsChangedAuxiliar(false);
				
				inventario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresInventario(Inventario inventario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresInventarios(List<Inventario> inventarios,Boolean conEnteros) throws Exception  {
		
		for(Inventario inventario: inventarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaInventario(List<Inventario> inventarios,Inventario inventarioAux) throws Exception  {
		InventarioConstantesFunciones.InicializarValoresInventario(inventarioAux,true);
		
		for(Inventario inventario: inventarios) {
			if(inventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=InventarioConstantesFunciones.getArrayColumnasGlobalesInventario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesInventario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Inventario> inventarios,Inventario inventario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Inventario inventarioAux: inventarios) {
			if(inventarioAux!=null && inventario!=null) {
				if((inventarioAux.getId()==null && inventario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(inventarioAux.getId()!=null && inventario.getId()!=null){
					if(inventarioAux.getId().equals(inventario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaInventario(List<Inventario> inventarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Inventario inventario: inventarios) {			
			if(inventario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaInventario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasInventario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInventario() throws Exception  {
		return InventarioConstantesFunciones.getTiposSeleccionarInventario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInventario(Boolean conFk) throws Exception  {
		return InventarioConstantesFunciones.getTiposSeleccionarInventario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInventario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InventarioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(InventarioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesInventario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesInventario(Inventario inventarioAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesInventario(List<Inventario> inventariosTemp) throws Exception {
		for(Inventario inventarioAux:inventariosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return InventarioConstantesFunciones.getClassesRelationshipsOfInventario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfInventario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return InventarioConstantesFunciones.getClassesRelationshipsFromStringsOfInventario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfInventario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Inventario inventario,List<Inventario> inventarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Inventario inventarioEncontrado=null;
			
			for(Inventario inventarioLocal:inventarios) {
				if(inventarioLocal.getId().equals(inventario.getId())) {
					inventarioEncontrado=inventarioLocal;
					
					inventarioLocal.setIsChanged(inventario.getIsChanged());
					inventarioLocal.setIsNew(inventario.getIsNew());
					inventarioLocal.setIsDeleted(inventario.getIsDeleted());
					
					inventarioLocal.setGeneralEntityOriginal(inventario.getGeneralEntityOriginal());
					
					inventarioLocal.setId(inventario.getId());	
					inventarioLocal.setVersionRow(inventario.getVersionRow());	
					inventarioLocal.setcodigo(inventario.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!inventario.getIsDeleted()) {
				if(!existe) {
					inventarios.add(inventario);
				}
			} else {
				if(inventarioEncontrado!=null && permiteQuitar)  {
					inventarios.remove(inventarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Inventario inventario,List<Inventario> inventarios) throws Exception {
		try	{			
			for(Inventario inventarioLocal:inventarios) {
				if(inventarioLocal.getId().equals(inventario.getId())) {
					inventarioLocal.setIsSelected(inventario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesInventario(List<Inventario> inventariosAux) throws Exception {
		//this.inventariosAux=inventariosAux;
		
		for(Inventario inventarioAux:inventariosAux) {
			if(inventarioAux.getIsChanged()) {
				inventarioAux.setIsChanged(false);
			}		
			
			if(inventarioAux.getIsNew()) {
				inventarioAux.setIsNew(false);
			}	
			
			if(inventarioAux.getIsDeleted()) {
				inventarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesInventario(Inventario inventarioAux) throws Exception {
		//this.inventarioAux=inventarioAux;
		
			if(inventarioAux.getIsChanged()) {
				inventarioAux.setIsChanged(false);
			}		
			
			if(inventarioAux.getIsNew()) {
				inventarioAux.setIsNew(false);
			}	
			
			if(inventarioAux.getIsDeleted()) {
				inventarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Inventario inventarioAsignar,Inventario inventario) throws Exception {
		inventarioAsignar.setId(inventario.getId());	
		inventarioAsignar.setVersionRow(inventario.getVersionRow());	
		inventarioAsignar.setcodigo(inventario.getcodigo());	
	}
	
	public static void inicializarInventario(Inventario inventario) throws Exception {
		try {
				inventario.setId(0L);	
					
				inventario.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderInventario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(InventarioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataInventario(String sTipo,Row row,Workbook workbook,Inventario inventario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(inventario.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryInventario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryInventario() {
		return this.sFinalQueryInventario;
	}
	
	public void setsFinalQueryInventario(String sFinalQueryInventario) {
		this.sFinalQueryInventario= sFinalQueryInventario;
	}
	
	public Border resaltarSeleccionarInventario=null;
	
	public Border setResaltarSeleccionarInventario(ParametroGeneralUsuario parametroGeneralUsuario/*InventarioBeanSwingJInternalFrame inventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//inventarioBeanSwingJInternalFrame.jTtoolBarInventario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarInventario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarInventario() {
		return this.resaltarSeleccionarInventario;
	}
	
	public void setResaltarSeleccionarInventario(Border borderResaltarSeleccionarInventario) {
		this.resaltarSeleccionarInventario= borderResaltarSeleccionarInventario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridInventario=null;
	public Boolean mostraridInventario=true;
	public Boolean activaridInventario=true;

	public Border resaltarcodigoInventario=null;
	public Boolean mostrarcodigoInventario=true;
	public Boolean activarcodigoInventario=true;

	
	

	public Border setResaltaridInventario(ParametroGeneralUsuario parametroGeneralUsuario/*InventarioBeanSwingJInternalFrame inventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//inventarioBeanSwingJInternalFrame.jTtoolBarInventario.setBorder(borderResaltar);
		
		this.resaltaridInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridInventario() {
		return this.resaltaridInventario;
	}

	public void setResaltaridInventario(Border borderResaltar) {
		this.resaltaridInventario= borderResaltar;
	}

	public Boolean getMostraridInventario() {
		return this.mostraridInventario;
	}

	public void setMostraridInventario(Boolean mostraridInventario) {
		this.mostraridInventario= mostraridInventario;
	}

	public Boolean getActivaridInventario() {
		return this.activaridInventario;
	}

	public void setActivaridInventario(Boolean activaridInventario) {
		this.activaridInventario= activaridInventario;
	}

	public Border setResaltarcodigoInventario(ParametroGeneralUsuario parametroGeneralUsuario/*InventarioBeanSwingJInternalFrame inventarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//inventarioBeanSwingJInternalFrame.jTtoolBarInventario.setBorder(borderResaltar);
		
		this.resaltarcodigoInventario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoInventario() {
		return this.resaltarcodigoInventario;
	}

	public void setResaltarcodigoInventario(Border borderResaltar) {
		this.resaltarcodigoInventario= borderResaltar;
	}

	public Boolean getMostrarcodigoInventario() {
		return this.mostrarcodigoInventario;
	}

	public void setMostrarcodigoInventario(Boolean mostrarcodigoInventario) {
		this.mostrarcodigoInventario= mostrarcodigoInventario;
	}

	public Boolean getActivarcodigoInventario() {
		return this.activarcodigoInventario;
	}

	public void setActivarcodigoInventario(Boolean activarcodigoInventario) {
		this.activarcodigoInventario= activarcodigoInventario;
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
		
		
		this.setMostraridInventario(esInicial);
		this.setMostrarcodigoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InventarioConstantesFunciones.ID)) {
				this.setMostraridInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(InventarioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoInventario(esAsigna);
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
		
		
		this.setActivaridInventario(esInicial);
		this.setActivarcodigoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InventarioConstantesFunciones.ID)) {
				this.setActivaridInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(InventarioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoInventario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,InventarioBeanSwingJInternalFrame inventarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridInventario(esInicial);
		this.setResaltarcodigoInventario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InventarioConstantesFunciones.ID)) {
				this.setResaltaridInventario(esAsigna);
				continue;
			}

			if(campo.clase.equals(InventarioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoInventario(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,InventarioBeanSwingJInternalFrame inventarioBeanSwingJInternalFrame*/)throws Exception {	
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