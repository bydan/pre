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


import com.bydan.erp.tesoreria.util.TipoMovimiento_TSConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoMovimiento_TSParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoMovimiento_TSParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoMovimiento_TSConstantesFunciones extends TipoMovimiento_TSConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoMovimiento_TS";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoMovimiento_TS"+TipoMovimiento_TSConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoMovimiento_TSHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoMovimiento_TSHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoMovimiento_TSConstantesFunciones.SCHEMA+"_"+TipoMovimiento_TSConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoMovimiento_TSHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoMovimiento_TSConstantesFunciones.SCHEMA+"_"+TipoMovimiento_TSConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoMovimiento_TSConstantesFunciones.SCHEMA+"_"+TipoMovimiento_TSConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoMovimiento_TSHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoMovimiento_TSConstantesFunciones.SCHEMA+"_"+TipoMovimiento_TSConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimiento_TSConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMovimiento_TSHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimiento_TSConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimiento_TSConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMovimiento_TSHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimiento_TSConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoMovimiento_TSConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoMovimiento_TSConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoMovimiento_TSConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoMovimiento_TSConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Movimiento_ T Ses";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Movimiento_ T S";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Movimiento_ T S";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoMovimiento_TS";
	public static final String OBJECTNAME="tipomovimiento_ts";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tipo_movimiento__t_s";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipomovimiento_ts from "+TipoMovimiento_TSConstantesFunciones.SPERSISTENCENAME+" tipomovimiento_ts";
	public static String QUERYSELECTNATIVE="select "+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".id,"+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".version_row,"+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".codigo,"+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".nombre,"+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".id_empresa from "+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME;//+" as "+TipoMovimiento_TSConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoMovimiento_TSConstantesFuncionesAdditional tipomovimiento_tsConstantesFuncionesAdditional=null;
	
	public TipoMovimiento_TSConstantesFuncionesAdditional getTipoMovimiento_TSConstantesFuncionesAdditional() {
		return this.tipomovimiento_tsConstantesFuncionesAdditional;
	}
	
	public void setTipoMovimiento_TSConstantesFuncionesAdditional(TipoMovimiento_TSConstantesFuncionesAdditional tipomovimiento_tsConstantesFuncionesAdditional) {
		try {
			this.tipomovimiento_tsConstantesFuncionesAdditional=tipomovimiento_tsConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDEMPRESA= "id_empresa";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getTipoMovimiento_TSLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoMovimiento_TSConstantesFunciones.CODIGO)) {sLabelColumna=TipoMovimiento_TSConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoMovimiento_TSConstantesFunciones.NOMBRE)) {sLabelColumna=TipoMovimiento_TSConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoMovimiento_TSConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoMovimiento_TSConstantesFunciones.LABEL_IDEMPRESA;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoMovimiento_TSDescripcion(TipoMovimiento_TS tipomovimiento_ts) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipomovimiento_ts !=null/* && tipomovimiento_ts.getId()!=0*/) {
			sDescripcion=tipomovimiento_ts.getcodigo();//tipomovimiento_tstipomovimiento_ts.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoMovimiento_TSDescripcionDetallado(TipoMovimiento_TS tipomovimiento_ts) {
		String sDescripcion="";
			
		sDescripcion+=TipoMovimiento_TSConstantesFunciones.ID+"=";
		sDescripcion+=tipomovimiento_ts.getId().toString()+",";
		sDescripcion+=TipoMovimiento_TSConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipomovimiento_ts.getVersionRow().toString()+",";
		sDescripcion+=TipoMovimiento_TSConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipomovimiento_ts.getcodigo()+",";
		sDescripcion+=TipoMovimiento_TSConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipomovimiento_ts.getnombre()+",";
		sDescripcion+=TipoMovimiento_TSConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipomovimiento_ts.getid_empresa().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoMovimiento_TSDescripcion(TipoMovimiento_TS tipomovimiento_ts,String sValor) throws Exception {			
		if(tipomovimiento_ts !=null) {
			tipomovimiento_ts.setcodigo(sValor);;//tipomovimiento_tstipomovimiento_ts.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoMovimiento_TS(TipoMovimiento_TS tipomovimiento_ts,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomovimiento_ts.setcodigo(tipomovimiento_ts.getcodigo().trim());
		tipomovimiento_ts.setnombre(tipomovimiento_ts.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoMovimiento_TSs(List<TipoMovimiento_TS> tipomovimiento_tss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoMovimiento_TS tipomovimiento_ts: tipomovimiento_tss) {
			tipomovimiento_ts.setcodigo(tipomovimiento_ts.getcodigo().trim());
			tipomovimiento_ts.setnombre(tipomovimiento_ts.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMovimiento_TS(TipoMovimiento_TS tipomovimiento_ts,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipomovimiento_ts.getConCambioAuxiliar()) {
			tipomovimiento_ts.setIsDeleted(tipomovimiento_ts.getIsDeletedAuxiliar());	
			tipomovimiento_ts.setIsNew(tipomovimiento_ts.getIsNewAuxiliar());	
			tipomovimiento_ts.setIsChanged(tipomovimiento_ts.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipomovimiento_ts.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipomovimiento_ts.setIsDeletedAuxiliar(false);	
			tipomovimiento_ts.setIsNewAuxiliar(false);	
			tipomovimiento_ts.setIsChangedAuxiliar(false);
			
			tipomovimiento_ts.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMovimiento_TSs(List<TipoMovimiento_TS> tipomovimiento_tss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoMovimiento_TS tipomovimiento_ts : tipomovimiento_tss) {
			if(conAsignarBase && tipomovimiento_ts.getConCambioAuxiliar()) {
				tipomovimiento_ts.setIsDeleted(tipomovimiento_ts.getIsDeletedAuxiliar());	
				tipomovimiento_ts.setIsNew(tipomovimiento_ts.getIsNewAuxiliar());	
				tipomovimiento_ts.setIsChanged(tipomovimiento_ts.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipomovimiento_ts.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipomovimiento_ts.setIsDeletedAuxiliar(false);	
				tipomovimiento_ts.setIsNewAuxiliar(false);	
				tipomovimiento_ts.setIsChangedAuxiliar(false);
				
				tipomovimiento_ts.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoMovimiento_TS(TipoMovimiento_TS tipomovimiento_ts,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoMovimiento_TSs(List<TipoMovimiento_TS> tipomovimiento_tss,Boolean conEnteros) throws Exception  {
		
		for(TipoMovimiento_TS tipomovimiento_ts: tipomovimiento_tss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoMovimiento_TS(List<TipoMovimiento_TS> tipomovimiento_tss,TipoMovimiento_TS tipomovimiento_tsAux) throws Exception  {
		TipoMovimiento_TSConstantesFunciones.InicializarValoresTipoMovimiento_TS(tipomovimiento_tsAux,true);
		
		for(TipoMovimiento_TS tipomovimiento_ts: tipomovimiento_tss) {
			if(tipomovimiento_ts.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMovimiento_TS(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoMovimiento_TSConstantesFunciones.getArrayColumnasGlobalesTipoMovimiento_TS(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMovimiento_TS(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoMovimiento_TSConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoMovimiento_TSConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoMovimiento_TS(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoMovimiento_TS> tipomovimiento_tss,TipoMovimiento_TS tipomovimiento_ts,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoMovimiento_TS tipomovimiento_tsAux: tipomovimiento_tss) {
			if(tipomovimiento_tsAux!=null && tipomovimiento_ts!=null) {
				if((tipomovimiento_tsAux.getId()==null && tipomovimiento_ts.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipomovimiento_tsAux.getId()!=null && tipomovimiento_ts.getId()!=null){
					if(tipomovimiento_tsAux.getId().equals(tipomovimiento_ts.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoMovimiento_TS(List<TipoMovimiento_TS> tipomovimiento_tss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoMovimiento_TS tipomovimiento_ts: tipomovimiento_tss) {			
			if(tipomovimiento_ts.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoMovimiento_TS() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoMovimiento_TSConstantesFunciones.LABEL_ID, TipoMovimiento_TSConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMovimiento_TSConstantesFunciones.LABEL_VERSIONROW, TipoMovimiento_TSConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMovimiento_TSConstantesFunciones.LABEL_CODIGO, TipoMovimiento_TSConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMovimiento_TSConstantesFunciones.LABEL_NOMBRE, TipoMovimiento_TSConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMovimiento_TSConstantesFunciones.LABEL_IDEMPRESA, TipoMovimiento_TSConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoMovimiento_TS() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoMovimiento_TSConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMovimiento_TSConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMovimiento_TSConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMovimiento_TSConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMovimiento_TSConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMovimiento_TS() throws Exception  {
		return TipoMovimiento_TSConstantesFunciones.getTiposSeleccionarTipoMovimiento_TS(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMovimiento_TS(Boolean conFk) throws Exception  {
		return TipoMovimiento_TSConstantesFunciones.getTiposSeleccionarTipoMovimiento_TS(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMovimiento_TS(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMovimiento_TSConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoMovimiento_TSConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMovimiento_TSConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoMovimiento_TSConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMovimiento_TSConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoMovimiento_TSConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoMovimiento_TS(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMovimiento_TS(TipoMovimiento_TS tipomovimiento_tsAux) throws Exception {
		
			tipomovimiento_tsAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipomovimiento_tsAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMovimiento_TS(List<TipoMovimiento_TS> tipomovimiento_tssTemp) throws Exception {
		for(TipoMovimiento_TS tipomovimiento_tsAux:tipomovimiento_tssTemp) {
			
			tipomovimiento_tsAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipomovimiento_tsAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMovimiento_TS(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoMovimiento_TS(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMovimiento_TS(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMovimiento_TSConstantesFunciones.getClassesRelationshipsOfTipoMovimiento_TS(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMovimiento_TS(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMovimiento_TS(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMovimiento_TSConstantesFunciones.getClassesRelationshipsFromStringsOfTipoMovimiento_TS(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMovimiento_TS(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoMovimiento_TS tipomovimiento_ts,List<TipoMovimiento_TS> tipomovimiento_tss,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoMovimiento_TS tipomovimiento_tsEncontrado=null;
			
			for(TipoMovimiento_TS tipomovimiento_tsLocal:tipomovimiento_tss) {
				if(tipomovimiento_tsLocal.getId().equals(tipomovimiento_ts.getId())) {
					tipomovimiento_tsEncontrado=tipomovimiento_tsLocal;
					
					tipomovimiento_tsLocal.setIsChanged(tipomovimiento_ts.getIsChanged());
					tipomovimiento_tsLocal.setIsNew(tipomovimiento_ts.getIsNew());
					tipomovimiento_tsLocal.setIsDeleted(tipomovimiento_ts.getIsDeleted());
					
					tipomovimiento_tsLocal.setGeneralEntityOriginal(tipomovimiento_ts.getGeneralEntityOriginal());
					
					tipomovimiento_tsLocal.setId(tipomovimiento_ts.getId());	
					tipomovimiento_tsLocal.setVersionRow(tipomovimiento_ts.getVersionRow());	
					tipomovimiento_tsLocal.setcodigo(tipomovimiento_ts.getcodigo());	
					tipomovimiento_tsLocal.setnombre(tipomovimiento_ts.getnombre());	
					tipomovimiento_tsLocal.setid_empresa(tipomovimiento_ts.getid_empresa());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipomovimiento_ts.getIsDeleted()) {
				if(!existe) {
					tipomovimiento_tss.add(tipomovimiento_ts);
				}
			} else {
				if(tipomovimiento_tsEncontrado!=null && permiteQuitar)  {
					tipomovimiento_tss.remove(tipomovimiento_tsEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoMovimiento_TS tipomovimiento_ts,List<TipoMovimiento_TS> tipomovimiento_tss) throws Exception {
		try	{			
			for(TipoMovimiento_TS tipomovimiento_tsLocal:tipomovimiento_tss) {
				if(tipomovimiento_tsLocal.getId().equals(tipomovimiento_ts.getId())) {
					tipomovimiento_tsLocal.setIsSelected(tipomovimiento_ts.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoMovimiento_TS(List<TipoMovimiento_TS> tipomovimiento_tssAux) throws Exception {
		//this.tipomovimiento_tssAux=tipomovimiento_tssAux;
		
		for(TipoMovimiento_TS tipomovimiento_tsAux:tipomovimiento_tssAux) {
			if(tipomovimiento_tsAux.getIsChanged()) {
				tipomovimiento_tsAux.setIsChanged(false);
			}		
			
			if(tipomovimiento_tsAux.getIsNew()) {
				tipomovimiento_tsAux.setIsNew(false);
			}	
			
			if(tipomovimiento_tsAux.getIsDeleted()) {
				tipomovimiento_tsAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoMovimiento_TS(TipoMovimiento_TS tipomovimiento_tsAux) throws Exception {
		//this.tipomovimiento_tsAux=tipomovimiento_tsAux;
		
			if(tipomovimiento_tsAux.getIsChanged()) {
				tipomovimiento_tsAux.setIsChanged(false);
			}		
			
			if(tipomovimiento_tsAux.getIsNew()) {
				tipomovimiento_tsAux.setIsNew(false);
			}	
			
			if(tipomovimiento_tsAux.getIsDeleted()) {
				tipomovimiento_tsAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoMovimiento_TS tipomovimiento_tsAsignar,TipoMovimiento_TS tipomovimiento_ts) throws Exception {
		tipomovimiento_tsAsignar.setId(tipomovimiento_ts.getId());	
		tipomovimiento_tsAsignar.setVersionRow(tipomovimiento_ts.getVersionRow());	
		tipomovimiento_tsAsignar.setcodigo(tipomovimiento_ts.getcodigo());	
		tipomovimiento_tsAsignar.setnombre(tipomovimiento_ts.getnombre());	
		tipomovimiento_tsAsignar.setid_empresa(tipomovimiento_ts.getid_empresa());
		tipomovimiento_tsAsignar.setempresa_descripcion(tipomovimiento_ts.getempresa_descripcion());	
	}
	
	public static void inicializarTipoMovimiento_TS(TipoMovimiento_TS tipomovimiento_ts) throws Exception {
		try {
				tipomovimiento_ts.setId(0L);	
					
				tipomovimiento_ts.setcodigo("");	
				tipomovimiento_ts.setnombre("");	
				tipomovimiento_ts.setid_empresa(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoMovimiento_TS(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMovimiento_TSConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMovimiento_TSConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMovimiento_TSConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoMovimiento_TS(String sTipo,Row row,Workbook workbook,TipoMovimiento_TS tipomovimiento_ts,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomovimiento_ts.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomovimiento_ts.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomovimiento_ts.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoMovimiento_TS=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoMovimiento_TS() {
		return this.sFinalQueryTipoMovimiento_TS;
	}
	
	public void setsFinalQueryTipoMovimiento_TS(String sFinalQueryTipoMovimiento_TS) {
		this.sFinalQueryTipoMovimiento_TS= sFinalQueryTipoMovimiento_TS;
	}
	
	public Border resaltarSeleccionarTipoMovimiento_TS=null;
	
	public Border setResaltarSeleccionarTipoMovimiento_TS(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimiento_TSBeanSwingJInternalFrame tipomovimiento_tsBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipomovimiento_tsBeanSwingJInternalFrame.jTtoolBarTipoMovimiento_TS.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoMovimiento_TS= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoMovimiento_TS() {
		return this.resaltarSeleccionarTipoMovimiento_TS;
	}
	
	public void setResaltarSeleccionarTipoMovimiento_TS(Border borderResaltarSeleccionarTipoMovimiento_TS) {
		this.resaltarSeleccionarTipoMovimiento_TS= borderResaltarSeleccionarTipoMovimiento_TS;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoMovimiento_TS=null;
	public Boolean mostraridTipoMovimiento_TS=true;
	public Boolean activaridTipoMovimiento_TS=true;

	public Border resaltarcodigoTipoMovimiento_TS=null;
	public Boolean mostrarcodigoTipoMovimiento_TS=true;
	public Boolean activarcodigoTipoMovimiento_TS=true;

	public Border resaltarnombreTipoMovimiento_TS=null;
	public Boolean mostrarnombreTipoMovimiento_TS=true;
	public Boolean activarnombreTipoMovimiento_TS=true;

	public Border resaltarid_empresaTipoMovimiento_TS=null;
	public Boolean mostrarid_empresaTipoMovimiento_TS=true;
	public Boolean activarid_empresaTipoMovimiento_TS=true;
	public Boolean cargarid_empresaTipoMovimiento_TS=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoMovimiento_TS=false;//ConEventDepend=true

	
	

	public Border setResaltaridTipoMovimiento_TS(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimiento_TSBeanSwingJInternalFrame tipomovimiento_tsBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovimiento_tsBeanSwingJInternalFrame.jTtoolBarTipoMovimiento_TS.setBorder(borderResaltar);
		
		this.resaltaridTipoMovimiento_TS= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoMovimiento_TS() {
		return this.resaltaridTipoMovimiento_TS;
	}

	public void setResaltaridTipoMovimiento_TS(Border borderResaltar) {
		this.resaltaridTipoMovimiento_TS= borderResaltar;
	}

	public Boolean getMostraridTipoMovimiento_TS() {
		return this.mostraridTipoMovimiento_TS;
	}

	public void setMostraridTipoMovimiento_TS(Boolean mostraridTipoMovimiento_TS) {
		this.mostraridTipoMovimiento_TS= mostraridTipoMovimiento_TS;
	}

	public Boolean getActivaridTipoMovimiento_TS() {
		return this.activaridTipoMovimiento_TS;
	}

	public void setActivaridTipoMovimiento_TS(Boolean activaridTipoMovimiento_TS) {
		this.activaridTipoMovimiento_TS= activaridTipoMovimiento_TS;
	}

	public Border setResaltarcodigoTipoMovimiento_TS(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimiento_TSBeanSwingJInternalFrame tipomovimiento_tsBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovimiento_tsBeanSwingJInternalFrame.jTtoolBarTipoMovimiento_TS.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoMovimiento_TS= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoMovimiento_TS() {
		return this.resaltarcodigoTipoMovimiento_TS;
	}

	public void setResaltarcodigoTipoMovimiento_TS(Border borderResaltar) {
		this.resaltarcodigoTipoMovimiento_TS= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoMovimiento_TS() {
		return this.mostrarcodigoTipoMovimiento_TS;
	}

	public void setMostrarcodigoTipoMovimiento_TS(Boolean mostrarcodigoTipoMovimiento_TS) {
		this.mostrarcodigoTipoMovimiento_TS= mostrarcodigoTipoMovimiento_TS;
	}

	public Boolean getActivarcodigoTipoMovimiento_TS() {
		return this.activarcodigoTipoMovimiento_TS;
	}

	public void setActivarcodigoTipoMovimiento_TS(Boolean activarcodigoTipoMovimiento_TS) {
		this.activarcodigoTipoMovimiento_TS= activarcodigoTipoMovimiento_TS;
	}

	public Border setResaltarnombreTipoMovimiento_TS(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimiento_TSBeanSwingJInternalFrame tipomovimiento_tsBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovimiento_tsBeanSwingJInternalFrame.jTtoolBarTipoMovimiento_TS.setBorder(borderResaltar);
		
		this.resaltarnombreTipoMovimiento_TS= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoMovimiento_TS() {
		return this.resaltarnombreTipoMovimiento_TS;
	}

	public void setResaltarnombreTipoMovimiento_TS(Border borderResaltar) {
		this.resaltarnombreTipoMovimiento_TS= borderResaltar;
	}

	public Boolean getMostrarnombreTipoMovimiento_TS() {
		return this.mostrarnombreTipoMovimiento_TS;
	}

	public void setMostrarnombreTipoMovimiento_TS(Boolean mostrarnombreTipoMovimiento_TS) {
		this.mostrarnombreTipoMovimiento_TS= mostrarnombreTipoMovimiento_TS;
	}

	public Boolean getActivarnombreTipoMovimiento_TS() {
		return this.activarnombreTipoMovimiento_TS;
	}

	public void setActivarnombreTipoMovimiento_TS(Boolean activarnombreTipoMovimiento_TS) {
		this.activarnombreTipoMovimiento_TS= activarnombreTipoMovimiento_TS;
	}

	public Border setResaltarid_empresaTipoMovimiento_TS(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimiento_TSBeanSwingJInternalFrame tipomovimiento_tsBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovimiento_tsBeanSwingJInternalFrame.jTtoolBarTipoMovimiento_TS.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoMovimiento_TS= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoMovimiento_TS() {
		return this.resaltarid_empresaTipoMovimiento_TS;
	}

	public void setResaltarid_empresaTipoMovimiento_TS(Border borderResaltar) {
		this.resaltarid_empresaTipoMovimiento_TS= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoMovimiento_TS() {
		return this.mostrarid_empresaTipoMovimiento_TS;
	}

	public void setMostrarid_empresaTipoMovimiento_TS(Boolean mostrarid_empresaTipoMovimiento_TS) {
		this.mostrarid_empresaTipoMovimiento_TS= mostrarid_empresaTipoMovimiento_TS;
	}

	public Boolean getActivarid_empresaTipoMovimiento_TS() {
		return this.activarid_empresaTipoMovimiento_TS;
	}

	public void setActivarid_empresaTipoMovimiento_TS(Boolean activarid_empresaTipoMovimiento_TS) {
		this.activarid_empresaTipoMovimiento_TS= activarid_empresaTipoMovimiento_TS;
	}

	public Boolean getCargarid_empresaTipoMovimiento_TS() {
		return this.cargarid_empresaTipoMovimiento_TS;
	}

	public void setCargarid_empresaTipoMovimiento_TS(Boolean cargarid_empresaTipoMovimiento_TS) {
		this.cargarid_empresaTipoMovimiento_TS= cargarid_empresaTipoMovimiento_TS;
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
		
		
		this.setMostraridTipoMovimiento_TS(esInicial);
		this.setMostrarcodigoTipoMovimiento_TS(esInicial);
		this.setMostrarnombreTipoMovimiento_TS(esInicial);
		this.setMostrarid_empresaTipoMovimiento_TS(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.ID)) {
				this.setMostraridTipoMovimiento_TS(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoMovimiento_TS(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoMovimiento_TS(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoMovimiento_TS(esAsigna);
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
		
		
		this.setActivaridTipoMovimiento_TS(esInicial);
		this.setActivarcodigoTipoMovimiento_TS(esInicial);
		this.setActivarnombreTipoMovimiento_TS(esInicial);
		this.setActivarid_empresaTipoMovimiento_TS(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.ID)) {
				this.setActivaridTipoMovimiento_TS(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoMovimiento_TS(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoMovimiento_TS(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoMovimiento_TS(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMovimiento_TSBeanSwingJInternalFrame tipomovimiento_tsBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoMovimiento_TS(esInicial);
		this.setResaltarcodigoTipoMovimiento_TS(esInicial);
		this.setResaltarnombreTipoMovimiento_TS(esInicial);
		this.setResaltarid_empresaTipoMovimiento_TS(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.ID)) {
				this.setResaltaridTipoMovimiento_TS(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoMovimiento_TS(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoMovimiento_TS(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimiento_TSConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoMovimiento_TS(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMovimiento_TSBeanSwingJInternalFrame tipomovimiento_tsBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoMovimiento_TS=true;

	public Boolean getMostrarFK_IdEmpresaTipoMovimiento_TS() {
		return this.mostrarFK_IdEmpresaTipoMovimiento_TS;
	}

	public void setMostrarFK_IdEmpresaTipoMovimiento_TS(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoMovimiento_TS= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoMovimiento_TS=true;

	public Boolean getActivarFK_IdEmpresaTipoMovimiento_TS() {
		return this.activarFK_IdEmpresaTipoMovimiento_TS;
	}

	public void setActivarFK_IdEmpresaTipoMovimiento_TS(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoMovimiento_TS= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoMovimiento_TS=null;

	public Border getResaltarFK_IdEmpresaTipoMovimiento_TS() {
		return this.resaltarFK_IdEmpresaTipoMovimiento_TS;
	}

	public void setResaltarFK_IdEmpresaTipoMovimiento_TS(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoMovimiento_TS= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoMovimiento_TS(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimiento_TSBeanSwingJInternalFrame tipomovimiento_tsBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoMovimiento_TS= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}