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


import com.bydan.erp.cartera.util.ParametroFuncionalConstantesFunciones;
import com.bydan.erp.cartera.util.ParametroFuncionalParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ParametroFuncionalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroFuncionalConstantesFunciones extends ParametroFuncionalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroFuncional";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroFuncional"+ParametroFuncionalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroFuncionalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroFuncionalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroFuncionalConstantesFunciones.SCHEMA+"_"+ParametroFuncionalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFuncionalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroFuncionalConstantesFunciones.SCHEMA+"_"+ParametroFuncionalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroFuncionalConstantesFunciones.SCHEMA+"_"+ParametroFuncionalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFuncionalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroFuncionalConstantesFunciones.SCHEMA+"_"+ParametroFuncionalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFuncionalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFuncionalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFuncionalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFuncionalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFuncionalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFuncionalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroFuncionalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroFuncionalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroFuncionalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroFuncionalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Funcionales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Parametro Funcional";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Funcional";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroFuncional";
	public static final String OBJECTNAME="parametrofuncional";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="parametro_funcional";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrofuncional from "+ParametroFuncionalConstantesFunciones.SPERSISTENCENAME+" parametrofuncional";
	public static String QUERYSELECTNATIVE="select "+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".id,"+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".version_row,"+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".con_copia_clientes,"+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".con_copia_proveedor,"+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".con_proveedor_cliente from "+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME;//+" as "+ParametroFuncionalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroFuncionalConstantesFuncionesAdditional parametrofuncionalConstantesFuncionesAdditional=null;
	
	public ParametroFuncionalConstantesFuncionesAdditional getParametroFuncionalConstantesFuncionesAdditional() {
		return this.parametrofuncionalConstantesFuncionesAdditional;
	}
	
	public void setParametroFuncionalConstantesFuncionesAdditional(ParametroFuncionalConstantesFuncionesAdditional parametrofuncionalConstantesFuncionesAdditional) {
		try {
			this.parametrofuncionalConstantesFuncionesAdditional=parametrofuncionalConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CONCOPIACLIENTES= "con_copia_clientes";
    public static final String CONCOPIAPROVEEDOR= "con_copia_proveedor";
    public static final String CONPROVEEDORCLIENTE= "con_proveedor_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CONCOPIACLIENTES= "Concopia Clientes";
		public static final String LABEL_CONCOPIACLIENTES_LOWER= "con Copia Clientes";
    	public static final String LABEL_CONCOPIAPROVEEDOR= "Concopia Proveedor";
		public static final String LABEL_CONCOPIAPROVEEDOR_LOWER= "con Copia Proveedor";
    	public static final String LABEL_CONPROVEEDORCLIENTE= "Conproveedor Cliente";
		public static final String LABEL_CONPROVEEDORCLIENTE_LOWER= "con Proveedor Cliente";
	
		
		
		
		
		
	
	public static String getParametroFuncionalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroFuncionalConstantesFunciones.CONCOPIACLIENTES)) {sLabelColumna=ParametroFuncionalConstantesFunciones.LABEL_CONCOPIACLIENTES;}
		if(sNombreColumna.equals(ParametroFuncionalConstantesFunciones.CONCOPIAPROVEEDOR)) {sLabelColumna=ParametroFuncionalConstantesFunciones.LABEL_CONCOPIAPROVEEDOR;}
		if(sNombreColumna.equals(ParametroFuncionalConstantesFunciones.CONPROVEEDORCLIENTE)) {sLabelColumna=ParametroFuncionalConstantesFunciones.LABEL_CONPROVEEDORCLIENTE;}
		
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
	
	
	
			
			
		
	public static String getcon_copia_clientesDescripcion(ParametroFuncional parametrofuncional) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofuncional.getcon_copia_clientes()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_copia_clientesHtmlDescripcion(ParametroFuncional parametrofuncional) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofuncional.getId(),parametrofuncional.getcon_copia_clientes());

		return sDescripcion;
	}	
		
	public static String getcon_copia_proveedorDescripcion(ParametroFuncional parametrofuncional) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofuncional.getcon_copia_proveedor()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_copia_proveedorHtmlDescripcion(ParametroFuncional parametrofuncional) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofuncional.getId(),parametrofuncional.getcon_copia_proveedor());

		return sDescripcion;
	}	
		
	public static String getcon_proveedor_clienteDescripcion(ParametroFuncional parametrofuncional) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofuncional.getcon_proveedor_cliente()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_proveedor_clienteHtmlDescripcion(ParametroFuncional parametrofuncional) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofuncional.getId(),parametrofuncional.getcon_proveedor_cliente());

		return sDescripcion;
	}	
	
	public static String getParametroFuncionalDescripcion(ParametroFuncional parametrofuncional) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrofuncional !=null/* && parametrofuncional.getId()!=0*/) {
			if(parametrofuncional.getId()!=null) {
				sDescripcion=parametrofuncional.getId().toString();
			}//parametrofuncionalparametrofuncional.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroFuncionalDescripcionDetallado(ParametroFuncional parametrofuncional) {
		String sDescripcion="";
			
		sDescripcion+=ParametroFuncionalConstantesFunciones.ID+"=";
		sDescripcion+=parametrofuncional.getId().toString()+",";
		sDescripcion+=ParametroFuncionalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrofuncional.getVersionRow().toString()+",";
		sDescripcion+=ParametroFuncionalConstantesFunciones.CONCOPIACLIENTES+"=";
		sDescripcion+=parametrofuncional.getcon_copia_clientes().toString()+",";
		sDescripcion+=ParametroFuncionalConstantesFunciones.CONCOPIAPROVEEDOR+"=";
		sDescripcion+=parametrofuncional.getcon_copia_proveedor().toString()+",";
		sDescripcion+=ParametroFuncionalConstantesFunciones.CONPROVEEDORCLIENTE+"=";
		sDescripcion+=parametrofuncional.getcon_proveedor_cliente().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroFuncionalDescripcion(ParametroFuncional parametrofuncional,String sValor) throws Exception {			
		if(parametrofuncional !=null) {
			//parametrofuncionalparametrofuncional.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosParametroFuncional(ParametroFuncional parametrofuncional,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroFuncionals(List<ParametroFuncional> parametrofuncionals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroFuncional parametrofuncional: parametrofuncionals) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFuncional(ParametroFuncional parametrofuncional,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrofuncional.getConCambioAuxiliar()) {
			parametrofuncional.setIsDeleted(parametrofuncional.getIsDeletedAuxiliar());	
			parametrofuncional.setIsNew(parametrofuncional.getIsNewAuxiliar());	
			parametrofuncional.setIsChanged(parametrofuncional.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrofuncional.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrofuncional.setIsDeletedAuxiliar(false);	
			parametrofuncional.setIsNewAuxiliar(false);	
			parametrofuncional.setIsChangedAuxiliar(false);
			
			parametrofuncional.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFuncionals(List<ParametroFuncional> parametrofuncionals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroFuncional parametrofuncional : parametrofuncionals) {
			if(conAsignarBase && parametrofuncional.getConCambioAuxiliar()) {
				parametrofuncional.setIsDeleted(parametrofuncional.getIsDeletedAuxiliar());	
				parametrofuncional.setIsNew(parametrofuncional.getIsNewAuxiliar());	
				parametrofuncional.setIsChanged(parametrofuncional.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrofuncional.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrofuncional.setIsDeletedAuxiliar(false);	
				parametrofuncional.setIsNewAuxiliar(false);	
				parametrofuncional.setIsChangedAuxiliar(false);
				
				parametrofuncional.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroFuncional(ParametroFuncional parametrofuncional,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroFuncionals(List<ParametroFuncional> parametrofuncionals,Boolean conEnteros) throws Exception  {
		
		for(ParametroFuncional parametrofuncional: parametrofuncionals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroFuncional(List<ParametroFuncional> parametrofuncionals,ParametroFuncional parametrofuncionalAux) throws Exception  {
		ParametroFuncionalConstantesFunciones.InicializarValoresParametroFuncional(parametrofuncionalAux,true);
		
		for(ParametroFuncional parametrofuncional: parametrofuncionals) {
			if(parametrofuncional.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFuncional(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroFuncionalConstantesFunciones.getArrayColumnasGlobalesParametroFuncional(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFuncional(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroFuncional(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroFuncional> parametrofuncionals,ParametroFuncional parametrofuncional,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroFuncional parametrofuncionalAux: parametrofuncionals) {
			if(parametrofuncionalAux!=null && parametrofuncional!=null) {
				if((parametrofuncionalAux.getId()==null && parametrofuncional.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrofuncionalAux.getId()!=null && parametrofuncional.getId()!=null){
					if(parametrofuncionalAux.getId().equals(parametrofuncional.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroFuncional(List<ParametroFuncional> parametrofuncionals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroFuncional parametrofuncional: parametrofuncionals) {			
			if(parametrofuncional.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroFuncional() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroFuncionalConstantesFunciones.LABEL_ID, ParametroFuncionalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFuncionalConstantesFunciones.LABEL_VERSIONROW, ParametroFuncionalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFuncionalConstantesFunciones.LABEL_CONCOPIACLIENTES, ParametroFuncionalConstantesFunciones.CONCOPIACLIENTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFuncionalConstantesFunciones.LABEL_CONCOPIAPROVEEDOR, ParametroFuncionalConstantesFunciones.CONCOPIAPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFuncionalConstantesFunciones.LABEL_CONPROVEEDORCLIENTE, ParametroFuncionalConstantesFunciones.CONPROVEEDORCLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroFuncional() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroFuncionalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFuncionalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFuncionalConstantesFunciones.CONCOPIACLIENTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFuncionalConstantesFunciones.CONCOPIAPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFuncionalConstantesFunciones.CONPROVEEDORCLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFuncional() throws Exception  {
		return ParametroFuncionalConstantesFunciones.getTiposSeleccionarParametroFuncional(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFuncional(Boolean conFk) throws Exception  {
		return ParametroFuncionalConstantesFunciones.getTiposSeleccionarParametroFuncional(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFuncional(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFuncionalConstantesFunciones.LABEL_CONCOPIACLIENTES);
			reporte.setsDescripcion(ParametroFuncionalConstantesFunciones.LABEL_CONCOPIACLIENTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFuncionalConstantesFunciones.LABEL_CONCOPIAPROVEEDOR);
			reporte.setsDescripcion(ParametroFuncionalConstantesFunciones.LABEL_CONCOPIAPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFuncionalConstantesFunciones.LABEL_CONPROVEEDORCLIENTE);
			reporte.setsDescripcion(ParametroFuncionalConstantesFunciones.LABEL_CONPROVEEDORCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroFuncional(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFuncional(ParametroFuncional parametrofuncionalAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFuncional(List<ParametroFuncional> parametrofuncionalsTemp) throws Exception {
		for(ParametroFuncional parametrofuncionalAux:parametrofuncionalsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFuncional(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroFuncional(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFuncional(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFuncionalConstantesFunciones.getClassesRelationshipsOfParametroFuncional(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFuncional(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFuncional(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFuncionalConstantesFunciones.getClassesRelationshipsFromStringsOfParametroFuncional(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFuncional(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroFuncional parametrofuncional,List<ParametroFuncional> parametrofuncionals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroFuncional parametrofuncionalEncontrado=null;
			
			for(ParametroFuncional parametrofuncionalLocal:parametrofuncionals) {
				if(parametrofuncionalLocal.getId().equals(parametrofuncional.getId())) {
					parametrofuncionalEncontrado=parametrofuncionalLocal;
					
					parametrofuncionalLocal.setIsChanged(parametrofuncional.getIsChanged());
					parametrofuncionalLocal.setIsNew(parametrofuncional.getIsNew());
					parametrofuncionalLocal.setIsDeleted(parametrofuncional.getIsDeleted());
					
					parametrofuncionalLocal.setGeneralEntityOriginal(parametrofuncional.getGeneralEntityOriginal());
					
					parametrofuncionalLocal.setId(parametrofuncional.getId());	
					parametrofuncionalLocal.setVersionRow(parametrofuncional.getVersionRow());	
					parametrofuncionalLocal.setcon_copia_clientes(parametrofuncional.getcon_copia_clientes());	
					parametrofuncionalLocal.setcon_copia_proveedor(parametrofuncional.getcon_copia_proveedor());	
					parametrofuncionalLocal.setcon_proveedor_cliente(parametrofuncional.getcon_proveedor_cliente());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrofuncional.getIsDeleted()) {
				if(!existe) {
					parametrofuncionals.add(parametrofuncional);
				}
			} else {
				if(parametrofuncionalEncontrado!=null && permiteQuitar)  {
					parametrofuncionals.remove(parametrofuncionalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroFuncional parametrofuncional,List<ParametroFuncional> parametrofuncionals) throws Exception {
		try	{			
			for(ParametroFuncional parametrofuncionalLocal:parametrofuncionals) {
				if(parametrofuncionalLocal.getId().equals(parametrofuncional.getId())) {
					parametrofuncionalLocal.setIsSelected(parametrofuncional.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroFuncional(List<ParametroFuncional> parametrofuncionalsAux) throws Exception {
		//this.parametrofuncionalsAux=parametrofuncionalsAux;
		
		for(ParametroFuncional parametrofuncionalAux:parametrofuncionalsAux) {
			if(parametrofuncionalAux.getIsChanged()) {
				parametrofuncionalAux.setIsChanged(false);
			}		
			
			if(parametrofuncionalAux.getIsNew()) {
				parametrofuncionalAux.setIsNew(false);
			}	
			
			if(parametrofuncionalAux.getIsDeleted()) {
				parametrofuncionalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroFuncional(ParametroFuncional parametrofuncionalAux) throws Exception {
		//this.parametrofuncionalAux=parametrofuncionalAux;
		
			if(parametrofuncionalAux.getIsChanged()) {
				parametrofuncionalAux.setIsChanged(false);
			}		
			
			if(parametrofuncionalAux.getIsNew()) {
				parametrofuncionalAux.setIsNew(false);
			}	
			
			if(parametrofuncionalAux.getIsDeleted()) {
				parametrofuncionalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroFuncional parametrofuncionalAsignar,ParametroFuncional parametrofuncional) throws Exception {
		parametrofuncionalAsignar.setId(parametrofuncional.getId());	
		parametrofuncionalAsignar.setVersionRow(parametrofuncional.getVersionRow());	
		parametrofuncionalAsignar.setcon_copia_clientes(parametrofuncional.getcon_copia_clientes());	
		parametrofuncionalAsignar.setcon_copia_proveedor(parametrofuncional.getcon_copia_proveedor());	
		parametrofuncionalAsignar.setcon_proveedor_cliente(parametrofuncional.getcon_proveedor_cliente());	
	}
	
	public static void inicializarParametroFuncional(ParametroFuncional parametrofuncional) throws Exception {
		try {
				parametrofuncional.setId(0L);	
					
				parametrofuncional.setcon_copia_clientes(false);	
				parametrofuncional.setcon_copia_proveedor(false);	
				parametrofuncional.setcon_proveedor_cliente(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroFuncional(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFuncionalConstantesFunciones.LABEL_CONCOPIACLIENTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFuncionalConstantesFunciones.LABEL_CONCOPIAPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFuncionalConstantesFunciones.LABEL_CONPROVEEDORCLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroFuncional(String sTipo,Row row,Workbook workbook,ParametroFuncional parametrofuncional,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofuncional.getcon_copia_clientes()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofuncional.getcon_copia_proveedor()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofuncional.getcon_proveedor_cliente()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroFuncional=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroFuncional() {
		return this.sFinalQueryParametroFuncional;
	}
	
	public void setsFinalQueryParametroFuncional(String sFinalQueryParametroFuncional) {
		this.sFinalQueryParametroFuncional= sFinalQueryParametroFuncional;
	}
	
	public Border resaltarSeleccionarParametroFuncional=null;
	
	public Border setResaltarSeleccionarParametroFuncional(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFuncionalBeanSwingJInternalFrame parametrofuncionalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrofuncionalBeanSwingJInternalFrame.jTtoolBarParametroFuncional.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroFuncional= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroFuncional() {
		return this.resaltarSeleccionarParametroFuncional;
	}
	
	public void setResaltarSeleccionarParametroFuncional(Border borderResaltarSeleccionarParametroFuncional) {
		this.resaltarSeleccionarParametroFuncional= borderResaltarSeleccionarParametroFuncional;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroFuncional=null;
	public Boolean mostraridParametroFuncional=true;
	public Boolean activaridParametroFuncional=true;

	public Border resaltarcon_copia_clientesParametroFuncional=null;
	public Boolean mostrarcon_copia_clientesParametroFuncional=true;
	public Boolean activarcon_copia_clientesParametroFuncional=true;

	public Border resaltarcon_copia_proveedorParametroFuncional=null;
	public Boolean mostrarcon_copia_proveedorParametroFuncional=true;
	public Boolean activarcon_copia_proveedorParametroFuncional=true;

	public Border resaltarcon_proveedor_clienteParametroFuncional=null;
	public Boolean mostrarcon_proveedor_clienteParametroFuncional=true;
	public Boolean activarcon_proveedor_clienteParametroFuncional=true;

	
	

	public Border setResaltaridParametroFuncional(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFuncionalBeanSwingJInternalFrame parametrofuncionalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofuncionalBeanSwingJInternalFrame.jTtoolBarParametroFuncional.setBorder(borderResaltar);
		
		this.resaltaridParametroFuncional= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroFuncional() {
		return this.resaltaridParametroFuncional;
	}

	public void setResaltaridParametroFuncional(Border borderResaltar) {
		this.resaltaridParametroFuncional= borderResaltar;
	}

	public Boolean getMostraridParametroFuncional() {
		return this.mostraridParametroFuncional;
	}

	public void setMostraridParametroFuncional(Boolean mostraridParametroFuncional) {
		this.mostraridParametroFuncional= mostraridParametroFuncional;
	}

	public Boolean getActivaridParametroFuncional() {
		return this.activaridParametroFuncional;
	}

	public void setActivaridParametroFuncional(Boolean activaridParametroFuncional) {
		this.activaridParametroFuncional= activaridParametroFuncional;
	}

	public Border setResaltarcon_copia_clientesParametroFuncional(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFuncionalBeanSwingJInternalFrame parametrofuncionalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofuncionalBeanSwingJInternalFrame.jTtoolBarParametroFuncional.setBorder(borderResaltar);
		
		this.resaltarcon_copia_clientesParametroFuncional= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_copia_clientesParametroFuncional() {
		return this.resaltarcon_copia_clientesParametroFuncional;
	}

	public void setResaltarcon_copia_clientesParametroFuncional(Border borderResaltar) {
		this.resaltarcon_copia_clientesParametroFuncional= borderResaltar;
	}

	public Boolean getMostrarcon_copia_clientesParametroFuncional() {
		return this.mostrarcon_copia_clientesParametroFuncional;
	}

	public void setMostrarcon_copia_clientesParametroFuncional(Boolean mostrarcon_copia_clientesParametroFuncional) {
		this.mostrarcon_copia_clientesParametroFuncional= mostrarcon_copia_clientesParametroFuncional;
	}

	public Boolean getActivarcon_copia_clientesParametroFuncional() {
		return this.activarcon_copia_clientesParametroFuncional;
	}

	public void setActivarcon_copia_clientesParametroFuncional(Boolean activarcon_copia_clientesParametroFuncional) {
		this.activarcon_copia_clientesParametroFuncional= activarcon_copia_clientesParametroFuncional;
	}

	public Border setResaltarcon_copia_proveedorParametroFuncional(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFuncionalBeanSwingJInternalFrame parametrofuncionalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofuncionalBeanSwingJInternalFrame.jTtoolBarParametroFuncional.setBorder(borderResaltar);
		
		this.resaltarcon_copia_proveedorParametroFuncional= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_copia_proveedorParametroFuncional() {
		return this.resaltarcon_copia_proveedorParametroFuncional;
	}

	public void setResaltarcon_copia_proveedorParametroFuncional(Border borderResaltar) {
		this.resaltarcon_copia_proveedorParametroFuncional= borderResaltar;
	}

	public Boolean getMostrarcon_copia_proveedorParametroFuncional() {
		return this.mostrarcon_copia_proveedorParametroFuncional;
	}

	public void setMostrarcon_copia_proveedorParametroFuncional(Boolean mostrarcon_copia_proveedorParametroFuncional) {
		this.mostrarcon_copia_proveedorParametroFuncional= mostrarcon_copia_proveedorParametroFuncional;
	}

	public Boolean getActivarcon_copia_proveedorParametroFuncional() {
		return this.activarcon_copia_proveedorParametroFuncional;
	}

	public void setActivarcon_copia_proveedorParametroFuncional(Boolean activarcon_copia_proveedorParametroFuncional) {
		this.activarcon_copia_proveedorParametroFuncional= activarcon_copia_proveedorParametroFuncional;
	}

	public Border setResaltarcon_proveedor_clienteParametroFuncional(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFuncionalBeanSwingJInternalFrame parametrofuncionalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofuncionalBeanSwingJInternalFrame.jTtoolBarParametroFuncional.setBorder(borderResaltar);
		
		this.resaltarcon_proveedor_clienteParametroFuncional= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_proveedor_clienteParametroFuncional() {
		return this.resaltarcon_proveedor_clienteParametroFuncional;
	}

	public void setResaltarcon_proveedor_clienteParametroFuncional(Border borderResaltar) {
		this.resaltarcon_proveedor_clienteParametroFuncional= borderResaltar;
	}

	public Boolean getMostrarcon_proveedor_clienteParametroFuncional() {
		return this.mostrarcon_proveedor_clienteParametroFuncional;
	}

	public void setMostrarcon_proveedor_clienteParametroFuncional(Boolean mostrarcon_proveedor_clienteParametroFuncional) {
		this.mostrarcon_proveedor_clienteParametroFuncional= mostrarcon_proveedor_clienteParametroFuncional;
	}

	public Boolean getActivarcon_proveedor_clienteParametroFuncional() {
		return this.activarcon_proveedor_clienteParametroFuncional;
	}

	public void setActivarcon_proveedor_clienteParametroFuncional(Boolean activarcon_proveedor_clienteParametroFuncional) {
		this.activarcon_proveedor_clienteParametroFuncional= activarcon_proveedor_clienteParametroFuncional;
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
		
		
		this.setMostraridParametroFuncional(esInicial);
		this.setMostrarcon_copia_clientesParametroFuncional(esInicial);
		this.setMostrarcon_copia_proveedorParametroFuncional(esInicial);
		this.setMostrarcon_proveedor_clienteParametroFuncional(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.ID)) {
				this.setMostraridParametroFuncional(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.CONCOPIACLIENTES)) {
				this.setMostrarcon_copia_clientesParametroFuncional(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.CONCOPIAPROVEEDOR)) {
				this.setMostrarcon_copia_proveedorParametroFuncional(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.CONPROVEEDORCLIENTE)) {
				this.setMostrarcon_proveedor_clienteParametroFuncional(esAsigna);
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
		
		
		this.setActivaridParametroFuncional(esInicial);
		this.setActivarcon_copia_clientesParametroFuncional(esInicial);
		this.setActivarcon_copia_proveedorParametroFuncional(esInicial);
		this.setActivarcon_proveedor_clienteParametroFuncional(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.ID)) {
				this.setActivaridParametroFuncional(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.CONCOPIACLIENTES)) {
				this.setActivarcon_copia_clientesParametroFuncional(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.CONCOPIAPROVEEDOR)) {
				this.setActivarcon_copia_proveedorParametroFuncional(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.CONPROVEEDORCLIENTE)) {
				this.setActivarcon_proveedor_clienteParametroFuncional(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFuncionalBeanSwingJInternalFrame parametrofuncionalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroFuncional(esInicial);
		this.setResaltarcon_copia_clientesParametroFuncional(esInicial);
		this.setResaltarcon_copia_proveedorParametroFuncional(esInicial);
		this.setResaltarcon_proveedor_clienteParametroFuncional(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.ID)) {
				this.setResaltaridParametroFuncional(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.CONCOPIACLIENTES)) {
				this.setResaltarcon_copia_clientesParametroFuncional(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.CONCOPIAPROVEEDOR)) {
				this.setResaltarcon_copia_proveedorParametroFuncional(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFuncionalConstantesFunciones.CONPROVEEDORCLIENTE)) {
				this.setResaltarcon_proveedor_clienteParametroFuncional(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFuncionalBeanSwingJInternalFrame parametrofuncionalBeanSwingJInternalFrame*/)throws Exception {	
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