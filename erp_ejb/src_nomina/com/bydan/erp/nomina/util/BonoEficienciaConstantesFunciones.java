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


import com.bydan.erp.nomina.util.BonoEficienciaConstantesFunciones;
import com.bydan.erp.nomina.util.BonoEficienciaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.BonoEficienciaParameterGeneral;

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
final public class BonoEficienciaConstantesFunciones extends BonoEficienciaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="BonoEficiencia";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="BonoEficiencia"+BonoEficienciaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BonoEficienciaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BonoEficienciaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BonoEficienciaConstantesFunciones.SCHEMA+"_"+BonoEficienciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BonoEficienciaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BonoEficienciaConstantesFunciones.SCHEMA+"_"+BonoEficienciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BonoEficienciaConstantesFunciones.SCHEMA+"_"+BonoEficienciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BonoEficienciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BonoEficienciaConstantesFunciones.SCHEMA+"_"+BonoEficienciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BonoEficienciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BonoEficienciaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BonoEficienciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BonoEficienciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BonoEficienciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BonoEficienciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BonoEficienciaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BonoEficienciaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BonoEficienciaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BonoEficienciaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Bono Eficiencias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Bono Eficiencia";
	public static final String SCLASSWEBTITULO_LOWER="Bono Eficiencia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="BonoEficiencia";
	public static final String OBJECTNAME="bonoeficiencia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="bono_eficiencia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select bonoeficiencia from "+BonoEficienciaConstantesFunciones.SPERSISTENCENAME+" bonoeficiencia";
	public static String QUERYSELECTNATIVE="select "+BonoEficienciaConstantesFunciones.SCHEMA+"."+BonoEficienciaConstantesFunciones.TABLENAME+".id,"+BonoEficienciaConstantesFunciones.SCHEMA+"."+BonoEficienciaConstantesFunciones.TABLENAME+".version_row,"+BonoEficienciaConstantesFunciones.SCHEMA+"."+BonoEficienciaConstantesFunciones.TABLENAME+".id_empresa,"+BonoEficienciaConstantesFunciones.SCHEMA+"."+BonoEficienciaConstantesFunciones.TABLENAME+".dias,"+BonoEficienciaConstantesFunciones.SCHEMA+"."+BonoEficienciaConstantesFunciones.TABLENAME+".valor from "+BonoEficienciaConstantesFunciones.SCHEMA+"."+BonoEficienciaConstantesFunciones.TABLENAME;//+" as "+BonoEficienciaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected BonoEficienciaConstantesFuncionesAdditional bonoeficienciaConstantesFuncionesAdditional=null;
	
	public BonoEficienciaConstantesFuncionesAdditional getBonoEficienciaConstantesFuncionesAdditional() {
		return this.bonoeficienciaConstantesFuncionesAdditional;
	}
	
	public void setBonoEficienciaConstantesFuncionesAdditional(BonoEficienciaConstantesFuncionesAdditional bonoeficienciaConstantesFuncionesAdditional) {
		try {
			this.bonoeficienciaConstantesFuncionesAdditional=bonoeficienciaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String DIAS= "dias";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_DIAS= "Dias";
		public static final String LABEL_DIAS_LOWER= "Dias";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
	
	public static String getBonoEficienciaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BonoEficienciaConstantesFunciones.IDEMPRESA)) {sLabelColumna=BonoEficienciaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BonoEficienciaConstantesFunciones.DIAS)) {sLabelColumna=BonoEficienciaConstantesFunciones.LABEL_DIAS;}
		if(sNombreColumna.equals(BonoEficienciaConstantesFunciones.VALOR)) {sLabelColumna=BonoEficienciaConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getBonoEficienciaDescripcion(BonoEficiencia bonoeficiencia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(bonoeficiencia !=null/* && bonoeficiencia.getId()!=0*/) {
			if(bonoeficiencia.getId()!=null) {
				sDescripcion=bonoeficiencia.getId().toString();
			}//bonoeficienciabonoeficiencia.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getBonoEficienciaDescripcionDetallado(BonoEficiencia bonoeficiencia) {
		String sDescripcion="";
			
		sDescripcion+=BonoEficienciaConstantesFunciones.ID+"=";
		sDescripcion+=bonoeficiencia.getId().toString()+",";
		sDescripcion+=BonoEficienciaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=bonoeficiencia.getVersionRow().toString()+",";
		sDescripcion+=BonoEficienciaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=bonoeficiencia.getid_empresa().toString()+",";
		sDescripcion+=BonoEficienciaConstantesFunciones.DIAS+"=";
		sDescripcion+=bonoeficiencia.getdias().toString()+",";
		sDescripcion+=BonoEficienciaConstantesFunciones.VALOR+"=";
		sDescripcion+=bonoeficiencia.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setBonoEficienciaDescripcion(BonoEficiencia bonoeficiencia,String sValor) throws Exception {			
		if(bonoeficiencia !=null) {
			//bonoeficienciabonoeficiencia.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosBonoEficiencia(BonoEficiencia bonoeficiencia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosBonoEficiencias(List<BonoEficiencia> bonoeficiencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BonoEficiencia bonoeficiencia: bonoeficiencias) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBonoEficiencia(BonoEficiencia bonoeficiencia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && bonoeficiencia.getConCambioAuxiliar()) {
			bonoeficiencia.setIsDeleted(bonoeficiencia.getIsDeletedAuxiliar());	
			bonoeficiencia.setIsNew(bonoeficiencia.getIsNewAuxiliar());	
			bonoeficiencia.setIsChanged(bonoeficiencia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			bonoeficiencia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			bonoeficiencia.setIsDeletedAuxiliar(false);	
			bonoeficiencia.setIsNewAuxiliar(false);	
			bonoeficiencia.setIsChangedAuxiliar(false);
			
			bonoeficiencia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBonoEficiencias(List<BonoEficiencia> bonoeficiencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(BonoEficiencia bonoeficiencia : bonoeficiencias) {
			if(conAsignarBase && bonoeficiencia.getConCambioAuxiliar()) {
				bonoeficiencia.setIsDeleted(bonoeficiencia.getIsDeletedAuxiliar());	
				bonoeficiencia.setIsNew(bonoeficiencia.getIsNewAuxiliar());	
				bonoeficiencia.setIsChanged(bonoeficiencia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				bonoeficiencia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				bonoeficiencia.setIsDeletedAuxiliar(false);	
				bonoeficiencia.setIsNewAuxiliar(false);	
				bonoeficiencia.setIsChangedAuxiliar(false);
				
				bonoeficiencia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBonoEficiencia(BonoEficiencia bonoeficiencia,Boolean conEnteros) throws Exception  {
		bonoeficiencia.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			bonoeficiencia.setdias(0);
		}
	}		
	
	public static void InicializarValoresBonoEficiencias(List<BonoEficiencia> bonoeficiencias,Boolean conEnteros) throws Exception  {
		
		for(BonoEficiencia bonoeficiencia: bonoeficiencias) {
			bonoeficiencia.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				bonoeficiencia.setdias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaBonoEficiencia(List<BonoEficiencia> bonoeficiencias,BonoEficiencia bonoeficienciaAux) throws Exception  {
		BonoEficienciaConstantesFunciones.InicializarValoresBonoEficiencia(bonoeficienciaAux,true);
		
		for(BonoEficiencia bonoeficiencia: bonoeficiencias) {
			if(bonoeficiencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			bonoeficienciaAux.setdias(bonoeficienciaAux.getdias()+bonoeficiencia.getdias());			
			bonoeficienciaAux.setvalor(bonoeficienciaAux.getvalor()+bonoeficiencia.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBonoEficiencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BonoEficienciaConstantesFunciones.getArrayColumnasGlobalesBonoEficiencia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBonoEficiencia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BonoEficienciaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BonoEficienciaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBonoEficiencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<BonoEficiencia> bonoeficiencias,BonoEficiencia bonoeficiencia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(BonoEficiencia bonoeficienciaAux: bonoeficiencias) {
			if(bonoeficienciaAux!=null && bonoeficiencia!=null) {
				if((bonoeficienciaAux.getId()==null && bonoeficiencia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(bonoeficienciaAux.getId()!=null && bonoeficiencia.getId()!=null){
					if(bonoeficienciaAux.getId().equals(bonoeficiencia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBonoEficiencia(List<BonoEficiencia> bonoeficiencias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(BonoEficiencia bonoeficiencia: bonoeficiencias) {			
			if(bonoeficiencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=bonoeficiencia.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BonoEficienciaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(BonoEficienciaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBonoEficiencia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BonoEficienciaConstantesFunciones.LABEL_ID, BonoEficienciaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BonoEficienciaConstantesFunciones.LABEL_VERSIONROW, BonoEficienciaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BonoEficienciaConstantesFunciones.LABEL_IDEMPRESA, BonoEficienciaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BonoEficienciaConstantesFunciones.LABEL_DIAS, BonoEficienciaConstantesFunciones.DIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BonoEficienciaConstantesFunciones.LABEL_VALOR, BonoEficienciaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBonoEficiencia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BonoEficienciaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BonoEficienciaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BonoEficienciaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BonoEficienciaConstantesFunciones.DIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BonoEficienciaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBonoEficiencia() throws Exception  {
		return BonoEficienciaConstantesFunciones.getTiposSeleccionarBonoEficiencia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBonoEficiencia(Boolean conFk) throws Exception  {
		return BonoEficienciaConstantesFunciones.getTiposSeleccionarBonoEficiencia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBonoEficiencia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BonoEficienciaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BonoEficienciaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BonoEficienciaConstantesFunciones.LABEL_DIAS);
			reporte.setsDescripcion(BonoEficienciaConstantesFunciones.LABEL_DIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BonoEficienciaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(BonoEficienciaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBonoEficiencia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBonoEficiencia(BonoEficiencia bonoeficienciaAux) throws Exception {
		
			bonoeficienciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bonoeficienciaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBonoEficiencia(List<BonoEficiencia> bonoeficienciasTemp) throws Exception {
		for(BonoEficiencia bonoeficienciaAux:bonoeficienciasTemp) {
			
			bonoeficienciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bonoeficienciaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBonoEficiencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBonoEficiencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBonoEficiencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BonoEficienciaConstantesFunciones.getClassesRelationshipsOfBonoEficiencia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBonoEficiencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBonoEficiencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BonoEficienciaConstantesFunciones.getClassesRelationshipsFromStringsOfBonoEficiencia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBonoEficiencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(BonoEficiencia bonoeficiencia,List<BonoEficiencia> bonoeficiencias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			BonoEficiencia bonoeficienciaEncontrado=null;
			
			for(BonoEficiencia bonoeficienciaLocal:bonoeficiencias) {
				if(bonoeficienciaLocal.getId().equals(bonoeficiencia.getId())) {
					bonoeficienciaEncontrado=bonoeficienciaLocal;
					
					bonoeficienciaLocal.setIsChanged(bonoeficiencia.getIsChanged());
					bonoeficienciaLocal.setIsNew(bonoeficiencia.getIsNew());
					bonoeficienciaLocal.setIsDeleted(bonoeficiencia.getIsDeleted());
					
					bonoeficienciaLocal.setGeneralEntityOriginal(bonoeficiencia.getGeneralEntityOriginal());
					
					bonoeficienciaLocal.setId(bonoeficiencia.getId());	
					bonoeficienciaLocal.setVersionRow(bonoeficiencia.getVersionRow());	
					bonoeficienciaLocal.setid_empresa(bonoeficiencia.getid_empresa());	
					bonoeficienciaLocal.setdias(bonoeficiencia.getdias());	
					bonoeficienciaLocal.setvalor(bonoeficiencia.getvalor());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!bonoeficiencia.getIsDeleted()) {
				if(!existe) {
					bonoeficiencias.add(bonoeficiencia);
				}
			} else {
				if(bonoeficienciaEncontrado!=null && permiteQuitar)  {
					bonoeficiencias.remove(bonoeficienciaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(BonoEficiencia bonoeficiencia,List<BonoEficiencia> bonoeficiencias) throws Exception {
		try	{			
			for(BonoEficiencia bonoeficienciaLocal:bonoeficiencias) {
				if(bonoeficienciaLocal.getId().equals(bonoeficiencia.getId())) {
					bonoeficienciaLocal.setIsSelected(bonoeficiencia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBonoEficiencia(List<BonoEficiencia> bonoeficienciasAux) throws Exception {
		//this.bonoeficienciasAux=bonoeficienciasAux;
		
		for(BonoEficiencia bonoeficienciaAux:bonoeficienciasAux) {
			if(bonoeficienciaAux.getIsChanged()) {
				bonoeficienciaAux.setIsChanged(false);
			}		
			
			if(bonoeficienciaAux.getIsNew()) {
				bonoeficienciaAux.setIsNew(false);
			}	
			
			if(bonoeficienciaAux.getIsDeleted()) {
				bonoeficienciaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBonoEficiencia(BonoEficiencia bonoeficienciaAux) throws Exception {
		//this.bonoeficienciaAux=bonoeficienciaAux;
		
			if(bonoeficienciaAux.getIsChanged()) {
				bonoeficienciaAux.setIsChanged(false);
			}		
			
			if(bonoeficienciaAux.getIsNew()) {
				bonoeficienciaAux.setIsNew(false);
			}	
			
			if(bonoeficienciaAux.getIsDeleted()) {
				bonoeficienciaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(BonoEficiencia bonoeficienciaAsignar,BonoEficiencia bonoeficiencia) throws Exception {
		bonoeficienciaAsignar.setId(bonoeficiencia.getId());	
		bonoeficienciaAsignar.setVersionRow(bonoeficiencia.getVersionRow());	
		bonoeficienciaAsignar.setid_empresa(bonoeficiencia.getid_empresa());
		bonoeficienciaAsignar.setempresa_descripcion(bonoeficiencia.getempresa_descripcion());	
		bonoeficienciaAsignar.setdias(bonoeficiencia.getdias());	
		bonoeficienciaAsignar.setvalor(bonoeficiencia.getvalor());	
	}
	
	public static void inicializarBonoEficiencia(BonoEficiencia bonoeficiencia) throws Exception {
		try {
				bonoeficiencia.setId(0L);	
					
				bonoeficiencia.setid_empresa(-1L);	
				bonoeficiencia.setdias(0);	
				bonoeficiencia.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBonoEficiencia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BonoEficienciaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BonoEficienciaConstantesFunciones.LABEL_DIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BonoEficienciaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBonoEficiencia(String sTipo,Row row,Workbook workbook,BonoEficiencia bonoeficiencia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(bonoeficiencia.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bonoeficiencia.getdias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bonoeficiencia.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBonoEficiencia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryBonoEficiencia() {
		return this.sFinalQueryBonoEficiencia;
	}
	
	public void setsFinalQueryBonoEficiencia(String sFinalQueryBonoEficiencia) {
		this.sFinalQueryBonoEficiencia= sFinalQueryBonoEficiencia;
	}
	
	public Border resaltarSeleccionarBonoEficiencia=null;
	
	public Border setResaltarSeleccionarBonoEficiencia(ParametroGeneralUsuario parametroGeneralUsuario/*BonoEficienciaBeanSwingJInternalFrame bonoeficienciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//bonoeficienciaBeanSwingJInternalFrame.jTtoolBarBonoEficiencia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBonoEficiencia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBonoEficiencia() {
		return this.resaltarSeleccionarBonoEficiencia;
	}
	
	public void setResaltarSeleccionarBonoEficiencia(Border borderResaltarSeleccionarBonoEficiencia) {
		this.resaltarSeleccionarBonoEficiencia= borderResaltarSeleccionarBonoEficiencia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBonoEficiencia=null;
	public Boolean mostraridBonoEficiencia=true;
	public Boolean activaridBonoEficiencia=true;

	public Border resaltarid_empresaBonoEficiencia=null;
	public Boolean mostrarid_empresaBonoEficiencia=true;
	public Boolean activarid_empresaBonoEficiencia=true;
	public Boolean cargarid_empresaBonoEficiencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBonoEficiencia=false;//ConEventDepend=true

	public Border resaltardiasBonoEficiencia=null;
	public Boolean mostrardiasBonoEficiencia=true;
	public Boolean activardiasBonoEficiencia=true;

	public Border resaltarvalorBonoEficiencia=null;
	public Boolean mostrarvalorBonoEficiencia=true;
	public Boolean activarvalorBonoEficiencia=true;

	
	

	public Border setResaltaridBonoEficiencia(ParametroGeneralUsuario parametroGeneralUsuario/*BonoEficienciaBeanSwingJInternalFrame bonoeficienciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bonoeficienciaBeanSwingJInternalFrame.jTtoolBarBonoEficiencia.setBorder(borderResaltar);
		
		this.resaltaridBonoEficiencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBonoEficiencia() {
		return this.resaltaridBonoEficiencia;
	}

	public void setResaltaridBonoEficiencia(Border borderResaltar) {
		this.resaltaridBonoEficiencia= borderResaltar;
	}

	public Boolean getMostraridBonoEficiencia() {
		return this.mostraridBonoEficiencia;
	}

	public void setMostraridBonoEficiencia(Boolean mostraridBonoEficiencia) {
		this.mostraridBonoEficiencia= mostraridBonoEficiencia;
	}

	public Boolean getActivaridBonoEficiencia() {
		return this.activaridBonoEficiencia;
	}

	public void setActivaridBonoEficiencia(Boolean activaridBonoEficiencia) {
		this.activaridBonoEficiencia= activaridBonoEficiencia;
	}

	public Border setResaltarid_empresaBonoEficiencia(ParametroGeneralUsuario parametroGeneralUsuario/*BonoEficienciaBeanSwingJInternalFrame bonoeficienciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bonoeficienciaBeanSwingJInternalFrame.jTtoolBarBonoEficiencia.setBorder(borderResaltar);
		
		this.resaltarid_empresaBonoEficiencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBonoEficiencia() {
		return this.resaltarid_empresaBonoEficiencia;
	}

	public void setResaltarid_empresaBonoEficiencia(Border borderResaltar) {
		this.resaltarid_empresaBonoEficiencia= borderResaltar;
	}

	public Boolean getMostrarid_empresaBonoEficiencia() {
		return this.mostrarid_empresaBonoEficiencia;
	}

	public void setMostrarid_empresaBonoEficiencia(Boolean mostrarid_empresaBonoEficiencia) {
		this.mostrarid_empresaBonoEficiencia= mostrarid_empresaBonoEficiencia;
	}

	public Boolean getActivarid_empresaBonoEficiencia() {
		return this.activarid_empresaBonoEficiencia;
	}

	public void setActivarid_empresaBonoEficiencia(Boolean activarid_empresaBonoEficiencia) {
		this.activarid_empresaBonoEficiencia= activarid_empresaBonoEficiencia;
	}

	public Boolean getCargarid_empresaBonoEficiencia() {
		return this.cargarid_empresaBonoEficiencia;
	}

	public void setCargarid_empresaBonoEficiencia(Boolean cargarid_empresaBonoEficiencia) {
		this.cargarid_empresaBonoEficiencia= cargarid_empresaBonoEficiencia;
	}

	public Border setResaltardiasBonoEficiencia(ParametroGeneralUsuario parametroGeneralUsuario/*BonoEficienciaBeanSwingJInternalFrame bonoeficienciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bonoeficienciaBeanSwingJInternalFrame.jTtoolBarBonoEficiencia.setBorder(borderResaltar);
		
		this.resaltardiasBonoEficiencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardiasBonoEficiencia() {
		return this.resaltardiasBonoEficiencia;
	}

	public void setResaltardiasBonoEficiencia(Border borderResaltar) {
		this.resaltardiasBonoEficiencia= borderResaltar;
	}

	public Boolean getMostrardiasBonoEficiencia() {
		return this.mostrardiasBonoEficiencia;
	}

	public void setMostrardiasBonoEficiencia(Boolean mostrardiasBonoEficiencia) {
		this.mostrardiasBonoEficiencia= mostrardiasBonoEficiencia;
	}

	public Boolean getActivardiasBonoEficiencia() {
		return this.activardiasBonoEficiencia;
	}

	public void setActivardiasBonoEficiencia(Boolean activardiasBonoEficiencia) {
		this.activardiasBonoEficiencia= activardiasBonoEficiencia;
	}

	public Border setResaltarvalorBonoEficiencia(ParametroGeneralUsuario parametroGeneralUsuario/*BonoEficienciaBeanSwingJInternalFrame bonoeficienciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bonoeficienciaBeanSwingJInternalFrame.jTtoolBarBonoEficiencia.setBorder(borderResaltar);
		
		this.resaltarvalorBonoEficiencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorBonoEficiencia() {
		return this.resaltarvalorBonoEficiencia;
	}

	public void setResaltarvalorBonoEficiencia(Border borderResaltar) {
		this.resaltarvalorBonoEficiencia= borderResaltar;
	}

	public Boolean getMostrarvalorBonoEficiencia() {
		return this.mostrarvalorBonoEficiencia;
	}

	public void setMostrarvalorBonoEficiencia(Boolean mostrarvalorBonoEficiencia) {
		this.mostrarvalorBonoEficiencia= mostrarvalorBonoEficiencia;
	}

	public Boolean getActivarvalorBonoEficiencia() {
		return this.activarvalorBonoEficiencia;
	}

	public void setActivarvalorBonoEficiencia(Boolean activarvalorBonoEficiencia) {
		this.activarvalorBonoEficiencia= activarvalorBonoEficiencia;
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
		
		
		this.setMostraridBonoEficiencia(esInicial);
		this.setMostrarid_empresaBonoEficiencia(esInicial);
		this.setMostrardiasBonoEficiencia(esInicial);
		this.setMostrarvalorBonoEficiencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.ID)) {
				this.setMostraridBonoEficiencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBonoEficiencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.DIAS)) {
				this.setMostrardiasBonoEficiencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.VALOR)) {
				this.setMostrarvalorBonoEficiencia(esAsigna);
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
		
		
		this.setActivaridBonoEficiencia(esInicial);
		this.setActivarid_empresaBonoEficiencia(esInicial);
		this.setActivardiasBonoEficiencia(esInicial);
		this.setActivarvalorBonoEficiencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.ID)) {
				this.setActivaridBonoEficiencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBonoEficiencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.DIAS)) {
				this.setActivardiasBonoEficiencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.VALOR)) {
				this.setActivarvalorBonoEficiencia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BonoEficienciaBeanSwingJInternalFrame bonoeficienciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBonoEficiencia(esInicial);
		this.setResaltarid_empresaBonoEficiencia(esInicial);
		this.setResaltardiasBonoEficiencia(esInicial);
		this.setResaltarvalorBonoEficiencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.ID)) {
				this.setResaltaridBonoEficiencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBonoEficiencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.DIAS)) {
				this.setResaltardiasBonoEficiencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(BonoEficienciaConstantesFunciones.VALOR)) {
				this.setResaltarvalorBonoEficiencia(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BonoEficienciaBeanSwingJInternalFrame bonoeficienciaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaBonoEficiencia=true;

	public Boolean getMostrarFK_IdEmpresaBonoEficiencia() {
		return this.mostrarFK_IdEmpresaBonoEficiencia;
	}

	public void setMostrarFK_IdEmpresaBonoEficiencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaBonoEficiencia= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaBonoEficiencia=true;

	public Boolean getActivarFK_IdEmpresaBonoEficiencia() {
		return this.activarFK_IdEmpresaBonoEficiencia;
	}

	public void setActivarFK_IdEmpresaBonoEficiencia(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaBonoEficiencia= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaBonoEficiencia=null;

	public Border getResaltarFK_IdEmpresaBonoEficiencia() {
		return this.resaltarFK_IdEmpresaBonoEficiencia;
	}

	public void setResaltarFK_IdEmpresaBonoEficiencia(Border borderResaltar) {
		this.resaltarFK_IdEmpresaBonoEficiencia= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaBonoEficiencia(ParametroGeneralUsuario parametroGeneralUsuario/*BonoEficienciaBeanSwingJInternalFrame bonoeficienciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaBonoEficiencia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}