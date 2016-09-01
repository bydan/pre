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


import com.bydan.erp.cartera.util.TipoTelefoConstantesFunciones;
import com.bydan.erp.cartera.util.TipoTelefoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoTelefoParameterGeneral;

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
final public class TipoTelefoConstantesFunciones extends TipoTelefoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoTelefo";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoTelefo"+TipoTelefoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoTelefoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoTelefoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoTelefoConstantesFunciones.SCHEMA+"_"+TipoTelefoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoTelefoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoTelefoConstantesFunciones.SCHEMA+"_"+TipoTelefoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoTelefoConstantesFunciones.SCHEMA+"_"+TipoTelefoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoTelefoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoTelefoConstantesFunciones.SCHEMA+"_"+TipoTelefoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTelefoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTelefoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTelefoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTelefoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTelefoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTelefoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoTelefoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoTelefoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoTelefoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoTelefoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Telefos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Telefo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Telefo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoTelefo";
	public static final String OBJECTNAME="tipotelefo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_telefo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipotelefo from "+TipoTelefoConstantesFunciones.SPERSISTENCENAME+" tipotelefo";
	public static String QUERYSELECTNATIVE="select "+TipoTelefoConstantesFunciones.SCHEMA+"."+TipoTelefoConstantesFunciones.TABLENAME+".id,"+TipoTelefoConstantesFunciones.SCHEMA+"."+TipoTelefoConstantesFunciones.TABLENAME+".version_row,"+TipoTelefoConstantesFunciones.SCHEMA+"."+TipoTelefoConstantesFunciones.TABLENAME+".id_empresa,"+TipoTelefoConstantesFunciones.SCHEMA+"."+TipoTelefoConstantesFunciones.TABLENAME+".codigo,"+TipoTelefoConstantesFunciones.SCHEMA+"."+TipoTelefoConstantesFunciones.TABLENAME+".nombre from "+TipoTelefoConstantesFunciones.SCHEMA+"."+TipoTelefoConstantesFunciones.TABLENAME;//+" as "+TipoTelefoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoTelefoConstantesFuncionesAdditional tipotelefoConstantesFuncionesAdditional=null;
	
	public TipoTelefoConstantesFuncionesAdditional getTipoTelefoConstantesFuncionesAdditional() {
		return this.tipotelefoConstantesFuncionesAdditional;
	}
	
	public void setTipoTelefoConstantesFuncionesAdditional(TipoTelefoConstantesFuncionesAdditional tipotelefoConstantesFuncionesAdditional) {
		try {
			this.tipotelefoConstantesFuncionesAdditional=tipotelefoConstantesFuncionesAdditional;
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
	
	public static String getTipoTelefoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoTelefoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoTelefoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoTelefoConstantesFunciones.CODIGO)) {sLabelColumna=TipoTelefoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoTelefoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoTelefoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoTelefoDescripcion(TipoTelefo tipotelefo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipotelefo !=null/* && tipotelefo.getId()!=0*/) {
			sDescripcion=tipotelefo.getcodigo();//tipotelefotipotelefo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoTelefoDescripcionDetallado(TipoTelefo tipotelefo) {
		String sDescripcion="";
			
		sDescripcion+=TipoTelefoConstantesFunciones.ID+"=";
		sDescripcion+=tipotelefo.getId().toString()+",";
		sDescripcion+=TipoTelefoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipotelefo.getVersionRow().toString()+",";
		sDescripcion+=TipoTelefoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipotelefo.getid_empresa().toString()+",";
		sDescripcion+=TipoTelefoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipotelefo.getcodigo()+",";
		sDescripcion+=TipoTelefoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipotelefo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoTelefoDescripcion(TipoTelefo tipotelefo,String sValor) throws Exception {			
		if(tipotelefo !=null) {
			tipotelefo.setcodigo(sValor);;//tipotelefotipotelefo.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoTelefo(TipoTelefo tipotelefo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipotelefo.setcodigo(tipotelefo.getcodigo().trim());
		tipotelefo.setnombre(tipotelefo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoTelefos(List<TipoTelefo> tipotelefos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoTelefo tipotelefo: tipotelefos) {
			tipotelefo.setcodigo(tipotelefo.getcodigo().trim());
			tipotelefo.setnombre(tipotelefo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTelefo(TipoTelefo tipotelefo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipotelefo.getConCambioAuxiliar()) {
			tipotelefo.setIsDeleted(tipotelefo.getIsDeletedAuxiliar());	
			tipotelefo.setIsNew(tipotelefo.getIsNewAuxiliar());	
			tipotelefo.setIsChanged(tipotelefo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipotelefo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipotelefo.setIsDeletedAuxiliar(false);	
			tipotelefo.setIsNewAuxiliar(false);	
			tipotelefo.setIsChangedAuxiliar(false);
			
			tipotelefo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTelefos(List<TipoTelefo> tipotelefos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoTelefo tipotelefo : tipotelefos) {
			if(conAsignarBase && tipotelefo.getConCambioAuxiliar()) {
				tipotelefo.setIsDeleted(tipotelefo.getIsDeletedAuxiliar());	
				tipotelefo.setIsNew(tipotelefo.getIsNewAuxiliar());	
				tipotelefo.setIsChanged(tipotelefo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipotelefo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipotelefo.setIsDeletedAuxiliar(false);	
				tipotelefo.setIsNewAuxiliar(false);	
				tipotelefo.setIsChangedAuxiliar(false);
				
				tipotelefo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoTelefo(TipoTelefo tipotelefo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoTelefos(List<TipoTelefo> tipotelefos,Boolean conEnteros) throws Exception  {
		
		for(TipoTelefo tipotelefo: tipotelefos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoTelefo(List<TipoTelefo> tipotelefos,TipoTelefo tipotelefoAux) throws Exception  {
		TipoTelefoConstantesFunciones.InicializarValoresTipoTelefo(tipotelefoAux,true);
		
		for(TipoTelefo tipotelefo: tipotelefos) {
			if(tipotelefo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTelefo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoTelefoConstantesFunciones.getArrayColumnasGlobalesTipoTelefo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTelefo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoTelefoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoTelefoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoTelefo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoTelefo> tipotelefos,TipoTelefo tipotelefo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoTelefo tipotelefoAux: tipotelefos) {
			if(tipotelefoAux!=null && tipotelefo!=null) {
				if((tipotelefoAux.getId()==null && tipotelefo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipotelefoAux.getId()!=null && tipotelefo.getId()!=null){
					if(tipotelefoAux.getId().equals(tipotelefo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoTelefo(List<TipoTelefo> tipotelefos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoTelefo tipotelefo: tipotelefos) {			
			if(tipotelefo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoTelefo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoTelefoConstantesFunciones.LABEL_ID, TipoTelefoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTelefoConstantesFunciones.LABEL_VERSIONROW, TipoTelefoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTelefoConstantesFunciones.LABEL_IDEMPRESA, TipoTelefoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTelefoConstantesFunciones.LABEL_CODIGO, TipoTelefoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTelefoConstantesFunciones.LABEL_NOMBRE, TipoTelefoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoTelefo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoTelefoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTelefoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTelefoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTelefoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTelefoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTelefo() throws Exception  {
		return TipoTelefoConstantesFunciones.getTiposSeleccionarTipoTelefo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTelefo(Boolean conFk) throws Exception  {
		return TipoTelefoConstantesFunciones.getTiposSeleccionarTipoTelefo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTelefo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTelefoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoTelefoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTelefoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoTelefoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTelefoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoTelefoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoTelefo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTelefo(TipoTelefo tipotelefoAux) throws Exception {
		
			tipotelefoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipotelefoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTelefo(List<TipoTelefo> tipotelefosTemp) throws Exception {
		for(TipoTelefo tipotelefoAux:tipotelefosTemp) {
			
			tipotelefoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipotelefoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTelefo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoTelefo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTelefo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTelefoConstantesFunciones.getClassesRelationshipsOfTipoTelefo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTelefo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Telefono.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Telefono.class)) {
						classes.add(new Classe(Telefono.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTelefo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTelefoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoTelefo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTelefo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Telefono.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Telefono.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Telefono.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Telefono.class)); continue;
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
	public static void actualizarLista(TipoTelefo tipotelefo,List<TipoTelefo> tipotelefos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoTelefo tipotelefoEncontrado=null;
			
			for(TipoTelefo tipotelefoLocal:tipotelefos) {
				if(tipotelefoLocal.getId().equals(tipotelefo.getId())) {
					tipotelefoEncontrado=tipotelefoLocal;
					
					tipotelefoLocal.setIsChanged(tipotelefo.getIsChanged());
					tipotelefoLocal.setIsNew(tipotelefo.getIsNew());
					tipotelefoLocal.setIsDeleted(tipotelefo.getIsDeleted());
					
					tipotelefoLocal.setGeneralEntityOriginal(tipotelefo.getGeneralEntityOriginal());
					
					tipotelefoLocal.setId(tipotelefo.getId());	
					tipotelefoLocal.setVersionRow(tipotelefo.getVersionRow());	
					tipotelefoLocal.setid_empresa(tipotelefo.getid_empresa());	
					tipotelefoLocal.setcodigo(tipotelefo.getcodigo());	
					tipotelefoLocal.setnombre(tipotelefo.getnombre());	
					
					
					tipotelefoLocal.setTelefonos(tipotelefo.getTelefonos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipotelefo.getIsDeleted()) {
				if(!existe) {
					tipotelefos.add(tipotelefo);
				}
			} else {
				if(tipotelefoEncontrado!=null && permiteQuitar)  {
					tipotelefos.remove(tipotelefoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoTelefo tipotelefo,List<TipoTelefo> tipotelefos) throws Exception {
		try	{			
			for(TipoTelefo tipotelefoLocal:tipotelefos) {
				if(tipotelefoLocal.getId().equals(tipotelefo.getId())) {
					tipotelefoLocal.setIsSelected(tipotelefo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoTelefo(List<TipoTelefo> tipotelefosAux) throws Exception {
		//this.tipotelefosAux=tipotelefosAux;
		
		for(TipoTelefo tipotelefoAux:tipotelefosAux) {
			if(tipotelefoAux.getIsChanged()) {
				tipotelefoAux.setIsChanged(false);
			}		
			
			if(tipotelefoAux.getIsNew()) {
				tipotelefoAux.setIsNew(false);
			}	
			
			if(tipotelefoAux.getIsDeleted()) {
				tipotelefoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoTelefo(TipoTelefo tipotelefoAux) throws Exception {
		//this.tipotelefoAux=tipotelefoAux;
		
			if(tipotelefoAux.getIsChanged()) {
				tipotelefoAux.setIsChanged(false);
			}		
			
			if(tipotelefoAux.getIsNew()) {
				tipotelefoAux.setIsNew(false);
			}	
			
			if(tipotelefoAux.getIsDeleted()) {
				tipotelefoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoTelefo tipotelefoAsignar,TipoTelefo tipotelefo) throws Exception {
		tipotelefoAsignar.setId(tipotelefo.getId());	
		tipotelefoAsignar.setVersionRow(tipotelefo.getVersionRow());	
		tipotelefoAsignar.setid_empresa(tipotelefo.getid_empresa());
		tipotelefoAsignar.setempresa_descripcion(tipotelefo.getempresa_descripcion());	
		tipotelefoAsignar.setcodigo(tipotelefo.getcodigo());	
		tipotelefoAsignar.setnombre(tipotelefo.getnombre());	
	}
	
	public static void inicializarTipoTelefo(TipoTelefo tipotelefo) throws Exception {
		try {
				tipotelefo.setId(0L);	
					
				tipotelefo.setid_empresa(-1L);	
				tipotelefo.setcodigo("");	
				tipotelefo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoTelefo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTelefoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTelefoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTelefoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoTelefo(String sTipo,Row row,Workbook workbook,TipoTelefo tipotelefo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotelefo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotelefo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotelefo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoTelefo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoTelefo() {
		return this.sFinalQueryTipoTelefo;
	}
	
	public void setsFinalQueryTipoTelefo(String sFinalQueryTipoTelefo) {
		this.sFinalQueryTipoTelefo= sFinalQueryTipoTelefo;
	}
	
	public Border resaltarSeleccionarTipoTelefo=null;
	
	public Border setResaltarSeleccionarTipoTelefo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTelefoBeanSwingJInternalFrame tipotelefoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipotelefoBeanSwingJInternalFrame.jTtoolBarTipoTelefo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoTelefo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoTelefo() {
		return this.resaltarSeleccionarTipoTelefo;
	}
	
	public void setResaltarSeleccionarTipoTelefo(Border borderResaltarSeleccionarTipoTelefo) {
		this.resaltarSeleccionarTipoTelefo= borderResaltarSeleccionarTipoTelefo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoTelefo=null;
	public Boolean mostraridTipoTelefo=true;
	public Boolean activaridTipoTelefo=true;

	public Border resaltarid_empresaTipoTelefo=null;
	public Boolean mostrarid_empresaTipoTelefo=true;
	public Boolean activarid_empresaTipoTelefo=true;
	public Boolean cargarid_empresaTipoTelefo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoTelefo=false;//ConEventDepend=true

	public Border resaltarcodigoTipoTelefo=null;
	public Boolean mostrarcodigoTipoTelefo=true;
	public Boolean activarcodigoTipoTelefo=true;

	public Border resaltarnombreTipoTelefo=null;
	public Boolean mostrarnombreTipoTelefo=true;
	public Boolean activarnombreTipoTelefo=true;

	
	

	public Border setResaltaridTipoTelefo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTelefoBeanSwingJInternalFrame tipotelefoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotelefoBeanSwingJInternalFrame.jTtoolBarTipoTelefo.setBorder(borderResaltar);
		
		this.resaltaridTipoTelefo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoTelefo() {
		return this.resaltaridTipoTelefo;
	}

	public void setResaltaridTipoTelefo(Border borderResaltar) {
		this.resaltaridTipoTelefo= borderResaltar;
	}

	public Boolean getMostraridTipoTelefo() {
		return this.mostraridTipoTelefo;
	}

	public void setMostraridTipoTelefo(Boolean mostraridTipoTelefo) {
		this.mostraridTipoTelefo= mostraridTipoTelefo;
	}

	public Boolean getActivaridTipoTelefo() {
		return this.activaridTipoTelefo;
	}

	public void setActivaridTipoTelefo(Boolean activaridTipoTelefo) {
		this.activaridTipoTelefo= activaridTipoTelefo;
	}

	public Border setResaltarid_empresaTipoTelefo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTelefoBeanSwingJInternalFrame tipotelefoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotelefoBeanSwingJInternalFrame.jTtoolBarTipoTelefo.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoTelefo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoTelefo() {
		return this.resaltarid_empresaTipoTelefo;
	}

	public void setResaltarid_empresaTipoTelefo(Border borderResaltar) {
		this.resaltarid_empresaTipoTelefo= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoTelefo() {
		return this.mostrarid_empresaTipoTelefo;
	}

	public void setMostrarid_empresaTipoTelefo(Boolean mostrarid_empresaTipoTelefo) {
		this.mostrarid_empresaTipoTelefo= mostrarid_empresaTipoTelefo;
	}

	public Boolean getActivarid_empresaTipoTelefo() {
		return this.activarid_empresaTipoTelefo;
	}

	public void setActivarid_empresaTipoTelefo(Boolean activarid_empresaTipoTelefo) {
		this.activarid_empresaTipoTelefo= activarid_empresaTipoTelefo;
	}

	public Boolean getCargarid_empresaTipoTelefo() {
		return this.cargarid_empresaTipoTelefo;
	}

	public void setCargarid_empresaTipoTelefo(Boolean cargarid_empresaTipoTelefo) {
		this.cargarid_empresaTipoTelefo= cargarid_empresaTipoTelefo;
	}

	public Border setResaltarcodigoTipoTelefo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTelefoBeanSwingJInternalFrame tipotelefoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotelefoBeanSwingJInternalFrame.jTtoolBarTipoTelefo.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoTelefo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoTelefo() {
		return this.resaltarcodigoTipoTelefo;
	}

	public void setResaltarcodigoTipoTelefo(Border borderResaltar) {
		this.resaltarcodigoTipoTelefo= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoTelefo() {
		return this.mostrarcodigoTipoTelefo;
	}

	public void setMostrarcodigoTipoTelefo(Boolean mostrarcodigoTipoTelefo) {
		this.mostrarcodigoTipoTelefo= mostrarcodigoTipoTelefo;
	}

	public Boolean getActivarcodigoTipoTelefo() {
		return this.activarcodigoTipoTelefo;
	}

	public void setActivarcodigoTipoTelefo(Boolean activarcodigoTipoTelefo) {
		this.activarcodigoTipoTelefo= activarcodigoTipoTelefo;
	}

	public Border setResaltarnombreTipoTelefo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTelefoBeanSwingJInternalFrame tipotelefoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotelefoBeanSwingJInternalFrame.jTtoolBarTipoTelefo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoTelefo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoTelefo() {
		return this.resaltarnombreTipoTelefo;
	}

	public void setResaltarnombreTipoTelefo(Border borderResaltar) {
		this.resaltarnombreTipoTelefo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoTelefo() {
		return this.mostrarnombreTipoTelefo;
	}

	public void setMostrarnombreTipoTelefo(Boolean mostrarnombreTipoTelefo) {
		this.mostrarnombreTipoTelefo= mostrarnombreTipoTelefo;
	}

	public Boolean getActivarnombreTipoTelefo() {
		return this.activarnombreTipoTelefo;
	}

	public void setActivarnombreTipoTelefo(Boolean activarnombreTipoTelefo) {
		this.activarnombreTipoTelefo= activarnombreTipoTelefo;
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
		
		
		this.setMostraridTipoTelefo(esInicial);
		this.setMostrarid_empresaTipoTelefo(esInicial);
		this.setMostrarcodigoTipoTelefo(esInicial);
		this.setMostrarnombreTipoTelefo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTelefoConstantesFunciones.ID)) {
				this.setMostraridTipoTelefo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTelefoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoTelefo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTelefoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoTelefo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTelefoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoTelefo(esAsigna);
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
		
		
		this.setActivaridTipoTelefo(esInicial);
		this.setActivarid_empresaTipoTelefo(esInicial);
		this.setActivarcodigoTipoTelefo(esInicial);
		this.setActivarnombreTipoTelefo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTelefoConstantesFunciones.ID)) {
				this.setActivaridTipoTelefo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTelefoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoTelefo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTelefoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoTelefo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTelefoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoTelefo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTelefoBeanSwingJInternalFrame tipotelefoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoTelefo(esInicial);
		this.setResaltarid_empresaTipoTelefo(esInicial);
		this.setResaltarcodigoTipoTelefo(esInicial);
		this.setResaltarnombreTipoTelefo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTelefoConstantesFunciones.ID)) {
				this.setResaltaridTipoTelefo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTelefoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoTelefo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTelefoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoTelefo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTelefoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoTelefo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTelefonoTipoTelefo=null;

	public Border getResaltarTelefonoTipoTelefo() {
		return this.resaltarTelefonoTipoTelefo;
	}

	public void setResaltarTelefonoTipoTelefo(Border borderResaltarTelefono) {
		if(borderResaltarTelefono!=null) {
			this.resaltarTelefonoTipoTelefo= borderResaltarTelefono;
		}
	}

	public Border setResaltarTelefonoTipoTelefo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTelefoBeanSwingJInternalFrame tipotelefoBeanSwingJInternalFrame*/) {
		Border borderResaltarTelefono=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipotelefoBeanSwingJInternalFrame.jTtoolBarTipoTelefo.setBorder(borderResaltarTelefono);
			
		this.resaltarTelefonoTipoTelefo= borderResaltarTelefono;

		 return borderResaltarTelefono;
	}



	public Boolean mostrarTelefonoTipoTelefo=true;

	public Boolean getMostrarTelefonoTipoTelefo() {
		return this.mostrarTelefonoTipoTelefo;
	}

	public void setMostrarTelefonoTipoTelefo(Boolean visibilidadResaltarTelefono) {
		this.mostrarTelefonoTipoTelefo= visibilidadResaltarTelefono;
	}



	public Boolean activarTelefonoTipoTelefo=true;

	public Boolean gethabilitarResaltarTelefonoTipoTelefo() {
		return this.activarTelefonoTipoTelefo;
	}

	public void setActivarTelefonoTipoTelefo(Boolean habilitarResaltarTelefono) {
		this.activarTelefonoTipoTelefo= habilitarResaltarTelefono;
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

		this.setMostrarTelefonoTipoTelefo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Telefono.class)) {
				this.setMostrarTelefonoTipoTelefo(esAsigna);
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

		this.setActivarTelefonoTipoTelefo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Telefono.class)) {
				this.setActivarTelefonoTipoTelefo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTelefoBeanSwingJInternalFrame tipotelefoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTelefonoTipoTelefo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Telefono.class)) {
				this.setResaltarTelefonoTipoTelefo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoTelefo=true;

	public Boolean getMostrarFK_IdEmpresaTipoTelefo() {
		return this.mostrarFK_IdEmpresaTipoTelefo;
	}

	public void setMostrarFK_IdEmpresaTipoTelefo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoTelefo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoTelefo=true;

	public Boolean getActivarFK_IdEmpresaTipoTelefo() {
		return this.activarFK_IdEmpresaTipoTelefo;
	}

	public void setActivarFK_IdEmpresaTipoTelefo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoTelefo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoTelefo=null;

	public Border getResaltarFK_IdEmpresaTipoTelefo() {
		return this.resaltarFK_IdEmpresaTipoTelefo;
	}

	public void setResaltarFK_IdEmpresaTipoTelefo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoTelefo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoTelefo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTelefoBeanSwingJInternalFrame tipotelefoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoTelefo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}