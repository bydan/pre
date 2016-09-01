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
package com.bydan.erp.produccion.util;

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


import com.bydan.erp.produccion.util.TipoMermaEmpresaConstantesFunciones;
import com.bydan.erp.produccion.util.TipoMermaEmpresaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoMermaEmpresaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoMermaEmpresaConstantesFunciones extends TipoMermaEmpresaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoMermaEmpresa";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoMermaEmpresa"+TipoMermaEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoMermaEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoMermaEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoMermaEmpresaConstantesFunciones.SCHEMA+"_"+TipoMermaEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoMermaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoMermaEmpresaConstantesFunciones.SCHEMA+"_"+TipoMermaEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoMermaEmpresaConstantesFunciones.SCHEMA+"_"+TipoMermaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoMermaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoMermaEmpresaConstantesFunciones.SCHEMA+"_"+TipoMermaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMermaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMermaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMermaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMermaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMermaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMermaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoMermaEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoMermaEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoMermaEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoMermaEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Merma Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Merma Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Merma Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoMermaEmpresa";
	public static final String OBJECTNAME="tipomermaempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="tipo_merma_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipomermaempresa from "+TipoMermaEmpresaConstantesFunciones.SPERSISTENCENAME+" tipomermaempresa";
	public static String QUERYSELECTNATIVE="select "+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".id,"+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME+".descripcion from "+TipoMermaEmpresaConstantesFunciones.SCHEMA+"."+TipoMermaEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoMermaEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoMermaEmpresaConstantesFuncionesAdditional tipomermaempresaConstantesFuncionesAdditional=null;
	
	public TipoMermaEmpresaConstantesFuncionesAdditional getTipoMermaEmpresaConstantesFuncionesAdditional() {
		return this.tipomermaempresaConstantesFuncionesAdditional;
	}
	
	public void setTipoMermaEmpresaConstantesFuncionesAdditional(TipoMermaEmpresaConstantesFuncionesAdditional tipomermaempresaConstantesFuncionesAdditional) {
		try {
			this.tipomermaempresaConstantesFuncionesAdditional=tipomermaempresaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoMermaEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoMermaEmpresaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoMermaEmpresaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoMermaEmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoMermaEmpresaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoMermaEmpresaConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoMermaEmpresaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoMermaEmpresaDescripcion(TipoMermaEmpresa tipomermaempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipomermaempresa !=null/* && tipomermaempresa.getId()!=0*/) {
			sDescripcion=tipomermaempresa.getnombre();//tipomermaempresatipomermaempresa.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoMermaEmpresaDescripcionDetallado(TipoMermaEmpresa tipomermaempresa) {
		String sDescripcion="";
			
		sDescripcion+=TipoMermaEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=tipomermaempresa.getId().toString()+",";
		sDescripcion+=TipoMermaEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipomermaempresa.getVersionRow().toString()+",";
		sDescripcion+=TipoMermaEmpresaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipomermaempresa.getid_empresa().toString()+",";
		sDescripcion+=TipoMermaEmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipomermaempresa.getnombre()+",";
		sDescripcion+=TipoMermaEmpresaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipomermaempresa.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoMermaEmpresaDescripcion(TipoMermaEmpresa tipomermaempresa,String sValor) throws Exception {			
		if(tipomermaempresa !=null) {
			tipomermaempresa.setnombre(sValor);;//tipomermaempresatipomermaempresa.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoMermaEmpresa(TipoMermaEmpresa tipomermaempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomermaempresa.setnombre(tipomermaempresa.getnombre().trim());
		tipomermaempresa.setdescripcion(tipomermaempresa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoMermaEmpresas(List<TipoMermaEmpresa> tipomermaempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoMermaEmpresa tipomermaempresa: tipomermaempresas) {
			tipomermaempresa.setnombre(tipomermaempresa.getnombre().trim());
			tipomermaempresa.setdescripcion(tipomermaempresa.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMermaEmpresa(TipoMermaEmpresa tipomermaempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipomermaempresa.getConCambioAuxiliar()) {
			tipomermaempresa.setIsDeleted(tipomermaempresa.getIsDeletedAuxiliar());	
			tipomermaempresa.setIsNew(tipomermaempresa.getIsNewAuxiliar());	
			tipomermaempresa.setIsChanged(tipomermaempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipomermaempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipomermaempresa.setIsDeletedAuxiliar(false);	
			tipomermaempresa.setIsNewAuxiliar(false);	
			tipomermaempresa.setIsChangedAuxiliar(false);
			
			tipomermaempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMermaEmpresas(List<TipoMermaEmpresa> tipomermaempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoMermaEmpresa tipomermaempresa : tipomermaempresas) {
			if(conAsignarBase && tipomermaempresa.getConCambioAuxiliar()) {
				tipomermaempresa.setIsDeleted(tipomermaempresa.getIsDeletedAuxiliar());	
				tipomermaempresa.setIsNew(tipomermaempresa.getIsNewAuxiliar());	
				tipomermaempresa.setIsChanged(tipomermaempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipomermaempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipomermaempresa.setIsDeletedAuxiliar(false);	
				tipomermaempresa.setIsNewAuxiliar(false);	
				tipomermaempresa.setIsChangedAuxiliar(false);
				
				tipomermaempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoMermaEmpresa(TipoMermaEmpresa tipomermaempresa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoMermaEmpresas(List<TipoMermaEmpresa> tipomermaempresas,Boolean conEnteros) throws Exception  {
		
		for(TipoMermaEmpresa tipomermaempresa: tipomermaempresas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoMermaEmpresa(List<TipoMermaEmpresa> tipomermaempresas,TipoMermaEmpresa tipomermaempresaAux) throws Exception  {
		TipoMermaEmpresaConstantesFunciones.InicializarValoresTipoMermaEmpresa(tipomermaempresaAux,true);
		
		for(TipoMermaEmpresa tipomermaempresa: tipomermaempresas) {
			if(tipomermaempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMermaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoMermaEmpresaConstantesFunciones.getArrayColumnasGlobalesTipoMermaEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMermaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoMermaEmpresaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoMermaEmpresaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoMermaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoMermaEmpresa> tipomermaempresas,TipoMermaEmpresa tipomermaempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoMermaEmpresa tipomermaempresaAux: tipomermaempresas) {
			if(tipomermaempresaAux!=null && tipomermaempresa!=null) {
				if((tipomermaempresaAux.getId()==null && tipomermaempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipomermaempresaAux.getId()!=null && tipomermaempresa.getId()!=null){
					if(tipomermaempresaAux.getId().equals(tipomermaempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoMermaEmpresa(List<TipoMermaEmpresa> tipomermaempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoMermaEmpresa tipomermaempresa: tipomermaempresas) {			
			if(tipomermaempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoMermaEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoMermaEmpresaConstantesFunciones.LABEL_ID, TipoMermaEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMermaEmpresaConstantesFunciones.LABEL_VERSIONROW, TipoMermaEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMermaEmpresaConstantesFunciones.LABEL_IDEMPRESA, TipoMermaEmpresaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMermaEmpresaConstantesFunciones.LABEL_NOMBRE, TipoMermaEmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMermaEmpresaConstantesFunciones.LABEL_DESCRIPCION, TipoMermaEmpresaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoMermaEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoMermaEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMermaEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMermaEmpresaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMermaEmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMermaEmpresaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMermaEmpresa() throws Exception  {
		return TipoMermaEmpresaConstantesFunciones.getTiposSeleccionarTipoMermaEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMermaEmpresa(Boolean conFk) throws Exception  {
		return TipoMermaEmpresaConstantesFunciones.getTiposSeleccionarTipoMermaEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMermaEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMermaEmpresaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoMermaEmpresaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMermaEmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoMermaEmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMermaEmpresaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoMermaEmpresaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoMermaEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMermaEmpresa(TipoMermaEmpresa tipomermaempresaAux) throws Exception {
		
			tipomermaempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipomermaempresaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMermaEmpresa(List<TipoMermaEmpresa> tipomermaempresasTemp) throws Exception {
		for(TipoMermaEmpresa tipomermaempresaAux:tipomermaempresasTemp) {
			
			tipomermaempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipomermaempresaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMermaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoMermaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMermaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMermaEmpresaConstantesFunciones.getClassesRelationshipsOfTipoMermaEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMermaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoOrdenDetaProduMerma.class));
				classes.add(new Classe(ProductoProduMerma.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProduMerma.class)) {
						classes.add(new Classe(ProductoOrdenDetaProduMerma.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProduMerma.class)) {
						classes.add(new Classe(ProductoProduMerma.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMermaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMermaEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoMermaEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMermaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoOrdenDetaProduMerma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMerma.class)); continue;
					}

					if(ProductoProduMerma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMerma.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoOrdenDetaProduMerma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMerma.class)); continue;
					}

					if(ProductoProduMerma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMerma.class)); continue;
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
	public static void actualizarLista(TipoMermaEmpresa tipomermaempresa,List<TipoMermaEmpresa> tipomermaempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoMermaEmpresa tipomermaempresaEncontrado=null;
			
			for(TipoMermaEmpresa tipomermaempresaLocal:tipomermaempresas) {
				if(tipomermaempresaLocal.getId().equals(tipomermaempresa.getId())) {
					tipomermaempresaEncontrado=tipomermaempresaLocal;
					
					tipomermaempresaLocal.setIsChanged(tipomermaempresa.getIsChanged());
					tipomermaempresaLocal.setIsNew(tipomermaempresa.getIsNew());
					tipomermaempresaLocal.setIsDeleted(tipomermaempresa.getIsDeleted());
					
					tipomermaempresaLocal.setGeneralEntityOriginal(tipomermaempresa.getGeneralEntityOriginal());
					
					tipomermaempresaLocal.setId(tipomermaempresa.getId());	
					tipomermaempresaLocal.setVersionRow(tipomermaempresa.getVersionRow());	
					tipomermaempresaLocal.setid_empresa(tipomermaempresa.getid_empresa());	
					tipomermaempresaLocal.setnombre(tipomermaempresa.getnombre());	
					tipomermaempresaLocal.setdescripcion(tipomermaempresa.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipomermaempresa.getIsDeleted()) {
				if(!existe) {
					tipomermaempresas.add(tipomermaempresa);
				}
			} else {
				if(tipomermaempresaEncontrado!=null && permiteQuitar)  {
					tipomermaempresas.remove(tipomermaempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoMermaEmpresa tipomermaempresa,List<TipoMermaEmpresa> tipomermaempresas) throws Exception {
		try	{			
			for(TipoMermaEmpresa tipomermaempresaLocal:tipomermaempresas) {
				if(tipomermaempresaLocal.getId().equals(tipomermaempresa.getId())) {
					tipomermaempresaLocal.setIsSelected(tipomermaempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoMermaEmpresa(List<TipoMermaEmpresa> tipomermaempresasAux) throws Exception {
		//this.tipomermaempresasAux=tipomermaempresasAux;
		
		for(TipoMermaEmpresa tipomermaempresaAux:tipomermaempresasAux) {
			if(tipomermaempresaAux.getIsChanged()) {
				tipomermaempresaAux.setIsChanged(false);
			}		
			
			if(tipomermaempresaAux.getIsNew()) {
				tipomermaempresaAux.setIsNew(false);
			}	
			
			if(tipomermaempresaAux.getIsDeleted()) {
				tipomermaempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoMermaEmpresa(TipoMermaEmpresa tipomermaempresaAux) throws Exception {
		//this.tipomermaempresaAux=tipomermaempresaAux;
		
			if(tipomermaempresaAux.getIsChanged()) {
				tipomermaempresaAux.setIsChanged(false);
			}		
			
			if(tipomermaempresaAux.getIsNew()) {
				tipomermaempresaAux.setIsNew(false);
			}	
			
			if(tipomermaempresaAux.getIsDeleted()) {
				tipomermaempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoMermaEmpresa tipomermaempresaAsignar,TipoMermaEmpresa tipomermaempresa) throws Exception {
		tipomermaempresaAsignar.setId(tipomermaempresa.getId());	
		tipomermaempresaAsignar.setVersionRow(tipomermaempresa.getVersionRow());	
		tipomermaempresaAsignar.setid_empresa(tipomermaempresa.getid_empresa());
		tipomermaempresaAsignar.setempresa_descripcion(tipomermaempresa.getempresa_descripcion());	
		tipomermaempresaAsignar.setnombre(tipomermaempresa.getnombre());	
		tipomermaempresaAsignar.setdescripcion(tipomermaempresa.getdescripcion());	
	}
	
	public static void inicializarTipoMermaEmpresa(TipoMermaEmpresa tipomermaempresa) throws Exception {
		try {
				tipomermaempresa.setId(0L);	
					
				tipomermaempresa.setid_empresa(-1L);	
				tipomermaempresa.setnombre("");	
				tipomermaempresa.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoMermaEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMermaEmpresaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMermaEmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMermaEmpresaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoMermaEmpresa(String sTipo,Row row,Workbook workbook,TipoMermaEmpresa tipomermaempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomermaempresa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomermaempresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomermaempresa.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoMermaEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoMermaEmpresa() {
		return this.sFinalQueryTipoMermaEmpresa;
	}
	
	public void setsFinalQueryTipoMermaEmpresa(String sFinalQueryTipoMermaEmpresa) {
		this.sFinalQueryTipoMermaEmpresa= sFinalQueryTipoMermaEmpresa;
	}
	
	public Border resaltarSeleccionarTipoMermaEmpresa=null;
	
	public Border setResaltarSeleccionarTipoMermaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaEmpresaBeanSwingJInternalFrame tipomermaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipomermaempresaBeanSwingJInternalFrame.jTtoolBarTipoMermaEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoMermaEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoMermaEmpresa() {
		return this.resaltarSeleccionarTipoMermaEmpresa;
	}
	
	public void setResaltarSeleccionarTipoMermaEmpresa(Border borderResaltarSeleccionarTipoMermaEmpresa) {
		this.resaltarSeleccionarTipoMermaEmpresa= borderResaltarSeleccionarTipoMermaEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoMermaEmpresa=null;
	public Boolean mostraridTipoMermaEmpresa=true;
	public Boolean activaridTipoMermaEmpresa=true;

	public Border resaltarid_empresaTipoMermaEmpresa=null;
	public Boolean mostrarid_empresaTipoMermaEmpresa=true;
	public Boolean activarid_empresaTipoMermaEmpresa=true;
	public Boolean cargarid_empresaTipoMermaEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoMermaEmpresa=false;//ConEventDepend=true

	public Border resaltarnombreTipoMermaEmpresa=null;
	public Boolean mostrarnombreTipoMermaEmpresa=true;
	public Boolean activarnombreTipoMermaEmpresa=true;

	public Border resaltardescripcionTipoMermaEmpresa=null;
	public Boolean mostrardescripcionTipoMermaEmpresa=true;
	public Boolean activardescripcionTipoMermaEmpresa=true;

	
	

	public Border setResaltaridTipoMermaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaEmpresaBeanSwingJInternalFrame tipomermaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomermaempresaBeanSwingJInternalFrame.jTtoolBarTipoMermaEmpresa.setBorder(borderResaltar);
		
		this.resaltaridTipoMermaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoMermaEmpresa() {
		return this.resaltaridTipoMermaEmpresa;
	}

	public void setResaltaridTipoMermaEmpresa(Border borderResaltar) {
		this.resaltaridTipoMermaEmpresa= borderResaltar;
	}

	public Boolean getMostraridTipoMermaEmpresa() {
		return this.mostraridTipoMermaEmpresa;
	}

	public void setMostraridTipoMermaEmpresa(Boolean mostraridTipoMermaEmpresa) {
		this.mostraridTipoMermaEmpresa= mostraridTipoMermaEmpresa;
	}

	public Boolean getActivaridTipoMermaEmpresa() {
		return this.activaridTipoMermaEmpresa;
	}

	public void setActivaridTipoMermaEmpresa(Boolean activaridTipoMermaEmpresa) {
		this.activaridTipoMermaEmpresa= activaridTipoMermaEmpresa;
	}

	public Border setResaltarid_empresaTipoMermaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaEmpresaBeanSwingJInternalFrame tipomermaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomermaempresaBeanSwingJInternalFrame.jTtoolBarTipoMermaEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoMermaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoMermaEmpresa() {
		return this.resaltarid_empresaTipoMermaEmpresa;
	}

	public void setResaltarid_empresaTipoMermaEmpresa(Border borderResaltar) {
		this.resaltarid_empresaTipoMermaEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoMermaEmpresa() {
		return this.mostrarid_empresaTipoMermaEmpresa;
	}

	public void setMostrarid_empresaTipoMermaEmpresa(Boolean mostrarid_empresaTipoMermaEmpresa) {
		this.mostrarid_empresaTipoMermaEmpresa= mostrarid_empresaTipoMermaEmpresa;
	}

	public Boolean getActivarid_empresaTipoMermaEmpresa() {
		return this.activarid_empresaTipoMermaEmpresa;
	}

	public void setActivarid_empresaTipoMermaEmpresa(Boolean activarid_empresaTipoMermaEmpresa) {
		this.activarid_empresaTipoMermaEmpresa= activarid_empresaTipoMermaEmpresa;
	}

	public Boolean getCargarid_empresaTipoMermaEmpresa() {
		return this.cargarid_empresaTipoMermaEmpresa;
	}

	public void setCargarid_empresaTipoMermaEmpresa(Boolean cargarid_empresaTipoMermaEmpresa) {
		this.cargarid_empresaTipoMermaEmpresa= cargarid_empresaTipoMermaEmpresa;
	}

	public Border setResaltarnombreTipoMermaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaEmpresaBeanSwingJInternalFrame tipomermaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomermaempresaBeanSwingJInternalFrame.jTtoolBarTipoMermaEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreTipoMermaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoMermaEmpresa() {
		return this.resaltarnombreTipoMermaEmpresa;
	}

	public void setResaltarnombreTipoMermaEmpresa(Border borderResaltar) {
		this.resaltarnombreTipoMermaEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreTipoMermaEmpresa() {
		return this.mostrarnombreTipoMermaEmpresa;
	}

	public void setMostrarnombreTipoMermaEmpresa(Boolean mostrarnombreTipoMermaEmpresa) {
		this.mostrarnombreTipoMermaEmpresa= mostrarnombreTipoMermaEmpresa;
	}

	public Boolean getActivarnombreTipoMermaEmpresa() {
		return this.activarnombreTipoMermaEmpresa;
	}

	public void setActivarnombreTipoMermaEmpresa(Boolean activarnombreTipoMermaEmpresa) {
		this.activarnombreTipoMermaEmpresa= activarnombreTipoMermaEmpresa;
	}

	public Border setResaltardescripcionTipoMermaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaEmpresaBeanSwingJInternalFrame tipomermaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomermaempresaBeanSwingJInternalFrame.jTtoolBarTipoMermaEmpresa.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoMermaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoMermaEmpresa() {
		return this.resaltardescripcionTipoMermaEmpresa;
	}

	public void setResaltardescripcionTipoMermaEmpresa(Border borderResaltar) {
		this.resaltardescripcionTipoMermaEmpresa= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoMermaEmpresa() {
		return this.mostrardescripcionTipoMermaEmpresa;
	}

	public void setMostrardescripcionTipoMermaEmpresa(Boolean mostrardescripcionTipoMermaEmpresa) {
		this.mostrardescripcionTipoMermaEmpresa= mostrardescripcionTipoMermaEmpresa;
	}

	public Boolean getActivardescripcionTipoMermaEmpresa() {
		return this.activardescripcionTipoMermaEmpresa;
	}

	public void setActivardescripcionTipoMermaEmpresa(Boolean activardescripcionTipoMermaEmpresa) {
		this.activardescripcionTipoMermaEmpresa= activardescripcionTipoMermaEmpresa;
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
		
		
		this.setMostraridTipoMermaEmpresa(esInicial);
		this.setMostrarid_empresaTipoMermaEmpresa(esInicial);
		this.setMostrarnombreTipoMermaEmpresa(esInicial);
		this.setMostrardescripcionTipoMermaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.ID)) {
				this.setMostraridTipoMermaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoMermaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoMermaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoMermaEmpresa(esAsigna);
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
		
		
		this.setActivaridTipoMermaEmpresa(esInicial);
		this.setActivarid_empresaTipoMermaEmpresa(esInicial);
		this.setActivarnombreTipoMermaEmpresa(esInicial);
		this.setActivardescripcionTipoMermaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.ID)) {
				this.setActivaridTipoMermaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoMermaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoMermaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoMermaEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMermaEmpresaBeanSwingJInternalFrame tipomermaempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoMermaEmpresa(esInicial);
		this.setResaltarid_empresaTipoMermaEmpresa(esInicial);
		this.setResaltarnombreTipoMermaEmpresa(esInicial);
		this.setResaltardescripcionTipoMermaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.ID)) {
				this.setResaltaridTipoMermaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoMermaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoMermaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMermaEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoMermaEmpresa(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMermaEmpresaBeanSwingJInternalFrame tipomermaempresaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoMermaEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaTipoMermaEmpresa() {
		return this.mostrarFK_IdEmpresaTipoMermaEmpresa;
	}

	public void setMostrarFK_IdEmpresaTipoMermaEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoMermaEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoMermaEmpresa=true;

	public Boolean getActivarFK_IdEmpresaTipoMermaEmpresa() {
		return this.activarFK_IdEmpresaTipoMermaEmpresa;
	}

	public void setActivarFK_IdEmpresaTipoMermaEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoMermaEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoMermaEmpresa=null;

	public Border getResaltarFK_IdEmpresaTipoMermaEmpresa() {
		return this.resaltarFK_IdEmpresaTipoMermaEmpresa;
	}

	public void setResaltarFK_IdEmpresaTipoMermaEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoMermaEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoMermaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMermaEmpresaBeanSwingJInternalFrame tipomermaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoMermaEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}