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
package com.bydan.erp.nomina.util.report;

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

import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;

import com.bydan.erp.nomina.util.report.ProcesoGeneraRolesConstantesFunciones;
import com.bydan.erp.nomina.util.report.ProcesoGeneraRolesParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoGeneraRolesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoGeneraRolesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoGeneraRoles";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoGeneraRoles"+ProcesoGeneraRolesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoGeneraRolesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoGeneraRolesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoGeneraRolesConstantesFunciones.SCHEMA+"_"+ProcesoGeneraRolesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoGeneraRolesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoGeneraRolesConstantesFunciones.SCHEMA+"_"+ProcesoGeneraRolesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoGeneraRolesConstantesFunciones.SCHEMA+"_"+ProcesoGeneraRolesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoGeneraRolesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoGeneraRolesConstantesFunciones.SCHEMA+"_"+ProcesoGeneraRolesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGeneraRolesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoGeneraRolesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGeneraRolesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGeneraRolesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoGeneraRolesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoGeneraRolesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoGeneraRolesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoGeneraRolesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoGeneraRolesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoGeneraRolesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Genera Roleses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Genera Roles";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Genera Roles";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoGeneraRoles";
	public static final String OBJECTNAME="procesogeneraroles";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="proceso_genera_roles";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesogeneraroles from "+ProcesoGeneraRolesConstantesFunciones.SPERSISTENCENAME+" procesogeneraroles";
	public static String QUERYSELECTNATIVE="select "+ProcesoGeneraRolesConstantesFunciones.SCHEMA+"."+ProcesoGeneraRolesConstantesFunciones.TABLENAME+".id,"+ProcesoGeneraRolesConstantesFunciones.SCHEMA+"."+ProcesoGeneraRolesConstantesFunciones.TABLENAME+".version_row,"+ProcesoGeneraRolesConstantesFunciones.SCHEMA+"."+ProcesoGeneraRolesConstantesFunciones.TABLENAME+".id_mes,"+ProcesoGeneraRolesConstantesFunciones.SCHEMA+"."+ProcesoGeneraRolesConstantesFunciones.TABLENAME+".id_estructura,"+ProcesoGeneraRolesConstantesFunciones.SCHEMA+"."+ProcesoGeneraRolesConstantesFunciones.TABLENAME+".id_empleado from "+ProcesoGeneraRolesConstantesFunciones.SCHEMA+"."+ProcesoGeneraRolesConstantesFunciones.TABLENAME;//+" as "+ProcesoGeneraRolesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDMES= "id_mes";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDEMPLEADO= "id_empleado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
	
		
		
		
		
		
	
	public static String getProcesoGeneraRolesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoGeneraRolesConstantesFunciones.IDMES)) {sLabelColumna=ProcesoGeneraRolesConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(ProcesoGeneraRolesConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=ProcesoGeneraRolesConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(ProcesoGeneraRolesConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ProcesoGeneraRolesConstantesFunciones.LABEL_IDEMPLEADO;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getProcesoGeneraRolesDescripcion(ProcesoGeneraRoles procesogeneraroles) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesogeneraroles !=null/* && procesogeneraroles.getId()!=0*/) {
			if(procesogeneraroles.getId()!=null) {
				sDescripcion=procesogeneraroles.getId().toString();
			}//procesogenerarolesprocesogeneraroles.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoGeneraRolesDescripcionDetallado(ProcesoGeneraRoles procesogeneraroles) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoGeneraRolesConstantesFunciones.ID+"=";
		sDescripcion+=procesogeneraroles.getId().toString()+",";
		sDescripcion+=ProcesoGeneraRolesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesogeneraroles.getVersionRow().toString()+",";
		sDescripcion+=ProcesoGeneraRolesConstantesFunciones.IDMES+"=";
		sDescripcion+=procesogeneraroles.getid_mes().toString()+",";
		sDescripcion+=ProcesoGeneraRolesConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=procesogeneraroles.getid_estructura().toString()+",";
		sDescripcion+=ProcesoGeneraRolesConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=procesogeneraroles.getid_empleado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoGeneraRolesDescripcion(ProcesoGeneraRoles procesogeneraroles,String sValor) throws Exception {			
		if(procesogeneraroles !=null) {
			//procesogenerarolesprocesogeneraroles.getId().toString();
		}		
	}
	
		

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoGeneraRoles")) {
			sNombreIndice="Tipo=  Por Mes Por Estructura Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoGeneraRoles(Long id_mes,Long id_estructura,Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();}
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();}
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoGeneraRoles(ProcesoGeneraRoles procesogeneraroles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoGeneraRoless(List<ProcesoGeneraRoles> procesogeneraroless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoGeneraRoles procesogeneraroles: procesogeneraroless) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoGeneraRoles(ProcesoGeneraRoles procesogeneraroles,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesogeneraroles.getConCambioAuxiliar()) {
			procesogeneraroles.setIsDeleted(procesogeneraroles.getIsDeletedAuxiliar());	
			procesogeneraroles.setIsNew(procesogeneraroles.getIsNewAuxiliar());	
			procesogeneraroles.setIsChanged(procesogeneraroles.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesogeneraroles.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesogeneraroles.setIsDeletedAuxiliar(false);	
			procesogeneraroles.setIsNewAuxiliar(false);	
			procesogeneraroles.setIsChangedAuxiliar(false);
			
			procesogeneraroles.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoGeneraRoless(List<ProcesoGeneraRoles> procesogeneraroless,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoGeneraRoles procesogeneraroles : procesogeneraroless) {
			if(conAsignarBase && procesogeneraroles.getConCambioAuxiliar()) {
				procesogeneraroles.setIsDeleted(procesogeneraroles.getIsDeletedAuxiliar());	
				procesogeneraroles.setIsNew(procesogeneraroles.getIsNewAuxiliar());	
				procesogeneraroles.setIsChanged(procesogeneraroles.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesogeneraroles.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesogeneraroles.setIsDeletedAuxiliar(false);	
				procesogeneraroles.setIsNewAuxiliar(false);	
				procesogeneraroles.setIsChangedAuxiliar(false);
				
				procesogeneraroles.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoGeneraRoles(ProcesoGeneraRoles procesogeneraroles,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoGeneraRoless(List<ProcesoGeneraRoles> procesogeneraroless,Boolean conEnteros) throws Exception  {
		
		for(ProcesoGeneraRoles procesogeneraroles: procesogeneraroless) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoGeneraRoles(List<ProcesoGeneraRoles> procesogeneraroless,ProcesoGeneraRoles procesogenerarolesAux) throws Exception  {
		ProcesoGeneraRolesConstantesFunciones.InicializarValoresProcesoGeneraRoles(procesogenerarolesAux,true);
		
		for(ProcesoGeneraRoles procesogeneraroles: procesogeneraroless) {
			if(procesogeneraroles.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoGeneraRoles(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoGeneraRolesConstantesFunciones.getArrayColumnasGlobalesProcesoGeneraRoles(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoGeneraRoles(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoGeneraRoles(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoGeneraRoles> procesogeneraroless,ProcesoGeneraRoles procesogeneraroles,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoGeneraRoles procesogenerarolesAux: procesogeneraroless) {
			if(procesogenerarolesAux!=null && procesogeneraroles!=null) {
				if((procesogenerarolesAux.getId()==null && procesogeneraroles.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesogenerarolesAux.getId()!=null && procesogeneraroles.getId()!=null){
					if(procesogenerarolesAux.getId().equals(procesogeneraroles.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoGeneraRoles(List<ProcesoGeneraRoles> procesogeneraroless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoGeneraRoles procesogeneraroles: procesogeneraroless) {			
			if(procesogeneraroles.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoGeneraRoles() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoGeneraRoles() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoGeneraRoles() throws Exception  {
		return ProcesoGeneraRolesConstantesFunciones.getTiposSeleccionarProcesoGeneraRoles(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoGeneraRoles(Boolean conFk) throws Exception  {
		return ProcesoGeneraRolesConstantesFunciones.getTiposSeleccionarProcesoGeneraRoles(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoGeneraRoles(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGeneraRolesConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ProcesoGeneraRolesConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGeneraRolesConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(ProcesoGeneraRolesConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoGeneraRolesConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ProcesoGeneraRolesConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoGeneraRoles(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoGeneraRoles(ProcesoGeneraRoles procesogenerarolesAux) throws Exception {
		
			procesogenerarolesAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesogenerarolesAux.getMes()));
			procesogenerarolesAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(procesogenerarolesAux.getEstructura()));
			procesogenerarolesAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(procesogenerarolesAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoGeneraRoles(List<ProcesoGeneraRoles> procesogenerarolessTemp) throws Exception {
		for(ProcesoGeneraRoles procesogenerarolesAux:procesogenerarolessTemp) {
			
			procesogenerarolesAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(procesogenerarolesAux.getMes()));
			procesogenerarolesAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(procesogenerarolesAux.getEstructura()));
			procesogenerarolesAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(procesogenerarolesAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoGeneraRoles(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoGeneraRoles(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoGeneraRoles(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoGeneraRolesConstantesFunciones.getClassesRelationshipsOfProcesoGeneraRoles(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoGeneraRoles(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoGeneraRoles(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoGeneraRolesConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoGeneraRoles(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoGeneraRoles(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoGeneraRoles procesogeneraroles,List<ProcesoGeneraRoles> procesogeneraroless,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoGeneraRoles procesogeneraroles,List<ProcesoGeneraRoles> procesogeneraroless) throws Exception {
		try	{			
			for(ProcesoGeneraRoles procesogenerarolesLocal:procesogeneraroless) {
				if(procesogenerarolesLocal.getId().equals(procesogeneraroles.getId())) {
					procesogenerarolesLocal.setIsSelected(procesogeneraroles.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoGeneraRoles(List<ProcesoGeneraRoles> procesogenerarolessAux) throws Exception {
		//this.procesogenerarolessAux=procesogenerarolessAux;
		
		for(ProcesoGeneraRoles procesogenerarolesAux:procesogenerarolessAux) {
			if(procesogenerarolesAux.getIsChanged()) {
				procesogenerarolesAux.setIsChanged(false);
			}		
			
			if(procesogenerarolesAux.getIsNew()) {
				procesogenerarolesAux.setIsNew(false);
			}	
			
			if(procesogenerarolesAux.getIsDeleted()) {
				procesogenerarolesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoGeneraRoles(ProcesoGeneraRoles procesogenerarolesAux) throws Exception {
		//this.procesogenerarolesAux=procesogenerarolesAux;
		
			if(procesogenerarolesAux.getIsChanged()) {
				procesogenerarolesAux.setIsChanged(false);
			}		
			
			if(procesogenerarolesAux.getIsNew()) {
				procesogenerarolesAux.setIsNew(false);
			}	
			
			if(procesogenerarolesAux.getIsDeleted()) {
				procesogenerarolesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoGeneraRoles procesogenerarolesAsignar,ProcesoGeneraRoles procesogeneraroles) throws Exception {
		procesogenerarolesAsignar.setId(procesogeneraroles.getId());	
		procesogenerarolesAsignar.setVersionRow(procesogeneraroles.getVersionRow());	
		procesogenerarolesAsignar.setid_mes(procesogeneraroles.getid_mes());
		procesogenerarolesAsignar.setmes_descripcion(procesogeneraroles.getmes_descripcion());	
		procesogenerarolesAsignar.setid_estructura(procesogeneraroles.getid_estructura());
		procesogenerarolesAsignar.setestructura_descripcion(procesogeneraroles.getestructura_descripcion());	
		procesogenerarolesAsignar.setid_empleado(procesogeneraroles.getid_empleado());
		procesogenerarolesAsignar.setempleado_descripcion(procesogeneraroles.getempleado_descripcion());	
	}
	
	public static void inicializarProcesoGeneraRoles(ProcesoGeneraRoles procesogeneraroles) throws Exception {
		try {
				procesogeneraroles.setId(0L);	
					
				procesogeneraroles.setid_mes(null);	
				procesogeneraroles.setid_estructura(-1L);	
				procesogeneraroles.setid_empleado(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoGeneraRoles(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGeneraRolesConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGeneraRolesConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoGeneraRolesConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoGeneraRoles(String sTipo,Row row,Workbook workbook,ProcesoGeneraRoles procesogeneraroles,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogeneraroles.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogeneraroles.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesogeneraroles.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoGeneraRoles="";
	
	public String getsFinalQueryProcesoGeneraRoles() {
		return this.sFinalQueryProcesoGeneraRoles;
	}
	
	public void setsFinalQueryProcesoGeneraRoles(String sFinalQueryProcesoGeneraRoles) {
		this.sFinalQueryProcesoGeneraRoles= sFinalQueryProcesoGeneraRoles;
	}
	
	public Border resaltarSeleccionarProcesoGeneraRoles=null;
	
	public Border setResaltarSeleccionarProcesoGeneraRoles(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGeneraRolesBeanSwingJInternalFrame procesogenerarolesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesogenerarolesBeanSwingJInternalFrame.jTtoolBarProcesoGeneraRoles.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoGeneraRoles= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoGeneraRoles() {
		return this.resaltarSeleccionarProcesoGeneraRoles;
	}
	
	public void setResaltarSeleccionarProcesoGeneraRoles(Border borderResaltarSeleccionarProcesoGeneraRoles) {
		this.resaltarSeleccionarProcesoGeneraRoles= borderResaltarSeleccionarProcesoGeneraRoles;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoGeneraRoles=null;
	public Boolean mostraridProcesoGeneraRoles=true;
	public Boolean activaridProcesoGeneraRoles=true;

	public Border resaltarid_mesProcesoGeneraRoles=null;
	public Boolean mostrarid_mesProcesoGeneraRoles=true;
	public Boolean activarid_mesProcesoGeneraRoles=true;
	public Boolean cargarid_mesProcesoGeneraRoles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesProcesoGeneraRoles=false;//ConEventDepend=true

	public Border resaltarid_estructuraProcesoGeneraRoles=null;
	public Boolean mostrarid_estructuraProcesoGeneraRoles=true;
	public Boolean activarid_estructuraProcesoGeneraRoles=true;
	public Boolean cargarid_estructuraProcesoGeneraRoles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraProcesoGeneraRoles=false;//ConEventDepend=true

	public Border resaltarid_empleadoProcesoGeneraRoles=null;
	public Boolean mostrarid_empleadoProcesoGeneraRoles=true;
	public Boolean activarid_empleadoProcesoGeneraRoles=true;
	public Boolean cargarid_empleadoProcesoGeneraRoles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoProcesoGeneraRoles=false;//ConEventDepend=true

	
	

	public Border setResaltaridProcesoGeneraRoles(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGeneraRolesBeanSwingJInternalFrame procesogenerarolesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarolesBeanSwingJInternalFrame.jTtoolBarProcesoGeneraRoles.setBorder(borderResaltar);
		
		this.resaltaridProcesoGeneraRoles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoGeneraRoles() {
		return this.resaltaridProcesoGeneraRoles;
	}

	public void setResaltaridProcesoGeneraRoles(Border borderResaltar) {
		this.resaltaridProcesoGeneraRoles= borderResaltar;
	}

	public Boolean getMostraridProcesoGeneraRoles() {
		return this.mostraridProcesoGeneraRoles;
	}

	public void setMostraridProcesoGeneraRoles(Boolean mostraridProcesoGeneraRoles) {
		this.mostraridProcesoGeneraRoles= mostraridProcesoGeneraRoles;
	}

	public Boolean getActivaridProcesoGeneraRoles() {
		return this.activaridProcesoGeneraRoles;
	}

	public void setActivaridProcesoGeneraRoles(Boolean activaridProcesoGeneraRoles) {
		this.activaridProcesoGeneraRoles= activaridProcesoGeneraRoles;
	}

	public Border setResaltarid_mesProcesoGeneraRoles(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGeneraRolesBeanSwingJInternalFrame procesogenerarolesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarolesBeanSwingJInternalFrame.jTtoolBarProcesoGeneraRoles.setBorder(borderResaltar);
		
		this.resaltarid_mesProcesoGeneraRoles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesProcesoGeneraRoles() {
		return this.resaltarid_mesProcesoGeneraRoles;
	}

	public void setResaltarid_mesProcesoGeneraRoles(Border borderResaltar) {
		this.resaltarid_mesProcesoGeneraRoles= borderResaltar;
	}

	public Boolean getMostrarid_mesProcesoGeneraRoles() {
		return this.mostrarid_mesProcesoGeneraRoles;
	}

	public void setMostrarid_mesProcesoGeneraRoles(Boolean mostrarid_mesProcesoGeneraRoles) {
		this.mostrarid_mesProcesoGeneraRoles= mostrarid_mesProcesoGeneraRoles;
	}

	public Boolean getActivarid_mesProcesoGeneraRoles() {
		return this.activarid_mesProcesoGeneraRoles;
	}

	public void setActivarid_mesProcesoGeneraRoles(Boolean activarid_mesProcesoGeneraRoles) {
		this.activarid_mesProcesoGeneraRoles= activarid_mesProcesoGeneraRoles;
	}

	public Boolean getCargarid_mesProcesoGeneraRoles() {
		return this.cargarid_mesProcesoGeneraRoles;
	}

	public void setCargarid_mesProcesoGeneraRoles(Boolean cargarid_mesProcesoGeneraRoles) {
		this.cargarid_mesProcesoGeneraRoles= cargarid_mesProcesoGeneraRoles;
	}

	public Border setResaltarid_estructuraProcesoGeneraRoles(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGeneraRolesBeanSwingJInternalFrame procesogenerarolesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarolesBeanSwingJInternalFrame.jTtoolBarProcesoGeneraRoles.setBorder(borderResaltar);
		
		this.resaltarid_estructuraProcesoGeneraRoles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraProcesoGeneraRoles() {
		return this.resaltarid_estructuraProcesoGeneraRoles;
	}

	public void setResaltarid_estructuraProcesoGeneraRoles(Border borderResaltar) {
		this.resaltarid_estructuraProcesoGeneraRoles= borderResaltar;
	}

	public Boolean getMostrarid_estructuraProcesoGeneraRoles() {
		return this.mostrarid_estructuraProcesoGeneraRoles;
	}

	public void setMostrarid_estructuraProcesoGeneraRoles(Boolean mostrarid_estructuraProcesoGeneraRoles) {
		this.mostrarid_estructuraProcesoGeneraRoles= mostrarid_estructuraProcesoGeneraRoles;
	}

	public Boolean getActivarid_estructuraProcesoGeneraRoles() {
		return this.activarid_estructuraProcesoGeneraRoles;
	}

	public void setActivarid_estructuraProcesoGeneraRoles(Boolean activarid_estructuraProcesoGeneraRoles) {
		this.activarid_estructuraProcesoGeneraRoles= activarid_estructuraProcesoGeneraRoles;
	}

	public Boolean getCargarid_estructuraProcesoGeneraRoles() {
		return this.cargarid_estructuraProcesoGeneraRoles;
	}

	public void setCargarid_estructuraProcesoGeneraRoles(Boolean cargarid_estructuraProcesoGeneraRoles) {
		this.cargarid_estructuraProcesoGeneraRoles= cargarid_estructuraProcesoGeneraRoles;
	}

	public Border setResaltarid_empleadoProcesoGeneraRoles(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGeneraRolesBeanSwingJInternalFrame procesogenerarolesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesogenerarolesBeanSwingJInternalFrame.jTtoolBarProcesoGeneraRoles.setBorder(borderResaltar);
		
		this.resaltarid_empleadoProcesoGeneraRoles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoProcesoGeneraRoles() {
		return this.resaltarid_empleadoProcesoGeneraRoles;
	}

	public void setResaltarid_empleadoProcesoGeneraRoles(Border borderResaltar) {
		this.resaltarid_empleadoProcesoGeneraRoles= borderResaltar;
	}

	public Boolean getMostrarid_empleadoProcesoGeneraRoles() {
		return this.mostrarid_empleadoProcesoGeneraRoles;
	}

	public void setMostrarid_empleadoProcesoGeneraRoles(Boolean mostrarid_empleadoProcesoGeneraRoles) {
		this.mostrarid_empleadoProcesoGeneraRoles= mostrarid_empleadoProcesoGeneraRoles;
	}

	public Boolean getActivarid_empleadoProcesoGeneraRoles() {
		return this.activarid_empleadoProcesoGeneraRoles;
	}

	public void setActivarid_empleadoProcesoGeneraRoles(Boolean activarid_empleadoProcesoGeneraRoles) {
		this.activarid_empleadoProcesoGeneraRoles= activarid_empleadoProcesoGeneraRoles;
	}

	public Boolean getCargarid_empleadoProcesoGeneraRoles() {
		return this.cargarid_empleadoProcesoGeneraRoles;
	}

	public void setCargarid_empleadoProcesoGeneraRoles(Boolean cargarid_empleadoProcesoGeneraRoles) {
		this.cargarid_empleadoProcesoGeneraRoles= cargarid_empleadoProcesoGeneraRoles;
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
		
		
		this.setMostraridProcesoGeneraRoles(esInicial);
		this.setMostrarid_mesProcesoGeneraRoles(esInicial);
		this.setMostrarid_estructuraProcesoGeneraRoles(esInicial);
		this.setMostrarid_empleadoProcesoGeneraRoles(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.ID)) {
				this.setMostraridProcesoGeneraRoles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.IDMES)) {
				this.setMostrarid_mesProcesoGeneraRoles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraProcesoGeneraRoles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoProcesoGeneraRoles(esAsigna);
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
		
		
		this.setActivaridProcesoGeneraRoles(esInicial);
		this.setActivarid_mesProcesoGeneraRoles(esInicial);
		this.setActivarid_estructuraProcesoGeneraRoles(esInicial);
		this.setActivarid_empleadoProcesoGeneraRoles(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.ID)) {
				this.setActivaridProcesoGeneraRoles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.IDMES)) {
				this.setActivarid_mesProcesoGeneraRoles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraProcesoGeneraRoles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoProcesoGeneraRoles(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoGeneraRolesBeanSwingJInternalFrame procesogenerarolesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoGeneraRoles(esInicial);
		this.setResaltarid_mesProcesoGeneraRoles(esInicial);
		this.setResaltarid_estructuraProcesoGeneraRoles(esInicial);
		this.setResaltarid_empleadoProcesoGeneraRoles(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.ID)) {
				this.setResaltaridProcesoGeneraRoles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.IDMES)) {
				this.setResaltarid_mesProcesoGeneraRoles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraProcesoGeneraRoles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoGeneraRolesConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoProcesoGeneraRoles(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoGeneraRolesBeanSwingJInternalFrame procesogenerarolesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoGeneraRolesProcesoGeneraRoles=true;

	public Boolean getMostrarBusquedaProcesoGeneraRolesProcesoGeneraRoles() {
		return this.mostrarBusquedaProcesoGeneraRolesProcesoGeneraRoles;
	}

	public void setMostrarBusquedaProcesoGeneraRolesProcesoGeneraRoles(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoGeneraRolesProcesoGeneraRoles= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoGeneraRolesProcesoGeneraRoles=true;

	public Boolean getActivarBusquedaProcesoGeneraRolesProcesoGeneraRoles() {
		return this.activarBusquedaProcesoGeneraRolesProcesoGeneraRoles;
	}

	public void setActivarBusquedaProcesoGeneraRolesProcesoGeneraRoles(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoGeneraRolesProcesoGeneraRoles= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoGeneraRolesProcesoGeneraRoles=null;

	public Border getResaltarBusquedaProcesoGeneraRolesProcesoGeneraRoles() {
		return this.resaltarBusquedaProcesoGeneraRolesProcesoGeneraRoles;
	}

	public void setResaltarBusquedaProcesoGeneraRolesProcesoGeneraRoles(Border borderResaltar) {
		this.resaltarBusquedaProcesoGeneraRolesProcesoGeneraRoles= borderResaltar;
	}

	public void setResaltarBusquedaProcesoGeneraRolesProcesoGeneraRoles(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoGeneraRolesBeanSwingJInternalFrame procesogenerarolesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoGeneraRolesProcesoGeneraRoles= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}