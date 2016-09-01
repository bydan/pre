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


import com.bydan.erp.nomina.util.SolicitudHoraExtraConstantesFunciones;
import com.bydan.erp.nomina.util.SolicitudHoraExtraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.SolicitudHoraExtraParameterGeneral;

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
final public class SolicitudHoraExtraConstantesFunciones extends SolicitudHoraExtraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SolicitudHoraExtra";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SolicitudHoraExtra"+SolicitudHoraExtraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SolicitudHoraExtraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SolicitudHoraExtraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SolicitudHoraExtraConstantesFunciones.SCHEMA+"_"+SolicitudHoraExtraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SolicitudHoraExtraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SolicitudHoraExtraConstantesFunciones.SCHEMA+"_"+SolicitudHoraExtraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SolicitudHoraExtraConstantesFunciones.SCHEMA+"_"+SolicitudHoraExtraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SolicitudHoraExtraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SolicitudHoraExtraConstantesFunciones.SCHEMA+"_"+SolicitudHoraExtraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudHoraExtraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SolicitudHoraExtraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudHoraExtraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudHoraExtraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SolicitudHoraExtraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SolicitudHoraExtraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SolicitudHoraExtraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SolicitudHoraExtraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SolicitudHoraExtraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SolicitudHoraExtraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Solicitud Hora Extras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Solicitud Hora Extra";
	public static final String SCLASSWEBTITULO_LOWER="Solicitud Hora Extra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SolicitudHoraExtra";
	public static final String OBJECTNAME="solicitudhoraextra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="solicitud_hora_extra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select solicitudhoraextra from "+SolicitudHoraExtraConstantesFunciones.SPERSISTENCENAME+" solicitudhoraextra";
	public static String QUERYSELECTNATIVE="select "+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".version_row,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_empresa,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_sucursal,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_empleado,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_estructura,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_empleado_jefe,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_estado_solicitud_nomi,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_empleado_reemplazo,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".secuencial,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".fecha_solicita,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".fecha_ejecuta,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".numero_horas,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".costo_unitario,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".costo_total,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".descripcion from "+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME;//+" as "+SolicitudHoraExtraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SolicitudHoraExtraConstantesFuncionesAdditional solicitudhoraextraConstantesFuncionesAdditional=null;
	
	public SolicitudHoraExtraConstantesFuncionesAdditional getSolicitudHoraExtraConstantesFuncionesAdditional() {
		return this.solicitudhoraextraConstantesFuncionesAdditional;
	}
	
	public void setSolicitudHoraExtraConstantesFuncionesAdditional(SolicitudHoraExtraConstantesFuncionesAdditional solicitudhoraextraConstantesFuncionesAdditional) {
		try {
			this.solicitudhoraextraConstantesFuncionesAdditional=solicitudhoraextraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDEMPLEADOJEFE= "id_empleado_jefe";
    public static final String IDESTADOSOLICITUDNOMI= "id_estado_solicitud_nomi";
    public static final String IDEMPLEADOREEMPLAZO= "id_empleado_reemplazo";
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
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDEMPLEADOJEFE= "Empleado Jefe";
		public static final String LABEL_IDEMPLEADOJEFE_LOWER= "Empleado Jefe";
    	public static final String LABEL_IDESTADOSOLICITUDNOMI= "Estado Solicitud Nomi";
		public static final String LABEL_IDESTADOSOLICITUDNOMI_LOWER= "Estado Solicitud Nomi";
    	public static final String LABEL_IDEMPLEADOREEMPLAZO= "Empleado Reemplazo";
		public static final String LABEL_IDEMPLEADOREEMPLAZO_LOWER= "Empleado Reemplazo";
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
	
	public static String getSolicitudHoraExtraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.IDEMPRESA)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADO)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADOJEFE;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADOREEMPLAZO;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.SECUENCIAL)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.FECHASOLICITA)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_FECHASOLICITA;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.FECHAEJECUTA)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_FECHAEJECUTA;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.NUMEROHORAS)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_NUMEROHORAS;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.COSTOTOTAL)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(SolicitudHoraExtraConstantesFunciones.DESCRIPCION)) {sLabelColumna=SolicitudHoraExtraConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSolicitudHoraExtraDescripcion(SolicitudHoraExtra solicitudhoraextra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(solicitudhoraextra !=null/* && solicitudhoraextra.getId()!=0*/) {
			if(solicitudhoraextra.getId()!=null) {
				sDescripcion=solicitudhoraextra.getId().toString();
			}//solicitudhoraextrasolicitudhoraextra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSolicitudHoraExtraDescripcionDetallado(SolicitudHoraExtra solicitudhoraextra) {
		String sDescripcion="";
			
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.ID+"=";
		sDescripcion+=solicitudhoraextra.getId().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=solicitudhoraextra.getVersionRow().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=solicitudhoraextra.getid_empresa().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=solicitudhoraextra.getid_sucursal().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=solicitudhoraextra.getid_empleado().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=solicitudhoraextra.getid_estructura().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE+"=";
		sDescripcion+=solicitudhoraextra.getid_empleado_jefe().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI+"=";
		sDescripcion+=solicitudhoraextra.getid_estado_solicitud_nomi().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO+"=";
		sDescripcion+=solicitudhoraextra.getid_empleado_reemplazo().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=solicitudhoraextra.getsecuencial()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.FECHASOLICITA+"=";
		sDescripcion+=solicitudhoraextra.getfecha_solicita().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.FECHAEJECUTA+"=";
		sDescripcion+=solicitudhoraextra.getfecha_ejecuta().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.NUMEROHORAS+"=";
		sDescripcion+=solicitudhoraextra.getnumero_horas().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=solicitudhoraextra.getcosto_unitario().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=solicitudhoraextra.getcosto_total().toString()+",";
		sDescripcion+=SolicitudHoraExtraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=solicitudhoraextra.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setSolicitudHoraExtraDescripcion(SolicitudHoraExtra solicitudhoraextra,String sValor) throws Exception {			
		if(solicitudhoraextra !=null) {
			//solicitudhoraextrasolicitudhoraextra.getId().toString();
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

	public static String getEmpleadoJefeDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
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

	public static String getEmpleadoReemplazoDescripcion(Empleado empleado) {
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
	
	
	
	
	
	
	public static void quitarEspaciosSolicitudHoraExtra(SolicitudHoraExtra solicitudhoraextra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		solicitudhoraextra.setsecuencial(solicitudhoraextra.getsecuencial().trim());
		solicitudhoraextra.setdescripcion(solicitudhoraextra.getdescripcion().trim());
	}
	
	public static void quitarEspaciosSolicitudHoraExtras(List<SolicitudHoraExtra> solicitudhoraextras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SolicitudHoraExtra solicitudhoraextra: solicitudhoraextras) {
			solicitudhoraextra.setsecuencial(solicitudhoraextra.getsecuencial().trim());
			solicitudhoraextra.setdescripcion(solicitudhoraextra.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSolicitudHoraExtra(SolicitudHoraExtra solicitudhoraextra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && solicitudhoraextra.getConCambioAuxiliar()) {
			solicitudhoraextra.setIsDeleted(solicitudhoraextra.getIsDeletedAuxiliar());	
			solicitudhoraextra.setIsNew(solicitudhoraextra.getIsNewAuxiliar());	
			solicitudhoraextra.setIsChanged(solicitudhoraextra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			solicitudhoraextra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			solicitudhoraextra.setIsDeletedAuxiliar(false);	
			solicitudhoraextra.setIsNewAuxiliar(false);	
			solicitudhoraextra.setIsChangedAuxiliar(false);
			
			solicitudhoraextra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSolicitudHoraExtras(List<SolicitudHoraExtra> solicitudhoraextras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SolicitudHoraExtra solicitudhoraextra : solicitudhoraextras) {
			if(conAsignarBase && solicitudhoraextra.getConCambioAuxiliar()) {
				solicitudhoraextra.setIsDeleted(solicitudhoraextra.getIsDeletedAuxiliar());	
				solicitudhoraextra.setIsNew(solicitudhoraextra.getIsNewAuxiliar());	
				solicitudhoraextra.setIsChanged(solicitudhoraextra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				solicitudhoraextra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				solicitudhoraextra.setIsDeletedAuxiliar(false);	
				solicitudhoraextra.setIsNewAuxiliar(false);	
				solicitudhoraextra.setIsChangedAuxiliar(false);
				
				solicitudhoraextra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSolicitudHoraExtra(SolicitudHoraExtra solicitudhoraextra,Boolean conEnteros) throws Exception  {
		solicitudhoraextra.setcosto_unitario(0.0);
		solicitudhoraextra.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			solicitudhoraextra.setnumero_horas(0);
		}
	}		
	
	public static void InicializarValoresSolicitudHoraExtras(List<SolicitudHoraExtra> solicitudhoraextras,Boolean conEnteros) throws Exception  {
		
		for(SolicitudHoraExtra solicitudhoraextra: solicitudhoraextras) {
			solicitudhoraextra.setcosto_unitario(0.0);
			solicitudhoraextra.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				solicitudhoraextra.setnumero_horas(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaSolicitudHoraExtra(List<SolicitudHoraExtra> solicitudhoraextras,SolicitudHoraExtra solicitudhoraextraAux) throws Exception  {
		SolicitudHoraExtraConstantesFunciones.InicializarValoresSolicitudHoraExtra(solicitudhoraextraAux,true);
		
		for(SolicitudHoraExtra solicitudhoraextra: solicitudhoraextras) {
			if(solicitudhoraextra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			solicitudhoraextraAux.setnumero_horas(solicitudhoraextraAux.getnumero_horas()+solicitudhoraextra.getnumero_horas());			
			solicitudhoraextraAux.setcosto_unitario(solicitudhoraextraAux.getcosto_unitario()+solicitudhoraextra.getcosto_unitario());			
			solicitudhoraextraAux.setcosto_total(solicitudhoraextraAux.getcosto_total()+solicitudhoraextra.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSolicitudHoraExtra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SolicitudHoraExtraConstantesFunciones.getArrayColumnasGlobalesSolicitudHoraExtra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSolicitudHoraExtra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SolicitudHoraExtraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SolicitudHoraExtraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SolicitudHoraExtraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SolicitudHoraExtraConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSolicitudHoraExtra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SolicitudHoraExtra> solicitudhoraextras,SolicitudHoraExtra solicitudhoraextra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SolicitudHoraExtra solicitudhoraextraAux: solicitudhoraextras) {
			if(solicitudhoraextraAux!=null && solicitudhoraextra!=null) {
				if((solicitudhoraextraAux.getId()==null && solicitudhoraextra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(solicitudhoraextraAux.getId()!=null && solicitudhoraextra.getId()!=null){
					if(solicitudhoraextraAux.getId().equals(solicitudhoraextra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSolicitudHoraExtra(List<SolicitudHoraExtra> solicitudhoraextras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(SolicitudHoraExtra solicitudhoraextra: solicitudhoraextras) {			
			if(solicitudhoraextra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costo_unitarioTotal+=solicitudhoraextra.getcosto_unitario();
			costo_totalTotal+=solicitudhoraextra.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SolicitudHoraExtraConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSolicitudHoraExtra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_ID, SolicitudHoraExtraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_VERSIONROW, SolicitudHoraExtraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPRESA, SolicitudHoraExtraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_IDSUCURSAL, SolicitudHoraExtraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADO, SolicitudHoraExtraConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_IDESTRUCTURA, SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADOJEFE, SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI, SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADOREEMPLAZO, SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_SECUENCIAL, SolicitudHoraExtraConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_FECHASOLICITA, SolicitudHoraExtraConstantesFunciones.FECHASOLICITA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_FECHAEJECUTA, SolicitudHoraExtraConstantesFunciones.FECHAEJECUTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_NUMEROHORAS, SolicitudHoraExtraConstantesFunciones.NUMEROHORAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_COSTOUNITARIO, SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_COSTOTOTAL, SolicitudHoraExtraConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SolicitudHoraExtraConstantesFunciones.LABEL_DESCRIPCION, SolicitudHoraExtraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSolicitudHoraExtra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.FECHASOLICITA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.FECHAEJECUTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.NUMEROHORAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SolicitudHoraExtraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSolicitudHoraExtra() throws Exception  {
		return SolicitudHoraExtraConstantesFunciones.getTiposSeleccionarSolicitudHoraExtra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSolicitudHoraExtra(Boolean conFk) throws Exception  {
		return SolicitudHoraExtraConstantesFunciones.getTiposSeleccionarSolicitudHoraExtra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSolicitudHoraExtra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADOJEFE);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADOJEFE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADOREEMPLAZO);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADOREEMPLAZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_FECHASOLICITA);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_FECHASOLICITA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_FECHAEJECUTA);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_FECHAEJECUTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_NUMEROHORAS);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_NUMEROHORAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SolicitudHoraExtraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(SolicitudHoraExtraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSolicitudHoraExtra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSolicitudHoraExtra(SolicitudHoraExtra solicitudhoraextraAux) throws Exception {
		
			solicitudhoraextraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(solicitudhoraextraAux.getEmpresa()));
			solicitudhoraextraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(solicitudhoraextraAux.getSucursal()));
			solicitudhoraextraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudhoraextraAux.getEmpleado()));
			solicitudhoraextraAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(solicitudhoraextraAux.getEstructura()));
			solicitudhoraextraAux.setempleadojefe_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudhoraextraAux.getEmpleadoJefe()));
			solicitudhoraextraAux.setestadosolicitudnomi_descripcion(EstadoSolicitudNomiConstantesFunciones.getEstadoSolicitudNomiDescripcion(solicitudhoraextraAux.getEstadoSolicitudNomi()));
			solicitudhoraextraAux.setempleadoreemplazo_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudhoraextraAux.getEmpleadoReemplazo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSolicitudHoraExtra(List<SolicitudHoraExtra> solicitudhoraextrasTemp) throws Exception {
		for(SolicitudHoraExtra solicitudhoraextraAux:solicitudhoraextrasTemp) {
			
			solicitudhoraextraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(solicitudhoraextraAux.getEmpresa()));
			solicitudhoraextraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(solicitudhoraextraAux.getSucursal()));
			solicitudhoraextraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudhoraextraAux.getEmpleado()));
			solicitudhoraextraAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(solicitudhoraextraAux.getEstructura()));
			solicitudhoraextraAux.setempleadojefe_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudhoraextraAux.getEmpleadoJefe()));
			solicitudhoraextraAux.setestadosolicitudnomi_descripcion(EstadoSolicitudNomiConstantesFunciones.getEstadoSolicitudNomiDescripcion(solicitudhoraextraAux.getEstadoSolicitudNomi()));
			solicitudhoraextraAux.setempleadoreemplazo_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(solicitudhoraextraAux.getEmpleadoReemplazo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSolicitudHoraExtra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(EstadoSolicitudNomi.class));
				classes.add(new Classe(Empleado.class));
				
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
					if(clas.clas.equals(EstadoSolicitudNomi.class)) {
						classes.add(new Classe(EstadoSolicitudNomi.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSolicitudHoraExtra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(EstadoSolicitudNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoSolicitudNomi.class)); continue;
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

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(EstadoSolicitudNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoSolicitudNomi.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSolicitudHoraExtra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SolicitudHoraExtraConstantesFunciones.getClassesRelationshipsOfSolicitudHoraExtra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSolicitudHoraExtra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSolicitudHoraExtra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SolicitudHoraExtraConstantesFunciones.getClassesRelationshipsFromStringsOfSolicitudHoraExtra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSolicitudHoraExtra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SolicitudHoraExtra solicitudhoraextra,List<SolicitudHoraExtra> solicitudhoraextras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SolicitudHoraExtra solicitudhoraextraEncontrado=null;
			
			for(SolicitudHoraExtra solicitudhoraextraLocal:solicitudhoraextras) {
				if(solicitudhoraextraLocal.getId().equals(solicitudhoraextra.getId())) {
					solicitudhoraextraEncontrado=solicitudhoraextraLocal;
					
					solicitudhoraextraLocal.setIsChanged(solicitudhoraextra.getIsChanged());
					solicitudhoraextraLocal.setIsNew(solicitudhoraextra.getIsNew());
					solicitudhoraextraLocal.setIsDeleted(solicitudhoraextra.getIsDeleted());
					
					solicitudhoraextraLocal.setGeneralEntityOriginal(solicitudhoraextra.getGeneralEntityOriginal());
					
					solicitudhoraextraLocal.setId(solicitudhoraextra.getId());	
					solicitudhoraextraLocal.setVersionRow(solicitudhoraextra.getVersionRow());	
					solicitudhoraextraLocal.setid_empresa(solicitudhoraextra.getid_empresa());	
					solicitudhoraextraLocal.setid_sucursal(solicitudhoraextra.getid_sucursal());	
					solicitudhoraextraLocal.setid_empleado(solicitudhoraextra.getid_empleado());	
					solicitudhoraextraLocal.setid_estructura(solicitudhoraextra.getid_estructura());	
					solicitudhoraextraLocal.setid_empleado_jefe(solicitudhoraextra.getid_empleado_jefe());	
					solicitudhoraextraLocal.setid_estado_solicitud_nomi(solicitudhoraextra.getid_estado_solicitud_nomi());	
					solicitudhoraextraLocal.setid_empleado_reemplazo(solicitudhoraextra.getid_empleado_reemplazo());	
					solicitudhoraextraLocal.setsecuencial(solicitudhoraextra.getsecuencial());	
					solicitudhoraextraLocal.setfecha_solicita(solicitudhoraextra.getfecha_solicita());	
					solicitudhoraextraLocal.setfecha_ejecuta(solicitudhoraextra.getfecha_ejecuta());	
					solicitudhoraextraLocal.setnumero_horas(solicitudhoraextra.getnumero_horas());	
					solicitudhoraextraLocal.setcosto_unitario(solicitudhoraextra.getcosto_unitario());	
					solicitudhoraextraLocal.setcosto_total(solicitudhoraextra.getcosto_total());	
					solicitudhoraextraLocal.setdescripcion(solicitudhoraextra.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!solicitudhoraextra.getIsDeleted()) {
				if(!existe) {
					solicitudhoraextras.add(solicitudhoraextra);
				}
			} else {
				if(solicitudhoraextraEncontrado!=null && permiteQuitar)  {
					solicitudhoraextras.remove(solicitudhoraextraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SolicitudHoraExtra solicitudhoraextra,List<SolicitudHoraExtra> solicitudhoraextras) throws Exception {
		try	{			
			for(SolicitudHoraExtra solicitudhoraextraLocal:solicitudhoraextras) {
				if(solicitudhoraextraLocal.getId().equals(solicitudhoraextra.getId())) {
					solicitudhoraextraLocal.setIsSelected(solicitudhoraextra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSolicitudHoraExtra(List<SolicitudHoraExtra> solicitudhoraextrasAux) throws Exception {
		//this.solicitudhoraextrasAux=solicitudhoraextrasAux;
		
		for(SolicitudHoraExtra solicitudhoraextraAux:solicitudhoraextrasAux) {
			if(solicitudhoraextraAux.getIsChanged()) {
				solicitudhoraextraAux.setIsChanged(false);
			}		
			
			if(solicitudhoraextraAux.getIsNew()) {
				solicitudhoraextraAux.setIsNew(false);
			}	
			
			if(solicitudhoraextraAux.getIsDeleted()) {
				solicitudhoraextraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSolicitudHoraExtra(SolicitudHoraExtra solicitudhoraextraAux) throws Exception {
		//this.solicitudhoraextraAux=solicitudhoraextraAux;
		
			if(solicitudhoraextraAux.getIsChanged()) {
				solicitudhoraextraAux.setIsChanged(false);
			}		
			
			if(solicitudhoraextraAux.getIsNew()) {
				solicitudhoraextraAux.setIsNew(false);
			}	
			
			if(solicitudhoraextraAux.getIsDeleted()) {
				solicitudhoraextraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SolicitudHoraExtra solicitudhoraextraAsignar,SolicitudHoraExtra solicitudhoraextra) throws Exception {
		solicitudhoraextraAsignar.setId(solicitudhoraextra.getId());	
		solicitudhoraextraAsignar.setVersionRow(solicitudhoraextra.getVersionRow());	
		solicitudhoraextraAsignar.setid_empresa(solicitudhoraextra.getid_empresa());
		solicitudhoraextraAsignar.setempresa_descripcion(solicitudhoraextra.getempresa_descripcion());	
		solicitudhoraextraAsignar.setid_sucursal(solicitudhoraextra.getid_sucursal());
		solicitudhoraextraAsignar.setsucursal_descripcion(solicitudhoraextra.getsucursal_descripcion());	
		solicitudhoraextraAsignar.setid_empleado(solicitudhoraextra.getid_empleado());
		solicitudhoraextraAsignar.setempleado_descripcion(solicitudhoraextra.getempleado_descripcion());	
		solicitudhoraextraAsignar.setid_estructura(solicitudhoraextra.getid_estructura());
		solicitudhoraextraAsignar.setestructura_descripcion(solicitudhoraextra.getestructura_descripcion());	
		solicitudhoraextraAsignar.setid_empleado_jefe(solicitudhoraextra.getid_empleado_jefe());
		solicitudhoraextraAsignar.setempleadojefe_descripcion(solicitudhoraextra.getempleadojefe_descripcion());	
		solicitudhoraextraAsignar.setid_estado_solicitud_nomi(solicitudhoraextra.getid_estado_solicitud_nomi());
		solicitudhoraextraAsignar.setestadosolicitudnomi_descripcion(solicitudhoraextra.getestadosolicitudnomi_descripcion());	
		solicitudhoraextraAsignar.setid_empleado_reemplazo(solicitudhoraextra.getid_empleado_reemplazo());
		solicitudhoraextraAsignar.setempleadoreemplazo_descripcion(solicitudhoraextra.getempleadoreemplazo_descripcion());	
		solicitudhoraextraAsignar.setsecuencial(solicitudhoraextra.getsecuencial());	
		solicitudhoraextraAsignar.setfecha_solicita(solicitudhoraextra.getfecha_solicita());	
		solicitudhoraextraAsignar.setfecha_ejecuta(solicitudhoraextra.getfecha_ejecuta());	
		solicitudhoraextraAsignar.setnumero_horas(solicitudhoraextra.getnumero_horas());	
		solicitudhoraextraAsignar.setcosto_unitario(solicitudhoraextra.getcosto_unitario());	
		solicitudhoraextraAsignar.setcosto_total(solicitudhoraextra.getcosto_total());	
		solicitudhoraextraAsignar.setdescripcion(solicitudhoraextra.getdescripcion());	
	}
	
	public static void inicializarSolicitudHoraExtra(SolicitudHoraExtra solicitudhoraextra) throws Exception {
		try {
				solicitudhoraextra.setId(0L);	
					
				solicitudhoraextra.setid_empresa(-1L);	
				solicitudhoraextra.setid_sucursal(-1L);	
				solicitudhoraextra.setid_empleado(-1L);	
				solicitudhoraextra.setid_estructura(-1L);	
				solicitudhoraextra.setid_empleado_jefe(-1L);	
				solicitudhoraextra.setid_estado_solicitud_nomi(-1L);	
				solicitudhoraextra.setid_empleado_reemplazo(-1L);	
				solicitudhoraextra.setsecuencial("");	
				solicitudhoraextra.setfecha_solicita(new Date());	
				solicitudhoraextra.setfecha_ejecuta(new Date());	
				solicitudhoraextra.setnumero_horas(0);	
				solicitudhoraextra.setcosto_unitario(0.0);	
				solicitudhoraextra.setcosto_total(0.0);	
				solicitudhoraextra.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSolicitudHoraExtra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADOJEFE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_IDESTADOSOLICITUDNOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_IDEMPLEADOREEMPLAZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_FECHASOLICITA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_FECHAEJECUTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_NUMEROHORAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SolicitudHoraExtraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSolicitudHoraExtra(String sTipo,Row row,Workbook workbook,SolicitudHoraExtra solicitudhoraextra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getempleadojefe_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getestadosolicitudnomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getempleadoreemplazo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getfecha_solicita());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getfecha_ejecuta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getnumero_horas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(solicitudhoraextra.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySolicitudHoraExtra=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySolicitudHoraExtra() {
		return this.sFinalQuerySolicitudHoraExtra;
	}
	
	public void setsFinalQuerySolicitudHoraExtra(String sFinalQuerySolicitudHoraExtra) {
		this.sFinalQuerySolicitudHoraExtra= sFinalQuerySolicitudHoraExtra;
	}
	
	public Border resaltarSeleccionarSolicitudHoraExtra=null;
	
	public Border setResaltarSeleccionarSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSolicitudHoraExtra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSolicitudHoraExtra() {
		return this.resaltarSeleccionarSolicitudHoraExtra;
	}
	
	public void setResaltarSeleccionarSolicitudHoraExtra(Border borderResaltarSeleccionarSolicitudHoraExtra) {
		this.resaltarSeleccionarSolicitudHoraExtra= borderResaltarSeleccionarSolicitudHoraExtra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSolicitudHoraExtra=null;
	public Boolean mostraridSolicitudHoraExtra=true;
	public Boolean activaridSolicitudHoraExtra=true;

	public Border resaltarid_empresaSolicitudHoraExtra=null;
	public Boolean mostrarid_empresaSolicitudHoraExtra=true;
	public Boolean activarid_empresaSolicitudHoraExtra=true;
	public Boolean cargarid_empresaSolicitudHoraExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSolicitudHoraExtra=false;//ConEventDepend=true

	public Border resaltarid_sucursalSolicitudHoraExtra=null;
	public Boolean mostrarid_sucursalSolicitudHoraExtra=true;
	public Boolean activarid_sucursalSolicitudHoraExtra=true;
	public Boolean cargarid_sucursalSolicitudHoraExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalSolicitudHoraExtra=false;//ConEventDepend=true

	public Border resaltarid_empleadoSolicitudHoraExtra=null;
	public Boolean mostrarid_empleadoSolicitudHoraExtra=true;
	public Boolean activarid_empleadoSolicitudHoraExtra=true;
	public Boolean cargarid_empleadoSolicitudHoraExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoSolicitudHoraExtra=false;//ConEventDepend=true

	public Border resaltarid_estructuraSolicitudHoraExtra=null;
	public Boolean mostrarid_estructuraSolicitudHoraExtra=true;
	public Boolean activarid_estructuraSolicitudHoraExtra=true;
	public Boolean cargarid_estructuraSolicitudHoraExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraSolicitudHoraExtra=false;//ConEventDepend=true

	public Border resaltarid_empleado_jefeSolicitudHoraExtra=null;
	public Boolean mostrarid_empleado_jefeSolicitudHoraExtra=true;
	public Boolean activarid_empleado_jefeSolicitudHoraExtra=true;
	public Boolean cargarid_empleado_jefeSolicitudHoraExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_jefeSolicitudHoraExtra=false;//ConEventDepend=true

	public Border resaltarid_estado_solicitud_nomiSolicitudHoraExtra=null;
	public Boolean mostrarid_estado_solicitud_nomiSolicitudHoraExtra=true;
	public Boolean activarid_estado_solicitud_nomiSolicitudHoraExtra=true;
	public Boolean cargarid_estado_solicitud_nomiSolicitudHoraExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_solicitud_nomiSolicitudHoraExtra=false;//ConEventDepend=true

	public Border resaltarid_empleado_reemplazoSolicitudHoraExtra=null;
	public Boolean mostrarid_empleado_reemplazoSolicitudHoraExtra=true;
	public Boolean activarid_empleado_reemplazoSolicitudHoraExtra=true;
	public Boolean cargarid_empleado_reemplazoSolicitudHoraExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_reemplazoSolicitudHoraExtra=false;//ConEventDepend=true

	public Border resaltarsecuencialSolicitudHoraExtra=null;
	public Boolean mostrarsecuencialSolicitudHoraExtra=true;
	public Boolean activarsecuencialSolicitudHoraExtra=true;

	public Border resaltarfecha_solicitaSolicitudHoraExtra=null;
	public Boolean mostrarfecha_solicitaSolicitudHoraExtra=true;
	public Boolean activarfecha_solicitaSolicitudHoraExtra=false;

	public Border resaltarfecha_ejecutaSolicitudHoraExtra=null;
	public Boolean mostrarfecha_ejecutaSolicitudHoraExtra=true;
	public Boolean activarfecha_ejecutaSolicitudHoraExtra=false;

	public Border resaltarnumero_horasSolicitudHoraExtra=null;
	public Boolean mostrarnumero_horasSolicitudHoraExtra=true;
	public Boolean activarnumero_horasSolicitudHoraExtra=true;

	public Border resaltarcosto_unitarioSolicitudHoraExtra=null;
	public Boolean mostrarcosto_unitarioSolicitudHoraExtra=true;
	public Boolean activarcosto_unitarioSolicitudHoraExtra=true;

	public Border resaltarcosto_totalSolicitudHoraExtra=null;
	public Boolean mostrarcosto_totalSolicitudHoraExtra=true;
	public Boolean activarcosto_totalSolicitudHoraExtra=true;

	public Border resaltardescripcionSolicitudHoraExtra=null;
	public Boolean mostrardescripcionSolicitudHoraExtra=true;
	public Boolean activardescripcionSolicitudHoraExtra=true;

	
	

	public Border setResaltaridSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltaridSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSolicitudHoraExtra() {
		return this.resaltaridSolicitudHoraExtra;
	}

	public void setResaltaridSolicitudHoraExtra(Border borderResaltar) {
		this.resaltaridSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostraridSolicitudHoraExtra() {
		return this.mostraridSolicitudHoraExtra;
	}

	public void setMostraridSolicitudHoraExtra(Boolean mostraridSolicitudHoraExtra) {
		this.mostraridSolicitudHoraExtra= mostraridSolicitudHoraExtra;
	}

	public Boolean getActivaridSolicitudHoraExtra() {
		return this.activaridSolicitudHoraExtra;
	}

	public void setActivaridSolicitudHoraExtra(Boolean activaridSolicitudHoraExtra) {
		this.activaridSolicitudHoraExtra= activaridSolicitudHoraExtra;
	}

	public Border setResaltarid_empresaSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarid_empresaSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSolicitudHoraExtra() {
		return this.resaltarid_empresaSolicitudHoraExtra;
	}

	public void setResaltarid_empresaSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarid_empresaSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarid_empresaSolicitudHoraExtra() {
		return this.mostrarid_empresaSolicitudHoraExtra;
	}

	public void setMostrarid_empresaSolicitudHoraExtra(Boolean mostrarid_empresaSolicitudHoraExtra) {
		this.mostrarid_empresaSolicitudHoraExtra= mostrarid_empresaSolicitudHoraExtra;
	}

	public Boolean getActivarid_empresaSolicitudHoraExtra() {
		return this.activarid_empresaSolicitudHoraExtra;
	}

	public void setActivarid_empresaSolicitudHoraExtra(Boolean activarid_empresaSolicitudHoraExtra) {
		this.activarid_empresaSolicitudHoraExtra= activarid_empresaSolicitudHoraExtra;
	}

	public Boolean getCargarid_empresaSolicitudHoraExtra() {
		return this.cargarid_empresaSolicitudHoraExtra;
	}

	public void setCargarid_empresaSolicitudHoraExtra(Boolean cargarid_empresaSolicitudHoraExtra) {
		this.cargarid_empresaSolicitudHoraExtra= cargarid_empresaSolicitudHoraExtra;
	}

	public Border setResaltarid_sucursalSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarid_sucursalSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalSolicitudHoraExtra() {
		return this.resaltarid_sucursalSolicitudHoraExtra;
	}

	public void setResaltarid_sucursalSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarid_sucursalSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalSolicitudHoraExtra() {
		return this.mostrarid_sucursalSolicitudHoraExtra;
	}

	public void setMostrarid_sucursalSolicitudHoraExtra(Boolean mostrarid_sucursalSolicitudHoraExtra) {
		this.mostrarid_sucursalSolicitudHoraExtra= mostrarid_sucursalSolicitudHoraExtra;
	}

	public Boolean getActivarid_sucursalSolicitudHoraExtra() {
		return this.activarid_sucursalSolicitudHoraExtra;
	}

	public void setActivarid_sucursalSolicitudHoraExtra(Boolean activarid_sucursalSolicitudHoraExtra) {
		this.activarid_sucursalSolicitudHoraExtra= activarid_sucursalSolicitudHoraExtra;
	}

	public Boolean getCargarid_sucursalSolicitudHoraExtra() {
		return this.cargarid_sucursalSolicitudHoraExtra;
	}

	public void setCargarid_sucursalSolicitudHoraExtra(Boolean cargarid_sucursalSolicitudHoraExtra) {
		this.cargarid_sucursalSolicitudHoraExtra= cargarid_sucursalSolicitudHoraExtra;
	}

	public Border setResaltarid_empleadoSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarid_empleadoSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoSolicitudHoraExtra() {
		return this.resaltarid_empleadoSolicitudHoraExtra;
	}

	public void setResaltarid_empleadoSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarid_empleadoSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarid_empleadoSolicitudHoraExtra() {
		return this.mostrarid_empleadoSolicitudHoraExtra;
	}

	public void setMostrarid_empleadoSolicitudHoraExtra(Boolean mostrarid_empleadoSolicitudHoraExtra) {
		this.mostrarid_empleadoSolicitudHoraExtra= mostrarid_empleadoSolicitudHoraExtra;
	}

	public Boolean getActivarid_empleadoSolicitudHoraExtra() {
		return this.activarid_empleadoSolicitudHoraExtra;
	}

	public void setActivarid_empleadoSolicitudHoraExtra(Boolean activarid_empleadoSolicitudHoraExtra) {
		this.activarid_empleadoSolicitudHoraExtra= activarid_empleadoSolicitudHoraExtra;
	}

	public Boolean getCargarid_empleadoSolicitudHoraExtra() {
		return this.cargarid_empleadoSolicitudHoraExtra;
	}

	public void setCargarid_empleadoSolicitudHoraExtra(Boolean cargarid_empleadoSolicitudHoraExtra) {
		this.cargarid_empleadoSolicitudHoraExtra= cargarid_empleadoSolicitudHoraExtra;
	}

	public Border setResaltarid_estructuraSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarid_estructuraSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraSolicitudHoraExtra() {
		return this.resaltarid_estructuraSolicitudHoraExtra;
	}

	public void setResaltarid_estructuraSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarid_estructuraSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarid_estructuraSolicitudHoraExtra() {
		return this.mostrarid_estructuraSolicitudHoraExtra;
	}

	public void setMostrarid_estructuraSolicitudHoraExtra(Boolean mostrarid_estructuraSolicitudHoraExtra) {
		this.mostrarid_estructuraSolicitudHoraExtra= mostrarid_estructuraSolicitudHoraExtra;
	}

	public Boolean getActivarid_estructuraSolicitudHoraExtra() {
		return this.activarid_estructuraSolicitudHoraExtra;
	}

	public void setActivarid_estructuraSolicitudHoraExtra(Boolean activarid_estructuraSolicitudHoraExtra) {
		this.activarid_estructuraSolicitudHoraExtra= activarid_estructuraSolicitudHoraExtra;
	}

	public Boolean getCargarid_estructuraSolicitudHoraExtra() {
		return this.cargarid_estructuraSolicitudHoraExtra;
	}

	public void setCargarid_estructuraSolicitudHoraExtra(Boolean cargarid_estructuraSolicitudHoraExtra) {
		this.cargarid_estructuraSolicitudHoraExtra= cargarid_estructuraSolicitudHoraExtra;
	}

	public Border setResaltarid_empleado_jefeSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarid_empleado_jefeSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_jefeSolicitudHoraExtra() {
		return this.resaltarid_empleado_jefeSolicitudHoraExtra;
	}

	public void setResaltarid_empleado_jefeSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarid_empleado_jefeSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarid_empleado_jefeSolicitudHoraExtra() {
		return this.mostrarid_empleado_jefeSolicitudHoraExtra;
	}

	public void setMostrarid_empleado_jefeSolicitudHoraExtra(Boolean mostrarid_empleado_jefeSolicitudHoraExtra) {
		this.mostrarid_empleado_jefeSolicitudHoraExtra= mostrarid_empleado_jefeSolicitudHoraExtra;
	}

	public Boolean getActivarid_empleado_jefeSolicitudHoraExtra() {
		return this.activarid_empleado_jefeSolicitudHoraExtra;
	}

	public void setActivarid_empleado_jefeSolicitudHoraExtra(Boolean activarid_empleado_jefeSolicitudHoraExtra) {
		this.activarid_empleado_jefeSolicitudHoraExtra= activarid_empleado_jefeSolicitudHoraExtra;
	}

	public Boolean getCargarid_empleado_jefeSolicitudHoraExtra() {
		return this.cargarid_empleado_jefeSolicitudHoraExtra;
	}

	public void setCargarid_empleado_jefeSolicitudHoraExtra(Boolean cargarid_empleado_jefeSolicitudHoraExtra) {
		this.cargarid_empleado_jefeSolicitudHoraExtra= cargarid_empleado_jefeSolicitudHoraExtra;
	}

	public Border setResaltarid_estado_solicitud_nomiSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarid_estado_solicitud_nomiSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_solicitud_nomiSolicitudHoraExtra() {
		return this.resaltarid_estado_solicitud_nomiSolicitudHoraExtra;
	}

	public void setResaltarid_estado_solicitud_nomiSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarid_estado_solicitud_nomiSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarid_estado_solicitud_nomiSolicitudHoraExtra() {
		return this.mostrarid_estado_solicitud_nomiSolicitudHoraExtra;
	}

	public void setMostrarid_estado_solicitud_nomiSolicitudHoraExtra(Boolean mostrarid_estado_solicitud_nomiSolicitudHoraExtra) {
		this.mostrarid_estado_solicitud_nomiSolicitudHoraExtra= mostrarid_estado_solicitud_nomiSolicitudHoraExtra;
	}

	public Boolean getActivarid_estado_solicitud_nomiSolicitudHoraExtra() {
		return this.activarid_estado_solicitud_nomiSolicitudHoraExtra;
	}

	public void setActivarid_estado_solicitud_nomiSolicitudHoraExtra(Boolean activarid_estado_solicitud_nomiSolicitudHoraExtra) {
		this.activarid_estado_solicitud_nomiSolicitudHoraExtra= activarid_estado_solicitud_nomiSolicitudHoraExtra;
	}

	public Boolean getCargarid_estado_solicitud_nomiSolicitudHoraExtra() {
		return this.cargarid_estado_solicitud_nomiSolicitudHoraExtra;
	}

	public void setCargarid_estado_solicitud_nomiSolicitudHoraExtra(Boolean cargarid_estado_solicitud_nomiSolicitudHoraExtra) {
		this.cargarid_estado_solicitud_nomiSolicitudHoraExtra= cargarid_estado_solicitud_nomiSolicitudHoraExtra;
	}

	public Border setResaltarid_empleado_reemplazoSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarid_empleado_reemplazoSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_reemplazoSolicitudHoraExtra() {
		return this.resaltarid_empleado_reemplazoSolicitudHoraExtra;
	}

	public void setResaltarid_empleado_reemplazoSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarid_empleado_reemplazoSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarid_empleado_reemplazoSolicitudHoraExtra() {
		return this.mostrarid_empleado_reemplazoSolicitudHoraExtra;
	}

	public void setMostrarid_empleado_reemplazoSolicitudHoraExtra(Boolean mostrarid_empleado_reemplazoSolicitudHoraExtra) {
		this.mostrarid_empleado_reemplazoSolicitudHoraExtra= mostrarid_empleado_reemplazoSolicitudHoraExtra;
	}

	public Boolean getActivarid_empleado_reemplazoSolicitudHoraExtra() {
		return this.activarid_empleado_reemplazoSolicitudHoraExtra;
	}

	public void setActivarid_empleado_reemplazoSolicitudHoraExtra(Boolean activarid_empleado_reemplazoSolicitudHoraExtra) {
		this.activarid_empleado_reemplazoSolicitudHoraExtra= activarid_empleado_reemplazoSolicitudHoraExtra;
	}

	public Boolean getCargarid_empleado_reemplazoSolicitudHoraExtra() {
		return this.cargarid_empleado_reemplazoSolicitudHoraExtra;
	}

	public void setCargarid_empleado_reemplazoSolicitudHoraExtra(Boolean cargarid_empleado_reemplazoSolicitudHoraExtra) {
		this.cargarid_empleado_reemplazoSolicitudHoraExtra= cargarid_empleado_reemplazoSolicitudHoraExtra;
	}

	public Border setResaltarsecuencialSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarsecuencialSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialSolicitudHoraExtra() {
		return this.resaltarsecuencialSolicitudHoraExtra;
	}

	public void setResaltarsecuencialSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarsecuencialSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarsecuencialSolicitudHoraExtra() {
		return this.mostrarsecuencialSolicitudHoraExtra;
	}

	public void setMostrarsecuencialSolicitudHoraExtra(Boolean mostrarsecuencialSolicitudHoraExtra) {
		this.mostrarsecuencialSolicitudHoraExtra= mostrarsecuencialSolicitudHoraExtra;
	}

	public Boolean getActivarsecuencialSolicitudHoraExtra() {
		return this.activarsecuencialSolicitudHoraExtra;
	}

	public void setActivarsecuencialSolicitudHoraExtra(Boolean activarsecuencialSolicitudHoraExtra) {
		this.activarsecuencialSolicitudHoraExtra= activarsecuencialSolicitudHoraExtra;
	}

	public Border setResaltarfecha_solicitaSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarfecha_solicitaSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_solicitaSolicitudHoraExtra() {
		return this.resaltarfecha_solicitaSolicitudHoraExtra;
	}

	public void setResaltarfecha_solicitaSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarfecha_solicitaSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarfecha_solicitaSolicitudHoraExtra() {
		return this.mostrarfecha_solicitaSolicitudHoraExtra;
	}

	public void setMostrarfecha_solicitaSolicitudHoraExtra(Boolean mostrarfecha_solicitaSolicitudHoraExtra) {
		this.mostrarfecha_solicitaSolicitudHoraExtra= mostrarfecha_solicitaSolicitudHoraExtra;
	}

	public Boolean getActivarfecha_solicitaSolicitudHoraExtra() {
		return this.activarfecha_solicitaSolicitudHoraExtra;
	}

	public void setActivarfecha_solicitaSolicitudHoraExtra(Boolean activarfecha_solicitaSolicitudHoraExtra) {
		this.activarfecha_solicitaSolicitudHoraExtra= activarfecha_solicitaSolicitudHoraExtra;
	}

	public Border setResaltarfecha_ejecutaSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarfecha_ejecutaSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ejecutaSolicitudHoraExtra() {
		return this.resaltarfecha_ejecutaSolicitudHoraExtra;
	}

	public void setResaltarfecha_ejecutaSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarfecha_ejecutaSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarfecha_ejecutaSolicitudHoraExtra() {
		return this.mostrarfecha_ejecutaSolicitudHoraExtra;
	}

	public void setMostrarfecha_ejecutaSolicitudHoraExtra(Boolean mostrarfecha_ejecutaSolicitudHoraExtra) {
		this.mostrarfecha_ejecutaSolicitudHoraExtra= mostrarfecha_ejecutaSolicitudHoraExtra;
	}

	public Boolean getActivarfecha_ejecutaSolicitudHoraExtra() {
		return this.activarfecha_ejecutaSolicitudHoraExtra;
	}

	public void setActivarfecha_ejecutaSolicitudHoraExtra(Boolean activarfecha_ejecutaSolicitudHoraExtra) {
		this.activarfecha_ejecutaSolicitudHoraExtra= activarfecha_ejecutaSolicitudHoraExtra;
	}

	public Border setResaltarnumero_horasSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarnumero_horasSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_horasSolicitudHoraExtra() {
		return this.resaltarnumero_horasSolicitudHoraExtra;
	}

	public void setResaltarnumero_horasSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarnumero_horasSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarnumero_horasSolicitudHoraExtra() {
		return this.mostrarnumero_horasSolicitudHoraExtra;
	}

	public void setMostrarnumero_horasSolicitudHoraExtra(Boolean mostrarnumero_horasSolicitudHoraExtra) {
		this.mostrarnumero_horasSolicitudHoraExtra= mostrarnumero_horasSolicitudHoraExtra;
	}

	public Boolean getActivarnumero_horasSolicitudHoraExtra() {
		return this.activarnumero_horasSolicitudHoraExtra;
	}

	public void setActivarnumero_horasSolicitudHoraExtra(Boolean activarnumero_horasSolicitudHoraExtra) {
		this.activarnumero_horasSolicitudHoraExtra= activarnumero_horasSolicitudHoraExtra;
	}

	public Border setResaltarcosto_unitarioSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarcosto_unitarioSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioSolicitudHoraExtra() {
		return this.resaltarcosto_unitarioSolicitudHoraExtra;
	}

	public void setResaltarcosto_unitarioSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarcosto_unitarioSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioSolicitudHoraExtra() {
		return this.mostrarcosto_unitarioSolicitudHoraExtra;
	}

	public void setMostrarcosto_unitarioSolicitudHoraExtra(Boolean mostrarcosto_unitarioSolicitudHoraExtra) {
		this.mostrarcosto_unitarioSolicitudHoraExtra= mostrarcosto_unitarioSolicitudHoraExtra;
	}

	public Boolean getActivarcosto_unitarioSolicitudHoraExtra() {
		return this.activarcosto_unitarioSolicitudHoraExtra;
	}

	public void setActivarcosto_unitarioSolicitudHoraExtra(Boolean activarcosto_unitarioSolicitudHoraExtra) {
		this.activarcosto_unitarioSolicitudHoraExtra= activarcosto_unitarioSolicitudHoraExtra;
	}

	public Border setResaltarcosto_totalSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltarcosto_totalSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalSolicitudHoraExtra() {
		return this.resaltarcosto_totalSolicitudHoraExtra;
	}

	public void setResaltarcosto_totalSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarcosto_totalSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrarcosto_totalSolicitudHoraExtra() {
		return this.mostrarcosto_totalSolicitudHoraExtra;
	}

	public void setMostrarcosto_totalSolicitudHoraExtra(Boolean mostrarcosto_totalSolicitudHoraExtra) {
		this.mostrarcosto_totalSolicitudHoraExtra= mostrarcosto_totalSolicitudHoraExtra;
	}

	public Boolean getActivarcosto_totalSolicitudHoraExtra() {
		return this.activarcosto_totalSolicitudHoraExtra;
	}

	public void setActivarcosto_totalSolicitudHoraExtra(Boolean activarcosto_totalSolicitudHoraExtra) {
		this.activarcosto_totalSolicitudHoraExtra= activarcosto_totalSolicitudHoraExtra;
	}

	public Border setResaltardescripcionSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//solicitudhoraextraBeanSwingJInternalFrame.jTtoolBarSolicitudHoraExtra.setBorder(borderResaltar);
		
		this.resaltardescripcionSolicitudHoraExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionSolicitudHoraExtra() {
		return this.resaltardescripcionSolicitudHoraExtra;
	}

	public void setResaltardescripcionSolicitudHoraExtra(Border borderResaltar) {
		this.resaltardescripcionSolicitudHoraExtra= borderResaltar;
	}

	public Boolean getMostrardescripcionSolicitudHoraExtra() {
		return this.mostrardescripcionSolicitudHoraExtra;
	}

	public void setMostrardescripcionSolicitudHoraExtra(Boolean mostrardescripcionSolicitudHoraExtra) {
		this.mostrardescripcionSolicitudHoraExtra= mostrardescripcionSolicitudHoraExtra;
	}

	public Boolean getActivardescripcionSolicitudHoraExtra() {
		return this.activardescripcionSolicitudHoraExtra;
	}

	public void setActivardescripcionSolicitudHoraExtra(Boolean activardescripcionSolicitudHoraExtra) {
		this.activardescripcionSolicitudHoraExtra= activardescripcionSolicitudHoraExtra;
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
		
		
		this.setMostraridSolicitudHoraExtra(esInicial);
		this.setMostrarid_empresaSolicitudHoraExtra(esInicial);
		this.setMostrarid_sucursalSolicitudHoraExtra(esInicial);
		this.setMostrarid_empleadoSolicitudHoraExtra(esInicial);
		this.setMostrarid_estructuraSolicitudHoraExtra(esInicial);
		this.setMostrarid_empleado_jefeSolicitudHoraExtra(esInicial);
		this.setMostrarid_estado_solicitud_nomiSolicitudHoraExtra(esInicial);
		this.setMostrarid_empleado_reemplazoSolicitudHoraExtra(esInicial);
		this.setMostrarsecuencialSolicitudHoraExtra(esInicial);
		this.setMostrarfecha_solicitaSolicitudHoraExtra(esInicial);
		this.setMostrarfecha_ejecutaSolicitudHoraExtra(esInicial);
		this.setMostrarnumero_horasSolicitudHoraExtra(esInicial);
		this.setMostrarcosto_unitarioSolicitudHoraExtra(esInicial);
		this.setMostrarcosto_totalSolicitudHoraExtra(esInicial);
		this.setMostrardescripcionSolicitudHoraExtra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.ID)) {
				this.setMostraridSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE)) {
				this.setMostrarid_empleado_jefeSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI)) {
				this.setMostrarid_estado_solicitud_nomiSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO)) {
				this.setMostrarid_empleado_reemplazoSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.FECHASOLICITA)) {
				this.setMostrarfecha_solicitaSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.FECHAEJECUTA)) {
				this.setMostrarfecha_ejecutaSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.NUMEROHORAS)) {
				this.setMostrarnumero_horasSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionSolicitudHoraExtra(esAsigna);
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
		
		
		this.setActivaridSolicitudHoraExtra(esInicial);
		this.setActivarid_empresaSolicitudHoraExtra(esInicial);
		this.setActivarid_sucursalSolicitudHoraExtra(esInicial);
		this.setActivarid_empleadoSolicitudHoraExtra(esInicial);
		this.setActivarid_estructuraSolicitudHoraExtra(esInicial);
		this.setActivarid_empleado_jefeSolicitudHoraExtra(esInicial);
		this.setActivarid_estado_solicitud_nomiSolicitudHoraExtra(esInicial);
		this.setActivarid_empleado_reemplazoSolicitudHoraExtra(esInicial);
		this.setActivarsecuencialSolicitudHoraExtra(esInicial);
		this.setActivarfecha_solicitaSolicitudHoraExtra(esInicial);
		this.setActivarfecha_ejecutaSolicitudHoraExtra(esInicial);
		this.setActivarnumero_horasSolicitudHoraExtra(esInicial);
		this.setActivarcosto_unitarioSolicitudHoraExtra(esInicial);
		this.setActivarcosto_totalSolicitudHoraExtra(esInicial);
		this.setActivardescripcionSolicitudHoraExtra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.ID)) {
				this.setActivaridSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE)) {
				this.setActivarid_empleado_jefeSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI)) {
				this.setActivarid_estado_solicitud_nomiSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO)) {
				this.setActivarid_empleado_reemplazoSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.FECHASOLICITA)) {
				this.setActivarfecha_solicitaSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.FECHAEJECUTA)) {
				this.setActivarfecha_ejecutaSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.NUMEROHORAS)) {
				this.setActivarnumero_horasSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionSolicitudHoraExtra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSolicitudHoraExtra(esInicial);
		this.setResaltarid_empresaSolicitudHoraExtra(esInicial);
		this.setResaltarid_sucursalSolicitudHoraExtra(esInicial);
		this.setResaltarid_empleadoSolicitudHoraExtra(esInicial);
		this.setResaltarid_estructuraSolicitudHoraExtra(esInicial);
		this.setResaltarid_empleado_jefeSolicitudHoraExtra(esInicial);
		this.setResaltarid_estado_solicitud_nomiSolicitudHoraExtra(esInicial);
		this.setResaltarid_empleado_reemplazoSolicitudHoraExtra(esInicial);
		this.setResaltarsecuencialSolicitudHoraExtra(esInicial);
		this.setResaltarfecha_solicitaSolicitudHoraExtra(esInicial);
		this.setResaltarfecha_ejecutaSolicitudHoraExtra(esInicial);
		this.setResaltarnumero_horasSolicitudHoraExtra(esInicial);
		this.setResaltarcosto_unitarioSolicitudHoraExtra(esInicial);
		this.setResaltarcosto_totalSolicitudHoraExtra(esInicial);
		this.setResaltardescripcionSolicitudHoraExtra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.ID)) {
				this.setResaltaridSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE)) {
				this.setResaltarid_empleado_jefeSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI)) {
				this.setResaltarid_estado_solicitud_nomiSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO)) {
				this.setResaltarid_empleado_reemplazoSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.FECHASOLICITA)) {
				this.setResaltarfecha_solicitaSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.FECHAEJECUTA)) {
				this.setResaltarfecha_ejecutaSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.NUMEROHORAS)) {
				this.setResaltarnumero_horasSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalSolicitudHoraExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(SolicitudHoraExtraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionSolicitudHoraExtra(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoSolicitudHoraExtra=true;

	public Boolean getMostrarFK_IdEmpleadoSolicitudHoraExtra() {
		return this.mostrarFK_IdEmpleadoSolicitudHoraExtra;
	}

	public void setMostrarFK_IdEmpleadoSolicitudHoraExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoSolicitudHoraExtra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoJefeSolicitudHoraExtra=true;

	public Boolean getMostrarFK_IdEmpleadoJefeSolicitudHoraExtra() {
		return this.mostrarFK_IdEmpleadoJefeSolicitudHoraExtra;
	}

	public void setMostrarFK_IdEmpleadoJefeSolicitudHoraExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoJefeSolicitudHoraExtra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoReemplazoSolicitudHoraExtra=true;

	public Boolean getMostrarFK_IdEmpleadoReemplazoSolicitudHoraExtra() {
		return this.mostrarFK_IdEmpleadoReemplazoSolicitudHoraExtra;
	}

	public void setMostrarFK_IdEmpleadoReemplazoSolicitudHoraExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoReemplazoSolicitudHoraExtra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSolicitudHoraExtra=true;

	public Boolean getMostrarFK_IdEmpresaSolicitudHoraExtra() {
		return this.mostrarFK_IdEmpresaSolicitudHoraExtra;
	}

	public void setMostrarFK_IdEmpresaSolicitudHoraExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSolicitudHoraExtra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoSolicitudNomiSolicitudHoraExtra=true;

	public Boolean getMostrarFK_IdEstadoSolicitudNomiSolicitudHoraExtra() {
		return this.mostrarFK_IdEstadoSolicitudNomiSolicitudHoraExtra;
	}

	public void setMostrarFK_IdEstadoSolicitudNomiSolicitudHoraExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoSolicitudNomiSolicitudHoraExtra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraSolicitudHoraExtra=true;

	public Boolean getMostrarFK_IdEstructuraSolicitudHoraExtra() {
		return this.mostrarFK_IdEstructuraSolicitudHoraExtra;
	}

	public void setMostrarFK_IdEstructuraSolicitudHoraExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraSolicitudHoraExtra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalSolicitudHoraExtra=true;

	public Boolean getMostrarFK_IdSucursalSolicitudHoraExtra() {
		return this.mostrarFK_IdSucursalSolicitudHoraExtra;
	}

	public void setMostrarFK_IdSucursalSolicitudHoraExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalSolicitudHoraExtra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoSolicitudHoraExtra=true;

	public Boolean getActivarFK_IdEmpleadoSolicitudHoraExtra() {
		return this.activarFK_IdEmpleadoSolicitudHoraExtra;
	}

	public void setActivarFK_IdEmpleadoSolicitudHoraExtra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoSolicitudHoraExtra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoJefeSolicitudHoraExtra=true;

	public Boolean getActivarFK_IdEmpleadoJefeSolicitudHoraExtra() {
		return this.activarFK_IdEmpleadoJefeSolicitudHoraExtra;
	}

	public void setActivarFK_IdEmpleadoJefeSolicitudHoraExtra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoJefeSolicitudHoraExtra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoReemplazoSolicitudHoraExtra=true;

	public Boolean getActivarFK_IdEmpleadoReemplazoSolicitudHoraExtra() {
		return this.activarFK_IdEmpleadoReemplazoSolicitudHoraExtra;
	}

	public void setActivarFK_IdEmpleadoReemplazoSolicitudHoraExtra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoReemplazoSolicitudHoraExtra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSolicitudHoraExtra=true;

	public Boolean getActivarFK_IdEmpresaSolicitudHoraExtra() {
		return this.activarFK_IdEmpresaSolicitudHoraExtra;
	}

	public void setActivarFK_IdEmpresaSolicitudHoraExtra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSolicitudHoraExtra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoSolicitudNomiSolicitudHoraExtra=true;

	public Boolean getActivarFK_IdEstadoSolicitudNomiSolicitudHoraExtra() {
		return this.activarFK_IdEstadoSolicitudNomiSolicitudHoraExtra;
	}

	public void setActivarFK_IdEstadoSolicitudNomiSolicitudHoraExtra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoSolicitudNomiSolicitudHoraExtra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraSolicitudHoraExtra=true;

	public Boolean getActivarFK_IdEstructuraSolicitudHoraExtra() {
		return this.activarFK_IdEstructuraSolicitudHoraExtra;
	}

	public void setActivarFK_IdEstructuraSolicitudHoraExtra(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraSolicitudHoraExtra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalSolicitudHoraExtra=true;

	public Boolean getActivarFK_IdSucursalSolicitudHoraExtra() {
		return this.activarFK_IdSucursalSolicitudHoraExtra;
	}

	public void setActivarFK_IdSucursalSolicitudHoraExtra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalSolicitudHoraExtra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoSolicitudHoraExtra=null;

	public Border getResaltarFK_IdEmpleadoSolicitudHoraExtra() {
		return this.resaltarFK_IdEmpleadoSolicitudHoraExtra;
	}

	public void setResaltarFK_IdEmpleadoSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoSolicitudHoraExtra= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoSolicitudHoraExtra= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoJefeSolicitudHoraExtra=null;

	public Border getResaltarFK_IdEmpleadoJefeSolicitudHoraExtra() {
		return this.resaltarFK_IdEmpleadoJefeSolicitudHoraExtra;
	}

	public void setResaltarFK_IdEmpleadoJefeSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoJefeSolicitudHoraExtra= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoJefeSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoJefeSolicitudHoraExtra= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoReemplazoSolicitudHoraExtra=null;

	public Border getResaltarFK_IdEmpleadoReemplazoSolicitudHoraExtra() {
		return this.resaltarFK_IdEmpleadoReemplazoSolicitudHoraExtra;
	}

	public void setResaltarFK_IdEmpleadoReemplazoSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoReemplazoSolicitudHoraExtra= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoReemplazoSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoReemplazoSolicitudHoraExtra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSolicitudHoraExtra=null;

	public Border getResaltarFK_IdEmpresaSolicitudHoraExtra() {
		return this.resaltarFK_IdEmpresaSolicitudHoraExtra;
	}

	public void setResaltarFK_IdEmpresaSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSolicitudHoraExtra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSolicitudHoraExtra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoSolicitudNomiSolicitudHoraExtra=null;

	public Border getResaltarFK_IdEstadoSolicitudNomiSolicitudHoraExtra() {
		return this.resaltarFK_IdEstadoSolicitudNomiSolicitudHoraExtra;
	}

	public void setResaltarFK_IdEstadoSolicitudNomiSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarFK_IdEstadoSolicitudNomiSolicitudHoraExtra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoSolicitudNomiSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoSolicitudNomiSolicitudHoraExtra= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraSolicitudHoraExtra=null;

	public Border getResaltarFK_IdEstructuraSolicitudHoraExtra() {
		return this.resaltarFK_IdEstructuraSolicitudHoraExtra;
	}

	public void setResaltarFK_IdEstructuraSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarFK_IdEstructuraSolicitudHoraExtra= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraSolicitudHoraExtra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalSolicitudHoraExtra=null;

	public Border getResaltarFK_IdSucursalSolicitudHoraExtra() {
		return this.resaltarFK_IdSucursalSolicitudHoraExtra;
	}

	public void setResaltarFK_IdSucursalSolicitudHoraExtra(Border borderResaltar) {
		this.resaltarFK_IdSucursalSolicitudHoraExtra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalSolicitudHoraExtra(ParametroGeneralUsuario parametroGeneralUsuario/*SolicitudHoraExtraBeanSwingJInternalFrame solicitudhoraextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalSolicitudHoraExtra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}