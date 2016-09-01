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


import com.bydan.erp.nomina.util.AsistenciaPorCentroCostoConstantesFunciones;
import com.bydan.erp.nomina.util.AsistenciaPorCentroCostoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.AsistenciaPorCentroCostoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AsistenciaPorCentroCostoConstantesFunciones extends AsistenciaPorCentroCostoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AsistenciaPorCentroCosto";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AsistenciaPorCentroCosto"+AsistenciaPorCentroCostoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AsistenciaPorCentroCostoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AsistenciaPorCentroCostoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"_"+AsistenciaPorCentroCostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AsistenciaPorCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"_"+AsistenciaPorCentroCostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"_"+AsistenciaPorCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AsistenciaPorCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"_"+AsistenciaPorCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaPorCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AsistenciaPorCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaPorCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaPorCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AsistenciaPorCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaPorCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AsistenciaPorCentroCostoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AsistenciaPorCentroCostoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AsistenciaPorCentroCostoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AsistenciaPorCentroCostoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Asistencia Por Centro Costos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Asistencia Por Centro Costo";
	public static final String SCLASSWEBTITULO_LOWER="Asistencia Por Centro Costo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AsistenciaPorCentroCosto";
	public static final String OBJECTNAME="asistenciaporcentrocosto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="asistencia_por_centro_costo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select asistenciaporcentrocosto from "+AsistenciaPorCentroCostoConstantesFunciones.SPERSISTENCENAME+" asistenciaporcentrocosto";
	public static String QUERYSELECTNATIVE="select "+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".id,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".version_row,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".id_empresa,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".id_centro_costo,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".id_empleado,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".fecha,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".porcentaje,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".valor_hora,"+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME+".permiso from "+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+"."+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME;//+" as "+AsistenciaPorCentroCostoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AsistenciaPorCentroCostoConstantesFuncionesAdditional asistenciaporcentrocostoConstantesFuncionesAdditional=null;
	
	public AsistenciaPorCentroCostoConstantesFuncionesAdditional getAsistenciaPorCentroCostoConstantesFuncionesAdditional() {
		return this.asistenciaporcentrocostoConstantesFuncionesAdditional;
	}
	
	public void setAsistenciaPorCentroCostoConstantesFuncionesAdditional(AsistenciaPorCentroCostoConstantesFuncionesAdditional asistenciaporcentrocostoConstantesFuncionesAdditional) {
		try {
			this.asistenciaporcentrocostoConstantesFuncionesAdditional=asistenciaporcentrocostoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String FECHA= "fecha";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALORHORA= "valor_hora";
    public static final String PERMISO= "permiso";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALORHORA= "Valor Hora";
		public static final String LABEL_VALORHORA_LOWER= "Valor Hora";
    	public static final String LABEL_PERMISO= "Permiso";
		public static final String LABEL_PERMISO_LOWER= "Permiso";
	
		
		
		
		
		
		
		
		
		
	
	public static String getAsistenciaPorCentroCostoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA)) {sLabelColumna=AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(AsistenciaPorCentroCostoConstantesFunciones.FECHA)) {sLabelColumna=AsistenciaPorCentroCostoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(AsistenciaPorCentroCostoConstantesFunciones.PORCENTAJE)) {sLabelColumna=AsistenciaPorCentroCostoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(AsistenciaPorCentroCostoConstantesFunciones.VALORHORA)) {sLabelColumna=AsistenciaPorCentroCostoConstantesFunciones.LABEL_VALORHORA;}
		if(sNombreColumna.equals(AsistenciaPorCentroCostoConstantesFunciones.PERMISO)) {sLabelColumna=AsistenciaPorCentroCostoConstantesFunciones.LABEL_PERMISO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getAsistenciaPorCentroCostoDescripcion(AsistenciaPorCentroCosto asistenciaporcentrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(asistenciaporcentrocosto !=null/* && asistenciaporcentrocosto.getId()!=0*/) {
			if(asistenciaporcentrocosto.getId()!=null) {
				sDescripcion=asistenciaporcentrocosto.getId().toString();
			}//asistenciaporcentrocostoasistenciaporcentrocosto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAsistenciaPorCentroCostoDescripcionDetallado(AsistenciaPorCentroCosto asistenciaporcentrocosto) {
		String sDescripcion="";
			
		sDescripcion+=AsistenciaPorCentroCostoConstantesFunciones.ID+"=";
		sDescripcion+=asistenciaporcentrocosto.getId().toString()+",";
		sDescripcion+=AsistenciaPorCentroCostoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=asistenciaporcentrocosto.getVersionRow().toString()+",";
		sDescripcion+=AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=asistenciaporcentrocosto.getid_empresa().toString()+",";
		sDescripcion+=AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=asistenciaporcentrocosto.getid_centro_costo().toString()+",";
		sDescripcion+=AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=asistenciaporcentrocosto.getid_empleado().toString()+",";
		sDescripcion+=AsistenciaPorCentroCostoConstantesFunciones.FECHA+"=";
		sDescripcion+=asistenciaporcentrocosto.getfecha().toString()+",";
		sDescripcion+=AsistenciaPorCentroCostoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=asistenciaporcentrocosto.getporcentaje().toString()+",";
		sDescripcion+=AsistenciaPorCentroCostoConstantesFunciones.VALORHORA+"=";
		sDescripcion+=asistenciaporcentrocosto.getvalor_hora().toString()+",";
		sDescripcion+=AsistenciaPorCentroCostoConstantesFunciones.PERMISO+"=";
		sDescripcion+=asistenciaporcentrocosto.getpermiso().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAsistenciaPorCentroCostoDescripcion(AsistenciaPorCentroCosto asistenciaporcentrocosto,String sValor) throws Exception {			
		if(asistenciaporcentrocosto !=null) {
			//asistenciaporcentrocostoasistenciaporcentrocosto.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
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
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAsistenciaPorCentroCosto(AsistenciaPorCentroCosto asistenciaporcentrocosto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosAsistenciaPorCentroCostos(List<AsistenciaPorCentroCosto> asistenciaporcentrocostos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AsistenciaPorCentroCosto asistenciaporcentrocosto: asistenciaporcentrocostos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAsistenciaPorCentroCosto(AsistenciaPorCentroCosto asistenciaporcentrocosto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && asistenciaporcentrocosto.getConCambioAuxiliar()) {
			asistenciaporcentrocosto.setIsDeleted(asistenciaporcentrocosto.getIsDeletedAuxiliar());	
			asistenciaporcentrocosto.setIsNew(asistenciaporcentrocosto.getIsNewAuxiliar());	
			asistenciaporcentrocosto.setIsChanged(asistenciaporcentrocosto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			asistenciaporcentrocosto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			asistenciaporcentrocosto.setIsDeletedAuxiliar(false);	
			asistenciaporcentrocosto.setIsNewAuxiliar(false);	
			asistenciaporcentrocosto.setIsChangedAuxiliar(false);
			
			asistenciaporcentrocosto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAsistenciaPorCentroCostos(List<AsistenciaPorCentroCosto> asistenciaporcentrocostos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AsistenciaPorCentroCosto asistenciaporcentrocosto : asistenciaporcentrocostos) {
			if(conAsignarBase && asistenciaporcentrocosto.getConCambioAuxiliar()) {
				asistenciaporcentrocosto.setIsDeleted(asistenciaporcentrocosto.getIsDeletedAuxiliar());	
				asistenciaporcentrocosto.setIsNew(asistenciaporcentrocosto.getIsNewAuxiliar());	
				asistenciaporcentrocosto.setIsChanged(asistenciaporcentrocosto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				asistenciaporcentrocosto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				asistenciaporcentrocosto.setIsDeletedAuxiliar(false);	
				asistenciaporcentrocosto.setIsNewAuxiliar(false);	
				asistenciaporcentrocosto.setIsChangedAuxiliar(false);
				
				asistenciaporcentrocosto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAsistenciaPorCentroCosto(AsistenciaPorCentroCosto asistenciaporcentrocosto,Boolean conEnteros) throws Exception  {
		asistenciaporcentrocosto.setporcentaje(0.0);
		asistenciaporcentrocosto.setvalor_hora(0.0);
		asistenciaporcentrocosto.setpermiso(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAsistenciaPorCentroCostos(List<AsistenciaPorCentroCosto> asistenciaporcentrocostos,Boolean conEnteros) throws Exception  {
		
		for(AsistenciaPorCentroCosto asistenciaporcentrocosto: asistenciaporcentrocostos) {
			asistenciaporcentrocosto.setporcentaje(0.0);
			asistenciaporcentrocosto.setvalor_hora(0.0);
			asistenciaporcentrocosto.setpermiso(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAsistenciaPorCentroCosto(List<AsistenciaPorCentroCosto> asistenciaporcentrocostos,AsistenciaPorCentroCosto asistenciaporcentrocostoAux) throws Exception  {
		AsistenciaPorCentroCostoConstantesFunciones.InicializarValoresAsistenciaPorCentroCosto(asistenciaporcentrocostoAux,true);
		
		for(AsistenciaPorCentroCosto asistenciaporcentrocosto: asistenciaporcentrocostos) {
			if(asistenciaporcentrocosto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			asistenciaporcentrocostoAux.setporcentaje(asistenciaporcentrocostoAux.getporcentaje()+asistenciaporcentrocosto.getporcentaje());			
			asistenciaporcentrocostoAux.setvalor_hora(asistenciaporcentrocostoAux.getvalor_hora()+asistenciaporcentrocosto.getvalor_hora());			
			asistenciaporcentrocostoAux.setpermiso(asistenciaporcentrocostoAux.getpermiso()+asistenciaporcentrocosto.getpermiso());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAsistenciaPorCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AsistenciaPorCentroCostoConstantesFunciones.getArrayColumnasGlobalesAsistenciaPorCentroCosto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAsistenciaPorCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAsistenciaPorCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AsistenciaPorCentroCosto> asistenciaporcentrocostos,AsistenciaPorCentroCosto asistenciaporcentrocosto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AsistenciaPorCentroCosto asistenciaporcentrocostoAux: asistenciaporcentrocostos) {
			if(asistenciaporcentrocostoAux!=null && asistenciaporcentrocosto!=null) {
				if((asistenciaporcentrocostoAux.getId()==null && asistenciaporcentrocosto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(asistenciaporcentrocostoAux.getId()!=null && asistenciaporcentrocosto.getId()!=null){
					if(asistenciaporcentrocostoAux.getId().equals(asistenciaporcentrocosto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAsistenciaPorCentroCosto(List<AsistenciaPorCentroCosto> asistenciaporcentrocostos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valor_horaTotal=0.0;
		Double permisoTotal=0.0;
	
		for(AsistenciaPorCentroCosto asistenciaporcentrocosto: asistenciaporcentrocostos) {			
			if(asistenciaporcentrocosto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=asistenciaporcentrocosto.getporcentaje();
			valor_horaTotal+=asistenciaporcentrocosto.getvalor_hora();
			permisoTotal+=asistenciaporcentrocosto.getpermiso();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaPorCentroCostoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(AsistenciaPorCentroCostoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaPorCentroCostoConstantesFunciones.VALORHORA);
		datoGeneral.setsDescripcion(AsistenciaPorCentroCostoConstantesFunciones.LABEL_VALORHORA);
		datoGeneral.setdValorDouble(valor_horaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaPorCentroCostoConstantesFunciones.PERMISO);
		datoGeneral.setsDescripcion(AsistenciaPorCentroCostoConstantesFunciones.LABEL_PERMISO);
		datoGeneral.setdValorDouble(permisoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAsistenciaPorCentroCosto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AsistenciaPorCentroCostoConstantesFunciones.LABEL_ID, AsistenciaPorCentroCostoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaPorCentroCostoConstantesFunciones.LABEL_VERSIONROW, AsistenciaPorCentroCostoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDEMPRESA, AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO, AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDEMPLEADO, AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaPorCentroCostoConstantesFunciones.LABEL_FECHA, AsistenciaPorCentroCostoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaPorCentroCostoConstantesFunciones.LABEL_PORCENTAJE, AsistenciaPorCentroCostoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaPorCentroCostoConstantesFunciones.LABEL_VALORHORA, AsistenciaPorCentroCostoConstantesFunciones.VALORHORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaPorCentroCostoConstantesFunciones.LABEL_PERMISO, AsistenciaPorCentroCostoConstantesFunciones.PERMISO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAsistenciaPorCentroCosto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AsistenciaPorCentroCostoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaPorCentroCostoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaPorCentroCostoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaPorCentroCostoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaPorCentroCostoConstantesFunciones.VALORHORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaPorCentroCostoConstantesFunciones.PERMISO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsistenciaPorCentroCosto() throws Exception  {
		return AsistenciaPorCentroCostoConstantesFunciones.getTiposSeleccionarAsistenciaPorCentroCosto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsistenciaPorCentroCosto(Boolean conFk) throws Exception  {
		return AsistenciaPorCentroCostoConstantesFunciones.getTiposSeleccionarAsistenciaPorCentroCosto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsistenciaPorCentroCosto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaPorCentroCostoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(AsistenciaPorCentroCostoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaPorCentroCostoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(AsistenciaPorCentroCostoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaPorCentroCostoConstantesFunciones.LABEL_VALORHORA);
			reporte.setsDescripcion(AsistenciaPorCentroCostoConstantesFunciones.LABEL_VALORHORA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaPorCentroCostoConstantesFunciones.LABEL_PERMISO);
			reporte.setsDescripcion(AsistenciaPorCentroCostoConstantesFunciones.LABEL_PERMISO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAsistenciaPorCentroCosto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(AsistenciaPorCentroCosto asistenciaporcentrocostoAux) throws Exception {
		
			asistenciaporcentrocostoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(asistenciaporcentrocostoAux.getEmpresa()));
			asistenciaporcentrocostoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(asistenciaporcentrocostoAux.getCentroCosto()));
			asistenciaporcentrocostoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(asistenciaporcentrocostoAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAsistenciaPorCentroCosto(List<AsistenciaPorCentroCosto> asistenciaporcentrocostosTemp) throws Exception {
		for(AsistenciaPorCentroCosto asistenciaporcentrocostoAux:asistenciaporcentrocostosTemp) {
			
			asistenciaporcentrocostoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(asistenciaporcentrocostoAux.getEmpresa()));
			asistenciaporcentrocostoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(asistenciaporcentrocostoAux.getCentroCosto()));
			asistenciaporcentrocostoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(asistenciaporcentrocostoAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAsistenciaPorCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAsistenciaPorCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsistenciaPorCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AsistenciaPorCentroCostoConstantesFunciones.getClassesRelationshipsOfAsistenciaPorCentroCosto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsistenciaPorCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAsistenciaPorCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AsistenciaPorCentroCostoConstantesFunciones.getClassesRelationshipsFromStringsOfAsistenciaPorCentroCosto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAsistenciaPorCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AsistenciaPorCentroCosto asistenciaporcentrocosto,List<AsistenciaPorCentroCosto> asistenciaporcentrocostos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AsistenciaPorCentroCosto asistenciaporcentrocostoEncontrado=null;
			
			for(AsistenciaPorCentroCosto asistenciaporcentrocostoLocal:asistenciaporcentrocostos) {
				if(asistenciaporcentrocostoLocal.getId().equals(asistenciaporcentrocosto.getId())) {
					asistenciaporcentrocostoEncontrado=asistenciaporcentrocostoLocal;
					
					asistenciaporcentrocostoLocal.setIsChanged(asistenciaporcentrocosto.getIsChanged());
					asistenciaporcentrocostoLocal.setIsNew(asistenciaporcentrocosto.getIsNew());
					asistenciaporcentrocostoLocal.setIsDeleted(asistenciaporcentrocosto.getIsDeleted());
					
					asistenciaporcentrocostoLocal.setGeneralEntityOriginal(asistenciaporcentrocosto.getGeneralEntityOriginal());
					
					asistenciaporcentrocostoLocal.setId(asistenciaporcentrocosto.getId());	
					asistenciaporcentrocostoLocal.setVersionRow(asistenciaporcentrocosto.getVersionRow());	
					asistenciaporcentrocostoLocal.setid_empresa(asistenciaporcentrocosto.getid_empresa());	
					asistenciaporcentrocostoLocal.setid_centro_costo(asistenciaporcentrocosto.getid_centro_costo());	
					asistenciaporcentrocostoLocal.setid_empleado(asistenciaporcentrocosto.getid_empleado());	
					asistenciaporcentrocostoLocal.setfecha(asistenciaporcentrocosto.getfecha());	
					asistenciaporcentrocostoLocal.setporcentaje(asistenciaporcentrocosto.getporcentaje());	
					asistenciaporcentrocostoLocal.setvalor_hora(asistenciaporcentrocosto.getvalor_hora());	
					asistenciaporcentrocostoLocal.setpermiso(asistenciaporcentrocosto.getpermiso());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!asistenciaporcentrocosto.getIsDeleted()) {
				if(!existe) {
					asistenciaporcentrocostos.add(asistenciaporcentrocosto);
				}
			} else {
				if(asistenciaporcentrocostoEncontrado!=null && permiteQuitar)  {
					asistenciaporcentrocostos.remove(asistenciaporcentrocostoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AsistenciaPorCentroCosto asistenciaporcentrocosto,List<AsistenciaPorCentroCosto> asistenciaporcentrocostos) throws Exception {
		try	{			
			for(AsistenciaPorCentroCosto asistenciaporcentrocostoLocal:asistenciaporcentrocostos) {
				if(asistenciaporcentrocostoLocal.getId().equals(asistenciaporcentrocosto.getId())) {
					asistenciaporcentrocostoLocal.setIsSelected(asistenciaporcentrocosto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAsistenciaPorCentroCosto(List<AsistenciaPorCentroCosto> asistenciaporcentrocostosAux) throws Exception {
		//this.asistenciaporcentrocostosAux=asistenciaporcentrocostosAux;
		
		for(AsistenciaPorCentroCosto asistenciaporcentrocostoAux:asistenciaporcentrocostosAux) {
			if(asistenciaporcentrocostoAux.getIsChanged()) {
				asistenciaporcentrocostoAux.setIsChanged(false);
			}		
			
			if(asistenciaporcentrocostoAux.getIsNew()) {
				asistenciaporcentrocostoAux.setIsNew(false);
			}	
			
			if(asistenciaporcentrocostoAux.getIsDeleted()) {
				asistenciaporcentrocostoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAsistenciaPorCentroCosto(AsistenciaPorCentroCosto asistenciaporcentrocostoAux) throws Exception {
		//this.asistenciaporcentrocostoAux=asistenciaporcentrocostoAux;
		
			if(asistenciaporcentrocostoAux.getIsChanged()) {
				asistenciaporcentrocostoAux.setIsChanged(false);
			}		
			
			if(asistenciaporcentrocostoAux.getIsNew()) {
				asistenciaporcentrocostoAux.setIsNew(false);
			}	
			
			if(asistenciaporcentrocostoAux.getIsDeleted()) {
				asistenciaporcentrocostoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AsistenciaPorCentroCosto asistenciaporcentrocostoAsignar,AsistenciaPorCentroCosto asistenciaporcentrocosto) throws Exception {
		asistenciaporcentrocostoAsignar.setId(asistenciaporcentrocosto.getId());	
		asistenciaporcentrocostoAsignar.setVersionRow(asistenciaporcentrocosto.getVersionRow());	
		asistenciaporcentrocostoAsignar.setid_empresa(asistenciaporcentrocosto.getid_empresa());
		asistenciaporcentrocostoAsignar.setempresa_descripcion(asistenciaporcentrocosto.getempresa_descripcion());	
		asistenciaporcentrocostoAsignar.setid_centro_costo(asistenciaporcentrocosto.getid_centro_costo());
		asistenciaporcentrocostoAsignar.setcentrocosto_descripcion(asistenciaporcentrocosto.getcentrocosto_descripcion());	
		asistenciaporcentrocostoAsignar.setid_empleado(asistenciaporcentrocosto.getid_empleado());
		asistenciaporcentrocostoAsignar.setempleado_descripcion(asistenciaporcentrocosto.getempleado_descripcion());	
		asistenciaporcentrocostoAsignar.setfecha(asistenciaporcentrocosto.getfecha());	
		asistenciaporcentrocostoAsignar.setporcentaje(asistenciaporcentrocosto.getporcentaje());	
		asistenciaporcentrocostoAsignar.setvalor_hora(asistenciaporcentrocosto.getvalor_hora());	
		asistenciaporcentrocostoAsignar.setpermiso(asistenciaporcentrocosto.getpermiso());	
	}
	
	public static void inicializarAsistenciaPorCentroCosto(AsistenciaPorCentroCosto asistenciaporcentrocosto) throws Exception {
		try {
				asistenciaporcentrocosto.setId(0L);	
					
				asistenciaporcentrocosto.setid_empresa(-1L);	
				asistenciaporcentrocosto.setid_centro_costo(null);	
				asistenciaporcentrocosto.setid_empleado(-1L);	
				asistenciaporcentrocosto.setfecha(new Date());	
				asistenciaporcentrocosto.setporcentaje(0.0);	
				asistenciaporcentrocosto.setvalor_hora(0.0);	
				asistenciaporcentrocosto.setpermiso(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAsistenciaPorCentroCosto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaPorCentroCostoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaPorCentroCostoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaPorCentroCostoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaPorCentroCostoConstantesFunciones.LABEL_VALORHORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaPorCentroCostoConstantesFunciones.LABEL_PERMISO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAsistenciaPorCentroCosto(String sTipo,Row row,Workbook workbook,AsistenciaPorCentroCosto asistenciaporcentrocosto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciaporcentrocosto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciaporcentrocosto.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciaporcentrocosto.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciaporcentrocosto.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciaporcentrocosto.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciaporcentrocosto.getvalor_hora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciaporcentrocosto.getpermiso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAsistenciaPorCentroCosto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAsistenciaPorCentroCosto() {
		return this.sFinalQueryAsistenciaPorCentroCosto;
	}
	
	public void setsFinalQueryAsistenciaPorCentroCosto(String sFinalQueryAsistenciaPorCentroCosto) {
		this.sFinalQueryAsistenciaPorCentroCosto= sFinalQueryAsistenciaPorCentroCosto;
	}
	
	public Border resaltarSeleccionarAsistenciaPorCentroCosto=null;
	
	public Border setResaltarSeleccionarAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//asistenciaporcentrocostoBeanSwingJInternalFrame.jTtoolBarAsistenciaPorCentroCosto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAsistenciaPorCentroCosto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAsistenciaPorCentroCosto() {
		return this.resaltarSeleccionarAsistenciaPorCentroCosto;
	}
	
	public void setResaltarSeleccionarAsistenciaPorCentroCosto(Border borderResaltarSeleccionarAsistenciaPorCentroCosto) {
		this.resaltarSeleccionarAsistenciaPorCentroCosto= borderResaltarSeleccionarAsistenciaPorCentroCosto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAsistenciaPorCentroCosto=null;
	public Boolean mostraridAsistenciaPorCentroCosto=true;
	public Boolean activaridAsistenciaPorCentroCosto=true;

	public Border resaltarid_empresaAsistenciaPorCentroCosto=null;
	public Boolean mostrarid_empresaAsistenciaPorCentroCosto=true;
	public Boolean activarid_empresaAsistenciaPorCentroCosto=true;
	public Boolean cargarid_empresaAsistenciaPorCentroCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAsistenciaPorCentroCosto=false;//ConEventDepend=true

	public Border resaltarid_centro_costoAsistenciaPorCentroCosto=null;
	public Boolean mostrarid_centro_costoAsistenciaPorCentroCosto=true;
	public Boolean activarid_centro_costoAsistenciaPorCentroCosto=true;
	public Boolean cargarid_centro_costoAsistenciaPorCentroCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoAsistenciaPorCentroCosto=false;//ConEventDepend=true

	public Border resaltarid_empleadoAsistenciaPorCentroCosto=null;
	public Boolean mostrarid_empleadoAsistenciaPorCentroCosto=true;
	public Boolean activarid_empleadoAsistenciaPorCentroCosto=true;
	public Boolean cargarid_empleadoAsistenciaPorCentroCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoAsistenciaPorCentroCosto=false;//ConEventDepend=true

	public Border resaltarfechaAsistenciaPorCentroCosto=null;
	public Boolean mostrarfechaAsistenciaPorCentroCosto=true;
	public Boolean activarfechaAsistenciaPorCentroCosto=false;

	public Border resaltarporcentajeAsistenciaPorCentroCosto=null;
	public Boolean mostrarporcentajeAsistenciaPorCentroCosto=true;
	public Boolean activarporcentajeAsistenciaPorCentroCosto=true;

	public Border resaltarvalor_horaAsistenciaPorCentroCosto=null;
	public Boolean mostrarvalor_horaAsistenciaPorCentroCosto=true;
	public Boolean activarvalor_horaAsistenciaPorCentroCosto=true;

	public Border resaltarpermisoAsistenciaPorCentroCosto=null;
	public Boolean mostrarpermisoAsistenciaPorCentroCosto=true;
	public Boolean activarpermisoAsistenciaPorCentroCosto=true;

	
	

	public Border setResaltaridAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciaporcentrocostoBeanSwingJInternalFrame.jTtoolBarAsistenciaPorCentroCosto.setBorder(borderResaltar);
		
		this.resaltaridAsistenciaPorCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAsistenciaPorCentroCosto() {
		return this.resaltaridAsistenciaPorCentroCosto;
	}

	public void setResaltaridAsistenciaPorCentroCosto(Border borderResaltar) {
		this.resaltaridAsistenciaPorCentroCosto= borderResaltar;
	}

	public Boolean getMostraridAsistenciaPorCentroCosto() {
		return this.mostraridAsistenciaPorCentroCosto;
	}

	public void setMostraridAsistenciaPorCentroCosto(Boolean mostraridAsistenciaPorCentroCosto) {
		this.mostraridAsistenciaPorCentroCosto= mostraridAsistenciaPorCentroCosto;
	}

	public Boolean getActivaridAsistenciaPorCentroCosto() {
		return this.activaridAsistenciaPorCentroCosto;
	}

	public void setActivaridAsistenciaPorCentroCosto(Boolean activaridAsistenciaPorCentroCosto) {
		this.activaridAsistenciaPorCentroCosto= activaridAsistenciaPorCentroCosto;
	}

	public Border setResaltarid_empresaAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciaporcentrocostoBeanSwingJInternalFrame.jTtoolBarAsistenciaPorCentroCosto.setBorder(borderResaltar);
		
		this.resaltarid_empresaAsistenciaPorCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAsistenciaPorCentroCosto() {
		return this.resaltarid_empresaAsistenciaPorCentroCosto;
	}

	public void setResaltarid_empresaAsistenciaPorCentroCosto(Border borderResaltar) {
		this.resaltarid_empresaAsistenciaPorCentroCosto= borderResaltar;
	}

	public Boolean getMostrarid_empresaAsistenciaPorCentroCosto() {
		return this.mostrarid_empresaAsistenciaPorCentroCosto;
	}

	public void setMostrarid_empresaAsistenciaPorCentroCosto(Boolean mostrarid_empresaAsistenciaPorCentroCosto) {
		this.mostrarid_empresaAsistenciaPorCentroCosto= mostrarid_empresaAsistenciaPorCentroCosto;
	}

	public Boolean getActivarid_empresaAsistenciaPorCentroCosto() {
		return this.activarid_empresaAsistenciaPorCentroCosto;
	}

	public void setActivarid_empresaAsistenciaPorCentroCosto(Boolean activarid_empresaAsistenciaPorCentroCosto) {
		this.activarid_empresaAsistenciaPorCentroCosto= activarid_empresaAsistenciaPorCentroCosto;
	}

	public Boolean getCargarid_empresaAsistenciaPorCentroCosto() {
		return this.cargarid_empresaAsistenciaPorCentroCosto;
	}

	public void setCargarid_empresaAsistenciaPorCentroCosto(Boolean cargarid_empresaAsistenciaPorCentroCosto) {
		this.cargarid_empresaAsistenciaPorCentroCosto= cargarid_empresaAsistenciaPorCentroCosto;
	}

	public Border setResaltarid_centro_costoAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciaporcentrocostoBeanSwingJInternalFrame.jTtoolBarAsistenciaPorCentroCosto.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoAsistenciaPorCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoAsistenciaPorCentroCosto() {
		return this.resaltarid_centro_costoAsistenciaPorCentroCosto;
	}

	public void setResaltarid_centro_costoAsistenciaPorCentroCosto(Border borderResaltar) {
		this.resaltarid_centro_costoAsistenciaPorCentroCosto= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoAsistenciaPorCentroCosto() {
		return this.mostrarid_centro_costoAsistenciaPorCentroCosto;
	}

	public void setMostrarid_centro_costoAsistenciaPorCentroCosto(Boolean mostrarid_centro_costoAsistenciaPorCentroCosto) {
		this.mostrarid_centro_costoAsistenciaPorCentroCosto= mostrarid_centro_costoAsistenciaPorCentroCosto;
	}

	public Boolean getActivarid_centro_costoAsistenciaPorCentroCosto() {
		return this.activarid_centro_costoAsistenciaPorCentroCosto;
	}

	public void setActivarid_centro_costoAsistenciaPorCentroCosto(Boolean activarid_centro_costoAsistenciaPorCentroCosto) {
		this.activarid_centro_costoAsistenciaPorCentroCosto= activarid_centro_costoAsistenciaPorCentroCosto;
	}

	public Boolean getCargarid_centro_costoAsistenciaPorCentroCosto() {
		return this.cargarid_centro_costoAsistenciaPorCentroCosto;
	}

	public void setCargarid_centro_costoAsistenciaPorCentroCosto(Boolean cargarid_centro_costoAsistenciaPorCentroCosto) {
		this.cargarid_centro_costoAsistenciaPorCentroCosto= cargarid_centro_costoAsistenciaPorCentroCosto;
	}

	public Border setResaltarid_empleadoAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciaporcentrocostoBeanSwingJInternalFrame.jTtoolBarAsistenciaPorCentroCosto.setBorder(borderResaltar);
		
		this.resaltarid_empleadoAsistenciaPorCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoAsistenciaPorCentroCosto() {
		return this.resaltarid_empleadoAsistenciaPorCentroCosto;
	}

	public void setResaltarid_empleadoAsistenciaPorCentroCosto(Border borderResaltar) {
		this.resaltarid_empleadoAsistenciaPorCentroCosto= borderResaltar;
	}

	public Boolean getMostrarid_empleadoAsistenciaPorCentroCosto() {
		return this.mostrarid_empleadoAsistenciaPorCentroCosto;
	}

	public void setMostrarid_empleadoAsistenciaPorCentroCosto(Boolean mostrarid_empleadoAsistenciaPorCentroCosto) {
		this.mostrarid_empleadoAsistenciaPorCentroCosto= mostrarid_empleadoAsistenciaPorCentroCosto;
	}

	public Boolean getActivarid_empleadoAsistenciaPorCentroCosto() {
		return this.activarid_empleadoAsistenciaPorCentroCosto;
	}

	public void setActivarid_empleadoAsistenciaPorCentroCosto(Boolean activarid_empleadoAsistenciaPorCentroCosto) {
		this.activarid_empleadoAsistenciaPorCentroCosto= activarid_empleadoAsistenciaPorCentroCosto;
	}

	public Boolean getCargarid_empleadoAsistenciaPorCentroCosto() {
		return this.cargarid_empleadoAsistenciaPorCentroCosto;
	}

	public void setCargarid_empleadoAsistenciaPorCentroCosto(Boolean cargarid_empleadoAsistenciaPorCentroCosto) {
		this.cargarid_empleadoAsistenciaPorCentroCosto= cargarid_empleadoAsistenciaPorCentroCosto;
	}

	public Border setResaltarfechaAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciaporcentrocostoBeanSwingJInternalFrame.jTtoolBarAsistenciaPorCentroCosto.setBorder(borderResaltar);
		
		this.resaltarfechaAsistenciaPorCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaAsistenciaPorCentroCosto() {
		return this.resaltarfechaAsistenciaPorCentroCosto;
	}

	public void setResaltarfechaAsistenciaPorCentroCosto(Border borderResaltar) {
		this.resaltarfechaAsistenciaPorCentroCosto= borderResaltar;
	}

	public Boolean getMostrarfechaAsistenciaPorCentroCosto() {
		return this.mostrarfechaAsistenciaPorCentroCosto;
	}

	public void setMostrarfechaAsistenciaPorCentroCosto(Boolean mostrarfechaAsistenciaPorCentroCosto) {
		this.mostrarfechaAsistenciaPorCentroCosto= mostrarfechaAsistenciaPorCentroCosto;
	}

	public Boolean getActivarfechaAsistenciaPorCentroCosto() {
		return this.activarfechaAsistenciaPorCentroCosto;
	}

	public void setActivarfechaAsistenciaPorCentroCosto(Boolean activarfechaAsistenciaPorCentroCosto) {
		this.activarfechaAsistenciaPorCentroCosto= activarfechaAsistenciaPorCentroCosto;
	}

	public Border setResaltarporcentajeAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciaporcentrocostoBeanSwingJInternalFrame.jTtoolBarAsistenciaPorCentroCosto.setBorder(borderResaltar);
		
		this.resaltarporcentajeAsistenciaPorCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeAsistenciaPorCentroCosto() {
		return this.resaltarporcentajeAsistenciaPorCentroCosto;
	}

	public void setResaltarporcentajeAsistenciaPorCentroCosto(Border borderResaltar) {
		this.resaltarporcentajeAsistenciaPorCentroCosto= borderResaltar;
	}

	public Boolean getMostrarporcentajeAsistenciaPorCentroCosto() {
		return this.mostrarporcentajeAsistenciaPorCentroCosto;
	}

	public void setMostrarporcentajeAsistenciaPorCentroCosto(Boolean mostrarporcentajeAsistenciaPorCentroCosto) {
		this.mostrarporcentajeAsistenciaPorCentroCosto= mostrarporcentajeAsistenciaPorCentroCosto;
	}

	public Boolean getActivarporcentajeAsistenciaPorCentroCosto() {
		return this.activarporcentajeAsistenciaPorCentroCosto;
	}

	public void setActivarporcentajeAsistenciaPorCentroCosto(Boolean activarporcentajeAsistenciaPorCentroCosto) {
		this.activarporcentajeAsistenciaPorCentroCosto= activarporcentajeAsistenciaPorCentroCosto;
	}

	public Border setResaltarvalor_horaAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciaporcentrocostoBeanSwingJInternalFrame.jTtoolBarAsistenciaPorCentroCosto.setBorder(borderResaltar);
		
		this.resaltarvalor_horaAsistenciaPorCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_horaAsistenciaPorCentroCosto() {
		return this.resaltarvalor_horaAsistenciaPorCentroCosto;
	}

	public void setResaltarvalor_horaAsistenciaPorCentroCosto(Border borderResaltar) {
		this.resaltarvalor_horaAsistenciaPorCentroCosto= borderResaltar;
	}

	public Boolean getMostrarvalor_horaAsistenciaPorCentroCosto() {
		return this.mostrarvalor_horaAsistenciaPorCentroCosto;
	}

	public void setMostrarvalor_horaAsistenciaPorCentroCosto(Boolean mostrarvalor_horaAsistenciaPorCentroCosto) {
		this.mostrarvalor_horaAsistenciaPorCentroCosto= mostrarvalor_horaAsistenciaPorCentroCosto;
	}

	public Boolean getActivarvalor_horaAsistenciaPorCentroCosto() {
		return this.activarvalor_horaAsistenciaPorCentroCosto;
	}

	public void setActivarvalor_horaAsistenciaPorCentroCosto(Boolean activarvalor_horaAsistenciaPorCentroCosto) {
		this.activarvalor_horaAsistenciaPorCentroCosto= activarvalor_horaAsistenciaPorCentroCosto;
	}

	public Border setResaltarpermisoAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciaporcentrocostoBeanSwingJInternalFrame.jTtoolBarAsistenciaPorCentroCosto.setBorder(borderResaltar);
		
		this.resaltarpermisoAsistenciaPorCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpermisoAsistenciaPorCentroCosto() {
		return this.resaltarpermisoAsistenciaPorCentroCosto;
	}

	public void setResaltarpermisoAsistenciaPorCentroCosto(Border borderResaltar) {
		this.resaltarpermisoAsistenciaPorCentroCosto= borderResaltar;
	}

	public Boolean getMostrarpermisoAsistenciaPorCentroCosto() {
		return this.mostrarpermisoAsistenciaPorCentroCosto;
	}

	public void setMostrarpermisoAsistenciaPorCentroCosto(Boolean mostrarpermisoAsistenciaPorCentroCosto) {
		this.mostrarpermisoAsistenciaPorCentroCosto= mostrarpermisoAsistenciaPorCentroCosto;
	}

	public Boolean getActivarpermisoAsistenciaPorCentroCosto() {
		return this.activarpermisoAsistenciaPorCentroCosto;
	}

	public void setActivarpermisoAsistenciaPorCentroCosto(Boolean activarpermisoAsistenciaPorCentroCosto) {
		this.activarpermisoAsistenciaPorCentroCosto= activarpermisoAsistenciaPorCentroCosto;
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
		
		
		this.setMostraridAsistenciaPorCentroCosto(esInicial);
		this.setMostrarid_empresaAsistenciaPorCentroCosto(esInicial);
		this.setMostrarid_centro_costoAsistenciaPorCentroCosto(esInicial);
		this.setMostrarid_empleadoAsistenciaPorCentroCosto(esInicial);
		this.setMostrarfechaAsistenciaPorCentroCosto(esInicial);
		this.setMostrarporcentajeAsistenciaPorCentroCosto(esInicial);
		this.setMostrarvalor_horaAsistenciaPorCentroCosto(esInicial);
		this.setMostrarpermisoAsistenciaPorCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.ID)) {
				this.setMostraridAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.FECHA)) {
				this.setMostrarfechaAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.VALORHORA)) {
				this.setMostrarvalor_horaAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.PERMISO)) {
				this.setMostrarpermisoAsistenciaPorCentroCosto(esAsigna);
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
		
		
		this.setActivaridAsistenciaPorCentroCosto(esInicial);
		this.setActivarid_empresaAsistenciaPorCentroCosto(esInicial);
		this.setActivarid_centro_costoAsistenciaPorCentroCosto(esInicial);
		this.setActivarid_empleadoAsistenciaPorCentroCosto(esInicial);
		this.setActivarfechaAsistenciaPorCentroCosto(esInicial);
		this.setActivarporcentajeAsistenciaPorCentroCosto(esInicial);
		this.setActivarvalor_horaAsistenciaPorCentroCosto(esInicial);
		this.setActivarpermisoAsistenciaPorCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.ID)) {
				this.setActivaridAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.FECHA)) {
				this.setActivarfechaAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.VALORHORA)) {
				this.setActivarvalor_horaAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.PERMISO)) {
				this.setActivarpermisoAsistenciaPorCentroCosto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAsistenciaPorCentroCosto(esInicial);
		this.setResaltarid_empresaAsistenciaPorCentroCosto(esInicial);
		this.setResaltarid_centro_costoAsistenciaPorCentroCosto(esInicial);
		this.setResaltarid_empleadoAsistenciaPorCentroCosto(esInicial);
		this.setResaltarfechaAsistenciaPorCentroCosto(esInicial);
		this.setResaltarporcentajeAsistenciaPorCentroCosto(esInicial);
		this.setResaltarvalor_horaAsistenciaPorCentroCosto(esInicial);
		this.setResaltarpermisoAsistenciaPorCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.ID)) {
				this.setResaltaridAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.FECHA)) {
				this.setResaltarfechaAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.VALORHORA)) {
				this.setResaltarvalor_horaAsistenciaPorCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaPorCentroCostoConstantesFunciones.PERMISO)) {
				this.setResaltarpermisoAsistenciaPorCentroCosto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCentroCostoAsistenciaPorCentroCosto=true;

	public Boolean getMostrarFK_IdCentroCostoAsistenciaPorCentroCosto() {
		return this.mostrarFK_IdCentroCostoAsistenciaPorCentroCosto;
	}

	public void setMostrarFK_IdCentroCostoAsistenciaPorCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoAsistenciaPorCentroCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoAsistenciaPorCentroCosto=true;

	public Boolean getMostrarFK_IdEmpleadoAsistenciaPorCentroCosto() {
		return this.mostrarFK_IdEmpleadoAsistenciaPorCentroCosto;
	}

	public void setMostrarFK_IdEmpleadoAsistenciaPorCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoAsistenciaPorCentroCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaAsistenciaPorCentroCosto=true;

	public Boolean getMostrarFK_IdEmpresaAsistenciaPorCentroCosto() {
		return this.mostrarFK_IdEmpresaAsistenciaPorCentroCosto;
	}

	public void setMostrarFK_IdEmpresaAsistenciaPorCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAsistenciaPorCentroCosto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCentroCostoAsistenciaPorCentroCosto=true;

	public Boolean getActivarFK_IdCentroCostoAsistenciaPorCentroCosto() {
		return this.activarFK_IdCentroCostoAsistenciaPorCentroCosto;
	}

	public void setActivarFK_IdCentroCostoAsistenciaPorCentroCosto(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoAsistenciaPorCentroCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoAsistenciaPorCentroCosto=true;

	public Boolean getActivarFK_IdEmpleadoAsistenciaPorCentroCosto() {
		return this.activarFK_IdEmpleadoAsistenciaPorCentroCosto;
	}

	public void setActivarFK_IdEmpleadoAsistenciaPorCentroCosto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoAsistenciaPorCentroCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaAsistenciaPorCentroCosto=true;

	public Boolean getActivarFK_IdEmpresaAsistenciaPorCentroCosto() {
		return this.activarFK_IdEmpresaAsistenciaPorCentroCosto;
	}

	public void setActivarFK_IdEmpresaAsistenciaPorCentroCosto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAsistenciaPorCentroCosto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCentroCostoAsistenciaPorCentroCosto=null;

	public Border getResaltarFK_IdCentroCostoAsistenciaPorCentroCosto() {
		return this.resaltarFK_IdCentroCostoAsistenciaPorCentroCosto;
	}

	public void setResaltarFK_IdCentroCostoAsistenciaPorCentroCosto(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoAsistenciaPorCentroCosto= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoAsistenciaPorCentroCosto= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoAsistenciaPorCentroCosto=null;

	public Border getResaltarFK_IdEmpleadoAsistenciaPorCentroCosto() {
		return this.resaltarFK_IdEmpleadoAsistenciaPorCentroCosto;
	}

	public void setResaltarFK_IdEmpleadoAsistenciaPorCentroCosto(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoAsistenciaPorCentroCosto= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoAsistenciaPorCentroCosto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaAsistenciaPorCentroCosto=null;

	public Border getResaltarFK_IdEmpresaAsistenciaPorCentroCosto() {
		return this.resaltarFK_IdEmpresaAsistenciaPorCentroCosto;
	}

	public void setResaltarFK_IdEmpresaAsistenciaPorCentroCosto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAsistenciaPorCentroCosto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAsistenciaPorCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaPorCentroCostoBeanSwingJInternalFrame asistenciaporcentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAsistenciaPorCentroCosto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}