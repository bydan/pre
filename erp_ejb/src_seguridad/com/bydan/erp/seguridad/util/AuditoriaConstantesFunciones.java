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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.AuditoriaConstantesFunciones;
import com.bydan.erp.seguridad.util.AuditoriaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.AuditoriaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AuditoriaConstantesFunciones extends AuditoriaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AuditoriaFinal";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Auditoria"+AuditoriaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AuditoriaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AuditoriaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AuditoriaConstantesFunciones.SCHEMA+"_"+AuditoriaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AuditoriaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AuditoriaConstantesFunciones.SCHEMA+"_"+AuditoriaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AuditoriaConstantesFunciones.SCHEMA+"_"+AuditoriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AuditoriaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AuditoriaConstantesFunciones.SCHEMA+"_"+AuditoriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AuditoriaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AuditoriaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AuditoriaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AuditoriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AuditoriaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AuditoriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AuditoriaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AuditoriaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AuditoriaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AuditoriaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Auditorias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Auditoria";
	public static final String SCLASSWEBTITULO_LOWER="Auditoria";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Auditoria";
	public static final String OBJECTNAME="auditoria";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_AUDITORIA;	
	public static final String TABLENAME="auditoria";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select auditoria from "+AuditoriaConstantesFunciones.SPERSISTENCENAME+" auditoria";
	public static String QUERYSELECTNATIVE="select "+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".id,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".version_row,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".id_usuario,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".nombre_tabla,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".id_fila,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".accion,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".proceso,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".nombre_p_c,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".ip_pc,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".usuario_p_c,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".fecha_hora,"+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME+".observacion from "+AuditoriaConstantesFunciones.SCHEMA+"."+AuditoriaConstantesFunciones.TABLENAME;//+" as "+AuditoriaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=true;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AuditoriaConstantesFuncionesAdditional auditoriaConstantesFuncionesAdditional=null;
	
	public AuditoriaConstantesFuncionesAdditional getAuditoriaConstantesFuncionesAdditional() {
		return this.auditoriaConstantesFuncionesAdditional;
	}
	
	public void setAuditoriaConstantesFuncionesAdditional(AuditoriaConstantesFuncionesAdditional auditoriaConstantesFuncionesAdditional) {
		try {
			this.auditoriaConstantesFuncionesAdditional=auditoriaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDUSUARIO= "id_usuario";
    public static final String NOMBRETABLA= "nombre_tabla";
    public static final String IDFILA= "id_fila";
    public static final String ACCION= "accion";
    public static final String PROCESO= "proceso";
    public static final String NOMBREPC= "nombre_p_c";
    public static final String IPPC= "ip_pc";
    public static final String USUARIOPC= "usuario_p_c";
    public static final String FECHAHORA= "fecha_hora";
    public static final String OBSERVACION= "observacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "A";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "A";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_NOMBRETABLA= "Nombre De La Tabla";
		public static final String LABEL_NOMBRETABLA_LOWER= "Nombre Tabla";
    	public static final String LABEL_IDFILA= "Fila";
		public static final String LABEL_IDFILA_LOWER= "id Fila";
    	public static final String LABEL_ACCION= "Accion";
		public static final String LABEL_ACCION_LOWER= "Accion";
    	public static final String LABEL_PROCESO= "Proceso";
		public static final String LABEL_PROCESO_LOWER= "Proceso";
    	public static final String LABEL_NOMBREPC= "Nombre De Pc";
		public static final String LABEL_NOMBREPC_LOWER= "Nombre P C";
    	public static final String LABEL_IPPC= "Ip Del Pc";
		public static final String LABEL_IPPC_LOWER= "I P P C";
    	public static final String LABEL_USUARIOPC= "Usuario Del Pc";
		public static final String LABEL_USUARIOPC_LOWER= "Usuario P C";
    	public static final String LABEL_FECHAHORA= "Fecha Y Hora";
		public static final String LABEL_FECHAHORA_LOWER= "Fecha Hora";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
	
		
		
		
	public static final String SREGEXNOMBRE_TABLA=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXNOMBRE_TABLA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXACCION=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXACCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPROCESO=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXPROCESO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_P_C=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXNOMBRE_P_C=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXIP_PC=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXIP_PC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXUSUARIO_P_C=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXUSUARIO_P_C=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENATODOS;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getAuditoriaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AuditoriaConstantesFunciones.IDUSUARIO)) {sLabelColumna=AuditoriaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(AuditoriaConstantesFunciones.NOMBRETABLA)) {sLabelColumna=AuditoriaConstantesFunciones.LABEL_NOMBRETABLA;}
		if(sNombreColumna.equals(AuditoriaConstantesFunciones.IDFILA)) {sLabelColumna=AuditoriaConstantesFunciones.LABEL_IDFILA;}
		if(sNombreColumna.equals(AuditoriaConstantesFunciones.ACCION)) {sLabelColumna=AuditoriaConstantesFunciones.LABEL_ACCION;}
		if(sNombreColumna.equals(AuditoriaConstantesFunciones.PROCESO)) {sLabelColumna=AuditoriaConstantesFunciones.LABEL_PROCESO;}
		if(sNombreColumna.equals(AuditoriaConstantesFunciones.NOMBREPC)) {sLabelColumna=AuditoriaConstantesFunciones.LABEL_NOMBREPC;}
		if(sNombreColumna.equals(AuditoriaConstantesFunciones.IPPC)) {sLabelColumna=AuditoriaConstantesFunciones.LABEL_IPPC;}
		if(sNombreColumna.equals(AuditoriaConstantesFunciones.USUARIOPC)) {sLabelColumna=AuditoriaConstantesFunciones.LABEL_USUARIOPC;}
		if(sNombreColumna.equals(AuditoriaConstantesFunciones.FECHAHORA)) {sLabelColumna=AuditoriaConstantesFunciones.LABEL_FECHAHORA;}
		if(sNombreColumna.equals(AuditoriaConstantesFunciones.OBSERVACION)) {sLabelColumna=AuditoriaConstantesFunciones.LABEL_OBSERVACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAuditoriaDescripcion(Auditoria auditoria) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(auditoria !=null/* && auditoria.getId()!=0*/) {
			if(auditoria.getId()!=null) {
				sDescripcion=auditoria.getId().toString();
			}//auditoriaauditoria.getId().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAuditoriaDescripcionDetallado(Auditoria auditoria) {
		String sDescripcion="";
			
		sDescripcion+=AuditoriaConstantesFunciones.ID+"=";
		sDescripcion+=auditoria.getId().toString()+",";
		sDescripcion+=AuditoriaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=auditoria.getVersionRow().toString()+",";
		sDescripcion+=AuditoriaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=auditoria.getid_usuario().toString()+",";
		sDescripcion+=AuditoriaConstantesFunciones.NOMBRETABLA+"=";
		sDescripcion+=auditoria.getnombre_tabla()+",";
		sDescripcion+=AuditoriaConstantesFunciones.IDFILA+"=";
		sDescripcion+=auditoria.getid_fila().toString()+",";
		sDescripcion+=AuditoriaConstantesFunciones.ACCION+"=";
		sDescripcion+=auditoria.getaccion()+",";
		sDescripcion+=AuditoriaConstantesFunciones.PROCESO+"=";
		sDescripcion+=auditoria.getproceso()+",";
		sDescripcion+=AuditoriaConstantesFunciones.NOMBREPC+"=";
		sDescripcion+=auditoria.getnombre_p_c()+",";
		sDescripcion+=AuditoriaConstantesFunciones.IPPC+"=";
		sDescripcion+=auditoria.getip_pc()+",";
		sDescripcion+=AuditoriaConstantesFunciones.USUARIOPC+"=";
		sDescripcion+=auditoria.getusuario_p_c()+",";
		sDescripcion+=AuditoriaConstantesFunciones.FECHAHORA+"=";
		sDescripcion+=auditoria.getfecha_hora().toString()+",";
		sDescripcion+=AuditoriaConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=auditoria.getobservacion()+",";
			
		return sDescripcion;
	}
	
	public static void setAuditoriaDescripcion(Auditoria auditoria,String sValor) throws Exception {			
		if(auditoria !=null) {
			;//auditoriaauditoria.getId().toString().trim();
		}		
	}
	
		

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdUsuarioPorFechaHora")) {
			sNombreIndice="Tipo=  Por Usuario Por Fecha Y Hora";
		} else if(sNombreIndice.equals("BusquedaPorIPPCPorFechaHora")) {
			sNombreIndice="Tipo=  Por Ip Del Pc Por Fecha Y Hora";
		} else if(sNombreIndice.equals("BusquedaPorNombrePCPorFechaHora")) {
			sNombreIndice="Tipo=  Por Nombre De Pc Por Fecha Y Hora";
		} else if(sNombreIndice.equals("BusquedaPorNombreTablaPorFechaHora")) {
			sNombreIndice="Tipo=  Por Nombre De La Tabla Por Fecha Y Hora";
		} else if(sNombreIndice.equals("BusquedaPorObservacionesPorFechaHora")) {
			sNombreIndice="Tipo=  Por Fecha Y Hora Por Observacion";
		} else if(sNombreIndice.equals("BusquedaPorProcesoPorFechaHora")) {
			sNombreIndice="Tipo=  Por Proceso Por Fecha Y Hora";
		} else if(sNombreIndice.equals("BusquedaPorUsuarioPCPorFechaHora")) {
			sNombreIndice="Tipo=  Por Usuario Del Pc Por Fecha Y Hora";
		} else if(sNombreIndice.equals("FK_IdAuditoria")) {
			sNombreIndice="Tipo=  Por Fila";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdUsuarioPorFechaHora(Long id_usuario,Timestamp fecha_hora,Timestamp fecha_horaFinal) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();}
		if(fecha_hora!=null) {sDetalleIndice+=" Fecha Y Hora="+fecha_hora.toString();}
		if(fecha_horaFinal!=null) {sDetalleIndice+=" Fecha Y Hora FINAL="+fecha_horaFinal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorIPPCPorFechaHora(String ip_pc,Timestamp fecha_hora,Timestamp fecha_horaFinal) {
		String sDetalleIndice=" Parametros->";
		if(ip_pc!=null) {sDetalleIndice+=" Ip Del Pc="+ip_pc;}
		if(fecha_hora!=null) {sDetalleIndice+=" Fecha Y Hora="+fecha_hora.toString();}
		if(fecha_horaFinal!=null) {sDetalleIndice+=" Fecha Y Hora FINAL="+fecha_horaFinal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombrePCPorFechaHora(String nombre_p_c,Timestamp fecha_hora,Timestamp fecha_horaFinal) {
		String sDetalleIndice=" Parametros->";
		if(nombre_p_c!=null) {sDetalleIndice+=" Nombre De Pc="+nombre_p_c;}
		if(fecha_hora!=null) {sDetalleIndice+=" Fecha Y Hora="+fecha_hora.toString();}
		if(fecha_horaFinal!=null) {sDetalleIndice+=" Fecha Y Hora FINAL="+fecha_horaFinal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombreTablaPorFechaHora(String nombre_tabla,Timestamp fecha_hora,Timestamp fecha_horaFinal) {
		String sDetalleIndice=" Parametros->";
		if(nombre_tabla!=null) {sDetalleIndice+=" Nombre De La Tabla="+nombre_tabla;}
		if(fecha_hora!=null) {sDetalleIndice+=" Fecha Y Hora="+fecha_hora.toString();}
		if(fecha_horaFinal!=null) {sDetalleIndice+=" Fecha Y Hora FINAL="+fecha_horaFinal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorObservacionesPorFechaHora(Timestamp fecha_hora,Timestamp fecha_horaFinal,String observacion) {
		String sDetalleIndice=" Parametros->";
		if(fecha_hora!=null) {sDetalleIndice+=" Fecha Y Hora="+fecha_hora.toString();}
		if(fecha_horaFinal!=null) {sDetalleIndice+=" Fecha Y Hora FINAL="+fecha_horaFinal.toString();}
		if(observacion!=null) {sDetalleIndice+=" Observacion="+observacion;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorProcesoPorFechaHora(String proceso,Timestamp fecha_hora,Timestamp fecha_horaFinal) {
		String sDetalleIndice=" Parametros->";
		if(proceso!=null) {sDetalleIndice+=" Proceso="+proceso;}
		if(fecha_hora!=null) {sDetalleIndice+=" Fecha Y Hora="+fecha_hora.toString();}
		if(fecha_horaFinal!=null) {sDetalleIndice+=" Fecha Y Hora FINAL="+fecha_horaFinal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorUsuarioPCPorFechaHora(String usuario_p_c,Timestamp fecha_hora,Timestamp fecha_horaFinal) {
		String sDetalleIndice=" Parametros->";
		if(usuario_p_c!=null) {sDetalleIndice+=" Usuario Del Pc="+usuario_p_c;}
		if(fecha_hora!=null) {sDetalleIndice+=" Fecha Y Hora="+fecha_hora.toString();}
		if(fecha_horaFinal!=null) {sDetalleIndice+=" Fecha Y Hora FINAL="+fecha_horaFinal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAuditoria(Long id_fila) {
		String sDetalleIndice=" Parametros->";
		if(id_fila!=null) {sDetalleIndice+=" Fila="+id_fila.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAuditoria(Auditoria auditoria,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		auditoria.setnombre_tabla(auditoria.getnombre_tabla().trim());
		auditoria.setaccion(auditoria.getaccion().trim());
		auditoria.setproceso(auditoria.getproceso().trim());
		auditoria.setnombre_p_c(auditoria.getnombre_p_c().trim());
		auditoria.setip_pc(auditoria.getip_pc().trim());
		auditoria.setusuario_p_c(auditoria.getusuario_p_c().trim());
		auditoria.setobservacion(auditoria.getobservacion().trim());
	}
	
	public static void quitarEspaciosAuditorias(List<Auditoria> auditorias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Auditoria auditoria: auditorias) {
			auditoria.setnombre_tabla(auditoria.getnombre_tabla().trim());
			auditoria.setaccion(auditoria.getaccion().trim());
			auditoria.setproceso(auditoria.getproceso().trim());
			auditoria.setnombre_p_c(auditoria.getnombre_p_c().trim());
			auditoria.setip_pc(auditoria.getip_pc().trim());
			auditoria.setusuario_p_c(auditoria.getusuario_p_c().trim());
			auditoria.setobservacion(auditoria.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAuditoria(Auditoria auditoria,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && auditoria.getConCambioAuxiliar()) {
			auditoria.setIsDeleted(auditoria.getIsDeletedAuxiliar());	
			auditoria.setIsNew(auditoria.getIsNewAuxiliar());	
			auditoria.setIsChanged(auditoria.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			auditoria.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			auditoria.setIsDeletedAuxiliar(false);	
			auditoria.setIsNewAuxiliar(false);	
			auditoria.setIsChangedAuxiliar(false);
			
			auditoria.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAuditorias(List<Auditoria> auditorias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Auditoria auditoria : auditorias) {
			if(conAsignarBase && auditoria.getConCambioAuxiliar()) {
				auditoria.setIsDeleted(auditoria.getIsDeletedAuxiliar());	
				auditoria.setIsNew(auditoria.getIsNewAuxiliar());	
				auditoria.setIsChanged(auditoria.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				auditoria.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				auditoria.setIsDeletedAuxiliar(false);	
				auditoria.setIsNewAuxiliar(false);	
				auditoria.setIsChangedAuxiliar(false);
				
				auditoria.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAuditoria(Auditoria auditoria,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			auditoria.setid_fila(0L);
		}
	}		
	
	public static void InicializarValoresAuditorias(List<Auditoria> auditorias,Boolean conEnteros) throws Exception  {
		
		for(Auditoria auditoria: auditorias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				auditoria.setid_fila(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaAuditoria(List<Auditoria> auditorias,Auditoria auditoriaAux) throws Exception  {
		AuditoriaConstantesFunciones.InicializarValoresAuditoria(auditoriaAux,true);
		
		for(Auditoria auditoria: auditorias) {
			if(auditoria.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			auditoriaAux.setid_fila(auditoriaAux.getid_fila()+auditoria.getid_fila());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAuditoria(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AuditoriaConstantesFunciones.getArrayColumnasGlobalesAuditoria(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAuditoria(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AuditoriaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AuditoriaConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAuditoria(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Auditoria> auditorias,Auditoria auditoria,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Auditoria auditoriaAux: auditorias) {
			if(auditoriaAux!=null && auditoria!=null) {
				if((auditoriaAux.getId()==null && auditoria.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(auditoriaAux.getId()!=null && auditoria.getId()!=null){
					if(auditoriaAux.getId().equals(auditoria.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAuditoria(List<Auditoria> auditorias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Auditoria auditoria: auditorias) {			
			if(auditoria.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAuditoria() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_ID, AuditoriaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_VERSIONROW, AuditoriaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_IDUSUARIO, AuditoriaConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_NOMBRETABLA, AuditoriaConstantesFunciones.NOMBRETABLA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_IDFILA, AuditoriaConstantesFunciones.IDFILA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_ACCION, AuditoriaConstantesFunciones.ACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_PROCESO, AuditoriaConstantesFunciones.PROCESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_NOMBREPC, AuditoriaConstantesFunciones.NOMBREPC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_IPPC, AuditoriaConstantesFunciones.IPPC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_USUARIOPC, AuditoriaConstantesFunciones.USUARIOPC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_FECHAHORA, AuditoriaConstantesFunciones.FECHAHORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AuditoriaConstantesFunciones.LABEL_OBSERVACION, AuditoriaConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAuditoria() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.NOMBRETABLA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.IDFILA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.ACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.PROCESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.NOMBREPC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.IPPC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.USUARIOPC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.FECHAHORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AuditoriaConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAuditoria() throws Exception  {
		return AuditoriaConstantesFunciones.getTiposSeleccionarAuditoria(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAuditoria(Boolean conFk) throws Exception  {
		return AuditoriaConstantesFunciones.getTiposSeleccionarAuditoria(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAuditoria(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(AuditoriaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaConstantesFunciones.LABEL_NOMBRETABLA);
			reporte.setsDescripcion(AuditoriaConstantesFunciones.LABEL_NOMBRETABLA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaConstantesFunciones.LABEL_IDFILA);
			reporte.setsDescripcion(AuditoriaConstantesFunciones.LABEL_IDFILA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaConstantesFunciones.LABEL_ACCION);
			reporte.setsDescripcion(AuditoriaConstantesFunciones.LABEL_ACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaConstantesFunciones.LABEL_PROCESO);
			reporte.setsDescripcion(AuditoriaConstantesFunciones.LABEL_PROCESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaConstantesFunciones.LABEL_NOMBREPC);
			reporte.setsDescripcion(AuditoriaConstantesFunciones.LABEL_NOMBREPC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaConstantesFunciones.LABEL_IPPC);
			reporte.setsDescripcion(AuditoriaConstantesFunciones.LABEL_IPPC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaConstantesFunciones.LABEL_USUARIOPC);
			reporte.setsDescripcion(AuditoriaConstantesFunciones.LABEL_USUARIOPC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(AuditoriaConstantesFunciones.LABEL_FECHAHORA);
		reporte.setsDescripcion(AuditoriaConstantesFunciones.LABEL_FECHAHORA);

		arrTiposSeleccionarTodos.add(reporte);
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AuditoriaConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(AuditoriaConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAuditoria(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAuditoria(Auditoria auditoriaAux) throws Exception {
		
			auditoriaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(auditoriaAux.getUsuario()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAuditoria(List<Auditoria> auditoriasTemp) throws Exception {
		for(Auditoria auditoriaAux:auditoriasTemp) {
			
			auditoriaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(auditoriaAux.getUsuario()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAuditoria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Usuario.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAuditoria(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAuditoria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AuditoriaConstantesFunciones.getClassesRelationshipsOfAuditoria(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAuditoria(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(AuditoriaDetalle.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(AuditoriaDetalle.class)) {
						classes.add(new Classe(AuditoriaDetalle.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAuditoria(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AuditoriaConstantesFunciones.getClassesRelationshipsFromStringsOfAuditoria(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAuditoria(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(AuditoriaDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AuditoriaDetalle.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(AuditoriaDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AuditoriaDetalle.class)); continue;
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
	public static void actualizarLista(Auditoria auditoria,List<Auditoria> auditorias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Auditoria auditoriaEncontrado=null;
			
			for(Auditoria auditoriaLocal:auditorias) {
				if(auditoriaLocal.getId().equals(auditoria.getId())) {
					auditoriaEncontrado=auditoriaLocal;
					
					auditoriaLocal.setIsChanged(auditoria.getIsChanged());
					auditoriaLocal.setIsNew(auditoria.getIsNew());
					auditoriaLocal.setIsDeleted(auditoria.getIsDeleted());
					
					auditoriaLocal.setGeneralEntityOriginal(auditoria.getGeneralEntityOriginal());
					
					auditoriaLocal.setId(auditoria.getId());	
					auditoriaLocal.setVersionRow(auditoria.getVersionRow());	
					auditoriaLocal.setid_usuario(auditoria.getid_usuario());	
					auditoriaLocal.setnombre_tabla(auditoria.getnombre_tabla());	
					auditoriaLocal.setid_fila(auditoria.getid_fila());	
					auditoriaLocal.setaccion(auditoria.getaccion());	
					auditoriaLocal.setproceso(auditoria.getproceso());	
					auditoriaLocal.setnombre_p_c(auditoria.getnombre_p_c());	
					auditoriaLocal.setip_pc(auditoria.getip_pc());	
					auditoriaLocal.setusuario_p_c(auditoria.getusuario_p_c());	
					auditoriaLocal.setfecha_hora(auditoria.getfecha_hora());	
					auditoriaLocal.setobservacion(auditoria.getobservacion());	
					
					
					auditoriaLocal.setAuditoriaDetalles(auditoria.getAuditoriaDetalles());
					
					existe=true;
					break;
				}
			}
			
			if(!auditoria.getIsDeleted()) {
				if(!existe) {
					auditorias.add(auditoria);
				}
			} else {
				if(auditoriaEncontrado!=null && permiteQuitar)  {
					auditorias.remove(auditoriaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Auditoria auditoria,List<Auditoria> auditorias) throws Exception {
		try	{			
			for(Auditoria auditoriaLocal:auditorias) {
				if(auditoriaLocal.getId().equals(auditoria.getId())) {
					auditoriaLocal.setIsSelected(auditoria.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAuditoria(List<Auditoria> auditoriasAux) throws Exception {
		//this.auditoriasAux=auditoriasAux;
		
		for(Auditoria auditoriaAux:auditoriasAux) {
			if(auditoriaAux.getIsChanged()) {
				auditoriaAux.setIsChanged(false);
			}		
			
			if(auditoriaAux.getIsNew()) {
				auditoriaAux.setIsNew(false);
			}	
			
			if(auditoriaAux.getIsDeleted()) {
				auditoriaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAuditoria(Auditoria auditoriaAux) throws Exception {
		//this.auditoriaAux=auditoriaAux;
		
			if(auditoriaAux.getIsChanged()) {
				auditoriaAux.setIsChanged(false);
			}		
			
			if(auditoriaAux.getIsNew()) {
				auditoriaAux.setIsNew(false);
			}	
			
			if(auditoriaAux.getIsDeleted()) {
				auditoriaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Auditoria auditoriaAsignar,Auditoria auditoria) throws Exception {
		auditoriaAsignar.setId(auditoria.getId());	
		auditoriaAsignar.setVersionRow(auditoria.getVersionRow());	
		auditoriaAsignar.setid_usuario(auditoria.getid_usuario());
		auditoriaAsignar.setusuario_descripcion(auditoria.getusuario_descripcion());	
		auditoriaAsignar.setnombre_tabla(auditoria.getnombre_tabla());	
		auditoriaAsignar.setid_fila(auditoria.getid_fila());	
		auditoriaAsignar.setaccion(auditoria.getaccion());	
		auditoriaAsignar.setproceso(auditoria.getproceso());	
		auditoriaAsignar.setnombre_p_c(auditoria.getnombre_p_c());	
		auditoriaAsignar.setip_pc(auditoria.getip_pc());	
		auditoriaAsignar.setusuario_p_c(auditoria.getusuario_p_c());	
		auditoriaAsignar.setfecha_hora(auditoria.getfecha_hora());	
		auditoriaAsignar.setobservacion(auditoria.getobservacion());	
	}
	
	public static void inicializarAuditoria(Auditoria auditoria) throws Exception {
		try {
				auditoria.setId(0L);	
					
				auditoria.setid_usuario(-1L);	
				auditoria.setnombre_tabla("");	
				auditoria.setid_fila(0L);	
				auditoria.setaccion("");	
				auditoria.setproceso("");	
				auditoria.setnombre_p_c("");	
				auditoria.setip_pc("");	
				auditoria.setusuario_p_c("");	
				auditoria.setfecha_hora(new Timestamp((new Date()).getTime()));	
				auditoria.setobservacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAuditoria(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaConstantesFunciones.LABEL_NOMBRETABLA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaConstantesFunciones.LABEL_IDFILA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaConstantesFunciones.LABEL_ACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaConstantesFunciones.LABEL_PROCESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaConstantesFunciones.LABEL_NOMBREPC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaConstantesFunciones.LABEL_IPPC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaConstantesFunciones.LABEL_USUARIOPC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaConstantesFunciones.LABEL_FECHAHORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AuditoriaConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAuditoria(String sTipo,Row row,Workbook workbook,Auditoria auditoria,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoria.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoria.getnombre_tabla());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoria.getid_fila());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoria.getaccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoria.getproceso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoria.getnombre_p_c());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoria.getip_pc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoria.getusuario_p_c());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoria.getfecha_hora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(auditoria.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAuditoria=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAuditoria() {
		return this.sFinalQueryAuditoria;
	}
	
	public void setsFinalQueryAuditoria(String sFinalQueryAuditoria) {
		this.sFinalQueryAuditoria= sFinalQueryAuditoria;
	}
	
	public Border resaltarSeleccionarAuditoria=null;
	
	public Border setResaltarSeleccionarAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAuditoria= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAuditoria() {
		return this.resaltarSeleccionarAuditoria;
	}
	
	public void setResaltarSeleccionarAuditoria(Border borderResaltarSeleccionarAuditoria) {
		this.resaltarSeleccionarAuditoria= borderResaltarSeleccionarAuditoria;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAuditoria=null;
	public Boolean mostraridAuditoria=true;
	public Boolean activaridAuditoria=true;

	public Border resaltarid_usuarioAuditoria=null;
	public Boolean mostrarid_usuarioAuditoria=true;
	public Boolean activarid_usuarioAuditoria=true;
	public Boolean cargarid_usuarioAuditoria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioAuditoria=false;//ConEventDepend=true

	public Border resaltarnombre_tablaAuditoria=null;
	public Boolean mostrarnombre_tablaAuditoria=true;
	public Boolean activarnombre_tablaAuditoria=true;

	public Border resaltarid_filaAuditoria=null;
	public Boolean mostrarid_filaAuditoria=true;
	public Boolean activarid_filaAuditoria=true;

	public Border resaltaraccionAuditoria=null;
	public Boolean mostraraccionAuditoria=true;
	public Boolean activaraccionAuditoria=true;

	public Border resaltarprocesoAuditoria=null;
	public Boolean mostrarprocesoAuditoria=true;
	public Boolean activarprocesoAuditoria=true;

	public Border resaltarnombre_p_cAuditoria=null;
	public Boolean mostrarnombre_p_cAuditoria=true;
	public Boolean activarnombre_p_cAuditoria=true;

	public Border resaltarip_pcAuditoria=null;
	public Boolean mostrarip_pcAuditoria=true;
	public Boolean activarip_pcAuditoria=true;

	public Border resaltarusuario_p_cAuditoria=null;
	public Boolean mostrarusuario_p_cAuditoria=true;
	public Boolean activarusuario_p_cAuditoria=true;

	public Border resaltarfecha_horaAuditoria=null;
	public Boolean mostrarfecha_horaAuditoria=true;
	public Boolean activarfecha_horaAuditoria=true;

	public Border resaltarobservacionAuditoria=null;
	public Boolean mostrarobservacionAuditoria=true;
	public Boolean activarobservacionAuditoria=true;

	
	

	public Border setResaltaridAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltaridAuditoria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAuditoria() {
		return this.resaltaridAuditoria;
	}

	public void setResaltaridAuditoria(Border borderResaltar) {
		this.resaltaridAuditoria= borderResaltar;
	}

	public Boolean getMostraridAuditoria() {
		return this.mostraridAuditoria;
	}

	public void setMostraridAuditoria(Boolean mostraridAuditoria) {
		this.mostraridAuditoria= mostraridAuditoria;
	}

	public Boolean getActivaridAuditoria() {
		return this.activaridAuditoria;
	}

	public void setActivaridAuditoria(Boolean activaridAuditoria) {
		this.activaridAuditoria= activaridAuditoria;
	}

	public Border setResaltarid_usuarioAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltarid_usuarioAuditoria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioAuditoria() {
		return this.resaltarid_usuarioAuditoria;
	}

	public void setResaltarid_usuarioAuditoria(Border borderResaltar) {
		this.resaltarid_usuarioAuditoria= borderResaltar;
	}

	public Boolean getMostrarid_usuarioAuditoria() {
		return this.mostrarid_usuarioAuditoria;
	}

	public void setMostrarid_usuarioAuditoria(Boolean mostrarid_usuarioAuditoria) {
		this.mostrarid_usuarioAuditoria= mostrarid_usuarioAuditoria;
	}

	public Boolean getActivarid_usuarioAuditoria() {
		return this.activarid_usuarioAuditoria;
	}

	public void setActivarid_usuarioAuditoria(Boolean activarid_usuarioAuditoria) {
		this.activarid_usuarioAuditoria= activarid_usuarioAuditoria;
	}

	public Boolean getCargarid_usuarioAuditoria() {
		return this.cargarid_usuarioAuditoria;
	}

	public void setCargarid_usuarioAuditoria(Boolean cargarid_usuarioAuditoria) {
		this.cargarid_usuarioAuditoria= cargarid_usuarioAuditoria;
	}

	public Border setResaltarnombre_tablaAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltarnombre_tablaAuditoria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tablaAuditoria() {
		return this.resaltarnombre_tablaAuditoria;
	}

	public void setResaltarnombre_tablaAuditoria(Border borderResaltar) {
		this.resaltarnombre_tablaAuditoria= borderResaltar;
	}

	public Boolean getMostrarnombre_tablaAuditoria() {
		return this.mostrarnombre_tablaAuditoria;
	}

	public void setMostrarnombre_tablaAuditoria(Boolean mostrarnombre_tablaAuditoria) {
		this.mostrarnombre_tablaAuditoria= mostrarnombre_tablaAuditoria;
	}

	public Boolean getActivarnombre_tablaAuditoria() {
		return this.activarnombre_tablaAuditoria;
	}

	public void setActivarnombre_tablaAuditoria(Boolean activarnombre_tablaAuditoria) {
		this.activarnombre_tablaAuditoria= activarnombre_tablaAuditoria;
	}

	public Border setResaltarid_filaAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltarid_filaAuditoria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_filaAuditoria() {
		return this.resaltarid_filaAuditoria;
	}

	public void setResaltarid_filaAuditoria(Border borderResaltar) {
		this.resaltarid_filaAuditoria= borderResaltar;
	}

	public Boolean getMostrarid_filaAuditoria() {
		return this.mostrarid_filaAuditoria;
	}

	public void setMostrarid_filaAuditoria(Boolean mostrarid_filaAuditoria) {
		this.mostrarid_filaAuditoria= mostrarid_filaAuditoria;
	}

	public Boolean getActivarid_filaAuditoria() {
		return this.activarid_filaAuditoria;
	}

	public void setActivarid_filaAuditoria(Boolean activarid_filaAuditoria) {
		this.activarid_filaAuditoria= activarid_filaAuditoria;
	}

	public Border setResaltaraccionAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltaraccionAuditoria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaraccionAuditoria() {
		return this.resaltaraccionAuditoria;
	}

	public void setResaltaraccionAuditoria(Border borderResaltar) {
		this.resaltaraccionAuditoria= borderResaltar;
	}

	public Boolean getMostraraccionAuditoria() {
		return this.mostraraccionAuditoria;
	}

	public void setMostraraccionAuditoria(Boolean mostraraccionAuditoria) {
		this.mostraraccionAuditoria= mostraraccionAuditoria;
	}

	public Boolean getActivaraccionAuditoria() {
		return this.activaraccionAuditoria;
	}

	public void setActivaraccionAuditoria(Boolean activaraccionAuditoria) {
		this.activaraccionAuditoria= activaraccionAuditoria;
	}

	public Border setResaltarprocesoAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltarprocesoAuditoria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprocesoAuditoria() {
		return this.resaltarprocesoAuditoria;
	}

	public void setResaltarprocesoAuditoria(Border borderResaltar) {
		this.resaltarprocesoAuditoria= borderResaltar;
	}

	public Boolean getMostrarprocesoAuditoria() {
		return this.mostrarprocesoAuditoria;
	}

	public void setMostrarprocesoAuditoria(Boolean mostrarprocesoAuditoria) {
		this.mostrarprocesoAuditoria= mostrarprocesoAuditoria;
	}

	public Boolean getActivarprocesoAuditoria() {
		return this.activarprocesoAuditoria;
	}

	public void setActivarprocesoAuditoria(Boolean activarprocesoAuditoria) {
		this.activarprocesoAuditoria= activarprocesoAuditoria;
	}

	public Border setResaltarnombre_p_cAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltarnombre_p_cAuditoria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_p_cAuditoria() {
		return this.resaltarnombre_p_cAuditoria;
	}

	public void setResaltarnombre_p_cAuditoria(Border borderResaltar) {
		this.resaltarnombre_p_cAuditoria= borderResaltar;
	}

	public Boolean getMostrarnombre_p_cAuditoria() {
		return this.mostrarnombre_p_cAuditoria;
	}

	public void setMostrarnombre_p_cAuditoria(Boolean mostrarnombre_p_cAuditoria) {
		this.mostrarnombre_p_cAuditoria= mostrarnombre_p_cAuditoria;
	}

	public Boolean getActivarnombre_p_cAuditoria() {
		return this.activarnombre_p_cAuditoria;
	}

	public void setActivarnombre_p_cAuditoria(Boolean activarnombre_p_cAuditoria) {
		this.activarnombre_p_cAuditoria= activarnombre_p_cAuditoria;
	}

	public Border setResaltarip_pcAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltarip_pcAuditoria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarip_pcAuditoria() {
		return this.resaltarip_pcAuditoria;
	}

	public void setResaltarip_pcAuditoria(Border borderResaltar) {
		this.resaltarip_pcAuditoria= borderResaltar;
	}

	public Boolean getMostrarip_pcAuditoria() {
		return this.mostrarip_pcAuditoria;
	}

	public void setMostrarip_pcAuditoria(Boolean mostrarip_pcAuditoria) {
		this.mostrarip_pcAuditoria= mostrarip_pcAuditoria;
	}

	public Boolean getActivarip_pcAuditoria() {
		return this.activarip_pcAuditoria;
	}

	public void setActivarip_pcAuditoria(Boolean activarip_pcAuditoria) {
		this.activarip_pcAuditoria= activarip_pcAuditoria;
	}

	public Border setResaltarusuario_p_cAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltarusuario_p_cAuditoria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarusuario_p_cAuditoria() {
		return this.resaltarusuario_p_cAuditoria;
	}

	public void setResaltarusuario_p_cAuditoria(Border borderResaltar) {
		this.resaltarusuario_p_cAuditoria= borderResaltar;
	}

	public Boolean getMostrarusuario_p_cAuditoria() {
		return this.mostrarusuario_p_cAuditoria;
	}

	public void setMostrarusuario_p_cAuditoria(Boolean mostrarusuario_p_cAuditoria) {
		this.mostrarusuario_p_cAuditoria= mostrarusuario_p_cAuditoria;
	}

	public Boolean getActivarusuario_p_cAuditoria() {
		return this.activarusuario_p_cAuditoria;
	}

	public void setActivarusuario_p_cAuditoria(Boolean activarusuario_p_cAuditoria) {
		this.activarusuario_p_cAuditoria= activarusuario_p_cAuditoria;
	}

	public Border setResaltarfecha_horaAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltarfecha_horaAuditoria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_horaAuditoria() {
		return this.resaltarfecha_horaAuditoria;
	}

	public void setResaltarfecha_horaAuditoria(Border borderResaltar) {
		this.resaltarfecha_horaAuditoria= borderResaltar;
	}

	public Boolean getMostrarfecha_horaAuditoria() {
		return this.mostrarfecha_horaAuditoria;
	}

	public void setMostrarfecha_horaAuditoria(Boolean mostrarfecha_horaAuditoria) {
		this.mostrarfecha_horaAuditoria= mostrarfecha_horaAuditoria;
	}

	public Boolean getActivarfecha_horaAuditoria() {
		return this.activarfecha_horaAuditoria;
	}

	public void setActivarfecha_horaAuditoria(Boolean activarfecha_horaAuditoria) {
		this.activarfecha_horaAuditoria= activarfecha_horaAuditoria;
	}

	public Border setResaltarobservacionAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltar);
		
		this.resaltarobservacionAuditoria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionAuditoria() {
		return this.resaltarobservacionAuditoria;
	}

	public void setResaltarobservacionAuditoria(Border borderResaltar) {
		this.resaltarobservacionAuditoria= borderResaltar;
	}

	public Boolean getMostrarobservacionAuditoria() {
		return this.mostrarobservacionAuditoria;
	}

	public void setMostrarobservacionAuditoria(Boolean mostrarobservacionAuditoria) {
		this.mostrarobservacionAuditoria= mostrarobservacionAuditoria;
	}

	public Boolean getActivarobservacionAuditoria() {
		return this.activarobservacionAuditoria;
	}

	public void setActivarobservacionAuditoria(Boolean activarobservacionAuditoria) {
		this.activarobservacionAuditoria= activarobservacionAuditoria;
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
		
		
		this.setMostraridAuditoria(esInicial);
		this.setMostrarid_usuarioAuditoria(esInicial);
		this.setMostrarnombre_tablaAuditoria(esInicial);
		this.setMostrarid_filaAuditoria(esInicial);
		this.setMostraraccionAuditoria(esInicial);
		this.setMostrarprocesoAuditoria(esInicial);
		this.setMostrarnombre_p_cAuditoria(esInicial);
		this.setMostrarip_pcAuditoria(esInicial);
		this.setMostrarusuario_p_cAuditoria(esInicial);
		this.setMostrarfecha_horaAuditoria(esInicial);
		this.setMostrarobservacionAuditoria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AuditoriaConstantesFunciones.ID)) {
				this.setMostraridAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.NOMBRETABLA)) {
				this.setMostrarnombre_tablaAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.IDFILA)) {
				this.setMostrarid_filaAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.ACCION)) {
				this.setMostraraccionAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.PROCESO)) {
				this.setMostrarprocesoAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.NOMBREPC)) {
				this.setMostrarnombre_p_cAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.IPPC)) {
				this.setMostrarip_pcAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.USUARIOPC)) {
				this.setMostrarusuario_p_cAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.FECHAHORA)) {
				this.setMostrarfecha_horaAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionAuditoria(esAsigna);
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
		
		
		this.setActivaridAuditoria(esInicial);
		this.setActivarid_usuarioAuditoria(esInicial);
		this.setActivarnombre_tablaAuditoria(esInicial);
		this.setActivarid_filaAuditoria(esInicial);
		this.setActivaraccionAuditoria(esInicial);
		this.setActivarprocesoAuditoria(esInicial);
		this.setActivarnombre_p_cAuditoria(esInicial);
		this.setActivarip_pcAuditoria(esInicial);
		this.setActivarusuario_p_cAuditoria(esInicial);
		this.setActivarfecha_horaAuditoria(esInicial);
		this.setActivarobservacionAuditoria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AuditoriaConstantesFunciones.ID)) {
				this.setActivaridAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.NOMBRETABLA)) {
				this.setActivarnombre_tablaAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.IDFILA)) {
				this.setActivarid_filaAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.ACCION)) {
				this.setActivaraccionAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.PROCESO)) {
				this.setActivarprocesoAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.NOMBREPC)) {
				this.setActivarnombre_p_cAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.IPPC)) {
				this.setActivarip_pcAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.USUARIOPC)) {
				this.setActivarusuario_p_cAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.FECHAHORA)) {
				this.setActivarfecha_horaAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionAuditoria(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAuditoria(esInicial);
		this.setResaltarid_usuarioAuditoria(esInicial);
		this.setResaltarnombre_tablaAuditoria(esInicial);
		this.setResaltarid_filaAuditoria(esInicial);
		this.setResaltaraccionAuditoria(esInicial);
		this.setResaltarprocesoAuditoria(esInicial);
		this.setResaltarnombre_p_cAuditoria(esInicial);
		this.setResaltarip_pcAuditoria(esInicial);
		this.setResaltarusuario_p_cAuditoria(esInicial);
		this.setResaltarfecha_horaAuditoria(esInicial);
		this.setResaltarobservacionAuditoria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AuditoriaConstantesFunciones.ID)) {
				this.setResaltaridAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.NOMBRETABLA)) {
				this.setResaltarnombre_tablaAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.IDFILA)) {
				this.setResaltarid_filaAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.ACCION)) {
				this.setResaltaraccionAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.PROCESO)) {
				this.setResaltarprocesoAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.NOMBREPC)) {
				this.setResaltarnombre_p_cAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.IPPC)) {
				this.setResaltarip_pcAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.USUARIOPC)) {
				this.setResaltarusuario_p_cAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.FECHAHORA)) {
				this.setResaltarfecha_horaAuditoria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AuditoriaConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionAuditoria(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarAuditoriaDetalleAuditoria=null;

	public Border getResaltarAuditoriaDetalleAuditoria() {
		return this.resaltarAuditoriaDetalleAuditoria;
	}

	public void setResaltarAuditoriaDetalleAuditoria(Border borderResaltarAuditoriaDetalle) {
		if(borderResaltarAuditoriaDetalle!=null) {
			this.resaltarAuditoriaDetalleAuditoria= borderResaltarAuditoriaDetalle;
		}
	}

	public Border setResaltarAuditoriaDetalleAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltarAuditoriaDetalle=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//auditoriaBeanSwingJInternalFrame.jTtoolBarAuditoria.setBorder(borderResaltarAuditoriaDetalle);
			
		this.resaltarAuditoriaDetalleAuditoria= borderResaltarAuditoriaDetalle;

		 return borderResaltarAuditoriaDetalle;
	}



	public Boolean mostrarAuditoriaDetalleAuditoria=true;

	public Boolean getMostrarAuditoriaDetalleAuditoria() {
		return this.mostrarAuditoriaDetalleAuditoria;
	}

	public void setMostrarAuditoriaDetalleAuditoria(Boolean visibilidadResaltarAuditoriaDetalle) {
		this.mostrarAuditoriaDetalleAuditoria= visibilidadResaltarAuditoriaDetalle;
	}



	public Boolean activarAuditoriaDetalleAuditoria=true;

	public Boolean gethabilitarResaltarAuditoriaDetalleAuditoria() {
		return this.activarAuditoriaDetalleAuditoria;
	}

	public void setActivarAuditoriaDetalleAuditoria(Boolean habilitarResaltarAuditoriaDetalle) {
		this.activarAuditoriaDetalleAuditoria= habilitarResaltarAuditoriaDetalle;
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

		this.setMostrarAuditoriaDetalleAuditoria(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AuditoriaDetalle.class)) {
				this.setMostrarAuditoriaDetalleAuditoria(esAsigna);
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

		this.setActivarAuditoriaDetalleAuditoria(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AuditoriaDetalle.class)) {
				this.setActivarAuditoriaDetalleAuditoria(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarAuditoriaDetalleAuditoria(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AuditoriaDetalle.class)) {
				this.setResaltarAuditoriaDetalleAuditoria(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdUsuarioPorFechaHoraAuditoria=true;

	public Boolean getMostrarBusquedaPorIdUsuarioPorFechaHoraAuditoria() {
		return this.mostrarBusquedaPorIdUsuarioPorFechaHoraAuditoria;
	}

	public void setMostrarBusquedaPorIdUsuarioPorFechaHoraAuditoria(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdUsuarioPorFechaHoraAuditoria= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIPPCPorFechaHoraAuditoria=true;

	public Boolean getMostrarBusquedaPorIPPCPorFechaHoraAuditoria() {
		return this.mostrarBusquedaPorIPPCPorFechaHoraAuditoria;
	}

	public void setMostrarBusquedaPorIPPCPorFechaHoraAuditoria(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIPPCPorFechaHoraAuditoria= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombrePCPorFechaHoraAuditoria=true;

	public Boolean getMostrarBusquedaPorNombrePCPorFechaHoraAuditoria() {
		return this.mostrarBusquedaPorNombrePCPorFechaHoraAuditoria;
	}

	public void setMostrarBusquedaPorNombrePCPorFechaHoraAuditoria(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombrePCPorFechaHoraAuditoria= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTablaPorFechaHoraAuditoria=true;

	public Boolean getMostrarBusquedaPorNombreTablaPorFechaHoraAuditoria() {
		return this.mostrarBusquedaPorNombreTablaPorFechaHoraAuditoria;
	}

	public void setMostrarBusquedaPorNombreTablaPorFechaHoraAuditoria(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTablaPorFechaHoraAuditoria= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorObservacionesPorFechaHoraAuditoria=true;

	public Boolean getMostrarBusquedaPorObservacionesPorFechaHoraAuditoria() {
		return this.mostrarBusquedaPorObservacionesPorFechaHoraAuditoria;
	}

	public void setMostrarBusquedaPorObservacionesPorFechaHoraAuditoria(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorObservacionesPorFechaHoraAuditoria= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorProcesoPorFechaHoraAuditoria=true;

	public Boolean getMostrarBusquedaPorProcesoPorFechaHoraAuditoria() {
		return this.mostrarBusquedaPorProcesoPorFechaHoraAuditoria;
	}

	public void setMostrarBusquedaPorProcesoPorFechaHoraAuditoria(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorProcesoPorFechaHoraAuditoria= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorUsuarioPCPorFechaHoraAuditoria=true;

	public Boolean getMostrarBusquedaPorUsuarioPCPorFechaHoraAuditoria() {
		return this.mostrarBusquedaPorUsuarioPCPorFechaHoraAuditoria;
	}

	public void setMostrarBusquedaPorUsuarioPCPorFechaHoraAuditoria(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorUsuarioPCPorFechaHoraAuditoria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdAuditoriaAuditoria=true;

	public Boolean getMostrarFK_IdAuditoriaAuditoria() {
		return this.mostrarFK_IdAuditoriaAuditoria;
	}

	public void setMostrarFK_IdAuditoriaAuditoria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAuditoriaAuditoria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioAuditoria=true;

	public Boolean getMostrarFK_IdUsuarioAuditoria() {
		return this.mostrarFK_IdUsuarioAuditoria;
	}

	public void setMostrarFK_IdUsuarioAuditoria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioAuditoria= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdUsuarioPorFechaHoraAuditoria=true;

	public Boolean getActivarBusquedaPorIdUsuarioPorFechaHoraAuditoria() {
		return this.activarBusquedaPorIdUsuarioPorFechaHoraAuditoria;
	}

	public void setActivarBusquedaPorIdUsuarioPorFechaHoraAuditoria(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdUsuarioPorFechaHoraAuditoria= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIPPCPorFechaHoraAuditoria=true;

	public Boolean getActivarBusquedaPorIPPCPorFechaHoraAuditoria() {
		return this.activarBusquedaPorIPPCPorFechaHoraAuditoria;
	}

	public void setActivarBusquedaPorIPPCPorFechaHoraAuditoria(Boolean habilitarResaltar) {
		this.activarBusquedaPorIPPCPorFechaHoraAuditoria= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombrePCPorFechaHoraAuditoria=true;

	public Boolean getActivarBusquedaPorNombrePCPorFechaHoraAuditoria() {
		return this.activarBusquedaPorNombrePCPorFechaHoraAuditoria;
	}

	public void setActivarBusquedaPorNombrePCPorFechaHoraAuditoria(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombrePCPorFechaHoraAuditoria= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTablaPorFechaHoraAuditoria=true;

	public Boolean getActivarBusquedaPorNombreTablaPorFechaHoraAuditoria() {
		return this.activarBusquedaPorNombreTablaPorFechaHoraAuditoria;
	}

	public void setActivarBusquedaPorNombreTablaPorFechaHoraAuditoria(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTablaPorFechaHoraAuditoria= habilitarResaltar;
	}

	public Boolean activarBusquedaPorObservacionesPorFechaHoraAuditoria=true;

	public Boolean getActivarBusquedaPorObservacionesPorFechaHoraAuditoria() {
		return this.activarBusquedaPorObservacionesPorFechaHoraAuditoria;
	}

	public void setActivarBusquedaPorObservacionesPorFechaHoraAuditoria(Boolean habilitarResaltar) {
		this.activarBusquedaPorObservacionesPorFechaHoraAuditoria= habilitarResaltar;
	}

	public Boolean activarBusquedaPorProcesoPorFechaHoraAuditoria=true;

	public Boolean getActivarBusquedaPorProcesoPorFechaHoraAuditoria() {
		return this.activarBusquedaPorProcesoPorFechaHoraAuditoria;
	}

	public void setActivarBusquedaPorProcesoPorFechaHoraAuditoria(Boolean habilitarResaltar) {
		this.activarBusquedaPorProcesoPorFechaHoraAuditoria= habilitarResaltar;
	}

	public Boolean activarBusquedaPorUsuarioPCPorFechaHoraAuditoria=true;

	public Boolean getActivarBusquedaPorUsuarioPCPorFechaHoraAuditoria() {
		return this.activarBusquedaPorUsuarioPCPorFechaHoraAuditoria;
	}

	public void setActivarBusquedaPorUsuarioPCPorFechaHoraAuditoria(Boolean habilitarResaltar) {
		this.activarBusquedaPorUsuarioPCPorFechaHoraAuditoria= habilitarResaltar;
	}

	public Boolean activarFK_IdAuditoriaAuditoria=true;

	public Boolean getActivarFK_IdAuditoriaAuditoria() {
		return this.activarFK_IdAuditoriaAuditoria;
	}

	public void setActivarFK_IdAuditoriaAuditoria(Boolean habilitarResaltar) {
		this.activarFK_IdAuditoriaAuditoria= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioAuditoria=true;

	public Boolean getActivarFK_IdUsuarioAuditoria() {
		return this.activarFK_IdUsuarioAuditoria;
	}

	public void setActivarFK_IdUsuarioAuditoria(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioAuditoria= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdUsuarioPorFechaHoraAuditoria=null;

	public Border getResaltarBusquedaPorIdUsuarioPorFechaHoraAuditoria() {
		return this.resaltarBusquedaPorIdUsuarioPorFechaHoraAuditoria;
	}

	public void setResaltarBusquedaPorIdUsuarioPorFechaHoraAuditoria(Border borderResaltar) {
		this.resaltarBusquedaPorIdUsuarioPorFechaHoraAuditoria= borderResaltar;
	}

	public void setResaltarBusquedaPorIdUsuarioPorFechaHoraAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdUsuarioPorFechaHoraAuditoria= borderResaltar;
	}

	public Border resaltarBusquedaPorIPPCPorFechaHoraAuditoria=null;

	public Border getResaltarBusquedaPorIPPCPorFechaHoraAuditoria() {
		return this.resaltarBusquedaPorIPPCPorFechaHoraAuditoria;
	}

	public void setResaltarBusquedaPorIPPCPorFechaHoraAuditoria(Border borderResaltar) {
		this.resaltarBusquedaPorIPPCPorFechaHoraAuditoria= borderResaltar;
	}

	public void setResaltarBusquedaPorIPPCPorFechaHoraAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIPPCPorFechaHoraAuditoria= borderResaltar;
	}

	public Border resaltarBusquedaPorNombrePCPorFechaHoraAuditoria=null;

	public Border getResaltarBusquedaPorNombrePCPorFechaHoraAuditoria() {
		return this.resaltarBusquedaPorNombrePCPorFechaHoraAuditoria;
	}

	public void setResaltarBusquedaPorNombrePCPorFechaHoraAuditoria(Border borderResaltar) {
		this.resaltarBusquedaPorNombrePCPorFechaHoraAuditoria= borderResaltar;
	}

	public void setResaltarBusquedaPorNombrePCPorFechaHoraAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombrePCPorFechaHoraAuditoria= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTablaPorFechaHoraAuditoria=null;

	public Border getResaltarBusquedaPorNombreTablaPorFechaHoraAuditoria() {
		return this.resaltarBusquedaPorNombreTablaPorFechaHoraAuditoria;
	}

	public void setResaltarBusquedaPorNombreTablaPorFechaHoraAuditoria(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTablaPorFechaHoraAuditoria= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTablaPorFechaHoraAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTablaPorFechaHoraAuditoria= borderResaltar;
	}

	public Border resaltarBusquedaPorObservacionesPorFechaHoraAuditoria=null;

	public Border getResaltarBusquedaPorObservacionesPorFechaHoraAuditoria() {
		return this.resaltarBusquedaPorObservacionesPorFechaHoraAuditoria;
	}

	public void setResaltarBusquedaPorObservacionesPorFechaHoraAuditoria(Border borderResaltar) {
		this.resaltarBusquedaPorObservacionesPorFechaHoraAuditoria= borderResaltar;
	}

	public void setResaltarBusquedaPorObservacionesPorFechaHoraAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorObservacionesPorFechaHoraAuditoria= borderResaltar;
	}

	public Border resaltarBusquedaPorProcesoPorFechaHoraAuditoria=null;

	public Border getResaltarBusquedaPorProcesoPorFechaHoraAuditoria() {
		return this.resaltarBusquedaPorProcesoPorFechaHoraAuditoria;
	}

	public void setResaltarBusquedaPorProcesoPorFechaHoraAuditoria(Border borderResaltar) {
		this.resaltarBusquedaPorProcesoPorFechaHoraAuditoria= borderResaltar;
	}

	public void setResaltarBusquedaPorProcesoPorFechaHoraAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorProcesoPorFechaHoraAuditoria= borderResaltar;
	}

	public Border resaltarBusquedaPorUsuarioPCPorFechaHoraAuditoria=null;

	public Border getResaltarBusquedaPorUsuarioPCPorFechaHoraAuditoria() {
		return this.resaltarBusquedaPorUsuarioPCPorFechaHoraAuditoria;
	}

	public void setResaltarBusquedaPorUsuarioPCPorFechaHoraAuditoria(Border borderResaltar) {
		this.resaltarBusquedaPorUsuarioPCPorFechaHoraAuditoria= borderResaltar;
	}

	public void setResaltarBusquedaPorUsuarioPCPorFechaHoraAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorUsuarioPCPorFechaHoraAuditoria= borderResaltar;
	}

	public Border resaltarFK_IdAuditoriaAuditoria=null;

	public Border getResaltarFK_IdAuditoriaAuditoria() {
		return this.resaltarFK_IdAuditoriaAuditoria;
	}

	public void setResaltarFK_IdAuditoriaAuditoria(Border borderResaltar) {
		this.resaltarFK_IdAuditoriaAuditoria= borderResaltar;
	}

	public void setResaltarFK_IdAuditoriaAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAuditoriaAuditoria= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioAuditoria=null;

	public Border getResaltarFK_IdUsuarioAuditoria() {
		return this.resaltarFK_IdUsuarioAuditoria;
	}

	public void setResaltarFK_IdUsuarioAuditoria(Border borderResaltar) {
		this.resaltarFK_IdUsuarioAuditoria= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioAuditoria(ParametroGeneralUsuario parametroGeneralUsuario/*AuditoriaBeanSwingJInternalFrame auditoriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioAuditoria= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}