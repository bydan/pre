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


import com.bydan.erp.produccion.util.TipoProcesoEmpresaProduConstantesFunciones;
import com.bydan.erp.produccion.util.TipoProcesoEmpresaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoProcesoEmpresaProduParameterGeneral;

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
final public class TipoProcesoEmpresaProduConstantesFunciones extends TipoProcesoEmpresaProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoProcesoEmpresaProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoProcesoEmpresaProdu"+TipoProcesoEmpresaProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoProcesoEmpresaProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoProcesoEmpresaProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoProcesoEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoProcesoEmpresaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoProcesoEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoProcesoEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoProcesoEmpresaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoProcesoEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoProcesoEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoProcesoEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoProcesoEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoProcesoEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProcesoEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoProcesoEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoProcesoEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoProcesoEmpresaProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoProcesoEmpresaProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoProcesoEmpresaProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoProcesoEmpresaProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Proceso Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Proceso Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Proceso Empresa Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoProcesoEmpresaProdu";
	public static final String OBJECTNAME="tipoprocesoempresaprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="tipo_proceso_empresa_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoprocesoempresaprodu from "+TipoProcesoEmpresaProduConstantesFunciones.SPERSISTENCENAME+" tipoprocesoempresaprodu";
	public static String QUERYSELECTNATIVE="select "+TipoProcesoEmpresaProduConstantesFunciones.SCHEMA+"."+TipoProcesoEmpresaProduConstantesFunciones.TABLENAME+".id,"+TipoProcesoEmpresaProduConstantesFunciones.SCHEMA+"."+TipoProcesoEmpresaProduConstantesFunciones.TABLENAME+".version_row,"+TipoProcesoEmpresaProduConstantesFunciones.SCHEMA+"."+TipoProcesoEmpresaProduConstantesFunciones.TABLENAME+".id_empresa,"+TipoProcesoEmpresaProduConstantesFunciones.SCHEMA+"."+TipoProcesoEmpresaProduConstantesFunciones.TABLENAME+".nombre,"+TipoProcesoEmpresaProduConstantesFunciones.SCHEMA+"."+TipoProcesoEmpresaProduConstantesFunciones.TABLENAME+".descripcion from "+TipoProcesoEmpresaProduConstantesFunciones.SCHEMA+"."+TipoProcesoEmpresaProduConstantesFunciones.TABLENAME;//+" as "+TipoProcesoEmpresaProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoProcesoEmpresaProduConstantesFuncionesAdditional tipoprocesoempresaproduConstantesFuncionesAdditional=null;
	
	public TipoProcesoEmpresaProduConstantesFuncionesAdditional getTipoProcesoEmpresaProduConstantesFuncionesAdditional() {
		return this.tipoprocesoempresaproduConstantesFuncionesAdditional;
	}
	
	public void setTipoProcesoEmpresaProduConstantesFuncionesAdditional(TipoProcesoEmpresaProduConstantesFuncionesAdditional tipoprocesoempresaproduConstantesFuncionesAdditional) {
		try {
			this.tipoprocesoempresaproduConstantesFuncionesAdditional=tipoprocesoempresaproduConstantesFuncionesAdditional;
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
	
	public static String getTipoProcesoEmpresaProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoProcesoEmpresaProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoProcesoEmpresaProduConstantesFunciones.NOMBRE)) {sLabelColumna=TipoProcesoEmpresaProduConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoProcesoEmpresaProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoProcesoEmpresaProduConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoProcesoEmpresaProduDescripcion(TipoProcesoEmpresaProdu tipoprocesoempresaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoprocesoempresaprodu !=null/* && tipoprocesoempresaprodu.getId()!=0*/) {
			sDescripcion=tipoprocesoempresaprodu.getnombre();//tipoprocesoempresaprodutipoprocesoempresaprodu.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoProcesoEmpresaProduDescripcionDetallado(TipoProcesoEmpresaProdu tipoprocesoempresaprodu) {
		String sDescripcion="";
			
		sDescripcion+=TipoProcesoEmpresaProduConstantesFunciones.ID+"=";
		sDescripcion+=tipoprocesoempresaprodu.getId().toString()+",";
		sDescripcion+=TipoProcesoEmpresaProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoprocesoempresaprodu.getVersionRow().toString()+",";
		sDescripcion+=TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoprocesoempresaprodu.getid_empresa().toString()+",";
		sDescripcion+=TipoProcesoEmpresaProduConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoprocesoempresaprodu.getnombre()+",";
		sDescripcion+=TipoProcesoEmpresaProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipoprocesoempresaprodu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoProcesoEmpresaProduDescripcion(TipoProcesoEmpresaProdu tipoprocesoempresaprodu,String sValor) throws Exception {			
		if(tipoprocesoempresaprodu !=null) {
			tipoprocesoempresaprodu.setnombre(sValor);;//tipoprocesoempresaprodutipoprocesoempresaprodu.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoProcesoEmpresaProdu(TipoProcesoEmpresaProdu tipoprocesoempresaprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprocesoempresaprodu.setnombre(tipoprocesoempresaprodu.getnombre().trim());
		tipoprocesoempresaprodu.setdescripcion(tipoprocesoempresaprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoProcesoEmpresaProdus(List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu: tipoprocesoempresaprodus) {
			tipoprocesoempresaprodu.setnombre(tipoprocesoempresaprodu.getnombre().trim());
			tipoprocesoempresaprodu.setdescripcion(tipoprocesoempresaprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProcesoEmpresaProdu(TipoProcesoEmpresaProdu tipoprocesoempresaprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoprocesoempresaprodu.getConCambioAuxiliar()) {
			tipoprocesoempresaprodu.setIsDeleted(tipoprocesoempresaprodu.getIsDeletedAuxiliar());	
			tipoprocesoempresaprodu.setIsNew(tipoprocesoempresaprodu.getIsNewAuxiliar());	
			tipoprocesoempresaprodu.setIsChanged(tipoprocesoempresaprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoprocesoempresaprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoprocesoempresaprodu.setIsDeletedAuxiliar(false);	
			tipoprocesoempresaprodu.setIsNewAuxiliar(false);	
			tipoprocesoempresaprodu.setIsChangedAuxiliar(false);
			
			tipoprocesoempresaprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoProcesoEmpresaProdus(List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu : tipoprocesoempresaprodus) {
			if(conAsignarBase && tipoprocesoempresaprodu.getConCambioAuxiliar()) {
				tipoprocesoempresaprodu.setIsDeleted(tipoprocesoempresaprodu.getIsDeletedAuxiliar());	
				tipoprocesoempresaprodu.setIsNew(tipoprocesoempresaprodu.getIsNewAuxiliar());	
				tipoprocesoempresaprodu.setIsChanged(tipoprocesoempresaprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoprocesoempresaprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoprocesoempresaprodu.setIsDeletedAuxiliar(false);	
				tipoprocesoempresaprodu.setIsNewAuxiliar(false);	
				tipoprocesoempresaprodu.setIsChangedAuxiliar(false);
				
				tipoprocesoempresaprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoProcesoEmpresaProdu(TipoProcesoEmpresaProdu tipoprocesoempresaprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoProcesoEmpresaProdus(List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus,Boolean conEnteros) throws Exception  {
		
		for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu: tipoprocesoempresaprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoProcesoEmpresaProdu(List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus,TipoProcesoEmpresaProdu tipoprocesoempresaproduAux) throws Exception  {
		TipoProcesoEmpresaProduConstantesFunciones.InicializarValoresTipoProcesoEmpresaProdu(tipoprocesoempresaproduAux,true);
		
		for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu: tipoprocesoempresaprodus) {
			if(tipoprocesoempresaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProcesoEmpresaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoProcesoEmpresaProduConstantesFunciones.getArrayColumnasGlobalesTipoProcesoEmpresaProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProcesoEmpresaProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoProcesoEmpresaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus,TipoProcesoEmpresaProdu tipoprocesoempresaprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoProcesoEmpresaProdu tipoprocesoempresaproduAux: tipoprocesoempresaprodus) {
			if(tipoprocesoempresaproduAux!=null && tipoprocesoempresaprodu!=null) {
				if((tipoprocesoempresaproduAux.getId()==null && tipoprocesoempresaprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoprocesoempresaproduAux.getId()!=null && tipoprocesoempresaprodu.getId()!=null){
					if(tipoprocesoempresaproduAux.getId().equals(tipoprocesoempresaprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoProcesoEmpresaProdu(List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu: tipoprocesoempresaprodus) {			
			if(tipoprocesoempresaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoProcesoEmpresaProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoProcesoEmpresaProduConstantesFunciones.LABEL_ID, TipoProcesoEmpresaProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProcesoEmpresaProduConstantesFunciones.LABEL_VERSIONROW, TipoProcesoEmpresaProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProcesoEmpresaProduConstantesFunciones.LABEL_IDEMPRESA, TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProcesoEmpresaProduConstantesFunciones.LABEL_NOMBRE, TipoProcesoEmpresaProduConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoProcesoEmpresaProduConstantesFunciones.LABEL_DESCRIPCION, TipoProcesoEmpresaProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoProcesoEmpresaProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoEmpresaProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoEmpresaProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoEmpresaProduConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoProcesoEmpresaProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProcesoEmpresaProdu() throws Exception  {
		return TipoProcesoEmpresaProduConstantesFunciones.getTiposSeleccionarTipoProcesoEmpresaProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProcesoEmpresaProdu(Boolean conFk) throws Exception  {
		return TipoProcesoEmpresaProduConstantesFunciones.getTiposSeleccionarTipoProcesoEmpresaProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoProcesoEmpresaProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProcesoEmpresaProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoProcesoEmpresaProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProcesoEmpresaProduConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoProcesoEmpresaProduConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoProcesoEmpresaProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoProcesoEmpresaProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoProcesoEmpresaProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(TipoProcesoEmpresaProdu tipoprocesoempresaproduAux) throws Exception {
		
			tipoprocesoempresaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoprocesoempresaproduAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusTemp) throws Exception {
		for(TipoProcesoEmpresaProdu tipoprocesoempresaproduAux:tipoprocesoempresaprodusTemp) {
			
			tipoprocesoempresaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoprocesoempresaproduAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProcesoEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoProcesoEmpresaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProcesoEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProcesoEmpresaProduConstantesFunciones.getClassesRelationshipsOfTipoProcesoEmpresaProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProcesoEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoProduMano.class));
				classes.add(new Classe(ProductoOrdenDetaProduMano.class));
				classes.add(new Classe(ProductoOrdenDetaProduMaquina.class));
				classes.add(new Classe(ProductoProduMaquina.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProduMano.class)) {
						classes.add(new Classe(ProductoProduMano.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProduMano.class)) {
						classes.add(new Classe(ProductoOrdenDetaProduMano.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProduMaquina.class)) {
						classes.add(new Classe(ProductoProduMaquina.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProcesoEmpresaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoProcesoEmpresaProduConstantesFunciones.getClassesRelationshipsFromStringsOfTipoProcesoEmpresaProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoProcesoEmpresaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMano.class)); continue;
					}

					if(ProductoOrdenDetaProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMano.class)); continue;
					}

					if(ProductoOrdenDetaProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); continue;
					}

					if(ProductoProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMaquina.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMano.class)); continue;
					}

					if(ProductoOrdenDetaProduMano.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMano.class)); continue;
					}

					if(ProductoOrdenDetaProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); continue;
					}

					if(ProductoProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMaquina.class)); continue;
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
	public static void actualizarLista(TipoProcesoEmpresaProdu tipoprocesoempresaprodu,List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoProcesoEmpresaProdu tipoprocesoempresaproduEncontrado=null;
			
			for(TipoProcesoEmpresaProdu tipoprocesoempresaproduLocal:tipoprocesoempresaprodus) {
				if(tipoprocesoempresaproduLocal.getId().equals(tipoprocesoempresaprodu.getId())) {
					tipoprocesoempresaproduEncontrado=tipoprocesoempresaproduLocal;
					
					tipoprocesoempresaproduLocal.setIsChanged(tipoprocesoempresaprodu.getIsChanged());
					tipoprocesoempresaproduLocal.setIsNew(tipoprocesoempresaprodu.getIsNew());
					tipoprocesoempresaproduLocal.setIsDeleted(tipoprocesoempresaprodu.getIsDeleted());
					
					tipoprocesoempresaproduLocal.setGeneralEntityOriginal(tipoprocesoempresaprodu.getGeneralEntityOriginal());
					
					tipoprocesoempresaproduLocal.setId(tipoprocesoempresaprodu.getId());	
					tipoprocesoempresaproduLocal.setVersionRow(tipoprocesoempresaprodu.getVersionRow());	
					tipoprocesoempresaproduLocal.setid_empresa(tipoprocesoempresaprodu.getid_empresa());	
					tipoprocesoempresaproduLocal.setnombre(tipoprocesoempresaprodu.getnombre());	
					tipoprocesoempresaproduLocal.setdescripcion(tipoprocesoempresaprodu.getdescripcion());	
					
					
					tipoprocesoempresaproduLocal.setProductoProduManos(tipoprocesoempresaprodu.getProductoProduManos());
					tipoprocesoempresaproduLocal.setProductoOrdenDetaProduManos(tipoprocesoempresaprodu.getProductoOrdenDetaProduManos());
					tipoprocesoempresaproduLocal.setProductoOrdenDetaProduMaquinas(tipoprocesoempresaprodu.getProductoOrdenDetaProduMaquinas());
					tipoprocesoempresaproduLocal.setProductoProduMaquinas(tipoprocesoempresaprodu.getProductoProduMaquinas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoprocesoempresaprodu.getIsDeleted()) {
				if(!existe) {
					tipoprocesoempresaprodus.add(tipoprocesoempresaprodu);
				}
			} else {
				if(tipoprocesoempresaproduEncontrado!=null && permiteQuitar)  {
					tipoprocesoempresaprodus.remove(tipoprocesoempresaproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoProcesoEmpresaProdu tipoprocesoempresaprodu,List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus) throws Exception {
		try	{			
			for(TipoProcesoEmpresaProdu tipoprocesoempresaproduLocal:tipoprocesoempresaprodus) {
				if(tipoprocesoempresaproduLocal.getId().equals(tipoprocesoempresaprodu.getId())) {
					tipoprocesoempresaproduLocal.setIsSelected(tipoprocesoempresaprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoProcesoEmpresaProdu(List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusAux) throws Exception {
		//this.tipoprocesoempresaprodusAux=tipoprocesoempresaprodusAux;
		
		for(TipoProcesoEmpresaProdu tipoprocesoempresaproduAux:tipoprocesoempresaprodusAux) {
			if(tipoprocesoempresaproduAux.getIsChanged()) {
				tipoprocesoempresaproduAux.setIsChanged(false);
			}		
			
			if(tipoprocesoempresaproduAux.getIsNew()) {
				tipoprocesoempresaproduAux.setIsNew(false);
			}	
			
			if(tipoprocesoempresaproduAux.getIsDeleted()) {
				tipoprocesoempresaproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoProcesoEmpresaProdu(TipoProcesoEmpresaProdu tipoprocesoempresaproduAux) throws Exception {
		//this.tipoprocesoempresaproduAux=tipoprocesoempresaproduAux;
		
			if(tipoprocesoempresaproduAux.getIsChanged()) {
				tipoprocesoempresaproduAux.setIsChanged(false);
			}		
			
			if(tipoprocesoempresaproduAux.getIsNew()) {
				tipoprocesoempresaproduAux.setIsNew(false);
			}	
			
			if(tipoprocesoempresaproduAux.getIsDeleted()) {
				tipoprocesoempresaproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoProcesoEmpresaProdu tipoprocesoempresaproduAsignar,TipoProcesoEmpresaProdu tipoprocesoempresaprodu) throws Exception {
		tipoprocesoempresaproduAsignar.setId(tipoprocesoempresaprodu.getId());	
		tipoprocesoempresaproduAsignar.setVersionRow(tipoprocesoempresaprodu.getVersionRow());	
		tipoprocesoempresaproduAsignar.setid_empresa(tipoprocesoempresaprodu.getid_empresa());
		tipoprocesoempresaproduAsignar.setempresa_descripcion(tipoprocesoempresaprodu.getempresa_descripcion());	
		tipoprocesoempresaproduAsignar.setnombre(tipoprocesoempresaprodu.getnombre());	
		tipoprocesoempresaproduAsignar.setdescripcion(tipoprocesoempresaprodu.getdescripcion());	
	}
	
	public static void inicializarTipoProcesoEmpresaProdu(TipoProcesoEmpresaProdu tipoprocesoempresaprodu) throws Exception {
		try {
				tipoprocesoempresaprodu.setId(0L);	
					
				tipoprocesoempresaprodu.setid_empresa(-1L);	
				tipoprocesoempresaprodu.setnombre("");	
				tipoprocesoempresaprodu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoProcesoEmpresaProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProcesoEmpresaProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProcesoEmpresaProduConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoProcesoEmpresaProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoProcesoEmpresaProdu(String sTipo,Row row,Workbook workbook,TipoProcesoEmpresaProdu tipoprocesoempresaprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprocesoempresaprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprocesoempresaprodu.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoprocesoempresaprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoProcesoEmpresaProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoProcesoEmpresaProdu() {
		return this.sFinalQueryTipoProcesoEmpresaProdu;
	}
	
	public void setsFinalQueryTipoProcesoEmpresaProdu(String sFinalQueryTipoProcesoEmpresaProdu) {
		this.sFinalQueryTipoProcesoEmpresaProdu= sFinalQueryTipoProcesoEmpresaProdu;
	}
	
	public Border resaltarSeleccionarTipoProcesoEmpresaProdu=null;
	
	public Border setResaltarSeleccionarTipoProcesoEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoprocesoempresaproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoProcesoEmpresaProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoProcesoEmpresaProdu() {
		return this.resaltarSeleccionarTipoProcesoEmpresaProdu;
	}
	
	public void setResaltarSeleccionarTipoProcesoEmpresaProdu(Border borderResaltarSeleccionarTipoProcesoEmpresaProdu) {
		this.resaltarSeleccionarTipoProcesoEmpresaProdu= borderResaltarSeleccionarTipoProcesoEmpresaProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoProcesoEmpresaProdu=null;
	public Boolean mostraridTipoProcesoEmpresaProdu=true;
	public Boolean activaridTipoProcesoEmpresaProdu=true;

	public Border resaltarid_empresaTipoProcesoEmpresaProdu=null;
	public Boolean mostrarid_empresaTipoProcesoEmpresaProdu=true;
	public Boolean activarid_empresaTipoProcesoEmpresaProdu=true;
	public Boolean cargarid_empresaTipoProcesoEmpresaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoProcesoEmpresaProdu=false;//ConEventDepend=true

	public Border resaltarnombreTipoProcesoEmpresaProdu=null;
	public Boolean mostrarnombreTipoProcesoEmpresaProdu=true;
	public Boolean activarnombreTipoProcesoEmpresaProdu=true;

	public Border resaltardescripcionTipoProcesoEmpresaProdu=null;
	public Boolean mostrardescripcionTipoProcesoEmpresaProdu=true;
	public Boolean activardescripcionTipoProcesoEmpresaProdu=true;

	
	

	public Border setResaltaridTipoProcesoEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprocesoempresaproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltaridTipoProcesoEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoProcesoEmpresaProdu() {
		return this.resaltaridTipoProcesoEmpresaProdu;
	}

	public void setResaltaridTipoProcesoEmpresaProdu(Border borderResaltar) {
		this.resaltaridTipoProcesoEmpresaProdu= borderResaltar;
	}

	public Boolean getMostraridTipoProcesoEmpresaProdu() {
		return this.mostraridTipoProcesoEmpresaProdu;
	}

	public void setMostraridTipoProcesoEmpresaProdu(Boolean mostraridTipoProcesoEmpresaProdu) {
		this.mostraridTipoProcesoEmpresaProdu= mostraridTipoProcesoEmpresaProdu;
	}

	public Boolean getActivaridTipoProcesoEmpresaProdu() {
		return this.activaridTipoProcesoEmpresaProdu;
	}

	public void setActivaridTipoProcesoEmpresaProdu(Boolean activaridTipoProcesoEmpresaProdu) {
		this.activaridTipoProcesoEmpresaProdu= activaridTipoProcesoEmpresaProdu;
	}

	public Border setResaltarid_empresaTipoProcesoEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprocesoempresaproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoProcesoEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoProcesoEmpresaProdu() {
		return this.resaltarid_empresaTipoProcesoEmpresaProdu;
	}

	public void setResaltarid_empresaTipoProcesoEmpresaProdu(Border borderResaltar) {
		this.resaltarid_empresaTipoProcesoEmpresaProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoProcesoEmpresaProdu() {
		return this.mostrarid_empresaTipoProcesoEmpresaProdu;
	}

	public void setMostrarid_empresaTipoProcesoEmpresaProdu(Boolean mostrarid_empresaTipoProcesoEmpresaProdu) {
		this.mostrarid_empresaTipoProcesoEmpresaProdu= mostrarid_empresaTipoProcesoEmpresaProdu;
	}

	public Boolean getActivarid_empresaTipoProcesoEmpresaProdu() {
		return this.activarid_empresaTipoProcesoEmpresaProdu;
	}

	public void setActivarid_empresaTipoProcesoEmpresaProdu(Boolean activarid_empresaTipoProcesoEmpresaProdu) {
		this.activarid_empresaTipoProcesoEmpresaProdu= activarid_empresaTipoProcesoEmpresaProdu;
	}

	public Boolean getCargarid_empresaTipoProcesoEmpresaProdu() {
		return this.cargarid_empresaTipoProcesoEmpresaProdu;
	}

	public void setCargarid_empresaTipoProcesoEmpresaProdu(Boolean cargarid_empresaTipoProcesoEmpresaProdu) {
		this.cargarid_empresaTipoProcesoEmpresaProdu= cargarid_empresaTipoProcesoEmpresaProdu;
	}

	public Border setResaltarnombreTipoProcesoEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprocesoempresaproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltarnombreTipoProcesoEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoProcesoEmpresaProdu() {
		return this.resaltarnombreTipoProcesoEmpresaProdu;
	}

	public void setResaltarnombreTipoProcesoEmpresaProdu(Border borderResaltar) {
		this.resaltarnombreTipoProcesoEmpresaProdu= borderResaltar;
	}

	public Boolean getMostrarnombreTipoProcesoEmpresaProdu() {
		return this.mostrarnombreTipoProcesoEmpresaProdu;
	}

	public void setMostrarnombreTipoProcesoEmpresaProdu(Boolean mostrarnombreTipoProcesoEmpresaProdu) {
		this.mostrarnombreTipoProcesoEmpresaProdu= mostrarnombreTipoProcesoEmpresaProdu;
	}

	public Boolean getActivarnombreTipoProcesoEmpresaProdu() {
		return this.activarnombreTipoProcesoEmpresaProdu;
	}

	public void setActivarnombreTipoProcesoEmpresaProdu(Boolean activarnombreTipoProcesoEmpresaProdu) {
		this.activarnombreTipoProcesoEmpresaProdu= activarnombreTipoProcesoEmpresaProdu;
	}

	public Border setResaltardescripcionTipoProcesoEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoprocesoempresaproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoProcesoEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoProcesoEmpresaProdu() {
		return this.resaltardescripcionTipoProcesoEmpresaProdu;
	}

	public void setResaltardescripcionTipoProcesoEmpresaProdu(Border borderResaltar) {
		this.resaltardescripcionTipoProcesoEmpresaProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoProcesoEmpresaProdu() {
		return this.mostrardescripcionTipoProcesoEmpresaProdu;
	}

	public void setMostrardescripcionTipoProcesoEmpresaProdu(Boolean mostrardescripcionTipoProcesoEmpresaProdu) {
		this.mostrardescripcionTipoProcesoEmpresaProdu= mostrardescripcionTipoProcesoEmpresaProdu;
	}

	public Boolean getActivardescripcionTipoProcesoEmpresaProdu() {
		return this.activardescripcionTipoProcesoEmpresaProdu;
	}

	public void setActivardescripcionTipoProcesoEmpresaProdu(Boolean activardescripcionTipoProcesoEmpresaProdu) {
		this.activardescripcionTipoProcesoEmpresaProdu= activardescripcionTipoProcesoEmpresaProdu;
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
		
		
		this.setMostraridTipoProcesoEmpresaProdu(esInicial);
		this.setMostrarid_empresaTipoProcesoEmpresaProdu(esInicial);
		this.setMostrarnombreTipoProcesoEmpresaProdu(esInicial);
		this.setMostrardescripcionTipoProcesoEmpresaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.ID)) {
				this.setMostraridTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoProcesoEmpresaProdu(esAsigna);
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
		
		
		this.setActivaridTipoProcesoEmpresaProdu(esInicial);
		this.setActivarid_empresaTipoProcesoEmpresaProdu(esInicial);
		this.setActivarnombreTipoProcesoEmpresaProdu(esInicial);
		this.setActivardescripcionTipoProcesoEmpresaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.ID)) {
				this.setActivaridTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoProcesoEmpresaProdu(esInicial);
		this.setResaltarid_empresaTipoProcesoEmpresaProdu(esInicial);
		this.setResaltarnombreTipoProcesoEmpresaProdu(esInicial);
		this.setResaltardescripcionTipoProcesoEmpresaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.ID)) {
				this.setResaltaridTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoProcesoEmpresaProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoProduManoTipoProcesoEmpresaProdu=null;

	public Border getResaltarProductoProduManoTipoProcesoEmpresaProdu() {
		return this.resaltarProductoProduManoTipoProcesoEmpresaProdu;
	}

	public void setResaltarProductoProduManoTipoProcesoEmpresaProdu(Border borderResaltarProductoProduMano) {
		if(borderResaltarProductoProduMano!=null) {
			this.resaltarProductoProduManoTipoProcesoEmpresaProdu= borderResaltarProductoProduMano;
		}
	}

	public Border setResaltarProductoProduManoTipoProcesoEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoProduMano=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprocesoempresaproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoEmpresaProdu.setBorder(borderResaltarProductoProduMano);
			
		this.resaltarProductoProduManoTipoProcesoEmpresaProdu= borderResaltarProductoProduMano;

		 return borderResaltarProductoProduMano;
	}



	public Boolean mostrarProductoProduManoTipoProcesoEmpresaProdu=true;

	public Boolean getMostrarProductoProduManoTipoProcesoEmpresaProdu() {
		return this.mostrarProductoProduManoTipoProcesoEmpresaProdu;
	}

	public void setMostrarProductoProduManoTipoProcesoEmpresaProdu(Boolean visibilidadResaltarProductoProduMano) {
		this.mostrarProductoProduManoTipoProcesoEmpresaProdu= visibilidadResaltarProductoProduMano;
	}



	public Boolean activarProductoProduManoTipoProcesoEmpresaProdu=true;

	public Boolean gethabilitarResaltarProductoProduManoTipoProcesoEmpresaProdu() {
		return this.activarProductoProduManoTipoProcesoEmpresaProdu;
	}

	public void setActivarProductoProduManoTipoProcesoEmpresaProdu(Boolean habilitarResaltarProductoProduMano) {
		this.activarProductoProduManoTipoProcesoEmpresaProdu= habilitarResaltarProductoProduMano;
	}


	public Border resaltarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu=null;

	public Border getResaltarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu() {
		return this.resaltarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu;
	}

	public void setResaltarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu(Border borderResaltarProductoOrdenDetaProduMano) {
		if(borderResaltarProductoOrdenDetaProduMano!=null) {
			this.resaltarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu= borderResaltarProductoOrdenDetaProduMano;
		}
	}

	public Border setResaltarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoOrdenDetaProduMano=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprocesoempresaproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoEmpresaProdu.setBorder(borderResaltarProductoOrdenDetaProduMano);
			
		this.resaltarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu= borderResaltarProductoOrdenDetaProduMano;

		 return borderResaltarProductoOrdenDetaProduMano;
	}



	public Boolean mostrarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu=true;

	public Boolean getMostrarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu() {
		return this.mostrarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu;
	}

	public void setMostrarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu(Boolean visibilidadResaltarProductoOrdenDetaProduMano) {
		this.mostrarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu= visibilidadResaltarProductoOrdenDetaProduMano;
	}



	public Boolean activarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu=true;

	public Boolean gethabilitarResaltarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu() {
		return this.activarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu;
	}

	public void setActivarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu(Boolean habilitarResaltarProductoOrdenDetaProduMano) {
		this.activarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu= habilitarResaltarProductoOrdenDetaProduMano;
	}


	public Border resaltarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu=null;

	public Border getResaltarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu() {
		return this.resaltarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu;
	}

	public void setResaltarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu(Border borderResaltarProductoOrdenDetaProduMaquina) {
		if(borderResaltarProductoOrdenDetaProduMaquina!=null) {
			this.resaltarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu= borderResaltarProductoOrdenDetaProduMaquina;
		}
	}

	public Border setResaltarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoOrdenDetaProduMaquina=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprocesoempresaproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoEmpresaProdu.setBorder(borderResaltarProductoOrdenDetaProduMaquina);
			
		this.resaltarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu= borderResaltarProductoOrdenDetaProduMaquina;

		 return borderResaltarProductoOrdenDetaProduMaquina;
	}



	public Boolean mostrarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu=true;

	public Boolean getMostrarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu() {
		return this.mostrarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu;
	}

	public void setMostrarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu(Boolean visibilidadResaltarProductoOrdenDetaProduMaquina) {
		this.mostrarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu= visibilidadResaltarProductoOrdenDetaProduMaquina;
	}



	public Boolean activarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu=true;

	public Boolean gethabilitarResaltarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu() {
		return this.activarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu;
	}

	public void setActivarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu(Boolean habilitarResaltarProductoOrdenDetaProduMaquina) {
		this.activarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu= habilitarResaltarProductoOrdenDetaProduMaquina;
	}


	public Border resaltarProductoProduMaquinaTipoProcesoEmpresaProdu=null;

	public Border getResaltarProductoProduMaquinaTipoProcesoEmpresaProdu() {
		return this.resaltarProductoProduMaquinaTipoProcesoEmpresaProdu;
	}

	public void setResaltarProductoProduMaquinaTipoProcesoEmpresaProdu(Border borderResaltarProductoProduMaquina) {
		if(borderResaltarProductoProduMaquina!=null) {
			this.resaltarProductoProduMaquinaTipoProcesoEmpresaProdu= borderResaltarProductoProduMaquina;
		}
	}

	public Border setResaltarProductoProduMaquinaTipoProcesoEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoProduMaquina=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoprocesoempresaproduBeanSwingJInternalFrame.jTtoolBarTipoProcesoEmpresaProdu.setBorder(borderResaltarProductoProduMaquina);
			
		this.resaltarProductoProduMaquinaTipoProcesoEmpresaProdu= borderResaltarProductoProduMaquina;

		 return borderResaltarProductoProduMaquina;
	}



	public Boolean mostrarProductoProduMaquinaTipoProcesoEmpresaProdu=true;

	public Boolean getMostrarProductoProduMaquinaTipoProcesoEmpresaProdu() {
		return this.mostrarProductoProduMaquinaTipoProcesoEmpresaProdu;
	}

	public void setMostrarProductoProduMaquinaTipoProcesoEmpresaProdu(Boolean visibilidadResaltarProductoProduMaquina) {
		this.mostrarProductoProduMaquinaTipoProcesoEmpresaProdu= visibilidadResaltarProductoProduMaquina;
	}



	public Boolean activarProductoProduMaquinaTipoProcesoEmpresaProdu=true;

	public Boolean gethabilitarResaltarProductoProduMaquinaTipoProcesoEmpresaProdu() {
		return this.activarProductoProduMaquinaTipoProcesoEmpresaProdu;
	}

	public void setActivarProductoProduMaquinaTipoProcesoEmpresaProdu(Boolean habilitarResaltarProductoProduMaquina) {
		this.activarProductoProduMaquinaTipoProcesoEmpresaProdu= habilitarResaltarProductoProduMaquina;
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

		this.setMostrarProductoProduManoTipoProcesoEmpresaProdu(esInicial);
		this.setMostrarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu(esInicial);
		this.setMostrarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu(esInicial);
		this.setMostrarProductoProduMaquinaTipoProcesoEmpresaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoProduMano.class)) {
				this.setMostrarProductoProduManoTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMano.class)) {
				this.setMostrarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setMostrarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setMostrarProductoProduMaquinaTipoProcesoEmpresaProdu(esAsigna);
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

		this.setActivarProductoProduManoTipoProcesoEmpresaProdu(esInicial);
		this.setActivarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu(esInicial);
		this.setActivarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu(esInicial);
		this.setActivarProductoProduMaquinaTipoProcesoEmpresaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoProduMano.class)) {
				this.setActivarProductoProduManoTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMano.class)) {
				this.setActivarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setActivarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setActivarProductoProduMaquinaTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoProduManoTipoProcesoEmpresaProdu(esInicial);
		this.setResaltarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu(esInicial);
		this.setResaltarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu(esInicial);
		this.setResaltarProductoProduMaquinaTipoProcesoEmpresaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoProduMano.class)) {
				this.setResaltarProductoProduManoTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMano.class)) {
				this.setResaltarProductoOrdenDetaProduManoTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setResaltarProductoOrdenDetaProduMaquinaTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setResaltarProductoProduMaquinaTipoProcesoEmpresaProdu(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoProcesoEmpresaProdu=true;

	public Boolean getMostrarFK_IdEmpresaTipoProcesoEmpresaProdu() {
		return this.mostrarFK_IdEmpresaTipoProcesoEmpresaProdu;
	}

	public void setMostrarFK_IdEmpresaTipoProcesoEmpresaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoProcesoEmpresaProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoProcesoEmpresaProdu=true;

	public Boolean getActivarFK_IdEmpresaTipoProcesoEmpresaProdu() {
		return this.activarFK_IdEmpresaTipoProcesoEmpresaProdu;
	}

	public void setActivarFK_IdEmpresaTipoProcesoEmpresaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoProcesoEmpresaProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoProcesoEmpresaProdu=null;

	public Border getResaltarFK_IdEmpresaTipoProcesoEmpresaProdu() {
		return this.resaltarFK_IdEmpresaTipoProcesoEmpresaProdu;
	}

	public void setResaltarFK_IdEmpresaTipoProcesoEmpresaProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoProcesoEmpresaProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoProcesoEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoProcesoEmpresaProduBeanSwingJInternalFrame tipoprocesoempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoProcesoEmpresaProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}