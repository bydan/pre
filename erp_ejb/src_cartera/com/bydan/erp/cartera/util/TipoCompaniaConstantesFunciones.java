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


import com.bydan.erp.cartera.util.TipoCompaniaConstantesFunciones;
import com.bydan.erp.cartera.util.TipoCompaniaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoCompaniaParameterGeneral;

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
final public class TipoCompaniaConstantesFunciones extends TipoCompaniaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCompania";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCompania"+TipoCompaniaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCompaniaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCompaniaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCompaniaConstantesFunciones.SCHEMA+"_"+TipoCompaniaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCompaniaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCompaniaConstantesFunciones.SCHEMA+"_"+TipoCompaniaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCompaniaConstantesFunciones.SCHEMA+"_"+TipoCompaniaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCompaniaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCompaniaConstantesFunciones.SCHEMA+"_"+TipoCompaniaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCompaniaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCompaniaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCompaniaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCompaniaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCompaniaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCompaniaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCompaniaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCompaniaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCompaniaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCompaniaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Companias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Compania";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Compania";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCompania";
	public static final String OBJECTNAME="tipocompania";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_compania";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocompania from "+TipoCompaniaConstantesFunciones.SPERSISTENCENAME+" tipocompania";
	public static String QUERYSELECTNATIVE="select "+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".id,"+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".version_row,"+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".id_empresa,"+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".codigo,"+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".nombre from "+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME;//+" as "+TipoCompaniaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoCompaniaConstantesFuncionesAdditional tipocompaniaConstantesFuncionesAdditional=null;
	
	public TipoCompaniaConstantesFuncionesAdditional getTipoCompaniaConstantesFuncionesAdditional() {
		return this.tipocompaniaConstantesFuncionesAdditional;
	}
	
	public void setTipoCompaniaConstantesFuncionesAdditional(TipoCompaniaConstantesFuncionesAdditional tipocompaniaConstantesFuncionesAdditional) {
		try {
			this.tipocompaniaConstantesFuncionesAdditional=tipocompaniaConstantesFuncionesAdditional;
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
	
	public static String getTipoCompaniaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCompaniaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoCompaniaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoCompaniaConstantesFunciones.CODIGO)) {sLabelColumna=TipoCompaniaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCompaniaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCompaniaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoCompaniaDescripcion(TipoCompania tipocompania) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocompania !=null/* && tipocompania.getId()!=0*/) {
			sDescripcion=tipocompania.getcodigo();//tipocompaniatipocompania.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCompaniaDescripcionDetallado(TipoCompania tipocompania) {
		String sDescripcion="";
			
		sDescripcion+=TipoCompaniaConstantesFunciones.ID+"=";
		sDescripcion+=tipocompania.getId().toString()+",";
		sDescripcion+=TipoCompaniaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocompania.getVersionRow().toString()+",";
		sDescripcion+=TipoCompaniaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocompania.getid_empresa().toString()+",";
		sDescripcion+=TipoCompaniaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocompania.getcodigo()+",";
		sDescripcion+=TipoCompaniaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocompania.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCompaniaDescripcion(TipoCompania tipocompania,String sValor) throws Exception {			
		if(tipocompania !=null) {
			tipocompania.setcodigo(sValor);;//tipocompaniatipocompania.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoCompania(TipoCompania tipocompania,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocompania.setcodigo(tipocompania.getcodigo().trim());
		tipocompania.setnombre(tipocompania.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCompanias(List<TipoCompania> tipocompanias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCompania tipocompania: tipocompanias) {
			tipocompania.setcodigo(tipocompania.getcodigo().trim());
			tipocompania.setnombre(tipocompania.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCompania(TipoCompania tipocompania,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocompania.getConCambioAuxiliar()) {
			tipocompania.setIsDeleted(tipocompania.getIsDeletedAuxiliar());	
			tipocompania.setIsNew(tipocompania.getIsNewAuxiliar());	
			tipocompania.setIsChanged(tipocompania.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocompania.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocompania.setIsDeletedAuxiliar(false);	
			tipocompania.setIsNewAuxiliar(false);	
			tipocompania.setIsChangedAuxiliar(false);
			
			tipocompania.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCompanias(List<TipoCompania> tipocompanias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCompania tipocompania : tipocompanias) {
			if(conAsignarBase && tipocompania.getConCambioAuxiliar()) {
				tipocompania.setIsDeleted(tipocompania.getIsDeletedAuxiliar());	
				tipocompania.setIsNew(tipocompania.getIsNewAuxiliar());	
				tipocompania.setIsChanged(tipocompania.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocompania.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocompania.setIsDeletedAuxiliar(false);	
				tipocompania.setIsNewAuxiliar(false);	
				tipocompania.setIsChangedAuxiliar(false);
				
				tipocompania.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCompania(TipoCompania tipocompania,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCompanias(List<TipoCompania> tipocompanias,Boolean conEnteros) throws Exception  {
		
		for(TipoCompania tipocompania: tipocompanias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCompania(List<TipoCompania> tipocompanias,TipoCompania tipocompaniaAux) throws Exception  {
		TipoCompaniaConstantesFunciones.InicializarValoresTipoCompania(tipocompaniaAux,true);
		
		for(TipoCompania tipocompania: tipocompanias) {
			if(tipocompania.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCompania(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCompaniaConstantesFunciones.getArrayColumnasGlobalesTipoCompania(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCompania(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoCompaniaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoCompaniaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCompania(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCompania> tipocompanias,TipoCompania tipocompania,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCompania tipocompaniaAux: tipocompanias) {
			if(tipocompaniaAux!=null && tipocompania!=null) {
				if((tipocompaniaAux.getId()==null && tipocompania.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocompaniaAux.getId()!=null && tipocompania.getId()!=null){
					if(tipocompaniaAux.getId().equals(tipocompania.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCompania(List<TipoCompania> tipocompanias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCompania tipocompania: tipocompanias) {			
			if(tipocompania.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCompania() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCompaniaConstantesFunciones.LABEL_ID, TipoCompaniaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCompaniaConstantesFunciones.LABEL_VERSIONROW, TipoCompaniaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCompaniaConstantesFunciones.LABEL_IDEMPRESA, TipoCompaniaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCompaniaConstantesFunciones.LABEL_CODIGO, TipoCompaniaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCompaniaConstantesFunciones.LABEL_NOMBRE, TipoCompaniaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCompania() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCompaniaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCompaniaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCompaniaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCompaniaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCompaniaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCompania() throws Exception  {
		return TipoCompaniaConstantesFunciones.getTiposSeleccionarTipoCompania(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCompania(Boolean conFk) throws Exception  {
		return TipoCompaniaConstantesFunciones.getTiposSeleccionarTipoCompania(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCompania(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCompaniaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoCompaniaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCompaniaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCompaniaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCompaniaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCompaniaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCompania(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCompania(TipoCompania tipocompaniaAux) throws Exception {
		
			tipocompaniaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocompaniaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCompania(List<TipoCompania> tipocompaniasTemp) throws Exception {
		for(TipoCompania tipocompaniaAux:tipocompaniasTemp) {
			
			tipocompaniaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocompaniaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCompania(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCompania(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCompania(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCompaniaConstantesFunciones.getClassesRelationshipsOfTipoCompania(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCompania(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DatoConstitucion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoConstitucion.class)) {
						classes.add(new Classe(DatoConstitucion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCompania(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCompaniaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCompania(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCompania(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoConstitucion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoConstitucion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoConstitucion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoConstitucion.class)); continue;
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
	public static void actualizarLista(TipoCompania tipocompania,List<TipoCompania> tipocompanias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCompania tipocompaniaEncontrado=null;
			
			for(TipoCompania tipocompaniaLocal:tipocompanias) {
				if(tipocompaniaLocal.getId().equals(tipocompania.getId())) {
					tipocompaniaEncontrado=tipocompaniaLocal;
					
					tipocompaniaLocal.setIsChanged(tipocompania.getIsChanged());
					tipocompaniaLocal.setIsNew(tipocompania.getIsNew());
					tipocompaniaLocal.setIsDeleted(tipocompania.getIsDeleted());
					
					tipocompaniaLocal.setGeneralEntityOriginal(tipocompania.getGeneralEntityOriginal());
					
					tipocompaniaLocal.setId(tipocompania.getId());	
					tipocompaniaLocal.setVersionRow(tipocompania.getVersionRow());	
					tipocompaniaLocal.setid_empresa(tipocompania.getid_empresa());	
					tipocompaniaLocal.setcodigo(tipocompania.getcodigo());	
					tipocompaniaLocal.setnombre(tipocompania.getnombre());	
					
					
					tipocompaniaLocal.setDatoConstitucions(tipocompania.getDatoConstitucions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocompania.getIsDeleted()) {
				if(!existe) {
					tipocompanias.add(tipocompania);
				}
			} else {
				if(tipocompaniaEncontrado!=null && permiteQuitar)  {
					tipocompanias.remove(tipocompaniaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCompania tipocompania,List<TipoCompania> tipocompanias) throws Exception {
		try	{			
			for(TipoCompania tipocompaniaLocal:tipocompanias) {
				if(tipocompaniaLocal.getId().equals(tipocompania.getId())) {
					tipocompaniaLocal.setIsSelected(tipocompania.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCompania(List<TipoCompania> tipocompaniasAux) throws Exception {
		//this.tipocompaniasAux=tipocompaniasAux;
		
		for(TipoCompania tipocompaniaAux:tipocompaniasAux) {
			if(tipocompaniaAux.getIsChanged()) {
				tipocompaniaAux.setIsChanged(false);
			}		
			
			if(tipocompaniaAux.getIsNew()) {
				tipocompaniaAux.setIsNew(false);
			}	
			
			if(tipocompaniaAux.getIsDeleted()) {
				tipocompaniaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCompania(TipoCompania tipocompaniaAux) throws Exception {
		//this.tipocompaniaAux=tipocompaniaAux;
		
			if(tipocompaniaAux.getIsChanged()) {
				tipocompaniaAux.setIsChanged(false);
			}		
			
			if(tipocompaniaAux.getIsNew()) {
				tipocompaniaAux.setIsNew(false);
			}	
			
			if(tipocompaniaAux.getIsDeleted()) {
				tipocompaniaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCompania tipocompaniaAsignar,TipoCompania tipocompania) throws Exception {
		tipocompaniaAsignar.setId(tipocompania.getId());	
		tipocompaniaAsignar.setVersionRow(tipocompania.getVersionRow());	
		tipocompaniaAsignar.setid_empresa(tipocompania.getid_empresa());
		tipocompaniaAsignar.setempresa_descripcion(tipocompania.getempresa_descripcion());	
		tipocompaniaAsignar.setcodigo(tipocompania.getcodigo());	
		tipocompaniaAsignar.setnombre(tipocompania.getnombre());	
	}
	
	public static void inicializarTipoCompania(TipoCompania tipocompania) throws Exception {
		try {
				tipocompania.setId(0L);	
					
				tipocompania.setid_empresa(-1L);	
				tipocompania.setcodigo("");	
				tipocompania.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCompania(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCompaniaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCompaniaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCompaniaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCompania(String sTipo,Row row,Workbook workbook,TipoCompania tipocompania,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocompania.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocompania.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocompania.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCompania=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCompania() {
		return this.sFinalQueryTipoCompania;
	}
	
	public void setsFinalQueryTipoCompania(String sFinalQueryTipoCompania) {
		this.sFinalQueryTipoCompania= sFinalQueryTipoCompania;
	}
	
	public Border resaltarSeleccionarTipoCompania=null;
	
	public Border setResaltarSeleccionarTipoCompania(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCompaniaBeanSwingJInternalFrame tipocompaniaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocompaniaBeanSwingJInternalFrame.jTtoolBarTipoCompania.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCompania= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCompania() {
		return this.resaltarSeleccionarTipoCompania;
	}
	
	public void setResaltarSeleccionarTipoCompania(Border borderResaltarSeleccionarTipoCompania) {
		this.resaltarSeleccionarTipoCompania= borderResaltarSeleccionarTipoCompania;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCompania=null;
	public Boolean mostraridTipoCompania=true;
	public Boolean activaridTipoCompania=true;

	public Border resaltarid_empresaTipoCompania=null;
	public Boolean mostrarid_empresaTipoCompania=true;
	public Boolean activarid_empresaTipoCompania=true;
	public Boolean cargarid_empresaTipoCompania=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoCompania=false;//ConEventDepend=true

	public Border resaltarcodigoTipoCompania=null;
	public Boolean mostrarcodigoTipoCompania=true;
	public Boolean activarcodigoTipoCompania=true;

	public Border resaltarnombreTipoCompania=null;
	public Boolean mostrarnombreTipoCompania=true;
	public Boolean activarnombreTipoCompania=true;

	
	

	public Border setResaltaridTipoCompania(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCompaniaBeanSwingJInternalFrame tipocompaniaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocompaniaBeanSwingJInternalFrame.jTtoolBarTipoCompania.setBorder(borderResaltar);
		
		this.resaltaridTipoCompania= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCompania() {
		return this.resaltaridTipoCompania;
	}

	public void setResaltaridTipoCompania(Border borderResaltar) {
		this.resaltaridTipoCompania= borderResaltar;
	}

	public Boolean getMostraridTipoCompania() {
		return this.mostraridTipoCompania;
	}

	public void setMostraridTipoCompania(Boolean mostraridTipoCompania) {
		this.mostraridTipoCompania= mostraridTipoCompania;
	}

	public Boolean getActivaridTipoCompania() {
		return this.activaridTipoCompania;
	}

	public void setActivaridTipoCompania(Boolean activaridTipoCompania) {
		this.activaridTipoCompania= activaridTipoCompania;
	}

	public Border setResaltarid_empresaTipoCompania(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCompaniaBeanSwingJInternalFrame tipocompaniaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocompaniaBeanSwingJInternalFrame.jTtoolBarTipoCompania.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoCompania= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoCompania() {
		return this.resaltarid_empresaTipoCompania;
	}

	public void setResaltarid_empresaTipoCompania(Border borderResaltar) {
		this.resaltarid_empresaTipoCompania= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoCompania() {
		return this.mostrarid_empresaTipoCompania;
	}

	public void setMostrarid_empresaTipoCompania(Boolean mostrarid_empresaTipoCompania) {
		this.mostrarid_empresaTipoCompania= mostrarid_empresaTipoCompania;
	}

	public Boolean getActivarid_empresaTipoCompania() {
		return this.activarid_empresaTipoCompania;
	}

	public void setActivarid_empresaTipoCompania(Boolean activarid_empresaTipoCompania) {
		this.activarid_empresaTipoCompania= activarid_empresaTipoCompania;
	}

	public Boolean getCargarid_empresaTipoCompania() {
		return this.cargarid_empresaTipoCompania;
	}

	public void setCargarid_empresaTipoCompania(Boolean cargarid_empresaTipoCompania) {
		this.cargarid_empresaTipoCompania= cargarid_empresaTipoCompania;
	}

	public Border setResaltarcodigoTipoCompania(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCompaniaBeanSwingJInternalFrame tipocompaniaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocompaniaBeanSwingJInternalFrame.jTtoolBarTipoCompania.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCompania= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCompania() {
		return this.resaltarcodigoTipoCompania;
	}

	public void setResaltarcodigoTipoCompania(Border borderResaltar) {
		this.resaltarcodigoTipoCompania= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCompania() {
		return this.mostrarcodigoTipoCompania;
	}

	public void setMostrarcodigoTipoCompania(Boolean mostrarcodigoTipoCompania) {
		this.mostrarcodigoTipoCompania= mostrarcodigoTipoCompania;
	}

	public Boolean getActivarcodigoTipoCompania() {
		return this.activarcodigoTipoCompania;
	}

	public void setActivarcodigoTipoCompania(Boolean activarcodigoTipoCompania) {
		this.activarcodigoTipoCompania= activarcodigoTipoCompania;
	}

	public Border setResaltarnombreTipoCompania(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCompaniaBeanSwingJInternalFrame tipocompaniaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocompaniaBeanSwingJInternalFrame.jTtoolBarTipoCompania.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCompania= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCompania() {
		return this.resaltarnombreTipoCompania;
	}

	public void setResaltarnombreTipoCompania(Border borderResaltar) {
		this.resaltarnombreTipoCompania= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCompania() {
		return this.mostrarnombreTipoCompania;
	}

	public void setMostrarnombreTipoCompania(Boolean mostrarnombreTipoCompania) {
		this.mostrarnombreTipoCompania= mostrarnombreTipoCompania;
	}

	public Boolean getActivarnombreTipoCompania() {
		return this.activarnombreTipoCompania;
	}

	public void setActivarnombreTipoCompania(Boolean activarnombreTipoCompania) {
		this.activarnombreTipoCompania= activarnombreTipoCompania;
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
		
		
		this.setMostraridTipoCompania(esInicial);
		this.setMostrarid_empresaTipoCompania(esInicial);
		this.setMostrarcodigoTipoCompania(esInicial);
		this.setMostrarnombreTipoCompania(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.ID)) {
				this.setMostraridTipoCompania(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoCompania(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCompania(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCompania(esAsigna);
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
		
		
		this.setActivaridTipoCompania(esInicial);
		this.setActivarid_empresaTipoCompania(esInicial);
		this.setActivarcodigoTipoCompania(esInicial);
		this.setActivarnombreTipoCompania(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.ID)) {
				this.setActivaridTipoCompania(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoCompania(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCompania(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCompania(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCompaniaBeanSwingJInternalFrame tipocompaniaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCompania(esInicial);
		this.setResaltarid_empresaTipoCompania(esInicial);
		this.setResaltarcodigoTipoCompania(esInicial);
		this.setResaltarnombreTipoCompania(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.ID)) {
				this.setResaltaridTipoCompania(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoCompania(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCompania(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCompaniaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCompania(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDatoConstitucionTipoCompania=null;

	public Border getResaltarDatoConstitucionTipoCompania() {
		return this.resaltarDatoConstitucionTipoCompania;
	}

	public void setResaltarDatoConstitucionTipoCompania(Border borderResaltarDatoConstitucion) {
		if(borderResaltarDatoConstitucion!=null) {
			this.resaltarDatoConstitucionTipoCompania= borderResaltarDatoConstitucion;
		}
	}

	public Border setResaltarDatoConstitucionTipoCompania(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCompaniaBeanSwingJInternalFrame tipocompaniaBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoConstitucion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocompaniaBeanSwingJInternalFrame.jTtoolBarTipoCompania.setBorder(borderResaltarDatoConstitucion);
			
		this.resaltarDatoConstitucionTipoCompania= borderResaltarDatoConstitucion;

		 return borderResaltarDatoConstitucion;
	}



	public Boolean mostrarDatoConstitucionTipoCompania=true;

	public Boolean getMostrarDatoConstitucionTipoCompania() {
		return this.mostrarDatoConstitucionTipoCompania;
	}

	public void setMostrarDatoConstitucionTipoCompania(Boolean visibilidadResaltarDatoConstitucion) {
		this.mostrarDatoConstitucionTipoCompania= visibilidadResaltarDatoConstitucion;
	}



	public Boolean activarDatoConstitucionTipoCompania=true;

	public Boolean gethabilitarResaltarDatoConstitucionTipoCompania() {
		return this.activarDatoConstitucionTipoCompania;
	}

	public void setActivarDatoConstitucionTipoCompania(Boolean habilitarResaltarDatoConstitucion) {
		this.activarDatoConstitucionTipoCompania= habilitarResaltarDatoConstitucion;
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

		this.setMostrarDatoConstitucionTipoCompania(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoConstitucion.class)) {
				this.setMostrarDatoConstitucionTipoCompania(esAsigna);
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

		this.setActivarDatoConstitucionTipoCompania(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoConstitucion.class)) {
				this.setActivarDatoConstitucionTipoCompania(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCompaniaBeanSwingJInternalFrame tipocompaniaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDatoConstitucionTipoCompania(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoConstitucion.class)) {
				this.setResaltarDatoConstitucionTipoCompania(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoCompania=true;

	public Boolean getMostrarFK_IdEmpresaTipoCompania() {
		return this.mostrarFK_IdEmpresaTipoCompania;
	}

	public void setMostrarFK_IdEmpresaTipoCompania(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoCompania= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoCompania=true;

	public Boolean getActivarFK_IdEmpresaTipoCompania() {
		return this.activarFK_IdEmpresaTipoCompania;
	}

	public void setActivarFK_IdEmpresaTipoCompania(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoCompania= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoCompania=null;

	public Border getResaltarFK_IdEmpresaTipoCompania() {
		return this.resaltarFK_IdEmpresaTipoCompania;
	}

	public void setResaltarFK_IdEmpresaTipoCompania(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoCompania= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoCompania(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCompaniaBeanSwingJInternalFrame tipocompaniaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoCompania= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}