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


import com.bydan.erp.cartera.util.TipoCargaFamiConstantesFunciones;
import com.bydan.erp.cartera.util.TipoCargaFamiParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoCargaFamiParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCargaFamiConstantesFunciones extends TipoCargaFamiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCargaFami";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCargaFami"+TipoCargaFamiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCargaFamiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCargaFamiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCargaFamiConstantesFunciones.SCHEMA+"_"+TipoCargaFamiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCargaFamiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCargaFamiConstantesFunciones.SCHEMA+"_"+TipoCargaFamiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCargaFamiConstantesFunciones.SCHEMA+"_"+TipoCargaFamiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCargaFamiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCargaFamiConstantesFunciones.SCHEMA+"_"+TipoCargaFamiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCargaFamiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCargaFamiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCargaFamiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCargaFamiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCargaFamiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCargaFamiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCargaFamiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCargaFamiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCargaFamiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCargaFamiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Carga Famis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Carga Fami";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Carga Fami";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCargaFami";
	public static final String OBJECTNAME="tipocargafami";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_carga_fami";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocargafami from "+TipoCargaFamiConstantesFunciones.SPERSISTENCENAME+" tipocargafami";
	public static String QUERYSELECTNATIVE="select "+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+".id,"+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+".version_row,"+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+".codigo,"+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME+".nombre from "+TipoCargaFamiConstantesFunciones.SCHEMA+"."+TipoCargaFamiConstantesFunciones.TABLENAME;//+" as "+TipoCargaFamiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoCargaFamiConstantesFuncionesAdditional tipocargafamiConstantesFuncionesAdditional=null;
	
	public TipoCargaFamiConstantesFuncionesAdditional getTipoCargaFamiConstantesFuncionesAdditional() {
		return this.tipocargafamiConstantesFuncionesAdditional;
	}
	
	public void setTipoCargaFamiConstantesFuncionesAdditional(TipoCargaFamiConstantesFuncionesAdditional tipocargafamiConstantesFuncionesAdditional) {
		try {
			this.tipocargafamiConstantesFuncionesAdditional=tipocargafamiConstantesFuncionesAdditional;
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
	
	public static String getTipoCargaFamiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCargaFamiConstantesFunciones.CODIGO)) {sLabelColumna=TipoCargaFamiConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCargaFamiConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCargaFamiConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoCargaFamiDescripcion(TipoCargaFami tipocargafami) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocargafami !=null/* && tipocargafami.getId()!=0*/) {
			sDescripcion=tipocargafami.getcodigo();//tipocargafamitipocargafami.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCargaFamiDescripcionDetallado(TipoCargaFami tipocargafami) {
		String sDescripcion="";
			
		sDescripcion+=TipoCargaFamiConstantesFunciones.ID+"=";
		sDescripcion+=tipocargafami.getId().toString()+",";
		sDescripcion+=TipoCargaFamiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocargafami.getVersionRow().toString()+",";
		sDescripcion+=TipoCargaFamiConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocargafami.getcodigo()+",";
		sDescripcion+=TipoCargaFamiConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocargafami.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCargaFamiDescripcion(TipoCargaFami tipocargafami,String sValor) throws Exception {			
		if(tipocargafami !=null) {
			tipocargafami.setcodigo(sValor);;//tipocargafamitipocargafami.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCargaFami(TipoCargaFami tipocargafami,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocargafami.setcodigo(tipocargafami.getcodigo().trim());
		tipocargafami.setnombre(tipocargafami.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCargaFamis(List<TipoCargaFami> tipocargafamis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCargaFami tipocargafami: tipocargafamis) {
			tipocargafami.setcodigo(tipocargafami.getcodigo().trim());
			tipocargafami.setnombre(tipocargafami.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCargaFami(TipoCargaFami tipocargafami,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocargafami.getConCambioAuxiliar()) {
			tipocargafami.setIsDeleted(tipocargafami.getIsDeletedAuxiliar());	
			tipocargafami.setIsNew(tipocargafami.getIsNewAuxiliar());	
			tipocargafami.setIsChanged(tipocargafami.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocargafami.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocargafami.setIsDeletedAuxiliar(false);	
			tipocargafami.setIsNewAuxiliar(false);	
			tipocargafami.setIsChangedAuxiliar(false);
			
			tipocargafami.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCargaFamis(List<TipoCargaFami> tipocargafamis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCargaFami tipocargafami : tipocargafamis) {
			if(conAsignarBase && tipocargafami.getConCambioAuxiliar()) {
				tipocargafami.setIsDeleted(tipocargafami.getIsDeletedAuxiliar());	
				tipocargafami.setIsNew(tipocargafami.getIsNewAuxiliar());	
				tipocargafami.setIsChanged(tipocargafami.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocargafami.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocargafami.setIsDeletedAuxiliar(false);	
				tipocargafami.setIsNewAuxiliar(false);	
				tipocargafami.setIsChangedAuxiliar(false);
				
				tipocargafami.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCargaFami(TipoCargaFami tipocargafami,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCargaFamis(List<TipoCargaFami> tipocargafamis,Boolean conEnteros) throws Exception  {
		
		for(TipoCargaFami tipocargafami: tipocargafamis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCargaFami(List<TipoCargaFami> tipocargafamis,TipoCargaFami tipocargafamiAux) throws Exception  {
		TipoCargaFamiConstantesFunciones.InicializarValoresTipoCargaFami(tipocargafamiAux,true);
		
		for(TipoCargaFami tipocargafami: tipocargafamis) {
			if(tipocargafami.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCargaFami(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCargaFamiConstantesFunciones.getArrayColumnasGlobalesTipoCargaFami(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCargaFami(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCargaFami(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCargaFami> tipocargafamis,TipoCargaFami tipocargafami,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCargaFami tipocargafamiAux: tipocargafamis) {
			if(tipocargafamiAux!=null && tipocargafami!=null) {
				if((tipocargafamiAux.getId()==null && tipocargafami.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocargafamiAux.getId()!=null && tipocargafami.getId()!=null){
					if(tipocargafamiAux.getId().equals(tipocargafami.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCargaFami(List<TipoCargaFami> tipocargafamis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCargaFami tipocargafami: tipocargafamis) {			
			if(tipocargafami.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCargaFami() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCargaFamiConstantesFunciones.LABEL_ID, TipoCargaFamiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCargaFamiConstantesFunciones.LABEL_VERSIONROW, TipoCargaFamiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCargaFamiConstantesFunciones.LABEL_CODIGO, TipoCargaFamiConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCargaFamiConstantesFunciones.LABEL_NOMBRE, TipoCargaFamiConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCargaFami() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCargaFamiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCargaFamiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCargaFamiConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCargaFamiConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCargaFami() throws Exception  {
		return TipoCargaFamiConstantesFunciones.getTiposSeleccionarTipoCargaFami(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCargaFami(Boolean conFk) throws Exception  {
		return TipoCargaFamiConstantesFunciones.getTiposSeleccionarTipoCargaFami(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCargaFami(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCargaFamiConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCargaFamiConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCargaFamiConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCargaFamiConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCargaFami(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCargaFami(TipoCargaFami tipocargafamiAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCargaFami(List<TipoCargaFami> tipocargafamisTemp) throws Exception {
		for(TipoCargaFami tipocargafamiAux:tipocargafamisTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCargaFami(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCargaFami(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCargaFami(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCargaFamiConstantesFunciones.getClassesRelationshipsOfTipoCargaFami(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCargaFami(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CargaFamiliar_NM.class));
				classes.add(new Classe(CargaFamiliar.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CargaFamiliar_NM.class)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CargaFamiliar.class)) {
						classes.add(new Classe(CargaFamiliar.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCargaFami(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCargaFamiConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCargaFami(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCargaFami(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CargaFamiliar_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); continue;
					}

					if(CargaFamiliar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CargaFamiliar_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar_NM.class)); continue;
					}

					if(CargaFamiliar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CargaFamiliar.class)); continue;
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
	public static void actualizarLista(TipoCargaFami tipocargafami,List<TipoCargaFami> tipocargafamis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCargaFami tipocargafamiEncontrado=null;
			
			for(TipoCargaFami tipocargafamiLocal:tipocargafamis) {
				if(tipocargafamiLocal.getId().equals(tipocargafami.getId())) {
					tipocargafamiEncontrado=tipocargafamiLocal;
					
					tipocargafamiLocal.setIsChanged(tipocargafami.getIsChanged());
					tipocargafamiLocal.setIsNew(tipocargafami.getIsNew());
					tipocargafamiLocal.setIsDeleted(tipocargafami.getIsDeleted());
					
					tipocargafamiLocal.setGeneralEntityOriginal(tipocargafami.getGeneralEntityOriginal());
					
					tipocargafamiLocal.setId(tipocargafami.getId());	
					tipocargafamiLocal.setVersionRow(tipocargafami.getVersionRow());	
					tipocargafamiLocal.setcodigo(tipocargafami.getcodigo());	
					tipocargafamiLocal.setnombre(tipocargafami.getnombre());	
					
					
					tipocargafamiLocal.setCargaFamiliar_NMs(tipocargafami.getCargaFamiliar_NMs());
					tipocargafamiLocal.setCargaFamiliars(tipocargafami.getCargaFamiliars());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocargafami.getIsDeleted()) {
				if(!existe) {
					tipocargafamis.add(tipocargafami);
				}
			} else {
				if(tipocargafamiEncontrado!=null && permiteQuitar)  {
					tipocargafamis.remove(tipocargafamiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCargaFami tipocargafami,List<TipoCargaFami> tipocargafamis) throws Exception {
		try	{			
			for(TipoCargaFami tipocargafamiLocal:tipocargafamis) {
				if(tipocargafamiLocal.getId().equals(tipocargafami.getId())) {
					tipocargafamiLocal.setIsSelected(tipocargafami.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCargaFami(List<TipoCargaFami> tipocargafamisAux) throws Exception {
		//this.tipocargafamisAux=tipocargafamisAux;
		
		for(TipoCargaFami tipocargafamiAux:tipocargafamisAux) {
			if(tipocargafamiAux.getIsChanged()) {
				tipocargafamiAux.setIsChanged(false);
			}		
			
			if(tipocargafamiAux.getIsNew()) {
				tipocargafamiAux.setIsNew(false);
			}	
			
			if(tipocargafamiAux.getIsDeleted()) {
				tipocargafamiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCargaFami(TipoCargaFami tipocargafamiAux) throws Exception {
		//this.tipocargafamiAux=tipocargafamiAux;
		
			if(tipocargafamiAux.getIsChanged()) {
				tipocargafamiAux.setIsChanged(false);
			}		
			
			if(tipocargafamiAux.getIsNew()) {
				tipocargafamiAux.setIsNew(false);
			}	
			
			if(tipocargafamiAux.getIsDeleted()) {
				tipocargafamiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCargaFami tipocargafamiAsignar,TipoCargaFami tipocargafami) throws Exception {
		tipocargafamiAsignar.setId(tipocargafami.getId());	
		tipocargafamiAsignar.setVersionRow(tipocargafami.getVersionRow());	
		tipocargafamiAsignar.setcodigo(tipocargafami.getcodigo());	
		tipocargafamiAsignar.setnombre(tipocargafami.getnombre());	
	}
	
	public static void inicializarTipoCargaFami(TipoCargaFami tipocargafami) throws Exception {
		try {
				tipocargafami.setId(0L);	
					
				tipocargafami.setcodigo("");	
				tipocargafami.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCargaFami(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCargaFamiConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCargaFamiConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCargaFami(String sTipo,Row row,Workbook workbook,TipoCargaFami tipocargafami,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocargafami.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocargafami.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCargaFami=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCargaFami() {
		return this.sFinalQueryTipoCargaFami;
	}
	
	public void setsFinalQueryTipoCargaFami(String sFinalQueryTipoCargaFami) {
		this.sFinalQueryTipoCargaFami= sFinalQueryTipoCargaFami;
	}
	
	public Border resaltarSeleccionarTipoCargaFami=null;
	
	public Border setResaltarSeleccionarTipoCargaFami(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargaFamiBeanSwingJInternalFrame tipocargafamiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocargafamiBeanSwingJInternalFrame.jTtoolBarTipoCargaFami.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCargaFami= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCargaFami() {
		return this.resaltarSeleccionarTipoCargaFami;
	}
	
	public void setResaltarSeleccionarTipoCargaFami(Border borderResaltarSeleccionarTipoCargaFami) {
		this.resaltarSeleccionarTipoCargaFami= borderResaltarSeleccionarTipoCargaFami;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCargaFami=null;
	public Boolean mostraridTipoCargaFami=true;
	public Boolean activaridTipoCargaFami=true;

	public Border resaltarcodigoTipoCargaFami=null;
	public Boolean mostrarcodigoTipoCargaFami=true;
	public Boolean activarcodigoTipoCargaFami=true;

	public Border resaltarnombreTipoCargaFami=null;
	public Boolean mostrarnombreTipoCargaFami=true;
	public Boolean activarnombreTipoCargaFami=true;

	
	

	public Border setResaltaridTipoCargaFami(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargaFamiBeanSwingJInternalFrame tipocargafamiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocargafamiBeanSwingJInternalFrame.jTtoolBarTipoCargaFami.setBorder(borderResaltar);
		
		this.resaltaridTipoCargaFami= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCargaFami() {
		return this.resaltaridTipoCargaFami;
	}

	public void setResaltaridTipoCargaFami(Border borderResaltar) {
		this.resaltaridTipoCargaFami= borderResaltar;
	}

	public Boolean getMostraridTipoCargaFami() {
		return this.mostraridTipoCargaFami;
	}

	public void setMostraridTipoCargaFami(Boolean mostraridTipoCargaFami) {
		this.mostraridTipoCargaFami= mostraridTipoCargaFami;
	}

	public Boolean getActivaridTipoCargaFami() {
		return this.activaridTipoCargaFami;
	}

	public void setActivaridTipoCargaFami(Boolean activaridTipoCargaFami) {
		this.activaridTipoCargaFami= activaridTipoCargaFami;
	}

	public Border setResaltarcodigoTipoCargaFami(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargaFamiBeanSwingJInternalFrame tipocargafamiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocargafamiBeanSwingJInternalFrame.jTtoolBarTipoCargaFami.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCargaFami= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCargaFami() {
		return this.resaltarcodigoTipoCargaFami;
	}

	public void setResaltarcodigoTipoCargaFami(Border borderResaltar) {
		this.resaltarcodigoTipoCargaFami= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCargaFami() {
		return this.mostrarcodigoTipoCargaFami;
	}

	public void setMostrarcodigoTipoCargaFami(Boolean mostrarcodigoTipoCargaFami) {
		this.mostrarcodigoTipoCargaFami= mostrarcodigoTipoCargaFami;
	}

	public Boolean getActivarcodigoTipoCargaFami() {
		return this.activarcodigoTipoCargaFami;
	}

	public void setActivarcodigoTipoCargaFami(Boolean activarcodigoTipoCargaFami) {
		this.activarcodigoTipoCargaFami= activarcodigoTipoCargaFami;
	}

	public Border setResaltarnombreTipoCargaFami(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargaFamiBeanSwingJInternalFrame tipocargafamiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocargafamiBeanSwingJInternalFrame.jTtoolBarTipoCargaFami.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCargaFami= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCargaFami() {
		return this.resaltarnombreTipoCargaFami;
	}

	public void setResaltarnombreTipoCargaFami(Border borderResaltar) {
		this.resaltarnombreTipoCargaFami= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCargaFami() {
		return this.mostrarnombreTipoCargaFami;
	}

	public void setMostrarnombreTipoCargaFami(Boolean mostrarnombreTipoCargaFami) {
		this.mostrarnombreTipoCargaFami= mostrarnombreTipoCargaFami;
	}

	public Boolean getActivarnombreTipoCargaFami() {
		return this.activarnombreTipoCargaFami;
	}

	public void setActivarnombreTipoCargaFami(Boolean activarnombreTipoCargaFami) {
		this.activarnombreTipoCargaFami= activarnombreTipoCargaFami;
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
		
		
		this.setMostraridTipoCargaFami(esInicial);
		this.setMostrarcodigoTipoCargaFami(esInicial);
		this.setMostrarnombreTipoCargaFami(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCargaFamiConstantesFunciones.ID)) {
				this.setMostraridTipoCargaFami(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargaFamiConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCargaFami(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargaFamiConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCargaFami(esAsigna);
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
		
		
		this.setActivaridTipoCargaFami(esInicial);
		this.setActivarcodigoTipoCargaFami(esInicial);
		this.setActivarnombreTipoCargaFami(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCargaFamiConstantesFunciones.ID)) {
				this.setActivaridTipoCargaFami(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargaFamiConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCargaFami(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargaFamiConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCargaFami(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCargaFamiBeanSwingJInternalFrame tipocargafamiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCargaFami(esInicial);
		this.setResaltarcodigoTipoCargaFami(esInicial);
		this.setResaltarnombreTipoCargaFami(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCargaFamiConstantesFunciones.ID)) {
				this.setResaltaridTipoCargaFami(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargaFamiConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCargaFami(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCargaFamiConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCargaFami(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCargaFamiliar_NMTipoCargaFami=null;

	public Border getResaltarCargaFamiliar_NMTipoCargaFami() {
		return this.resaltarCargaFamiliar_NMTipoCargaFami;
	}

	public void setResaltarCargaFamiliar_NMTipoCargaFami(Border borderResaltarCargaFamiliar_NM) {
		if(borderResaltarCargaFamiliar_NM!=null) {
			this.resaltarCargaFamiliar_NMTipoCargaFami= borderResaltarCargaFamiliar_NM;
		}
	}

	public Border setResaltarCargaFamiliar_NMTipoCargaFami(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargaFamiBeanSwingJInternalFrame tipocargafamiBeanSwingJInternalFrame*/) {
		Border borderResaltarCargaFamiliar_NM=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocargafamiBeanSwingJInternalFrame.jTtoolBarTipoCargaFami.setBorder(borderResaltarCargaFamiliar_NM);
			
		this.resaltarCargaFamiliar_NMTipoCargaFami= borderResaltarCargaFamiliar_NM;

		 return borderResaltarCargaFamiliar_NM;
	}



	public Boolean mostrarCargaFamiliar_NMTipoCargaFami=true;

	public Boolean getMostrarCargaFamiliar_NMTipoCargaFami() {
		return this.mostrarCargaFamiliar_NMTipoCargaFami;
	}

	public void setMostrarCargaFamiliar_NMTipoCargaFami(Boolean visibilidadResaltarCargaFamiliar_NM) {
		this.mostrarCargaFamiliar_NMTipoCargaFami= visibilidadResaltarCargaFamiliar_NM;
	}



	public Boolean activarCargaFamiliar_NMTipoCargaFami=true;

	public Boolean gethabilitarResaltarCargaFamiliar_NMTipoCargaFami() {
		return this.activarCargaFamiliar_NMTipoCargaFami;
	}

	public void setActivarCargaFamiliar_NMTipoCargaFami(Boolean habilitarResaltarCargaFamiliar_NM) {
		this.activarCargaFamiliar_NMTipoCargaFami= habilitarResaltarCargaFamiliar_NM;
	}


	public Border resaltarCargaFamiliarTipoCargaFami=null;

	public Border getResaltarCargaFamiliarTipoCargaFami() {
		return this.resaltarCargaFamiliarTipoCargaFami;
	}

	public void setResaltarCargaFamiliarTipoCargaFami(Border borderResaltarCargaFamiliar) {
		if(borderResaltarCargaFamiliar!=null) {
			this.resaltarCargaFamiliarTipoCargaFami= borderResaltarCargaFamiliar;
		}
	}

	public Border setResaltarCargaFamiliarTipoCargaFami(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCargaFamiBeanSwingJInternalFrame tipocargafamiBeanSwingJInternalFrame*/) {
		Border borderResaltarCargaFamiliar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocargafamiBeanSwingJInternalFrame.jTtoolBarTipoCargaFami.setBorder(borderResaltarCargaFamiliar);
			
		this.resaltarCargaFamiliarTipoCargaFami= borderResaltarCargaFamiliar;

		 return borderResaltarCargaFamiliar;
	}



	public Boolean mostrarCargaFamiliarTipoCargaFami=true;

	public Boolean getMostrarCargaFamiliarTipoCargaFami() {
		return this.mostrarCargaFamiliarTipoCargaFami;
	}

	public void setMostrarCargaFamiliarTipoCargaFami(Boolean visibilidadResaltarCargaFamiliar) {
		this.mostrarCargaFamiliarTipoCargaFami= visibilidadResaltarCargaFamiliar;
	}



	public Boolean activarCargaFamiliarTipoCargaFami=true;

	public Boolean gethabilitarResaltarCargaFamiliarTipoCargaFami() {
		return this.activarCargaFamiliarTipoCargaFami;
	}

	public void setActivarCargaFamiliarTipoCargaFami(Boolean habilitarResaltarCargaFamiliar) {
		this.activarCargaFamiliarTipoCargaFami= habilitarResaltarCargaFamiliar;
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

		this.setMostrarCargaFamiliar_NMTipoCargaFami(esInicial);
		this.setMostrarCargaFamiliarTipoCargaFami(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setMostrarCargaFamiliar_NMTipoCargaFami(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setMostrarCargaFamiliarTipoCargaFami(esAsigna);
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

		this.setActivarCargaFamiliar_NMTipoCargaFami(esInicial);
		this.setActivarCargaFamiliarTipoCargaFami(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setActivarCargaFamiliar_NMTipoCargaFami(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setActivarCargaFamiliarTipoCargaFami(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCargaFamiBeanSwingJInternalFrame tipocargafamiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCargaFamiliar_NMTipoCargaFami(esInicial);
		this.setResaltarCargaFamiliarTipoCargaFami(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CargaFamiliar_NM.class)) {
				this.setResaltarCargaFamiliar_NMTipoCargaFami(esAsigna);
				continue;
			}

			if(clase.clas.equals(CargaFamiliar.class)) {
				this.setResaltarCargaFamiliarTipoCargaFami(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}