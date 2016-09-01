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


import com.bydan.erp.nomina.util.SolicitudReemplazoConstantesFunciones;
import com.bydan.erp.nomina.util.SolicitudReemplazoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.SolicitudReemplazoParameterGeneral;

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
final public class SolicitudReemplazoConstantesFunciones extends SolicitudReemplazoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SolicitudReemplazo";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SolicitudReemplazo"+SolicitudReemplazoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SolicitudReemplazoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SolicitudReemplazoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SolicitudReemplazoConstantesFunciones.SCHEMA+"_"+SolicitudReemplazoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SolicitudReemplazoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SolicitudReemplazoConstantesFunciones.SCHEMA+"_"+SolicitudReemplazoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SolicitudReemplazoConstantesFunciones.SCHEMA+"_"+SolicitudReemplazoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SolicitudReemplazoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SolicitudReemplazoConstantesFunciones.SCHEMA+"_"+SolicitudReemplazoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudReemplazoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SolicitudReemplazoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudReemplazoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudReemplazoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SolicitudReemplazoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudReemplazoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SolicitudReemplazoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SolicitudReemplazoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SolicitudReemplazoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SolicitudReemplazoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Solicitud Reemplazos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Solicitud Reemplazo";
	public static final String SCLASSWEBTITULO_LOWER="Solicitud Reemplazo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SolicitudReemplazo";
	public static final String OBJECTNAME="solicitudreemplazo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="solicitud_reemplazo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select solicitudreemplazo from "+SolicitudReemplazoConstantesFunciones.SPERSISTENCENAME+" solicitudreemplazo";
	public static String QUERYSELECTNATIVE="select "+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".version_row,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_empresa,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_sucursal,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_empleado_jefe,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_empleado,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_empleado_reemplazo,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_estructura,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_estado_solicitud_nomi,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".secuencial,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".fecha_solicita,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".fecha_ejecuta,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".numero_horas,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".costo_unitario,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".costo_total,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".descripcion from "+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME;//+" as "+SolicitudReemplazoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SolicitudReemplazoConstantesFuncionesAdditional solicitudreemplazoConstantesFuncionesAdditional=null;
	
	public SolicitudReemplazoConstantesFuncionesAdditional getSolicitudReemplazoConstantesFuncionesAdditional() {
		return this.solicitudreemplazoConstantesFuncionesAdditional;
	}
	
	public void setSolicitudReemplazoConstantesFuncionesAdditional(SolicitudReemplazoConstantesFuncionesAdditional solicitudreemplazoConstantesFuncionesAdditional) {
		try {
			this.solicitudreemplazoConstantesFuncionesAdditional=solicitudreemplazoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEMPLEADOJEFE= "id_empleado_jefe";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDEMPLEADOREEMPLAZO= "id_empleado_reemplazo";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDESTADOSOLICITUDNOMI= "id_estado_solicitud_nomi";
    public static final String SECUENCIAL= "secuencial";
    public static final String FECHASOLICITA= "fecha_solicita";
    public static final String FECHAEJECUTA= "fecha_ejecuta";
    public static final String NUMEROHORAS= "numero_horas";
    public static final String COSTOUNITARIO= "costo_unitario";
    public static final String COSTOTOTAL= "costo_total";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEMPLEADOJEFE= "Empleado Jefe";
		public static final String LABEL_IDEMPLEADOJEFE_LOWER= "Empleado Jefe";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDEMPLEADOREEMPLAZO= "Empleado Reemplazo";
		public static final String LABEL_IDEMPLEADOREEMPLAZO_LOWER= "Empleado Reemplazo";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDESTADOSOLICITUDNOMI= "Estado Solicitud Nomi";
		public static final String LABEL_IDESTADOSOLICITUDNOMI_LOWER= "Estado Solicitud Nomi";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_FECHASOLICITA= "Fecha Solicita";
		public static final String LABEL_FECHASOLICITA_LOWER= "Fecha Solicita";
    	public static final String LABEL_FECHAEJECUTA= "Fecha Ejecuta";
		public static final String LABEL_FECHAEJECUTA_LOWER= "Fecha Ejecuta";
    	public static final String LABEL_NUMEROHORAS= "Numero Horas";
		public static final String LABEL_NUMEROHORAS_LOWER= "Numero Horas";
    	public static final String LABEL_COSTOUNITARIO= "Costo Unitario";
		public static final String LABEL_COSTOUNITARIO_LOWER= "Costo Unitario";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSolicitudReemplazoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.IDEMPRESA)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADOJEFE;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADOREEMPLAZO;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.SECUENCIAL)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.FECHASOLICITA)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_FECHASOLICITA;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.FECHAEJECUTA)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_FECHAEJECUTA;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.NUMEROHORAS)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_NUMEROHORAS;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.COSTOTOTAL)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(SolicitudReemplazoConstantesFunciones.DESCRIPCION)) {sLabelColumna=SolicitudReemplazoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSolicitudReemplazoDescripcion(SolicitudReemplazo solicitudreemplazo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(solicitudreemplazo !=null/* && solicitudreemplazo.getId()!=0*/) {
			if(solicitudreemplazo.getId()!=null) {
				sDescripcion=solicitudreemplazo.getId().toString();
			}//solicitudreemplazosolicitudreemplazo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSolicitudReemplazoDescripcionDetallado(SolicitudReemplazo solicitudreemplazo) {
		String sDescripcion="";
			
		sDescripcion+=SolicitudReemplazoConstantesFunciones.ID+"=";
		sDescripcion+=solicitudreemplazo.getId().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=solicitudreemplazo.getVersionRow().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=solicitudreemplazo.getid_empresa().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=solicitudreemplazo.getid_sucursal().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE+"=";
		sDescripcion+=solicitudreemplazo.getid_empleado_jefe().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=solicitudreemplazo.getid_empleado().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO+"=";
		sDescripcion+=solicitudreemplazo.getid_empleado_reemplazo().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=solicitudreemplazo.getid_estructura().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI+"=";
		sDescripcion+=solicitudreemplazo.getid_estado_solicitud_nomi().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=solicitudreemplazo.getsecuencial()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.FECHASOLICITA+"=";
		sDescripcion+=solicitudreemplazo.getfecha_solicita().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.FECHAEJECUTA+"=";
		sDescripcion+=solicitudreemplazo.getfecha_ejecuta().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.NUMEROHORAS+"=";
		sDescripcion+=solicitudreemplazo.getnumero_horas().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=solicitudreemplazo.getcosto_unitario().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=solicitudreemplazo.getcosto_total().toString()+",";
		sDescripcion+=SolicitudReemplazoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=solicitudreemplazo.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setSolicitudReemplazoDescripcion(SolicitudReemplazo solicitudreemplazo,String sValor) throws Exception {			
		if(solicitudreemplazo !=null) {
			//solicitudreemplazosolicitudreemplazo.getId().toString();
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

	public static String getEmpleadoJefeDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
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

	public static String getEmpleadoReemplazoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
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

	public static String getEstadoSolicitudNomiDescripcion(EstadoSolicitudNomi estadosolicitudnomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadosolicitudnomi!=null/*&&estadosolicitudnomi.getId()>0*/) {
			sDescripcion=EstadoSolicitudNomiConstantesFunciones.getEstadoSolicitudNomiDescripcion(estadosolicitudnomi);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpleadoJefe")) {
			sNombreIndice="Tipo=  Por Empleado Jefe";
		} else if(sNombreIndice.equals("FK_IdEmpleadoReemplazo")) {
			sNombreIndice="Tipo=  Por Empleado Reemplazo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoSolicitudNomi")) {
			sNombreIndice="Tipo=  Por Estado Solicitud Nomi";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleadoJefe(Long id_empleado_jefe) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado_jefe!=null) {sDetalleIndice+=" Codigo Unico De Empleado Jefe="+id_empleado_jefe.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleadoReemplazo(Long id_empleado_reemplazo) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado_reemplazo!=null) {sDetalleIndice+=" Codigo Unico De Empleado Reemplazo="+id_empleado_reemplazo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoSolicitudNomi(Long id_estado_solicitud_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_solicitud_nomi!=null) {sDetalleIndice+=" Codigo Unico De Estado Solicitud Nomi="+id_estado_solicitud_nomi.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSolicitudReemplazo(SolicitudReemplazo solicitudreemplazo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		solicitudreemplazo.setsecuencial(solicitudreemplazo.getsecuencial().trim());
		solicitudreemplazo.setdescripcion(solicitudreemplazo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosSolicitudReemplazos(List<SolicitudReemplazo> solicitudreemplazos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SolicitudReemplazo solicitudreemplazo: solicitudreemplazos) {
			solicitudreemplazo.setsecuencial(solicitudreemplazo.getsecuencial().trim());
			solicitudreemplazo.setdescripcion(solicitudreemplazo.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSolicitudReemplazo(SolicitudReemplazo solicitudreemplazo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && solicitudreemplazo.getConCambioAuxiliar()) {
			solicitudreemplazo.setIsDeleted(solicitudreemplazo.getIsDeletedAuxiliar());	
			solicitudreemplazo.setIsNew(solicitudreemplazo.getIsNewAuxiliar());	
			solicitudreemplazo.setIsChanged(solicitudreemplazo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			solicitudreemplazo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			solicitudreemplazo.setIsDeletedAuxiliar(false);	
			solicitudreemplazo.setIsNewAuxiliar(false);	
			solicitudreemplazo.setIsChangedAuxiliar(false);
			
			solicitudreemplazo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSolicitudReemplazos(List<SolicitudReemplazo> solicitudreemplazos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SolicitudReemplazo solicitudreemplazo : solicitudreemplazos) {
			if(conAsignarBase && solicitudreemplazo.getConCambioAuxiliar()) {
				solicitudreemplazo.setIsDeleted(solicitudreemplazo.getIsDeletedAuxiliar());	
				solicitudreemplazo.setIsNew(solicitudreemplazo.getIsNewAuxiliar());	
				solicitudreemplazo.setIsChanged(solicitudreemplazo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				solicitudreemplazo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				solicitudreemplazo.setIsDeletedAuxiliar(false);	
				solicitudreemplazo.setIsNewAuxiliar(false);	
				solicitudreemplazo.setIsChangedAuxiliar(false);
				
				solicitudreemplazo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSolicitudReemplazo(SolicitudReemplazo solicitudreemplazo,Boolean conEnteros) throws Exception  {
		solicitudreemplazo.setcosto_unitario(0.0);
		solicitudreemplazo.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			solicitudreemplazo.setnumero_horas(0);
		}
	}		
	
	public static void InicializarValoresSolicitudReemplazos(List<SolicitudReemplazo> solicitudreemplazos,Boolean conEnteros) throws Exception  {
		
		for(SolicitudReemplazo solicitudreemplazo: solicitudreemplazos) {
			solicitudreemplazo.setcosto_unitario(0.0);
			solicitudreemplazo.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				solicitudreemplazo.setnumero_horas(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaSolicitudReemplazo(List<SolicitudReemplazo> solicitudreemplazos,SolicitudReemplazo solicitudreemplazoAux) throws Exception  {
		SolicitudReemplazoConstantesFunciones.InicializarValoresSolicitudReemplazo(solicitudreemplazoAux,true);
		
		for(SolicitudReemplazo solicitudreemplazo: solicitudreemplazos) {
			if(solicitudreemplazo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			solicitudreemplazoAux.setnumero_horas(solicitudreemplazoAux.getnumero_horas()+solicitudreemplazo.getnumero_horas());			
			solicitudreemplazoAux.setcosto_unitario(solicitudreemplazoAux.getcosto_unitario()+solicitudreemplazo.getcosto_unitario());			
			solicitudreemplazoAux.setcosto_total(solicitudreemplazoAux.getcosto_total()+solicitudreemplazo.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSolicitudReemplazo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SolicitudReemplazoConstantesFunciones.getArrayColumnasGlobalesSolicitudReemplazo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSolicitudReemplazo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SolicitudReemplazoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SolicitudReemplazoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SolicitudReemplazoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SolicitudReemplazoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSolicitudReemplazo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SolicitudReemplazo> solicitudreemplazos,SolicitudReemplazo solicitudreemplazo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SolicitudReemplazo solicitudreemplazoAux: solicitudreemplazos) {
			if(solicitudreemplazoAux!=null && solicitudreemplazo!=null) {
				if((solicitudreemplazoAux.getId()==null && solicitudreemplazo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(solicitudreemplazoAux.getId()!=null && solicitudreemplazo.getId()!=null){
					if(solicitudreemplazoAux.getId().equals(solicitudreemplazo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSolicitudReemplazo(List<SolicitudReemplazo> solicitudreemplazos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(SolicitudReemplazo solicitudreemplazo: solicitudreemplazos) {			
			if(solicitudreemplazo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costo_unitarioTotal+=solicitudreemplazo.getcosto_unitario();
			costo_totalTotal+=solicitudreemplazo.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SolicitudReemplazoConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SolicitudReemplazoConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSolicitudReemplazo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_ID, SolicitudReemplazoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_VERSIONROW, SolicitudReemplazoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_IDEMPRESA, SolicitudReemplazoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_IDSUCURSAL, SolicitudReemplazoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADOJEFE, SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADO, SolicitudReemplazoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADOREEMPLAZO, SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_IDESTRUCTURA, SolicitudReemplazoConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI, SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_SECUENCIAL, SolicitudReemplazoConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_FECHASOLICITA, SolicitudReemplazoConstantesFunciones.FECHASOLICITA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_FECHAEJECUTA, SolicitudReemplazoConstantesFunciones.FECHAEJECUTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_NUMEROHORAS, SolicitudReemplazoConstantesFunciones.NUMEROHORAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_COSTOUNITARIO, SolicitudReemplazoConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_COSTOTOTAL, SolicitudReemplazoConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudReemplazoConstantesFunciones.LABEL_DESCRIPCION, SolicitudReemplazoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSolicitudReemplazo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.FECHASOLICITA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.FECHAEJECUTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.NUMEROHORAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudReemplazoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSolicitudReemplazo() throws Exception  {
		return SolicitudReemplazoConstantesFunciones.getTiposSeleccionarSolicitudReemplazo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSolicitudReemplazo(Boolean conFk) throws Exception  {
		return SolicitudReemplazoConstantesFunciones.getTiposSeleccionarSolicitudReemplazo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSolicitudReemplazo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADOJEFE);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADOJEFE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADOREEMPLAZO);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADOREEMPLAZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_FECHASOLICITA);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_FECHASOLICITA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_FECHAEJECUTA);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_FECHAEJECUTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_NUMEROHORAS);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_NUMEROHORAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudReemplazoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSolicitudReemplazo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSolicitudReemplazo(SolicitudReemplazo solicitudreemplazoAux) throws Exception {
		
			solicitudreemplazoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(solicitudreemplazoAux.getEmpresa()));
			solicitudreemplazoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(solicitudreemplazoAux.getSucursal()));
			solicitudreemplazoAux.setempleadojefe_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudreemplazoAux.getEmpleadoJefe()));
			solicitudreemplazoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudreemplazoAux.getEmpleado()));
			solicitudreemplazoAux.setempleadoreemplazo_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudreemplazoAux.getEmpleadoReemplazo()));
			solicitudreemplazoAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(solicitudreemplazoAux.getEstructura()));
			solicitudreemplazoAux.setestadosolicitudnomi_descripcion(EstadoSolicitudNomiConstantesFunciones.getEstadoSolicitudNomiDescripcion(solicitudreemplazoAux.getEstadoSolicitudNomi()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSolicitudReemplazo(List<SolicitudReemplazo> solicitudreemplazosTemp) throws Exception {
		for(SolicitudReemplazo solicitudreemplazoAux:solicitudreemplazosTemp) {
			
			solicitudreemplazoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(solicitudreemplazoAux.getEmpresa()));
			solicitudreemplazoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(solicitudreemplazoAux.getSucursal()));
			solicitudreemplazoAux.setempleadojefe_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudreemplazoAux.getEmpleadoJefe()));
			solicitudreemplazoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudreemplazoAux.getEmpleado()));
			solicitudreemplazoAux.setempleadoreemplazo_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudreemplazoAux.getEmpleadoReemplazo()));
			solicitudreemplazoAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(solicitudreemplazoAux.getEstructura()));
			solicitudreemplazoAux.setestadosolicitudnomi_descripcion(EstadoSolicitudNomiConstantesFunciones.getEstadoSolicitudNomiDescripcion(solicitudreemplazoAux.getEstadoSolicitudNomi()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSolicitudReemplazo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(EstadoSolicitudNomi.class));
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoSolicitudNomi.class)) {
						classes.add(new Classe(EstadoSolicitudNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSolicitudReemplazo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(EstadoSolicitudNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoSolicitudNomi.class)); continue;
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

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(EstadoSolicitudNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoSolicitudNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSolicitudReemplazo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SolicitudReemplazoConstantesFunciones.getClassesRelationshipsOfSolicitudReemplazo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSolicitudReemplazo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSolicitudReemplazo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SolicitudReemplazoConstantesFunciones.getClassesRelationshipsFromStringsOfSolicitudReemplazo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSolicitudReemplazo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SolicitudReemplazo solicitudreemplazo,List<SolicitudReemplazo> solicitudreemplazos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SolicitudReemplazo solicitudreemplazoEncontrado=null;
			
			for(SolicitudReemplazo solicitudreemplazoLocal:solicitudreemplazos) {
				if(solicitudreemplazoLocal.getId().equals(solicitudreemplazo.getId())) {
					solicitudreemplazoEncontrado=solicitudreemplazoLocal;
					
					solicitudreemplazoLocal.setIsChanged(solicitudreemplazo.getIsChanged());
					solicitudreemplazoLocal.setIsNew(solicitudreemplazo.getIsNew());
					solicitudreemplazoLocal.setIsDeleted(solicitudreemplazo.getIsDeleted());
					
					solicitudreemplazoLocal.setGeneralEntityOriginal(solicitudreemplazo.getGeneralEntityOriginal());
					
					solicitudreemplazoLocal.setId(solicitudreemplazo.getId());	
					solicitudreemplazoLocal.setVersionRow(solicitudreemplazo.getVersionRow());	
					solicitudreemplazoLocal.setid_empresa(solicitudreemplazo.getid_empresa());	
					solicitudreemplazoLocal.setid_sucursal(solicitudreemplazo.getid_sucursal());	
					solicitudreemplazoLocal.setid_empleado_jefe(solicitudreemplazo.getid_empleado_jefe());	
					solicitudreemplazoLocal.setid_empleado(solicitudreemplazo.getid_empleado());	
					solicitudreemplazoLocal.setid_empleado_reemplazo(solicitudreemplazo.getid_empleado_reemplazo());	
					solicitudreemplazoLocal.setid_estructura(solicitudreemplazo.getid_estructura());	
					solicitudreemplazoLocal.setid_estado_solicitud_nomi(solicitudreemplazo.getid_estado_solicitud_nomi());	
					solicitudreemplazoLocal.setsecuencial(solicitudreemplazo.getsecuencial());	
					solicitudreemplazoLocal.setfecha_solicita(solicitudreemplazo.getfecha_solicita());	
					solicitudreemplazoLocal.setfecha_ejecuta(solicitudreemplazo.getfecha_ejecuta());	
					solicitudreemplazoLocal.setnumero_horas(solicitudreemplazo.getnumero_horas());	
					solicitudreemplazoLocal.setcosto_unitario(solicitudreemplazo.getcosto_unitario());	
					solicitudreemplazoLocal.setcosto_total(solicitudreemplazo.getcosto_total());	
					solicitudreemplazoLocal.setdescripcion(solicitudreemplazo.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!solicitudreemplazo.getIsDeleted()) {
				if(!existe) {
					solicitudreemplazos.add(solicitudreemplazo);
				}
			} else {
				if(solicitudreemplazoEncontrado!=null && permiteQuitar)  {
					solicitudreemplazos.remove(solicitudreemplazoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SolicitudReemplazo solicitudreemplazo,List<SolicitudReemplazo> solicitudreemplazos) throws Exception {
		try	{			
			for(SolicitudReemplazo solicitudreemplazoLocal:solicitudreemplazos) {
				if(solicitudreemplazoLocal.getId().equals(solicitudreemplazo.getId())) {
					solicitudreemplazoLocal.setIsSelected(solicitudreemplazo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSolicitudReemplazo(List<SolicitudReemplazo> solicitudreemplazosAux) throws Exception {
		//this.solicitudreemplazosAux=solicitudreemplazosAux;
		
		for(SolicitudReemplazo solicitudreemplazoAux:solicitudreemplazosAux) {
			if(solicitudreemplazoAux.getIsChanged()) {
				solicitudreemplazoAux.setIsChanged(false);
			}		
			
			if(solicitudreemplazoAux.getIsNew()) {
				solicitudreemplazoAux.setIsNew(false);
			}	
			
			if(solicitudreemplazoAux.getIsDeleted()) {
				solicitudreemplazoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSolicitudReemplazo(SolicitudReemplazo solicitudreemplazoAux) throws Exception {
		//this.solicitudreemplazoAux=solicitudreemplazoAux;
		
			if(solicitudreemplazoAux.getIsChanged()) {
				solicitudreemplazoAux.setIsChanged(false);
			}		
			
			if(solicitudreemplazoAux.getIsNew()) {
				solicitudreemplazoAux.setIsNew(false);
			}	
			
			if(solicitudreemplazoAux.getIsDeleted()) {
				solicitudreemplazoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SolicitudReemplazo solicitudreemplazoAsignar,SolicitudReemplazo solicitudreemplazo) throws Exception {
		solicitudreemplazoAsignar.setId(solicitudreemplazo.getId());	
		solicitudreemplazoAsignar.setVersionRow(solicitudreemplazo.getVersionRow());	
		solicitudreemplazoAsignar.setid_empresa(solicitudreemplazo.getid_empresa());
		solicitudreemplazoAsignar.setempresa_descripcion(solicitudreemplazo.getempresa_descripcion());	
		solicitudreemplazoAsignar.setid_sucursal(solicitudreemplazo.getid_sucursal());
		solicitudreemplazoAsignar.setsucursal_descripcion(solicitudreemplazo.getsucursal_descripcion());	
		solicitudreemplazoAsignar.setid_empleado_jefe(solicitudreemplazo.getid_empleado_jefe());
		solicitudreemplazoAsignar.setempleadojefe_descripcion(solicitudreemplazo.getempleadojefe_descripcion());	
		solicitudreemplazoAsignar.setid_empleado(solicitudreemplazo.getid_empleado());
		solicitudreemplazoAsignar.setempleado_descripcion(solicitudreemplazo.getempleado_descripcion());	
		solicitudreemplazoAsignar.setid_empleado_reemplazo(solicitudreemplazo.getid_empleado_reemplazo());
		solicitudreemplazoAsignar.setempleadoreemplazo_descripcion(solicitudreemplazo.getempleadoreemplazo_descripcion());	
		solicitudreemplazoAsignar.setid_estructura(solicitudreemplazo.getid_estructura());
		solicitudreemplazoAsignar.setestructura_descripcion(solicitudreemplazo.getestructura_descripcion());	
		solicitudreemplazoAsignar.setid_estado_solicitud_nomi(solicitudreemplazo.getid_estado_solicitud_nomi());
		solicitudreemplazoAsignar.setestadosolicitudnomi_descripcion(solicitudreemplazo.getestadosolicitudnomi_descripcion());	
		solicitudreemplazoAsignar.setsecuencial(solicitudreemplazo.getsecuencial());	
		solicitudreemplazoAsignar.setfecha_solicita(solicitudreemplazo.getfecha_solicita());	
		solicitudreemplazoAsignar.setfecha_ejecuta(solicitudreemplazo.getfecha_ejecuta());	
		solicitudreemplazoAsignar.setnumero_horas(solicitudreemplazo.getnumero_horas());	
		solicitudreemplazoAsignar.setcosto_unitario(solicitudreemplazo.getcosto_unitario());	
		solicitudreemplazoAsignar.setcosto_total(solicitudreemplazo.getcosto_total());	
		solicitudreemplazoAsignar.setdescripcion(solicitudreemplazo.getdescripcion());	
	}
	
	public static void inicializarSolicitudReemplazo(SolicitudReemplazo solicitudreemplazo) throws Exception {
		try {
				solicitudreemplazo.setId(0L);	
					
				solicitudreemplazo.setid_empresa(-1L);	
				solicitudreemplazo.setid_sucursal(-1L);	
				solicitudreemplazo.setid_empleado_jefe(-1L);	
				solicitudreemplazo.setid_empleado(-1L);	
				solicitudreemplazo.setid_empleado_reemplazo(-1L);	
				solicitudreemplazo.setid_estructura(-1L);	
				solicitudreemplazo.setid_estado_solicitud_nomi(-1L);	
				solicitudreemplazo.setsecuencial("");	
				solicitudreemplazo.setfecha_solicita(new Date());	
				solicitudreemplazo.setfecha_ejecuta(new Date());	
				solicitudreemplazo.setnumero_horas(0);	
				solicitudreemplazo.setcosto_unitario(0.0);	
				solicitudreemplazo.setcosto_total(0.0);	
				solicitudreemplazo.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSolicitudReemplazo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADOJEFE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_IDEMPLEADOREEMPLAZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_FECHASOLICITA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_FECHAEJECUTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_NUMEROHORAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudReemplazoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSolicitudReemplazo(String sTipo,Row row,Workbook workbook,SolicitudReemplazo solicitudreemplazo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getempleadojefe_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getempleadoreemplazo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getestadosolicitudnomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getfecha_solicita());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getfecha_ejecuta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getnumero_horas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudreemplazo.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySolicitudReemplazo=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySolicitudReemplazo() {
		return this.sFinalQuerySolicitudReemplazo;
	}
	
	public void setsFinalQuerySolicitudReemplazo(String sFinalQuerySolicitudReemplazo) {
		this.sFinalQuerySolicitudReemplazo= sFinalQuerySolicitudReemplazo;
	}
	
	public Border resaltarSeleccionarSolicitudReemplazo=null;
	
	public Border setResaltarSeleccionarSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSolicitudReemplazo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSolicitudReemplazo() {
		return this.resaltarSeleccionarSolicitudReemplazo;
	}
	
	public void setResaltarSeleccionarSolicitudReemplazo(Border borderResaltarSeleccionarSolicitudReemplazo) {
		this.resaltarSeleccionarSolicitudReemplazo= borderResaltarSeleccionarSolicitudReemplazo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSolicitudReemplazo=null;
	public Boolean mostraridSolicitudReemplazo=true;
	public Boolean activaridSolicitudReemplazo=true;

	public Border resaltarid_empresaSolicitudReemplazo=null;
	public Boolean mostrarid_empresaSolicitudReemplazo=true;
	public Boolean activarid_empresaSolicitudReemplazo=true;
	public Boolean cargarid_empresaSolicitudReemplazo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSolicitudReemplazo=false;//ConEventDepend=true

	public Border resaltarid_sucursalSolicitudReemplazo=null;
	public Boolean mostrarid_sucursalSolicitudReemplazo=true;
	public Boolean activarid_sucursalSolicitudReemplazo=true;
	public Boolean cargarid_sucursalSolicitudReemplazo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalSolicitudReemplazo=false;//ConEventDepend=true

	public Border resaltarid_empleado_jefeSolicitudReemplazo=null;
	public Boolean mostrarid_empleado_jefeSolicitudReemplazo=true;
	public Boolean activarid_empleado_jefeSolicitudReemplazo=true;
	public Boolean cargarid_empleado_jefeSolicitudReemplazo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_jefeSolicitudReemplazo=false;//ConEventDepend=true

	public Border resaltarid_empleadoSolicitudReemplazo=null;
	public Boolean mostrarid_empleadoSolicitudReemplazo=true;
	public Boolean activarid_empleadoSolicitudReemplazo=true;
	public Boolean cargarid_empleadoSolicitudReemplazo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoSolicitudReemplazo=false;//ConEventDepend=true

	public Border resaltarid_empleado_reemplazoSolicitudReemplazo=null;
	public Boolean mostrarid_empleado_reemplazoSolicitudReemplazo=true;
	public Boolean activarid_empleado_reemplazoSolicitudReemplazo=true;
	public Boolean cargarid_empleado_reemplazoSolicitudReemplazo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_reemplazoSolicitudReemplazo=false;//ConEventDepend=true

	public Border resaltarid_estructuraSolicitudReemplazo=null;
	public Boolean mostrarid_estructuraSolicitudReemplazo=true;
	public Boolean activarid_estructuraSolicitudReemplazo=true;
	public Boolean cargarid_estructuraSolicitudReemplazo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraSolicitudReemplazo=false;//ConEventDepend=true

	public Border resaltarid_estado_solicitud_nomiSolicitudReemplazo=null;
	public Boolean mostrarid_estado_solicitud_nomiSolicitudReemplazo=true;
	public Boolean activarid_estado_solicitud_nomiSolicitudReemplazo=true;
	public Boolean cargarid_estado_solicitud_nomiSolicitudReemplazo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_solicitud_nomiSolicitudReemplazo=false;//ConEventDepend=true

	public Border resaltarsecuencialSolicitudReemplazo=null;
	public Boolean mostrarsecuencialSolicitudReemplazo=true;
	public Boolean activarsecuencialSolicitudReemplazo=true;

	public Border resaltarfecha_solicitaSolicitudReemplazo=null;
	public Boolean mostrarfecha_solicitaSolicitudReemplazo=true;
	public Boolean activarfecha_solicitaSolicitudReemplazo=false;

	public Border resaltarfecha_ejecutaSolicitudReemplazo=null;
	public Boolean mostrarfecha_ejecutaSolicitudReemplazo=true;
	public Boolean activarfecha_ejecutaSolicitudReemplazo=false;

	public Border resaltarnumero_horasSolicitudReemplazo=null;
	public Boolean mostrarnumero_horasSolicitudReemplazo=true;
	public Boolean activarnumero_horasSolicitudReemplazo=true;

	public Border resaltarcosto_unitarioSolicitudReemplazo=null;
	public Boolean mostrarcosto_unitarioSolicitudReemplazo=true;
	public Boolean activarcosto_unitarioSolicitudReemplazo=true;

	public Border resaltarcosto_totalSolicitudReemplazo=null;
	public Boolean mostrarcosto_totalSolicitudReemplazo=true;
	public Boolean activarcosto_totalSolicitudReemplazo=true;

	public Border resaltardescripcionSolicitudReemplazo=null;
	public Boolean mostrardescripcionSolicitudReemplazo=true;
	public Boolean activardescripcionSolicitudReemplazo=true;

	
	

	public Border setResaltaridSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltaridSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSolicitudReemplazo() {
		return this.resaltaridSolicitudReemplazo;
	}

	public void setResaltaridSolicitudReemplazo(Border borderResaltar) {
		this.resaltaridSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostraridSolicitudReemplazo() {
		return this.mostraridSolicitudReemplazo;
	}

	public void setMostraridSolicitudReemplazo(Boolean mostraridSolicitudReemplazo) {
		this.mostraridSolicitudReemplazo= mostraridSolicitudReemplazo;
	}

	public Boolean getActivaridSolicitudReemplazo() {
		return this.activaridSolicitudReemplazo;
	}

	public void setActivaridSolicitudReemplazo(Boolean activaridSolicitudReemplazo) {
		this.activaridSolicitudReemplazo= activaridSolicitudReemplazo;
	}

	public Border setResaltarid_empresaSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarid_empresaSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSolicitudReemplazo() {
		return this.resaltarid_empresaSolicitudReemplazo;
	}

	public void setResaltarid_empresaSolicitudReemplazo(Border borderResaltar) {
		this.resaltarid_empresaSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarid_empresaSolicitudReemplazo() {
		return this.mostrarid_empresaSolicitudReemplazo;
	}

	public void setMostrarid_empresaSolicitudReemplazo(Boolean mostrarid_empresaSolicitudReemplazo) {
		this.mostrarid_empresaSolicitudReemplazo= mostrarid_empresaSolicitudReemplazo;
	}

	public Boolean getActivarid_empresaSolicitudReemplazo() {
		return this.activarid_empresaSolicitudReemplazo;
	}

	public void setActivarid_empresaSolicitudReemplazo(Boolean activarid_empresaSolicitudReemplazo) {
		this.activarid_empresaSolicitudReemplazo= activarid_empresaSolicitudReemplazo;
	}

	public Boolean getCargarid_empresaSolicitudReemplazo() {
		return this.cargarid_empresaSolicitudReemplazo;
	}

	public void setCargarid_empresaSolicitudReemplazo(Boolean cargarid_empresaSolicitudReemplazo) {
		this.cargarid_empresaSolicitudReemplazo= cargarid_empresaSolicitudReemplazo;
	}

	public Border setResaltarid_sucursalSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarid_sucursalSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalSolicitudReemplazo() {
		return this.resaltarid_sucursalSolicitudReemplazo;
	}

	public void setResaltarid_sucursalSolicitudReemplazo(Border borderResaltar) {
		this.resaltarid_sucursalSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarid_sucursalSolicitudReemplazo() {
		return this.mostrarid_sucursalSolicitudReemplazo;
	}

	public void setMostrarid_sucursalSolicitudReemplazo(Boolean mostrarid_sucursalSolicitudReemplazo) {
		this.mostrarid_sucursalSolicitudReemplazo= mostrarid_sucursalSolicitudReemplazo;
	}

	public Boolean getActivarid_sucursalSolicitudReemplazo() {
		return this.activarid_sucursalSolicitudReemplazo;
	}

	public void setActivarid_sucursalSolicitudReemplazo(Boolean activarid_sucursalSolicitudReemplazo) {
		this.activarid_sucursalSolicitudReemplazo= activarid_sucursalSolicitudReemplazo;
	}

	public Boolean getCargarid_sucursalSolicitudReemplazo() {
		return this.cargarid_sucursalSolicitudReemplazo;
	}

	public void setCargarid_sucursalSolicitudReemplazo(Boolean cargarid_sucursalSolicitudReemplazo) {
		this.cargarid_sucursalSolicitudReemplazo= cargarid_sucursalSolicitudReemplazo;
	}

	public Border setResaltarid_empleado_jefeSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarid_empleado_jefeSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_jefeSolicitudReemplazo() {
		return this.resaltarid_empleado_jefeSolicitudReemplazo;
	}

	public void setResaltarid_empleado_jefeSolicitudReemplazo(Border borderResaltar) {
		this.resaltarid_empleado_jefeSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarid_empleado_jefeSolicitudReemplazo() {
		return this.mostrarid_empleado_jefeSolicitudReemplazo;
	}

	public void setMostrarid_empleado_jefeSolicitudReemplazo(Boolean mostrarid_empleado_jefeSolicitudReemplazo) {
		this.mostrarid_empleado_jefeSolicitudReemplazo= mostrarid_empleado_jefeSolicitudReemplazo;
	}

	public Boolean getActivarid_empleado_jefeSolicitudReemplazo() {
		return this.activarid_empleado_jefeSolicitudReemplazo;
	}

	public void setActivarid_empleado_jefeSolicitudReemplazo(Boolean activarid_empleado_jefeSolicitudReemplazo) {
		this.activarid_empleado_jefeSolicitudReemplazo= activarid_empleado_jefeSolicitudReemplazo;
	}

	public Boolean getCargarid_empleado_jefeSolicitudReemplazo() {
		return this.cargarid_empleado_jefeSolicitudReemplazo;
	}

	public void setCargarid_empleado_jefeSolicitudReemplazo(Boolean cargarid_empleado_jefeSolicitudReemplazo) {
		this.cargarid_empleado_jefeSolicitudReemplazo= cargarid_empleado_jefeSolicitudReemplazo;
	}

	public Border setResaltarid_empleadoSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarid_empleadoSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoSolicitudReemplazo() {
		return this.resaltarid_empleadoSolicitudReemplazo;
	}

	public void setResaltarid_empleadoSolicitudReemplazo(Border borderResaltar) {
		this.resaltarid_empleadoSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarid_empleadoSolicitudReemplazo() {
		return this.mostrarid_empleadoSolicitudReemplazo;
	}

	public void setMostrarid_empleadoSolicitudReemplazo(Boolean mostrarid_empleadoSolicitudReemplazo) {
		this.mostrarid_empleadoSolicitudReemplazo= mostrarid_empleadoSolicitudReemplazo;
	}

	public Boolean getActivarid_empleadoSolicitudReemplazo() {
		return this.activarid_empleadoSolicitudReemplazo;
	}

	public void setActivarid_empleadoSolicitudReemplazo(Boolean activarid_empleadoSolicitudReemplazo) {
		this.activarid_empleadoSolicitudReemplazo= activarid_empleadoSolicitudReemplazo;
	}

	public Boolean getCargarid_empleadoSolicitudReemplazo() {
		return this.cargarid_empleadoSolicitudReemplazo;
	}

	public void setCargarid_empleadoSolicitudReemplazo(Boolean cargarid_empleadoSolicitudReemplazo) {
		this.cargarid_empleadoSolicitudReemplazo= cargarid_empleadoSolicitudReemplazo;
	}

	public Border setResaltarid_empleado_reemplazoSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarid_empleado_reemplazoSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_reemplazoSolicitudReemplazo() {
		return this.resaltarid_empleado_reemplazoSolicitudReemplazo;
	}

	public void setResaltarid_empleado_reemplazoSolicitudReemplazo(Border borderResaltar) {
		this.resaltarid_empleado_reemplazoSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarid_empleado_reemplazoSolicitudReemplazo() {
		return this.mostrarid_empleado_reemplazoSolicitudReemplazo;
	}

	public void setMostrarid_empleado_reemplazoSolicitudReemplazo(Boolean mostrarid_empleado_reemplazoSolicitudReemplazo) {
		this.mostrarid_empleado_reemplazoSolicitudReemplazo= mostrarid_empleado_reemplazoSolicitudReemplazo;
	}

	public Boolean getActivarid_empleado_reemplazoSolicitudReemplazo() {
		return this.activarid_empleado_reemplazoSolicitudReemplazo;
	}

	public void setActivarid_empleado_reemplazoSolicitudReemplazo(Boolean activarid_empleado_reemplazoSolicitudReemplazo) {
		this.activarid_empleado_reemplazoSolicitudReemplazo= activarid_empleado_reemplazoSolicitudReemplazo;
	}

	public Boolean getCargarid_empleado_reemplazoSolicitudReemplazo() {
		return this.cargarid_empleado_reemplazoSolicitudReemplazo;
	}

	public void setCargarid_empleado_reemplazoSolicitudReemplazo(Boolean cargarid_empleado_reemplazoSolicitudReemplazo) {
		this.cargarid_empleado_reemplazoSolicitudReemplazo= cargarid_empleado_reemplazoSolicitudReemplazo;
	}

	public Border setResaltarid_estructuraSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarid_estructuraSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraSolicitudReemplazo() {
		return this.resaltarid_estructuraSolicitudReemplazo;
	}

	public void setResaltarid_estructuraSolicitudReemplazo(Border borderResaltar) {
		this.resaltarid_estructuraSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarid_estructuraSolicitudReemplazo() {
		return this.mostrarid_estructuraSolicitudReemplazo;
	}

	public void setMostrarid_estructuraSolicitudReemplazo(Boolean mostrarid_estructuraSolicitudReemplazo) {
		this.mostrarid_estructuraSolicitudReemplazo= mostrarid_estructuraSolicitudReemplazo;
	}

	public Boolean getActivarid_estructuraSolicitudReemplazo() {
		return this.activarid_estructuraSolicitudReemplazo;
	}

	public void setActivarid_estructuraSolicitudReemplazo(Boolean activarid_estructuraSolicitudReemplazo) {
		this.activarid_estructuraSolicitudReemplazo= activarid_estructuraSolicitudReemplazo;
	}

	public Boolean getCargarid_estructuraSolicitudReemplazo() {
		return this.cargarid_estructuraSolicitudReemplazo;
	}

	public void setCargarid_estructuraSolicitudReemplazo(Boolean cargarid_estructuraSolicitudReemplazo) {
		this.cargarid_estructuraSolicitudReemplazo= cargarid_estructuraSolicitudReemplazo;
	}

	public Border setResaltarid_estado_solicitud_nomiSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarid_estado_solicitud_nomiSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_solicitud_nomiSolicitudReemplazo() {
		return this.resaltarid_estado_solicitud_nomiSolicitudReemplazo;
	}

	public void setResaltarid_estado_solicitud_nomiSolicitudReemplazo(Border borderResaltar) {
		this.resaltarid_estado_solicitud_nomiSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarid_estado_solicitud_nomiSolicitudReemplazo() {
		return this.mostrarid_estado_solicitud_nomiSolicitudReemplazo;
	}

	public void setMostrarid_estado_solicitud_nomiSolicitudReemplazo(Boolean mostrarid_estado_solicitud_nomiSolicitudReemplazo) {
		this.mostrarid_estado_solicitud_nomiSolicitudReemplazo= mostrarid_estado_solicitud_nomiSolicitudReemplazo;
	}

	public Boolean getActivarid_estado_solicitud_nomiSolicitudReemplazo() {
		return this.activarid_estado_solicitud_nomiSolicitudReemplazo;
	}

	public void setActivarid_estado_solicitud_nomiSolicitudReemplazo(Boolean activarid_estado_solicitud_nomiSolicitudReemplazo) {
		this.activarid_estado_solicitud_nomiSolicitudReemplazo= activarid_estado_solicitud_nomiSolicitudReemplazo;
	}

	public Boolean getCargarid_estado_solicitud_nomiSolicitudReemplazo() {
		return this.cargarid_estado_solicitud_nomiSolicitudReemplazo;
	}

	public void setCargarid_estado_solicitud_nomiSolicitudReemplazo(Boolean cargarid_estado_solicitud_nomiSolicitudReemplazo) {
		this.cargarid_estado_solicitud_nomiSolicitudReemplazo= cargarid_estado_solicitud_nomiSolicitudReemplazo;
	}

	public Border setResaltarsecuencialSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarsecuencialSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialSolicitudReemplazo() {
		return this.resaltarsecuencialSolicitudReemplazo;
	}

	public void setResaltarsecuencialSolicitudReemplazo(Border borderResaltar) {
		this.resaltarsecuencialSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarsecuencialSolicitudReemplazo() {
		return this.mostrarsecuencialSolicitudReemplazo;
	}

	public void setMostrarsecuencialSolicitudReemplazo(Boolean mostrarsecuencialSolicitudReemplazo) {
		this.mostrarsecuencialSolicitudReemplazo= mostrarsecuencialSolicitudReemplazo;
	}

	public Boolean getActivarsecuencialSolicitudReemplazo() {
		return this.activarsecuencialSolicitudReemplazo;
	}

	public void setActivarsecuencialSolicitudReemplazo(Boolean activarsecuencialSolicitudReemplazo) {
		this.activarsecuencialSolicitudReemplazo= activarsecuencialSolicitudReemplazo;
	}

	public Border setResaltarfecha_solicitaSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarfecha_solicitaSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_solicitaSolicitudReemplazo() {
		return this.resaltarfecha_solicitaSolicitudReemplazo;
	}

	public void setResaltarfecha_solicitaSolicitudReemplazo(Border borderResaltar) {
		this.resaltarfecha_solicitaSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarfecha_solicitaSolicitudReemplazo() {
		return this.mostrarfecha_solicitaSolicitudReemplazo;
	}

	public void setMostrarfecha_solicitaSolicitudReemplazo(Boolean mostrarfecha_solicitaSolicitudReemplazo) {
		this.mostrarfecha_solicitaSolicitudReemplazo= mostrarfecha_solicitaSolicitudReemplazo;
	}

	public Boolean getActivarfecha_solicitaSolicitudReemplazo() {
		return this.activarfecha_solicitaSolicitudReemplazo;
	}

	public void setActivarfecha_solicitaSolicitudReemplazo(Boolean activarfecha_solicitaSolicitudReemplazo) {
		this.activarfecha_solicitaSolicitudReemplazo= activarfecha_solicitaSolicitudReemplazo;
	}

	public Border setResaltarfecha_ejecutaSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarfecha_ejecutaSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ejecutaSolicitudReemplazo() {
		return this.resaltarfecha_ejecutaSolicitudReemplazo;
	}

	public void setResaltarfecha_ejecutaSolicitudReemplazo(Border borderResaltar) {
		this.resaltarfecha_ejecutaSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarfecha_ejecutaSolicitudReemplazo() {
		return this.mostrarfecha_ejecutaSolicitudReemplazo;
	}

	public void setMostrarfecha_ejecutaSolicitudReemplazo(Boolean mostrarfecha_ejecutaSolicitudReemplazo) {
		this.mostrarfecha_ejecutaSolicitudReemplazo= mostrarfecha_ejecutaSolicitudReemplazo;
	}

	public Boolean getActivarfecha_ejecutaSolicitudReemplazo() {
		return this.activarfecha_ejecutaSolicitudReemplazo;
	}

	public void setActivarfecha_ejecutaSolicitudReemplazo(Boolean activarfecha_ejecutaSolicitudReemplazo) {
		this.activarfecha_ejecutaSolicitudReemplazo= activarfecha_ejecutaSolicitudReemplazo;
	}

	public Border setResaltarnumero_horasSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarnumero_horasSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_horasSolicitudReemplazo() {
		return this.resaltarnumero_horasSolicitudReemplazo;
	}

	public void setResaltarnumero_horasSolicitudReemplazo(Border borderResaltar) {
		this.resaltarnumero_horasSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarnumero_horasSolicitudReemplazo() {
		return this.mostrarnumero_horasSolicitudReemplazo;
	}

	public void setMostrarnumero_horasSolicitudReemplazo(Boolean mostrarnumero_horasSolicitudReemplazo) {
		this.mostrarnumero_horasSolicitudReemplazo= mostrarnumero_horasSolicitudReemplazo;
	}

	public Boolean getActivarnumero_horasSolicitudReemplazo() {
		return this.activarnumero_horasSolicitudReemplazo;
	}

	public void setActivarnumero_horasSolicitudReemplazo(Boolean activarnumero_horasSolicitudReemplazo) {
		this.activarnumero_horasSolicitudReemplazo= activarnumero_horasSolicitudReemplazo;
	}

	public Border setResaltarcosto_unitarioSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarcosto_unitarioSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioSolicitudReemplazo() {
		return this.resaltarcosto_unitarioSolicitudReemplazo;
	}

	public void setResaltarcosto_unitarioSolicitudReemplazo(Border borderResaltar) {
		this.resaltarcosto_unitarioSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioSolicitudReemplazo() {
		return this.mostrarcosto_unitarioSolicitudReemplazo;
	}

	public void setMostrarcosto_unitarioSolicitudReemplazo(Boolean mostrarcosto_unitarioSolicitudReemplazo) {
		this.mostrarcosto_unitarioSolicitudReemplazo= mostrarcosto_unitarioSolicitudReemplazo;
	}

	public Boolean getActivarcosto_unitarioSolicitudReemplazo() {
		return this.activarcosto_unitarioSolicitudReemplazo;
	}

	public void setActivarcosto_unitarioSolicitudReemplazo(Boolean activarcosto_unitarioSolicitudReemplazo) {
		this.activarcosto_unitarioSolicitudReemplazo= activarcosto_unitarioSolicitudReemplazo;
	}

	public Border setResaltarcosto_totalSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltarcosto_totalSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalSolicitudReemplazo() {
		return this.resaltarcosto_totalSolicitudReemplazo;
	}

	public void setResaltarcosto_totalSolicitudReemplazo(Border borderResaltar) {
		this.resaltarcosto_totalSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrarcosto_totalSolicitudReemplazo() {
		return this.mostrarcosto_totalSolicitudReemplazo;
	}

	public void setMostrarcosto_totalSolicitudReemplazo(Boolean mostrarcosto_totalSolicitudReemplazo) {
		this.mostrarcosto_totalSolicitudReemplazo= mostrarcosto_totalSolicitudReemplazo;
	}

	public Boolean getActivarcosto_totalSolicitudReemplazo() {
		return this.activarcosto_totalSolicitudReemplazo;
	}

	public void setActivarcosto_totalSolicitudReemplazo(Boolean activarcosto_totalSolicitudReemplazo) {
		this.activarcosto_totalSolicitudReemplazo= activarcosto_totalSolicitudReemplazo;
	}

	public Border setResaltardescripcionSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudreemplazoBeanSwingJInternalFrame.jTtoolBarSolicitudReemplazo.setBorder(borderResaltar);
		
		this.resaltardescripcionSolicitudReemplazo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionSolicitudReemplazo() {
		return this.resaltardescripcionSolicitudReemplazo;
	}

	public void setResaltardescripcionSolicitudReemplazo(Border borderResaltar) {
		this.resaltardescripcionSolicitudReemplazo= borderResaltar;
	}

	public Boolean getMostrardescripcionSolicitudReemplazo() {
		return this.mostrardescripcionSolicitudReemplazo;
	}

	public void setMostrardescripcionSolicitudReemplazo(Boolean mostrardescripcionSolicitudReemplazo) {
		this.mostrardescripcionSolicitudReemplazo= mostrardescripcionSolicitudReemplazo;
	}

	public Boolean getActivardescripcionSolicitudReemplazo() {
		return this.activardescripcionSolicitudReemplazo;
	}

	public void setActivardescripcionSolicitudReemplazo(Boolean activardescripcionSolicitudReemplazo) {
		this.activardescripcionSolicitudReemplazo= activardescripcionSolicitudReemplazo;
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
		
		
		this.setMostraridSolicitudReemplazo(esInicial);
		this.setMostrarid_empresaSolicitudReemplazo(esInicial);
		this.setMostrarid_sucursalSolicitudReemplazo(esInicial);
		this.setMostrarid_empleado_jefeSolicitudReemplazo(esInicial);
		this.setMostrarid_empleadoSolicitudReemplazo(esInicial);
		this.setMostrarid_empleado_reemplazoSolicitudReemplazo(esInicial);
		this.setMostrarid_estructuraSolicitudReemplazo(esInicial);
		this.setMostrarid_estado_solicitud_nomiSolicitudReemplazo(esInicial);
		this.setMostrarsecuencialSolicitudReemplazo(esInicial);
		this.setMostrarfecha_solicitaSolicitudReemplazo(esInicial);
		this.setMostrarfecha_ejecutaSolicitudReemplazo(esInicial);
		this.setMostrarnumero_horasSolicitudReemplazo(esInicial);
		this.setMostrarcosto_unitarioSolicitudReemplazo(esInicial);
		this.setMostrarcosto_totalSolicitudReemplazo(esInicial);
		this.setMostrardescripcionSolicitudReemplazo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.ID)) {
				this.setMostraridSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE)) {
				this.setMostrarid_empleado_jefeSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO)) {
				this.setMostrarid_empleado_reemplazoSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI)) {
				this.setMostrarid_estado_solicitud_nomiSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.FECHASOLICITA)) {
				this.setMostrarfecha_solicitaSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.FECHAEJECUTA)) {
				this.setMostrarfecha_ejecutaSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.NUMEROHORAS)) {
				this.setMostrarnumero_horasSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionSolicitudReemplazo(esAsigna);
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
		
		
		this.setActivaridSolicitudReemplazo(esInicial);
		this.setActivarid_empresaSolicitudReemplazo(esInicial);
		this.setActivarid_sucursalSolicitudReemplazo(esInicial);
		this.setActivarid_empleado_jefeSolicitudReemplazo(esInicial);
		this.setActivarid_empleadoSolicitudReemplazo(esInicial);
		this.setActivarid_empleado_reemplazoSolicitudReemplazo(esInicial);
		this.setActivarid_estructuraSolicitudReemplazo(esInicial);
		this.setActivarid_estado_solicitud_nomiSolicitudReemplazo(esInicial);
		this.setActivarsecuencialSolicitudReemplazo(esInicial);
		this.setActivarfecha_solicitaSolicitudReemplazo(esInicial);
		this.setActivarfecha_ejecutaSolicitudReemplazo(esInicial);
		this.setActivarnumero_horasSolicitudReemplazo(esInicial);
		this.setActivarcosto_unitarioSolicitudReemplazo(esInicial);
		this.setActivarcosto_totalSolicitudReemplazo(esInicial);
		this.setActivardescripcionSolicitudReemplazo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.ID)) {
				this.setActivaridSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE)) {
				this.setActivarid_empleado_jefeSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO)) {
				this.setActivarid_empleado_reemplazoSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI)) {
				this.setActivarid_estado_solicitud_nomiSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.FECHASOLICITA)) {
				this.setActivarfecha_solicitaSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.FECHAEJECUTA)) {
				this.setActivarfecha_ejecutaSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.NUMEROHORAS)) {
				this.setActivarnumero_horasSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionSolicitudReemplazo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSolicitudReemplazo(esInicial);
		this.setResaltarid_empresaSolicitudReemplazo(esInicial);
		this.setResaltarid_sucursalSolicitudReemplazo(esInicial);
		this.setResaltarid_empleado_jefeSolicitudReemplazo(esInicial);
		this.setResaltarid_empleadoSolicitudReemplazo(esInicial);
		this.setResaltarid_empleado_reemplazoSolicitudReemplazo(esInicial);
		this.setResaltarid_estructuraSolicitudReemplazo(esInicial);
		this.setResaltarid_estado_solicitud_nomiSolicitudReemplazo(esInicial);
		this.setResaltarsecuencialSolicitudReemplazo(esInicial);
		this.setResaltarfecha_solicitaSolicitudReemplazo(esInicial);
		this.setResaltarfecha_ejecutaSolicitudReemplazo(esInicial);
		this.setResaltarnumero_horasSolicitudReemplazo(esInicial);
		this.setResaltarcosto_unitarioSolicitudReemplazo(esInicial);
		this.setResaltarcosto_totalSolicitudReemplazo(esInicial);
		this.setResaltardescripcionSolicitudReemplazo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.ID)) {
				this.setResaltaridSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE)) {
				this.setResaltarid_empleado_jefeSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO)) {
				this.setResaltarid_empleado_reemplazoSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI)) {
				this.setResaltarid_estado_solicitud_nomiSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.FECHASOLICITA)) {
				this.setResaltarfecha_solicitaSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.FECHAEJECUTA)) {
				this.setResaltarfecha_ejecutaSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.NUMEROHORAS)) {
				this.setResaltarnumero_horasSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalSolicitudReemplazo(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudReemplazoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionSolicitudReemplazo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoSolicitudReemplazo=true;

	public Boolean getMostrarFK_IdEmpleadoSolicitudReemplazo() {
		return this.mostrarFK_IdEmpleadoSolicitudReemplazo;
	}

	public void setMostrarFK_IdEmpleadoSolicitudReemplazo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoSolicitudReemplazo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoJefeSolicitudReemplazo=true;

	public Boolean getMostrarFK_IdEmpleadoJefeSolicitudReemplazo() {
		return this.mostrarFK_IdEmpleadoJefeSolicitudReemplazo;
	}

	public void setMostrarFK_IdEmpleadoJefeSolicitudReemplazo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoJefeSolicitudReemplazo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoReemplazoSolicitudReemplazo=true;

	public Boolean getMostrarFK_IdEmpleadoReemplazoSolicitudReemplazo() {
		return this.mostrarFK_IdEmpleadoReemplazoSolicitudReemplazo;
	}

	public void setMostrarFK_IdEmpleadoReemplazoSolicitudReemplazo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoReemplazoSolicitudReemplazo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSolicitudReemplazo=true;

	public Boolean getMostrarFK_IdEmpresaSolicitudReemplazo() {
		return this.mostrarFK_IdEmpresaSolicitudReemplazo;
	}

	public void setMostrarFK_IdEmpresaSolicitudReemplazo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSolicitudReemplazo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoSolicitudNomiSolicitudReemplazo=true;

	public Boolean getMostrarFK_IdEstadoSolicitudNomiSolicitudReemplazo() {
		return this.mostrarFK_IdEstadoSolicitudNomiSolicitudReemplazo;
	}

	public void setMostrarFK_IdEstadoSolicitudNomiSolicitudReemplazo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoSolicitudNomiSolicitudReemplazo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraSolicitudReemplazo=true;

	public Boolean getMostrarFK_IdEstructuraSolicitudReemplazo() {
		return this.mostrarFK_IdEstructuraSolicitudReemplazo;
	}

	public void setMostrarFK_IdEstructuraSolicitudReemplazo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraSolicitudReemplazo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalSolicitudReemplazo=true;

	public Boolean getMostrarFK_IdSucursalSolicitudReemplazo() {
		return this.mostrarFK_IdSucursalSolicitudReemplazo;
	}

	public void setMostrarFK_IdSucursalSolicitudReemplazo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalSolicitudReemplazo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoSolicitudReemplazo=true;

	public Boolean getActivarFK_IdEmpleadoSolicitudReemplazo() {
		return this.activarFK_IdEmpleadoSolicitudReemplazo;
	}

	public void setActivarFK_IdEmpleadoSolicitudReemplazo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoSolicitudReemplazo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoJefeSolicitudReemplazo=true;

	public Boolean getActivarFK_IdEmpleadoJefeSolicitudReemplazo() {
		return this.activarFK_IdEmpleadoJefeSolicitudReemplazo;
	}

	public void setActivarFK_IdEmpleadoJefeSolicitudReemplazo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoJefeSolicitudReemplazo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoReemplazoSolicitudReemplazo=true;

	public Boolean getActivarFK_IdEmpleadoReemplazoSolicitudReemplazo() {
		return this.activarFK_IdEmpleadoReemplazoSolicitudReemplazo;
	}

	public void setActivarFK_IdEmpleadoReemplazoSolicitudReemplazo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoReemplazoSolicitudReemplazo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSolicitudReemplazo=true;

	public Boolean getActivarFK_IdEmpresaSolicitudReemplazo() {
		return this.activarFK_IdEmpresaSolicitudReemplazo;
	}

	public void setActivarFK_IdEmpresaSolicitudReemplazo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSolicitudReemplazo= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoSolicitudNomiSolicitudReemplazo=true;

	public Boolean getActivarFK_IdEstadoSolicitudNomiSolicitudReemplazo() {
		return this.activarFK_IdEstadoSolicitudNomiSolicitudReemplazo;
	}

	public void setActivarFK_IdEstadoSolicitudNomiSolicitudReemplazo(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoSolicitudNomiSolicitudReemplazo= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraSolicitudReemplazo=true;

	public Boolean getActivarFK_IdEstructuraSolicitudReemplazo() {
		return this.activarFK_IdEstructuraSolicitudReemplazo;
	}

	public void setActivarFK_IdEstructuraSolicitudReemplazo(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraSolicitudReemplazo= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalSolicitudReemplazo=true;

	public Boolean getActivarFK_IdSucursalSolicitudReemplazo() {
		return this.activarFK_IdSucursalSolicitudReemplazo;
	}

	public void setActivarFK_IdSucursalSolicitudReemplazo(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalSolicitudReemplazo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoSolicitudReemplazo=null;

	public Border getResaltarFK_IdEmpleadoSolicitudReemplazo() {
		return this.resaltarFK_IdEmpleadoSolicitudReemplazo;
	}

	public void setResaltarFK_IdEmpleadoSolicitudReemplazo(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoSolicitudReemplazo= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoSolicitudReemplazo= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoJefeSolicitudReemplazo=null;

	public Border getResaltarFK_IdEmpleadoJefeSolicitudReemplazo() {
		return this.resaltarFK_IdEmpleadoJefeSolicitudReemplazo;
	}

	public void setResaltarFK_IdEmpleadoJefeSolicitudReemplazo(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoJefeSolicitudReemplazo= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoJefeSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoJefeSolicitudReemplazo= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoReemplazoSolicitudReemplazo=null;

	public Border getResaltarFK_IdEmpleadoReemplazoSolicitudReemplazo() {
		return this.resaltarFK_IdEmpleadoReemplazoSolicitudReemplazo;
	}

	public void setResaltarFK_IdEmpleadoReemplazoSolicitudReemplazo(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoReemplazoSolicitudReemplazo= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoReemplazoSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoReemplazoSolicitudReemplazo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSolicitudReemplazo=null;

	public Border getResaltarFK_IdEmpresaSolicitudReemplazo() {
		return this.resaltarFK_IdEmpresaSolicitudReemplazo;
	}

	public void setResaltarFK_IdEmpresaSolicitudReemplazo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSolicitudReemplazo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSolicitudReemplazo= borderResaltar;
	}

	public Border resaltarFK_IdEstadoSolicitudNomiSolicitudReemplazo=null;

	public Border getResaltarFK_IdEstadoSolicitudNomiSolicitudReemplazo() {
		return this.resaltarFK_IdEstadoSolicitudNomiSolicitudReemplazo;
	}

	public void setResaltarFK_IdEstadoSolicitudNomiSolicitudReemplazo(Border borderResaltar) {
		this.resaltarFK_IdEstadoSolicitudNomiSolicitudReemplazo= borderResaltar;
	}

	public void setResaltarFK_IdEstadoSolicitudNomiSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoSolicitudNomiSolicitudReemplazo= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraSolicitudReemplazo=null;

	public Border getResaltarFK_IdEstructuraSolicitudReemplazo() {
		return this.resaltarFK_IdEstructuraSolicitudReemplazo;
	}

	public void setResaltarFK_IdEstructuraSolicitudReemplazo(Border borderResaltar) {
		this.resaltarFK_IdEstructuraSolicitudReemplazo= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraSolicitudReemplazo= borderResaltar;
	}

	public Border resaltarFK_IdSucursalSolicitudReemplazo=null;

	public Border getResaltarFK_IdSucursalSolicitudReemplazo() {
		return this.resaltarFK_IdSucursalSolicitudReemplazo;
	}

	public void setResaltarFK_IdSucursalSolicitudReemplazo(Border borderResaltar) {
		this.resaltarFK_IdSucursalSolicitudReemplazo= borderResaltar;
	}

	public void setResaltarFK_IdSucursalSolicitudReemplazo(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudReemplazoBeanSwingJInternalFrame solicitudreemplazoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalSolicitudReemplazo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}