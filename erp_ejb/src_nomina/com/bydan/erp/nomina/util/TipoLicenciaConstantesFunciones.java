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


import com.bydan.erp.nomina.util.TipoLicenciaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoLicenciaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoLicenciaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoLicenciaConstantesFunciones extends TipoLicenciaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoLicencia";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoLicencia"+TipoLicenciaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoLicenciaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoLicenciaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoLicenciaConstantesFunciones.SCHEMA+"_"+TipoLicenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoLicenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoLicenciaConstantesFunciones.SCHEMA+"_"+TipoLicenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoLicenciaConstantesFunciones.SCHEMA+"_"+TipoLicenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoLicenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoLicenciaConstantesFunciones.SCHEMA+"_"+TipoLicenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLicenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoLicenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLicenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLicenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoLicenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLicenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoLicenciaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoLicenciaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoLicenciaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoLicenciaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Licencias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Licencia";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Licencia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoLicencia";
	public static final String OBJECTNAME="tipolicencia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_licencia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipolicencia from "+TipoLicenciaConstantesFunciones.SPERSISTENCENAME+" tipolicencia";
	public static String QUERYSELECTNATIVE="select "+TipoLicenciaConstantesFunciones.SCHEMA+"."+TipoLicenciaConstantesFunciones.TABLENAME+".id,"+TipoLicenciaConstantesFunciones.SCHEMA+"."+TipoLicenciaConstantesFunciones.TABLENAME+".version_row,"+TipoLicenciaConstantesFunciones.SCHEMA+"."+TipoLicenciaConstantesFunciones.TABLENAME+".id_empresa,"+TipoLicenciaConstantesFunciones.SCHEMA+"."+TipoLicenciaConstantesFunciones.TABLENAME+".codigo,"+TipoLicenciaConstantesFunciones.SCHEMA+"."+TipoLicenciaConstantesFunciones.TABLENAME+".nombre from "+TipoLicenciaConstantesFunciones.SCHEMA+"."+TipoLicenciaConstantesFunciones.TABLENAME;//+" as "+TipoLicenciaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoLicenciaConstantesFuncionesAdditional tipolicenciaConstantesFuncionesAdditional=null;
	
	public TipoLicenciaConstantesFuncionesAdditional getTipoLicenciaConstantesFuncionesAdditional() {
		return this.tipolicenciaConstantesFuncionesAdditional;
	}
	
	public void setTipoLicenciaConstantesFuncionesAdditional(TipoLicenciaConstantesFuncionesAdditional tipolicenciaConstantesFuncionesAdditional) {
		try {
			this.tipolicenciaConstantesFuncionesAdditional=tipolicenciaConstantesFuncionesAdditional;
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
	
	public static String getTipoLicenciaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoLicenciaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoLicenciaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoLicenciaConstantesFunciones.CODIGO)) {sLabelColumna=TipoLicenciaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoLicenciaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoLicenciaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoLicenciaDescripcion(TipoLicencia tipolicencia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipolicencia !=null/* && tipolicencia.getId()!=0*/) {
			sDescripcion=tipolicencia.getcodigo();//tipolicenciatipolicencia.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoLicenciaDescripcionDetallado(TipoLicencia tipolicencia) {
		String sDescripcion="";
			
		sDescripcion+=TipoLicenciaConstantesFunciones.ID+"=";
		sDescripcion+=tipolicencia.getId().toString()+",";
		sDescripcion+=TipoLicenciaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipolicencia.getVersionRow().toString()+",";
		sDescripcion+=TipoLicenciaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipolicencia.getid_empresa().toString()+",";
		sDescripcion+=TipoLicenciaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipolicencia.getcodigo()+",";
		sDescripcion+=TipoLicenciaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipolicencia.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoLicenciaDescripcion(TipoLicencia tipolicencia,String sValor) throws Exception {			
		if(tipolicencia !=null) {
			tipolicencia.setcodigo(sValor);;//tipolicenciatipolicencia.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoLicencia(TipoLicencia tipolicencia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipolicencia.setcodigo(tipolicencia.getcodigo().trim());
		tipolicencia.setnombre(tipolicencia.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoLicencias(List<TipoLicencia> tipolicencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoLicencia tipolicencia: tipolicencias) {
			tipolicencia.setcodigo(tipolicencia.getcodigo().trim());
			tipolicencia.setnombre(tipolicencia.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoLicencia(TipoLicencia tipolicencia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipolicencia.getConCambioAuxiliar()) {
			tipolicencia.setIsDeleted(tipolicencia.getIsDeletedAuxiliar());	
			tipolicencia.setIsNew(tipolicencia.getIsNewAuxiliar());	
			tipolicencia.setIsChanged(tipolicencia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipolicencia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipolicencia.setIsDeletedAuxiliar(false);	
			tipolicencia.setIsNewAuxiliar(false);	
			tipolicencia.setIsChangedAuxiliar(false);
			
			tipolicencia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoLicencias(List<TipoLicencia> tipolicencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoLicencia tipolicencia : tipolicencias) {
			if(conAsignarBase && tipolicencia.getConCambioAuxiliar()) {
				tipolicencia.setIsDeleted(tipolicencia.getIsDeletedAuxiliar());	
				tipolicencia.setIsNew(tipolicencia.getIsNewAuxiliar());	
				tipolicencia.setIsChanged(tipolicencia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipolicencia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipolicencia.setIsDeletedAuxiliar(false);	
				tipolicencia.setIsNewAuxiliar(false);	
				tipolicencia.setIsChangedAuxiliar(false);
				
				tipolicencia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoLicencia(TipoLicencia tipolicencia,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoLicencias(List<TipoLicencia> tipolicencias,Boolean conEnteros) throws Exception  {
		
		for(TipoLicencia tipolicencia: tipolicencias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoLicencia(List<TipoLicencia> tipolicencias,TipoLicencia tipolicenciaAux) throws Exception  {
		TipoLicenciaConstantesFunciones.InicializarValoresTipoLicencia(tipolicenciaAux,true);
		
		for(TipoLicencia tipolicencia: tipolicencias) {
			if(tipolicencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoLicencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoLicenciaConstantesFunciones.getArrayColumnasGlobalesTipoLicencia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoLicencia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoLicenciaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoLicenciaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoLicencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoLicencia> tipolicencias,TipoLicencia tipolicencia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoLicencia tipolicenciaAux: tipolicencias) {
			if(tipolicenciaAux!=null && tipolicencia!=null) {
				if((tipolicenciaAux.getId()==null && tipolicencia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipolicenciaAux.getId()!=null && tipolicencia.getId()!=null){
					if(tipolicenciaAux.getId().equals(tipolicencia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoLicencia(List<TipoLicencia> tipolicencias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoLicencia tipolicencia: tipolicencias) {			
			if(tipolicencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoLicencia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoLicenciaConstantesFunciones.LABEL_ID, TipoLicenciaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLicenciaConstantesFunciones.LABEL_VERSIONROW, TipoLicenciaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLicenciaConstantesFunciones.LABEL_IDEMPRESA, TipoLicenciaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLicenciaConstantesFunciones.LABEL_CODIGO, TipoLicenciaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLicenciaConstantesFunciones.LABEL_NOMBRE, TipoLicenciaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoLicencia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoLicenciaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLicenciaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLicenciaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLicenciaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLicenciaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLicencia() throws Exception  {
		return TipoLicenciaConstantesFunciones.getTiposSeleccionarTipoLicencia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLicencia(Boolean conFk) throws Exception  {
		return TipoLicenciaConstantesFunciones.getTiposSeleccionarTipoLicencia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLicencia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoLicenciaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoLicenciaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoLicenciaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoLicenciaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoLicenciaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoLicenciaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoLicencia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoLicencia(TipoLicencia tipolicenciaAux) throws Exception {
		
			tipolicenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipolicenciaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoLicencia(List<TipoLicencia> tipolicenciasTemp) throws Exception {
		for(TipoLicencia tipolicenciaAux:tipolicenciasTemp) {
			
			tipolicenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipolicenciaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoLicencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoLicencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoLicencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoLicenciaConstantesFunciones.getClassesRelationshipsOfTipoLicencia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoLicencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoLicencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoLicenciaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoLicencia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoLicencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoLicencia tipolicencia,List<TipoLicencia> tipolicencias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoLicencia tipolicenciaEncontrado=null;
			
			for(TipoLicencia tipolicenciaLocal:tipolicencias) {
				if(tipolicenciaLocal.getId().equals(tipolicencia.getId())) {
					tipolicenciaEncontrado=tipolicenciaLocal;
					
					tipolicenciaLocal.setIsChanged(tipolicencia.getIsChanged());
					tipolicenciaLocal.setIsNew(tipolicencia.getIsNew());
					tipolicenciaLocal.setIsDeleted(tipolicencia.getIsDeleted());
					
					tipolicenciaLocal.setGeneralEntityOriginal(tipolicencia.getGeneralEntityOriginal());
					
					tipolicenciaLocal.setId(tipolicencia.getId());	
					tipolicenciaLocal.setVersionRow(tipolicencia.getVersionRow());	
					tipolicenciaLocal.setid_empresa(tipolicencia.getid_empresa());	
					tipolicenciaLocal.setcodigo(tipolicencia.getcodigo());	
					tipolicenciaLocal.setnombre(tipolicencia.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipolicencia.getIsDeleted()) {
				if(!existe) {
					tipolicencias.add(tipolicencia);
				}
			} else {
				if(tipolicenciaEncontrado!=null && permiteQuitar)  {
					tipolicencias.remove(tipolicenciaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoLicencia tipolicencia,List<TipoLicencia> tipolicencias) throws Exception {
		try	{			
			for(TipoLicencia tipolicenciaLocal:tipolicencias) {
				if(tipolicenciaLocal.getId().equals(tipolicencia.getId())) {
					tipolicenciaLocal.setIsSelected(tipolicencia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoLicencia(List<TipoLicencia> tipolicenciasAux) throws Exception {
		//this.tipolicenciasAux=tipolicenciasAux;
		
		for(TipoLicencia tipolicenciaAux:tipolicenciasAux) {
			if(tipolicenciaAux.getIsChanged()) {
				tipolicenciaAux.setIsChanged(false);
			}		
			
			if(tipolicenciaAux.getIsNew()) {
				tipolicenciaAux.setIsNew(false);
			}	
			
			if(tipolicenciaAux.getIsDeleted()) {
				tipolicenciaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoLicencia(TipoLicencia tipolicenciaAux) throws Exception {
		//this.tipolicenciaAux=tipolicenciaAux;
		
			if(tipolicenciaAux.getIsChanged()) {
				tipolicenciaAux.setIsChanged(false);
			}		
			
			if(tipolicenciaAux.getIsNew()) {
				tipolicenciaAux.setIsNew(false);
			}	
			
			if(tipolicenciaAux.getIsDeleted()) {
				tipolicenciaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoLicencia tipolicenciaAsignar,TipoLicencia tipolicencia) throws Exception {
		tipolicenciaAsignar.setId(tipolicencia.getId());	
		tipolicenciaAsignar.setVersionRow(tipolicencia.getVersionRow());	
		tipolicenciaAsignar.setid_empresa(tipolicencia.getid_empresa());
		tipolicenciaAsignar.setempresa_descripcion(tipolicencia.getempresa_descripcion());	
		tipolicenciaAsignar.setcodigo(tipolicencia.getcodigo());	
		tipolicenciaAsignar.setnombre(tipolicencia.getnombre());	
	}
	
	public static void inicializarTipoLicencia(TipoLicencia tipolicencia) throws Exception {
		try {
				tipolicencia.setId(0L);	
					
				tipolicencia.setid_empresa(-1L);	
				tipolicencia.setcodigo("");	
				tipolicencia.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoLicencia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoLicenciaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoLicenciaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoLicenciaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoLicencia(String sTipo,Row row,Workbook workbook,TipoLicencia tipolicencia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolicencia.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolicencia.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolicencia.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoLicencia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoLicencia() {
		return this.sFinalQueryTipoLicencia;
	}
	
	public void setsFinalQueryTipoLicencia(String sFinalQueryTipoLicencia) {
		this.sFinalQueryTipoLicencia= sFinalQueryTipoLicencia;
	}
	
	public Border resaltarSeleccionarTipoLicencia=null;
	
	public Border setResaltarSeleccionarTipoLicencia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLicenciaBeanSwingJInternalFrame tipolicenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipolicenciaBeanSwingJInternalFrame.jTtoolBarTipoLicencia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoLicencia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoLicencia() {
		return this.resaltarSeleccionarTipoLicencia;
	}
	
	public void setResaltarSeleccionarTipoLicencia(Border borderResaltarSeleccionarTipoLicencia) {
		this.resaltarSeleccionarTipoLicencia= borderResaltarSeleccionarTipoLicencia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoLicencia=null;
	public Boolean mostraridTipoLicencia=true;
	public Boolean activaridTipoLicencia=true;

	public Border resaltarid_empresaTipoLicencia=null;
	public Boolean mostrarid_empresaTipoLicencia=true;
	public Boolean activarid_empresaTipoLicencia=true;
	public Boolean cargarid_empresaTipoLicencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoLicencia=false;//ConEventDepend=true

	public Border resaltarcodigoTipoLicencia=null;
	public Boolean mostrarcodigoTipoLicencia=true;
	public Boolean activarcodigoTipoLicencia=true;

	public Border resaltarnombreTipoLicencia=null;
	public Boolean mostrarnombreTipoLicencia=true;
	public Boolean activarnombreTipoLicencia=true;

	
	

	public Border setResaltaridTipoLicencia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLicenciaBeanSwingJInternalFrame tipolicenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolicenciaBeanSwingJInternalFrame.jTtoolBarTipoLicencia.setBorder(borderResaltar);
		
		this.resaltaridTipoLicencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoLicencia() {
		return this.resaltaridTipoLicencia;
	}

	public void setResaltaridTipoLicencia(Border borderResaltar) {
		this.resaltaridTipoLicencia= borderResaltar;
	}

	public Boolean getMostraridTipoLicencia() {
		return this.mostraridTipoLicencia;
	}

	public void setMostraridTipoLicencia(Boolean mostraridTipoLicencia) {
		this.mostraridTipoLicencia= mostraridTipoLicencia;
	}

	public Boolean getActivaridTipoLicencia() {
		return this.activaridTipoLicencia;
	}

	public void setActivaridTipoLicencia(Boolean activaridTipoLicencia) {
		this.activaridTipoLicencia= activaridTipoLicencia;
	}

	public Border setResaltarid_empresaTipoLicencia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLicenciaBeanSwingJInternalFrame tipolicenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolicenciaBeanSwingJInternalFrame.jTtoolBarTipoLicencia.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoLicencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoLicencia() {
		return this.resaltarid_empresaTipoLicencia;
	}

	public void setResaltarid_empresaTipoLicencia(Border borderResaltar) {
		this.resaltarid_empresaTipoLicencia= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoLicencia() {
		return this.mostrarid_empresaTipoLicencia;
	}

	public void setMostrarid_empresaTipoLicencia(Boolean mostrarid_empresaTipoLicencia) {
		this.mostrarid_empresaTipoLicencia= mostrarid_empresaTipoLicencia;
	}

	public Boolean getActivarid_empresaTipoLicencia() {
		return this.activarid_empresaTipoLicencia;
	}

	public void setActivarid_empresaTipoLicencia(Boolean activarid_empresaTipoLicencia) {
		this.activarid_empresaTipoLicencia= activarid_empresaTipoLicencia;
	}

	public Boolean getCargarid_empresaTipoLicencia() {
		return this.cargarid_empresaTipoLicencia;
	}

	public void setCargarid_empresaTipoLicencia(Boolean cargarid_empresaTipoLicencia) {
		this.cargarid_empresaTipoLicencia= cargarid_empresaTipoLicencia;
	}

	public Border setResaltarcodigoTipoLicencia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLicenciaBeanSwingJInternalFrame tipolicenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolicenciaBeanSwingJInternalFrame.jTtoolBarTipoLicencia.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoLicencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoLicencia() {
		return this.resaltarcodigoTipoLicencia;
	}

	public void setResaltarcodigoTipoLicencia(Border borderResaltar) {
		this.resaltarcodigoTipoLicencia= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoLicencia() {
		return this.mostrarcodigoTipoLicencia;
	}

	public void setMostrarcodigoTipoLicencia(Boolean mostrarcodigoTipoLicencia) {
		this.mostrarcodigoTipoLicencia= mostrarcodigoTipoLicencia;
	}

	public Boolean getActivarcodigoTipoLicencia() {
		return this.activarcodigoTipoLicencia;
	}

	public void setActivarcodigoTipoLicencia(Boolean activarcodigoTipoLicencia) {
		this.activarcodigoTipoLicencia= activarcodigoTipoLicencia;
	}

	public Border setResaltarnombreTipoLicencia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLicenciaBeanSwingJInternalFrame tipolicenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolicenciaBeanSwingJInternalFrame.jTtoolBarTipoLicencia.setBorder(borderResaltar);
		
		this.resaltarnombreTipoLicencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoLicencia() {
		return this.resaltarnombreTipoLicencia;
	}

	public void setResaltarnombreTipoLicencia(Border borderResaltar) {
		this.resaltarnombreTipoLicencia= borderResaltar;
	}

	public Boolean getMostrarnombreTipoLicencia() {
		return this.mostrarnombreTipoLicencia;
	}

	public void setMostrarnombreTipoLicencia(Boolean mostrarnombreTipoLicencia) {
		this.mostrarnombreTipoLicencia= mostrarnombreTipoLicencia;
	}

	public Boolean getActivarnombreTipoLicencia() {
		return this.activarnombreTipoLicencia;
	}

	public void setActivarnombreTipoLicencia(Boolean activarnombreTipoLicencia) {
		this.activarnombreTipoLicencia= activarnombreTipoLicencia;
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
		
		
		this.setMostraridTipoLicencia(esInicial);
		this.setMostrarid_empresaTipoLicencia(esInicial);
		this.setMostrarcodigoTipoLicencia(esInicial);
		this.setMostrarnombreTipoLicencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.ID)) {
				this.setMostraridTipoLicencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoLicencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoLicencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoLicencia(esAsigna);
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
		
		
		this.setActivaridTipoLicencia(esInicial);
		this.setActivarid_empresaTipoLicencia(esInicial);
		this.setActivarcodigoTipoLicencia(esInicial);
		this.setActivarnombreTipoLicencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.ID)) {
				this.setActivaridTipoLicencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoLicencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoLicencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoLicencia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoLicenciaBeanSwingJInternalFrame tipolicenciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoLicencia(esInicial);
		this.setResaltarid_empresaTipoLicencia(esInicial);
		this.setResaltarcodigoTipoLicencia(esInicial);
		this.setResaltarnombreTipoLicencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.ID)) {
				this.setResaltaridTipoLicencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoLicencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoLicencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLicenciaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoLicencia(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoLicenciaBeanSwingJInternalFrame tipolicenciaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoLicencia=true;

	public Boolean getMostrarFK_IdEmpresaTipoLicencia() {
		return this.mostrarFK_IdEmpresaTipoLicencia;
	}

	public void setMostrarFK_IdEmpresaTipoLicencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoLicencia= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoLicencia=true;

	public Boolean getActivarFK_IdEmpresaTipoLicencia() {
		return this.activarFK_IdEmpresaTipoLicencia;
	}

	public void setActivarFK_IdEmpresaTipoLicencia(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoLicencia= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoLicencia=null;

	public Border getResaltarFK_IdEmpresaTipoLicencia() {
		return this.resaltarFK_IdEmpresaTipoLicencia;
	}

	public void setResaltarFK_IdEmpresaTipoLicencia(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoLicencia= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoLicencia(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLicenciaBeanSwingJInternalFrame tipolicenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoLicencia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}