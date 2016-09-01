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


import com.bydan.erp.nomina.util.TipoVariableNomiConstantesFunciones;
import com.bydan.erp.nomina.util.TipoVariableNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoVariableNomiParameterGeneral;

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
final public class TipoVariableNomiConstantesFunciones extends TipoVariableNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoVariableNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoVariableNomi"+TipoVariableNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoVariableNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoVariableNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoVariableNomiConstantesFunciones.SCHEMA+"_"+TipoVariableNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoVariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoVariableNomiConstantesFunciones.SCHEMA+"_"+TipoVariableNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoVariableNomiConstantesFunciones.SCHEMA+"_"+TipoVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoVariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoVariableNomiConstantesFunciones.SCHEMA+"_"+TipoVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoVariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoVariableNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoVariableNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoVariableNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoVariableNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoVariableNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoVariableNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Variables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Variable";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Variable Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoVariableNomi";
	public static final String OBJECTNAME="tipovariablenomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_variable_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipovariablenomi from "+TipoVariableNomiConstantesFunciones.SPERSISTENCENAME+" tipovariablenomi";
	public static String QUERYSELECTNATIVE="select "+TipoVariableNomiConstantesFunciones.SCHEMA+"."+TipoVariableNomiConstantesFunciones.TABLENAME+".id,"+TipoVariableNomiConstantesFunciones.SCHEMA+"."+TipoVariableNomiConstantesFunciones.TABLENAME+".version_row,"+TipoVariableNomiConstantesFunciones.SCHEMA+"."+TipoVariableNomiConstantesFunciones.TABLENAME+".codigo,"+TipoVariableNomiConstantesFunciones.SCHEMA+"."+TipoVariableNomiConstantesFunciones.TABLENAME+".nombre from "+TipoVariableNomiConstantesFunciones.SCHEMA+"."+TipoVariableNomiConstantesFunciones.TABLENAME;//+" as "+TipoVariableNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoVariableNomiConstantesFuncionesAdditional tipovariablenomiConstantesFuncionesAdditional=null;
	
	public TipoVariableNomiConstantesFuncionesAdditional getTipoVariableNomiConstantesFuncionesAdditional() {
		return this.tipovariablenomiConstantesFuncionesAdditional;
	}
	
	public void setTipoVariableNomiConstantesFuncionesAdditional(TipoVariableNomiConstantesFuncionesAdditional tipovariablenomiConstantesFuncionesAdditional) {
		try {
			this.tipovariablenomiConstantesFuncionesAdditional=tipovariablenomiConstantesFuncionesAdditional;
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
	
	public static String getTipoVariableNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoVariableNomiConstantesFunciones.CODIGO)) {sLabelColumna=TipoVariableNomiConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoVariableNomiConstantesFunciones.NOMBRE)) {sLabelColumna=TipoVariableNomiConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoVariableNomiDescripcion(TipoVariableNomi tipovariablenomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipovariablenomi !=null/* && tipovariablenomi.getId()!=0*/) {
			sDescripcion=tipovariablenomi.getcodigo();//tipovariablenomitipovariablenomi.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoVariableNomiDescripcionDetallado(TipoVariableNomi tipovariablenomi) {
		String sDescripcion="";
			
		sDescripcion+=TipoVariableNomiConstantesFunciones.ID+"=";
		sDescripcion+=tipovariablenomi.getId().toString()+",";
		sDescripcion+=TipoVariableNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipovariablenomi.getVersionRow().toString()+",";
		sDescripcion+=TipoVariableNomiConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipovariablenomi.getcodigo()+",";
		sDescripcion+=TipoVariableNomiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipovariablenomi.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoVariableNomiDescripcion(TipoVariableNomi tipovariablenomi,String sValor) throws Exception {			
		if(tipovariablenomi !=null) {
			tipovariablenomi.setcodigo(sValor);;//tipovariablenomitipovariablenomi.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoVariableNomi(TipoVariableNomi tipovariablenomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipovariablenomi.setcodigo(tipovariablenomi.getcodigo().trim());
		tipovariablenomi.setnombre(tipovariablenomi.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoVariableNomis(List<TipoVariableNomi> tipovariablenomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoVariableNomi tipovariablenomi: tipovariablenomis) {
			tipovariablenomi.setcodigo(tipovariablenomi.getcodigo().trim());
			tipovariablenomi.setnombre(tipovariablenomi.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoVariableNomi(TipoVariableNomi tipovariablenomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipovariablenomi.getConCambioAuxiliar()) {
			tipovariablenomi.setIsDeleted(tipovariablenomi.getIsDeletedAuxiliar());	
			tipovariablenomi.setIsNew(tipovariablenomi.getIsNewAuxiliar());	
			tipovariablenomi.setIsChanged(tipovariablenomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipovariablenomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipovariablenomi.setIsDeletedAuxiliar(false);	
			tipovariablenomi.setIsNewAuxiliar(false);	
			tipovariablenomi.setIsChangedAuxiliar(false);
			
			tipovariablenomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoVariableNomis(List<TipoVariableNomi> tipovariablenomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoVariableNomi tipovariablenomi : tipovariablenomis) {
			if(conAsignarBase && tipovariablenomi.getConCambioAuxiliar()) {
				tipovariablenomi.setIsDeleted(tipovariablenomi.getIsDeletedAuxiliar());	
				tipovariablenomi.setIsNew(tipovariablenomi.getIsNewAuxiliar());	
				tipovariablenomi.setIsChanged(tipovariablenomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipovariablenomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipovariablenomi.setIsDeletedAuxiliar(false);	
				tipovariablenomi.setIsNewAuxiliar(false);	
				tipovariablenomi.setIsChangedAuxiliar(false);
				
				tipovariablenomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoVariableNomi(TipoVariableNomi tipovariablenomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoVariableNomis(List<TipoVariableNomi> tipovariablenomis,Boolean conEnteros) throws Exception  {
		
		for(TipoVariableNomi tipovariablenomi: tipovariablenomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoVariableNomi(List<TipoVariableNomi> tipovariablenomis,TipoVariableNomi tipovariablenomiAux) throws Exception  {
		TipoVariableNomiConstantesFunciones.InicializarValoresTipoVariableNomi(tipovariablenomiAux,true);
		
		for(TipoVariableNomi tipovariablenomi: tipovariablenomis) {
			if(tipovariablenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoVariableNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoVariableNomiConstantesFunciones.getArrayColumnasGlobalesTipoVariableNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoVariableNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoVariableNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoVariableNomi> tipovariablenomis,TipoVariableNomi tipovariablenomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoVariableNomi tipovariablenomiAux: tipovariablenomis) {
			if(tipovariablenomiAux!=null && tipovariablenomi!=null) {
				if((tipovariablenomiAux.getId()==null && tipovariablenomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipovariablenomiAux.getId()!=null && tipovariablenomi.getId()!=null){
					if(tipovariablenomiAux.getId().equals(tipovariablenomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoVariableNomi(List<TipoVariableNomi> tipovariablenomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoVariableNomi tipovariablenomi: tipovariablenomis) {			
			if(tipovariablenomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoVariableNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoVariableNomiConstantesFunciones.LABEL_ID, TipoVariableNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVariableNomiConstantesFunciones.LABEL_VERSIONROW, TipoVariableNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVariableNomiConstantesFunciones.LABEL_CODIGO, TipoVariableNomiConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoVariableNomiConstantesFunciones.LABEL_NOMBRE, TipoVariableNomiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoVariableNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoVariableNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVariableNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVariableNomiConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoVariableNomiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVariableNomi() throws Exception  {
		return TipoVariableNomiConstantesFunciones.getTiposSeleccionarTipoVariableNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVariableNomi(Boolean conFk) throws Exception  {
		return TipoVariableNomiConstantesFunciones.getTiposSeleccionarTipoVariableNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoVariableNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoVariableNomiConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoVariableNomiConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoVariableNomiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoVariableNomiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoVariableNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoVariableNomi(TipoVariableNomi tipovariablenomiAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoVariableNomi(List<TipoVariableNomi> tipovariablenomisTemp) throws Exception {
		for(TipoVariableNomi tipovariablenomiAux:tipovariablenomisTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoVariableNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoVariableNomiConstantesFunciones.getClassesRelationshipsOfTipoVariableNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(VariableNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(VariableNomi.class)) {
						classes.add(new Classe(VariableNomi.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoVariableNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoVariableNomiConstantesFunciones.getClassesRelationshipsFromStringsOfTipoVariableNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoVariableNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(VariableNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(VariableNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(VariableNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(VariableNomi.class)); continue;
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
	public static void actualizarLista(TipoVariableNomi tipovariablenomi,List<TipoVariableNomi> tipovariablenomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoVariableNomi tipovariablenomiEncontrado=null;
			
			for(TipoVariableNomi tipovariablenomiLocal:tipovariablenomis) {
				if(tipovariablenomiLocal.getId().equals(tipovariablenomi.getId())) {
					tipovariablenomiEncontrado=tipovariablenomiLocal;
					
					tipovariablenomiLocal.setIsChanged(tipovariablenomi.getIsChanged());
					tipovariablenomiLocal.setIsNew(tipovariablenomi.getIsNew());
					tipovariablenomiLocal.setIsDeleted(tipovariablenomi.getIsDeleted());
					
					tipovariablenomiLocal.setGeneralEntityOriginal(tipovariablenomi.getGeneralEntityOriginal());
					
					tipovariablenomiLocal.setId(tipovariablenomi.getId());	
					tipovariablenomiLocal.setVersionRow(tipovariablenomi.getVersionRow());	
					tipovariablenomiLocal.setcodigo(tipovariablenomi.getcodigo());	
					tipovariablenomiLocal.setnombre(tipovariablenomi.getnombre());	
					
					
					tipovariablenomiLocal.setVariableNomis(tipovariablenomi.getVariableNomis());
					
					existe=true;
					break;
				}
			}
			
			if(!tipovariablenomi.getIsDeleted()) {
				if(!existe) {
					tipovariablenomis.add(tipovariablenomi);
				}
			} else {
				if(tipovariablenomiEncontrado!=null && permiteQuitar)  {
					tipovariablenomis.remove(tipovariablenomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoVariableNomi tipovariablenomi,List<TipoVariableNomi> tipovariablenomis) throws Exception {
		try	{			
			for(TipoVariableNomi tipovariablenomiLocal:tipovariablenomis) {
				if(tipovariablenomiLocal.getId().equals(tipovariablenomi.getId())) {
					tipovariablenomiLocal.setIsSelected(tipovariablenomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoVariableNomi(List<TipoVariableNomi> tipovariablenomisAux) throws Exception {
		//this.tipovariablenomisAux=tipovariablenomisAux;
		
		for(TipoVariableNomi tipovariablenomiAux:tipovariablenomisAux) {
			if(tipovariablenomiAux.getIsChanged()) {
				tipovariablenomiAux.setIsChanged(false);
			}		
			
			if(tipovariablenomiAux.getIsNew()) {
				tipovariablenomiAux.setIsNew(false);
			}	
			
			if(tipovariablenomiAux.getIsDeleted()) {
				tipovariablenomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoVariableNomi(TipoVariableNomi tipovariablenomiAux) throws Exception {
		//this.tipovariablenomiAux=tipovariablenomiAux;
		
			if(tipovariablenomiAux.getIsChanged()) {
				tipovariablenomiAux.setIsChanged(false);
			}		
			
			if(tipovariablenomiAux.getIsNew()) {
				tipovariablenomiAux.setIsNew(false);
			}	
			
			if(tipovariablenomiAux.getIsDeleted()) {
				tipovariablenomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoVariableNomi tipovariablenomiAsignar,TipoVariableNomi tipovariablenomi) throws Exception {
		tipovariablenomiAsignar.setId(tipovariablenomi.getId());	
		tipovariablenomiAsignar.setVersionRow(tipovariablenomi.getVersionRow());	
		tipovariablenomiAsignar.setcodigo(tipovariablenomi.getcodigo());	
		tipovariablenomiAsignar.setnombre(tipovariablenomi.getnombre());	
	}
	
	public static void inicializarTipoVariableNomi(TipoVariableNomi tipovariablenomi) throws Exception {
		try {
				tipovariablenomi.setId(0L);	
					
				tipovariablenomi.setcodigo("");	
				tipovariablenomi.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoVariableNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoVariableNomiConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoVariableNomiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoVariableNomi(String sTipo,Row row,Workbook workbook,TipoVariableNomi tipovariablenomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovariablenomi.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipovariablenomi.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoVariableNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoVariableNomi() {
		return this.sFinalQueryTipoVariableNomi;
	}
	
	public void setsFinalQueryTipoVariableNomi(String sFinalQueryTipoVariableNomi) {
		this.sFinalQueryTipoVariableNomi= sFinalQueryTipoVariableNomi;
	}
	
	public Border resaltarSeleccionarTipoVariableNomi=null;
	
	public Border setResaltarSeleccionarTipoVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVariableNomiBeanSwingJInternalFrame tipovariablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipovariablenomiBeanSwingJInternalFrame.jTtoolBarTipoVariableNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoVariableNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoVariableNomi() {
		return this.resaltarSeleccionarTipoVariableNomi;
	}
	
	public void setResaltarSeleccionarTipoVariableNomi(Border borderResaltarSeleccionarTipoVariableNomi) {
		this.resaltarSeleccionarTipoVariableNomi= borderResaltarSeleccionarTipoVariableNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoVariableNomi=null;
	public Boolean mostraridTipoVariableNomi=true;
	public Boolean activaridTipoVariableNomi=true;

	public Border resaltarcodigoTipoVariableNomi=null;
	public Boolean mostrarcodigoTipoVariableNomi=true;
	public Boolean activarcodigoTipoVariableNomi=true;

	public Border resaltarnombreTipoVariableNomi=null;
	public Boolean mostrarnombreTipoVariableNomi=true;
	public Boolean activarnombreTipoVariableNomi=true;

	
	

	public Border setResaltaridTipoVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVariableNomiBeanSwingJInternalFrame tipovariablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovariablenomiBeanSwingJInternalFrame.jTtoolBarTipoVariableNomi.setBorder(borderResaltar);
		
		this.resaltaridTipoVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoVariableNomi() {
		return this.resaltaridTipoVariableNomi;
	}

	public void setResaltaridTipoVariableNomi(Border borderResaltar) {
		this.resaltaridTipoVariableNomi= borderResaltar;
	}

	public Boolean getMostraridTipoVariableNomi() {
		return this.mostraridTipoVariableNomi;
	}

	public void setMostraridTipoVariableNomi(Boolean mostraridTipoVariableNomi) {
		this.mostraridTipoVariableNomi= mostraridTipoVariableNomi;
	}

	public Boolean getActivaridTipoVariableNomi() {
		return this.activaridTipoVariableNomi;
	}

	public void setActivaridTipoVariableNomi(Boolean activaridTipoVariableNomi) {
		this.activaridTipoVariableNomi= activaridTipoVariableNomi;
	}

	public Border setResaltarcodigoTipoVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVariableNomiBeanSwingJInternalFrame tipovariablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovariablenomiBeanSwingJInternalFrame.jTtoolBarTipoVariableNomi.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoVariableNomi() {
		return this.resaltarcodigoTipoVariableNomi;
	}

	public void setResaltarcodigoTipoVariableNomi(Border borderResaltar) {
		this.resaltarcodigoTipoVariableNomi= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoVariableNomi() {
		return this.mostrarcodigoTipoVariableNomi;
	}

	public void setMostrarcodigoTipoVariableNomi(Boolean mostrarcodigoTipoVariableNomi) {
		this.mostrarcodigoTipoVariableNomi= mostrarcodigoTipoVariableNomi;
	}

	public Boolean getActivarcodigoTipoVariableNomi() {
		return this.activarcodigoTipoVariableNomi;
	}

	public void setActivarcodigoTipoVariableNomi(Boolean activarcodigoTipoVariableNomi) {
		this.activarcodigoTipoVariableNomi= activarcodigoTipoVariableNomi;
	}

	public Border setResaltarnombreTipoVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVariableNomiBeanSwingJInternalFrame tipovariablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipovariablenomiBeanSwingJInternalFrame.jTtoolBarTipoVariableNomi.setBorder(borderResaltar);
		
		this.resaltarnombreTipoVariableNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoVariableNomi() {
		return this.resaltarnombreTipoVariableNomi;
	}

	public void setResaltarnombreTipoVariableNomi(Border borderResaltar) {
		this.resaltarnombreTipoVariableNomi= borderResaltar;
	}

	public Boolean getMostrarnombreTipoVariableNomi() {
		return this.mostrarnombreTipoVariableNomi;
	}

	public void setMostrarnombreTipoVariableNomi(Boolean mostrarnombreTipoVariableNomi) {
		this.mostrarnombreTipoVariableNomi= mostrarnombreTipoVariableNomi;
	}

	public Boolean getActivarnombreTipoVariableNomi() {
		return this.activarnombreTipoVariableNomi;
	}

	public void setActivarnombreTipoVariableNomi(Boolean activarnombreTipoVariableNomi) {
		this.activarnombreTipoVariableNomi= activarnombreTipoVariableNomi;
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
		
		
		this.setMostraridTipoVariableNomi(esInicial);
		this.setMostrarcodigoTipoVariableNomi(esInicial);
		this.setMostrarnombreTipoVariableNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVariableNomiConstantesFunciones.ID)) {
				this.setMostraridTipoVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVariableNomiConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVariableNomiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoVariableNomi(esAsigna);
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
		
		
		this.setActivaridTipoVariableNomi(esInicial);
		this.setActivarcodigoTipoVariableNomi(esInicial);
		this.setActivarnombreTipoVariableNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVariableNomiConstantesFunciones.ID)) {
				this.setActivaridTipoVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVariableNomiConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVariableNomiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoVariableNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoVariableNomiBeanSwingJInternalFrame tipovariablenomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoVariableNomi(esInicial);
		this.setResaltarcodigoTipoVariableNomi(esInicial);
		this.setResaltarnombreTipoVariableNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoVariableNomiConstantesFunciones.ID)) {
				this.setResaltaridTipoVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVariableNomiConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoVariableNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoVariableNomiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoVariableNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarVariableNomiTipoVariableNomi=null;

	public Border getResaltarVariableNomiTipoVariableNomi() {
		return this.resaltarVariableNomiTipoVariableNomi;
	}

	public void setResaltarVariableNomiTipoVariableNomi(Border borderResaltarVariableNomi) {
		if(borderResaltarVariableNomi!=null) {
			this.resaltarVariableNomiTipoVariableNomi= borderResaltarVariableNomi;
		}
	}

	public Border setResaltarVariableNomiTipoVariableNomi(ParametroGeneralUsuario parametroGeneralUsuario/*TipoVariableNomiBeanSwingJInternalFrame tipovariablenomiBeanSwingJInternalFrame*/) {
		Border borderResaltarVariableNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipovariablenomiBeanSwingJInternalFrame.jTtoolBarTipoVariableNomi.setBorder(borderResaltarVariableNomi);
			
		this.resaltarVariableNomiTipoVariableNomi= borderResaltarVariableNomi;

		 return borderResaltarVariableNomi;
	}



	public Boolean mostrarVariableNomiTipoVariableNomi=true;

	public Boolean getMostrarVariableNomiTipoVariableNomi() {
		return this.mostrarVariableNomiTipoVariableNomi;
	}

	public void setMostrarVariableNomiTipoVariableNomi(Boolean visibilidadResaltarVariableNomi) {
		this.mostrarVariableNomiTipoVariableNomi= visibilidadResaltarVariableNomi;
	}



	public Boolean activarVariableNomiTipoVariableNomi=true;

	public Boolean gethabilitarResaltarVariableNomiTipoVariableNomi() {
		return this.activarVariableNomiTipoVariableNomi;
	}

	public void setActivarVariableNomiTipoVariableNomi(Boolean habilitarResaltarVariableNomi) {
		this.activarVariableNomiTipoVariableNomi= habilitarResaltarVariableNomi;
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

		this.setMostrarVariableNomiTipoVariableNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(VariableNomi.class)) {
				this.setMostrarVariableNomiTipoVariableNomi(esAsigna);
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

		this.setActivarVariableNomiTipoVariableNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(VariableNomi.class)) {
				this.setActivarVariableNomiTipoVariableNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoVariableNomiBeanSwingJInternalFrame tipovariablenomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarVariableNomiTipoVariableNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(VariableNomi.class)) {
				this.setResaltarVariableNomiTipoVariableNomi(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}