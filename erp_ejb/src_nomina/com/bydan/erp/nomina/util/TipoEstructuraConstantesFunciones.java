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


import com.bydan.erp.nomina.util.TipoEstructuraConstantesFunciones;
import com.bydan.erp.nomina.util.TipoEstructuraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoEstructuraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoEstructuraConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoEstructura";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoEstructura"+TipoEstructuraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoEstructuraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoEstructuraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoEstructuraConstantesFunciones.SCHEMA+"_"+TipoEstructuraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoEstructuraConstantesFunciones.SCHEMA+"_"+TipoEstructuraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoEstructuraConstantesFunciones.SCHEMA+"_"+TipoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoEstructuraConstantesFunciones.SCHEMA+"_"+TipoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoEstructuraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoEstructuraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoEstructuraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoEstructuraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Estructuras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Estructura";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Estructura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoEstructura";
	public static final String OBJECTNAME="tipoestructura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_estructura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoestructura from "+TipoEstructuraConstantesFunciones.SPERSISTENCENAME+" tipoestructura";
	public static String QUERYSELECTNATIVE="select "+TipoEstructuraConstantesFunciones.SCHEMA+"."+TipoEstructuraConstantesFunciones.TABLENAME+".id,"+TipoEstructuraConstantesFunciones.SCHEMA+"."+TipoEstructuraConstantesFunciones.TABLENAME+".version_row,"+TipoEstructuraConstantesFunciones.SCHEMA+"."+TipoEstructuraConstantesFunciones.TABLENAME+".codigo,"+TipoEstructuraConstantesFunciones.SCHEMA+"."+TipoEstructuraConstantesFunciones.TABLENAME+".nombre from "+TipoEstructuraConstantesFunciones.SCHEMA+"."+TipoEstructuraConstantesFunciones.TABLENAME;//+" as "+TipoEstructuraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
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
	
	public static String getTipoEstructuraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoEstructuraConstantesFunciones.CODIGO)) {sLabelColumna=TipoEstructuraConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoEstructuraConstantesFunciones.NOMBRE)) {sLabelColumna=TipoEstructuraConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoEstructuraDescripcion(TipoEstructura tipoestructura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoestructura !=null/* && tipoestructura.getId()!=0*/) {
			sDescripcion=tipoestructura.getcodigo();//tipoestructuratipoestructura.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoEstructuraDescripcionDetallado(TipoEstructura tipoestructura) {
		String sDescripcion="";
			
		sDescripcion+=TipoEstructuraConstantesFunciones.ID+"=";
		sDescripcion+=tipoestructura.getId().toString()+",";
		sDescripcion+=TipoEstructuraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoestructura.getVersionRow().toString()+",";
		sDescripcion+=TipoEstructuraConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoestructura.getcodigo()+",";
		sDescripcion+=TipoEstructuraConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoestructura.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoEstructuraDescripcion(TipoEstructura tipoestructura,String sValor) throws Exception {			
		if(tipoestructura !=null) {
			tipoestructura.setcodigo(sValor);;//tipoestructuratipoestructura.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoEstructura(TipoEstructura tipoestructura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoestructura.setcodigo(tipoestructura.getcodigo().trim());
		tipoestructura.setnombre(tipoestructura.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoEstructuras(List<TipoEstructura> tipoestructuras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoEstructura tipoestructura: tipoestructuras) {
			tipoestructura.setcodigo(tipoestructura.getcodigo().trim());
			tipoestructura.setnombre(tipoestructura.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEstructura(TipoEstructura tipoestructura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoestructura.getConCambioAuxiliar()) {
			tipoestructura.setIsDeleted(tipoestructura.getIsDeletedAuxiliar());	
			tipoestructura.setIsNew(tipoestructura.getIsNewAuxiliar());	
			tipoestructura.setIsChanged(tipoestructura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoestructura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoestructura.setIsDeletedAuxiliar(false);	
			tipoestructura.setIsNewAuxiliar(false);	
			tipoestructura.setIsChangedAuxiliar(false);
			
			tipoestructura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEstructuras(List<TipoEstructura> tipoestructuras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoEstructura tipoestructura : tipoestructuras) {
			if(conAsignarBase && tipoestructura.getConCambioAuxiliar()) {
				tipoestructura.setIsDeleted(tipoestructura.getIsDeletedAuxiliar());	
				tipoestructura.setIsNew(tipoestructura.getIsNewAuxiliar());	
				tipoestructura.setIsChanged(tipoestructura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoestructura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoestructura.setIsDeletedAuxiliar(false);	
				tipoestructura.setIsNewAuxiliar(false);	
				tipoestructura.setIsChangedAuxiliar(false);
				
				tipoestructura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoEstructura(TipoEstructura tipoestructura,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoEstructuras(List<TipoEstructura> tipoestructuras,Boolean conEnteros) throws Exception  {
		
		for(TipoEstructura tipoestructura: tipoestructuras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoEstructura(List<TipoEstructura> tipoestructuras,TipoEstructura tipoestructuraAux) throws Exception  {
		TipoEstructuraConstantesFunciones.InicializarValoresTipoEstructura(tipoestructuraAux,true);
		
		for(TipoEstructura tipoestructura: tipoestructuras) {
			if(tipoestructura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoEstructuraConstantesFunciones.getArrayColumnasGlobalesTipoEstructura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEstructura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoEstructura> tipoestructuras,TipoEstructura tipoestructura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoEstructura tipoestructuraAux: tipoestructuras) {
			if(tipoestructuraAux!=null && tipoestructura!=null) {
				if((tipoestructuraAux.getId()==null && tipoestructura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoestructuraAux.getId()!=null && tipoestructura.getId()!=null){
					if(tipoestructuraAux.getId().equals(tipoestructura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoEstructura(List<TipoEstructura> tipoestructuras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoEstructura tipoestructura: tipoestructuras) {			
			if(tipoestructura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoEstructura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoEstructuraConstantesFunciones.LABEL_ID, TipoEstructuraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEstructuraConstantesFunciones.LABEL_VERSIONROW, TipoEstructuraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEstructuraConstantesFunciones.LABEL_CODIGO, TipoEstructuraConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEstructuraConstantesFunciones.LABEL_NOMBRE, TipoEstructuraConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoEstructura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoEstructuraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEstructuraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEstructuraConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEstructuraConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEstructura() throws Exception  {
		return TipoEstructuraConstantesFunciones.getTiposSeleccionarTipoEstructura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEstructura(Boolean conFk) throws Exception  {
		return TipoEstructuraConstantesFunciones.getTiposSeleccionarTipoEstructura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEstructura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEstructuraConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoEstructuraConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEstructuraConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoEstructuraConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoEstructura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEstructura(TipoEstructura tipoestructuraAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEstructura(List<TipoEstructura> tipoestructurasTemp) throws Exception {
		for(TipoEstructura tipoestructuraAux:tipoestructurasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEstructuraConstantesFunciones.getClassesRelationshipsOfTipoEstructura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEstructuraConstantesFunciones.getClassesRelationshipsFromStringsOfTipoEstructura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoEstructura tipoestructura,List<TipoEstructura> tipoestructuras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoEstructura tipoestructuraEncontrado=null;
			
			for(TipoEstructura tipoestructuraLocal:tipoestructuras) {
				if(tipoestructuraLocal.getId().equals(tipoestructura.getId())) {
					tipoestructuraEncontrado=tipoestructuraLocal;
					
					tipoestructuraLocal.setIsChanged(tipoestructura.getIsChanged());
					tipoestructuraLocal.setIsNew(tipoestructura.getIsNew());
					tipoestructuraLocal.setIsDeleted(tipoestructura.getIsDeleted());
					
					tipoestructuraLocal.setGeneralEntityOriginal(tipoestructura.getGeneralEntityOriginal());
					
					tipoestructuraLocal.setId(tipoestructura.getId());	
					tipoestructuraLocal.setVersionRow(tipoestructura.getVersionRow());	
					tipoestructuraLocal.setcodigo(tipoestructura.getcodigo());	
					tipoestructuraLocal.setnombre(tipoestructura.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoestructura.getIsDeleted()) {
				if(!existe) {
					tipoestructuras.add(tipoestructura);
				}
			} else {
				if(tipoestructuraEncontrado!=null && permiteQuitar)  {
					tipoestructuras.remove(tipoestructuraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoEstructura tipoestructura,List<TipoEstructura> tipoestructuras) throws Exception {
		try	{			
			for(TipoEstructura tipoestructuraLocal:tipoestructuras) {
				if(tipoestructuraLocal.getId().equals(tipoestructura.getId())) {
					tipoestructuraLocal.setIsSelected(tipoestructura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoEstructura(List<TipoEstructura> tipoestructurasAux) throws Exception {
		//this.tipoestructurasAux=tipoestructurasAux;
		
		for(TipoEstructura tipoestructuraAux:tipoestructurasAux) {
			if(tipoestructuraAux.getIsChanged()) {
				tipoestructuraAux.setIsChanged(false);
			}		
			
			if(tipoestructuraAux.getIsNew()) {
				tipoestructuraAux.setIsNew(false);
			}	
			
			if(tipoestructuraAux.getIsDeleted()) {
				tipoestructuraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoEstructura(TipoEstructura tipoestructuraAux) throws Exception {
		//this.tipoestructuraAux=tipoestructuraAux;
		
			if(tipoestructuraAux.getIsChanged()) {
				tipoestructuraAux.setIsChanged(false);
			}		
			
			if(tipoestructuraAux.getIsNew()) {
				tipoestructuraAux.setIsNew(false);
			}	
			
			if(tipoestructuraAux.getIsDeleted()) {
				tipoestructuraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoEstructura tipoestructuraAsignar,TipoEstructura tipoestructura) throws Exception {
		tipoestructuraAsignar.setId(tipoestructura.getId());	
		tipoestructuraAsignar.setVersionRow(tipoestructura.getVersionRow());	
		tipoestructuraAsignar.setcodigo(tipoestructura.getcodigo());	
		tipoestructuraAsignar.setnombre(tipoestructura.getnombre());	
	}
	
	public static void inicializarTipoEstructura(TipoEstructura tipoestructura) throws Exception {
		try {
				tipoestructura.setId(0L);	
					
				tipoestructura.setcodigo("");	
				tipoestructura.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoEstructura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEstructuraConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEstructuraConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoEstructura(String sTipo,Row row,Workbook workbook,TipoEstructura tipoestructura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoestructura.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoestructura.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoEstructura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoEstructura() {
		return this.sFinalQueryTipoEstructura;
	}
	
	public void setsFinalQueryTipoEstructura(String sFinalQueryTipoEstructura) {
		this.sFinalQueryTipoEstructura= sFinalQueryTipoEstructura;
	}
	
	public Border resaltarSeleccionarTipoEstructura=null;
	
	public Border setResaltarSeleccionarTipoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstructuraBeanSwingJInternalFrame tipoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoestructuraBeanSwingJInternalFrame.jTtoolBarTipoEstructura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoEstructura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoEstructura() {
		return this.resaltarSeleccionarTipoEstructura;
	}
	
	public void setResaltarSeleccionarTipoEstructura(Border borderResaltarSeleccionarTipoEstructura) {
		this.resaltarSeleccionarTipoEstructura= borderResaltarSeleccionarTipoEstructura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoEstructura=null;
	public Boolean mostraridTipoEstructura=true;
	public Boolean activaridTipoEstructura=true;

	public Border resaltarcodigoTipoEstructura=null;
	public Boolean mostrarcodigoTipoEstructura=true;
	public Boolean activarcodigoTipoEstructura=true;

	public Border resaltarnombreTipoEstructura=null;
	public Boolean mostrarnombreTipoEstructura=true;
	public Boolean activarnombreTipoEstructura=true;

	
	

	public Border setResaltaridTipoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstructuraBeanSwingJInternalFrame tipoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoestructuraBeanSwingJInternalFrame.jTtoolBarTipoEstructura.setBorder(borderResaltar);
		
		this.resaltaridTipoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoEstructura() {
		return this.resaltaridTipoEstructura;
	}

	public void setResaltaridTipoEstructura(Border borderResaltar) {
		this.resaltaridTipoEstructura= borderResaltar;
	}

	public Boolean getMostraridTipoEstructura() {
		return this.mostraridTipoEstructura;
	}

	public void setMostraridTipoEstructura(Boolean mostraridTipoEstructura) {
		this.mostraridTipoEstructura= mostraridTipoEstructura;
	}

	public Boolean getActivaridTipoEstructura() {
		return this.activaridTipoEstructura;
	}

	public void setActivaridTipoEstructura(Boolean activaridTipoEstructura) {
		this.activaridTipoEstructura= activaridTipoEstructura;
	}

	public Border setResaltarcodigoTipoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstructuraBeanSwingJInternalFrame tipoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoestructuraBeanSwingJInternalFrame.jTtoolBarTipoEstructura.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoEstructura() {
		return this.resaltarcodigoTipoEstructura;
	}

	public void setResaltarcodigoTipoEstructura(Border borderResaltar) {
		this.resaltarcodigoTipoEstructura= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoEstructura() {
		return this.mostrarcodigoTipoEstructura;
	}

	public void setMostrarcodigoTipoEstructura(Boolean mostrarcodigoTipoEstructura) {
		this.mostrarcodigoTipoEstructura= mostrarcodigoTipoEstructura;
	}

	public Boolean getActivarcodigoTipoEstructura() {
		return this.activarcodigoTipoEstructura;
	}

	public void setActivarcodigoTipoEstructura(Boolean activarcodigoTipoEstructura) {
		this.activarcodigoTipoEstructura= activarcodigoTipoEstructura;
	}

	public Border setResaltarnombreTipoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEstructuraBeanSwingJInternalFrame tipoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoestructuraBeanSwingJInternalFrame.jTtoolBarTipoEstructura.setBorder(borderResaltar);
		
		this.resaltarnombreTipoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoEstructura() {
		return this.resaltarnombreTipoEstructura;
	}

	public void setResaltarnombreTipoEstructura(Border borderResaltar) {
		this.resaltarnombreTipoEstructura= borderResaltar;
	}

	public Boolean getMostrarnombreTipoEstructura() {
		return this.mostrarnombreTipoEstructura;
	}

	public void setMostrarnombreTipoEstructura(Boolean mostrarnombreTipoEstructura) {
		this.mostrarnombreTipoEstructura= mostrarnombreTipoEstructura;
	}

	public Boolean getActivarnombreTipoEstructura() {
		return this.activarnombreTipoEstructura;
	}

	public void setActivarnombreTipoEstructura(Boolean activarnombreTipoEstructura) {
		this.activarnombreTipoEstructura= activarnombreTipoEstructura;
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
		
		
		this.setMostraridTipoEstructura(esInicial);
		this.setMostrarcodigoTipoEstructura(esInicial);
		this.setMostrarnombreTipoEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEstructuraConstantesFunciones.ID)) {
				this.setMostraridTipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstructuraConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstructuraConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoEstructura(esAsigna);
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
		
		
		this.setActivaridTipoEstructura(esInicial);
		this.setActivarcodigoTipoEstructura(esInicial);
		this.setActivarnombreTipoEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEstructuraConstantesFunciones.ID)) {
				this.setActivaridTipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstructuraConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstructuraConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoEstructura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEstructuraBeanSwingJInternalFrame tipoestructuraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoEstructura(esInicial);
		this.setResaltarcodigoTipoEstructura(esInicial);
		this.setResaltarnombreTipoEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEstructuraConstantesFunciones.ID)) {
				this.setResaltaridTipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstructuraConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEstructuraConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoEstructura(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEstructuraBeanSwingJInternalFrame tipoestructuraBeanSwingJInternalFrame*/)throws Exception {	
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