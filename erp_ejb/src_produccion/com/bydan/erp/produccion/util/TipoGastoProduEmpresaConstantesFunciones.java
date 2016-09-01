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


import com.bydan.erp.produccion.util.TipoGastoProduEmpresaConstantesFunciones;
import com.bydan.erp.produccion.util.TipoGastoProduEmpresaParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoGastoProduEmpresaParameterGeneral;

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
final public class TipoGastoProduEmpresaConstantesFunciones extends TipoGastoProduEmpresaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoGastoProduEmpresa";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoGastoProduEmpresa"+TipoGastoProduEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoGastoProduEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoGastoProduEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"_"+TipoGastoProduEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoGastoProduEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"_"+TipoGastoProduEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"_"+TipoGastoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoGastoProduEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"_"+TipoGastoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGastoProduEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoGastoProduEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoGastoProduEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoGastoProduEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoGastoProduEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoGastoProduEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoGastoProduEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Gasto Produccion Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Gasto Produccion Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Gasto Produ Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoGastoProduEmpresa";
	public static final String OBJECTNAME="tipogastoproduempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="tipo_gasto_produ_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipogastoproduempresa from "+TipoGastoProduEmpresaConstantesFunciones.SPERSISTENCENAME+" tipogastoproduempresa";
	public static String QUERYSELECTNATIVE="select "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".id,"+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME+".descripcion from "+TipoGastoProduEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoProduEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoGastoProduEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoGastoProduEmpresaConstantesFuncionesAdditional tipogastoproduempresaConstantesFuncionesAdditional=null;
	
	public TipoGastoProduEmpresaConstantesFuncionesAdditional getTipoGastoProduEmpresaConstantesFuncionesAdditional() {
		return this.tipogastoproduempresaConstantesFuncionesAdditional;
	}
	
	public void setTipoGastoProduEmpresaConstantesFuncionesAdditional(TipoGastoProduEmpresaConstantesFuncionesAdditional tipogastoproduempresaConstantesFuncionesAdditional) {
		try {
			this.tipogastoproduempresaConstantesFuncionesAdditional=tipogastoproduempresaConstantesFuncionesAdditional;
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
	
	public static String getTipoGastoProduEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoGastoProduEmpresaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoGastoProduEmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoGastoProduEmpresaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoGastoProduEmpresaConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoGastoProduEmpresaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoGastoProduEmpresaDescripcion(TipoGastoProduEmpresa tipogastoproduempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipogastoproduempresa !=null/* && tipogastoproduempresa.getId()!=0*/) {
			sDescripcion=tipogastoproduempresa.getnombre();//tipogastoproduempresatipogastoproduempresa.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoGastoProduEmpresaDescripcionDetallado(TipoGastoProduEmpresa tipogastoproduempresa) {
		String sDescripcion="";
			
		sDescripcion+=TipoGastoProduEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=tipogastoproduempresa.getId().toString()+",";
		sDescripcion+=TipoGastoProduEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipogastoproduempresa.getVersionRow().toString()+",";
		sDescripcion+=TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipogastoproduempresa.getid_empresa().toString()+",";
		sDescripcion+=TipoGastoProduEmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipogastoproduempresa.getnombre()+",";
		sDescripcion+=TipoGastoProduEmpresaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipogastoproduempresa.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoGastoProduEmpresaDescripcion(TipoGastoProduEmpresa tipogastoproduempresa,String sValor) throws Exception {			
		if(tipogastoproduempresa !=null) {
			tipogastoproduempresa.setnombre(sValor);;//tipogastoproduempresatipogastoproduempresa.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoGastoProduEmpresa(TipoGastoProduEmpresa tipogastoproduempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipogastoproduempresa.setnombre(tipogastoproduempresa.getnombre().trim());
		tipogastoproduempresa.setdescripcion(tipogastoproduempresa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoGastoProduEmpresas(List<TipoGastoProduEmpresa> tipogastoproduempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoGastoProduEmpresa tipogastoproduempresa: tipogastoproduempresas) {
			tipogastoproduempresa.setnombre(tipogastoproduempresa.getnombre().trim());
			tipogastoproduempresa.setdescripcion(tipogastoproduempresa.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGastoProduEmpresa(TipoGastoProduEmpresa tipogastoproduempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipogastoproduempresa.getConCambioAuxiliar()) {
			tipogastoproduempresa.setIsDeleted(tipogastoproduempresa.getIsDeletedAuxiliar());	
			tipogastoproduempresa.setIsNew(tipogastoproduempresa.getIsNewAuxiliar());	
			tipogastoproduempresa.setIsChanged(tipogastoproduempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipogastoproduempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipogastoproduempresa.setIsDeletedAuxiliar(false);	
			tipogastoproduempresa.setIsNewAuxiliar(false);	
			tipogastoproduempresa.setIsChangedAuxiliar(false);
			
			tipogastoproduempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoGastoProduEmpresas(List<TipoGastoProduEmpresa> tipogastoproduempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoGastoProduEmpresa tipogastoproduempresa : tipogastoproduempresas) {
			if(conAsignarBase && tipogastoproduempresa.getConCambioAuxiliar()) {
				tipogastoproduempresa.setIsDeleted(tipogastoproduempresa.getIsDeletedAuxiliar());	
				tipogastoproduempresa.setIsNew(tipogastoproduempresa.getIsNewAuxiliar());	
				tipogastoproduempresa.setIsChanged(tipogastoproduempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipogastoproduempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipogastoproduempresa.setIsDeletedAuxiliar(false);	
				tipogastoproduempresa.setIsNewAuxiliar(false);	
				tipogastoproduempresa.setIsChangedAuxiliar(false);
				
				tipogastoproduempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoGastoProduEmpresa(TipoGastoProduEmpresa tipogastoproduempresa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoGastoProduEmpresas(List<TipoGastoProduEmpresa> tipogastoproduempresas,Boolean conEnteros) throws Exception  {
		
		for(TipoGastoProduEmpresa tipogastoproduempresa: tipogastoproduempresas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoGastoProduEmpresa(List<TipoGastoProduEmpresa> tipogastoproduempresas,TipoGastoProduEmpresa tipogastoproduempresaAux) throws Exception  {
		TipoGastoProduEmpresaConstantesFunciones.InicializarValoresTipoGastoProduEmpresa(tipogastoproduempresaAux,true);
		
		for(TipoGastoProduEmpresa tipogastoproduempresa: tipogastoproduempresas) {
			if(tipogastoproduempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGastoProduEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoGastoProduEmpresaConstantesFunciones.getArrayColumnasGlobalesTipoGastoProduEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoGastoProduEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoGastoProduEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoGastoProduEmpresa> tipogastoproduempresas,TipoGastoProduEmpresa tipogastoproduempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoGastoProduEmpresa tipogastoproduempresaAux: tipogastoproduempresas) {
			if(tipogastoproduempresaAux!=null && tipogastoproduempresa!=null) {
				if((tipogastoproduempresaAux.getId()==null && tipogastoproduempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipogastoproduempresaAux.getId()!=null && tipogastoproduempresa.getId()!=null){
					if(tipogastoproduempresaAux.getId().equals(tipogastoproduempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoGastoProduEmpresa(List<TipoGastoProduEmpresa> tipogastoproduempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoGastoProduEmpresa tipogastoproduempresa: tipogastoproduempresas) {			
			if(tipogastoproduempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoGastoProduEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoGastoProduEmpresaConstantesFunciones.LABEL_ID, TipoGastoProduEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoProduEmpresaConstantesFunciones.LABEL_VERSIONROW, TipoGastoProduEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoProduEmpresaConstantesFunciones.LABEL_IDEMPRESA, TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoProduEmpresaConstantesFunciones.LABEL_NOMBRE, TipoGastoProduEmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoGastoProduEmpresaConstantesFunciones.LABEL_DESCRIPCION, TipoGastoProduEmpresaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoGastoProduEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoGastoProduEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoProduEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoProduEmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoGastoProduEmpresaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGastoProduEmpresa() throws Exception  {
		return TipoGastoProduEmpresaConstantesFunciones.getTiposSeleccionarTipoGastoProduEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGastoProduEmpresa(Boolean conFk) throws Exception  {
		return TipoGastoProduEmpresaConstantesFunciones.getTiposSeleccionarTipoGastoProduEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoGastoProduEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoProduEmpresaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoGastoProduEmpresaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoProduEmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoGastoProduEmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoGastoProduEmpresaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoGastoProduEmpresaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoGastoProduEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(TipoGastoProduEmpresa tipogastoproduempresaAux) throws Exception {
		
			tipogastoproduempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipogastoproduempresaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoGastoProduEmpresa(List<TipoGastoProduEmpresa> tipogastoproduempresasTemp) throws Exception {
		for(TipoGastoProduEmpresa tipogastoproduempresaAux:tipogastoproduempresasTemp) {
			
			tipogastoproduempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipogastoproduempresaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGastoProduEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoGastoProduEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGastoProduEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGastoProduEmpresaConstantesFunciones.getClassesRelationshipsOfTipoGastoProduEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGastoProduEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoOrdenDetaProduGasto.class));
				classes.add(new Classe(ProductoProduGasto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProduGasto.class)) {
						classes.add(new Classe(ProductoOrdenDetaProduGasto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProduGasto.class)) {
						classes.add(new Classe(ProductoProduGasto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGastoProduEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoGastoProduEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoGastoProduEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoGastoProduEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoOrdenDetaProduGasto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduGasto.class)); continue;
					}

					if(ProductoProduGasto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduGasto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoOrdenDetaProduGasto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduGasto.class)); continue;
					}

					if(ProductoProduGasto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduGasto.class)); continue;
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
	public static void actualizarLista(TipoGastoProduEmpresa tipogastoproduempresa,List<TipoGastoProduEmpresa> tipogastoproduempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoGastoProduEmpresa tipogastoproduempresaEncontrado=null;
			
			for(TipoGastoProduEmpresa tipogastoproduempresaLocal:tipogastoproduempresas) {
				if(tipogastoproduempresaLocal.getId().equals(tipogastoproduempresa.getId())) {
					tipogastoproduempresaEncontrado=tipogastoproduempresaLocal;
					
					tipogastoproduempresaLocal.setIsChanged(tipogastoproduempresa.getIsChanged());
					tipogastoproduempresaLocal.setIsNew(tipogastoproduempresa.getIsNew());
					tipogastoproduempresaLocal.setIsDeleted(tipogastoproduempresa.getIsDeleted());
					
					tipogastoproduempresaLocal.setGeneralEntityOriginal(tipogastoproduempresa.getGeneralEntityOriginal());
					
					tipogastoproduempresaLocal.setId(tipogastoproduempresa.getId());	
					tipogastoproduempresaLocal.setVersionRow(tipogastoproduempresa.getVersionRow());	
					tipogastoproduempresaLocal.setid_empresa(tipogastoproduempresa.getid_empresa());	
					tipogastoproduempresaLocal.setnombre(tipogastoproduempresa.getnombre());	
					tipogastoproduempresaLocal.setdescripcion(tipogastoproduempresa.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipogastoproduempresa.getIsDeleted()) {
				if(!existe) {
					tipogastoproduempresas.add(tipogastoproduempresa);
				}
			} else {
				if(tipogastoproduempresaEncontrado!=null && permiteQuitar)  {
					tipogastoproduempresas.remove(tipogastoproduempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoGastoProduEmpresa tipogastoproduempresa,List<TipoGastoProduEmpresa> tipogastoproduempresas) throws Exception {
		try	{			
			for(TipoGastoProduEmpresa tipogastoproduempresaLocal:tipogastoproduempresas) {
				if(tipogastoproduempresaLocal.getId().equals(tipogastoproduempresa.getId())) {
					tipogastoproduempresaLocal.setIsSelected(tipogastoproduempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoGastoProduEmpresa(List<TipoGastoProduEmpresa> tipogastoproduempresasAux) throws Exception {
		//this.tipogastoproduempresasAux=tipogastoproduempresasAux;
		
		for(TipoGastoProduEmpresa tipogastoproduempresaAux:tipogastoproduempresasAux) {
			if(tipogastoproduempresaAux.getIsChanged()) {
				tipogastoproduempresaAux.setIsChanged(false);
			}		
			
			if(tipogastoproduempresaAux.getIsNew()) {
				tipogastoproduempresaAux.setIsNew(false);
			}	
			
			if(tipogastoproduempresaAux.getIsDeleted()) {
				tipogastoproduempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoGastoProduEmpresa(TipoGastoProduEmpresa tipogastoproduempresaAux) throws Exception {
		//this.tipogastoproduempresaAux=tipogastoproduempresaAux;
		
			if(tipogastoproduempresaAux.getIsChanged()) {
				tipogastoproduempresaAux.setIsChanged(false);
			}		
			
			if(tipogastoproduempresaAux.getIsNew()) {
				tipogastoproduempresaAux.setIsNew(false);
			}	
			
			if(tipogastoproduempresaAux.getIsDeleted()) {
				tipogastoproduempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoGastoProduEmpresa tipogastoproduempresaAsignar,TipoGastoProduEmpresa tipogastoproduempresa) throws Exception {
		tipogastoproduempresaAsignar.setId(tipogastoproduempresa.getId());	
		tipogastoproduempresaAsignar.setVersionRow(tipogastoproduempresa.getVersionRow());	
		tipogastoproduempresaAsignar.setid_empresa(tipogastoproduempresa.getid_empresa());
		tipogastoproduempresaAsignar.setempresa_descripcion(tipogastoproduempresa.getempresa_descripcion());	
		tipogastoproduempresaAsignar.setnombre(tipogastoproduempresa.getnombre());	
		tipogastoproduempresaAsignar.setdescripcion(tipogastoproduempresa.getdescripcion());	
	}
	
	public static void inicializarTipoGastoProduEmpresa(TipoGastoProduEmpresa tipogastoproduempresa) throws Exception {
		try {
				tipogastoproduempresa.setId(0L);	
					
				tipogastoproduempresa.setid_empresa(-1L);	
				tipogastoproduempresa.setnombre("");	
				tipogastoproduempresa.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoGastoProduEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoProduEmpresaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoProduEmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoGastoProduEmpresaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoGastoProduEmpresa(String sTipo,Row row,Workbook workbook,TipoGastoProduEmpresa tipogastoproduempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoproduempresa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoproduempresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipogastoproduempresa.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoGastoProduEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoGastoProduEmpresa() {
		return this.sFinalQueryTipoGastoProduEmpresa;
	}
	
	public void setsFinalQueryTipoGastoProduEmpresa(String sFinalQueryTipoGastoProduEmpresa) {
		this.sFinalQueryTipoGastoProduEmpresa= sFinalQueryTipoGastoProduEmpresa;
	}
	
	public Border resaltarSeleccionarTipoGastoProduEmpresa=null;
	
	public Border setResaltarSeleccionarTipoGastoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduEmpresaBeanSwingJInternalFrame tipogastoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipogastoproduempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoProduEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoGastoProduEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoGastoProduEmpresa() {
		return this.resaltarSeleccionarTipoGastoProduEmpresa;
	}
	
	public void setResaltarSeleccionarTipoGastoProduEmpresa(Border borderResaltarSeleccionarTipoGastoProduEmpresa) {
		this.resaltarSeleccionarTipoGastoProduEmpresa= borderResaltarSeleccionarTipoGastoProduEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoGastoProduEmpresa=null;
	public Boolean mostraridTipoGastoProduEmpresa=true;
	public Boolean activaridTipoGastoProduEmpresa=true;

	public Border resaltarid_empresaTipoGastoProduEmpresa=null;
	public Boolean mostrarid_empresaTipoGastoProduEmpresa=true;
	public Boolean activarid_empresaTipoGastoProduEmpresa=true;
	public Boolean cargarid_empresaTipoGastoProduEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoGastoProduEmpresa=false;//ConEventDepend=true

	public Border resaltarnombreTipoGastoProduEmpresa=null;
	public Boolean mostrarnombreTipoGastoProduEmpresa=true;
	public Boolean activarnombreTipoGastoProduEmpresa=true;

	public Border resaltardescripcionTipoGastoProduEmpresa=null;
	public Boolean mostrardescripcionTipoGastoProduEmpresa=true;
	public Boolean activardescripcionTipoGastoProduEmpresa=true;

	
	

	public Border setResaltaridTipoGastoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduEmpresaBeanSwingJInternalFrame tipogastoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoproduempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoProduEmpresa.setBorder(borderResaltar);
		
		this.resaltaridTipoGastoProduEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoGastoProduEmpresa() {
		return this.resaltaridTipoGastoProduEmpresa;
	}

	public void setResaltaridTipoGastoProduEmpresa(Border borderResaltar) {
		this.resaltaridTipoGastoProduEmpresa= borderResaltar;
	}

	public Boolean getMostraridTipoGastoProduEmpresa() {
		return this.mostraridTipoGastoProduEmpresa;
	}

	public void setMostraridTipoGastoProduEmpresa(Boolean mostraridTipoGastoProduEmpresa) {
		this.mostraridTipoGastoProduEmpresa= mostraridTipoGastoProduEmpresa;
	}

	public Boolean getActivaridTipoGastoProduEmpresa() {
		return this.activaridTipoGastoProduEmpresa;
	}

	public void setActivaridTipoGastoProduEmpresa(Boolean activaridTipoGastoProduEmpresa) {
		this.activaridTipoGastoProduEmpresa= activaridTipoGastoProduEmpresa;
	}

	public Border setResaltarid_empresaTipoGastoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduEmpresaBeanSwingJInternalFrame tipogastoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoproduempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoProduEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoGastoProduEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoGastoProduEmpresa() {
		return this.resaltarid_empresaTipoGastoProduEmpresa;
	}

	public void setResaltarid_empresaTipoGastoProduEmpresa(Border borderResaltar) {
		this.resaltarid_empresaTipoGastoProduEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoGastoProduEmpresa() {
		return this.mostrarid_empresaTipoGastoProduEmpresa;
	}

	public void setMostrarid_empresaTipoGastoProduEmpresa(Boolean mostrarid_empresaTipoGastoProduEmpresa) {
		this.mostrarid_empresaTipoGastoProduEmpresa= mostrarid_empresaTipoGastoProduEmpresa;
	}

	public Boolean getActivarid_empresaTipoGastoProduEmpresa() {
		return this.activarid_empresaTipoGastoProduEmpresa;
	}

	public void setActivarid_empresaTipoGastoProduEmpresa(Boolean activarid_empresaTipoGastoProduEmpresa) {
		this.activarid_empresaTipoGastoProduEmpresa= activarid_empresaTipoGastoProduEmpresa;
	}

	public Boolean getCargarid_empresaTipoGastoProduEmpresa() {
		return this.cargarid_empresaTipoGastoProduEmpresa;
	}

	public void setCargarid_empresaTipoGastoProduEmpresa(Boolean cargarid_empresaTipoGastoProduEmpresa) {
		this.cargarid_empresaTipoGastoProduEmpresa= cargarid_empresaTipoGastoProduEmpresa;
	}

	public Border setResaltarnombreTipoGastoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduEmpresaBeanSwingJInternalFrame tipogastoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoproduempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoProduEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreTipoGastoProduEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoGastoProduEmpresa() {
		return this.resaltarnombreTipoGastoProduEmpresa;
	}

	public void setResaltarnombreTipoGastoProduEmpresa(Border borderResaltar) {
		this.resaltarnombreTipoGastoProduEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreTipoGastoProduEmpresa() {
		return this.mostrarnombreTipoGastoProduEmpresa;
	}

	public void setMostrarnombreTipoGastoProduEmpresa(Boolean mostrarnombreTipoGastoProduEmpresa) {
		this.mostrarnombreTipoGastoProduEmpresa= mostrarnombreTipoGastoProduEmpresa;
	}

	public Boolean getActivarnombreTipoGastoProduEmpresa() {
		return this.activarnombreTipoGastoProduEmpresa;
	}

	public void setActivarnombreTipoGastoProduEmpresa(Boolean activarnombreTipoGastoProduEmpresa) {
		this.activarnombreTipoGastoProduEmpresa= activarnombreTipoGastoProduEmpresa;
	}

	public Border setResaltardescripcionTipoGastoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduEmpresaBeanSwingJInternalFrame tipogastoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipogastoproduempresaBeanSwingJInternalFrame.jTtoolBarTipoGastoProduEmpresa.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoGastoProduEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoGastoProduEmpresa() {
		return this.resaltardescripcionTipoGastoProduEmpresa;
	}

	public void setResaltardescripcionTipoGastoProduEmpresa(Border borderResaltar) {
		this.resaltardescripcionTipoGastoProduEmpresa= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoGastoProduEmpresa() {
		return this.mostrardescripcionTipoGastoProduEmpresa;
	}

	public void setMostrardescripcionTipoGastoProduEmpresa(Boolean mostrardescripcionTipoGastoProduEmpresa) {
		this.mostrardescripcionTipoGastoProduEmpresa= mostrardescripcionTipoGastoProduEmpresa;
	}

	public Boolean getActivardescripcionTipoGastoProduEmpresa() {
		return this.activardescripcionTipoGastoProduEmpresa;
	}

	public void setActivardescripcionTipoGastoProduEmpresa(Boolean activardescripcionTipoGastoProduEmpresa) {
		this.activardescripcionTipoGastoProduEmpresa= activardescripcionTipoGastoProduEmpresa;
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
		
		
		this.setMostraridTipoGastoProduEmpresa(esInicial);
		this.setMostrarid_empresaTipoGastoProduEmpresa(esInicial);
		this.setMostrarnombreTipoGastoProduEmpresa(esInicial);
		this.setMostrardescripcionTipoGastoProduEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.ID)) {
				this.setMostraridTipoGastoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoGastoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoGastoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoGastoProduEmpresa(esAsigna);
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
		
		
		this.setActivaridTipoGastoProduEmpresa(esInicial);
		this.setActivarid_empresaTipoGastoProduEmpresa(esInicial);
		this.setActivarnombreTipoGastoProduEmpresa(esInicial);
		this.setActivardescripcionTipoGastoProduEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.ID)) {
				this.setActivaridTipoGastoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoGastoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoGastoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoGastoProduEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGastoProduEmpresaBeanSwingJInternalFrame tipogastoproduempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoGastoProduEmpresa(esInicial);
		this.setResaltarid_empresaTipoGastoProduEmpresa(esInicial);
		this.setResaltarnombreTipoGastoProduEmpresa(esInicial);
		this.setResaltardescripcionTipoGastoProduEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.ID)) {
				this.setResaltaridTipoGastoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoGastoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoGastoProduEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoGastoProduEmpresaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoGastoProduEmpresa(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoGastoProduEmpresaBeanSwingJInternalFrame tipogastoproduempresaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoGastoProduEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaTipoGastoProduEmpresa() {
		return this.mostrarFK_IdEmpresaTipoGastoProduEmpresa;
	}

	public void setMostrarFK_IdEmpresaTipoGastoProduEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoGastoProduEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoGastoProduEmpresa=true;

	public Boolean getActivarFK_IdEmpresaTipoGastoProduEmpresa() {
		return this.activarFK_IdEmpresaTipoGastoProduEmpresa;
	}

	public void setActivarFK_IdEmpresaTipoGastoProduEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoGastoProduEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoGastoProduEmpresa=null;

	public Border getResaltarFK_IdEmpresaTipoGastoProduEmpresa() {
		return this.resaltarFK_IdEmpresaTipoGastoProduEmpresa;
	}

	public void setResaltarFK_IdEmpresaTipoGastoProduEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoGastoProduEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoGastoProduEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoGastoProduEmpresaBeanSwingJInternalFrame tipogastoproduempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoGastoProduEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}