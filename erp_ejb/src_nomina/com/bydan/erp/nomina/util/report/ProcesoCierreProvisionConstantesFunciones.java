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

import com.bydan.erp.nomina.util.report.ProcesoCierreProvisionConstantesFunciones;
import com.bydan.erp.nomina.util.report.ProcesoCierreProvisionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.ProcesoCierreProvisionParameterGeneral;

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
final public class ProcesoCierreProvisionConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoCierreProvision";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoCierreProvision"+ProcesoCierreProvisionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoCierreProvisionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoCierreProvisionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoCierreProvisionConstantesFunciones.SCHEMA+"_"+ProcesoCierreProvisionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCierreProvisionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoCierreProvisionConstantesFunciones.SCHEMA+"_"+ProcesoCierreProvisionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoCierreProvisionConstantesFunciones.SCHEMA+"_"+ProcesoCierreProvisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCierreProvisionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoCierreProvisionConstantesFunciones.SCHEMA+"_"+ProcesoCierreProvisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreProvisionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCierreProvisionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreProvisionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreProvisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCierreProvisionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreProvisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoCierreProvisionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoCierreProvisionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoCierreProvisionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoCierreProvisionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Cierre Provisiones";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Cierre Provision";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Cierre Provision";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoCierreProvision";
	public static final String OBJECTNAME="procesocierreprovision";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="proceso_cierre_provision";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesocierreprovision from "+ProcesoCierreProvisionConstantesFunciones.SPERSISTENCENAME+" procesocierreprovision";
	public static String QUERYSELECTNATIVE="select "+ProcesoCierreProvisionConstantesFunciones.SCHEMA+"."+ProcesoCierreProvisionConstantesFunciones.TABLENAME+".id,"+ProcesoCierreProvisionConstantesFunciones.SCHEMA+"."+ProcesoCierreProvisionConstantesFunciones.TABLENAME+".version_row,"+ProcesoCierreProvisionConstantesFunciones.SCHEMA+"."+ProcesoCierreProvisionConstantesFunciones.TABLENAME+".id_anio,"+ProcesoCierreProvisionConstantesFunciones.SCHEMA+"."+ProcesoCierreProvisionConstantesFunciones.TABLENAME+".id_estructura,"+ProcesoCierreProvisionConstantesFunciones.SCHEMA+"."+ProcesoCierreProvisionConstantesFunciones.TABLENAME+".id_empleado,"+ProcesoCierreProvisionConstantesFunciones.SCHEMA+"."+ProcesoCierreProvisionConstantesFunciones.TABLENAME+".id_defi_provision_empleado from "+ProcesoCierreProvisionConstantesFunciones.SCHEMA+"."+ProcesoCierreProvisionConstantesFunciones.TABLENAME;//+" as "+ProcesoCierreProvisionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDANIO= "id_anio";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDDEFIPROVISIONEMPLEADO= "id_defi_provision_empleado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDDEFIPROVISIONEMPLEADO= "Defi Provision Empleado";
		public static final String LABEL_IDDEFIPROVISIONEMPLEADO_LOWER= "Defi Provision Empleado";
	
		
		
		
		
		
		
	
	public static String getProcesoCierreProvisionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoCierreProvisionConstantesFunciones.IDANIO)) {sLabelColumna=ProcesoCierreProvisionConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ProcesoCierreProvisionConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=ProcesoCierreProvisionConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(ProcesoCierreProvisionConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ProcesoCierreProvisionConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ProcesoCierreProvisionConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {sLabelColumna=ProcesoCierreProvisionConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getProcesoCierreProvisionDescripcion(ProcesoCierreProvision procesocierreprovision) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesocierreprovision !=null/* && procesocierreprovision.getId()!=0*/) {
			if(procesocierreprovision.getId()!=null) {
				sDescripcion=procesocierreprovision.getId().toString();
			}//procesocierreprovisionprocesocierreprovision.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoCierreProvisionDescripcionDetallado(ProcesoCierreProvision procesocierreprovision) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoCierreProvisionConstantesFunciones.ID+"=";
		sDescripcion+=procesocierreprovision.getId().toString()+",";
		sDescripcion+=ProcesoCierreProvisionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesocierreprovision.getVersionRow().toString()+",";
		sDescripcion+=ProcesoCierreProvisionConstantesFunciones.IDANIO+"=";
		sDescripcion+=procesocierreprovision.getid_anio().toString()+",";
		sDescripcion+=ProcesoCierreProvisionConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=procesocierreprovision.getid_estructura().toString()+",";
		sDescripcion+=ProcesoCierreProvisionConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=procesocierreprovision.getid_empleado().toString()+",";
		sDescripcion+=ProcesoCierreProvisionConstantesFunciones.IDDEFIPROVISIONEMPLEADO+"=";
		sDescripcion+=procesocierreprovision.getid_defi_provision_empleado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoCierreProvisionDescripcion(ProcesoCierreProvision procesocierreprovision,String sValor) throws Exception {			
		if(procesocierreprovision !=null) {
			//procesocierreprovisionprocesocierreprovision.getId().toString();
		}		
	}
	
		

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
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

	public static String getDefiProvisionEmpleadoDescripcion(DefiProvisionEmpleado defiprovisionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(defiprovisionempleado!=null/*&&defiprovisionempleado.getId()>0*/) {
			sDescripcion=DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoDescripcion(defiprovisionempleado);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoCierreProvision")) {
			sNombreIndice="Tipo=  Por Anio Por Estructura Por Empleado Por Defi Provision Empleado";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdDefiProvisionEmpleado")) {
			sNombreIndice="Tipo=  Por Defi Provision Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoCierreProvision(Long id_anio,Long id_estructura,Long id_empleado,Long id_defi_provision_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();}
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();}
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();}
		if(id_defi_provision_empleado!=null) {sDetalleIndice+=" Codigo Unico De Defi Provision Empleado="+id_defi_provision_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDefiProvisionEmpleado(Long id_defi_provision_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_defi_provision_empleado!=null) {sDetalleIndice+=" Codigo Unico De Defi Provision Empleado="+id_defi_provision_empleado.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProcesoCierreProvision(ProcesoCierreProvision procesocierreprovision,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoCierreProvisions(List<ProcesoCierreProvision> procesocierreprovisions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCierreProvision procesocierreprovision: procesocierreprovisions) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCierreProvision(ProcesoCierreProvision procesocierreprovision,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesocierreprovision.getConCambioAuxiliar()) {
			procesocierreprovision.setIsDeleted(procesocierreprovision.getIsDeletedAuxiliar());	
			procesocierreprovision.setIsNew(procesocierreprovision.getIsNewAuxiliar());	
			procesocierreprovision.setIsChanged(procesocierreprovision.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesocierreprovision.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesocierreprovision.setIsDeletedAuxiliar(false);	
			procesocierreprovision.setIsNewAuxiliar(false);	
			procesocierreprovision.setIsChangedAuxiliar(false);
			
			procesocierreprovision.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCierreProvisions(List<ProcesoCierreProvision> procesocierreprovisions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoCierreProvision procesocierreprovision : procesocierreprovisions) {
			if(conAsignarBase && procesocierreprovision.getConCambioAuxiliar()) {
				procesocierreprovision.setIsDeleted(procesocierreprovision.getIsDeletedAuxiliar());	
				procesocierreprovision.setIsNew(procesocierreprovision.getIsNewAuxiliar());	
				procesocierreprovision.setIsChanged(procesocierreprovision.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesocierreprovision.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesocierreprovision.setIsDeletedAuxiliar(false);	
				procesocierreprovision.setIsNewAuxiliar(false);	
				procesocierreprovision.setIsChangedAuxiliar(false);
				
				procesocierreprovision.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoCierreProvision(ProcesoCierreProvision procesocierreprovision,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoCierreProvisions(List<ProcesoCierreProvision> procesocierreprovisions,Boolean conEnteros) throws Exception  {
		
		for(ProcesoCierreProvision procesocierreprovision: procesocierreprovisions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoCierreProvision(List<ProcesoCierreProvision> procesocierreprovisions,ProcesoCierreProvision procesocierreprovisionAux) throws Exception  {
		ProcesoCierreProvisionConstantesFunciones.InicializarValoresProcesoCierreProvision(procesocierreprovisionAux,true);
		
		for(ProcesoCierreProvision procesocierreprovision: procesocierreprovisions) {
			if(procesocierreprovision.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCierreProvision(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoCierreProvisionConstantesFunciones.getArrayColumnasGlobalesProcesoCierreProvision(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCierreProvision(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoCierreProvision(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCierreProvision> procesocierreprovisions,ProcesoCierreProvision procesocierreprovision,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCierreProvision procesocierreprovisionAux: procesocierreprovisions) {
			if(procesocierreprovisionAux!=null && procesocierreprovision!=null) {
				if((procesocierreprovisionAux.getId()==null && procesocierreprovision.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesocierreprovisionAux.getId()!=null && procesocierreprovision.getId()!=null){
					if(procesocierreprovisionAux.getId().equals(procesocierreprovision.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCierreProvision(List<ProcesoCierreProvision> procesocierreprovisions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoCierreProvision procesocierreprovision: procesocierreprovisions) {			
			if(procesocierreprovision.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoCierreProvision() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoCierreProvision() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreProvision() throws Exception  {
		return ProcesoCierreProvisionConstantesFunciones.getTiposSeleccionarProcesoCierreProvision(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreProvision(Boolean conFk) throws Exception  {
		return ProcesoCierreProvisionConstantesFunciones.getTiposSeleccionarProcesoCierreProvision(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreProvision(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreProvisionConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ProcesoCierreProvisionConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreProvisionConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(ProcesoCierreProvisionConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreProvisionConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ProcesoCierreProvisionConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreProvisionConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO);
			reporte.setsDescripcion(ProcesoCierreProvisionConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoCierreProvision(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCierreProvision(ProcesoCierreProvision procesocierreprovisionAux) throws Exception {
		
			procesocierreprovisionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesocierreprovisionAux.getAnio()));
			procesocierreprovisionAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(procesocierreprovisionAux.getEstructura()));
			procesocierreprovisionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(procesocierreprovisionAux.getEmpleado()));
			procesocierreprovisionAux.setdefiprovisionempleado_descripcion(DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoDescripcion(procesocierreprovisionAux.getDefiProvisionEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCierreProvision(List<ProcesoCierreProvision> procesocierreprovisionsTemp) throws Exception {
		for(ProcesoCierreProvision procesocierreprovisionAux:procesocierreprovisionsTemp) {
			
			procesocierreprovisionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(procesocierreprovisionAux.getAnio()));
			procesocierreprovisionAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(procesocierreprovisionAux.getEstructura()));
			procesocierreprovisionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(procesocierreprovisionAux.getEmpleado()));
			procesocierreprovisionAux.setdefiprovisionempleado_descripcion(DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoDescripcion(procesocierreprovisionAux.getDefiProvisionEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoCierreProvision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(DefiProvisionEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(DefiProvisionEmpleado.class)) {
						classes.add(new Classe(DefiProvisionEmpleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoCierreProvision(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(DefiProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DefiProvisionEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(DefiProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DefiProvisionEmpleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCierreProvision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCierreProvisionConstantesFunciones.getClassesRelationshipsOfProcesoCierreProvision(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCierreProvision(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCierreProvision(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCierreProvisionConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoCierreProvision(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCierreProvision(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoCierreProvision procesocierreprovision,List<ProcesoCierreProvision> procesocierreprovisions,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoCierreProvision procesocierreprovision,List<ProcesoCierreProvision> procesocierreprovisions) throws Exception {
		try	{			
			for(ProcesoCierreProvision procesocierreprovisionLocal:procesocierreprovisions) {
				if(procesocierreprovisionLocal.getId().equals(procesocierreprovision.getId())) {
					procesocierreprovisionLocal.setIsSelected(procesocierreprovision.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoCierreProvision(List<ProcesoCierreProvision> procesocierreprovisionsAux) throws Exception {
		//this.procesocierreprovisionsAux=procesocierreprovisionsAux;
		
		for(ProcesoCierreProvision procesocierreprovisionAux:procesocierreprovisionsAux) {
			if(procesocierreprovisionAux.getIsChanged()) {
				procesocierreprovisionAux.setIsChanged(false);
			}		
			
			if(procesocierreprovisionAux.getIsNew()) {
				procesocierreprovisionAux.setIsNew(false);
			}	
			
			if(procesocierreprovisionAux.getIsDeleted()) {
				procesocierreprovisionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoCierreProvision(ProcesoCierreProvision procesocierreprovisionAux) throws Exception {
		//this.procesocierreprovisionAux=procesocierreprovisionAux;
		
			if(procesocierreprovisionAux.getIsChanged()) {
				procesocierreprovisionAux.setIsChanged(false);
			}		
			
			if(procesocierreprovisionAux.getIsNew()) {
				procesocierreprovisionAux.setIsNew(false);
			}	
			
			if(procesocierreprovisionAux.getIsDeleted()) {
				procesocierreprovisionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoCierreProvision procesocierreprovisionAsignar,ProcesoCierreProvision procesocierreprovision) throws Exception {
		procesocierreprovisionAsignar.setId(procesocierreprovision.getId());	
		procesocierreprovisionAsignar.setVersionRow(procesocierreprovision.getVersionRow());	
		procesocierreprovisionAsignar.setid_anio(procesocierreprovision.getid_anio());
		procesocierreprovisionAsignar.setanio_descripcion(procesocierreprovision.getanio_descripcion());	
		procesocierreprovisionAsignar.setid_estructura(procesocierreprovision.getid_estructura());
		procesocierreprovisionAsignar.setestructura_descripcion(procesocierreprovision.getestructura_descripcion());	
		procesocierreprovisionAsignar.setid_empleado(procesocierreprovision.getid_empleado());
		procesocierreprovisionAsignar.setempleado_descripcion(procesocierreprovision.getempleado_descripcion());	
		procesocierreprovisionAsignar.setid_defi_provision_empleado(procesocierreprovision.getid_defi_provision_empleado());
		procesocierreprovisionAsignar.setdefiprovisionempleado_descripcion(procesocierreprovision.getdefiprovisionempleado_descripcion());	
	}
	
	public static void inicializarProcesoCierreProvision(ProcesoCierreProvision procesocierreprovision) throws Exception {
		try {
				procesocierreprovision.setId(0L);	
					
				procesocierreprovision.setid_anio(null);	
				procesocierreprovision.setid_estructura(-1L);	
				procesocierreprovision.setid_empleado(-1L);	
				procesocierreprovision.setid_defi_provision_empleado(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoCierreProvision(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreProvisionConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreProvisionConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreProvisionConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreProvisionConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoCierreProvision(String sTipo,Row row,Workbook workbook,ProcesoCierreProvision procesocierreprovision,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierreprovision.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierreprovision.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierreprovision.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierreprovision.getdefiprovisionempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoCierreProvision="";
	
	public String getsFinalQueryProcesoCierreProvision() {
		return this.sFinalQueryProcesoCierreProvision;
	}
	
	public void setsFinalQueryProcesoCierreProvision(String sFinalQueryProcesoCierreProvision) {
		this.sFinalQueryProcesoCierreProvision= sFinalQueryProcesoCierreProvision;
	}
	
	public Border resaltarSeleccionarProcesoCierreProvision=null;
	
	public Border setResaltarSeleccionarProcesoCierreProvision(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreProvisionBeanSwingJInternalFrame procesocierreprovisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesocierreprovisionBeanSwingJInternalFrame.jTtoolBarProcesoCierreProvision.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoCierreProvision= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoCierreProvision() {
		return this.resaltarSeleccionarProcesoCierreProvision;
	}
	
	public void setResaltarSeleccionarProcesoCierreProvision(Border borderResaltarSeleccionarProcesoCierreProvision) {
		this.resaltarSeleccionarProcesoCierreProvision= borderResaltarSeleccionarProcesoCierreProvision;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoCierreProvision=null;
	public Boolean mostraridProcesoCierreProvision=true;
	public Boolean activaridProcesoCierreProvision=true;

	public Border resaltarid_anioProcesoCierreProvision=null;
	public Boolean mostrarid_anioProcesoCierreProvision=true;
	public Boolean activarid_anioProcesoCierreProvision=true;
	public Boolean cargarid_anioProcesoCierreProvision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioProcesoCierreProvision=false;//ConEventDepend=true

	public Border resaltarid_estructuraProcesoCierreProvision=null;
	public Boolean mostrarid_estructuraProcesoCierreProvision=true;
	public Boolean activarid_estructuraProcesoCierreProvision=true;
	public Boolean cargarid_estructuraProcesoCierreProvision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraProcesoCierreProvision=false;//ConEventDepend=true

	public Border resaltarid_empleadoProcesoCierreProvision=null;
	public Boolean mostrarid_empleadoProcesoCierreProvision=true;
	public Boolean activarid_empleadoProcesoCierreProvision=true;
	public Boolean cargarid_empleadoProcesoCierreProvision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoProcesoCierreProvision=false;//ConEventDepend=true

	public Border resaltarid_defi_provision_empleadoProcesoCierreProvision=null;
	public Boolean mostrarid_defi_provision_empleadoProcesoCierreProvision=true;
	public Boolean activarid_defi_provision_empleadoProcesoCierreProvision=true;
	public Boolean cargarid_defi_provision_empleadoProcesoCierreProvision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_defi_provision_empleadoProcesoCierreProvision=false;//ConEventDepend=true

	
	

	public Border setResaltaridProcesoCierreProvision(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreProvisionBeanSwingJInternalFrame procesocierreprovisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreprovisionBeanSwingJInternalFrame.jTtoolBarProcesoCierreProvision.setBorder(borderResaltar);
		
		this.resaltaridProcesoCierreProvision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoCierreProvision() {
		return this.resaltaridProcesoCierreProvision;
	}

	public void setResaltaridProcesoCierreProvision(Border borderResaltar) {
		this.resaltaridProcesoCierreProvision= borderResaltar;
	}

	public Boolean getMostraridProcesoCierreProvision() {
		return this.mostraridProcesoCierreProvision;
	}

	public void setMostraridProcesoCierreProvision(Boolean mostraridProcesoCierreProvision) {
		this.mostraridProcesoCierreProvision= mostraridProcesoCierreProvision;
	}

	public Boolean getActivaridProcesoCierreProvision() {
		return this.activaridProcesoCierreProvision;
	}

	public void setActivaridProcesoCierreProvision(Boolean activaridProcesoCierreProvision) {
		this.activaridProcesoCierreProvision= activaridProcesoCierreProvision;
	}

	public Border setResaltarid_anioProcesoCierreProvision(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreProvisionBeanSwingJInternalFrame procesocierreprovisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreprovisionBeanSwingJInternalFrame.jTtoolBarProcesoCierreProvision.setBorder(borderResaltar);
		
		this.resaltarid_anioProcesoCierreProvision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioProcesoCierreProvision() {
		return this.resaltarid_anioProcesoCierreProvision;
	}

	public void setResaltarid_anioProcesoCierreProvision(Border borderResaltar) {
		this.resaltarid_anioProcesoCierreProvision= borderResaltar;
	}

	public Boolean getMostrarid_anioProcesoCierreProvision() {
		return this.mostrarid_anioProcesoCierreProvision;
	}

	public void setMostrarid_anioProcesoCierreProvision(Boolean mostrarid_anioProcesoCierreProvision) {
		this.mostrarid_anioProcesoCierreProvision= mostrarid_anioProcesoCierreProvision;
	}

	public Boolean getActivarid_anioProcesoCierreProvision() {
		return this.activarid_anioProcesoCierreProvision;
	}

	public void setActivarid_anioProcesoCierreProvision(Boolean activarid_anioProcesoCierreProvision) {
		this.activarid_anioProcesoCierreProvision= activarid_anioProcesoCierreProvision;
	}

	public Boolean getCargarid_anioProcesoCierreProvision() {
		return this.cargarid_anioProcesoCierreProvision;
	}

	public void setCargarid_anioProcesoCierreProvision(Boolean cargarid_anioProcesoCierreProvision) {
		this.cargarid_anioProcesoCierreProvision= cargarid_anioProcesoCierreProvision;
	}

	public Border setResaltarid_estructuraProcesoCierreProvision(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreProvisionBeanSwingJInternalFrame procesocierreprovisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreprovisionBeanSwingJInternalFrame.jTtoolBarProcesoCierreProvision.setBorder(borderResaltar);
		
		this.resaltarid_estructuraProcesoCierreProvision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraProcesoCierreProvision() {
		return this.resaltarid_estructuraProcesoCierreProvision;
	}

	public void setResaltarid_estructuraProcesoCierreProvision(Border borderResaltar) {
		this.resaltarid_estructuraProcesoCierreProvision= borderResaltar;
	}

	public Boolean getMostrarid_estructuraProcesoCierreProvision() {
		return this.mostrarid_estructuraProcesoCierreProvision;
	}

	public void setMostrarid_estructuraProcesoCierreProvision(Boolean mostrarid_estructuraProcesoCierreProvision) {
		this.mostrarid_estructuraProcesoCierreProvision= mostrarid_estructuraProcesoCierreProvision;
	}

	public Boolean getActivarid_estructuraProcesoCierreProvision() {
		return this.activarid_estructuraProcesoCierreProvision;
	}

	public void setActivarid_estructuraProcesoCierreProvision(Boolean activarid_estructuraProcesoCierreProvision) {
		this.activarid_estructuraProcesoCierreProvision= activarid_estructuraProcesoCierreProvision;
	}

	public Boolean getCargarid_estructuraProcesoCierreProvision() {
		return this.cargarid_estructuraProcesoCierreProvision;
	}

	public void setCargarid_estructuraProcesoCierreProvision(Boolean cargarid_estructuraProcesoCierreProvision) {
		this.cargarid_estructuraProcesoCierreProvision= cargarid_estructuraProcesoCierreProvision;
	}

	public Border setResaltarid_empleadoProcesoCierreProvision(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreProvisionBeanSwingJInternalFrame procesocierreprovisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreprovisionBeanSwingJInternalFrame.jTtoolBarProcesoCierreProvision.setBorder(borderResaltar);
		
		this.resaltarid_empleadoProcesoCierreProvision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoProcesoCierreProvision() {
		return this.resaltarid_empleadoProcesoCierreProvision;
	}

	public void setResaltarid_empleadoProcesoCierreProvision(Border borderResaltar) {
		this.resaltarid_empleadoProcesoCierreProvision= borderResaltar;
	}

	public Boolean getMostrarid_empleadoProcesoCierreProvision() {
		return this.mostrarid_empleadoProcesoCierreProvision;
	}

	public void setMostrarid_empleadoProcesoCierreProvision(Boolean mostrarid_empleadoProcesoCierreProvision) {
		this.mostrarid_empleadoProcesoCierreProvision= mostrarid_empleadoProcesoCierreProvision;
	}

	public Boolean getActivarid_empleadoProcesoCierreProvision() {
		return this.activarid_empleadoProcesoCierreProvision;
	}

	public void setActivarid_empleadoProcesoCierreProvision(Boolean activarid_empleadoProcesoCierreProvision) {
		this.activarid_empleadoProcesoCierreProvision= activarid_empleadoProcesoCierreProvision;
	}

	public Boolean getCargarid_empleadoProcesoCierreProvision() {
		return this.cargarid_empleadoProcesoCierreProvision;
	}

	public void setCargarid_empleadoProcesoCierreProvision(Boolean cargarid_empleadoProcesoCierreProvision) {
		this.cargarid_empleadoProcesoCierreProvision= cargarid_empleadoProcesoCierreProvision;
	}

	public Border setResaltarid_defi_provision_empleadoProcesoCierreProvision(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreProvisionBeanSwingJInternalFrame procesocierreprovisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierreprovisionBeanSwingJInternalFrame.jTtoolBarProcesoCierreProvision.setBorder(borderResaltar);
		
		this.resaltarid_defi_provision_empleadoProcesoCierreProvision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_defi_provision_empleadoProcesoCierreProvision() {
		return this.resaltarid_defi_provision_empleadoProcesoCierreProvision;
	}

	public void setResaltarid_defi_provision_empleadoProcesoCierreProvision(Border borderResaltar) {
		this.resaltarid_defi_provision_empleadoProcesoCierreProvision= borderResaltar;
	}

	public Boolean getMostrarid_defi_provision_empleadoProcesoCierreProvision() {
		return this.mostrarid_defi_provision_empleadoProcesoCierreProvision;
	}

	public void setMostrarid_defi_provision_empleadoProcesoCierreProvision(Boolean mostrarid_defi_provision_empleadoProcesoCierreProvision) {
		this.mostrarid_defi_provision_empleadoProcesoCierreProvision= mostrarid_defi_provision_empleadoProcesoCierreProvision;
	}

	public Boolean getActivarid_defi_provision_empleadoProcesoCierreProvision() {
		return this.activarid_defi_provision_empleadoProcesoCierreProvision;
	}

	public void setActivarid_defi_provision_empleadoProcesoCierreProvision(Boolean activarid_defi_provision_empleadoProcesoCierreProvision) {
		this.activarid_defi_provision_empleadoProcesoCierreProvision= activarid_defi_provision_empleadoProcesoCierreProvision;
	}

	public Boolean getCargarid_defi_provision_empleadoProcesoCierreProvision() {
		return this.cargarid_defi_provision_empleadoProcesoCierreProvision;
	}

	public void setCargarid_defi_provision_empleadoProcesoCierreProvision(Boolean cargarid_defi_provision_empleadoProcesoCierreProvision) {
		this.cargarid_defi_provision_empleadoProcesoCierreProvision= cargarid_defi_provision_empleadoProcesoCierreProvision;
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
		
		
		this.setMostraridProcesoCierreProvision(esInicial);
		this.setMostrarid_anioProcesoCierreProvision(esInicial);
		this.setMostrarid_estructuraProcesoCierreProvision(esInicial);
		this.setMostrarid_empleadoProcesoCierreProvision(esInicial);
		this.setMostrarid_defi_provision_empleadoProcesoCierreProvision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.ID)) {
				this.setMostraridProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {
				this.setMostrarid_defi_provision_empleadoProcesoCierreProvision(esAsigna);
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
		
		
		this.setActivaridProcesoCierreProvision(esInicial);
		this.setActivarid_anioProcesoCierreProvision(esInicial);
		this.setActivarid_estructuraProcesoCierreProvision(esInicial);
		this.setActivarid_empleadoProcesoCierreProvision(esInicial);
		this.setActivarid_defi_provision_empleadoProcesoCierreProvision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.ID)) {
				this.setActivaridProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDANIO)) {
				this.setActivarid_anioProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {
				this.setActivarid_defi_provision_empleadoProcesoCierreProvision(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCierreProvisionBeanSwingJInternalFrame procesocierreprovisionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoCierreProvision(esInicial);
		this.setResaltarid_anioProcesoCierreProvision(esInicial);
		this.setResaltarid_estructuraProcesoCierreProvision(esInicial);
		this.setResaltarid_empleadoProcesoCierreProvision(esInicial);
		this.setResaltarid_defi_provision_empleadoProcesoCierreProvision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.ID)) {
				this.setResaltaridProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoProcesoCierreProvision(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreProvisionConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {
				this.setResaltarid_defi_provision_empleadoProcesoCierreProvision(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCierreProvisionBeanSwingJInternalFrame procesocierreprovisionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoCierreProvisionProcesoCierreProvision=true;

	public Boolean getMostrarBusquedaProcesoCierreProvisionProcesoCierreProvision() {
		return this.mostrarBusquedaProcesoCierreProvisionProcesoCierreProvision;
	}

	public void setMostrarBusquedaProcesoCierreProvisionProcesoCierreProvision(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoCierreProvisionProcesoCierreProvision= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoCierreProvisionProcesoCierreProvision=true;

	public Boolean getActivarBusquedaProcesoCierreProvisionProcesoCierreProvision() {
		return this.activarBusquedaProcesoCierreProvisionProcesoCierreProvision;
	}

	public void setActivarBusquedaProcesoCierreProvisionProcesoCierreProvision(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoCierreProvisionProcesoCierreProvision= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoCierreProvisionProcesoCierreProvision=null;

	public Border getResaltarBusquedaProcesoCierreProvisionProcesoCierreProvision() {
		return this.resaltarBusquedaProcesoCierreProvisionProcesoCierreProvision;
	}

	public void setResaltarBusquedaProcesoCierreProvisionProcesoCierreProvision(Border borderResaltar) {
		this.resaltarBusquedaProcesoCierreProvisionProcesoCierreProvision= borderResaltar;
	}

	public void setResaltarBusquedaProcesoCierreProvisionProcesoCierreProvision(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreProvisionBeanSwingJInternalFrame procesocierreprovisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoCierreProvisionProcesoCierreProvision= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}