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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.TasaConstantesFunciones;
import com.bydan.erp.facturacion.util.TasaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TasaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TasaConstantesFunciones extends TasaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Tasa";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Tasa"+TasaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TasaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TasaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TasaConstantesFunciones.SCHEMA+"_"+TasaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TasaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TasaConstantesFunciones.SCHEMA+"_"+TasaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TasaConstantesFunciones.SCHEMA+"_"+TasaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TasaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TasaConstantesFunciones.SCHEMA+"_"+TasaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TasaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TasaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TasaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TasaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TasaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TasaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TasaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TasaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TasaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TasaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tasas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tasa";
	public static final String SCLASSWEBTITULO_LOWER="Tasa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Tasa";
	public static final String OBJECTNAME="tasa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tasa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tasa from "+TasaConstantesFunciones.SPERSISTENCENAME+" tasa";
	public static String QUERYSELECTNATIVE="select "+TasaConstantesFunciones.SCHEMA+"."+TasaConstantesFunciones.TABLENAME+".id,"+TasaConstantesFunciones.SCHEMA+"."+TasaConstantesFunciones.TABLENAME+".version_row,"+TasaConstantesFunciones.SCHEMA+"."+TasaConstantesFunciones.TABLENAME+".id_empresa,"+TasaConstantesFunciones.SCHEMA+"."+TasaConstantesFunciones.TABLENAME+".valor from "+TasaConstantesFunciones.SCHEMA+"."+TasaConstantesFunciones.TABLENAME;//+" as "+TasaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TasaConstantesFuncionesAdditional tasaConstantesFuncionesAdditional=null;
	
	public TasaConstantesFuncionesAdditional getTasaConstantesFuncionesAdditional() {
		return this.tasaConstantesFuncionesAdditional;
	}
	
	public void setTasaConstantesFuncionesAdditional(TasaConstantesFuncionesAdditional tasaConstantesFuncionesAdditional) {
		try {
			this.tasaConstantesFuncionesAdditional=tasaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
	
	public static String getTasaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TasaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TasaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TasaConstantesFunciones.VALOR)) {sLabelColumna=TasaConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
	
	public static String getTasaDescripcion(Tasa tasa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tasa !=null/* && tasa.getId()!=0*/) {
			if(tasa.getId()!=null) {
				sDescripcion=tasa.getId().toString();
			}//tasatasa.getId().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTasaDescripcionDetallado(Tasa tasa) {
		String sDescripcion="";
			
		sDescripcion+=TasaConstantesFunciones.ID+"=";
		sDescripcion+=tasa.getId().toString()+",";
		sDescripcion+=TasaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tasa.getVersionRow().toString()+",";
		sDescripcion+=TasaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tasa.getid_empresa().toString()+",";
		sDescripcion+=TasaConstantesFunciones.VALOR+"=";
		sDescripcion+=tasa.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTasaDescripcion(Tasa tasa,String sValor) throws Exception {			
		if(tasa !=null) {
			;//tasatasa.getId().toString().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTasa(Tasa tasa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosTasas(List<Tasa> tasas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Tasa tasa: tasas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTasa(Tasa tasa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tasa.getConCambioAuxiliar()) {
			tasa.setIsDeleted(tasa.getIsDeletedAuxiliar());	
			tasa.setIsNew(tasa.getIsNewAuxiliar());	
			tasa.setIsChanged(tasa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tasa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tasa.setIsDeletedAuxiliar(false);	
			tasa.setIsNewAuxiliar(false);	
			tasa.setIsChangedAuxiliar(false);
			
			tasa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTasas(List<Tasa> tasas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Tasa tasa : tasas) {
			if(conAsignarBase && tasa.getConCambioAuxiliar()) {
				tasa.setIsDeleted(tasa.getIsDeletedAuxiliar());	
				tasa.setIsNew(tasa.getIsNewAuxiliar());	
				tasa.setIsChanged(tasa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tasa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tasa.setIsDeletedAuxiliar(false);	
				tasa.setIsNewAuxiliar(false);	
				tasa.setIsChangedAuxiliar(false);
				
				tasa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTasa(Tasa tasa,Boolean conEnteros) throws Exception  {
		tasa.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTasas(List<Tasa> tasas,Boolean conEnteros) throws Exception  {
		
		for(Tasa tasa: tasas) {
			tasa.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTasa(List<Tasa> tasas,Tasa tasaAux) throws Exception  {
		TasaConstantesFunciones.InicializarValoresTasa(tasaAux,true);
		
		for(Tasa tasa: tasas) {
			if(tasa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tasaAux.setvalor(tasaAux.getvalor()+tasa.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTasa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TasaConstantesFunciones.getArrayColumnasGlobalesTasa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTasa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TasaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TasaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTasa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Tasa> tasas,Tasa tasa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Tasa tasaAux: tasas) {
			if(tasaAux!=null && tasa!=null) {
				if((tasaAux.getId()==null && tasa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tasaAux.getId()!=null && tasa.getId()!=null){
					if(tasaAux.getId().equals(tasa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTasa(List<Tasa> tasas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(Tasa tasa: tasas) {			
			if(tasa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=tasa.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TasaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(TasaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTasa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TasaConstantesFunciones.LABEL_ID, TasaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TasaConstantesFunciones.LABEL_VERSIONROW, TasaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TasaConstantesFunciones.LABEL_IDEMPRESA, TasaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TasaConstantesFunciones.LABEL_VALOR, TasaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTasa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TasaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TasaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TasaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TasaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTasa() throws Exception  {
		return TasaConstantesFunciones.getTiposSeleccionarTasa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTasa(Boolean conFk) throws Exception  {
		return TasaConstantesFunciones.getTiposSeleccionarTasa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTasa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TasaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TasaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TasaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(TasaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTasa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTasa(Tasa tasaAux) throws Exception {
		
			tasaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tasaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTasa(List<Tasa> tasasTemp) throws Exception {
		for(Tasa tasaAux:tasasTemp) {
			
			tasaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tasaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTasa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTasa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTasa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TasaConstantesFunciones.getClassesRelationshipsOfTasa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTasa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TablaAmorti.class));
				classes.add(new Classe(TablaAmortiDetalle.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TablaAmorti.class)) {
						classes.add(new Classe(TablaAmorti.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TablaAmortiDetalle.class)) {
						classes.add(new Classe(TablaAmortiDetalle.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTasa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TasaConstantesFunciones.getClassesRelationshipsFromStringsOfTasa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTasa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TablaAmorti.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TablaAmorti.class)); continue;
					}

					if(TablaAmortiDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TablaAmortiDetalle.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TablaAmorti.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TablaAmorti.class)); continue;
					}

					if(TablaAmortiDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TablaAmortiDetalle.class)); continue;
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
	public static void actualizarLista(Tasa tasa,List<Tasa> tasas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Tasa tasaEncontrado=null;
			
			for(Tasa tasaLocal:tasas) {
				if(tasaLocal.getId().equals(tasa.getId())) {
					tasaEncontrado=tasaLocal;
					
					tasaLocal.setIsChanged(tasa.getIsChanged());
					tasaLocal.setIsNew(tasa.getIsNew());
					tasaLocal.setIsDeleted(tasa.getIsDeleted());
					
					tasaLocal.setGeneralEntityOriginal(tasa.getGeneralEntityOriginal());
					
					tasaLocal.setId(tasa.getId());	
					tasaLocal.setVersionRow(tasa.getVersionRow());	
					tasaLocal.setid_empresa(tasa.getid_empresa());	
					tasaLocal.setvalor(tasa.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tasa.getIsDeleted()) {
				if(!existe) {
					tasas.add(tasa);
				}
			} else {
				if(tasaEncontrado!=null && permiteQuitar)  {
					tasas.remove(tasaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Tasa tasa,List<Tasa> tasas) throws Exception {
		try	{			
			for(Tasa tasaLocal:tasas) {
				if(tasaLocal.getId().equals(tasa.getId())) {
					tasaLocal.setIsSelected(tasa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTasa(List<Tasa> tasasAux) throws Exception {
		//this.tasasAux=tasasAux;
		
		for(Tasa tasaAux:tasasAux) {
			if(tasaAux.getIsChanged()) {
				tasaAux.setIsChanged(false);
			}		
			
			if(tasaAux.getIsNew()) {
				tasaAux.setIsNew(false);
			}	
			
			if(tasaAux.getIsDeleted()) {
				tasaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTasa(Tasa tasaAux) throws Exception {
		//this.tasaAux=tasaAux;
		
			if(tasaAux.getIsChanged()) {
				tasaAux.setIsChanged(false);
			}		
			
			if(tasaAux.getIsNew()) {
				tasaAux.setIsNew(false);
			}	
			
			if(tasaAux.getIsDeleted()) {
				tasaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Tasa tasaAsignar,Tasa tasa) throws Exception {
		tasaAsignar.setId(tasa.getId());	
		tasaAsignar.setVersionRow(tasa.getVersionRow());	
		tasaAsignar.setid_empresa(tasa.getid_empresa());
		tasaAsignar.setempresa_descripcion(tasa.getempresa_descripcion());	
		tasaAsignar.setvalor(tasa.getvalor());	
	}
	
	public static void inicializarTasa(Tasa tasa) throws Exception {
		try {
				tasa.setId(0L);	
					
				tasa.setid_empresa(-1L);	
				tasa.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTasa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TasaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TasaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTasa(String sTipo,Row row,Workbook workbook,Tasa tasa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tasa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tasa.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTasa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTasa() {
		return this.sFinalQueryTasa;
	}
	
	public void setsFinalQueryTasa(String sFinalQueryTasa) {
		this.sFinalQueryTasa= sFinalQueryTasa;
	}
	
	public Border resaltarSeleccionarTasa=null;
	
	public Border setResaltarSeleccionarTasa(ParametroGeneralUsuario parametroGeneralUsuario/*TasaBeanSwingJInternalFrame tasaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tasaBeanSwingJInternalFrame.jTtoolBarTasa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTasa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTasa() {
		return this.resaltarSeleccionarTasa;
	}
	
	public void setResaltarSeleccionarTasa(Border borderResaltarSeleccionarTasa) {
		this.resaltarSeleccionarTasa= borderResaltarSeleccionarTasa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTasa=null;
	public Boolean mostraridTasa=true;
	public Boolean activaridTasa=true;

	public Border resaltarid_empresaTasa=null;
	public Boolean mostrarid_empresaTasa=true;
	public Boolean activarid_empresaTasa=true;
	public Boolean cargarid_empresaTasa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTasa=false;//ConEventDepend=true

	public Border resaltarvalorTasa=null;
	public Boolean mostrarvalorTasa=true;
	public Boolean activarvalorTasa=true;

	
	

	public Border setResaltaridTasa(ParametroGeneralUsuario parametroGeneralUsuario/*TasaBeanSwingJInternalFrame tasaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tasaBeanSwingJInternalFrame.jTtoolBarTasa.setBorder(borderResaltar);
		
		this.resaltaridTasa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTasa() {
		return this.resaltaridTasa;
	}

	public void setResaltaridTasa(Border borderResaltar) {
		this.resaltaridTasa= borderResaltar;
	}

	public Boolean getMostraridTasa() {
		return this.mostraridTasa;
	}

	public void setMostraridTasa(Boolean mostraridTasa) {
		this.mostraridTasa= mostraridTasa;
	}

	public Boolean getActivaridTasa() {
		return this.activaridTasa;
	}

	public void setActivaridTasa(Boolean activaridTasa) {
		this.activaridTasa= activaridTasa;
	}

	public Border setResaltarid_empresaTasa(ParametroGeneralUsuario parametroGeneralUsuario/*TasaBeanSwingJInternalFrame tasaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tasaBeanSwingJInternalFrame.jTtoolBarTasa.setBorder(borderResaltar);
		
		this.resaltarid_empresaTasa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTasa() {
		return this.resaltarid_empresaTasa;
	}

	public void setResaltarid_empresaTasa(Border borderResaltar) {
		this.resaltarid_empresaTasa= borderResaltar;
	}

	public Boolean getMostrarid_empresaTasa() {
		return this.mostrarid_empresaTasa;
	}

	public void setMostrarid_empresaTasa(Boolean mostrarid_empresaTasa) {
		this.mostrarid_empresaTasa= mostrarid_empresaTasa;
	}

	public Boolean getActivarid_empresaTasa() {
		return this.activarid_empresaTasa;
	}

	public void setActivarid_empresaTasa(Boolean activarid_empresaTasa) {
		this.activarid_empresaTasa= activarid_empresaTasa;
	}

	public Boolean getCargarid_empresaTasa() {
		return this.cargarid_empresaTasa;
	}

	public void setCargarid_empresaTasa(Boolean cargarid_empresaTasa) {
		this.cargarid_empresaTasa= cargarid_empresaTasa;
	}

	public Border setResaltarvalorTasa(ParametroGeneralUsuario parametroGeneralUsuario/*TasaBeanSwingJInternalFrame tasaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tasaBeanSwingJInternalFrame.jTtoolBarTasa.setBorder(borderResaltar);
		
		this.resaltarvalorTasa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorTasa() {
		return this.resaltarvalorTasa;
	}

	public void setResaltarvalorTasa(Border borderResaltar) {
		this.resaltarvalorTasa= borderResaltar;
	}

	public Boolean getMostrarvalorTasa() {
		return this.mostrarvalorTasa;
	}

	public void setMostrarvalorTasa(Boolean mostrarvalorTasa) {
		this.mostrarvalorTasa= mostrarvalorTasa;
	}

	public Boolean getActivarvalorTasa() {
		return this.activarvalorTasa;
	}

	public void setActivarvalorTasa(Boolean activarvalorTasa) {
		this.activarvalorTasa= activarvalorTasa;
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
		
		
		this.setMostraridTasa(esInicial);
		this.setMostrarid_empresaTasa(esInicial);
		this.setMostrarvalorTasa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TasaConstantesFunciones.ID)) {
				this.setMostraridTasa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TasaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTasa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TasaConstantesFunciones.VALOR)) {
				this.setMostrarvalorTasa(esAsigna);
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
		
		
		this.setActivaridTasa(esInicial);
		this.setActivarid_empresaTasa(esInicial);
		this.setActivarvalorTasa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TasaConstantesFunciones.ID)) {
				this.setActivaridTasa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TasaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTasa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TasaConstantesFunciones.VALOR)) {
				this.setActivarvalorTasa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TasaBeanSwingJInternalFrame tasaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTasa(esInicial);
		this.setResaltarid_empresaTasa(esInicial);
		this.setResaltarvalorTasa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TasaConstantesFunciones.ID)) {
				this.setResaltaridTasa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TasaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTasa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TasaConstantesFunciones.VALOR)) {
				this.setResaltarvalorTasa(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TasaBeanSwingJInternalFrame tasaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTasa=true;

	public Boolean getMostrarFK_IdEmpresaTasa() {
		return this.mostrarFK_IdEmpresaTasa;
	}

	public void setMostrarFK_IdEmpresaTasa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTasa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTasa=true;

	public Boolean getActivarFK_IdEmpresaTasa() {
		return this.activarFK_IdEmpresaTasa;
	}

	public void setActivarFK_IdEmpresaTasa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTasa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTasa=null;

	public Border getResaltarFK_IdEmpresaTasa() {
		return this.resaltarFK_IdEmpresaTasa;
	}

	public void setResaltarFK_IdEmpresaTasa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTasa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTasa(ParametroGeneralUsuario parametroGeneralUsuario/*TasaBeanSwingJInternalFrame tasaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTasa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}