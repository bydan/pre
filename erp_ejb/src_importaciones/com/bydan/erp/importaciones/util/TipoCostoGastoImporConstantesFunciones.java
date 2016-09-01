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
package com.bydan.erp.importaciones.util;

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


import com.bydan.erp.importaciones.util.TipoCostoGastoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.TipoCostoGastoImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.TipoCostoGastoImporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCostoGastoImporConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCostoGastoImpor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCostoGastoImpor"+TipoCostoGastoImporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCostoGastoImporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCostoGastoImporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCostoGastoImporConstantesFunciones.SCHEMA+"_"+TipoCostoGastoImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCostoGastoImporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCostoGastoImporConstantesFunciones.SCHEMA+"_"+TipoCostoGastoImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCostoGastoImporConstantesFunciones.SCHEMA+"_"+TipoCostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCostoGastoImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCostoGastoImporConstantesFunciones.SCHEMA+"_"+TipoCostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCostoGastoImporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCostoGastoImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCostoGastoImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCostoGastoImporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCostoGastoImporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCostoGastoImporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCostoGastoImporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Costo Gastos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Costo Gasto";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Costo Gasto Impor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCostoGastoImpor";
	public static final String OBJECTNAME="tipocostogastoimpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="tipo_costo_gasto_impor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocostogastoimpor from "+TipoCostoGastoImporConstantesFunciones.SPERSISTENCENAME+" tipocostogastoimpor";
	public static String QUERYSELECTNATIVE="select "+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+".id,"+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+".version_row,"+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+".codigo,"+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME+".nombre from "+TipoCostoGastoImporConstantesFunciones.SCHEMA+"."+TipoCostoGastoImporConstantesFunciones.TABLENAME;//+" as "+TipoCostoGastoImporConstantesFunciones.TABLENAME;
	
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
	
	public static String getTipoCostoGastoImporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCostoGastoImporConstantesFunciones.CODIGO)) {sLabelColumna=TipoCostoGastoImporConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCostoGastoImporConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCostoGastoImporConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoCostoGastoImporDescripcion(TipoCostoGastoImpor tipocostogastoimpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocostogastoimpor !=null/* && tipocostogastoimpor.getId()!=0*/) {
			sDescripcion=tipocostogastoimpor.getcodigo();//tipocostogastoimportipocostogastoimpor.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCostoGastoImporDescripcionDetallado(TipoCostoGastoImpor tipocostogastoimpor) {
		String sDescripcion="";
			
		sDescripcion+=TipoCostoGastoImporConstantesFunciones.ID+"=";
		sDescripcion+=tipocostogastoimpor.getId().toString()+",";
		sDescripcion+=TipoCostoGastoImporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocostogastoimpor.getVersionRow().toString()+",";
		sDescripcion+=TipoCostoGastoImporConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocostogastoimpor.getcodigo()+",";
		sDescripcion+=TipoCostoGastoImporConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocostogastoimpor.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCostoGastoImporDescripcion(TipoCostoGastoImpor tipocostogastoimpor,String sValor) throws Exception {			
		if(tipocostogastoimpor !=null) {
			tipocostogastoimpor.setcodigo(sValor);;//tipocostogastoimportipocostogastoimpor.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCostoGastoImpor(TipoCostoGastoImpor tipocostogastoimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocostogastoimpor.setcodigo(tipocostogastoimpor.getcodigo().trim());
		tipocostogastoimpor.setnombre(tipocostogastoimpor.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCostoGastoImpors(List<TipoCostoGastoImpor> tipocostogastoimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCostoGastoImpor tipocostogastoimpor: tipocostogastoimpors) {
			tipocostogastoimpor.setcodigo(tipocostogastoimpor.getcodigo().trim());
			tipocostogastoimpor.setnombre(tipocostogastoimpor.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCostoGastoImpor(TipoCostoGastoImpor tipocostogastoimpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocostogastoimpor.getConCambioAuxiliar()) {
			tipocostogastoimpor.setIsDeleted(tipocostogastoimpor.getIsDeletedAuxiliar());	
			tipocostogastoimpor.setIsNew(tipocostogastoimpor.getIsNewAuxiliar());	
			tipocostogastoimpor.setIsChanged(tipocostogastoimpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocostogastoimpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocostogastoimpor.setIsDeletedAuxiliar(false);	
			tipocostogastoimpor.setIsNewAuxiliar(false);	
			tipocostogastoimpor.setIsChangedAuxiliar(false);
			
			tipocostogastoimpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCostoGastoImpors(List<TipoCostoGastoImpor> tipocostogastoimpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCostoGastoImpor tipocostogastoimpor : tipocostogastoimpors) {
			if(conAsignarBase && tipocostogastoimpor.getConCambioAuxiliar()) {
				tipocostogastoimpor.setIsDeleted(tipocostogastoimpor.getIsDeletedAuxiliar());	
				tipocostogastoimpor.setIsNew(tipocostogastoimpor.getIsNewAuxiliar());	
				tipocostogastoimpor.setIsChanged(tipocostogastoimpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocostogastoimpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocostogastoimpor.setIsDeletedAuxiliar(false);	
				tipocostogastoimpor.setIsNewAuxiliar(false);	
				tipocostogastoimpor.setIsChangedAuxiliar(false);
				
				tipocostogastoimpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCostoGastoImpor(TipoCostoGastoImpor tipocostogastoimpor,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCostoGastoImpors(List<TipoCostoGastoImpor> tipocostogastoimpors,Boolean conEnteros) throws Exception  {
		
		for(TipoCostoGastoImpor tipocostogastoimpor: tipocostogastoimpors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCostoGastoImpor(List<TipoCostoGastoImpor> tipocostogastoimpors,TipoCostoGastoImpor tipocostogastoimporAux) throws Exception  {
		TipoCostoGastoImporConstantesFunciones.InicializarValoresTipoCostoGastoImpor(tipocostogastoimporAux,true);
		
		for(TipoCostoGastoImpor tipocostogastoimpor: tipocostogastoimpors) {
			if(tipocostogastoimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCostoGastoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCostoGastoImporConstantesFunciones.getArrayColumnasGlobalesTipoCostoGastoImpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCostoGastoImpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCostoGastoImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCostoGastoImpor> tipocostogastoimpors,TipoCostoGastoImpor tipocostogastoimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCostoGastoImpor tipocostogastoimporAux: tipocostogastoimpors) {
			if(tipocostogastoimporAux!=null && tipocostogastoimpor!=null) {
				if((tipocostogastoimporAux.getId()==null && tipocostogastoimpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocostogastoimporAux.getId()!=null && tipocostogastoimpor.getId()!=null){
					if(tipocostogastoimporAux.getId().equals(tipocostogastoimpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCostoGastoImpor(List<TipoCostoGastoImpor> tipocostogastoimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCostoGastoImpor tipocostogastoimpor: tipocostogastoimpors) {			
			if(tipocostogastoimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCostoGastoImpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCostoGastoImporConstantesFunciones.LABEL_ID, TipoCostoGastoImporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCostoGastoImporConstantesFunciones.LABEL_VERSIONROW, TipoCostoGastoImporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCostoGastoImporConstantesFunciones.LABEL_CODIGO, TipoCostoGastoImporConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCostoGastoImporConstantesFunciones.LABEL_NOMBRE, TipoCostoGastoImporConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCostoGastoImpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCostoGastoImporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCostoGastoImporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCostoGastoImporConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCostoGastoImporConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCostoGastoImpor() throws Exception  {
		return TipoCostoGastoImporConstantesFunciones.getTiposSeleccionarTipoCostoGastoImpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCostoGastoImpor(Boolean conFk) throws Exception  {
		return TipoCostoGastoImporConstantesFunciones.getTiposSeleccionarTipoCostoGastoImpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCostoGastoImpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCostoGastoImporConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCostoGastoImporConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCostoGastoImporConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCostoGastoImporConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCostoGastoImpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCostoGastoImpor(TipoCostoGastoImpor tipocostogastoimporAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCostoGastoImpor(List<TipoCostoGastoImpor> tipocostogastoimporsTemp) throws Exception {
		for(TipoCostoGastoImpor tipocostogastoimporAux:tipocostogastoimporsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCostoGastoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCostoGastoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCostoGastoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCostoGastoImporConstantesFunciones.getClassesRelationshipsOfTipoCostoGastoImpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCostoGastoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCostoGastoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCostoGastoImporConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCostoGastoImpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCostoGastoImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoCostoGastoImpor tipocostogastoimpor,List<TipoCostoGastoImpor> tipocostogastoimpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCostoGastoImpor tipocostogastoimporEncontrado=null;
			
			for(TipoCostoGastoImpor tipocostogastoimporLocal:tipocostogastoimpors) {
				if(tipocostogastoimporLocal.getId().equals(tipocostogastoimpor.getId())) {
					tipocostogastoimporEncontrado=tipocostogastoimporLocal;
					
					tipocostogastoimporLocal.setIsChanged(tipocostogastoimpor.getIsChanged());
					tipocostogastoimporLocal.setIsNew(tipocostogastoimpor.getIsNew());
					tipocostogastoimporLocal.setIsDeleted(tipocostogastoimpor.getIsDeleted());
					
					tipocostogastoimporLocal.setGeneralEntityOriginal(tipocostogastoimpor.getGeneralEntityOriginal());
					
					tipocostogastoimporLocal.setId(tipocostogastoimpor.getId());	
					tipocostogastoimporLocal.setVersionRow(tipocostogastoimpor.getVersionRow());	
					tipocostogastoimporLocal.setcodigo(tipocostogastoimpor.getcodigo());	
					tipocostogastoimporLocal.setnombre(tipocostogastoimpor.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipocostogastoimpor.getIsDeleted()) {
				if(!existe) {
					tipocostogastoimpors.add(tipocostogastoimpor);
				}
			} else {
				if(tipocostogastoimporEncontrado!=null && permiteQuitar)  {
					tipocostogastoimpors.remove(tipocostogastoimporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCostoGastoImpor tipocostogastoimpor,List<TipoCostoGastoImpor> tipocostogastoimpors) throws Exception {
		try	{			
			for(TipoCostoGastoImpor tipocostogastoimporLocal:tipocostogastoimpors) {
				if(tipocostogastoimporLocal.getId().equals(tipocostogastoimpor.getId())) {
					tipocostogastoimporLocal.setIsSelected(tipocostogastoimpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCostoGastoImpor(List<TipoCostoGastoImpor> tipocostogastoimporsAux) throws Exception {
		//this.tipocostogastoimporsAux=tipocostogastoimporsAux;
		
		for(TipoCostoGastoImpor tipocostogastoimporAux:tipocostogastoimporsAux) {
			if(tipocostogastoimporAux.getIsChanged()) {
				tipocostogastoimporAux.setIsChanged(false);
			}		
			
			if(tipocostogastoimporAux.getIsNew()) {
				tipocostogastoimporAux.setIsNew(false);
			}	
			
			if(tipocostogastoimporAux.getIsDeleted()) {
				tipocostogastoimporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCostoGastoImpor(TipoCostoGastoImpor tipocostogastoimporAux) throws Exception {
		//this.tipocostogastoimporAux=tipocostogastoimporAux;
		
			if(tipocostogastoimporAux.getIsChanged()) {
				tipocostogastoimporAux.setIsChanged(false);
			}		
			
			if(tipocostogastoimporAux.getIsNew()) {
				tipocostogastoimporAux.setIsNew(false);
			}	
			
			if(tipocostogastoimporAux.getIsDeleted()) {
				tipocostogastoimporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCostoGastoImpor tipocostogastoimporAsignar,TipoCostoGastoImpor tipocostogastoimpor) throws Exception {
		tipocostogastoimporAsignar.setId(tipocostogastoimpor.getId());	
		tipocostogastoimporAsignar.setVersionRow(tipocostogastoimpor.getVersionRow());	
		tipocostogastoimporAsignar.setcodigo(tipocostogastoimpor.getcodigo());	
		tipocostogastoimporAsignar.setnombre(tipocostogastoimpor.getnombre());	
	}
	
	public static void inicializarTipoCostoGastoImpor(TipoCostoGastoImpor tipocostogastoimpor) throws Exception {
		try {
				tipocostogastoimpor.setId(0L);	
					
				tipocostogastoimpor.setcodigo("");	
				tipocostogastoimpor.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCostoGastoImpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCostoGastoImporConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCostoGastoImporConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCostoGastoImpor(String sTipo,Row row,Workbook workbook,TipoCostoGastoImpor tipocostogastoimpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocostogastoimpor.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocostogastoimpor.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCostoGastoImpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCostoGastoImpor() {
		return this.sFinalQueryTipoCostoGastoImpor;
	}
	
	public void setsFinalQueryTipoCostoGastoImpor(String sFinalQueryTipoCostoGastoImpor) {
		this.sFinalQueryTipoCostoGastoImpor= sFinalQueryTipoCostoGastoImpor;
	}
	
	public Border resaltarSeleccionarTipoCostoGastoImpor=null;
	
	public Border setResaltarSeleccionarTipoCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoGastoImporBeanSwingJInternalFrame tipocostogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocostogastoimporBeanSwingJInternalFrame.jTtoolBarTipoCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCostoGastoImpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCostoGastoImpor() {
		return this.resaltarSeleccionarTipoCostoGastoImpor;
	}
	
	public void setResaltarSeleccionarTipoCostoGastoImpor(Border borderResaltarSeleccionarTipoCostoGastoImpor) {
		this.resaltarSeleccionarTipoCostoGastoImpor= borderResaltarSeleccionarTipoCostoGastoImpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCostoGastoImpor=null;
	public Boolean mostraridTipoCostoGastoImpor=true;
	public Boolean activaridTipoCostoGastoImpor=true;

	public Border resaltarcodigoTipoCostoGastoImpor=null;
	public Boolean mostrarcodigoTipoCostoGastoImpor=true;
	public Boolean activarcodigoTipoCostoGastoImpor=true;

	public Border resaltarnombreTipoCostoGastoImpor=null;
	public Boolean mostrarnombreTipoCostoGastoImpor=true;
	public Boolean activarnombreTipoCostoGastoImpor=true;

	
	

	public Border setResaltaridTipoCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoGastoImporBeanSwingJInternalFrame tipocostogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocostogastoimporBeanSwingJInternalFrame.jTtoolBarTipoCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltaridTipoCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCostoGastoImpor() {
		return this.resaltaridTipoCostoGastoImpor;
	}

	public void setResaltaridTipoCostoGastoImpor(Border borderResaltar) {
		this.resaltaridTipoCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostraridTipoCostoGastoImpor() {
		return this.mostraridTipoCostoGastoImpor;
	}

	public void setMostraridTipoCostoGastoImpor(Boolean mostraridTipoCostoGastoImpor) {
		this.mostraridTipoCostoGastoImpor= mostraridTipoCostoGastoImpor;
	}

	public Boolean getActivaridTipoCostoGastoImpor() {
		return this.activaridTipoCostoGastoImpor;
	}

	public void setActivaridTipoCostoGastoImpor(Boolean activaridTipoCostoGastoImpor) {
		this.activaridTipoCostoGastoImpor= activaridTipoCostoGastoImpor;
	}

	public Border setResaltarcodigoTipoCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoGastoImporBeanSwingJInternalFrame tipocostogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocostogastoimporBeanSwingJInternalFrame.jTtoolBarTipoCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCostoGastoImpor() {
		return this.resaltarcodigoTipoCostoGastoImpor;
	}

	public void setResaltarcodigoTipoCostoGastoImpor(Border borderResaltar) {
		this.resaltarcodigoTipoCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCostoGastoImpor() {
		return this.mostrarcodigoTipoCostoGastoImpor;
	}

	public void setMostrarcodigoTipoCostoGastoImpor(Boolean mostrarcodigoTipoCostoGastoImpor) {
		this.mostrarcodigoTipoCostoGastoImpor= mostrarcodigoTipoCostoGastoImpor;
	}

	public Boolean getActivarcodigoTipoCostoGastoImpor() {
		return this.activarcodigoTipoCostoGastoImpor;
	}

	public void setActivarcodigoTipoCostoGastoImpor(Boolean activarcodigoTipoCostoGastoImpor) {
		this.activarcodigoTipoCostoGastoImpor= activarcodigoTipoCostoGastoImpor;
	}

	public Border setResaltarnombreTipoCostoGastoImpor(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCostoGastoImporBeanSwingJInternalFrame tipocostogastoimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocostogastoimporBeanSwingJInternalFrame.jTtoolBarTipoCostoGastoImpor.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCostoGastoImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCostoGastoImpor() {
		return this.resaltarnombreTipoCostoGastoImpor;
	}

	public void setResaltarnombreTipoCostoGastoImpor(Border borderResaltar) {
		this.resaltarnombreTipoCostoGastoImpor= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCostoGastoImpor() {
		return this.mostrarnombreTipoCostoGastoImpor;
	}

	public void setMostrarnombreTipoCostoGastoImpor(Boolean mostrarnombreTipoCostoGastoImpor) {
		this.mostrarnombreTipoCostoGastoImpor= mostrarnombreTipoCostoGastoImpor;
	}

	public Boolean getActivarnombreTipoCostoGastoImpor() {
		return this.activarnombreTipoCostoGastoImpor;
	}

	public void setActivarnombreTipoCostoGastoImpor(Boolean activarnombreTipoCostoGastoImpor) {
		this.activarnombreTipoCostoGastoImpor= activarnombreTipoCostoGastoImpor;
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
		
		
		this.setMostraridTipoCostoGastoImpor(esInicial);
		this.setMostrarcodigoTipoCostoGastoImpor(esInicial);
		this.setMostrarnombreTipoCostoGastoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCostoGastoImporConstantesFunciones.ID)) {
				this.setMostraridTipoCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoGastoImporConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoGastoImporConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCostoGastoImpor(esAsigna);
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
		
		
		this.setActivaridTipoCostoGastoImpor(esInicial);
		this.setActivarcodigoTipoCostoGastoImpor(esInicial);
		this.setActivarnombreTipoCostoGastoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCostoGastoImporConstantesFunciones.ID)) {
				this.setActivaridTipoCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoGastoImporConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoGastoImporConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCostoGastoImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCostoGastoImporBeanSwingJInternalFrame tipocostogastoimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCostoGastoImpor(esInicial);
		this.setResaltarcodigoTipoCostoGastoImpor(esInicial);
		this.setResaltarnombreTipoCostoGastoImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCostoGastoImporConstantesFunciones.ID)) {
				this.setResaltaridTipoCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoGastoImporConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCostoGastoImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCostoGastoImporConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCostoGastoImpor(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCostoGastoImporBeanSwingJInternalFrame tipocostogastoimporBeanSwingJInternalFrame*/)throws Exception {	
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