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


import com.bydan.erp.nomina.util.AsistenciaDiariaConstantesFunciones;
import com.bydan.erp.nomina.util.AsistenciaDiariaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.AsistenciaDiariaParameterGeneral;

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
final public class AsistenciaDiariaConstantesFunciones extends AsistenciaDiariaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AsistenciaDiaria";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AsistenciaDiaria"+AsistenciaDiariaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AsistenciaDiariaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AsistenciaDiariaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AsistenciaDiariaConstantesFunciones.SCHEMA+"_"+AsistenciaDiariaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AsistenciaDiariaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AsistenciaDiariaConstantesFunciones.SCHEMA+"_"+AsistenciaDiariaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AsistenciaDiariaConstantesFunciones.SCHEMA+"_"+AsistenciaDiariaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AsistenciaDiariaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AsistenciaDiariaConstantesFunciones.SCHEMA+"_"+AsistenciaDiariaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaDiariaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AsistenciaDiariaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaDiariaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaDiariaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AsistenciaDiariaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsistenciaDiariaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AsistenciaDiariaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AsistenciaDiariaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AsistenciaDiariaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AsistenciaDiariaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Asistencia Diarias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Asistencia Diaria";
	public static final String SCLASSWEBTITULO_LOWER="Asistencia Diaria";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AsistenciaDiaria";
	public static final String OBJECTNAME="asistenciadiaria";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="asistencia_diaria";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select asistenciadiaria from "+AsistenciaDiariaConstantesFunciones.SPERSISTENCENAME+" asistenciadiaria";
	public static String QUERYSELECTNATIVE="select "+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".id,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".version_row,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".id_empresa,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".id_empleado,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".id_estructura,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".id_estructura_seccion,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".fecha,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".hora,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_atraso,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_falta,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_permiso,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_extra25,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_extra50,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".horas_extra100,"+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME+".descripcion from "+AsistenciaDiariaConstantesFunciones.SCHEMA+"."+AsistenciaDiariaConstantesFunciones.TABLENAME;//+" as "+AsistenciaDiariaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AsistenciaDiariaConstantesFuncionesAdditional asistenciadiariaConstantesFuncionesAdditional=null;
	
	public AsistenciaDiariaConstantesFuncionesAdditional getAsistenciaDiariaConstantesFuncionesAdditional() {
		return this.asistenciadiariaConstantesFuncionesAdditional;
	}
	
	public void setAsistenciaDiariaConstantesFuncionesAdditional(AsistenciaDiariaConstantesFuncionesAdditional asistenciadiariaConstantesFuncionesAdditional) {
		try {
			this.asistenciadiariaConstantesFuncionesAdditional=asistenciadiariaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDESTRUCTURASECCION= "id_estructura_seccion";
    public static final String FECHA= "fecha";
    public static final String HORA= "hora";
    public static final String HORASATRASO= "horas_atraso";
    public static final String HORASFALTA= "horas_falta";
    public static final String HORASPERMISO= "horas_permiso";
    public static final String HORASEXTRA25= "horas_extra25";
    public static final String HORASEXTRA50= "horas_extra50";
    public static final String HORASEXTRA100= "horas_extra100";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDESTRUCTURASECCION= "Estructura Seccion";
		public static final String LABEL_IDESTRUCTURASECCION_LOWER= "Estructura Seccion";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_HORA= "Hora";
		public static final String LABEL_HORA_LOWER= "Hora";
    	public static final String LABEL_HORASATRASO= "Horas Atraso";
		public static final String LABEL_HORASATRASO_LOWER= "Horas Atraso";
    	public static final String LABEL_HORASFALTA= "Horas Falta";
		public static final String LABEL_HORASFALTA_LOWER= "Horas Falta";
    	public static final String LABEL_HORASPERMISO= "Horas Permiso";
		public static final String LABEL_HORASPERMISO_LOWER= "Horas Permiso";
    	public static final String LABEL_HORASEXTRA25= "Horas Extra25";
		public static final String LABEL_HORASEXTRA25_LOWER= "Horas Extra25";
    	public static final String LABEL_HORASEXTRA50= "Horas Extra50";
		public static final String LABEL_HORASEXTRA50_LOWER= "Horas Extra50";
    	public static final String LABEL_HORASEXTRA100= "Horas Extra100";
		public static final String LABEL_HORASEXTRA100_LOWER= "Horas Extra100";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getAsistenciaDiariaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.IDEMPRESA)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_IDESTRUCTURASECCION;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.FECHA)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.HORA)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_HORA;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.HORASATRASO)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_HORASATRASO;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.HORASFALTA)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_HORASFALTA;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.HORASPERMISO)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_HORASPERMISO;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA25)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA25;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA50)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA50;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA100)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA100;}
		if(sNombreColumna.equals(AsistenciaDiariaConstantesFunciones.DESCRIPCION)) {sLabelColumna=AsistenciaDiariaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAsistenciaDiariaDescripcion(AsistenciaDiaria asistenciadiaria) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(asistenciadiaria !=null/* && asistenciadiaria.getId()!=0*/) {
			if(asistenciadiaria.getId()!=null) {
				sDescripcion=asistenciadiaria.getId().toString();
			}//asistenciadiariaasistenciadiaria.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAsistenciaDiariaDescripcionDetallado(AsistenciaDiaria asistenciadiaria) {
		String sDescripcion="";
			
		sDescripcion+=AsistenciaDiariaConstantesFunciones.ID+"=";
		sDescripcion+=asistenciadiaria.getId().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=asistenciadiaria.getVersionRow().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=asistenciadiaria.getid_empresa().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=asistenciadiaria.getid_empleado().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=asistenciadiaria.getid_estructura().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION+"=";
		sDescripcion+=asistenciadiaria.getid_estructura_seccion().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.FECHA+"=";
		sDescripcion+=asistenciadiaria.getfecha().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.HORA+"=";
		sDescripcion+=asistenciadiaria.gethora().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.HORASATRASO+"=";
		sDescripcion+=asistenciadiaria.gethoras_atraso().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.HORASFALTA+"=";
		sDescripcion+=asistenciadiaria.gethoras_falta().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.HORASPERMISO+"=";
		sDescripcion+=asistenciadiaria.gethoras_permiso().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.HORASEXTRA25+"=";
		sDescripcion+=asistenciadiaria.gethoras_extra25().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.HORASEXTRA50+"=";
		sDescripcion+=asistenciadiaria.gethoras_extra50().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.HORASEXTRA100+"=";
		sDescripcion+=asistenciadiaria.gethoras_extra100().toString()+",";
		sDescripcion+=AsistenciaDiariaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=asistenciadiaria.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setAsistenciaDiariaDescripcion(AsistenciaDiaria asistenciadiaria,String sValor) throws Exception {			
		if(asistenciadiaria !=null) {
			//asistenciadiariaasistenciadiaria.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getEstructuraSeccionDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdEstructuraSeccion")) {
			sNombreIndice="Tipo=  Por Estructura Seccion";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructuraSeccion(Long id_estructura_seccion) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura_seccion!=null) {sDetalleIndice+=" Codigo Unico De Estructura Seccion="+id_estructura_seccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAsistenciaDiaria(AsistenciaDiaria asistenciadiaria,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		asistenciadiaria.setdescripcion(asistenciadiaria.getdescripcion().trim());
	}
	
	public static void quitarEspaciosAsistenciaDiarias(List<AsistenciaDiaria> asistenciadiarias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AsistenciaDiaria asistenciadiaria: asistenciadiarias) {
			asistenciadiaria.setdescripcion(asistenciadiaria.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAsistenciaDiaria(AsistenciaDiaria asistenciadiaria,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && asistenciadiaria.getConCambioAuxiliar()) {
			asistenciadiaria.setIsDeleted(asistenciadiaria.getIsDeletedAuxiliar());	
			asistenciadiaria.setIsNew(asistenciadiaria.getIsNewAuxiliar());	
			asistenciadiaria.setIsChanged(asistenciadiaria.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			asistenciadiaria.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			asistenciadiaria.setIsDeletedAuxiliar(false);	
			asistenciadiaria.setIsNewAuxiliar(false);	
			asistenciadiaria.setIsChangedAuxiliar(false);
			
			asistenciadiaria.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAsistenciaDiarias(List<AsistenciaDiaria> asistenciadiarias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AsistenciaDiaria asistenciadiaria : asistenciadiarias) {
			if(conAsignarBase && asistenciadiaria.getConCambioAuxiliar()) {
				asistenciadiaria.setIsDeleted(asistenciadiaria.getIsDeletedAuxiliar());	
				asistenciadiaria.setIsNew(asistenciadiaria.getIsNewAuxiliar());	
				asistenciadiaria.setIsChanged(asistenciadiaria.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				asistenciadiaria.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				asistenciadiaria.setIsDeletedAuxiliar(false);	
				asistenciadiaria.setIsNewAuxiliar(false);	
				asistenciadiaria.setIsChangedAuxiliar(false);
				
				asistenciadiaria.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAsistenciaDiaria(AsistenciaDiaria asistenciadiaria,Boolean conEnteros) throws Exception  {
		asistenciadiaria.sethoras_atraso(0.0);
		asistenciadiaria.sethoras_falta(0.0);
		asistenciadiaria.sethoras_permiso(0.0);
		asistenciadiaria.sethoras_extra25(0.0);
		asistenciadiaria.sethoras_extra50(0.0);
		asistenciadiaria.sethoras_extra100(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAsistenciaDiarias(List<AsistenciaDiaria> asistenciadiarias,Boolean conEnteros) throws Exception  {
		
		for(AsistenciaDiaria asistenciadiaria: asistenciadiarias) {
			asistenciadiaria.sethoras_atraso(0.0);
			asistenciadiaria.sethoras_falta(0.0);
			asistenciadiaria.sethoras_permiso(0.0);
			asistenciadiaria.sethoras_extra25(0.0);
			asistenciadiaria.sethoras_extra50(0.0);
			asistenciadiaria.sethoras_extra100(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAsistenciaDiaria(List<AsistenciaDiaria> asistenciadiarias,AsistenciaDiaria asistenciadiariaAux) throws Exception  {
		AsistenciaDiariaConstantesFunciones.InicializarValoresAsistenciaDiaria(asistenciadiariaAux,true);
		
		for(AsistenciaDiaria asistenciadiaria: asistenciadiarias) {
			if(asistenciadiaria.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			asistenciadiariaAux.sethoras_atraso(asistenciadiariaAux.gethoras_atraso()+asistenciadiaria.gethoras_atraso());			
			asistenciadiariaAux.sethoras_falta(asistenciadiariaAux.gethoras_falta()+asistenciadiaria.gethoras_falta());			
			asistenciadiariaAux.sethoras_permiso(asistenciadiariaAux.gethoras_permiso()+asistenciadiaria.gethoras_permiso());			
			asistenciadiariaAux.sethoras_extra25(asistenciadiariaAux.gethoras_extra25()+asistenciadiaria.gethoras_extra25());			
			asistenciadiariaAux.sethoras_extra50(asistenciadiariaAux.gethoras_extra50()+asistenciadiaria.gethoras_extra50());			
			asistenciadiariaAux.sethoras_extra100(asistenciadiariaAux.gethoras_extra100()+asistenciadiaria.gethoras_extra100());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAsistenciaDiaria(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AsistenciaDiariaConstantesFunciones.getArrayColumnasGlobalesAsistenciaDiaria(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAsistenciaDiaria(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsistenciaDiariaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsistenciaDiariaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAsistenciaDiaria(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AsistenciaDiaria> asistenciadiarias,AsistenciaDiaria asistenciadiaria,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AsistenciaDiaria asistenciadiariaAux: asistenciadiarias) {
			if(asistenciadiariaAux!=null && asistenciadiaria!=null) {
				if((asistenciadiariaAux.getId()==null && asistenciadiaria.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(asistenciadiariaAux.getId()!=null && asistenciadiaria.getId()!=null){
					if(asistenciadiariaAux.getId().equals(asistenciadiaria.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAsistenciaDiaria(List<AsistenciaDiaria> asistenciadiarias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double horas_atrasoTotal=0.0;
		Double horas_faltaTotal=0.0;
		Double horas_permisoTotal=0.0;
		Double horas_extra25Total=0.0;
		Double horas_extra50Total=0.0;
		Double horas_extra100Total=0.0;
	
		for(AsistenciaDiaria asistenciadiaria: asistenciadiarias) {			
			if(asistenciadiaria.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			horas_atrasoTotal+=asistenciadiaria.gethoras_atraso();
			horas_faltaTotal+=asistenciadiaria.gethoras_falta();
			horas_permisoTotal+=asistenciadiaria.gethoras_permiso();
			horas_extra25Total+=asistenciadiaria.gethoras_extra25();
			horas_extra50Total+=asistenciadiaria.gethoras_extra50();
			horas_extra100Total+=asistenciadiaria.gethoras_extra100();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASATRASO);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASATRASO);
		datoGeneral.setdValorDouble(horas_atrasoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASFALTA);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASFALTA);
		datoGeneral.setdValorDouble(horas_faltaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASPERMISO);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASPERMISO);
		datoGeneral.setdValorDouble(horas_permisoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASEXTRA25);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA25);
		datoGeneral.setdValorDouble(horas_extra25Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASEXTRA50);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA50);
		datoGeneral.setdValorDouble(horas_extra50Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsistenciaDiariaConstantesFunciones.HORASEXTRA100);
		datoGeneral.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA100);
		datoGeneral.setdValorDouble(horas_extra100Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAsistenciaDiaria() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_ID, AsistenciaDiariaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_VERSIONROW, AsistenciaDiariaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_IDEMPRESA, AsistenciaDiariaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_IDEMPLEADO, AsistenciaDiariaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_IDESTRUCTURA, AsistenciaDiariaConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_IDESTRUCTURASECCION, AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_FECHA, AsistenciaDiariaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_HORA, AsistenciaDiariaConstantesFunciones.HORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_HORASATRASO, AsistenciaDiariaConstantesFunciones.HORASATRASO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_HORASFALTA, AsistenciaDiariaConstantesFunciones.HORASFALTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_HORASPERMISO, AsistenciaDiariaConstantesFunciones.HORASPERMISO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA25, AsistenciaDiariaConstantesFunciones.HORASEXTRA25,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA50, AsistenciaDiariaConstantesFunciones.HORASEXTRA50,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA100, AsistenciaDiariaConstantesFunciones.HORASEXTRA100,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsistenciaDiariaConstantesFunciones.LABEL_DESCRIPCION, AsistenciaDiariaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAsistenciaDiaria() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.HORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.HORASATRASO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.HORASFALTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.HORASPERMISO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.HORASEXTRA25;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.HORASEXTRA50;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.HORASEXTRA100;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsistenciaDiariaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsistenciaDiaria() throws Exception  {
		return AsistenciaDiariaConstantesFunciones.getTiposSeleccionarAsistenciaDiaria(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsistenciaDiaria(Boolean conFk) throws Exception  {
		return AsistenciaDiariaConstantesFunciones.getTiposSeleccionarAsistenciaDiaria(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsistenciaDiaria(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_IDESTRUCTURASECCION);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_IDESTRUCTURASECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_HORA);
		reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORA);

		arrTiposSeleccionarTodos.add(reporte);
		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_HORASATRASO);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASATRASO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_HORASFALTA);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASFALTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_HORASPERMISO);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASPERMISO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA25);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA25);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA50);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA50);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA100);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA100);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsistenciaDiariaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(AsistenciaDiariaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAsistenciaDiaria(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAsistenciaDiaria(AsistenciaDiaria asistenciadiariaAux) throws Exception {
		
			asistenciadiariaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(asistenciadiariaAux.getEmpresa()));
			asistenciadiariaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(asistenciadiariaAux.getEmpleado()));
			asistenciadiariaAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(asistenciadiariaAux.getEstructura()));
			asistenciadiariaAux.setestructuraseccion_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(asistenciadiariaAux.getEstructuraSeccion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAsistenciaDiaria(List<AsistenciaDiaria> asistenciadiariasTemp) throws Exception {
		for(AsistenciaDiaria asistenciadiariaAux:asistenciadiariasTemp) {
			
			asistenciadiariaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(asistenciadiariaAux.getEmpresa()));
			asistenciadiariaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(asistenciadiariaAux.getEmpleado()));
			asistenciadiariaAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(asistenciadiariaAux.getEstructura()));
			asistenciadiariaAux.setestructuraseccion_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(asistenciadiariaAux.getEstructuraSeccion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAsistenciaDiaria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Estructura.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAsistenciaDiaria(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsistenciaDiaria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AsistenciaDiariaConstantesFunciones.getClassesRelationshipsOfAsistenciaDiaria(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsistenciaDiaria(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAsistenciaDiaria(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AsistenciaDiariaConstantesFunciones.getClassesRelationshipsFromStringsOfAsistenciaDiaria(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAsistenciaDiaria(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AsistenciaDiaria asistenciadiaria,List<AsistenciaDiaria> asistenciadiarias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AsistenciaDiaria asistenciadiariaEncontrado=null;
			
			for(AsistenciaDiaria asistenciadiariaLocal:asistenciadiarias) {
				if(asistenciadiariaLocal.getId().equals(asistenciadiaria.getId())) {
					asistenciadiariaEncontrado=asistenciadiariaLocal;
					
					asistenciadiariaLocal.setIsChanged(asistenciadiaria.getIsChanged());
					asistenciadiariaLocal.setIsNew(asistenciadiaria.getIsNew());
					asistenciadiariaLocal.setIsDeleted(asistenciadiaria.getIsDeleted());
					
					asistenciadiariaLocal.setGeneralEntityOriginal(asistenciadiaria.getGeneralEntityOriginal());
					
					asistenciadiariaLocal.setId(asistenciadiaria.getId());	
					asistenciadiariaLocal.setVersionRow(asistenciadiaria.getVersionRow());	
					asistenciadiariaLocal.setid_empresa(asistenciadiaria.getid_empresa());	
					asistenciadiariaLocal.setid_empleado(asistenciadiaria.getid_empleado());	
					asistenciadiariaLocal.setid_estructura(asistenciadiaria.getid_estructura());	
					asistenciadiariaLocal.setid_estructura_seccion(asistenciadiaria.getid_estructura_seccion());	
					asistenciadiariaLocal.setfecha(asistenciadiaria.getfecha());	
					asistenciadiariaLocal.sethora(asistenciadiaria.gethora());	
					asistenciadiariaLocal.sethoras_atraso(asistenciadiaria.gethoras_atraso());	
					asistenciadiariaLocal.sethoras_falta(asistenciadiaria.gethoras_falta());	
					asistenciadiariaLocal.sethoras_permiso(asistenciadiaria.gethoras_permiso());	
					asistenciadiariaLocal.sethoras_extra25(asistenciadiaria.gethoras_extra25());	
					asistenciadiariaLocal.sethoras_extra50(asistenciadiaria.gethoras_extra50());	
					asistenciadiariaLocal.sethoras_extra100(asistenciadiaria.gethoras_extra100());	
					asistenciadiariaLocal.setdescripcion(asistenciadiaria.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!asistenciadiaria.getIsDeleted()) {
				if(!existe) {
					asistenciadiarias.add(asistenciadiaria);
				}
			} else {
				if(asistenciadiariaEncontrado!=null && permiteQuitar)  {
					asistenciadiarias.remove(asistenciadiariaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AsistenciaDiaria asistenciadiaria,List<AsistenciaDiaria> asistenciadiarias) throws Exception {
		try	{			
			for(AsistenciaDiaria asistenciadiariaLocal:asistenciadiarias) {
				if(asistenciadiariaLocal.getId().equals(asistenciadiaria.getId())) {
					asistenciadiariaLocal.setIsSelected(asistenciadiaria.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAsistenciaDiaria(List<AsistenciaDiaria> asistenciadiariasAux) throws Exception {
		//this.asistenciadiariasAux=asistenciadiariasAux;
		
		for(AsistenciaDiaria asistenciadiariaAux:asistenciadiariasAux) {
			if(asistenciadiariaAux.getIsChanged()) {
				asistenciadiariaAux.setIsChanged(false);
			}		
			
			if(asistenciadiariaAux.getIsNew()) {
				asistenciadiariaAux.setIsNew(false);
			}	
			
			if(asistenciadiariaAux.getIsDeleted()) {
				asistenciadiariaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAsistenciaDiaria(AsistenciaDiaria asistenciadiariaAux) throws Exception {
		//this.asistenciadiariaAux=asistenciadiariaAux;
		
			if(asistenciadiariaAux.getIsChanged()) {
				asistenciadiariaAux.setIsChanged(false);
			}		
			
			if(asistenciadiariaAux.getIsNew()) {
				asistenciadiariaAux.setIsNew(false);
			}	
			
			if(asistenciadiariaAux.getIsDeleted()) {
				asistenciadiariaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AsistenciaDiaria asistenciadiariaAsignar,AsistenciaDiaria asistenciadiaria) throws Exception {
		asistenciadiariaAsignar.setId(asistenciadiaria.getId());	
		asistenciadiariaAsignar.setVersionRow(asistenciadiaria.getVersionRow());	
		asistenciadiariaAsignar.setid_empresa(asistenciadiaria.getid_empresa());
		asistenciadiariaAsignar.setempresa_descripcion(asistenciadiaria.getempresa_descripcion());	
		asistenciadiariaAsignar.setid_empleado(asistenciadiaria.getid_empleado());
		asistenciadiariaAsignar.setempleado_descripcion(asistenciadiaria.getempleado_descripcion());	
		asistenciadiariaAsignar.setid_estructura(asistenciadiaria.getid_estructura());
		asistenciadiariaAsignar.setestructura_descripcion(asistenciadiaria.getestructura_descripcion());	
		asistenciadiariaAsignar.setid_estructura_seccion(asistenciadiaria.getid_estructura_seccion());
		asistenciadiariaAsignar.setestructuraseccion_descripcion(asistenciadiaria.getestructuraseccion_descripcion());	
		asistenciadiariaAsignar.setfecha(asistenciadiaria.getfecha());	
		asistenciadiariaAsignar.sethora(asistenciadiaria.gethora());	
		asistenciadiariaAsignar.sethoras_atraso(asistenciadiaria.gethoras_atraso());	
		asistenciadiariaAsignar.sethoras_falta(asistenciadiaria.gethoras_falta());	
		asistenciadiariaAsignar.sethoras_permiso(asistenciadiaria.gethoras_permiso());	
		asistenciadiariaAsignar.sethoras_extra25(asistenciadiaria.gethoras_extra25());	
		asistenciadiariaAsignar.sethoras_extra50(asistenciadiaria.gethoras_extra50());	
		asistenciadiariaAsignar.sethoras_extra100(asistenciadiaria.gethoras_extra100());	
		asistenciadiariaAsignar.setdescripcion(asistenciadiaria.getdescripcion());	
	}
	
	public static void inicializarAsistenciaDiaria(AsistenciaDiaria asistenciadiaria) throws Exception {
		try {
				asistenciadiaria.setId(0L);	
					
				asistenciadiaria.setid_empresa(-1L);	
				asistenciadiaria.setid_empleado(-1L);	
				asistenciadiaria.setid_estructura(-1L);	
				asistenciadiaria.setid_estructura_seccion(-1L);	
				asistenciadiaria.setfecha(new Date());	
				asistenciadiaria.sethora(new Time((new Date()).getTime()));	
				asistenciadiaria.sethoras_atraso(0.0);	
				asistenciadiaria.sethoras_falta(0.0);	
				asistenciadiaria.sethoras_permiso(0.0);	
				asistenciadiaria.sethoras_extra25(0.0);	
				asistenciadiaria.sethoras_extra50(0.0);	
				asistenciadiaria.sethoras_extra100(0.0);	
				asistenciadiaria.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAsistenciaDiaria(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_IDESTRUCTURASECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_HORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_HORASATRASO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_HORASFALTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_HORASPERMISO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA25);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA50);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_HORASEXTRA100);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsistenciaDiariaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAsistenciaDiaria(String sTipo,Row row,Workbook workbook,AsistenciaDiaria asistenciadiaria,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.getestructuraseccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.gethora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.gethoras_atraso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.gethoras_falta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.gethoras_permiso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.gethoras_extra25());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.gethoras_extra50());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.gethoras_extra100());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asistenciadiaria.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAsistenciaDiaria=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAsistenciaDiaria() {
		return this.sFinalQueryAsistenciaDiaria;
	}
	
	public void setsFinalQueryAsistenciaDiaria(String sFinalQueryAsistenciaDiaria) {
		this.sFinalQueryAsistenciaDiaria= sFinalQueryAsistenciaDiaria;
	}
	
	public Border resaltarSeleccionarAsistenciaDiaria=null;
	
	public Border setResaltarSeleccionarAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAsistenciaDiaria= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAsistenciaDiaria() {
		return this.resaltarSeleccionarAsistenciaDiaria;
	}
	
	public void setResaltarSeleccionarAsistenciaDiaria(Border borderResaltarSeleccionarAsistenciaDiaria) {
		this.resaltarSeleccionarAsistenciaDiaria= borderResaltarSeleccionarAsistenciaDiaria;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAsistenciaDiaria=null;
	public Boolean mostraridAsistenciaDiaria=true;
	public Boolean activaridAsistenciaDiaria=true;

	public Border resaltarid_empresaAsistenciaDiaria=null;
	public Boolean mostrarid_empresaAsistenciaDiaria=true;
	public Boolean activarid_empresaAsistenciaDiaria=true;
	public Boolean cargarid_empresaAsistenciaDiaria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAsistenciaDiaria=false;//ConEventDepend=true

	public Border resaltarid_empleadoAsistenciaDiaria=null;
	public Boolean mostrarid_empleadoAsistenciaDiaria=true;
	public Boolean activarid_empleadoAsistenciaDiaria=true;
	public Boolean cargarid_empleadoAsistenciaDiaria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoAsistenciaDiaria=false;//ConEventDepend=true

	public Border resaltarid_estructuraAsistenciaDiaria=null;
	public Boolean mostrarid_estructuraAsistenciaDiaria=true;
	public Boolean activarid_estructuraAsistenciaDiaria=true;
	public Boolean cargarid_estructuraAsistenciaDiaria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraAsistenciaDiaria=false;//ConEventDepend=true

	public Border resaltarid_estructura_seccionAsistenciaDiaria=null;
	public Boolean mostrarid_estructura_seccionAsistenciaDiaria=true;
	public Boolean activarid_estructura_seccionAsistenciaDiaria=true;
	public Boolean cargarid_estructura_seccionAsistenciaDiaria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructura_seccionAsistenciaDiaria=false;//ConEventDepend=true

	public Border resaltarfechaAsistenciaDiaria=null;
	public Boolean mostrarfechaAsistenciaDiaria=true;
	public Boolean activarfechaAsistenciaDiaria=false;

	public Border resaltarhoraAsistenciaDiaria=null;
	public Boolean mostrarhoraAsistenciaDiaria=true;
	public Boolean activarhoraAsistenciaDiaria=true;

	public Border resaltarhoras_atrasoAsistenciaDiaria=null;
	public Boolean mostrarhoras_atrasoAsistenciaDiaria=true;
	public Boolean activarhoras_atrasoAsistenciaDiaria=true;

	public Border resaltarhoras_faltaAsistenciaDiaria=null;
	public Boolean mostrarhoras_faltaAsistenciaDiaria=true;
	public Boolean activarhoras_faltaAsistenciaDiaria=true;

	public Border resaltarhoras_permisoAsistenciaDiaria=null;
	public Boolean mostrarhoras_permisoAsistenciaDiaria=true;
	public Boolean activarhoras_permisoAsistenciaDiaria=true;

	public Border resaltarhoras_extra25AsistenciaDiaria=null;
	public Boolean mostrarhoras_extra25AsistenciaDiaria=true;
	public Boolean activarhoras_extra25AsistenciaDiaria=true;

	public Border resaltarhoras_extra50AsistenciaDiaria=null;
	public Boolean mostrarhoras_extra50AsistenciaDiaria=true;
	public Boolean activarhoras_extra50AsistenciaDiaria=true;

	public Border resaltarhoras_extra100AsistenciaDiaria=null;
	public Boolean mostrarhoras_extra100AsistenciaDiaria=true;
	public Boolean activarhoras_extra100AsistenciaDiaria=true;

	public Border resaltardescripcionAsistenciaDiaria=null;
	public Boolean mostrardescripcionAsistenciaDiaria=true;
	public Boolean activardescripcionAsistenciaDiaria=true;

	
	

	public Border setResaltaridAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltaridAsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAsistenciaDiaria() {
		return this.resaltaridAsistenciaDiaria;
	}

	public void setResaltaridAsistenciaDiaria(Border borderResaltar) {
		this.resaltaridAsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostraridAsistenciaDiaria() {
		return this.mostraridAsistenciaDiaria;
	}

	public void setMostraridAsistenciaDiaria(Boolean mostraridAsistenciaDiaria) {
		this.mostraridAsistenciaDiaria= mostraridAsistenciaDiaria;
	}

	public Boolean getActivaridAsistenciaDiaria() {
		return this.activaridAsistenciaDiaria;
	}

	public void setActivaridAsistenciaDiaria(Boolean activaridAsistenciaDiaria) {
		this.activaridAsistenciaDiaria= activaridAsistenciaDiaria;
	}

	public Border setResaltarid_empresaAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarid_empresaAsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAsistenciaDiaria() {
		return this.resaltarid_empresaAsistenciaDiaria;
	}

	public void setResaltarid_empresaAsistenciaDiaria(Border borderResaltar) {
		this.resaltarid_empresaAsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarid_empresaAsistenciaDiaria() {
		return this.mostrarid_empresaAsistenciaDiaria;
	}

	public void setMostrarid_empresaAsistenciaDiaria(Boolean mostrarid_empresaAsistenciaDiaria) {
		this.mostrarid_empresaAsistenciaDiaria= mostrarid_empresaAsistenciaDiaria;
	}

	public Boolean getActivarid_empresaAsistenciaDiaria() {
		return this.activarid_empresaAsistenciaDiaria;
	}

	public void setActivarid_empresaAsistenciaDiaria(Boolean activarid_empresaAsistenciaDiaria) {
		this.activarid_empresaAsistenciaDiaria= activarid_empresaAsistenciaDiaria;
	}

	public Boolean getCargarid_empresaAsistenciaDiaria() {
		return this.cargarid_empresaAsistenciaDiaria;
	}

	public void setCargarid_empresaAsistenciaDiaria(Boolean cargarid_empresaAsistenciaDiaria) {
		this.cargarid_empresaAsistenciaDiaria= cargarid_empresaAsistenciaDiaria;
	}

	public Border setResaltarid_empleadoAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarid_empleadoAsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoAsistenciaDiaria() {
		return this.resaltarid_empleadoAsistenciaDiaria;
	}

	public void setResaltarid_empleadoAsistenciaDiaria(Border borderResaltar) {
		this.resaltarid_empleadoAsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarid_empleadoAsistenciaDiaria() {
		return this.mostrarid_empleadoAsistenciaDiaria;
	}

	public void setMostrarid_empleadoAsistenciaDiaria(Boolean mostrarid_empleadoAsistenciaDiaria) {
		this.mostrarid_empleadoAsistenciaDiaria= mostrarid_empleadoAsistenciaDiaria;
	}

	public Boolean getActivarid_empleadoAsistenciaDiaria() {
		return this.activarid_empleadoAsistenciaDiaria;
	}

	public void setActivarid_empleadoAsistenciaDiaria(Boolean activarid_empleadoAsistenciaDiaria) {
		this.activarid_empleadoAsistenciaDiaria= activarid_empleadoAsistenciaDiaria;
	}

	public Boolean getCargarid_empleadoAsistenciaDiaria() {
		return this.cargarid_empleadoAsistenciaDiaria;
	}

	public void setCargarid_empleadoAsistenciaDiaria(Boolean cargarid_empleadoAsistenciaDiaria) {
		this.cargarid_empleadoAsistenciaDiaria= cargarid_empleadoAsistenciaDiaria;
	}

	public Border setResaltarid_estructuraAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarid_estructuraAsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraAsistenciaDiaria() {
		return this.resaltarid_estructuraAsistenciaDiaria;
	}

	public void setResaltarid_estructuraAsistenciaDiaria(Border borderResaltar) {
		this.resaltarid_estructuraAsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarid_estructuraAsistenciaDiaria() {
		return this.mostrarid_estructuraAsistenciaDiaria;
	}

	public void setMostrarid_estructuraAsistenciaDiaria(Boolean mostrarid_estructuraAsistenciaDiaria) {
		this.mostrarid_estructuraAsistenciaDiaria= mostrarid_estructuraAsistenciaDiaria;
	}

	public Boolean getActivarid_estructuraAsistenciaDiaria() {
		return this.activarid_estructuraAsistenciaDiaria;
	}

	public void setActivarid_estructuraAsistenciaDiaria(Boolean activarid_estructuraAsistenciaDiaria) {
		this.activarid_estructuraAsistenciaDiaria= activarid_estructuraAsistenciaDiaria;
	}

	public Boolean getCargarid_estructuraAsistenciaDiaria() {
		return this.cargarid_estructuraAsistenciaDiaria;
	}

	public void setCargarid_estructuraAsistenciaDiaria(Boolean cargarid_estructuraAsistenciaDiaria) {
		this.cargarid_estructuraAsistenciaDiaria= cargarid_estructuraAsistenciaDiaria;
	}

	public Border setResaltarid_estructura_seccionAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarid_estructura_seccionAsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructura_seccionAsistenciaDiaria() {
		return this.resaltarid_estructura_seccionAsistenciaDiaria;
	}

	public void setResaltarid_estructura_seccionAsistenciaDiaria(Border borderResaltar) {
		this.resaltarid_estructura_seccionAsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarid_estructura_seccionAsistenciaDiaria() {
		return this.mostrarid_estructura_seccionAsistenciaDiaria;
	}

	public void setMostrarid_estructura_seccionAsistenciaDiaria(Boolean mostrarid_estructura_seccionAsistenciaDiaria) {
		this.mostrarid_estructura_seccionAsistenciaDiaria= mostrarid_estructura_seccionAsistenciaDiaria;
	}

	public Boolean getActivarid_estructura_seccionAsistenciaDiaria() {
		return this.activarid_estructura_seccionAsistenciaDiaria;
	}

	public void setActivarid_estructura_seccionAsistenciaDiaria(Boolean activarid_estructura_seccionAsistenciaDiaria) {
		this.activarid_estructura_seccionAsistenciaDiaria= activarid_estructura_seccionAsistenciaDiaria;
	}

	public Boolean getCargarid_estructura_seccionAsistenciaDiaria() {
		return this.cargarid_estructura_seccionAsistenciaDiaria;
	}

	public void setCargarid_estructura_seccionAsistenciaDiaria(Boolean cargarid_estructura_seccionAsistenciaDiaria) {
		this.cargarid_estructura_seccionAsistenciaDiaria= cargarid_estructura_seccionAsistenciaDiaria;
	}

	public Border setResaltarfechaAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarfechaAsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaAsistenciaDiaria() {
		return this.resaltarfechaAsistenciaDiaria;
	}

	public void setResaltarfechaAsistenciaDiaria(Border borderResaltar) {
		this.resaltarfechaAsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarfechaAsistenciaDiaria() {
		return this.mostrarfechaAsistenciaDiaria;
	}

	public void setMostrarfechaAsistenciaDiaria(Boolean mostrarfechaAsistenciaDiaria) {
		this.mostrarfechaAsistenciaDiaria= mostrarfechaAsistenciaDiaria;
	}

	public Boolean getActivarfechaAsistenciaDiaria() {
		return this.activarfechaAsistenciaDiaria;
	}

	public void setActivarfechaAsistenciaDiaria(Boolean activarfechaAsistenciaDiaria) {
		this.activarfechaAsistenciaDiaria= activarfechaAsistenciaDiaria;
	}

	public Border setResaltarhoraAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarhoraAsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoraAsistenciaDiaria() {
		return this.resaltarhoraAsistenciaDiaria;
	}

	public void setResaltarhoraAsistenciaDiaria(Border borderResaltar) {
		this.resaltarhoraAsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarhoraAsistenciaDiaria() {
		return this.mostrarhoraAsistenciaDiaria;
	}

	public void setMostrarhoraAsistenciaDiaria(Boolean mostrarhoraAsistenciaDiaria) {
		this.mostrarhoraAsistenciaDiaria= mostrarhoraAsistenciaDiaria;
	}

	public Boolean getActivarhoraAsistenciaDiaria() {
		return this.activarhoraAsistenciaDiaria;
	}

	public void setActivarhoraAsistenciaDiaria(Boolean activarhoraAsistenciaDiaria) {
		this.activarhoraAsistenciaDiaria= activarhoraAsistenciaDiaria;
	}

	public Border setResaltarhoras_atrasoAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarhoras_atrasoAsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_atrasoAsistenciaDiaria() {
		return this.resaltarhoras_atrasoAsistenciaDiaria;
	}

	public void setResaltarhoras_atrasoAsistenciaDiaria(Border borderResaltar) {
		this.resaltarhoras_atrasoAsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarhoras_atrasoAsistenciaDiaria() {
		return this.mostrarhoras_atrasoAsistenciaDiaria;
	}

	public void setMostrarhoras_atrasoAsistenciaDiaria(Boolean mostrarhoras_atrasoAsistenciaDiaria) {
		this.mostrarhoras_atrasoAsistenciaDiaria= mostrarhoras_atrasoAsistenciaDiaria;
	}

	public Boolean getActivarhoras_atrasoAsistenciaDiaria() {
		return this.activarhoras_atrasoAsistenciaDiaria;
	}

	public void setActivarhoras_atrasoAsistenciaDiaria(Boolean activarhoras_atrasoAsistenciaDiaria) {
		this.activarhoras_atrasoAsistenciaDiaria= activarhoras_atrasoAsistenciaDiaria;
	}

	public Border setResaltarhoras_faltaAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarhoras_faltaAsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_faltaAsistenciaDiaria() {
		return this.resaltarhoras_faltaAsistenciaDiaria;
	}

	public void setResaltarhoras_faltaAsistenciaDiaria(Border borderResaltar) {
		this.resaltarhoras_faltaAsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarhoras_faltaAsistenciaDiaria() {
		return this.mostrarhoras_faltaAsistenciaDiaria;
	}

	public void setMostrarhoras_faltaAsistenciaDiaria(Boolean mostrarhoras_faltaAsistenciaDiaria) {
		this.mostrarhoras_faltaAsistenciaDiaria= mostrarhoras_faltaAsistenciaDiaria;
	}

	public Boolean getActivarhoras_faltaAsistenciaDiaria() {
		return this.activarhoras_faltaAsistenciaDiaria;
	}

	public void setActivarhoras_faltaAsistenciaDiaria(Boolean activarhoras_faltaAsistenciaDiaria) {
		this.activarhoras_faltaAsistenciaDiaria= activarhoras_faltaAsistenciaDiaria;
	}

	public Border setResaltarhoras_permisoAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarhoras_permisoAsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_permisoAsistenciaDiaria() {
		return this.resaltarhoras_permisoAsistenciaDiaria;
	}

	public void setResaltarhoras_permisoAsistenciaDiaria(Border borderResaltar) {
		this.resaltarhoras_permisoAsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarhoras_permisoAsistenciaDiaria() {
		return this.mostrarhoras_permisoAsistenciaDiaria;
	}

	public void setMostrarhoras_permisoAsistenciaDiaria(Boolean mostrarhoras_permisoAsistenciaDiaria) {
		this.mostrarhoras_permisoAsistenciaDiaria= mostrarhoras_permisoAsistenciaDiaria;
	}

	public Boolean getActivarhoras_permisoAsistenciaDiaria() {
		return this.activarhoras_permisoAsistenciaDiaria;
	}

	public void setActivarhoras_permisoAsistenciaDiaria(Boolean activarhoras_permisoAsistenciaDiaria) {
		this.activarhoras_permisoAsistenciaDiaria= activarhoras_permisoAsistenciaDiaria;
	}

	public Border setResaltarhoras_extra25AsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarhoras_extra25AsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_extra25AsistenciaDiaria() {
		return this.resaltarhoras_extra25AsistenciaDiaria;
	}

	public void setResaltarhoras_extra25AsistenciaDiaria(Border borderResaltar) {
		this.resaltarhoras_extra25AsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarhoras_extra25AsistenciaDiaria() {
		return this.mostrarhoras_extra25AsistenciaDiaria;
	}

	public void setMostrarhoras_extra25AsistenciaDiaria(Boolean mostrarhoras_extra25AsistenciaDiaria) {
		this.mostrarhoras_extra25AsistenciaDiaria= mostrarhoras_extra25AsistenciaDiaria;
	}

	public Boolean getActivarhoras_extra25AsistenciaDiaria() {
		return this.activarhoras_extra25AsistenciaDiaria;
	}

	public void setActivarhoras_extra25AsistenciaDiaria(Boolean activarhoras_extra25AsistenciaDiaria) {
		this.activarhoras_extra25AsistenciaDiaria= activarhoras_extra25AsistenciaDiaria;
	}

	public Border setResaltarhoras_extra50AsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarhoras_extra50AsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_extra50AsistenciaDiaria() {
		return this.resaltarhoras_extra50AsistenciaDiaria;
	}

	public void setResaltarhoras_extra50AsistenciaDiaria(Border borderResaltar) {
		this.resaltarhoras_extra50AsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarhoras_extra50AsistenciaDiaria() {
		return this.mostrarhoras_extra50AsistenciaDiaria;
	}

	public void setMostrarhoras_extra50AsistenciaDiaria(Boolean mostrarhoras_extra50AsistenciaDiaria) {
		this.mostrarhoras_extra50AsistenciaDiaria= mostrarhoras_extra50AsistenciaDiaria;
	}

	public Boolean getActivarhoras_extra50AsistenciaDiaria() {
		return this.activarhoras_extra50AsistenciaDiaria;
	}

	public void setActivarhoras_extra50AsistenciaDiaria(Boolean activarhoras_extra50AsistenciaDiaria) {
		this.activarhoras_extra50AsistenciaDiaria= activarhoras_extra50AsistenciaDiaria;
	}

	public Border setResaltarhoras_extra100AsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltarhoras_extra100AsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoras_extra100AsistenciaDiaria() {
		return this.resaltarhoras_extra100AsistenciaDiaria;
	}

	public void setResaltarhoras_extra100AsistenciaDiaria(Border borderResaltar) {
		this.resaltarhoras_extra100AsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrarhoras_extra100AsistenciaDiaria() {
		return this.mostrarhoras_extra100AsistenciaDiaria;
	}

	public void setMostrarhoras_extra100AsistenciaDiaria(Boolean mostrarhoras_extra100AsistenciaDiaria) {
		this.mostrarhoras_extra100AsistenciaDiaria= mostrarhoras_extra100AsistenciaDiaria;
	}

	public Boolean getActivarhoras_extra100AsistenciaDiaria() {
		return this.activarhoras_extra100AsistenciaDiaria;
	}

	public void setActivarhoras_extra100AsistenciaDiaria(Boolean activarhoras_extra100AsistenciaDiaria) {
		this.activarhoras_extra100AsistenciaDiaria= activarhoras_extra100AsistenciaDiaria;
	}

	public Border setResaltardescripcionAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asistenciadiariaBeanSwingJInternalFrame.jTtoolBarAsistenciaDiaria.setBorder(borderResaltar);
		
		this.resaltardescripcionAsistenciaDiaria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionAsistenciaDiaria() {
		return this.resaltardescripcionAsistenciaDiaria;
	}

	public void setResaltardescripcionAsistenciaDiaria(Border borderResaltar) {
		this.resaltardescripcionAsistenciaDiaria= borderResaltar;
	}

	public Boolean getMostrardescripcionAsistenciaDiaria() {
		return this.mostrardescripcionAsistenciaDiaria;
	}

	public void setMostrardescripcionAsistenciaDiaria(Boolean mostrardescripcionAsistenciaDiaria) {
		this.mostrardescripcionAsistenciaDiaria= mostrardescripcionAsistenciaDiaria;
	}

	public Boolean getActivardescripcionAsistenciaDiaria() {
		return this.activardescripcionAsistenciaDiaria;
	}

	public void setActivardescripcionAsistenciaDiaria(Boolean activardescripcionAsistenciaDiaria) {
		this.activardescripcionAsistenciaDiaria= activardescripcionAsistenciaDiaria;
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
		
		
		this.setMostraridAsistenciaDiaria(esInicial);
		this.setMostrarid_empresaAsistenciaDiaria(esInicial);
		this.setMostrarid_empleadoAsistenciaDiaria(esInicial);
		this.setMostrarid_estructuraAsistenciaDiaria(esInicial);
		this.setMostrarid_estructura_seccionAsistenciaDiaria(esInicial);
		this.setMostrarfechaAsistenciaDiaria(esInicial);
		this.setMostrarhoraAsistenciaDiaria(esInicial);
		this.setMostrarhoras_atrasoAsistenciaDiaria(esInicial);
		this.setMostrarhoras_faltaAsistenciaDiaria(esInicial);
		this.setMostrarhoras_permisoAsistenciaDiaria(esInicial);
		this.setMostrarhoras_extra25AsistenciaDiaria(esInicial);
		this.setMostrarhoras_extra50AsistenciaDiaria(esInicial);
		this.setMostrarhoras_extra100AsistenciaDiaria(esInicial);
		this.setMostrardescripcionAsistenciaDiaria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.ID)) {
				this.setMostraridAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION)) {
				this.setMostrarid_estructura_seccionAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.FECHA)) {
				this.setMostrarfechaAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORA)) {
				this.setMostrarhoraAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASATRASO)) {
				this.setMostrarhoras_atrasoAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASFALTA)) {
				this.setMostrarhoras_faltaAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASPERMISO)) {
				this.setMostrarhoras_permisoAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA25)) {
				this.setMostrarhoras_extra25AsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA50)) {
				this.setMostrarhoras_extra50AsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA100)) {
				this.setMostrarhoras_extra100AsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionAsistenciaDiaria(esAsigna);
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
		
		
		this.setActivaridAsistenciaDiaria(esInicial);
		this.setActivarid_empresaAsistenciaDiaria(esInicial);
		this.setActivarid_empleadoAsistenciaDiaria(esInicial);
		this.setActivarid_estructuraAsistenciaDiaria(esInicial);
		this.setActivarid_estructura_seccionAsistenciaDiaria(esInicial);
		this.setActivarfechaAsistenciaDiaria(esInicial);
		this.setActivarhoraAsistenciaDiaria(esInicial);
		this.setActivarhoras_atrasoAsistenciaDiaria(esInicial);
		this.setActivarhoras_faltaAsistenciaDiaria(esInicial);
		this.setActivarhoras_permisoAsistenciaDiaria(esInicial);
		this.setActivarhoras_extra25AsistenciaDiaria(esInicial);
		this.setActivarhoras_extra50AsistenciaDiaria(esInicial);
		this.setActivarhoras_extra100AsistenciaDiaria(esInicial);
		this.setActivardescripcionAsistenciaDiaria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.ID)) {
				this.setActivaridAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION)) {
				this.setActivarid_estructura_seccionAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.FECHA)) {
				this.setActivarfechaAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORA)) {
				this.setActivarhoraAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASATRASO)) {
				this.setActivarhoras_atrasoAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASFALTA)) {
				this.setActivarhoras_faltaAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASPERMISO)) {
				this.setActivarhoras_permisoAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA25)) {
				this.setActivarhoras_extra25AsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA50)) {
				this.setActivarhoras_extra50AsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA100)) {
				this.setActivarhoras_extra100AsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionAsistenciaDiaria(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAsistenciaDiaria(esInicial);
		this.setResaltarid_empresaAsistenciaDiaria(esInicial);
		this.setResaltarid_empleadoAsistenciaDiaria(esInicial);
		this.setResaltarid_estructuraAsistenciaDiaria(esInicial);
		this.setResaltarid_estructura_seccionAsistenciaDiaria(esInicial);
		this.setResaltarfechaAsistenciaDiaria(esInicial);
		this.setResaltarhoraAsistenciaDiaria(esInicial);
		this.setResaltarhoras_atrasoAsistenciaDiaria(esInicial);
		this.setResaltarhoras_faltaAsistenciaDiaria(esInicial);
		this.setResaltarhoras_permisoAsistenciaDiaria(esInicial);
		this.setResaltarhoras_extra25AsistenciaDiaria(esInicial);
		this.setResaltarhoras_extra50AsistenciaDiaria(esInicial);
		this.setResaltarhoras_extra100AsistenciaDiaria(esInicial);
		this.setResaltardescripcionAsistenciaDiaria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.ID)) {
				this.setResaltaridAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.IDESTRUCTURASECCION)) {
				this.setResaltarid_estructura_seccionAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.FECHA)) {
				this.setResaltarfechaAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORA)) {
				this.setResaltarhoraAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASATRASO)) {
				this.setResaltarhoras_atrasoAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASFALTA)) {
				this.setResaltarhoras_faltaAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASPERMISO)) {
				this.setResaltarhoras_permisoAsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA25)) {
				this.setResaltarhoras_extra25AsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA50)) {
				this.setResaltarhoras_extra50AsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.HORASEXTRA100)) {
				this.setResaltarhoras_extra100AsistenciaDiaria(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsistenciaDiariaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionAsistenciaDiaria(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoAsistenciaDiaria=true;

	public Boolean getMostrarFK_IdEmpleadoAsistenciaDiaria() {
		return this.mostrarFK_IdEmpleadoAsistenciaDiaria;
	}

	public void setMostrarFK_IdEmpleadoAsistenciaDiaria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoAsistenciaDiaria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaAsistenciaDiaria=true;

	public Boolean getMostrarFK_IdEmpresaAsistenciaDiaria() {
		return this.mostrarFK_IdEmpresaAsistenciaDiaria;
	}

	public void setMostrarFK_IdEmpresaAsistenciaDiaria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAsistenciaDiaria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraAsistenciaDiaria=true;

	public Boolean getMostrarFK_IdEstructuraAsistenciaDiaria() {
		return this.mostrarFK_IdEstructuraAsistenciaDiaria;
	}

	public void setMostrarFK_IdEstructuraAsistenciaDiaria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraAsistenciaDiaria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraSeccionAsistenciaDiaria=true;

	public Boolean getMostrarFK_IdEstructuraSeccionAsistenciaDiaria() {
		return this.mostrarFK_IdEstructuraSeccionAsistenciaDiaria;
	}

	public void setMostrarFK_IdEstructuraSeccionAsistenciaDiaria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraSeccionAsistenciaDiaria= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoAsistenciaDiaria=true;

	public Boolean getActivarFK_IdEmpleadoAsistenciaDiaria() {
		return this.activarFK_IdEmpleadoAsistenciaDiaria;
	}

	public void setActivarFK_IdEmpleadoAsistenciaDiaria(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoAsistenciaDiaria= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaAsistenciaDiaria=true;

	public Boolean getActivarFK_IdEmpresaAsistenciaDiaria() {
		return this.activarFK_IdEmpresaAsistenciaDiaria;
	}

	public void setActivarFK_IdEmpresaAsistenciaDiaria(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAsistenciaDiaria= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraAsistenciaDiaria=true;

	public Boolean getActivarFK_IdEstructuraAsistenciaDiaria() {
		return this.activarFK_IdEstructuraAsistenciaDiaria;
	}

	public void setActivarFK_IdEstructuraAsistenciaDiaria(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraAsistenciaDiaria= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraSeccionAsistenciaDiaria=true;

	public Boolean getActivarFK_IdEstructuraSeccionAsistenciaDiaria() {
		return this.activarFK_IdEstructuraSeccionAsistenciaDiaria;
	}

	public void setActivarFK_IdEstructuraSeccionAsistenciaDiaria(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraSeccionAsistenciaDiaria= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoAsistenciaDiaria=null;

	public Border getResaltarFK_IdEmpleadoAsistenciaDiaria() {
		return this.resaltarFK_IdEmpleadoAsistenciaDiaria;
	}

	public void setResaltarFK_IdEmpleadoAsistenciaDiaria(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoAsistenciaDiaria= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoAsistenciaDiaria= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaAsistenciaDiaria=null;

	public Border getResaltarFK_IdEmpresaAsistenciaDiaria() {
		return this.resaltarFK_IdEmpresaAsistenciaDiaria;
	}

	public void setResaltarFK_IdEmpresaAsistenciaDiaria(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAsistenciaDiaria= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAsistenciaDiaria= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraAsistenciaDiaria=null;

	public Border getResaltarFK_IdEstructuraAsistenciaDiaria() {
		return this.resaltarFK_IdEstructuraAsistenciaDiaria;
	}

	public void setResaltarFK_IdEstructuraAsistenciaDiaria(Border borderResaltar) {
		this.resaltarFK_IdEstructuraAsistenciaDiaria= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraAsistenciaDiaria= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraSeccionAsistenciaDiaria=null;

	public Border getResaltarFK_IdEstructuraSeccionAsistenciaDiaria() {
		return this.resaltarFK_IdEstructuraSeccionAsistenciaDiaria;
	}

	public void setResaltarFK_IdEstructuraSeccionAsistenciaDiaria(Border borderResaltar) {
		this.resaltarFK_IdEstructuraSeccionAsistenciaDiaria= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraSeccionAsistenciaDiaria(ParametroGeneralUsuario parametroGeneralUsuario/*AsistenciaDiariaBeanSwingJInternalFrame asistenciadiariaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraSeccionAsistenciaDiaria= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}