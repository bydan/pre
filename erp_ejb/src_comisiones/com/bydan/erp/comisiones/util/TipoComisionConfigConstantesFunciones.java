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
package com.bydan.erp.comisiones.util;

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


import com.bydan.erp.comisiones.util.TipoComisionConfigConstantesFunciones;
import com.bydan.erp.comisiones.util.TipoComisionConfigParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.TipoComisionConfigParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.comisiones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.comisiones.business.dataaccess.*;
//import com.bydan.erp.comisiones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoComisionConfigConstantesFunciones extends TipoComisionConfigConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoComisionConfig";
	public static final String SPATHOPCION="Comisiones";	
	public static final String SPATHMODULO="comisiones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoComisionConfig"+TipoComisionConfigConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoComisionConfigHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoComisionConfigHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoComisionConfigConstantesFunciones.SCHEMA+"_"+TipoComisionConfigConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoComisionConfigHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoComisionConfigConstantesFunciones.SCHEMA+"_"+TipoComisionConfigConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoComisionConfigConstantesFunciones.SCHEMA+"_"+TipoComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoComisionConfigHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoComisionConfigConstantesFunciones.SCHEMA+"_"+TipoComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoComisionConfigHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoComisionConfigHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoComisionConfigConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoComisionConfigConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoComisionConfigConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoComisionConfigConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoComisionConfigConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Comision Configes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Comision Config";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Comision Config";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoComisionConfig";
	public static final String OBJECTNAME="tipocomisionconfig";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_COMISIONES;	
	public static final String TABLENAME="tipo_comision_config";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocomisionconfig from "+TipoComisionConfigConstantesFunciones.SPERSISTENCENAME+" tipocomisionconfig";
	public static String QUERYSELECTNATIVE="select "+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".id,"+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".version_row,"+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".id_empresa,"+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".codigo,"+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".nombre from "+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME;//+" as "+TipoComisionConfigConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoComisionConfigConstantesFuncionesAdditional tipocomisionconfigConstantesFuncionesAdditional=null;
	
	public TipoComisionConfigConstantesFuncionesAdditional getTipoComisionConfigConstantesFuncionesAdditional() {
		return this.tipocomisionconfigConstantesFuncionesAdditional;
	}
	
	public void setTipoComisionConfigConstantesFuncionesAdditional(TipoComisionConfigConstantesFuncionesAdditional tipocomisionconfigConstantesFuncionesAdditional) {
		try {
			this.tipocomisionconfigConstantesFuncionesAdditional=tipocomisionconfigConstantesFuncionesAdditional;
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
	
	public static String getTipoComisionConfigLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoComisionConfigConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoComisionConfigConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoComisionConfigConstantesFunciones.CODIGO)) {sLabelColumna=TipoComisionConfigConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoComisionConfigConstantesFunciones.NOMBRE)) {sLabelColumna=TipoComisionConfigConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoComisionConfigDescripcion(TipoComisionConfig tipocomisionconfig) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocomisionconfig !=null/* && tipocomisionconfig.getId()!=0*/) {
			sDescripcion=tipocomisionconfig.getcodigo();//tipocomisionconfigtipocomisionconfig.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoComisionConfigDescripcionDetallado(TipoComisionConfig tipocomisionconfig) {
		String sDescripcion="";
			
		sDescripcion+=TipoComisionConfigConstantesFunciones.ID+"=";
		sDescripcion+=tipocomisionconfig.getId().toString()+",";
		sDescripcion+=TipoComisionConfigConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocomisionconfig.getVersionRow().toString()+",";
		sDescripcion+=TipoComisionConfigConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocomisionconfig.getid_empresa().toString()+",";
		sDescripcion+=TipoComisionConfigConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocomisionconfig.getcodigo()+",";
		sDescripcion+=TipoComisionConfigConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocomisionconfig.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoComisionConfigDescripcion(TipoComisionConfig tipocomisionconfig,String sValor) throws Exception {			
		if(tipocomisionconfig !=null) {
			tipocomisionconfig.setcodigo(sValor);;//tipocomisionconfigtipocomisionconfig.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoComisionConfig(TipoComisionConfig tipocomisionconfig,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocomisionconfig.setcodigo(tipocomisionconfig.getcodigo().trim());
		tipocomisionconfig.setnombre(tipocomisionconfig.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoComisionConfigs(List<TipoComisionConfig> tipocomisionconfigs,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoComisionConfig tipocomisionconfig: tipocomisionconfigs) {
			tipocomisionconfig.setcodigo(tipocomisionconfig.getcodigo().trim());
			tipocomisionconfig.setnombre(tipocomisionconfig.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoComisionConfig(TipoComisionConfig tipocomisionconfig,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocomisionconfig.getConCambioAuxiliar()) {
			tipocomisionconfig.setIsDeleted(tipocomisionconfig.getIsDeletedAuxiliar());	
			tipocomisionconfig.setIsNew(tipocomisionconfig.getIsNewAuxiliar());	
			tipocomisionconfig.setIsChanged(tipocomisionconfig.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocomisionconfig.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocomisionconfig.setIsDeletedAuxiliar(false);	
			tipocomisionconfig.setIsNewAuxiliar(false);	
			tipocomisionconfig.setIsChangedAuxiliar(false);
			
			tipocomisionconfig.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoComisionConfigs(List<TipoComisionConfig> tipocomisionconfigs,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoComisionConfig tipocomisionconfig : tipocomisionconfigs) {
			if(conAsignarBase && tipocomisionconfig.getConCambioAuxiliar()) {
				tipocomisionconfig.setIsDeleted(tipocomisionconfig.getIsDeletedAuxiliar());	
				tipocomisionconfig.setIsNew(tipocomisionconfig.getIsNewAuxiliar());	
				tipocomisionconfig.setIsChanged(tipocomisionconfig.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocomisionconfig.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocomisionconfig.setIsDeletedAuxiliar(false);	
				tipocomisionconfig.setIsNewAuxiliar(false);	
				tipocomisionconfig.setIsChangedAuxiliar(false);
				
				tipocomisionconfig.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoComisionConfig(TipoComisionConfig tipocomisionconfig,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoComisionConfigs(List<TipoComisionConfig> tipocomisionconfigs,Boolean conEnteros) throws Exception  {
		
		for(TipoComisionConfig tipocomisionconfig: tipocomisionconfigs) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoComisionConfig(List<TipoComisionConfig> tipocomisionconfigs,TipoComisionConfig tipocomisionconfigAux) throws Exception  {
		TipoComisionConfigConstantesFunciones.InicializarValoresTipoComisionConfig(tipocomisionconfigAux,true);
		
		for(TipoComisionConfig tipocomisionconfig: tipocomisionconfigs) {
			if(tipocomisionconfig.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoComisionConfig(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoComisionConfigConstantesFunciones.getArrayColumnasGlobalesTipoComisionConfig(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoComisionConfig(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoComisionConfigConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoComisionConfigConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoComisionConfig(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoComisionConfig> tipocomisionconfigs,TipoComisionConfig tipocomisionconfig,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoComisionConfig tipocomisionconfigAux: tipocomisionconfigs) {
			if(tipocomisionconfigAux!=null && tipocomisionconfig!=null) {
				if((tipocomisionconfigAux.getId()==null && tipocomisionconfig.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocomisionconfigAux.getId()!=null && tipocomisionconfig.getId()!=null){
					if(tipocomisionconfigAux.getId().equals(tipocomisionconfig.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoComisionConfig(List<TipoComisionConfig> tipocomisionconfigs) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoComisionConfig tipocomisionconfig: tipocomisionconfigs) {			
			if(tipocomisionconfig.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoComisionConfig() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoComisionConfigConstantesFunciones.LABEL_ID, TipoComisionConfigConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoComisionConfigConstantesFunciones.LABEL_VERSIONROW, TipoComisionConfigConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoComisionConfigConstantesFunciones.LABEL_IDEMPRESA, TipoComisionConfigConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoComisionConfigConstantesFunciones.LABEL_CODIGO, TipoComisionConfigConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoComisionConfigConstantesFunciones.LABEL_NOMBRE, TipoComisionConfigConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoComisionConfig() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoComisionConfigConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoComisionConfigConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoComisionConfigConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoComisionConfigConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoComisionConfigConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoComisionConfig() throws Exception  {
		return TipoComisionConfigConstantesFunciones.getTiposSeleccionarTipoComisionConfig(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoComisionConfig(Boolean conFk) throws Exception  {
		return TipoComisionConfigConstantesFunciones.getTiposSeleccionarTipoComisionConfig(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoComisionConfig(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoComisionConfigConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoComisionConfigConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoComisionConfigConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoComisionConfigConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoComisionConfigConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoComisionConfigConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoComisionConfig(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoComisionConfig(TipoComisionConfig tipocomisionconfigAux) throws Exception {
		
			tipocomisionconfigAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocomisionconfigAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoComisionConfig(List<TipoComisionConfig> tipocomisionconfigsTemp) throws Exception {
		for(TipoComisionConfig tipocomisionconfigAux:tipocomisionconfigsTemp) {
			
			tipocomisionconfigAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocomisionconfigAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoComisionConfig(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoComisionConfig(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoComisionConfig(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoComisionConfigConstantesFunciones.getClassesRelationshipsOfTipoComisionConfig(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoComisionConfig(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ComisionConfig.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionConfig.class)) {
						classes.add(new Classe(ComisionConfig.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoComisionConfig(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoComisionConfigConstantesFunciones.getClassesRelationshipsFromStringsOfTipoComisionConfig(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoComisionConfig(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
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
	public static void actualizarLista(TipoComisionConfig tipocomisionconfig,List<TipoComisionConfig> tipocomisionconfigs,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoComisionConfig tipocomisionconfigEncontrado=null;
			
			for(TipoComisionConfig tipocomisionconfigLocal:tipocomisionconfigs) {
				if(tipocomisionconfigLocal.getId().equals(tipocomisionconfig.getId())) {
					tipocomisionconfigEncontrado=tipocomisionconfigLocal;
					
					tipocomisionconfigLocal.setIsChanged(tipocomisionconfig.getIsChanged());
					tipocomisionconfigLocal.setIsNew(tipocomisionconfig.getIsNew());
					tipocomisionconfigLocal.setIsDeleted(tipocomisionconfig.getIsDeleted());
					
					tipocomisionconfigLocal.setGeneralEntityOriginal(tipocomisionconfig.getGeneralEntityOriginal());
					
					tipocomisionconfigLocal.setId(tipocomisionconfig.getId());	
					tipocomisionconfigLocal.setVersionRow(tipocomisionconfig.getVersionRow());	
					tipocomisionconfigLocal.setid_empresa(tipocomisionconfig.getid_empresa());	
					tipocomisionconfigLocal.setcodigo(tipocomisionconfig.getcodigo());	
					tipocomisionconfigLocal.setnombre(tipocomisionconfig.getnombre());	
					
					
					tipocomisionconfigLocal.setComisionConfigs(tipocomisionconfig.getComisionConfigs());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocomisionconfig.getIsDeleted()) {
				if(!existe) {
					tipocomisionconfigs.add(tipocomisionconfig);
				}
			} else {
				if(tipocomisionconfigEncontrado!=null && permiteQuitar)  {
					tipocomisionconfigs.remove(tipocomisionconfigEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoComisionConfig tipocomisionconfig,List<TipoComisionConfig> tipocomisionconfigs) throws Exception {
		try	{			
			for(TipoComisionConfig tipocomisionconfigLocal:tipocomisionconfigs) {
				if(tipocomisionconfigLocal.getId().equals(tipocomisionconfig.getId())) {
					tipocomisionconfigLocal.setIsSelected(tipocomisionconfig.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoComisionConfig(List<TipoComisionConfig> tipocomisionconfigsAux) throws Exception {
		//this.tipocomisionconfigsAux=tipocomisionconfigsAux;
		
		for(TipoComisionConfig tipocomisionconfigAux:tipocomisionconfigsAux) {
			if(tipocomisionconfigAux.getIsChanged()) {
				tipocomisionconfigAux.setIsChanged(false);
			}		
			
			if(tipocomisionconfigAux.getIsNew()) {
				tipocomisionconfigAux.setIsNew(false);
			}	
			
			if(tipocomisionconfigAux.getIsDeleted()) {
				tipocomisionconfigAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoComisionConfig(TipoComisionConfig tipocomisionconfigAux) throws Exception {
		//this.tipocomisionconfigAux=tipocomisionconfigAux;
		
			if(tipocomisionconfigAux.getIsChanged()) {
				tipocomisionconfigAux.setIsChanged(false);
			}		
			
			if(tipocomisionconfigAux.getIsNew()) {
				tipocomisionconfigAux.setIsNew(false);
			}	
			
			if(tipocomisionconfigAux.getIsDeleted()) {
				tipocomisionconfigAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoComisionConfig tipocomisionconfigAsignar,TipoComisionConfig tipocomisionconfig) throws Exception {
		tipocomisionconfigAsignar.setId(tipocomisionconfig.getId());	
		tipocomisionconfigAsignar.setVersionRow(tipocomisionconfig.getVersionRow());	
		tipocomisionconfigAsignar.setid_empresa(tipocomisionconfig.getid_empresa());
		tipocomisionconfigAsignar.setempresa_descripcion(tipocomisionconfig.getempresa_descripcion());	
		tipocomisionconfigAsignar.setcodigo(tipocomisionconfig.getcodigo());	
		tipocomisionconfigAsignar.setnombre(tipocomisionconfig.getnombre());	
	}
	
	public static void inicializarTipoComisionConfig(TipoComisionConfig tipocomisionconfig) throws Exception {
		try {
				tipocomisionconfig.setId(0L);	
					
				tipocomisionconfig.setid_empresa(-1L);	
				tipocomisionconfig.setcodigo("");	
				tipocomisionconfig.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoComisionConfig(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoComisionConfigConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoComisionConfigConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoComisionConfigConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoComisionConfig(String sTipo,Row row,Workbook workbook,TipoComisionConfig tipocomisionconfig,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocomisionconfig.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocomisionconfig.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocomisionconfig.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoComisionConfig=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoComisionConfig() {
		return this.sFinalQueryTipoComisionConfig;
	}
	
	public void setsFinalQueryTipoComisionConfig(String sFinalQueryTipoComisionConfig) {
		this.sFinalQueryTipoComisionConfig= sFinalQueryTipoComisionConfig;
	}
	
	public Border resaltarSeleccionarTipoComisionConfig=null;
	
	public Border setResaltarSeleccionarTipoComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComisionConfigBeanSwingJInternalFrame tipocomisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocomisionconfigBeanSwingJInternalFrame.jTtoolBarTipoComisionConfig.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoComisionConfig= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoComisionConfig() {
		return this.resaltarSeleccionarTipoComisionConfig;
	}
	
	public void setResaltarSeleccionarTipoComisionConfig(Border borderResaltarSeleccionarTipoComisionConfig) {
		this.resaltarSeleccionarTipoComisionConfig= borderResaltarSeleccionarTipoComisionConfig;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoComisionConfig=null;
	public Boolean mostraridTipoComisionConfig=true;
	public Boolean activaridTipoComisionConfig=true;

	public Border resaltarid_empresaTipoComisionConfig=null;
	public Boolean mostrarid_empresaTipoComisionConfig=true;
	public Boolean activarid_empresaTipoComisionConfig=true;
	public Boolean cargarid_empresaTipoComisionConfig=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoComisionConfig=false;//ConEventDepend=true

	public Border resaltarcodigoTipoComisionConfig=null;
	public Boolean mostrarcodigoTipoComisionConfig=true;
	public Boolean activarcodigoTipoComisionConfig=true;

	public Border resaltarnombreTipoComisionConfig=null;
	public Boolean mostrarnombreTipoComisionConfig=true;
	public Boolean activarnombreTipoComisionConfig=true;

	
	

	public Border setResaltaridTipoComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComisionConfigBeanSwingJInternalFrame tipocomisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocomisionconfigBeanSwingJInternalFrame.jTtoolBarTipoComisionConfig.setBorder(borderResaltar);
		
		this.resaltaridTipoComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoComisionConfig() {
		return this.resaltaridTipoComisionConfig;
	}

	public void setResaltaridTipoComisionConfig(Border borderResaltar) {
		this.resaltaridTipoComisionConfig= borderResaltar;
	}

	public Boolean getMostraridTipoComisionConfig() {
		return this.mostraridTipoComisionConfig;
	}

	public void setMostraridTipoComisionConfig(Boolean mostraridTipoComisionConfig) {
		this.mostraridTipoComisionConfig= mostraridTipoComisionConfig;
	}

	public Boolean getActivaridTipoComisionConfig() {
		return this.activaridTipoComisionConfig;
	}

	public void setActivaridTipoComisionConfig(Boolean activaridTipoComisionConfig) {
		this.activaridTipoComisionConfig= activaridTipoComisionConfig;
	}

	public Border setResaltarid_empresaTipoComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComisionConfigBeanSwingJInternalFrame tipocomisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocomisionconfigBeanSwingJInternalFrame.jTtoolBarTipoComisionConfig.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoComisionConfig() {
		return this.resaltarid_empresaTipoComisionConfig;
	}

	public void setResaltarid_empresaTipoComisionConfig(Border borderResaltar) {
		this.resaltarid_empresaTipoComisionConfig= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoComisionConfig() {
		return this.mostrarid_empresaTipoComisionConfig;
	}

	public void setMostrarid_empresaTipoComisionConfig(Boolean mostrarid_empresaTipoComisionConfig) {
		this.mostrarid_empresaTipoComisionConfig= mostrarid_empresaTipoComisionConfig;
	}

	public Boolean getActivarid_empresaTipoComisionConfig() {
		return this.activarid_empresaTipoComisionConfig;
	}

	public void setActivarid_empresaTipoComisionConfig(Boolean activarid_empresaTipoComisionConfig) {
		this.activarid_empresaTipoComisionConfig= activarid_empresaTipoComisionConfig;
	}

	public Boolean getCargarid_empresaTipoComisionConfig() {
		return this.cargarid_empresaTipoComisionConfig;
	}

	public void setCargarid_empresaTipoComisionConfig(Boolean cargarid_empresaTipoComisionConfig) {
		this.cargarid_empresaTipoComisionConfig= cargarid_empresaTipoComisionConfig;
	}

	public Border setResaltarcodigoTipoComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComisionConfigBeanSwingJInternalFrame tipocomisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocomisionconfigBeanSwingJInternalFrame.jTtoolBarTipoComisionConfig.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoComisionConfig() {
		return this.resaltarcodigoTipoComisionConfig;
	}

	public void setResaltarcodigoTipoComisionConfig(Border borderResaltar) {
		this.resaltarcodigoTipoComisionConfig= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoComisionConfig() {
		return this.mostrarcodigoTipoComisionConfig;
	}

	public void setMostrarcodigoTipoComisionConfig(Boolean mostrarcodigoTipoComisionConfig) {
		this.mostrarcodigoTipoComisionConfig= mostrarcodigoTipoComisionConfig;
	}

	public Boolean getActivarcodigoTipoComisionConfig() {
		return this.activarcodigoTipoComisionConfig;
	}

	public void setActivarcodigoTipoComisionConfig(Boolean activarcodigoTipoComisionConfig) {
		this.activarcodigoTipoComisionConfig= activarcodigoTipoComisionConfig;
	}

	public Border setResaltarnombreTipoComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComisionConfigBeanSwingJInternalFrame tipocomisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocomisionconfigBeanSwingJInternalFrame.jTtoolBarTipoComisionConfig.setBorder(borderResaltar);
		
		this.resaltarnombreTipoComisionConfig= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoComisionConfig() {
		return this.resaltarnombreTipoComisionConfig;
	}

	public void setResaltarnombreTipoComisionConfig(Border borderResaltar) {
		this.resaltarnombreTipoComisionConfig= borderResaltar;
	}

	public Boolean getMostrarnombreTipoComisionConfig() {
		return this.mostrarnombreTipoComisionConfig;
	}

	public void setMostrarnombreTipoComisionConfig(Boolean mostrarnombreTipoComisionConfig) {
		this.mostrarnombreTipoComisionConfig= mostrarnombreTipoComisionConfig;
	}

	public Boolean getActivarnombreTipoComisionConfig() {
		return this.activarnombreTipoComisionConfig;
	}

	public void setActivarnombreTipoComisionConfig(Boolean activarnombreTipoComisionConfig) {
		this.activarnombreTipoComisionConfig= activarnombreTipoComisionConfig;
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
		
		
		this.setMostraridTipoComisionConfig(esInicial);
		this.setMostrarid_empresaTipoComisionConfig(esInicial);
		this.setMostrarcodigoTipoComisionConfig(esInicial);
		this.setMostrarnombreTipoComisionConfig(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.ID)) {
				this.setMostraridTipoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoComisionConfig(esAsigna);
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
		
		
		this.setActivaridTipoComisionConfig(esInicial);
		this.setActivarid_empresaTipoComisionConfig(esInicial);
		this.setActivarcodigoTipoComisionConfig(esInicial);
		this.setActivarnombreTipoComisionConfig(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.ID)) {
				this.setActivaridTipoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoComisionConfig(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoComisionConfigBeanSwingJInternalFrame tipocomisionconfigBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoComisionConfig(esInicial);
		this.setResaltarid_empresaTipoComisionConfig(esInicial);
		this.setResaltarcodigoTipoComisionConfig(esInicial);
		this.setResaltarnombreTipoComisionConfig(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.ID)) {
				this.setResaltaridTipoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoComisionConfig(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoComisionConfigConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoComisionConfig(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarComisionConfigTipoComisionConfig=null;

	public Border getResaltarComisionConfigTipoComisionConfig() {
		return this.resaltarComisionConfigTipoComisionConfig;
	}

	public void setResaltarComisionConfigTipoComisionConfig(Border borderResaltarComisionConfig) {
		if(borderResaltarComisionConfig!=null) {
			this.resaltarComisionConfigTipoComisionConfig= borderResaltarComisionConfig;
		}
	}

	public Border setResaltarComisionConfigTipoComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComisionConfigBeanSwingJInternalFrame tipocomisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltarComisionConfig=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocomisionconfigBeanSwingJInternalFrame.jTtoolBarTipoComisionConfig.setBorder(borderResaltarComisionConfig);
			
		this.resaltarComisionConfigTipoComisionConfig= borderResaltarComisionConfig;

		 return borderResaltarComisionConfig;
	}



	public Boolean mostrarComisionConfigTipoComisionConfig=true;

	public Boolean getMostrarComisionConfigTipoComisionConfig() {
		return this.mostrarComisionConfigTipoComisionConfig;
	}

	public void setMostrarComisionConfigTipoComisionConfig(Boolean visibilidadResaltarComisionConfig) {
		this.mostrarComisionConfigTipoComisionConfig= visibilidadResaltarComisionConfig;
	}



	public Boolean activarComisionConfigTipoComisionConfig=true;

	public Boolean gethabilitarResaltarComisionConfigTipoComisionConfig() {
		return this.activarComisionConfigTipoComisionConfig;
	}

	public void setActivarComisionConfigTipoComisionConfig(Boolean habilitarResaltarComisionConfig) {
		this.activarComisionConfigTipoComisionConfig= habilitarResaltarComisionConfig;
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

		this.setMostrarComisionConfigTipoComisionConfig(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ComisionConfig.class)) {
				this.setMostrarComisionConfigTipoComisionConfig(esAsigna);
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

		this.setActivarComisionConfigTipoComisionConfig(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ComisionConfig.class)) {
				this.setActivarComisionConfigTipoComisionConfig(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoComisionConfigBeanSwingJInternalFrame tipocomisionconfigBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarComisionConfigTipoComisionConfig(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ComisionConfig.class)) {
				this.setResaltarComisionConfigTipoComisionConfig(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoComisionConfig=true;

	public Boolean getMostrarFK_IdEmpresaTipoComisionConfig() {
		return this.mostrarFK_IdEmpresaTipoComisionConfig;
	}

	public void setMostrarFK_IdEmpresaTipoComisionConfig(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoComisionConfig= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoComisionConfig=true;

	public Boolean getActivarFK_IdEmpresaTipoComisionConfig() {
		return this.activarFK_IdEmpresaTipoComisionConfig;
	}

	public void setActivarFK_IdEmpresaTipoComisionConfig(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoComisionConfig= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoComisionConfig=null;

	public Border getResaltarFK_IdEmpresaTipoComisionConfig() {
		return this.resaltarFK_IdEmpresaTipoComisionConfig;
	}

	public void setResaltarFK_IdEmpresaTipoComisionConfig(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoComisionConfig= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoComisionConfig(ParametroGeneralUsuario parametroGeneralUsuario/*TipoComisionConfigBeanSwingJInternalFrame tipocomisionconfigBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoComisionConfig= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}