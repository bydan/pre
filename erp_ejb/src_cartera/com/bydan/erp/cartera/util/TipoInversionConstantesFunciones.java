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


import com.bydan.erp.cartera.util.TipoInversionConstantesFunciones;
import com.bydan.erp.cartera.util.TipoInversionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoInversionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoInversionConstantesFunciones extends TipoInversionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoInversion";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoInversion"+TipoInversionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoInversionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoInversionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoInversionConstantesFunciones.SCHEMA+"_"+TipoInversionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoInversionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoInversionConstantesFunciones.SCHEMA+"_"+TipoInversionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoInversionConstantesFunciones.SCHEMA+"_"+TipoInversionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoInversionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoInversionConstantesFunciones.SCHEMA+"_"+TipoInversionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInversionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoInversionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInversionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInversionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoInversionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInversionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoInversionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoInversionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoInversionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoInversionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Inversiones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Inversion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Inversion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoInversion";
	public static final String OBJECTNAME="tipoinversion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_inversion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoinversion from "+TipoInversionConstantesFunciones.SPERSISTENCENAME+" tipoinversion";
	public static String QUERYSELECTNATIVE="select "+TipoInversionConstantesFunciones.SCHEMA+"."+TipoInversionConstantesFunciones.TABLENAME+".id,"+TipoInversionConstantesFunciones.SCHEMA+"."+TipoInversionConstantesFunciones.TABLENAME+".version_row,"+TipoInversionConstantesFunciones.SCHEMA+"."+TipoInversionConstantesFunciones.TABLENAME+".id_empresa,"+TipoInversionConstantesFunciones.SCHEMA+"."+TipoInversionConstantesFunciones.TABLENAME+".codigo,"+TipoInversionConstantesFunciones.SCHEMA+"."+TipoInversionConstantesFunciones.TABLENAME+".nombre from "+TipoInversionConstantesFunciones.SCHEMA+"."+TipoInversionConstantesFunciones.TABLENAME;//+" as "+TipoInversionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoInversionConstantesFuncionesAdditional tipoinversionConstantesFuncionesAdditional=null;
	
	public TipoInversionConstantesFuncionesAdditional getTipoInversionConstantesFuncionesAdditional() {
		return this.tipoinversionConstantesFuncionesAdditional;
	}
	
	public void setTipoInversionConstantesFuncionesAdditional(TipoInversionConstantesFuncionesAdditional tipoinversionConstantesFuncionesAdditional) {
		try {
			this.tipoinversionConstantesFuncionesAdditional=tipoinversionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoInversionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoInversionConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoInversionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoInversionConstantesFunciones.CODIGO)) {sLabelColumna=TipoInversionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoInversionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoInversionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoInversionDescripcion(TipoInversion tipoinversion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoinversion !=null/* && tipoinversion.getId()!=0*/) {
			sDescripcion=tipoinversion.getcodigo();//tipoinversiontipoinversion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoInversionDescripcionDetallado(TipoInversion tipoinversion) {
		String sDescripcion="";
			
		sDescripcion+=TipoInversionConstantesFunciones.ID+"=";
		sDescripcion+=tipoinversion.getId().toString()+",";
		sDescripcion+=TipoInversionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoinversion.getVersionRow().toString()+",";
		sDescripcion+=TipoInversionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoinversion.getid_empresa().toString()+",";
		sDescripcion+=TipoInversionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoinversion.getcodigo()+",";
		sDescripcion+=TipoInversionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoinversion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoInversionDescripcion(TipoInversion tipoinversion,String sValor) throws Exception {			
		if(tipoinversion !=null) {
			tipoinversion.setcodigo(sValor);;//tipoinversiontipoinversion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoInversion(TipoInversion tipoinversion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoinversion.setcodigo(tipoinversion.getcodigo().trim());
		tipoinversion.setnombre(tipoinversion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoInversions(List<TipoInversion> tipoinversions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoInversion tipoinversion: tipoinversions) {
			tipoinversion.setcodigo(tipoinversion.getcodigo().trim());
			tipoinversion.setnombre(tipoinversion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoInversion(TipoInversion tipoinversion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoinversion.getConCambioAuxiliar()) {
			tipoinversion.setIsDeleted(tipoinversion.getIsDeletedAuxiliar());	
			tipoinversion.setIsNew(tipoinversion.getIsNewAuxiliar());	
			tipoinversion.setIsChanged(tipoinversion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoinversion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoinversion.setIsDeletedAuxiliar(false);	
			tipoinversion.setIsNewAuxiliar(false);	
			tipoinversion.setIsChangedAuxiliar(false);
			
			tipoinversion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoInversions(List<TipoInversion> tipoinversions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoInversion tipoinversion : tipoinversions) {
			if(conAsignarBase && tipoinversion.getConCambioAuxiliar()) {
				tipoinversion.setIsDeleted(tipoinversion.getIsDeletedAuxiliar());	
				tipoinversion.setIsNew(tipoinversion.getIsNewAuxiliar());	
				tipoinversion.setIsChanged(tipoinversion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoinversion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoinversion.setIsDeletedAuxiliar(false);	
				tipoinversion.setIsNewAuxiliar(false);	
				tipoinversion.setIsChangedAuxiliar(false);
				
				tipoinversion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoInversion(TipoInversion tipoinversion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoInversions(List<TipoInversion> tipoinversions,Boolean conEnteros) throws Exception  {
		
		for(TipoInversion tipoinversion: tipoinversions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoInversion(List<TipoInversion> tipoinversions,TipoInversion tipoinversionAux) throws Exception  {
		TipoInversionConstantesFunciones.InicializarValoresTipoInversion(tipoinversionAux,true);
		
		for(TipoInversion tipoinversion: tipoinversions) {
			if(tipoinversion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoInversion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoInversionConstantesFunciones.getArrayColumnasGlobalesTipoInversion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoInversion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoInversionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoInversionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoInversion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoInversion> tipoinversions,TipoInversion tipoinversion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoInversion tipoinversionAux: tipoinversions) {
			if(tipoinversionAux!=null && tipoinversion!=null) {
				if((tipoinversionAux.getId()==null && tipoinversion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoinversionAux.getId()!=null && tipoinversion.getId()!=null){
					if(tipoinversionAux.getId().equals(tipoinversion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoInversion(List<TipoInversion> tipoinversions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoInversion tipoinversion: tipoinversions) {			
			if(tipoinversion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoInversion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoInversionConstantesFunciones.LABEL_ID, TipoInversionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInversionConstantesFunciones.LABEL_VERSIONROW, TipoInversionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInversionConstantesFunciones.LABEL_IDEMPRESA, TipoInversionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInversionConstantesFunciones.LABEL_CODIGO, TipoInversionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInversionConstantesFunciones.LABEL_NOMBRE, TipoInversionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoInversion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoInversionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInversionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInversionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInversionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInversionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInversion() throws Exception  {
		return TipoInversionConstantesFunciones.getTiposSeleccionarTipoInversion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInversion(Boolean conFk) throws Exception  {
		return TipoInversionConstantesFunciones.getTiposSeleccionarTipoInversion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInversion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInversionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoInversionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInversionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoInversionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInversionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoInversionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoInversion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoInversion(TipoInversion tipoinversionAux) throws Exception {
		
			tipoinversionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoinversionAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoInversion(List<TipoInversion> tipoinversionsTemp) throws Exception {
		for(TipoInversion tipoinversionAux:tipoinversionsTemp) {
			
			tipoinversionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoinversionAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoInversion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoInversion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInversion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoInversionConstantesFunciones.getClassesRelationshipsOfTipoInversion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInversion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Accionista.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Accionista.class)) {
						classes.add(new Classe(Accionista.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoInversion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoInversionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoInversion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoInversion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Accionista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Accionista.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Accionista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Accionista.class)); continue;
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
	public static void actualizarLista(TipoInversion tipoinversion,List<TipoInversion> tipoinversions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoInversion tipoinversionEncontrado=null;
			
			for(TipoInversion tipoinversionLocal:tipoinversions) {
				if(tipoinversionLocal.getId().equals(tipoinversion.getId())) {
					tipoinversionEncontrado=tipoinversionLocal;
					
					tipoinversionLocal.setIsChanged(tipoinversion.getIsChanged());
					tipoinversionLocal.setIsNew(tipoinversion.getIsNew());
					tipoinversionLocal.setIsDeleted(tipoinversion.getIsDeleted());
					
					tipoinversionLocal.setGeneralEntityOriginal(tipoinversion.getGeneralEntityOriginal());
					
					tipoinversionLocal.setId(tipoinversion.getId());	
					tipoinversionLocal.setVersionRow(tipoinversion.getVersionRow());	
					tipoinversionLocal.setid_empresa(tipoinversion.getid_empresa());	
					tipoinversionLocal.setcodigo(tipoinversion.getcodigo());	
					tipoinversionLocal.setnombre(tipoinversion.getnombre());	
					
					
					tipoinversionLocal.setAccionistas(tipoinversion.getAccionistas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoinversion.getIsDeleted()) {
				if(!existe) {
					tipoinversions.add(tipoinversion);
				}
			} else {
				if(tipoinversionEncontrado!=null && permiteQuitar)  {
					tipoinversions.remove(tipoinversionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoInversion tipoinversion,List<TipoInversion> tipoinversions) throws Exception {
		try	{			
			for(TipoInversion tipoinversionLocal:tipoinversions) {
				if(tipoinversionLocal.getId().equals(tipoinversion.getId())) {
					tipoinversionLocal.setIsSelected(tipoinversion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoInversion(List<TipoInversion> tipoinversionsAux) throws Exception {
		//this.tipoinversionsAux=tipoinversionsAux;
		
		for(TipoInversion tipoinversionAux:tipoinversionsAux) {
			if(tipoinversionAux.getIsChanged()) {
				tipoinversionAux.setIsChanged(false);
			}		
			
			if(tipoinversionAux.getIsNew()) {
				tipoinversionAux.setIsNew(false);
			}	
			
			if(tipoinversionAux.getIsDeleted()) {
				tipoinversionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoInversion(TipoInversion tipoinversionAux) throws Exception {
		//this.tipoinversionAux=tipoinversionAux;
		
			if(tipoinversionAux.getIsChanged()) {
				tipoinversionAux.setIsChanged(false);
			}		
			
			if(tipoinversionAux.getIsNew()) {
				tipoinversionAux.setIsNew(false);
			}	
			
			if(tipoinversionAux.getIsDeleted()) {
				tipoinversionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoInversion tipoinversionAsignar,TipoInversion tipoinversion) throws Exception {
		tipoinversionAsignar.setId(tipoinversion.getId());	
		tipoinversionAsignar.setVersionRow(tipoinversion.getVersionRow());	
		tipoinversionAsignar.setid_empresa(tipoinversion.getid_empresa());
		tipoinversionAsignar.setempresa_descripcion(tipoinversion.getempresa_descripcion());	
		tipoinversionAsignar.setcodigo(tipoinversion.getcodigo());	
		tipoinversionAsignar.setnombre(tipoinversion.getnombre());	
	}
	
	public static void inicializarTipoInversion(TipoInversion tipoinversion) throws Exception {
		try {
				tipoinversion.setId(0L);	
					
				tipoinversion.setid_empresa(-1L);	
				tipoinversion.setcodigo("");	
				tipoinversion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoInversion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInversionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInversionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInversionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoInversion(String sTipo,Row row,Workbook workbook,TipoInversion tipoinversion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoinversion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoinversion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoinversion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoInversion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoInversion() {
		return this.sFinalQueryTipoInversion;
	}
	
	public void setsFinalQueryTipoInversion(String sFinalQueryTipoInversion) {
		this.sFinalQueryTipoInversion= sFinalQueryTipoInversion;
	}
	
	public Border resaltarSeleccionarTipoInversion=null;
	
	public Border setResaltarSeleccionarTipoInversion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInversionBeanSwingJInternalFrame tipoinversionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoinversionBeanSwingJInternalFrame.jTtoolBarTipoInversion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoInversion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoInversion() {
		return this.resaltarSeleccionarTipoInversion;
	}
	
	public void setResaltarSeleccionarTipoInversion(Border borderResaltarSeleccionarTipoInversion) {
		this.resaltarSeleccionarTipoInversion= borderResaltarSeleccionarTipoInversion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoInversion=null;
	public Boolean mostraridTipoInversion=true;
	public Boolean activaridTipoInversion=true;

	public Border resaltarid_empresaTipoInversion=null;
	public Boolean mostrarid_empresaTipoInversion=true;
	public Boolean activarid_empresaTipoInversion=true;
	public Boolean cargarid_empresaTipoInversion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoInversion=false;//ConEventDepend=true

	public Border resaltarcodigoTipoInversion=null;
	public Boolean mostrarcodigoTipoInversion=true;
	public Boolean activarcodigoTipoInversion=true;

	public Border resaltarnombreTipoInversion=null;
	public Boolean mostrarnombreTipoInversion=true;
	public Boolean activarnombreTipoInversion=true;

	
	

	public Border setResaltaridTipoInversion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInversionBeanSwingJInternalFrame tipoinversionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinversionBeanSwingJInternalFrame.jTtoolBarTipoInversion.setBorder(borderResaltar);
		
		this.resaltaridTipoInversion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoInversion() {
		return this.resaltaridTipoInversion;
	}

	public void setResaltaridTipoInversion(Border borderResaltar) {
		this.resaltaridTipoInversion= borderResaltar;
	}

	public Boolean getMostraridTipoInversion() {
		return this.mostraridTipoInversion;
	}

	public void setMostraridTipoInversion(Boolean mostraridTipoInversion) {
		this.mostraridTipoInversion= mostraridTipoInversion;
	}

	public Boolean getActivaridTipoInversion() {
		return this.activaridTipoInversion;
	}

	public void setActivaridTipoInversion(Boolean activaridTipoInversion) {
		this.activaridTipoInversion= activaridTipoInversion;
	}

	public Border setResaltarid_empresaTipoInversion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInversionBeanSwingJInternalFrame tipoinversionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinversionBeanSwingJInternalFrame.jTtoolBarTipoInversion.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoInversion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoInversion() {
		return this.resaltarid_empresaTipoInversion;
	}

	public void setResaltarid_empresaTipoInversion(Border borderResaltar) {
		this.resaltarid_empresaTipoInversion= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoInversion() {
		return this.mostrarid_empresaTipoInversion;
	}

	public void setMostrarid_empresaTipoInversion(Boolean mostrarid_empresaTipoInversion) {
		this.mostrarid_empresaTipoInversion= mostrarid_empresaTipoInversion;
	}

	public Boolean getActivarid_empresaTipoInversion() {
		return this.activarid_empresaTipoInversion;
	}

	public void setActivarid_empresaTipoInversion(Boolean activarid_empresaTipoInversion) {
		this.activarid_empresaTipoInversion= activarid_empresaTipoInversion;
	}

	public Boolean getCargarid_empresaTipoInversion() {
		return this.cargarid_empresaTipoInversion;
	}

	public void setCargarid_empresaTipoInversion(Boolean cargarid_empresaTipoInversion) {
		this.cargarid_empresaTipoInversion= cargarid_empresaTipoInversion;
	}

	public Border setResaltarcodigoTipoInversion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInversionBeanSwingJInternalFrame tipoinversionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinversionBeanSwingJInternalFrame.jTtoolBarTipoInversion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoInversion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoInversion() {
		return this.resaltarcodigoTipoInversion;
	}

	public void setResaltarcodigoTipoInversion(Border borderResaltar) {
		this.resaltarcodigoTipoInversion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoInversion() {
		return this.mostrarcodigoTipoInversion;
	}

	public void setMostrarcodigoTipoInversion(Boolean mostrarcodigoTipoInversion) {
		this.mostrarcodigoTipoInversion= mostrarcodigoTipoInversion;
	}

	public Boolean getActivarcodigoTipoInversion() {
		return this.activarcodigoTipoInversion;
	}

	public void setActivarcodigoTipoInversion(Boolean activarcodigoTipoInversion) {
		this.activarcodigoTipoInversion= activarcodigoTipoInversion;
	}

	public Border setResaltarnombreTipoInversion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInversionBeanSwingJInternalFrame tipoinversionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinversionBeanSwingJInternalFrame.jTtoolBarTipoInversion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoInversion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoInversion() {
		return this.resaltarnombreTipoInversion;
	}

	public void setResaltarnombreTipoInversion(Border borderResaltar) {
		this.resaltarnombreTipoInversion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoInversion() {
		return this.mostrarnombreTipoInversion;
	}

	public void setMostrarnombreTipoInversion(Boolean mostrarnombreTipoInversion) {
		this.mostrarnombreTipoInversion= mostrarnombreTipoInversion;
	}

	public Boolean getActivarnombreTipoInversion() {
		return this.activarnombreTipoInversion;
	}

	public void setActivarnombreTipoInversion(Boolean activarnombreTipoInversion) {
		this.activarnombreTipoInversion= activarnombreTipoInversion;
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
		
		
		this.setMostraridTipoInversion(esInicial);
		this.setMostrarid_empresaTipoInversion(esInicial);
		this.setMostrarcodigoTipoInversion(esInicial);
		this.setMostrarnombreTipoInversion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInversionConstantesFunciones.ID)) {
				this.setMostraridTipoInversion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInversionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoInversion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInversionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoInversion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInversionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoInversion(esAsigna);
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
		
		
		this.setActivaridTipoInversion(esInicial);
		this.setActivarid_empresaTipoInversion(esInicial);
		this.setActivarcodigoTipoInversion(esInicial);
		this.setActivarnombreTipoInversion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInversionConstantesFunciones.ID)) {
				this.setActivaridTipoInversion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInversionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoInversion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInversionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoInversion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInversionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoInversion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoInversionBeanSwingJInternalFrame tipoinversionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoInversion(esInicial);
		this.setResaltarid_empresaTipoInversion(esInicial);
		this.setResaltarcodigoTipoInversion(esInicial);
		this.setResaltarnombreTipoInversion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInversionConstantesFunciones.ID)) {
				this.setResaltaridTipoInversion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInversionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoInversion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInversionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoInversion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInversionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoInversion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarAccionistaTipoInversion=null;

	public Border getResaltarAccionistaTipoInversion() {
		return this.resaltarAccionistaTipoInversion;
	}

	public void setResaltarAccionistaTipoInversion(Border borderResaltarAccionista) {
		if(borderResaltarAccionista!=null) {
			this.resaltarAccionistaTipoInversion= borderResaltarAccionista;
		}
	}

	public Border setResaltarAccionistaTipoInversion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInversionBeanSwingJInternalFrame tipoinversionBeanSwingJInternalFrame*/) {
		Border borderResaltarAccionista=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoinversionBeanSwingJInternalFrame.jTtoolBarTipoInversion.setBorder(borderResaltarAccionista);
			
		this.resaltarAccionistaTipoInversion= borderResaltarAccionista;

		 return borderResaltarAccionista;
	}



	public Boolean mostrarAccionistaTipoInversion=true;

	public Boolean getMostrarAccionistaTipoInversion() {
		return this.mostrarAccionistaTipoInversion;
	}

	public void setMostrarAccionistaTipoInversion(Boolean visibilidadResaltarAccionista) {
		this.mostrarAccionistaTipoInversion= visibilidadResaltarAccionista;
	}



	public Boolean activarAccionistaTipoInversion=true;

	public Boolean gethabilitarResaltarAccionistaTipoInversion() {
		return this.activarAccionistaTipoInversion;
	}

	public void setActivarAccionistaTipoInversion(Boolean habilitarResaltarAccionista) {
		this.activarAccionistaTipoInversion= habilitarResaltarAccionista;
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

		this.setMostrarAccionistaTipoInversion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Accionista.class)) {
				this.setMostrarAccionistaTipoInversion(esAsigna);
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

		this.setActivarAccionistaTipoInversion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Accionista.class)) {
				this.setActivarAccionistaTipoInversion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoInversionBeanSwingJInternalFrame tipoinversionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarAccionistaTipoInversion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Accionista.class)) {
				this.setResaltarAccionistaTipoInversion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoInversion=true;

	public Boolean getMostrarFK_IdEmpresaTipoInversion() {
		return this.mostrarFK_IdEmpresaTipoInversion;
	}

	public void setMostrarFK_IdEmpresaTipoInversion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoInversion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoInversion=true;

	public Boolean getActivarFK_IdEmpresaTipoInversion() {
		return this.activarFK_IdEmpresaTipoInversion;
	}

	public void setActivarFK_IdEmpresaTipoInversion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoInversion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoInversion=null;

	public Border getResaltarFK_IdEmpresaTipoInversion() {
		return this.resaltarFK_IdEmpresaTipoInversion;
	}

	public void setResaltarFK_IdEmpresaTipoInversion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoInversion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoInversion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInversionBeanSwingJInternalFrame tipoinversionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoInversion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}