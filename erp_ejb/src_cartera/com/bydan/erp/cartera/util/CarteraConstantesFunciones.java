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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.CarteraConstantesFunciones;
import com.bydan.erp.cartera.util.CarteraParameterReturnGeneral;
//import com.bydan.erp.cartera.util.CarteraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.cartera.util.report.*;
import com.bydan.erp.cartera.business.entity.report.*;
import com.bydan.erp.cartera.util.CarteraSql;
import com.bydan.erp.cartera.util.CarteraSqlReporte;


@SuppressWarnings("unused")
final public class CarteraConstantesFunciones extends CarteraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Cartera";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Cartera"+CarteraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CarteraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CarteraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CarteraConstantesFunciones.SCHEMA+"_"+CarteraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CarteraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CarteraConstantesFunciones.SCHEMA+"_"+CarteraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CarteraConstantesFunciones.SCHEMA+"_"+CarteraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CarteraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CarteraConstantesFunciones.SCHEMA+"_"+CarteraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CarteraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CarteraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CarteraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CarteraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CarteraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CarteraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CarteraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CarteraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CarteraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CarteraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Carteras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cartera";
	public static final String SCLASSWEBTITULO_LOWER="Cartera";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Cartera";
	public static final String OBJECTNAME="cartera";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cartera";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cartera from "+CarteraConstantesFunciones.SPERSISTENCENAME+" cartera";
	public static String QUERYSELECTNATIVE="select "+CarteraConstantesFunciones.SCHEMA+"."+CarteraConstantesFunciones.TABLENAME+".id,"+CarteraConstantesFunciones.SCHEMA+"."+CarteraConstantesFunciones.TABLENAME+".version_row,"+CarteraConstantesFunciones.SCHEMA+"."+CarteraConstantesFunciones.TABLENAME+".codigo from "+CarteraConstantesFunciones.SCHEMA+"."+CarteraConstantesFunciones.TABLENAME;//+" as "+CarteraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CarteraConstantesFuncionesAdditional carteraConstantesFuncionesAdditional=null;
	
	public CarteraConstantesFuncionesAdditional getCarteraConstantesFuncionesAdditional() {
		return this.carteraConstantesFuncionesAdditional;
	}
	
	public void setCarteraConstantesFuncionesAdditional(CarteraConstantesFuncionesAdditional carteraConstantesFuncionesAdditional) {
		try {
			this.carteraConstantesFuncionesAdditional=carteraConstantesFuncionesAdditional;
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
	
	public static String getCarteraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CarteraConstantesFunciones.CODIGO)) {sLabelColumna=CarteraConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
	
	public static String getCarteraDescripcion(Cartera cartera) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cartera !=null/* && cartera.getId()!=0*/) {
			sDescripcion=cartera.getcodigo();//carteracartera.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCarteraDescripcionDetallado(Cartera cartera) {
		String sDescripcion="";
			
		sDescripcion+=CarteraConstantesFunciones.ID+"=";
		sDescripcion+=cartera.getId().toString()+",";
		sDescripcion+=CarteraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cartera.getVersionRow().toString()+",";
		sDescripcion+=CarteraConstantesFunciones.CODIGO+"=";
		sDescripcion+=cartera.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setCarteraDescripcion(Cartera cartera,String sValor) throws Exception {			
		if(cartera !=null) {
			cartera.setcodigo(sValor);;//carteracartera.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosCartera(Cartera cartera,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cartera.setcodigo(cartera.getcodigo().trim());
	}
	
	public static void quitarEspaciosCarteras(List<Cartera> carteras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Cartera cartera: carteras) {
			cartera.setcodigo(cartera.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCartera(Cartera cartera,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cartera.getConCambioAuxiliar()) {
			cartera.setIsDeleted(cartera.getIsDeletedAuxiliar());	
			cartera.setIsNew(cartera.getIsNewAuxiliar());	
			cartera.setIsChanged(cartera.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cartera.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cartera.setIsDeletedAuxiliar(false);	
			cartera.setIsNewAuxiliar(false);	
			cartera.setIsChangedAuxiliar(false);
			
			cartera.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCarteras(List<Cartera> carteras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Cartera cartera : carteras) {
			if(conAsignarBase && cartera.getConCambioAuxiliar()) {
				cartera.setIsDeleted(cartera.getIsDeletedAuxiliar());	
				cartera.setIsNew(cartera.getIsNewAuxiliar());	
				cartera.setIsChanged(cartera.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cartera.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cartera.setIsDeletedAuxiliar(false);	
				cartera.setIsNewAuxiliar(false);	
				cartera.setIsChangedAuxiliar(false);
				
				cartera.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCartera(Cartera cartera,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCarteras(List<Cartera> carteras,Boolean conEnteros) throws Exception  {
		
		for(Cartera cartera: carteras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCartera(List<Cartera> carteras,Cartera carteraAux) throws Exception  {
		CarteraConstantesFunciones.InicializarValoresCartera(carteraAux,true);
		
		for(Cartera cartera: carteras) {
			if(cartera.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCartera(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CarteraConstantesFunciones.getArrayColumnasGlobalesCartera(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCartera(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCartera(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Cartera> carteras,Cartera cartera,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Cartera carteraAux: carteras) {
			if(carteraAux!=null && cartera!=null) {
				if((carteraAux.getId()==null && cartera.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(carteraAux.getId()!=null && cartera.getId()!=null){
					if(carteraAux.getId().equals(cartera.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCartera(List<Cartera> carteras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Cartera cartera: carteras) {			
			if(cartera.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCartera() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCartera() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCartera() throws Exception  {
		return CarteraConstantesFunciones.getTiposSeleccionarCartera(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCartera(Boolean conFk) throws Exception  {
		return CarteraConstantesFunciones.getTiposSeleccionarCartera(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCartera(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CarteraConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CarteraConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCartera(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCartera(Cartera carteraAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesCartera(List<Cartera> carterasTemp) throws Exception {
		for(Cartera carteraAux:carterasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCartera(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCartera(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCartera(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CarteraConstantesFunciones.getClassesRelationshipsOfCartera(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCartera(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCartera(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CarteraConstantesFunciones.getClassesRelationshipsFromStringsOfCartera(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCartera(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Cartera cartera,List<Cartera> carteras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Cartera carteraEncontrado=null;
			
			for(Cartera carteraLocal:carteras) {
				if(carteraLocal.getId().equals(cartera.getId())) {
					carteraEncontrado=carteraLocal;
					
					carteraLocal.setIsChanged(cartera.getIsChanged());
					carteraLocal.setIsNew(cartera.getIsNew());
					carteraLocal.setIsDeleted(cartera.getIsDeleted());
					
					carteraLocal.setGeneralEntityOriginal(cartera.getGeneralEntityOriginal());
					
					carteraLocal.setId(cartera.getId());	
					carteraLocal.setVersionRow(cartera.getVersionRow());	
					carteraLocal.setcodigo(cartera.getcodigo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cartera.getIsDeleted()) {
				if(!existe) {
					carteras.add(cartera);
				}
			} else {
				if(carteraEncontrado!=null && permiteQuitar)  {
					carteras.remove(carteraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Cartera cartera,List<Cartera> carteras) throws Exception {
		try	{			
			for(Cartera carteraLocal:carteras) {
				if(carteraLocal.getId().equals(cartera.getId())) {
					carteraLocal.setIsSelected(cartera.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCartera(List<Cartera> carterasAux) throws Exception {
		//this.carterasAux=carterasAux;
		
		for(Cartera carteraAux:carterasAux) {
			if(carteraAux.getIsChanged()) {
				carteraAux.setIsChanged(false);
			}		
			
			if(carteraAux.getIsNew()) {
				carteraAux.setIsNew(false);
			}	
			
			if(carteraAux.getIsDeleted()) {
				carteraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCartera(Cartera carteraAux) throws Exception {
		//this.carteraAux=carteraAux;
		
			if(carteraAux.getIsChanged()) {
				carteraAux.setIsChanged(false);
			}		
			
			if(carteraAux.getIsNew()) {
				carteraAux.setIsNew(false);
			}	
			
			if(carteraAux.getIsDeleted()) {
				carteraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Cartera carteraAsignar,Cartera cartera) throws Exception {
		carteraAsignar.setId(cartera.getId());	
		carteraAsignar.setVersionRow(cartera.getVersionRow());	
		carteraAsignar.setcodigo(cartera.getcodigo());	
	}
	
	public static void inicializarCartera(Cartera cartera) throws Exception {
		try {
				cartera.setId(0L);	
					
				cartera.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCartera(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CarteraConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCartera(String sTipo,Row row,Workbook workbook,Cartera cartera,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cartera.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCartera=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCartera() {
		return this.sFinalQueryCartera;
	}
	
	public void setsFinalQueryCartera(String sFinalQueryCartera) {
		this.sFinalQueryCartera= sFinalQueryCartera;
	}
	
	public Border resaltarSeleccionarCartera=null;
	
	public Border setResaltarSeleccionarCartera(ParametroGeneralUsuario parametroGeneralUsuario/*CarteraBeanSwingJInternalFrame carteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//carteraBeanSwingJInternalFrame.jTtoolBarCartera.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCartera= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCartera() {
		return this.resaltarSeleccionarCartera;
	}
	
	public void setResaltarSeleccionarCartera(Border borderResaltarSeleccionarCartera) {
		this.resaltarSeleccionarCartera= borderResaltarSeleccionarCartera;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCartera=null;
	public Boolean mostraridCartera=true;
	public Boolean activaridCartera=true;

	public Border resaltarcodigoCartera=null;
	public Boolean mostrarcodigoCartera=true;
	public Boolean activarcodigoCartera=true;

	
	

	public Border setResaltaridCartera(ParametroGeneralUsuario parametroGeneralUsuario/*CarteraBeanSwingJInternalFrame carteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//carteraBeanSwingJInternalFrame.jTtoolBarCartera.setBorder(borderResaltar);
		
		this.resaltaridCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCartera() {
		return this.resaltaridCartera;
	}

	public void setResaltaridCartera(Border borderResaltar) {
		this.resaltaridCartera= borderResaltar;
	}

	public Boolean getMostraridCartera() {
		return this.mostraridCartera;
	}

	public void setMostraridCartera(Boolean mostraridCartera) {
		this.mostraridCartera= mostraridCartera;
	}

	public Boolean getActivaridCartera() {
		return this.activaridCartera;
	}

	public void setActivaridCartera(Boolean activaridCartera) {
		this.activaridCartera= activaridCartera;
	}

	public Border setResaltarcodigoCartera(ParametroGeneralUsuario parametroGeneralUsuario/*CarteraBeanSwingJInternalFrame carteraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//carteraBeanSwingJInternalFrame.jTtoolBarCartera.setBorder(borderResaltar);
		
		this.resaltarcodigoCartera= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCartera() {
		return this.resaltarcodigoCartera;
	}

	public void setResaltarcodigoCartera(Border borderResaltar) {
		this.resaltarcodigoCartera= borderResaltar;
	}

	public Boolean getMostrarcodigoCartera() {
		return this.mostrarcodigoCartera;
	}

	public void setMostrarcodigoCartera(Boolean mostrarcodigoCartera) {
		this.mostrarcodigoCartera= mostrarcodigoCartera;
	}

	public Boolean getActivarcodigoCartera() {
		return this.activarcodigoCartera;
	}

	public void setActivarcodigoCartera(Boolean activarcodigoCartera) {
		this.activarcodigoCartera= activarcodigoCartera;
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
		
		
		this.setMostraridCartera(esInicial);
		this.setMostrarcodigoCartera(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CarteraConstantesFunciones.ID)) {
				this.setMostraridCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(CarteraConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCartera(esAsigna);
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
		
		
		this.setActivaridCartera(esInicial);
		this.setActivarcodigoCartera(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CarteraConstantesFunciones.ID)) {
				this.setActivaridCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(CarteraConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCartera(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CarteraBeanSwingJInternalFrame carteraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCartera(esInicial);
		this.setResaltarcodigoCartera(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CarteraConstantesFunciones.ID)) {
				this.setResaltaridCartera(esAsigna);
				continue;
			}

			if(campo.clase.equals(CarteraConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCartera(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CarteraBeanSwingJInternalFrame carteraBeanSwingJInternalFrame*/)throws Exception {	
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