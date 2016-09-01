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
package com.bydan.erp.seguridad.util.report;

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

import com.bydan.erp.seguridad.resources.general.AuxiliarGeneral;

import com.bydan.erp.seguridad.util.report.ProcesoCambiarEmpresaSucursalConstantesFunciones;
import com.bydan.erp.seguridad.util.report.ProcesoCambiarEmpresaSucursalParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.report.ProcesoCambiarEmpresaSucursalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoCambiarEmpresaSucursalConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="ProcesoCambiarEmpresaSucursal";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoCambiarEmpresaSucursal"+ProcesoCambiarEmpresaSucursalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoCambiarEmpresaSucursalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoCambiarEmpresaSucursalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoCambiarEmpresaSucursalConstantesFunciones.SCHEMA+"_"+ProcesoCambiarEmpresaSucursalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarEmpresaSucursalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoCambiarEmpresaSucursalConstantesFunciones.SCHEMA+"_"+ProcesoCambiarEmpresaSucursalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoCambiarEmpresaSucursalConstantesFunciones.SCHEMA+"_"+ProcesoCambiarEmpresaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarEmpresaSucursalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoCambiarEmpresaSucursalConstantesFunciones.SCHEMA+"_"+ProcesoCambiarEmpresaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarEmpresaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarEmpresaSucursalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarEmpresaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarEmpresaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCambiarEmpresaSucursalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCambiarEmpresaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoCambiarEmpresaSucursalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoCambiarEmpresaSucursalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoCambiarEmpresaSucursalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoCambiarEmpresaSucursalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Cambiar Empresa Sucursales";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Cambiar Empresa Sucursal";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Cambiar Empresa Sucursal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoCambiarEmpresaSucursal";
	public static final String OBJECTNAME="procesocambiarempresasucursal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="proceso_cambiar_empresa_sucursal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesocambiarempresasucursal from "+ProcesoCambiarEmpresaSucursalConstantesFunciones.SPERSISTENCENAME+" procesocambiarempresasucursal";
	public static String QUERYSELECTNATIVE="select "+ProcesoCambiarEmpresaSucursalConstantesFunciones.SCHEMA+"."+ProcesoCambiarEmpresaSucursalConstantesFunciones.TABLENAME+".id,"+ProcesoCambiarEmpresaSucursalConstantesFunciones.SCHEMA+"."+ProcesoCambiarEmpresaSucursalConstantesFunciones.TABLENAME+".version_row,"+ProcesoCambiarEmpresaSucursalConstantesFunciones.SCHEMA+"."+ProcesoCambiarEmpresaSucursalConstantesFunciones.TABLENAME+".id_empresa,"+ProcesoCambiarEmpresaSucursalConstantesFunciones.SCHEMA+"."+ProcesoCambiarEmpresaSucursalConstantesFunciones.TABLENAME+".id_sucursal from "+ProcesoCambiarEmpresaSucursalConstantesFunciones.SCHEMA+"."+ProcesoCambiarEmpresaSucursalConstantesFunciones.TABLENAME;//+" as "+ProcesoCambiarEmpresaSucursalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
	
		
		
		
		
	
	public static String getProcesoCambiarEmpresaSucursalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProcesoCambiarEmpresaSucursalConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProcesoCambiarEmpresaSucursalConstantesFunciones.LABEL_IDSUCURSAL;}
		
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
	
	
	
			
			
			
			
	
	public static String getProcesoCambiarEmpresaSucursalDescripcion(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesocambiarempresasucursal !=null/* && procesocambiarempresasucursal.getId()!=0*/) {
			if(procesocambiarempresasucursal.getId()!=null) {
				sDescripcion=procesocambiarempresasucursal.getId().toString();
			}//procesocambiarempresasucursalprocesocambiarempresasucursal.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoCambiarEmpresaSucursalDescripcionDetallado(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoCambiarEmpresaSucursalConstantesFunciones.ID+"=";
		sDescripcion+=procesocambiarempresasucursal.getId().toString()+",";
		sDescripcion+=ProcesoCambiarEmpresaSucursalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesocambiarempresasucursal.getVersionRow().toString()+",";
		sDescripcion+=ProcesoCambiarEmpresaSucursalConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=procesocambiarempresasucursal.getid_empresa().toString()+",";
		sDescripcion+=ProcesoCambiarEmpresaSucursalConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=procesocambiarempresasucursal.getid_sucursal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoCambiarEmpresaSucursalDescripcion(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,String sValor) throws Exception {			
		if(procesocambiarempresasucursal !=null) {
			//procesocambiarempresasucursalprocesocambiarempresasucursal.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoCambiarEmpresaSucursal")) {
			sNombreIndice="Tipo=  Por Empresa Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoCambiarEmpresaSucursal(Long id_empresa,Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoCambiarEmpresaSucursal(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoCambiarEmpresaSucursals(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal: procesocambiarempresasucursals) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCambiarEmpresaSucursal(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesocambiarempresasucursal.getConCambioAuxiliar()) {
			procesocambiarempresasucursal.setIsDeleted(procesocambiarempresasucursal.getIsDeletedAuxiliar());	
			procesocambiarempresasucursal.setIsNew(procesocambiarempresasucursal.getIsNewAuxiliar());	
			procesocambiarempresasucursal.setIsChanged(procesocambiarempresasucursal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesocambiarempresasucursal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesocambiarempresasucursal.setIsDeletedAuxiliar(false);	
			procesocambiarempresasucursal.setIsNewAuxiliar(false);	
			procesocambiarempresasucursal.setIsChangedAuxiliar(false);
			
			procesocambiarempresasucursal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCambiarEmpresaSucursals(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal : procesocambiarempresasucursals) {
			if(conAsignarBase && procesocambiarempresasucursal.getConCambioAuxiliar()) {
				procesocambiarempresasucursal.setIsDeleted(procesocambiarempresasucursal.getIsDeletedAuxiliar());	
				procesocambiarempresasucursal.setIsNew(procesocambiarempresasucursal.getIsNewAuxiliar());	
				procesocambiarempresasucursal.setIsChanged(procesocambiarempresasucursal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesocambiarempresasucursal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesocambiarempresasucursal.setIsDeletedAuxiliar(false);	
				procesocambiarempresasucursal.setIsNewAuxiliar(false);	
				procesocambiarempresasucursal.setIsChangedAuxiliar(false);
				
				procesocambiarempresasucursal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoCambiarEmpresaSucursal(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoCambiarEmpresaSucursals(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,Boolean conEnteros) throws Exception  {
		
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal: procesocambiarempresasucursals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoCambiarEmpresaSucursal(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,ProcesoCambiarEmpresaSucursal procesocambiarempresasucursalAux) throws Exception  {
		ProcesoCambiarEmpresaSucursalConstantesFunciones.InicializarValoresProcesoCambiarEmpresaSucursal(procesocambiarempresasucursalAux,true);
		
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal: procesocambiarempresasucursals) {
			if(procesocambiarempresasucursal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCambiarEmpresaSucursal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoCambiarEmpresaSucursalConstantesFunciones.getArrayColumnasGlobalesProcesoCambiarEmpresaSucursal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCambiarEmpresaSucursal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoCambiarEmpresaSucursal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursalAux: procesocambiarempresasucursals) {
			if(procesocambiarempresasucursalAux!=null && procesocambiarempresasucursal!=null) {
				if((procesocambiarempresasucursalAux.getId()==null && procesocambiarempresasucursal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesocambiarempresasucursalAux.getId()!=null && procesocambiarempresasucursal.getId()!=null){
					if(procesocambiarempresasucursalAux.getId().equals(procesocambiarempresasucursal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCambiarEmpresaSucursal(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal: procesocambiarempresasucursals) {			
			if(procesocambiarempresasucursal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoCambiarEmpresaSucursal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoCambiarEmpresaSucursal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCambiarEmpresaSucursal() throws Exception  {
		return ProcesoCambiarEmpresaSucursalConstantesFunciones.getTiposSeleccionarProcesoCambiarEmpresaSucursal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCambiarEmpresaSucursal(Boolean conFk) throws Exception  {
		return ProcesoCambiarEmpresaSucursalConstantesFunciones.getTiposSeleccionarProcesoCambiarEmpresaSucursal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCambiarEmpresaSucursal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarEmpresaSucursalConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProcesoCambiarEmpresaSucursalConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCambiarEmpresaSucursalConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProcesoCambiarEmpresaSucursalConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoCambiarEmpresaSucursal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCambiarEmpresaSucursal(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursalAux) throws Exception {
		
			procesocambiarempresasucursalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesocambiarempresasucursalAux.getEmpresa()));
			procesocambiarempresasucursalAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesocambiarempresasucursalAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCambiarEmpresaSucursal(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursalsTemp) throws Exception {
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursalAux:procesocambiarempresasucursalsTemp) {
			
			procesocambiarempresasucursalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesocambiarempresasucursalAux.getEmpresa()));
			procesocambiarempresasucursalAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesocambiarempresasucursalAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoCambiarEmpresaSucursal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoCambiarEmpresaSucursal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCambiarEmpresaSucursal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCambiarEmpresaSucursalConstantesFunciones.getClassesRelationshipsOfProcesoCambiarEmpresaSucursal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCambiarEmpresaSucursal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCambiarEmpresaSucursal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCambiarEmpresaSucursalConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoCambiarEmpresaSucursal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCambiarEmpresaSucursal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals) throws Exception {
		try	{			
			for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursalLocal:procesocambiarempresasucursals) {
				if(procesocambiarempresasucursalLocal.getId().equals(procesocambiarempresasucursal.getId())) {
					procesocambiarempresasucursalLocal.setIsSelected(procesocambiarempresasucursal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoCambiarEmpresaSucursal(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursalsAux) throws Exception {
		//this.procesocambiarempresasucursalsAux=procesocambiarempresasucursalsAux;
		
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursalAux:procesocambiarempresasucursalsAux) {
			if(procesocambiarempresasucursalAux.getIsChanged()) {
				procesocambiarempresasucursalAux.setIsChanged(false);
			}		
			
			if(procesocambiarempresasucursalAux.getIsNew()) {
				procesocambiarempresasucursalAux.setIsNew(false);
			}	
			
			if(procesocambiarempresasucursalAux.getIsDeleted()) {
				procesocambiarempresasucursalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoCambiarEmpresaSucursal(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursalAux) throws Exception {
		//this.procesocambiarempresasucursalAux=procesocambiarempresasucursalAux;
		
			if(procesocambiarempresasucursalAux.getIsChanged()) {
				procesocambiarempresasucursalAux.setIsChanged(false);
			}		
			
			if(procesocambiarempresasucursalAux.getIsNew()) {
				procesocambiarempresasucursalAux.setIsNew(false);
			}	
			
			if(procesocambiarempresasucursalAux.getIsDeleted()) {
				procesocambiarempresasucursalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursalAsignar,ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal) throws Exception {
		procesocambiarempresasucursalAsignar.setId(procesocambiarempresasucursal.getId());	
		procesocambiarempresasucursalAsignar.setVersionRow(procesocambiarempresasucursal.getVersionRow());	
	}
	
	public static void inicializarProcesoCambiarEmpresaSucursal(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal) throws Exception {
		try {
				procesocambiarempresasucursal.setId(0L);	
					
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoCambiarEmpresaSucursal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarEmpresaSucursalConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCambiarEmpresaSucursalConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoCambiarEmpresaSucursal(String sTipo,Row row,Workbook workbook,ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocambiarempresasucursal.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocambiarempresasucursal.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoCambiarEmpresaSucursal="";
	
	public String getsFinalQueryProcesoCambiarEmpresaSucursal() {
		return this.sFinalQueryProcesoCambiarEmpresaSucursal;
	}
	
	public void setsFinalQueryProcesoCambiarEmpresaSucursal(String sFinalQueryProcesoCambiarEmpresaSucursal) {
		this.sFinalQueryProcesoCambiarEmpresaSucursal= sFinalQueryProcesoCambiarEmpresaSucursal;
	}
	
	public Border resaltarSeleccionarProcesoCambiarEmpresaSucursal=null;
	
	public Border setResaltarSeleccionarProcesoCambiarEmpresaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarEmpresaSucursalBeanSwingJInternalFrame procesocambiarempresasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesocambiarempresasucursalBeanSwingJInternalFrame.jTtoolBarProcesoCambiarEmpresaSucursal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoCambiarEmpresaSucursal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoCambiarEmpresaSucursal() {
		return this.resaltarSeleccionarProcesoCambiarEmpresaSucursal;
	}
	
	public void setResaltarSeleccionarProcesoCambiarEmpresaSucursal(Border borderResaltarSeleccionarProcesoCambiarEmpresaSucursal) {
		this.resaltarSeleccionarProcesoCambiarEmpresaSucursal= borderResaltarSeleccionarProcesoCambiarEmpresaSucursal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoCambiarEmpresaSucursal=null;
	public Boolean mostraridProcesoCambiarEmpresaSucursal=true;
	public Boolean activaridProcesoCambiarEmpresaSucursal=true;

	public Border resaltarid_empresaProcesoCambiarEmpresaSucursal=null;
	public Boolean mostrarid_empresaProcesoCambiarEmpresaSucursal=true;
	public Boolean activarid_empresaProcesoCambiarEmpresaSucursal=true;
	public Boolean cargarid_empresaProcesoCambiarEmpresaSucursal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProcesoCambiarEmpresaSucursal=false;//ConEventDepend=true

	public Border resaltarid_sucursalProcesoCambiarEmpresaSucursal=null;
	public Boolean mostrarid_sucursalProcesoCambiarEmpresaSucursal=true;
	public Boolean activarid_sucursalProcesoCambiarEmpresaSucursal=true;
	public Boolean cargarid_sucursalProcesoCambiarEmpresaSucursal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProcesoCambiarEmpresaSucursal=true;//ConEventDepend=true

	
	

	public Border setResaltaridProcesoCambiarEmpresaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarEmpresaSucursalBeanSwingJInternalFrame procesocambiarempresasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarempresasucursalBeanSwingJInternalFrame.jTtoolBarProcesoCambiarEmpresaSucursal.setBorder(borderResaltar);
		
		this.resaltaridProcesoCambiarEmpresaSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoCambiarEmpresaSucursal() {
		return this.resaltaridProcesoCambiarEmpresaSucursal;
	}

	public void setResaltaridProcesoCambiarEmpresaSucursal(Border borderResaltar) {
		this.resaltaridProcesoCambiarEmpresaSucursal= borderResaltar;
	}

	public Boolean getMostraridProcesoCambiarEmpresaSucursal() {
		return this.mostraridProcesoCambiarEmpresaSucursal;
	}

	public void setMostraridProcesoCambiarEmpresaSucursal(Boolean mostraridProcesoCambiarEmpresaSucursal) {
		this.mostraridProcesoCambiarEmpresaSucursal= mostraridProcesoCambiarEmpresaSucursal;
	}

	public Boolean getActivaridProcesoCambiarEmpresaSucursal() {
		return this.activaridProcesoCambiarEmpresaSucursal;
	}

	public void setActivaridProcesoCambiarEmpresaSucursal(Boolean activaridProcesoCambiarEmpresaSucursal) {
		this.activaridProcesoCambiarEmpresaSucursal= activaridProcesoCambiarEmpresaSucursal;
	}

	public Border setResaltarid_empresaProcesoCambiarEmpresaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarEmpresaSucursalBeanSwingJInternalFrame procesocambiarempresasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarempresasucursalBeanSwingJInternalFrame.jTtoolBarProcesoCambiarEmpresaSucursal.setBorder(borderResaltar);
		
		this.resaltarid_empresaProcesoCambiarEmpresaSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProcesoCambiarEmpresaSucursal() {
		return this.resaltarid_empresaProcesoCambiarEmpresaSucursal;
	}

	public void setResaltarid_empresaProcesoCambiarEmpresaSucursal(Border borderResaltar) {
		this.resaltarid_empresaProcesoCambiarEmpresaSucursal= borderResaltar;
	}

	public Boolean getMostrarid_empresaProcesoCambiarEmpresaSucursal() {
		return this.mostrarid_empresaProcesoCambiarEmpresaSucursal;
	}

	public void setMostrarid_empresaProcesoCambiarEmpresaSucursal(Boolean mostrarid_empresaProcesoCambiarEmpresaSucursal) {
		this.mostrarid_empresaProcesoCambiarEmpresaSucursal= mostrarid_empresaProcesoCambiarEmpresaSucursal;
	}

	public Boolean getActivarid_empresaProcesoCambiarEmpresaSucursal() {
		return this.activarid_empresaProcesoCambiarEmpresaSucursal;
	}

	public void setActivarid_empresaProcesoCambiarEmpresaSucursal(Boolean activarid_empresaProcesoCambiarEmpresaSucursal) {
		this.activarid_empresaProcesoCambiarEmpresaSucursal= activarid_empresaProcesoCambiarEmpresaSucursal;
	}

	public Boolean getCargarid_empresaProcesoCambiarEmpresaSucursal() {
		return this.cargarid_empresaProcesoCambiarEmpresaSucursal;
	}

	public void setCargarid_empresaProcesoCambiarEmpresaSucursal(Boolean cargarid_empresaProcesoCambiarEmpresaSucursal) {
		this.cargarid_empresaProcesoCambiarEmpresaSucursal= cargarid_empresaProcesoCambiarEmpresaSucursal;
	}

	public Border setResaltarid_sucursalProcesoCambiarEmpresaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarEmpresaSucursalBeanSwingJInternalFrame procesocambiarempresasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocambiarempresasucursalBeanSwingJInternalFrame.jTtoolBarProcesoCambiarEmpresaSucursal.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProcesoCambiarEmpresaSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProcesoCambiarEmpresaSucursal() {
		return this.resaltarid_sucursalProcesoCambiarEmpresaSucursal;
	}

	public void setResaltarid_sucursalProcesoCambiarEmpresaSucursal(Border borderResaltar) {
		this.resaltarid_sucursalProcesoCambiarEmpresaSucursal= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProcesoCambiarEmpresaSucursal() {
		return this.mostrarid_sucursalProcesoCambiarEmpresaSucursal;
	}

	public void setMostrarid_sucursalProcesoCambiarEmpresaSucursal(Boolean mostrarid_sucursalProcesoCambiarEmpresaSucursal) {
		this.mostrarid_sucursalProcesoCambiarEmpresaSucursal= mostrarid_sucursalProcesoCambiarEmpresaSucursal;
	}

	public Boolean getActivarid_sucursalProcesoCambiarEmpresaSucursal() {
		return this.activarid_sucursalProcesoCambiarEmpresaSucursal;
	}

	public void setActivarid_sucursalProcesoCambiarEmpresaSucursal(Boolean activarid_sucursalProcesoCambiarEmpresaSucursal) {
		this.activarid_sucursalProcesoCambiarEmpresaSucursal= activarid_sucursalProcesoCambiarEmpresaSucursal;
	}

	public Boolean getCargarid_sucursalProcesoCambiarEmpresaSucursal() {
		return this.cargarid_sucursalProcesoCambiarEmpresaSucursal;
	}

	public void setCargarid_sucursalProcesoCambiarEmpresaSucursal(Boolean cargarid_sucursalProcesoCambiarEmpresaSucursal) {
		this.cargarid_sucursalProcesoCambiarEmpresaSucursal= cargarid_sucursalProcesoCambiarEmpresaSucursal;
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
		
		
		this.setMostraridProcesoCambiarEmpresaSucursal(esInicial);
		this.setMostrarid_empresaProcesoCambiarEmpresaSucursal(esInicial);
		this.setMostrarid_sucursalProcesoCambiarEmpresaSucursal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.ID)) {
				this.setMostraridProcesoCambiarEmpresaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProcesoCambiarEmpresaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProcesoCambiarEmpresaSucursal(esAsigna);
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
		
		
		this.setActivaridProcesoCambiarEmpresaSucursal(esInicial);
		this.setActivarid_empresaProcesoCambiarEmpresaSucursal(esInicial);
		this.setActivarid_sucursalProcesoCambiarEmpresaSucursal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.ID)) {
				this.setActivaridProcesoCambiarEmpresaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProcesoCambiarEmpresaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProcesoCambiarEmpresaSucursal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCambiarEmpresaSucursalBeanSwingJInternalFrame procesocambiarempresasucursalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoCambiarEmpresaSucursal(esInicial);
		this.setResaltarid_empresaProcesoCambiarEmpresaSucursal(esInicial);
		this.setResaltarid_sucursalProcesoCambiarEmpresaSucursal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.ID)) {
				this.setResaltaridProcesoCambiarEmpresaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProcesoCambiarEmpresaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProcesoCambiarEmpresaSucursal(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCambiarEmpresaSucursalBeanSwingJInternalFrame procesocambiarempresasucursalBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal=true;

	public Boolean getMostrarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal() {
		return this.mostrarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal;
	}

	public void setMostrarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal=true;

	public Boolean getActivarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal() {
		return this.activarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal;
	}

	public void setActivarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal=null;

	public Border getResaltarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal() {
		return this.resaltarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal;
	}

	public void setResaltarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal(Border borderResaltar) {
		this.resaltarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal= borderResaltar;
	}

	public void setResaltarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCambiarEmpresaSucursalBeanSwingJInternalFrame procesocambiarempresasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoCambiarEmpresaSucursalProcesoCambiarEmpresaSucursal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}