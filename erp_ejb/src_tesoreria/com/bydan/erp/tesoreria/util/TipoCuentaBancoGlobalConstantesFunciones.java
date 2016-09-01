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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.TipoCuentaBancoGlobalConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoCuentaBancoGlobalParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoCuentaBancoGlobalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCuentaBancoGlobalConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCuentaBancoGlobal";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCuentaBancoGlobal"+TipoCuentaBancoGlobalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCuentaBancoGlobalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCuentaBancoGlobalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoGlobalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoGlobalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"_"+TipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoGlobalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCuentaBancoGlobalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCuentaBancoGlobalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCuentaBancoGlobalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCuentaBancoGlobalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCuentaBancoGlobalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCuentaBancoGlobalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Cuenta Banco Globals";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Cuenta Banco Global";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Cuenta Banco Global";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCuentaBancoGlobal";
	public static final String OBJECTNAME="tipocuentabancoglobal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tipo_cuenta_banco_global";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocuentabancoglobal from "+TipoCuentaBancoGlobalConstantesFunciones.SPERSISTENCENAME+" tipocuentabancoglobal";
	public static String QUERYSELECTNATIVE="select "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id,"+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".version_row,"+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".codigo,"+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".nombre from "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME;//+" as "+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoCuentaBancoGlobalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCuentaBancoGlobalConstantesFunciones.CODIGO)) {sLabelColumna=TipoCuentaBancoGlobalConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCuentaBancoGlobalConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCuentaBancoGlobalConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoCuentaBancoGlobalDescripcion(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocuentabancoglobal !=null/* && tipocuentabancoglobal.getId()!=0*/) {
			sDescripcion=tipocuentabancoglobal.getcodigo();//tipocuentabancoglobaltipocuentabancoglobal.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCuentaBancoGlobalDescripcionDetallado(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		String sDescripcion="";
			
		sDescripcion+=TipoCuentaBancoGlobalConstantesFunciones.ID+"=";
		sDescripcion+=tipocuentabancoglobal.getId().toString()+",";
		sDescripcion+=TipoCuentaBancoGlobalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocuentabancoglobal.getVersionRow().toString()+",";
		sDescripcion+=TipoCuentaBancoGlobalConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocuentabancoglobal.getcodigo()+",";
		sDescripcion+=TipoCuentaBancoGlobalConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocuentabancoglobal.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCuentaBancoGlobalDescripcion(TipoCuentaBancoGlobal tipocuentabancoglobal,String sValor) throws Exception {			
		if(tipocuentabancoglobal !=null) {
			tipocuentabancoglobal.setcodigo(sValor);;//tipocuentabancoglobaltipocuentabancoglobal.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocuentabancoglobal.setcodigo(tipocuentabancoglobal.getcodigo().trim());
		tipocuentabancoglobal.setnombre(tipocuentabancoglobal.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCuentaBancoGlobals(List<TipoCuentaBancoGlobal> tipocuentabancoglobals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCuentaBancoGlobal tipocuentabancoglobal: tipocuentabancoglobals) {
			tipocuentabancoglobal.setcodigo(tipocuentabancoglobal.getcodigo().trim());
			tipocuentabancoglobal.setnombre(tipocuentabancoglobal.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocuentabancoglobal.getConCambioAuxiliar()) {
			tipocuentabancoglobal.setIsDeleted(tipocuentabancoglobal.getIsDeletedAuxiliar());	
			tipocuentabancoglobal.setIsNew(tipocuentabancoglobal.getIsNewAuxiliar());	
			tipocuentabancoglobal.setIsChanged(tipocuentabancoglobal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocuentabancoglobal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocuentabancoglobal.setIsDeletedAuxiliar(false);	
			tipocuentabancoglobal.setIsNewAuxiliar(false);	
			tipocuentabancoglobal.setIsChangedAuxiliar(false);
			
			tipocuentabancoglobal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCuentaBancoGlobals(List<TipoCuentaBancoGlobal> tipocuentabancoglobals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCuentaBancoGlobal tipocuentabancoglobal : tipocuentabancoglobals) {
			if(conAsignarBase && tipocuentabancoglobal.getConCambioAuxiliar()) {
				tipocuentabancoglobal.setIsDeleted(tipocuentabancoglobal.getIsDeletedAuxiliar());	
				tipocuentabancoglobal.setIsNew(tipocuentabancoglobal.getIsNewAuxiliar());	
				tipocuentabancoglobal.setIsChanged(tipocuentabancoglobal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocuentabancoglobal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocuentabancoglobal.setIsDeletedAuxiliar(false);	
				tipocuentabancoglobal.setIsNewAuxiliar(false);	
				tipocuentabancoglobal.setIsChangedAuxiliar(false);
				
				tipocuentabancoglobal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCuentaBancoGlobals(List<TipoCuentaBancoGlobal> tipocuentabancoglobals,Boolean conEnteros) throws Exception  {
		
		for(TipoCuentaBancoGlobal tipocuentabancoglobal: tipocuentabancoglobals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCuentaBancoGlobal(List<TipoCuentaBancoGlobal> tipocuentabancoglobals,TipoCuentaBancoGlobal tipocuentabancoglobalAux) throws Exception  {
		TipoCuentaBancoGlobalConstantesFunciones.InicializarValoresTipoCuentaBancoGlobal(tipocuentabancoglobalAux,true);
		
		for(TipoCuentaBancoGlobal tipocuentabancoglobal: tipocuentabancoglobals) {
			if(tipocuentabancoglobal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCuentaBancoGlobal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCuentaBancoGlobalConstantesFunciones.getArrayColumnasGlobalesTipoCuentaBancoGlobal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCuentaBancoGlobal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCuentaBancoGlobal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCuentaBancoGlobal> tipocuentabancoglobals,TipoCuentaBancoGlobal tipocuentabancoglobal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCuentaBancoGlobal tipocuentabancoglobalAux: tipocuentabancoglobals) {
			if(tipocuentabancoglobalAux!=null && tipocuentabancoglobal!=null) {
				if((tipocuentabancoglobalAux.getId()==null && tipocuentabancoglobal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocuentabancoglobalAux.getId()!=null && tipocuentabancoglobal.getId()!=null){
					if(tipocuentabancoglobalAux.getId().equals(tipocuentabancoglobal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCuentaBancoGlobal(List<TipoCuentaBancoGlobal> tipocuentabancoglobals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCuentaBancoGlobal tipocuentabancoglobal: tipocuentabancoglobals) {			
			if(tipocuentabancoglobal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCuentaBancoGlobal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCuentaBancoGlobalConstantesFunciones.LABEL_ID, TipoCuentaBancoGlobalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoGlobalConstantesFunciones.LABEL_VERSIONROW, TipoCuentaBancoGlobalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoGlobalConstantesFunciones.LABEL_CODIGO, TipoCuentaBancoGlobalConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCuentaBancoGlobalConstantesFunciones.LABEL_NOMBRE, TipoCuentaBancoGlobalConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCuentaBancoGlobal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoGlobalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoGlobalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoGlobalConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCuentaBancoGlobalConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaBancoGlobal() throws Exception  {
		return TipoCuentaBancoGlobalConstantesFunciones.getTiposSeleccionarTipoCuentaBancoGlobal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaBancoGlobal(Boolean conFk) throws Exception  {
		return TipoCuentaBancoGlobalConstantesFunciones.getTiposSeleccionarTipoCuentaBancoGlobal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCuentaBancoGlobal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuentaBancoGlobalConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCuentaBancoGlobalConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCuentaBancoGlobalConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCuentaBancoGlobalConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCuentaBancoGlobal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobalAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(List<TipoCuentaBancoGlobal> tipocuentabancoglobalsTemp) throws Exception {
		for(TipoCuentaBancoGlobal tipocuentabancoglobalAux:tipocuentabancoglobalsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCuentaBancoGlobal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCuentaBancoGlobal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaBancoGlobal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCuentaBancoGlobalConstantesFunciones.getClassesRelationshipsOfTipoCuentaBancoGlobal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaBancoGlobal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(BancoTipoCuentaBancoGlobal.class));
				classes.add(new Classe(DatoGeneralEmpleado.class));
				classes.add(new Classe(PoliticasCliente.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(CuentaBanco.class));
				classes.add(new Classe(ParametroTesoreriaDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(BancoTipoCuentaBancoGlobal.class)) {
						classes.add(new Classe(BancoTipoCuentaBancoGlobal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralEmpleado.class)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PoliticasCliente.class)) {
						classes.add(new Classe(PoliticasCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaBanco.class)) {
						classes.add(new Classe(CuentaBanco.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroTesoreriaDefecto.class)) {
						classes.add(new Classe(ParametroTesoreriaDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCuentaBancoGlobal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCuentaBancoGlobalConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCuentaBancoGlobal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCuentaBancoGlobal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(BancoTipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BancoTipoCuentaBancoGlobal.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}

					if(ParametroTesoreriaDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroTesoreriaDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(BancoTipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BancoTipoCuentaBancoGlobal.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(PoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PoliticasCliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}

					if(ParametroTesoreriaDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroTesoreriaDefecto.class)); continue;
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
	public static void actualizarLista(TipoCuentaBancoGlobal tipocuentabancoglobal,List<TipoCuentaBancoGlobal> tipocuentabancoglobals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCuentaBancoGlobal tipocuentabancoglobalEncontrado=null;
			
			for(TipoCuentaBancoGlobal tipocuentabancoglobalLocal:tipocuentabancoglobals) {
				if(tipocuentabancoglobalLocal.getId().equals(tipocuentabancoglobal.getId())) {
					tipocuentabancoglobalEncontrado=tipocuentabancoglobalLocal;
					
					tipocuentabancoglobalLocal.setIsChanged(tipocuentabancoglobal.getIsChanged());
					tipocuentabancoglobalLocal.setIsNew(tipocuentabancoglobal.getIsNew());
					tipocuentabancoglobalLocal.setIsDeleted(tipocuentabancoglobal.getIsDeleted());
					
					tipocuentabancoglobalLocal.setGeneralEntityOriginal(tipocuentabancoglobal.getGeneralEntityOriginal());
					
					tipocuentabancoglobalLocal.setId(tipocuentabancoglobal.getId());	
					tipocuentabancoglobalLocal.setVersionRow(tipocuentabancoglobal.getVersionRow());	
					tipocuentabancoglobalLocal.setcodigo(tipocuentabancoglobal.getcodigo());	
					tipocuentabancoglobalLocal.setnombre(tipocuentabancoglobal.getnombre());	
					
					
					tipocuentabancoglobalLocal.setBancoTipoCuentaBancoGlobals(tipocuentabancoglobal.getBancoTipoCuentaBancoGlobals());
					tipocuentabancoglobalLocal.setDatoGeneralEmpleados(tipocuentabancoglobal.getDatoGeneralEmpleados());
					tipocuentabancoglobalLocal.setPoliticasClientes(tipocuentabancoglobal.getPoliticasClientes());
					tipocuentabancoglobalLocal.setEmpleados(tipocuentabancoglobal.getEmpleados());
					tipocuentabancoglobalLocal.setParametroTesoreriaDefectos(tipocuentabancoglobal.getParametroTesoreriaDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocuentabancoglobal.getIsDeleted()) {
				if(!existe) {
					tipocuentabancoglobals.add(tipocuentabancoglobal);
				}
			} else {
				if(tipocuentabancoglobalEncontrado!=null && permiteQuitar)  {
					tipocuentabancoglobals.remove(tipocuentabancoglobalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCuentaBancoGlobal tipocuentabancoglobal,List<TipoCuentaBancoGlobal> tipocuentabancoglobals) throws Exception {
		try	{			
			for(TipoCuentaBancoGlobal tipocuentabancoglobalLocal:tipocuentabancoglobals) {
				if(tipocuentabancoglobalLocal.getId().equals(tipocuentabancoglobal.getId())) {
					tipocuentabancoglobalLocal.setIsSelected(tipocuentabancoglobal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCuentaBancoGlobal(List<TipoCuentaBancoGlobal> tipocuentabancoglobalsAux) throws Exception {
		//this.tipocuentabancoglobalsAux=tipocuentabancoglobalsAux;
		
		for(TipoCuentaBancoGlobal tipocuentabancoglobalAux:tipocuentabancoglobalsAux) {
			if(tipocuentabancoglobalAux.getIsChanged()) {
				tipocuentabancoglobalAux.setIsChanged(false);
			}		
			
			if(tipocuentabancoglobalAux.getIsNew()) {
				tipocuentabancoglobalAux.setIsNew(false);
			}	
			
			if(tipocuentabancoglobalAux.getIsDeleted()) {
				tipocuentabancoglobalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobalAux) throws Exception {
		//this.tipocuentabancoglobalAux=tipocuentabancoglobalAux;
		
			if(tipocuentabancoglobalAux.getIsChanged()) {
				tipocuentabancoglobalAux.setIsChanged(false);
			}		
			
			if(tipocuentabancoglobalAux.getIsNew()) {
				tipocuentabancoglobalAux.setIsNew(false);
			}	
			
			if(tipocuentabancoglobalAux.getIsDeleted()) {
				tipocuentabancoglobalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCuentaBancoGlobal tipocuentabancoglobalAsignar,TipoCuentaBancoGlobal tipocuentabancoglobal) throws Exception {
		tipocuentabancoglobalAsignar.setId(tipocuentabancoglobal.getId());	
		tipocuentabancoglobalAsignar.setVersionRow(tipocuentabancoglobal.getVersionRow());	
		tipocuentabancoglobalAsignar.setcodigo(tipocuentabancoglobal.getcodigo());	
		tipocuentabancoglobalAsignar.setnombre(tipocuentabancoglobal.getnombre());	
	}
	
	public static void inicializarTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobal) throws Exception {
		try {
				tipocuentabancoglobal.setId(0L);	
					
				tipocuentabancoglobal.setcodigo("");	
				tipocuentabancoglobal.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCuentaBancoGlobal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuentaBancoGlobalConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCuentaBancoGlobalConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCuentaBancoGlobal(String sTipo,Row row,Workbook workbook,TipoCuentaBancoGlobal tipocuentabancoglobal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuentabancoglobal.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocuentabancoglobal.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCuentaBancoGlobal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCuentaBancoGlobal() {
		return this.sFinalQueryTipoCuentaBancoGlobal;
	}
	
	public void setsFinalQueryTipoCuentaBancoGlobal(String sFinalQueryTipoCuentaBancoGlobal) {
		this.sFinalQueryTipoCuentaBancoGlobal= sFinalQueryTipoCuentaBancoGlobal;
	}
	
	public Border resaltarSeleccionarTipoCuentaBancoGlobal=null;
	
	public Border setResaltarSeleccionarTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGlobalBeanSwingJInternalFrame tipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGlobal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCuentaBancoGlobal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCuentaBancoGlobal() {
		return this.resaltarSeleccionarTipoCuentaBancoGlobal;
	}
	
	public void setResaltarSeleccionarTipoCuentaBancoGlobal(Border borderResaltarSeleccionarTipoCuentaBancoGlobal) {
		this.resaltarSeleccionarTipoCuentaBancoGlobal= borderResaltarSeleccionarTipoCuentaBancoGlobal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCuentaBancoGlobal=null;
	public Boolean mostraridTipoCuentaBancoGlobal=true;
	public Boolean activaridTipoCuentaBancoGlobal=true;

	public Border resaltarcodigoTipoCuentaBancoGlobal=null;
	public Boolean mostrarcodigoTipoCuentaBancoGlobal=true;
	public Boolean activarcodigoTipoCuentaBancoGlobal=true;

	public Border resaltarnombreTipoCuentaBancoGlobal=null;
	public Boolean mostrarnombreTipoCuentaBancoGlobal=true;
	public Boolean activarnombreTipoCuentaBancoGlobal=true;

	
	

	public Border setResaltaridTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGlobalBeanSwingJInternalFrame tipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGlobal.setBorder(borderResaltar);
		
		this.resaltaridTipoCuentaBancoGlobal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCuentaBancoGlobal() {
		return this.resaltaridTipoCuentaBancoGlobal;
	}

	public void setResaltaridTipoCuentaBancoGlobal(Border borderResaltar) {
		this.resaltaridTipoCuentaBancoGlobal= borderResaltar;
	}

	public Boolean getMostraridTipoCuentaBancoGlobal() {
		return this.mostraridTipoCuentaBancoGlobal;
	}

	public void setMostraridTipoCuentaBancoGlobal(Boolean mostraridTipoCuentaBancoGlobal) {
		this.mostraridTipoCuentaBancoGlobal= mostraridTipoCuentaBancoGlobal;
	}

	public Boolean getActivaridTipoCuentaBancoGlobal() {
		return this.activaridTipoCuentaBancoGlobal;
	}

	public void setActivaridTipoCuentaBancoGlobal(Boolean activaridTipoCuentaBancoGlobal) {
		this.activaridTipoCuentaBancoGlobal= activaridTipoCuentaBancoGlobal;
	}

	public Border setResaltarcodigoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGlobalBeanSwingJInternalFrame tipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGlobal.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCuentaBancoGlobal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCuentaBancoGlobal() {
		return this.resaltarcodigoTipoCuentaBancoGlobal;
	}

	public void setResaltarcodigoTipoCuentaBancoGlobal(Border borderResaltar) {
		this.resaltarcodigoTipoCuentaBancoGlobal= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCuentaBancoGlobal() {
		return this.mostrarcodigoTipoCuentaBancoGlobal;
	}

	public void setMostrarcodigoTipoCuentaBancoGlobal(Boolean mostrarcodigoTipoCuentaBancoGlobal) {
		this.mostrarcodigoTipoCuentaBancoGlobal= mostrarcodigoTipoCuentaBancoGlobal;
	}

	public Boolean getActivarcodigoTipoCuentaBancoGlobal() {
		return this.activarcodigoTipoCuentaBancoGlobal;
	}

	public void setActivarcodigoTipoCuentaBancoGlobal(Boolean activarcodigoTipoCuentaBancoGlobal) {
		this.activarcodigoTipoCuentaBancoGlobal= activarcodigoTipoCuentaBancoGlobal;
	}

	public Border setResaltarnombreTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGlobalBeanSwingJInternalFrame tipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGlobal.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCuentaBancoGlobal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCuentaBancoGlobal() {
		return this.resaltarnombreTipoCuentaBancoGlobal;
	}

	public void setResaltarnombreTipoCuentaBancoGlobal(Border borderResaltar) {
		this.resaltarnombreTipoCuentaBancoGlobal= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCuentaBancoGlobal() {
		return this.mostrarnombreTipoCuentaBancoGlobal;
	}

	public void setMostrarnombreTipoCuentaBancoGlobal(Boolean mostrarnombreTipoCuentaBancoGlobal) {
		this.mostrarnombreTipoCuentaBancoGlobal= mostrarnombreTipoCuentaBancoGlobal;
	}

	public Boolean getActivarnombreTipoCuentaBancoGlobal() {
		return this.activarnombreTipoCuentaBancoGlobal;
	}

	public void setActivarnombreTipoCuentaBancoGlobal(Boolean activarnombreTipoCuentaBancoGlobal) {
		this.activarnombreTipoCuentaBancoGlobal= activarnombreTipoCuentaBancoGlobal;
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
		
		
		this.setMostraridTipoCuentaBancoGlobal(esInicial);
		this.setMostrarcodigoTipoCuentaBancoGlobal(esInicial);
		this.setMostrarnombreTipoCuentaBancoGlobal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaBancoGlobalConstantesFunciones.ID)) {
				this.setMostraridTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGlobalConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGlobalConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCuentaBancoGlobal(esAsigna);
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
		
		
		this.setActivaridTipoCuentaBancoGlobal(esInicial);
		this.setActivarcodigoTipoCuentaBancoGlobal(esInicial);
		this.setActivarnombreTipoCuentaBancoGlobal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaBancoGlobalConstantesFunciones.ID)) {
				this.setActivaridTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGlobalConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGlobalConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCuentaBancoGlobal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCuentaBancoGlobalBeanSwingJInternalFrame tipocuentabancoglobalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCuentaBancoGlobal(esInicial);
		this.setResaltarcodigoTipoCuentaBancoGlobal(esInicial);
		this.setResaltarnombreTipoCuentaBancoGlobal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCuentaBancoGlobalConstantesFunciones.ID)) {
				this.setResaltaridTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGlobalConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCuentaBancoGlobalConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCuentaBancoGlobal(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal=null;

	public Border getResaltarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal() {
		return this.resaltarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal;
	}

	public void setResaltarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal(Border borderResaltarBancoTipoCuentaBancoGlobal) {
		if(borderResaltarBancoTipoCuentaBancoGlobal!=null) {
			this.resaltarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal= borderResaltarBancoTipoCuentaBancoGlobal;
		}
	}

	public Border setResaltarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGlobalBeanSwingJInternalFrame tipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltarBancoTipoCuentaBancoGlobal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGlobal.setBorder(borderResaltarBancoTipoCuentaBancoGlobal);
			
		this.resaltarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal= borderResaltarBancoTipoCuentaBancoGlobal;

		 return borderResaltarBancoTipoCuentaBancoGlobal;
	}



	public Boolean mostrarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal=true;

	public Boolean getMostrarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal() {
		return this.mostrarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal;
	}

	public void setMostrarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal(Boolean visibilidadResaltarBancoTipoCuentaBancoGlobal) {
		this.mostrarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal= visibilidadResaltarBancoTipoCuentaBancoGlobal;
	}



	public Boolean activarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal=true;

	public Boolean gethabilitarResaltarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal() {
		return this.activarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal;
	}

	public void setActivarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal(Boolean habilitarResaltarBancoTipoCuentaBancoGlobal) {
		this.activarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal= habilitarResaltarBancoTipoCuentaBancoGlobal;
	}


	public Border resaltarDatoGeneralEmpleadoTipoCuentaBancoGlobal=null;

	public Border getResaltarDatoGeneralEmpleadoTipoCuentaBancoGlobal() {
		return this.resaltarDatoGeneralEmpleadoTipoCuentaBancoGlobal;
	}

	public void setResaltarDatoGeneralEmpleadoTipoCuentaBancoGlobal(Border borderResaltarDatoGeneralEmpleado) {
		if(borderResaltarDatoGeneralEmpleado!=null) {
			this.resaltarDatoGeneralEmpleadoTipoCuentaBancoGlobal= borderResaltarDatoGeneralEmpleado;
		}
	}

	public Border setResaltarDatoGeneralEmpleadoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGlobalBeanSwingJInternalFrame tipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoGeneralEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGlobal.setBorder(borderResaltarDatoGeneralEmpleado);
			
		this.resaltarDatoGeneralEmpleadoTipoCuentaBancoGlobal= borderResaltarDatoGeneralEmpleado;

		 return borderResaltarDatoGeneralEmpleado;
	}



	public Boolean mostrarDatoGeneralEmpleadoTipoCuentaBancoGlobal=true;

	public Boolean getMostrarDatoGeneralEmpleadoTipoCuentaBancoGlobal() {
		return this.mostrarDatoGeneralEmpleadoTipoCuentaBancoGlobal;
	}

	public void setMostrarDatoGeneralEmpleadoTipoCuentaBancoGlobal(Boolean visibilidadResaltarDatoGeneralEmpleado) {
		this.mostrarDatoGeneralEmpleadoTipoCuentaBancoGlobal= visibilidadResaltarDatoGeneralEmpleado;
	}



	public Boolean activarDatoGeneralEmpleadoTipoCuentaBancoGlobal=true;

	public Boolean gethabilitarResaltarDatoGeneralEmpleadoTipoCuentaBancoGlobal() {
		return this.activarDatoGeneralEmpleadoTipoCuentaBancoGlobal;
	}

	public void setActivarDatoGeneralEmpleadoTipoCuentaBancoGlobal(Boolean habilitarResaltarDatoGeneralEmpleado) {
		this.activarDatoGeneralEmpleadoTipoCuentaBancoGlobal= habilitarResaltarDatoGeneralEmpleado;
	}


	public Border resaltarPoliticasClienteTipoCuentaBancoGlobal=null;

	public Border getResaltarPoliticasClienteTipoCuentaBancoGlobal() {
		return this.resaltarPoliticasClienteTipoCuentaBancoGlobal;
	}

	public void setResaltarPoliticasClienteTipoCuentaBancoGlobal(Border borderResaltarPoliticasCliente) {
		if(borderResaltarPoliticasCliente!=null) {
			this.resaltarPoliticasClienteTipoCuentaBancoGlobal= borderResaltarPoliticasCliente;
		}
	}

	public Border setResaltarPoliticasClienteTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGlobalBeanSwingJInternalFrame tipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltarPoliticasCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGlobal.setBorder(borderResaltarPoliticasCliente);
			
		this.resaltarPoliticasClienteTipoCuentaBancoGlobal= borderResaltarPoliticasCliente;

		 return borderResaltarPoliticasCliente;
	}



	public Boolean mostrarPoliticasClienteTipoCuentaBancoGlobal=true;

	public Boolean getMostrarPoliticasClienteTipoCuentaBancoGlobal() {
		return this.mostrarPoliticasClienteTipoCuentaBancoGlobal;
	}

	public void setMostrarPoliticasClienteTipoCuentaBancoGlobal(Boolean visibilidadResaltarPoliticasCliente) {
		this.mostrarPoliticasClienteTipoCuentaBancoGlobal= visibilidadResaltarPoliticasCliente;
	}



	public Boolean activarPoliticasClienteTipoCuentaBancoGlobal=true;

	public Boolean gethabilitarResaltarPoliticasClienteTipoCuentaBancoGlobal() {
		return this.activarPoliticasClienteTipoCuentaBancoGlobal;
	}

	public void setActivarPoliticasClienteTipoCuentaBancoGlobal(Boolean habilitarResaltarPoliticasCliente) {
		this.activarPoliticasClienteTipoCuentaBancoGlobal= habilitarResaltarPoliticasCliente;
	}


	public Border resaltarEmpleadoTipoCuentaBancoGlobal=null;

	public Border getResaltarEmpleadoTipoCuentaBancoGlobal() {
		return this.resaltarEmpleadoTipoCuentaBancoGlobal;
	}

	public void setResaltarEmpleadoTipoCuentaBancoGlobal(Border borderResaltarEmpleado) {
		if(borderResaltarEmpleado!=null) {
			this.resaltarEmpleadoTipoCuentaBancoGlobal= borderResaltarEmpleado;
		}
	}

	public Border setResaltarEmpleadoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGlobalBeanSwingJInternalFrame tipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGlobal.setBorder(borderResaltarEmpleado);
			
		this.resaltarEmpleadoTipoCuentaBancoGlobal= borderResaltarEmpleado;

		 return borderResaltarEmpleado;
	}



	public Boolean mostrarEmpleadoTipoCuentaBancoGlobal=true;

	public Boolean getMostrarEmpleadoTipoCuentaBancoGlobal() {
		return this.mostrarEmpleadoTipoCuentaBancoGlobal;
	}

	public void setMostrarEmpleadoTipoCuentaBancoGlobal(Boolean visibilidadResaltarEmpleado) {
		this.mostrarEmpleadoTipoCuentaBancoGlobal= visibilidadResaltarEmpleado;
	}



	public Boolean activarEmpleadoTipoCuentaBancoGlobal=true;

	public Boolean gethabilitarResaltarEmpleadoTipoCuentaBancoGlobal() {
		return this.activarEmpleadoTipoCuentaBancoGlobal;
	}

	public void setActivarEmpleadoTipoCuentaBancoGlobal(Boolean habilitarResaltarEmpleado) {
		this.activarEmpleadoTipoCuentaBancoGlobal= habilitarResaltarEmpleado;
	}


	public Border resaltarParametroTesoreriaDefectoTipoCuentaBancoGlobal=null;

	public Border getResaltarParametroTesoreriaDefectoTipoCuentaBancoGlobal() {
		return this.resaltarParametroTesoreriaDefectoTipoCuentaBancoGlobal;
	}

	public void setResaltarParametroTesoreriaDefectoTipoCuentaBancoGlobal(Border borderResaltarParametroTesoreriaDefecto) {
		if(borderResaltarParametroTesoreriaDefecto!=null) {
			this.resaltarParametroTesoreriaDefectoTipoCuentaBancoGlobal= borderResaltarParametroTesoreriaDefecto;
		}
	}

	public Border setResaltarParametroTesoreriaDefectoTipoCuentaBancoGlobal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCuentaBancoGlobalBeanSwingJInternalFrame tipocuentabancoglobalBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroTesoreriaDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocuentabancoglobalBeanSwingJInternalFrame.jTtoolBarTipoCuentaBancoGlobal.setBorder(borderResaltarParametroTesoreriaDefecto);
			
		this.resaltarParametroTesoreriaDefectoTipoCuentaBancoGlobal= borderResaltarParametroTesoreriaDefecto;

		 return borderResaltarParametroTesoreriaDefecto;
	}



	public Boolean mostrarParametroTesoreriaDefectoTipoCuentaBancoGlobal=true;

	public Boolean getMostrarParametroTesoreriaDefectoTipoCuentaBancoGlobal() {
		return this.mostrarParametroTesoreriaDefectoTipoCuentaBancoGlobal;
	}

	public void setMostrarParametroTesoreriaDefectoTipoCuentaBancoGlobal(Boolean visibilidadResaltarParametroTesoreriaDefecto) {
		this.mostrarParametroTesoreriaDefectoTipoCuentaBancoGlobal= visibilidadResaltarParametroTesoreriaDefecto;
	}



	public Boolean activarParametroTesoreriaDefectoTipoCuentaBancoGlobal=true;

	public Boolean gethabilitarResaltarParametroTesoreriaDefectoTipoCuentaBancoGlobal() {
		return this.activarParametroTesoreriaDefectoTipoCuentaBancoGlobal;
	}

	public void setActivarParametroTesoreriaDefectoTipoCuentaBancoGlobal(Boolean habilitarResaltarParametroTesoreriaDefecto) {
		this.activarParametroTesoreriaDefectoTipoCuentaBancoGlobal= habilitarResaltarParametroTesoreriaDefecto;
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

		this.setMostrarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal(esInicial);
		this.setMostrarDatoGeneralEmpleadoTipoCuentaBancoGlobal(esInicial);
		this.setMostrarPoliticasClienteTipoCuentaBancoGlobal(esInicial);
		this.setMostrarEmpleadoTipoCuentaBancoGlobal(esInicial);
		this.setMostrarParametroTesoreriaDefectoTipoCuentaBancoGlobal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(BancoTipoCuentaBancoGlobal.class)) {
				this.setMostrarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setMostrarDatoGeneralEmpleadoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setMostrarPoliticasClienteTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setMostrarEmpleadoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroTesoreriaDefecto.class)) {
				this.setMostrarParametroTesoreriaDefectoTipoCuentaBancoGlobal(esAsigna);
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

		this.setActivarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal(esInicial);
		this.setActivarDatoGeneralEmpleadoTipoCuentaBancoGlobal(esInicial);
		this.setActivarPoliticasClienteTipoCuentaBancoGlobal(esInicial);
		this.setActivarEmpleadoTipoCuentaBancoGlobal(esInicial);
		this.setActivarParametroTesoreriaDefectoTipoCuentaBancoGlobal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(BancoTipoCuentaBancoGlobal.class)) {
				this.setActivarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setActivarDatoGeneralEmpleadoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setActivarPoliticasClienteTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setActivarEmpleadoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroTesoreriaDefecto.class)) {
				this.setActivarParametroTesoreriaDefectoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCuentaBancoGlobalBeanSwingJInternalFrame tipocuentabancoglobalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal(esInicial);
		this.setResaltarDatoGeneralEmpleadoTipoCuentaBancoGlobal(esInicial);
		this.setResaltarPoliticasClienteTipoCuentaBancoGlobal(esInicial);
		this.setResaltarEmpleadoTipoCuentaBancoGlobal(esInicial);
		this.setResaltarParametroTesoreriaDefectoTipoCuentaBancoGlobal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(BancoTipoCuentaBancoGlobal.class)) {
				this.setResaltarBancoTipoCuentaBancoGlobalTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setResaltarDatoGeneralEmpleadoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(PoliticasCliente.class)) {
				this.setResaltarPoliticasClienteTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setResaltarEmpleadoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroTesoreriaDefecto.class)) {
				this.setResaltarParametroTesoreriaDefectoTipoCuentaBancoGlobal(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}