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


import com.bydan.erp.nomina.util.SolicitudVacacionConstantesFunciones;
import com.bydan.erp.nomina.util.SolicitudVacacionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.SolicitudVacacionParameterGeneral;

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
final public class SolicitudVacacionConstantesFunciones extends SolicitudVacacionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SolicitudVacacion";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SolicitudVacacion"+SolicitudVacacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SolicitudVacacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SolicitudVacacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SolicitudVacacionConstantesFunciones.SCHEMA+"_"+SolicitudVacacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SolicitudVacacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SolicitudVacacionConstantesFunciones.SCHEMA+"_"+SolicitudVacacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SolicitudVacacionConstantesFunciones.SCHEMA+"_"+SolicitudVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SolicitudVacacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SolicitudVacacionConstantesFunciones.SCHEMA+"_"+SolicitudVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SolicitudVacacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SolicitudVacacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudVacacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SolicitudVacacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SolicitudVacacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SolicitudVacacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SolicitudVacacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Solicitud Vacaciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Solicitud Vacacion";
	public static final String SCLASSWEBTITULO_LOWER="Solicitud Vacacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SolicitudVacacion";
	public static final String OBJECTNAME="solicitudvacacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="solicitud_vacacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select solicitudvacacion from "+SolicitudVacacionConstantesFunciones.SPERSISTENCENAME+" solicitudvacacion";
	public static String QUERYSELECTNATIVE="select "+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".version_row,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_empresa,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_sucursal,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_empleado_jefe,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_empleado,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_estructura,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_estado_solicitud_nomi,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_formato,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".secuencial,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".fecha_solicita,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".fecha_ejecuta,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".numero_horas,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".costo_unitario,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".costo_total,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".descripcion from "+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME;//+" as "+SolicitudVacacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SolicitudVacacionConstantesFuncionesAdditional solicitudvacacionConstantesFuncionesAdditional=null;
	
	public SolicitudVacacionConstantesFuncionesAdditional getSolicitudVacacionConstantesFuncionesAdditional() {
		return this.solicitudvacacionConstantesFuncionesAdditional;
	}
	
	public void setSolicitudVacacionConstantesFuncionesAdditional(SolicitudVacacionConstantesFuncionesAdditional solicitudvacacionConstantesFuncionesAdditional) {
		try {
			this.solicitudvacacionConstantesFuncionesAdditional=solicitudvacacionConstantesFuncionesAdditional;
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
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDESTADOSOLICITUDNOMI= "id_estado_solicitud_nomi";
    public static final String IDFORMATO= "id_formato";
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
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDESTADOSOLICITUDNOMI= "Estado Solicitud Nomi";
		public static final String LABEL_IDESTADOSOLICITUDNOMI_LOWER= "Estado Solicitud Nomi";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
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
	
	public static String getSolicitudVacacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.IDEMPRESA)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_IDEMPLEADOJEFE;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.IDEMPLEADO)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.IDFORMATO)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.SECUENCIAL)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.FECHASOLICITA)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_FECHASOLICITA;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.FECHAEJECUTA)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_FECHAEJECUTA;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.NUMEROHORAS)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_NUMEROHORAS;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.COSTOTOTAL)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(SolicitudVacacionConstantesFunciones.DESCRIPCION)) {sLabelColumna=SolicitudVacacionConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSolicitudVacacionDescripcion(SolicitudVacacion solicitudvacacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(solicitudvacacion !=null/* && solicitudvacacion.getId()!=0*/) {
			if(solicitudvacacion.getId()!=null) {
				sDescripcion=solicitudvacacion.getId().toString();
			}//solicitudvacacionsolicitudvacacion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSolicitudVacacionDescripcionDetallado(SolicitudVacacion solicitudvacacion) {
		String sDescripcion="";
			
		sDescripcion+=SolicitudVacacionConstantesFunciones.ID+"=";
		sDescripcion+=solicitudvacacion.getId().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=solicitudvacacion.getVersionRow().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=solicitudvacacion.getid_empresa().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=solicitudvacacion.getid_sucursal().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE+"=";
		sDescripcion+=solicitudvacacion.getid_empleado_jefe().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=solicitudvacacion.getid_empleado().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=solicitudvacacion.getid_estructura().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI+"=";
		sDescripcion+=solicitudvacacion.getid_estado_solicitud_nomi().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=solicitudvacacion.getid_formato().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=solicitudvacacion.getsecuencial()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.FECHASOLICITA+"=";
		sDescripcion+=solicitudvacacion.getfecha_solicita().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.FECHAEJECUTA+"=";
		sDescripcion+=solicitudvacacion.getfecha_ejecuta().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.NUMEROHORAS+"=";
		sDescripcion+=solicitudvacacion.getnumero_horas().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=solicitudvacacion.getcosto_unitario().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=solicitudvacacion.getcosto_total().toString()+",";
		sDescripcion+=SolicitudVacacionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=solicitudvacacion.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setSolicitudVacacionDescripcion(SolicitudVacacion solicitudvacacion,String sValor) throws Exception {			
		if(solicitudvacacion !=null) {
			//solicitudvacacionsolicitudvacacion.getId().toString();
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

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoSolicitudNomi")) {
			sNombreIndice="Tipo=  Por Estado Solicitud Nomi";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
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

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSolicitudVacacion(SolicitudVacacion solicitudvacacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		solicitudvacacion.setsecuencial(solicitudvacacion.getsecuencial().trim());
		solicitudvacacion.setdescripcion(solicitudvacacion.getdescripcion().trim());
	}
	
	public static void quitarEspaciosSolicitudVacacions(List<SolicitudVacacion> solicitudvacacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SolicitudVacacion solicitudvacacion: solicitudvacacions) {
			solicitudvacacion.setsecuencial(solicitudvacacion.getsecuencial().trim());
			solicitudvacacion.setdescripcion(solicitudvacacion.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSolicitudVacacion(SolicitudVacacion solicitudvacacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && solicitudvacacion.getConCambioAuxiliar()) {
			solicitudvacacion.setIsDeleted(solicitudvacacion.getIsDeletedAuxiliar());	
			solicitudvacacion.setIsNew(solicitudvacacion.getIsNewAuxiliar());	
			solicitudvacacion.setIsChanged(solicitudvacacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			solicitudvacacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			solicitudvacacion.setIsDeletedAuxiliar(false);	
			solicitudvacacion.setIsNewAuxiliar(false);	
			solicitudvacacion.setIsChangedAuxiliar(false);
			
			solicitudvacacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSolicitudVacacions(List<SolicitudVacacion> solicitudvacacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SolicitudVacacion solicitudvacacion : solicitudvacacions) {
			if(conAsignarBase && solicitudvacacion.getConCambioAuxiliar()) {
				solicitudvacacion.setIsDeleted(solicitudvacacion.getIsDeletedAuxiliar());	
				solicitudvacacion.setIsNew(solicitudvacacion.getIsNewAuxiliar());	
				solicitudvacacion.setIsChanged(solicitudvacacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				solicitudvacacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				solicitudvacacion.setIsDeletedAuxiliar(false);	
				solicitudvacacion.setIsNewAuxiliar(false);	
				solicitudvacacion.setIsChangedAuxiliar(false);
				
				solicitudvacacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSolicitudVacacion(SolicitudVacacion solicitudvacacion,Boolean conEnteros) throws Exception  {
		solicitudvacacion.setcosto_unitario(0.0);
		solicitudvacacion.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			solicitudvacacion.setnumero_horas(0);
		}
	}		
	
	public static void InicializarValoresSolicitudVacacions(List<SolicitudVacacion> solicitudvacacions,Boolean conEnteros) throws Exception  {
		
		for(SolicitudVacacion solicitudvacacion: solicitudvacacions) {
			solicitudvacacion.setcosto_unitario(0.0);
			solicitudvacacion.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				solicitudvacacion.setnumero_horas(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaSolicitudVacacion(List<SolicitudVacacion> solicitudvacacions,SolicitudVacacion solicitudvacacionAux) throws Exception  {
		SolicitudVacacionConstantesFunciones.InicializarValoresSolicitudVacacion(solicitudvacacionAux,true);
		
		for(SolicitudVacacion solicitudvacacion: solicitudvacacions) {
			if(solicitudvacacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			solicitudvacacionAux.setnumero_horas(solicitudvacacionAux.getnumero_horas()+solicitudvacacion.getnumero_horas());			
			solicitudvacacionAux.setcosto_unitario(solicitudvacacionAux.getcosto_unitario()+solicitudvacacion.getcosto_unitario());			
			solicitudvacacionAux.setcosto_total(solicitudvacacionAux.getcosto_total()+solicitudvacacion.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSolicitudVacacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SolicitudVacacionConstantesFunciones.getArrayColumnasGlobalesSolicitudVacacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSolicitudVacacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SolicitudVacacionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SolicitudVacacionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SolicitudVacacionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SolicitudVacacionConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSolicitudVacacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SolicitudVacacion> solicitudvacacions,SolicitudVacacion solicitudvacacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SolicitudVacacion solicitudvacacionAux: solicitudvacacions) {
			if(solicitudvacacionAux!=null && solicitudvacacion!=null) {
				if((solicitudvacacionAux.getId()==null && solicitudvacacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(solicitudvacacionAux.getId()!=null && solicitudvacacion.getId()!=null){
					if(solicitudvacacionAux.getId().equals(solicitudvacacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSolicitudVacacion(List<SolicitudVacacion> solicitudvacacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(SolicitudVacacion solicitudvacacion: solicitudvacacions) {			
			if(solicitudvacacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costo_unitarioTotal+=solicitudvacacion.getcosto_unitario();
			costo_totalTotal+=solicitudvacacion.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SolicitudVacacionConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SolicitudVacacionConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSolicitudVacacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_ID, SolicitudVacacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_VERSIONROW, SolicitudVacacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_IDEMPRESA, SolicitudVacacionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_IDSUCURSAL, SolicitudVacacionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_IDEMPLEADOJEFE, SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_IDEMPLEADO, SolicitudVacacionConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_IDESTRUCTURA, SolicitudVacacionConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI, SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_IDFORMATO, SolicitudVacacionConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_SECUENCIAL, SolicitudVacacionConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_FECHASOLICITA, SolicitudVacacionConstantesFunciones.FECHASOLICITA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_FECHAEJECUTA, SolicitudVacacionConstantesFunciones.FECHAEJECUTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_NUMEROHORAS, SolicitudVacacionConstantesFunciones.NUMEROHORAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_COSTOUNITARIO, SolicitudVacacionConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_COSTOTOTAL, SolicitudVacacionConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudVacacionConstantesFunciones.LABEL_DESCRIPCION, SolicitudVacacionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSolicitudVacacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.FECHASOLICITA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.FECHAEJECUTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.NUMEROHORAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudVacacionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSolicitudVacacion() throws Exception  {
		return SolicitudVacacionConstantesFunciones.getTiposSeleccionarSolicitudVacacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSolicitudVacacion(Boolean conFk) throws Exception  {
		return SolicitudVacacionConstantesFunciones.getTiposSeleccionarSolicitudVacacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSolicitudVacacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_IDEMPLEADOJEFE);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_IDEMPLEADOJEFE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_FECHASOLICITA);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_FECHASOLICITA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_FECHAEJECUTA);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_FECHAEJECUTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_NUMEROHORAS);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_NUMEROHORAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudVacacionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(SolicitudVacacionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSolicitudVacacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSolicitudVacacion(SolicitudVacacion solicitudvacacionAux) throws Exception {
		
			solicitudvacacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(solicitudvacacionAux.getEmpresa()));
			solicitudvacacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(solicitudvacacionAux.getSucursal()));
			solicitudvacacionAux.setempleadojefe_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudvacacionAux.getEmpleadoJefe()));
			solicitudvacacionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudvacacionAux.getEmpleado()));
			solicitudvacacionAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(solicitudvacacionAux.getEstructura()));
			solicitudvacacionAux.setestadosolicitudnomi_descripcion(EstadoSolicitudNomiConstantesFunciones.getEstadoSolicitudNomiDescripcion(solicitudvacacionAux.getEstadoSolicitudNomi()));
			solicitudvacacionAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(solicitudvacacionAux.getFormato()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSolicitudVacacion(List<SolicitudVacacion> solicitudvacacionsTemp) throws Exception {
		for(SolicitudVacacion solicitudvacacionAux:solicitudvacacionsTemp) {
			
			solicitudvacacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(solicitudvacacionAux.getEmpresa()));
			solicitudvacacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(solicitudvacacionAux.getSucursal()));
			solicitudvacacionAux.setempleadojefe_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudvacacionAux.getEmpleadoJefe()));
			solicitudvacacionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudvacacionAux.getEmpleado()));
			solicitudvacacionAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(solicitudvacacionAux.getEstructura()));
			solicitudvacacionAux.setestadosolicitudnomi_descripcion(EstadoSolicitudNomiConstantesFunciones.getEstadoSolicitudNomiDescripcion(solicitudvacacionAux.getEstadoSolicitudNomi()));
			solicitudvacacionAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(solicitudvacacionAux.getFormato()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSolicitudVacacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(EstadoSolicitudNomi.class));
				classes.add(new Classe(Formato.class));
				
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
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoSolicitudNomi.class)) {
						classes.add(new Classe(EstadoSolicitudNomi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSolicitudVacacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(EstadoSolicitudNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoSolicitudNomi.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(EstadoSolicitudNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoSolicitudNomi.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSolicitudVacacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SolicitudVacacionConstantesFunciones.getClassesRelationshipsOfSolicitudVacacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSolicitudVacacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSolicitudVacacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SolicitudVacacionConstantesFunciones.getClassesRelationshipsFromStringsOfSolicitudVacacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSolicitudVacacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SolicitudVacacion solicitudvacacion,List<SolicitudVacacion> solicitudvacacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SolicitudVacacion solicitudvacacionEncontrado=null;
			
			for(SolicitudVacacion solicitudvacacionLocal:solicitudvacacions) {
				if(solicitudvacacionLocal.getId().equals(solicitudvacacion.getId())) {
					solicitudvacacionEncontrado=solicitudvacacionLocal;
					
					solicitudvacacionLocal.setIsChanged(solicitudvacacion.getIsChanged());
					solicitudvacacionLocal.setIsNew(solicitudvacacion.getIsNew());
					solicitudvacacionLocal.setIsDeleted(solicitudvacacion.getIsDeleted());
					
					solicitudvacacionLocal.setGeneralEntityOriginal(solicitudvacacion.getGeneralEntityOriginal());
					
					solicitudvacacionLocal.setId(solicitudvacacion.getId());	
					solicitudvacacionLocal.setVersionRow(solicitudvacacion.getVersionRow());	
					solicitudvacacionLocal.setid_empresa(solicitudvacacion.getid_empresa());	
					solicitudvacacionLocal.setid_sucursal(solicitudvacacion.getid_sucursal());	
					solicitudvacacionLocal.setid_empleado_jefe(solicitudvacacion.getid_empleado_jefe());	
					solicitudvacacionLocal.setid_empleado(solicitudvacacion.getid_empleado());	
					solicitudvacacionLocal.setid_estructura(solicitudvacacion.getid_estructura());	
					solicitudvacacionLocal.setid_estado_solicitud_nomi(solicitudvacacion.getid_estado_solicitud_nomi());	
					solicitudvacacionLocal.setid_formato(solicitudvacacion.getid_formato());	
					solicitudvacacionLocal.setsecuencial(solicitudvacacion.getsecuencial());	
					solicitudvacacionLocal.setfecha_solicita(solicitudvacacion.getfecha_solicita());	
					solicitudvacacionLocal.setfecha_ejecuta(solicitudvacacion.getfecha_ejecuta());	
					solicitudvacacionLocal.setnumero_horas(solicitudvacacion.getnumero_horas());	
					solicitudvacacionLocal.setcosto_unitario(solicitudvacacion.getcosto_unitario());	
					solicitudvacacionLocal.setcosto_total(solicitudvacacion.getcosto_total());	
					solicitudvacacionLocal.setdescripcion(solicitudvacacion.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!solicitudvacacion.getIsDeleted()) {
				if(!existe) {
					solicitudvacacions.add(solicitudvacacion);
				}
			} else {
				if(solicitudvacacionEncontrado!=null && permiteQuitar)  {
					solicitudvacacions.remove(solicitudvacacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SolicitudVacacion solicitudvacacion,List<SolicitudVacacion> solicitudvacacions) throws Exception {
		try	{			
			for(SolicitudVacacion solicitudvacacionLocal:solicitudvacacions) {
				if(solicitudvacacionLocal.getId().equals(solicitudvacacion.getId())) {
					solicitudvacacionLocal.setIsSelected(solicitudvacacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSolicitudVacacion(List<SolicitudVacacion> solicitudvacacionsAux) throws Exception {
		//this.solicitudvacacionsAux=solicitudvacacionsAux;
		
		for(SolicitudVacacion solicitudvacacionAux:solicitudvacacionsAux) {
			if(solicitudvacacionAux.getIsChanged()) {
				solicitudvacacionAux.setIsChanged(false);
			}		
			
			if(solicitudvacacionAux.getIsNew()) {
				solicitudvacacionAux.setIsNew(false);
			}	
			
			if(solicitudvacacionAux.getIsDeleted()) {
				solicitudvacacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSolicitudVacacion(SolicitudVacacion solicitudvacacionAux) throws Exception {
		//this.solicitudvacacionAux=solicitudvacacionAux;
		
			if(solicitudvacacionAux.getIsChanged()) {
				solicitudvacacionAux.setIsChanged(false);
			}		
			
			if(solicitudvacacionAux.getIsNew()) {
				solicitudvacacionAux.setIsNew(false);
			}	
			
			if(solicitudvacacionAux.getIsDeleted()) {
				solicitudvacacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SolicitudVacacion solicitudvacacionAsignar,SolicitudVacacion solicitudvacacion) throws Exception {
		solicitudvacacionAsignar.setId(solicitudvacacion.getId());	
		solicitudvacacionAsignar.setVersionRow(solicitudvacacion.getVersionRow());	
		solicitudvacacionAsignar.setid_empresa(solicitudvacacion.getid_empresa());
		solicitudvacacionAsignar.setempresa_descripcion(solicitudvacacion.getempresa_descripcion());	
		solicitudvacacionAsignar.setid_sucursal(solicitudvacacion.getid_sucursal());
		solicitudvacacionAsignar.setsucursal_descripcion(solicitudvacacion.getsucursal_descripcion());	
		solicitudvacacionAsignar.setid_empleado_jefe(solicitudvacacion.getid_empleado_jefe());
		solicitudvacacionAsignar.setempleadojefe_descripcion(solicitudvacacion.getempleadojefe_descripcion());	
		solicitudvacacionAsignar.setid_empleado(solicitudvacacion.getid_empleado());
		solicitudvacacionAsignar.setempleado_descripcion(solicitudvacacion.getempleado_descripcion());	
		solicitudvacacionAsignar.setid_estructura(solicitudvacacion.getid_estructura());
		solicitudvacacionAsignar.setestructura_descripcion(solicitudvacacion.getestructura_descripcion());	
		solicitudvacacionAsignar.setid_estado_solicitud_nomi(solicitudvacacion.getid_estado_solicitud_nomi());
		solicitudvacacionAsignar.setestadosolicitudnomi_descripcion(solicitudvacacion.getestadosolicitudnomi_descripcion());	
		solicitudvacacionAsignar.setid_formato(solicitudvacacion.getid_formato());
		solicitudvacacionAsignar.setformato_descripcion(solicitudvacacion.getformato_descripcion());	
		solicitudvacacionAsignar.setsecuencial(solicitudvacacion.getsecuencial());	
		solicitudvacacionAsignar.setfecha_solicita(solicitudvacacion.getfecha_solicita());	
		solicitudvacacionAsignar.setfecha_ejecuta(solicitudvacacion.getfecha_ejecuta());	
		solicitudvacacionAsignar.setnumero_horas(solicitudvacacion.getnumero_horas());	
		solicitudvacacionAsignar.setcosto_unitario(solicitudvacacion.getcosto_unitario());	
		solicitudvacacionAsignar.setcosto_total(solicitudvacacion.getcosto_total());	
		solicitudvacacionAsignar.setdescripcion(solicitudvacacion.getdescripcion());	
	}
	
	public static void inicializarSolicitudVacacion(SolicitudVacacion solicitudvacacion) throws Exception {
		try {
				solicitudvacacion.setId(0L);	
					
				solicitudvacacion.setid_empresa(-1L);	
				solicitudvacacion.setid_sucursal(-1L);	
				solicitudvacacion.setid_empleado_jefe(-1L);	
				solicitudvacacion.setid_empleado(-1L);	
				solicitudvacacion.setid_estructura(-1L);	
				solicitudvacacion.setid_estado_solicitud_nomi(-1L);	
				solicitudvacacion.setid_formato(-1L);	
				solicitudvacacion.setsecuencial("");	
				solicitudvacacion.setfecha_solicita(new Date());	
				solicitudvacacion.setfecha_ejecuta(new Date());	
				solicitudvacacion.setnumero_horas(0);	
				solicitudvacacion.setcosto_unitario(0.0);	
				solicitudvacacion.setcosto_total(0.0);	
				solicitudvacacion.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSolicitudVacacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_IDEMPLEADOJEFE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_FECHASOLICITA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_FECHAEJECUTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_NUMEROHORAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudVacacionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSolicitudVacacion(String sTipo,Row row,Workbook workbook,SolicitudVacacion solicitudvacacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getempleadojefe_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getestadosolicitudnomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getfecha_solicita());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getfecha_ejecuta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getnumero_horas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudvacacion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySolicitudVacacion=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySolicitudVacacion() {
		return this.sFinalQuerySolicitudVacacion;
	}
	
	public void setsFinalQuerySolicitudVacacion(String sFinalQuerySolicitudVacacion) {
		this.sFinalQuerySolicitudVacacion= sFinalQuerySolicitudVacacion;
	}
	
	public Border resaltarSeleccionarSolicitudVacacion=null;
	
	public Border setResaltarSeleccionarSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSolicitudVacacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSolicitudVacacion() {
		return this.resaltarSeleccionarSolicitudVacacion;
	}
	
	public void setResaltarSeleccionarSolicitudVacacion(Border borderResaltarSeleccionarSolicitudVacacion) {
		this.resaltarSeleccionarSolicitudVacacion= borderResaltarSeleccionarSolicitudVacacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSolicitudVacacion=null;
	public Boolean mostraridSolicitudVacacion=true;
	public Boolean activaridSolicitudVacacion=true;

	public Border resaltarid_empresaSolicitudVacacion=null;
	public Boolean mostrarid_empresaSolicitudVacacion=true;
	public Boolean activarid_empresaSolicitudVacacion=true;
	public Boolean cargarid_empresaSolicitudVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSolicitudVacacion=false;//ConEventDepend=true

	public Border resaltarid_sucursalSolicitudVacacion=null;
	public Boolean mostrarid_sucursalSolicitudVacacion=true;
	public Boolean activarid_sucursalSolicitudVacacion=true;
	public Boolean cargarid_sucursalSolicitudVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalSolicitudVacacion=false;//ConEventDepend=true

	public Border resaltarid_empleado_jefeSolicitudVacacion=null;
	public Boolean mostrarid_empleado_jefeSolicitudVacacion=true;
	public Boolean activarid_empleado_jefeSolicitudVacacion=true;
	public Boolean cargarid_empleado_jefeSolicitudVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_jefeSolicitudVacacion=false;//ConEventDepend=true

	public Border resaltarid_empleadoSolicitudVacacion=null;
	public Boolean mostrarid_empleadoSolicitudVacacion=true;
	public Boolean activarid_empleadoSolicitudVacacion=true;
	public Boolean cargarid_empleadoSolicitudVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoSolicitudVacacion=false;//ConEventDepend=true

	public Border resaltarid_estructuraSolicitudVacacion=null;
	public Boolean mostrarid_estructuraSolicitudVacacion=true;
	public Boolean activarid_estructuraSolicitudVacacion=true;
	public Boolean cargarid_estructuraSolicitudVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraSolicitudVacacion=false;//ConEventDepend=true

	public Border resaltarid_estado_solicitud_nomiSolicitudVacacion=null;
	public Boolean mostrarid_estado_solicitud_nomiSolicitudVacacion=true;
	public Boolean activarid_estado_solicitud_nomiSolicitudVacacion=true;
	public Boolean cargarid_estado_solicitud_nomiSolicitudVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_solicitud_nomiSolicitudVacacion=false;//ConEventDepend=true

	public Border resaltarid_formatoSolicitudVacacion=null;
	public Boolean mostrarid_formatoSolicitudVacacion=true;
	public Boolean activarid_formatoSolicitudVacacion=true;
	public Boolean cargarid_formatoSolicitudVacacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoSolicitudVacacion=false;//ConEventDepend=true

	public Border resaltarsecuencialSolicitudVacacion=null;
	public Boolean mostrarsecuencialSolicitudVacacion=true;
	public Boolean activarsecuencialSolicitudVacacion=true;

	public Border resaltarfecha_solicitaSolicitudVacacion=null;
	public Boolean mostrarfecha_solicitaSolicitudVacacion=true;
	public Boolean activarfecha_solicitaSolicitudVacacion=false;

	public Border resaltarfecha_ejecutaSolicitudVacacion=null;
	public Boolean mostrarfecha_ejecutaSolicitudVacacion=true;
	public Boolean activarfecha_ejecutaSolicitudVacacion=false;

	public Border resaltarnumero_horasSolicitudVacacion=null;
	public Boolean mostrarnumero_horasSolicitudVacacion=true;
	public Boolean activarnumero_horasSolicitudVacacion=true;

	public Border resaltarcosto_unitarioSolicitudVacacion=null;
	public Boolean mostrarcosto_unitarioSolicitudVacacion=true;
	public Boolean activarcosto_unitarioSolicitudVacacion=true;

	public Border resaltarcosto_totalSolicitudVacacion=null;
	public Boolean mostrarcosto_totalSolicitudVacacion=true;
	public Boolean activarcosto_totalSolicitudVacacion=true;

	public Border resaltardescripcionSolicitudVacacion=null;
	public Boolean mostrardescripcionSolicitudVacacion=true;
	public Boolean activardescripcionSolicitudVacacion=true;

	
	

	public Border setResaltaridSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltaridSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSolicitudVacacion() {
		return this.resaltaridSolicitudVacacion;
	}

	public void setResaltaridSolicitudVacacion(Border borderResaltar) {
		this.resaltaridSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostraridSolicitudVacacion() {
		return this.mostraridSolicitudVacacion;
	}

	public void setMostraridSolicitudVacacion(Boolean mostraridSolicitudVacacion) {
		this.mostraridSolicitudVacacion= mostraridSolicitudVacacion;
	}

	public Boolean getActivaridSolicitudVacacion() {
		return this.activaridSolicitudVacacion;
	}

	public void setActivaridSolicitudVacacion(Boolean activaridSolicitudVacacion) {
		this.activaridSolicitudVacacion= activaridSolicitudVacacion;
	}

	public Border setResaltarid_empresaSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarid_empresaSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSolicitudVacacion() {
		return this.resaltarid_empresaSolicitudVacacion;
	}

	public void setResaltarid_empresaSolicitudVacacion(Border borderResaltar) {
		this.resaltarid_empresaSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarid_empresaSolicitudVacacion() {
		return this.mostrarid_empresaSolicitudVacacion;
	}

	public void setMostrarid_empresaSolicitudVacacion(Boolean mostrarid_empresaSolicitudVacacion) {
		this.mostrarid_empresaSolicitudVacacion= mostrarid_empresaSolicitudVacacion;
	}

	public Boolean getActivarid_empresaSolicitudVacacion() {
		return this.activarid_empresaSolicitudVacacion;
	}

	public void setActivarid_empresaSolicitudVacacion(Boolean activarid_empresaSolicitudVacacion) {
		this.activarid_empresaSolicitudVacacion= activarid_empresaSolicitudVacacion;
	}

	public Boolean getCargarid_empresaSolicitudVacacion() {
		return this.cargarid_empresaSolicitudVacacion;
	}

	public void setCargarid_empresaSolicitudVacacion(Boolean cargarid_empresaSolicitudVacacion) {
		this.cargarid_empresaSolicitudVacacion= cargarid_empresaSolicitudVacacion;
	}

	public Border setResaltarid_sucursalSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalSolicitudVacacion() {
		return this.resaltarid_sucursalSolicitudVacacion;
	}

	public void setResaltarid_sucursalSolicitudVacacion(Border borderResaltar) {
		this.resaltarid_sucursalSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalSolicitudVacacion() {
		return this.mostrarid_sucursalSolicitudVacacion;
	}

	public void setMostrarid_sucursalSolicitudVacacion(Boolean mostrarid_sucursalSolicitudVacacion) {
		this.mostrarid_sucursalSolicitudVacacion= mostrarid_sucursalSolicitudVacacion;
	}

	public Boolean getActivarid_sucursalSolicitudVacacion() {
		return this.activarid_sucursalSolicitudVacacion;
	}

	public void setActivarid_sucursalSolicitudVacacion(Boolean activarid_sucursalSolicitudVacacion) {
		this.activarid_sucursalSolicitudVacacion= activarid_sucursalSolicitudVacacion;
	}

	public Boolean getCargarid_sucursalSolicitudVacacion() {
		return this.cargarid_sucursalSolicitudVacacion;
	}

	public void setCargarid_sucursalSolicitudVacacion(Boolean cargarid_sucursalSolicitudVacacion) {
		this.cargarid_sucursalSolicitudVacacion= cargarid_sucursalSolicitudVacacion;
	}

	public Border setResaltarid_empleado_jefeSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarid_empleado_jefeSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_jefeSolicitudVacacion() {
		return this.resaltarid_empleado_jefeSolicitudVacacion;
	}

	public void setResaltarid_empleado_jefeSolicitudVacacion(Border borderResaltar) {
		this.resaltarid_empleado_jefeSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarid_empleado_jefeSolicitudVacacion() {
		return this.mostrarid_empleado_jefeSolicitudVacacion;
	}

	public void setMostrarid_empleado_jefeSolicitudVacacion(Boolean mostrarid_empleado_jefeSolicitudVacacion) {
		this.mostrarid_empleado_jefeSolicitudVacacion= mostrarid_empleado_jefeSolicitudVacacion;
	}

	public Boolean getActivarid_empleado_jefeSolicitudVacacion() {
		return this.activarid_empleado_jefeSolicitudVacacion;
	}

	public void setActivarid_empleado_jefeSolicitudVacacion(Boolean activarid_empleado_jefeSolicitudVacacion) {
		this.activarid_empleado_jefeSolicitudVacacion= activarid_empleado_jefeSolicitudVacacion;
	}

	public Boolean getCargarid_empleado_jefeSolicitudVacacion() {
		return this.cargarid_empleado_jefeSolicitudVacacion;
	}

	public void setCargarid_empleado_jefeSolicitudVacacion(Boolean cargarid_empleado_jefeSolicitudVacacion) {
		this.cargarid_empleado_jefeSolicitudVacacion= cargarid_empleado_jefeSolicitudVacacion;
	}

	public Border setResaltarid_empleadoSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarid_empleadoSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoSolicitudVacacion() {
		return this.resaltarid_empleadoSolicitudVacacion;
	}

	public void setResaltarid_empleadoSolicitudVacacion(Border borderResaltar) {
		this.resaltarid_empleadoSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarid_empleadoSolicitudVacacion() {
		return this.mostrarid_empleadoSolicitudVacacion;
	}

	public void setMostrarid_empleadoSolicitudVacacion(Boolean mostrarid_empleadoSolicitudVacacion) {
		this.mostrarid_empleadoSolicitudVacacion= mostrarid_empleadoSolicitudVacacion;
	}

	public Boolean getActivarid_empleadoSolicitudVacacion() {
		return this.activarid_empleadoSolicitudVacacion;
	}

	public void setActivarid_empleadoSolicitudVacacion(Boolean activarid_empleadoSolicitudVacacion) {
		this.activarid_empleadoSolicitudVacacion= activarid_empleadoSolicitudVacacion;
	}

	public Boolean getCargarid_empleadoSolicitudVacacion() {
		return this.cargarid_empleadoSolicitudVacacion;
	}

	public void setCargarid_empleadoSolicitudVacacion(Boolean cargarid_empleadoSolicitudVacacion) {
		this.cargarid_empleadoSolicitudVacacion= cargarid_empleadoSolicitudVacacion;
	}

	public Border setResaltarid_estructuraSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarid_estructuraSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraSolicitudVacacion() {
		return this.resaltarid_estructuraSolicitudVacacion;
	}

	public void setResaltarid_estructuraSolicitudVacacion(Border borderResaltar) {
		this.resaltarid_estructuraSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarid_estructuraSolicitudVacacion() {
		return this.mostrarid_estructuraSolicitudVacacion;
	}

	public void setMostrarid_estructuraSolicitudVacacion(Boolean mostrarid_estructuraSolicitudVacacion) {
		this.mostrarid_estructuraSolicitudVacacion= mostrarid_estructuraSolicitudVacacion;
	}

	public Boolean getActivarid_estructuraSolicitudVacacion() {
		return this.activarid_estructuraSolicitudVacacion;
	}

	public void setActivarid_estructuraSolicitudVacacion(Boolean activarid_estructuraSolicitudVacacion) {
		this.activarid_estructuraSolicitudVacacion= activarid_estructuraSolicitudVacacion;
	}

	public Boolean getCargarid_estructuraSolicitudVacacion() {
		return this.cargarid_estructuraSolicitudVacacion;
	}

	public void setCargarid_estructuraSolicitudVacacion(Boolean cargarid_estructuraSolicitudVacacion) {
		this.cargarid_estructuraSolicitudVacacion= cargarid_estructuraSolicitudVacacion;
	}

	public Border setResaltarid_estado_solicitud_nomiSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarid_estado_solicitud_nomiSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_solicitud_nomiSolicitudVacacion() {
		return this.resaltarid_estado_solicitud_nomiSolicitudVacacion;
	}

	public void setResaltarid_estado_solicitud_nomiSolicitudVacacion(Border borderResaltar) {
		this.resaltarid_estado_solicitud_nomiSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarid_estado_solicitud_nomiSolicitudVacacion() {
		return this.mostrarid_estado_solicitud_nomiSolicitudVacacion;
	}

	public void setMostrarid_estado_solicitud_nomiSolicitudVacacion(Boolean mostrarid_estado_solicitud_nomiSolicitudVacacion) {
		this.mostrarid_estado_solicitud_nomiSolicitudVacacion= mostrarid_estado_solicitud_nomiSolicitudVacacion;
	}

	public Boolean getActivarid_estado_solicitud_nomiSolicitudVacacion() {
		return this.activarid_estado_solicitud_nomiSolicitudVacacion;
	}

	public void setActivarid_estado_solicitud_nomiSolicitudVacacion(Boolean activarid_estado_solicitud_nomiSolicitudVacacion) {
		this.activarid_estado_solicitud_nomiSolicitudVacacion= activarid_estado_solicitud_nomiSolicitudVacacion;
	}

	public Boolean getCargarid_estado_solicitud_nomiSolicitudVacacion() {
		return this.cargarid_estado_solicitud_nomiSolicitudVacacion;
	}

	public void setCargarid_estado_solicitud_nomiSolicitudVacacion(Boolean cargarid_estado_solicitud_nomiSolicitudVacacion) {
		this.cargarid_estado_solicitud_nomiSolicitudVacacion= cargarid_estado_solicitud_nomiSolicitudVacacion;
	}

	public Border setResaltarid_formatoSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarid_formatoSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoSolicitudVacacion() {
		return this.resaltarid_formatoSolicitudVacacion;
	}

	public void setResaltarid_formatoSolicitudVacacion(Border borderResaltar) {
		this.resaltarid_formatoSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarid_formatoSolicitudVacacion() {
		return this.mostrarid_formatoSolicitudVacacion;
	}

	public void setMostrarid_formatoSolicitudVacacion(Boolean mostrarid_formatoSolicitudVacacion) {
		this.mostrarid_formatoSolicitudVacacion= mostrarid_formatoSolicitudVacacion;
	}

	public Boolean getActivarid_formatoSolicitudVacacion() {
		return this.activarid_formatoSolicitudVacacion;
	}

	public void setActivarid_formatoSolicitudVacacion(Boolean activarid_formatoSolicitudVacacion) {
		this.activarid_formatoSolicitudVacacion= activarid_formatoSolicitudVacacion;
	}

	public Boolean getCargarid_formatoSolicitudVacacion() {
		return this.cargarid_formatoSolicitudVacacion;
	}

	public void setCargarid_formatoSolicitudVacacion(Boolean cargarid_formatoSolicitudVacacion) {
		this.cargarid_formatoSolicitudVacacion= cargarid_formatoSolicitudVacacion;
	}

	public Border setResaltarsecuencialSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarsecuencialSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialSolicitudVacacion() {
		return this.resaltarsecuencialSolicitudVacacion;
	}

	public void setResaltarsecuencialSolicitudVacacion(Border borderResaltar) {
		this.resaltarsecuencialSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarsecuencialSolicitudVacacion() {
		return this.mostrarsecuencialSolicitudVacacion;
	}

	public void setMostrarsecuencialSolicitudVacacion(Boolean mostrarsecuencialSolicitudVacacion) {
		this.mostrarsecuencialSolicitudVacacion= mostrarsecuencialSolicitudVacacion;
	}

	public Boolean getActivarsecuencialSolicitudVacacion() {
		return this.activarsecuencialSolicitudVacacion;
	}

	public void setActivarsecuencialSolicitudVacacion(Boolean activarsecuencialSolicitudVacacion) {
		this.activarsecuencialSolicitudVacacion= activarsecuencialSolicitudVacacion;
	}

	public Border setResaltarfecha_solicitaSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarfecha_solicitaSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_solicitaSolicitudVacacion() {
		return this.resaltarfecha_solicitaSolicitudVacacion;
	}

	public void setResaltarfecha_solicitaSolicitudVacacion(Border borderResaltar) {
		this.resaltarfecha_solicitaSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarfecha_solicitaSolicitudVacacion() {
		return this.mostrarfecha_solicitaSolicitudVacacion;
	}

	public void setMostrarfecha_solicitaSolicitudVacacion(Boolean mostrarfecha_solicitaSolicitudVacacion) {
		this.mostrarfecha_solicitaSolicitudVacacion= mostrarfecha_solicitaSolicitudVacacion;
	}

	public Boolean getActivarfecha_solicitaSolicitudVacacion() {
		return this.activarfecha_solicitaSolicitudVacacion;
	}

	public void setActivarfecha_solicitaSolicitudVacacion(Boolean activarfecha_solicitaSolicitudVacacion) {
		this.activarfecha_solicitaSolicitudVacacion= activarfecha_solicitaSolicitudVacacion;
	}

	public Border setResaltarfecha_ejecutaSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarfecha_ejecutaSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ejecutaSolicitudVacacion() {
		return this.resaltarfecha_ejecutaSolicitudVacacion;
	}

	public void setResaltarfecha_ejecutaSolicitudVacacion(Border borderResaltar) {
		this.resaltarfecha_ejecutaSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarfecha_ejecutaSolicitudVacacion() {
		return this.mostrarfecha_ejecutaSolicitudVacacion;
	}

	public void setMostrarfecha_ejecutaSolicitudVacacion(Boolean mostrarfecha_ejecutaSolicitudVacacion) {
		this.mostrarfecha_ejecutaSolicitudVacacion= mostrarfecha_ejecutaSolicitudVacacion;
	}

	public Boolean getActivarfecha_ejecutaSolicitudVacacion() {
		return this.activarfecha_ejecutaSolicitudVacacion;
	}

	public void setActivarfecha_ejecutaSolicitudVacacion(Boolean activarfecha_ejecutaSolicitudVacacion) {
		this.activarfecha_ejecutaSolicitudVacacion= activarfecha_ejecutaSolicitudVacacion;
	}

	public Border setResaltarnumero_horasSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarnumero_horasSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_horasSolicitudVacacion() {
		return this.resaltarnumero_horasSolicitudVacacion;
	}

	public void setResaltarnumero_horasSolicitudVacacion(Border borderResaltar) {
		this.resaltarnumero_horasSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarnumero_horasSolicitudVacacion() {
		return this.mostrarnumero_horasSolicitudVacacion;
	}

	public void setMostrarnumero_horasSolicitudVacacion(Boolean mostrarnumero_horasSolicitudVacacion) {
		this.mostrarnumero_horasSolicitudVacacion= mostrarnumero_horasSolicitudVacacion;
	}

	public Boolean getActivarnumero_horasSolicitudVacacion() {
		return this.activarnumero_horasSolicitudVacacion;
	}

	public void setActivarnumero_horasSolicitudVacacion(Boolean activarnumero_horasSolicitudVacacion) {
		this.activarnumero_horasSolicitudVacacion= activarnumero_horasSolicitudVacacion;
	}

	public Border setResaltarcosto_unitarioSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarcosto_unitarioSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioSolicitudVacacion() {
		return this.resaltarcosto_unitarioSolicitudVacacion;
	}

	public void setResaltarcosto_unitarioSolicitudVacacion(Border borderResaltar) {
		this.resaltarcosto_unitarioSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioSolicitudVacacion() {
		return this.mostrarcosto_unitarioSolicitudVacacion;
	}

	public void setMostrarcosto_unitarioSolicitudVacacion(Boolean mostrarcosto_unitarioSolicitudVacacion) {
		this.mostrarcosto_unitarioSolicitudVacacion= mostrarcosto_unitarioSolicitudVacacion;
	}

	public Boolean getActivarcosto_unitarioSolicitudVacacion() {
		return this.activarcosto_unitarioSolicitudVacacion;
	}

	public void setActivarcosto_unitarioSolicitudVacacion(Boolean activarcosto_unitarioSolicitudVacacion) {
		this.activarcosto_unitarioSolicitudVacacion= activarcosto_unitarioSolicitudVacacion;
	}

	public Border setResaltarcosto_totalSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltarcosto_totalSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalSolicitudVacacion() {
		return this.resaltarcosto_totalSolicitudVacacion;
	}

	public void setResaltarcosto_totalSolicitudVacacion(Border borderResaltar) {
		this.resaltarcosto_totalSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrarcosto_totalSolicitudVacacion() {
		return this.mostrarcosto_totalSolicitudVacacion;
	}

	public void setMostrarcosto_totalSolicitudVacacion(Boolean mostrarcosto_totalSolicitudVacacion) {
		this.mostrarcosto_totalSolicitudVacacion= mostrarcosto_totalSolicitudVacacion;
	}

	public Boolean getActivarcosto_totalSolicitudVacacion() {
		return this.activarcosto_totalSolicitudVacacion;
	}

	public void setActivarcosto_totalSolicitudVacacion(Boolean activarcosto_totalSolicitudVacacion) {
		this.activarcosto_totalSolicitudVacacion= activarcosto_totalSolicitudVacacion;
	}

	public Border setResaltardescripcionSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudvacacionBeanSwingJInternalFrame.jTtoolBarSolicitudVacacion.setBorder(borderResaltar);
		
		this.resaltardescripcionSolicitudVacacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionSolicitudVacacion() {
		return this.resaltardescripcionSolicitudVacacion;
	}

	public void setResaltardescripcionSolicitudVacacion(Border borderResaltar) {
		this.resaltardescripcionSolicitudVacacion= borderResaltar;
	}

	public Boolean getMostrardescripcionSolicitudVacacion() {
		return this.mostrardescripcionSolicitudVacacion;
	}

	public void setMostrardescripcionSolicitudVacacion(Boolean mostrardescripcionSolicitudVacacion) {
		this.mostrardescripcionSolicitudVacacion= mostrardescripcionSolicitudVacacion;
	}

	public Boolean getActivardescripcionSolicitudVacacion() {
		return this.activardescripcionSolicitudVacacion;
	}

	public void setActivardescripcionSolicitudVacacion(Boolean activardescripcionSolicitudVacacion) {
		this.activardescripcionSolicitudVacacion= activardescripcionSolicitudVacacion;
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
		
		
		this.setMostraridSolicitudVacacion(esInicial);
		this.setMostrarid_empresaSolicitudVacacion(esInicial);
		this.setMostrarid_sucursalSolicitudVacacion(esInicial);
		this.setMostrarid_empleado_jefeSolicitudVacacion(esInicial);
		this.setMostrarid_empleadoSolicitudVacacion(esInicial);
		this.setMostrarid_estructuraSolicitudVacacion(esInicial);
		this.setMostrarid_estado_solicitud_nomiSolicitudVacacion(esInicial);
		this.setMostrarid_formatoSolicitudVacacion(esInicial);
		this.setMostrarsecuencialSolicitudVacacion(esInicial);
		this.setMostrarfecha_solicitaSolicitudVacacion(esInicial);
		this.setMostrarfecha_ejecutaSolicitudVacacion(esInicial);
		this.setMostrarnumero_horasSolicitudVacacion(esInicial);
		this.setMostrarcosto_unitarioSolicitudVacacion(esInicial);
		this.setMostrarcosto_totalSolicitudVacacion(esInicial);
		this.setMostrardescripcionSolicitudVacacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.ID)) {
				this.setMostraridSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE)) {
				this.setMostrarid_empleado_jefeSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI)) {
				this.setMostrarid_estado_solicitud_nomiSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.FECHASOLICITA)) {
				this.setMostrarfecha_solicitaSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.FECHAEJECUTA)) {
				this.setMostrarfecha_ejecutaSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.NUMEROHORAS)) {
				this.setMostrarnumero_horasSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionSolicitudVacacion(esAsigna);
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
		
		
		this.setActivaridSolicitudVacacion(esInicial);
		this.setActivarid_empresaSolicitudVacacion(esInicial);
		this.setActivarid_sucursalSolicitudVacacion(esInicial);
		this.setActivarid_empleado_jefeSolicitudVacacion(esInicial);
		this.setActivarid_empleadoSolicitudVacacion(esInicial);
		this.setActivarid_estructuraSolicitudVacacion(esInicial);
		this.setActivarid_estado_solicitud_nomiSolicitudVacacion(esInicial);
		this.setActivarid_formatoSolicitudVacacion(esInicial);
		this.setActivarsecuencialSolicitudVacacion(esInicial);
		this.setActivarfecha_solicitaSolicitudVacacion(esInicial);
		this.setActivarfecha_ejecutaSolicitudVacacion(esInicial);
		this.setActivarnumero_horasSolicitudVacacion(esInicial);
		this.setActivarcosto_unitarioSolicitudVacacion(esInicial);
		this.setActivarcosto_totalSolicitudVacacion(esInicial);
		this.setActivardescripcionSolicitudVacacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.ID)) {
				this.setActivaridSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE)) {
				this.setActivarid_empleado_jefeSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI)) {
				this.setActivarid_estado_solicitud_nomiSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.FECHASOLICITA)) {
				this.setActivarfecha_solicitaSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.FECHAEJECUTA)) {
				this.setActivarfecha_ejecutaSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.NUMEROHORAS)) {
				this.setActivarnumero_horasSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionSolicitudVacacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSolicitudVacacion(esInicial);
		this.setResaltarid_empresaSolicitudVacacion(esInicial);
		this.setResaltarid_sucursalSolicitudVacacion(esInicial);
		this.setResaltarid_empleado_jefeSolicitudVacacion(esInicial);
		this.setResaltarid_empleadoSolicitudVacacion(esInicial);
		this.setResaltarid_estructuraSolicitudVacacion(esInicial);
		this.setResaltarid_estado_solicitud_nomiSolicitudVacacion(esInicial);
		this.setResaltarid_formatoSolicitudVacacion(esInicial);
		this.setResaltarsecuencialSolicitudVacacion(esInicial);
		this.setResaltarfecha_solicitaSolicitudVacacion(esInicial);
		this.setResaltarfecha_ejecutaSolicitudVacacion(esInicial);
		this.setResaltarnumero_horasSolicitudVacacion(esInicial);
		this.setResaltarcosto_unitarioSolicitudVacacion(esInicial);
		this.setResaltarcosto_totalSolicitudVacacion(esInicial);
		this.setResaltardescripcionSolicitudVacacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.ID)) {
				this.setResaltaridSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE)) {
				this.setResaltarid_empleado_jefeSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI)) {
				this.setResaltarid_estado_solicitud_nomiSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.FECHASOLICITA)) {
				this.setResaltarfecha_solicitaSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.FECHAEJECUTA)) {
				this.setResaltarfecha_ejecutaSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.NUMEROHORAS)) {
				this.setResaltarnumero_horasSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalSolicitudVacacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudVacacionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionSolicitudVacacion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoSolicitudVacacion=true;

	public Boolean getMostrarFK_IdEmpleadoSolicitudVacacion() {
		return this.mostrarFK_IdEmpleadoSolicitudVacacion;
	}

	public void setMostrarFK_IdEmpleadoSolicitudVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoSolicitudVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoJefeSolicitudVacacion=true;

	public Boolean getMostrarFK_IdEmpleadoJefeSolicitudVacacion() {
		return this.mostrarFK_IdEmpleadoJefeSolicitudVacacion;
	}

	public void setMostrarFK_IdEmpleadoJefeSolicitudVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoJefeSolicitudVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSolicitudVacacion=true;

	public Boolean getMostrarFK_IdEmpresaSolicitudVacacion() {
		return this.mostrarFK_IdEmpresaSolicitudVacacion;
	}

	public void setMostrarFK_IdEmpresaSolicitudVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSolicitudVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoSolicitudNomiSolicitudVacacion=true;

	public Boolean getMostrarFK_IdEstadoSolicitudNomiSolicitudVacacion() {
		return this.mostrarFK_IdEstadoSolicitudNomiSolicitudVacacion;
	}

	public void setMostrarFK_IdEstadoSolicitudNomiSolicitudVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoSolicitudNomiSolicitudVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraSolicitudVacacion=true;

	public Boolean getMostrarFK_IdEstructuraSolicitudVacacion() {
		return this.mostrarFK_IdEstructuraSolicitudVacacion;
	}

	public void setMostrarFK_IdEstructuraSolicitudVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraSolicitudVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoSolicitudVacacion=true;

	public Boolean getMostrarFK_IdFormatoSolicitudVacacion() {
		return this.mostrarFK_IdFormatoSolicitudVacacion;
	}

	public void setMostrarFK_IdFormatoSolicitudVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoSolicitudVacacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalSolicitudVacacion=true;

	public Boolean getMostrarFK_IdSucursalSolicitudVacacion() {
		return this.mostrarFK_IdSucursalSolicitudVacacion;
	}

	public void setMostrarFK_IdSucursalSolicitudVacacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalSolicitudVacacion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoSolicitudVacacion=true;

	public Boolean getActivarFK_IdEmpleadoSolicitudVacacion() {
		return this.activarFK_IdEmpleadoSolicitudVacacion;
	}

	public void setActivarFK_IdEmpleadoSolicitudVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoSolicitudVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoJefeSolicitudVacacion=true;

	public Boolean getActivarFK_IdEmpleadoJefeSolicitudVacacion() {
		return this.activarFK_IdEmpleadoJefeSolicitudVacacion;
	}

	public void setActivarFK_IdEmpleadoJefeSolicitudVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoJefeSolicitudVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSolicitudVacacion=true;

	public Boolean getActivarFK_IdEmpresaSolicitudVacacion() {
		return this.activarFK_IdEmpresaSolicitudVacacion;
	}

	public void setActivarFK_IdEmpresaSolicitudVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSolicitudVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoSolicitudNomiSolicitudVacacion=true;

	public Boolean getActivarFK_IdEstadoSolicitudNomiSolicitudVacacion() {
		return this.activarFK_IdEstadoSolicitudNomiSolicitudVacacion;
	}

	public void setActivarFK_IdEstadoSolicitudNomiSolicitudVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoSolicitudNomiSolicitudVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraSolicitudVacacion=true;

	public Boolean getActivarFK_IdEstructuraSolicitudVacacion() {
		return this.activarFK_IdEstructuraSolicitudVacacion;
	}

	public void setActivarFK_IdEstructuraSolicitudVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraSolicitudVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoSolicitudVacacion=true;

	public Boolean getActivarFK_IdFormatoSolicitudVacacion() {
		return this.activarFK_IdFormatoSolicitudVacacion;
	}

	public void setActivarFK_IdFormatoSolicitudVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoSolicitudVacacion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalSolicitudVacacion=true;

	public Boolean getActivarFK_IdSucursalSolicitudVacacion() {
		return this.activarFK_IdSucursalSolicitudVacacion;
	}

	public void setActivarFK_IdSucursalSolicitudVacacion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalSolicitudVacacion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoSolicitudVacacion=null;

	public Border getResaltarFK_IdEmpleadoSolicitudVacacion() {
		return this.resaltarFK_IdEmpleadoSolicitudVacacion;
	}

	public void setResaltarFK_IdEmpleadoSolicitudVacacion(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoSolicitudVacacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoSolicitudVacacion= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoJefeSolicitudVacacion=null;

	public Border getResaltarFK_IdEmpleadoJefeSolicitudVacacion() {
		return this.resaltarFK_IdEmpleadoJefeSolicitudVacacion;
	}

	public void setResaltarFK_IdEmpleadoJefeSolicitudVacacion(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoJefeSolicitudVacacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoJefeSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoJefeSolicitudVacacion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSolicitudVacacion=null;

	public Border getResaltarFK_IdEmpresaSolicitudVacacion() {
		return this.resaltarFK_IdEmpresaSolicitudVacacion;
	}

	public void setResaltarFK_IdEmpresaSolicitudVacacion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSolicitudVacacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSolicitudVacacion= borderResaltar;
	}

	public Border resaltarFK_IdEstadoSolicitudNomiSolicitudVacacion=null;

	public Border getResaltarFK_IdEstadoSolicitudNomiSolicitudVacacion() {
		return this.resaltarFK_IdEstadoSolicitudNomiSolicitudVacacion;
	}

	public void setResaltarFK_IdEstadoSolicitudNomiSolicitudVacacion(Border borderResaltar) {
		this.resaltarFK_IdEstadoSolicitudNomiSolicitudVacacion= borderResaltar;
	}

	public void setResaltarFK_IdEstadoSolicitudNomiSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoSolicitudNomiSolicitudVacacion= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraSolicitudVacacion=null;

	public Border getResaltarFK_IdEstructuraSolicitudVacacion() {
		return this.resaltarFK_IdEstructuraSolicitudVacacion;
	}

	public void setResaltarFK_IdEstructuraSolicitudVacacion(Border borderResaltar) {
		this.resaltarFK_IdEstructuraSolicitudVacacion= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraSolicitudVacacion= borderResaltar;
	}

	public Border resaltarFK_IdFormatoSolicitudVacacion=null;

	public Border getResaltarFK_IdFormatoSolicitudVacacion() {
		return this.resaltarFK_IdFormatoSolicitudVacacion;
	}

	public void setResaltarFK_IdFormatoSolicitudVacacion(Border borderResaltar) {
		this.resaltarFK_IdFormatoSolicitudVacacion= borderResaltar;
	}

	public void setResaltarFK_IdFormatoSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoSolicitudVacacion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalSolicitudVacacion=null;

	public Border getResaltarFK_IdSucursalSolicitudVacacion() {
		return this.resaltarFK_IdSucursalSolicitudVacacion;
	}

	public void setResaltarFK_IdSucursalSolicitudVacacion(Border borderResaltar) {
		this.resaltarFK_IdSucursalSolicitudVacacion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalSolicitudVacacion(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudVacacionBeanSwingJInternalFrame solicitudvacacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalSolicitudVacacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}